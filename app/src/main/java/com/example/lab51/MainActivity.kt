package com.example.lab51

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab51.adapter.CommentsAdapter
import com.example.lab51.adapter.NewsAdapter
import com.example.lab51.databinding.ActivityMainBinding
import com.example.lab51.model.CommentsModel
import com.example.lab51.model.NewsModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var newsList: MutableList<NewsModel>
    private lateinit var commentsList: MutableList<CommentsModel>
    private lateinit var newsAdapter: NewsAdapter
    private lateinit var commentsAdapter: CommentsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        newsList = getList()
        newsAdapter = NewsAdapter(newsList, binding)

        binding.rvNewsList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = newsAdapter
        }

        commentsList = getCommentsList()
        commentsAdapter = CommentsAdapter(commentsList, this)

        binding.rvComments.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = commentsAdapter
        }

        binding.buttonBack.setOnClickListener { binding.newsAndComments.visibility = View.GONE }

    }

    private fun getCommentsList():MutableList<CommentsModel> {
        val commentslist = mutableListOf<CommentsModel>()
        commentslist.add(
            CommentsModel(
                "Alice",
                "Not bad",
                BitmapFactory.decodeResource(resources, R.mipmap.emoticon)
            )
        )
        commentslist.add(
            CommentsModel(
                "John",
                "Good!",
                BitmapFactory.decodeResource(resources, R.mipmap.emoticon)
            )
        )
        commentslist.add(
            CommentsModel(
                "Max",
                "Awesome!",
                BitmapFactory.decodeResource(resources, R.mipmap.emoticon)
            )
        )
        commentslist.add(
            CommentsModel(
                "Victor",
                "Cool!",
                BitmapFactory.decodeResource(resources, R.mipmap.emoticon)
            )
        )
        return commentslist
    }

    private fun getList():MutableList<NewsModel>{
        val list = mutableListOf<NewsModel>()
        val text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."

        list.add(
            NewsModel("News 1", text, BitmapFactory.decodeResource(resources, R.mipmap.sky))
        )
        list.add(
            NewsModel("News 2", text, BitmapFactory.decodeResource(resources, R.mipmap.sky2))
        )
        list.add(
            NewsModel("News 3", text, BitmapFactory.decodeResource(resources, R.mipmap.sky3))
        )
        list.add(
            NewsModel("News 1", text, BitmapFactory.decodeResource(resources, R.mipmap.sky))
        )
        list.add(
            NewsModel("News 2", text, BitmapFactory.decodeResource(resources, R.mipmap.sky2))
        )
        list.add(
            NewsModel("News 3", text, BitmapFactory.decodeResource(resources, R.mipmap.sky3))
        )
        list.add(
            NewsModel("News 1", text, BitmapFactory.decodeResource(resources, R.mipmap.sky))
        )
        list.add(
            NewsModel("News 2", text, BitmapFactory.decodeResource(resources, R.mipmap.sky2))
        )
        list.add(
            NewsModel("News 3", text, BitmapFactory.decodeResource(resources, R.mipmap.sky3))
        )
        list.add(
            NewsModel("News 1", text, BitmapFactory.decodeResource(resources, R.mipmap.sky))
        )
        list.add(
            NewsModel("News 2", text, BitmapFactory.decodeResource(resources, R.mipmap.sky2))
        )
        list.add(
            NewsModel("News 3", text, BitmapFactory.decodeResource(resources, R.mipmap.sky3))
        )
        list.add(
            NewsModel("News 1", text, BitmapFactory.decodeResource(resources, R.mipmap.sky))
        )
        list.add(
            NewsModel("News 2", text, BitmapFactory.decodeResource(resources, R.mipmap.sky2))
        )
        list.add(
            NewsModel("News 3", text, BitmapFactory.decodeResource(resources, R.mipmap.sky3))
        )
        list.add(
            NewsModel("News 1", text, BitmapFactory.decodeResource(resources, R.mipmap.sky))
        )
        list.add(
            NewsModel("News 2", text, BitmapFactory.decodeResource(resources, R.mipmap.sky2))
        )
        list.add(
            NewsModel("News 3", text, BitmapFactory.decodeResource(resources, R.mipmap.sky3))
        )
        return list
    }
}