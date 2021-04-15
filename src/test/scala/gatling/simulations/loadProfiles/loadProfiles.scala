package gatling.simulations.loadProfiles

import gatling.simulations.common.SimulationFacade
import gatling.simulations.scenarios.Task1Scenario.durationT
import io.gatling.core.Predef._
import io.gatling.core.controller.inject.closed.ClosedInjectionStep

import scala.concurrent.duration.DurationInt



object loadProfiles extends SimulationFacade{
   val loadTest: ClosedInjectionStep = constantConcurrentUsers(users).during(durationT);
   val capacityClosedModel: ClosedInjectionStep = rampConcurrentUsers(users).to(30).during(durationT)
}
