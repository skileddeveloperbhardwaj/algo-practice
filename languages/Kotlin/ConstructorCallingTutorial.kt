open class Base3(val name: String) {

    init { println("Initializing Base") } // -- 3.

    open val size: Int =
        name.length.also { println("Initializing size in Base: $it") } //--4.
}

class Derived4(
    name: String,
    val lastName: String
) : Base3(name.capitalize().also { println("Argument for Base: $it") }) { //-- 2.

    init { println("Initializing Derived") } // -- 5.

    override val size: Int =
        (super.size + lastName.length).also { println("Initializing size in Derived: $it") } //--6.
}

fun main() {
    println("Constructing Derived(\"hello\", \"world\")")  // -- 1.
    val d = Derived4("hello", "world")
}