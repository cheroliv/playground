package education.cccp.coroutines

import education.cccp.coroutines.CoroutinesTuto.log
import kotlinx.coroutines.CoroutineStart.LAZY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.slf4j.Logger
import org.slf4j.LoggerFactory.getLogger
import java.lang.Thread.currentThread
import java.lang.Thread.sleep


object CoroutinesTuto {
    @JvmStatic
    val log: Logger = getLogger(CoroutinesTuto.javaClass)
}

//page 53
fun firstCoroutine() {
    (1..10000).forEach {
        GlobalScope.launch {
            val threadName = currentThread().name
            log.info("$it printed on thread $threadName")
        }
    }
    sleep(1000)
}

//page 58
fun secondCoroutine() {
    GlobalScope.launch {
        log.info("Hello coroutine!")
        delay(500)
        log.info("Right back at ya!")
    }
    sleep(1000)
}

//page 59
fun thirdCoroutine() {
    val job1 = GlobalScope.launch(start = LAZY) {
        delay(200)
        log.info("Pong")
        delay(200)
    }

    GlobalScope.launch {
        delay(200)
        log.info("Ping")
        job1.join()
        log.info("Ping")
        delay(200)
    }
    sleep(1000)
}

//page 60
fun fourthCoroutine() {
    with(GlobalScope) {
        val parentJob = launch {
            delay(200)
            log.info("I’m the parent")
            delay(200)
        }
        launch(context = parentJob) {
            delay(200)
            log.info("I’m a child")
            delay(200)
        }
        if (parentJob.children.iterator().hasNext())
            log.info("The Job has children ${parentJob.children}")
        else log.info("The Job has NO children")
        sleep(1000)
    }
}

//page 61
@Suppress("UNUSED_VALUE")
fun fifthCoroutine() {
    var isDoorOpen = false
    log.info("Unlocking the door... please wait.\n")
    GlobalScope.launch { delay(3000) }
    isDoorOpen = true
    GlobalScope.launch {
        repeat(4) {
            log.info("Trying to open the door...\n")
            delay(800)
        }
    }
    if (isDoorOpen)
        log.info("Opened the door!\n")
    else log.info("The door is still locked\n")
    sleep(5000)
}

//page 62
fun sixthUICoroutine() {
    GlobalScope.launch {
        val bgThreadName = currentThread().name
        log.info("I’m Job 1 in thread $bgThreadName")
        delay(200)
        GlobalScope.launch(Dispatchers.Main) {
            val uiThreadName = currentThread().name
            log.info("I’m Job 2 in thread $uiThreadName")
        }
    }
    sleep(1000)
}
