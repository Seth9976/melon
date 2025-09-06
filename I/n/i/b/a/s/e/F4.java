package i.n.i.b.a.s.e;

import com.iloen.melon.custom.S0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;

public final class f4 implements u0, v0 {
    public final v0[] a;
    public final IdentityHashMap b;
    public final E4 c;
    public final ArrayList d;
    public u0 e;
    public wc f;
    public v0[] g;
    public S0 h;

    public f4(E4 e40, long[] arr_v, v0[] arr_v0) {
        this.c = e40;
        this.a = arr_v0;
        this.d = new ArrayList();
        e40.getClass();
        this.h = new S0(new b8[0], 27);
        this.b = new IdentityHashMap();
        this.g = new v0[0];
        for(int v = 0; v < arr_v0.length; ++v) {
            long v1 = arr_v[v];
            if(v1 != 0L) {
                this.a[v] = new d4(arr_v0[v], v1);
            }
        }
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final long a(long v, Xb xb0) {
        v0[] arr_v0 = this.g;
        return arr_v0.length <= 0 ? this.a[0].a(v, xb0) : arr_v0[0].a(v, xb0);
    }

    @Override  // i.n.i.b.a.s.e.b8
    public final boolean a() {
        return this.h.a();
    }

    @Override  // i.n.i.b.a.s.e.b8
    public final boolean a(long v) {
        ArrayList arrayList0 = this.d;
        if(!arrayList0.isEmpty()) {
            int v1 = arrayList0.size();
            for(int v2 = 0; v2 < v1; ++v2) {
                ((v0)arrayList0.get(v2)).a(v);
            }
            return false;
        }
        return this.h.a(v);
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final long b(long v) {
        long v1 = this.g[0].b(v);
        for(int v2 = 1; true; ++v2) {
            v0[] arr_v0 = this.g;
            if(v2 >= arr_v0.length) {
                break;
            }
            if(arr_v0[v2].b(v1) != v1) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
        }
        return v1;
    }

    @Override  // i.n.i.b.a.s.e.b8
    public final void b(long v) {
        this.h.b(v);
    }

    @Override  // i.n.i.b.a.s.e.a8
    public final void b(b8 b80) {
        v0 v00 = (v0)b80;
        u0 u00 = this.e;
        u00.getClass();
        u00.b(this);
    }

    @Override  // i.n.i.b.a.s.e.b8
    public final long c() {
        return this.h.c();
    }

    @Override  // i.n.i.b.a.s.e.u0
    public final void c(v0 v00) {
        this.d.remove(v00);
        if(!this.d.isEmpty()) {
            return;
        }
        v0[] arr_v0 = this.a;
        int v1 = 0;
        for(int v = 0; v < arr_v0.length; ++v) {
            v1 += arr_v0[v].h().a;
        }
        vc[] arr_vc = new vc[v1];
        for(int v2 = 0; v2 < arr_v0.length; ++v2) {
            wc wc0 = arr_v0[v2].h();
            int v4 = wc0.a;
            int v5 = 0;
            for(int v3 = 0; v5 < v4; ++v3) {
                arr_vc[v3] = wc0.b[v5];
                ++v5;
            }
        }
        this.f = new wc(arr_vc);
        u0 u00 = this.e;
        u00.getClass();
        u00.c(this);
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final long e() {
        return 0L;
    }

    @Override  // i.n.i.b.a.s.e.b8
    public final long f() {
        return this.h.f();
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final long g() {
        return 0x8000000000000001L;
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final wc h() {
        wc wc0 = this.f;
        wc0.getClass();
        return wc0;
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final void k() {
        v0[] arr_v0 = this.a;
        for(int v = 0; v < arr_v0.length; ++v) {
            arr_v0[v].k();
        }
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final long l() {
        return 0x8000000000000001L;
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final void l(u0 u00, long v) {
        this.e = u00;
        v0[] arr_v0 = this.a;
        Collections.addAll(this.d, arr_v0);
        for(int v1 = 0; v1 < arr_v0.length; ++v1) {
            arr_v0[v1].l(this, v);
        }
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final long m() {
        v0[] arr_v0 = this.g;
        long v = 0x8000000000000001L;
        for(int v1 = 0; v1 < arr_v0.length; ++v1) {
            v0 v00 = arr_v0[v1];
            long v2 = v00.m();
            if(Long.compare(v2, 0x8000000000000001L) != 0) {
                if(v == 0x8000000000000001L) {
                    v0[] arr_v01 = this.g;
                    for(int v3 = 0; v3 < arr_v01.length; ++v3) {
                        v0 v01 = arr_v01[v3];
                        if(v01 == v00) {
                            break;
                        }
                        if(v01.b(v2) != v2) {
                            throw new IllegalStateException("Unexpected child seekToUs result.");
                        }
                    }
                    v = v2;
                }
                else if(v2 != v) {
                    throw new IllegalStateException("Conflicting discontinuities.");
                }
            }
            else if(v != 0x8000000000000001L && v00.b(v) != v) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
        }
        return v;
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final boolean m(q2[] arr_q2, boolean[] arr_z, B7[] arr_b7) {
        return false;
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final long v(q2[] arr_q2, boolean[] arr_z, B7[] arr_b7, boolean[] arr_z1, long v) {
        v0[] arr_v0;
        IdentityHashMap identityHashMap0;
        int[] arr_v = new int[arr_q2.length];
        int[] arr_v1 = new int[arr_q2.length];
        for(int v1 = 0; true; ++v1) {
            identityHashMap0 = this.b;
            arr_v0 = this.a;
            if(v1 >= arr_q2.length) {
                break;
            }
            B7 b70 = arr_b7[v1];
            Integer integer0 = b70 == null ? null : ((Integer)identityHashMap0.get(b70));
            arr_v[v1] = integer0 == null ? -1 : ((int)integer0);
            arr_v1[v1] = -1;
            q2 q20 = arr_q2[v1];
            if(q20 != null) {
                vc vc0 = q20.a;
                for(int v2 = 0; v2 < arr_v0.length; ++v2) {
                    if(arr_v0[v2].h().a(vc0) != -1) {
                        arr_v1[v1] = v2;
                        break;
                    }
                }
            }
        }
        identityHashMap0.clear();
        B7[] arr_b71 = new B7[arr_q2.length];
        B7[] arr_b72 = new B7[arr_q2.length];
        q2[] arr_q21 = new q2[arr_q2.length];
        ArrayList arrayList0 = new ArrayList(arr_v0.length);
        long v3 = v;
        for(int v4 = 0; v4 < arr_v0.length; v4 = v6 + 1) {
            for(int v5 = 0; v5 < arr_q2.length; ++v5) {
                arr_b72[v5] = arr_v[v5] == v4 ? arr_b7[v5] : null;
                arr_q21[v5] = arr_v1[v5] == v4 ? arr_q2[v5] : null;
            }
            int v6 = v4;
            long v7 = arr_v0[v6].v(arr_q21, arr_z, arr_b72, arr_z1, v3);
            if(v6 == 0) {
                v3 = v7;
            }
            else if(v7 != v3) {
                throw new IllegalStateException("Children enabled at different positions.");
            }
            boolean z = false;
            for(int v8 = 0; true; ++v8) {
                boolean z1 = true;
                if(v8 >= arr_q2.length) {
                    break;
                }
                if(arr_v1[v8] == v6) {
                    B7 b71 = arr_b72[v8];
                    b71.getClass();
                    arr_b71[v8] = arr_b72[v8];
                    identityHashMap0.put(b71, v6);
                    z = true;
                }
                else if(arr_v[v8] == v6) {
                    if(arr_b72[v8] != null) {
                        z1 = false;
                    }
                    M7.J(z1);
                }
            }
            if(z) {
                arrayList0.add(arr_v0[v6]);
            }
        }
        System.arraycopy(arr_b71, 0, arr_b7, 0, arr_q2.length);
        v0[] arr_v01 = (v0[])arrayList0.toArray(new v0[0]);
        this.g = arr_v01;
        this.c.getClass();
        this.h = new S0(arr_v01, 27);
        return v3;
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final void w(long v, boolean z) {
        v0[] arr_v0 = this.g;
        for(int v1 = 0; v1 < arr_v0.length; ++v1) {
            arr_v0[v1].w(v, z);
        }
    }
}

