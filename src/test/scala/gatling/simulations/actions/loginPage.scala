package gatling.simulations.actions

import io.gatling.core.Predef._
import io.gatling.core.action.builder.ActionBuilder
import io.gatling.http.Predef._


object loginPage {
    val accountUrl:String = "/accounts"
    val loginUrl:String = "/login/"

    def getLoginPage:ActionBuilder={
        http("GET login")
          .get(loginUrl)
          .check(status.is(200)).check(css("input[name='csrfmiddlewaretoken']", "value").saveAs("token"))
    }

    def postLoginPage:ActionBuilder={
        http("POST login")
          .post(accountUrl + loginUrl).formParam("csrfmiddlewaretoken", "${CSRFF}")
          .formParam("username", "youkio")
          .formParam("password", "718397")
    }
}
