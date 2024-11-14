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
    var currentPlayer = "X"             // A string variable that keeps track of the player, starting with X
    var isGameGoing = true              // A boolean to keep track of if the game is still going

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

        // Assign each btn var to a button from the layout left to right, top to bottom
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

        // Make an array to access the buttons in the layout more easily
        val layoutButtons = arrayOf(btn1, btn2, btn3,
                                    btn4, btn5, btn6,
                                    btn7, btn8, btn9)

        // for each button on the layout
        // set an onClickListener, if the button is
        // clicked and if the game is sill going
        // continue with the function boardChange
        // passing the button pressed as the parameter
        for (button in layoutButtons) {
            button.setOnClickListener{
                if (isGameGoing){
                    boardChange(button)
                }
            }
        }

        // When the new game btn is pressed
        // Delete the text from each button
        // change the current player and status
        // text to 'X' and change the
        // boolean isGameGoing to true
        newGameButton.setOnClickListener() {
            for (button in layoutButtons) {
                button.text = ""
            }

            currentPlayer = "X"
            playerTurn.text = "Player $currentPlayer's Turn"
            isGameGoing = true
        }
    }

    // This method when called will
    // check if the button pressed is empty
    // if so, it will occupy the button text with
    // the current player's letter
    // once done it will call the method gameWinCondition
    // to see if the player has won, if so end the game
    // else change the players turn and text to say who's turn's it is
    fun boardChange(button: Button) {
        if (button.text.isEmpty()) {
            button.text = currentPlayer

            if (gameWinCondition()) {
                playerTurn.text = "Player $currentPlayer Wins!!!"
                isGameGoing = false
            }

            else {
                currentPlayer = if (currentPlayer == "X") "O" else "X"
                playerTurn.text = "Player $currentPlayer's turn"
            }
        }
    }

    // This method will be used to check if any player has won
    // we make an array of arrays containing 3 consecutive boxes / buttons
    // and run through each array to see if all indexes have the current player's
    // symbol, if so return true as the player has won, otherwise return false
    fun gameWinCondition(): Boolean {
        val winningConditions = arrayOf(
            arrayOf( btn1, btn2, btn3 ), // Top row
            arrayOf( btn4, btn5, btn6 ), // Middle row
            arrayOf( btn7, btn8, btn9 ), // Bottom Row

            arrayOf( btn1, btn4, btn7 ), // left column
            arrayOf( btn2, btn5, btn8 ), // middle column
            arrayOf( btn3, btn6, btn9 ), // right column

            arrayOf( btn1, btn5, btn9 ), // across backwards
            arrayOf( btn3, btn5, btn7 ) // across forwards
        )

        for (eachCondition in winningConditions) {
            if (eachCondition[0].text == currentPlayer &&
                eachCondition[1].text == currentPlayer &&
                eachCondition[2].text == currentPlayer) {
                return true
            }
        }

        return false
    }
}
















