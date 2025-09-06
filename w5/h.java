package W5;

import A1.g;
import Ac.X3;
import P5.G;
import P5.H;
import P5.l;
import P5.m;
import P5.o;
import P5.p;
import P5.r;
import P5.s;
import P5.t;
import P5.v;
import Q5.i;
import Q5.j;
import Q5.n;
import Q5.q;
import R5.f;
import X5.b;
import X5.d;
import Z5.a;
import android.content.Context;
import android.util.Log;
import androidx.media3.session.legacy.V;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.concurrent.Executor;

public final class h {
    public final Context a;
    public final f b;
    public final d c;
    public final c d;
    public final Executor e;
    public final Y5.c f;
    public final a g;
    public final a h;
    public final X5.c i;

    public h(Context context0, f f0, d d0, c c0, Executor executor0, Y5.c c1, a a0, a a1, X5.c c2) {
        this.a = context0;
        this.b = f0;
        this.c = d0;
        this.d = c0;
        this.e = executor0;
        this.f = c1;
        this.g = a0;
        this.h = a1;
        this.i = c2;
    }

    public final void a(j j0, int v) {
        R5.a a3;
        String s13;
        g g0;
        String s9;
        Integer integer1;
        long v2;
        R5.a a0;
        X5.j j1;
        byte[] arr_b = j0.b;
        R5.h h0 = this.b.a(j0.a);
        long v1 = 0L;
        while(true) {
            W5.f f0 = new W5.f(this, j0, 0);
            j1 = (X5.j)this.f;
            if(!((Boolean)j1.n(f0)).booleanValue()) {
                break;
            }
            Iterable iterable0 = (Iterable)j1.n(new W5.f(this, j0, 1));
            if(!iterable0.iterator().hasNext()) {
                return;
            }
            if(h0 == null) {
                Q1.c.s("Uploader", "Unknown backend for %s, deleting event batch for it...", j0);
                a0 = new R5.a(3, -1L);
                v2 = v1;
            }
            else {
                ArrayList arrayList0 = new ArrayList();
                for(Object object0: iterable0) {
                    arrayList0.add(((b)object0).c);
                }
                if(arr_b != null) {
                    Objects.requireNonNull(this.i);
                    T5.a a1 = (T5.a)j1.n(new X3(this.i, 13));
                    Q5.h h1 = new Q5.h();  // 初始化器: Ljava/lang/Object;-><init>()V
                    h1.h = new HashMap();
                    h1.f = this.g.f();
                    h1.g = this.h.f();
                    h1.a = "GDT_CLIENT_METRICS";
                    N5.c c0 = new N5.c("proto");
                    a1.getClass();
                    q.a.getClass();
                    ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
                    try {
                        q.a.f(a1, byteArrayOutputStream0);
                    }
                    catch(IOException unused_ex) {
                    }
                    h1.e = new n(c0, byteArrayOutputStream0.toByteArray());
                    arrayList0.add(((O5.c)h0).a(h1.b()));
                }
                O5.c c1 = (O5.c)h0;
                HashMap hashMap0 = new HashMap();
                for(Object object1: arrayList0) {
                    i i0 = (i)object1;
                    String s = i0.a;
                    if(hashMap0.containsKey(s)) {
                        ((List)hashMap0.get(s)).add(i0);
                    }
                    else {
                        ArrayList arrayList1 = new ArrayList();
                        arrayList1.add(i0);
                        hashMap0.put(s, arrayList1);
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                for(Object object2: hashMap0.entrySet()) {
                    Map.Entry map$Entry0 = (Map.Entry)object2;
                    i i1 = (i)((List)map$Entry0.getValue()).get(0);
                    long v3 = c1.f.f();
                    long v4 = c1.e.f();
                    Integer integer0 = i1.b("sdk-version");
                    String s1 = i1.a("model");
                    String s2 = i1.a("hardware");
                    String s3 = i1.a("device");
                    String s4 = i1.a("product");
                    String s5 = i1.a("os-uild");
                    String s6 = i1.a("manufacturer");
                    String s7 = i1.a("fingerprint");
                    String s8 = i1.a("country");
                    P5.n n0 = new P5.n(new l(integer0, s1, s2, s3, s4, s5, s6, s7, i1.a("locale"), s8, i1.a("mcc_mnc"), i1.a("application_build")));
                    try {
                        integer1 = Integer.parseInt(((String)map$Entry0.getKey()));
                        s9 = null;
                    }
                    catch(NumberFormatException unused_ex) {
                        s9 = (String)map$Entry0.getKey();
                        integer1 = null;
                    }
                    ArrayList arrayList3 = new ArrayList();
                    for(Object object3: ((List)map$Entry0.getValue())) {
                        i i2 = (i)object3;
                        N5.c c2 = i2.c.a;
                        byte[] arr_b1 = i2.c.b;
                        if(c2.equals(new N5.c("proto"))) {
                            g0 = new g();  // 初始化器: Ljava/lang/Object;-><init>()V
                            g0.e = arr_b1;
                        }
                        else if(c2.equals(new N5.c("json"))) {
                            String s10 = new String(arr_b1, Charset.forName("UTF-8"));
                            g g1 = new g();  // 初始化器: Ljava/lang/Object;-><init>()V
                            g1.f = s10;
                            g0 = g1;
                        }
                        else {
                            goto label_117;
                        }
                        byte[] arr_b2 = i2.j;
                        g0.a = i2.d;
                        g0.d = i2.e;
                        String s11 = (String)i2.f.get("tz-offset");
                        g0.g = (long)(s11 == null ? 0L : ((long)Long.valueOf(s11)));
                        int v5 = i2.b("net-type");
                        H h2 = (H)H.a.get(v5);
                        int v6 = i2.b("mobile-subtype");
                        g0.h = new v(h2, ((G)G.a.get(v6)));
                        Integer integer2 = i2.b;
                        if(integer2 != null) {
                            g0.b = integer2;
                        }
                        Integer integer3 = i2.g;
                        if(integer3 != null) {
                            g0.c = new o(new r(new P5.q(integer3)));
                        }
                        byte[] arr_b3 = i2.i;
                        if(arr_b3 != null || arr_b2 != null) {
                            if(arr_b3 == null) {
                                arr_b3 = null;
                            }
                            g0.i = new p(arr_b3, (arr_b2 == null ? null : arr_b2));
                        }
                        String s12 = ((Long)g0.a) == null ? " eventTimeMs" : "";
                        if(((Long)g0.d) == null) {
                            s12 = s12 + " eventUptimeMs";
                        }
                        if(((Long)g0.g) == null) {
                            s12 = s12 + " timezoneOffsetSeconds";
                        }
                        if(s12.isEmpty()) {
                            arrayList3.add(new s(((long)(((Long)g0.a))), ((Integer)g0.b), ((o)g0.c), ((long)(((Long)g0.d))), ((byte[])g0.e), ((String)g0.f), ((long)(((Long)g0.g))), ((v)g0.h), ((p)g0.i)));
                        }
                        else {
                            throw new IllegalStateException("Missing required properties:" + s12);
                        label_117:
                            if(Log.isLoggable("TRuntime.CctTransportBackend", 5)) {
                                Log.w("TRuntime.CctTransportBackend", "Received event of unsupported encoding " + c2 + ". Skipping...");
                            }
                        }
                    }
                    arrayList2.add(new t(v3, v4, n0, integer1, s9, arrayList3));
                }
                v2 = v1;
                m m0 = new m(arrayList2);
                URL uRL0 = c1.d;
                if(arr_b == null) {
                    s13 = null;
                }
                else {
                    try {
                        O5.a a2 = O5.a.a(arr_b);
                        s13 = a2.b == null ? null : a2.b;
                        String s14 = a2.a;
                        if(s14 != null) {
                            uRL0 = O5.c.b(s14);
                        }
                    }
                    catch(IllegalArgumentException unused_ex) {
                        a0 = new R5.a(3, -1L);
                        goto label_164;
                    }
                }
                try {
                    V v7 = new V(uRL0, m0, s13);
                    X3 x30 = new X3(c1, 9);
                    for(int v8 = 5; true; --v8) {
                        O5.b b0 = x30.d(v7);
                        URL uRL1 = (URL)b0.c;
                        if(uRL1 == null) {
                            v7 = null;
                        }
                        else {
                            Q1.c.s("CctTransportBackend", "Following redirect to: %s", uRL1);
                            v7 = new V(uRL1, ((m)v7.b), ((String)v7.c));
                        }
                        if(v7 == null || v8 - 1 < 1) {
                            int v9 = b0.a;
                            if(v9 == 200) {
                                a0 = new R5.a(1, b0.b);
                            }
                            else {
                                if(v9 >= 500 || v9 == 404) {
                                    a3 = new R5.a(2, -1L);
                                }
                                else if(v9 == 400) {
                                    a3 = new R5.a(4, -1L);
                                }
                                else {
                                    a3 = new R5.a(3, -1L);
                                }
                                a0 = a3;
                            }
                            break;
                        }
                    }
                }
                catch(IOException iOException0) {
                    Q1.c.u(iOException0, "CctTransportBackend", "Could not make request to the backend");
                    a0 = new R5.a(2, -1L);
                }
            }
        label_164:
            int v10 = a0.a;
            if(v10 == 2) {
                j1.n(new W5.g(this, iterable0, j0, v2));
                this.d.a(j0, v + 1, true);
                return;
            }
            v1 = v2;
            j1.n(new B9.g(14, this, iterable0));
            if(v10 == 1) {
                v1 = Math.max(v1, a0.b);
                if(arr_b == null) {
                    continue;
                }
                j1.n(new X3(this, 15));
            }
            else if(v10 == 4) {
                HashMap hashMap1 = new HashMap();
                for(Object object4: iterable0) {
                    String s15 = ((b)object4).c.a;
                    if(hashMap1.containsKey(s15)) {
                        hashMap1.put(s15, ((int)(((int)(((Integer)hashMap1.get(s15)))) + 1)));
                    }
                    else {
                        hashMap1.put(s15, 1);
                    }
                }
                j1.n(new B9.g(15, this, hashMap1));
            }
        }
        j1.n(new I7.g(this, j0, v1));
    }
}

