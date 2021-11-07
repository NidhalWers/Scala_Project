package controller

import models.{Airport, Country, Runway}
import service.{CountryService, QueryService, ReportService}


class ConsoleController {

  val countryService = new CountryService
  val queryService = new QueryService
  val reportService = new ReportService


  def queryAndReports( airports: List[Airport], countries: List[Country], runways: List[Runway] ): Unit = {
    println("Please choose between an option :" +
      "\n\t1 - Query" +
      "\n\t2 - Reports" +
      "\n\t3 - Quit")
    val input = scala.io.StdIn.readLine()
    input match {
      case "1" => query( airports, countries, runways )
      case "2" => report( airports, countries, runways )
      case "3" => println("good by")
      case _ => queryAndReports( airports, countries, runways )
    }
  }

  private def query( airports: List[Airport], countries: List[Country], runways: List[Runway] ): Unit ={
    println("please enter the country code or the country name" )
    val input = scala.io.StdIn.readLine()
    if ( countryService.isStringCountryCode(input) ){
      val result = queryService.queryCode("\""+input+"\"", airports, runways)
      println(result.map{case (k,v) => k + " : "+ v }.mkString("\n")  )

      queryAndReports(airports,countries,runways)
    }else{
      val result = queryService.queryName("\""+input+"\"", countries, airports, runways)
      println(result)

      queryAndReports(airports,countries,runways)
    }
  }



    private def report(airports: List[Airport], countries: List[Country], runways: List[Runway] ): Unit ={
    println("This is a menu, choose the informations you want :" +
      "\n\t1 - 10 countries with highest number of airports" +
      "\n\t2 - 10 countries with lowest number of airports " +
      "\n\t3 - Type of runways per country" +
      "\n\t4 - The top 10 most common runway latitude" +
      "\n\t5 - Back   to the main menu")

    val input = scala.io.StdIn.readLine()
    input match {
      case "1" => {
        val result = reportService.getTenCountriesHighestNumberOfAirports(airports)
        println(result)

        queryAndReports(airports,countries,runways)
      }
      case "2" => {
        val result = reportService.getTenCountriesLowestNumberOfAirports(airports)
        println(result)

        queryAndReports(airports,countries,runways)
      }
      case "3" => {
        val result = reportService.getTypeOfRunwaysPerCountry(airports, runways)
        println(result.mkString("\n"))

        queryAndReports(airports,countries,runways)
      }
      case "4" => {
        val result = reportService.getTenMostCommonRunwaysLatitude(runways)
        println(result)

        queryAndReports(airports,countries,runways)
      }
      case "5" => {
        queryAndReports(airports,countries,runways)
      }
    }
  }


}
