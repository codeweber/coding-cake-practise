package interviewcake.dynamic

import org.scalatest.flatspec.AnyFlatSpec

class FibSpec extends AnyFlatSpec:

    import Fib.*

    val ns = List(0,1,2,3,4,5,6)
    val expected = List(0,1,1,2,3,5,8)

    "fib" should "return the correct set of Fibonnaci numbers" in {

        val fibs = ns.map(fib(_))
        assert(fibs == expected)

    }

    "fibForward" should "return the correct set of Fibonnaci numbers" in {

        val fibs = ns.map(fibForward(_))
        assert(fibs == expected)

    }

    "fibRecursive" should "return the correct set of Fibonnaci numbers" in {

        val fibs = ns.map(fibRecursive(_))
        assert(fibs == expected)

    }
