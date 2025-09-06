package com.iloen.melon.utils.dragdrop.scroll;

import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.iloen.melon.utils.dragdrop.DragSortHeaderFooterAdapter;
import com.paulburke.android.itemtouchhelperdemo.ItemTouchHelperAdapter;

public class ScrollStrategyBase implements IDragScrollStrategy {
    public static enum ScrollSpeed {
        SCROLL_SPEED_LOW(10),
        SCROLL_SPEED_MIDDLE(30),
        SCROLL_SPEED_HIGH(50);

        public final int a;

        public ScrollSpeed(int v1) {
            this.a = v1;
        }

        public int getValue() {
            return this.a;
        }
    }

    public float a;
    public int b;
    protected boolean isHorizontal;
    protected RecyclerView recyclerView;

    public ScrollStrategyBase(RecyclerView recyclerView0) {
        this.a = 0.4f;
        this.b = ScrollSpeed.SCROLL_SPEED_MIDDLE.getValue();
        this.isHorizontal = false;
        this.recyclerView = recyclerView0;
    }

    @Override  // com.iloen.melon.utils.dragdrop.scroll.IDragScrollStrategy
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
        if(this.isHorizontal) {
            if(v - 1 <= v2 && dragPos0.x < 0.0f) {
                dragPos0.x = 0.0f;
            }
            else if(v + 1 >= v3 && dragPos0.x > 0.0f) {
                dragPos0.x = 0.0f;
            }
            this.autoScrollHorizontal(this.recyclerView, o00, dragPos0.x, v4);
            return;
        }
        if(v - 1 <= v2 && dragPos0.y < 0.0f) {
            dragPos0.y = 0.0f;
        }
        else if(v + 1 >= v3 && dragPos0.y > 0.0f) {
            dragPos0.y = 0.0f;
        }
        this.autoScrollVertical(this.recyclerView, o00, dragPos0.y, v4);
    }

    public void autoScrollHorizontal(RecyclerView recyclerView0, O0 o00, float f, int v) {
        O0 o01 = recyclerView0.findViewHolderForAdapterPosition(v);
        O0 o02 = recyclerView0.findViewHolderForAdapterPosition(this.getLastVisiblePosition());
        if(o01 != null && o02 != null) {
            float f1 = (float)o01.itemView.getLeft();
            int v1 = o02.itemView.getLeft();
            float f2 = (float)(o02.itemView.getWidth() + v1);
            float f3 = f2 - f1;
            float f4 = this.a * f3;
            float f5 = f3 - f4;
            float f6 = f3 - (o00.itemView.getX() + ((float)(o00.itemView.getWidth() / 2)));
            if(Float.compare(f, 0.0f) < 0) {
                if(f6 > f1 + f5) {
                    recyclerView0.scrollBy(-((int)(((float)this.b) * (1.0f - (f3 - f6) / f4))), 0);
                }
            }
            else if(f > 0.0f && f6 < f2 - f5) {
                recyclerView0.scrollBy(((int)(((float)this.b) * (1.0f - f6 / f4))), 0);
            }
        }
    }

    public void autoScrollVertical(RecyclerView recyclerView0, O0 o00, float f, int v) {
        O0 o01 = recyclerView0.findViewHolderForAdapterPosition(v);
        O0 o02 = recyclerView0.findViewHolderForAdapterPosition(this.getLastVisiblePosition());
        if(o01 != null && o02 != null) {
            float f1 = (float)o01.itemView.getTop();
            int v1 = o02.itemView.getTop();
            float f2 = (float)(o02.itemView.getHeight() + v1);
            float f3 = f2 - f1;
            float f4 = this.a * f3;
            float f5 = f3 - f4;
            float f6 = f3 - (o00.itemView.getY() + ((float)(o00.itemView.getHeight() / 2)));
            if(Float.compare(f, 0.0f) < 0) {
                if(f6 > f1 + f5) {
                    recyclerView0.scrollBy(0, -((int)(((float)this.b) * (1.0f - (f3 - f6) / f4))));
                }
            }
            else if(f > 0.0f && f6 < f2 - f5) {
                recyclerView0.scrollBy(0, ((int)(((float)this.b) * (1.0f - f6 / f4))));
            }
        }
    }

    @Override  // com.iloen.melon.utils.dragdrop.scroll.IDragScrollStrategy
    public int getFirstVisiblePosition() {
        return 0;
    }

    @Override  // com.iloen.melon.utils.dragdrop.scroll.IDragScrollStrategy
    public int getLastVisiblePosition() {
        return 0;
    }

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.utils.dragdrop.scroll.IDragScrollStrategy
    public int getMovementFlags() {
        return 0x33033;
    }

    public int getScrollSpeed() {
        return this.b;
    }

    public void setAutoScrollWindow(float f) {
        if(((double)f) >= 0.1 && ((double)f) <= 0.5) {
            this.a = f;
        }
    }

    public void setScrollSpeed(ScrollSpeed scrollStrategyBase$ScrollSpeed0) {
        this.b = scrollStrategyBase$ScrollSpeed0.getValue() / 2;
    }
}

