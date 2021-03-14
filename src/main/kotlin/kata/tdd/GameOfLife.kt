package kata.tdd

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

typealias Cell = Pair<Int, Int>

class Board(private vararg val liveCells: Cell) {

    fun liveCells(): List<Cell> {
        return liveCells.asList()
    }

    fun nextGeneration(): Board {
        return Board(*liveCells
            .flatMap { it.neighborhood }
            .distinct()
            .filter { consider(contains(it), it.neighbors.filter { n -> contains(n) }.size) }
            .toTypedArray()
        )
    }

    private fun consider(alive: Boolean, liveNeighbors: Int) =
        when {
            alive && liveNeighbors == 2 -> true
            liveNeighbors == 3 -> true
            else -> false
        }

    fun contains(cell: Cell): Boolean =
        liveCells.contains(cell)
}
