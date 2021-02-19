package gatling.simulations.scenarios

import gatling.simulations.actions
import gatling.simulations.actions.basePage
import gatling.{SimulationFacade, utils}
import gatling.utils.RandomDate.getRandomDate
import gatling.utils.RandomTitle.getRandomTitle
import gatling.utils.ReadTextFile.{getText, getTextPart}
import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder

object Task2Scenario extends SimulationFacade{
  val scenarioTask2: ScenarioBuilder = scenario("Task2")
    .repeat(requests) {
      basePage.getHomePage
        .exec(actions.loginPage.getLoginPage)
        .exec {
          session =>
            session.set("CSRFF", session("token").as[String])
        }
        .exec(actions.loginPage.postLoginPage)
        .exec(actions.adminPage.getAdminPage)
        .exec(actions.adminPage.getAdminArticlePage)
        .exec(actions.adminPage.getEachArticleAdd)
        .exec {
          session =>
            session.set("CSRFF1", session("token_1").as[String])

        }
        .exec(_.set("Title", getRandomTitle))
        .exec(_.set("Date", getRandomDate))
        .exec(_.set("TextPart", getTextPart(getText(utils.TestData.LOREM_IPSUM))))
        .exec(actions.adminPage.postAdminArticlePage)
    }
}
