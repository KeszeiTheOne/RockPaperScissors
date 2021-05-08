package game

class ChooseCardAction {
    lateinit var view: RockPaperScissorsView
    lateinit var randomGenerator: RandomGenerator
    lateinit var gameRule: GameRule
    lateinit var leaderboardProvider: LeaderboardProvider

    fun run(request: ChooseCardRequest) {
        this.view.showUserCard(request.card)

        val computerCard = Card.values().get(this.randomGenerator.random())
        this.view.showComputerCard(computerCard)

        val decideWhoWin = this.gameRule.decideWhoWin(request.card, computerCard)
        if (decideWhoWin == 0) {
            this.view.showWinner(Players.BOTH)
        } else {
            val leaderboard = leaderboardProvider.getLeaderboard()
            if (decideWhoWin == -1) {
                this.view.showWinner(Players.USER)
                leaderboard.player += 1
            } else {
                this.view.showWinner(Players.COMPUTER)
                leaderboard.computer += 1
            }

            if (leaderboard.player >= 3) {
                this.view.showEndgameWinner(Players.USER)
            } else if (leaderboard.computer >= 3) {
                this.view.showEndgameWinner(Players.COMPUTER)
            }
        }
    }

}