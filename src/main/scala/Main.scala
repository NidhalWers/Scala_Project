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
    val airports = airportService.convertFileToAirports("resources/airports.csv")

    val countries = countryService.convertFileToCountries("resources/countries.csv")

    val runways = runwayService.convertFileToRunways("resources/runways.csv")

    val listOfCodesAndNames = countryService.getListOfCodesAndNames(countries.toList)

    consoleController.queryAndReports( airports.toList, countries.toList, runways.toList, listOfCodesAndNames)
  }

}
