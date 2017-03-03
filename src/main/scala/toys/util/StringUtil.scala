package toys.util

object StringUtil {
  def unicodeProduct(s: String): BigInt = {
    s.foldLeft(1: BigInt)((a, b) => a * b)
  }
  
  def unicodeProductRec(s: String): BigInt = {
    if (s.length == 0) 1
    else s.head * unicodeProductRec(s.tail)
  }
}