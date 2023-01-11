package collections

class Queue[A] {
  class Node (var value: A){
    var next: Option[Node] = None
    var prev: Option[Node] = None

    def hasNext: Boolean = next.isDefined
    def hasPrev: Boolean = prev.isDefined
  }

  private var front: Option[Node] = None
  private var rear: Option[Node] = None

  def enqueue(value: A): Queue[A] = {
    val newNode = new Node(value)
    if (front.isEmpty){
      front = rear
    }
    newNode.next = rear
    if (rear.isDefined){
      rear.get.prev = Some(newNode)
    }
    rear = Some(newNode)
    this
  }

  def deque: Option[A] = {
    if (front.isEmpty && rear.isDefined) {
        val res = rear.get.value
        rear = None
        return Some(res)
    }
    else if (front.isDefined) {
      val res = front.get.value
      val newFront = front.get.prev
      if (newFront.isDefined) newFront.get.next = None
      front = newFront
      return Some(res)
    }
    None
  }

  def show(): Unit = {
    if (rear.isDefined) {
      var currentNode: Node = rear.get
      print(currentNode.value)
      while (currentNode.hasNext){
        currentNode = currentNode.next.get
        print(s"=>${currentNode.value}")
      }
    }
    println()
  }
}
