package interviewcake.arrays

import org.scalatest.flatspec.AnyFlatSpec 

class ArrayReverseWordsSpec extends AnyFlatSpec:

    import ArrayReverseWords.*

    "reverseWords" should "correctly reverse words" in {

        val cs = "Hello World".toArray
        reverseWords(cs)
        assert(cs sameElements "World Hello".toArray)

    }

    "reverseWords" should "correctly handle spaces at the end" in {

        val cs = "Hello World ".toArray
        reverseWords(cs)
        assert(cs sameElements " World Hello".toArray)

    }
