package interviewcake.trees

import org.scalatest.flatspec.AnyFlatSpec

class BinarySearchTreeSpec extends AnyFlatSpec:

    import BinarySearchTree.*
    import Tree.*

    "isBinarySearchTree" should "be true for a tree with a single root node" in {
        val t = Leaf(0)
        assert(isBinarySearchTree(t))
    }

    it should "be true for a tree an ordered depth 1 tree" in {
        val t = Branch(1, Leaf(0), Leaf(2))
        assert(isBinarySearchTree(t))
    }

    it should "be false for a tree an unordered depth 1 tree" in {
        val t = Branch(1, Leaf(2), Leaf(0))
        assert(!isBinarySearchTree(t))
    }

    it should "be false for an unsorted tree where children are ordered relative to parent" in {
        val t = Branch(50, Branch(30, Leaf(20), Leaf(60)), Branch(80, Leaf(70), Leaf(90)))
        assert(!isBinarySearchTree(t))
    }

    it should "be true for a sorted tree where children are ordered relative to parent" in {
        val t = Branch(50, Branch(30, Leaf(20), Leaf(40)), Branch(80, Leaf(70), Leaf(90)))
        assert(isBinarySearchTree(t))
    }

    it should "be false for an unsorted tree (leaf)" in {
        val t = Branch(50, Branch(30, Leaf(40), Leaf(20)), Branch(80, Leaf(70), Leaf(90)))
        assert(!isBinarySearchTree(t))
    }

    it should "be false for an unsorted tree (branch)" in {
        val t = Branch(50, Branch(80, Leaf(70), Leaf(90)), Branch(30, Leaf(20), Leaf(40)))
        assert(!isBinarySearchTree(t))
    }

    "isBinarySearchTreeIterative" should "be true for a tree with a single root node" in {
        val t = Leaf(0)
        assert(isBinarySearchTreeIterative(t))
    }

    it should "be true for a tree an ordered depth 1 tree" in {
        val t = Branch(1, Leaf(0), Leaf(2))
        assert(isBinarySearchTreeIterative(t))
    }

    it should "be false for a tree an unordered depth 1 tree" in {
        val t = Branch(1, Leaf(2), Leaf(0))
        assert(!isBinarySearchTreeIterative(t))
    }

    it should "be false for an unsorted tree where children are ordered relative to parent" in {
        val t = Branch(50, Branch(30, Leaf(20), Leaf(60)), Branch(80, Leaf(70), Leaf(90)))
        assert(!isBinarySearchTreeIterative(t))
    }

    it should "be true for a sorted tree where children are ordered relative to parent" in {
        val t = Branch(50, Branch(30, Leaf(20), Leaf(40)), Branch(80, Leaf(70), Leaf(90)))
        assert(isBinarySearchTreeIterative(t))
    }

    it should "be false for an unsorted tree (leaf)" in {
        val t = Branch(50, Branch(30, Leaf(40), Leaf(20)), Branch(80, Leaf(70), Leaf(90)))
        assert(!isBinarySearchTreeIterative(t))
    }

    it should "be false for an unsorted tree (branch)" in {
        val t = Branch(50, Branch(80, Leaf(70), Leaf(90)), Branch(30, Leaf(20), Leaf(40)))
        assert(!isBinarySearchTreeIterative(t))
    }