package toys.util

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import toys.SafeQueens

class SafeQueensSpec extends FlatSpec with Matchers {
  "queens" should "return all combinations of queen placements such that they do not threaten each other" in {
    var e = Set(List(1, 3, 0, 2), List(2, 0, 3, 1))
    assertResult(e) {
      SafeQueens.queens(4)
    }
  }
  it should "throw exception because queens cannot be placed safely if n is less than 4" in {
    assertThrows[IllegalArgumentException] {
      SafeQueens.queens(3)
    }
  }
}
