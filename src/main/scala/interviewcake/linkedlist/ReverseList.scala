package interviewcake.linkedlist

object ReverseList:

    class LinkedListNode(var value: Int, var next: LinkedListNode)

    def reverseInPlace(startNode: LinkedListNode): LinkedListNode =

        var node1 = startNode 
        var node2 = if node1 != null then node1.next else null

        if node2 == null then
            //we are already at the end; nothing to reverse
            node1
        else
            //set startNode to lastNode, so point to null
            node1.next = null
            var node3 = node2.next 
            node2.next = node1

            while node3 != null do 

                node1 = node2
                node2 = node3
                node3 = node2.next
                node2.next = node1

            node2