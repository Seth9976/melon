package androidx.media3.session;

import I6.G0;
import I6.Q;
import I6.V;
import I6.p0;
import android.app.PendingIntent;
import android.media.session.MediaSession.Token;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcelable;
import b3.N;
import java.util.ArrayList;

public final class i {
    public static final String A;
    public static final String B;
    public static final String C;
    public final int a;
    public final int b;
    public final m c;
    public final PendingIntent d;
    public final t1 e;
    public final N f;
    public final N g;
    public final Bundle h;
    public final Bundle i;
    public final k1 j;
    public final V k;
    public final V l;
    public final MediaSession.Token m;
    public final V n;
    public static final String o;
    public static final String p;
    public static final String q;
    public static final String r;
    public static final String s;
    public static final String t;
    public static final String u;
    public static final String v;
    public static final String w;
    public static final String x;
    public static final String y;
    public static final String z;

    static {
        i.o = "0";
        i.p = "1";
        i.q = "2";
        i.r = "9";
        i.s = "e";
        i.t = "d";
        i.u = "3";
        i.v = "4";
        i.w = "5";
        i.x = "6";
        i.y = "b";
        i.z = "7";
        i.A = "8";
        i.B = "a";
        i.C = "c";
    }

    public i(int v, int v1, m m0, PendingIntent pendingIntent0, V v2, V v3, V v4, t1 t10, N n0, N n1, Bundle bundle0, Bundle bundle1, k1 k10, MediaSession.Token mediaSession$Token0) {
        this.a = v;
        this.b = v1;
        this.c = m0;
        this.d = pendingIntent0;
        this.k = v2;
        this.l = v3;
        this.n = v4;
        this.e = t10;
        this.f = n0;
        this.g = n1;
        this.h = bundle0;
        this.i = bundle1;
        this.j = k10;
        this.m = mediaSession$Token0;
    }

    public static i a(Bundle bundle0) {
        m m0;
        p0 p02;
        p0 p01;
        p0 p00;
        IBinder iBinder0 = bundle0.getBinder(i.B);
        if(iBinder0 instanceof h) {
            return ((h)iBinder0).a;
        }
        int v1 = bundle0.getInt(i.o, 0);
        int v2 = bundle0.getInt(i.A, 0);
        IBinder iBinder1 = bundle0.getBinder(i.p);
        iBinder1.getClass();
        Parcelable parcelable0 = bundle0.getParcelable(i.q);
        ArrayList arrayList0 = bundle0.getParcelableArrayList(i.r);
        if(arrayList0 == null) {
            p00 = p0.e;
        }
        else {
            Q q0 = V.o();
            for(int v3 = 0; v3 < arrayList0.size(); ++v3) {
                Bundle bundle1 = (Bundle)arrayList0.get(v3);
                bundle1.getClass();
                q0.a(b.a(v2, bundle1));
            }
            p00 = q0.g();
        }
        ArrayList arrayList1 = bundle0.getParcelableArrayList(i.s);
        if(arrayList1 == null) {
            p01 = p0.e;
        }
        else {
            Q q1 = V.o();
            for(int v4 = 0; v4 < arrayList1.size(); ++v4) {
                Bundle bundle2 = (Bundle)arrayList1.get(v4);
                bundle2.getClass();
                q1.a(b.a(v2, bundle2));
            }
            p01 = q1.g();
        }
        ArrayList arrayList2 = bundle0.getParcelableArrayList(i.t);
        if(arrayList2 == null) {
            p02 = p0.e;
        }
        else {
            Q q2 = V.o();
            for(int v = 0; v < arrayList2.size(); ++v) {
                Bundle bundle3 = (Bundle)arrayList2.get(v);
                bundle3.getClass();
                q2.a(b.a(v2, bundle3));
            }
            p02 = q2.g();
        }
        Bundle bundle4 = bundle0.getBundle(i.u);
        t1 t10 = bundle4 == null ? t1.b : t1.b(bundle4);
        Bundle bundle5 = bundle0.getBundle(i.w);
        N n0 = bundle5 == null ? N.b : N.b(bundle5);
        Bundle bundle6 = bundle0.getBundle(i.v);
        N n1 = bundle6 == null ? N.b : N.b(bundle6);
        Bundle bundle7 = bundle0.getBundle(i.x);
        Bundle bundle8 = bundle0.getBundle(i.y);
        Bundle bundle9 = bundle0.getBundle(i.z);
        k1 k10 = bundle9 == null ? k1.F : k1.r(v2, bundle9);
        Parcelable parcelable1 = bundle0.getParcelable(i.C);
        Bundle bundle10 = bundle8;
        IInterface iInterface0 = iBinder1.queryLocalInterface("androidx.media3.session.IMediaSession");
        if(iInterface0 == null || !(iInterface0 instanceof m)) {
            m0 = new l();  // 初始化器: Ljava/lang/Object;-><init>()V
            m0.a = iBinder1;
        }
        else {
            m0 = (m)iInterface0;
        }
        if(bundle7 == null) {
            bundle7 = Bundle.EMPTY;
        }
        if(bundle10 == null) {
            bundle10 = Bundle.EMPTY;
        }
        return new i(v1, v2, m0, ((PendingIntent)parcelable0), p00, p01, p02, t10, n1, n0, bundle7, bundle10, k10, ((MediaSession.Token)parcelable1));
    }

