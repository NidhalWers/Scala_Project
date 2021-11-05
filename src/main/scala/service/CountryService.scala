package service

import models.Country

class CountryService {

  def convertFileToCountries(filePath : String): Iterator[Country] = {
    scala.io.Source.fromFile(filePath, "utf-8").getLines().drop(1) map(l => Country(l))
  }

}
