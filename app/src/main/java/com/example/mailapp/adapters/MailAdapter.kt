package com.example.mailapp.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import com.amulyakhare.textdrawable.TextDrawable
import com.amulyakhare.textdrawable.util.ColorGenerator
import com.example.listviewexamples.models.MailModel


class MailAdapter(var items: List<MailModel>, var context: Context) :
    BaseAdapter()
{
    private var count = 0

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

    override fun getView(i: Int, view: View, viewGroup: ViewGroup): View
    {
        val viewHolder: com.example.listviewexamples.adapters.CustomAdapter.ViewHolder

        if (view == null)
        {
            view = LayoutInflater.from(context).inflate(R.layout.layout_item_view, viewGroup, false)
            Log.v("TAG", "Count: " + count++)
            viewHolder = com.example.listviewexamples.adapters.CustomAdapter.ViewHolder()
            viewHolder.imageAvatar = view.findViewById<ImageView>(R.id.image_avatar)
            viewHolder.textTitle = view.findViewById<TextView>(R.id.text_title)
            viewHolder.textSubtitle = view.findViewById<TextView>(R.id.text_subtitle)
            viewHolder.checkSelected = view.findViewById<CheckBox>(R.id.check_selected)
            view.tag = viewHolder
        }
        else viewHolder =
            view.tag as com.example.listviewexamples.adapters.CustomAdapter.ViewHolder

        val item: ItemModel = items[i]

        val avatar = avatar_by_1st_letter(i) // radius in px

        viewHolder.imageAvatar?.setImageDrawable(avatar)
        viewHolder.textTitle?.text = item.sender
        viewHolder.textTopic?.text = item.topic
        viewHolder.textPreview?.text = item.preview
        viewHolder.checkSelected?.isChecked = item.is_favorite

        viewHolder.checkSelected?.setOnClickListener(View.OnClickListener { view ->
            item.is_favorite = ((view as CheckBox).isChecked)
            notifyDataSetChanged()
        })

        return my_view
    }

    private fun avatar_by_1st_letter(i: Int): TextDrawable?
    {
        val first_letter: String = getItem(i).toString()[0].toString()

        val generator = ColorGenerator.MATERIAL // or use DEFAULT

        // generate random color
        val color = generator.getColor(getItem(i))

        return TextDrawable.builder()
            .buildRound(first_letter, color) // radius in px
    }

    private inner class ViewHolder
    {
        var imageAvatar: ImageView? = null
        var textTitle: TextView? = null
        var textTopic: TextView? = null
        var textPreview: TextView? = null
        var checkSelected: CheckBox? = null
    }

    init
    {
        count = 0
    }
}