    public final Bundle b(int v) {
        Bundle bundle0 = new Bundle();
        bundle0.putInt(i.o, this.a);
        IBinder iBinder0 = this.c.asBinder();
        bundle0.putBinder(i.p, iBinder0);
        bundle0.putParcelable(i.q, this.d);
        V v1 = this.k;
        String s = i.r;
        if(!v1.isEmpty()) {
            ArrayList arrayList0 = new ArrayList(v1.size());
            for(Object object0: v1) {
                arrayList0.add(((b)object0).b());
            }
            bundle0.putParcelableArrayList(s, arrayList0);
        }
        V v2 = this.l;
        if(!v2.isEmpty()) {
            if(v >= 7) {
                ArrayList arrayList1 = new ArrayList(v2.size());
                for(Object object1: v2) {
                    arrayList1.add(((b)object1).b());
                }
                bundle0.putParcelableArrayList(i.s, arrayList1);
            }
            else {
                ArrayList arrayList2 = new ArrayList(v2.size());
                for(Object object2: v2) {
                    arrayList2.add(((b)object2).b());
                }
                bundle0.putParcelableArrayList(s, arrayList2);
            }
        }
        V v3 = this.n;
        if(!v3.isEmpty()) {
            ArrayList arrayList3 = new ArrayList(v3.size());
            for(Object object3: v3) {
                arrayList3.add(((b)object3).b());
            }
            bundle0.putParcelableArrayList(i.t, arrayList3);
        }
        this.e.getClass();
        Bundle bundle1 = new Bundle();
        ArrayList arrayList4 = new ArrayList();
        G0 g00 = this.e.a.k();
        while(g00.hasNext()) {
            Object object4 = g00.next();
            arrayList4.add(((s1)object4).b());
        }
        bundle1.putParcelableArrayList("0", arrayList4);
        bundle0.putBundle(i.u, bundle1);
        Bundle bundle2 = this.f.c();
        bundle0.putBundle(i.v, bundle2);
        Bundle bundle3 = this.g.c();
        bundle0.putBundle(i.w, bundle3);
        bundle0.putBundle(i.x, this.h);
        bundle0.putBundle(i.y, this.i);
        N n0 = h1.d(this.f, this.g);
        Bundle bundle4 = this.j.q(n0, false, false).t(v);
        bundle0.putBundle(i.z, bundle4);
        bundle0.putInt(i.A, this.b);
        MediaSession.Token mediaSession$Token0 = this.m;
        if(mediaSession$Token0 != null) {
            bundle0.putParcelable(i.C, mediaSession$Token0);
        }
        return bundle0;
    }
}

