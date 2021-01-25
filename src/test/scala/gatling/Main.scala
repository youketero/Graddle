package gatling

import gatling.simulations.Task2
import io.gatling.app.Gatling
import io.gatling.core.config.GatlingPropertiesBuilder

object Main {
  def main(args: Array[String]): Unit = {
    val simClass = classOf[Task2].getName
    val props = new GatlingPropertiesBuilder
    props.simulationClass(simClass)
    Gatling.fromMap(props.build)

  }
}
