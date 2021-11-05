package models

case class Airports(id: Int, ident: String, theType: String, name: String, latitudeDeg: Float, longitudeDeg: Float, elevationFit: Int,
                    continent: String, iso_country: String, iso_region: String, municipality: String, scheduled_service: String,
                    gps_code : String, iata_code: String, local_code: String, home_link: String, wikipedia_link: String, keywords : String )

case class AirportsBuilder(id: Option[Int], ident: Option[String], theType: Option[String], name: Option[String], latitudeDeg: Option[Float],
                           longitudeDeg: Option[Float], elevationFit: Option[Int], continent: Option[String], isoCountry: Option[String],
                           isoRegion: Option[String], municipality: Option[String], scheduledService: Option[String], gpsCode : Option[String],
                           iataCode: Option[String], localCode: Option[String], homeLink: Option[String], wikipediaLink: Option[String], keywords : Option[String] ){

  def id(f: Int) = this.copy(id = Some(f))

  def ident(f: String) = this.copy(ident = Some(f))

  def theType(f: String) = this.copy(theType = Some(f))

  def name(f: String) = this.copy(name = Some(f))

  def latitudeDeg(f : Float) = this.copy(latitudeDeg = Some(f))

  def longitudeDeg(f : Float ) = this.copy(longitudeDeg = Some(f))

  def elevationFit(f : Int ) = this.copy(elevationFit = Some(f))

  def continent(f : String ) = this.copy(continent = Some(f))

  def isoCountry(f : String ) = this.copy(isoCountry = Some(f))

  def isoRegion(f : String ) = this.copy(isoRegion = Some(f))

  def municipality(f : String ) = this.copy(municipality = Some(f))

  def scheduledService(f : String ) = this.copy(scheduledService = Some(f))

  def gpsCode(f : String ) = this.copy(gpsCode = Some(f))

  def iataCode(f : String ) = this.copy(iataCode = Some(f))

  def localCode(f : String ) = this.copy(localCode = Some(f))

  def homeLink(f : String ) = this.copy(homeLink = Some(f))

  def wikipediaLink(f : String ) = this.copy(wikipediaLink = Some(f))

  def keywords(f : String ) = this.copy(keywords = Some(f))

}