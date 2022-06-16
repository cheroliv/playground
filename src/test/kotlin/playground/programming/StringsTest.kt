@file:Suppress(
    "NonAsciiCharacters",
    "ConvertToStringTemplate",
    "ReplaceGetOrSet",
    "PLATFORM_CLASS_MAPPED_TO_KOTLIN",
    "KotlinConstantConditions",
    "ReplaceCallWithBinaryOperator",
)

package playground.programming

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class StringsTest {
    @Test
    fun `chaines de caractères et caractères`() {
        //inférence de type
        val s = "C'est"
        assertEquals("C'est", s)

        //concaténation
        val t: String = s + " le moment."
        assertEquals("C'est le moment.", t)

        // StringBuilder
        val t1: String = s + buildString { append(" le moment.") }
        assertEquals("C'est le moment.", t1)

        //interpolation
        val t2 = "$s le moment."
        assertEquals("C'est le moment.", t2)

        //multiligne chaine de caractères
        val t3 = """$s le moment."""
        assertEquals("C'est le moment.", t3)

        //conversion de type
        @Suppress("ConvertToStringTemplate")
        val t4 = t + " " + 23.4
        assertEquals("C'est le moment. 23.4", t4)

        val t5 = 'C'.toString()
        assertEquals("C", t5)

        //taille de la chaine de caractères
        assertEquals(16, t.length)

        //sous-chaine d'une chaine de caractères

        //retourne une chaine de caractères contenant,
        //les caractères aux positions x à y-1
        //sub = t.substring(x, y)

        //t = "C'est le moment."
        //retourne les caractères 6 et 7
        var sub = t.substring(6, 8)
        assertEquals("le", sub)

        //retourne les caractères 0 à 4
        sub = t.substring(0, 5)
        assertEquals("C'est", sub)

        //la longueur d'une sous-chaine est toujours égale (y-x)
        val numChars = sub.length
        assertEquals(5 - 0, numChars)

        //extraction des caractères d'une chaine
        assertEquals('e', t.elementAt(2))
        assertEquals('e', t.get(2))
        assertEquals('e', t[2])

        //conversion d'une chaine en tableau de caractères
        val ca = t.toCharArray()
        assertEquals(t.length, ca.size)
        t.mapIndexed { index, char -> assertEquals(char, ca[index]) }

        //place les 4 premiers caractères de t1
        //dans le tableau ca a la position 2
        (t as java.lang.String).getChars(
            /* srcBegin = */ 0,
            /* srcEnd = */ 3,
            /* dst = */ ca,
            /* dstBegin = */ 1
        )
        assertEquals("CC'et le moment.", String(ca))
        assertEquals("CC'et le moment.", ca.concatToString())

        //to lower case
        assertEquals("c'est le moment.", t.toLowerCase())
        assertEquals("c'est le moment.", t.lowercase())
        //to lower case
        assertEquals("C'EST LE MOMENT.", t.toUpperCase())
        assertEquals("C'EST LE MOMENT.", t.uppercase())

        //comparaison de chaines de caractères
        //t = "C'est le moment."
        assertFalse(t.equals("hello"))
        assertFalse(t == "hello")
        //ignore la casse
        assertTrue(t.equalsIgnoreCase("C'EST LE MOMENT."))
        assertTrue(t.equals("C'EST LE MOMENT.", ignoreCase = true))

        //démarre par
        assertTrue(t.startsWith("C'est"))
        //se finit par
        assertTrue(t.endsWith("le moment."))

//        println(t.toUpperCase())
    }
}