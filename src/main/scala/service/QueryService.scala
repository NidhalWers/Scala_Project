package service

import models.Country
import models.response.QueryResponse

class QueryService {

  val countryService = new CountryService

  def queryCode(countryCode : String) : Option[QueryResponse] = {

  }


  def queryName(countryName : String, countries: Iterator[Country]) : Option[QueryResponse] = {
    val code = countryService.getCodeFromName(countryName, countries)
    code match {
      case None => None
      case Some(codeValue) =>queryCode(codeValue)
    }
  }



}
