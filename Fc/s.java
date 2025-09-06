package Fc;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.K0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.r0;
import kotlin.jvm.internal.q;

public final class s extends r0 {
    public final int a;
    public final int b;
    public final int c;

    public s(int v, int v1, int v2) {
        this.a = v;
        this.b = v1;
        this.c = v2;
    }

    @Override  // androidx.recyclerview.widget.r0
    public final void getItemOffsets(Rect rect0, View view0, RecyclerView recyclerView0, K0 k00) {
        q.g(rect0, "outRect");
        q.g(view0, "view");
        q.g(k00, "state");
        rect0.left = this.a;
        rect0.right = this.a;
        rect0.bottom = recyclerView0.getChildAdapterPosition(view0) == k00.b() - 1 ? this.c : this.b;
    }
}

