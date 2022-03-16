package interviewcake.arrays

import java.util.concurrent.TimeUnit

object ArrayReverse:

    def reverseArraySlice(xs: Array[Char], from: Int, until: Int): Unit = 
        
        def swap(i: Int, j: Int): Unit = 
            xs.synchronized {
                val x = xs(i)
                xs(i) = xs(j)
                xs(j) = x
            }


        val numElementsInSubArray = (until - from) / 2

        for 
            idx <- 0 until numElementsInSubArray
        do {
            val i = from + idx
            val j = (until-1) - idx 
            swap(i,j)
        }


    def reverseArray(xs: Array[Char]): Unit = 
        
        reverseArraySlice(xs, 0, xs.size)




    def reverseList(xs: List[Char]): List[Char] = 
        xs.foldLeft(List[Char]())( (b,a) => a :: b)