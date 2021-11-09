package service

import models.{Runways, Country, Airport}

class ReportServiceTest extends org.scalatest.FunSuite {

    val airports = airportService.convertFileToAirports("resources/airports.csv")

    val countries = countryService.convertFileToCountries("resources/countries.csv")

    val runways = runwayService.convertFileToRunways("resources/runways.csv")

  test("testGetTenMostCommonRunwaysLatitude") {
    val r1 = getTenMostCommonRunwaysLatitude(runways)

    assert(r1!=null)
    assert(r1.size == 10)

    assert(r1.contains("18"))
    assert(r1.contains("16"))
    assert(r1.contains("15"))
    assert(r1.contains("09"))
    assert(r1.contains("12"))
    assert(r1.contains("H1"))
    assert(r1.contains("08"))
    assert(r1.contains("17"))
    assert(r1.contains("13"))
    assert(r1.contains("14"))

  }

  test("testGetTenCountriesLowestNumberOfAirports") {
    val a1 = getTenCountriesLowestNumberOfAirports(airports)

    assert(a1!=null)
    assert(a1.size == 10)

    assert(a1.contains("BL" -> 1))
    assert(a1.contains("AI" -> 1))
    assert(a1.contains("TV" -> 1))
    assert(a1.contains("CW" -> 1))
    assert(a1.contains("MQ" -> 1))
    assert(a1.contains("JE" -> 1))
    assert(a1.contains("NU" -> 1))
    assert(a1.contains("ZZ" -> 1))
    assert(a1.contains("VA" -> 1))
    assert(a1.contains("GM" -> 1))

  }

