package gatling.simulations

import gatling.SimulationFacade
import gatling.simulations.http.HttpConf.httpConf
import gatling.simulations.loadProfiles.loadProfiles._
import gatling.simulations.scenarios.Task1Scenario.scenarioTask1
import gatling.simulations.scenarios.Task3Scenario.scenarioTask3
import io.gatling.core.Predef._
import io.gatling.core.controller.inject.closed.ClosedInjectionStep
import io.gatling.core.structure.ScenarioBuilder

class SimulationConstructor extends SimulationFacade {

  val scenarioNames:Map[String,ScenarioBuilder] = Map("Task3" -> scenarioTask3, "Task1" -> scenarioTask1)
  val loadProfiles:Map[String,ClosedInjectionStep] = Map("Load test" -> loadTest)

  setUp(
    scenarioNames(scenarioName).inject(loadTest).protocols(httpConf)
   )

}

