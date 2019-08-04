interface Base1 {
    val count: Int
}

class Derived2(override val count: Int) : Base1


class Derived3:Base1 {
    override val count:Int =0
}