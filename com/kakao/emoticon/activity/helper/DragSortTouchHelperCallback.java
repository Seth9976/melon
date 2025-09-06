package com.kakao.emoticon.activity.helper;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.L;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 52\u00020\u0001:\u00015B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0003\u00A2\u0006\u0004\b\t\u0010\nJ\u000F\u0010\f\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000E\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b\u000E\u0010\rJ\u001F\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0011\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u001F\u0010\u0015\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0010\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b\u0015\u0010\u0016J\'\u0010\u0019\u001A\u00020\u000B2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0017\u001A\u00020\u000F2\u0006\u0010\u0018\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b\u0019\u0010\u001AJ7\u0010 \u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u001B\u001A\u00020\b2\u0006\u0010\u001C\u001A\u00020\b2\u0006\u0010\u001D\u001A\u00020\b2\u0006\u0010\u001F\u001A\u00020\u001EH\u0016\u00A2\u0006\u0004\b \u0010!JG\u0010)\u001A\u00020\u00122\u0006\u0010#\u001A\u00020\"2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010%\u001A\u00020$2\u0006\u0010&\u001A\u00020$2\u0006\u0010\'\u001A\u00020\b2\u0006\u0010(\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b)\u0010*J!\u0010+\u001A\u00020\u00122\b\u0010\u0010\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\'\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b+\u0010\u0014J\u001F\u0010,\u001A\u00020\u00122\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0010\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b,\u0010-R\u0016\u0010.\u001A\u00020\b8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00101\u001A\u0002008\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b1\u00102R\u0014\u00103\u001A\u0002008\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b3\u00102R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0003\u00104\u00A8\u00066"}, d2 = {"Lcom/kakao/emoticon/activity/helper/DragSortTouchHelperCallback;", "Landroidx/recyclerview/widget/L;", "Lcom/kakao/emoticon/activity/helper/DragSortTouchHelperAdapter;", "mAdapter", "<init>", "(Lcom/kakao/emoticon/activity/helper/DragSortTouchHelperAdapter;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "getMaxDragScroll", "(Landroidx/recyclerview/widget/RecyclerView;)I", "", "isLongPressDragEnabled", "()Z", "isItemViewSwipeEnabled", "Landroidx/recyclerview/widget/O0;", "viewHolder", "direction", "Lie/H;", "onSwiped", "(Landroidx/recyclerview/widget/O0;I)V", "getMovementFlags", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/O0;)I", "source", "target", "onMove", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/O0;Landroidx/recyclerview/widget/O0;)Z", "viewSize", "viewSizeOutOfBounds", "totalSize", "", "msSinceStartScroll", "interpolateOutOfBoundsScroll", "(Landroidx/recyclerview/widget/RecyclerView;IIIJ)I", "Landroid/graphics/Canvas;", "c", "", "dX", "dY", "actionState", "isCurrentlyActive", "onChildDraw", "(Landroid/graphics/Canvas;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/O0;FFIZ)V", "onSelectedChanged", "clearView", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/O0;)V", "mCachedMaxScrollSpeed", "I", "Landroid/view/animation/Interpolator;", "sDragScrollInterpolator", "Landroid/view/animation/Interpolator;", "sDragViewScrollCapInterpolator", "Lcom/kakao/emoticon/activity/helper/DragSortTouchHelperAdapter;", "Companion", "kakaoemoticon-sdk-lib_release"}, k = 1, mv = {1, 4, 0})
public final class DragSortTouchHelperCallback extends L {
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/kakao/emoticon/activity/helper/DragSortTouchHelperCallback$Companion;", "", "()V", "DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS", "", "kakaoemoticon-sdk-lib_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final Companion Companion = null;
    private static final long DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS = 500L;
    private final DragSortTouchHelperAdapter mAdapter;
    private int mCachedMaxScrollSpeed;
    private final Interpolator sDragScrollInterpolator;
    private final Interpolator sDragViewScrollCapInterpolator;

    static {
        DragSortTouchHelperCallback.Companion = new Companion(null);
    }

