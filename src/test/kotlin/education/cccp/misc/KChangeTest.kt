package education.cccp.misc

import kotlin.test.Test

class KChangeTest {

    @Test
    fun test_change() {
        val s = 109L // Change this value to perform other tests
        val m = KChange.optimalChange(s)
        println("Coin(s)  2€: " + m.coin2)
        println("Bill(s)  5€: " + m.bill5)
        println("Bill(s) 10€: " + m.bill10)
        val result = m.coin2 * 2 + m.bill5 * 5 + m.bill10 * 10
        println("\nChange given = $result")
    }

    internal class KChange @JvmOverloads constructor(
        private val coin2: Long = 0,
        private val bill5: Long = 0,
        private val bill10: Long = 0
    ) {
        companion object {
            // Do not modify this method signature
            fun optimalChange(s: Long): JChange {
                var r = s
                val change = JChange()
                //tant que le reste est superieure à 2
                while (r > 2) {
                    // si c'est exactement un multiple de 10
                    if (r % 10 == 0L) {
                        change.bill10 = r / 10
                        return change
                    } else {
                        //sinon rend des 10 et occupe toi du reste
                        change.bill10 = r / 10
                        r %= 10
                        // si c'est exactement un multiple de 5
                        if (r % 5 == 0L)
                            return change.apply {
                                bill5 = r / 5
                            }
                        else {
                            //sinon rend des 5 et occupe toi du reste
                            change.bill5 = r / 5
                            r %= 5
                            // si c'est exactement un multiple de 2
                            if (r % 2 == 0L) {
                                change.coin2 = r / 2
                                return change
                            } else {
                                //sinon rend des 2 et occupe toi du reste
                                change.coin2 = r / 2
                                r %= 2
                            }
                        }
                    }
                }
                return change
            }
        }
    }
}