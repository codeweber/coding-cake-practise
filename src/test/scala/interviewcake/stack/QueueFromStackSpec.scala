package interviewcake.stack

import org.scalatest.flatspec.AnyFlatSpec

class QueueFromStackSpec extends AnyFlatSpec:

    import QueueFromStack.queueStack

    "queueFromStack" should "be FIFO" in {

        val q = new queueStack[Int]

        q.enqueue(1)
        q.enqueue(2)
        q.enqueue(3)

        assert(q.dequeue() == 1)

    }

    it should "dequeue should work after enqueue" in {

        val q = new queueStack[Int]

        q.enqueue(1)

        assert(q.dequeue() == 1)

    }

    it should "be FIFO for all inputs" in {

        val q = new queueStack[Int]

        q.enqueue(1)
        q.enqueue(2)
        q.enqueue(3)

        assert(q.dequeue() == 1 && q.dequeue() == 2 && q.dequeue() == 3)

    }
