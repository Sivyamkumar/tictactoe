package com.example.tictactoe

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class gameactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_startactivity)


    }

    fun game(view : View){

        var cellid = 0
        val selector = view as Button

        when(selector.id){
            R.id.button ->
                cellid = 1
            R.id.button2 ->
                cellid = 2
            R.id.button3 ->
                cellid = 3
            R.id.button4 ->
                cellid = 4
            R.id.button5 ->
                cellid = 5
            R.id.button6 ->
                cellid = 6
            R.id.button7 ->
                cellid = 7
            R.id.button8 ->
                cellid = 8
            R.id.button9 ->
                cellid = 9
        }

        playGame(cellid,selector)

    }


    var activeplayer = 1
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    fun playGame(cellId:Int, selectedbutton:Button){

        if(activeplayer == 1){
            selectedbutton.text="X"
            val colour = resources.getDrawable(R.drawable.player1)
            selectedbutton.setBackground(colour)
            player1.add(cellId)
            activeplayer = 2
        }else{
            selectedbutton.text = "0"
            val colour = resources.getDrawable(R.drawable.playeer2)
            selectedbutton.setBackground(colour)
            player2.add(cellId)
            activeplayer=1
        }
        selectedbutton.isEnabled=false

        winner()
    }

    var haswinner=false

    fun winner(){
        var winner = -1

//        Player 1 Winning Sceneraio
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner=1
            haswinner=true
        }
        if(player1.contains(1) && player1.contains(4) && player1.contains(6)){
            winner=1
            haswinner=true
        }
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner=1
            haswinner=true
        }
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner=1
            haswinner=true
        }
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner=1
            haswinner=true
        }
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner=1
            haswinner=true
        }
        if(player1.contains(1) && player1.contains(5) && player1.contains(9)){
            winner=1
            haswinner=true
        }
        if(player1.contains(3) && player1.contains(5) && player1.contains(7)){
            winner=1
            haswinner=true
        }

//        Player2 Winning Scenario

        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner=2
            haswinner=true
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(6)){
            winner=2
            haswinner=true
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner=2
            haswinner=true
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner=2
            haswinner=true
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner=2
            haswinner=true
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner=2
            haswinner=true
        }
        if(player2.contains(1) && player2.contains(5) && player2.contains(9)){
            winner=2
            haswinner=true
        }
        if(player2.contains(3) && player2.contains(5) && player2.contains(7)){
            winner=2
            haswinner=true
        }

        if(winner == 1){
            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.dialogbox)
            dialog.setCancelable(false)

            val result = dialog.findViewById<TextView>(R.id.result)
            val back = dialog.findViewById<Button>(R.id.exit)
            val again = dialog.findViewById<Button>(R.id.playgame)


            result.text = "Player 1 Win The Game"
            back.setOnClickListener {
                finishAffinity()
            }
            again.setOnClickListener {
                val intent = Intent(this,gameactivity::class.java)
                finish()
                startActivity(intent)
            }
            dialog.show()

        }else if (winner==2){
            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.dialogbox)
            dialog.setCancelable(false)

            val result = dialog.findViewById<TextView>(R.id.result)
            val back = dialog.findViewById<Button>(R.id.exit)
            val again = dialog.findViewById<Button>(R.id.playgame)


            result.text = "Player 2 Win The Game"
            back.setOnClickListener {
                finishAffinity()
            }
            again.setOnClickListener {
                val intent = Intent(this,gameactivity::class.java)
                finish()
                startActivity(intent)
            }

            dialog.show()
        }
        if(haswinner == false && (player1.size >= 4 && player2.size >=4)){
            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.dialogbox)

            val result = dialog.findViewById<TextView>(R.id.result)
            val back = dialog.findViewById<Button>(R.id.exit)
            val again = dialog.findViewById<Button>(R.id.playgame)

            result.text = "Game Drawn !!"

            back.setOnClickListener {
                finishAffinity()
            }

            again.setOnClickListener {
                val intent =Intent(this,gameactivity::class.java)
                startActivity(intent)
            }

            dialog.show()
        }

    }

}