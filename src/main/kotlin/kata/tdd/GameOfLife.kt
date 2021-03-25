package kata.tdd

typealias Cell = Pair<Int, Int>
typealias Board = List<Cell>

fun Cell.isAlive(board: Board) = board.contains(this)

fun Board.nextGeneration() =
    this.flatMap { it.neighborhood }
        .distinct()
        .filter { it.willLive(this) }

private fun Cell.willLive(board: Board) =
    liveNeighbors(board) == 3
            ||(isAlive(board) && liveNeighbors(board) == 2)

private fun Cell.liveNeighbors(board: Board) =
    neighbors.filter { it.isAlive(board) }.size

private val Cell.neighborhood: List<Cell>
    get() = neighbors + this

private val Cell.neighbors: List<Cell>
    get() =
        (-1..1)
            .map { x -> (-1..1).map{ y -> Pair(x,y) } }
            .flatten()
            .filter { !(it.first == 0 && it.second == 0) }
            .map { delta -> Cell(first + delta.first, second + delta.second) }

