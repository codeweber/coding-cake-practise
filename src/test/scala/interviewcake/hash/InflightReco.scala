package interviewcake.hash

import org.scalatest.flatspec.AnyFlatSpec

class InflightRecoSpec extends AnyFlatSpec:

    import InflightReco.{existTwoFilms, existTwoFilmsFunctional, existTwoFilmsOptimised}

    "existTwoFilms" should "return true when two different films exists with required sum of lengths" in {

        val flightLength = 100 
        val movieLengths = Array(75,25,30)

        assert(existTwoFilms(flightLength, movieLengths))
    }

    it should "return false when no suitable combination of films exists" in { 
        
        val flightLength = 100 
        val movieLengths = Array(75,23,30)

        assert(!existTwoFilms(flightLength, movieLengths))

    }

    it should "return true when two films of the same length are suitable" in { 
        
        val flightLength = 100 
        val movieLengths = Array(50, 50, 25)

        assert(existTwoFilms(flightLength, movieLengths))

    }

    it should "return false when only one film of half the flight length is present" in {
        
        val flightLength = 100 
        val movieLengths = Array(50, 25, 25)

        assert(!existTwoFilms(flightLength, movieLengths))

    }

    "existTwoFilmsFunctional" should "return true when two different films exists with required sum of lengths" in {

        val flightLength = 100 
        val movieLengths = Array(75,25,30)

        assert(existTwoFilmsFunctional(flightLength, movieLengths))
    }

    it should "return false when no suitable combination of films exists" in { 
        
        val flightLength = 100 
        val movieLengths = Array(75,23,30)

        assert(!existTwoFilmsFunctional(flightLength, movieLengths))

    }

    it should "return true when two films of the same length are suitable" in { 
        
        val flightLength = 100 
        val movieLengths = Array(50, 50, 25)

        assert(existTwoFilmsFunctional(flightLength, movieLengths))

    }

    it should "return false when only one film of half the flight length is present" in {
        
        val flightLength = 100 
        val movieLengths = Array(50, 25, 25)

        assert(!existTwoFilmsFunctional(flightLength, movieLengths))

    }

    "existTwoFilmsOptimised" should "return true when two different films exists with required sum of lengths" in {

        val flightLength = 100 
        val movieLengths = Array(75,25,30)

        assert(existTwoFilmsOptimised(flightLength, movieLengths))
    }

    it should "return false when no suitable combination of films exists" in { 
        
        val flightLength = 100 
        val movieLengths = Array(75,23,30)

        assert(!existTwoFilmsOptimised(flightLength, movieLengths))

    }

    it should "return true when two films of the same length are suitable" in { 
        
        val flightLength = 100 
        val movieLengths = Array(50, 50, 25)

        assert(existTwoFilmsOptimised(flightLength, movieLengths))

    }

    it should "return false when only one film of half the flight length is present" in {
        
        val flightLength = 100 
        val movieLengths = Array(50, 25, 25)

        assert(!existTwoFilmsOptimised(flightLength, movieLengths))

    }

