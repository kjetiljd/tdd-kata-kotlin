package kata.tdd

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
        val board = Board(*scenario.liveCells)

        val nextGeneration = board.nextGeneration()

        assertFalse(nextGeneration.isAlive(scenario.protagonist))
    }

    @Test
    fun `Any live cell with two live neighbours lives on to the next generation`() {
        val scenario = """
            101
            0+0
            000
            """
        val board = Board(*scenario.liveCells)

        val nextGeneration = board.nextGeneration()

        assertTrue(nextGeneration.isAlive(scenario.protagonist))
    }

    @Test
    fun `Any live cell with three live neighbours lives on to the next generation`() {
        val scenario = """
            101
            0+0
            010
            """
        val board = Board(*scenario.liveCells)

        val nextGeneration = board.nextGeneration()

        assertTrue(nextGeneration.isAlive(scenario.protagonist))
    }

    @Test
    fun `Any live cell with more than three live neighbours dies, as if by overpopulation`() {
        val scenario = """
            101
            0+1
            010
            """
        val board = Board(*scenario.liveCells)

        val nextGeneration = board.nextGeneration()

        assertFalse(nextGeneration.isAlive(scenario.protagonist))
    }

    @Test
    fun `Any dead cell with three live neighbours becomes a live cell`() {
        val scenario = """
            101
            0x1
            000
            """
        val board = Board(*scenario.liveCells)

        val nextGeneration = board.nextGeneration()

        assertTrue(nextGeneration.isAlive(scenario.protagonist))
    }
}

private val String.liveCells: Array<Pair<Int, Int>>
    get() = filterBy('+', '1').toTypedArray()

private val String.protagonist: Pair<Int, Int>
    get() = filterBy('+', 'x').first()

private fun String.filterBy(vararg chars: Char) =
    this.trimIndent()
        .split("\n")
        .mapIndexed { y, row ->
            row.mapIndexed { x, cell ->
                if (cell in chars) Cell(x, y) else null
            }
        }
        .flatten()
        .filterNotNull()

