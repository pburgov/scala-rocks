package com.pburgov.lectures.part2op

/**
 * Created by Pedro Burgo on 17/05/2020.
 * scala-rocks 
 */
object Exceptions extends App {

  val x: String = null
  //println(x.length)
  // throw  new NullPointerException

  //  val aWeirdValue =  throw  new NullPointerException

  // how to catch Exceptions
  def getInt(withException: Boolean): Int = {
    if (withException) throw new NullPointerException("No Int for you")
    else 42
  }

  val potencialFail = try {
    getInt(true)
  } catch {
    case e: NullPointerException => println("A NullPointerException's been caught")
    case e: RuntimeException => println("A RuntimeException's been caught")

  } finally {
    println("executed no matter what")
  }


  //how to define customs exceptions

  class MyException extends Exception {

  }

  val myException = new MyException

  throw myException

}
