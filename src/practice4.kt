package practice4

import java.io.PrintWriter
import java.math.BigDecimal

operator fun BigDecimal.div(other : Long) : BigDecimal = this / other.toBigDecimal()
operator fun BigDecimal.rem(other : Long) : BigDecimal = this % other.toBigDecimal()
operator fun BigDecimal.times(other : Long) : BigDecimal = this * other.toBigDecimal()

val pr = PrintWriter(System.out)
fun main() {
    func()
    pr.flush()
}

fun func() {
    val n = readLine()!!.toInt()
    val order = readLine()!!.split(" ").map { it.toBigDecimal() }
    val reordered = mutableListOf<BigDecimal>()

    for (x in order) {
        if (x % 3 === 0.toBigDecimal() && (x / 3 * 2) % 3 === 0.toBigDecimal()) {
            reordered.add(x)
            break
        }
    }
    if (reordered.size === 0) {
        for (x in order) {
            if (x % 3 === 0.toBigDecimal()) {
                reordered.add(x)
                break
            }
        }
    }

    while (order.size !== reordered.size) {
        val mul = order.find { it == reordered.last() * 2 }
        val div = order.find { it == reordered.last() / 3 }
        if (mul !== null) {
            reordered.add(mul)
        } else if (div !== null) {
            reordered.add(div)
        }
    }

    pr.println(reordered.joinToString(" "))
}