package Examples

import DFS
import Grid

fun day10a(input: List<String>): Long {
    var ans = 0L
    val grid = Grid(input)
    grid.print()
    grid.getNodes().forEach { t ->
        grid.getStraightNeighbours(t).forEach { n ->
            if (n.data == t.data as Char + 1)
                grid.addEdge(t, n)
        }
    }
    grid.getNodes().forEach {
        val dfs = DFS(grid)
        if (it.data != '0')
            return@forEach
        dfs.dfsRecursive(grid.node2Id(it))
        val visitedNines = dfs.getCurrentVisited().count { grid.id2Node(it)?.data == '9' }
        ans += visitedNines
    }
    return ans
}