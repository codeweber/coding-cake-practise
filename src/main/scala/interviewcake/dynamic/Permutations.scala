package interviewcake.dynamic

import scala.annotation.tailrec

object Permutations:

    def insertCharIntoSetOfString(c: Char, ss: Set[String]): Set[String] = 
        ss.flatMap( s => insertCharIntoString(c, s.toList).map(x => x.mkString).toSet ) 

    def insertCharIntoString(c: Char, s: List[Char]): List[List[Char]] = 

        s match
            case Nil => List(c :: Nil)
            case x :: xs => (c :: s) :: (insertCharIntoString(c, xs).map(y => x :: y))

    def permuteString(s: String): Set[String] = 

        permute(s.toList).map(_.mkString).toSet

    def permute[T](s: List[T]): List[List[T]] = 

        s match 
            case Nil => List(Nil)
            case x :: xs => permute(xs).flatMap( insert(x, _) )


    def insert[T](x: T, xs: List[T]): List[List[T]] = 
        
        xs match
            case Nil => List(List(x))
            case y :: ys => (x :: xs) :: insert(x, ys).map(y :: _)


    def reverseList[T](xs: List[T]): List[T] =

        @tailrec
        def reverseListHelper(ys: List[T], agg: List[T]): List[T] =

            ys match
                case Nil => agg
                case z :: zs => reverseListHelper(zs, z :: agg)


        reverseListHelper(xs, Nil)



    @main def TryPermute() =

        val str = "helo"
        val perms = permuteString(str)
        println(s"Number of permutations found: ${perms.size}")
        println(perms)


    @main def TryReverse() =

        val str = "helo"
        val test = reverseList(str.toList).mkString
        println(test)


        