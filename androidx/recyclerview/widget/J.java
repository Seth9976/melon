package androidx.recyclerview.widget;

import I.H1;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import androidx.appcompat.app.o;
import java.util.ArrayList;

public final class j {
    public final h0 a;
    public final H1 b;
    public final ArrayList c;
    public int d;
    public View e;

    public j(h0 h00) {
        this.d = 0;
        this.a = h00;
        this.b = new H1();
        this.c = new ArrayList();
    }

    public final void a(View view0, int v, boolean z) {
        RecyclerView recyclerView0 = this.a.a;
        int v1 = v >= 0 ? this.f(v) : recyclerView0.getChildCount();
        this.b.A(v1, z);
        if(z) {
            this.i(view0);
        }
        recyclerView0.addView(view0, v1);
        O0 o00 = RecyclerView.H(view0);
        j0 j00 = recyclerView0.m;
        if(j00 != null && o00 != null) {
            j00.onViewAttachedToWindow(o00);
        }
        ArrayList arrayList0 = recyclerView0.b0;
        if(arrayList0 != null) {
            for(int v2 = arrayList0.size() - 1; v2 >= 0; --v2) {
                ((x0)recyclerView0.b0.get(v2)).b(view0);
            }
        }
    }

    public final void b(View view0, int v, ViewGroup.LayoutParams viewGroup$LayoutParams0, boolean z) {
        RecyclerView recyclerView0 = this.a.a;
        int v1 = v >= 0 ? this.f(v) : recyclerView0.getChildCount();
        this.b.A(v1, z);
        if(z) {
            this.i(view0);
        }
        O0 o00 = RecyclerView.H(view0);
        boolean z1 = false;
        if(o00 != null) {
            z1 = true;
            if(!o00.isTmpDetached() && !o00.shouldIgnore()) {
                StringBuilder stringBuilder0 = new StringBuilder("Called attach on a child which is not detached: ");
                stringBuilder0.append(o00);
                throw new IllegalArgumentException(o.l(recyclerView0, stringBuilder0));
            }
            if(RecyclerView.Z0) {
                Log.d("RecyclerView", "reAttach " + o00);
            }
            o00.clearTmpDetachFlag();
        }
        else if(!RecyclerView.Y0) {
            z1 = true;
        }
        if(z1) {
            recyclerView0.attachViewToParent(view0, v1, viewGroup$LayoutParams0);
            return;
        }
        StringBuilder stringBuilder1 = new StringBuilder("No ViewHolder found for child: ");
        stringBuilder1.append(view0);
        stringBuilder1.append(", index: ");
        stringBuilder1.append(v1);
        throw new IllegalArgumentException(o.l(recyclerView0, stringBuilder1));
    }

    public final void c(int v) {
        int v1 = this.f(v);
        this.b.D(v1);
        RecyclerView recyclerView0 = this.a.a;
        View view0 = recyclerView0.getChildAt(v1);
        boolean z = false;
        if(view0 != null) {
            z = true;
            O0 o00 = RecyclerView.H(view0);
            if(o00 == null) {
                recyclerView0.detachViewFromParent(v1);
                return;
            }
            if(o00.isTmpDetached() && !o00.shouldIgnore()) {
                StringBuilder stringBuilder0 = new StringBuilder("called detach on an already detached child ");
                stringBuilder0.append(o00);
                throw new IllegalArgumentException(o.l(recyclerView0, stringBuilder0));
            }
            if(RecyclerView.Z0) {
                Log.d("RecyclerView", "tmpDetach " + o00);
            }
            o00.addFlags(0x100);
        }
        else if(!RecyclerView.Y0) {
            z = true;
        }
        if(z) {
            recyclerView0.detachViewFromParent(v1);
            return;
        }
        StringBuilder stringBuilder1 = new StringBuilder("No view at offset ");
        stringBuilder1.append(v1);
        throw new IllegalArgumentException(o.l(recyclerView0, stringBuilder1));
    }

    public final View d(int v) {
        int v1 = this.f(v);
        return this.a.a.getChildAt(v1);
    }

    public final int e() {
        return this.a.a.getChildCount() - this.c.size();
    }

    public final int f(int v) {
        if(v < 0) {
            return -1;
        }
        int v1 = this.a.a.getChildCount();
        for(int v2 = v; v2 < v1; v2 += v3) {
            H1 h10 = this.b;
            int v3 = v - (v2 - h10.x(v2));
            if(v3 == 0) {
                while(h10.z(v2)) {
                    ++v2;
                }
                return v2;
            }
        }
        return -1;
    }

    public final View g(int v) {
        return this.a.a.getChildAt(v);
    }

    public final int h() {
        return this.a.a.getChildCount();
    }

    public final void i(View view0) {
        this.c.add(view0);
        O0 o00 = RecyclerView.H(view0);
        if(o00 != null) {
            o00.onEnteredHiddenState(this.a.a);
        }
    }

    public final int j(View view0) {
        int v = this.a.a.indexOfChild(view0);
        if(v == -1) {
            return -1;
        }
        return this.b.z(v) ? -1 : v - this.b.x(v);
    }

    public final void k(int v) {
        h0 h00 = this.a;
        switch(this.d) {
            case 1: {
                throw new IllegalStateException("Cannot call removeView(At) within removeView(At)");
            }
            case 2: {
                throw new IllegalStateException("Cannot call removeView(At) within removeViewIfHidden");
            }
            default: {
                try {
                    int v2 = this.f(v);
                    View view0 = h00.a.getChildAt(v2);
                    if(view0 != null) {
                        this.d = 1;
                        this.e = view0;
                        if(this.b.D(v2)) {
                            this.l(view0);
                        }
                        h00.k(v2);
                    }
                }
                finally {
                    this.d = 0;
                    this.e = null;
                }
            }
        }
    }

    public final void l(View view0) {
        if(this.c.remove(view0)) {
            O0 o00 = RecyclerView.H(view0);
            if(o00 != null) {
                o00.onLeftHiddenState(this.a.a);
            }
        }
    }

    // 去混淆评级： 低(40)
    @Override
    public final String toString() {
        return "0, hidden list:" + this.c.size();
    }
}

