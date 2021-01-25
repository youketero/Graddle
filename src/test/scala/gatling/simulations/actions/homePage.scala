package gatling.simulations.actions

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.core.action.builder.ActionBuilder
import io.gatling.http.Predef.{http, status}

object homePage {
    def homePageGet:ActionBuilder={
      http("GET Home")
        .get("")
        .check(status.is(200))
    }
}
