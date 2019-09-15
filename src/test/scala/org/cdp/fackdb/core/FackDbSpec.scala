package org.cdp.fackdb.core

import akka.pattern.ask
import akka.actor.ActorSystem
import akka.testkit.TestActorRef
import org.cdp.fackdb.entity.message.{GetRequest, KeyIfNotExists, SetRequest}
import akka.util.Timeout
import org.scalatest.{FunSpecLike, Matchers}
import scala.concurrent.duration._
import scala.util.{Failure, Success}
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * db 基础处理 测试
  * 在当前测试用例中构建一个fackdb并直接向actor发送消息进行测试
  */
class FackDbSpec extends FunSpecLike with Matchers {

  implicit val system: ActorSystem = ActorSystem()

  implicit val timeout: Timeout = Timeout(5.seconds)

  describe("fackDb") {
    describe("Test SetRequest") {
      it("should place k/v into map") {
        val actorRef = TestActorRef(new FackDb)
        actorRef ! SetRequest("hello", "fack")

        val set = actorRef ? SetRequest("hello", "fack")
        set.onComplete {
          case Success(_) =>
            println("set is ok")
          case Failure(e) =>
            println(s"set is error: $e")
        }

        val get = actorRef ? GetRequest("hello")
        get.onComplete {
          case Success(ok) =>
            ok should equal("fack")
            println(s"get is ok")
          case Failure(e) =>
            println(s"get is error: $e")
        }

        val exists = actorRef ? KeyIfNotExists("hello")
        exists.onComplete {
          case Success(_) =>
            println("exists is ok")
          case Failure(e) =>
            println(s"exists is error: $e")
        }

        // TODO delete
      }
    }
  }

}
