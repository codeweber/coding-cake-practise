package interviewcake.general

import org.scalatest.flatspec.AnyFlatSpec

class tempOccurrencesSpec extends AnyFlatSpec:

    import tempOccurrences.* 

    "tempTracker" should "correctly track min, max, mean and mode" in {


        val t = new tempTracker


        val temps = List(3, 5, 7, 7, 21)
        temps.foreach(t.insertTemp(_))

        assert(t.getMaxTemp == 21 && t.getMinTemp == 3 && (t.getMeanTemp - (43.0/5.0)).abs < 1E-10 && t.getModeTemp == 7)

    }



