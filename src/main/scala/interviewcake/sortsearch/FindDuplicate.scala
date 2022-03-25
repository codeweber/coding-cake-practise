package interviewcake.sortsearch

object FindDuplicate:

    def shrinkRange(nums: Array[Int], xMin: Int, xMax: Int): (Int, Int) =

        val xMid = xMin + (xMax - xMin)/2

        var i, numMinVals, numMidVals, numMaxVals, sumLessThanMid = 0

        while i < nums.size && numMinVals <= 1 && numMaxVals <= 1 && numMidVals <= 1 do

            val currentVal = nums(i)
            if currentVal < xMid && currentVal >= xMin then 
                if currentVal == xMin then
                    numMinVals += 1
                sumLessThanMid += currentVal
            else if currentVal == xMid then 
                numMidVals += 1
            else if currentVal == xMax then
                numMaxVals += 1

            i += 1 

        if numMinVals > 1 then
            (xMin, xMin)
        else if numMidVals > 1 then
            (xMid, xMid)
        else if numMaxVals > 1 then
            (xMax, xMax)
        else if 2*sumLessThanMid < (xMin + (xMid-1))*(xMin - (xMid - 1) + 1) then
            (xMin+1, xMid-1)
        else (xMid+1, xMax-1)


    def findDuplicate(nums: Array[Int]): Int = 

        var nMin = 1
        var nMax = nums.size - 1

        while nMin < nMax do

            val (pMin, pMax) = shrinkRange(nums, nMin, nMax)
            nMin = pMin
            nMax = pMax
        
        if nMin == nMax then
            nMin 
        else 
            -1

        

        