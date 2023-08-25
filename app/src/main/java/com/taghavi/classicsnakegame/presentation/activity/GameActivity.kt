package com.taghavi.classicsnakegame.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.taghavi.classicsnakegame.domain.game.GameEngine
import com.taghavi.classicsnakegame.domain.game.SnakeDirection
import com.taghavi.classicsnakegame.presentation.component.Board
import com.taghavi.classicsnakegame.presentation.component.Controller
import com.taghavi.classicsnakegame.ui.theme.ClassicSnakeGameTheme
import kotlinx.coroutines.CoroutineScope

class GameActivity : ComponentActivity() {
    private lateinit var scope: CoroutineScope

    private var gameEngine = GameEngine(
        scope = lifecycleScope,
        onGameEnded = {

        },
        onFoodEaten = {

        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClassicSnakeGameTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SnakeGame()
                }
            }
        }
    }

    @Composable
    fun SnakeGame() {
        scope = rememberCoroutineScope()
        val state = gameEngine.state.collectAsState(initial = null)
        Column {
            state.value?.let { Board(state = it) }
            Controller{
                when(it){
                    SnakeDirection.Up -> gameEngine.move = Pair(0,-1)
                    SnakeDirection.Left -> gameEngine.move = Pair(-1,0)
                    SnakeDirection.Right -> gameEngine.move = Pair(1,0)
                    SnakeDirection.Down -> gameEngine.move = Pair(0,1)
                }
            }
        }
    }
}
