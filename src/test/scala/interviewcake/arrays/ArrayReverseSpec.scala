package interviewcake.arrays

import org.scalatest.flatspec.AnyFlatSpec 

class ArrayReverseSpec extends AnyFlatSpec:

    import ArrayReverse.*

    "reverseArraySlice" should "reverse a given array" in {

        val xs = "Hello World ".toArray
        reverseArraySlice(xs, 0, xs.size)
        println(xs.mkString)
        assert(xs sameElements " dlroW olleH".toArray)

    }

    it should "reverse only a slice of an array" in {

        val xs = "Hello World!".toArray
        reverseArraySlice(xs, 0, 5)
        assert(xs sameElements "olleH World!".toArray)

    }

    "reverseArray" should "not change an empty Array" in {

        val xs = "".toArray
        val ys = xs.clone()
        reverseArray(xs)
        assert(ys sameElements xs )

    }

    it should "resverse a non-empty Array" in {

        val xs = "hello".toArray
        reverseArray(xs)
        assert(xs sameElements "olleh".toArray)

    }

    "reverseList" should "not change an empty List" in {

        assert(reverseList("".toList) == "".toList)
    }

    it should "correctly reverse a non-empty list" in {
        assert(reverseList("hello".toList) == "olleh".toList)
    }
