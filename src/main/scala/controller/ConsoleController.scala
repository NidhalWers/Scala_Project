package controller

import models.{Airport, Country, Runway}
import service.{CountryService, QueryService, ReportService, Utils}


class ConsoleController {

  val countryService = new CountryService
  val queryService = new QueryService
  val reportService = new ReportService
  val utils = new Utils


  def queryAndReports( airports: List[Airport], countries: List[Country], runways: List[Runway], listOfCodesAndNames: List[(String,String)] ): Unit = {
    println("Please choose between an option :" +
      "\n\t1 - Query" +
      "\n\t2 - Reports" +
      "\n\t3 - Quit")
    val input = scala.io.StdIn.readLine()
    input match {
      case "1" => query( airports, countries, runways, listOfCodesAndNames )
      case "2" => report( airports, countries, runways, listOfCodesAndNames )
      case "3" => println("good bye")
      case _ => queryAndReports( airports, countries, runways, listOfCodesAndNames )
    }
  }

  private def query( airports: List[Airport], countries: List[Country], runways: List[Runway], listOfCodesAndNames: List[(String,String)] ): Unit ={
    println("please enter the country code or the country name" )
    val input = scala.io.StdIn.readLine()
    if ( countryService.isStringCountryCode("\""+input+"\"", listOfCodesAndNames.map(s => s._2)) ){
      val result = queryService.queryCode("\""+input+"\"", airports, runways)
      println("\n\tHere are the the airports & runways at each airport for this country \n\n"
        + result.map{case (k,v) => "%60s".format(k.get) + " ----------->\t"+ v.mkString("\t|\t")  }.mkString("\n")
      )

      queryAndReports(airports,countries,runways, listOfCodesAndNames)
    }else{
      if( countryService.isStringCountryName("\""+input+"\"", listOfCodesAndNames.map(s=> s._1)) ){
        val result = queryService.queryName("\""+input+"\"", countries, airports, runways)
        println("\n\tHere are the the airports & runways at each airport for this country \n\n"
          + result.map{case (k,v) => "%60s".format(k.get) + " ----------->\t"+ v.mkString("\t|\t")  }.mkString("\n")
        )

      }else{
        val completionList = countryService.nameCompletion("\""+input, listOfCodesAndNames.map(s=> s._1))
        completionList match {
          case Nil => println("no country for this input : "+input)
          case _ :: Nil => {
            println("Did you mean : "+completionList(0)+"\n\t1 - Yes\n\t2 - No")

            val inputYesOrNo = scala.io.StdIn.readLine()
            inputYesOrNo match{
              case "1" => {
                val result = queryService.queryName(completionList(0), countries, airports, runways)
                println("\n\tHere are the the airports & runways at each airport for this country \n\n"
                  + result.map{case (k,v) => "%60s".format(k.get) + " ----------->\t"+ v.mkString("\t|\t")  }.mkString("\n")
                )

              }
              case "2" => queryAndReports(airports,countries,runways, listOfCodesAndNames)
              case _ => query(airports, countries, runways, listOfCodesAndNames)
            }
          }
          case _ :: _ => {
            println("Choose the country's index you want (Beginning by 1) :\n\t" + completionList)

            val completInput = scala.io.StdIn.readLine()
            if (utils.isIndexForCompletion(completInput, completionList.size)) {
              val result = queryService.queryName(completionList(completInput.toInt - 1), countries, airports, runways)
              println("\n\tHere are the the airports & runways at each airport for this country \n\n"
                + result.map{case (k,v) => "%60s".format(k.get) + " ----------->\t"+ v.mkString("\t|\t")  }.mkString("\n")
              )

            }
          }
        }
      }

      queryAndReports(airports,countries,runways, listOfCodesAndNames)
    }
  }



    private def report(airports: List[Airport], countries: List[Country], runways: List[Runway], listOfCodesAndNames: List[(String,String)] ): Unit ={
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
        println("\n\there are the 10 countries with highest number of airports (with count)\n"+result.mkString("\n\t\t"))

        queryAndReports(airports,countries,runways, listOfCodesAndNames)
      }
      case "2" => {
        val result = reportService.getTenCountriesLowestNumberOfAirports(airports)
        println("\n\there are the 10 countries with lowest number of airports (with count)\n"+result.mkString("\n\t\t"))

        queryAndReports(airports,countries,runways, listOfCodesAndNames)
      }
      case "3" => {
        val result = reportService.getTypeOfRunwaysPerCountry(airports, runways)
        println("\n\tHere are the type of runways per country\n"+result.mkString("\n\n"))

        queryAndReports(airports,countries,runways, listOfCodesAndNames)
      }
      case "4" => {
        val result = reportService.getTenMostCommonRunwaysLatitude(runways)
        println("\n\tThe top 10 most common runway latitude\n"+result.mkString("\n\t\t"))

        queryAndReports(airports,countries,runways, listOfCodesAndNames)
      }
      case "5" => {
        queryAndReports(airports,countries,runways, listOfCodesAndNames)
      }
    }
  }


}
