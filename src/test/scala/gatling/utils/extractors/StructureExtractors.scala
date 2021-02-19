package gatling.utils.extractors

import io.gatling.core.Predef._
import io.gatling.core.check.CheckBuilder
import io.gatling.core.check.regex.RegexCheckType

object StructureExtractors {
  val extractRandomCathed: CheckBuilder[RegexCheckType, String, String] = regex("<a href=\"\\/structure\\/(.*)\\/\">").findRandom.saveAs("CathedRandom")
  val extractFirstCathed: CheckBuilder[RegexCheckType, String, String] = regex("<a href=\"\\/structure\\/(.*)\\/\">").saveAs("CathedFirst")
}
