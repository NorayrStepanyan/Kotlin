
fun main() {
    listCollection()
}

fun collection_1(): Array<String> {
    val things = arrayOf("foo", "bar", "goo")
    things[2] = "OK"
    return things
}

fun collection_2(): List<String> {
    val things = listOf("foo", "bar", "goo")


    return things
}

fun collection_3(): MutableList<String> {
    val things = mutableListOf("foo", "bar", "goo")
    things[2] = "OK"
    return things
}


fun collection_4(): MutableList<Int> {
    val things = mutableListOf(1, -5, 5, 78, -7, 9)

    return things
}

fun fibonacciGen(start: Int, end: Int) = sequence {
    var first = 0
    var second = 1
    while (true) {
        if (first > end) break
        if (first > start) yield(first)
        val temp = first
        first += second
        second = temp

    }
}.toList()

fun String.wordToNumber(): Int {
    var sumOfWord = 0
    val numericOfAlfa = mapOf(
        'A' to 1, 'a' to 1, 'B' to 2, 'b' to 2, 'C' to 3, 'c' to 3, 'D' to 4, 'd' to 4, 'E' to 5,
        'e' to 5, 'F' to 6, 'f' to 6, 'G' to 7, 'g' to 7, 'H' to 8, 'h' to 8, 'I' to 9, 'i' to 9,
        'J' to 10, 'j' to 10, 'K' to 20, 'k' to 20, 'L' to 30, 'l' to 30, 'M' to 40, 'm' to 40,
        'N' to 50, 'n' to 50, 'O' to 60, 'o' to 60, 'P' to 70, 'p' to 70, 'Q' to 80, 'q' to 80,
        'R' to 90, 'r' to 90, 'S' to 100, 's' to 100, 'T' to 200, 't' to 200, 'U' to 300, 'u' to 300,
        'V' to 400, 'v' to 400, 'W' to 500, 'w' to 500, 'X' to 600, 'x' to 600, 'Y' to 700, 'y' to 700,
        'Z' to 800, 'z' to 800
    )
    this.reversed().forEach { sumOfWord += numericOfAlfa[it] ?: 0 }
    return sumOfWord
}

fun listCollection() {
    val list1 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val list2 = mutableListOf("one111", "two1", "three", "four1111", "five")
    list1.add(-10)
    list1.addAll(listOf(-5, -8))
    list1 += 11
    list1 += listOf(12, 13, 14)
    val newList = list1.plus(15)
    val newList1 = list1.minus(11)
    list1 -= listOf(12, 13, 14)
    list1.removeAt(0)
    list1.remove(2)
    println(list1)
    var sumOfItem = 0
    list1.forEach { if (it > 0) sumOfItem += it else sumOfItem -= it }
    println("sum of list $sumOfItem")
    println("map ${list1.associateBy { "key$it" }}")
    println("map ${list1.associateWith { "Value ${it * 2 + sumOfItem}" }}")
    println(list1)
    println("last ${list1.last { it in 3..100 }}")
    println("first ${list1.first { it in 3..100 }}")
    println("take first n elements ${list1.take(3)}")
    val anyList = mutableListOf<Any>(1, 2, 4, 2.5, 4.7, "Ok", 4, "Cancel", 2, true, 12, false)
    println("take first n elements ${anyList.filterIsInstance<String>()}")
    println("take first n elements ${anyList.filterIsInstance<Char>()}")
    println("take first n elements ${list2.filter { it.length > 3 }}")

    println("take first n elements ${anyList.filterIndexed { index, item -> index % 2 == 0 && index != 0 && item is Int }}")
    val listList = mutableListOf<List<Int>>(listOf(1, 2, 3), listOf(10, 20, 30), listOf(100, 200, 300))
    println(listList.flatten().filter { it in 10..200 }.joinToString { "$it is price" })
    println(list1.zip(list2).toMap().filterValues { it.length in 4..5 })
    println(list2.zip(fibonacciGen(10, 100)).toMap())

    println(list1.sortedWith(compareBy { it }))
    println(list2.sortedWith(compareBy { it.length }))

    val comp = Comparator { o1: String, o2: String -> o1.wordToNumber() }
    println(list2.sortedWith( comp))
    println(list2.sortedWith(compareBy { it.wordToNumber()/it.length }))

}
