package org.cdp.fackdb.core

import akka.actor.ActorSystem
import akka.testkit.TestActorRef
import org.cdp.fackdb.entity.message.SetRequest
import org.scalatest.concurrent.PatienceConfiguration.Timeout
import org.scalatest.{FunSpecLike, Matchers}

import scala.concurrent.duration._

class FackDbSpec extends FunSpecLike with Matchers {

  implicit val system: ActorSystem = ActorSystem()

  implicit val timeout: Timeout = Timeout(5.seconds)

  describe("fackDb") {
    describe("given SetRequest") {
      it("should place k/v into map") {
        val actorRef = TestActorRef(new FackDb)
        actorRef ! SetRequest("hello", "fack")

        val fackDb = actorRef.underlyingActor
        println("cdp: "+fackDb.map.get("hello"))
        fackDb.map.get("hello").should(equal(Some("fack")))
      }
    }
  }

}
