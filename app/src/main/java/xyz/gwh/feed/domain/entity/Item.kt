package xyz.gwh.feed.domain.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item(
    val text: String
) : Parcelable