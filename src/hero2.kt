package hero2

import java.io.PrintWriter

val pw = PrintWriter(System.out)
fun main() {
    func()
    pw.flush()
}

fun func() {
    val n = nextInt()
    val selfies = listOfNextInt()
    val count = selfies.max()
    val last = selfies.lastIndexOf(count)
    pw.println(n * (count!! - 1.toBigDecimal()) + last.toBigDecimal() + 1.toBigDecimal())
}

fun next() = readLine()!!
fun nextInt() = next().toBigDecimal()
fun listOfNextInt() = next().split(" ").map { it.toBigDecimal() }