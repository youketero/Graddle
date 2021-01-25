package gatling.simulations.actions

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.core.action.builder.ActionBuilder
import io.gatling.http.Predef.{http, status}

object contactPage {
  def contactPageGet: ActionBuilder = {
    http("GET Contact")
      .get("/contact/")
      .check(status.is(200))
  }
}
