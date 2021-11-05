package models

case class Runways(id : Int,
                   airportRef : Int,
                   airportIdent: String,
                   lengthFt : String,
                   widthFt : Int,
                   surface : String,
                   lighted : Boolean,
                   closed : Boolean,
                   leIden : String,
                   leLatitudeDeg : Float,
                   leLongitudeDeg : Float,
                   leElevationFt : Int,
                   leHeadingDegT : Int,
                   leDisplacedThresholdFt : Int,
                   heIdent : String,
                   heLatitudeDeg : Float,
                   heLongitudeDeg : Float,
                   heElevationFt : Int,
                   heHeadingDegT : Int,
                   heDisplacedThresholdFt :Int)

object Runways {
  def apply(line : String): Runways = {
    val data = line.split(",")
    new Runways(
      data(0).toInt,
      data(1).toInt,
      data(2),
      data(3),
      data(4).toInt,
      data(5),
      data(6).toBoolean,
      data(7).toBoolean,
      data(8),
      data(9).toFloat,
      data(10).toFloat,
      data(11).toInt,
      data(12).toInt,
      data(13).toInt,
      data(14),
      data(15).toFloat,
      data(16).toFloat,
      data(17).toInt,
      data(18).toInt,
      data(19).toInt
    )
  }
}