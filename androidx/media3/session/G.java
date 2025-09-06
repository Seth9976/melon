package androidx.media3.session;

import android.os.Bundle;
import e3.b;

public final class g {
    public final int a;
    public final int b;
    public final String c;
    public final int d;
    public final Bundle e;
    public final int f;
    public static final String g;
    public static final String h;
    public static final String i;
    public static final String j;
    public static final String k;
    public static final String l;

    static {
        g.g = "0";
        g.h = "1";
        g.i = "2";
        g.j = "3";
        g.k = "4";
        g.l = "5";
    }

    public g(int v, int v1, String s, int v2, Bundle bundle0, int v3) {
        this.a = v;
        this.b = v1;
        this.c = s;
        this.d = v2;
        this.e = bundle0;
        this.f = v3;
    }

    public g(String s, int v, Bundle bundle0) {
        this(1005001300, 7, s, v, new Bundle(bundle0), 0);
    }

    public static g a(Bundle bundle0) {
        int v = bundle0.getInt(g.g, 0);
        int v1 = bundle0.getInt(g.k, 0);
        String s = bundle0.getString(g.h);
        s.getClass();
        b.c(bundle0.containsKey("2"));
        int v2 = bundle0.getInt("2");
        Bundle bundle1 = bundle0.getBundle(g.j);
        int v3 = bundle0.getInt(g.l, 0);
        if(bundle1 == null) {
            bundle1 = Bundle.EMPTY;
        }
        return new g(v, v1, s, v2, bundle1, v3);
    }

    public final Bundle b() {
        Bundle bundle0 = new Bundle();
        bundle0.putInt(g.g, this.a);
        bundle0.putString(g.h, this.c);
        bundle0.putInt("2", this.d);
        bundle0.putBundle(g.j, this.e);
        bundle0.putInt(g.k, this.b);
        bundle0.putInt(g.l, this.f);
        return bundle0;
    }
}

