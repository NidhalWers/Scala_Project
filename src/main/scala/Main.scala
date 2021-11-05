import models.Airports

object Main {

  val airports = scala.io.Source.fromFile("resources/airports.csv", "utf-8").getLines().drop(1) map( l => Airports(l))

  //val countries = scala.io.Source.fromFile("resources/countries.csv", "utf-8").getLines
  //val runways = scala.io.Source.fromFile("resources/countries.csv", "utf-8").getLines

  def main(args: Array[String]): Unit = {
    println("\tthe airports\n")
    while (airports.hasNext){
      println(airports.next().name)
    }
  }

}
