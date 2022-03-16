package interviewcake.arrays

object MergingRanges:

    type Meeting = (Int, Int)

    def isMergable(r1: Meeting, r2: Meeting): Boolean =
        
        val (firstMeeting, secondMeeting) =
            if isMeetingEarlier(r1, r2) then
                (r1, r2)
            else (r2, r1)
        
        secondMeeting._1 <= firstMeeting._2
        

    def mergeMeetings(r1: Meeting, r2: Meeting): Meeting = 
        (r1._1 min r2._1, r1._2 max r2._2 )

    def isMeetingEarlier(m1: Meeting, m2:Meeting): Boolean =
        (m1._1 <= m2._1) & (m1._2 < m2._2)

    def sortRanges(ms: List[Meeting]): List[Meeting] = 
        ms.sortWith(isMeetingEarlier)

    def mergeRanges(ms: List[Meeting]): List[Meeting] =

        def mergeSortedRanges(xs: List[Meeting]): List[Meeting] =
            xs match 
                case Nil => Nil 
                case (r1 :: r2 :: rs) if isMergable(r1, r2) =>
                    mergeSortedRanges( mergeMeetings(r1,r2) :: rs ) 
                case (r :: rs) => r :: mergeSortedRanges(rs)


        val sortedMs = sortRanges(ms)
        mergeSortedRanges(sortedMs)


    def mergeArrayRanges(ms: Array[Meeting]): Array[Meeting] =

        val sortedArray = ms.sortWith(isMeetingEarlier)

        val newArray = new Array[Meeting](ms.size)
        var i,j: Int = 0

        var meetingToMerge = sortedArray(0)

        while i < ms.size do
            val currentMeeting = sortedArray(i)
            if isMergable(meetingToMerge, currentMeeting) then
                meetingToMerge = mergeMeetings(meetingToMerge, currentMeeting)
            else 
                newArray(j) = meetingToMerge
                meetingToMerge = currentMeeting
                j += 1
            i+=1

        newArray(j) = meetingToMerge 
        j += 1
        newArray.slice(0,j)


