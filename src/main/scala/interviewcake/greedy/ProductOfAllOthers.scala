package interviewcake.greedy

object ProductOfAllOthers:

    def getProductsOfAllIntsExceptAtIndex(ints: Array[Int]): Array[Int] = 

        val products = Array.fill(ints.size)(1)

        var i = 0
        var j = ints.size-1

        var leftProduct, rightProduct = 1
        
        while i < ints.size && j > -1 do 

            leftProduct = if i == 0 then 1 else leftProduct * ints(i-1)
            rightProduct = if j == (ints.size-1) then 1 else rightProduct * ints(j+1)

            products(i) *= leftProduct
            products(j) *= rightProduct
            
            i += 1
            j -= 1

        products