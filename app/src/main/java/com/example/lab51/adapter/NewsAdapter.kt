package com.example.lab51.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab51.R
import com.example.lab51.databinding.ActivityMainBinding
import com.example.lab51.databinding.ItemNewsBinding
import com.example.lab51.model.NewsModel

class NewsAdapter(private var newsList: List<NewsModel>, private var mainActivity: ActivityMainBinding) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    class NewsViewHolder(private val binding: ItemNewsBinding, private val mainBinding: ActivityMainBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(newsModel: NewsModel) {
            binding.tvNewsHeader.text = newsModel.header
            binding.tvNewsDescription.text = newsModel.description
            binding.tvNewsImage.setImageBitmap(newsModel.avatar)
            binding.tvLikeAmount.text = newsModel.likeAmount.toString()
            binding.root.setOnClickListener {
                mainBinding.newsAndComments.visibility = View.VISIBLE
                mainBinding.newsImage.setImageBitmap(newsModel.avatar)
                mainBinding.newsName.text = newsModel.header
                mainBinding.newsText.text = newsModel.description

                mainBinding.tvNewsLikeAmount.text = newsModel.likeAmount.toString()
                setLikeButtonState(mainBinding.ivNewsLikeButton, newsModel.liked)

                mainBinding.ivNewsLikeButton.setOnClickListener {
                    newsModel.liked = !newsModel.liked

                    if (newsModel.liked) {
                        newsModel.likeAmount++
                    } else {
                        newsModel.likeAmount--
                    }

                    binding.ivLikeButton.isSelected = newsModel.liked
                    binding.tvLikeAmount.text = newsModel.likeAmount.toString()
                    mainBinding.tvNewsLikeAmount.text = newsModel.likeAmount.toString()
                    setLikeButtonState(binding.ivLikeButton, newsModel.liked)
                    setLikeButtonState(mainBinding.ivNewsLikeButton, newsModel.liked)

                    mainBinding.tvNewsLikeAmount.text = newsModel.likeAmount.toString()
                }
            }

            setLikeButtonState(binding.ivLikeButton, newsModel.liked)

            binding.ivLikeButton.setOnClickListener {
                newsModel.liked = !newsModel.liked
                setLikeButtonState(binding.ivLikeButton, newsModel.liked)

                if (newsModel.liked) {
                    newsModel.likeAmount++
                } else {
                    newsModel.likeAmount--
                }
                binding.tvLikeAmount.text = newsModel.likeAmount.toString()
            }
        }

        private fun setLikeButtonState(button: ImageView, isLiked: Boolean) {
            if (isLiked) {
                button.setImageResource(R.drawable.fav_filled)
            } else {
                button.setImageResource(R.drawable.fav_hollow)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemNewsBinding.inflate(layoutInflater, parent, false)
        return NewsViewHolder(binding, mainActivity)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val newsModel = newsList[position]
        holder.bind(newsModel)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }
}