package examples
//https://codeforces.com/problemset/problem/20/C
import graphClasses.Dijkstra
import graphClasses.IntGraph
import graphClasses.getPath
import graphClasses.readInts

fun main(){
    val (n,m) = readInts(2)
    val g = IntGraph()
    repeat(n+1){
        g.addNodes(it)
    }
    repeat(m){
        val (u,v, w) = readInts(3)
        g.connect(u,v, w.toDouble())
    }
    val dijkstra = Dijkstra(g.getAdjacencyList())
    dijkstra.dijkstra(1)
    val path = getPath(n, dijkstra.parents)
    if(path.size == 1 && path[0] !=1){
        println(-1)
        return
    }
    path.forEach{
        print("$it ")
    }
}