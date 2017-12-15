package controllers

import javax.inject._
import play.api._
import play.api.mvc._

@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  private lazy val logger = Logger(this.getClass)

  def index() = Action { implicit request: Request[AnyContent] =>
    println("This is a println message")
    logger.debug("This is a DEBUG message")
    logger.info("This is an INFO message")
    logger.warn("This is a WARN message")
    logger.error("This is an ERROR message")

    Ok(views.html.index())
  }

  def upload = Action(parse.multipartFormData) { request =>
    Ok("upload done")
  }
}
