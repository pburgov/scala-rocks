package com.pburgov.lectures.part2op

object Inheritance extends App {

  class Animal {
    def eat = println("I'm a Animal Class")

    val creatureTyoe = "wild"
  }

  class Cat extends Animal {

    def crunch(): Unit = {
      eat
      println("I'm  a Cat class")
    }
  }

  val cat = new Cat
  cat.crunch()

  //constructors

  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)

  }

  class Adult(name: String, age: Int, id: String) extends Person(name, age)

  class Young(name: String, age: Int, id: String) extends Person(name)


  //Overriding

  class Dog extends Animal {
    override val creatureTyoe: String = "domestic"

    override def eat: Unit = println("I'm a Dog class")
  }

  val dog = new Dog
  dog.eat
  println(dog.creatureTyoe)

  //override in the constructor
  class Cow(override val creatureTyoe: String) extends Animal {
    override def eat: Unit = println("I'm a Cow class")
  }

  val cow = new Cow("Farm")
  cow.eat
  println(cow.creatureTyoe)

  // type substitution

  val unkwonAnimal: Animal = new Cow("Wild")
  unkwonAnimal.eat

  //super
  class Horse extends Animal {
    override val creatureTyoe: String = "domestic"

    override def eat: Unit = {
      super.eat
      println("Im a Horse class")
    }
  }

  val horse = new Horse
  horse.eat

  //preventing overrides
  // 1 - using final key word in member
  // 2 - using final on the entire class
  // 3 - seal the class = extend the class in THIS FILE but CANT BE EXTENDED FROM OTHER FILES
  class Bird {
    final def fly: Unit = println("I just fly")
  }

  class Eagle extends Bird {
    def flyWithOtherName: Unit = println("I fly high")
  }

  val eagle = new Eagle
  eagle.flyWithOtherName
}
