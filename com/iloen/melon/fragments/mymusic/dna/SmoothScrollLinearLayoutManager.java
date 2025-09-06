package com.iloen.melon.fragments.mymusic.dna;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.K0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000E\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0002\u0018\u0019B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J+\u0010\r\u001A\u00020\f2\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010\t\u001A\u0004\u0018\u00010\b2\u0006\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000ER\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000F\u001A\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001A\u00020\n8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001A"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/dna/SmoothScrollLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/K0;", "state", "", "position", "Lie/H;", "smoothScrollToPosition", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/K0;I)V", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "offset", "I", "getOffset", "()I", "setOffset", "(I)V", "Companion", "Scroller", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SmoothScrollLinearLayoutManager extends LinearLayoutManager {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/dna/SmoothScrollLinearLayoutManager$Companion;", "", "<init>", "()V", "TAG", "", "MILLISECONDS_PER_INCH", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001A\u0004\u0018\u00010\u00072\u0006\u0010\b\u001A\u00020\tH\u0016J\u001A\u0010\n\u001A\u00020\t2\b\u0010\u000B\u001A\u0004\u0018\u00010\f2\u0006\u0010\r\u001A\u00020\tH\u0016J\u0010\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u0011H\u0014¨\u0006\u0012"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/dna/SmoothScrollLinearLayoutManager$Scroller;", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "context", "Landroid/content/Context;", "<init>", "(Lcom/iloen/melon/fragments/mymusic/dna/SmoothScrollLinearLayoutManager;Landroid/content/Context;)V", "computeScrollVectorForPosition", "Landroid/graphics/PointF;", "targetPosition", "", "calculateDxToMakeVisible", "view", "Landroid/view/View;", "snapPreference", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class Scroller extends LinearSmoothScroller {
        public Scroller(@NotNull Context context0) {
            q.g(context0, "context");
            SmoothScrollLinearLayoutManager.this = smoothScrollLinearLayoutManager0;
            super(context0);
        }

        @Override  // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateDxToMakeVisible(@Nullable View view0, int v) {
            int v1 = super.calculateDxToMakeVisible(view0, -1);
            return SmoothScrollLinearLayoutManager.this.getOffset() + v1;
        }

        @Override  // androidx.recyclerview.widget.LinearSmoothScroller
        public float calculateSpeedPerPixel(@NotNull DisplayMetrics displayMetrics0) {
            q.g(displayMetrics0, "displayMetrics");
            return 25.0f / ((float)displayMetrics0.densityDpi);
        }

        @Override  // androidx.recyclerview.widget.J0
        @Nullable
        public PointF computeScrollVectorForPosition(int v) {
            return SmoothScrollLinearLayoutManager.this.computeScrollVectorForPosition(v);
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    private static final float MILLISECONDS_PER_INCH = 25.0f;
    @NotNull
    private static final String TAG = "SmoothScrollLinearLayoutManager";
    @NotNull
    private final Context context;
    private int offset;

    static {
        SmoothScrollLinearLayoutManager.Companion = new Companion(null);
        SmoothScrollLinearLayoutManager.$stable = 8;
    }

    public SmoothScrollLinearLayoutManager(@NotNull Context context0) {
        q.g(context0, "context");
        super(0, false);
        this.context = context0;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    public final int getOffset() {
        return this.offset;
    }

    public final void setOffset(int v) {
        this.offset = v;
    }

    @Override  // androidx.recyclerview.widget.LinearLayoutManager
    public void smoothScrollToPosition(@Nullable RecyclerView recyclerView0, @Nullable K0 k00, int v) {
        Scroller smoothScrollLinearLayoutManager$Scroller0 = new Scroller(this, this.context);
        smoothScrollLinearLayoutManager$Scroller0.setTargetPosition(v);
        this.startSmoothScroll(smoothScrollLinearLayoutManager$Scroller0);
    }
}

