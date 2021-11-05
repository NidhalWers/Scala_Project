package models

case class Countries(id : Int, code : String, name : String, continent : String, wikipedia_link : String, keywords : String )

case class CountriesBuilder (id : Option[Int], code : Option[String], name : Option[String], continent : Option[String], wikipedia_link : Option[String], keywords : Option[String] ) {
  def id(id : Int) = this.copy(id= Some(id))
  def code(code : String) = this.copy(code= Some(code))
  def name(name : String) = this.copy(name= Some(name))
  def continent(continent : String) = this.copy(continent= Some(continent))
  def wikipedia_link(wikipedia_link : String) = this.copy(wikipedia_link= Some(wikipedia_link))
  def keywords(keywords : String) = this.copy(keywords= Some(keywords))
}




