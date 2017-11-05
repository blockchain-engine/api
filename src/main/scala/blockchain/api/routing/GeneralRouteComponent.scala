package blockchain.api.routing

import akka.http.scaladsl.server.Route

trait GeneralRouteComponent {
  def generalRoute: GeneralRoute

  trait GeneralRoute {
    def route: Route
  }
}

trait DefaultGeneralRouteComponent extends GeneralRouteComponent {
  this: UserRouteComponent =>

  class DefaultGeneralRoute extends GeneralRoute {
    override val route: Route = userRoute.route
  }
}
