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
    get() = listOf(
        Cell(first - 1, second - 1),
        Cell(first    , second - 1),
        Cell(first + 1, second - 1),
        Cell(first - 1, second),
        Cell(first + 1, second),
        Cell(first - 1, second + 1),
        Cell(first    , second + 1),
        Cell(first + 1, second + 1),
    )
