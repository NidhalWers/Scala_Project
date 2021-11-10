package service

import models.{Airport, Runway}

class RunwayServiceTest extends org.scalatest.FunSuite {

  val runwayService = new RunwayService

  test("testGetRunwaysInAirportList") {
    val a1 = new Airport(id=Some(1),
      ident=Some("ident_1"),
      theType= None,
      name= Some("airport_1"),
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

    val airports = List((Some("ident_1"),Some("airport_1")),
      (Some("ident_2"), Some("airport_2")),
      (Some("ident_3"),Some("airport_3") ))

    val r1 = new Runway(id = Some(1),
      airportRef = None,
      airportIdent= Some("ident_3"),
      lengthFt = None,
      widthFt = None,
      surface = None,
      lighted = None,
      closed = None,
      leIdent = None,
      leLatitudeDeg = None,
      leLongitudeDeg = None,
      leElevationFt = None,
      leHeadingDegT = None,
      leDisplacedThresholdFt = None,
      heIdent = None,
      heLatitudeDeg = None,
      heLongitudeDeg = None,
      heElevationFt = None,
      heHeadingDegT = None,
      heDisplacedThresholdFt = None
    )

    val runways = List(r1)

    // when
    val actual = runwayService.getRunwaysInAirportList(airports, runways)

    //then
    assert(actual!=null)
    assert(actual.contains(Some("airport_3")) )
    assert(actual( Some("airport_3") ).equals(List("id = 1")))
  }

  test("testConvertFileToRunways") {
    val file = "src/test/test_ressource/testRunways.csv"
    val actual = runwayService.convertFileToRunways(file).next()
    assert( actual.id.get == 269408 )
    assert( actual.airportRef.get == 6523)
    assert( actual.airportIdent.get.equals("\"00A\"") )
    assert( actual.lengthFt.get.equals("80") )
    assert( actual.widthFt.get == 80 )
    assert( actual.surface.get.equals("\"ASPH-G\"") )
    assert( actual.lighted.get )
    assert( ! actual.closed.get )
    assert( actual.leIdent.get.equals("\"H1\"") )
    assert( actual.leLatitudeDeg.equals(None) )
    assert( actual.leLongitudeDeg.equals(None) )
    assert( actual.leElevationFt.equals(None) )
    assert( actual.leHeadingDegT.equals(None) )
    assert( actual.leDisplacedThresholdFt.equals(None) )
    assert( actual.heIdent.equals(None) )
    assert( actual.heLatitudeDeg.equals(None) )
    assert( actual.heLongitudeDeg.equals(None) )
    assert( actual.heElevationFt.equals(None) )
    assert( actual.heHeadingDegT.equals(None) )
    assert( actual.heDisplacedThresholdFt.equals(None) )
  }

}
