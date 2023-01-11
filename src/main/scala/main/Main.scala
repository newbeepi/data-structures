package main

import collections.{LinkedList, Queue, Stack, ImmutableLinkedList}

object Main {

  def main(args: Array[String]): Unit = {
/*  testStack()
    testQueue()
    testLinkedList()
    testImmutableLinkedList()
  }
  def testImmutableLinkedList(): Unit = {
    val list = new ImmutableLinkedList[Int](1, 2, 3, 4, 5)
    list.show()
    list.map(_ * 2).filter(_ > 5).show()
  }
  def testLinkedList(): Unit = {
    val list: LinkedList[Int] = new LinkedList
    list.append(1).append(2).append(4)
    // println(list.length)
    // list.show()
    println(list.find(1))
    list.insert(5)
    list.insert(6)
   // list.show()
    list.insert(3, 3)
    list.show()
    val res = list.map(x => x * 2).filter(x => x > 2).reduce((x, y) => x - y)
    println(res)
  }
  def testQueue(): Unit = {
    val queue: Queue[Int] = new Queue
    queue.enqueue(2)
      .enqueue(3)
      .enqueue(4)
      .enqueue(5)

    queue.show()
    queue.deque
    queue.show()
    queue.deque
    queue.show()
  }
  def testStack(): Unit = {
    val stack: Stack[Int] = new Stack
    stack.push(1).push(2).push(3)
    stack.show()
  }
}
