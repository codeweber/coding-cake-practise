package interviewcake.general

import org.scalatest.flatspec.AnyFlatSpec

class RectangleSpec extends AnyFlatSpec:

    import Rectangles.*

    "getIntersection" should "return overlap for overlapping rectangles" in {

        val r1 = Rectangle(10,10,10,10)
        val r2 = Rectangle(15,15,10,10)

        assert(getIntersection(r1,r2) == Some(Rectangle(15,15,5,5)))

    }

    it should "return None when there is no overlap" in {


        val r1 = Rectangle(10,10,10,10)
        val r2 = Rectangle(25,25,10,10)

        assert(getIntersection(r1,r2) == None )


    }

    it should "return the inner rectangle, when one lies entirely inside the other" in {


        val r1 = Rectangle(10,10,10,10)
        val r2 = Rectangle(15,15,1,1)

        assert(getIntersection(r1,r2) == Some(r2) )

    }

    it should "return a rectangle when the two inputs share an edge" in {


        val r1 = Rectangle(10,10,10,10)
        val r2 = Rectangle(20,10,5,5)

        assert(getIntersection(r1,r2) == Some(Rectangle(20,10,0,5)) )

    }

    it should "return a rectangle when the two inputs share a corner" in {


        val r1 = Rectangle(10,10,10,10)
        val r2 = Rectangle(20,20,5,5)

        assert(getIntersection(r1,r2) == Some(Rectangle(20,20,0,0)) )

    }

