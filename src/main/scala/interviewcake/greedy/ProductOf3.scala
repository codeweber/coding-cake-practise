package interviewcake.greedy

object ProductOf3:

    def highestProduct(arrayOfInts: Array[Int]): Int = 


        if arrayOfInts.size < 3 then 
            throw new IllegalArgumentException("arrayOfInts must have size greater than 3")

        val threeSortedInts: Array[Int] = arrayOfInts.take(3).sorted

        var maxVal = threeSortedInts(2)
        var nextMaxVal = threeSortedInts(1)
        var minVal = threeSortedInts(0)
        var maxProduct = threeSortedInts.product

        var i = 3
        while i < arrayOfInts.size do 
        
            val currentVal = arrayOfInts(i)

            maxProduct = maxProduct max (minVal * currentVal * maxVal) max (currentVal * nextMaxVal * maxVal) max (if maxVal == 0 then 0 else (maxProduct * currentVal / maxVal))

            // Set a new min value
            minVal = minVal min currentVal

            // Set new max and nextMax
            if currentVal > maxVal then
                nextMaxVal = maxVal 
                maxVal = currentVal
            else if currentVal > nextMaxVal then
                nextMaxVal = currentVal

            i += 1 

        maxProduct


