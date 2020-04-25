package com.pburgov.lectures.part1basics

object Expressions extends App {

  val x = 1 + 3
  println(x)

  var aVariable = 2
  aVariable += 1
  println(aVariable)

  //IF expression
  val aCondition = true
  val aConditioned = if (aCondition) 5 else 9
  println(aConditioned)

  val aWeirdWalue = (aVariable = 3) //Unit == void

  println(aWeirdWalue)

  val aCodeBlock = {
    val y = 2
    val z = y + 1
    if (z > 2) "Hello" else "Bye bye"
  }
  println(aCodeBlock)

}
