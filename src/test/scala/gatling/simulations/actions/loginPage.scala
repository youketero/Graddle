package gatling.simulations.actions

import gatling.simulations.http.UrlNames.{accountUrl, loginUrl}
import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._


object loginPage {

  val getLoginPage: ChainBuilder = {
    exec(
      http("GET login")
        .get(loginUrl)
        .check(status.is(200))
        .check(css("input[name='csrfmiddlewaretoken']", "value")
          .saveAs("token"))
    )
  }

  val postLoginPage: ChainBuilder = {
    exec(
      http("POST login")
        .post(accountUrl + loginUrl).formParam("csrfmiddlewaretoken", "${CSRFF}")
        .formParam("username", "youkio")
        .formParam("password", "718397")
    )
  }
}
