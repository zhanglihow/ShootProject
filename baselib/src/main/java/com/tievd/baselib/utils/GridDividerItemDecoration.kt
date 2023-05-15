package com.tievd.baselib.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration


class GridDividerItemDecoration(val space:Int=10, private val includeEdge:Boolean=true) : ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val gridLayoutManager:GridLayoutManager = parent.layoutManager as GridLayoutManager
        //列数
        val spanCount = gridLayoutManager.spanCount
        val position: Int =parent.getChildLayoutPosition(view)
        val column = position % spanCount
        if (includeEdge) {
            outRect.left = space - column * space / spanCount
            outRect.right = (column + 1) * space / spanCount
            if (position < spanCount) {
                outRect.top = space
            }
            outRect.bottom = space
        } else {
            outRect.left = column * space / spanCount
            outRect.right = space - (column + 1) * space / spanCount
            if (position >= spanCount) {
                outRect.top = space
            }
        }
    }

}