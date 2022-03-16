package interviewcake.hash

import scala.collection.mutable.HashMap

object WordCloud:

    def makeWordCloud(str: String): Map[String, Int] = 

        val words = str.map {
            case '-' => '-'
            case '\'' => '\''
            case l if l >= 'a' && l <= 'z' => l
            case upper if upper >= 'A' && upper <= 'Z' => upper.toLower   
            case _ => ' '
        }.split(' ').filter(!_.isEmpty)
        val wordCloud = words.groupBy(identity).map( (k,v) => (k,v.size))

        wordCloud

    def makeWordCloudEfficient(str: String): HashMap[String, Int] = 

        val wordCount = new HashMap[String, Int]
        var i,wordStart,wordEnd = 0

        while i <= str.size do

            val current = if i < str.size then str(i).toLower else ' '

            if (current >= 'a' && current <= 'z') || current == '-' || current == '\'' then 
                
                if wordStart == wordEnd then 
                    wordStart = i
                    
                wordEnd = i + 1

            else

                if wordStart != wordEnd then
                    val word = str.slice(wordStart, wordEnd).toLowerCase
                    val currentNum = wordCount.getOrElse(word, 0)
                    wordCount.addOne(word, currentNum+1)
                    wordStart = wordEnd

            i += 1

        end while 

        wordCount




