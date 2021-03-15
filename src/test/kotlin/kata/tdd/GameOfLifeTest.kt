package kata.tdd

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class GameOfLifeTest {

    @Test
    fun `Any live cell with fewer than two live neighbours dies`() {
        val scenario = """
            100
            0+0
            000
            """
        val board = scenario.board

        val nextGeneration = board.nextGeneration()

        assertFalse(scenario.protagonist.isAlive(nextGeneration))
    }

    @Test
    fun `Any live cell with two live neighbours lives on to the next generation`() {
        val scenario = """
            101
            0+0
            000
            """
        val board = scenario.board

        val nextGeneration = board.nextGeneration()

        assertTrue(scenario.protagonist.isAlive(nextGeneration))
    }

    @Test
    fun `Any live cell with three live neighbours lives on to the next generation`() {
        val scenario = """
            101
            0+0
            010
            """
        val board = scenario.board

        val nextGeneration = board.nextGeneration()

        assertTrue(scenario.protagonist.isAlive(nextGeneration))
    }

    @Test
    fun `Any live cell with more than three live neighbours dies, as if by overpopulation`() {
        val scenario = """
            101
            0+1
            010
            """
        val board = scenario.board

        val nextGeneration = board.nextGeneration()

        assertFalse(scenario.protagonist.isAlive(nextGeneration))
    }

    @Test
    fun `Any dead cell with three live neighbours becomes a live cell`() {
        val scenario = """
            101
            0x1
            000
            """
        val board = scenario.board

        val nextGeneration = board.nextGeneration()

        assertTrue(scenario.protagonist.isAlive(nextGeneration))
    }

    @Test
    fun `Glider lives forever`() {
        val glider = """
            010
            100
            111
            """
        var board: Board = glider.board

        repeat(1000) {
            assertEquals(5, board.size)
            board = board.nextGeneration()
        }
        assertEquals(5, board.size)
    }
}
private val String.protagonist: Cell
    get() = cellsFilteredBy('+', 'x').first()
