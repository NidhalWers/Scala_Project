package models

case class Countries(id : Int, code : String, name : String, continent : String, wikipediaLink : String, keywords : String )

case class CountriesBuilder (id : Option[Int], code : Option[String], name : Option[String], continent : Option[String], wikipediaLink : Option[String], keywords : Option[String] ) {
  def id(id : Int) = this.copy(id= Some(id))
  def code(code : String) = this.copy(code= Some(code))
  def name(name : String) = this.copy(name= Some(name))
  def continent(continent : String) = this.copy(continent= Some(continent))
  def wikipedia_link(wikipediaLink : String) = this.copy(wikipediaLink= Some(wikipediaLink))
  def keywords(keywords : String) = this.copy(keywords= Some(keywords))
}




