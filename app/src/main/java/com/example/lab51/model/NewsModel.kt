package com.example.lab51.model

import android.graphics.Bitmap

class NewsModel (val header: String, val description: String, val avatar: Bitmap, var likeAmount: Int = 0, var liked: Boolean = false)