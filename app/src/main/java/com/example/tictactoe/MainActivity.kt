package com.example.tictactoe

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tictactoe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    // Get all the buttons from left to right top to bottom
    val btn1: Button = binding.button1
    val btn2: Button = binding.button2
    val btn3: Button = binding.button3
    val btn4: Button = binding.button4
    val btn5: Button = binding.button5
    val btn6: Button = binding.button6
    val btn7: Button = binding.button7
    val btn8: Button = binding.button8
    val btn9: Button = binding.button9

    // Get the TextView to change text
    val turnText: TextView = binding.playerTurnTextView

    // Keep a track of who's turn it is with a boolean value
    var isPlayerXTurn = true

    // This method should start a New Game by making all
    // the buttons blank and starting with player X's turn
    fun startNewGame(view: View) {
        val arrayOfButtons: Array<Button> = arrayOf(btn1, btn2, btn3,
                                                    btn4, btn5, btn6,
                                                    btn7, btn8, btn9)
        for (item in arrayOfButtons){
            item.text = ""
        }

        turnText.text = "Player X's Turn"
        isPlayerXTurn = true
    }

    // Stopped working here, The app keeps on crashing
    fun btnLayoutTouch(btn: Button) {
        if (!btn.text.isNotEmpty()) {
            if (isPlayerXTurn) {
                btn.text = "X"
                isPlayerXTurn = false
                turnText.text = "Player O's Turn"
            }
            else {
                btn.text = "O"
                isPlayerXTurn = true
                turnText.text = "Player X's Turn"
            }
        }
    }
}
















