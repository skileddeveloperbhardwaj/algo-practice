open class Base {
   open val x:Int = 0 //open modifier required for overriding it into derived class
}

class Derived:Base() {
    override var x:Int = 0 //cannot have a variable with same name and property as base class.
}