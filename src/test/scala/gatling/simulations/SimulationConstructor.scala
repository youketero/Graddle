package gatling.simulations

import gatling.simulations.common.SimulationFacade
import gatling.simulations.http.HttpConf
import gatling.simulations.http.HttpConf.httpConfGeology
import gatling.simulations.http.HttpConfFlask.httpConfFlask
import gatling.simulations.loadProfiles.loadProfiles._
import gatling.simulations.scenarios.Task1Scenario.scenarioTask1
import gatling.simulations.scenarios.Task3Scenario.scenarioTask3
import gatling.simulations.scenarios.flaskScenario.flask
import io.gatling.core.Predef._
import io.gatling.core.controller.inject.closed.ClosedInjectionStep
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.protocol.HttpProtocolBuilder

class SimulationConstructor extends SimulationFacade {

  val scenarioNames:Map[String,ScenarioBuilder] = Map("Task3" -> scenarioTask3, "Task1" -> scenarioTask1, "Flask" -> flask)
  val loadProfiles:Map[String,ClosedInjectionStep] = Map("Load" -> loadTest, "Capacity" -> capacityClosedModel)
  val httpConf:Map[String,HttpProtocolBuilder] = Map("Geology" -> httpConfGeology, "Flask" -> httpConfFlask)


  setUp(
    scenarioNames(scenarioName).inject(loadProfiles(loadProfile)).protocols(httpConf(http))
   )

}

