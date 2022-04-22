data class Person(val name: String, val address: String, val phoneNumber: String)

fun main() {
    val karen = Person("karen", "armenia", "1231233")
    val david = Person("david", "armenia", "12121212")
    println("${karen.name} ${karen.address} ${karen.phoneNumber}")
    println("${david.name} ${david.address} ${david.phoneNumber}")
    with(karen) {
        println("$name's address is $address, phone number is $phoneNumber.")
    }
    with(david) {
        println("$name's address is $address, phone number is $phoneNumber.")
    }
}
