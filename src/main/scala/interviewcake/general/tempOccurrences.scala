package interviewcake.general

object tempOccurrences:

    class tempTracker:

        private val occurrences = new Array[Int](111)

        private var maxOcc = 0
        private var modeTemp = 0

        private var numTemp = 0 
        private var sumTemp = 0

        private var maxTemp = Int.MinValue
        private var minTemp = Int.MaxValue

        def insertTemp(temp: Int): Unit = 

            numTemp += 1
            sumTemp += temp 

            maxTemp = maxTemp max temp
            minTemp = minTemp min temp 

            val newOcc = occurrences(temp) + 1
            occurrences(temp) = newOcc

            if newOcc > maxOcc then
                maxOcc = newOcc 
                modeTemp = temp


        def getMaxTemp: Int = maxTemp 

        def getMinTemp: Int = minTemp

        def getMeanTemp: Double = (1.0 * sumTemp) / numTemp 

        def getModeTemp: Int = modeTemp

