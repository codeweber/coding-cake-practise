package interviewcake.trees

object FindDuplicate:


    def findDuplicate(nums: Array[Int]): Int = 

        val n = nums.size - 1

        if n <= 1 then
            throw new IllegalArgumentException("Input array must have length greater than 1")

        val lastPosition = n + 1

        def getNumberAtPosition(position: Int): Int =

            val number = nums(position-1)

            if number < 1 || number > n then
                throw new IllegalStateException(s"Value ${number} is out of the range [1,$n]")
            else 
                number

        def getLoopLength(startPosition: Int): Int =

            var loopLength = 1
            var nextPosition = getNumberAtPosition(startPosition)

            while nextPosition != startPosition && loopLength < n do
                loopLength += 1
                nextPosition = getNumberAtPosition(nextPosition)

            if nextPosition != startPosition then 
                throw new IllegalStateException("No loop detected")

            loopLength

        def traverseChain(startPosition: Int, maxChainLinks: Int): (Int, Int)  =
            
            var chainStart = startPosition 
            var chainEnd  = getNumberAtPosition(startPosition)
        
            var numChainLinks = 1
            var i = 0

            while chainStart != chainEnd && i < n do

                chainEnd = getNumberAtPosition(chainEnd)
                numChainLinks += 1
                
                if numChainLinks > maxChainLinks then
                    chainStart = getNumberAtPosition(chainStart) 
                    numChainLinks -= 1
                
                i += 1

            (chainStart, chainEnd)
            
        val (_, positionInLoop) = traverseChain(lastPosition, n)
        val loopLength = getLoopLength(positionInLoop)
        println(s"Loop length found: ${loopLength}")
        val (duplicatePosition, _) = traverseChain(lastPosition, loopLength)

        duplicatePosition
