package org.cdp.fackdb.client

import java.util.concurrent.TimeoutException

import org.scalatest.{FunSuite, Matchers}

import scala.concurrent.Await
import scala.concurrent.duration._
import scala.util.{Failure, Success, Try}

/**
  * 使用模拟fackdb客户端进行int类型的测试
  */
class FackDbClientIntSuite extends FunSuite with Matchers {

  val client = new FackDbClient("127.0.0.1:13888")

  test("fackdb client int test") {
    client.set("a", 1)
    val future = client.get("a")

    Try(Await.result(future, 5.seconds)) match {
      case Success(result) =>
        result should equal(1)
      case Failure(ex) if ex.isInstanceOf[TimeoutException] =>
        println("连接fackdb超时，请检查是否启动了fackdb")
    }
  }

}
