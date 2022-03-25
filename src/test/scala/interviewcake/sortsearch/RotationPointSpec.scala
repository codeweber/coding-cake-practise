package interviewcake.sortsearch

import org.scalatest.flatspec.AnyFlatSpec

class RotationPointSpec extends AnyFlatSpec:

    import RotationPoint.*

    "findRotationPoint" should "work for a simple sorted list" in {

        val words = Array("Alpha", "Beta", "Charlie", "Zulu")

        assert(findRotationPoint(words) == 0)

    }

    it should "work for a simple rotated list" in {

        val words = Array("Charlie", "Zulu", "Alpha", "Beta")

        assert(findRotationPoint(words) == 2)

    }

    it should "work for the example rotated list" in {

        val words = Array(
            "ptolemaic",
            "retrograde",
            "supplant",
            "undulate",
            "xenoepist",
            "asymptote",  // <-- rotates here!
            "babka",
            "banoffee",
            "engender",
            "karpatka",
            "othellolagkage"
        )

        assert(findRotationPoint(words) == 5)

    }
