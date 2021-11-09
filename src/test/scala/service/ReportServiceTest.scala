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

    assert(a1.map("BL" -> 1))
    assert(a1.map("AI" -> 1))
    assert(a1.map("TV" -> 1))
    assert(a1.map("CW" -> 1))
    assert(a1.map("MQ" -> 1))
    assert(a1.map("JE" -> 1))
    assert(a1.map("NU" -> 1))
    assert(a1.map("ZZ" -> 1))
    assert(a1.map("VA" -> 1))
    assert(a1.map("GM" -> 1))

  }

  test("testGetTypeOfRunwaysPerCountry") {

    val r2 = getTypeOfRunwaysPerCountry(airports, runways)

    assert(r2!=null)
    assert(r2.size == 236)

    assert(r2.contains("GR"-> Set("ASP", "UNK", "PEM")))

    assert(r2.map("LY"-> HashSet("COP", "ASP", "CON", "SAN", "GVL")))

    assert(r2.contains("LU"-> Set("PEM", "grass")))

    assert(r2.contains("OM"-> Set("ASP", "GVL", "GRE")))

    assert(r2.contains("GF"-> Set("ASP", "CON")))

    assert(r2.contains("SE"-> HashSet("PEM", "Asphalt", "ASP", "GRE", "CON", "UNK", "Gravel", "Pavement", "grass", "GRS", "Grass")))

    assert(r2.contains("CG"-> Set("ASP", "UNK")))

    assert(r2.map("CO"-> Set("ASP", "UNK", "CON", "GRE")))

    assert(r2.contains("MD"-> Set("CON", "grass")))

    assert(r2.contains("MY"-> Set("ASP", "GRE", "paved")))

    assert(r2.map("NC"-> HashSet("Asphalt", "ASP", "MAC", "UNK", "Paved/Gravel", "Paved/Compacted schist")))

    assert(r2.contains("FK"-> Set("ASP")))

    assert(r2.contains("AI"-> Set("ASP")))

    assert(r2.map("CK"-> Set("COR", "ASP", "UNK", "CON")))

    assert(r2.contains("GY"-> Set("ASP", "concrete")))

    assert(r2.map("IT"-> HashSet("ground", "ASP", "concrete", "GRE", "UNK", "asphalt", "BIT", "grass", "BITUMINOUS", "dirt", "GRS", "Grass")))

    assert(r2.contains("GG"-> Set("GRE", "ASP")))

    assert(r2.contains("NP"-> Set("ASP", "UNK", "asphalt")))

    assert(r2.map("MX"-> HashSet("paved", "Soil", "Asphalt", "ASP", "GRE", "CON", "UNK", "asphalt", "ASPHALTH", "packed dirt", "concrete")))

    assert(r2.contains("TV"-> Set("UNK")))

    assert(r2.contains("BQ"-> Set("ASP")))

    assert(r2.contains("LR"-> Set("ASP")))

    assert(r2.contains("IM"-> Set("ASP")))

    assert(r2.map("PR"-> HashSet("TURF", "ASPH-CONC", "ASP", "CON", "ASPH-G", "ASPH-F", "WATER", "ASPH")))

    assert(r2.contains("CW" -> Set("ASP")))

    assert(r2.contains("RW"-> Set("ASP", "'asphalt'", "grass")))

    assert(r2.contains("BT"-> Set("BIT", "Asphalt", "ASP")))

    assert(r2.contains("LS"-> Set("ASP", "GRE")))

    assert(r2.map("DZ"-> HashSet("PEM", "ASP", "GRE", "CON", "UNK", "BIT", "SAN")))

    assert(r2.contains("BF"-> Set("ASP", "LAT")))

    assert(r2.contains("PW"-> Set("GRVL-F", "GRAVEL-F", "ASP")))

    assert(r2.contains("EC"-> Set("ASP", "UNK", "Paviment hard")))

    assert(r2.map("MG"-> Set("PEM", "ASP", "COP", "BIT")))

    assert(r2.contains("LV"> Set("ASP", "PEM", "CON")))

    assert(r2.contains("MQ"-> Set("ASP")))

    assert(r2.map("GL"-> HashSet("ICE", "ASP", "CON", "UNK", "GVL", "ASPH")))

    assert(r2.contains("KI"-> Set("BIT", "COR", "ASP")))

    assert(r2.map("SA"-> HashSet("ASP", "CON", "UNK", "BIT", "SAN")))

    assert(r2.contains("BH"-> Set("ASP")))

    assert(r2.contains("ET"-> Set("ASP", "PEM", "CON")))

    assert(r2.contains("GU"-> Set("PEM", "ASP")))

    assert(r2.contains("JE"-> Set("ASP")))

    assert(r2.contains("EH"-> Set("ASP")))

    assert(r2.map("MK"-> Set("GRE", "GRS", "CON", "ASP")))

    assert(r2.map("SI"-> HashSet("ASP", "concrete", "asphalt", "grass", "GRS")))

    assert(r2.map("CA"-> HashSet("GRAVEL/GRASS", "TURF/GRAVEL/CL", "CLAY/GRAVEL", "GVL", "SAND/CLAY/GRAV", "CLAY/GRVL", "turf", "gravel", "TURF", "TREATED GRAVEL", "Turf / Gravel", "EARTH", "COM", "Gravel/Asphalt mix", "paved", "water", "PEM", "TURF/EARTH/GRA", "COP", "Asphalt/Turf", "GRAVEL/TURF", "GRVL/TURF", "Turf/Snow", "GRASS", "TURF/GRAVEL/AS", "Stone Dust", "Asphalt", "TURF/CLAY", "GRAVEL/SAND/CL", "GRASS/GRAVEL", "OILED GRAVEL/T", "TURF/OIL PACKE", "Turf", "TURF/GRAVEL/SN", "TURF/SOIL", "CLAY", "OILED", "ASP", "TURF/SNOW", "OLD ASP", "EARTH/SNOW", "OILED GRAVEL", "GRAVEL/SAND", "TURF/ASPHALT", "EARTH/TURF", "TRTD GRVL", "SAND/GRVL", "TURF/CHIPSEAL", "GRE", "TURF/GRAVEL", "DIRT", "GRAVEL/CLAY", "SAND/GRAVEL", "CON", "dirt, No winter maint.", "UNK", "CLAY/SAND", "ASPHALT", "SAND", "Gravel", "Gravel/Snow", "TREATED SAND", "asphalt/gravel", "SAND/GRAVEL/AS", "CONC/GRVL", "Turf, soft during spring thaw", "GRAVEL", "GRAVEL/CLAY/SA", "asphalt", "GRVL/ASP", "Turf / Snow", "CRUSHED ROCK", "TURF/ASP", "CLAY/GRAVEL/TU", "asp", "TURF/EARTH", "TURF/GRVL", "LOOSE GRAVEL", "GRVL/CLAY", "SAN", "SNOW", "PACKED GRAVEL", "TURF/TREATED G", "SOFT SAND", "CLAY/TURF", "GRASS/SNOW", "GRVL", "ASP/TURF", "grass", "Ice", "ASPHALT/TURF", "GRS", "Sand", "Grass", "GRASS&amp;GRAVEL", "ASPH")))

    assert(r2.contains("NU"-> Set("ASP")))

    assert(r2.contains("MU"-> Set("ASP")))

    assert(r2.contains("AO"-> Set("ASP", "UNK")))

    assert(r2.map("AQ"-> Set("SNO", "ICE", "GRE", "ice")))

    assert(r2.contains("TH"-> Set("ASP", "CON")))

    assert(r2.map("PH"-> HashSet("PEM", "COP", "ASP", "Paved", "CON", "dirt", "Concrete", "BIT", "ASP/CON")))

    assert(r2.contains("SS"-> Set("Asphalt", "ASP", "UNK")))

    assert(r2.map("UA"-> HashSet("PEM", "ASP", "GRE", "BRI", "CON", "UNK", "GRS")))

    assert(r2.map("TR"-> HashSet("Asphalt", "ASP", "concrete", "CON", "PER", "Concrete", "CONCRETE")))

    assert(r2.contains("BB"-> Set("ASP")))

    assert(r2.contains("AG"-> Set("ASP")))

    assert(r2.map("SY"-> HashSet("PEM", "ASP", "GRE", "CON", "UNK", "SAN")))

    assert(r2.map("NO"-> HashSet("Asphalt", "ASP", "CON", "UNK", "Gravel", "Concrete", "Gravel/Grass", "Ice - frozen lake", "Ice", "Grass")))

    assert(r2.map("ZA"-> HashSet("gravel", "Grass/Concrete", "Asphalt", "Soil, rough gravel", "grass, use at own risk, animals may errode surface", "tar", "GRE", "CON", "UNK", "Gravel", "LAT", "asphalt", "hard", "COM", "Tar", "paving", "ASP", "dirt, use at own risk, animals may errode surface", "tar old", "Tar - lights 5 clicks on 124.8", "GVL", "GRS", "Grass")))

    assert(r2.contains("LK"-> Set("ASP", "Asphalt")))

    assert(r2.contains("FJ"-> Set("ASP", "UNK")))

    assert(r2.map("FR"-> HashSet("GRASS", "Asphalt", "Unpaved", "Paved", "CON", "grass - herbe  (avion)", "CONCRETE", "paved", "PEM", "UNPAVED", "Turf", "ASP", "UnPaved", "grass - herbe  (planeur)", "MAC", "Grass - Herbe", "Unknown", "UNK", "Grass - Herbe -> Avion - ULM", "GRS", "Grass")))

    assert(r2.contains("HT"-> Set("ASP")))

    assert(r2.map("IE"-> HashSet("PEM", "GRASS", "ASP", "GRASS/HARDCORE", "Bituminous", "CON", "UNK", "BIT", "Grass", "ASPH")))

    assert(r2.contains("YE"-> Set("ASP", "UNK")))

    assert(r2.map("SN"-> Set("SAN", "ASP", "GRE", "MAC")))

    assert(r2.contains("GH"-> Set("ASP")))

    assert(r2.contains("FO"-> Set("ASP")))

    assert(r2.contains("GQ"-> Set("ASP", "UNK", "CON")))

    assert(r2.contains("PA"-> Set("ASP", "CON", "Asphalt")))

    assert(r2.contains("DM"-> Set("ASP")))

    assert(r2.contains("TM"-> Set("ASP", "CON")))

    assert(r2.contains("MP"-> Set("ASP", "PEM", "TURF-GRVL")))

    assert(r2.contains("MT"-> Set("ASP")))

    assert(r2.contains("IL"-> Set("ASP", "PEM", "Asphalt")))

    assert(r2.map("CZ"-> HashSet("Asphalt", "ASP", "CON", "UNK", "grass", "GRS", "Grass")))

    assert(r2.map("AU"-> HashSet("COP", "NSGG", "X", "GRE", "N", "CON", "XU", "XSA", "GVL", "gravel", "TURF", "COM", "GG", "paved", "PEM", "unsealed", "Asphalt", "Grass and granite sand", "ASP", "B", "sealed", "S", "SU", "UNK", "NRC", "XS", "CLA", "dirt", "PER", "Gravel", "XUG", "G", "BIT", "SAN", "L", "Grass/Gravel", "C", "grass", "UG", "Grass", "Earth/sand", "GRS", "H", "NW")))

    assert(r2.contains("CV"-> Set("ASP", "UNK")))

    assert(r2.contains("KN"-> Set("ASP")))

    assert(r2.contains("AM"-> Set("paved", "CON", "ASP")))

    assert(r2.contains("GE"-> Set("CON", "ASP")))

    assert(r2.contains("BS"-> Set("BIT", "ASP", "ASPH")))

    assert(r2.map("KG"-> HashSet("ASP", "concrete", "ASB", "CON", "asphalt")))

    assert(r2.map("CD"-> HashSet("PEM", "Dirt", "ASP", "CON", "LAT", "GVL")))

    assert(r2.contains("CR" -> Set("ASP", "CON", "UNK")))

    assert(r2.contains("NE" -> Set("ASP", "UNK", "LAT")))

    assert(r2.contains("NA"-> Set("ASP", "GVL", "UNK")))

    assert(r2.contains("WS"-> Set("ASP")))

    assert(r2.map("VE"-> Set("ASP", "CON", "UNK", "CONCRETE")))

    assert(r2.contains("JO"-> Set("ASP", "CON")))

    assert(r2.map("CN"-> HashSet("paved", "Asphalt", "ASP", "concrete", "CON", "UNK", "Concrete")))

    assert(r2.contains("MW"-> Set("ASP", "GRS", "BIT")))

    assert(r2.map("IS"-> Set("ASP", "BIT", "UNK", "ASPH-G")))

    assert(r2.map("ZM"-> HashSet("ASP", "BRI", "CON", "UNK", "Gravel", "BIT", "GRS")))

    assert(r2.map("KZ"-> HashSet("PEM", "ASP", "GRE", "CON", "asphalt", "GRS")))

    assert(r2.map("HU"-> HashSet("ASP", "concrete", "GRE", "CON", "UNK", "Concrete", "grass", "GRS", "Grass")))

    assert(r2.map("BE"-> HashSet("PEM", "ASP", "CON", "UNK", "grass", "GRS", "Grass")))

    assert(r2.map("AT" -> HashSet("GRASS", "CLOSED", "ASP", "CON", "ASPHALT", "GRS")))

    assert(r2.contains("ST"-> Set("ASP")))

    assert(r2.map("NL" -> HashSet("PEM", "grass, first 500x6 meter on 25 is paved", "ASP", "CON", "asphalt", "grass", "ASPH")))

    assert(r2.map("KH"-> HashSet("ASP", "CON", "UNK", "GVL", "GRS")))

    assert(r2.contains("MM"-> Set("CON", "ASP", "BIT")))

    assert(r2.map("JP"-> HashSet("PEM", "ASP", "GRE", "CON", "UNK", "PSP", "GRS", "COR", "U", "concrete")))

    assert(r2.map("AL"-> HashSet("paved", "ASP", "GRE", "CON", "GRS")))

    assert(r2.contains("EG"-> Set("ASP", "Asphalt", "UNK")))

    assert(r2.map("RU"-> HashSet("PEM", "Asphalt", "ASP", "concrete", "GRE", "CON", "UNK", "Concrete", "Ground", "'concrete'", "grass", "GRS", "Grass")))

    assert(r2.contains("GM"-> Set("ASP")))

    assert(r2.map("PG"-> HashSet("Grey gravel", "White gravel", "Brown Silt clay", "Grassed limestone gravel", "Grassed grey silt sand", "Grassed river gravel", "Sandy gravel with clay", "Grassed white coronas", "Grassed red clay", "Grassed brown clay gravel", "Grassed brown silty clay", "Red silt clay", "Grassed black silt", "Black silt", "Grassed Brown Clay", "Grey clay", "Grassed grey silt clay", "Yellow gravel", "Grassed sand clay", "Clay", "Grassed brown silt clay", "Grassed Red Clay", "Brown clay gravel", "Grassed black clay", "Grassed blackclay", "Brown clay", "Hard loam", "Red gravel", "Grassed yellow gravel", "Grassed brown silt loam", "Grassed white lime stone", "Grassed brown loam", "Grass red silty clay", "ASP", "Grassed brown gravel", "Red clay", "Black clay", "Grassed clay silt clay", "Grassed grey sand", "Red clay gravel", "Grassed yellow clay", "GRE", "Grass/gravel", "Grassed red silt clay", "Grassed clay", "Grassed gravel", "Grassed silt clay", "UNK", "Grassed yellow silt clay", "Grassed black clay silt", "Grassed brown clay", "Grassed black sand", "Brown silt clay", "Grassed grey clay", "Grassed red silty clay", "Gravel", "Grassed black silt clay", "Grey silt clay", "Grassed red silt", "Grassed red clay gravel", "Grassed black silt sand", "Grassed black clay sand", "Grassed brown sandy clay", "Grassed black soil", "Brown gravel", "Grassed sandy loam", "Grassed white gravel", "GVL", "GRS", "Grassed grey gravel", "Grassed Sand", "Grassed red silt sand")))

    assert(r2.map("SB"-> HashSet("Limestone/Grass", "Crushed coral", "Coral grass", "grass coral", "Sand/grass", "UNK", "Sand grass", "Coral", "Gravel dirt", "Soil and Grass", "Grass", "Coral sand", "Graded earth", "ASP")))

    assert(r2.contains("BW"-> Set("ASP", "GVL", "CON")))

    assert(r2.contains("MV"-> Set("CON", "BIT", "ASP")))

    assert(r2.contains("TT"-> Set("ASP")))

    assert(r2.map("BO"-> Set("ASP", "UNK", "CON", "GRE")))

    assert(r2.contains("NI"-> Set("ASP", "CON")))

    assert(r2.contains("TL"-> Set("ASP", "Grass")))

    assert(r2.contains("NG"-> Set("ASP", "LAT", "CON")))

    assert(r2.contains("SZ"-> Set("ASP")))

    assert(r2.contains("IO"-> Set("CON")))

    assert(r2.contains("BI"-> Set("UNK", "ASP")))

    assert(r2.contains("GI"-> Set("ASP")))

    assert(r2.contains("CC"-> Set("ASP")))

    assert(r2.contains("KM"-> Set("ASP", "UNK")))

    assert(r2.map("IR"-> Set("ASP", "GRE", "CON", "PEM")))

    assert(r2.contains("BN"-> Set("ASP")))

    assert(r2.map("HN"-> HashSet("GRASS", "ASP", "CON", "GRVL-GRASS", "GRVL")))

    assert(r2.contains("GP"-> Set("ASP")))

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

    assert(r2.map("ES"-> HashSet("Asphalt", "ASP", "concrete", "GRE", "CON", "UNK", "ASPHALT", "GRS")))

    assert(r2.map("NZ"-> HashSet("ASP", "concrete", "GRE", "CON", "UNK", "Sealed", "bitumen/gravel", "Bitumen", "BIT", "GVL", "COM", "paved", "GRS", "Grass")))

    assert(r2.contains("LC"-> Set("ASP")))

    assert(r2.contains("GA"-> Set("ASP", "LAT", "UNK")))

    assert(r2.map("TZ"-> HashSet("Hard", "ASP", "GRE", "UNK", "BIT")))

    assert(r2.contains("SG"-> Set("ASP", "GRS")))

    assert(r2.contains("SO"-> Set("sand", "ASP", "UNK")))

    assert(r2.contains("CI"-> Set("ASP", "UNK", "CON")))

    assert(r2.contains("CM"-> Set("UNK", "ASP")))

    assert(r2.map("LT"-> HashSet("paved", "GRASS", "ASP", "concrete", "CON", "UNK", "Grass", "Asphalt", "GRASS OR EARTH NOT GRADED OR ROLLED")))

    assert(r2.contains("GN"-> Set("ASP", "UNK")))

    assert(r2.contains("BJ"-> Set("ASP", "UNK")))

    assert(r2.contains("CU"-> Set("CON", "ASP")))

    assert(r2.map("AE" -> HashSet("Asphalt", "ASP", "UNK", "MAC", "U")))

    assert(r2.map("ID"-> HashSet("Dirt/grass", "PEM", "Dirt/rock", "Sod with gravel & sand", "Gravel", "Grass/dirt", "Sand/clay", "Grass/Clay", "grass", "Rocky gravel", "Hard mud", "Grass/rolled earth", "Grass/clay", "Grass/sandy soil", "Gravel/soil", "Gravel/grass, First 410m of RWY 23 paved", "Clay", "Asphalt", "Hard clay", "Grass over hard gravel", "Graded earth", "Grass/red clay", "ASP", "Asphalt/Concrete", "Gravel/clay", "Grass over rock", "ASPH/CONC", "Coral penetration", "Sand/grass", "Asphalt concrete", "Clay/grass", "GRE", "Grass/gravel", "CON", "Compacted sand", "Grass over gravel", "Compacted coral and sand", "Asphalt/Grass", "Grass/Moss", "ASPHALT", "Gravel/dirt", "asphalt", "Sand laterite", "Gravel/grass", "Coral", "Rock/Gravel/Clay", "Sod over hard clay", "Grass Dirt", "GVL", "GRS", "Grass")))

    assert(r2.contains("CY"-> Set("concrete", "ASP")))

    assert(r2.map("MA"-> Set("ASP", "BIT", "UNK", "CON")))

    assert(r2.contains("QA"-> Set("ASP", "Asphalt")))

    assert(r2.contains("YT"-> Set("ASP")))

    assert(r2.contains("FM"-> Set("ASP")))

    assert(r2.contains("KY"-> Set("ASP")))

    assert(r2.contains("ME"-> Set("GRS", "ASP")))

    assert(r2.map("FI"-> HashSet("COM", "COP", "GRASS", "Asphalt", "GRVL/GRASS", "Oilgravel", "GVL", "Sand", "ASPH", "ASPH/GRASS", "ASPH/GRVL", "ASP", "Oligravel/GRVL", "Oilgravel/sand", "sand/grass", "GRVL", "grass")))

    assert(r2.contains("TN"-> Set("ASP", "PEM", "CON")))

    assert(r2.contains("TJ"-> Set("ASP", "CON")))

    assert(r2.contains("TF"-> Set("dirt")))

    assert(r2.map("KR"-> HashSet("PEM", "concrete", "GRE", "CON", "UNK", "BIT", "GVL", "GRS", "Graded earth", "ASP")))

    assert(r2.map("GB"-> HashSet("Grass/Helipads Concrete", "PEM", "GRASS", "Asphalt", "Grass/Graded Hardcore", "U", "GRE", "CON", "Gravel", "Concrete", "Graded Hardcore", "grass", "Grass/Asphalt", "TURF", "Concrete/Asphalt", "ASP", "Tarmac", "UNK", "SAND", "Grass/Asphalt Insert 1968X59 Feet", "Concrete/Grass", "asphalt", "GRS", "Grass")))

    assert(r2.contains("AW"-> Set("ASP")))

    assert(r2.map("PF"-> Set("ASP", "UNK", "BIT", "COR")))

    assert(r2.map("MN"-> HashSet("ASP", "GRE", "CON", "UNK", "BIT")))

    assert(r2.map("PK"-> HashSet("PEM", "ASP", "MAC", "GRE", "CON", "UNK", "'asphalt'", "GVL", "BIT", "SAN")))

    assert(r2.contains("PS"-> Set("ASP")))

    assert(r2.contains("BZ"-> Set("ASP")))

    assert(r2.contains("BD"-> Set("ASP", "PEM", "CON")))

    assert(r2.map("SK"-> HashSet("ASP", "CON", "UNK", "grass", "GRS")))

    assert(r2.map("BR"-> HashSet("GRV", "GRASS", "ASP/GRE", "MET/CON", "GRVL/PIÇ", "ASP", "CON", "UNK", "Gravel", "CON/MET", "MTAL", "GRAVEL", "ARG", "conc", "MET", "GVL", "PIÇ", "PIC", "SAI", "Asphalt", "ASP/GRS", "GRE", "TER", "GRE/GRS", "SAND", "CONC/MTAL", "WOOD", "GRVL", "CON/GRS", "GRS", "CON/ASP", "Grass", "CONC", "ASPH")))

    assert(r2.map("UY"-> HashSet("PEM", "ASP", "CON", "UNK", "GRS")))

    assert(r2.contains("SC"-> Set("CON", "ASP")))

    assert(r2.map("TW"-> Set("UNK", "ASP", "CON", "PEM")))

    assert(r2.contains("CX"-> Set("ASP")))

    assert(r2.contains("KP"-> Set("CON", "ASP", "GRS")))

    assert(r2.map("DE"-> HashSet("TURF", "PEM", "Asphalt", "ASP", "Paved", "CON", "UNK", "ASPHALT", "Concrete", "asphalt", "ASPH", "gras", "GRASS", "U", "concrete", "CONCRETE + GRASS. MTOM 2t", "grass", "GRS", "Grass")))

    assert(r2.contains("AZ"-> Set("CON", "ASP")))

    assert(r2.map("ML"-> HashSet("Brown clay gravel", "ASP", "UNK", "LAT", "GVL")))

    assert(r2.map("KE"-> Set("ASP", "BIT", "UNK", "GRE")))

    assert(r2.map("AR"-> HashSet("ASP", "STONE", "GRE", "CON", "UNK", "Concrete", "MET")))

    assert(r2.contains("NR" -> Set("ASP")))

    assert(r2.map("MZ"-> Set("BIT", "ASP", "SAN", "GVL")))

    assert(r2.contains("VG"-> Set("UNK", "ASP")))

    assert(r2.map("CL"-> HashSet("GRV", "GRASS", "PAD/CON", "CLAY", "GRAIN", "ASP", "GRV/ASP", "SAND/GRASS", "CON", "GRV/PAD", "CON/PAD", "BIT", "GRV/MAICILLO", "GVL", "GRE", "PAD/GRASS", "GRASS/PAD", "UNK", "GRV/GRASS", "PAD")))

    assert(r2.contains("KS"-> Set("ASP")))

    assert(r2.contains("LA"-> Set("ASP", "CON", "COP")))

    assert(r2.map("CH"-> HashSet("GRASS", "ASP", "concrete", "CON", "UNK", "CAUTION: ATC do NOT apply wake turbulence separation ! GRS.", "asphalt", "GRS", "CONC", "CONCRETE", "ASPH")))

    assert(r2.map("IQ"-> HashSet("PEM", "ASP", "U", "CON", "UNK", "GRE", "Asphaltic Concrete")))

    assert(r2.contains("SX"-> Set("ASP", "ASPH-CONC")))

    assert(r2.contains("KW"-> Set("PEM", "ASP", "CON")))

    assert(r2.contains("SV"-> Set("ASP")))

    assert(r2.map("PT"-> HashSet("asph", "ASP", "CON", "UNK", "GRAV", "asphalt", "grav", "GVL")))

    assert(r2.contains("NF"-> Set("ASP")))

    assert(r2.map("IN"-> HashSet("PAVED", "Dirt", "ASP", "MAC", "GRE", "CON", "UNK", "ASPHALT", "Concrete", "grass/concrete", "Bitumen", "asphalt", "BIT", "GVL", "COM", "paved", "PEM", "GRS", "Grass")))

    assert(r2.contains("VI"-> Set("ASP", "WATER")))

    assert(r2.map("DK"-> HashSet("PEM", "ASP", "GRE", "UNK", "grass", "GRS", "Grass")))

    assert(r2.contains("DO"-> Set("ASP", "UNK", "asphalt")))

    assert(r2.map("SD"-> HashSet("gravel", "Asphalt", "ASP", "UNK", "GVL", "graded earth")))

    assert(r2.contains("PY" -> Set("ASP", "UNK", "CON")))

    assert(r2.map("PL"-> HashSet("PEM", "ASP", "CON", "UNK", "asphalt", "grass", "Brick", "GRS", "Grass")))

    assert(r2.map("VU"-> HashSet("Grass on coral", "Asphalt", "Volcanic ash impregnated with bitumen", "ASP", "Volcanic ash/soil", "Coral", "GRS", "Grass")))

    assert(r2.contains("SL"-> Set("ASP")))

    assert(r2.contains("RE"-> Set("ASP")))

    assert(r2.contains("MS"-> Set("ASP")))

    assert(r2.contains("TD" -> Set("UNK", "ASP")))

    assert(r2.map("BG" -> HashSet("PEM", "ASP", "concrete", "GRE", "CON")))

    assert(r2.contains("CF" -> Set("ASP", "UNK")))

    assert(r2.map("HR" -> HashSet("PEM", "ASP", "GRE", "CON", "UNK", "grass")))

    assert(r2.contains("DJ"-> Set("PEM")))

    assert(r2.contains("PM"-> Set("ASP")))

    assert(r2.contains("TC"-> Set("ASP", "UNK")))

    assert(r2.contains("MO"-> Set("CON")))

    assert(r2.map("RO"-> HashSet("ASP", "CON", "UNK", "grass", "Grass")))

    assert(r2.contains("GT"-> Set("ASP", "CON", "Dirt/Gravel")))

    assert(r2.map("AF" -> HashSet("GRV", "ASP", "CON", "CONCRETE AND ASP", "GVL")))

    assert(r2.contains("TG"-> Set("CON", "ASP")))

    assert(r2.contains("UG"-> Set("GRE", "ASP", "UNK")))

    assert(r2.contains("UM"-> Set("ASP", "UNK")))

    assert(r2.contains("JM"-> Set("ASP")))

    assert(r2.contains("BM"-> Set("ASP")))

    assert(r2.map("US"HashSet("ASPH-TURF-F", "ASPH-DIRT-G", "MATS-G", "ASPH-TRTD", "turf", "ALUM", "ASPH-TURF-E", "TURF", "ASPH-GRVL-F", "ROOFTOP", "COM", "ASP/CONC", "PEM", "DECK", "GRAVEL-G", "ASPH-E", "COP", "TURF-TRTD-G", "ASPH-DIRT-P", "CONC-TRTD-G", "CONC-GRVL", "CORAL", "GRASS", "TREATED-E", "TURF-DIRT-F", "STEEL", "CONC-G", "Asphalt", "OIL&CHIP-T-G", "GRVL-E", "Water", "WATER-E", "ASPH-L", "TURF-GRVL-G", "Turf", "TURF-GRVL", "ICE", "ASPH-CONC-F", "GRAVEL-E", "ASPH-CONC", "GRVL-TURF-G", "ALUMINUM", "TRTD-DIRT-P", "OILED DIRT", "ASP", "ALUM-DECK", "DIRT-TURF-F", "GRVL-G", "TURF-G", "ASPH/CONC", "UNKNOWN", "TURF-E", "U", "DIRT-P", "GRVL-DIRT-E", "CONC-TURF-G", "concrete", "ASPH-P", "CONC-TURF", "GRE", "GRASS / SOD, GRAVEL", "TRTD-DIRT", "GRVL-F", "ASPH/GRVL-F", "TURF-DIRT-G", "DIRT", "CONC-GRVL-G", "TREATED", "DIRT-GRVL-F", "SOD", "CON", "TREATED-F", "DIRT-SAND", "CONC-F", "ASPH-GRVL", "TRTD", "DIRT-F", "Natural Soil", "ASPH-TURF-G", "UNK", "GRVL-TURF-F", "ASPH/ CONC", "None", "CLA", "SAND", "PER", "CONC-TURF-F", "BRICK", "ASPH-G", "GRAVEL, TRTD", "Gravel", "TURF-SAND-F", "GRAVEL, GRASS / SOD", "ASPH-TURF", "PSP", "DIRT-GRVL-P", "ASPH-GRVL-P", "TRTD-DIRT-F", "ASPH-GRVL-G", "ASPH-TRTD-G", "NEOPRENE", "GRAVEL", "GRVL-DIRT", "TURF-P", "WATER-G", "TREATED-G", "LAT", "CONC-E", "asphalt", "DIRT-GRVL-G", "DIRT-TRTD", "CONC-TRTD", "CALICHE", "GRAVEL-P", "PIERCED STEEL PLANKING / LANDING MATS / MEMBRANES", "DIRT-TURF-G", "DIRT-G", "GRVL-DIRT-P", "BIT", "NSTD", "WOOD", "GRVL-TRTD-F", "GRVL-TRTD", "ASPH-TURF-P", "STEEL-CONC", "ASPH-DIRT", "NATURAL SOIL", "SAND-F", "MATS", "ASPH-F", "DIRT-E", "GRVL", "C", "ASPH-CONC-P", "GRASS / SOD, NATURAL SOIL", "grass", "Conc", "GRASS / SOD", "GRVL-TURF", "DIRT-GRVL", "WATER", "ASPH-TRTD-P", "GRVL-DIRT-F", "GVL", "TURF-DIRT", "PFC", "ASPH-CONC-G", "TURF-F", "ROOF-TOP", "GRS", "TURF-GRVL-F", "GRVL-P", "Grass", "DIRT-TURF", "CONC", "TURF-GRVL-P", "GRAVEL-F", "CONC-P", "ASPH", "METAL", "TURF-DIRT-P", "GRVL-DIRT-G", "GRAVEL / CINDERS / CRUSHED ROCK / CORAL/SHELLS / SLAG", "GRVL-TURF-P", "GRVL-TRTD-P", "ASPH-TRTD-F", "COR", "GRASS-F", "NATURAL SOIL, GRASS / SOD")))

    assert(r2.contains("PE"-> Set("ASP", "UNK", "CON")))

    assert(r2.map("TO"-> Set("ASP", "GRS", "BIT", "UNK")))

    assert(r2.contains("SR"-> Set("ASPHALT")))

    assert(r2.contains("LB"-> Set("CON", "ASP")))

    assert(r2.contains("MR"-> Set("BIT", "ASP", "MAC")))

    assert(r2.contains("EE"-> Set("CON", "ASP", "GRS")))

    assert(r2.contains("VC"-> Set("ASP")))

    assert(r2.contains("SH"-> Set("ASP")))

    assert(r2.contains("UZ"-> Set("CON", "ASP")))

    assert(r2.contains("HK"-> Set("ASP", "Asphalt")))

    assert(r2.map("RS"-> HashSet("ASP", "Paved", "grass", "GRS", "Grass")))

    assert(r2.map("ZW"-> HashSet("ASP", "MAC", "GRE", "BIT", "GRS")))


  }

  test("testGetTenCountriesHighestNumberOfAirports") {
    val a2 = getTenCountriesHighestNumberOfAirports(airports)

    assert(a2!=null)
    assert(a2.size == 10)

    assert(a2.map("US" -> 21501))
    assert(a2.map("BR" -> 3839))
    assert(a2.map("CA" -> 2454))
    assert(a2.map("AU" -> 1908))
    assert(a2.map("RU" -> 920))
    assert(a2.map("FR" -> 789))
    assert(a2.map("AR" -> 713))
    assert(a2.map("DE" -> 703))
    assert(a2.map("CO" -> 700))
    assert(a2.map("VE" -> 592))

  }

}
