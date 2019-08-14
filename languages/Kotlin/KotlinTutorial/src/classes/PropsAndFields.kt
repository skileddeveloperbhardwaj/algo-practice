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
            field = temp
        }
}

fun main() {
    var propertyTest = PropsAndFields()
    println(propertyTest.allByDefault) // getter called
    propertyTest.allByDefault = 15 //setter called
    println("${propertyTest.allByDefault}")
}