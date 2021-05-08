package game.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import game.*
import kotlin.random.Random

class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        val chooseCardAction = ChooseCardAction()
        chooseCardAction.view = GameView(this)
        chooseCardAction.randomGenerator = GameRandomGenerator()
        chooseCardAction.gameRule = GameRuleImplement()
        chooseCardAction.leaderboardProvider = GameLeaderboardProvider()

        val rock: Button = findViewById(R.id.rock)
        rock.setOnClickListener {
            var request = ChooseCardRequest()
            request.card = Card.ROCK
            chooseCardAction.run(request)
        }
        val paper: Button = findViewById(R.id.paper)
        paper.setOnClickListener {
            var request = ChooseCardRequest()
            request.card = Card.PAPER
            chooseCardAction.run(request)
        }

        val scissors: Button = findViewById(R.id.scissors)
        scissors.setOnClickListener {
            var request = ChooseCardRequest()
            request.card = Card.SCISSORS
            chooseCardAction.run(request)
        }
    }
}

class GameRandomGenerator : RandomGenerator {
    override fun random(): Int {
        return Random.nextInt(1, 3)
    }
}

class GameRuleImplement : GameRule {
    override fun decideWhoWin(card1: Card, card2: Card): Int {
        var winner = 0;
        when (card1) {
            Card.ROCK -> {
                if (!card2.equals(Card.ROCK)) {
                    if (card2.equals(Card.SCISSORS)) {
                        winner = -1
                    } else if (card2.equals(Card.PAPER)) {
                        winner = 1
                    }
                }
            }
            Card.PAPER -> {
                if (!card2.equals(Card.PAPER)) {
                    if (card2.equals(Card.ROCK)) {
                        winner = -1
                    } else if (card2.equals(Card.SCISSORS)) {
                        winner = 1
                    }
                }
            }
            Card.SCISSORS -> {
                if (!card2.equals(Card.SCISSORS)) {
                    if (card2.equals(Card.PAPER)) {
                        winner = -1
                    } else if (card2.equals(Card.ROCK)) {
                        winner = 1
                    }
                }
            }
        }
        return winner
    }
}

class GameLeaderboardProvider : LeaderboardProvider {
    override fun getLeaderboard(): Leaderboard {
        return Leaderboard()
    }

}