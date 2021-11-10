package service


import scala.collection.immutable.HashSet

class ReportServiceTest extends org.scalatest.FunSuite {
  val airportService = new AirportService
  val countryService = new CountryService
  val runwayService = new RunwayService
  val reportService = new ReportService

  val airports = airportService.convertFileToAirports("resources/airports.csv").toList

  val countries = countryService.convertFileToCountries("resources/countries.csv").toList

  val runways = runwayService.convertFileToRunways("resources/runways.csv").toList

  test("testGetTenMostCommonRunwaysLatitude") {
    val actual = reportService.getTenMostCommonRunwaysLatitude(runways)

    assert(actual!=null)
    assert(actual.size == 10)

    assert(actual.contains("\"18\""))
    assert(actual.contains("\"16\""))
    assert(actual.contains("\"15\""))
    assert(actual.contains("\"09\""))
    assert(actual.contains("\"12\""))
    assert(actual.contains("\"H1\""))
    assert(actual.contains("\"08\""))
    assert(actual.contains("\"17\""))
    assert(actual.contains("\"13\""))
    assert(actual.contains("\"14\""))

  }

  test("testGetTenCountriesLowestNumberOfAirports") {
    val actual = reportService.getTenCountriesLowestNumberOfAirports(airports)

    assert(actual!=null)
    assert(actual.size == 10)

    assert(actual.contains("\"BL\""))
    assert(actual.contains("\"AI\""))
    assert(actual.contains("\"TV\""))
    assert(actual.contains("\"CW\""))
    assert(actual.contains("\"MQ\""))
    assert(actual.contains("\"JE\""))
    assert(actual.contains("\"NU\""))
    assert(actual.contains("\"ZZ\""))
    assert(actual.contains("\"VA\""))
    assert(actual.contains("\"GM\""))

  }

