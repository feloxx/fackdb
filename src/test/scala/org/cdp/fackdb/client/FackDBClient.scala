package org.cdp.fackdb.client

import akka.actor.{ActorSelection, ActorSystem}
import akka.pattern.ask
import akka.util.Timeout
import com.typesafe.config.{Config, ConfigFactory}
import org.cdp.fackdb.message.{GetRequest, SetRequest}
import scala.concurrent.Future
import scala.concurrent.duration._

/**
  * 测试前需要启动一个fackdb
  * 模拟fackdb远程客户端
  * 需要注意的是，要准备一个配置文件，为了简便直接将配置内容都写在一个字符串中
  *
  * @param remoteAddress fackdb远程地址:端口
  */
class FackDbClient(remoteAddress: String) {

  implicit val timeout: Timeout = Timeout(10.seconds)

  // 加载字符串形式的配置文件
  val config: Config = ConfigFactory.parseString(
    """
      |akka {
      |  actor {
      |    provider = "akka.remote.RemoteActorRefProvider"
      |  }
      |}
    """.stripMargin)

  // 创建actorSystem时，并使用字符串的配置文件
  implicit val system: ActorSystem = ActorSystem.create("LocalSystem", config)

  val remoteFackDb: ActorSelection = system.actorSelection(s"akka.tcp://fackSystem@$remoteAddress/user/fackDb")

  def set(k: String, v: Any): Future[Any] = {
    remoteFackDb ? SetRequest(k, v)
  }

  def get(k: String): Future[Any] = {
    remoteFackDb ? GetRequest(k)
  }

}
