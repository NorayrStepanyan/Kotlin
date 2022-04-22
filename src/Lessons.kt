// let, run, with, apply, also

fun main() {

    println("============ let ==============")
    maximumNumber(12, 34).let {
        println(it)
        val a = it + 56
        println(a)
    }

    println("========= let equivalent ===========")
    val result = maximumNumber(12, 34)
    println(result)
    val aa = result + 56
    println(aa)

    println("=========== run ===============")

    val numbers = mutableListOf(1, 3, -5, 0, -7)
    val resultPositive = numbers.run {
        add(-8)
        add(-18)
        sort()
        sum()
    }
    println(numbers)
    println(resultPositive)

    println("=========== with ===============")

    val resultCount = with(numbers) {
        add(12)
        count { it > 0 }
    }
    println(resultCount)

    println("=========== apply ===============")
    numbers.apply {
        remove(0)
    }
    println(numbers)

    println("=========== also ===============")

    numbers.also { it ->
        it.forEach {
            print(it)
        }
        it.add(100).run {
//            if (this) 100 else 1000
        }
    }
    println()
}

fun maximumNumber(x: Int, y: Int): Int {
    return if (x > y) x else y            // if վերադարձնում է արժեք
}