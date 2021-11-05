package service

class Utils {

  def myToInt(s: String): Option[Int] = {
    if (s.isBlank){
      None
    }else{
      Some(s.toInt)
    }
  }

  def myToFloat(s: String): Option[Float] = {
    if (s.isBlank){
      None
    }else{
      Some(s.toFloat)
    }
  }

  def myToString(s: String): Option[String] = {
    if (s.isBlank){
      None
    }else{
      Some(s)
    }
  }


}
