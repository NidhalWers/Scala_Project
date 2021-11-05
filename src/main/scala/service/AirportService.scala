package service

import models.Airport

class AirportService {

  def convertFileToAirports(file : String): Iterator[Airport] = {
    scala.io.Source.fromFile(file, "utf-8").getLines().drop(1) map( l => Airport(l))
  }

}
