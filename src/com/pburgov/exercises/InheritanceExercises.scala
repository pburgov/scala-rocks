package com.pburgov.exercises


abstract class MyList {
  def head: Int

  def tail: MyList

  def add(number: Int): MyList

  def isEmpty: Boolean

  def printElements: String

  override def toString: String = "[" + printElements + "]"

}

object Empty extends MyList {
  override def head: Int = throw new NoSuchElementException

  override def tail: MyList = throw new NoSuchElementException

  override def add(number: Int): MyList = new Cons(number, Empty)

  override def isEmpty: Boolean = true

  def printElements = ""
}

class Cons(h: Int, t: MyList) extends MyList {
  override def head: Int = h

  override def tail: MyList = t

  override def add(number: Int): MyList = new Cons(number, this)

  override def isEmpty: Boolean = false

  def printElements: String = {
    if (t.isEmpty) " " + h
    else h + " " + t.printElements
  }
}

object InheritanceExercises extends App {

  val myList = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(myList.tail.head)
  println(myList.isEmpty)
  println(myList.add(4).tail)
  println(myList.toString)

}
