import kotlin.math.pow

fun main() {

    println(summa(1))
    println(operationDouble(12, ::square, ::summaTwo))
    println(upperCase1("abc"))
    println(upperCase2("abc"))
    println(upperCase3("abc"))
    println(calculator(15.0, 3.0))
    println(trueAndFalse("hello"))
    println(variant1)
    println(variant2)

}

fun square(number: Int) = number * number
fun summa(number: Int) = number + number
fun summaTwo(number1: Int, number2: Int) = number1 + number2


fun operationDouble(num: Int, oper: (Int) -> Int, oper1: (Int, Int) -> Int) =
    oper(num) - oper1(num, num + 10)

val upperCase1 = { str: String -> str.uppercase() }
val upperCase2: (String) -> String = { str -> str.uppercase() }     //Lambda
val upperCase3: (String) -> String = { if (it.isNotEmpty()) it.uppercase() else "empty" }  //Lambda


val variant1 = { a: Int, b: Int -> a + b }            //Lambda
val variant2 = { a: Int, b: Int -> if (a > b) a + b else a - b }      //Lambda

var calculator = { _: Double, num2: Double -> 15.0.pow(num2) }
val trueAndFalse = { str: String -> println(str) }


