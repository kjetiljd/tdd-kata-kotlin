package kata.tdd

typealias Cell = Pair<Int, Int>

class Board(private vararg val liveCells: Cell) {

    fun liveCells(): List<Cell> {
        return liveCells.asList()
    }

    fun nextGeneration(): Board {
        return Board()
    }

    fun contains(cell: Cell): Boolean =
        liveCells.contains(cell)
}