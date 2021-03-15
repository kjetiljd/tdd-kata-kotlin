package kata.tdd

import java.lang.Integer.*
import java.lang.Thread.sleep

fun main(args: Array<String>) {
    var board = """
        1100000010000000
        1100000100000111
        0000000111000000
    """.board

    var minX = MAX_VALUE
    var minY = MAX_VALUE
    var maxX = MIN_VALUE
    var maxY = MIN_VALUE

    while (true) {
        minX = min(minX, board.minOf { it.first })
        minY = min(minY, board.minOf { it.second })
        maxX = max(maxX, board.maxOf { it.first })
        maxY = max(maxY, board.maxOf { it.second })
        (minY..maxY).forEach { y ->
            (minX..maxX).forEach{ x ->
                print(if (Cell(x,y).isAlive(board)) "X" else "_")
            }
            println()
        }
        println()
        sleep(300)
        board = board.nextGeneration()
    }
}

val String.board: Board
    get() = cellsFilteredBy('+', '1')

fun String.cellsFilteredBy(vararg chars: Char) =
    this.trimIndent()
        .split("\n")
        .mapIndexed { y, row ->
            row.mapIndexed { x, cell ->
                if (cell in chars) Cell(x, y) else null
            }
        }
        .flatten()
        .filterNotNull()
