package gatling.utils.extractors

import io.gatling.core.Predef._
import io.gatling.core.check.CheckBuilder
import io.gatling.core.check.regex.RegexCheckType

object Extractors {

    val extractRandomNews: CheckBuilder[RegexCheckType, String, String] = regex("\"\\/article\\/(.*)\"\\s.*\"en\">").findRandom.saveAs("RegNews")
    val extractFirstNews: CheckBuilder[RegexCheckType, String, String] = regex("\"\\/article\\/(.*)\"\\s.*\"en\">").saveAs("RegNewsFirst")
    val extractRandomInfo: CheckBuilder[RegexCheckType, String, String] = regex("\"\\/info_for_students_detailed\\/(.*)\"\\s.*\"en\">").findRandom.saveAs("RegInfo")
    val extractFirstInfo: CheckBuilder[RegexCheckType, String, String] = regex("\"\\/info_for_students_detailed\\/(.*)\"\\s.*\"en\">").saveAs("RegInfoFirst")
    val extractRandomPage: CheckBuilder[RegexCheckType, String, String] = regex("<a href=\"\\?page=(\\w)\">").findRandom.saveAs("RandomNewsPage")
}
