package toys.util

import org.scalatest.FlatSpec

class MathUtilSpec extends FlatSpec {
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
