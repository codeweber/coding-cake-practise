package interviewcake.stack

import org.scalatest.flatspec.AnyFlatSpec

class BracketValidatorSpec extends AnyFlatSpec:

    import BracketValidator.isValid

    "isValid" should "return true in a test case 1" in {

        assert(isValid("{ [ ] ( ) }"))

    }

    it should "return false in a test case 2" in {

        assert(!isValid("{ [ ( ] ) }"))

    }

    it should "return false in a test case 3" in {

        assert(!isValid("{ [ }"))

    }
