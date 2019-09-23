package org.cdp.fackdb.skiplist

class Node(key: Any, height: Int) {
  var k: Any = key
  var next: List[Node] = _

  def getNext(level: Int): Node = next(level)

  def setNext(level: Int, x: Node): Unit = next(level) = x
}
