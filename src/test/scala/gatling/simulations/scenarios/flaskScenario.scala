package gatling.simulations.scenarios

import gatling.simulations.actions.flaskPage
import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder

object flaskScenario {

  val flask: ScenarioBuilder = scenario("FlaskScenario")
    .exec(flaskPage.getHome).pause(5)

}
