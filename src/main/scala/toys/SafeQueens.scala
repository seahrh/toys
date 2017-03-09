package toys

object SafeQueens {
  /**
   * Given n number of queens, place the queens on a nxn chessboard, 
   * such that they do not threaten each other.
   * (i.e. queens cannot be placed on the same row, column and diagonal) 
   *
   * One way to solve the problem would be to place a queen in each row. 
   * So we start with the first row, place a queen there, then place a queen in the second row, and so on. 
   * Once we've placed a number of queens, we must check 
   * for the next queen in the column that it does not threaten any of the other queens, 
   * so that it sits in its own column and it doesn't threaten the other queens by following a diagonal. 
   * That's lead to a recursive algorithm for solving the problem.
   *
   * @param n
   * @return
   */
  def queens(n: Int): Set[List[Int]] = {
    if (n < 4) {
      throw new IllegalArgumentException("#queens must be greater than or equal to 4, in order for them to be placed safely.")
    }
    def placeQueens(k: Int): Set[List[Int]] = {
      if (k == 0) Set(List())
      else
        for {
          queens <- placeQueens(k - 1)
          col <- 0 until n
          if isSafe(col, queens)
        } yield col :: queens
    }
    placeQueens(n)
  }

  def isSafe(col: Int, queens: List[Int]): Boolean = {
    // row is the number of queens already placed,
    // we are placing a new queen (col)
    // so row must be less than n!
    val row = queens.length
    val queensWithRow = (row - 1 to 0 by -1) zip queens
    queensWithRow forall {
      // diagonals differ by the same number of rows and columns
      case (r, c) => col != c && math.abs(col - c) != row - r
    }
  }
  
  def main(args: Array[String]): Unit = {
    val n = args(0).toInt
    def show(queens: List[Int]): String = {
      val len = queens.length
      val lines = 
        for (col <- queens.reverse) 
          yield Vector.fill(len)("- ").updated(col, "X ").mkString 
      // Format each row on new line
      "\n" + (lines mkString "\n")
    }
    // Format each combination on new line
    println((queens(n) map show) mkString "\n")
  }
}