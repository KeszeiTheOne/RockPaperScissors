package game

class NewGameAction(private val view: RockPaperScissorsView) {
    fun run() {
        view.showGameBoard()
    }
}