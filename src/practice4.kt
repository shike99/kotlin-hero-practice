package practice4

import java.io.PrintWriter
import java.math.BigDecimal

operator fun BigDecimal.div(other : Long) : BigDecimal = this / other.toBigDecimal()
operator fun BigDecimal.rem(other : Long) : BigDecimal = this % other.toBigDecimal()
operator fun BigDecimal.times(other : Long) : BigDecimal = this * other.toBigDecimal()

val pw = PrintWriter(System.out)
fun main() {
    func()
    pw.flush()
}

fun func() {
    val n = readLine()!!.toInt()
    val order = readLine()!!.split(" ").map { it.toBigDecimal() }
    val reordered = mutableListOf<BigDecimal>()

    for (x in order) {
        reordered.add(x)
        while (reordered.size !== n) {
            val div = order.find { reordered.last() % 3 == 0.toBigDecimal() && it == reordered.last() / 3 }
            val mul = order.find { it == reordered.last() * 2 }
            if (mul === null && div === null) {
                reordered.clear()
                break
            }
            if (div !== null) {
                reordered.add(div)
            } else if (mul !== null) {
                reordered.add(mul)
            }
        }
    }

    pw.println(reordered.joinToString(" "))
}