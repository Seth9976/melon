package androidx.media3.session;

import android.content.ComponentName;
import android.media.session.MediaSession.Token;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import java.util.Arrays;
import x1.a;

public final class z1 implements x1 {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final String e;
    public final String f;
    public final ComponentName g;
    public final IBinder h;
    public final Bundle i;
    public final MediaSession.Token j;
    public static final String k;
    public static final String l;
    public static final String m;
    public static final String n;
    public static final String o;
    public static final String p;
    public static final String q;
    public static final String r;
    public static final String s;
    public static final String t;

    static {
        z1.k = "0";
        z1.l = "1";
        z1.m = "2";
        z1.n = "3";
        z1.o = "4";
        z1.p = "5";
        z1.q = "6";
        z1.r = "7";
        z1.s = "8";
        z1.t = "9";
    }

    public z1(int v, int v1, int v2, int v3, String s, String s1, ComponentName componentName0, IBinder iBinder0, Bundle bundle0, MediaSession.Token mediaSession$Token0) {
        this.a = v;
        this.b = v1;
        this.c = v2;
        this.d = v3;
        this.e = s;
        this.f = s1;
        this.g = componentName0;
        this.h = iBinder0;
        this.i = bundle0;
        this.j = mediaSession$Token0;
    }

    @Override  // androidx.media3.session.x1
    public final Object a() {
        return this.h;
    }

    @Override  // androidx.media3.session.x1
    public final String b() {
        return this.f;
    }

    @Override  // androidx.media3.session.x1
    public final int c() {
        return this.d;
    }

    @Override  // androidx.media3.session.x1
    public final ComponentName d() {
        return this.g;
    }

    @Override  // androidx.media3.session.x1
    public final boolean e() {
        return false;
    }

    // 去混淆评级： 中等(60)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof z1 ? this.a == ((z1)object0).a && this.b == ((z1)object0).b && this.c == ((z1)object0).c && this.d == ((z1)object0).d && TextUtils.equals(this.e, ((z1)object0).e) && TextUtils.equals(this.f, ((z1)object0).f) && a.w(this.g, ((z1)object0).g) && a.w(this.h, ((z1)object0).h) && a.w(this.j, ((z1)object0).j) : false;
    }

    @Override  // androidx.media3.session.x1
    public final MediaSession.Token f() {
        return this.j;
    }

    @Override  // androidx.media3.session.x1
    public final Bundle getExtras() {
        return new Bundle(this.i);
    }

    @Override  // androidx.media3.session.x1
    public final String getPackageName() {
        return this.e;
    }

    @Override  // androidx.media3.session.x1
    public final int getType() {
        return this.b;
    }

    @Override  // androidx.media3.session.x1
    public final int getUid() {
        return this.a;
    }

    @Override
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.j});
    }

    @Override  // androidx.media3.session.x1
    public final Bundle toBundle() {
        Bundle bundle0 = new Bundle();
        bundle0.putInt(z1.k, this.a);
        bundle0.putInt(z1.l, this.b);
        bundle0.putInt(z1.m, this.c);
        bundle0.putString(z1.n, this.e);
        bundle0.putString(z1.o, this.f);
        bundle0.putBinder(z1.q, this.h);
        bundle0.putParcelable(z1.p, this.g);
        bundle0.putBundle(z1.r, this.i);
        bundle0.putInt(z1.s, this.d);
        MediaSession.Token mediaSession$Token0 = this.j;
        if(mediaSession$Token0 != null) {
            bundle0.putParcelable(z1.t, mediaSession$Token0);
        }
        return bundle0;
    }

    @Override
    public final String toString() {
        return "SessionToken {pkg=" + this.e + " type=" + this.b + " libraryVersion=" + this.c + " interfaceVersion=" + this.d + " service=" + this.f + " IMediaSession=" + this.h + " extras=" + this.i + "}";
    }
}

