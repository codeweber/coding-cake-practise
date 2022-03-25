package interviewcake.sortsearch

import org.scalatest.flatspec.AnyFlatSpec

class FindDuplicateSpec extends AnyFlatSpec:

    import FindDuplicate.*

    "shrinkRange" should "work" in {

        val nums = Array(1,2,3,4,5,3)
        assert(shrinkRange(nums,1,5) == (3,3))

    }

    "findDuplicate" should "work" in {

        val nums = Array(1,2,3,4,5,3)
        assert(findDuplicate(nums) == 3)
    }

    "findDuplicate" should "work again" in {

        val nums = Array(1,1,1,1,1,1)
        assert(findDuplicate(nums) == 1)
    }

    "findDuplicate" should "detect no dupes" in {

        val nums = (1 to 10).toArray
        assert(findDuplicate(nums) == -1)
    }
