package x1;

import C1.b;
import C1.h;
import D1.a;
import D1.e;
import D1.f;
import D1.g;
import D1.i;
import U4.x;
import j3.n;
import java.util.ArrayList;
import java.util.HashMap;
import r1.c;

public final class s {
    public n a;
    public boolean b;
    public final HashMap c;
    public final HashMap d;
    public final HashMap e;
    public final b f;
    public int g;
    public final ArrayList h;
    public final ArrayList i;
    public boolean j;
    public final c k;
    public long l;

    public s(c c0) {
        this.b = true;
        HashMap hashMap0 = new HashMap();
        this.c = hashMap0;
        this.d = new HashMap();
        this.e = new HashMap();
        b b0 = new b(this);
        this.f = b0;
        this.g = 0;
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.j = true;
        b0.a = 0;
        hashMap0.put(0, b0);
        this.k = c0;
        this.l = r1.b.b(0, 0, 15);
        this.a = new n(this, 14);
    }

    public final void a(Object object0) {
        this.h.add(object0);
        this.j = true;
    }

    public final b b(Object object0) {
        HashMap hashMap0 = this.c;
        h h0 = (h)hashMap0.get(object0);
        if(h0 == null) {
            h0 = new b(this);
            hashMap0.put(object0, h0);
            h0.a = object0;
        }
        return h0 instanceof b ? ((b)h0) : null;
    }

    public final int c(Float float0) {
        return Math.round(((float)float0));
    }

    public final g d(int v, String s) {
        b b0 = this.b(s);
        if(b0.c == null || !(b0.c instanceof g)) {
            g g0 = new g(this);
            g0.b = v;
            g0.g = s;
            b0.c = g0;
            b0.b(g0.a());
        }
        return (g)b0.c;
    }

    public final C1.g e(int v) {
        StringBuilder stringBuilder0 = new StringBuilder("__HELPER_KEY_");
        int v1 = this.g;
        this.g = v1 + 1;
        String s = x.g(v1, "__", stringBuilder0);
        HashMap hashMap0 = this.d;
        C1.g g0 = (C1.g)hashMap0.get(s);
        if(g0 == null) {
            switch(e0.b.b(v)) {
                case 0: {
                    g0 = new D1.h(this, 1);  // 初始化器: LD1/c;-><init>(Lx1/s;I)V
                    break;
                }
                case 1: {
                    g0 = new i(this, 2);  // 初始化器: LD1/c;-><init>(Lx1/s;I)V
                    break;
                }
                case 2: {
                    g0 = new a(this, 4, 0);
                    g0.o0 = 0.5f;
                    break;
                }
                case 3: {
                    g0 = new a(this, 4, 1);
                    g0.o0 = 0.5f;
                    break;
                }
                case 4: {
                    g0 = new D1.b(this, 5);  // 初始化器: LC1/g;-><init>(Lx1/s;I)V
                    break;
                }
                case 6: 
                case 7: {
                    g0 = new e(this, v);
                    break;
                }
                case 8: 
                case 9: 
                case 10: {
                    g0 = new f(this, v);
                    break;
                }
                default: {
                    g0 = new C1.g(this, v);
                }
            }
            g0.a = s;
            hashMap0.put(s, g0);
        }
        return g0;
    }
}

