package toys

import org.scalatest.FlatSpec

class DiamondSpec extends FlatSpec {
  "mkString" should "return the correct diamond shape for odd width" in {
    var n = 3
    var out = " + \n+++\n + "
    assertResult(out) {
      Diamond.mkString(n)
    }
    n = 5
    out = "  +  \n +++ \n+++++\n +++ \n  +  "
    assertResult(out) {
      Diamond.mkString(n)
    }
  }
  it should "return the correct diamond shape for even width" in {
    val n = 6
    val out = "  ++  \n ++++ \n++++++\n ++++ \n  ++  "
    assertResult(out) {
      Diamond.mkString(n)
    }
  }
  it should "throw exception for width less than 3" in {
    assertThrows[IllegalArgumentException] { 
      Diamond.mkString(2)
    }
  }
}
