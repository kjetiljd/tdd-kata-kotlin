package kata.tdd

typealias Cell = Pair<Int, Int>

typealias Board = List<Cell>

fun Board.isAlive(cell: Cell): Boolean = cell.isAlive(this)

fun Board.nextGeneration() =
    this
        .flatMap { it.neighborhood }
        .distinct()
        .filter { it.willLive(this) }

private fun Cell.isAlive(board: Board) = board.contains(this)

private fun Cell.willLive(liveCells: Board): Boolean {
    val liveNeighbors = liveNeighbors(liveCells)
    return (isAlive(liveCells) && liveNeighbors == 2) || liveNeighbors == 3
}

private fun Cell.liveNeighbors(liveCells: Board) =
    neighbors.filter { it.isAlive(liveCells) }.size

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