  test("testGetTypeOfRunwaysPerCountry") {

    val actual = reportService.getTypeOfRunwaysPerCountry(airports, runways)

    assert(actual!=null)

    println("\n\n\n uuuuuuuuuuuuuu\n\n "+ (actual("\"GR\"") == (Set("ASP", "UNK", "PEM")))+"\n\n\nuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu")

    assert(actual("\"GR\"").equals(Set("ASP", "UNK", "PEM")))

    assert(actual("\"LY\"").equals(HashSet("COP", "ASP", "CON", "SAN", "GVL")))

    assert(actual("\"LU\"").equals(Set("PEM", "grass")))

    assert(actual("\"OM\"").equals(Set("ASP", "GVL", "GRE")))

    assert(actual("\"GF\"").equals(Set("ASP", "CON")))

    assert(actual("\"SE\"").equals(HashSet("PEM", "Asphalt", "ASP", "GRE", "CON", "UNK", "Gravel", "Pavement", "grass", "GRS", "Grass")))

    assert(actual("\"CG\"").equals(Set("ASP", "UNK")))

    assert(actual("\"CO\"").equals(Set("ASP", "UNK", "CON", "GRE")))

    assert(actual("\"MD\"").equals(Set("CON", "grass")))

    assert(actual("\"MY\"").equals(Set("ASP", "GRE", "paved")))

    assert(actual("\"NC\"").equals(HashSet("Asphalt", "ASP", "MAC", "UNK", "Paved/Gravel", "Paved/Compacted schist")))

    assert(actual("\"FK\"").equals(Set("ASP")))

    assert(actual("\"AI\"").equals(Set("ASP")))

    assert(actual("\"CK\"").equals(Set("COR", "ASP", "UNK", "CON")))

    assert(actual("\"GY\"").equals(Set("ASP", "concrete")))

    assert(actual("\"IT\"").equals(HashSet("ground", "ASP", "concrete", "GRE", "UNK", "asphalt", "BIT", "grass", "BITUMINOUS", "dirt", "GRS", "Grass")))

    assert(actual("\"GG\"").equals(Set("GRE", "ASP")))

    assert(actual("\"NP\"").equals(Set("ASP", "UNK", "asphalt")))

    assert(actual("\"MX\"").equals(HashSet("paved", "Soil", "Asphalt", "ASP", "GRE", "CON", "UNK", "asphalt", "ASPHALTH", "packed dirt", "concrete")))

    assert(actual("\"TV\"").equals(Set("UNK")))

    assert(actual("\"BQ\"").equals(Set("ASP")))

    assert(actual("\"LR\"").equals(Set("ASP")))

    assert(actual("\"IM\"").equals(Set("ASP")))

    assert(actual("\"PR\"").equals(HashSet("TURF", "ASPH-CONC", "ASP", "CON", "ASPH-G", "ASPH-F", "WATER", "ASPH")))

    assert(actual("\"CW\"").equals(Set("ASP")))

    assert(actual("\"RW\"").equals(Set("ASP", "'asphalt'", "grass")))

    assert(actual("\"BT\"").equals(Set("BIT", "Asphalt", "ASP")))

    assert(actual("\"LS\"").equals(Set("ASP", "GRE")))

    assert(actual("\"DZ\"").equals(HashSet("PEM", "ASP", "GRE", "CON", "UNK", "BIT", "SAN")))

    assert(actual("\"BF\"").equals(Set("ASP", "LAT")))

    assert(actual("\"PW\"").equals(Set("GRVL-F", "GRAVEL-F", "ASP")))

    assert(actual("\"EC\"").equals(Set("ASP", "UNK", "Paviment hard")))

    assert(actual("\"MG\"").equals(Set("PEM", "ASP", "COP", "BIT")))

    assert(actual("\"LV\"").equals(Set("ASP", "PEM", "CON")))

    assert(actual("\"MQ\"").equals(Set("ASP")))

    assert(actual("\"GL\"").equals(HashSet("ICE", "ASP", "CON", "UNK", "GVL", "ASPH")))

    assert(actual("\"KI\"").equals(Set("BIT", "COR", "ASP")))

    assert(actual("\"SA\"").equals(HashSet("ASP", "CON", "UNK", "BIT", "SAN")))

    assert(actual("\"BH\"").equals(Set("ASP")))

    assert(actual("\"ET\"").equals(Set("ASP", "PEM", "CON")))

    assert(actual("\"GU\"").equals(Set("PEM", "ASP")))

    assert(actual("\"JE\"").equals(Set("ASP")))

    assert(actual("\"EH\"").equals(Set("ASP")))

    assert(actual("\"MK\"").equals(Set("GRE", "GRS", "CON", "ASP")))

    assert(actual("\"SI\"").equals(HashSet("ASP", "concrete", "asphalt", "grass", "GRS")))

    assert(actual("\"CA\"").equals( HashSet("GRAVEL/GRASS", "TURF/GRAVEL/CL", "CLAY/GRAVEL", "GVL", "SAND/CLAY/GRAV", "CLAY/GRVL", "turf", "gravel", "TURF", "TREATED GRAVEL", "Turf / Gravel", "EARTH", "COM", "Gravel/Asphalt mix", "paved", "water", "PEM", "TURF/EARTH/GRA", "COP", "Asphalt/Turf", "GRAVEL/TURF", "GRVL/TURF", "Turf/Snow", "GRASS", "TURF/GRAVEL/AS", "Stone Dust", "Asphalt", "TURF/CLAY", "GRAVEL/SAND/CL", "GRASS/GRAVEL", "OILED GRAVEL/T", "TURF/OIL PACKE", "Turf", "TURF/GRAVEL/SN", "TURF/SOIL", "CLAY", "OILED", "ASP", "TURF/SNOW", "OLD ASP", "EARTH/SNOW", "OILED GRAVEL", "GRAVEL/SAND", "TURF/ASPHALT", "EARTH/TURF", "TRTD GRVL", "SAND/GRVL", "TURF/CHIPSEAL", "GRE", "TURF/GRAVEL", "DIRT", "GRAVEL/CLAY", "SAND/GRAVEL", "CON", "dirt, No winter maint.", "UNK", "CLAY/SAND", "ASPHALT", "SAND", "Gravel", "Gravel/Snow", "TREATED SAND", "asphalt/gravel", "SAND/GRAVEL/AS", "CONC/GRVL", "Turf, soft during spring thaw", "GRAVEL", "GRAVEL/CLAY/SA", "asphalt", "GRVL/ASP", "Turf / Snow", "CRUSHED ROCK", "TURF/ASP", "CLAY/GRAVEL/TU", "asp", "TURF/EARTH", "TURF/GRVL", "LOOSE GRAVEL", "GRVL/CLAY", "SAN", "SNOW", "PACKED GRAVEL", "TURF/TREATED G", "SOFT SAND", "CLAY/TURF", "GRASS/SNOW", "GRVL", "ASP/TURF", "grass", "Ice", "ASPHALT/TURF", "GRS", "Sand", "Grass", "GRASS&amp;GRAVEL", "ASPH")))

    assert(actual("\"NU\"").equals( Set("ASP")))

    assert(actual("\"MU\"").equals( Set("ASP")))

    assert(actual("\"AO\"").equals( Set("ASP", "UNK")))

    assert(actual("\"AQ\"").equals( Set("SNO", "ICE", "GRE", "ice")))

    assert(actual("\"TH\"").equals( Set("ASP", "CON")))

    assert(actual("\"PH\"").equals( HashSet("PEM", "COP", "ASP", "Paved", "CON", "dirt", "Concrete", "BIT", "ASP/CON")))

    assert(actual("\"SS\"").equals( Set("Asphalt", "ASP", "UNK")))

    assert(actual("\"UA\"").equals( HashSet("PEM", "ASP", "GRE", "BRI", "CON", "UNK", "GRS")))

    assert(actual("\"TR\"").equals( HashSet("Asphalt", "ASP", "concrete", "CON", "PER", "Concrete", "CONCRETE")))

    assert(actual("\"BB\"").equals( Set("ASP")))

    assert(actual("\"AG\"").equals( Set("ASP")))

    assert(actual("\"SY\"").equals( HashSet("PEM", "ASP", "GRE", "CON", "UNK", "SAN")))

    assert(actual("\"NO\"").equals( HashSet("Asphalt", "ASP", "CON", "UNK", "Gravel", "Concrete", "Gravel/Grass", "Ice - frozen lake", "Ice", "Grass")))

    assert(actual("\"ZA\"").equals( HashSet("gravel", "Grass/Concrete", "Asphalt", "Soil, rough gravel", "grass, use at own risk, animals may errode surface", "tar", "GRE", "CON", "UNK", "Gravel", "LAT", "asphalt", "hard", "COM", "Tar", "paving", "ASP", "dirt, use at own risk, animals may errode surface", "tar old", "Tar - lights 5 clicks on 124.8", "GVL", "GRS", "Grass")))

    assert(actual("\"LK\"").equals( Set("ASP", "Asphalt")))

    assert(actual("\"FJ\"").equals( Set("ASP", "UNK")))

    assert(actual("\"FR\"").equals( HashSet("GRASS", "Asphalt", "Unpaved", "Paved", "CON", "grass - herbe  (avion)", "CONCRETE", "paved", "PEM", "UNPAVED", "Turf", "ASP", "UnPaved", "grass - herbe  (planeur)", "MAC", "Grass - Herbe", "Unknown", "UNK", "Grass - Herbe -> Avion - ULM", "GRS", "Grass")))

    assert(actual("\"HT\"").equals( Set("ASP")))

    assert(actual("\"IE\"").equals( HashSet("PEM", "GRASS", "ASP", "GRASS/HARDCORE", "Bituminous", "CON", "UNK", "BIT", "Grass", "ASPH")))

    assert(actual("\"YE\"").equals( Set("ASP", "UNK")))

    assert(actual("\"SN\"").equals( Set("SAN", "ASP", "GRE", "MAC")))

    assert(actual("\"GH\"").equals( Set("ASP")))

    assert(actual("\"FO\"").equals( Set("ASP")))

    assert(actual("\"GQ\"").equals( Set("ASP", "UNK", "CON")))

    assert(actual("\"PA\"").equals( Set("ASP", "CON", "Asphalt")))

    assert(actual("\"DM\"").equals( Set("ASP")))

    assert(actual("\"TM\"").equals( Set("ASP", "CON")))

    assert(actual("\"MP\"").equals( Set("ASP", "PEM", "TURF-GRVL")))

    assert(actual("\"MT\"").equals( Set("ASP")))

    assert(actual("\"IL\"").equals( Set("ASP", "PEM", "Asphalt")))

    assert(actual("\"CZ\"").equals( HashSet("Asphalt", "ASP", "CON", "UNK", "grass", "GRS", "Grass")))

    assert(actual("\"AU\"").equals( HashSet("COP", "NSGG", "X", "GRE", "N", "CON", "XU", "XSA", "GVL", "gravel", "TURF", "COM", "GG", "paved", "PEM", "unsealed", "Asphalt", "Grass and granite sand", "ASP", "B", "sealed", "S", "SU", "UNK", "NRC", "XS", "CLA", "dirt", "PER", "Gravel", "XUG", "G", "BIT", "SAN", "L", "Grass/Gravel", "C", "grass", "UG", "Grass", "Earth/sand", "GRS", "H", "NW")))

    assert(actual("\"CV\"").equals( Set("ASP", "UNK")))

    assert(actual("\"KN\"").equals( Set("ASP")))

    assert(actual("\"AM\"").equals( Set("paved", "CON", "ASP")))

    assert(actual("\"GE\"").equals( Set("CON", "ASP")))

    assert(actual("\"BS\"").equals( Set("BIT", "ASP", "ASPH")))

    assert(actual("\"KG\"").equals( HashSet("ASP", "concrete", "ASB", "CON", "asphalt")))

    assert(actual("\"CD\"").equals( HashSet("PEM", "Dirt", "ASP", "CON", "LAT", "GVL")))

    assert(actual("\"CR\"" ).equals( Set("ASP", "CON", "UNK")))

    assert(actual("\"NE\"" ).equals( Set("ASP", "UNK", "LAT")))

    assert(actual("\"NA\"").equals( Set("ASP", "GVL", "UNK")))

    assert(actual("\"WS\"").equals( Set("ASP")))

    assert(actual("\"VE\"").equals( Set("ASP", "CON", "UNK", "CONCRETE")))

    assert(actual("\"JO\"").equals( Set("ASP", "CON")))

    assert(actual("\"CN\"").equals( HashSet("paved", "Asphalt", "ASP", "concrete", "CON", "UNK", "Concrete")))

    assert(actual("\"MW\"").equals( Set("ASP", "GRS", "BIT")))

    assert(actual("\"IS\"").equals( Set("ASP", "BIT", "UNK", "ASPH-G")))

    assert(actual("\"ZM\"").equals( HashSet("ASP", "BRI", "CON", "UNK", "Gravel", "BIT", "GRS")))

    assert(actual("\"KZ\"").equals( HashSet("PEM", "ASP", "GRE", "CON", "asphalt", "GRS")))

    assert(actual("\"HU\"").equals( HashSet("ASP", "concrete", "GRE", "CON", "UNK", "Concrete", "grass", "GRS", "Grass")))

    assert(actual("\"BE\"").equals( HashSet("PEM", "ASP", "CON", "UNK", "grass", "GRS", "Grass")))

    assert(actual("\"AT\"" ).equals( HashSet("GRASS", "CLOSED", "ASP", "CON", "ASPHALT", "GRS")))

    assert(actual("\"ST\"").equals( Set("ASP")))

    assert(actual("\"NL\"" ).equals( HashSet("PEM", "grass, first 500x6 meter on 25 is paved", "ASP", "CON", "asphalt", "grass", "ASPH")))

    assert(actual("\"KH\"").equals( HashSet("ASP", "CON", "UNK", "GVL", "GRS")))

    assert(actual("\"MM\"").equals( Set("CON", "ASP", "BIT")))

    assert(actual("\"JP\"").equals( HashSet("PEM", "ASP", "GRE", "CON", "UNK", "PSP", "GRS", "COR", "U", "concrete")))

    assert(actual("\"AL\"").equals( HashSet("paved", "ASP", "GRE", "CON", "GRS")))

    assert(actual("\"EG\"").equals( Set("ASP", "Asphalt", "UNK")))

    assert(actual("\"RU\"").equals( HashSet("PEM", "Asphalt", "ASP", "concrete", "GRE", "CON", "UNK", "Concrete", "Ground", "'concrete'", "grass", "GRS", "Grass")))

    assert(actual("\"GM\"").equals( Set("ASP")))

    assert(actual("\"PG\"").equals( HashSet("Grey gravel", "White gravel", "Brown Silt clay", "Grassed limestone gravel", "Grassed grey silt sand", "Grassed river gravel", "Sandy gravel with clay", "Grassed white coronas", "Grassed red clay", "Grassed brown clay gravel", "Grassed brown silty clay", "Red silt clay", "Grassed black silt", "Black silt", "Grassed Brown Clay", "Grey clay", "Grassed grey silt clay", "Yellow gravel", "Grassed sand clay", "Clay", "Grassed brown silt clay", "Grassed Red Clay", "Brown clay gravel", "Grassed black clay", "Grassed blackclay", "Brown clay", "Hard loam", "Red gravel", "Grassed yellow gravel", "Grassed brown silt loam", "Grassed white lime stone", "Grassed brown loam", "Grass red silty clay", "ASP", "Grassed brown gravel", "Red clay", "Black clay", "Grassed clay silt clay", "Grassed grey sand", "Red clay gravel", "Grassed yellow clay", "GRE", "Grass/gravel", "Grassed red silt clay", "Grassed clay", "Grassed gravel", "Grassed silt clay", "UNK", "Grassed yellow silt clay", "Grassed black clay silt", "Grassed brown clay", "Grassed black sand", "Brown silt clay", "Grassed grey clay", "Grassed red silty clay", "Gravel", "Grassed black silt clay", "Grey silt clay", "Grassed red silt", "Grassed red clay gravel", "Grassed black silt sand", "Grassed black clay sand", "Grassed brown sandy clay", "Grassed black soil", "Brown gravel", "Grassed sandy loam", "Grassed white gravel", "GVL", "GRS", "Grassed grey gravel", "Grassed Sand", "Grassed red silt sand")))

    assert(actual("\"SB\"").equals( HashSet("Limestone/Grass", "Crushed coral", "Coral grass", "grass coral", "Sand/grass", "UNK", "Sand grass", "Coral", "Gravel dirt", "Soil and Grass", "Grass", "Coral sand", "Graded earth", "ASP")))

    assert(actual("\"BW\"").equals( Set("ASP", "GVL", "CON")))

    assert(actual("\"MV\"").equals( Set("CON", "BIT", "ASP")))

    assert(actual("\"TT\"").equals( Set("ASP")))

    assert(actual("\"BO\"").equals( Set("ASP", "UNK", "CON", "GRE")))

    assert(actual("\"NI\"").equals( Set("ASP", "CON")))

    assert(actual("\"TL\"").equals( Set("ASP", "Grass")))

    assert(actual("\"NG\"").equals( Set("ASP", "LAT", "CON")))

    assert(actual("\"SZ\"").equals( Set("ASP")))

    assert(actual("\"IO\"").equals( Set("CON")))

    assert(actual("\"BI\"").equals( Set("UNK", "ASP")))

    assert(actual("\"GI\"").equals( Set("ASP")))

    assert(actual("\"CC\"").equals( Set("ASP")))

    assert(actual("\"KM\"").equals( Set("ASP", "UNK")))

    assert(actual("\"IR\"").equals( Set("ASP", "GRE", "CON", "PEM")))

    assert(actual("\"BN\"").equals( Set("ASP")))

    assert(actual("\"HN\"").equals( HashSet("GRASS", "ASP", "CON", "GRVL-GRASS", "GRVL")))

    assert(actual("\"GP\"").equals( Set("ASP")))

    assert(actual("\"GD\"").equals( Set("ASP", "UNK")))

    assert(actual("\"BA\"").equals( Set("GRASS", "ASP", "Grass")))

    assert(actual("\"ER\"").equals( Set("ASP", "CON")))

    assert(actual("\"MH\"").equals( Set("GRVL", "ASP")))

    assert(actual("\"GW\"").equals( Set("ASP", "BIT")))

    assert(actual("\"MF\"").equals( Set("ASP")))

    assert(actual("\"VN\"").equals( Set("ASP", "CON", "UNK")))

    assert(actual("\"BY\"").equals( Set("ASP", "CON")))

    assert(actual("\"AS\"").equals( Set("CONC-G", "CON", "ASP")))

    assert(actual("\"WF\"").equals( Set("UNK", "ASP")))

    assert(actual("\"ES\"").equals( HashSet("Asphalt", "ASP", "concrete", "GRE", "CON", "UNK", "ASPHALT", "GRS")))

    assert(actual("\"NZ\"").equals( HashSet("ASP", "concrete", "GRE", "CON", "UNK", "Sealed", "bitumen/gravel", "Bitumen", "BIT", "GVL", "COM", "paved", "GRS", "Grass")))

    assert(actual("\"LC\"").equals( Set("ASP")))

    assert(actual("\"GA\"").equals( Set("ASP", "LAT", "UNK")))

    assert(actual("\"TZ\"").equals( HashSet("Hard", "ASP", "GRE", "UNK", "BIT")))

    assert(actual("\"SG\"").equals( Set("ASP", "GRS")))

    assert(actual("\"SO\"").equals( Set("sand", "ASP", "UNK")))

    assert(actual("\"CI\"").equals( Set("ASP", "UNK", "CON")))

    assert(actual("\"CM\"").equals( Set("UNK", "ASP")))

    assert(actual("\"LT\"").equals( HashSet("paved", "GRASS", "ASP", "concrete", "CON", "UNK", "Grass", "Asphalt", "GRASS OR EARTH NOT GRADED OR ROLLED")))

    assert(actual("\"GN\"").equals( Set("ASP", "UNK")))

    assert(actual("\"BJ\"").equals( Set("ASP", "UNK")))

    assert(actual("\"CU\"").equals( Set("CON", "ASP")))

    assert(actual("\"AE\"" ).equals( HashSet("Asphalt", "ASP", "UNK", "MAC", "U")))

    assert(actual("\"ID\"").equals( HashSet("Dirt/grass", "PEM", "Dirt/rock", "Sod with gravel & sand", "Gravel", "Grass/dirt", "Sand/clay", "Grass/Clay", "grass", "Rocky gravel", "Hard mud", "Grass/rolled earth", "Grass/clay", "Grass/sandy soil", "Gravel/soil", "Gravel/grass, First 410m of RWY 23 paved", "Clay", "Asphalt", "Hard clay", "Grass over hard gravel", "Graded earth", "Grass/red clay", "ASP", "Asphalt/Concrete", "Gravel/clay", "Grass over rock", "ASPH/CONC", "Coral penetration", "Sand/grass", "Asphalt concrete", "Clay/grass", "GRE", "Grass/gravel", "CON", "Compacted sand", "Grass over gravel", "Compacted coral and sand", "Asphalt/Grass", "Grass/Moss", "ASPHALT", "Gravel/dirt", "asphalt", "Sand laterite", "Gravel/grass", "Coral", "Rock/Gravel/Clay", "Sod over hard clay", "Grass Dirt", "GVL", "GRS", "Grass")))

    assert(actual("\"CY\"").equals( Set("concrete", "ASP")))

    assert(actual("\"MA\"").equals( Set("ASP", "BIT", "UNK", "CON")))

    assert(actual("\"QA\"").equals( Set("ASP", "Asphalt")))

    assert(actual("\"YT\"").equals( Set("ASP")))

    assert(actual("\"FM\"").equals( Set("ASP")))

    assert(actual("\"KY\"").equals( Set("ASP")))

    assert(actual("\"ME\"").equals( Set("GRS", "ASP")))

    assert(actual("\"FI\"").equals( HashSet("COM", "COP", "GRASS", "Asphalt", "GRVL/GRASS", "Oilgravel", "GVL", "Sand", "ASPH", "ASPH/GRASS", "ASPH/GRVL", "ASP", "Oligravel/GRVL", "Oilgravel/sand", "sand/grass", "GRVL", "grass")))

    assert(actual("\"TN\"").equals( Set("ASP", "PEM", "CON")))

    assert(actual("\"TJ\"").equals( Set("ASP", "CON")))

    assert(actual("\"TF\"").equals( Set("dirt")))

    assert(actual("\"KR\"").equals( HashSet("PEM", "concrete", "GRE", "CON", "UNK", "BIT", "GVL", "GRS", "Graded earth", "ASP")))

    assert(actual("\"GB\"").equals( HashSet("Grass/Helipads Concrete", "PEM", "GRASS", "Asphalt", "Grass/Graded Hardcore", "U", "GRE", "CON", "Gravel", "Concrete", "Graded Hardcore", "grass", "Grass/Asphalt", "TURF", "Concrete/Asphalt", "ASP", "Tarmac", "UNK", "SAND", "Grass/Asphalt Insert 1968X59 Feet", "Concrete/Grass", "asphalt", "GRS", "Grass")))

    assert(actual("\"AW\"").equals( Set("ASP")))

    assert(actual("\"PF\"").equals( Set("ASP", "UNK", "BIT", "COR")))

    assert(actual("\"MN\"").equals( HashSet("ASP", "GRE", "CON", "UNK", "BIT")))

    assert(actual("\"PK\"").equals( HashSet("PEM", "ASP", "MAC", "GRE", "CON", "UNK", "'asphalt'", "GVL", "BIT", "SAN")))

    assert(actual("\"PS\"").equals( Set("ASP")))

    assert(actual("\"BZ\"").equals( Set("ASP")))

    assert(actual("\"BD\"").equals( Set("ASP", "PEM", "CON")))

    assert(actual("\"SK\"").equals( HashSet("ASP", "CON", "UNK", "grass", "GRS")))

    assert(actual("\"BR\"").equals( HashSet("GRV", "GRASS", "ASP/GRE", "MET/CON", "GRVL/PIÇ", "ASP", "CON", "UNK", "Gravel", "CON/MET", "MTAL", "GRAVEL", "ARG", "conc", "MET", "GVL", "PIÇ", "PIC", "SAI", "Asphalt", "ASP/GRS", "GRE", "TER", "GRE/GRS", "SAND", "CONC/MTAL", "WOOD", "GRVL", "CON/GRS", "GRS", "CON/ASP", "Grass", "CONC", "ASPH")))

    assert(actual("\"UY\"").equals( HashSet("PEM", "ASP", "CON", "UNK", "GRS")))

    assert(actual("\"SC\"").equals( Set("CON", "ASP")))

    assert(actual("\"TW\"").equals( Set("UNK", "ASP", "CON", "PEM")))

    assert(actual("\"CX\"").equals( Set("ASP")))

    assert(actual("\"KP\"").equals( Set("CON", "ASP", "GRS")))

    assert(actual("\"DE\"").equals( HashSet("TURF", "PEM", "Asphalt", "ASP", "Paved", "CON", "UNK", "ASPHALT", "Concrete", "asphalt", "ASPH", "gras", "GRASS", "U", "concrete", "CONCRETE + GRASS. MTOM 2t", "grass", "GRS", "Grass")))

    assert(actual("\"AZ\"").equals( Set("CON", "ASP")))

    assert(actual("\"ML\"").equals( HashSet("Brown clay gravel", "ASP", "UNK", "LAT", "GVL")))

    assert(actual("\"KE\"").equals( Set("ASP", "BIT", "UNK", "GRE")))

    assert(actual("\"AR\"").equals( HashSet("ASP", "STONE", "GRE", "CON", "UNK", "Concrete", "MET")))

    assert(actual("\"NR\"" ).equals( Set("ASP")))

    assert(actual("\"MZ\"").equals( Set("BIT", "ASP", "SAN", "GVL")))

    assert(actual("\"VG\"").equals( Set("UNK", "ASP")))

    assert(actual("\"CL\"").equals( HashSet("GRV", "GRASS", "PAD/CON", "CLAY", "GRAIN", "ASP", "GRV/ASP", "SAND/GRASS", "CON", "GRV/PAD", "CON/PAD", "BIT", "GRV/MAICILLO", "GVL", "GRE", "PAD/GRASS", "GRASS/PAD", "UNK", "GRV/GRASS", "PAD")))

    assert(actual("\"KS\"").equals( Set("ASP")))

    assert(actual("\"LA\"").equals( Set("ASP", "CON", "COP")))

    assert(actual("\"CH\"").equals( HashSet("GRASS", "ASP", "concrete", "CON", "UNK", "CAUTION: ATC do NOT apply wake turbulence separation ! GRS.", "asphalt", "GRS", "CONC", "CONCRETE", "ASPH")))

    assert(actual("\"IQ\"").equals( HashSet("PEM", "ASP", "U", "CON", "UNK", "GRE", "Asphaltic Concrete")))

    assert(actual("\"SX\"").equals( Set("ASP", "ASPH-CONC")))

    assert(actual("\"KW\"").equals( Set("PEM", "ASP", "CON")))

    assert(actual("\"SV\"").equals( Set("ASP")))

    assert(actual("\"PT\"").equals(HashSet("asph", "ASP", "CON", "UNK", "GRAV", "asphalt", "grav", "GVL")))

    assert(actual("\"NF\"").equals(Set("ASP")))

    assert(actual("\"IN\"").equals(HashSet("PAVED", "Dirt", "ASP", "MAC", "GRE", "CON", "UNK", "ASPHALT", "Concrete", "grass/concrete", "Bitumen", "asphalt", "BIT", "GVL", "COM", "paved", "PEM", "GRS", "Grass")))

    assert(actual("\"VI\"").equals(Set("ASP", "WATER")))

    assert(actual("\"DK\"").equals(HashSet("PEM", "ASP", "GRE", "UNK", "grass", "GRS", "Grass")))

    assert(actual("\"DO\"").equals(Set("ASP", "UNK", "asphalt")))

    assert(actual("\"SD\"").equals( HashSet("gravel", "Asphalt", "ASP", "UNK", "GVL", "graded earth")))

    assert(actual("\"PY\"" ).equals( Set("ASP", "UNK", "CON")))

    assert(actual("\"PL\"").equals( HashSet("PEM", "ASP", "CON", "UNK", "asphalt", "grass", "Brick", "GRS", "Grass")))

    assert(actual("\"VU\"").equals( HashSet("Grass on coral", "Asphalt", "Volcanic ash impregnated with bitumen", "ASP", "Volcanic ash/soil", "Coral", "GRS", "Grass")))

    assert(actual("\"SL\"").equals( Set("ASP")))

    assert(actual("\"RE\"").equals( Set("ASP")))

    assert(actual("\"MS\"").equals( Set("ASP")))

    assert(actual("\"TD\"" ).equals( Set("UNK", "ASP")))

    assert(actual("\"BG\"" ).equals(HashSet("PEM", "ASP", "concrete", "GRE", "CON")))

    assert(actual("\"CF\"").equals(Set("ASP", "UNK")))

    assert(actual("\"HR\"" ).equals(HashSet("PEM", "ASP", "GRE", "CON", "UNK", "grass")))

    assert(actual("\"DJ\"").equals(Set("PEM")))

    assert(actual("\"PM\"").equals(Set("ASP")))

    assert(actual("\"TC\"").equals(Set("ASP", "UNK")))

    assert(actual("\"MO\"").equals(Set("CON")))

    assert(actual("\"RO\"").equals(HashSet("ASP", "CON", "UNK", "grass", "Grass")))

    assert(actual("\"GT\"").equals(Set("ASP", "CON", "Dirt/Gravel")))

    assert(actual("\"AF\"").equals(HashSet("GRV", "ASP", "CON", "CONCRETE AND ASP", "GVL")))

    assert(actual("\"TG\"").equals(Set("CON", "ASP")))

    assert(actual("\"UG\"").equals(Set("GRE", "ASP", "UNK")))

    assert(actual("\"UM\"").equals(Set("ASP", "UNK")))

    assert(actual("\"JM\"").equals(Set("ASP")))

    assert(actual("\"BM\"").equals(Set("ASP")))

    assert(actual("\"US\"").equals(HashSet("ASPH-TURF-F", "ASPH-DIRT-G", "MATS-G", "ASPH-TRTD", "turf", "ALUM", "ASPH-TURF-E", "TURF", "ASPH-GRVL-F", "ROOFTOP", "COM", "ASP/CONC", "PEM", "DECK", "GRAVEL-G", "ASPH-E", "COP", "TURF-TRTD-G", "ASPH-DIRT-P", "CONC-TRTD-G", "CONC-GRVL", "CORAL", "GRASS", "TREATED-E", "TURF-DIRT-F", "STEEL", "CONC-G", "Asphalt", "OIL&CHIP-T-G", "GRVL-E", "Water", "WATER-E", "ASPH-L", "TURF-GRVL-G", "Turf", "TURF-GRVL", "ICE", "ASPH-CONC-F", "GRAVEL-E", "ASPH-CONC", "GRVL-TURF-G", "ALUMINUM", "TRTD-DIRT-P", "OILED DIRT", "ASP", "ALUM-DECK", "DIRT-TURF-F", "GRVL-G", "TURF-G", "ASPH/CONC", "UNKNOWN", "TURF-E", "U", "DIRT-P", "GRVL-DIRT-E", "CONC-TURF-G", "concrete", "ASPH-P", "CONC-TURF", "GRE", "GRASS / SOD, GRAVEL", "TRTD-DIRT", "GRVL-F", "ASPH/GRVL-F", "TURF-DIRT-G", "DIRT", "CONC-GRVL-G", "TREATED", "DIRT-GRVL-F", "SOD", "CON", "TREATED-F", "DIRT-SAND", "CONC-F", "ASPH-GRVL", "TRTD", "DIRT-F", "Natural Soil", "ASPH-TURF-G", "UNK", "GRVL-TURF-F", "ASPH/ CONC", "None", "CLA", "SAND", "PER", "CONC-TURF-F", "BRICK", "ASPH-G", "GRAVEL, TRTD", "Gravel", "TURF-SAND-F", "GRAVEL, GRASS / SOD", "ASPH-TURF", "PSP", "DIRT-GRVL-P", "ASPH-GRVL-P", "TRTD-DIRT-F", "ASPH-GRVL-G", "ASPH-TRTD-G", "NEOPRENE", "GRAVEL", "GRVL-DIRT", "TURF-P", "WATER-G", "TREATED-G", "LAT", "CONC-E", "asphalt", "DIRT-GRVL-G", "DIRT-TRTD", "CONC-TRTD", "CALICHE", "GRAVEL-P", "PIERCED STEEL PLANKING / LANDING MATS / MEMBRANES", "DIRT-TURF-G", "DIRT-G", "GRVL-DIRT-P", "BIT", "NSTD", "WOOD", "GRVL-TRTD-F", "GRVL-TRTD", "ASPH-TURF-P", "STEEL-CONC", "ASPH-DIRT", "NATURAL SOIL", "SAND-F", "MATS", "ASPH-F", "DIRT-E", "GRVL", "C", "ASPH-CONC-P", "GRASS / SOD, NATURAL SOIL", "grass", "Conc", "GRASS / SOD", "GRVL-TURF", "DIRT-GRVL", "WATER", "ASPH-TRTD-P", "GRVL-DIRT-F", "GVL", "TURF-DIRT", "PFC", "ASPH-CONC-G", "TURF-F", "ROOF-TOP", "GRS", "TURF-GRVL-F", "GRVL-P", "Grass", "DIRT-TURF", "CONC", "TURF-GRVL-P", "GRAVEL-F", "CONC-P", "ASPH", "METAL", "TURF-DIRT-P", "GRVL-DIRT-G", "GRAVEL / CINDERS / CRUSHED ROCK / CORAL/SHELLS / SLAG", "GRVL-TURF-P", "GRVL-TRTD-P", "ASPH-TRTD-F", "COR", "GRASS-F", "NATURAL SOIL, GRASS / SOD")))

    assert(actual("\"PE\"").equals(Set("ASP", "UNK", "CON")))

    assert(actual("\"TO\"").equals(Set("ASP", "GRS", "BIT", "UNK")))

    assert(actual("\"SR\"").equals(Set("ASPHALT")))

    assert(actual("\"LB\"").equals(Set("CON", "ASP")))

    assert(actual("\"MR\"").equals(Set("BIT", "ASP", "MAC")))

    assert(actual("\"EE\"").equals(Set("CON", "ASP", "GRS")))

    assert(actual("\"VC\"").equals(Set("ASP")))

    assert(actual("\"SH\"").equals(Set("ASP")))

    assert(actual("\"UZ\"").equals(Set("CON", "ASP")))

    assert(actual("\"HK\"").equals(Set("ASP", "Asphalt")))

    assert(actual("\"RS\"").equals(HashSet("ASP", "Paved", "grass", "GRS", "Grass")))

    assert(actual("\"ZW\"").equals(HashSet("ASP", "MAC", "GRE", "BIT", "GRS")))

  }

  test("testGetTenCountriesHighestNumberOfAirports") {
    val actual = reportService.getTenCountriesHighestNumberOfAirports(airports)

    assert(actual!=null)
    assert(actual.size == 10)

    assert(actual("\"US\"").equals(21501))
    assert(actual("\"BR\"").equals(3839))
    assert(actual("\"CA\"").equals(2454))
    assert(actual("\"AU\"").equals(1908))
    assert(actual("\"RU\"").equals(920))
    assert(actual("\"FR\"").equals(789))
    assert(actual("\"AR\"").equals(713))
    assert(actual("\"DE\"").equals(703))
    assert(actual("\"CO\"").equals(700))
    assert(actual("\"VE\"").equals(592))

  }

}
