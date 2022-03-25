package interviewcake.sortsearch

import org.scalatest.flatspec.AnyFlatSpec

class TopScoresSpec extends AnyFlatSpec:

    import TopScores.*

    "sortScores" should "return expected result" in {

        val scores = Array(37, 89, 41, 65, 91, 53)
        val sortedScores = sortScores(scores, 100)
        val sortedScoresExpected = Array(91, 89, 65, 53, 41, 37)
        assert(sortedScores sameElements sortedScoresExpected)

    }

    "sortScores" should "correctly handle repeated scores" in {

        val scores = Array(37, 89, 41, 65, 91, 53, 41, 65)
        val sortedScores = sortScores(scores, 100)
        val sortedScoresExpected = Array(91, 89, 65, 65, 53, 41, 41, 37)
        assert(sortedScores sameElements sortedScoresExpected)

    }

    "sortScores" should "correctly handle scores at extremes" in {

        val scores = Array(37, 89, 41, 65, 91, 53, 41, 65,0,100)
        val sortedScores = sortScores(scores, 100)
        val sortedScoresExpected = Array(100,91, 89, 65, 65, 53, 41, 41, 37,0)
        assert(sortedScores sameElements sortedScoresExpected)

    }
