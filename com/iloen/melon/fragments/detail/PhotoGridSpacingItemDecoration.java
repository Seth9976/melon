package com.iloen.melon.fragments.detail;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.K0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.r0;
import androidx.recyclerview.widget.w0;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.utils.system.ScreenUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u0012\u001A\u00020\u00112\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/iloen/melon/fragments/detail/PhotoGridSpacingItemDecoration;", "Landroidx/recyclerview/widget/r0;", "<init>", "()V", "Landroid/content/Context;", "context", "", "getSpacingPx", "(Landroid/content/Context;)I", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/K0;", "state", "Lie/H;", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/K0;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PhotoGridSpacingItemDecoration extends r0 {
    public static final int $stable = 8;

    @Override  // androidx.recyclerview.widget.r0
    public void getItemOffsets(@NotNull Rect rect0, @NotNull View view0, @NotNull RecyclerView recyclerView0, @NotNull K0 k00) {
        q.g(rect0, "outRect");
        q.g(view0, "view");
        q.g(recyclerView0, "recyclerView");
        q.g(k00, "state");
        j0 j00 = recyclerView0.getAdapter();
        GridLayoutManager gridLayoutManager0 = null;
        p p0 = j00 instanceof p ? ((p)j00) : null;
        if(p0 != null) {
            w0 w00 = recyclerView0.getLayoutManager();
            if(w00 instanceof GridLayoutManager) {
                gridLayoutManager0 = (GridLayoutManager)w00;
            }
            if(gridLayoutManager0 != null) {
                int v = gridLayoutManager0.b;
                int v1 = recyclerView0.getChildAdapterPosition(view0);
                int v2 = v1 - p0.getHeaderCount();
                if(!p0.isReservedPosition(v1) && v2 >= 0) {
                    int v3 = v2 % v;
                    Context context0 = recyclerView0.getContext();
                    q.d(context0);
                    int v4 = this.getSpacingPx(context0);
                    int v5 = ScreenUtils.dipToPixel(context0, 1.0f);
                    rect0.left = v3 == 0 ? v5 : v4;
                    if(v3 != v - 1) {
                        v5 = v4;
                    }
                    rect0.right = v5;
                    rect0.top = v4;
                    rect0.bottom = v4;
                }
            }
        }
    }

    // 去混淆评级： 低(20)
    private final int getSpacingPx(Context context0) {
        return !ScreenUtils.isTablet(context0) || ScreenUtils.isOrientationPortrait(context0) ? ScreenUtils.dipToPixel(context0, 1.0f) : ScreenUtils.dipToPixel(context0, 1.5f);
    }
}

