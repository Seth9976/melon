package androidx.recyclerview.widget;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;

public class f0 extends y0 {
    public RecyclerView a;
    public final R0 b;
    public c0 c;
    public b0 d;

    public f0() {
        this.b = new R0(this);
    }

    public final void a(RecyclerView recyclerView0) {
        RecyclerView recyclerView1 = this.a;
        if(recyclerView1 != recyclerView0) {
            R0 r00 = this.b;
            if(recyclerView1 != null) {
                recyclerView1.removeOnScrollListener(r00);
                this.a.setOnFlingListener(null);
            }
            this.a = recyclerView0;
            if(recyclerView0 != null) {
                if(recyclerView0.getOnFlingListener() != null) {
                    throw new IllegalStateException("An instance of OnFlingListener already set.");
                }
                this.a.addOnScrollListener(r00);
                this.a.setOnFlingListener(this);
                new Scroller(this.a.getContext(), new DecelerateInterpolator());
                this.h();
            }
        }
    }

    public final int[] b(w0 w00, View view0) {
        int[] arr_v = new int[2];
        arr_v[0] = w00.canScrollHorizontally() ? f0.c(view0, this.f(w00)) : 0;
        if(w00.canScrollVertically()) {
            arr_v[1] = f0.c(view0, this.g(w00));
            return arr_v;
        }
        arr_v[1] = 0;
        return arr_v;
    }

    public static int c(View view0, d0 d00) {
        int v = d00.e(view0);
        int v1 = d00.c(view0);
        int v2 = d00.k();
        return v1 / 2 + v - (d00.l() / 2 + v2);
    }

    public static View d(w0 w00, d0 d00) {
        int v = w00.getChildCount();
        View view0 = null;
        if(v == 0) {
            return null;
        }
        int v1 = d00.k();
        int v2 = d00.l();
        int v3 = 0x7FFFFFFF;
        for(int v4 = 0; v4 < v; ++v4) {
            View view1 = w00.getChildAt(v4);
            int v5 = d00.e(view1);
            int v6 = Math.abs(d00.c(view1) / 2 + v5 - (v2 / 2 + v1));
            if(v6 < v3) {
                view0 = view1;
                v3 = v6;
            }
        }
        return view0;
    }

    public View e(w0 w00) {
        if(w00.canScrollVertically()) {
            return f0.d(w00, this.g(w00));
        }
        return w00.canScrollHorizontally() ? f0.d(w00, this.f(w00)) : null;
    }

    public final d0 f(w0 w00) {
        if(this.d == null || this.d.a != w00) {
            this.d = new b0(w00);  // 初始化器: Landroidx/recyclerview/widget/d0;-><init>(Landroidx/recyclerview/widget/w0;)V
        }
        return this.d;
    }

    public final d0 g(w0 w00) {
        if(this.c == null || this.c.a != w00) {
            this.c = new c0(w00);  // 初始化器: Landroidx/recyclerview/widget/d0;-><init>(Landroidx/recyclerview/widget/w0;)V
        }
        return this.c;
    }

    public final void h() {
        RecyclerView recyclerView0 = this.a;
        if(recyclerView0 != null) {
            w0 w00 = recyclerView0.getLayoutManager();
            if(w00 != null) {
                View view0 = this.e(w00);
                if(view0 != null) {
                    int[] arr_v = this.b(w00, view0);
                    int v = arr_v[0];
                    if(v != 0 || arr_v[1] != 0) {
                        this.a.smoothScrollBy(v, arr_v[1]);
                    }
                }
            }
        }
    }
}

