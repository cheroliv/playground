package education.cccp.coroutines

import kotlinx.coroutines.runBlocking
import org.slf4j.LoggerFactory
import kotlin.test.Test

/**
 * to run the project
 * ```
 * ./gradlew check
 * ```
 */
class CoroutinesTutoTest {
    companion object {

        @JvmStatic
        private val log = LoggerFactory.getLogger(CoroutinesTutoTest::class.java)
    }

    @Test
    fun foo() = runBlocking {}

    @Test
    fun testFirstCoroutine() = firstCoroutine()

    @Test
    fun testSecondCoroutine() = secondCoroutine()

    @Test
    fun testThirdCoroutine() = thirdCoroutine()

    @Test
    fun testFourthCoroutine() = fourthCoroutine()

    @Test
    fun testFifthCoroutine() = fifthCoroutine()

    @Test
    fun testSixthUICoroutine() = sixthUICoroutine()
}