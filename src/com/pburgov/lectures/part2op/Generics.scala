package com.pburgov.lectures.part2op


object Generics extends App {

  class MyList[A] {
    //use the type of A
  }

  val listOfIntegers = new MyList[Int]

  //generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]

  //variance problem

  class Animal

  class Cat extends Animal

  class Dog extends Animal

  // 1. YES, list[Cat] extends list[Animal] = COVARIANCE
  class CovariantList[+A]

  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]

  // 2. NO = INVARIANCE
  class InvariantList[A]

  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  //3. CONTRAVARIANCE
  class Trainer[-A]

  val trainer: Trainer[Cat] = new Trainer[Animal]

  //bounde types
  class Cage[A <: Animal](animal: Animal) //subtypes
  val cage = new Cage(new Dog)


}
