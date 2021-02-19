package gatling.simulations.loadProfiles

import gatling.SimulationFacade
import io.gatling.core.Predef._
import io.gatling.core.controller.inject.closed.ClosedInjectionStep



object loadProfiles extends SimulationFacade{
   val loadTest: ClosedInjectionStep = constantConcurrentUsers(users).during(durationT);
}
