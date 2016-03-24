
val t1 = new NonEmpty(5, new Empty, new Empty)
val t2 = t1 incl 4
val t3 = t2 incl 1

object blackTree {
  def steal(money:Int) : Boolean = throw new Error("Oh no")
}


trait magic {
  def hasMana : Boolean = true
}

class tree(size:Int) {

}

class magicTree extends tree(5) with magic {

}

trait entity {
  def alive : Boolean
}
abstract class IntSet {
  def incl(x:Int) : IntSet
  def contains(x:Int) : Boolean
}
class Empty extends IntSet {
  def incl(x:Int) : IntSet =
    new NonEmpty(x, new Empty, new Empty)
  def contains(x:Int) : Boolean = false
}
class NonEmpty(element:Int, left:IntSet, right:IntSet) extends IntSet {
  def incl(x:Int) : IntSet =
    if (x < element) left incl x
    else if (x > element) right incl x
    else this

  def contains(x:Int) : Boolean =
    if (x < element) left contains x
    else if (x > element) right contains x
    else true
}

/*

abstract class IntSet {
  def contains(x:Int) : Boolean
  def incl(x:Int) : IntSet
}

class Empty extends IntSet {
  def contains(x: Int): Boolean = false

  def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)

  override def toString = "."
}

class NonEmpty(element:Int, left:IntSet, right:IntSet) extends IntSet {
  def contains(x: Int): Boolean =
    if (x < element) left contains x
    else if (x > element) right contains x
    else true

  def incl(x: Int): IntSet =
    if (x < element) new NonEmpty(element, left incl x, right)
    else if (x > element) new NonEmpty(element, left, right incl x)
    else this

  override def toString = "{" + left + element + right + "}"
}
*/
