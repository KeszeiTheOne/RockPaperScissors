package game

import kotlin.test.Test
import kotlin.test.assertSame

class NewGameActionTest {

    var view: RockPaperScissorsViewFake = RockPaperScissorsViewFake()

    @Test
    fun startNewGame() {
        this.run()

        assertSame(true, view.showGameBoard)
    }

    fun run() {
        NewGameAction(view).run()
    }
}

