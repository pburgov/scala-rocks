package com.pburgov.lectures.part1basics

object DefaultArgs extends App {

  def factorial(n: Int, acc: Int = 1): Int = {
    if (n <= 1) acc
    else factorial(n - 1, n * acc)
  }

  println(factorial(3))

  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080) = println("saving picture")

  savePicture()
  savePicture("bmp")
  savePicture(width = 80)
}
