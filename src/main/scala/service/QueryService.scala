package service

import models.{Airport, Country, Runway}
import models.response.QueryResponse

class QueryService {

  val countryService = new CountryService
  val airportService = new AirportService
  val runwayService = new RunwayService

  //todo transform the Map into a QueryResponse

  def queryCode(countryCode : String, airports: List[Airport], runways: List[Runway]) : Map[Option[String], List[String]] = {
    val airportsInCountry =  airportService.getAirportsInCountry(countryCode, airports)
    //println("airports : " +airportsInCountry)
    runwayService.getRunwaysInAirportList( airportsInCountry.map(a => (a.ident, a.name) ), runways)
  }


  def queryName(countryName : String, countries: List[Country], airports: List[Airport], runways: List[Runway]) : Map[Option[String], List[String]] = {
    val code = countryService.getCodeFromName(countryName, countries)
    code match {
      case None => Map[Option[String], List[String]]()
      case Some(codeValue) => queryCode(codeValue, airports, runways)
    }
  }



}
