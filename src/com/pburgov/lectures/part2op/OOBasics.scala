package com.pburgov.lectures.part2op

object OOBasics extends App {

  val person = new Person("John", 26)

  println("Age:" + person.age)
  println("X: " + person.x)
  person.greet_wrong("Daniel")
  person.greet_right("Daniel")
}

//constructor
class Person(name: String, val age: Int) { //class parameters are NOT fields of the class

  val x = 2 //field

  println("executed in every instantiation: " + (x + 1)) //evaluated/executed in every instantiation

  def greet_wrong(name: String): Unit = println(s"$name says, hi $name")

  def greet_right(name: String): Unit = println(s"${this.name} says, hi $name")

  //overloading
  def greet_wrong(): Unit = println(s"Hi i'm $name")

  //overloading constructors

  def this(name: String) = this(name, 0)

}


