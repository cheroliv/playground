package playground.programming

import java.text.DateFormat
import java.util.*
import kotlin.test.Test

class DatesHoursTest {

    @Test
    fun `Dates et heures`() {

        //l'heure courante en millisecondes
        val t0 = System.currentTimeMillis()
        //une autre repsentation de la meme information
        val now = java.util.Date()
        //converti un objet java.util.Date en une valeur long.
        @Suppress("UsePropertyAccessSyntax")
        val t1 = now.getTime()
        //kotlin property access syntaxe
        @Suppress("UNUSED_VARIABLE", "LocalVariableName")
        val t1_prime = now.time

        //affiche la date d'aujourd'hui en utilisant le format
        //par défaut des parametres locaux
        val dateFormat = DateFormat.getDateInstance(1, Locale.FRANCE)
        println(dateFormat.format(Date()))
    }
}