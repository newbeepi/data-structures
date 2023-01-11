package collections

class LinkedList[A] {
  class Node (var value: A){
    var next: Option[Node] = None

    def hasNext: Boolean = next.isDefined
  }
  private var head: Option[Node] = None

  def fromValues(values: A*): LinkedList[A] = {
    val res: LinkedList[A] = new LinkedList[A].fromIterable(values)
    res
  }

  def fromIterable(values: Iterable[A]): LinkedList[A] = {
    val res: LinkedList[A] = new LinkedList[A]
    for (value <- values) {
      res.append(value)
    }
    res
  }
  def append(value: A): LinkedList[A] ={
    val newNode = new Node(value)
    if (head.isDefined){
      newNode.next = head
    }
    head = Some(newNode)
    this
  }

  def insert(value: A, index: Int = 0): LinkedList[A] ={
    if (index == 0)
      append(value)
    else if (index <= length){
      var prevNode: Node = head.get
      val nodeToInsert: Node = new Node(value)
      for (_ <- 0 until index - 1) prevNode = prevNode.next.get
      nodeToInsert.next = prevNode.next
      prevNode.next = Some(nodeToInsert)
    }
    else {
      throw new RuntimeException("Index is bigger than length")
    }
    this
  }

  def deleteByIndex(index: Int = 0): Unit ={
    var prevNode: Node = head.get
    if (index == 0) head = prevNode.next
    else if (index <= length){
      for (_ <- 0 until index - 1) prevNode = prevNode.next.get
      prevNode.next = prevNode.next.get.next
    }
    else {
      throw new RuntimeException("Index is bigger than length")
    }
  }

  def deleteByValue(value: A): Unit ={
    val index = find(value)
    if (index != -1){
      deleteByIndex(index)
    }
    else {
      throw new RuntimeException("Value not found!")
    }
  }

  def find(valueToFind: A): Int = {
    if (head.isEmpty) -1
    else {
      var index = 0
      var currentNode: Option[Node] = head
      while (currentNode.isDefined){
        if (currentNode.get.value == valueToFind){
          return index
        }
        index += 1
        currentNode = currentNode.get.next
      }
      -1
    }
  }
  def length: Int = {
    if (head.isEmpty) 0
    else {
      var count = 1
      var currentNode: Node = head.get
      while (currentNode.hasNext){
        count += 1
        currentNode = currentNode.next.get
      }
      count
    }
  }
  def map(f: A => A): LinkedList[A] = {
    val list = new LinkedList[A]
    var currentNode = head.get
    while (currentNode.hasNext){
      list.insert(f(currentNode.value), list.length)
      currentNode = currentNode.next.get
    }
    list
  }

  def filter(f: A => Boolean): LinkedList[A] = {
    val list = new LinkedList[A]
    var currentNode = head.get
    while (currentNode.hasNext){
      if (f(currentNode.value)) list.insert(currentNode.value, list.length)
      currentNode = currentNode.next.get
    }
    list
  }

  def reduce(op: (A, A) => A): A = {
    var currentNode = head.get
    var res = currentNode.value
    while (currentNode.hasNext){
      currentNode = currentNode.next.get
      res = op(res, currentNode.value)
    }
    res
  }
  def show(): Unit = {
    if (head.isDefined) {
      var currentNode: Node = head.get
      print(currentNode.value)
      while (currentNode.hasNext){
        currentNode = currentNode.next.get
        print(s"=>${currentNode.value}")
      }
    }
    println()
  }
}
