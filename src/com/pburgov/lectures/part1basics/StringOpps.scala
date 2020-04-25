package com.pburgov.lectures.part1basics

object StringOpps extends App {


  val str: String = "Hello, I am learning Scala"

  println(str.charAt(2))
  println(str.substring(7, 11))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase)
  println(str.toUpperCase)
  println(str.length)

  val aNumberString = "45121"
  val aNumber = aNumberString.toInt

  println('a' +: aNumberString :+ 'z')
  println(str.reverse)
  println(str.take(2))

  //S-Interporlators
  val name = "John Snow"
  val age = 12
  val greeting = s"Hello my name is $name and I am $age years old"
  val anotherGreeting = s"Hello my name is $name and I will be turning ${age + 1} years old"
  println(greeting)
  println(anotherGreeting)

  //F-Interpolators
  val speed = 1.2f
  val myth = f"$name%s can eat $speed%2.2f burguers per minute"
  println(myth)

  //raw-Interpolator

  println(raw"This a \n new line")
  val escaped = "This a \n new line"
  println(raw"$escaped")


}
