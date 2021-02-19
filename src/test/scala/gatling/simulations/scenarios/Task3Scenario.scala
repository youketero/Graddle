package gatling.simulations.scenarios

import gatling.simulations.actions.{basePage, infoPage, newsPage, structurePage}
import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder

object Task3Scenario{

  val scenarioTask3: ScenarioBuilder = scenario("Task3")
      .randomSwitch(
        100.0 -> exec(basePage.getHomePage, randomSwitch(
          33.33 -> exec(basePage.getBlogPage).randomSwitch(
            50.0 -> exec(newsPage.getRandomArticle),
            50.0 -> exec(newsPage.getFirstArticle)),
          33.33 -> exec(basePage.getStructurePage, randomSwitch(
            50.0 -> structurePage.getRandomCathed,
            50.0 -> structurePage.getFirstCathed
          )),
          16.66 -> exec(basePage.getInfoPage).randomSwitch(
            50.0 -> exec(infoPage.getFirstInfoPage),
            50.0 -> exec(infoPage.getRandomInfoPage)),
          16.66 -> exec(basePage.getContactPage)
        ))
      )
}
