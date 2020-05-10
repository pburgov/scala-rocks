package com.pburgov.lectures.part2op


object CaseClasses extends App {

  /*
   equals, hashcode, toString
   */

  case class Person(name: String, age: Int)

  // 1. Parameters are promoted to fields
  val jim = new Person("Jim", 25)
  println(jim.age)

  // 2. sensible to toString
  // println(instance) = println(instance.toString)(
  println(jim.toString)
  println(jim)

  // 3. equals and hashcode implemented OOTB
  val jim2 = new Person("Jim", 34)
  println(jim == jim2)

  // 4. CCs have copy method
  val jim3 = jim.copy()
  println(jim3 == jim)

  // 5. CCs have companion objects
  val thePerson = Person
  val mary = Person("Mary", 35)

  // 6. CCs are serializable
  // 7. CCs have extractors patterns
}
