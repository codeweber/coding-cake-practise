package interviewcake.trees

import scala.collection.mutable.{Set => mSet}

object GraphColour:

    class GraphNode(val label: String, var colour: Option[Int]):

        private val neighbours = mSet.empty[GraphNode]

        def getNeighbours: Set[GraphNode] = Set.from(neighbours)

        def addNeighbour(n: GraphNode): Unit = neighbours.add(n)

        def addNeighbours(ns: GraphNode*): Unit = neighbours.addAll(ns)

        def this(label: String) =
            this(label, None)
    
    def createGraphColouring(graph: Array[GraphNode], maxDegree: Int): Unit = 
        
        import scala.collection.mutable.Queue
        val frontier = Queue.empty[GraphNode]

        frontier.enqueue(graph(0))

        while !frontier.isEmpty do

            val node = frontier.dequeue

            import scala.collection.mutable.HashSet
            val colours = HashSet.from(0 to maxDegree)

            // Determine all colours that have currently been assigned
            if node.colour.isDefined then
                colours.remove(node.colour.get)

            val localNodes = node.getNeighbours
            for 
                localNode <- localNodes
                colour <- localNode.colour
            do colours.remove(colour)

            // Get an iterator to remaining colours
            val freeColours = colours.iterator

            // Set the colours   
            if !node.colour.isDefined then
                if freeColours.hasNext then
                    node.colour = Some(freeColours.next) 
                else
                    throw new IllegalStateException("Insufficient colours!")

            for 
                localNode <- localNodes
            do 
                if !localNode.colour.isDefined then
                    if freeColours.hasNext then
                        node.colour = Some(freeColours.next) 
                    else
                        throw new IllegalStateException("Insufficient colours!")  
                    frontier.enqueue(localNode)

        end while



    @main def TryGraphColour() = 

        val nodeA = GraphNode("a")
        val nodeB = GraphNode("b")
        val nodeC = GraphNode("c")

        nodeA.addNeighbour(nodeB)
        nodeB.addNeighbour(nodeA)
        nodeB.addNeighbour(nodeC)
        nodeC.addNeighbour(nodeB)

        val graph = Array(nodeA, nodeB, nodeC)

        createGraphColouring(graph,2)

        graph.foreach(x => println(s"Node ${x.label} colour: ${x.colour}"))

    @main def TryGraphColourCyclic() = 

        val nodeA = GraphNode("a")
        val nodeB = GraphNode("b")
        val nodeC = GraphNode("c")
        val nodeD = GraphNode("d")

        nodeA.addNeighbour(nodeB)
        nodeB.addNeighbour(nodeA)

        nodeA.addNeighbour(nodeD)
        nodeD.addNeighbour(nodeA)

        nodeB.addNeighbour(nodeC)
        nodeC.addNeighbour(nodeB)

        nodeC.addNeighbour(nodeD)
        nodeD.addNeighbour(nodeC)

        val graph = Array(nodeA, nodeB, nodeC, nodeD)

        createGraphColouring(graph,2)

        graph.foreach(x => println(s"Node ${x.label} colour: ${x.colour}"))

