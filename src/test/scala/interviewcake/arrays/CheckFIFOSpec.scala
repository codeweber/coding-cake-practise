package interviewcake.arrays

import org.scalatest.flatspec.AnyFlatSpec

class CheckFIFOSpec extends AnyFlatSpec:

    import CheckFIFO.*

    "checkServedOrders" should "be true" in {

        val tOO = Array(17,8,24)
        val dIO = Array(12,19,2)
        val sO = Array(17,8,12,19,24,2)
        assert(checkServedOrders(tOO,dIO,sO) ==  true)

    }


    "checkServedOrders" should "be false" in {

        val tOO = Array(1,3,5)
        val dIO = Array(2,4,6)
        val sO = Array(1,2,4,6,5,3)
        assert(checkServedOrders(tOO,dIO,sO) ==  false)

    }