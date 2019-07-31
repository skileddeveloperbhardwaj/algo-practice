fun main() {
    var i = 0
    for(i in 1..3) {
        println(i)
    }

    //each increment is of size 2
    //output: 6
    //4
    //2
    //0
    for (i in 6 downTo 0 step 2) {
        println(i)
    }

}