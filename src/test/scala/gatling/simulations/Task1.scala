package gatling.simulations

import gatling.common.SimulationFacade
import io.gatling.core.Predef._
import gatling.utils.http.HttpConf.httpConf

class Task1 extends SimulationFacade {

  val scn = scenario("Task1")
    .repeat(requests) {
      exec(actions.homePage.homePageGet)
      exec(actions.contactPage.contactPageGet)
    }

  setUp(scn.inject(rampUsers(users) during 5).protocols(httpConf))
}
