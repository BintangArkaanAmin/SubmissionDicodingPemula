package com.example.submissiondicodingpemula.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HandphoneData(
    val NamaHP: String,
    val DescHP: String,
    val GambarHP: String
): Parcelable
