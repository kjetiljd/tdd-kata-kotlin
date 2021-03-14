package kata.tdd

typealias Cell = Pair<Int, Int>

class Board {
    val liveCells = mutableListOf<Cell>()

    fun setAlive(coordinate: Cell) {
        liveCells.add(coordinate)
    }

    fun liveCells(): List<Cell> {
        return liveCells
    }

    fun nextGeneration() {
    }
}