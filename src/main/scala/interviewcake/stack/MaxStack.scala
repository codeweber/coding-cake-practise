package interviewcake.stack

import scala.collection.mutable.Stack

object MaxStack:


    class MaxStack:

        private val maxValStack = new Stack[Int]
        private val stack = new Stack[Int]

        def pop(): Int = 
            val x = stack.pop

            if x == maxValStack.head then
                maxValStack.pop 

            x
             
        def push(elem: Int): Unit = 

            stack.push(elem)

            if maxValStack.isEmpty || elem >= maxValStack.head then
                maxValStack.push(elem)

            

        def getMax: Int = 
            maxValStack.head





