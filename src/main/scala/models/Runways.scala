package models

import javax.swing.text.html.Option

case class Runways(id : Int, airportRef : Int, lengthFt : String, widthFt : Int, surface : String,
                   lighted : Boolean, closed : Boolean, leIden : String, leLatitudeDeg : Float,
                   leLongitudeDeg : Float, leElevationFt : Int, leHeadingDegT : Int,
                   leDisplacedThresholdFt : Int, heIdent : String, heLatitudeDeg : Float,
                   heLongitudeDeg : Float, heElevationFt : Int, heHeadingDegT : Int,
                   heDisplacedThresholdFt :Int)

case class RunwaysBuilder(id : Option[Int], airportRef : Option[Int], lengthFt : Option[String], widthFt : Option[Int], surface : Option[String],
                          lighted : Option[Boolean], closed : Option[Boolean], leIden : Option[String], leLatitudeDeg : Option[Float],
                          leLongitudeDeg : Option[Float], leElevationFt : Option[Int], leHeadingDegT : Option[Int],
                          leDisplacedThresholdFt : Option[Int], heIdent : Option[String], heLatitudeDeg : Option[Float],
                          heLongitudeDeg : Option[Float], heElevationFt : Option[Int], heHeadingDegT : Option[Int],
                          heDisplacedThresholdFt :Option[Int]) {

  def id(id: Int) = this.copy(id = Some(id))
  def airportRef(airportRef: Int) = this.copy(airportRef = Some(airportRef))
  def lengthFt(lengthFt: String) = this.copy(lengthFt = Some(lengthFt))
  def widthFt(widthFt: Int) = this.copy(widthFt = Some(widthFt))
  def surface(surface: String) = this.copy(surface = Some(surface))
  def lighted(lighted: Boolean) = this.copy(lighted = Some(lighted))
  def closed(closed: Boolean) = this.copy(closed = Some(closed))
  def leIden(leIden: String) = this.copy(leIden = Some(leIden))
  def leLatitudeDeg(leLatitudeDeg: Float) = this.copy(leLatitudeDeg = Some(leLatitudeDeg))
  def leLongitudeDeg(leLongitudeDeg: Float) = this.copy(leLongitudeDeg = Some(leLongitudeDeg))
  def leElevationFt(leElevationFt: Int) = this.copy(leElevationFt = Some(leElevationFt))
  def leHeadingDegT(leHeadingDegT: Int) = this.copy(leHeadingDegT = Some(leHeadingDegT))
  def leDisplacedThresholdFt(leDisplacedThresholdFt: Int) = this.copy(leDisplacedThresholdFt = Some(leDisplacedThresholdFt))
  def heIdent(heIdent: String) = this.copy(heIdent = Some(heIdent))
  def heLatitudeDeg(heLatitudeDeg: Float) = this.copy(heLatitudeDeg = Some(heLatitudeDeg))
  def heLongitudeDeg(heLongitudeDeg: Float) = this.copy(heLongitudeDeg = Some(heLongitudeDeg))
  def heElevationFt(heElevationFt: Int) = this.copy(heElevationFt = Some(heElevationFt))
  def heHeadingDegT(heHeadingDegT: Int) = this.copy(heHeadingDegT = Some(heHeadingDegT))
  def heDisplacedThresholdFt(heDisplacedThresholdFt: Int) = this.copy(heDisplacedThresholdFt = Some(heDisplacedThresholdFt))




}