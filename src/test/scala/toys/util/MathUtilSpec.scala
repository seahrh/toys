package toys.util

import org.scalatest.FlatSpec

class MathUtilSpec extends FlatSpec {
  "isPrime" should "return true for prime numbers" in {
    val ps = Array(7, 17, 31)
    ps forall (p => MathUtil.isPrime(p) == true)
  }
  it should "return false for non-prime numbers" in {
    val nps = Array(6, 21, 144)
    nps forall (np => MathUtil.isPrime(np) == false)
  }
  "pairsHavingPrimeSum" should "return pairs where the sum is a prime number" in {
    var r = Vector[(Int, Int)]((2,1))
    assertResult(r) {
      MathUtil.pairsHavingPrimeSum(3)
    }
    r = Vector[(Int, Int)]((2,1), (3,2))
    assertResult(r) {
      MathUtil.pairsHavingPrimeSum(4)
    }
    r = Vector[(Int, Int)]((2,1), (3,2), (4,1), (4,3))
    assertResult(r) {
      MathUtil.pairsHavingPrimeSum(5)
    }
    r = Vector[(Int, Int)]((2,1), (3,2), (4,1), (4,3), (5,2), (6,1), (6,5))
    assertResult(r) {
      MathUtil.pairsHavingPrimeSum(7)
    }
  }
  it should "throw exception if n is less than 1" in {
    assertThrows[IllegalArgumentException] { 
      MathUtil.pairsHavingPrimeSum(0)
    }
  }
  "scalarProduct" should "return the scalar product of two non-empty arrays" in {
    var xs = Array[Float](1.5F, 2.2F, 3.5F)
    var ys = Array[Float](4.2F, 5.5F, 6.4F)
    assertResult(40.8F) {
      MathUtil.scalarProduct(xs, ys)
    }
    xs = Array(1F)
    ys = Array(2F)
    assertResult(2F) {
      MathUtil.scalarProduct(xs, ys)
    }
  }
  it should "throw exception if the first array is empty" in {
    var xs = Array[Float]()
    var ys = Array[Float](4.2F, 5.5F, 6.4F)
    assertThrows[IllegalArgumentException] { 
      MathUtil.scalarProduct(xs, ys)
    }
  }
  it should "throw exception if the second array is empty" in {
    var xs = Array[Float](1.5F, 2.2F, 3.5F)
    var ys = Array[Float]()
    assertThrows[IllegalArgumentException] { 
      MathUtil.scalarProduct(xs, ys)
    }
  }
  "fib" should "return 0 for the 1st fibonacci number" in {
    assertResult(0) {
      MathUtil.fib(1)
    }
  }
  it should "return 1 for the 2nd fibonacci number" in {
    assertResult(1) {
      MathUtil.fib(2)
    }
  }
  it should "return 144 for the 13th fibonacci number" in {
    assertResult(144) {
      MathUtil.fib(13)
    }
  }
  it should "throw exception because sequence number must be greater than zero" in {
    assertThrows[IllegalArgumentException] { 
      MathUtil.fib(0)
    }
  }
  "factorial" should "return 24 for 4!" in {
    assertResult(24) {
      MathUtil.factorial(4)
    }
  }
  it should "return 1 for 0!" in {
    assertResult(1) {
      MathUtil.factorial(0)
    }
  }
  it should "throw exception for factorial of negative numbers, which is undefined" in {
    assertThrows[IllegalArgumentException] { 
      MathUtil.factorial(-1)
    }
  }
  "greatestCommonDivisor" should "return 0 if both numbers are zero" in {
    assertResult(0) {
      MathUtil.greatestCommonDivisor(0, 0)
    }
  }
  it should "return 1 if both numbers are 1" in {
    assertResult(1) {
      MathUtil.greatestCommonDivisor(1, 1)
    }
  }
  it should "return 7 if numbers are 14, 21" in {
    assertResult(7) {
      MathUtil.greatestCommonDivisor(14, 21)
    }
  }
  "signum" should "return 1 if n is greater than zero" in {
    assertResult(1) {
      MathUtil.signum(1)
    }
    assertResult(1) {
      MathUtil.signum(Int.MaxValue)
    }
  }
  it should "return -1 if n is less than zero" in {
    assertResult(-1) {
      MathUtil.signum(-1)
    }
    assertResult(-1) {
      MathUtil.signum(Int.MinValue)
    }
  }
  it should "return 0 if n equals zero" in {
    assertResult(0) {
      MathUtil.signum(0)
    }
  }
  "sum" should "return 42 as the sum of its varargs (12, 18, 4, 8)" in {
    assertResult(42) {
      MathUtil.sum(12, 18, 4, 8)
    }
  }
  it should "return the same value as the arg if there is only 1 arg" in {
    assertResult(Int.MaxValue) {
      MathUtil.sum(Int.MaxValue)
    }
    assertResult(Int.MinValue) {
      MathUtil.sum(Int.MinValue)
    }
  }
  it should "return the sum of its varargs which may contain zero or negative numbers" in {
    assertResult(0) {
      MathUtil.sum(1, 0, -1)
    }
  }
}
