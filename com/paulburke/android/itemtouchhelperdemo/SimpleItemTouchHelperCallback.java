package com.paulburke.android.itemtouchhelperdemo;

import android.graphics.Canvas;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.L;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;

public class SimpleItemTouchHelperCallback extends L {
    public static final float ALPHA_FULL = 1.0f;
    private final ItemTouchHelperAdapter mAdapter;

    public SimpleItemTouchHelperCallback(ItemTouchHelperAdapter itemTouchHelperAdapter0) {
        this.mAdapter = itemTouchHelperAdapter0;
    }

    @Override  // androidx.recyclerview.widget.L
    public void clearView(RecyclerView recyclerView0, O0 o00) {
        super.clearView(recyclerView0, o00);
        o00.itemView.setAlpha(1.0f);
        if(o00 instanceof ItemTouchHelperViewHolder) {
            ((ItemTouchHelperViewHolder)o00).onItemClear();
        }
    }

    // 去混淆评级： 中等(60)
    @Override  // androidx.recyclerview.widget.L
    public int getMovementFlags(RecyclerView recyclerView0, O0 o00) {
        return recyclerView0.getLayoutManager() instanceof GridLayoutManager ? 0xF000F : 0x33033;
    }

    @Override  // androidx.recyclerview.widget.L
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    @Override  // androidx.recyclerview.widget.L
    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override  // androidx.recyclerview.widget.L
    public void onChildDraw(Canvas canvas0, RecyclerView recyclerView0, O0 o00, float f, float f1, int v, boolean z) {
        if(v == 1) {
            float f2 = 1.0f - Math.abs(f) / ((float)o00.itemView.getWidth());
            o00.itemView.setAlpha(f2);
            o00.itemView.setTranslationX(f);
            return;
        }
        super.onChildDraw(canvas0, recyclerView0, o00, f, f1, v, z);
    }

    @Override  // androidx.recyclerview.widget.L
    public boolean onMove(RecyclerView recyclerView0, O0 o00, O0 o01) {
        if(o00.getItemViewType() != o01.getItemViewType()) {
            return false;
        }
        int v = o00.getAdapterPosition();
        int v1 = o01.getAdapterPosition();
        this.mAdapter.onItemMove(v, v1);
        return true;
    }

    @Override  // androidx.recyclerview.widget.L
    public void onSelectedChanged(O0 o00, int v) {
        if(v != 0 && o00 instanceof ItemTouchHelperViewHolder) {
            ((ItemTouchHelperViewHolder)o00).onItemSelected();
        }
    }

    @Override  // androidx.recyclerview.widget.L
    public void onSwiped(O0 o00, int v) {
        int v1 = o00.getAdapterPosition();
        this.mAdapter.onItemDismiss(v1);
    }
}