  test("testGetTypeOfRunwaysPerCountry") {

    val r2 = getTenCountriesLowestNumberOfAirports(airports)

    assert(r2!=null)
    assert(r2.size == 10)

    assert(r2.contains("GR"-> Set("ASP", "UNK", "PEM")))

    assert(r2.contains("LY"-> HashSet("COP", "ASP", "CON", "SAN", "GVL"))

    assert(r2.contains("LU"-> Set("PEM", "grass"))

    assert(r2.contains("OM"-> Set("ASP", "GVL", "GRE"))

    assert(r2.contains("GF"-> Set("ASP", "CON"))

    assert(r2.contains("SE"-> HashSet("PEM", "Asphalt", "ASP", "GRE", "CON", "UNK", "Gravel", "Pavement", "grass", "GRS", "Grass"))

    assert(r2.contains("CG"-> Set("ASP", "UNK"))

    assert(r2.contains("CO"-> Set("ASP", "UNK", "CON", "GRE"))

    assert(r2.contains("MD"-> Set("CON", "grass"))

    assert(r2.contains("MY"-> Set("ASP", "GRE", "paved"))

    assert(r2.contains("NC"-> HashSet("Asphalt", "ASP", "MAC", "UNK", "Paved/Gravel", "Paved/Compacted schist"))

    assert(r2.contains("FK"-> Set("ASP"))

    assert(r2.contains("AI"-> Set("ASP"))

    assert(r2.contains("CK"-> Set("COR", "ASP", "UNK", "CON"))

    assert(r2.contains("GY"-> Set("ASP", "concrete"))

    assert(r2.contains("IT"-> HashSet("ground", "ASP", "concrete", "GRE", "UNK", "asphalt", "BIT", "grass", "BITUMINOUS", "dirt", "GRS", "Grass"))

    assert(r2.contains("GG"-> Set("GRE", "ASP"))

    assert(r2.contains("NP"-> Set("ASP", "UNK", "asphalt"))

    assert(r2.contains("MX"-> HashSet("paved", "Soil", "Asphalt", "ASP", "GRE", "CON", "UNK", "asphalt", "ASPHALTH", "packed dirt", "concrete")))

    assert(r2.contains("TV"-> Set("UNK")))

    assert(r2.contains("BQ"-> Set("ASP")))

    assert(r2.contains("LR"-> Set("ASP")))

    assert(r2.contains("IM"-> Set("ASP")))

    assert(r2.contains("PR"-> HashSet("TURF", "ASPH-CONC", "ASP", "CON", "ASPH-G", "ASPH-F", "WATER", "ASPH")))

    assert(r2.contains("CW" -> Set("ASP")))

    assert(r2.contains("RW"-> Set("ASP", "'asphalt'", "grass")))

    assert(r2.contains("BT"-> Set("BIT", "Asphalt", "ASP")))

    assert(r2.contains("LS"-> Set("ASP", "GRE")))

    assert(r2.contains("DZ"-> HashSet("PEM", "ASP", "GRE", "CON", "UNK", "BIT", "SAN")))

    assert(r2.contains("BF"-> Set("ASP", "LAT")))

    assert(r2.contains("PW"-> Set("GRVL-F", "GRAVEL-F", "ASP")))

    assert(r2.contains("EC"-> Set("ASP", "UNK", "Paviment hard")))

    assert(r2.contains("MG"-> Set("PEM", "ASP", "COP", "BIT")))

    assert(r2.contains("LV"> Set("ASP", "PEM", "CON")))

    assert(r2.contains("MQ"-> Set("ASP")))

    assert(r2.contains("GL"-> HashSet("ICE", "ASP", "CON", "UNK", "GVL", "ASPH")))

    assert(r2.contains("KI"-> Set("BIT", "COR", "ASP")))

    assert(r2.contains("SA"-> HashSet("ASP", "CON", "UNK", "BIT", "SAN")))

    assert(r2.contains("BH"-> Set("ASP")))

    assert(r2.contains("ET"-> Set("ASP", "PEM", "CON")))

    assert(r2.contains("GU"-> Set("PEM", "ASP")))

    assert(r2.contains("JE"-> Set("ASP")))

    assert(r2.contains("EH"-> Set("ASP")))

    assert(r2.contains("MK"-> Set("GRE", "GRS", "CON", "ASP")))

    assert(r2.contains("SI"-> HashSet("ASP", "concrete", "asphalt", "grass", "GRS")))

    assert(r2.contains("CA", 1))

    assert(r2.contains("NU"-> Set("ASP")))

    assert(r2.contains("MU"-> Set("ASP")))

    assert(r2.contains("AO"-> Set("ASP", "UNK")))

    assert(r2.contains("AQ"-> Set("SNO", "ICE", "GRE", "ice")))

    assert(r2.contains("TH"-> Set("ASP", "CON")))

    assert(r2.contains("PH"-> HashSet("PEM", "COP", "ASP", "Paved", "CON", "dirt", "Concrete", "BIT", "ASP/CON")))

    assert(r2.contains("SS"-> Set("Asphalt", "ASP", "UNK")))

    assert(r2.contains("UA"-> HashSet("PEM", "ASP", "GRE", "BRI", "CON", "UNK", "GRS")))

    assert(r2.contains("TR"-> HashSet("Asphalt", "ASP", "concrete", "CON", "PER", "Concrete", "CONCRETE")))

    assert(r2.contains("BB"-> Set("ASP")))

    assert(r2.contains("AG"-> Set("ASP")))

    assert(r2.contains("SY"-> HashSet("PEM", "ASP", "GRE", "CON", "UNK", "SAN")))

    assert(r2.contains("NO"-> HashSet("Asphalt", "ASP", "CON", "UNK", "Gravel", "Concrete", "Gravel/Grass", "Ice - frozen lake", "Ice", "Grass")))

    assert(r2.contains("ZA"-> HashSet("gravel", "Grass/Concrete", "Asphalt", "Soil, rough gravel", "grass, use at own risk, animals may errode surface", "tar", "GRE", "CON", "UNK", "Gravel", "LAT", "asphalt", "hard", "COM", "Tar", "paving", "ASP", "dirt, use at own risk, animals may errode surface", "tar old", "Tar - lights 5 clicks on 124.8", "GVL", "GRS", "Grass")))

    assert(r2.contains("LK"-> Set("ASP", "Asphalt")))

    assert(r2.contains("FJ"-> Set("ASP", "UNK")))

    assert(r2.contains("FR", 1))

    assert(r2.contains("HT"-> Set("ASP")))

    assert(r2.contains("IE", 1))

    assert(r2.contains("YE"-> Set("ASP", "UNK")))

    assert(r2.contains("SN"-> Set("SAN", "ASP", "GRE", "MAC")))

    assert(r2.contains("GH"-> Set("ASP")))

    assert(r2.contains("FO"-> Set("ASP")))

    assert(r2.contains("GQ"-> Set("ASP", "UNK", "CON")))

    assert(r2.contains("PA"-> Set("ASP", "CON", "Asphalt")))

    assert(r2.contains("DM"-> Set("ASP")))

    assert(r2.contains("TM"-> Set("ASP", "CON"))

    assert(r2.contains("MP"-> Set("ASP", "PEM", "TURF-GRVL")))

    assert(r2.contains("MT"-> Set("ASP")))

    assert(r2.contains("IL"-> Set("ASP", "PEM", "Asphalt")))

    assert(r2.contains("CZ"-> HashSet("Asphalt", "ASP", "CON", "UNK", "grass", "GRS", "Grass")))

    assert(r2.contains("AU", 1))

    assert(r2.contains("CV"-> Set("ASP", "UNK")))

    assert(r2.contains("KN"-> Set("ASP")))

    assert(r2.contains("AM"-> Set("paved", "CON", "ASP")))

    assert(r2.contains("GE"-> Set("CON", "ASP")))

    assert(r2.contains("BS"-> Set("BIT", "ASP", "ASPH")))

    assert(r2.contains("KG"-> HashSet("ASP", "concrete", "ASB", "CON", "asphalt")))

    assert(r2.contains("CD"-> HashSet("PEM", "Dirt", "ASP", "CON", "LAT", "GVL")))

    assert(r2.contains("CR" -> Set("ASP", "CON", "UNK"))

    assert(r2.contains("NE" -> Set("ASP", "UNK", "LAT"))

    assert(r2.contains("NA"-> Set("ASP", "GVL", "UNK")))

    assert(r2.contains("WS"-> Set("ASP")))

    assert(r2.contains("VE"-> Set("ASP", "CON", "UNK", "CONCRETE")))

    assert(r2.contains("JO"-> Set("ASP", "CON")))

    assert(r2.contains("CN"-> HashSet("paved", "Asphalt", "ASP", "concrete", "CON", "UNK", "Concrete")))

    assert(r2.contains("MW"-> Set("ASP", "GRS", "BIT")))

    assert(r2.contains("IS"-> Set("ASP", "BIT", "UNK", "ASPH-G")))

    assert(r2.contains("ZM"-> HashSet("ASP", "BRI", "CON", "UNK", "Gravel", "BIT", "GRS")))

    assert(r2.contains("KZ"-> HashSet("PEM", "ASP", "GRE", "CON", "asphalt", "GRS")))

    assert(r2.contains("HU"-> HashSet("ASP", "concrete", "GRE", "CON", "UNK", "Concrete", "grass", "GRS", "Grass")))

    assert(r2.contains("BE"-> HashSet("PEM", "ASP", "CON", "UNK", "grass", "GRS", "Grass")))

    assert(r2.contains("AT" -> HashSet("GRASS", "CLOSED", "ASP", "CON", "ASPHALT", "GRS")))

    assert(r2.contains("ST"-> Set("ASP")))

    assert(r2.contains("NL" -> HashSet("PEM", "grass, first 500x6 meter on 25 is paved", "ASP", "CON", "asphalt", "grass", "ASPH")))

    assert(r2.contains("KH"-> HashSet("ASP", "CON", "UNK", "GVL", "GRS")))

    assert(r2.contains("MM"-> Set("CON", "ASP", "BIT"))

    assert(r2.contains("JP"-> HashSet("PEM", "ASP", "GRE", "CON", "UNK", "PSP", "GRS", "COR", "U", "concrete")))

    assert(r2.contains("AL"-> HashSet("paved", "ASP", "GRE", "CON", "GRS")))

    assert(r2.contains("EG"-> Set("ASP", "Asphalt", "UNK")))

    assert(r2.contains("RU", 1))

    assert(r2.contains("GM"-> Set("ASP")))

    assert(r2.contains("PG", 1))

    assert(r2.contains("SB", 1))

    assert(r2.contains("BW"-> Set("ASP", "GVL", "CON")))

    assert(r2.contains("MV"-> Set("CON", "BIT", "ASP")))

    assert(r2.contains("TT"-> Set("ASP")))

    assert(r2.contains("BO"-> Set("ASP", "UNK", "CON", "GRE")))

    assert(r2.contains("NI"-> Set("ASP", "CON")))

    assert(r2.contains("TL"-> Set("ASP", "Grass")))

    assert(r2.contains("NG"-> Set("ASP", "LAT", "CON")))

    assert(r2.contains("SZ"-> Set("ASP")))

    assert(r2.contains("IO"-> Set("CON")))

    assert(r2.contains("BI"-> Set("UNK", "ASP")))

    assert(r2.contains("GI"-> Set("ASP")))

    assert(r2.contains("CC"-> Set("ASP")))

    assert(r2.contains("KM"-> Set("ASP", "UNK")))

    assert(r2.contains("IR"-> Set("ASP", "GRE", "CON", "PEM")))

    assert(r2.contains("BN"-> Set("ASP")))

    assert(r2.contains("HN"-> HashSet("GRASS", "ASP", "CON", "GRVL-GRASS", "GRVL")))

    assert(r2.contains("GP"-> Set("ASP"))

    assert(r2.contains("GD"-> Set("ASP", "UNK")))

    assert(r2.contains("BA"-> Set("GRASS", "ASP", "Grass")))

    assert(r2.contains("ER"-> Set("ASP", "CON")))

    assert(r2.contains("MH"-> Set("GRVL", "ASP")))

    assert(r2.contains("GW"-> Set("ASP", "BIT")))

    assert(r2.contains("MF"-> Set("ASP")))

    assert(r2.contains("VN"-> Set("ASP", "CON", "UNK")))

    assert(r2.contains("BY"-> Set("ASP", "CON")))

    assert(r2.contains("AS"-> Set("CONC-G", "CON", "ASP")))

    assert(r2.contains("WF"-> Set("UNK", "ASP")))

    assert(r2.contains("ES"-> HashSet("Asphalt", "ASP", "concrete", "GRE", "CON", "UNK", "ASPHALT", "GRS")))

    assert(r2.contains("NZ", 1))

    assert(r2.contains("LC"-> Set("ASP")))

    assert(r2.contains("GA"-> Set("ASP", "LAT", "UNK")))

    assert(r2.contains("TZ"-> HashSet("Hard", "ASP", "GRE", "UNK", "BIT")))

    assert(r2.contains("SG"-> Set("ASP", "GRS")))

    assert(r2.contains("SO"-> Set("sand", "ASP", "UNK")))

    assert(r2.contains("CI"-> Set("ASP", "UNK", "CON")))

    assert(r2.contains("CM"-> Set("UNK", "ASP")))

    assert(r2.contains("LT", 1))

    assert(r2.contains("GN"-> Set("ASP", "UNK")))

    assert(r2.contains("BJ"-> Set("ASP", "UNK")))

    assert(r2.contains("CU"-> Set("CON", "ASP")))

    assert(r2.contains("AE" -> HashSet("Asphalt", "ASP", "UNK", "MAC", "U")))

    assert(r2.contains("ID", 1))

    assert(r2.contains("CY"-> Set("concrete", "ASP")))

    assert(r2.contains("MA"-> Set("ASP", "BIT", "UNK", "CON")))

    assert(r2.contains("QA"-> Set("ASP", "Asphalt")))

    assert(r2.contains("YT"-> Set("ASP")))

    assert(r2.contains("FM"-> Set("ASP"))

    assert(r2.contains("KY"-> Set("ASP")))

    assert(r2.contains("ME"-> Set("GRS", "ASP")))

    assert(r2.contains("FI", 1))

    assert(r2.contains("TN"-> Set("ASP", "PEM", "CON")))

    assert(r2.contains("TJ"-> Set("ASP", "CON")))

    assert(r2.contains("TF"-> Set("dirt")))

    assert(r2.contains("KR"-> HashSet("PEM", "concrete", "GRE", "CON", "UNK", "BIT", "GVL", "GRS", "Graded earth", "ASP")))

    assert(r2.contains("GB", 1))

    assert(r2.contains("AW"-> Set("ASP")))

    assert(r2.contains("PF"-> Set("ASP", "UNK", "BIT", "COR")))

    assert(r2.contains("MN"-> HashSet("ASP", "GRE", "CON", "UNK", "BIT")))

    assert(r2.contains("PK"-> HashSet("PEM", "ASP", "MAC", "GRE", "CON", "UNK", "'asphalt'", "GVL", "BIT", "SAN")))

    assert(r2.contains("PS"-> Set("ASP")))

    assert(r2.contains("BZ"-> Set("ASP")))

    assert(r2.contains("BD"-> Set("ASP", "PEM", "CON")))

    assert(r2.contains("SK"-> HashSet("ASP", "CON", "UNK", "grass", "GRS")))

    assert(r2.contains("BR", 1))

    assert(r2.contains("UY"-> HashSet("PEM", "ASP", "CON", "UNK", "GRS")))

    assert(r2.contains("SC"-> Set("CON", "ASP")))

    assert(r2.contains("TW"-> Set("UNK", "ASP", "CON", "PEM")))

    assert(r2.contains("CX"-> Set("ASP")))

    assert(r2.contains("KP"-> Set("CON", "ASP", "GRS")))

    assert(r2.contains("DE", 1))

    assert(r2.contains("AZ"-> Set("CON", "ASP")))

    assert(r2.contains("ML"-> HashSet("Brown clay gravel", "ASP", "UNK", "LAT", "GVL")))

    assert(r2.contains("KE"-> Set("ASP", "BIT", "UNK", "GRE")))

    assert(r2.contains("AR"-> HashSet("ASP", "STONE", "GRE", "CON", "UNK", "Concrete", "MET")))

    assert(r2.contains("NR" -> Set("ASP")))

    assert(r2.contains("MZ"-> Set("BIT", "ASP", "SAN", "GVL")))

    assert(r2.contains("VG"-> Set("UNK", "ASP")))

    assert(r2.contains("CL", 1))

    assert(r2.contains("KS"-> Set("ASP")))

    assert(r2.contains("LA"-> Set("ASP", "CON", "COP")))

    assert(r2.contains("CH"-> HashSet("GRASS", "ASP", "concrete", "CON", "UNK", "CAUTION: ATC do NOT apply wake turbulence separation ! GRS.", "asphalt", "GRS", "CONC", "CONCRETE", "ASPH")))

    assert(r2.contains("IQ"-> HashSet("PEM", "ASP", "U", "CON", "UNK", "GRE", "Asphaltic Concrete")))

    assert(r2.contains("SX"-> Set("ASP", "ASPH-CONC")))

    assert(r2.contains("KW"-> Set("PEM", "ASP", "CON")))

    assert(r2.contains("SV"-> Set("ASP")))

    assert(r2.contains("PT"-> HashSet("asph", "ASP", "CON", "UNK", "GRAV", "asphalt", "grav", "GVL")))

    assert(r2.contains("NF"-> Set("ASP")))

    assert(r2.contains("IN", 1))

    assert(r2.contains("VI"-> Set("ASP", "WATER")))

    assert(r2.contains("DK"-> HashSet("PEM", "ASP", "GRE", "UNK", "grass", "GRS", "Grass")))

    assert(r2.contains("DO"-> Set("ASP", "UNK", "asphalt")))

    assert(r2.contains("SD"-> HashSet("gravel", "Asphalt", "ASP", "UNK", "GVL", "graded earth")))

    assert(r2.contains("PY" -> Set("ASP", "UNK", "CON")))

    assert(r2.contains("PL"-> HashSet("PEM", "ASP", "CON", "UNK", "asphalt", "grass", "Brick", "GRS", "Grass")))

    assert(r2.contains("VU", 1))

    assert(r2.contains("SL"-> Set("ASP")))

    assert(r2.contains("RE"-> Set("ASP")))

    assert(r2.contains("MS"-> Set("ASP")))

    assert(r2.contains("TD" -> Set("UNK", "ASP")))

    assert(r2.contains("BG" -> HashSet("PEM", "ASP", "concrete", "GRE", "CON")))

    assert(r2.contains("CF" -> Set("ASP", "UNK")))

    assert(r2.contains("HR" -> HashSet("PEM", "ASP", "GRE", "CON", "UNK", "grass")))

    assert(r2.contains("DJ"-> Set("PEM")))

    assert(r2.contains("PM"-> Set("ASP")))

    assert(r2.contains("TC"-> Set("ASP", "UNK")))

    assert(r2.contains("MO"-> Set("CON")))

    assert(r2.contains("RO"-> HashSet("ASP", "CON", "UNK", "grass", "Grass")))

    assert(r2.contains("GT"-> Set("ASP", "CON", "Dirt/Gravel")))

    assert(r2.contains("AF" -> HashSet("GRV", "ASP", "CON", "CONCRETE AND ASP", "GVL")))

    assert(r2.contains("TG"-> Set("CON", "ASP")))

    assert(r2.contains("UG"-> Set("GRE", "ASP", "UNK"))

    assert(r2.contains("UM"-> Set("ASP", "UNK")))

    assert(r2.contains("JM"-> Set("ASP")))

    assert(r2.contains("BM"-> Set("ASP")))

    assert(r2.contains("US", 1))

    assert(r2.contains("PE"-> Set("ASP", "UNK", "CON")))

    assert(r2.contains("TO"-> Set("ASP", "GRS", "BIT", "UNK")))

    assert(r2.contains("SR"-> Set("ASPHALT"))

    assert(r2.contains("LB"-> Set("CON", "ASP")))

    assert(r2.contains("MR"-> Set("BIT", "ASP", "MAC")))

    assert(r2.contains("EE"-> Set("CON", "ASP", "GRS")))

    assert(r2.contains("VC"-> Set("ASP")))

    assert(r2.contains("SH"-> Set("ASP")))

    assert(r2.contains("UZ"-> Set("CON", "ASP")))

    assert(r2.contains("HK"-> Set("ASP", "Asphalt")))

    assert(r2.contains("RS"-> HashSet("ASP", "Paved", "grass", "GRS", "Grass")))

    assert(r2.contains("ZW"-> HashSet("ASP", "MAC", "GRE", "BIT", "GRS")))



































  }

  test("testGetTenCountriesHighestNumberOfAirports") {
    val a2 = getTenCountriesHighestNumberOfAirports(airports)

    assert(a2!=null)
    assert(a2.size == 10)

    assert(a2.contains("US" -> 21501))
    assert(a2.contains("BR" -> 3839))
    assert(a2.contains("CA" -> 2454))
    assert(a2.contains("AU" -> 1908))
    assert(a2.contains("RU" -> 920))
    assert(a2.contains("FR" -> 789))
    assert(a2.contains("AR" -> 713))
    assert(a2.contains("DE" -> 703))
    assert(a2.contains("CO" -> 700))
    assert(a2.contains("VE" -> 592))

  }

}
