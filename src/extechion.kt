import java.math.BigDecimal
import kotlin.math.pow
import kotlin.random.Random

fun main() {


}


fun Int.dividerList(): ArrayList<Int> {
    val divList = arrayListOf<Int>()
    for (i in 1..this / 2) {
        if (this % i == 0) divList.add(i)
    }
    return divList

}

fun Int.dividerSum() = this.dividerList().sum()
fun Int.dividerProd() = this.dividerList().prod()

fun ArrayList<Int>.prod(): Long {
    var tr = 1L
    for (i in this) tr *= i
    return tr
}

fun Int.digitList(): ArrayList<Int> {
    val digitList = arrayListOf<Int>()
    for (ch in this.toString()) digitList.add(ch.toString().toInt())
    return digitList
}

fun Int.isOdd() = this % 2 == 1
fun Int.square(degree: Int) = (this.toDouble().pow(degree.toDouble())).toInt()
fun Int.isPrime(): Boolean {
    if (this == 0 || this == 1) return false
    else if (this == 2) return true
    else {
        for (i in 2..this / 2) {

        }
        return true
    }
}

fun ArrayList<Int>.sumOfPositive(): Int {

    var substitute = 0
    for (i in this) {
        if (i > 0) substitute += i

    }

    return substitute
}

fun Int.factorial(): BigDecimal {
    var pad = BigDecimal(1)
    for (i in 1..this) pad *= i.toBigDecimal()
    return pad
}

fun numberToDigit(a: Int): List<Int> {
    val digitList = mutableListOf<Int>()
    for (item in a.toString()) digitList.add(item.toString().toInt())
    return digitList
}

fun Int.lifecycle(): Int {
    if (this <= 10) return 1
    else {
        var temp = 1
        var number = this
        var counter = 0
        while (true) {
            for (i in numberToDigit(number))
                temp *= i
            counter++
            number = temp
            if (number < 10) {

                break
            }
        }
        return counter
    }

}

fun Int.friendsNumber(): Int {
    var num = 0

    while (true) {
        num++
        if (num.dividerSum() == this && this.dividerSum() == num)
            return num
        else {
            if (num == 100 * this)
                return -1
        }
    }
}

fun hoursDaysMonthsYear(date: Int, num: Int): ArrayList<Pair<String, Int>> {
    val answers = arrayListOf<Pair<String, Int>>()
    var seconds = 0
    var minute = 0
    var hours = 0
    var days = 0
    var months = 0
    var years = 0
    var countOfDays = 0
    var countOfMonths = 0
    do {
        countOfDays++
        if (countOfDays == 30) {
            days += countOfDays
            countOfMonths++
        } else if (countOfDays > 31 && countOfDays % 31 == 0) {
            countOfMonths++
            days += countOfDays / 2
            countOfDays = 0
        }
        if (countOfMonths == 12) {
            years++
            if (years == 4 || years % 4 == 0)  //նահանջի տարի
                days--
            months += countOfMonths
            countOfMonths = 0
        }
    } while (years != date - num)
    hours += 24 * days
    minute += hours * 60
    seconds += minute * 60
//    answers.add("num-$num  years-$years months-$months days-$days hours-$hours minute-$minute seconds-$seconds")
    answers.add(Pair("num-$num = years-", years))
    answers.add(Pair("months-", months))
    answers.add(Pair("days-", days))
    answers.add(Pair("hours-", hours))
    answers.add(Pair("minute-", minute))
    answers.add(Pair("seconds-", seconds))

    return answers
}

fun generationPrimeNumber(start: Int, end: Int) = sequence<Int> {
    var fact = 1
    for (i in 1..end) {
        fact *= i
        if (i >= start) yield(fact)
    }
}

fun generals(count: Int) = sequence {
    val randomNum = arrayListOf<Int>()
    for (i in 1..count) {
        randomNum.add(Random(i).nextInt())
    }
    yield(randomNum)
}

fun fibonacci(start: Int, end: Int) = sequence {
    var fib = 0
    var fib1 = 1
    var fib2 = 1
    while (true) {

        fib = fib1 + fib2
        fib1 = fib2
        fib2 = fib
        if (fib > end) {
            break
        } else {
            if (fib > start) yield(fib)
        }
    }
}

fun getFibonacci(start: Int, end: Int) = sequence {
    val item = Pair(0, 1)

    while (true) {
        if (item.first > end) break
        else {
            if (item.first > start)
                yield(item.first)
        }
    }
}

fun collatz(num: Int) = sequence {
    var start = num
    while (start != 1) yield(
        if (start % 2 == 0) {
            start /= 2
            start
        } else {
            start = 3 * start + 1
            start
        }
    )
}

fun primeNumberGenerator(start: Int, end: Int) = sequence {
    for (i in 0..end) {
        if (i >= start && i.isPrime()) yield(i)
    }
}

fun superPrimeNumberGenerator(start: Int, end: Int) = sequence {
    var
            index = 0
    for (i in primeNumberGenerator(start, end)) {
        if (index.isPrime()) yield(i)
        index += 1
    }
}

