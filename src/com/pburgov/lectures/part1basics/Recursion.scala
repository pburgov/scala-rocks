package com.pburgov.lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {


  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else n * factorial(n - 1)
    //{
    // println("Computing factorial of " + n + " I need factorial of " + (n - 1))
    //val result = n * factorial(n - 1)
    //println("Computed factorial of " + n)

    //result

    //}
  }

  println(factorial(10))

  def smartFactorial(n: Int): Int = {
    @tailrec
    def factHelper(x: Int, accumulator: Int): Int = {
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator)
    }

    factHelper(n, 1)
  }
}
