package org.cdp.fackdb.entity.message

/**
  * kv中 插入数据
  *
  * @param key   数据的k
  * @param value 数据的v
  */
case class SetRequest(key: String, value: Any)
