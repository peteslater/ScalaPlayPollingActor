package solutions.kuriso.actors


import solutions.kuriso.actors.PollingActor.Poll
import akka.actor.{Actor, Props}

import scala.concurrent.duration._
import scala.language.postfixOps
import scala.concurrent.ExecutionContext.Implicits.global

object PollingActor {
  def props = Props[PollingActor]

  case object Poll
}

class PollingActor extends Actor {
  override def receive: Receive = {
    case Poll =>
      poll
      context.system.scheduler.scheduleOnce(5 seconds, self, Poll)
  }

  def poll = println("***** POLLING *****")
}
