package interviewcake.greedy

import scala.util.Random

object InPlaceShuffle:

    val rand = Random(1000L)

    def getRandom(floor: Int, ceiling: Int): Int = rand.between(floor, ceiling+1)

    def randomShuffle(ints: Array[Int]): Unit =

        var i = 0
        while i < ints.size do 

            val currentVal = ints(i)
            val j = getRandom(i, ints.size-1)
            val newVal = ints(j)
            ints(i) = newVal 
            ints(j) = currentVal

            i += 1

            
