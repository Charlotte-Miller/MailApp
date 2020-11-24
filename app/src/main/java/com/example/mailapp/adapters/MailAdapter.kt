package com.example.mailapp.adapters

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.TextView
import android.widget.ToggleButton
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.listviewexamples.models.MailModel
import com.example.mailapp.R
import com.google.android.material.button.MaterialButton


class MailAdapter(var items: List<MailModel>, var context: Context) :
    BaseAdapter()
{
    override fun getCount(): Int
    {
        return items.size
    }

    override fun getItem(i: Int): Any
    {
        return items[i]
    }

    override fun getItemId(i: Int): Long
    {
        return i.toLong()
    }

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup): View
    {
        var viewHolder = ViewHolder()
        var convert_view: View?

        // inflate UI from XML file
        convert_view =
            LayoutInflater.from(context).inflate(R.layout.item_listview, viewGroup, false)


        // get all UI view
        viewHolder.avatar_button = convert_view.findViewById<MaterialButton>(R.id.mail_item_avatar)
        viewHolder.text_sender = convert_view.findViewById<TextView>(R.id.mail_item_sender)
        viewHolder.text_topic = convert_view.findViewById<TextView>(R.id.mail_item_topic)
        viewHolder.text_preview = convert_view.findViewById<TextView>(R.id.mail_item_preview)
        viewHolder.toggle_checked = convert_view.findViewById<CheckBox>(R.id.button_favorite)

        // set tag for holder
        convert_view.tag = viewHolder

        val item: MailModel = items[i]

        viewHolder.avatar_button?.text = item.sender.take(1)
        viewHolder.text_sender?.text = item.sender
        viewHolder.text_topic?.text = item.topic
        viewHolder.text_preview?.text = item.preview
        viewHolder.toggle_checked?.isChecked = item.is_favorite

        viewHolder.toggle_checked?.setOnClickListener(View.OnClickListener { view ->
            item.is_favorite = viewHolder.toggle_checked!!.isChecked
        })

        return convert_view
    }

    private inner class ViewHolder
    {
        var text_sender: TextView? = null
        var avatar_button: MaterialButton? = null
        var text_topic: TextView? = null
        var text_preview: TextView? = null
        var toggle_checked: CheckBox? = null
    }
}