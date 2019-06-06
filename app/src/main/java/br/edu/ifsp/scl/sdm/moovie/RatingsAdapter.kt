package br.edu.ifsp.scl.sdm.moovie

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import br.edu.ifsp.scl.sdm.moovie.model.Ratings
import android.widget.TwoLineListItem
import android.view.LayoutInflater

class RatingsAdapter(
    private val context: Context,
    private val ratings : List<Ratings>
) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val twoLineListItem: TwoLineListItem

        if (convertView == null) {
            val inflater = context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            twoLineListItem = inflater.inflate(
                android.R.layout.simple_list_item_2, null
            ) as TwoLineListItem
        } else {
            twoLineListItem = convertView as TwoLineListItem
        }

        val text1 = twoLineListItem.text1
        val text2 = twoLineListItem.text2

        val rating = getItem(position)

        text1.text = rating.Source
        text2.text = rating.Value

        return twoLineListItem
    }

    override fun getItem(position: Int): Ratings {
        return ratings[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return ratings.size
    }

}