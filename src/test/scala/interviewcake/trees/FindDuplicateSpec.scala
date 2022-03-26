package interviewcake.trees

import org.scalatest.flatspec.AnyFlatSpec

class FindDuplicateSpec extends AnyFlatSpec:

    import FindDuplicate.findDuplicate

    "findDuplicate" should "work with simple loop" in {

        val nums = Array(2,3,4,5,1,1)
        assert(findDuplicate(nums) == 1)
    }

    "findDuplicate" should "work with loop of length 1" in {

        val nums = Array(1,3,4,5,1,1)
        assert(findDuplicate(nums) == 1)
    }

    "findDuplicate" should "work" in {

        val nums = Array(1,2,3,4,5,3)
        assert(findDuplicate(nums) == 3)
    }

    "findDuplicate" should "work again" in {

        val nums = Array(1,1,1,1,1,1)
        assert(findDuplicate(nums) == 1)
    }

    it should "find duplicate" in {

        val nums = Array(2,3,4,1,5,6,7,1)
        assert(findDuplicate(nums) == 1)
    }

    "findDuplicate" should "fail with exception if there are no dupes" in {

        val nums = (1 to 10).toArray

        val thrown = intercept[Exception] {
            findDuplicate(nums)
        }
        assert(thrown.getMessage == "Value 10 is out of the range [1,9]" )
    }
