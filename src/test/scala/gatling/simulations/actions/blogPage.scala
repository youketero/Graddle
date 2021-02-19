package gatling.simulations.actions

import gatling.utils.Timers.constantTimer
import gatling.utils.extractors.Extractors.{extractFirstNews, extractRandomNews}
import gatling.simulations.http.UrlNames.{articlesUrl, newsUrl}
import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._

object blogPage {
  val getFirstBlogPage: ChainBuilder = {
    exec(
      http("Get first News page")
        .get(newsUrl + "?page=1")
        .check(status.is(200))
        .check(extractRandomNews)
        .check(extractFirstNews)
    ).pause(constantTimer)
  }

  val getRandomBlogPage: ChainBuilder = {
    exec(
      http("Get random News page")
        .get(articlesUrl + "?page=${RandomNewsPage}")
        .check(status.is(200))
        .check(extractRandomNews)
        .check(extractFirstNews)
    )
  }
}
