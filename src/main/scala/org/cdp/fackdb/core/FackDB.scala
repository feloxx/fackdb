package org.cdp.fackdb.core

import akka.actor.{Actor, Status}
import akka.event.Logging
import org.cdp.fackdb.entity.message.{GetRequest, KeyNotFoundException, SetRequest}
import scala.collection.mutable

/**
  * db 基础处理
  */
class FackDb extends Actor {

  val fackMap = new mutable.HashMap[String, Any]()

  val log = Logging(context.system, this)

  override def receive: Receive = {
    case SetRequest(k, v) =>
      log.info(s"received SetRequest - key: $k, value: $v")
      fackMap.put(k, v)
      sender() ! Status.Success
    case GetRequest(k) =>
      log.info(s"received GetRequest - key : $k")
      val response: Option[Any] = fackMap.get(k)
      response match {
        case Some(x) =>
          sender() ! x
        case None =>
          sender() ! Status.Failure(KeyNotFoundException(k))
      }
    case other@_ =>
      log.info(s"received unknown msg: $other")
      Status.Failure(new ClassNotFoundException)
  }

}
