package interviewcake.hash

import scala.collection.mutable

object Palindrome:

    def isPermutationOfPalindrome(cs: Array[Char]): Boolean =

        val letterSet = new mutable.HashSet[Char]

        cs.foreach {
            c =>
                if letterSet.contains(c) then 
                    letterSet.remove(c)
                else letterSet.add(c)
        }

        letterSet.size == cs.size % 2
        


