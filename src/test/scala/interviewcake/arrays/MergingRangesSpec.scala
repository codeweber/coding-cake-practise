package interviewcake.arrays 

import org.scalatest.flatspec.AnyFlatSpec

class MergingRangesSpec extends AnyFlatSpec:

    import MergingRanges.*

    "isMergable" should "be true for two overlapping meetings" in {
        
        val m1 = (1,3)
        val m2 = (3,4)

        assert(isMergable(m1,m2))
    
    } 

    it should "be false for two non-overlapping meetings" in {

        val m1 = (1,3)
        val m2 = (4,5)

        assert(!isMergable(m1,m2))

    }


    "mergeMeetings" should "correctly merge a meeting" in {

        val m1 = (1,3)
        val m2 = (3,4)

        assert(mergeMeetings(m1,m2) == (1,4))
    }

    "sortRanges" should "correctly sort meetings" in {

        val listRanges = List((0,1), (5,10), (1,6), (5,8))
        val sortedRanges = List((0,1), (1,6), (5,8), (5,10))

        assert(sortRanges(listRanges) == sortedRanges)

    }

    "mergeRanges" should "corrently collapse overallping meetings into a single meeting" in {

        val listRanges = List((0,1), (5,10), (1,6), (5,8))
        val expected = List((0,10))

        assert(mergeRanges(listRanges) == expected)

    }

    it should "not collapse non overlapping meetings" in {

        val listRanges = List((0,1), (5,6), (2,4), (7,8))
        val expected = List((0,1), (2,4), (5,6), (7,8))

        assert(mergeRanges(listRanges) == expected)

    }

    it should "correctly merge subsumed meetings" in {

        val listRanges = List((1,5), (2,3))
        val expected = List((1,5))

        assert(mergeRanges(listRanges) == expected)

    }

    it should "correctly merge all other meetings into the longest" in {

        val listRanges = List((1, 10), (2, 6), (3, 5), (7, 9))
        val expected = List((1,10))

        assert(mergeRanges(listRanges) == expected)

    }

    it should "not leave out the last meeting" in {

        val listRanges = List((1,4), (4,7))
        assert(mergeRanges(listRanges) == List((1,7)))
    }

    "mergeArrayRanges" should "successfully merge touching ranges" in {

        val arrayRanges = Array((1,2), (2,3))
        val expectedRanges = Array((1,3))
        assert(mergeArrayRanges(arrayRanges) sameElements expectedRanges)
    
    }

    it should "successfully merge ranges that can be subsumed" in {

        val arrayRanges = Array((1,5), (2,3))
        val expectedRanges = Array((1,5))
        assert(mergeArrayRanges(arrayRanges) sameElements expectedRanges)
    
    }

    it should "successfully merge all ranges that can be subsumed" in {

        val arrayRanges = Array((1, 10), (2, 6), (3, 5), (7, 9))
        val expectedRanges = Array((1,10))
        assert(mergeArrayRanges(arrayRanges) sameElements expectedRanges)
    
    }