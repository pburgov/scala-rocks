package com.pburgov.lectures.part2op


object AnomymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  // anonymous class
  val funnyAnimal = new Animal {
    override def eat: Unit = println("funnyAnimal")
  }

  //equal to
  /*
    class AnomymousClasses$$anon$1 extends Animal {
    override def eat: Unit = println("funnyAnimal")
    }
    val funnyAnimal: Animal = new AnomymousClasses$$anon$1
   */
  println(funnyAnimal.getClass)


  class Person(name: String) {
    def sayHi: Unit = println(s"Hi my name is $name, how can I help")
  }

  val jim = new Person("jim") {
    override def sayHi: Unit = println(s"Hi my name is Jim, how can I be of service?")
  }
}
