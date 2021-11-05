package service

import models.Runway

class RunwayService {

  def convertFileToRunways(file : String): Iterator[Runway] = {
    scala.io.Source.fromFile(file, "utf-8").getLines().drop(1) map( l => Runway(l))
  }

}
