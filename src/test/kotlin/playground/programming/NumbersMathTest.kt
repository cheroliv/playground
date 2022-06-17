package playground.programming

import kotlin.test.Test

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
        val b: Byte = java.lang.Byte.parseByte(s)
        val sh: Short = java.lang.Short.parseShort(s)
        val i: Int = java.lang.Integer.parseInt(s)
        val l: Long = java.lang.Long.parseLong(s)
        val f: Float = java.lang.Float.parseFloat(s)
        val d: Double = java.lang.Double.parseDouble(s)

        //valeur exacte
        val f_exac = java.lang.Float.valueOf(s)
        val d_exac = java.lang.Double.valueOf(s)

    }
}