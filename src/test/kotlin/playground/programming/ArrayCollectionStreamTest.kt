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
        //pas trouvé retourne une valeur negative
        assert(Arrays.binarySearch(intarray, 12) < 0)
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