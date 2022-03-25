package interviewcake.trees

import org.scalatest.flatspec.AnyFlatSpec

class SuperbalancedSpec extends AnyFlatSpec:

    import Superbalanced.*
    import Tree.*

    "isSuperbalanced" should "be true for a tree with depth 0" in {

        val t = Leaf(0)
        assert(isSuperbalanced(t))

    }
    
    it should "be true for a tree with depth 1" in {

        val t = Branch(0,Leaf(1), Leaf(2))
        assert(isSuperbalanced(t))

    }

    it should "be true for a balanced tree with depth 2" in {

        val t = Branch(0,Branch(1, Leaf(3), Leaf(4)), Branch(2, Leaf(5), Leaf(6)))
        assert(isSuperbalanced(t))

    }

    it should "be true for an imbalanced tree with depth 2" in {

        val t = Branch(0,Branch(1, Leaf(3), Leaf(4)), Leaf(2))
        assert(isSuperbalanced(t))

    }

    it should "be false for an imbalanced tree with depth 3" in {

        val t = Branch(0,Branch(1, Leaf(3), Branch(4, Leaf(5), Leaf(6))), Leaf(2))
        assert(!isSuperbalanced(t))

    }

    "isSuperbalancedIterative" should "be true for an imbalanced tree with depth 2" in {

        val t = Branch(0,Branch(1, Leaf(3), Leaf(4)), Leaf(2))
        assert(isSuperbalancedIterative(t))

    }

    it should "be false for an imbalanced tree with depth 3" in {

        val t = Branch(0,Branch(1, Leaf(3), Branch(4, Leaf(5), Leaf(6))), Leaf(2))
        assert(!isSuperbalancedIterative(t))

    }
    
    it should "be true for a tree with depth 0" in {

        val t = Leaf(0)
        assert(isSuperbalancedIterative(t))

    }

    "isSuperbalancedIterativeV2" should "be true for an imbalanced tree with depth 2" in {

        val t = Branch(0,Branch(1, Leaf(3), Leaf(4)), Leaf(2))
        assert(isSuperbalancedIterativeV2(t))

    }

    it should "be false for an imbalanced tree with depth 3" in {

        val t = Branch(0,Branch(1, Leaf(3), Branch(4, Leaf(5), Leaf(6))), Leaf(2))
        assert(!isSuperbalancedIterativeV2(t))

    }
    
    it should "be true for a tree with depth 0" in {

        val t = Leaf(0)
        assert(isSuperbalancedIterativeV2(t))

    }

