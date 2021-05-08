package game.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import color.androidApp.R

class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
    }
}