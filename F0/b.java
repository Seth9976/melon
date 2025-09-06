package f0;

import P0.w;
import androidx.compose.runtime.p;
import androidx.compose.runtime.q;
import e1.m;
import java.util.ArrayList;

public final class b {
    public final p a;
    public a b;
    public boolean c;
    public final w d;
    public boolean e;
    public int f;
    public int g;
    public final ArrayList h;
    public int i;
    public int j;
    public int k;
    public int l;

    public b(p p0, a a0) {
        this.a = p0;
        this.b = a0;
        this.d = new w();
        this.e = true;
        this.h = new ArrayList();
        this.i = -1;
        this.j = -1;
        this.k = -1;
    }

    public final void a() {
        this.c();
        ArrayList arrayList0 = this.h;
        if(!arrayList0.isEmpty()) {
            arrayList0.remove(arrayList0.size() - 1);
            return;
        }
        ++this.g;
    }

    public final void b() {
        int v = this.g;
        if(v > 0) {
            J j0 = this.b.g;
            j0.L(G.d);
            j0.i[j0.j - j0.g[j0.h - 1].b] = v;
            this.g = 0;
        }
        ArrayList arrayList0 = this.h;
        if(!arrayList0.isEmpty()) {
            a a0 = this.b;
            int v1 = arrayList0.size();
            Object[] arr_object = new Object[v1];
            for(int v2 = 0; v2 < v1; ++v2) {
                arr_object[v2] = arrayList0.get(v2);
            }
            a0.getClass();
            if(v1 != 0) {
                a0.g.L(k.d);
                m.C(a0.g, 0, arr_object);
            }
            arrayList0.clear();
        }
    }

    public final void c() {
        int v = this.l;
        if(v > 0) {
            int v1 = this.i;
            if(v1 >= 0) {
                this.b();
                J j0 = this.b.g;
                j0.L(y.d);
                int v2 = j0.j - j0.g[j0.h - 1].b;
                int[] arr_v = j0.i;
                arr_v[v2] = v1;
                arr_v[v2 + 1] = v;
                this.i = -1;
            }
            else {
                int v3 = this.k;
                int v4 = this.j;
                this.b();
                J j1 = this.b.g;
                j1.L(v.d);
                int v5 = j1.j - j1.g[j1.h - 1].b;
                int[] arr_v1 = j1.i;
                arr_v1[v5 + 1] = v3;
                arr_v1[v5] = v4;
                arr_v1[v5 + 2] = v;
                this.j = -1;
                this.k = -1;
            }
            this.l = 0;
        }
    }

    public final void d(boolean z) {
        int v = z ? this.a.F.i : this.a.F.g;
        int v1 = v - this.f;
        if(v1 < 0) {
            q.c("Tried to seek backward");
        }
        if(v1 > 0) {
            J j0 = this.b.g;
            j0.L(d.d);
            j0.i[j0.j - j0.g[j0.h - 1].b] = v1;
            this.f = v;
        }
    }

    public final void e(int v, int v1) {
        if(v1 > 0) {
            if(v < 0) {
                q.c(("Invalid remove index " + v));
            }
            if(this.i == v) {
                this.l += v1;
                return;
            }
            this.c();
            this.i = v;
            this.l = v1;
        }
    }
}

