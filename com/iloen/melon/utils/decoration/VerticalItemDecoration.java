package com.iloen.melon.utils.decoration;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.K0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.r0;
import com.iloen.melon.utils.system.ScreenUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u001B\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J/\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/iloen/melon/utils/decoration/VerticalItemDecoration;", "Landroidx/recyclerview/widget/r0;", "", "itemSpacing", "marginVertical", "<init>", "(FF)V", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/K0;", "state", "Lie/H;", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/K0;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class VerticalItemDecoration extends r0 {
    public static final int $stable = 8;
    public final float a;
    public final float b;

    public VerticalItemDecoration() {
        this(0.0f, 0.0f, 3, null);
    }

    public VerticalItemDecoration(float f, float f1) {
        this.a = f;
        this.b = f1;
    }

    public VerticalItemDecoration(float f, float f1, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            f = 0.0f;
        }
        if((v & 2) != 0) {
            f1 = 0.0f;
        }
        this(f, f1);
    }

    @Override  // androidx.recyclerview.widget.r0
    public void getItemOffsets(@NotNull Rect rect0, @NotNull View view0, @NotNull RecyclerView recyclerView0, @NotNull K0 k00) {
        q.g(rect0, "outRect");
        q.g(view0, "view");
        q.g(recyclerView0, "parent");
        q.g(k00, "state");
        Context context0 = view0.getContext();
        float f = this.a;
        if(f != 0.0f) {
            rect0.top = ScreenUtils.dipToPixel(context0, f / 2.0f);
            rect0.bottom = ScreenUtils.dipToPixel(context0, f / 2.0f);
        }
        j0 j00 = recyclerView0.getAdapter();
        q.d(j00);
        int v = j00.getItemCount();
        float f1 = this.b;
        if(v == 1) {
            rect0.top = ScreenUtils.dipToPixel(context0, f1);
            return;
        }
        int v1 = recyclerView0.getChildAdapterPosition(view0);
        j0 j01 = recyclerView0.getAdapter();
        q.d(j01);
        if(v1 == j01.getItemCount() - 1) {
            rect0.bottom = ScreenUtils.dipToPixel(context0, f1);
            return;
        }
        if(recyclerView0.getChildAdapterPosition(view0) == 0) {
            rect0.top = ScreenUtils.dipToPixel(context0, f1);
        }
    }
}

