object Singleton {
    init {
        println("Singleton class invoked!!")
    }

    var variableName = "I am var"
    fun printVarName() {
        println(variableName)
    }
}

fun main(args:Array<String>) {
    Singleton.printVarName()
}