package interviewcake.hash

import org.scalatest.flatspec.AnyFlatSpec
import scala.collection.mutable.HashMap

class WordCloudSpec extends AnyFlatSpec:

    import WordCloud.*

    "makeWordCloud" should "behave as expected" in {
        val str = "hello hello hello dean"
        assert(makeWordCloud(str) == Map("hello" -> 3, "dean" -> 1))

    }

    "makeWordCloud" should "handle standard punctuation" in {

        val str = "We came, we saw, we conquered...then we ate Bill's (Mille-Feuille) cake."
        assert(makeWordCloud(str) == Map("we" -> 4, "came" -> 1, "saw" -> 1, "conquered" -> 1, "then"-> 1, "ate" -> 1, "bill's" -> 1, "mille-feuille" -> 1, "cake" -> 1))
    }

    "makeWordCloudEfficient" should "handle standard punctuation" in {

        val str = "We came, we saw, we conquered...then we ate Bill's (Mille-Feuille) cake."
        assert(makeWordCloudEfficient(str) == HashMap("we" -> 4, "came" -> 1, "saw" -> 1, "conquered" -> 1, "then"-> 1, "ate" -> 1, "bill's" -> 1, "mille-feuille" -> 1, "cake" -> 1))
    }