package com.pburgov.exercises

abstract class MyList[+A] {
  def head: A

  def tail: MyList[A]

  def add[B >: A](number: B): MyList[B]

  def isEmpty: Boolean

  def printElements: String

  override def toString: String = "[" + printElements + "]"

  def map[B](transformer: MyTransformer[A, B]): MyList[B]

  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]

  def filter(predicate: MyPredicate[A]): MyList[A]

  //concatenation
  def ++[B >: A](list: MyList[B]): MyList[B]

}

object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException

  def tail: MyList[Nothing] = throw new NoSuchElementException

  def add[B >: Nothing](number: B): MyList[B] = new Cons(number, Empty)

  def isEmpty: Boolean = true

  def printElements = ""

  override def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = Empty

  override def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty

  override def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty

  override def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
}

class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h

  def tail: MyList[A] = t

  def add[B >: A](number: B): MyList[B] = new Cons(number, this)

  def isEmpty: Boolean = false

  def printElements: String = {
    if (t.isEmpty) " " + h
    else h + " " + t.printElements
  }

  /*
    [1, 2, 3].map(n * 2)
    = new Cons(2, [2,3].map(n * 2)
    = new Cons(2, new Cons(4, [3].map(n * 2)))
    = new Cons(2, new Cons(4, new Cons(6, Empty.map(n * 2))))
    = new Cons(2, new Cons(4, new Cons(6, Empty)))
   */

  def map[B](transformer: MyTransformer[A, B]): MyList[B] = {
    new Cons(transformer.transform(h), t.map(transformer))
  }

  def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)


  /*
     [1, 2, 3].filter(n % 2 == 0)
     = [2, 3].filter(n % 2 == 0)
     = new Cons(2, [3].filter(n % 2 == 0))
     = new Cons(2, Empty.filter(n % 2 == 0))
     = new Cons(2, Empty)
   */
  def filter(predicate: MyPredicate[A]): MyList[A] = {
    if (predicate.test(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)
  }

  /*
    [1,2] ++ [3,4,5]
    = new Cons(1, [2] ++ [3,4,5])
    = new Cons(1, new Cons(2, Empty ++ [3,4,5]))
    = new Cons(1, new Cons(2, [3,4,5))
    = new Cons(1, new Cons(2. new Cons(3, new Cons(4, new Cons(5)))))
   */


  def flatMap[B](trans: MyTransformer[A, MyList[B]]): MyList[B] = {
    trans.transform(h) ++ t.flatMap(trans)
  }

}

trait MyPredicate[-T] {
  def test(elem: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(elem: A): B
}

object ExpandingCollection extends App {

  val listOfIntegers = new Cons(1, new Cons(2, new Cons(3, Empty)))

  val anotherListOfIntegers = new Cons(4, new Cons(5, Empty))

  println(listOfIntegers.map(new MyTransformer[Int, Int] {
    override def transform(elem: Int): Int = elem * 2
  }).toString)

  println(listOfIntegers.filter(new MyPredicate[Int] {
    override def test(elem: Int): Boolean = elem % 2 == 0
  }).toString)

  println(listOfIntegers ++ anotherListOfIntegers)

}
