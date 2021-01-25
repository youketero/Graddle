package gatling.utils

object RandomTitle {
    def getRandomTitle:String={
      val r = scala.util.Random
      return "Title" + r.nextInt(100) + r.nextInt(1000)
    }
}
