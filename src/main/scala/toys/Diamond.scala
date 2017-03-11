package toys

object Diamond extends App {
  /**
 * Print a diamond of '+'s with a maximum width n.
 * 
 * For even n, assume that the difference between the height
 * and width of the diamond should not be more than 1.
 * 
 * For odd n, the height and width of the diamond should be the same.
 * 
 * @param n
 * @return
 */
def mkString(n: Int): String = {
    if (n < 3) {
      throw new IllegalArgumentException("width must be greater than or equal to 3")
    }
    val bgChar: Char = ' '
    val fgChar: Char = '+'
    var i: Int = n / 2
    var fgWidth: Int = 1
    if (n % 2 == 0) {
      i -= 1
      fgWidth = 2
    }
    var top: List[String] = List()
    var fg: String = ""
    var line: String = ""
    // Get the top triangle of the diamond
    while (i > 0) {
      // Pad the foreground to the correct width
      fg = Vector.fill(fgWidth)(fgChar).mkString
      // Replace the background with the foreground
      // at the correct positions
      line = Vector.fill(n)(bgChar).patch(i, fg, fg.length).mkString
      top = top :+ line
      i -= 1
      fgWidth += 2
    }
    val middle: String = Vector.fill(n)(fgChar).mkString
    val bottom: List[String] = top.reverse
    (top mkString "\n") + "\n" + middle + "\n" + (bottom mkString "\n")
  }

  def draw(n: Int) = {
    println(mkString(n))
  }

  draw(5)
  draw(6)
}