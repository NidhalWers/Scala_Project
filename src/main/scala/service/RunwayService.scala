package service

import models.Runway

import scala.collection.immutable

class RunwayService {

  def convertFileToRunways(file : String): Iterator[Runway] = {
    scala.io.Source.fromFile(file, "utf-8").getLines().drop(1) map( l => Runway(l))
  }

  /**
   * create a hmap with the name of airport in key and the List of runways in value
   * @param airports : list of (ident, name)
   * @param runways
   * @return
   */
  def getRunwaysInAirportList(airports: List[ (Option[String],Option[String])], runways: List[Runway]): Map[Option[String], List[String]] = {
    def aux(airports: List[ (Option[String],Option[String]) ], runways: List[Runway], acc: Map[Option[String], List[String]] ): Map[Option[String], List[String]] = airports match{
      case Nil => acc
      case ( ident, name ) :: xs =>
        aux(xs, runways, acc + ( name -> getRunwaysInAirport(ident, runways) ) )
    }
    aux(airports, runways, Map[Option[String], List[String]]())
  }

  private def getRunwaysInAirport(airportIdent: Option[String], runways: List[Runway] ) : List[String] = {
    runways.filter( r => r.airportIdent match {
      case None => false
      case Some(value) => value.equals(airportIdent.get)
    }).map(r => "id = " + r.id.get)
  }

}
