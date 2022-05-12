package education.cccp.data

import org.apache.commons.lang3.StringUtils.stripAccents
import java.text.Normalizer.Form.NFD
import java.text.Normalizer.normalize

@Suppress("ClassName")
object datas {
    const val PI = 3.1415
    const val SEPARATOR = ", "
    val programmingLanguages: List<String> = listOf(
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
    @JvmStatic
    val intellectuals: List<String> = listOf(
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

    fun CharSequence.unaccent(): String =
        "\\p{InCombiningDiacriticalMarks}+"
            .toRegex()
            .replace(
                normalize(this, NFD),
                ""
            )

    fun List<String>.nameToLogin(): List<String> =
        map {
            stripAccents(
                it.lowercase().replace(
                    oldChar = ' ',
                    newChar = '.'
                )
            )
        }

    fun List<String>.nameToLoginNormalizer(): List<String> =
        map {
            it.lowercase()
                .replace(' ', '.')
                .unaccent()
        }
}




