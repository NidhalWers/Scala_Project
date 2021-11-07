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


  def getTypeOfRunwaysPerCountry(airports : List[Airport], runways: List[Runway]): Map[ String,Set[String] ] = {
    def aux(airports : List[Airport], runways: List[Runway], acc: Map[ String,Set[String] ] ): Map[ String,Set[String] ] = runways match {
      case Nil => acc
      case x :: xs => {
        x.surface match{
          case None => aux(airports, xs, acc)
          case Some(_) => {
            val airportOfRunway = airports.find(a => a.ident.equals(x.airportIdent))
            airportOfRunway match {
              case None => aux(airports, xs, acc)
              case Some(value) => {
                val key = value.isoCountry.get
                if (acc.contains(key)) {
                  val setOfCountry = acc(key)
                  val acc2 = acc.-(key)
                  aux(airports, xs, acc2 + (key -> (setOfCountry + x.surface.get )))
                } else {
                  aux(airports, xs, acc + (key -> (Set() + x.surface.get )))
                }
              }
            }
          }
        }
      }
    }


    aux(airports, runways, Map[String,Set[String]]())
  }

  def getTenMostCommonRunwaysLatitude(runways: List[Runway]): List[Float] = {
    null
  }
}
