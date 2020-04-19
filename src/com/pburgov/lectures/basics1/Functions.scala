package com.pburgov.lectures.basics1

object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + "  " + b
  }

  println(aFunction("Hello", 3))

  def aParameterlessFunction(): Int = 15

  println(aParameterlessFunction())
  println(aParameterlessFunction)

  def repeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + repeatedFunction(aString, n - 1)
  }

  println(repeatedFunction("Hello", 3))

}
