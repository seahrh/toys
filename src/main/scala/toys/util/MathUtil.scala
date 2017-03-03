package toys.util

object MathUtil {
  def signum(n: Int) = {
    if (n > 0) 1
    else if (n == 0) 0
    else -1
  }
  
  def sum(args: Int*) = {
    var ret = 0
    for (arg <- args) {
      ret += arg
    }
    ret
  }
}