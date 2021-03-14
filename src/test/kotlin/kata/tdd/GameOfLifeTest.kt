package kata.tdd

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class GameOfLifeTest {

    @Test
    fun `nextGeneration of no live cells is no live cells`() {
        val board = Board()

        val nextGeneration = board.nextGeneration()

        assertTrue(nextGeneration.liveCells().isEmpty())
    }

    @Test
    fun `board with one live cell will have no live cells nextGeneration`() {
        val board = Board(Cell(0,0))

        val nextGeneration = board.nextGeneration()

        assertTrue(nextGeneration.liveCells().isEmpty())
    }
}
