package com.pburgov.exercises


import scala.collection.mutable.ListBuffer

/**
 * Created by Pedro Burgo on 17/05/2020.
 * scala-rocks 
 */
object ExceptionExercises extends App {
  /*

1. Crash the program with an OutOfMemoryError
2. Crash the program with an SOError
3. Create a pocket calculator:

- add(x,y) throws OverFlowExceptions is add exceeds Int.MAX_VALUE
- substract (x,y) throws UnderFlowExceptions is substract exceeds Int.MIN_VALUE
- multiply (x,y)
- divide(x.y) throws MathCalculationException is divided by Zero
   */

  /*
    2. Crash the program with an SOError
   */
  var list: ListBuffer[String] = new ListBuffer[String]

  def askCountvonCount(x: BigInt): Unit = {
    if (x > 0) {
      val num = Math.pow(2, x.doubleValue)
      val message: String = s"${num.intValue()} times I've asked her to marry me, and ${num.intValue} times she said NO. HAHAHHAHAHA"
      list.addAll(addToList(num.intValue(), message, list))
      println("List size: " + list.length)
      askCountvonCount(x + 1)
    }
  }

  def addToList(times: BigInt, message: String, list: ListBuffer[String]): ListBuffer[String] = {
    val listTemp: ListBuffer[String] = new ListBuffer[String]
    if (times > 0) {
      println(message)
      listTemp.addOne(message)
      addToList(times - 1, message, list)
    }
    listTemp
  }

  /*
    3. Pocket Calculator
   */

  class Calculator {
    def add(x: Int, y: Int): BigInt = {
      var z: BigInt = x + y
      if (x > 0 && y > 0 && z < 0) throw new OverFlowException("Over Custom Class")
      else if (x < 0 && y < 0 && z > 0) throw new UnderFlowException("Under Custom Class")
      else {
        println(s"The result of $x + $y = $z")
        z
      }
    }

    def subtract(x: Int, y: Int): BigInt = {
      var z: BigInt = x + y
      if (x > 0 && y < 0 && z < 0) throw new OverFlowException("Over Custom Class")
      else if (x < 0 && y > 0 && z > 0) throw new UnderFlowException("Under Custom Class")
      else {
        println(s"The result of $x - $y = $z")
        z
      }
    }

    def multiply(x: Int, y: Int): Int = {
      var z = x * y
      if (x > 0 && y > 0 && z < 0) throw new OverFlowException("Over Custom Class")
      else if (x < 0 && y < 0 && z < 0) throw new OverFlowException("Over Custom Class")
      else if (x > 0 && y < 0 && z > 0) throw new UnderFlowException("Under Custom Class")
      else if (x < 0 && y > 0 && z > 0) throw new UnderFlowException("Under Custom Class")
      else {
        println(s"The result of $x * $y = $z")
        z
      }
    }

    def divide(x: Int, y: Int): Double = {
      if (y == 0) throw new MathCalculationException("Division by Zero")
      else x / y
    }

  }

  class OverFlowException(message: String) extends RuntimeException(message)


  class UnderFlowException(message: String) extends RuntimeException(message)

  class MathCalculationException(message: String) extends RuntimeException(message)


  //1. OOMrror
  //val array = Array.ofDim(Int.MaxValue)
  //2. SOError
  //askCountvonCount(1)

  //3. Pocket Calculator

  var calc = new Calculator
  calc.add(2, 5)
  //calc.add(Int.MaxValue, 10)
  //calc.add(Int.MinValue, -10)
  //calc.subtract(-1, Int.MaxValue)
  calc.multiply(Int.MaxValue, 2)
  calc.divide(10, 0)

}