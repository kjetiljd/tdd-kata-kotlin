package kata.tdd

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class GameOfLifeTest {

    @Test
    fun `nextGeneration of no live cells is no live cells`() {
        val board = Board()

        val nextGeneration = board.nextGeneration()

        assertTrue(nextGeneration.liveCells().isEmpty())
    }
}
