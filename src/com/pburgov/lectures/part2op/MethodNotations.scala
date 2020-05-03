package com.pburgov.lectures.part2op

import scala.language.postfixOps

object MethodNotations extends App {


  class Person(val name: String, favoriteMovie: String) {

    def likes(movie: String): Boolean = movie == favoriteMovie

    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def unary_! : String = s"${this.name} what the heck!!"

    def isAlive: Boolean = true

    def apply(): String = s"Hi my name is $name and my favorite movie is $favoriteMovie"
  }

  val mary = new Person("Mary", "Inception")

  //Inflix Notation (syntatic sugar)
  println(mary.likes("Inception"))
  println(mary likes "Inception")


  // "operators" in Scala

  val tom = new Person("Tom", "Fight Club")
  println(mary.hangOutWith(tom))
  println(mary hangOutWith tom)

  println(mary.+(tom))
  println(mary + tom)


  //Prefix Notation
  val x = -1 // equilvalente a  1.unary_-
  val y = 1.unary_-

  //unary prefix only works with + - ~ !

  println(!mary)
  println(mary.unary_!)


  //Postfix Notation
  println(mary.isAlive)
  println(mary isAlive)

  //apply
  println(mary.apply())
  println(mary()) // equilaventes

}
