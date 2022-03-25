package interviewcake.greedy

import org.scalatest.flatspec.AnyFlatSpec

class AppleStocksSpec extends AnyFlatSpec:

    import AppleStocks.*

    "getMaxProfit" should "work for a simple example" in {

        val stockPrices = Array(10, 7, 5, 8, 11, 9)

        assert(getMaxProfit(stockPrices) == 6)

    }


    it should "work for a monotonically increasing stock" in {

        val stockPrices = (1 to 10).toArray

        assert(getMaxProfit(stockPrices) == 9)

    }

    it should "work for a monotonically decreasing stock" in {

        val stockPrices = (1 to 10 by 2).reverse.toArray

        assert(getMaxProfit(stockPrices) == -2)

    }

    it should "work for a monotonically decreasing stock with large drops followed by a small drop" in {

        val stockPrices = (1 to 10 by 2).reverse.toArray ++ Array(0)

        assert(getMaxProfit(stockPrices) == -1)

    }

    it should "work for a stock who's price decreases sharply and recovers" in {

        val stockPrices = Array(100,101,50,75,74)

        assert(getMaxProfit(stockPrices) == 25)

    }

    it should "work for a stock who's price with an early min" in {

        val stockPrices = Array(110, 100, 110,105,120,110)

        assert(getMaxProfit(stockPrices) == 20)

    }

    it should "work for a stock who's price with an early min and late max" in {

        val stockPrices = Array(110, 100, 110,105,120,110,115,114,119,118,123)

        assert(getMaxProfit(stockPrices) == 23)

    }