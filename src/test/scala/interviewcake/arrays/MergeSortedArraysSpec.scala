package interviewcake.arrays


import org.scalatest.flatspec.AnyFlatSpec 

class MergeSortedArraySpec extends AnyFlatSpec:

    import MergeSortedArrays.*

    "mergeSortedArrays" should "take two sorted arrays and output a sorted array" in {

        val xs = Array(3,4,6,10,11,15)
        val ys = Array(1,5,8,12,14,19)
        
        val zs = mergeSortedArrays(xs, ys)
        val expected = Array(1, 3, 4, 5, 6, 8, 10, 11, 12, 14, 15, 19)
        assert(zs sameElements expected)

    }
