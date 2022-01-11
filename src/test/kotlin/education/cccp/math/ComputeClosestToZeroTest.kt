package education.cccp.math

import kotlin.math.abs
import kotlin.test.Test
import kotlin.test.assertEquals


fun computeClosestToZero(ts: Array<Int>): Int =
    if (ts.isNullOrEmpty()) 0
    else ts.minOf { abs(it) }


class ComputeClosestToZeroTest {
    private val temperatures = arrayOf(-12, -15, -2, 1, 17)

    @Test
    fun `test computeClosestToZero sur temperatures doit etre 1`() {
        assertEquals(computeClosestToZero(temperatures), 1)
    }
}