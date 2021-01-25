package gatling.utils

import java.util.concurrent.ThreadLocalRandom

object RandomDate {
    def getRandomDate:String={
      import java.time.LocalDate
      val startDate = LocalDate.of(2019, 1, 1).toEpochDay
      val endDate = LocalDate.of(2020,1,1).toEpochDay
      val random = ThreadLocalRandom.current().longs(startDate,endDate).findAny().getAsLong()
      return LocalDate.ofEpochDay(random).toString
    }
}
