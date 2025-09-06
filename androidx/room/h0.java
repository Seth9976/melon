package androidx.room;

import A3.c;
import A7.d;
import H0.b;
import H0.e;
import U4.x;
import Vb.i;
import Yc.D;
import d5.n;
import ie.m;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import je.C;
import je.y;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineName;
import we.a;

public final class h0 {
    public final H a;
    public final HashMap b;
    public final HashMap c;
    public final boolean d;
    public final D e;
    public final LinkedHashMap f;
    public final String[] g;
    public final c h;
    public final u i;
    public final AtomicBoolean j;
    public a k;
    public static final String[] l;

    static {
        h0.l = new String[]{"INSERT", "UPDATE", "DELETE"};
    }

    public h0(H h0, HashMap hashMap0, HashMap hashMap1, String[] arr_s, boolean z, D d0) {
        q.g(h0, "database");
        String s2;
        super();
        this.a = h0;
        this.b = hashMap0;
        this.c = hashMap1;
        this.d = z;
        this.e = d0;
        this.j = new AtomicBoolean(false);
        this.k = new i(9);
        this.f = new LinkedHashMap();
        String[] arr_s1 = new String[arr_s.length];
        for(int v = 0; v < arr_s.length; ++v) {
            Locale locale0 = Locale.ROOT;
            String s = arr_s[v].toLowerCase(locale0);
            q.f(s, "toLowerCase(...)");
            this.f.put(s, v);
            String s1 = (String)this.b.get(arr_s[v]);
            if(s1 == null) {
                s2 = null;
            }
            else {
                s2 = s1.toLowerCase(locale0);
                q.f(s2, "toLowerCase(...)");
            }
            if(s2 != null) {
                s = s2;
            }
            arr_s1[v] = s;
        }
        this.g = arr_s1;
        for(Object object0: this.b.entrySet()) {
            Map.Entry map$Entry0 = (Map.Entry)object0;
            String s3 = (String)map$Entry0.getValue();
            Locale locale1 = Locale.ROOT;
            String s4 = s3.toLowerCase(locale1);
            q.f(s4, "toLowerCase(...)");
            if(this.f.containsKey(s4)) {
                String s5 = ((String)map$Entry0.getKey()).toLowerCase(locale1);
                q.f(s5, "toLowerCase(...)");
                Object object1 = C.Q(s4, this.f);
                this.f.put(s5, object1);
            }
        }
        this.h = new c(this.g.length);
        this.i = new u(this.g.length);
    }

