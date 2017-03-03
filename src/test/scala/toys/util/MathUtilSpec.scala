package toys.util

import org.scalatest.FlatSpec

class MathUtilSpec extends FlatSpec {
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
