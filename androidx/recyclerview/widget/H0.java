package androidx.recyclerview.widget;

import android.util.Log;
import android.view.View;
import c2.i;
import java.util.ArrayList;

public final class h0 implements i {
    public final RecyclerView a;

    public h0(RecyclerView recyclerView0) {
        this.a = recyclerView0;
        super();
    }

    @Override  // c2.i
    public boolean a(float f) {
        int v1;
        int v;
        RecyclerView recyclerView0 = this.a;
        if(recyclerView0.n.canScrollVertically()) {
            v = (int)f;
            v1 = 0;
        }
        else {
            v1 = recyclerView0.n.canScrollHorizontally() ? ((int)f) : 0;
            v = 0;
        }
        if(v1 == 0 && v == 0) {
            return false;
        }
        recyclerView0.stopScroll();
        return recyclerView0.E(v1, v, 0, 0x7FFFFFFF);
    }

    @Override  // c2.i
    public float b() {
        RecyclerView recyclerView0 = this.a;
        if(recyclerView0.n.canScrollVertically()) {
            return -recyclerView0.y0;
        }
        return recyclerView0.n.canScrollHorizontally() ? -recyclerView0.x0 : 0.0f;
    }

    @Override  // c2.i
    public void c() {
        this.a.stopScroll();
    }

    public void d(a a0) {
        RecyclerView recyclerView0 = this.a;
        switch(a0.a) {
            case 1: {
                recyclerView0.n.onItemsAdded(recyclerView0, a0.b, a0.d);
                return;
            }
            case 2: {
                recyclerView0.n.onItemsRemoved(recyclerView0, a0.b, a0.d);
                return;
            }
            case 4: {
                recyclerView0.n.onItemsUpdated(recyclerView0, a0.b, a0.d, a0.c);
                return;
            }
            case 8: {
                recyclerView0.n.onItemsMoved(recyclerView0, a0.b, a0.d, 1);
            }
        }
    }

    public O0 e(int v) {
        RecyclerView recyclerView0 = this.a;
        O0 o00 = recyclerView0.D(v, true);
        if(o00 != null) {
            if(!recyclerView0.f.c.contains(o00.itemView)) {
                return o00;
            }
            if(RecyclerView.Z0) {
                Log.d("RecyclerView", "assuming view holder cannot be find because it is hidden");
                return null;
            }
        }
        return null;
    }

    public void f(int v, int v1, Object object0) {
        RecyclerView recyclerView0 = this.a;
        int v2 = recyclerView0.f.h();
        int v3 = v1 + v;
        for(int v4 = 0; v4 < v2; ++v4) {
            View view0 = recyclerView0.f.g(v4);
            O0 o00 = RecyclerView.H(view0);
            if(o00 != null && !o00.shouldIgnore() && (o00.mPosition >= v && o00.mPosition < v3)) {
                o00.addFlags(2);
                o00.addChangePayload(object0);
                ((LayoutParams)view0.getLayoutParams()).c = true;
            }
        }
        D0 d00 = recyclerView0.c;
        ArrayList arrayList0 = d00.c;
        for(int v5 = arrayList0.size() - 1; v5 >= 0; --v5) {
            O0 o01 = (O0)arrayList0.get(v5);
            if(o01 != null && (o01.mPosition >= v && o01.mPosition < v3)) {
                o01.addFlags(2);
                d00.g(v5);
            }
        }
        recyclerView0.H0 = true;
    }

    public void g(int v, int v1) {
        RecyclerView recyclerView0 = this.a;
        int v2 = recyclerView0.f.h();
        for(int v3 = 0; v3 < v2; ++v3) {
            O0 o00 = RecyclerView.H(recyclerView0.f.g(v3));
            if(o00 != null && !o00.shouldIgnore() && o00.mPosition >= v) {
                if(RecyclerView.Z0) {
                    Log.d("RecyclerView", "offsetPositionRecordsForInsert attached child " + v3 + " holder " + o00 + " now at position " + (o00.mPosition + v1));
                }
                o00.offsetPosition(v1, false);
                recyclerView0.D0.f = true;
            }
        }
        ArrayList arrayList0 = recyclerView0.c.c;
        int v4 = arrayList0.size();
        for(int v5 = 0; v5 < v4; ++v5) {
            O0 o01 = (O0)arrayList0.get(v5);
            if(o01 != null && o01.mPosition >= v) {
                if(RecyclerView.Z0) {
                    Log.d("RecyclerView", "offsetPositionRecordsForInsert cached " + v5 + " holder " + o01 + " now at position " + (o01.mPosition + v1));
                }
                o01.offsetPosition(v1, false);
            }
        }
        recyclerView0.requestLayout();
        recyclerView0.G0 = true;
    }

