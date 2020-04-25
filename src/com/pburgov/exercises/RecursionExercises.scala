package com.pburgov.exercises

import scala.annotation.tailrec

object RecursionExercises extends App {

  //Task 1 - Concatenate a string n times
  //Task 2 - IsPrime

  @tailrec
  def concatenateString(aString: String, n: Int, acumulator: String): String = {
    if (n <= 0) acumulator
    else concatenateString(aString, n - 1, aString + acumulator)
  }

  println(concatenateString("Hello", 10, ""))


  def isPrime(num: Int): Boolean = {
    @tailrec
    def isPrimeTailRec(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailRec(t - 1, num % t != 0 && isStillPrime)
    }

    isPrimeTailRec(num / 2, true)
  }

  println(isPrime(11))

  println(isPrime(57))

  def finonacci(n: Int): Int = {
    @tailrec
    def fibonacciTailrec(i: Int, last: Int, nextToLast: Int): Int = {
      if (i >= n) last
      else fibonacciTailrec(i + 1, last + nextToLast, last)
    }

    if (n <= 2) 1
    else fibonacciTailrec(2, 1, 1)

  }

  println(finonacci(8))

}
