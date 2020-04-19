package com.pburgov.playground

object ScalaPlayground extends App {

  //Functions
  //Task 1 - Greeting function
  def greetingFunction(name: String, age: Int): String = {
    "Hi, my name is " + name + " and I'm " + age + " years old"
  }

  println("Task 1 - Greeting function")
  println(greetingFunction("Paul", 12))

  //Task 2 - Factorial Function
  def factorial(num: Int): Int = {
    if (num <= 0) 1
    else num * factorial(num - 1)
  }

  println("Task 2 - Factorial Function")
  println(factorial(6))

  //Task 3 - Fibonacci Series
  def fibonacci(n: Int): Int = {
    if (n <= 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)
  }

  println("Task 3 - Fibonacci Series")
  println(fibonacci(8))

  //Task 4 - Prime
  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)
    }

    isPrimeUntil(n / 2)
  }

  println("Task 4 - Is Prime?")
  println(isPrime(11))
  println(isPrime(64))
  println(isPrime(17))
}
