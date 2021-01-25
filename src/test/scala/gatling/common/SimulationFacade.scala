package gatling.common

import gatling.utils.PropertyNames.{DURATION, REQUESTS, USERS}
import io.gatling.core.Predef._

import scala.concurrent.duration.FiniteDuration

class SimulationFacade extends Simulation{

  //protected def userPause = FiniteDuration.apply(Random.nextInt(3), SECONDS)
  private val duration:Long= Integer.parseInt(System.getProperty(DURATION, "5"))
  protected val requests:Int = Integer.parseInt(System.getProperty(REQUESTS,"10"))
  protected val users:Int = Integer.parseInt(System.getProperty(USERS,"5"))
  private val durationMin:String = "seconds"
  protected val durationParam:FiniteDuration = FiniteDuration.apply(duration,durationMin)
  private val rampToTotalRatio = Integer.parseInt("50")

}
