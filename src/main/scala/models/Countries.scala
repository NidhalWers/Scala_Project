package models

case class Countries(id : String,
                     code : String,
                     name : String,
                     continent : String,
                     wikipediaLink : String,
                     keywords : String )

object Countries{
  def apply(line : String): Countries = {
    val data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1)
    new Countries(
      data(0),
      data(1),
      data(2),
      data(3),
      data(4),
      data(5),
    )
  }
}


