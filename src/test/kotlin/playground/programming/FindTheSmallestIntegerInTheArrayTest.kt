package playground.programming

import kotlin.test.Test
import kotlin.test.assertEquals

fun findSmallestInt(nums: List<Int>): Int = nums.minOf { it }

class SmallestIntegerFinderTest {
    @Test
    fun `le plus petit int dans le tableau`() {
        assertEquals(10, findSmallestInt(listOf(15, 20, 10, 17, 22, 9001)))
    }
}