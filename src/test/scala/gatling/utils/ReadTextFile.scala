package gatling.utils

import scala.io.Source

object ReadTextFile {
    def getText(dataFile:String):String={
      val filename = Source.fromResource(dataFile).getLines()
      return filename.take(1).mkString("")
    }

    def getTextPart(textFragment:String):String={
      val r = scala.util.Random
      return  textFragment.substring(r.nextInt(100),50 + r.nextInt(400))
    }

}
