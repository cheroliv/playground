package education.cccp.text

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

const val PI = 3.1415
const val SEPARATOR = ", "

val dataList: List<String> = listOf(
    "Android",
    "Kotlin",
    "Java",
    "Javascript",
    "Typescript",
    "Groovy",
    "Go",
    "Swift",
    "iOS"
)

fun concat(
    texts: List<String>,
    separator: String = SEPARATOR
): String = texts.joinToString(separator)

class ConcatFunctionTest {
    @Test
    fun testSomePrinties() {
        println("Hello World Android Basics")
        println("PI: $PI")
        println(dataList)
        println(concat(dataList))
    }

    @Test
    fun test_concat_isCorrect() {
        assertEquals(
            concat(dataList),
            dataList.toString()
                //pour supprimer le premier et dernier caractère,
                // afin de valider l'egalité du test unitaire
                .drop(1)//suprimer les n premier caracteres de la chaine
                .dropLast(1)//suprimer les n derniers caracteres de la chaine
        )
    }

}