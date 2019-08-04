open class A {
    fun a() {
    }

    open fun f() {
        println("From A!!")
    }
}

interface B {
    fun b(){
    }

    fun f() {
        println("From B!!")
    }
}

class C : A(),B {
    override fun f() {
        super<A>.f()
        super<B>.f()
         println("From C!!")
    }
}

fun main() {
    C().f()
}