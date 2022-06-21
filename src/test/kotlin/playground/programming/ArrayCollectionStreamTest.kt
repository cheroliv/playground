@file:Suppress(
    "RemoveRedundantQualifierName",
    "UsePropertyAccessSyntax",
    "UNUSED_VARIABLE", "LocalVariableName",
)

package playground.programming

import java.util.*
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals

class ArrayCollectionStreamTest {
    @Test
    fun `Tableaux`() {
        //java.util.Arrays définit d'utiles méthodes de manipulation de tableaux, 
        //y compris de tri et de recherche au sein d'un tableau
        val intarray = arrayOf(10, 5, 7, -3)
        //tri le tableau
        Arrays.sort(intarray)
        val pos = Arrays.binarySearch(intarray, 7)
        //la valeur 7 est trouvé a l'index 2
        assertEquals(2, pos)
        //12 pas trouvé retourne une valeur negative
        assert(Arrays.binarySearch(intarray, 12) < 0)

        //les tableaux peuvent également etre triés
        //et faire l'objet d'une recherche
        val strarray = arrayOf("le", "moment", "c'est")
        assertEquals("c'est", strarray[2])
        assertEquals("le", strarray[0])
        assertEquals("moment", strarray[1])
        Arrays.sort(strarray)
        assertEquals("c'est", strarray[0])
        assertEquals("le", strarray[1])
        assertEquals("moment", strarray[2])

        //Arrays.equals() compare tous les éléments de deux tableaux
        //Arrays.clone() copie tous les elements du tableau dans un autre
        strarray.forEachIndexed { i, it -> assertEquals(it, strarray.clone()[i]) }

        //Arrays.fill() initialise tous les éléments des deux tableaux
        val data = ByteArray(100)
    }

    @Test
    @Ignore
    fun `Collections`() {
    }

    @Test
    @Ignore
    fun `Stream`() {
    }
}