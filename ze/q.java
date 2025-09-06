package Ze;

import W.p;
import ie.i;
import ie.m;
import je.C;
import qf.c;

public abstract class q {
    public static final c a;
    public static final c[] b;
    public static final p c;
    public static final r d;

    static {
        c c0 = new c("org.jspecify.nullness");
        c c1 = new c("org.jspecify.annotations");
        q.a = c1;
        c c2 = new c("io.reactivex.rxjava3.annotations");
        c c3 = new c("org.checkerframework.checker.nullness.compatqual");
        q.b = new c[]{new c("io.reactivex.rxjava3.annotations.Nullable"), new c("io.reactivex.rxjava3.annotations.NonNull")};
        m m0 = new m(new c("org.jetbrains.annotations"), r.d);
        m m1 = new m(new c("androidx.annotation"), r.d);
        m m2 = new m(new c("android.support.annotation"), r.d);
        m m3 = new m(new c("android.annotation"), r.d);
        m m4 = new m(new c("com.android.annotations"), r.d);
        m m5 = new m(new c("org.eclipse.jdt.annotation"), r.d);
        m m6 = new m(new c("org.checkerframework.checker.nullness.qual"), r.d);
        m m7 = new m(c3, r.d);
        m m8 = new m(new c("javax.annotation"), r.d);
        m m9 = new m(new c("edu.umd.cs.findbugs.annotations"), r.d);
        m m10 = new m(new c("io.reactivex.annotations"), r.d);
        m m11 = new m(new c("androidx.annotation.RecentlyNullable"), new r(z.c, 4));
        m m12 = new m(new c("androidx.annotation.RecentlyNonNull"), new r(z.c, 4));
        m m13 = new m(new c("lombok"), r.d);
        i i0 = new i(2, 1, 0);
        m m14 = new m(c0, new r(z.c, i0, z.d));
        i i1 = new i(2, 1, 0);
        m m15 = new m(c1, new r(z.c, i1, z.d));
        i i2 = new i(1, 8, 0);
        m m16 = new m(c2, new r(z.c, i2, z.d));
        c c4 = new c("jakarta.annotation");
        i i3 = new i(2, 4, 0);
        q.c = new p(C.S(new m[]{m0, m1, m2, m3, m4, m5, m6, m7, m8, m9, m10, m11, m12, m13, m14, m15, m16, new m(c4, new r(z.c, i3, z.d))}));
        q.d = new r(z.c, 4);
    }
}

