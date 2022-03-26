package interviewcake.general

object Rectangles:

    case class Rectangle(val leftX: Int, val bottomY: Int, val width: Int, val height: Int)


    def getIntersection(r1: Rectangle, r2: Rectangle): Option[Rectangle] = 

        extension (r: Rectangle)
            def rightX = r.leftX + r.width
            def topY = r.bottomY + r.height

        val lX = r1.leftX max r2.leftX
        val bY = r1.bottomY max r2.bottomY

        val rX = r1.rightX min r2.rightX
        val tY = r1.topY min r2.topY

        val width = rX - lX
        val height = tY - bY

        if width >= 0 && height >= 0 then
            Some(Rectangle(lX, bY, width, height))
        else
            None