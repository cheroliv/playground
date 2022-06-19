package playground.programming

import java.text.DateFormat
import java.time.Instant
import java.util.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class DatesHoursTest {

    @Test
    fun `Dates et heures`() {

        //l'heure courante en millisecondes
        val t0 = System.currentTimeMillis()
        //une autre repsentation de la meme information
        @Suppress("RemoveRedundantQualifierName")
        val now = java.util.Date()
        //converti un objet java.util.Date en une valeur long.
        @Suppress("UsePropertyAccessSyntax")
        val t1 = now.getTime()
        assertTrue(t1 > Instant.EPOCH.toEpochMilli())
        //kotlin property access syntaxe style
        @Suppress("UNUSED_VARIABLE", "LocalVariableName")
        val t1_prime = now.time

        //java.text.DateFormat
        //affiche la date d'aujourd'hui en utilisant le format
        //par défaut des parametres locaux
        val defaultDateFormat = DateFormat.getDateInstance()
        //personnalisation du formattage et de la locale
        val dateFormat = DateFormat.getDateInstance(DateFormat.LONG, Locale.FRANCE)
        val localeFormattedDate = dateFormat.format(Date())

        //constantes pour les styles de pattern de formattage
        assertEquals(0,DateFormat.FULL)
        assertEquals(1,DateFormat.LONG)
        assertEquals(2,DateFormat.MEDIUM)
        assertEquals(3,DateFormat.SHORT)
        assertEquals(2,DateFormat.DEFAULT)

//        println(dateFormat.format(Date(2019,5,7)))
    }
}