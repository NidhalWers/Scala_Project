package service

import models.Airport

class AirportService {

  def convertFileToAirports(file : String): Iterator[Airport] = {
    scala.io.Source.fromFile(file, "utf-8").getLines().drop(1) map( l => Airport(l))
  }

  def getAirportsInCountry(countryCode: String, airports: Iterator[Airport]) : List[Airport] = {
    //println(airports.toList )
    airports.filter( a => a.isoCountry match{
      case None => false
      case Some(value) => value.equals(countryCode)
    } ).toList
  }

}
