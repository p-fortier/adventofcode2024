package adventOfCode.dayOne

import kotlin.math.absoluteValue

class App()

fun main() {

    // intro fetch data
    try {
        val input = object {}.javaClass.getResource("/input.txt")!!.readText()

        val results = """\d+""".toRegex()
            .findAll(input)
            .map { it.value.toInt() }
            .withIndex()
            .groupBy { it.index % 2 == 0 }

        val listOne = results[true]
        val listTwo = results[false]

//        val listOne = results
//            .toList()
//            .filterIndexed { index, word -> index % 2 == 0 }
//            .map { it.value.toInt() }
//        val listTwo = results
//            .toList()
//            .filterIndexed { index, word -> index % 2 == 1 }
//            .map { it.value.toInt() }

        //part 1 distance score
        val distance = results[true]!!.sortedBy { it.value }
            .zip(results[false]!!.sortedBy {it.value})
            .map { (it.first.value - it.second.value).absoluteValue
        }.sum()
        println("Distance: $distance")

        //part 2 similarity score
        val similarity = listOne?.map { one ->
            one.value * (listTwo?.count { it.value.equals(one.value) }!!)
        }?.sum()
        println("Similarity: $similarity")
    } catch (_: NullPointerException) {
        println("Wrong file")
    }
}
