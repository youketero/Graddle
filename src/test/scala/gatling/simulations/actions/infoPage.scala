package gatling.simulations.actions

import gatling.simulations.http.UrlNames.infoDetailedUrl
import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._

object infoPage {

  val getRandomInfoPage: ChainBuilder = {
    exec(
      http("Get random Info page")
        .get(infoDetailedUrl + "${RegInfo}")
        .check(status.is(200))
    )
  }

  val getFirstInfoPage: ChainBuilder = {
    exec(
      http("Get random Info page")
        .get(infoDetailedUrl + "${RegInfoFirst}")
        .check(status.is(200))
    )
  }

}
