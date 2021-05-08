package game

interface RockPaperScissorsView {

    fun isOnGameBoard(): Boolean

    fun showGameBoard()

    fun showUserCard(card: Card)

    fun showComputerCard(card: Card)

    fun showWinner(player: Players)

    fun showEndgameWinner(player: Players)
}