package service

import models.{Runways, Country, Airport}

class ReportServiceTest extends org.scalatest.FunSuite {

    val airports = airportService.convertFileToAirports("resources/airports.csv")

    val countries = countryService.convertFileToCountries("resources/countries.csv")

    val runways = runwayService.convertFileToRunways("resources/runways.csv")

  test("testGetTenMostCommonRunwaysLatitude") {
    val b1 = new Runways(id=Some(1)),
    airport_ref = None,
    airport_ident = None,
    length_ft = None,
    width_ft = None,
    surface = None,
    lighted = None,
    closed = None,
    le_ident = None,
    le_latitude_deg = ("le_latitude_deg_1"),
    le_longitude_deg = None,
    le_elevation_ft = None,
    le_heading_degT = None,
    le_displaced_threshold_ft = None,
    he_ident = None,
    he_latitude_deg = ("he_latitude_deg_1"),
    he_longitude_deg = None,
    he_elevation_ft = None,
    he_heading_degT = None,
    he_displaced_threshold_ft = None,
























  }

  test("testGetTenCountriesLowestNumberOfAirports") {

  }

  test("testGetTypeOfRunwaysPerCountry") {

  }

  test("testGetTenCountriesHighestNumberOfAirports") {

  }

}
