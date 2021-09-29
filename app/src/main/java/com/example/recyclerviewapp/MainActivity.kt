package com.example.recyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var clElart: ConstraintLayout //Bonus
    private lateinit var enterMsg: EditText //User Input
    private lateinit var enter: Button //for Guess
    private lateinit var msgs: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clElart = findViewById(R.id.clElart)
        msgs = ArrayList()

        rvMsgs.adapter = MessageAdapter(this, msgs)
        rvMsgs.layoutManager = LinearLayoutManager(this)

        enterMsg = findViewById(R.id.etEnterMsg)
        enter = findViewById(R.id.btEnter)

        enter.setOnClickListener {
            val msg = enterMsg.text.toString()
            if (msg.isNotEmpty()) {
                msgs.add(msg)
                enterMsg.text.clear()// to clean edit text
                enterMsg.clearFocus()
            } else {
                Snackbar.make(clElart, "Enter text", Snackbar.LENGTH_LONG).show()// bouns
            }
        }
        }
    }



