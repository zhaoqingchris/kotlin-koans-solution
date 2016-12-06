package i_introduction._5_String_Templates

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class _05_String_Templates() {
    @Test fun match() {
        assertTrue("11 MAR 1952".matches(task5().toRegex()))
    }

    @Test fun match1() {
        assertTrue("24 AUG 1957".matches(task5().toRegex()))
    }

    @Test fun doNotMatch() {
        assertFalse("24 RRR 1957".matches(task5().toRegex()))
    }

    @Test fun match3() {
        val p = """
\d{2}\ \d{2}\ \d{4}
"""
        assertFalse("24 11 1957".matches(p.toRegex()))
    }
}
