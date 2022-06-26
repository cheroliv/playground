@file:Suppress(
    "RemoveRedundantQualifierName",
    "UsePropertyAccessSyntax",
    "UNUSED_VARIABLE", "LocalVariableName",
)

package playground.programming

import java.util.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ArrayCollectionStreamTest {
    @Test
    fun `Tableaux, collections, streams`() {
        //Tableau
        //java.util.Arrays définit d'utiles méthodes de manipulation de tableaux, 
        //y compris de tri et de recherche au sein d'un tableau
        val intArray = arrayOf(10, 5, 7, -3)
        //tri le tableau
        Arrays.sort(intArray)
        val pos = Arrays.binarySearch(intArray, 7)
        //la valeur 7 est trouvé a l'index 2
        assertEquals(2, pos)
        //12 pas trouvé retourne une valeur negative
        assert(Arrays.binarySearch(intArray, 12) < 0)

        //les tableaux peuvent également etre triés
        //et faire l'objet d'une recherche
        val stringArray = arrayOf("le", "moment", "c'est")
        assertEquals("c'est", stringArray[2])
        assertEquals("le", stringArray[0])
        assertEquals("moment", stringArray[1])
        Arrays.sort(stringArray)
        assertEquals("c'est", stringArray[0])
        assertEquals("le", stringArray[1])
        assertEquals("moment", stringArray[2])

        //Arrays.equals() compare tous les éléments de deux tableaux
        //Arrays.clone() copie tous les elements du tableau dans un autre
        stringArray.forEachIndexed { i, it -> assertEquals(it, stringArray.clone()[i]) }

        val data = ByteArray(100)
        //Arrays.fill() initialise tous les éléments des deux tableaux
        //initalise tous les éléments à -1
        Arrays.fill(data, -1)
        data.forEach { assertEquals(-1, it) }

        //attribue aux éléments 5, 6, 7, 8 et 9 la valeur -2
        Arrays.fill(data, 5, 10, -2)
        ((5 until (10 - 1))).forEach { assertEquals(-2, data[it]) }

        //récupère le type de data
        val type = data::class.java
        //est ce que data est un tableau?
        assertTrue(type.isArray())
        //est ce que data est un tableau de byte
        assertEquals(Byte::class.java, type.getComponentType())

        //Collection
        val s = java.util.HashSet<String>()
        s.add("test")
        assertTrue(s.contains("test"))
        assertFalse(s.contains("test2"))
        s.remove("test")
        assertFalse(s.contains("test"))

        val ss = TreeSet<String>()
        ss.add("b")
        ss.add("a")
        ss.iterator().forEach { assertTrue(it == "a" || it == "b") }

        //liste doublement chainée
        var dll: List<String> = LinkedList<String>()

        //plus efficace
        val l = ArrayList<String>()
        l.addAll(ss)
        l.addAll(1, ss)

    }
}