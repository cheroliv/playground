@file:Suppress(
    "UNUSED_VARIABLE",
    "LocalVariableName",
    "VARIABLE_WITH_REDUNDANT_INITIALIZER",
    "RemoveRedundantQualifierName",
    "ReplaceJavaStaticMethodWithKotlinAnalog",
)

package playground.programming

import java.text.NumberFormat
import java.util.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

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
        var i: Int = java.lang.Integer.parseInt(s)
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
        i = java.lang.Integer.valueOf("egg", 17).toInt()
        assertEquals(4334, i)

        //la méthode decode() gére les representations octale,
        //décimal, hexadécimal, en fonction du préfixe numérique
        //de la chaine de caractères
        //un 0 de tete signifie base 8
        //un 0x de tete signifie base 16
        //les autres sont en base 10
        val sho = java.lang.Short.decode("0377")

        //la classe Integer peut convertir les nombres
        //en diverses chaines de caractères.
        val decimal = java.lang.Integer.toString(42)
        assertEquals("42", decimal)

        val decimal_ = 42.toString()
        assertEquals("42", decimal_)

        val binary = java.lang.Integer.toBinaryString(42)
        assertEquals("101010", binary)

        val octal = java.lang.Integer.toOctalString(42)
        assertEquals("52", octal)

        val hex = java.lang.Integer.toHexString(42)
        assertEquals("2a", hex)

        val base36 = java.lang.Integer.toString(42, 36)
        assertEquals("16", base36)

        val base36_ = 42.toString(36)
        assertEquals("16", base36_)

        //java.text.NumberFormat effectue la conversion
        // d'une maniere spécifique aux parametres locaux
        //sans parametre prend la local systeme comme reference
        val nf = NumberFormat.getNumberInstance(Locale.FRANCE)
        val formatted_number = nf.format(9876543.21)
        assertNotEquals("9876543.21", formatted_number)

        //parse la chaine de caractères en fonction des parametres locaux(fr)
        val n = nf.parse("1234567,89")
        assertEquals(1234567.89, n)

        //les valeurs monétaires sont parfois formaté
        // d'une maniere differente des nombres
        val money_format = NumberFormat.getCurrencyInstance(Locale.FRANCE)
        assertNotEquals("1234.56",money_format.format(1234.56))
    }
}