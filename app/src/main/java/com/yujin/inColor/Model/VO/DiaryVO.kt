package com.yujin.inColor.Model.VO

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class DiaryVO(
    val date: Date?,
    val weather:Int?,
    val moodColor:Int?,
    val content: String?
): Parcelable