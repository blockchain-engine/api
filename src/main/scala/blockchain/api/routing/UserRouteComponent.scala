package blockchain.api.routing

import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.Directives._

trait UserRouteComponent {
  def userRoute: UserRoute

  trait UserRoute {
    def route: Route
  }
}

trait DefaultUserRouteComponent extends UserRouteComponent {

  class DefaultUserRoute extends UserRoute {
    override val route: Route =
      pathPrefix("user") {
        get {
          complete("Mocked User")
        }
      }
  }
}
