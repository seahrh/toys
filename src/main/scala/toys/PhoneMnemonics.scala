package toys

import scala.io.Source

object PhoneMnemonics extends App {
  val in = Source.fromFile("src/main/resources/linuxwords.txt")
  val words = in.getLines.toList filter (word => word forall (c => c.isLetter))
  val mnem: Map[Char, String] = Map('2' -> "ABC", '3' -> "DEF",
    '4' -> "GHI", '5' -> "JKL", '6' -> "MNO",
    '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ")
  /**
   * Invert the mnem map to give a map from chars A..Z to digits 2..9
   */
  val charCode: Map[Char, Char] =
    for {
      (digit, str) <- mnem
      letter <- str
    } yield letter -> digit
  /**
   * Maps a word to the digit string it represents
   * e.g. "Java" -> "5282"
   *
   * @param word
   * @return
   */
  def wordCode(word: String): String = {
    word.toUpperCase map charCode
  }
  /**
   * A map from digit strings to the words that represent them
   * e.g. "5282" -> List("Java", "Kata", "Lava", ...)
   * A missing number should map to the empty seq
   * e.g. "1111" -> List()
   */
  val wordsForNum: Map[String, Seq[String]] =
    words groupBy wordCode withDefaultValue Seq()
  /**
   * Return all ways to encode a number as a list of words
   *
   * @param number
   * @return
   */
  def encode(number: String): Set[List[String]] = {
    if (number.isEmpty) Set(List())
    else {
      for {
        split <- 1 to number.length
        word <- wordsForNum(number take split)
        rest <- encode(number drop split)
      } yield word :: rest
    }.toSet
  }
  
  def translate(number: String): Set[String] = {
    encode(number) map (_ mkString " ")
  }
  translate("7225247386") foreach println
}


