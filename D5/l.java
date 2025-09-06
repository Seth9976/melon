package d5;

import B3.L;
import B3.N;
import H4.f;
import H4.g;
import I6.S;
import N0.M;
import P0.I;
import V3.d;
import a1.T;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import androidx.collection.V;
import androidx.collection.s;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.w;
import androidx.media3.session.legacy.C;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.a1;
import androidx.recyclerview.widget.p0;
import androidx.work.impl.WorkDatabase_Impl;
import b3.H;
import b3.Z;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.utils.datastore.MusicDnaPreferenceKeysKt;
import f1.x;
import h4.G;
import i.n.i.b.a.s.e.F7;
import i.n.i.b.a.s.e.Qd;
import i.n.i.b.a.s.e.U5;
import i.n.i.b.a.s.e.r0;
import i.n.i.b.a.s.e.r6;
import i.n.i.b.a.s.e.ud;
import i.n.i.b.a.s.e.wb;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import je.p;
import k3.a;
import k8.Y;
import k8.t;
import kotlin.jvm.internal.q;
import we.k;
import we.n;
import y1.e;

public final class l implements g, ud, o0.l {
    public final int a;
    public Object b;
    public Object c;

    public l(int v) {
        this.a = v;
        switch(v) {
            case 6: {
                super();
                this.b = new V(0);
                this.c = new s(null);
                return;
            }
            case 7: {
                super();
                this.b = new Rect();
                this.c = new Rect();
                return;
            }
            case 12: {
                super();
                this.b = new HashSet();
                return;
            }
            case 14: {
                super();
                this.b = Z.g("MusicDnaLocalDataSource", true);
                MelonAppBase.Companion.getClass();
                this.c = new Cb.g(MusicDnaPreferenceKeysKt.getMusicDnaDataStore(t.a().getContext()).getData(), this, 5);
                return;
            }
            default: {
                super();
                this.b = Collections.EMPTY_LIST;
                this.c = Collections.EMPTY_LIST;
            }
        }
    }

