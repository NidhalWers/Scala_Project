package controller

import models.{Airport, Country, Runway}
import service.{CountryService, QueryService}

class ConsoleController {

  val countryService = new CountryService
  val queryService = new QueryService

  def queryAndReports( airports: Iterator[Airport], countries: Iterator[Country], runways: Iterator[Runway] ): Unit = {
    println("Please choose between option 1 & 2 :\n\t1 - Query\n\t2 - Reports")
    val input = scala.io.StdIn.readInt()
    input match {
      case 1 => query( airports, countries, runways )
      case 2 => report( airports, countries, runways )
      case _ => queryAndReports( airports, countries, runways )
    }
  }

  private def query( airports: Iterator[Airport], countries: Iterator[Country], runways: Iterator[Runway] ): Unit ={
    println("please enter the country code or the country name" )
    val input = scala.io.StdIn.readLine()
    if ( countryService.isStringCountryCode(input) ){
      val result = queryService.queryCode("\""+input+"\"", airports, runways)
      println(result.map{case (k,v) => k + " : "+ v }.mkString("\n")  )
    }else{
      val result = queryService.queryName("\""+input+"\"", countries, airports, runways)
      println(result)
    }
  }

  private def report( airports: Iterator[Airport], countries: Iterator[Country], runways: Iterator[Runway] ): Unit ={
    println("This is a menu")
  }


}
