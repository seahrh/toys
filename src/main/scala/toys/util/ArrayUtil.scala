package toys.util

import scala.util.Random
import scala.reflect.ClassTag

object ArrayUtil {
  
  def swapAdjacent[T: ClassTag](a: Array[T]): Array[T] = {
    a.grouped(2).flatMap(_.reverse).toArray
  }
  
  def swap[T](a: Array[T], i: Int, j: Int): Array[T] = {
    val len = a.length
    if (len < 2) {
      throw new IllegalArgumentException("length must be greater than 1")
    }
    if (i < 0 || i >= len) {
      throw new IllegalArgumentException("i is index out of bounds")
    }
    if (j < 0 || j >= len) {
      throw new IllegalArgumentException("j is index out of bounds")
    }
    val temp = a(i)
    a(i) = a(j)
    a(j) = temp
    a
  }
  
  def random(len: Int = 10, min: Int = 0, max: Int = 9): Array[Int] = {
    if (len <= 0) {
      throw new IllegalArgumentException("length must be greater than zero")
    }
    val a = new Array[Int](len)
    for (i <- 0 until a.length) {
      a(i) = Random.nextInt(max + 1) + min
    }
    a
  }
}