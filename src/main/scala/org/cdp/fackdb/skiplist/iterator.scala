package org.cdp.fackdb.skiplist

class Iterator {
  def valid(n: Node): Boolean = n != null

  def key(n: Node): Any = n.k

  def next(n: Node): Node = n.getNext(0)

  def prev(n: Node) = ???

  def seek = ???

  def head= ???

  def last = ???
}
