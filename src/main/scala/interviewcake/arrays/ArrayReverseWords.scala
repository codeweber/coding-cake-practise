package interviewcake.arrays

object ArrayReverseWords:



    def reverseWords(xs: Array[Char]): Unit =

        import ArrayReverse.reverseArraySlice
        reverseArraySlice(xs, 0, xs.size)

        var i,wordStart = 0

        while i < xs.size do

            if xs(i) == ' ' then
                reverseArraySlice(xs, wordStart, i)
                wordStart = i+1

            i += 1

        reverseArraySlice(xs, wordStart, i)



    