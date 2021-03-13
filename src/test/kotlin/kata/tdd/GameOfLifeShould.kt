package kata.tdd

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GameOfLifeShould {

    // 110
    // 1x0
    // 000
    @Test
    fun `dead cell with three live neighbours will be live`() {
        val allLiveCells = listOf(Pair(-1, -1), Pair(0, -1), Pair(-1, 0))
        val deadCell = Cell(0, 0, false)

        val nextGeneration = deadCell.nextGeneration(allLiveCells)

        val liveCell = Cell(0, 0, true)
        assertEquals(liveCell, nextGeneration)
    }

    // 110
    // 1x0
    // 000
    @Test
    fun `cell with 3 live neighbors count`() {
        val allLiveCells = listOf(Pair(-1, -1), Pair(0, -1), Pair(-1, 0))
        val THEcell = Cell(0, 0)

        val liveNeighbors = THEcell.liveNeighborsCount(allLiveCells)

        assertEquals(3, liveNeighbors)
    }
}

