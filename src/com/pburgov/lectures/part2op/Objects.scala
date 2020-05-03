package com.pburgov.lectures.part2op

object Objects extends App {

  //Scala does not have class-level functionality ("static")
  //Scala objects are Singleton Instance

  object Person {
    val N_INT = 2

    def canFly: Boolean = false

    def from(mother: Person, father: Person): Person = new Person("Bobbie")
  }

  class Person(val name: String) {

  }

  //COMPANIONS

  println(Person.N_INT)
  println(Person.canFly)

  val mary = new Person("Mary")
  val john = new Person("John")
  println(mary == john)

  val personA = Person
  val personB = Person

  println(personA == personB)

  val bobbie = Person.from(mary, john)

  //Scala Applications = Scala Object with
  //def main (args; Array[String]): Unit
}
