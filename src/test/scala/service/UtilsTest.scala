package service

class UtilsTest extends org.scalatest.FunSuite {
  val utils = new Utils()

  test("testMyToBoolean") {
    val s = "1"
    assert(utils.myToBoolean(s).equals(Some(true)))
  }

  test("testMyToString") {
    val s = "hello"
    assert(utils.myToString(s).equals(Some("hello")))
  }

  test("testMyToFloat") {
    val s = "1.0"
    assert(utils.myToFloat(s).equals(Some(1.0)))
  }

  test("testMyToInt") {
    val s = "711"
    assert(utils.myToInt(s).equals(Some(711)))
  }

}
