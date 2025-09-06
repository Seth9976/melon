package i5;

import H8.i;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.lifecycle.t;
import coil.memory.MemoryCache.Key;
import coil.request.ImageRequest.Builder;
import d5.m;
import e1.G;
import i.n.i.b.a.s.e.M3;
import ie.r;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import je.p;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;
import okhttp3.HttpUrl;
import q5.a;
import t5.c;
import t5.f;
import t5.s;
import t5.u;
import u5.g;
import w5.d;
import x5.j;
import x5.k;
import x5.l;

public final class n implements e {
    public final Context a;
    public final c b;
    public final r c;
    public final Object d;
    public final Object e;
    public final j f;
    public final k g;
    public final CoroutineScope h;
    public final m i;
    public final b j;
    public final ArrayList k;

    public n(Context context0, c c0, r r0, ie.j j0, ie.j j1, b b0, j j2, k k0) {
        this.a = context0;
        this.b = c0;
        this.c = r0;
        this.d = j0;
        this.e = j1;
        this.f = j2;
        this.g = k0;
        this.h = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()).plus(new i5.m(CoroutineExceptionHandler.Key, this)));
        l l0 = new l(this);
        m m0 = new m(this, l0, k0);
        this.i = m0;
        i i0 = new i(b0);
        i0.f(new a(2), HttpUrl.class);
        i0.f(new a(5), String.class);
        i0.f(new a(1), Uri.class);
        i0.f(new a(4), Uri.class);
        i0.f(new a(3), Integer.class);
        i0.f(new a(0), byte[].class);
        p5.c c1 = new p5.c();  // 初始化器: Ljava/lang/Object;-><init>()V
        ArrayList arrayList0 = (ArrayList)i0.d;
        arrayList0.add(new ie.m(c1, Uri.class));
        arrayList0.add(new ie.m(new p5.a(j2.a), File.class));
        i0.e(new n5.i(j1, j0, j2.c), Uri.class);
        i0.e(new n5.a(5), File.class);
        i0.e(new n5.a(0), Uri.class);
        i0.e(new n5.a(3), Uri.class);
        i0.e(new n5.a(6), Uri.class);
        i0.e(new n5.a(4), Drawable.class);
        i0.e(new n5.a(1), Bitmap.class);
        i0.e(new n5.a(2), ByteBuffer.class);
        k5.c c2 = new k5.c(j2.d, j2.e);
        ArrayList arrayList1 = (ArrayList)i0.f;
        arrayList1.add(c2);
        List list0 = G.H(((ArrayList)i0.b));
        this.j = new b(list0, G.H(((ArrayList)i0.c)), G.H(arrayList0), G.H(((ArrayList)i0.e)), G.H(arrayList1));
        this.k = p.z0(new o5.i(this, l0, m0, k0), list0);
        new AtomicBoolean(false);
    }

    public static final Object a(n n0, t5.j j0, int v, oe.c c0) {
        t5.k k1;
        Object object2;
        n n3;
        t5.r r1;
        t5.j j3;
        i5.c c4;
        Bitmap bitmap1;
        t5.j j2;
        i5.c c3;
        n n2;
        Object object1;
        BitmapDrawable bitmapDrawable0;
        Bitmap bitmap0;
        r5.a a1;
        n n1;
        i5.c c2;
        i5.c c1;
        t5.j j1;
        t5.r r0;
        i5.k k0;
        if(c0 instanceof i5.k) {
            k0 = (i5.k)c0;
            int v1 = k0.M;
            if((v1 & 0x80000000) == 0) {
                k0 = new i5.k(n0, c0);
            }
            else {
                k0.M = v1 ^ 0x80000000;
            }
        }
        else {
            k0 = new i5.k(n0, c0);
        }
        Object object0 = k0.G;
        ne.a a0 = ne.a.a;
        switch(k0.M) {
            case 0: {
                d5.n.D(object0);
                m m0 = n0.i;
                Job job0 = JobKt.getJob(k0.getContext());
                m0.getClass();
                t t0 = j0.x;
                v5.b b0 = j0.c;
                u u0 = b0 instanceof v5.a ? new u(((n)m0.b), j0, ((v5.a)b0), t0, job0) : new t5.a(t0, job0);
                r0 = u0;
                r0.h();
                ImageRequest.Builder imageRequest$Builder0 = t5.j.a(j0);
                imageRequest$Builder0.b = n0.b;
                imageRequest$Builder0.v = null;
                j1 = imageRequest$Builder0.a();
                c1 = i5.c.a;
                try {
                    if(j1.b == t5.l.b) {
                        throw new t5.m("The request\'s data is null.");  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V
                    }
                    r0.start();
                    if(v == 0) {
                        k0.r = n0;
                        k0.w = r0;
                        k0.B = j1;
                        k0.D = c1;
                        k0.M = 1;
                        if(d5.n.l(j1.x, k0) == a0) {
                            return a0;
                        }
                    }
                    goto label_48;
                }
                catch(Throwable throwable0) {
                    goto label_153;
                }
            }
            case 1: {
                try {
                    c2 = k0.D;
                    j1 = k0.B;
                    r0 = k0.w;
                    n1 = k0.r;
                    d5.n.D(object0);
                    c1 = c2;
                    n0 = n1;
                }
                catch(Throwable throwable0) {
                    c1 = c2;
                    n0 = n1;
                    goto label_153;
                }
                try {
                label_48:
                    r5.b b1 = (r5.b)n0.c.getValue();
                    if(b1 == null) {
                        bitmap0 = null;
                    }
                    else {
                        MemoryCache.Key memoryCache$Key0 = j1.B;
                        if(memoryCache$Key0 == null) {
                            a1 = null;
                        }
                        else {
                            a1 = b1.a.a(memoryCache$Key0);
                            if(a1 == null) {
                                a1 = b1.b.a(memoryCache$Key0);
                            }
                        }
                        bitmap0 = a1 == null ? null : a1.a;
                    }
                    if(bitmap0 == null) {
                        j1.D.getClass();
                        bitmapDrawable0 = null;
                    }
                    else {
                        bitmapDrawable0 = new BitmapDrawable(j1.a.getResources(), bitmap0);
                    }
                    v5.b b2 = j1.c;
                    if(b2 != null) {
                        b2.b(bitmapDrawable0);
                    }
                    c1.getClass();
                    t5.i i0 = j1.d;
                    if(i0 != null) {
                        i0.onStart(j1);
                    }
                    k0.r = n0;
                    k0.w = r0;
                    k0.B = j1;
                    k0.D = c1;
                    k0.E = bitmap0;
                    k0.M = 2;
                    object1 = j1.y.c(k0);
                }
                catch(Throwable throwable0) {
                    goto label_153;
                }
                if(object1 == a0) {
                    return a0;
                }
                n2 = n0;
                c3 = c1;
                j2 = j1;
                bitmap1 = bitmap0;
                object0 = object1;
                goto label_110;
            }
            case 2: {
                try {
                    Bitmap bitmap2 = k0.E;
                    c4 = k0.D;
                    j3 = k0.B;
                    r1 = k0.w;
                    n3 = k0.r;
                    d5.n.D(object0);
                    bitmap1 = bitmap2;
                    c3 = c4;
                    j2 = j3;
                    r0 = r1;
                    n2 = n3;
                }
                catch(Throwable throwable0) {
                    c1 = c4;
                    j1 = j3;
                    r0 = r1;
                    n0 = n3;
                    goto label_153;
                }
                try {
                label_110:
                    c3.getClass();
                    c1 = c3;
                    i5.l l0 = new i5.l(j2, n2, ((g)object0), c3, bitmap1, null);
                    c1 = c3;
                    k0.r = n2;
                    k0.w = r0;
                    k0.B = j2;
                    k0.D = c1;
                    k0.E = null;
                    k0.M = 3;
                    object2 = BuildersKt.withContext(j2.t, l0, k0);
                }
                catch(Throwable throwable0) {
                    j1 = j2;
                    n0 = n2;
                    goto label_153;
                }
                if(object2 == a0) {
                    return a0;
                }
                c2 = c1;
                j1 = j2;
                object0 = object2;
                break;
            }
            case 3: {
                try {
                    c2 = k0.D;
                    j1 = k0.B;
                    r0 = k0.w;
                    n1 = k0.r;
                    d5.n.D(object0);
                    n2 = n1;
                    break;
                }
                catch(Throwable throwable0) {
                    c1 = c2;
                    n0 = n1;
                    goto label_153;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            k1 = (t5.k)object0;
            if(k1 instanceof s) {
                n2.e(((s)k1), j1.c, c2);
            }
            else {
                if(!(k1 instanceof f)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                n2.d(((f)k1), j1.c, c2);
            }
            goto label_170;
        }
        catch(Throwable throwable0) {
            c1 = c2;
            n0 = n2;
        }
    label_153:
        try {
            if(throwable0 instanceof CancellationException) {
                if(n0.g != null) {
                    k.a("RealImageLoader", 4, "\uD83C\uDFD7  Cancelled - " + j1.b, null);
                }
                c1.getClass();
                t5.i i1 = j1.d;
                if(i1 != null) {
                    i1.onCancel(j1);
                }
                throw throwable0;
            }
            n0.i.getClass();
            f f0 = m.g(j1, throwable0);
            n0.d(f0, j1.c, c1);
            return f0;
        }
        finally {
            r0.complete();
        }
    label_170:
        r0.complete();
        return k1;
    }

    public final t5.e b(t5.j j0) {
        i5.g g0 = new i5.g(this, null, j0);
        BuildersKt__Builders_commonKt.async$default(this.h, null, null, g0, 3, null);
        v5.b b0 = j0.c;
        return b0 instanceof v5.a ? x5.g.c(((v5.a)b0).b).a() : new t5.n();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    // 去混淆评级： 低(20)
    public final Object c(t5.j j0, oe.c c0) {
        return j0.c instanceof v5.a ? CoroutineScopeKt.coroutineScope(new i5.i(this, null, j0), c0) : BuildersKt.withContext(Dispatchers.getMain().getImmediate(), new i5.j(this, null, j0), c0);
    }

    public final void d(f f0, v5.b b0, i5.c c0) {
        t5.j j0 = f0.b;
        Drawable drawable0 = f0.a;
        if(this.g != null) {
            k.a("RealImageLoader", 4, "\uD83D\uDEA8 Failed - " + j0.b + " - " + f0.c, null);
        }
        if(b0 instanceof w5.g) {
            w5.f f1 = f0.b.j.create(((w5.g)b0), f0);
            if(f1 instanceof d) {
                b0.d(drawable0);
            }
            else {
                c0.getClass();
                f1.a();
            }
        }
        else if(b0 != null) {
            b0.d(drawable0);
        }
        c0.getClass();
        t5.i i0 = j0.d;
        if(i0 != null) {
            i0.onError(j0, f0);
        }
    }

    public final void e(s s0, v5.b b0, i5.c c0) {
        String s1;
        t5.j j0 = s0.b;
        Drawable drawable0 = s0.a;
        k5.g g0 = s0.c;
        if(this.g != null) {
            StringBuilder stringBuilder0 = new StringBuilder();
            switch(g0.ordinal()) {
                case 0: 
                case 1: {
                    s1 = "\uD83E\uDDE0";
                    break;
                }
                case 2: {
                    s1 = "\uD83D\uDCBE";
                    break;
                }
                case 3: {
                    s1 = "☁️ ";
                    break;
                }
                default: {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
            }
            stringBuilder0.append(s1);
            stringBuilder0.append(" Successful (");
            stringBuilder0.append(g0.name());
            stringBuilder0.append(") - ");
            stringBuilder0.append(j0.b);
            k.a("RealImageLoader", 4, stringBuilder0.toString(), null);
        }
        if(b0 instanceof w5.g) {
            w5.f f0 = s0.b.j.create(((w5.g)b0), s0);
            if(f0 instanceof d) {
                b0.a(drawable0);
            }
            else {
                c0.getClass();
                f0.a();
            }
        }
        else if(b0 != null) {
            b0.a(drawable0);
        }
        c0.getClass();
        t5.i i0 = j0.d;
        if(i0 != null) {
            i0.onSuccess(j0, s0);
        }
    }
}

