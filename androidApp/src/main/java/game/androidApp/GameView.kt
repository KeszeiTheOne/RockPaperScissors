package game.androidApp

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import game.Card
import game.Players
import game.RockPaperScissorsView

class GameView(var context: Context) : RockPaperScissorsView {
    override fun isOnGameBoard(): Boolean {
        TODO("Not yet implemented")
    }

    override fun showGameBoard() {
        val intent = Intent(this.context, GameActivity::class.java)
        startActivity(context, intent, null)
    }

    override fun showUserCard(card: Card) {
        TODO("Not yet implemented")
    }

    override fun showComputerCard(card: Card) {
        TODO("Not yet implemented")
    }

    override fun showWinner(player: Players) {
        TODO("Not yet implemented")
    }

    override fun showEndgameWinner(player: Players) {
        TODO("Not yet implemented")
    }
}