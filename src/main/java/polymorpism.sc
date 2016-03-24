class tree[T](itemInHole: T) {
  def whatIsInTheHole_? : T = itemInHole
}
class rabbit {
  override def toString = "a rabbit ;)"
}

val myTree = new tree(new rabbit)
myTree whatIsInTheHole_?

trait List[T] {
  def isEmpty : Boolean
  def head : T
  def tail : List[T]
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}

class Nil[T] extends List[T] {
  def isEmpty = true
  def tail:Nothing = throw new NoSuchElementException("tail")
  def head = throw new NoSuchElementException("head")
}


def nht[T](n: Int, list: List[T]): T = {
  if (list.isEmpty) throw new IndexOutOfBoundsException
  else if (n == 0) list.head
  else nht(n-1, list.tail)
}

val numberList = new Cons(3, new Cons(5, new Cons(6, new Nil)))
val value = nht(-1, numberList)