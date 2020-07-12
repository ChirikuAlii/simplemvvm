package info.chirikualii.simplemvvm.ui.adapter


/**
 * Created by chirikuAlii on 12/07/2020.
 * github.com/chirikualii
 */

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.gson.Gson
import info.chirikualii.simplemvvm.R
import info.chirikualii.simplemvvm.data.local.ArticleEntity
import info.chirikualii.simplemvvm.utils.timeMillisToDateTime
import kotlinx.android.synthetic.main.item_article.view.*
import java.text.SimpleDateFormat


class HeadlineListAdapter() : RecyclerView.Adapter<HeadlineListAdapter.HeadlineHolder>(){

    var items : ArrayList<ArticleEntity> = arrayListOf()
    var listDataFiltered : ArrayList<ArticleEntity> = arrayListOf()

    class HeadlineHolder(view: View) : RecyclerView.ViewHolder(view)


    fun addList(listData :List<ArticleEntity>){
        val arrayList = arrayListOf<ArticleEntity>()
        arrayList.addAll(listData)
        items = arrayList
        listDataFiltered = arrayList
        Log.d("adapter","${Gson().toJsonTree(listDataFiltered)}")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeadlineHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_article,parent,false)
        return HeadlineHolder(view)
    }

    override fun getItemCount(): Int {
        return listDataFiltered.size
    }

    override fun onBindViewHolder(holder: HeadlineHolder, position: Int) {
        val data = listDataFiltered[position]
        val date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(data.publishedAt)

        holder.itemView.tv_title_article.text = data.title
        holder.itemView.tv_date.text = "Published at ${date.time.timeMillisToDateTime()}"


        Glide.with(holder.itemView.context)
            .load(data.urlToImage)
            .into(holder.itemView.iv_article)



    }

}