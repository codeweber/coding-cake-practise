package interviewcake.binary

import org.scalatest.flatspec.AnyFlatSpec

class FindDroneSpec extends AnyFlatSpec:

    import FindDrone.findUniqueInt

    "findUniqueInt" should "return unique int" in {

        val ns = (1 to 10).toArray

        assert(findUniqueInt(ns ++ ns ++ Array(100)) == 100 )
    }
