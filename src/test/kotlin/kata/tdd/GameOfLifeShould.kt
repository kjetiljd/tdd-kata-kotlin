package kata.tdd

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class GameOfLifeShould {

    @Test
    fun `dead cell with three live neighbours will be live`() {
        val deadCell = Cell(false)

        val nextGeneration = deadCell.nextGeneration(3)

        val liveCell = Cell(true)
        assertEquals(liveCell, nextGeneration)
    }
}

data class Cell(val alive: Boolean) {
    fun nextGeneration(liveNeighbours: Int) = Cell(true)
}
