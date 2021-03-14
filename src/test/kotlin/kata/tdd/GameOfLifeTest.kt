package kata.tdd

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GameOfLifeTest {

    @Test
    fun `Board accepts live cell coordinate`() {
        Board().setAlive(Pair(0,0))
    }

    @Test
    fun `Board can list live cell`() {
        val board = Board()
        board.setAlive(Pair(0,0))

        val liveCells = board.liveCells()

        assertEquals(listOf(Pair(0,0)), liveCells)
    }
}
