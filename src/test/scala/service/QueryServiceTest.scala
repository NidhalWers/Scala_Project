package service

import models.{Airport, Country, Runway}

class QueryServiceTest extends org.scalatest.FunSuite {

  val queryService = new QueryService

  test("testQueryName") {
    //given
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

    val a2 = new Airport(id=Some(2),
      ident=Some("ident_2"),
      theType= None,
      name= Some("airport_2"),
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
      ident=Some("ident_3"),
      theType= None,
      name= Some("airport_3"),
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

    val airports = List(a1, a2, a3)


    val c1 = new Country(id=Some(1),
      code=Some("FR"),
      name=Some("name_1"),
      continent=None,
      wikipediaLink=None,
      keywords=None )

    val countries = List(c1)

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

    //when
    val actual = queryService.queryName("name_1", countries, airports, runways)

    //then
    assert(actual!=null)
    assert(actual.contains(Some("airport_1")) )
    assert(actual( Some("airport_1") ).equals(List()))
    assert(actual.contains(Some("airport_3")) )
    assert(actual( Some("airport_3") ).equals(List("id = 1")))

  }

 test("testQueryCode") {
   //given
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

   val a2 = new Airport(id=Some(2),
     ident=Some("ident_2"),
     theType= None,
     name= Some("airport_2"),
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
     ident=Some("ident_3"),
     theType= None,
     name= Some("airport_3"),
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

   val airports = List(a1, a2, a3)


   val c1 = new Country(id=Some(1),
     code=Some("FR"),
     name=Some("name_1"),
     continent=None,
     wikipediaLink=None,
     keywords=None )

   val countries = List(c1)

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

   //when
   val actual = queryService.queryCode("FR", airports, runways)

   //then
   assert(actual!=null)
   assert(actual.contains(Some("airport_1")) )
   assert(actual( Some("airport_1") ).equals(List()))
   assert(actual.contains(Some("airport_3")) )
   assert(actual( Some("airport_3") ).equals(List("id = 1")))
  }

}
