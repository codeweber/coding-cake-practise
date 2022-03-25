package interviewcake.greedy

import org.scalatest.flatspec.AnyFlatSpec

class ProductOfAllOthersSpec extends AnyFlatSpec:

    import ProductOfAllOthers.*

    "getProductsOfAllIntsExceptAtIndex" should "work in simple case" in {

        val ns = Array(1,7,3,4)
        val expected = Array(84,12,28,21)
        val observed = getProductsOfAllIntsExceptAtIndex(ns)

        assert(getProductsOfAllIntsExceptAtIndex(ns) sameElements expected )
    }

    it should "work with zeros" in {

        val ns = Array(1,7,0,4)
        val expected = Array(0,0,28,0)
        val observed = getProductsOfAllIntsExceptAtIndex(ns)

        assert(getProductsOfAllIntsExceptAtIndex(ns) sameElements expected )
    }
