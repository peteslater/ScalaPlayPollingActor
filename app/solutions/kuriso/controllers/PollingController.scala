package solutions.kuriso.controllers

import akka.actor.ActorSystem
import javax.inject._
import play.api.mvc._
import solutions.kuriso.actors.PollingActor

@Singleton
class PollingController @Inject()(system: ActorSystem, cc: ControllerComponents) extends AbstractController(cc) {
  val pollingActor = system.actorOf(PollingActor.props, "polling-actor")
  pollingActor ! PollingActor.Poll

  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(solutions.kuriso.views.html.index())
  }
}
