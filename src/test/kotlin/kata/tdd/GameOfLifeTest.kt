package kata.tdd

import org.junit.jupiter.api.Assertions.assertFalse
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
        val board = Board(Cell(0, 0))

        val nextGeneration = board.nextGeneration()

        assertTrue(nextGeneration.liveCells().isEmpty())
    }

    @Test
    fun `Any live cell with fewer than two live neighbours dies`() {
        val scenario = """
            100
            0+0
            000
            """
        val board = Board(*scenario.liveCells)

        val nextGeneration = board.nextGeneration()

        assertFalse(nextGeneration.contains(scenario.protagonist))
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

        assertTrue(nextGeneration.contains(scenario.protagonist))
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

