package Ic;

import Hc.O;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.K0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.r0;
import com.iloen.melon.utils.system.ScreenUtils;
import kotlin.jvm.internal.q;

public final class g extends r0 {
    public final int a;

    public g(int v) {
        this.a = v;
        super();
    }

    @Override  // androidx.recyclerview.widget.r0
    public final void getItemOffsets(Rect rect0, View view0, RecyclerView recyclerView0, K0 k00) {
        if(this.a != 0) {
            q.g(rect0, "outRect");
            q.g(view0, "view");
            q.g(k00, "state");
            Context context0 = view0.getContext();
            int v = recyclerView0.getChildAdapterPosition(view0);
            j0 j00 = recyclerView0.getAdapter();
            q.e(j00, "null cannot be cast to non-null type com.melon.ui.detail.DetailAdapter");
            int v1 = ScreenUtils.dipToPixel(context0, 22.0f);
            int v2 = ((O)j00).c + 1;
            if(v == ((O)j00).getItemCount() - 1) {
                rect0.bottom = ScreenUtils.dipToPixel(context0, 40.0f);
                return;
            }
            if(v == v2) {
                rect0.top = 0;
                return;
            }
            if(v > v2) {
                rect0.top = v1;
            }
            return;
        }
        q.g(rect0, "outRect");
        q.g(view0, "view");
        q.g(k00, "state");
        Context context1 = view0.getContext();
        int v3 = recyclerView0.getChildAdapterPosition(view0);
        j0 j01 = recyclerView0.getAdapter();
        q.e(j01, "null cannot be cast to non-null type com.melon.ui.detail.DetailAdapter");
        int v4 = ScreenUtils.dipToPixel(context1, 22.0f);
        int v5 = ((O)j01).c + 1;
        if(v3 == ((O)j01).getItemCount() - 1) {
            rect0.bottom = ScreenUtils.dipToPixel(context1, 40.0f);
            return;
        }
        if(v3 == v5) {
            rect0.top = 0;
            return;
        }
        if(v3 > v5) {
            rect0.top = v4;
        }
    }
}

