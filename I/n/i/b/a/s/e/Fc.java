package i.n.i.b.a.s.e;

import android.net.Uri;
import android.util.Log;
import d5.c;
import java.io.IOException;
import java.util.Map;

public final class fc implements Lb, db {
    public final int a;
    public final jc b;

    public fc(jc jc0, int v) {
        this.a = v;
        this.b = jc0;
        super();
    }

    public void a() {
        synchronized(Ja.f) {
        }
        this.b.k0 = Ja.g ? Ja.h : 0x8000000000000001L;
        this.b.w(true);
    }

    @Override  // i.n.i.b.a.s.e.Lb
    public void b() {
        this.b.W.b();
        Oa oa0 = this.b.Y;
        if(oa0 != null) {
            throw oa0;
        }
    }

    @Override  // i.n.i.b.a.s.e.db
    public Jd f(gb gb0, long v, long v1, IOException iOException0, int v2) {
        if(this.a != 2) {
            Sd sd0 = new Sd(((ld)gb0).b, ((ld)gb0).d.c, ((ld)gb0).d.d, v, v1, ((ld)gb0).d.b);
            this.b.o.i(sd0, ((ld)gb0).c, iOException0, true);
            this.b.m.getClass();
            M7.H("DashMediaSource", "Failed to resolve time offset.", iOException0);
            this.b.w(true);
            return sa.g;
        }
        Uri uri0 = ((ld)gb0).d.c;
        Map map0 = ((ld)gb0).d.d;
        long v3 = ((ld)gb0).d.b;
        ye ye0 = ((ld)gb0).d;
        Sd sd1 = new Sd(((ld)gb0).b, uri0, map0, v, v1, v3);
        Ca ca0 = new Ca(v2, iOException0);
        long v4 = this.b.m.c(ca0);
        Jd jd0 = v4 == 0x8000000000000001L ? sa.h : new Jd(0, v4);
        boolean z = jd0.b();
        this.b.o.i(sd1, ((ld)gb0).c, iOException0, !z);
        this.b.f0 = null;
        if(this.b.N != null) {
            M7.f(((ld)gb0).b.b, ye0.c, ye0.d, ((ld)gb0).h);
        }
        return jd0;
    }

    @Override  // i.n.i.b.a.s.e.db
    public void o(gb gb0, long v, long v1) {
        if(this.a != 2) {
            Sd sd0 = new Sd(((ld)gb0).b, ((ld)gb0).d.c, ((ld)gb0).d.d, v, v1, ((ld)gb0).d.b);
            this.b.m.getClass();
            this.b.o.n(sd0, ((ld)gb0).c);
            this.b.k0 = ((long)(((Long)((ld)gb0).f))) - v;
            this.b.w(true);
            return;
        }
        ld ld0 = (ld)gb0;
        jc jc0 = this.b;
        jc0.f0 = null;
        Sd sd1 = new Sd(ld0.b, ld0.d.c, ld0.d.d, v, v1, ld0.d.b);
        jc0.m.getClass();
        jc0.o.n(sd1, ld0.c);
        p1 p10 = (p1)ld0.f;
        if(jc0.N != null) {
            M7.f(ld0.g.b, ld0.d.c, ld0.d.d, ld0.h);
        }
        int v2 = jc0.g0 == null ? 0 : jc0.g0.m.size();
        long v3 = p10.a(0).b;
        int v4;
        for(v4 = 0; v4 < v2 && jc0.g0.a(v4).b < v3; ++v4) {
        }
        if(p10.d) {
            boolean z = false;
            if(v2 - v4 > p10.m.size()) {
                z = true;
                Log.w("DashMediaSource", "Loaded out of sync manifest");
            }
            else if(jc0.m0 != 0x8000000000000001L && p10.h * 1000L <= jc0.m0) {
                z = true;
                Log.w("DashMediaSource", "Loaded stale dynamic manifest: " + p10.h + ", " + jc0.m0);
            }
            if(z) {
                int v5 = jc0.l0;
                jc0.l0 = v5 + 1;
                if(v5 < jc0.m.a(ld0.c)) {
                    jc0.Z.postDelayed(jc0.E, ((long)Math.min((jc0.l0 - 1) * 1000, 5000)));
                    return;
                }
                jc0.Y = new Oa();  // 初始化器: Ljava/io/IOException;-><init>()V
                return;
            }
            jc0.l0 = 0;
        }
        jc0.g0 = p10;
        jc0.h0 &= p10.d;
        jc0.i0 = v - v1;
        jc0.j0 = v;
        Object object0 = jc0.B;
        __monitor_enter(object0);
        if(ld0.b.b == jc0.c0) {
            jc0.c0 = jc0.g0.k == null ? ld0.d.c : jc0.g0.k;
        }
        __monitor_exit(object0);
        if(v2 == 0) {
            p1 p11 = jc0.g0;
            if(p11.d) {
                c c0 = p11.i;
                if(c0 != null) {
                    String s = (String)c0.b;
                    if(!L7.p(s, "urn:mpeg:dash:utc:direct:2014") && !L7.p(s, "urn:mpeg:dash:utc:direct:2012")) {
                        if(!L7.p(s, "urn:mpeg:dash:utc:http-iso:2014") && !L7.p(s, "urn:mpeg:dash:utc:http-iso:2012")) {
                            if(!L7.p(s, "urn:mpeg:dash:utc:http-xsdate:2014") && !L7.p(s, "urn:mpeg:dash:utc:http-xsdate:2012")) {
                                if(!L7.p(s, "urn:mpeg:dash:utc:ntp:2014") && !L7.p(s, "urn:mpeg:dash:utc:ntp:2012")) {
                                    M7.H("DashMediaSource", "Failed to resolve time offset.", new IOException("Unsupported UTC timing scheme"));
                                    jc0.w(true);
                                    return;
                                }
                                jc0.y();
                                return;
                            }
                            jc0.t(c0, new E4(18));
                            return;
                        }
                        jc0.t(c0, new ic());  // 初始化器: Ljava/lang/Object;-><init>()V
                        return;
                    }
                    try {
                        jc0.k0 = L7.I(((String)c0.c)) - jc0.j0;
                        jc0.w(true);
                    }
                    catch(H4 h40) {
                        M7.H("DashMediaSource", "Failed to resolve time offset.", h40);
                        jc0.w(true);
                    }
                    return;
                }
                jc0.y();
                return;
            }
            jc0.w(true);
            return;
        }
        jc0.n0 += v4;
        jc0.w(true);
    }

    @Override  // i.n.i.b.a.s.e.db
    public void r(gb gb0, long v, long v1, boolean z) {
        if(this.a != 2) {
            this.b.x(((ld)gb0), v, v1);
            return;
        }
        this.b.x(((ld)gb0), v, v1);
        if(this.b.N != null) {
            M7.f(((ld)gb0).g.b, ((ld)gb0).d.c, ((ld)gb0).d.d, ((ld)gb0).h);
        }
    }
}