    public void h(int v, int v1) {
        int v9;
        int v8;
        int v7;
        int v5;
        int v4;
        int v3;
        RecyclerView recyclerView0 = this.a;
        int v2 = recyclerView0.f.h();
        if(v < v1) {
            v3 = v;
            v4 = v1;
            v5 = -1;
        }
        else {
            v4 = v;
            v3 = v1;
            v5 = 1;
        }
        for(int v6 = 0; v6 < v2; ++v6) {
            O0 o00 = RecyclerView.H(recyclerView0.f.g(v6));
            if(o00 != null && (o00.mPosition >= v3 && o00.mPosition <= v4)) {
                if(RecyclerView.Z0) {
                    Log.d("RecyclerView", "offsetPositionRecordsForMove attached child " + v6 + " holder " + o00);
                }
                if(o00.mPosition == v) {
                    o00.offsetPosition(v1 - v, false);
                }
                else {
                    o00.offsetPosition(v5, false);
                }
                recyclerView0.D0.f = true;
            }
        }
        ArrayList arrayList0 = recyclerView0.c.c;
        if(v < v1) {
            v7 = v;
            v8 = v1;
            v9 = -1;
        }
        else {
            v8 = v;
            v7 = v1;
            v9 = 1;
        }
        int v10 = arrayList0.size();
        for(int v11 = 0; v11 < v10; ++v11) {
            O0 o01 = (O0)arrayList0.get(v11);
            if(o01 != null) {
                int v12 = o01.mPosition;
                if(v12 >= v7 && v12 <= v8) {
                    if(v12 == v) {
                        o01.offsetPosition(v1 - v, false);
                    }
                    else {
                        o01.offsetPosition(v9, false);
                    }
                    if(RecyclerView.Z0) {
                        Log.d("RecyclerView", "offsetPositionRecordsForMove cached child " + v11 + " holder " + o01);
                    }
                }
            }
        }
        recyclerView0.requestLayout();
        recyclerView0.G0 = true;
    }

    public void i(O0 o00, p0 p00, p0 p01) {
        boolean z;
        RecyclerView recyclerView0 = this.a;
        recyclerView0.getClass();
        o00.setIsRecyclable(false);
        q q0 = (q)recyclerView0.l0;
        if(p00 == null) {
        label_11:
            q0.l(o00);
            o00.itemView.setAlpha(0.0f);
            q0.i.add(o00);
            z = true;
        }
        else {
            q0.getClass();
            int v = p00.a;
            int v1 = p01.a;
            if(v != v1 || p00.b != p01.b) {
                z = q0.g(o00, v, p00.b, v1, p01.b);
                goto label_15;
            }
            goto label_11;
        }
    label_15:
        if(z) {
            recyclerView0.R();
        }
    }

    public void j(O0 o00, p0 p00, p0 p01) {
        boolean z;
        RecyclerView recyclerView0 = this.a;
        recyclerView0.c.l(o00);
        recyclerView0.h(o00);
        o00.setIsRecyclable(false);
        q q0 = (q)recyclerView0.l0;
        q0.getClass();
        int v = p00.a;
        int v1 = p00.b;
        View view0 = o00.itemView;
        int v2 = p01 == null ? view0.getLeft() : p01.a;
        int v3 = p01 == null ? view0.getTop() : p01.b;
        if(o00.isRemoved() || v == v2 && v1 == v3) {
            q0.l(o00);
            q0.h.add(o00);
            z = true;
        }
        else {
            view0.layout(v2, v3, view0.getWidth() + v2, view0.getHeight() + v3);
            z = q0.g(o00, v, v1, v2, v3);
        }
        if(z) {
            recyclerView0.R();
        }
    }

    public void k(int v) {
        RecyclerView recyclerView0 = this.a;
        View view0 = recyclerView0.getChildAt(v);
        if(view0 != null) {
            recyclerView0.p(view0);
            view0.clearAnimation();
        }
        recyclerView0.removeViewAt(v);
    }
}

