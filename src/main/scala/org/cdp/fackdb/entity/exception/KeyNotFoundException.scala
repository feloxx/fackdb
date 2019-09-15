package org.cdp.fackdb.entity.exception

/**
  * 自定义错误逻辑，k不存在异常
  *
  * @param key 传进来的查询条件
  */
case class KeyNotFoundException(key: String) extends Exception
