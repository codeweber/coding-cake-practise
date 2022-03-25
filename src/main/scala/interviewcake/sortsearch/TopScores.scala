package interviewcake.sortsearch

object TopScores:

    def sortScores(scores: Array[Int], maxPossibleScore: Int): Array[Int] =

        val countScores = Array.fill(maxPossibleScore+1)(0)
        var i = 0
        while i < scores.size do
            val score = scores(i)
            countScores(score) += 1
            i += 1
        
        val sortedScores = new Array[Int](scores.size)
        i = 0
        var j = countScores.size 
        while j > 0 && i < sortedScores.size do
            j -= 1
            val numWithScore = countScores(j)
            var k = 0
            while k < numWithScore do 
                sortedScores(i) = j
                i += 1
                k += 1

        sortedScores
