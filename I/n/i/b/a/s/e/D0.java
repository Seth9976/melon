package i.n.i.b.a.s.e;

import P.z;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.media3.session.H0;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class d0 extends C7 {
    public final D0 B;
    public final W2 D;
    public final sa E;
    public final boolean G;
    public final boolean I;
    public final r6 M;
    public final re N;
    public final List S;
    public final c3 T;
    public final Db V;
    public final wb W;
    public final boolean X;
    public final boolean Y;
    public final boolean Z;
    public sa b0;
    public D3 c0;
    public int d0;
    public boolean e0;
    public volatile boolean f0;
    public boolean g0;
    public h9 h0;
    public boolean i0;
    public boolean j0;
    public static final AtomicInteger k0;
    public final int m;
    public final int n;
    public final Uri o;
    public final boolean r;
    public final int w;

    static {
        d0.k0 = new AtomicInteger();
    }

    public d0(re re0, D0 d00, W2 w20, u u0, boolean z, D0 d01, W2 w21, boolean z1, Uri uri0, List list0, int v, Object object0, long v1, long v2, long v3, int v4, boolean z2, int v5, boolean z3, boolean z4, r6 r60, c3 c30, sa sa0, Db db0, wb wb0, boolean z5, H0 h00, boolean z6) {
        super(d00, w20, u0, v, object0, v1, v2, v3, h00);
        this.X = z;
        this.w = v4;
        this.j0 = z2;
        this.n = v5;
        this.D = w21;
        this.B = d01;
        this.e0 = w21 != null;
        this.Y = z1;
        this.o = uri0;
        this.G = z4;
        this.M = r60;
        this.I = z3;
        this.N = re0;
        this.S = list0;
        this.T = c30;
        this.E = sa0;
        this.V = db0;
        this.W = wb0;
        this.r = z5;
        this.h0 = c5.e;
        this.m = d0.k0.getAndIncrement();
        this.j = h00;
        this.Z = z6;
    }

    @Override  // i.n.i.b.a.s.e.gb
    public final void b() {
        this.f0 = true;
    }

    @Override  // i.n.i.b.a.s.e.C7
    public final boolean c() {
        throw null;
    }

    public final int d(int v) {
        M7.J(!this.r);
        return v < this.h0.size() ? ((int)(((Integer)this.h0.get(v)))) : 0;
    }

    public final D2 e(D0 d00, W2 w20) {
        sa sa1;
        boolean z;
        q q1;
        int v10;
        r6 r62;
        ArrayList arrayList1;
        int v15;
        List list3;
        int v14;
        List list2;
        int v13;
        wb wb0;
        long v1;
        long v = d00.b(w20);
        D2 d20 = new D2(d00, w20.f, v);
        if(this.b0 == null) {
            try {
                v1 = 0x8000000000000001L;
                wb0 = this.W;
                d20.f = 0;
                wb0.l(10);
                d20.k(wb0.a, 0, 10, false);
            }
            catch(EOFException unused_ex) {
                goto label_30;
            }
            if(wb0.B() == 4801587) {
                wb0.o(3);
                int v2 = wb0.y();
                byte[] arr_b = wb0.a;
                if(v2 + 10 > arr_b.length) {
                    wb0.l(v2 + 10);
                    System.arraycopy(arr_b, 0, wb0.a, 0, 10);
                }
                d20.k(wb0.a, 10, v2, false);
                x8 x80 = this.V.d0(v2, wb0.a);
                if(x80 != null) {
                    b[] arr_x8$b = x80.a;
                    for(int v3 = 0; v3 < arr_x8$b.length; ++v3) {
                        b x8$b0 = arr_x8$b[v3];
                        if(x8$b0 instanceof y9 && "com.apple.streaming.transportStreamTimestamp".equals(((y9)x8$b0).b)) {
                            System.arraycopy(((y9)x8$b0).c, 0, wb0.a, 0, 8);
                            wb0.n(0);
                            wb0.m(8);
                            v1 = wb0.w() & 0x1FFFFFFFFL;
                            break;
                        }
                    }
                }
            }
        label_30:
            d20.f = 0;
            sa sa0 = this.E;
            if(sa0 == null) {
                Uri uri0 = w20.b;
                Map map0 = d00.e();
                Hb hb0 = (Hb)this.N;
                hb0.getClass();
                u u1 = this.d;
                int v4 = Ja.e(u1.l);
                List list0 = (List)map0.get("Content-Type");
                int v5 = Ja.e((list0 == null || list0.isEmpty() ? null : ((String)list0.get(0))));
                int v6 = Ja.d(uri0);
                ArrayList arrayList0 = new ArrayList(7);
                Hb.a(v4, arrayList0);
                Hb.a(v5, arrayList0);
                Hb.a(v6, arrayList0);
                for(int v7 = 0; v7 < 7; ++v7) {
                    Hb.a(Hb.c[v7], arrayList0);
                }
                d20.f = 0;
                int v8 = 0;
                q q0 = null;
                while(true) {
                    r6 r61 = this.M;
                    if(v8 >= arrayList0.size()) {
                        goto label_180;
                    }
                    int v9 = (int)(((Integer)arrayList0.get(v8)));
                    switch(v9) {
                        case 0: {
                            arrayList1 = arrayList0;
                            r62 = r61;
                            v10 = v8;
                            q1 = new q();
                            break;
                        }
                        case 1: {
                            arrayList1 = arrayList0;
                            r62 = r61;
                            v10 = v8;
                            q1 = new q0();
                            break;
                        }
                        case 2: {
                            arrayList1 = arrayList0;
                            r62 = r61;
                            v10 = v8;
                            q1 = new c2(0);
                            break;
                        }
                        case 7: {
                            arrayList1 = arrayList0;
                            r62 = r61;
                            v10 = v8;
                            q1 = new Od(0L);
                            break;
                        }
                        default: {
                            List list1 = this.S;
                            switch(v9) {
                                case 8: {
                                    int v11 = 0;
                                    arrayList1 = arrayList0;
                                    v10 = v8;
                                    x8 x81 = u1.j;
                                    if(x81 != null) {
                                        for(int v12 = 0; true; ++v12) {
                                            b[] arr_x8$b1 = x81.a;
                                            if(v12 >= arr_x8$b1.length) {
                                                break;
                                            }
                                            b x8$b1 = arr_x8$b1[v12];
                                            if(x8$b1 instanceof hf) {
                                                v11 = !((hf)x8$b1).c.isEmpty();
                                                break;
                                            }
                                        }
                                    }
                                    if(v11 == 0) {
                                        list2 = list1;
                                        v13 = 0;
                                    }
                                    else {
                                        v13 = 4;
                                        list2 = list1;
                                    }
                                    if(list2 == null) {
                                        list2 = Collections.EMPTY_LIST;
                                    }
                                    r62 = r61;
                                    q1 = new q3(v13, r61, null, list2, null);
                                    break;
                                }
                                case 11: {
                                    Gd gd0 = hb0.b;
                                    gd0.b();
                                    if(list1 == null) {
                                        ob ob0 = new ob();
                                        arrayList1 = arrayList0;
                                        ob0.k = "application/cea-608";
                                        list3 = Collections.singletonList(new u(ob0));
                                        v14 = 16;
                                    }
                                    else {
                                        v14 = 0x30;
                                        list3 = list1;
                                        arrayList1 = arrayList0;
                                    }
                                    String s = u1.i;
                                    v10 = v8;
                                    if(TextUtils.isEmpty(s)) {
                                        v15 = v14;
                                    }
                                    else {
                                        if(mb.c(s, "audio/mp4a-latm") == null) {
                                            v14 |= 2;
                                        }
                                        if(mb.c(s, "video/avc") == null) {
                                            v15 = v14 | 4;
                                        }
                                    }
                                    if(gd0.v) {
                                        v15 |= 1;
                                    }
                                    q1 = new r0(2, r61, new z(v15, list3));
                                    r62 = r61;
                                    break;
                                }
                                default: {
                                    if(v9 == 13) {
                                        q1 = new g7(u1.c, r61);
                                        arrayList1 = arrayList0;
                                        r62 = r61;
                                        v10 = v8;
                                    }
                                    else {
                                        arrayList1 = arrayList0;
                                        r62 = r61;
                                        v10 = v8;
                                        q1 = null;
                                    }
                                    break;
                                }
                            }
                        }
                    }
                    q1.getClass();
                    try {
                        z = q1.e(d20);
                        d20.f = 0;
                    }
                    catch(EOFException unused_ex) {
                        d20.f = 0;
                        z = false;
                    }
                    catch(Throwable throwable0) {
                        d20.f = 0;
                        throw throwable0;
                    }
                    if(z) {
                        sa1 = new sa(q1, u1, r62);
                    }
                    else {
                        if(q0 == null && (v9 == v4 || v9 == v5 || v9 == v6 || v9 == 11)) {
                            q0 = q1;
                        }
                        v8 = v10 + 1;
                        arrayList0 = arrayList1;
                        continue;
                    label_180:
                        q0.getClass();
                        sa sa2 = new sa(q0, u1, r61);
                        sa1 = sa2;
                    }
                    break;
                }
            }
            else {
                r6 r60 = (r6)sa0.d;
                u u0 = (u)sa0.c;
                M7.J(!sa0.k());
                q4 q40 = (q4)sa0.b;
                if(q40 instanceof g7) {
                    sa1 = new sa(new g7(u0.c, r60), u0, r60);
                }
                else if(q40 instanceof c2) {
                    sa1 = new sa(new c2(0), u0, r60);
                }
                else if(q40 instanceof q) {
                    sa1 = new sa(new q(), u0, r60);
                }
                else if(q40 instanceof q0) {
                    sa1 = new sa(new q0(), u0, r60);
                }
                else {
                    if(!(q40 instanceof Od)) {
                        throw new IllegalStateException("Unexpected extractor type for recreation: " + q40.getClass().getSimpleName());
                    }
                    sa1 = new sa(new Od(0), u0, r60);
                }
            }
            this.b0 = sa1;
            q4 q41 = (q4)sa1.b;
            if(q41 instanceof c2 || q41 instanceof q || q41 instanceof q0 || q41 instanceof Od) {
                D3 d30 = this.c0;
                long v16 = v1 == 0x8000000000000001L ? this.g : this.M.b(v1);
                if(d30.u0 != v16) {
                    d30.u0 = v16;
                    B3[] arr_b3 = d30.N;
                    for(int v17 = 0; v17 < arr_b3.length; ++v17) {
                        B3 b30 = arr_b3[v17];
                        if(b30.G != v16) {
                            b30.G = v16;
                            b30.A = true;
                        }
                    }
                }
            }
            else {
                D3 d31 = this.c0;
                if(d31.u0 != 0L) {
                    d31.u0 = 0L;
                    B3[] arr_b31 = d31.N;
                    for(int v18 = 0; v18 < arr_b31.length; ++v18) {
                        B3 b31 = arr_b31[v18];
                        if(b31.G != 0L) {
                            b31.G = 0L;
                            b31.A = true;
                        }
                    }
                }
            }
            this.c0.T.clear();
            ((q4)this.b0.b).g(this.c0);
        }
        D3 d32 = this.c0;
        c3 c30 = this.T;
        if(!L7.p(d32.v0, c30)) {
            d32.v0 = c30;
            for(int v19 = 0; true; ++v19) {
                B3[] arr_b32 = d32.N;
                if(v19 >= arr_b32.length) {
                    break;
                }
                if(d32.n0[v19]) {
                    B3 b32 = arr_b32[v19];
                    b32.J = c30;
                    b32.A = true;
                }
            }
        }
        return d20;
    }

    public final void f(D0 d00, W2 w20, boolean z) {
        W2 w21;
        v3 v30 = this.j;
        if(v30 != null) {
            w20 = v30.b(w20);
        }
        this.k = w20;
        boolean z1 = false;
        if(!z) {
            w21 = w20.b(((long)this.d0));
        }
        else if(this.Z) {
            w21 = w20.b(((long)this.d0));
        }
        else {
            if(this.d0 != 0) {
                z1 = true;
            }
            w21 = w20;
        }
        try {
            D2 d20 = this.e(d00, w21);
            if(z1) {
                d20.g(this.d0);
            }
            while(!this.f0) {
                try {
                    try {
                        if(((q4)this.b0.b).f(d20, sa.e) == 0) {
                            goto label_30;
                        }
                        else {
                            goto label_32;
                        }
                        goto label_33;
                    }
                    catch(EOFException eOFException0) {
                        if((this.d.e & 0x4000) == 0) {
                            throw eOFException0;
                        }
                        this.b0.f();
                        break;
                    }
                }
                catch(Throwable throwable0) {
                    this.d0 = (int)(d20.d - w20.f);
                    throw throwable0;
                }
            label_30:
                boolean z2 = true;
                goto label_33;
            label_32:
                z2 = false;
            label_33:
                if(!z2) {
                    break;
                }
            }
            this.d0 = (int)(d20.d - w20.f);
        }
        finally {
            L7.m(d00);
        }
    }

    @Override  // i.n.i.b.a.s.e.gb
    public final void g() {
        this.c0.getClass();
        if(this.b0 == null && (this.E != null && this.E.k())) {
            this.b0 = this.E;
            this.e0 = false;
        }
        W2 w20 = this.D;
        D0 d00 = this.B;
        if(this.e0) {
            d00.getClass();
            w20.getClass();
            this.f(d00, w20, this.Y);
            this.d0 = 0;
            this.e0 = false;
        }
        if(!this.f0) {
            if(!this.I) {
                try {
                    r6 r60 = this.M;
                    boolean z = this.G;
                    long v = this.g;
                    synchronized(r60) {
                        if(z && !r60.a) {
                            r60.b = v;
                            r60.a = true;
                        }
                        if(!z || v != r60.b) {
                            while(r60.d == 0x8000000000000001L) {
                                r60.wait();
                            }
                        }
                    }
                }
                catch(InterruptedException unused_ex) {
                    throw new InterruptedIOException();
                }
                this.f(this.i, this.b, this.X);
            }
            this.g0 = !this.f0;
        }
    }

    public static byte[] h(String s) {
        if(M7.j(s).startsWith("0x")) {
            s = s.substring(2);
        }
        byte[] arr_b = new BigInteger(s, 16).toByteArray();
        byte[] arr_b1 = new byte[16];
        int v = arr_b.length <= 16 ? 0 : arr_b.length - 16;
        System.arraycopy(arr_b, v, arr_b1, 16 - arr_b.length + v, arr_b.length - v);
        return arr_b1;
    }

    public final int i(int v) {
        if(this.r) {
            Log.d("HlsMediaChunk", "shouldSpliceIn is ignored");
        }
        return v < this.h0.size() ? ((int)(((Integer)this.h0.get(v)))) : 0;
    }
}

