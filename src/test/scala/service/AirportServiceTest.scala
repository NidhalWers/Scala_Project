package service

import models.Airport

class AirportServiceTest extends org.scalatest.FunSuite {
  val airportService = new AirportService

  test("testGetAirportsInCountry") {
    //given
    val a1 = new Airport(id=Some(1),
      ident=None,
      theType= None,
      name= None,
      latitudeDeg = None,
      longitudeDeg = None,
      elevationFit = None,
      continent = None,
      isoCountry = Some("FR"),
      isoRegion = None,
      municipality = None,
      scheduled_service = None,
      gpsCode  = None,
      iataCode = None,
      localCode = None,
      homeLink = None,
      wikipediaLink = None,
      keywords  = None)

    val a2 = new Airport(id=Some(2),
      ident=None,
      theType= None,
      name= None,
      latitudeDeg = None,
      longitudeDeg = None,
      elevationFit = None,
      continent = None,
      isoCountry = Some("US"),
      isoRegion = None,
      municipality = None,
      scheduled_service = None,
      gpsCode  = None,
      iataCode = None,
      localCode = None,
      homeLink = None,
      wikipediaLink = None,
      keywords  = None)

    val a3 = new Airport(id=Some(3),
      ident=None,
      theType= None,
      name= None,
      latitudeDeg = None,
      longitudeDeg = None,
      elevationFit = None,
      continent = None,
      isoCountry = Some("FR"),
      isoRegion = None,
      municipality = None,
      scheduled_service = None,
      gpsCode  = None,
      iataCode = None,
      localCode = None,
      homeLink = None,
      wikipediaLink = None,
      keywords  = None)

    val airports = List(a1, a2, a3 )

    //when
    val actual = airportService.getAirportsInCountry("FR", airports)

    //then
    assert(actual!= null)
    assert(actual.size == 2)
    assert(actual(0).id.get==1)
    assert(actual(1).id.get==3)
  }

  test("testConvertFileToAirports") {
    val file = "src/test/ressource/testAirport.csv"
    val actual = airportService.convertFileToAirports(file).next()
    assert( actual.id.get == 6523 )
    assert( actual.ident.get.equals("\"00A\""))
    assert( actual.theType.get.equals("\"heliport\"") )
    assert( actual.name.get.equals("\"Total Rf Heliport\"") )
    assert( actual.latitudeDeg.get == 40.07080078125 )
    assert( actual.longitudeDeg.get == -74.93360137939453 )
    assert( actual.elevationFit.get == 11 )
    assert( actual.continent.get.equals("\"NA\"") )
    assert( actual.isoCountry.get.equals("\"US\"") )
    assert( actual.isoRegion.get.equals("\"US-PA\"") )
    assert( actual.municipality.get.equals("\"Bensalem\"") )
    assert( actual.scheduled_service.get.equals("\"no\"") )
    assert( actual.gpsCode.get.equals("\"00A\"") )
    assert( actual.iataCode.equals(None) )
    assert( actual.localCode.get.equals("\"00A\"") )
    assert( actual.homeLink.equals(None) )
    assert( actual.wikipediaLink.equals(None) )
    assert( actual.keywords.equals(None) )
  }

}
