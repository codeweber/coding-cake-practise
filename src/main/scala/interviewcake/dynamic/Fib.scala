package interviewcake.dynamic

import scala.annotation.tailrec

object Fib:

    def fib(n: Int): Int =

        n match
            case m if m <= 0 => 0
            case 1 => 1
            case _ => fib(n-1) + fib(n-2)

    def fibRecursive(n: Int): Int =

        @tailrec
        def fibTailRec(n: Int, a: Int, b: Int): Int =

            if n == 0 then 
                a 
            else if n == 1 then
                b
            else 
                fibTailRec(n-1, b, b+a)

        fibTailRec(n,0,1)


    def fibForward(n: Int): Int =

        if n <= 0 then
            0
        else if n == 1 then
            1
        else
            var n1 = 0
            var n2 = 1
            var m = 2

            while m < n do
                val next = n2 + n1
                n1 = n2 
                n2 = next 
                m += 1

            n1 + n2




    