package com.pburgov.exercises


import java.time.LocalDate

object OOBasicsExercises extends App {

  val writer = new Writer("John", "Doe", 1973)

  println(writer.fullName())

  val novel = new Novel("My First Novel", 2015, writer)
  novel.authorAge()


  //We get a new instance of novel
  val novel2 = novel.copy(2017)
  novel2.authorAge()

  println("The novel is written by author: " + novel.isWrittenBy(writer))

  val impostor = new Writer("John", "Doe", 1973)

  println("The novel is written by impostor: " + novel.isWrittenBy(impostor))


  println("Testing Counter Class")

  val resultString = "El valor actual de %s es: %d"
  val counterA = new Counter(3)
  println(resultString.format(counterA.toString, counterA.currentCount()))

  val counterB = counterA.increment()
  println(resultString.format(counterB.toString, counterB.currentCount()))

  val counterC = counterA.decrement()
  println(resultString.format(counterC.toString, counterC.currentCount()))

  val counterD = counterA.increment(10)
  println(resultString.format(counterD.toString, counterD.currentCount()))

  val counterE = counterA.decrement(10)
  println(resultString.format(counterE.toString, counterE.currentCount()))

  val counter = new Counter
  counter.increment().print
  counter.increment.increment.print
  counter.increment(5).print


}

class Writer(val firstName: String, val lastName: String, val yearOfBirth: Int) {

  def fullName(): String = firstName + " " + lastName

}

class Novel(name: String, yearOfRelease: Int, author: Writer) {

  private def calculateAge(yearOfBirth: Int): Int = {
    val year = LocalDate.now.getYear
    println("Current Year: " + year) //Not actually used, just trying
    return yearOfRelease - yearOfBirth
  }

  def authorAge(): Unit = println(s"The age of the author when the novel was written was: ${calculateAge(author.yearOfBirth)}")

  def isWrittenBy(author: Writer): Boolean = author == this.author

  def copy(newYear: Int): Novel = new Novel(name, newYear, author)

}

class Counter(val n: Int = 0) {

  def currentCount(): Int = n

  def increment() = {
    println("incrementing")
    new Counter(n + 1)
  }

  def decrement() = {
    println("decrementing")
    new Counter(n - 1)
  }

  def increment(x: Int): Counter = {
    if (x <= 0) this
    else increment().increment(x - 1)
  }

  def decrement(x: Int): Counter = {
    if (x <= 0) this
    else decrement().decrement(x - 1)
  }

  def print = println(currentCount())

  override def toString: String = "Counter-" + n
}

