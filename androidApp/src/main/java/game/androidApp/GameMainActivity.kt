package game.androidApp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import color.androidApp.R
import game.NewGameAction

class GameMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val context = this;
        val newGame: Button = findViewById(R.id.newGameButton)
        newGame.setOnClickListener {
            NewGameAction(GameView(context)).run()
        }
//        tv.text = greet()
    }
}