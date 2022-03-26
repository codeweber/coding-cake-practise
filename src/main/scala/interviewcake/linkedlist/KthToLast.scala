package interviewcake.linkedlist


object KthToLast:

    class LinkedListNode(var value: String, var next: LinkedListNode)

    def kthToLastNode(startNode: LinkedListNode, k: Int): LinkedListNode =

        var trailingNode = startNode
        var currentNode = startNode
        var nodesTrailing = 0

        while currentNode.next != null do

            currentNode = currentNode.next 
            nodesTrailing += 1

            if nodesTrailing >= k then
                trailingNode = trailingNode.next
                nodesTrailing -= 1

        if nodesTrailing == k - 1 then
            trailingNode
        else 
            null

