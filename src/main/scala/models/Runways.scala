package models

import javax.swing.text.html.Option

case class Runways(id : Int,
                   airportRef : Int,
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
  def apply(line : String): Runways{
    val data = line.split(",")
    new Runways{
      data(0).toInt,
      data(0).toInt,
      data(0).toString,
      data(0).toInt,
      data(0).toString,
      data(0).toBoolean,
      data(0).toBoolean,
      data(0).toString,
      data(0).toFloat,
      data(0).toFloat,
      data(0).toInt,
      data(0).toInt,
      data(0).toInt,
      data(0).toString,
      data(0).toFloat,
      data(0).toFloat,
      data(0).toInt,
      data(0).toInt,
      data(0).toInt,
    }
  }
}