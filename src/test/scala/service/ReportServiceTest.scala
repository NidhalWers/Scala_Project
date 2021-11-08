package service



class ReportServiceTest extends org.scalatest.FunSuite {

  val airports = airportService.convertFileToAirports("resources/airports.csv")

  val countries = countryService.convertFileToCountries("resources/countries.csv")

  val runways = runwayService.convertFileToRunways("resources/runways.csv")

  test("testGetTenMostCommonRunwaysLatitude") {

  }

  test("testGetTenCountriesLowestNumberOfAirports") {

  }

  test("testGetTypeOfRunwaysPerCountry") {

  }

  test("testGetTenCountriesHighestNumberOfAirports") {

  }

}
