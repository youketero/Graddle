package gatling.simulations.actions

import gatling.simulations.http.UrlNames.structureUrl
import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._

object structurePage {

  val getRandomCathed: ChainBuilder = {
    exec(
      http("GET Random Cathed")
        .get(structureUrl + "${CathedRandom}")
    )
  }

  val getFirstCathed: ChainBuilder = {
    exec(
      http("GET First Cathed")
        .get(structureUrl + "${CathedFirst}")
    )
  }

}
