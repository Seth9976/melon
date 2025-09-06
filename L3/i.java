package l3;

import B3.m;
import B3.r;
import I6.V;
import I6.p0;
import P.z;
import P3.c;
import R6.d;
import U4.F;
import android.net.Uri;
import android.text.TextUtils;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Metadata.Entry;
import androidx.media3.common.Metadata;
import androidx.media3.exoplayer.hls.HlsTrackMetadataEntry;
import androidx.media3.extractor.metadata.id3.PrivFrame;
import b3.H;
import b3.n;
import e3.v;
import g3.f;
import g3.j;
import h4.E;
import h4.a;
import h4.e;
import h7.u0;
import i3.l;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import t3.b;

public final class i extends b {
    public final boolean A;
    public final boolean B;
    public l3.b C;
    public p D;
    public int E;
    public boolean F;
    public volatile boolean G;
    public boolean H;
    public V I;
    public boolean J;
    public boolean K;
    public static final AtomicInteger L;
    public final int k;
    public final int l;
    public final Uri m;
    public final boolean n;
    public final int o;
    public final f p;
    public final j q;
    public final l3.b r;
    public final boolean s;
    public final boolean t;
    public final v u;
    public final h v;
    public final List w;
    public final DrmInitData x;
    public final c y;
    public final e3.p z;

    static {
        i.L = new AtomicInteger();
    }

    public i(h h0, f f0, j j0, androidx.media3.common.b b0, boolean z, f f1, j j1, boolean z1, Uri uri0, List list0, int v, Object object0, long v1, long v2, long v3, int v4, boolean z2, int v5, boolean z3, boolean z4, v v6, DrmInitData drmInitData0, l3.b b1, c c0, e3.p p0, boolean z5, l l0) {
        super(f0, j0, b0, v, object0, v1, v2, v3);
        this.A = z;
        this.o = v4;
        this.K = z2;
        this.l = v5;
        this.q = j1;
        this.p = f1;
        this.F = j1 != null;
        this.B = z1;
        this.m = uri0;
        this.s = z4;
        this.u = v6;
        this.t = z3;
        this.v = h0;
        this.w = list0;
        this.x = drmInitData0;
        this.r = b1;
        this.y = c0;
        this.z = p0;
        this.n = z5;
        this.I = p0.e;
        this.k = i.L.getAndIncrement();
    }

    public final void a(f f0, j j0, boolean z, boolean z1) {
        j j1;
        boolean z2 = false;
        if(z) {
            if(this.E != 0) {
                z2 = true;
            }
            j1 = j0;
        }
        else {
            long v = (long)this.E;
            long v1 = j0.f == -1L ? -1L : j0.f - v;
            j1 = v == 0L && j0.f == v1 ? j0 : new j(j0.a, j0.b, j0.c, j0.d, j0.e + v, v1, j0.g, j0.h);
        }
        try {
            m m0 = this.d(f0, j1, z1);
            if(z2) {
                m0.skipFully(this.E);
            }
            while(true) {
                try {
                    try {
                        if(this.G || this.C.a.a(m0, l3.b.f) != 0) {
                            break;
                        }
                    }
                    catch(EOFException eOFException0) {
                        if((this.d.f & 0x4000) == 0) {
                            throw eOFException0;
                        }
                        this.C.a.seek(0L, 0L);
                        break;
                    }
                }
                catch(Throwable throwable0) {
                    this.E = (int)(m0.d - j0.e);
                    throw throwable0;
                }
            }
            this.E = (int)(m0.d - j0.e);
        }
        finally {
            de.c.n(f0);
        }
    }

    public static byte[] b(String s) {
        if(u0.U(s).startsWith("0x")) {
            s = s.substring(2);
        }
        byte[] arr_b = new BigInteger(s, 16).toByteArray();
        byte[] arr_b1 = new byte[16];
        int v = arr_b.length <= 16 ? 0 : arr_b.length - 16;
        System.arraycopy(arr_b, v, arr_b1, 16 - arr_b.length + v, arr_b.length - v);
        return arr_b1;
    }

    public final int c(int v) {
        e3.b.j(!this.n);
        return v < this.I.size() ? ((int)(((Integer)this.I.get(v)))) : 0;
    }

    @Override  // w3.h
    public final void cancelLoad() {
        this.G = true;
    }

