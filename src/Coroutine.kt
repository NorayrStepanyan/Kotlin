import kotlinx.coroutines.*

suspend fun main() = coroutineScope {
    launch {
        coroutine_1()
        coroutine_2a()
        coroutine_2()
    }
    Unit
}

suspend fun coroutine_1() {
    for (i in 0..5) {
        delay(400L)
        println(i)
    }
    println("OK")
}

suspend fun coroutine_2() = coroutineScope {
    launch {
        for (i in 0..5) {
            delay(10L)
            println(i)
        }
    }
    println("OK")
    println("OK")
    println("OK")
    println("OK")
}

suspend fun coroutine_2a() = coroutineScope {
    launch {
        for (i in 0..5) {
            delay(10L)
            println(i)
        }
    }
    println("OK")
}


suspend fun coroutin_3() = coroutineScope {
    val job: Job = launch {
        for (i in 0..5) {
            delay(400L)
            println(i)
        }
    }
    println("Start")

    job.start()

    println("OK")
}

suspend fun coroutin_4() = coroutineScope {
    val job: Job = launch {
        for (i in 0..5) {
            delay(400L)
            println(i)
        }
    }
    println("OK")
    job.cancel()
    println("OK")
    job.join()
//    job.cancelAndJoin()
}

suspend fun coroutin_5() = coroutineScope {
    val job: Job = launch(start = CoroutineStart.LAZY) {
        for (i in 0..5) {
            delay(400L)
            println(i)
        }
    }
    println("OK")
    job.start()
    println("OK")
}


suspend fun sum(a: Int, b: Int): Int {
    delay(200L)
    return a + b
}

suspend fun coroutin_6() =
    coroutineScope {

        val intSum = async { sum(10, 20) }
        println(intSum.await())
        val intSum1 = async { sum(10, 20) }
        println(intSum.await())
//        intSum.cancelAndJoin()
    }

suspend fun coroutin_7() =
    coroutineScope {

        val intSum = async(start = CoroutineStart.LAZY) { sum(10, 20) }
        println(intSum.await())

    }