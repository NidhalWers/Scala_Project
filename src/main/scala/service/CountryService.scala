package service

import models.Country

import  scala.collection.mutable.Set

class CountryService {

  def convertFileToCountries(filePath : String): Iterator[Country] = {
    scala.io.Source.fromFile(filePath, "utf-8").getLines().drop(1) map(l => Country(l))
  }

  def isStringCountryCode(s: String, codes: List[String]): Boolean = {
    codes.contains(s)
  }

  def isStringCountryName(s: String, names: List[String]): Boolean = {
    names.contains(s)
  }

  def nameCompletion(s: String, names: List[String]): List[String] = {
    def aux(s: String, names: List[String], acc: List[String]): List[String] = names match{
      case Nil => acc
      case x::xs => {
        if (x.toLowerCase.startsWith(s.toLowerCase)){
          aux(s, xs, x::acc)
        }else{
          aux(s, xs, acc)
        }
      }
    }

    aux(s, names, List[String]())
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


  def getListOfCodesAndNames(countries: List[Country]) : List[(String,String)] = {
    def aux(countries: List[Country], acc: List[(String,String)]) : List[(String,String)] = countries match {
      case Nil => acc
      case x :: xs => aux(xs, (x.name.get,x.code.get)::acc)
    }

    aux(countries, List[(String,String)]())
  }

}
