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

    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var btn3: Button
    lateinit var btn4: Button
    lateinit var btn5: Button
    lateinit var btn6: Button
    lateinit var btn7: Button
    lateinit var btn8: Button
    lateinit var btn9: Button

    lateinit var playerTurn: TextView
    lateinit var newGameButton: Button

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

        newGameButton.setOnClickListener() {
            btn1.text = ""
            btn2.text = ""
            btn3.text = ""
            btn4.text = ""
            btn5.text = ""
            btn6.text = ""
            btn7.text = ""
            btn8.text = ""
            btn9.text = ""

            playerTurn.text = "Player X's Turn"
        }
    }
}
















