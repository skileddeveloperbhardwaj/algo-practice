package classes

open class PropsAndFields {
    var allByDefault:Int? = null
        get() = field //default getter
        /*set(value) { //default setter
            field= value
        }*/
        set(value) {
            var temp = value
            temp = temp?.plus(10)
            field = temp //field is the backing field; it  can be used only in the accessors: getters and setters
        }

    val isEmpty get() = this.allByDefault == 0  // has type Boolean --> type an be inferred from getter

    var setterVisibility: String = "abc"
        private set // the setter is private and has the default implementation
}

fun main() {
    var propertyTest = PropsAndFields()
    println(propertyTest.allByDefault) // getter called
    propertyTest.allByDefault = 15 //setter called
    println("${propertyTest.allByDefault}")
}