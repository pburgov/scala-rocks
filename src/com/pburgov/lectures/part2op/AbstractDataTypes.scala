package com.pburgov.lectures.part2op


object AbstractDataTypes extends App {

  abstract class Animal {
    val creatureType: String = "wild"

    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "I'm a Dog"

    override def eat: Unit = println("I eat bones")
  }

  //traits

  trait Carnivore {
    def eat(animal: Animal): Unit

    val preferredMeal: String = "Meat"


  }

  class Crocodrile extends Animal with Carnivore {
    override val creatureType: String = "I'm a crocodile"

    def eat: Unit = println("I eat Buffalos")

    def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating a ${animal.creatureType}")

    preferredMeal
  }

  val dog = new Dog
  val croc = new Crocodrile
  croc.eat(dog)
  println(croc.preferredMeal)

  // traits vs Abstract class
  // 1.- traits doesnt have constructor parameters
  // 2.- classes can extends multiple traits but just one abstract class
  // 3.- traits = behavior vs abstract = type of things
}
