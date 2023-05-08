package com.example.lab51.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.lab51.MainActivity
import com.example.lab51.R
import com.example.lab51.databinding.ActivityMainBinding
import com.example.lab51.databinding.ItemCommentBinding
import com.example.lab51.databinding.ItemNewsBinding
import com.example.lab51.model.CommentsModel
import com.example.lab51.model.NewsModel

class CommentsAdapter(private val commentsList: List<CommentsModel>, private val mainActivity: MainActivity) : RecyclerView.Adapter<CommentsAdapter.CommentsViewHolder>() {

    inner class CommentsViewHolder(private val binding: ItemCommentBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(commentsModel: CommentsModel) {
            binding.tvCommentsHeader.text = commentsModel.nameComment
            binding.tvCommentsDescription.text = commentsModel.descriptionComment
            binding.ivCommentsImage.setImageBitmap(commentsModel.avatarComment)
            binding.tvLikeAmountComment.text = commentsModel.likeAmountComment.toString()

            setCommLikeButtonState(binding.ivLikeButtonComment, commentsModel.likedComment)

            binding.ivLikeButtonComment.setOnClickListener {
                commentsModel.likedComment = !commentsModel.likedComment
                setCommLikeButtonState(binding.ivLikeButtonComment, commentsModel.likedComment)

                if (commentsModel.likedComment) {
                    commentsModel.likeAmountComment++
                } else {
                    commentsModel.likeAmountComment--
                }
                binding.tvLikeAmountComment.text = commentsModel.likeAmountComment.toString()
            }
        }

        private fun setCommLikeButtonState(button: ImageView, commIsLiked: Boolean) {
            if (commIsLiked) {
                button.setImageResource(R.drawable.fav_filled)
            } else {
                button.setImageResource(R.drawable.fav_hollow)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemCommentBinding.inflate(layoutInflater, parent, false)
        return CommentsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        val comm = commentsList[position]
        holder.bind(comm)
    }

    override fun getItemCount(): Int {
        return commentsList.size
    }
}