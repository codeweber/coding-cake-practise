package interviewcake.stack

import scala.collection.mutable.Stack

object QueueFromStack:

    class queueStack[T]:

        private val in = new Stack[T]
        private val out = new Stack[T]


        def enqueue(elem: T): Unit  = 

            if in.isEmpty && out.isEmpty then
                out.push(elem)
            else
                in.push(elem)

        def dequeue(): T = 

            if out.isEmpty then
                while !in.isEmpty do 
                    out.push(in.pop)
               
            out.pop