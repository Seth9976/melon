package com.kakao.emoticon.ui.tab;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.L;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.kakao.emoticon.R.dimen;
import com.kakao.emoticon.R.drawable;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

public class TabItemTouchHelperCallback extends L {
    private static final long DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS = 500L;
    private int deletePosition;
    private boolean isItemSelected;
    private boolean isOutSideTouch;
    private final TabItemTouchHelperAdapter mAdapter;
    private int mCachedMaxScrollSpeed;
    private final TabItemTouchListener mItemTouchListener;
    private final RecyclerView mRecyclerView;
    private static final Interpolator sDragScrollInterpolator;
    private static final Interpolator sDragViewScrollCapInterpolator;
    private int selectTo;
    private int tempDeletePosition;
    private final RectF trashArea;

    static {
        TabItemTouchHelperCallback.sDragScrollInterpolator = new d(0);
        TabItemTouchHelperCallback.sDragViewScrollCapInterpolator = new d(1);
    }

    public TabItemTouchHelperCallback(RecyclerView recyclerView0, TabItemTouchHelperAdapter tabItemTouchHelperAdapter0, TabItemTouchListener tabItemTouchListener0) {
        this.trashArea = new RectF();
        this.tempDeletePosition = -1;
        this.deletePosition = -1;
        this.selectTo = -1;
        this.mCachedMaxScrollSpeed = -1;
        this.mAdapter = tabItemTouchHelperAdapter0;
        this.mRecyclerView = recyclerView0;
        this.mItemTouchListener = tabItemTouchListener0;
    }

    public static float a(float f) {
        return f;
    }

    public static float b(float f) {
        return f - 1.0f + 1.0f;
    }

    @Override  // androidx.recyclerview.widget.L
    public void clearView(RecyclerView recyclerView0, O0 o00) {
        super.clearView(recyclerView0, o00);
        j0 j00 = this.mRecyclerView.getAdapter();
        Objects.requireNonNull(j00);
        EmoticonTabItem emoticonTabItem0 = ((EmoticonTabAdapter)j00).getItem(o00.getAdapterPosition());
        if(((EmoticonTabAdapter)this.mRecyclerView.getAdapter()).getSelectedItem() != null && emoticonTabItem0 != null && !emoticonTabItem0.getItemId().equals(((EmoticonTabAdapter)this.mRecyclerView.getAdapter()).getSelectedItem().getItemId())) {
            int v = o00.getAdapterPosition();
            ((EmoticonTabAdapter)this.mRecyclerView.getAdapter()).getItem(v).setIconImage(((TabViewHolder)o00).emoticonBtn);
        }
        o00.itemView.setAlpha(1.0f);
        o00.itemView.setScaleX(1.0f);
        o00.itemView.setScaleY(1.0f);
        o00.itemView.setBackgroundResource(drawable.emoticon_bottom);
        this.mItemTouchListener.onItemClear();
        if(this.deletePosition > -1 && emoticonTabItem0 instanceof DefaultItem) {
            o00.itemView.setAlpha(0.0f);
            this.mAdapter.onItemDismiss(this.deletePosition);
            return;
        }
        o00.itemView.setAlpha(1.0f);
    }

    @Override  // androidx.recyclerview.widget.L
    public int getBoundingBoxMargin() {
        return this.mRecyclerView == null || !this.isOutSideTouch ? super.getBoundingBoxMargin() : this.mRecyclerView.getHeight();
    }

    @SuppressLint({"PrivateResource"})
    private int getMaxDragScroll(RecyclerView recyclerView0) {
        if(this.mCachedMaxScrollSpeed == -1) {
            this.mCachedMaxScrollSpeed = recyclerView0.getResources().getDimensionPixelSize(0x7F070125);  // dimen:item_touch_helper_max_drag_scroll_per_frame
        }
        return this.mCachedMaxScrollSpeed;
    }

    // 去混淆评级： 低(20)
    @Override  // androidx.recyclerview.widget.L
    public int getMovementFlags(RecyclerView recyclerView0, O0 o00) {
        return 0xF000F;
    }

    @Override  // androidx.recyclerview.widget.L
    public int interpolateOutOfBoundsScroll(RecyclerView recyclerView0, int v, int v1, int v2, long v3) {
        int v4 = this.getMaxDragScroll(recyclerView0);
        float f = 1.0f;
        int v5 = (int)(TabItemTouchHelperCallback.sDragViewScrollCapInterpolator.getInterpolation(Math.min(1.0f, ((float)Math.abs(v1)) * 1.0f / ((float)v))) * ((float)(((int)Math.signum(v1)) * v4)));
        if(v3 <= 500L) {
            f = ((float)v3) / 500.0f;
        }
        int v6 = (int)(TabItemTouchHelperCallback.sDragScrollInterpolator.getInterpolation(f) * ((float)v5));
        if(v6 == 0) {
            return v1 <= 0 ? -1 : 1;
        }
        return v6;
    }

    // 去混淆评级： 低(20)
    private static boolean isEmoticonItem(EmoticonTabItem emoticonTabItem0) {
        return emoticonTabItem0 instanceof DefaultItem || emoticonTabItem0 instanceof ExpiredItem;
    }

    @Override  // androidx.recyclerview.widget.L
    public boolean isItemViewSwipeEnabled() {
        return false;
    }

    @Override  // androidx.recyclerview.widget.L
    public boolean isLongPressDragEnabled() {
        return true;
    }

