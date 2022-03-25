package interviewcake.greedy

object AppleStocks:

    def getMaxProfitInitial(stockPrices: Array[Int]): Int = 

        if stockPrices.size <= 1 then
            throw new IllegalArgumentException("stockPrices must have size greater than 1")


        var maxPeriodProfit = Int.MinValue
        var i, periodProfit = 0

        var minValue = Int.MaxValue 
        var minValuePrePeriod = Int.MaxValue
        var maxValuePostPeriod = Int.MaxValue

        while i < stockPrices.size do 

            val currentPrice = stockPrices(i)
            if currentPrice < minValue then
                minValue = currentPrice
            
            if currentPrice > maxValuePostPeriod then 
                maxValuePostPeriod = currentPrice

            val priceDifference = 
                if i+1 < stockPrices.size then
                    stockPrices(i+1) - stockPrices(i)
                else Int.MinValue

            if priceDifference >= 0 then
                periodProfit += priceDifference
            else if periodProfit > 0 then
                if periodProfit > maxPeriodProfit then
                    
                    maxPeriodProfit = periodProfit
                    minValuePrePeriod = minValue
                    maxValuePostPeriod = currentPrice

                periodProfit = 0
            else 
                if priceDifference > maxPeriodProfit then
                    maxPeriodProfit = priceDifference

            i += 1

        if maxPeriodProfit > 0 then
            maxValuePostPeriod - minValuePrePeriod
        else maxPeriodProfit


    def getMaxProfit(stockPrices: Array[Int]): Int = 

        if stockPrices.size <= 1 then
            throw new IllegalArgumentException("stockPrices must have size greater than 1")


        var maxProfit = stockPrices(1) - stockPrices(0)
        var minPrice = stockPrices(0)
        
        var i = 1
        while i < stockPrices.size do 

            val currentPrice = stockPrices(i)
            val profit = currentPrice - minPrice 

            maxProfit = maxProfit max profit 
            minPrice = minPrice min currentPrice

            i += 1

        maxProfit
