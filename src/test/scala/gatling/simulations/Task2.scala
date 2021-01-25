package gatling.simulations

import gatling.common.SimulationFacade
import gatling.utils
import gatling.utils.RandomDate.getRandomDate
import gatling.utils.RandomTitle.getRandomTitle
import gatling.utils.ReadTextFile.{getText, getTextPart}
import io.gatling.core.Predef._


class Task2 extends SimulationFacade{
  val httpConf = gatling.utils.http.HttpConf.httpConf

  val scn = scenario("Task2")
    .repeat(requests) {
      exec(actions.homePage.homePageGet)
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
        .exec(_.set("Title", getRandomTitle ))
        .exec(_.set("Date", getRandomDate ))
        .exec(_.set("TextPart", getTextPart(getText(utils.TestData.LOREM_IPSUM))))
        .exec(actions.adminPage.postAdminArticlePage)
    }
  setUp(scn.inject(rampUsers(users) during 5).protocols(httpConf))
}
