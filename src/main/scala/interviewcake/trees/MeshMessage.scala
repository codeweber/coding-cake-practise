package interviewcake.trees

object MeshMessage:

    def getShortestRoute(network: Map[String, List[String]], source: String, destination: String): List[String] =

        import scala.collection.mutable.Queue
        val paths = Queue.empty[List[String]]
        paths.enqueue(List(destination))

        import scala.collection.mutable.Set 
        val visitedNodes = Set.empty[String]
        visitedNodes.add(destination)

        var viablePath: Option[List[String]] = if destination == source then Option(List(source)) else Option.empty[List[String]]

        while viablePath.isEmpty && !paths.isEmpty do

            val path = paths.dequeue
            val currentNode = path.head
            val neighbours = network.getOrElse(currentNode, List.empty[String])

            for
                neighbour <- neighbours
            do 
                if visitedNodes.add(neighbour) then
                    val newPath = neighbour :: path
                    paths.enqueue(newPath)

                    if neighbour == source then
                        viablePath = Some(newPath)


        viablePath.getOrElse(List.empty[String])
