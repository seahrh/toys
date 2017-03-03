package toys.util

import org.scalatest.FlatSpec

class StringUtilSpec extends FlatSpec {
  "unicodeProduct, unicodeProductRec" should "return 1 if string is empty" in {
    assertResult(1) {
      StringUtil.unicodeProduct("")
      StringUtil.unicodeProductRec("")
    }
  }
  it should "return the product of the Unicode codes of all chars in a string" in {
    val in = "Hello"
    assertResult(9415087488L) {
      StringUtil.unicodeProduct(in)
      StringUtil.unicodeProductRec(in)
    }
  }
}
