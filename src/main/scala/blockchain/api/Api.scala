package blockchain.api

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import blockchain.api.routing.{DefaultGeneralRouteComponent, DefaultUserRouteComponent}


object Api
  extends App
    with DefaultGeneralRouteComponent
    with DefaultUserRouteComponent {

  override lazy val generalRoute: GeneralRoute = new DefaultGeneralRoute
  override lazy val userRoute: UserRoute = new DefaultUserRoute

  private implicit val system = ActorSystem("api")
  private implicit val materializer = ActorMaterializer()
  private implicit val executionContext = system.dispatcher

  private val interface = "localhost"
  private val port = 8080

  val bindingFuture = Http().bindAndHandle(generalRoute.route, interface, port)
}
