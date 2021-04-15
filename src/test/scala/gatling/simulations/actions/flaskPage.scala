package gatling.simulations.actions

import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._

object flaskPage {
  val getHome:ChainBuilder = {
    exec(
      http("Get Home Page")
        .get("/")
        .check(status.is(200))
    )
  }
}
