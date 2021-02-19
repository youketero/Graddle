package gatling.simulations.actions

import gatling.simulations.http.UrlNames.{adminUrl, articlesUrl, informationBlockUrl}

import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._

object adminPage {

  def getAdminPage: ChainBuilder = {
    exec(
      http("GET Admin")
        .get(adminUrl)
        .check(status.is(200))
    )
  }

  def getAdminArticlePage: ChainBuilder = {
    exec(
      http("GET Admin article page")
        .get(adminUrl + informationBlockUrl + articlesUrl)
        .check(status.is(200)))
  }


  def getEachArticleAdd: ChainBuilder = {
    exec(
      http("POST Article")
        .get(adminUrl + informationBlockUrl + articlesUrl + "add/")
        .check(css("input[name='csrfmiddlewaretoken']", "value")
          .saveAs("token_1")))
  }

  def postAdminArticlePage: ChainBuilder = {
    exec(
    http("POST Article")
      .post(adminUrl + informationBlockUrl + articlesUrl + "add/")
      .formParam("csrfmiddlewaretoken", "${CSRFF1}")
      .formParam("header_image", "2")
      .formParam("title", "${Title}")
      .formParam("text", "${TextPart}")
      .formParam("date", "${Date}")
      .formParam("link_facebook", "Enter link here")
      .formParam("link_telegram", "Enter link here")
      .formParam("link_twitter", "Enter link here")
      .formParam("user_id", "1")
      .formParam("_save", "Save"))
  }

}
