package service

class UtilsTest extends org.scalatest.FunSuite {

  test("testMyToBoolean") {
    val s = "1"
    val utils = new Utils()
    assert(utils.myToBoolean(s).equals(Some(true)))
  }

  test("testMyToString") {
    val s = "hello"
    val utils = new Utils()
    assert(utils.myToString(s).equals(Some("hello")))
  }

  test("testMyToFloat") {
    val s = "1.0"
    val utils = new Utils()
    assert(utils.myToFloat(s).equals(Some(1.0)))
  }

  test("testMyToInt") {
    val s = "711"
    val utils = new Utils()
    assert(utils.myToInt(s).equals(Some(711)))
  }

}
