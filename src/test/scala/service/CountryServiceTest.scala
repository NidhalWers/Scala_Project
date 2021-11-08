package service

import models.Country


class CountryServiceTest extends org.scalatest.FunSuite {
  val countryService = new CountryService

  test("testGetCodeFromName") {
    //given
    val c1 = new Country(id=Some(1),
      code=Some("code_1"),
      name=Some("name_1"),
      continent=None,
      wikipediaLink=None,
      keywords=None )

    val c2 = new Country(id=Some(2),
      code=Some("code_2"),
      name=Some("name_2"),
      continent=None,
      wikipediaLink=None,
      keywords=None )

    val c3 = new Country(id=Some(3),
      code=Some("code_3"),
      name=Some("name_3"),
      continent=None,
      wikipediaLink=None,
      keywords=None )

    val countries = List(c1, c2, c3)

    //when
    val actual = countryService.getCodeFromName("name_2", countries)

    //then
    assert(actual.get.equals("code_2"))
  }



  test("testConvertFileToCountries") {
    val file = "src/test/ressource/testContries.csv"
    val actual = countryService.convertFileToCountries(file).next()
    assert( actual.id.get == 302672 )
    assert( actual.code.get.equals("\"AD\""))
    assert( actual.name.get.equals("\"Andorra\"") )
    assert( actual.continent.get.equals("\"EU\"") )
    assert( actual.wikipediaLink.get.equals("\"http://en.wikipedia.org/wiki/Andorra\"") )
    assert( actual.keywords.equals(None) )

  }

  test("testIsStringCountryCode") {
    assert(countryService.isStringCountryCode("FR"))
    assert(! countryService.isStringCountryCode("France"))
    assert(! countryService.isStringCountryCode("fr"))
    assert(! countryService.isStringCountryCode("FRANCE"))
  }

}
