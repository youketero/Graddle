package gatling.simulations.scenarios

import gatling.simulations.actions.basePage
import gatling.simulations.common.SimulationFacade
import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder

object Task1Scenario extends SimulationFacade{
  val scenarioTask1: ScenarioBuilder  = scenario("Task1")
    .repeat(requests) {
      exec(basePage.getHomePage)
        .exec(basePage.getContactPage)
    }
}
