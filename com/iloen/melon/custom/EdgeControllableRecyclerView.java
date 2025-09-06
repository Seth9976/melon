package com.iloen.melon.custom;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.w0;
import com.iloen.melon.adapters.common.p;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r8.i;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\t\u001A\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u000F\u0010\u000B\u001A\u00020\bH\u0014¢\u0006\u0004\b\u000B\u0010\nJ\u0015\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\r\u001A\u00020\f¢\u0006\u0004\b\u000F\u0010\u0010J\u0015\u0010\u0011\u001A\u00020\u000E2\u0006\u0010\r\u001A\u00020\f¢\u0006\u0004\b\u0011\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/iloen/melon/custom/EdgeControllableRecyclerView;", "Lcom/iloen/melon/custom/RecyclerViewWithEmptyView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "getBottomFadingEdgeStrength", "()F", "getTopFadingEdgeStrength", "", "enable", "Lie/H;", "setTopFadingEdgeEnable", "(Z)V", "setBottomFadingEdgeEnable", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class EdgeControllableRecyclerView extends RecyclerViewWithEmptyView {
    public boolean k1;
    public boolean l1;

    public EdgeControllableRecyclerView(@NotNull Context context0, @Nullable AttributeSet attributeSet0) {
        q.g(context0, "context");
        super(context0, attributeSet0);
        this.k1 = true;
        this.l1 = true;
    }

    @Override  // android.view.View
    public float getBottomFadingEdgeStrength() {
        int v1;
        boolean z = this.l1;
        if(z) {
            j0 j00 = this.getAdapter();
            if(j00 != null) {
                w0 w00 = this.getLayoutManager();
                LinearLayoutManager linearLayoutManager0 = w00 instanceof LinearLayoutManager ? ((LinearLayoutManager)w00) : null;
                boolean z1 = true;
                if(linearLayoutManager0 != null) {
                    int v = linearLayoutManager0.findLastCompletelyVisibleItemPosition();
                    if(j00 instanceof i) {
                        v1 = ((i)j00).getCount();
                    }
                    else {
                        v1 = j00 instanceof p ? ((p)j00).getCount() : j00.getItemCount();
                    }
                    if(v >= v1 - 1) {
                        z1 = false;
                    }
                }
                z = z1;
            }
        }
        return z ? super.getBottomFadingEdgeStrength() : 0.0f;
    }

    // 去混淆评级： 低(20)
    @Override  // android.view.View
    public float getTopFadingEdgeStrength() {
        return this.k1 ? super.getTopFadingEdgeStrength() : 0.0f;
    }

    public final void setBottomFadingEdgeEnable(boolean z) {
        this.l1 = z;
    }

    public final void setTopFadingEdgeEnable(boolean z) {
        this.k1 = z;
    }
}

