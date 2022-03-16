package interviewcake.arrays

object CheckFIFO:

    def checkServedOrders(tOO: Array[Int], dIO: Array[Int], sO: Array[Int]): Boolean = 

        var iS, iTO, iDI = 0
        var isFIFO = (sO.size == tOO.size + dIO.size)

        while isFIFO && (iS < sO.size) do 

            val currentServed = sO(iS)

            val headValues = List(
                if (iTO < tOO.size) then Some(tOO(iTO)) else None,
                if (iDI < dIO.size) then Some(dIO(iDI)) else None
            ) 
            
            val matchStatus = headValues.map( x => x.map(y => y == currentServed).getOrElse(false))

            isFIFO = matchStatus.foldLeft(false)( _ || _ )
            if matchStatus.head then 
                iTO += 1
            else if matchStatus.tail.head then
                iDI += 1
        
            iS += 1

        isFIFO

