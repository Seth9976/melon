package com.iloen.melon.utils.dragdrop.scroll;

import android.view.View;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.paulburke.android.itemtouchhelperdemo.ItemTouchHelperAdapter;

public class FlexibleViewScrollStrategy extends ScrollStrategyBase {
    public FlexibleViewScrollStrategy(RecyclerView recyclerView0) {
        super(recyclerView0);
    }

    @Override  // com.iloen.melon.utils.dragdrop.scroll.ScrollStrategyBase
    public void autoScroll(O0 o00, ItemTouchHelperAdapter itemTouchHelperAdapter0, DragPos dragPos0) {
        int v = this.getFirstVisiblePosition();
        int v1 = this.getLastVisiblePosition();
        O0 o01 = this.recyclerView.findViewHolderForAdapterPosition(v);
        O0 o02 = this.recyclerView.findViewHolderForAdapterPosition(v1);
        if(o01 != null && o02 != null) {
            float f = (float)o01.itemView.getBottom();
            float f1 = (float)o02.itemView.getTop();
            float f2 = (float)o00.itemView.getTop();
            float f3 = (float)o00.itemView.getBottom();
            float f4 = (float)o00.itemView.getLeft();
            float f5 = (float)o00.itemView.getRight();
            int v2 = this.recyclerView.getLeft();
            int v3 = this.recyclerView.getRight();
            float f6 = dragPos0.y;
            if(Float.compare(f2 + f6, f) > 0) {
                if(f3 + f6 >= f1 && f6 > 0.0f) {
                    dragPos0.y = f1 - f3;
                }
            }
            else if(f6 < 0.0f) {
                dragPos0.y = f - f2;
            }
            float f7 = dragPos0.x;
            if(f4 + f7 > 0.0f) {
                float f8 = (float)(v3 - v2);
                if(f5 + f7 >= f8 && f7 > 0.0f) {
                    dragPos0.x = f8 - f5;
                }
            }
            else if(f7 < 0.0f) {
                dragPos0.x = 0.0f;
            }
        }
    }

    @Override  // com.iloen.melon.utils.dragdrop.scroll.ScrollStrategyBase
    public int getFirstVisiblePosition() {
        if(this.recyclerView.getLayoutManager() instanceof FlexboxLayoutManager) {
            FlexboxLayoutManager flexboxLayoutManager0 = (FlexboxLayoutManager)this.recyclerView.getLayoutManager();
            View view0 = flexboxLayoutManager0.z(0, flexboxLayoutManager0.getChildCount());
            return view0 == null ? -1 : flexboxLayoutManager0.getPosition(view0);
        }
        return 0;
    }

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.utils.dragdrop.scroll.ScrollStrategyBase
    public int getLastVisiblePosition() {
        return this.recyclerView.getLayoutManager() instanceof FlexboxLayoutManager ? ((FlexboxLayoutManager)this.recyclerView.getLayoutManager()).findLastVisibleItemPosition() : 0;
    }

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.utils.dragdrop.scroll.ScrollStrategyBase
    public int getMovementFlags() {
        return 0xF000F;
    }
}

