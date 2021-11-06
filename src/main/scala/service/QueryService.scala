package service

import models.{Airport, Country, Runway}
import models.response.QueryResponse

class QueryService {

  val countryService = new CountryService
  val airportService = new AirportService
  val runwayService = new RunwayService

  //todo transform the Map into a QueryResponse

  def queryCode(countryCode : String, airports: Iterator[Airport], runways: Iterator[Runway]) : Map[Option[String], List[Runway]] = {
    val airportsInCountry =  airportService.getAirportsInCountry(countryCode, airports)

    runwayService.getRunwaysInAirport( airportsInCountry.map(a => (a.ident, a.name) ), runways)
  }


  def queryName(countryName : String, countries: Iterator[Country], airports: Iterator[Airport], runways: Iterator[Runway]) : Map[Option[String], List[Runway]] = {
    val code = countryService.getCodeFromName(countryName, countries)
    code match {
      case None => Map[Option[String], List[Runway]]()
      case Some(codeValue) => queryCode(codeValue, airports, runways)
    }
  }



}
