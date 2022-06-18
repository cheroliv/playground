package playground.programming

import kotlin.test.Test
import kotlin.test.assertEquals

class NumbersMathTest {
    @Test
    fun `Nombres et Math`() {
        //Constantes utiles
        Byte.MIN_VALUE
        Byte.MAX_VALUE
        Short.MIN_VALUE
        Short.MAX_VALUE
        Float.MIN_VALUE
        Float.MAX_VALUE
        Math.PI
        Math.E
        val s = "-42"
        //conversion de chaine de caractères
        //vers un nombre, si possible.
        var b: Byte = java.lang.Byte.parseByte(s)
        var sh: Short = java.lang.Short.parseShort(s)
        val i: Int = java.lang.Integer.parseInt(s)
        val l: Long = java.lang.Long.parseLong(s)
        val f: Float = java.lang.Float.parseFloat(s)
        val d: Double = java.lang.Double.parseDouble(s)

        //valeur exacte
        val f_exac = java.lang.Float.valueOf(s)
        val d_exac = java.lang.Double.valueOf(s)

        //les routines de conversions entière gérent
        //les nombres dans diverses bases.
        //1011 en binare est égal a 11 en base dix
        b = java.lang.Byte.parseByte("1011", 2)
        assertEquals(11, b)
        //ff en base 16(hexa) est égal à 255 en base dix.
        sh = java.lang.Short.parseShort("ff", 16)
        assertEquals(255, sh)

        //la méthode valueOf() peut gérer des bases arbitraires.

        println(b)
        println(sh)

    }
}