package models

class CountryTest extends org.scalatest.FunSuite {

  test("testApply") {

    val line = "302672,\"AD\",\"Andorra\",\"EU\",\"http://en.wikipedia.org/wiki/Andorra\","
    val country = Country(line)

    assert(country!=null)
    assert(country.id.get == 302672)
    assert(country.code.get.equals("\"AD\""))
    assert(country.name.get.equals("\"Andorra\""))
    assert(country.continent.get.equals("\"EU\""))
    assert(country.wikipediaLink.get.equals("\"http://en.wikipedia.org/wiki/Andorra\""))
    assert(country.keywords.equals(None))

  }

}
