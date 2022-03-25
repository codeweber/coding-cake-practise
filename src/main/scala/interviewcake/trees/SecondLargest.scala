package interviewcake.trees

import math.Ordering.Implicits.infixOrderingOps

object SecondLargest:

    enum Tree[+T]:
        case Leaf(value: T)
        case Branch(value: T, left: Tree[T], right: Tree[T])


    @annotation.tailrec
    def getSecondLargest[T:Ordering](tree: Tree[T]): T =

        import Tree.*

        tree match 
            case Leaf(v) => 
                throw new IllegalArgumentException("Input tree must have depth greater than 1")
            case Branch(v, _, Leaf(vMax)) =>
                v
            case Branch(v, _, r) =>
                getSecondLargest(r)
