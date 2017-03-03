package toys.util

object MathUtil {
  
  def factorial(n: Int): Int = {
    if (n < 0) {
      throw new IllegalArgumentException("n must not be less than zero")
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