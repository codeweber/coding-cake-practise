package interviewcake.greedy

import org.scalatest.flatspec.AnyFlatSpec

class ProductOf3Spec extends AnyFlatSpec:

    import ProductOf3.*

    "highestProduct" should "work correcly with negative numbers" in {
        assert(highestProduct(Array(-10,-10,1,3,2)) == 300)
    }

    "highestProduct" should "work correcly with all negative numbers" in {
        assert(highestProduct(Array(-10,-10,-100,-4,-1)) == -40)
    }

    "highestProduct" should "work correcly with all positive numbers" in {
        assert(highestProduct(Array(1,10,100,4,10)) == 10000)
    }