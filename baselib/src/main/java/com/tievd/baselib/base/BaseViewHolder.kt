package com.tievd.baselib.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

open class BaseViewHolder(var v: ViewBinding, itemView: View) : RecyclerView.ViewHolder(itemView)