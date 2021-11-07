package service

import models.Country

class CountryService {

  def convertFileToCountries(filePath : String): Iterator[Country] = {
    scala.io.Source.fromFile(filePath, "utf-8").getLines().drop(1) map(l => Country(l))
  }

  def isStringCountryCode(s: String): Boolean = {
    s.equals(s.toUpperCase()) && s.length==2
  }

  def getCodeFromName(countryName : String, countries: List[Country]): Option[String] = {
    val countryResult = countries.find( c => c.name match{
      case None => false
      case Some(value) => value.equals(countryName)
    }  )

    countryResult match {
      case None => None
      case Some(x) => x.code
    }
  }

}
