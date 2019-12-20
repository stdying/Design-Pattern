package strategy

abstract class Duck {
    var flyBehavior: FlyBehavior? = null
    var quackBehavior: QuackBehavior? = null

    abstract fun display()

    fun performFly() {
        flyBehavior?.fly()
    }

    fun performQuack() {
        quackBehavior?.quack()
    }

    fun swim() {
        println("All duck float, event decoys!")
    }
}

interface FlyBehavior {
    fun fly()
}

interface QuackBehavior {
    fun quack()
}

class FlyWithWings : FlyBehavior {
    override fun fly() {
        println("I'm flying !!")
    }
}

class FlyNoWay : FlyBehavior {
    override fun fly() {
        println("I can't fly ")
    }
}

class Quack : QuackBehavior {
    override fun quack() {
        println("Quack")
    }

}

class MuteQuack : QuackBehavior {
    override fun quack() {
        println("<< Silence>>")
    }

}

class Squeak : QuackBehavior {
    override fun quack() {
        println(" Squeak ")
    }
}

class MallardDuck : Duck() {

    init {
        flyBehavior = FlyWithWings()
        quackBehavior = Quack()
    }

    override fun display() {
        println("I'm a real Mallard duck")
    }

}

fun main() {
    val mallard = MallardDuck()
    mallard.performQuack()
    mallard.performFly()
}
