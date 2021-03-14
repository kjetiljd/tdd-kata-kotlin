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
            0x0
            000
            """
        val board = Board(*scenario.liveCells)
        val nextGeneration = board.nextGeneration()

        assertFalse(
            nextGeneration
                .liveCells()
                .contains(scenario.protagonist)
        )
    }

}

private val String.protagonist: Pair<Int, Int>
    get() =
        this.trimIndent()
            .split("\n")
            .mapIndexed { y, row ->
                row.mapIndexed { x, cell ->
                    if (cell == '1') Cell(x, y) else null
                }
            }
            .flatten()
            .filterNotNull()
            .first()

private val String.liveCells: Array<Pair<Int, Int>>
    get() =
        this.trimIndent()
            .split("\n")
            .mapIndexed { y, row ->
                row.mapIndexed { x, cell ->
                    if (cell == '1') Cell(x, y) else null
                }
            }
            .flatten()
            .filterNotNull()
            .toTypedArray()
