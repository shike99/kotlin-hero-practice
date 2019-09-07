package hero1

import java.io.PrintWriter

val pw = PrintWriter(System.out)
fun main() {
    func()
    pw.flush()
}

fun func() {
    val n = nextInt()
    val problems = listOfNextInt()
    val output = if (problems.distinct().size >= 3) {
        problems.distinct().sorted().slice(0 until 3).map { problems.lastIndexOf(it) + 1 }
    } else {
        listOf(-1, -1, -1)
    }
    pw.println(output.joinToString(" "))
}

fun next() = readLine()!!
fun nextInt() = next().toBigDecimal()
fun listOfNextInt() = next().split(" ").map { it.toBigDecimal() }