    public l(int v, Object object0, Object object1) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        super();
    }

    public l(int v, boolean z) {
        this.a = v;
        super();
    }

    public l(I i0, M m0) {
        this.a = 3;
        super();
        this.b = i0;
        this.c = w.s(m0);
    }

    public l(WorkDatabase_Impl workDatabase_Impl0) {
        this.a = 0;
        super();
        this.b = workDatabase_Impl0;
        this.c = new b(workDatabase_Impl0, false, 3);
    }

    public l(r0 r00) {
        this.a = 10;
        super();
        this.c = r00;
        this.b = new N(new byte[4], 4, 6, 0);
    }

    public l(String s) {
        this.a = 2;
        super();
        this.b = s;
        this.c = null;
    }

    public l(List list0) {
        this.a = 9;
        super();
        this.b = list0;
        this.c = new L[list0.size()];
    }

    public l(e e0) {
        this.a = 15;
        super();
        this.c = e0;
    }

    @Override  // o0.l
    public Object a(o0.b b0, Object object0) {
        return ((n)this.b).invoke(b0, object0);
    }

    @Override  // i.n.i.b.a.s.e.ud
    public void b(r6 r60, U5 u50, G g0) {
    }

    @Override  // i.n.i.b.a.s.e.ud
    public void c(wb wb0) {
        r0 r00 = (r0)this.c;
        SparseArray sparseArray0 = r00.f;
        N n0 = (N)this.b;
        if(wb0.z() == 0 && (wb0.z() & 0x80) != 0) {
            wb0.o(6);
            int v = wb0.d();
            for(int v1 = 0; v1 < v / 4; ++v1) {
                wb0.j(n0.d, 0, 4);
                n0.p(0);
                int v2 = n0.a(16);
                n0.v(3);
                if(v2 == 0) {
                    n0.v(13);
                }
                else {
                    int v3 = n0.a(13);
                    if(sparseArray0.get(v3) == null) {
                        sparseArray0.put(v3, new Qd(new F7(r00, v3)));
                        ++r00.l;
                    }
                }
            }
            if(r00.a != 2) {
                sparseArray0.remove(0);
            }
        }
    }

    @Override  // o0.l
    public Object d(Object object0) {
        return ((k)this.c).invoke(object0);
    }

    public void e(O0 o00, p0 p00) {
        V v0 = (V)this.b;
        a1 a10 = (a1)v0.get(o00);
        if(a10 == null) {
            a10 = a1.a();
            v0.put(o00, a10);
        }
        a10.c = p00;
        a10.a |= 8;
    }

    public x f(List list0) {
        f1.g g1;
        f1.g g0;
        int v1;
        Object object0 = null;
        try {
            int v = list0.size();
            v1 = 0;
            g0 = null;
        }
        catch(Exception exception0) {
            goto label_19;
        }
        while(v1 < v) {
            try {
                g1 = (f1.g)list0.get(v1);
            }
            catch(Exception exception0) {
                object0 = g0;
                goto label_19;
            }
            try {
                g1.a(((d)this.c));
                ++v1;
                g0 = g1;
                continue;
            }
            catch(Exception exception0) {
                object0 = g1;
            }
        label_19:
            StringBuilder stringBuilder0 = new StringBuilder();
            stringBuilder0.append("Error while applying EditCommand batch to buffer (length=" + ((A3.g)((d)this.c).f).l() + ", composition=" + ((d)this.c).f() + ", selection=" + T.g(a1.t.b(((d)this.c).b, ((d)this.c).c)) + "):");
            stringBuilder0.append('\n');
            p.p0(list0, stringBuilder0, "\n", null, null, new androidx.compose.foundation.w(10, object0, this), 60);
            String s = stringBuilder0.toString();
            q.f(s, "toString(...)");
            throw new RuntimeException(s, exception0);
        }
        d d0 = (d)this.c;
        d0.getClass();
        a1.g g2 = new a1.g(((A3.g)d0.f).toString());
        long v2 = a1.t.b(((d)this.c).b, ((d)this.c).c);
        T t0 = new T(v2);
        if(!T.f(((x)this.b).b)) {
            object0 = t0;
        }
        x x0 = new x(g2, (object0 == null ? a1.t.b(T.d(v2), T.e(v2)) : object0.a), ((d)this.c).f());
        this.b = x0;
        return x0;
    }

    public void g(long v, e3.p p0) {
        if(p0.a() >= 9 && (p0.g() == 434 && p0.g() == 1195456820 && p0.u() == 3)) {
            B3.b.e(v, p0, ((L[])this.c));
        }
    }

    public void h(B3.t t0, G g0) {
        L[] arr_l = (L[])this.c;
        for(int v = 0; v < arr_l.length; ++v) {
            g0.c();
            g0.d();
            L l0 = t0.track(g0.d, 3);
            androidx.media3.common.b b0 = (androidx.media3.common.b)((List)this.b).get(v);
            e3.b.d("application/cea-608".equals(b0.n) || "application/cea-708".equals(b0.n), "Invalid closed caption MIME type provided: " + b0.n);
            b3.n n0 = new b3.n();
            g0.d();
            n0.a = g0.e;
            n0.m = H.l(b0.n);
            n0.e = b0.e;
            n0.d = b0.d;
            n0.G = b0.H;
            n0.p = b0.q;
            l0.b(new androidx.media3.common.b(n0));
            arr_l[v] = l0;
        }
    }

    public M i() {
        return (M)((androidx.compose.runtime.O0)(((b0)this.c))).getValue();
    }

    public void j(int v, Bundle bundle0) {
        if(Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", "Analytics listener received message. ID: " + v + ", Extras: " + bundle0, null);
        }
        String s = bundle0.getString("name");
        if(s != null) {
            Bundle bundle1 = bundle0.getBundle("params");
            if(bundle1 == null) {
                bundle1 = new Bundle();
            }
            y8.s s1 = "clx".equals(bundle1.getString("_o")) ? ((y8.s)this.b) : ((androidx.lifecycle.b)this.c);
            if(s1 != null) {
                s1.onEvent(s, bundle1);
            }
        }
    }

    public void k(Exception exception0, boolean z) {
        this.c = null;
        HashSet hashSet0 = (HashSet)this.b;
        I6.V v0 = I6.V.p(hashSet0);
        hashSet0.clear();
        S s0 = v0.r(0);
        while(s0.hasNext()) {
            k3.b b0 = (k3.b)s0.next();
            b0.getClass();
            b0.h(exception0, (z ? 1 : 3));
        }
    }

    public p0 l(O0 o00, int v) {
        p0 p00;
        V v1 = (V)this.b;
        int v2 = v1.indexOfKey(o00);
        if(v2 >= 0) {
            a1 a10 = (a1)v1.valueAt(v2);
            if(a10 != null) {
                int v3 = a10.a;
                if((v3 & v) != 0) {
                    int v4 = v3 & ~v;
                    a10.a = v4;
                    if(v == 4) {
                        p00 = a10.b;
                    }
                    else if(v == 8) {
                        p00 = a10.c;
                    }
                    else {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    if((v4 & 12) == 0) {
                        v1.removeAt(v2);
                        a10.a = 0;
                        a10.b = null;
                        a10.c = null;
                        a1.d.release(a10);
                    }
                    return p00;
                }
            }
        }
        return null;
    }

    public void m(k3.b b0) {
        ((HashSet)this.b).add(b0);
        if(((k3.b)this.c) != null) {
            return;
        }
        this.c = b0;
        k3.s s0 = b0.b.getProvisionRequest();
        b0.x = s0;
        C c0 = b0.r;
        s0.getClass();
        c0.getClass();
        c0.obtainMessage(1, new a(s3.q.c.getAndIncrement(), true, SystemClock.elapsedRealtime(), s0)).sendToTarget();
    }

    public void n(O0 o00) {
        a1 a10 = (a1)((V)this.b).get(o00);
        if(a10 == null) {
            return;
        }
        a10.a &= -2;
    }

    @Override  // H4.g
    public String o() {
        return (String)this.b;
    }

    @Override  // H4.g
    public void p(f f0) {
        d5.f.i(f0, ((Object[])this.c));
    }

    public void q(O0 o00) {
        s s0 = (s)this.c;
        for(int v = s0.h() - 1; v >= 0; --v) {
            if(o00 == s0.i(v)) {
                Object[] arr_object = s0.c;
                Object object0 = androidx.collection.t.a;
                if(arr_object[v] == object0) {
                    break;
                }
                arr_object[v] = object0;
                s0.a = true;
                break;
            }
        }
        a1 a10 = (a1)((V)this.b).remove(o00);
        if(a10 != null) {
            a10.a = 0;
            a10.b = null;
            a10.c = null;
            a1.d.release(a10);
        }
    }

    @Override
    public String toString() {
        String s = "[ ";
        switch(this.a) {
            case 1: {
                return "{ID3Tag. " + ("values: " + ((C9.e)this.b)) + " }";
            }
            case 15: {
                if(((y1.f)this.b) != null) {
                    for(int v = 0; v < 9; ++v) {
                        StringBuilder stringBuilder0 = Y.p(s);
                        stringBuilder0.append(((y1.f)this.b).h[v]);
                        stringBuilder0.append(" ");
                        s = stringBuilder0.toString();
                    }
                }
                StringBuilder stringBuilder1 = U4.x.p(s, "] ");
                stringBuilder1.append(((y1.f)this.b));
                return stringBuilder1.toString();
            }
            default: {
                return super.toString();
            }
        }
    }
}

