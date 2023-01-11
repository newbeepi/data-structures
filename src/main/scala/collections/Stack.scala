package collections

class Stack [A]{
  class Node (val value: A){
    var next: Option[Node] = None
    def hasNext: Boolean =  next.isDefined
  }
  private var root: Option[Node] = None
  def push(value: A): Stack[A] = {
    val newNode: Node = new Node(value)
    if (root.isDefined){
      newNode.next = root
    }
    root = Some(newNode)
    this
  }
  def pop: Option[A] = {
    if (root.isDefined){
      val res = root.get.value
      val newRoot = root.get.next
      root = newRoot
      Some(res)
    }
    else None
  }
  def show(): Unit = {
    if (root.isDefined){
      var currentNode: Node = root.get
      println(currentNode.value)
      while (currentNode.hasNext) {
        currentNode = currentNode.next.get
        println(currentNode.value)
      }
    }
    println()
  }
}
