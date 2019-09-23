package org.cdp.fackdb.message

/**
  * 原子判断k如果不存在
  *
  * @param key 传入的k
  */
case class KeyIfNotExists(key: String)
