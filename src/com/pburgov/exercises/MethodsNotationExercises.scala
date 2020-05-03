package com.pburgov.exercises

import scala.language.postfixOps

object MethodsNotationExercises extends App {


  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {

    def likes(movie: String): Boolean = movie == favoriteMovie

    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def +(nickname: String): Person = new Person(s"$name ($nickname)", favoriteMovie)

    def unary_! : String = s"${this.name} what the heck!!"

    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)

    def learns(language: String): String = s"$name learns $language"

    def learnsScala: String = this.learns("Scala")

    def isAlive: Boolean = true

    def apply(): String = s"Hi my name is $name and my favorite movie is $favoriteMovie"

    def apply(m: Int): String = s"$name watched $favoriteMovie $m times"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.+("the rockstar").apply())
  println((mary + "The Lady in Red").apply())
  println((mary + "The Lady in Red") ()) //inflix operator
  println((+mary).age) //prefix operator
  println(mary.learnsScala)
  println(mary learnsScala) //postfix operator
  println(mary.apply(2))
  println(mary(3))
}
