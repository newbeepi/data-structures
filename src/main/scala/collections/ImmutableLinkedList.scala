package collections

class ImmutableLinkedList[A]{
  private var list: LinkedList[A] = new LinkedList[A]
  def this(values: A*) = {
    this()
    list = new LinkedList[A].fromIterable(values)
  }
  private def this(list: LinkedList[A]) = {
    this()
    this.list = list
  }
  def length: Int = {
    list.length
  }
  def map(f: A => A): ImmutableLinkedList[A] = {
    new ImmutableLinkedList[A](list.map(f))
  }

  def filter(f: A => Boolean): ImmutableLinkedList[A] = {
    new ImmutableLinkedList[A](list.filter(f))
  }

  def reduce(op: (A, A) => A): A = {
    list.reduce(op)
  }
  def show(): Unit = {
    list.show()
  }
}
