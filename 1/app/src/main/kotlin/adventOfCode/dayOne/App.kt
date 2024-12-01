package adventOfCode.dayOne

import kotlin.math.absoluteValue

class App()

fun main() {

    // intro fetch data
    try {
        val input = object {}.javaClass.getResource("/input.txt")!!.readText()

        val results = """\d+""".toRegex().findAll(input)
        val listOne = results
            .toList()
            .filterIndexed { index, word -> index % 2 == 0 }
            .map { it.value.toInt() }
        val listTwo = results
            .toList()
            .filterIndexed { index, word -> index % 2 == 1 }
            .map { it.value.toInt() }

        //part 1 distance score
        val distance = listOne.sorted().zip(listTwo.sorted()).map {
            (it.first - it.second).absoluteValue
        }.sum()
        println("Distance: $distance")

        //part 2 similarity score
        val similarity = listOne.map { one ->
            one * listTwo.count { it.equals(one) }
        }.sum()
        println("Similarity: $similarity")
    } catch (_: NullPointerException) {
        println("Wrong file")
    }
}
