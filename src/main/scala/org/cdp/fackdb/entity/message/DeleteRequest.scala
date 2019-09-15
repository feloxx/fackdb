package org.cdp.fackdb.entity.message

/**
  * 原子删除一个key
  *
  * @param key 需要删除的k
  */
case class DeleteRequest(key: String)
