package toys.util

object MathUtil {
  
  def isPrime(n: Int): Boolean = {
    (2 until n) forall (d => n % d != 0)
  }
  
  /**
 * Given a positive integer n, find all the pairs of positive integers (i, j) 
 * such that 1 <= j < i < n, and i + j is prime.
 * 
 * @param n
 * @return
 */
def pairsHavingPrimeSum(n: Int): IndexedSeq[(Int, Int)] = {
    if (n <= 0) {
      throw new IllegalArgumentException("n must be a positive integer")
    }
    // for-expression with multiple sequence generators in curly braces
    for {
      i <- 1 until n // 1st generator
      j <- 1 until i // 2nd generator
      if isPrime(i + j) // filter
    } yield (i, j)
  }
  
  def scalarProduct(xs: Array[Float], ys: Array[Float]): Float = {
    if (xs.length == 0) {
      throw new IllegalArgumentException("first array must not be empty")
    }
    if (ys.length == 0) {
      throw new IllegalArgumentException("second array must not be empty")
    }
    // Pattern matching function value in map{}
    (xs zip ys).map{ case (x, y) => x * y }.sum
  }
  
  def fib(n: Int): Int = {
    if (n <= 0) {
      throw new IllegalArgumentException("n must be greater than zero")
    }
    // (Tail recursion example)
    def loop(i: Int, a: Int, b: Int): Int = {
      if (i == n) a
      else loop(i + 1, b, a + b)
    }
    // Fibonacci sequence starts with 0, 1, ...
    loop(1, 0, 1)
  }
  
  def factorial(n: Int): Int = {
    if (n < 0) {
      throw new IllegalArgumentException("n must be greater than or equal to zero")
    }
    // (Tail recursion example)
    def loop(acc: Int, n: Int): Int = {
      // Base case: n is zero
      if (n == 0) acc
      else loop(acc * n, n - 1)
    }
    // Starting value of accumulator is 1
    loop(1, n)
  }

  /**
   * Greatest common divisor of two numbers using Euclid's algorithm
   * <p>
   * (Tail recursion example)
   *
   * @param a
   * @param b
   * @return
   */
  def greatestCommonDivisor(a: Int, b: Int): Int = {
    if (b == 0) a
    else greatestCommonDivisor(b, a % b)
  }

  def signum(n: Int): Int = {
    if (n > 0) 1
    else if (n == 0) 0
    else -1
  }

  def sum(args: Int*): Int = {
    var ret = 0
    for (arg <- args) {
      ret += arg
    }
    ret
  }
}