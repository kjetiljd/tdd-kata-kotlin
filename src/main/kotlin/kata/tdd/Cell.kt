package kata.tdd

data class Cell(val x: Int, val y: Int, val alive: Boolean = false) {
    fun nextGeneration(liveNeighbours: Int) = Cell(x, y, true)

    fun liveNeighborsCount(allLiveCells: List<Pair<Int, Int>>): Int {
        return 3
    }
}