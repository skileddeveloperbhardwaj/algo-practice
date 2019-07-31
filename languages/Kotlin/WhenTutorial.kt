fun main() {
    var i = 20
    //Output is: Hello
    when(i) {
        20 -> println("Hello")
        else -> {
            println("World")
        }
    }

    //combination of conitions
    i=0
    when (i) {
        0, 1 -> println("x == 0 or x == 1")
        else -> println("otherwise")
    }

    //range conditions or collections
    i=5
    when (i) {
        in 1..10 -> println("x is in the range")
        //in validNumbers -> print("x is valid")
        !in 10..20 -> println("x is outside the range")
        else -> println("none of the above")
    }
    //no arguements
    when {
        i%2 != 0 -> println("x is odd")
        i%2 == 0 -> println("x is even")
        else -> println("x is funny")
    }

    /* Todo: understand this logic
    fun hasPrefix(x: Any) = when(x) {
    is String -> x.startsWith("prefix")
    else -> false
}
     */
}


