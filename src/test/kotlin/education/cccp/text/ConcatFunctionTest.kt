package education.cccp.text


import education.cccp.data.datas.PI
import education.cccp.data.datas.SEPARATOR
import education.cccp.data.datas.programmingLanguages
import kotlin.test.Test
import kotlin.test.assertEquals

fun concat(
    texts: List<String>,
    separator: String = SEPARATOR
): String = texts.joinToString(separator)

class ConcatFunctionTest {
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