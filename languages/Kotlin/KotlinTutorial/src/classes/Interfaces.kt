package classes

interface Interface1 {
    val prop1:Int
    val prop2:String
        get() = "Foo"
    fun foo() {
        print(prop1)
    }
}

interface Named {
    val name:String
}

interface Person:Named {
    val firstName:String
    val secondName:String
    override val name:String get() = "$firstName $secondName"
}

class Employee(override val firstName: String, override val secondName: String):Person

//fun main() {
//    print(Employee("Gaurav", "Bhardwaj").name)
//}

//Resolving overriding conflicts
interface A {
    fun foo() {
        print("foo A")
    }

    fun bar() //abstract method
}

interface B {
    fun foo() {
        print("foo B")
    }

    fun bar() {
        print("foo B")
    }
}

class C:A,B {
    override fun foo() {
        super<B>.foo()
        super<A>.foo()
    }

    override fun bar() {
//        super.bar()
        print("Bar C")
    }
}

fun main() {
    C().foo()
    C().bar()
}