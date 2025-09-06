package androidx.media3.common;

import I6.V;
import X5.g;
import b3.G;
import b3.K;
import b3.L;
import b3.N;
import b3.b0;
import b3.f0;
import b3.h0;
import b3.k;
import b3.p0;
import b3.u0;
import b3.w0;
import b3.z0;
import d3.c;
import e3.b;
import e3.q;
import java.util.HashSet;
import java.util.List;

public final class d {
    public int A;
    public Long B;
    public h0 C;
    public h0 D;
    public g E;
    public h0 F;
    public g G;
    public int H;
    public N a;
    public boolean b;
    public int c;
    public int d;
    public K e;
    public int f;
    public long g;
    public long h;
    public long i;
    public L j;
    public u0 k;
    public b3.d l;
    public float m;
    public z0 n;
    public c o;
    public k p;
    public int q;
    public q r;
    public Metadata s;
    public V t;
    public p0 u;
    public w0 v;
    public G w;
    public G x;
    public int y;
    public int z;

    public final void a() {
        this.z = -1;
        this.A = -1;
    }

    public final void b(List list0) {
        HashSet hashSet0 = new HashSet();
        for(int v = 0; v < list0.size(); ++v) {
            b.d(hashSet0.add(((b0)list0.get(v)).a), "Duplicate MediaItemData UID in playlist");
        }
        this.t = V.p(list0);
        this.u = new f0(this.t);
        this.v = null;
        this.w = null;
    }

    public final void c(float f) {
        b.c(f >= 0.0f && f <= 1.0f);
        this.m = f;
    }
}

