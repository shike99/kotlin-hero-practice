package practice5

import java.io.PrintWriter

val pw = PrintWriter(System.out)
fun main() {
    func()
    pw.flush()
}

fun func() {
    val n = nextInt()
    val cps = mutableMapOf<Int, List<Int>>()
    repeat(n) {
        val i = listOfNextInt()
        cps[it + 1] = listOf(i[0], i[1])
    }

    val k = nextInt()
    val rs = listOfNextInt()
    val ms = mutableListOf<List<Int>>()
    for ((i, cp) in cps) {
        val r = rs.filter { it >= cp[0] }.min()
        if (r != null) {
            ms.add(listOf(i, rs.indexOf(r) + 1))
        }
    }

    val total = ms.map { cps[it[0]]!![1] }
    pw.println(listOf(ms.size, total.sum()).joinToString(" "))
    for (m in ms) {
        pw.println(m.joinToString(" "))
    }
}

fun next() = readLine()!!
fun nextInt() = next().toInt()
fun listOfNextInt() = next().split(" ").map { it.toInt() }