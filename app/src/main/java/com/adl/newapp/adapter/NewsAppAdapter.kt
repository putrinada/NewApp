package com.adl.newapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.adl.newapp.R
import com.adl.newapp.model.NewHeadlines
import com.adl.newapp.model.NewsApiRespons
import com.bumptech.glide.Glide

class NewsAppAdapter ( val onClickListener: (Int) -> Unit
): RecyclerView.Adapter<NewsAppAdapter.CustomViewHolder>()  {
    var items: List<NewHeadlines> = emptyList<NewHeadlines>()

    fun setData(list: List<NewHeadlines>){
        items = list
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.headline_list_item, parent, false)

        return CustomViewHolder(view)
     }

     override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
         val item = items[position]
         holder.bindView(item)

         holder.itemView.setOnClickListener { onClickListener(position + 1) }


     }

     override fun getItemCount(): Int {
         return items.size

     }


    class CustomViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindView(item: NewHeadlines) = with(itemView) {
            val img = findViewById<ImageView>(R.id.img_Headline)
            val title = findViewById<TextView>(R.id.text_Title)
            val source = findViewById<TextView>(R.id.text_Resource)


            item.let {
                Glide.with(itemView.context).load(it.urlToImage).into(img)

                title.text = item.title
                source.text = item.source.name

            }



        }
    }


 }