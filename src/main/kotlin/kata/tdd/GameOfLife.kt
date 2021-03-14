package kata.tdd

typealias Cell = Pair<Int, Int>

class Board(private vararg val liveCell: Cell) {

    fun liveCells(): List<Cell> {
        return liveCell.asList()
    }

    fun nextGeneration(): Board {
        return Board()
    }
}