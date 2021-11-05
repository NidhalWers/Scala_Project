object Main {



  val airports = scala.io.Source.fromFile("resources/airports.csv", "utf-8").getLines

  //val countries = scala.io.Source.fromFile("resources/countries.csv", "utf-8").getLines
  //val runways = scala.io.Source.fromFile("resources/countries.csv", "utf-8").getLines

  def main(args: Array[String]): Unit = {
    print(airports)
  }

}
