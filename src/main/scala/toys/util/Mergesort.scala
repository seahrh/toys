package toys.util

object Mergesort {
  def sort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
    val mid = xs.length / 2
    if (mid == 0) return xs

    def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
      case (Nil, ys) => ys
      case (xs, Nil) => xs
      // x and y are the first elements of the respective lists
      case (x :: xtail, y :: ytail) =>
        if (ord.lt(x, y)) x :: merge(xtail, ys)
        else y :: merge(xs, ytail)
    }
    
    val (left, right) = xs splitAt mid
    merge(sort(left), sort(right))
  }
}