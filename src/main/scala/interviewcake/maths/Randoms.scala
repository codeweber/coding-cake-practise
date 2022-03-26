package interviewcake.maths

import scala.util.Random

object Randoms:


    val rand = Random(42)

    def rand7(): Int = rand.between(1,8)
    def rand5(): Int = rand.between(1,6)

    def rand5from7(): Int = 
        var num = rand7()
        while num > 5 do
            num = rand7()

        num

    def rand7from5(): Int = 
        
        var output = Option.empty[Int]

        while output.isEmpty do 

            val num1 = rand5()
            val num2 = rand5()

            val sum = num1 + num2

            if sum >= 3 && sum <= 9 then 

                val relativeProb = 
                    if sum <= 6 then 
                        sum - 1
                    else 
                        11 - sum


                var num3 = rand5()
                while num3 > relativeProb do
                    num3 = rand5()

                if num3 == 1 then
                    output = Some(sum - 2)
                

        output.get

    def rand7from5V2(): Int = 
        
        var output = Option.empty[Int]

        while output.isEmpty do 

            val sum = (rand5()-1) * 5 + rand5()

            if sum <= 21 then 
                output = Some(1 + sum%7)
                
        output.get

    def checkUniform(gen: () => Int): Boolean =
        
        import scala.collection.mutable.HashMap

        val counter = new HashMap[Int,Int]
        val numTrials = 10000

        for i <- 1 to numTrials do 
            val num = gen()
            val times = counter.getOrElse(num,0)
            counter.update(num, times + 1)

        val p = 1.0/counter.size 
        val mean = numTrials * p
        val std = scala.math.sqrt(numTrials*p*(1-p))

        println("Observations:")
        println(counter)
        println("Standard Deviations")
        val deviations = counter.map( (k,v) => (k, (v - mean)/ std) )
        println(deviations)

        val isUniform = deviations.values.toList.map(_.abs < 3).fold(true)(_ && _)
        isUniform


    @main def TryRandoms() =

        val isUniform = checkUniform(rand7)
        println(s"Is rand7 uniform: ${if isUniform then "Y" else "N"}")


        val isUniform5from7 = checkUniform(rand5from7)
        println(s"Is rand5from7 uniform: ${if isUniform5from7 then "Y" else "N"}")

        val isUniform7from5 = checkUniform(rand7from5)
        println(s"Is rand7from5 uniform: ${if isUniform7from5 then "Y" else "N"}")

        val isUniform7from5V2 = checkUniform(rand7from5V2)
        println(s"Is rand7from5V2 uniform: ${if isUniform7from5V2 then "Y" else "N"}")