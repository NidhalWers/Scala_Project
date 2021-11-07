package models

class AirportTest extends org.scalatest.FunSuite {

  test("apply function"){
    val line = "6523,\"00A\",\"heliport\",\"Total Rf Heliport\",40.07080078125,-74.93360137939453,11,\"NA\"," +
      "\"US\",\"US-PA\",\"Bensalem\",\"no\",\"00A\",,\"00A\",,,"
    val airport = Airport(line)

    assert(airport!=null)
    assert(airport.id.get == 6523)
    assert(airport.ident.get.equals("\"00A\"") )
    assert(airport.theType.get.equals("\"heliport\""))
    assert(airport.name.get.equals("\"Total Rf Heliport\""))
    assert(airport.latitudeDeg.get == 40.07080078125)
    assert(airport.longitudeDeg.get == -74.93360137939453)
    assert(airport.elevationFit.get == 11)
    assert(airport.continent.get.equals("\"NA\""))
    assert(airport.isoCountry.get.equals("\"US\""))
    assert(airport.isoRegion.get.equals("\"US-PA\""))
    assert(airport.municipality.get.equals("\"Bensalem\""))
    assert(airport.scheduled_service.get.equals("\"no\""))
    assert(airport.gpsCode.get.equals("\"00A\""))
    assert(airport.iataCode.equals(None))
    assert(airport.localCode.get.equals("\"00A\""))
    assert(airport.homeLink.equals(None))
    assert(airport.wikipediaLink.equals(None))
    assert(airport.keywords.equals(None))
  }

}
