package game

import kotlin.test.Test
import kotlin.test.assertSame

class ChooseCardActionTest {
    var view: RockPaperScissorsViewFake = RockPaperScissorsViewFake()
    var randomGenerator: RandomGeneratorFake = RandomGeneratorFake()
    var gameRule: GameRuleFake = GameRuleFake()
    var leaderboardProvider: LeaderboardProviderFake = LeaderboardProviderFake()

    @Test
    fun chooseACard() {
        this.run(request())

        assertSame(Card.PAPER, view.showedUserCard)
    }

    @Test
    fun chooseComputerCard() {
        this.run(request())

        assertSame(Card.ROCK, view.showedComputerCard)
    }

    @Test
    fun showPlayerWinner() {
        gameRule.win = -1

        this.run(request())

        assertSame(Players.USER, view.winner)
        assertSame(Card.PAPER, gameRule.card1)
        assertSame(Card.ROCK, gameRule.card2)
    }

    @Test
    fun showComputerWinner() {
        gameRule.win = 1

        this.run(request())

        assertSame(Players.COMPUTER, view.winner)
        assertSame(Card.PAPER, gameRule.card1)
        assertSame(Card.ROCK, gameRule.card2)
    }

    @Test
    fun showBothWinner() {
        gameRule.win = 0

        this.run(request())

        assertSame(Players.BOTH, view.winner)
        assertSame(Card.PAPER, gameRule.card1)
        assertSame(Card.ROCK, gameRule.card2)
    }

    @Test
    fun incrementLeaderBoardForPlayer() {
        gameRule.win = -1

        this.run(request())

        assertSame(1, leaderboardProvider.fakeLeaderboard.player)
    }


    @Test
    fun incrementLeaderBoardForComputer() {
        gameRule.win = 1

        this.run(request())

        assertSame(1, leaderboardProvider.fakeLeaderboard.computer)
    }

    @Test
    fun nonIncrementLeaderboardOnBothWinner() {
        gameRule.win = 0

        this.run(request())

        assertSame(0, leaderboardProvider.fakeLeaderboard.computer)
        assertSame(0, leaderboardProvider.fakeLeaderboard.player)
    }

    @Test
    fun showPlayerWinEndgame() {
        leaderboardProvider.fakeLeaderboard.player = 2
        gameRule.win = -1

        this.run(request())

        assertSame(3, leaderboardProvider.fakeLeaderboard.player)
        assertSame(Players.USER, view.endgameWinner)
    }

    @Test
    fun showComputerWinEndgame() {
        leaderboardProvider.fakeLeaderboard.computer = 2
        gameRule.win = 1

        this.run(request())

        assertSame(3, leaderboardProvider.fakeLeaderboard.computer)
        assertSame(Players.COMPUTER, view.endgameWinner)
    }

    @Test
    fun noOneWinEndgame() {
        gameRule.win = 1

        this.run(request())

        assertSame(null, view.endgameWinner)
    }

    fun run(request: ChooseCardRequest) {
        val chooseCardAction = ChooseCardAction()
        chooseCardAction.view = this.view
        chooseCardAction.gameRule = this.gameRule
        chooseCardAction.randomGenerator = this.randomGenerator
        chooseCardAction.leaderboardProvider = this.leaderboardProvider

        chooseCardAction.run(request)
    }

    fun request(): ChooseCardRequest {
        val request = ChooseCardRequest()
        request.card = Card.PAPER

        return request
    }
}

class RandomGeneratorFake : RandomGenerator {
    val number: Int = 0
    override fun random(): Int {
        return number
    }

}

class GameRuleFake : GameRule {
    var win: Int = 0
    lateinit var card1: Card
    lateinit var card2: Card
    override fun decideWhoWin(card1: Card, card2: Card): Int {
        this.card1 = card1
        this.card2 = card2

        return this.win
    }

}

class LeaderboardProviderFake : LeaderboardProvider {

    val fakeLeaderboard: Leaderboard = Leaderboard()

    override fun getLeaderboard(): Leaderboard {
        return this.fakeLeaderboard
    }

}

