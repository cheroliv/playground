package playground.basics

import kotlin.test.Test
import kotlin.test.assertEquals

class StringsTest {
    @Suppress("NonAsciiCharacters")
    @Test
    fun `chaines de caractères et caractères`() {
        //inférence de type
        val s = "C'est"
        assertEquals("C'est", s)

        //concaténation
        @Suppress("ConvertToStringTemplate")
        val t1: String = s + " le moment"
        assertEquals("C'est le moment", t1)

        // StringBuilder
        val t2: String = s + buildString { append(" le moment") }
        assertEquals("C'est le moment", t2)

        //interpolation
        val t3 = "$s le moment"
        assertEquals("C'est le moment", t3)

        //multiligne chaine de caractères
        val t4 = """$s le moment"""
        assertEquals("C'est le moment", t4)

        //conversion de type
        @Suppress("ConvertToStringTemplate")
        val t5 = t1 + " " + 23.4
        assertEquals("C'est le moment 23.4", t5)

        val t6 = 'C'.toString()
        assertEquals("C", t6)

        //taille de la chaine de caractères
        assertEquals(15, t1.length)

        //sous-chaine d'une chaine de caractères

        //retourne une chaine de caractères contenant,
        //les caractères aux positions x à y-1
        //sub = t1.substring(x, y)

        //t1 = "C'est le moment"
        //retourne les caractères 6 et 7
        var sub = t1.substring(6, 8)
        assertEquals("le", sub)

        //retourne les caractères 0 à 4
        sub = t1.substring(0, 5)
        assertEquals("C'est", sub)

        //la longueur d'une sous-chaine est toujours égale (y-x)
        val numChars = sub.length
        assertEquals(5 - 0, numChars)

        //extraction des caractères d'une chaine
        @Suppress("ReplaceGetOrSet")
        assertEquals('e', t1.elementAt(2))
        assertEquals('e', t1.get(2))
        assertEquals('e', t1[2])

        //conversion d'une chaine en tableau de caractères
        val ca = t1.toCharArray()
        assertEquals(t1.length, ca.size)
        t1.mapIndexed { index, char -> assertEquals(char, ca[index]) }

        //place les 4 premiers caractères de t1
        //dans le tableau ca a la position 2
        (t1 as java.lang.String).getChars(0, 3, ca, 1)
        assertEquals("CC'et le moment", String(ca))
        assertEquals("CC'et le moment", ca.concatToString())
    }
}