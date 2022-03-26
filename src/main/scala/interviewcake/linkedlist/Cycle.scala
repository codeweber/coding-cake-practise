package interviewcake.linkedlist

object Cycle:

    class LinkedListNode(var value: Int, var next: LinkedListNode)


    def containsCycle(node: LinkedListNode): Boolean =

        val initialNode = node
        
        var previousNode = node
        var currentNode = node.next
        var nextNode = if currentNode == null then null else currentNode.next

        var hasCycle = false

        while nextNode != null && !hasCycle do

            currentNode.next = previousNode

            previousNode = currentNode
            currentNode = nextNode 
            nextNode = currentNode.next

            if nextNode == initialNode then
                hasCycle = true


        hasCycle


