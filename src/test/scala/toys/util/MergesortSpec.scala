package toys.util

import org.scalatest.FlatSpec

class MergesortSpec extends FlatSpec {
  "sort" should "sort integers in ascending order implicitly" in {
    var in = List(-1, 2, 3, 4, -10, 0, -12)
    var out = List(-12, -10, -1, 0, 2, 3, 4)
    assertResult(out) {
      Mergesort.sort(in)
    }
  }
  it should "sort integers in descending order if such an Ordering is supplied" in {
    var in = List(-1, 2, 3, 4, -10, 0, -12)
    var out = List(4, 3, 2, 0, -1, -10, -12)
    assertResult(out) {
      Mergesort.sort(in)(Ordering[Int].reverse)
    }
  }
  it should "sort strings in ascending order implicitly" in {
    var in = List("pineapple", "orange", "apple", "pear")
    var out = List("apple", "orange", "pear", "pineapple")
    assertResult(out) {
      Mergesort.sort(in)
    }
  }
  it should "sort strings in descending order if such an Ordering is supplied" in {
    var in = List("pineapple", "orange", "apple", "pear")
    var out = List("pineapple", "pear", "orange", "apple")
    assertResult(out) {
      Mergesort.sort(in)(Ordering[String].reverse)
    }
  }
  it should "return the same list if the list has only 1 element" in {
    var in = List("pineapple")
    var out = List("pineapple")
    assertResult(out) {
      Mergesort.sort(in)
    }
  }
  it should "return the same list if the list is empty" in {
    var in = List()
    var out = List()
    assertResult(out) {
      Mergesort.sort(in)(Ordering[Int])
    }
  }
}
