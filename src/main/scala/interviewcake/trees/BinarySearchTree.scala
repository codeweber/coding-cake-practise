package interviewcake.trees

import math.Ordering.Implicits.infixOrderingOps

object BinarySearchTree:

    enum Tree[+T]:
        case Leaf(value: T)
        case Branch(value: T, left: Tree[T], right: Tree[T]) 


    def isBinarySearchTree[T:Ordering](tree: Tree[T]): Boolean = 

        import Tree.*

        def foo(t: Tree[T]): (Boolean, T, T) =

            t match
                case Leaf(v) => (true, v, v) 
                case Branch(v, l, r) => 

                    val (isBalancedLeft, leftMin, leftMax) = foo(l) 
                    if isBalancedLeft && leftMax <= v then
                        val (isBalancedRight, rightMin, rightMax) = foo(r)
                        (isBalancedRight && rightMin >= v, leftMin min rightMin min v, leftMax max rightMax max v)
                    else (false, leftMin, leftMax)

        foo(tree)._1


    def isBinarySearchTreeIterative[T:Ordering](tree: Tree[T]): Boolean = 

        import Tree.*

        import scala.collection.mutable.Stack
        val nodes = new Stack[(Tree[T], Option[T], Option[T])]

        var isBinarySearchTree = true 

        nodes.push((tree, None, None))

        while isBinarySearchTree && !nodes.isEmpty do

            val (node, optionMin, optionMax) = nodes.pop 

            val v = node match
                case Leaf(v) =>
                    v
                case Branch(v, l, r) =>
                    nodes.push((l, optionMin, Some(v)))
                    nodes.push((r, Some(v), optionMax))
                    v

            isBinarySearchTree = optionMin.map(v >= _).getOrElse(true) && optionMax.map(v <= _).getOrElse(true)


        isBinarySearchTree
