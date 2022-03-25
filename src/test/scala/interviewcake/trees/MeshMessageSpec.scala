package interviewcake.trees

import org.scalatest.flatspec.AnyFlatSpec

class MeshMessageSpec extends AnyFlatSpec:

    val network = Map(
        "Min" -> List("William", "Jayden", "Omar"),
        "William" -> List("Min", "Noam"),
        "Jayden" -> List("Min", "Amelia", "Ren", "Noam"),
        "Ren" -> List("Jayden", "Omar"),
        "Amelia" -> List("Jayden", "Adam", "Miguel"),
        "Adam" -> List("Amelia", "Miguel", "Sofia", "Lucas"),
        "Miguel" -> List("Amelia", "Adam", "Liam", "Nathan"),
        "Noam" -> List("Nathan", "Jayden", "William"),
        "Omar" -> List("Ren", "Min", "Scott"),
        "Dean" -> List("Suze", "Neve", "Oliver", "Annabella"),
        "Suze" -> List("Emily", "Tharni"),
        "Tharni" -> List("Tom")
    )

    import MeshMessage.*

    "getShortestRoute" should "work for given example" in {

        val proposedRoute = getShortestRoute(network, "Jayden", "Adam")
        val actualRoute = List("Jayden", "Amelia", "Adam")
        assert(proposedRoute == actualRoute)

    }

    it should "return an empty list when no route is possible" in {

        val proposedRoute = getShortestRoute(network, "Min", "Dean")
        val actualRoute = List.empty[String]
        assert(proposedRoute == actualRoute)

    }
