package interviewcake.hash

import scala.collection.mutable

object InflightReco:

    def existTwoFilms(flightLength: Int, movieLengths: Array[Int]): Boolean =

        val mapMovieLengthsToId = new mutable.HashMap[Int,Int]

        for
            l <- movieLengths
        do {
            val currentNumMovies = mapMovieLengthsToId.getOrElse(l, 0)
            mapMovieLengthsToId.addOne((l, currentNumMovies + 1))
        }

        var existsMoviePair = false
        val mapIterator = mapMovieLengthsToId.iterator

        while !existsMoviePair && mapIterator.hasNext do
            val (l1,nMovies1) = mapIterator.next
            val l2 = flightLength - l1
            existsMoviePair = 
                if l1 == l2 then
                    nMovies1 > 1
                else mapMovieLengthsToId.contains(l2)
            
        existsMoviePair

    def existTwoFilmsFunctional(flightLength: Int, movieLengths: Array[Int]): Boolean =

        val mapMovieLengthsToNum = movieLengths.groupBy(identity).map( (k,v) => (k,v.size) ) 
        val mapMovieMatchingPair = mapMovieLengthsToNum.filter {
            (k,v) => mapMovieLengthsToNum.contains(flightLength-k) && (2*k != flightLength || v > 1)
        }

        !mapMovieMatchingPair.isEmpty

    def existTwoFilmsOptimised(flightLength: Int, movieLengths: Array[Int]): Boolean =

        val movieLengthsSeen = new mutable.HashSet[Int]

        val movieLength = movieLengths.iterator
        var existsMoviePair = false

        while !existsMoviePair && movieLength.hasNext do

            val l = movieLength.next 
            if movieLengthsSeen.contains(flightLength -  l) then 
                existsMoviePair = true 
            else 
                movieLengthsSeen.add(l)
            
        existsMoviePair


        
