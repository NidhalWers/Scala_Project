package service

import models.Runway

import scala.collection.immutable

class RunwayService {

  def convertFileToRunways(file : String): Iterator[Runway] = {
    scala.io.Source.fromFile(file, "utf-8").getLines().drop(1) map( l => Runway(l))
  }

  /**
   * create a hashmap with the name of airport in key and the List of runways in value
   * @param airports : list of (ident, name)
   * @param runways
   * @return
   */
  def getRunwaysInAirport(airports: List[ (String,String) ], runways: Iterator[Runway]): Map[String, List[Runway]] = {
    def aux(airports: List[ (String,String) ], runways: Iterator[Runway], acc: Map[String, List[Runway]] ): Map[String, List[Runway]] = airports match{
      case Nil => acc
      case ( ident, name ) :: xs =>
        val choosedRunways = runways.filter( r => r.airportIdent match {
          case None => false
          case Some(value) => value.equals(ident)
        }).toList

        aux(xs, runways, acc + ( name -> choosedRunways ) )

    }
    aux(airports, runways, Map[String, List[Runway]]())
  }

}