    private static float lambda$static$0(float f) [...] // Inlined contents

    private static float lambda$static$1(float f) [...] // Inlined contents

    @Override  // androidx.recyclerview.widget.L
    public void onChildDraw(@NotNull Canvas canvas0, @NotNull RecyclerView recyclerView0, @NotNull O0 o00, float f, float f1, int v, boolean z) {
        if(this.isItemSelected && v == 2 && this.deletePosition == -1) {
            j0 j00 = this.mRecyclerView.getAdapter();
            Objects.requireNonNull(j00);
            if(TabItemTouchHelperCallback.isEmoticonItem(((EmoticonTabAdapter)j00).getItem(o00.getAdapterPosition()))) {
                float f2 = o00.itemView.getX();
                float f3 = o00.itemView.getY();
                float f4 = o00.itemView.getX() + ((float)o00.itemView.getWidth());
                float f5 = o00.itemView.getY() + ((float)o00.itemView.getHeight());
                boolean z1 = false;
                if(this.trashArea.intersects(f2, f3, f4, f5)) {
                    this.mItemTouchListener.onTrashHover(true);
                    o00.itemView.setAlpha(0.9f);
                    this.tempDeletePosition = o00.getAdapterPosition();
                    this.selectTo = -1;
                }
                else {
                    this.mItemTouchListener.onTrashHover(false);
                    this.tempDeletePosition = -1;
                    o00.itemView.setAlpha(1.0f);
                }
                if(o00.itemView.getX() + ((float)o00.itemView.getWidth()) > ((float)recyclerView0.getRight()) || o00.itemView.getX() < ((float)recyclerView0.getLeft())) {
                    z1 = true;
                }
                this.isOutSideTouch = z1;
                super.onChildDraw(canvas0, recyclerView0, o00, f, f1, 2, z);
            }
        }
    }

    @Override  // androidx.recyclerview.widget.L
    public boolean onMove(@NotNull RecyclerView recyclerView0, @NotNull O0 o00, @NotNull O0 o01) {
        if(o00.getItemViewType() != o01.getItemViewType()) {
            return false;
        }
        j0 j00 = this.mRecyclerView.getAdapter();
        Objects.requireNonNull(j00);
        EmoticonTabItem emoticonTabItem0 = ((EmoticonTabAdapter)j00).getItem(o00.getAdapterPosition());
        int v = o01.getAdapterPosition();
        if(TabItemTouchHelperCallback.isEmoticonItem(emoticonTabItem0) && TabItemTouchHelperCallback.isEmoticonItem(((EmoticonTabAdapter)this.mRecyclerView.getAdapter()).getItem(v))) {
            this.selectTo = o01.getAdapterPosition();
            int v1 = o00.getAdapterPosition();
            int v2 = o01.getAdapterPosition();
            this.mAdapter.onItemMove(v1, v2);
            return true;
        }
        return false;
    }

    @Override  // androidx.recyclerview.widget.L
    public void onSelectedChanged(O0 o00, int v) {
        if(v == 0) {
            int v4 = this.tempDeletePosition;
            if(v4 > -1) {
                this.deletePosition = v4;
                this.tempDeletePosition = -1;
                return;
            }
            int v5 = this.selectTo;
            if(v5 > -1) {
                this.mAdapter.onItemIdle(v5);
                this.selectTo = -1;
            }
        }
        else if(o00 instanceof TabViewHolder) {
            int v1 = o00.getAdapterPosition();
            if(TabItemTouchHelperCallback.isEmoticonItem(((EmoticonTabAdapter)this.mRecyclerView.getAdapter()).getItem(v1))) {
                this.isOutSideTouch = false;
                this.deletePosition = -1;
                this.tempDeletePosition = -1;
                int v2 = o00.getAdapterPosition();
                ((EmoticonTabAdapter)this.mRecyclerView.getAdapter()).getItem(v2).setIconOnImage(((TabViewHolder)o00).emoticonBtn);
                o00.itemView.setAlpha(1.0f);
                o00.itemView.setScaleX(1.3f);
                o00.itemView.setScaleY(1.3f);
                o00.itemView.setBackgroundResource(drawable.tab_menu_select);
                if(this.mItemTouchListener.onItemSelected()) {
                    this.isItemSelected = true;
                    Resources resources0 = this.mRecyclerView.getContext().getResources();
                    float f = ((float)this.mRecyclerView.getWidth()) / 2.0f;
                    float f1 = resources0.getDimension(dimen.emoticon_tab_height);
                    float f2 = ((float)this.mRecyclerView.getWidth()) / 2.0f;
                    float f3 = resources0.getDimension(dimen.emoticon_tab_height);
                    float f4 = (float)this.mRecyclerView.getTop();
                    float f5 = (((float)this.mRecyclerView.getHeight()) - resources0.getDimension(dimen.emoticon_tab_trash_btn_height)) / 2.0f + f4;
                    float f6 = resources0.getDimension(dimen.emoticon_tab_trash_btn_height);
                    this.trashArea.set(f - f1, f5, f3 + f2, f6 + f5);
                }
                else {
                    this.clearView(this.mRecyclerView, o00);
                    this.isItemSelected = false;
                }
                int v3 = o00.getAdapterPosition();
                this.mAdapter.onItemSelected(v3);
            }
        }
    }

    @Override  // androidx.recyclerview.widget.L
    public void onSwiped(O0 o00, int v) {
    }
}

