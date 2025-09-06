package C1;

import F1.e;
import java.util.HashMap;
import z1.a;

public final class k {
    public final e a;
    public int b;
    public int c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;
    public float l;
    public float m;
    public float n;
    public int o;
    public final HashMap p;

    public k(k k0) {
        this.a = null;
        this.b = 0;
        this.c = 0;
        this.d = NaNf;
        this.e = NaNf;
        this.f = NaNf;
        this.g = NaNf;
        this.h = NaNf;
        this.i = NaNf;
        this.j = NaNf;
        this.k = NaNf;
        this.l = NaNf;
        this.m = NaNf;
        this.n = NaNf;
        this.o = 0;
        this.p = new HashMap();
        this.a = k0.a;
        this.b = k0.b;
        this.c = k0.c;
        this.a(k0);
    }

    public k(e e0) {
        this.a = null;
        this.b = 0;
        this.c = 0;
        this.d = NaNf;
        this.e = NaNf;
        this.f = NaNf;
        this.g = NaNf;
        this.h = NaNf;
        this.i = NaNf;
        this.j = NaNf;
        this.k = NaNf;
        this.l = NaNf;
        this.m = NaNf;
        this.n = NaNf;
        this.o = 0;
        this.p = new HashMap();
        this.a = e0;
    }

    public final void a(k k0) {
        if(k0 != null) {
            this.d = k0.d;
            this.e = k0.e;
            this.f = k0.f;
            this.g = k0.g;
            this.h = k0.h;
            this.i = k0.i;
            this.j = k0.j;
            this.k = k0.k;
            this.l = k0.l;
            this.m = k0.m;
            this.n = k0.n;
            this.o = k0.o;
            HashMap hashMap0 = this.p;
            hashMap0.clear();
            for(Object object0: k0.p.values()) {
                String s = ((a)object0).a;
                a a0 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
                a0.a = s;
                a0.b = ((a)object0).b;
                a0.c = ((a)object0).c;
                a0.d = ((a)object0).d;
                hashMap0.put(s, a0);
            }
        }
    }
}

