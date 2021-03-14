package kata.tdd

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class GameOfLifeTest {

    @Test
    fun `Board accepts live cell coordinate`() {
        Board(Pair(0,0))
    }

    @Test
    fun `Board can list live cells`() {
        val board = Board(Pair(0,0), Pair(1,1))

        val liveCells = board.liveCells()

        assertEquals(listOf(Pair(0,0), Pair(1,1)), liveCells)
    }

    @Test
    fun `nextGeneration of no live cells is no live cells`() {
        val board = Board()

        val nextGeneration = board.nextGeneration()

        assertTrue(nextGeneration.liveCells().isEmpty())
    }
}
