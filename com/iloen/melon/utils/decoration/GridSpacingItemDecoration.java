package com.iloen.melon.utils.decoration;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.K0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.r0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u0012\u001A\u00020\u00112\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/iloen/melon/utils/decoration/GridSpacingItemDecoration;", "Landroidx/recyclerview/widget/r0;", "", "spanCount", "spacing", "", "includeEdge", "<init>", "(IIZ)V", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/K0;", "state", "Lie/H;", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/K0;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class GridSpacingItemDecoration extends r0 {
    public static final int $stable = 8;
    public final int a;
    public final int b;
    public final boolean c;

    public GridSpacingItemDecoration(int v, int v1, boolean z) {
        this.a = v;
        this.b = v1;
        this.c = z;
    }

    public GridSpacingItemDecoration(int v, int v1, boolean z, int v2, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v2 & 4) != 0) {
            z = false;
        }
        this(v, v1, z);
    }

    @Override  // androidx.recyclerview.widget.r0
    public void getItemOffsets(@NotNull Rect rect0, @NotNull View view0, @NotNull RecyclerView recyclerView0, @NotNull K0 k00) {
        q.g(rect0, "outRect");
        q.g(view0, "view");
        q.g(recyclerView0, "parent");
        q.g(k00, "state");
        int v = recyclerView0.getChildAdapterPosition(view0);
        int v1 = this.a;
        int v2 = v % v1;
        int v3 = this.b;
        if(this.c) {
            rect0.left = v3 - v2 * v3 / v1;
            rect0.right = (v2 + 1) * v3 / v1;
            if(v < v1) {
                rect0.top = v3;
            }
            rect0.bottom = v3;
            return;
        }
        rect0.left = v2 * v3 / v1;
        rect0.right = v3 - (v2 + 1) * v3 / v1;
        if(v >= v1) {
            rect0.top = v3;
        }
    }
}

