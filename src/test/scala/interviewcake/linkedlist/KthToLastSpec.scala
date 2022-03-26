package interviewcake.linkedlist

import org.scalatest.flatspec.AnyFlatSpec

class KthToLastSpec extends AnyFlatSpec:

    import KthToLast.*

    "kthToLastNode" should "do something" in {

        val nodeA = new LinkedListNode("A", null)
        val nodeB = new LinkedListNode("B", null)
        val nodeC = new LinkedListNode("C", null)
        val nodeD = new LinkedListNode("D", null)
        val nodeE = new LinkedListNode("E", null)

        nodeA.next = nodeB
        nodeB.next = nodeC
        nodeC.next = nodeD
        nodeD.next = nodeE

        assert(kthToLastNode(nodeA, 1) == nodeE && kthToLastNode(nodeA, 2) == nodeD)

    }

    "kthToLastNode" should "return null if k is longer then length of list" in {

        val nodeA = new LinkedListNode("A", null)
        val nodeB = new LinkedListNode("B", null)
        
        nodeA.next = nodeB
        
        assert(kthToLastNode(nodeA, 1) == nodeB  && kthToLastNode(nodeA, 2) == nodeA && kthToLastNode(nodeA, 3) == null)

    }