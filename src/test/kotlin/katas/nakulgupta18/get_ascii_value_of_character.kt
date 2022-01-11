package katas.nakulgupta18

import org.junit.Test
import kotlin.test.assertEquals

/**
 * get_ascii_value_of_character
 * @see <a href="https://www.codewars.com/kata/56a5d994ac971f1ac500003e/train/kotlin">nakulgupta18</a>
 *
 */

fun getAscii(c: Char): Int = c.toByte().toInt()


class TestGetAscii {
    @Test
    fun `Basic tests`() {
        assertEquals(65, getAscii('A'))
        assertEquals(32, getAscii(' '))
        assertEquals(33, getAscii('!'))
    }
}
