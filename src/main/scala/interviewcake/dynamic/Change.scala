package interviewcake.dynamic

object Change:

    def calcNumChangeWays(amount: Int, denominations: List[Int]): Int = 

        if amount == 0 then
            1 
        else
            denominations match
                case Nil => 0
                case c :: cs if c <= amount => 
                    println(s"Checking ways of making $amount with denominations: $denominations")
                    calcNumChangeWays(amount, cs) + calcNumChangeWays(amount-c, denominations)
                case c :: cs => 
                    println(s"Checking ways of making $amount with denominations: $denominations")
                    calcNumChangeWays(amount, cs)

    def calcNumChangeWaysBottomUp(amount: Int, denominations: List[Int]): Int = 

        import scala.collection.mutable.Queue
        val changeSets = new Queue[(Int, Option[Int])]

        changeSets.enqueue((amount, None))

        for denomination <- denominations do

            var lastAdded = Option.empty[Int]
            
            while lastAdded.isEmpty || lastAdded.get != denomination do

                lastAdded = changeSets.headOption.flatMap(_._2)
                if lastAdded != Some(denomination) then 
                    val (remainingAmount, _) = changeSets.dequeue
                    for 
                        n <- (0 to (remainingAmount/denomination))
                    do changeSets.enqueue((remainingAmount - n*denomination, Some(denomination)))

        changeSets.toList.filter(_._1 == 0).length

    def calcNumChangeWaysBottomUpV2(amount: Int, denominations: List[Int]): Int = 

        if denominations.length == 0 || amount < 0 then
            0
        else            
            val numWaysForN = Array.fill(amount+1)(0)
            numWaysForN(0) = 1

            for
                denomination <- denominations
                i <- denomination to amount
            do
                numWaysForN(i) += numWaysForN(i - denomination)

            numWaysForN(amount)


    def makeChange(amount: Int, denominations: List[Int]): List[List[Int]] = 

        def helper(amount: Int, denominations: List[Int], change: List[List[Int]]): List[List[Int]] = 

            if amount == 0 then
                change 
            else
                denominations match
                    case Nil => Nil
                    case c :: cs if c <= amount => helper(amount-c, denominations, change.map(c :: _)) ++ helper(amount, cs, change)
                    case c :: cs => helper(amount, cs, change)


        helper(amount, denominations, List(List.empty[Int]))

    def makeChangeBottomUp(amount: Int, denominations: List[Int]): List[List[Int]] = 

        import scala.collection.mutable.Queue
        val changeSets = new Queue[(Int, Option[Int], List[Int])]

        changeSets.enqueue((amount, None, Nil))

        for denomination <- denominations do

            var lastAdded = Option.empty[Int]
            
            while lastAdded.isEmpty || lastAdded.get != denomination do

                lastAdded = changeSets.headOption.flatMap(_._2)
                if lastAdded != Some(denomination) then 
                    val (remainingAmount, _, css) = changeSets.dequeue
                    for 
                        n <- (0 to (remainingAmount/denomination))
                    do changeSets.enqueue((remainingAmount - n*denomination, Some(denomination), List.fill(n)(denomination) ++ css))

        changeSets.toList.filter(_._1 == 0).map(_._3)

    @main def TryNumChageWays() =

        val change = calcNumChangeWays(4, List(1,2,3))
        println(change)

    @main def TryNumChageWaysBottomUp() =

        val change = calcNumChangeWaysBottomUp(4, List(1,2,3))
        println(change)

    @main def TryNumChageWaysBottomUpV2() =

        val change = calcNumChangeWaysBottomUpV2(4, List(1,2,3))
        println(change)


    @main def TryMakeChange() =

        val change = makeChange(4, List(1,2,3))
        println(change)

    @main def TryMakeChangeBottomUp() =

        val change = makeChangeBottomUp(4, List(1,2,3))
        println(change)