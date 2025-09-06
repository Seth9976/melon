package androidx.media3.session;

import L6.a;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.Arrays;

public final class b {
    public final s1 a;
    public final int b;
    public final int c;
    public final int d;
    public final Uri e;
    public final CharSequence f;
    public final Bundle g;
    public final a h;
    public final boolean i;
    public static final String j;
    public static final String k;
    public static final String l;
    public static final String m;
    public static final String n;
    public static final String o;
    public static final String p;
    public static final String q;
    public static final String r;

    static {
        b.j = "0";
        b.k = "1";
        b.l = "2";
        b.m = "3";
        b.n = "4";
        b.o = "5";
        b.p = "6";
        b.q = "7";
        b.r = "8";
    }

    public b(s1 s10, int v, int v1, int v2, Uri uri0, CharSequence charSequence0, Bundle bundle0, boolean z, a a0) {
        this.a = s10;
        this.b = v;
        this.c = v1;
        this.d = v2;
        this.e = uri0;
        this.f = charSequence0;
        this.g = new Bundle(bundle0);
        this.i = z;
        this.h = a0;
    }

    public static b a(int v, Bundle bundle0) {
        Bundle bundle1 = bundle0.getBundle(b.j);
        s1 s10 = bundle1 == null ? null : s1.a(bundle1);
        int v1 = bundle0.getInt(b.k, -1);
        boolean z = false;
        int v2 = bundle0.getInt(b.l, 0);
        CharSequence charSequence0 = bundle0.getCharSequence(b.m, "");
        Bundle bundle2 = bundle0.getBundle(b.n);
        boolean z1 = v < 3 || bundle0.getBoolean(b.o, true);
        Uri uri0 = (Uri)bundle0.getParcelable(b.p);
        int v3 = bundle0.getInt(b.q, 0);
        int[] arr_v = bundle0.getIntArray(b.r);
        androidx.media3.session.a a0 = new androidx.media3.session.a(v3, v2);
        if(s10 != null) {
            a0.c(s10);
        }
        if(v1 != -1) {
            a0.b(v1);
        }
        if(uri0 != null && (x1.a.w(uri0.getScheme(), "content") || x1.a.w(uri0.getScheme(), "android.resource"))) {
            e3.b.d(x1.a.w(uri0.getScheme(), "content") || x1.a.w(uri0.getScheme(), "android.resource"), "Only content or resource Uris are supported for CommandButton");
            a0.e = uri0;
        }
        a0.f = charSequence0;
        if(bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        a0.g = new Bundle(bundle2);
        a0.h = z1;
        if(arr_v == null) {
            arr_v = new int[]{6};
        }
        if(arr_v.length != 0) {
            z = true;
        }
        e3.b.c(z);
        a0.i = arr_v.length == 0 ? a.c : new a(Arrays.copyOf(arr_v, arr_v.length));
        return a0.a();
    }

    public final Bundle b() {
        Bundle bundle0 = new Bundle();
        s1 s10 = this.a;
        if(s10 != null) {
            Bundle bundle1 = s10.b();
            bundle0.putBundle(b.j, bundle1);
        }
        int v = this.b;
        if(v != -1) {
            bundle0.putInt(b.k, v);
        }
        int v1 = this.c;
        if(v1 != 0) {
            bundle0.putInt(b.q, v1);
        }
        int v2 = this.d;
        if(v2 != 0) {
            bundle0.putInt(b.l, v2);
        }
        CharSequence charSequence0 = this.f;
        if(charSequence0 != "") {
            bundle0.putCharSequence(b.m, charSequence0);
        }
        Bundle bundle2 = this.g;
        if(!bundle2.isEmpty()) {
            bundle0.putBundle(b.n, bundle2);
        }
        Uri uri0 = this.e;
        if(uri0 != null) {
            bundle0.putParcelable(b.p, uri0);
        }
        if(!this.i) {
            bundle0.putBoolean(b.o, false);
        }
        a a0 = this.h;
        int[] arr_v = a0.a;
        if(a0.b == 1) {
            y5.a.n(0, 1);
            if(arr_v[0] == 6) {
                return bundle0;
            }
        }
        int[] arr_v1 = Arrays.copyOfRange(arr_v, 0, a0.b);
        bundle0.putIntArray(b.r, arr_v1);
        return bundle0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof b ? x1.a.w(this.a, ((b)object0).a) && this.b == ((b)object0).b && this.c == ((b)object0).c && this.d == ((b)object0).d && x1.a.w(this.e, ((b)object0).e) && TextUtils.equals(this.f, ((b)object0).f) && this.i == ((b)object0).i && this.h.equals(((b)object0).h) : false;
    }

    @Override
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b, this.c, this.d, this.f, Boolean.valueOf(this.i), this.e, this.h});
    }
}

