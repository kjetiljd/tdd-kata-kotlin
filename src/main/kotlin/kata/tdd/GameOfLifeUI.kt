package kata.tdd

import javafx.application.Application
import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.*

class GameOfLifeApp: App(MainView::class)

class MainView: View() {
    private val model = BoardModel()

    override val root = borderpane {
        top = toolbar {
            button("Next") {
                action {
                    model.nextGeneration()
                }
            }
        }
        center = vbox {
            repeat(50) { y ->
                hbox {
                    repeat(50) { x ->
                        checkbox { model.cells[x][y] }
                    }
                }
            }
        }
    }
}

class BoardModel: ViewModel() {
    var board = """
        1100000010000000
        1100000100000111
        0000000111000000
    """.board

    val cells: List<List<SimpleBooleanProperty>> =
        (0..50).map {
            (0..50).map {
                SimpleBooleanProperty(false)
            }
        }.asObservable()

    fun nextGeneration() {
        board = board.nextGeneration()
        (-25..25).forEach { y ->
            (-25..25).forEach { x ->
                cells[x+25][y+25].set(
                    Cell(x, y).isAlive(board)
                )
            }
        }
    }
}