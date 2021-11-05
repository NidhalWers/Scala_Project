package models

import javax.swing.text.html.Option

case class Runways(id : Int, airport_ref : Int, length_ft : String, width_ft : Int, surface : String,
                   lighted : Boolean, closed : Boolean, le_iden : String, le_latitude_deg : Float,
                   le_longitude_deg : Float, le_elevation_ft : Int, le_heading_degT : Int,
                   le_displaced_threshold_ft : Int, he_ident : String, he_latitude_deg : Float,
                   he_longitude_deg : Float, he_elevation_ft : Int, he_heading_degT : Int,
                   he_displaced_threshold_ft :Int)

case class RunwaysBuilder(id : Option[Int], airport_ref : Option[Int], length_ft : Option[String], width_ft : Option[Int], surface : Option[String],
                          lighted : Option[Boolean], closed : Option[Boolean], le_iden : Option[String], le_latitude_deg : Option[Float],
                          le_longitude_deg : Option[Float], le_elevation_ft : Option[Int], le_heading_degT : Option[Int],
                          le_displaced_threshold_ft : Option[Int], he_ident : Option[String], he_latitude_deg : Option[Float],
                          he_longitude_deg : Option[Float], he_elevation_ft : Option[Int], he_heading_degT : Option[Int],
                          he_displaced_threshold_ft :Option[Int]) {

  def id(id: Int) = this.copy(id = Some(id))
  def airport_ref(airport_ref: Int) = this.copy(airport_ref = Some(airport_ref))
  def length_ft(length_ft: String) = this.copy(length_ft = Some(length_ft))
  def width_ft(width_ft: Int) = this.copy(width_ft = Some(width_ft))
  def surface(surface: String) = this.copy(surface = Some(surface))
  def lighted(lighted: Boolean) = this.copy(lighted = Some(lighted))
  def closed(closed: Boolean) = this.copy(closed = Some(closed))
  def le_iden(le_iden: String) = this.copy(le_iden = Some(le_iden))
  def le_latitude_deg(le_latitude_deg: Float) = this.copy(le_latitude_deg = Some(le_latitude_deg))
  def le_longitude_deg(le_longitude_deg: Float) = this.copy(le_longitude_deg = Some(le_longitude_deg))
  def le_elevation_ft(le_elevation_ft: Int) = this.copy(le_elevation_ft = Some(le_elevation_ft))
  def le_heading_degT(le_heading_degT: Int) = this.copy(le_heading_degT = Some(le_heading_degT))
  def le_displaced_threshold_ft(le_displaced_threshold_ft: Int) = this.copy(le_displaced_threshold_ft = Some(le_displaced_threshold_ft))
  def he_ident(he_ident: String) = this.copy(he_ident = Some(he_ident))
  def he_latitude_deg(he_latitude_deg: Float) = this.copy(he_latitude_deg = Some(he_latitude_deg))
  def he_longitude_deg(he_longitude_deg: Float) = this.copy(he_longitude_deg = Some(he_longitude_deg))
  def he_elevation_ft(he_elevation_ft: Int) = this.copy(he_elevation_ft = Some(he_elevation_ft))
  def he_heading_degT(he_heading_degT: Int) = this.copy(he_heading_degT = Some(he_heading_degT))
  def he_displaced_threshold_ft(he_displaced_threshold_ft: Int) = this.copy(he_displaced_threshold_ft = Some(he_displaced_threshold_ft))




}