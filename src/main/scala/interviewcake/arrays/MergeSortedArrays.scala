package interviewcake.arrays

object MergeSortedArrays:

    def mergeSortedArrays(xs: Array[Int], ys: Array[Int]): Array[Int] = 

        val zs = new Array[Int](xs.size + ys.size)

        var i,j,k = 0

        while i < zs.size do

            val nextVal = 
                if (j < xs.size) && ( (k >= ys.size) || (xs(j) < ys(k)) )  then 
                    val jCurrent = j
                    j += 1
                    xs(jCurrent)   
                else 
                    val kCurrent = k
                    k += 1
                    ys(kCurrent)

            zs(i) = nextVal
            i += 1

        zs