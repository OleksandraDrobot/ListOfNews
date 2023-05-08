package com.example.lab51.model

import android.graphics.Bitmap

class CommentsModel(val nameComment: String, val descriptionComment: String, val avatarComment: Bitmap, var likeAmountComment: Int = 0, var likedComment: Boolean = false)