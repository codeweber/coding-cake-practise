package interviewcake.stack

import scala.collection.mutable.Stack

object BracketValidator:

    def isValid(str: String): Boolean =

        val unclosedOpeners = new Stack[Char]

        val openers = Set('{', '[', '(')
        val closersToOpeners = Map('}' -> '{', ']' -> '[', ')' -> '(')

        var valid = true
        var i = 0

        while i < str.length && valid do

            val c = str(i)

            if openers(c) then
                unclosedOpeners.push(c)
            else if closersToOpeners.contains(c) then
                val lastOpener = unclosedOpeners.pop 
                valid = lastOpener == closersToOpeners(c)

            i += 1

        valid && unclosedOpeners.isEmpty

            