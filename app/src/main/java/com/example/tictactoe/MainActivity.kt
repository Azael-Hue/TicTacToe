package com.example.tictactoe

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tictactoe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // Use lateinit to declare the 9 buttons
    // in the Tic-Tac-Toe board/layout
    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var btn3: Button
    lateinit var btn4: Button
    lateinit var btn5: Button
    lateinit var btn6: Button
    lateinit var btn7: Button
    lateinit var btn8: Button
    lateinit var btn9: Button

    lateinit var playerTurn: TextView   // The Text View that states who's turn it is
    lateinit var newGameButton: Button  // The button we use to start a new game
    var currentPlayer = "X"             // The first player will always be X

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

        // Assign each btn var to a button from left to right top to bottom
        btn1 = binding.button1
        btn2 = binding.button2
        btn3 = binding.button3
        btn4 = binding.button4
        btn5 = binding.button5
        btn6 = binding.button6
        btn7 = binding.button7
        btn8 = binding.button8
        btn9 = binding.button9

        playerTurn = binding.playerStatusTxt
        newGameButton = binding.newGameBtn

        // Make an array to access the buttons in the layout
        val layoutButtons = arrayOf(btn1, btn2, btn3,
                                    btn4, btn5, btn6,
                                    btn7, btn8, btn9)

        for (button in layoutButtons) {
            button.setOnClickListener{ boardChange(button) }
        }

        newGameButton.setOnClickListener() {
            // Delete the text from each button
            for (button in layoutButtons) {
                button.text = ""
            }

            currentPlayer = "X"
            playerTurn.text = "Player X's Turn"
        }
    }

    fun boardChange(button: Button) {
        if (button.text.isEmpty()) {
            button.text = currentPlayer

            if (currentPlayer == "X") {
                currentPlayer = "O"
                playerTurn.text = "Player O's Turn"
            }

            else {
                currentPlayer = "X"
                playerTurn.text = "Player X's Turn"
            }
        }
    }


}
















