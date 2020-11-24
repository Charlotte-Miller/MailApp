package com.example.mailapp

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.listviewexamples.models.MailModel
import com.example.mailapp.R
import com.example.mailapp.adapters.MailAdapter
import com.google.android.material.appbar.MaterialToolbar
import java.util.*


class MainActivity : AppCompatActivity()
{
    var items: MutableList<MailModel>? = null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set custom app bar
        val top_app_bar = findViewById<MaterialToolbar>(R.id.top_app_bar)
        setSupportActionBar(top_app_bar)

        generate_adapter_data()
    }

    private fun generate_adapter_data()
    {
        items = ArrayList<MailModel>()

        for (i in 0..10) items!!.add(
            MailModel(
                "Richard Mille",
                "Couple of bad habits",
                "Come to no.11 Broadway..."
            )
        )

        val adapter = MailAdapter(items as ArrayList<MailModel>, this)

        val listView = findViewById<ListView>(R.id.mail_list)
        listView.adapter = adapter
    }
}