package androidx.media3.session;

import I6.Q;
import I6.V;
import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import android.text.TextUtils;
import b3.E;
import b3.g;
import e3.b;
import java.util.List;

public final class r {
    public final int a;
    public final long b;
    public final Object c;
    public final int d;
    public final d0 e;
    public final u1 f;
    public static final String g;
    public static final String h;
    public static final String i;
    public static final String j;
    public static final String k;
    public static final String l;

    static {
        r.g = "0";
        r.h = "1";
        r.i = "2";
        r.j = "3";
        r.k = "4";
        r.l = "5";
    }

    public r(int v, long v1, d0 d00, u1 u10, Object object0, int v2) {
        this.a = v;
        this.b = v1;
        this.e = d00;
        this.f = u10;
        this.c = object0;
        this.d = v2;
    }

    public static r a(Bundle bundle0) {
        u1 u10;
        int v1 = bundle0.getInt(r.g, 0);
        long v2 = SystemClock.elapsedRealtime();
        long v3 = bundle0.getLong(r.h, v2);
        Bundle bundle1 = bundle0.getBundle(r.i);
        E e0 = null;
        d0 d00 = bundle1 == null ? null : d0.a(bundle1);
        Bundle bundle2 = bundle0.getBundle(r.l);
        if(bundle2 == null) {
            u10 = v1 == 0 ? null : new u1(v1, "no error message provided");
        }
        else {
            u10 = u1.a(bundle2);
        }
        int v4 = bundle0.getInt(r.k);
        if(v4 != 1) {
            String s = r.j;
            switch(v4) {
                case 2: {
                    Bundle bundle3 = bundle0.getBundle(s);
                    return bundle3 == null ? new r(v1, v3, d00, u10, null, 2) : new r(v1, v3, d00, u10, E.b(bundle3), 2);
                }
                case 3: {
                    IBinder iBinder0 = bundle0.getBinder(s);
                    if(iBinder0 != null) {
                        V v5 = g.a(iBinder0);
                        Q q0 = V.o();
                        for(int v = 0; v < v5.size(); ++v) {
                            Bundle bundle4 = (Bundle)v5.get(v);
                            bundle4.getClass();
                            q0.a(E.b(bundle4));
                        }
                        e0 = q0.g();
                    }
                    break;
                }
                case 4: {
                    break;
                }
                default: {
                    throw new IllegalStateException();
                }
            }
        }
        return new r(v1, v3, d00, u10, e0, v4);
    }

    public static r b(int v) {
        u1 u10 = new u1("no error message provided", v, Bundle.EMPTY);
        long v1 = SystemClock.elapsedRealtime();
        return new r(u10.a, v1, null, u10, null, 4);
    }

    public static r c(List list0, d0 d00) {
        for(Object object0: list0) {
            r.d(((E)object0));
        }
        return new r(0, SystemClock.elapsedRealtime(), d00, null, V.p(list0), 3);
    }

    public static void d(E e0) {
        if(TextUtils.isEmpty(e0.a)) {
            throw new IllegalArgumentException("mediaId must not be empty");
        }
        boolean z = false;
        b.d(e0.d.q != null, "mediaMetadata must specify isBrowsable");
        if(e0.d.r != null) {
            z = true;
        }
        b.d(z, "mediaMetadata must specify isPlayable");
    }
}

