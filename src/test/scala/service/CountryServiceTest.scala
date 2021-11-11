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
    val file = "src/test/test_ressource/testContries.csv"
    val actual = countryService.convertFileToCountries(file).next()
    assert( actual.id.get == 302672 )
    assert( actual.code.get.equals("\"AD\""))
    assert( actual.name.get.equals("\"Andorra\"") )
    assert( actual.continent.get.equals("\"EU\"") )
    assert( actual.wikipediaLink.get.equals("\"http://en.wikipedia.org/wiki/Andorra\"") )
    assert( actual.keywords.equals(None) )

  }

  test("testListofCodesAndNames"){
    val countries = countryService.convertFileToCountries("src/test/test_ressource/testContries.csv").toList

    val actual = countryService.getListOfCodesAndNames(countries)

    assert( actual != null )
    assert( actual.size == 1)
    assert( actual(0)._1.equals("\"Andorra\""))
    assert( actual(0)._2.equals("\"AD\""))

  }

  test("testNameCompletion"){
    val countries = countryService.convertFileToCountries("src/test/test_ressource/testContries.csv").toList
    val listOfCodesAndNames = countryService.getListOfCodesAndNames(countries)

    val actual = countryService.nameCompletion("\"and",listOfCodesAndNames.map(s => s._1))

    assert( actual.size==1)
    assert(actual.contains("\"Andorra\""))
  }


  test("testIsStringCountryCode") {
    val countries = countryService.convertFileToCountries("src/test/test_ressource/testContries.csv").toList
    val listOfCodesAndNames = countryService.getListOfCodesAndNames(countries)

    assert(countryService.isStringCountryCode("\"AD\"", listOfCodesAndNames.map(s => s._2)))
    assert(! countryService.isStringCountryCode("\"Andorra\"", listOfCodesAndNames.map(s => s._2)))
    assert(! countryService.isStringCountryCode("\"ad\"", listOfCodesAndNames.map(s => s._2)))
    assert(! countryService.isStringCountryCode("\"ANDORRA\"", listOfCodesAndNames.map(s => s._2)))
  }

  test("testIsStringCountryName") {
    val countries = countryService.convertFileToCountries("src/test/test_ressource/testContries.csv").toList
    val listOfCodesAndNames = countryService.getListOfCodesAndNames(countries)

    assert(! countryService.isStringCountryName("\"AD\"", listOfCodesAndNames.map(s => s._1)))
    assert(countryService.isStringCountryName("\"Andorra\"", listOfCodesAndNames.map(s => s._1)))
    assert(! countryService.isStringCountryName("\"ad\"", listOfCodesAndNames.map(s => s._1)))
    assert(! countryService.isStringCountryName("\"ANDORRA\"", listOfCodesAndNames.map(s => s._1)))
  }

}
