package education.cccp.sbkll

import kotlinx.coroutines.*
import org.apache.commons.lang3.StringUtils.stripAccents
import java.text.Normalizer.Form.NFD
import java.text.Normalizer.normalize

val users: List<String> = listOf(
    "Karl Marx",
    "Jean-Jacques Rousseau",
    "Victor Hugo",
    "Platon",
    "René Descartes",
    "Socrate",
    "Homère",
    "Paul Verlaine",
    "Claude Roy",
    "Bernard Friot",
    "François Bégaudeau",
    "Frederic Lordon",
    "Antonio Gramsci",
    "Georg Lukacs",
    "Franz Kafka",
    "Arthur Rimbaud",
    "Gérard de Nerval",
    "Paul Verlaine",
    "Dominique Pagani",
    "Rocé",
    "Chrétien de Troyes",
    "François Rabelais",
    "Montesquieu",
    "Georg Hegel",
    "Friedrich Engels",
    "Voltaire",
    "Michel Clouscard"
)

fun main() {
    val result: List<Deferred<Int>> = (1..1_000_000).map { n ->
        val deferred: Deferred<Int> = GlobalScope.async {
            delay(1_000)
            println(n)
            n
        }
        deferred
    }
    runBlocking {
        println("the sum is ${result.sumOf { it.await() }}")
    }
    println(nameToLoginNormalizer(users))
}

fun nameToLogin(userList: List<String>): List<String> =
    userList.map {
        stripAccents(
            it.lowercase()
                .replace(' ', '.')
        )
    }

fun nameToLoginNormalizer(userList: List<String>): List<String> =
    userList.map {
        it.lowercase()
            .replace(' ', '.')
            .unaccent()
    }

fun CharSequence.unaccent(): String =
    "\\p{InCombiningDiacriticalMarks}+"
        .toRegex()
        .replace(
            normalize(this, NFD),
            ""
        )