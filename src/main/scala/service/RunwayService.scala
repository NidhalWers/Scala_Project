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
  def getRunwaysInAirport(airports: List[ (Option[String],Option[String])], runways: Iterator[Runway]): Map[Option[String], List[Product]] = {
    //println(runways.toList)
    def aux(airports: List[ (Option[String],Option[String]) ], runways: Iterator[Runway], acc: Map[Option[String], List[Product]] ): Map[Option[String], List[Product]] = airports match{
      case Nil => acc
      case ( ident, name ) :: xs =>
        //println("ident : " + ident)
        val choosedRunways = runways.filter( r => r.airportIdent match {
          case None => false
          case value => value.equals(ident)
        }).map(r => r.id).toList
        aux(xs, runways, acc + ( name -> choosedRunways ) )

    }
    aux(airports, runways, Map[Option[String], List[Runway]]())
  }

}
