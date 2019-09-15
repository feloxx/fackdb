package org.cdp.fackdb

import akka.actor.{ActorSystem, Props}
import com.typesafe.config.ConfigFactory
import org.cdp.fackdb.core.FackDb

/**
  * mian函数，程序入口
  */
object LetsGo {

  def main(args: Array[String]): Unit = {

    println(
      """
        |███████╗ █████╗  ██████╗██╗  ██╗██████╗ ██████╗
        |██╔════╝██╔══██╗██╔════╝██║ ██╔╝██╔══██╗██╔══██╗
        |█████╗  ███████║██║     █████╔╝ ██║  ██║██████╔╝
        |██╔══╝  ██╔══██║██║     ██╔═██╗ ██║  ██║██╔══██╗
        |██║     ██║  ██║╚██████╗██║  ██╗██████╔╝██████╔╝
        |╚═╝     ╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝╚═════╝ ╚═════╝
        |┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄
        |                                         v1.0.0
      """.stripMargin)

    val system = ActorSystem.create("fackSystem", ConfigFactory.load("application.conf"))
    val fuckDbActor = system.actorOf(Props[FackDb], name = "fackDb")

  }

}
