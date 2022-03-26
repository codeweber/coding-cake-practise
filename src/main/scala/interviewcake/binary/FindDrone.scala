package interviewcake.binary

object FindDrone:

    def findUniqueInt(ns: Array[Int]): Int =

        ns.fold(0)(_ ^ _)
