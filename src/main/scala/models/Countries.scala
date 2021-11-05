package models

case class Countries(id : Int,
                     code : String,
                     name : String,
                     continent : String,
                     wikipediaLink : String,
                     keywords : String )

object Countries{
  def apply(line : String): Countries = {
    val data = line.split("," )
    new Countries(
      data(0).toInt,
      data(1),
      data(2),
      data(3),
      data(4),
      data(5),
    )
  }
}


