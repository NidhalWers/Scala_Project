package models

class RunwayTest extends org.scalatest.FunSuite {

  test("testApply") {

    val line = "269408,6523,\"00A\",80,80,\"ASPH-G\",1,0,\"H1\",,,,,,,,,,,"
    val runway = Runway(line)

    assert(runway!=null)
    assert(runway.id.get == 269408)
    assert(runway.airportRef.get == 6523)
    assert(runway.airportIdent.get.equals("\"00A\""))
    assert(runway.lengthFt.get.equals("80"))
    assert(runway.widthFt.get == 80)
    assert(runway.surface.get.equals("\"ASPH-G\""))
    assert(runway.lighted.get == true)
    assert(runway.closed.get == false)
    assert(runway.leIdent.get.equals("\"H1\""))
    assert(runway.leLatitudeDeg.equals(None))
    assert(runway.leLongitudeDeg.equals(None))
    assert(runway.leElevationFt.equals(None))
    assert(runway.leHeadingDegT.equals(None))
    assert(runway.leDisplacedThresholdFt.equals(None))
    assert(runway.heIdent.equals(None))
    assert(runway.heLatitudeDeg.equals(None))
    assert(runway.heLongitudeDeg.equals(None))
    assert(runway.heElevationFt.equals(None))
    assert(runway.heHeadingDegT.equals(None))
    assert(runway.heDisplacedThresholdFt.equals(None))

  }

}
