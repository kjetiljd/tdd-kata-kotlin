package kata.tdd

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class GameOfLifeTest {

    @Test
    fun `Board accepts live cells`() {
        Board().accept(Cell(0,0))
    }
}
