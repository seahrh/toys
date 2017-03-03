package toys.util

import org.scalatest.FlatSpec
import org.scalatest.Matchers

class ArrayUtilSpec extends FlatSpec with Matchers {
  "orderByPositiveNumbersFirst" should "return a new array that contains all positive values of the original array, in their original order, followed by all values that are zero or negative, in their original order." in {
    val a = Array(-1, 2, 3, 4, -10, 0, -12)
    assertResult(Array(2, 3, 4, -1, -10, 0, -12)) {
      ArrayUtil.orderByPositiveNumbersFirst(a)
    }
  }
  "swapAdjacent" should "return Int array where adjacent element pairs are swapped" in {
    val a = Array[Int](1, 2, 3, 4, 5)
    assertResult(Array[Int](2, 1, 4, 3, 5)) {
      ArrayUtil.swapAdjacent(a.clone)
    }
  }
  it should "return Char array where adjacent element pairs are swapped" in {
    val a = Array[Char]('a', 'b', 'c', 'd', 'e')
    assertResult(Array[Char]('b', 'a', 'd', 'c', 'e')) {
      ArrayUtil.swapAdjacent(a.clone)
    }
  }
  "swap" should "return Int array where elements at specified indices are swapped" in {
    val a = Array[Int](1, 2, 3, 4, 5)
    assertResult(Array[Int](5, 2, 3, 4, 1)) {
      ArrayUtil.swap(a.clone, 0, 4)
    }
    assertResult(Array[Int](1, 4, 3, 2, 5)) {
      ArrayUtil.swap(a.clone, 1, 3)
    }
  }
  it should "return Char array where elements at specified indices are swapped" in {
    val a = Array[Char]('a', 'b', 'c', 'd', 'e')
    assertResult(Array[Char]('e', 'b', 'c', 'd', 'a')) {
      ArrayUtil.swap(a.clone, 0, 4)
    }
    assertResult(Array[Char]('a', 'd', 'c', 'b', 'e')) {
      ArrayUtil.swap(a.clone, 1, 3)
    }
  }
  "random" should "return 10 random integers in the range [0, 9] using default args" in {
    val a = ArrayUtil.random()
    val len = 10
    val min = 0
    val max = 9
    assertResult(len) {
      a.length
    }
    all(a) should (be >= min and be <= max)
  }
  it should "throw exception if length is less than or equal to zero" in {
    assertThrows[IllegalArgumentException] {
      ArrayUtil.random(len = 0)
    }
  }
  it should "return 5 random integers in the range [-5, 5]" in {
    val len = 5
    val min = -5
    val max = 5
    val a = ArrayUtil.random(len, min, max)
    assertResult(len) {
      a.length
    }
    all(a) should (be >= min and be <= max)
  }
}
