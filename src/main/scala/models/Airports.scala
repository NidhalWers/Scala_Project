package models

case class Airports(id: Int,
                    ident: String,
                    theType: String,
                    name: String,
                    latitudeDeg: Float,
                    longitudeDeg: Float,
                    elevationFit: Int,
                    continent: String,
                    iso_country: String,
                    iso_region: String,
                    municipality: String,
                    scheduled_service: String,
                    gps_code : String,
                    iata_code: String,
                    local_code: String,
                    home_link: String,
                    wikipedia_link: String,
                    keywords : String )

object Airports{
  def apply(line : String): Airports = {
    val data = line.split(",")
    new Airports(
      data(0).toInt,
      data(1),
      data(2),
      data(3),
      data(4).toFloat,
      data(5).toFloat,
      data(6).toInt,
      data(7),
      data(8),
      data(9),
      data(10),
      data(11),
      data(12),
      data(13),
      data(14),
      data(15),
      data(16),
      data(17),
    )
  }

}