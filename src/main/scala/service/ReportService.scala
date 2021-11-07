package service

import models.{Airport, Runway}

import scala.collection.immutable.ListMap

class ReportService {

  def getTenCountriesHighestNumberOfAirports(airports : List[Airport]): Map[String, Int] = {
    val mapOfNumber = createMapOfNumberAirports(airports)

    ListMap(mapOfNumber.toSeq.sortWith(_._2 > _._2):_*).take(10)
  }



  def getTenCountriesLowestNumberOfAirports(airports : List[Airport]): Map[String, Int] = {
    val mapOfNumber = createMapOfNumberAirports(airports)

    ListMap(mapOfNumber.toSeq.sortWith(_._2 < _._2):_*).take(10)
  }


  private def createMapOfNumberAirports(airports : List[Airport]): Map[String, Int] = {
    def aux(airports : List[Airport], acc: Map[String, Int] ): Map[String, Int] = airports match {
      case Nil => acc
      case x :: xs =>
        val key = x.isoCountry.get
        if(acc.contains(key)){
          val nb = acc(key)
          val acc2 = acc.-(key)
          aux( xs, acc2 + (key -> (nb+1)) )
        }else{
          aux( xs, acc + (key -> (1)) )
        }
    }

    aux(airports, Map[String,Int]())

  }


  def getTypeOfRunwaysPerCountry(airports : List[Airport], runways: List[Runway]): Map[ String,List[String] ] = {
    null
  }

  def getTenMostCommonRunwaysLatitude(runways: List[Runway]): List[Float] = {
    null
  }
}
