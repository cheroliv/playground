package education.cccp.data

import education.cccp.data.datas.nameToLoginNormalizer
import kotlinx.coroutines.*
import kotlin.test.Test

class UsualDataTest {
    @OptIn(DelicateCoroutinesApi::class)
    @Test
    fun data_test() {
        val result: List<Deferred<Int>> = (1..1_000).map { n ->
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
        println(datas.intellectuals.nameToLoginNormalizer())
    }

}