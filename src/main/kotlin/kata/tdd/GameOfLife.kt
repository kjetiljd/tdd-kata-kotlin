package kata.tdd

typealias Cell = Pair<Int, Int>

class Board(private vararg val liveCells: Cell) {

    fun nextGeneration(): Board {
        return Board(*liveCells
            .flatMap { it.neighborhood }
            .distinct()
            .filter { consider(isAlive(it), it.neighbors.filter { n -> isAlive(n) }.size) }
            .toTypedArray()
        )
    }

    private fun consider(alive: Boolean, liveNeighbors: Int) =
        (alive && liveNeighbors == 2) || liveNeighbors == 3

    fun isAlive(cell: Cell): Boolean = liveCells.contains(cell)
}

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


