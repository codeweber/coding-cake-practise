package interviewcake.dynamic

import org.scalatest.flatspec.AnyFlatSpec

class ChangeSpec extends AnyFlatSpec:

    import Change.*

    "calcNumChangeWaysBottomUpV2" should "work" in {

        assert(calcNumChangeWaysBottomUpV2(4, List(1,2,3)) == 4)

    }

    it should "work for a simple case" in {

        assert(calcNumChangeWaysBottomUpV2(5, List(2,3)) == 1)
    }

    it should "return 1 when amount is zero" in {

        assert(calcNumChangeWaysBottomUpV2(0, List(2,3)) == 1)
    }