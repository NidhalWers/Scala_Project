package models

case class Airports(id: Int, ident: String, thetype: String, name: String, latitude_deg: Float, longitude_deg: Float, elevation_ft: Int,  continent: String, iso_country: String,  iso_region: String, municipality: String, scheduled_service: String, gps_code : String, iata_code: String, local_code: String, home_link: String, wikipedia_link: String, keywords : String )

case class AirportsBuilder(id: Option[Int], ident: Option[String], thetype: Option[String], name: Option[String], latitude_deg: Option[Float], longitude_deg: Option[Float], elevation_ft: Option[Int],  continent: Option[String], iso_country: Option[String],  iso_region: Option[String], municipality: Option[String], scheduled_service: Option[String], gps_code : Option[String], iata_code: Option[String], local_code: Option[String], home_link: Option[String], wikipedia_link: Option[String], keywords : Option[String] ){

  def id(id: String) = this.copy(id = Some(id))

}