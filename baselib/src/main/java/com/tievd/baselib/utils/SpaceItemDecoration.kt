package com.tievd.baselib.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration


/**
 *
 * @author zhangli
 * @email zhanglihow@gmail.com
 * @time
 */
class SpaceItemDecoration(
    private val mSpace: Int,
    private val orientation: Int = RecyclerView.VERTICAL
) :
    ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        if (orientation == RecyclerView.VERTICAL) {
            outRect.bottom = mSpace
            if (parent.getChildAdapterPosition(view) == 0) {
                outRect.top = mSpace
            }
        } else {
            outRect.right = mSpace
        }
    }
}