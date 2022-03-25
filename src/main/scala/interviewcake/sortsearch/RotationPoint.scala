package interviewcake.sortsearch

object RotationPoint:

    def findRotationPoint(words: Array[String]): Int =

        if words.size < 2 then
            throw new IllegalArgumentException("Words must have more than one element")

        var iBegin = 0
        var iEnd = words.size - 1

        while iBegin < iEnd do

            val firstWord = words(iBegin)
            val lastWord = words(iEnd)

            if lastWord >= firstWord then
                //range is sorted, first element is the rotation
                iEnd = iBegin
            else 
                val iMiddle = iBegin + (iEnd - iBegin + 1)/2
                val middleWord = words(iMiddle)
                if lastWord >= middleWord then
                    iEnd = iMiddle
                    iBegin += 1
                else
                    iBegin = iMiddle + 1


        iBegin


