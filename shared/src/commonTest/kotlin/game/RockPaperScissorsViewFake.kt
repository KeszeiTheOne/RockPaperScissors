package game

class RockPaperScissorsViewFake : RockPaperScissorsView {

    var showGameBoard: Boolean = false

    lateinit var showedUserCard: Card
    lateinit var showedComputerCard: Card
    lateinit var winner: Players
    var endgameWinner: Players? = null

    override fun isOnGameBoard(): Boolean {
        return this.showGameBoard
    }

    override fun showGameBoard() {
        this.showGameBoard = true
    }

    override fun showUserCard(card: Card) {
        this.showedUserCard = card
    }

    override fun showComputerCard(card: Card) {
        this.showedComputerCard = card
    }

    override fun showWinner(player: Players) {
        this.winner = player
    }

    override fun showEndgameWinner(player: Players) {
        this.endgameWinner = player
    }
}