    public static final Object a(h0 h00, w w0, oe.c c0) {
        U u0;
        if(c0 instanceof U) {
            u0 = (U)c0;
            int v = u0.D;
            if((v & 0x80000000) == 0) {
                u0 = new U(h00, c0);
            }
            else {
                u0.D = v ^ 0x80000000;
            }
        }
        else {
            u0 = new U(h00, c0);
        }
        Object object0 = u0.w;
        ne.a a0 = ne.a.a;
        switch(u0.D) {
            case 0: {
                n.D(object0);
                Wf.a a1 = new Wf.a(12);
                u0.r = w0;
                u0.D = 1;
                object0 = w0.d("SELECT * FROM room_table_modification_log WHERE invalidated = 1", a1, u0);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                w0 = (w)u0.r;
                n.D(object0);
                break;
            }
            case 2: {
                Set set0 = (Set)u0.r;
                n.D(object0);
                return set0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(!((Set)object0).isEmpty()) {
            u0.r = (Set)object0;
            u0.D = 2;
            if(e.E(w0, "UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1", u0) == a0) {
                return a0;
            }
        }
        return (Set)object0;
    }

    public static final Object b(h0 h00, oe.c c0) {
        Set set0;
        y4.a a2;
        Object object1;
        y4.a a1;
        Y y0;
        H h0 = h00.a;
        if(c0 instanceof Y) {
            y0 = (Y)c0;
            int v = y0.E;
            if((v & 0x80000000) == 0) {
                y0 = new Y(h00, c0);
            }
            else {
                y0.E = v ^ 0x80000000;
            }
        }
        else {
            y0 = new Y(h00, c0);
        }
        Object object0 = y0.B;
        ne.a a0 = ne.a.a;
        switch(y0.E) {
            case 0: {
                n.D(object0);
                a1 = h0.getCloseBarrier$room_runtime_release();
                boolean z = a1.a();
                y y1 = y.a;
                if(z) {
                    try {
                        if(!h00.j.compareAndSet(true, false)) {
                            goto label_30;
                        }
                        if(!((Boolean)h00.k.invoke()).booleanValue()) {
                            goto label_28;
                        }
                        a0 a00 = new a0(h00, null);
                        y0.r = h00;
                        y0.w = a1;
                        y0.E = 1;
                        object1 = h0.useConnection$room_runtime_release(false, a00, y0);
                        if(object1 == a0) {
                            return a0;
                        }
                        break;
                    }
                    catch(Throwable throwable0) {
                        throwable1 = throwable0;
                        a2 = a1;
                        a2.b();
                        throw throwable1;
                    }
                label_28:
                    a1.b();
                    return y1;
                label_30:
                    a1.b();
                    return y1;
                }
                return y1;
            }
            case 1: {
                try {
                    a2 = y0.w;
                    h0 h01 = y0.r;
                    n.D(object0);
                    a1 = a2;
                    h00 = h01;
                    object1 = object0;
                    break;
                }
                catch(Throwable throwable1) {
                    a2.b();
                    throw throwable1;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            set0 = (Set)object1;
            if(!set0.isEmpty()) {
                h00.i.c(set0);
                h00.e.invoke(set0);
            }
        }
        catch(Throwable throwable0) {
            throwable1 = throwable0;
            a2 = a1;
            a2.b();
            throw throwable1;
        }
        a1.b();
        return set0;
    }

    public static final Object c(h0 h00, T t0, int v, oe.c c0) {
        String s;
        int v5;
        w w1;
        int v4;
        h0 h02;
        String[] arr_s;
        c0 c00;
        w w0 = t0;
        int v1 = v;
        h00.getClass();
        if(c0 instanceof c0) {
            c00 = (c0)c0;
            int v2 = c00.S;
            if((v2 & 0x80000000) == 0) {
                c00 = new c0(h00, c0);
            }
            else {
                c00.S = v2 ^ 0x80000000;
            }
        }
        else {
            c00 = new c0(h00, c0);
        }
        Object object0 = c00.M;
        ne.a a0 = ne.a.a;
    alab1:
        switch(c00.S) {
            case 0: {
                n.D(object0);
                c00.r = h00;
                c00.w = w0;
                c00.E = v1;
                c00.S = 1;
                if(e.E(w0, "INSERT OR IGNORE INTO room_table_modification_log VALUES(" + v1 + ", 0)", c00) != a0) {
                    goto label_29;
                }
                break;
            }
            case 1: {
                int v3 = c00.E;
                w0 = c00.w;
                h0 h01 = c00.r;
                n.D(object0);
                v1 = v3;
                h00 = h01;
            label_29:
                arr_s = h0.l;
                h02 = h00;
                v4 = 3;
                w1 = w0;
                v5 = 0;
                s = h00.g[v1];
                goto label_45;
            }
            case 2: {
                v4 = c00.I;
                v5 = c00.G;
                v1 = c00.E;
                arr_s = c00.D;
                s = c00.B;
                w1 = c00.w;
                h02 = c00.r;
                n.D(object0);
                while(true) {
                    ++v5;
                label_45:
                    if(v5 >= v4) {
                        return ie.H.a;
                    }
                    String s1 = arr_s[v5];
                    StringBuilder stringBuilder0 = d.o("CREATE ", (h02.d ? "TEMP" : ""), " TRIGGER IF NOT EXISTS `", "room_table_modification_trigger_" + s + '_' + s1, "` AFTER ");
                    d.u(stringBuilder0, s1, " ON `", s, "` BEGIN UPDATE room_table_modification_log SET invalidated = 1 WHERE table_id = ");
                    String s2 = x.g(v1, " AND invalidated = 0; END", stringBuilder0);
                    c00.r = h02;
                    c00.w = w1;
                    c00.B = s;
                    c00.D = arr_s;
                    c00.E = v1;
                    c00.G = v5;
                    c00.I = v4;
                    c00.S = 2;
                    if(e.E(w1, s2, c00) != a0) {
                        continue;
                    }
                    break alab1;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return a0;
    }

    public static final Object d(h0 h00, T t0, int v, oe.c c0) {
        String[] arr_s;
        int v3;
        w w0;
        int v2;
        String s;
        d0 d00;
        h00.getClass();
        if(c0 instanceof d0) {
            d00 = (d0)c0;
            int v1 = d00.M;
            if((v1 & 0x80000000) == 0) {
                d00 = new d0(h00, c0);
            }
            else {
                d00.M = v1 ^ 0x80000000;
            }
        }
        else {
            d00 = new d0(h00, c0);
        }
        Object object0 = d00.G;
        ne.a a0 = ne.a.a;
        switch(d00.M) {
            case 0: {
                n.D(object0);
                s = h00.g[v];
                v2 = 3;
                w0 = t0;
                v3 = 0;
                arr_s = h0.l;
                goto label_30;
            }
            case 1: {
                v2 = d00.E;
                v3 = d00.D;
                String[] arr_s1 = d00.B;
                s = d00.w;
                w w1 = d00.r;
                n.D(object0);
                arr_s = arr_s1;
                w0 = w1;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        while(true) {
            ++v3;
        label_30:
            if(v3 >= v2) {
                break;
            }
            d00.r = w0;
            d00.w = s;
            d00.B = arr_s;
            d00.D = v3;
            d00.E = v2;
            d00.M = 1;
            if(e.E(w0, b.c('`', "DROP TRIGGER IF EXISTS `", "room_table_modification_trigger_" + s + '_' + arr_s[v3]), d00) != a0) {
                continue;
            }
            return a0;
        }
        return ie.H.a;
    }

    public final void e(a a0, a a1) {
        q.g(a0, "onRefreshScheduled");
        q.g(a1, "onRefreshCompleted");
        if(this.j.compareAndSet(false, true)) {
            a0.invoke();
            BuildersKt__Builders_commonKt.launch$default(this.a.getCoroutineScope(), new CoroutineName("Room Invalidation Tracker Refresh"), null, new b0(this, a1, null), 2, null);
        }
    }

    public final Object f(oe.c c0) {
        y4.a a2;
        e0 e00;
        if(c0 instanceof e0) {
            e00 = (e0)c0;
            int v = e00.D;
            if((v & 0x80000000) == 0) {
                e00 = new e0(this, c0);
            }
            else {
                e00.D = v ^ 0x80000000;
            }
        }
        else {
            e00 = new e0(this, c0);
        }
        Object object0 = e00.w;
        ne.a a0 = ne.a.a;
        switch(e00.D) {
            case 0: {
                n.D(object0);
                H h0 = this.a;
                y4.a a1 = h0.getCloseBarrier$room_runtime_release();
                if(a1.a()) {
                    try {
                        g0 g00 = new g0(this, null);
                        e00.r = a1;
                        e00.D = 1;
                        if(h0.useConnection$room_runtime_release(false, g00, e00) == a0) {
                            return a0;
                        }
                    }
                    catch(Throwable throwable0) {
                        a2 = a1;
                        a2.b();
                        throw throwable0;
                    }
                    a2 = a1;
                    break;
                }
                return ie.H.a;
            }
            case 1: {
                try {
                    a2 = e00.r;
                    n.D(object0);
                    break;
                }
                catch(Throwable throwable0) {
                }
                a2.b();
                throw throwable0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        a2.b();
        return ie.H.a;
    }

    public final m g(String[] arr_s) {
        ke.i i0 = new ke.i();
        for(int v1 = 0; v1 < arr_s.length; ++v1) {
            String s = arr_s[v1];
            String s1 = s.toLowerCase(Locale.ROOT);
            q.f(s1, "toLowerCase(...)");
            Set set0 = (Set)this.c.get(s1);
            if(set0 == null) {
                i0.add(s);
            }
            else {
                i0.addAll(set0);
            }
        }
        String[] arr_s1 = (String[])e1.m.k(i0).toArray(new String[0]);
        int[] arr_v = new int[arr_s1.length];
        for(int v = 0; v < arr_s1.length; ++v) {
            String s2 = arr_s1[v];
            String s3 = s2.toLowerCase(Locale.ROOT);
            q.f(s3, "toLowerCase(...)");
            Integer integer0 = (Integer)this.f.get(s3);
            if(integer0 == null) {
                throw new IllegalArgumentException("There is no table with name " + s2);
            }
            arr_v[v] = (int)integer0;
        }
        return new m(arr_s1, arr_v);
    }
}

