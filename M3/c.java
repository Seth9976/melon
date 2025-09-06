package m3;

import B7.b;
import Nf.p;
import android.net.Uri.Builder;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import androidx.media3.session.N;
import b3.I;
import b3.n;
import e3.x;
import i3.d;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kb.D;
import s3.q;
import w3.g;
import w3.j;
import w3.k;
import w3.m;

public final class c implements g {
    public final D a;
    public final o b;
    public final p c;
    public final HashMap d;
    public final CopyOnWriteArrayList e;
    public b f;
    public k g;
    public Handler h;
    public l3.k i;
    public m3.k j;
    public Uri k;
    public h l;
    public boolean m;
    public long n;
    public static final d o;

    static {
        c.o = new d(18);
    }

    public c(D d0, p p0, o o0) {
        this.a = d0;
        this.b = o0;
        this.c = p0;
        this.e = new CopyOnWriteArrayList();
        this.d = new HashMap();
        this.n = 0x8000000000000001L;
    }

    @Override  // w3.g
    public final N a(w3.h h0, long v, long v1, IOException iOException0, int v2) {
        long v4;
        q q0 = new q(((m)h0).d.d, v1);
        int v3 = ((m)h0).c;
        this.c.getClass();
        if(iOException0 instanceof I || iOException0 instanceof FileNotFoundException || iOException0 instanceof g3.q || iOException0 instanceof j) {
        label_11:
            v4 = 0x8000000000000001L;
        }
        else {
            Throwable throwable0 = iOException0;
            while(throwable0 != null) {
                if(throwable0 instanceof g3.g && ((g3.g)throwable0).a == 2008) {
                    goto label_11;
                }
                throwable0 = throwable0.getCause();
            }
            v4 = (long)Math.min((v2 - 1) * 1000, 5000);
        }
        boolean z = Long.compare(v4, 0x8000000000000001L) == 0;
        this.f.t(q0, v3, -1, null, 0, null, 0x8000000000000001L, 0x8000000000000001L, iOException0, z);
        return z ? k.f : new N(v4, 0, false);
    }

    public final h b(Uri uri0, boolean z) {
        HashMap hashMap0 = this.d;
        h h0 = ((m3.b)hashMap0.get(uri0)).d;
        if(h0 != null && z) {
            if(!uri0.equals(this.k)) {
                List list0 = this.j.e;
                for(int v = 0; v < list0.size(); ++v) {
                    if(uri0.equals(((m3.j)list0.get(v)).a)) {
                        if(this.l != null && this.l.o) {
                            break;
                        }
                        this.k = uri0;
                        m3.b b0 = (m3.b)hashMap0.get(uri0);
                        h h1 = b0.d;
                        if(h1 != null && h1.o) {
                            this.l = h1;
                            this.i.u(h1);
                            break;
                        }
                        b0.g(this.c(uri0));
                        break;
                    }
                }
            }
            m3.b b1 = (m3.b)hashMap0.get(uri0);
            h h2 = b1.d;
            if(!b1.k) {
                b1.k = true;
                if(h2 != null && !h2.o) {
                    b1.e(true);
                }
            }
        }
        return h0;
    }

    public final Uri c(Uri uri0) {
        h h0 = this.l;
        if(h0 != null && h0.v.e) {
            e e0 = (e)h0.t.get(uri0);
            if(e0 != null) {
                Uri.Builder uri$Builder0 = uri0.buildUpon();
                uri$Builder0.appendQueryParameter("_HLS_msn", String.valueOf(e0.b));
                int v = e0.c;
                if(v != -1) {
                    uri$Builder0.appendQueryParameter("_HLS_part", String.valueOf(v));
                }
                return uri$Builder0.build();
            }
        }
        return uri0;
    }

    @Override  // w3.g
    public final void d(w3.h h0, long v, long v1) {
        m3.k k0;
        l l0 = (l)((m)h0).f;
        if(l0 instanceof h) {
            Uri uri0 = Uri.parse(l0.a);
            n n0 = new n();
            n0.a = "0";
            n0.l = "application/x-mpegURL";
            List list0 = Collections.singletonList(new m3.j(uri0, new androidx.media3.common.b(n0), null, null, null, null));
            k0 = new m3.k("", Collections.EMPTY_LIST, list0, Collections.EMPTY_LIST, Collections.EMPTY_LIST, Collections.EMPTY_LIST, Collections.EMPTY_LIST, null, null, false, Collections.EMPTY_MAP, Collections.EMPTY_LIST);
        }
        else {
            k0 = (m3.k)l0;
        }
        this.j = k0;
        this.k = ((m3.j)k0.e.get(0)).a;
        a a0 = new a(this);
        this.e.add(a0);
        List list1 = k0.d;
        int v2 = list1.size();
        for(int v3 = 0; v3 < v2; ++v3) {
            Uri uri1 = (Uri)list1.get(v3);
            m3.b b0 = new m3.b(this, uri1);
            this.d.put(uri1, b0);
        }
        q q0 = new q(((m)h0).d.d, v1);
        m3.b b1 = (m3.b)this.d.get(this.k);
        if(l0 instanceof h) {
            b1.i(((h)l0), q0);
        }
        else {
            b1.e(false);
        }
        this.c.getClass();
        this.f.s(q0, 4, -1, null, 0, null, 0x8000000000000001L, 0x8000000000000001L);
    }

    public final boolean e(Uri uri0) {
        m3.b b0 = (m3.b)this.d.get(uri0);
        if(b0.d != null) {
            long v = SystemClock.elapsedRealtime();
            long v1 = Math.max(30000L, x.Z(b0.d.u));
            return b0.d.o || (b0.d.d == 1 || b0.d.d == 2) || b0.e + v1 > v;
        }
        return false;
    }

    @Override  // w3.g
    public final void h(w3.h h0, long v, long v1, boolean z) {
        q q0 = new q(((m)h0).d.d, v1);
        this.c.getClass();
        this.f.r(q0, 4, -1, null, 0, null, 0x8000000000000001L, 0x8000000000000001L);
    }
}

