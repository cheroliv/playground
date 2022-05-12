@file:Suppress("NonAsciiCharacters")
//(4)
package education.cccp.lang

import kotlin.test.Test

class ZipTest {
    @Test fun main() {
        // zip:
        // Renvoie une liste de paires construites à partir des éléments
        // de ce tableau et de l'autre tableau avec le même index.
        // La liste renvoyée a la longueur de la collection la plus courte.

        // list des Pair<String,Boolean> associant les elements par occurence
        println(listDeTextes.zip(listDeBooleens))

        //list des résultats du texte et de la condition contains() rapproché par pair
        println(listDeTextes.zip(listDeTextes.map { it.contains("t") }))
    }
}

val listDeTextes: List<String>
    get() = listOf(
        "foo",
        "bar",
        "baz",
        "qux",
        "quux",
        "corge",
        "grault",
        "garply",
        "waldo",
        "fred",
        "plugh",
        "xyzzy",
        "thud"
    )

val listDeBooleens
    get() = listOf(
        false,
        true,
        true,
        false
    )
