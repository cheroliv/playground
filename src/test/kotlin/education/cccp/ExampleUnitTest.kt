package education.cccp


import education.cccp.data.datas.PI
import education.cccp.data.datas.SEPARATOR
import education.cccp.data.datas.programmingLanguages
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * écriture d'un test unitaire, execution locale.
 * Manipulation d'éléments de langage et de quelques fonctions utiles.
 * (listof(), String.drop(), String.dropLast())
 */


fun concat(
    texts: List<String>,
    separator: String = SEPARATOR
): String = texts.joinToString(separator)


class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testSomePrinties() {
        println("Hello World Android Basics")
        println("PI: $PI")
        println(programmingLanguages)
        println(concat(programmingLanguages))
    }

    @Test
    fun test_concat_isCorrect() {
        assertEquals(
            concat(programmingLanguages),
            programmingLanguages.toString()
                //pour supprimer le premier et dernier caractère,
                // afin de valider l'egalité du test unitaire
                .drop(1)//suprimer les n premier caracteres de la chaine
                .dropLast(1)//suprimer les n derniers caracteres de la chaine
        )
    }
}