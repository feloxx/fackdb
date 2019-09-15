package org.cdp.fackdb.entity.message

/**
  * kv中 使用key来查询
  *
  * @param key 查询条件
  */
case class GetRequest(key: String)
