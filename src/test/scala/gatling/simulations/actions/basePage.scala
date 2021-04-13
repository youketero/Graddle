package gatling.simulations.actions

import gatling.simulations.http.UrlNames._
import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._

import java.util.concurrent.TimeUnit

object basePage{

  val getContactPage: ChainBuilder = {
    exec(
      http("GET Contact Page")
        .get(contactUrl)
        .check(status.is(200))
    ).pause("1000","3000", TimeUnit.MILLISECONDS)
  }

  val getHomePage: ChainBuilder = {
    exec(
      http("GET Home")
        .get("")
        .check(status.is(200))
    )
  }

  val getAdminPage:ChainBuilder={
    exec(
    http("GET Admin Page")
      .get(adminUrl)
      .check(status.is(200))
    )
  }

  val getVstupPage: ChainBuilder = {
    exec(
      http("GET Entrance Page")
        .get(vstupUrl)
        .check(status.is(200))
    )
  }

  val getStructurePage: ChainBuilder = {
    exec(
      http("GET Structure Page")
        .get(structureUrl)
        .check(status.is(200))
    )
  }

  val getBlogPage: ChainBuilder = {
    exec(
      http("GET Blog page")
        .get(newsUrl)
        .check(status.is(200))
    )
  }

  val getInfoPage: ChainBuilder ={
    exec(
      http("GET Info page")
        .get(infoUrl)
        .check(status.is(200))
    )
  }
}
