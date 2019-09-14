package org.cdp.fackdb.core

import akka.actor.Actor
import akka.event.Logging
import org.cdp.fackdb.entity.message.SetRequest

import scala.collection.mutable

class FackDb extends Actor {

  val map = new mutable.HashMap[String, Any]()

  val log = Logging(context.system, this)

  override def receive: Receive = {
    case SetRequest(k, v) =>
      log.info(s"received SetRequest - key: $k, value: $v")
      map.put(k, v)
    case other @_ =>
      log.info(s"received unknown msg: $other")
  }

}
