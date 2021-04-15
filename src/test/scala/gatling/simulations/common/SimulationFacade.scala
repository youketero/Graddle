package gatling.simulations.common

import gatling.utils.PropertyNames._
import io.gatling.core.Predef._
import scala.concurrent.duration._

class SimulationFacade extends Simulation{

  private val durationTime:Int= Integer.parseInt(System.getProperty(DURATION, "5"))
  private val durationUnit:String = System.getProperty(DURATION_UNIT,"seconds")
  val requests:Int = Integer.parseInt(System.getProperty(REQUESTS,"10"))
  protected val users:Int = Integer.parseInt(System.getProperty(USERS,"5"))
  protected val durationT:FiniteDuration = FiniteDuration.apply(durationTime, durationUnit)
  protected val scenarioName: String = System.getProperty(SCENARIO,"Task1")
  protected val loadProfile:String = System.getProperty(LOAD_PROFILE,"Load")
  protected val http:String = System.getProperty(HTTPCONF,"Flask")

}
