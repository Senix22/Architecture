package com.senix22.architecture.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.marginBottom
import androidx.core.view.marginLeft
import androidx.recyclerview.widget.RecyclerView
import com.senix22.architecture.R
import com.senix22.architecture.DTO.Post
import kotlinx.android.synthetic.main.post_item_layout.view.*

class PostItemAdapter(val postList: List<Post>, val context: Context) :
    RecyclerView.Adapter<PostItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.post_item_layout,
            parent, false))
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (postList[position].userId) {
            7 -> {
                holder.itemView.userId.text = postList[position].userId.toString()
                holder.itemView.txtPostTitle.text = ""
                holder.itemView.txtPostBody.text = "Тут міг бути пост юзера ${postList[position].userId}, але він забанений”"
                holder.itemView.setBackgroundColor(Color.RED)
            }
            3,4 -> {
                holder.itemView.userId.text = postList[position].userId.toString()
                holder.itemView.userId.text ="${postList[position].userId}  WARNINNG"
                holder.itemView.setBackgroundColor(Color.GRAY)
            }
            else -> {
                holder.itemView.userId.text = postList[position].userId.toString()
                holder.itemView.txtPostTitle.text = postList[position].title
                holder.itemView.txtPostBody.text = postList[position].body
                holder.itemView.setBackgroundColor(Color.WHITE)
            }
        }

    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}