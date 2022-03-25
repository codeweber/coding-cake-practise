package interviewcake.trees

import scala.annotation.tailrec

object Superbalanced:


    enum Tree[+T]:
        case Leaf(value: T)
        case Branch(value: T, left: Tree[T], right: Tree[T])

    def isSuperbalanced[T](tree: Tree[T]): Boolean = 

        def getMinMaxDepth(t: Tree[T], currentDepth: Int): (Int, Int) = 

            import Tree.*

            t match
                case Leaf(_) => (currentDepth, currentDepth)
                case Branch(_, l, r) => 
                    val leftMinMax =  getMinMaxDepth(l, currentDepth+1)
                    val rightMinMax = getMinMaxDepth(r, currentDepth+1)
                    (leftMinMax._1 min rightMinMax._1, leftMinMax._2 max rightMinMax._2)
                    


        val (minDepth, maxDepth) = getMinMaxDepth(tree, 0)

        maxDepth-minDepth <= 1


    def isSuperbalancedIterative[T](tree: Tree[T]): Boolean = 

        import Tree.*

        var minDepth = Int.MaxValue
        var maxDepth = 0
        var currentDepth = 0

        import scala.collection.mutable.Stack
        val currentLevel = new Stack[Tree[T]]
        val nextLevel = new Stack[Tree[T]]
        
        currentLevel.push(tree)

        while !nextLevel.isEmpty || !currentLevel.isEmpty do 

            if !currentLevel.isEmpty then
                val t = currentLevel.pop 
                t match 
                    case Leaf(_) =>
                        minDepth = minDepth min currentDepth
                        maxDepth = maxDepth max currentDepth
                    case Branch(_,l,r) =>
                        nextLevel.push(l)
                        nextLevel.push(r)
            else if !nextLevel.isEmpty then
                currentDepth += 1
                currentLevel.pushAll(nextLevel.popAll)

        maxDepth-minDepth <= 1

    def isSuperbalancedIterativeV2[T](tree: Tree[T]): Boolean = 

        import Tree.*

        import scala.collection.mutable.{Stack, ListBuffer}

        val currentLevel = new Stack[(Tree[T], Int)]
        currentLevel.push((tree,0))

        val leafDepths = ListBuffer.empty[Int]

        var isSuperbalanced = true

        while isSuperbalanced && !currentLevel.isEmpty do 

            val (t,currentDepth) = currentLevel.pop 
            t match 
                case Leaf(_) =>
                    if !leafDepths.contains(currentDepth) then
                        leafDepths += currentDepth 

                    isSuperbalanced = leafDepths.length < 2 || (leafDepths.length == 2 && (leafDepths(1)-leafDepths(0)).abs <= 1 )

                case Branch(_,l,r) =>
                    currentLevel.push((l, currentDepth+1))
                    currentLevel.push((r, currentDepth+1))
            
        
        isSuperbalanced