    public final m d(f f0, j j0, boolean z) {
        l3.b b1;
        q q0;
        boolean z4;
        a a1;
        ArrayList arrayList1;
        v v13;
        List list3;
        int v17;
        d d1;
        boolean z2;
        R6.c c2;
        e3.p p0;
        long v3;
        long v = f0.p(j0);
        long v1 = this.g;
        v v2 = this.u;
        if(z) {
            try {
                v2.g(v1, this.s);
            }
            catch(InterruptedException unused_ex) {
                throw new InterruptedIOException();
            }
            catch(TimeoutException timeoutException0) {
                throw new IOException(timeoutException0);
            }
        }
        m m0 = new m(f0, j0.e, v);
        if(this.C == null) {
            try {
                v3 = 0x8000000000000001L;
                p0 = this.z;
                m0.f = 0;
                p0.D(10);
                m0.peekFully(p0.a, 0, 10, false);
            }
            catch(EOFException unused_ex) {
                goto label_40;
            }
            if(p0.x() == 4801587) {
                p0.H(3);
                int v4 = p0.t();
                byte[] arr_b = p0.a;
                if(v4 + 10 > arr_b.length) {
                    p0.D(v4 + 10);
                    System.arraycopy(arr_b, 0, p0.a, 0, 10);
                }
                m0.peekFully(p0.a, 10, v4, false);
                Metadata metadata0 = this.y.g0(v4, p0.a);
                if(metadata0 != null) {
                    Entry[] arr_metadata$Entry = metadata0.a;
                    for(int v5 = 0; v5 < arr_metadata$Entry.length; ++v5) {
                        Entry metadata$Entry0 = arr_metadata$Entry[v5];
                        if(metadata$Entry0 instanceof PrivFrame && "com.apple.streaming.transportStreamTimestamp".equals(((PrivFrame)metadata$Entry0).b)) {
                            System.arraycopy(((PrivFrame)metadata$Entry0).c, 0, p0.a, 0, 8);
                            p0.G(0);
                            p0.F(8);
                            v3 = p0.o() & 0x1FFFFFFFFL;
                            break;
                        }
                    }
                }
            }
        label_40:
            m0.f = 0;
            l3.b b0 = this.r;
            if(b0 == null) {
                Map map0 = f0.getResponseHeaders();
                l3.c c0 = (l3.c)this.v;
                c0.getClass();
                androidx.media3.common.b b2 = this.d;
                int v6 = F.I(b2.n);
                List list0 = (List)map0.get("Content-Type");
                int v7 = F.I((list0 == null || list0.isEmpty() ? null : ((String)list0.get(0))));
                int v8 = F.J(j0.a);
                ArrayList arrayList0 = new ArrayList(7);
                l3.c.a(v6, arrayList0);
                l3.c.a(v7, arrayList0);
                l3.c.a(v8, arrayList0);
                for(int v9 = 0; v9 < 7; ++v9) {
                    l3.c.a(l3.c.c[v9], arrayList0);
                }
                m0.f = 0;
                int v10 = 0;
                a a0 = null;
                while(true) {
                    v v11 = this.u;
                    if(v10 >= arrayList0.size()) {
                        goto label_190;
                    }
                    int v12 = (int)(((Integer)arrayList0.get(v10)));
                    switch(v12) {
                        case 0: {
                            v13 = v11;
                            arrayList1 = arrayList0;
                            a1 = new a();
                            break;
                        }
                        case 1: {
                            v13 = v11;
                            arrayList1 = arrayList0;
                            a1 = new h4.d();
                            break;
                        }
                        case 2: {
                            v13 = v11;
                            arrayList1 = arrayList0;
                            a1 = new e(0);
                            break;
                        }
                        case 7: {
                            v13 = v11;
                            arrayList1 = arrayList0;
                            a1 = new U3.d(0L);
                            break;
                        }
                        default: {
                            d d0 = Y3.j.z;
                            List list1 = this.w;
                            switch(v12) {
                                case 8: {
                                    int v14 = 0;
                                    v13 = v11;
                                    arrayList1 = arrayList0;
                                    R6.c c1 = c0.a;
                                    boolean z1 = c0.b;
                                    Metadata metadata1 = b2.l;
                                    if(metadata1 == null) {
                                        c2 = c1;
                                        z2 = z1;
                                    }
                                    else {
                                        c2 = c1;
                                        int v15 = 0;
                                        while(true) {
                                            Entry[] arr_metadata$Entry1 = metadata1.a;
                                            z2 = z1;
                                            if(v15 >= arr_metadata$Entry1.length) {
                                                break;
                                            }
                                            Entry metadata$Entry1 = arr_metadata$Entry1[v15];
                                            if(metadata$Entry1 instanceof HlsTrackMetadataEntry) {
                                                v14 = !((HlsTrackMetadataEntry)metadata$Entry1).c.isEmpty();
                                                break;
                                            }
                                            ++v15;
                                            z1 = z2;
                                        }
                                    }
                                    int v16 = v14 == 0 ? 0 : 4;
                                    if(z2) {
                                        d1 = c2;
                                    }
                                    else {
                                        v16 |= 0x20;
                                        d1 = d0;
                                    }
                                    List list2 = list1 == null ? p0.e : list1;
                                    a1 = new V3.j(d1, v16, v13, list2);
                                    break;
                                }
                                case 11: {
                                    arrayList1 = arrayList0;
                                    R6.c c3 = c0.a;
                                    boolean z3 = c0.b;
                                    if(list1 == null) {
                                        n n0 = new n();
                                        n0.m = "application/cea-608";
                                        list3 = Collections.singletonList(new androidx.media3.common.b(n0));
                                        v17 = 16;
                                    }
                                    else {
                                        v17 = 0x30;
                                        list3 = list1;
                                    }
                                    String s = b2.k;
                                    if(!TextUtils.isEmpty(s)) {
                                        if(H.a(s, "audio/mp4a-latm") == null) {
                                            v17 |= 2;
                                        }
                                        if(H.a(s, "video/avc") == null) {
                                            v17 |= 4;
                                        }
                                    }
                                    d d2 = z3 ? c3 : d0;
                                    v13 = v11;
                                    a1 = new E(2, !z3, d2, v11, new z(v17, list3));
                                    break;
                                }
                                case 13: {
                                    arrayList1 = arrayList0;
                                    a1 = new q(b2.d, v11, c0.a, c0.b);
                                    v13 = v11;
                                    break;
                                }
                                default: {
                                    v13 = v11;
                                    arrayList1 = arrayList0;
                                    a1 = null;
                                }
                            }
                        }
                    }
                    a1.getClass();
                    try {
                        z4 = a1.c(m0);
                        m0.f = 0;
                    }
                    catch(EOFException unused_ex) {
                        m0.f = 0;
                        z4 = false;
                    }
                    catch(Throwable throwable0) {
                        m0.f = 0;
                        throw throwable0;
                    }
                    if(z4) {
                        b1 = new l3.b(a1, b2, v13, c0.a, c0.b);
                    }
                    else {
                        if(a0 == null && (v12 == v6 || v12 == v7 || v12 == v8 || v12 == 11)) {
                            a0 = a1;
                        }
                        ++v10;
                        arrayList0 = arrayList1;
                        continue;
                    label_190:
                        a0.getClass();
                        b1 = new l3.b(a0, b2, v11, c0.a, c0.b);
                    }
                    break;
                }
            label_193:
                this.C = b1;
                if(b1.a instanceof e || b1.a instanceof a || b1.a instanceof h4.d || b1.a instanceof U3.d) {
                    p p1 = this.D;
                    long v18 = v3 == 0x8000000000000001L ? v1 : v2.b(v3);
                    if(p1.r0 != v18) {
                        p1.r0 = v18;
                        o[] arr_o = p1.I;
                        for(int v19 = 0; v19 < arr_o.length; ++v19) {
                            o o0 = arr_o[v19];
                            if(o0.F != v18) {
                                o0.F = v18;
                                o0.z = true;
                            }
                        }
                    }
                }
                else {
                    p p2 = this.D;
                    if(p2.r0 != 0L) {
                        p2.r0 = 0L;
                        o[] arr_o1 = p2.I;
                        for(int v20 = 0; v20 < arr_o1.length; ++v20) {
                            o o1 = arr_o1[v20];
                            if(o1.F != 0L) {
                                o1.F = 0L;
                                o1.z = true;
                            }
                        }
                    }
                }
            }
            else {
                r r0 = b0.a;
                e3.b.j(((boolean)((r0 instanceof E || r0 instanceof V3.j ? 1 : 0) ^ 1)));
                r0.getClass().toString();
                if(r0 instanceof q) {
                    q0 = new q(b0.b.d, b0.c, b0.d, b0.e);
                    b1 = new l3.b(q0, b0.b, b0.c, b0.d, b0.e);
                }
                else if(r0 instanceof e) {
                    q0 = new e(0);
                    b1 = new l3.b(q0, b0.b, b0.c, b0.d, b0.e);
                }
                else if(r0 instanceof a) {
                    q0 = new a();
                    b1 = new l3.b(q0, b0.b, b0.c, b0.d, b0.e);
                }
                else if(r0 instanceof h4.d) {
                    q0 = new h4.d();
                    b1 = new l3.b(q0, b0.b, b0.c, b0.d, b0.e);
                }
                else {
                    if(!(r0 instanceof U3.d)) {
                        throw new IllegalStateException("Unexpected extractor type for recreation: " + r0.getClass().getSimpleName());
                    }
                    b1 = new l3.b(new U3.d(0), b0.b, b0.c, b0.d, b0.e);
                }
                goto label_193;
            }
            this.D.N.clear();
            this.C.a.d(this.D);
        }
        p p3 = this.D;
        DrmInitData drmInitData0 = this.x;
        if(!Objects.equals(p3.s0, drmInitData0)) {
            p3.s0 = drmInitData0;
            for(int v21 = 0; true; ++v21) {
                o[] arr_o2 = p3.I;
                if(v21 >= arr_o2.length) {
                    break;
                }
                if(p3.k0[v21]) {
                    o o2 = arr_o2[v21];
                    o2.I = drmInitData0;
                    o2.z = true;
                }
            }
        }
        return m0;
    }

    @Override  // w3.h
    public final void load() {
        this.D.getClass();
        if(this.C == null) {
            l3.b b0 = this.r;
            if(b0 != null && (b0.a instanceof E || b0.a instanceof V3.j)) {
                this.C = b0;
                this.F = false;
            }
        }
        j j0 = this.q;
        f f0 = this.p;
        if(this.F) {
            f0.getClass();
            j0.getClass();
            this.a(f0, j0, this.B, false);
            this.E = 0;
            this.F = false;
        }
        if(!this.G) {
            if(!this.t) {
                this.a(this.i, this.b, this.A, true);
            }
            this.H = !this.G;
        }
    }
}

