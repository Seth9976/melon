package androidx.media3.session;

import android.os.Bundle;

public final class d0 {
    public final Bundle a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public static final String e;
    public static final String f;
    public static final String g;
    public static final String h;

    static {
        d0.e = "0";
        d0.f = "1";
        d0.g = "2";
        d0.h = "3";
    }

    public d0(Bundle bundle0, boolean z, boolean z1, boolean z2) {
        this.a = new Bundle(bundle0);
        this.b = z;
        this.c = z1;
        this.d = z2;
    }

    public static d0 a(Bundle bundle0) {
        Bundle bundle1 = bundle0.getBundle("0");
        boolean z = bundle0.getBoolean("1", false);
        boolean z1 = bundle0.getBoolean("2", false);
        boolean z2 = bundle0.getBoolean("3", false);
        if(bundle1 == null) {
            bundle1 = Bundle.EMPTY;
        }
        return new d0(bundle1, z, z1, z2);
    }
}

