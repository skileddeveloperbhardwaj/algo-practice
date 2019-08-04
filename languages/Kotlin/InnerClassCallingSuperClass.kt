open class Foo {
    open fun f() {
        println("Method from Base class!!") //--> this is the output
    }
}

class Derived5:Foo() {
    override fun f() {
        println("Method from Derived class!!")
    }

    inner class Inner1 {
        fun g() {
            super@Derived5.f()
        }
    }
}

fun main() {
    var derived = Derived5()
    derived.Inner1().g()
}