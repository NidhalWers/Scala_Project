import controller.ConsoleController
import service.{AirportService, CountryService, RunwayService}

object Main {
  // services
  val airportService = new AirportService
  val countryService = new CountryService
  val runwayService = new RunwayService
  val consoleController = new ConsoleController

  // processing

  //todo supprimer les var n,
  // là c'est juste pour voir la donnée facilement
  def main(args: Array[String]): Unit = {
    val airports = airportService.convertFileToAirports("resources/airports.csv").toList

    val countries = countryService.convertFileToCountries("resources/countries.csv").toList

    val runways = runwayService.convertFileToRunways("resources/runways.csv").toList

    val listOfCodesAndNames = countryService.getListOfCodesAndNames(countries)

    consoleController.queryAndReports( airports, countries, runways, listOfCodesAndNames)
  }

}
