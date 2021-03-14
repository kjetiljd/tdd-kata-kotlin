package kata.tdd

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class GameOfLifeTest {

    @Test
    fun `Board accepts live cell coordinate`() {
        Board().setAlive(0,0)
    }
}
