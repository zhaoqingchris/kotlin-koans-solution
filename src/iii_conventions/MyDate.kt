package iii_conventions

import java.util.*

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        if (other.year > year)  {
            return -1
        } else if (other.year == year) {
            if (other.month > month) {
                return -1
            } else if (other.month == month) {
                if (other.dayOfMonth > dayOfMonth) {
                    return -1
                } else {
                    return 0
                }
            } else {
                return 1
            }

        } else {
            return 1
        }
    }
}

operator fun MyDate.rangeTo(other: MyDate): DateRange {
    return DateRange(this, other)
}

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(val start: MyDate, val endInclusive: MyDate) : Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> = object : Iterator<MyDate> {
        var cursor: MyDate = start

        override fun hasNext(): Boolean {
            return cursor < endInclusive || cursor.equals(endInclusive)
        }

        override fun next(): MyDate {
            if (!hasNext()) {
                throw NoSuchElementException()
            }

            val current = cursor
            cursor = cursor.nextDay()
            return current
        }
    }

    operator fun contains(d: MyDate): Boolean {
        return d > start && d<= endInclusive
    }



}


