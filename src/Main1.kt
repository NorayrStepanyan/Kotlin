import java.util.*

fun main() {
//    multyple("String", "String")
//    simbol("String", "String")


}




fun parsToInt(input: String): Int? {
    return try {
        input.toInt()
    } catch (e: Exception) {
        null
    }

}

fun divTest(num: String?) = try {
//    if (num == null) throw NullPointerException()
//    if (num.isEmpty()) throw EmptyStackException()
//    val div = PI_NUM / num.toInt()
//    div
} catch (e: Exception) {
    "emmty string"
} catch (e: Exception) {
    "num=10 exception"
} catch (e: Exception) {
    "type error exception"
}


fun multyple(input1: String, input2: String) =
    if (parsToInt(input1) is Int && parsToInt(input2) is Int) input1.toInt() * input2.toInt()
    else -1


fun simbol(input1: String, input2: String) {
    if (parsToInt(input1) != null && parsToInt(input2) != null) println("$input1 $input2")
    else println("One of input is null.")
}


