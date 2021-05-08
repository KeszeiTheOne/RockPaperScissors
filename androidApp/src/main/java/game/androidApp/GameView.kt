package game.androidApp

import android.content.Context
import android.content.Intent
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import game.Card
import game.Players
import game.RockPaperScissorsView

class GameView(var context: AppCompatActivity) : RockPaperScissorsView {
    override fun isOnGameBoard(): Boolean {
        return true
    }

    override fun showGameBoard() {
        val intent = Intent(this.context, GameActivity::class.java)
        startActivity(context, intent, null)
    }

    override fun showUserCard(card: Card) {
        val image: ImageView = this.context.findViewById(R.id.userChooseImg)
        when (card) {
            Card.ROCK -> {
                image.setImageResource(R.drawable.rock)
            }
            Card.PAPER -> {
                image.setImageResource(R.drawable.paper)
            }
            Card.SCISSORS -> {
                image.setImageResource(R.drawable.scissors)
            }
        }
    }

    override fun showComputerCard(card: Card) {
        val image: ImageView = this.context.findViewById(R.id.computerCooseImg)
        when (card) {
            Card.ROCK -> {
                image.setImageResource(R.drawable.rock)
            }
            Card.PAPER -> {
                image.setImageResource(R.drawable.paper)
            }
            Card.SCISSORS -> {
                image.setImageResource(R.drawable.scissors)
            }
        }
    }

    override fun showWinner(player: Players) {
        val toast = Toast.makeText(this.context, "$player", Toast.LENGTH_SHORT)
        toast.show()
    }

    override fun showEndgameWinner(player: Players) {
        TODO("Not yet implemented")
    }
}