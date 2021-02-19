package gatling.simulations.actions

import gatling.simulations.http.UrlNames.articleUrl
import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._

object newsPage {

  val getRandomArticle: ChainBuilder = {
    exec(
      http("Get random News article")
        .get(articleUrl + "${RegNews}")
        .check(status.is(200))

    )
  }

  val getFirstArticle: ChainBuilder = {
    exec(
      http("Get first News article")
        .get(articleUrl + "${RegNewsFirst}")
        .check(status.is(200))
    ).pause(1)
  }

}
