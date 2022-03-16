package interviewcake.hash

import org.scalatest.flatspec.AnyFlatSpec

class PanlindromeSpec extends AnyFlatSpec:

    import Palindrome.*

    "isPermutationOfPalindrome" should "be true for civic" in {

        assert(isPermutationOfPalindrome("civic".toCharArray))
    }

    it should "be true for viicc" in {
        assert(isPermutationOfPalindrome("civic".toCharArray))
    }

    it should "be false for civil" in {
        assert(!isPermutationOfPalindrome("civil".toCharArray))
    }

    it should "be false for viilc" in {
        assert(!isPermutationOfPalindrome("viilc".toCharArray))
    }
