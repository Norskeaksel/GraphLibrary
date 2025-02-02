package Examples

import graphClasses.DFS
import graphClasses.Graph
import graphClasses.readInts

//https://codeforces.com/problemset/problem/893/C

fun rumor(): Long {
    val g = Graph()
    val (n, m) = readInts(2)
    val c = readInts(n)
    repeat(n) {
        g.addNode(it + 1)
    }
    repeat(m) {
        val (x, y) = readInts(2)
        g.connect(x, y)
    }
    val dfs = DFS(g.getAdjacencyList())
    val components = mutableListOf<List<Int>>()
    for (i in 0 until g.size()) {
        if (dfs.visited[i]) continue
        dfs.dfsRecursive(i)
        val component = dfs.getCurrentVisitedIds()
        if (component.isNotEmpty())
            components.add(component)
    }

    System.err.println(components)
    var sum = 0L
    components.forEach { component ->
        val min = component.map { c[it] }.min()
        sum += min
    }
    return sum

}

fun main() {
    println(rumor())
}
