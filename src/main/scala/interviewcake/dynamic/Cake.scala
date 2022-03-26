package interviewcake.dynamic

object Cake:

    case class CakeType(weight: Int, value: Int)

    def maxDuffelBagValue(cakeTypes: Array[CakeType], capacity: Int): Int =

        val cakes = cakeTypes.filter(_.value > 0).sortWith(_.weight < _.weight)

        if cakes.length == 0 then
            0
        else if cakes(0).weight == 0 then
            throw new RuntimeException("Max value is infinity")
        else
            val maxValues = Array.fill(capacity+1)(0)

            for 
                n <- 1 to capacity
                cake <- cakes
                if cake.weight <= n
            do
                maxValues(n) = maxValues(n) max (cake.value + maxValues(n-cake.weight))

            maxValues(capacity)


    @main def TryCake() =

        val cakeTypes = Array(CakeType(7,160), CakeType(3,90), CakeType(2,15))
        println(maxDuffelBagValue(cakeTypes, 20))
        println(maxDuffelBagValue(cakeTypes, 0))

        val badCakeTypes = Array(CakeType(7,160), CakeType(3,90), CakeType(2,15), CakeType(0,0))
        println(maxDuffelBagValue(badCakeTypes, 20))

        val veryBadCakeTypes = Array(CakeType(7,160), CakeType(3,90), CakeType(2,15), CakeType(0,1))
        println(maxDuffelBagValue(veryBadCakeTypes, 20))