    public DragSortTouchHelperCallback(@NotNull DragSortTouchHelperAdapter dragSortTouchHelperAdapter0) {
        q.g(dragSortTouchHelperAdapter0, "mAdapter");
        super();
        this.mAdapter = dragSortTouchHelperAdapter0;
        this.mCachedMaxScrollSpeed = -1;
        this.sDragScrollInterpolator = (float f) -> f;
        this.sDragViewScrollCapInterpolator = (float f) -> f - 1.0f + 1.0f;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "t", "getInterpolation"}, k = 3, mv = {1, 4, 0})
        final class com.kakao.emoticon.activity.helper.DragSortTouchHelperCallback.sDragScrollInterpolator.1 implements Interpolator {
            public static final com.kakao.emoticon.activity.helper.DragSortTouchHelperCallback.sDragScrollInterpolator.1 INSTANCE;

            static {
                com.kakao.emoticon.activity.helper.DragSortTouchHelperCallback.sDragScrollInterpolator.1.INSTANCE = new com.kakao.emoticon.activity.helper.DragSortTouchHelperCallback.sDragScrollInterpolator.1();
            }

            public com.kakao.emoticon.activity.helper.DragSortTouchHelperCallback.sDragScrollInterpolator.1() {
                super();
            }

            // 检测为 Lambda 实现
            @Override  // android.animation.TimeInterpolator
            public final float getInterpolation(float f) [...]
        }


        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "t", "getInterpolation"}, k = 3, mv = {1, 4, 0})
        final class com.kakao.emoticon.activity.helper.DragSortTouchHelperCallback.sDragViewScrollCapInterpolator.1 implements Interpolator {
            public static final com.kakao.emoticon.activity.helper.DragSortTouchHelperCallback.sDragViewScrollCapInterpolator.1 INSTANCE;

            static {
                com.kakao.emoticon.activity.helper.DragSortTouchHelperCallback.sDragViewScrollCapInterpolator.1.INSTANCE = new com.kakao.emoticon.activity.helper.DragSortTouchHelperCallback.sDragViewScrollCapInterpolator.1();
            }

            public com.kakao.emoticon.activity.helper.DragSortTouchHelperCallback.sDragViewScrollCapInterpolator.1() {
                super();
            }

            // 检测为 Lambda 实现
            @Override  // android.animation.TimeInterpolator
            public final float getInterpolation(float f) [...]
        }

    }

    @Override  // androidx.recyclerview.widget.L
    public void clearView(@NotNull RecyclerView recyclerView0, @NotNull O0 o00) {
        q.g(recyclerView0, "recyclerView");
        q.g(o00, "viewHolder");
        super.clearView(recyclerView0, o00);
        q.f(o00.itemView, "viewHolder.itemView");
        o00.itemView.setAlpha(1.0f);
        q.f(o00.itemView, "viewHolder.itemView");
        o00.itemView.setScaleX(1.0f);
        q.f(o00.itemView, "viewHolder.itemView");
        o00.itemView.setScaleY(1.0f);
        this.mAdapter.onItemClear();
    }

    @SuppressLint({"PrivateResource"})
    private final int getMaxDragScroll(RecyclerView recyclerView0) {
        if(this.mCachedMaxScrollSpeed == -1) {
            this.mCachedMaxScrollSpeed = recyclerView0.getResources().getDimensionPixelSize(0x7F070125);  // dimen:item_touch_helper_max_drag_scroll_per_frame
        }
        return this.mCachedMaxScrollSpeed;
    }

    @Override  // androidx.recyclerview.widget.L
    public int getMovementFlags(@NotNull RecyclerView recyclerView0, @NotNull O0 o00) {
        q.g(recyclerView0, "recyclerView");
        q.g(o00, "viewHolder");
        return 0x30003;
    }

    @Override  // androidx.recyclerview.widget.L
    public int interpolateOutOfBoundsScroll(@NotNull RecyclerView recyclerView0, int v, int v1, int v2, long v3) {
        q.g(recyclerView0, "recyclerView");
        int v4 = this.getMaxDragScroll(recyclerView0);
        float f = 1.0f;
        int v5 = (int)(this.sDragViewScrollCapInterpolator.getInterpolation(Math.min(1.0f, ((float)Math.abs(v1)) * 1.0f / ((float)v))) * ((float)(((int)Math.signum(v1)) * v4)));
        if(v3 <= 500L) {
            f = ((float)v3) / 500.0f;
        }
        int v6 = (int)(this.sDragScrollInterpolator.getInterpolation(f) * ((float)v5));
        if(v6 == 0) {
            return v1 <= 0 ? -1 : 1;
        }
        return v6;
    }

    @Override  // androidx.recyclerview.widget.L
    public boolean isItemViewSwipeEnabled() {
        return false;
    }

    @Override  // androidx.recyclerview.widget.L
    public boolean isLongPressDragEnabled() {
        return false;
    }

    @Override  // androidx.recyclerview.widget.L
    public void onChildDraw(@NotNull Canvas canvas0, @NotNull RecyclerView recyclerView0, @NotNull O0 o00, float f, float f1, int v, boolean z) {
        q.g(canvas0, "c");
        q.g(recyclerView0, "recyclerView");
        q.g(o00, "viewHolder");
        if(v == 2) {
            super.onChildDraw(canvas0, recyclerView0, o00, f, f1, 2, z);
        }
    }

    @Override  // androidx.recyclerview.widget.L
    public boolean onMove(@NotNull RecyclerView recyclerView0, @NotNull O0 o00, @NotNull O0 o01) {
        q.g(recyclerView0, "recyclerView");
        q.g(o00, "source");
        q.g(o01, "target");
        if(o00.getAdapterPosition() != 0 && o01.getAdapterPosition() != 0) {
            int v = o00.getAdapterPosition();
            int v1 = o01.getAdapterPosition();
            this.mAdapter.onItemMove(v, v1);
            return true;
        }
        return false;
    }

    @Override  // androidx.recyclerview.widget.L
    public void onSelectedChanged(@Nullable O0 o00, int v) {
        if(v != 0 && o00 != null) {
            q.f(o00.itemView, "viewHolder.itemView");
            o00.itemView.setAlpha(0.9f);
            q.f(o00.itemView, "viewHolder.itemView");
            o00.itemView.setScaleX(1.05f);
            q.f(o00.itemView, "viewHolder.itemView");
            o00.itemView.setScaleY(1.05f);
        }
    }

    @Override  // androidx.recyclerview.widget.L
    public void onSwiped(@NotNull O0 o00, int v) {
        q.g(o00, "viewHolder");
    }
}

