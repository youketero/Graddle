package gatling.simulations.actions

import io.gatling.core.action.builder.ActionBuilder
import io.gatling.http.Predef._
import io.gatling.core.Predef._

object adminPage {

  val adminUrl = "/admin/"
  val informationBlockUrl = "information_block/"
  val articleUrl = "articles/"

  def getAdminPage:ActionBuilder={
    http("GET Admin")
      .get(adminUrl)
      .check(status.is(200))
  }

  def getAdminArticlePage:ActionBuilder={
    http("GET Admin")
      .get(adminUrl + informationBlockUrl + articleUrl)
      .check(status.is(200))
  }


  def getEachArticleAdd:ActionBuilder={
    http("POST Article")
      .get(adminUrl + informationBlockUrl + articleUrl + "add/").check(css("input[name='csrfmiddlewaretoken']", "value").saveAs("token_1"))
  }

  def postAdminArticlePage:ActionBuilder={
    http("POST Article")
      .post(adminUrl + informationBlockUrl + articleUrl + "add/")
      .formParam("csrfmiddlewaretoken", "${CSRFF1}")
      .formParam("header_image", "2")
      .formParam("title","${Title}")
      .formParam("text", "${TextPart}")
      .formParam("date", "${Date}")
      .formParam("link_facebook", "Enter link here")
      .formParam("link_telegram", "Enter link here")
      .formParam("link_twitter", "Enter link here")
      .formParam("user_id", "1")
      .formParam("_save", "Save")
  }
}
