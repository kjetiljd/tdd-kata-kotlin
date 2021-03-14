package kata.tdd

typealias Cell = Pair<Int, Int>

class Board(private vararg val liveCells: Cell) {

    fun isAlive(cell: Cell): Boolean = cell.isAlive(liveCells)

    fun nextGeneration() =
        Board(*liveCells
            .flatMap { it.neighborhood }
            .distinct()
            .filter { it.willLive(liveCells) }
            .toTypedArray())
}

private fun Cell.isAlive(liveCells: Array<out Cell>) =
    liveCells.contains(this)

private fun Cell.willLive(liveCells: Array<out Cell>): Boolean {
    val liveNeighbors = liveNeighbors(liveCells)
    return (isAlive(liveCells) && liveNeighbors == 2) || liveNeighbors == 3
}

private fun Cell.liveNeighbors(liveCells: Array<out Cell>) =
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


