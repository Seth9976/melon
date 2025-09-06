package com.iloen.melon.utils.dragdrop;

import android.graphics.Canvas;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.w0;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.iloen.melon.utils.dragdrop.scroll.DragPos;
import com.iloen.melon.utils.dragdrop.scroll.FlexibleViewScrollStrategy;
import com.iloen.melon.utils.dragdrop.scroll.GridViewScrollStrategy;
import com.iloen.melon.utils.dragdrop.scroll.ListViewScrollStrategy;
import com.iloen.melon.utils.dragdrop.scroll.ScrollStrategyBase.ScrollSpeed;
import com.iloen.melon.utils.dragdrop.scroll.ScrollStrategyBase;
import com.paulburke.android.itemtouchhelperdemo.ItemTouchHelperAdapter;
import com.paulburke.android.itemtouchhelperdemo.SimpleItemTouchHelperCallback;

public class MelonItemTouchHelperCallback extends SimpleItemTouchHelperCallback {
    public final ItemTouchHelperAdapter a;
    public final boolean b;
    public ScrollStrategyBase c;

    public MelonItemTouchHelperCallback(ItemTouchHelperAdapter itemTouchHelperAdapter0) {
        super(itemTouchHelperAdapter0);
        this.b = false;
        this.a = itemTouchHelperAdapter0;
    }

    public MelonItemTouchHelperCallback(ItemTouchHelperAdapter itemTouchHelperAdapter0, boolean z) {
        super(itemTouchHelperAdapter0);
        this.a = itemTouchHelperAdapter0;
        this.b = z;
    }

    @Override  // com.paulburke.android.itemtouchhelperdemo.SimpleItemTouchHelperCallback
    public int getMovementFlags(RecyclerView recyclerView0, O0 o00) {
        w0 w00 = recyclerView0.getLayoutManager();
        if(w00 instanceof GridLayoutManager) {
            this.c = new GridViewScrollStrategy(recyclerView0);
            return this.c.getMovementFlags();
        }
        if(w00 instanceof FlexboxLayoutManager) {
            this.c = new FlexibleViewScrollStrategy(recyclerView0);
            return this.c.getMovementFlags();
        }
        this.c = new ListViewScrollStrategy(recyclerView0, this.b);
        return this.c.getMovementFlags();
    }

    @Override  // androidx.recyclerview.widget.L
    public int interpolateOutOfBoundsScroll(RecyclerView recyclerView0, int v, int v1, int v2, long v3) {
        return this.c.getScrollSpeed() * ((int)Math.signum(v1));
    }

    @Override  // com.paulburke.android.itemtouchhelperdemo.SimpleItemTouchHelperCallback
    public boolean isItemViewSwipeEnabled() {
        return false;
    }

    @Override  // com.paulburke.android.itemtouchhelperdemo.SimpleItemTouchHelperCallback
    public boolean isLongPressDragEnabled() {
        return false;
    }

    @Override  // com.paulburke.android.itemtouchhelperdemo.SimpleItemTouchHelperCallback
    public void onChildDraw(Canvas canvas0, RecyclerView recyclerView0, O0 o00, float f, float f1, int v, boolean z) {
        DragPos dragPos0 = new DragPos(f, f1);
        this.c.autoScroll(o00, this.a, dragPos0);
        super.onChildDraw(canvas0, recyclerView0, o00, dragPos0.x, dragPos0.y, v, z);
    }

    @Override  // com.paulburke.android.itemtouchhelperdemo.SimpleItemTouchHelperCallback
    public boolean onMove(RecyclerView recyclerView0, O0 o00, O0 o01) {
        j0 j00 = recyclerView0.getAdapter();
        if(j00 instanceof DragSortHeaderFooterAdapter) {
            int v = o01.getAdapterPosition();
            if(v == ((DragSortHeaderFooterAdapter)j00).getDragSortHeaderViewPosition()) {
                return false;
            }
            return v == ((DragSortHeaderFooterAdapter)j00).getDragSortFooterViewPosition() ? false : super.onMove(recyclerView0, o00, o01);
        }
        return super.onMove(recyclerView0, o00, o01);
    }

    @Override  // com.paulburke.android.itemtouchhelperdemo.SimpleItemTouchHelperCallback
    public void onSelectedChanged(O0 o00, int v) {
        super.onSelectedChanged(o00, v);
        ItemTouchHelperAdapter itemTouchHelperAdapter0 = this.a;
        if(v == 2) {
            itemTouchHelperAdapter0.onItemMoveStart();
            return;
        }
        if(v == 0) {
            itemTouchHelperAdapter0.onItemMoveFinish();
        }
    }

    public void setAutoScrollWindow(float f) {
        ScrollStrategyBase scrollStrategyBase0 = this.c;
        if(scrollStrategyBase0 != null) {
            scrollStrategyBase0.setAutoScrollWindow(f);
        }
    }

    public void setScrollSpeed(ScrollSpeed scrollStrategyBase$ScrollSpeed0) {
        ScrollStrategyBase scrollStrategyBase0 = this.c;
        if(scrollStrategyBase0 != null) {
            scrollStrategyBase0.setScrollSpeed(scrollStrategyBase$ScrollSpeed0);
        }
    }
}

