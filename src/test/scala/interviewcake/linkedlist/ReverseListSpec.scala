package interviewcake.linkedlist

import org.scalatest.flatspec.AnyFlatSpec

class ReverseListSpec extends AnyFlatSpec:

    import ReverseList.*

    "reverseList" should "reverse a given list in place" in {

        val nodeA = new LinkedListNode(0, null)
        val nodeB = new LinkedListNode(1, null)
        val nodeC = new LinkedListNode(2, null)

        nodeA.next = nodeB
        nodeB.next = nodeC

        val newHeadNode = reverseInPlace(nodeA)

        assert(newHeadNode == nodeC && newHeadNode.next == nodeB && newHeadNode.next.next == nodeA && newHeadNode.next.next.next == null)
        
    }

    it should "not reverse a list with one element" in {

        val nodeA = new LinkedListNode(0, null)
        
        val newHeadNode = reverseInPlace(nodeA)

        assert(newHeadNode == nodeA && newHeadNode.next == null)
        
    }


    it should "return null for an input null" in {
        
        val newHeadNode = reverseInPlace(null)

        assert(newHeadNode == null)
        
    }
