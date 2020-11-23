package com.example.listviewexamples.activities

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.amulyakhare.textdrawable.TextDrawable
import com.amulyakhare.textdrawable.util.ColorGenerator
import com.example.listviewexamples.models.MailModel
import com.example.mailapp.R
import com.example.mailapp.adapters.MailAdapter
import java.util.*


class MainActivity : AppCompatActivity()
{
    var items: MutableList<MailModel>? = null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        generate_adapter_data()
    }

    private fun generate_adapter_data()
    {
        items = ArrayList<MailModel>()

        for (i in 0..10) items!!.add(MailModel("Hoang", "Wanna be rich as fuck?", "Come to no.11 Broadway..."))

        val adapter = MailAdapter(items as ArrayList<MailModel>, this)

        val listView = findViewById<ListView>(R.id.mail_list)
        listView.adapter = adapter
    }
}