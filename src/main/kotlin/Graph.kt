class Graph {
    private var nrOfNodes = 0
    private val AdjacencyList = mutableListOf<MutableList<Pair<Double, Int>>>()
    private val node2id = mutableMapOf<Any, Int>()
    private val id2Node = mutableMapOf<Int, Any>()

    fun addNode(node: Any) {
        if (node2id.containsKey(node)) {
            System.err.println("Node already exists")
            return
        }
        node2id[node] = nrOfNodes
        id2Node[nrOfNodes++] = node
        AdjacencyList.add(mutableListOf())
    }

    fun addEdge(node1: Any, node2: Any, weight: Double=1.0) {
        val id1 = node2id[node1] ?: addNode(node1).run { node2id[node1]!! }
        val id2 = node2id[node2] ?: addNode(node2).run { node2id[node2]!! }
        AdjacencyList[id1].add(Pair(weight, id2))
        AdjacencyList[id2].add(Pair(weight, id1))
    }

    fun connect(node1: Any, node2: Any, weight: Double=1.0){
        addEdge(node1, node2, weight)
        addEdge(node2, node1, weight)
    }

    fun getEdges(node: Any): List<Pair<Double, Int>> {
        val id = node2id[node] ?: return emptyList()
        return AdjacencyList[id]
    }

    fun getId(node: Any): Int? = node2id[node]

    fun getAdjacencyList() = AdjacencyList

    fun nodes() = id2Node.values
    fun size() = nrOfNodes
}
