//import java.math.BigDecimal

/* =============== Home Work =============== */

fun main() {


}



fun table(num: Int): ArrayList<String> {
    val pad = arrayListOf<String>()
    for (i in 1..10) {
        pad.add("$num * $i = ${i * num}")
    }
    return pad
}

fun Int.triangle(a: Int, b: Int) {
    if (a + b > this) return println("true")
    if (a + this > b) return println("true")
    if (this + b > a) return println("true")
    else println("There is not corresponding value")


}











