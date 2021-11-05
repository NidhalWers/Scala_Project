import models.{Airport, Country, Runway}
import service.{AirportService, CountryService, RunwayService}

object Main {
  // services
  val airportService = new AirportService
  val countryService = new CountryService
  val runwayService = new RunwayService

  // processing
  val airports = airportService.convertFileToAirports("resources/airports.csv")

  val countries = countryService.convertFileToCountries("resources/countries.csv")

  val runways = runwayService.convertFileToRunways("resources/runways.csv")

  //todo supprimer les var n,
  // là c'est juste pour voir la donnée facilement
  def main(args: Array[String]): Unit = {
    println("-----------------------------------------------------\n\n\tthe airports\n")
    var n =0
    while (n<=10 && airports.hasNext){
      println(airports.next().name)
      n+=1
    }

    println("end airports\n\n\n-------------------------------------------------\n\n\tthe countries\n")
    while (n<=10 &&  countries.hasNext){
      println(countries.next().name)
      n+=1
    }

    println("end countries\n\n\n------------------------------------------------\n\n\tthe runways\n")
    while (n<=10 &&  runways.hasNext){
      println(runways.next().airportIdent)
      n+=1
    }
  }

}
