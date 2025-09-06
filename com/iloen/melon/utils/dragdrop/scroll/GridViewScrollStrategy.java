package com.iloen.melon.utils.dragdrop.scroll;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.iloen.melon.utils.dragdrop.DragSortHeaderFooterAdapter;
import com.paulburke.android.itemtouchhelperdemo.ItemTouchHelperAdapter;

public class GridViewScrollStrategy extends ScrollStrategyBase {
    public GridViewScrollStrategy(RecyclerView recyclerView0) {
        super(recyclerView0);
    }

    @Override  // com.iloen.melon.utils.dragdrop.scroll.ScrollStrategyBase
    public void autoScroll(O0 o00, ItemTouchHelperAdapter itemTouchHelperAdapter0, DragPos dragPos0) {
        int v3;
        int v2;
        int v = itemTouchHelperAdapter0.currentDragPosition();
        int v1 = this.recyclerView.getAdapter().getItemCount();
        j0 j00 = this.recyclerView.getAdapter();
        if(j00 instanceof DragSortHeaderFooterAdapter) {
            v2 = ((DragSortHeaderFooterAdapter)j00).getDragSortHeaderViewPosition();
            v3 = ((DragSortHeaderFooterAdapter)j00).getDragSortFooterViewPosition();
        }
        else {
            v3 = v1;
            v2 = -1;
        }
        int v4 = this.getFirstVisiblePosition();
        if(v4 <= v2) {
            v4 = v2 + 1;
        }
        if(v - 1 <= v2 && dragPos0.y < 0.0f) {
            dragPos0.y = 0.0f;
        }
        else if(v + 1 >= v3 && dragPos0.y > 0.0f) {
            dragPos0.y = 0.0f;
        }
        this.autoScrollVertical(this.recyclerView, o00, dragPos0.y, v4);
    }

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.utils.dragdrop.scroll.ScrollStrategyBase
    public int getFirstVisiblePosition() {
        return this.recyclerView.getLayoutManager() instanceof GridLayoutManager ? ((GridLayoutManager)this.recyclerView.getLayoutManager()).findFirstVisibleItemPosition() : 0;
    }

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.utils.dragdrop.scroll.ScrollStrategyBase
    public int getLastVisiblePosition() {
        return this.recyclerView.getLayoutManager() instanceof GridLayoutManager ? ((GridLayoutManager)this.recyclerView.getLayoutManager()).findLastVisibleItemPosition() : 0;
    }

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.utils.dragdrop.scroll.ScrollStrategyBase
    public int getMovementFlags() {
        return 0xF000F;
    }
}

