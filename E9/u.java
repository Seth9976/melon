package E9;

import Df.a;
import Df.c;
import Df.s;
import H8.q;
import Hf.x;
import I6.V;
import I6.p0;
import Je.t;
import Me.e;
import Me.w;
import Pe.A;
import U4.F;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.ColorStateList;
import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.Surface;
import androidx.appcompat.widget.E0;
import androidx.appcompat.widget.a1;
import androidx.compose.foundation.lazy.layout.Z;
import androidx.media3.common.b;
import androidx.media3.session.k1;
import androidx.media3.session.q1;
import androidx.media3.session.t1;
import androidx.media3.session.u1;
import b3.N;
import b3.S;
import b3.m0;
import com.google.android.gms.cloudmessaging.Rpc;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import e1.G;
import java.lang.annotation.Annotation;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import jeb.synthetic.FIN;
import jf.o;
import jf.p;
import k8.Y;
import lf.I;
import lf.T;
import lf.b0;
import lf.h;
import lf.j;
import nf.d;
import nf.f;
import o3.m;
import of.k;
import pf.g;
import s3.z;
import vf.i;
import vf.l;
import vf.v;
import we.n;

public final class u implements a, c {
    public Object a;
    public Object b;
    public Object c;
    public Object d;
    public Object e;
    public Object f;

    public u(int v) {
        if(v != 4) {
            super();
            this.a = new int[]{0x7F080077, 0x7F080075, 0x7F08002B};  // drawable:abc_textfield_search_default_mtrl_alpha
            this.b = new int[]{0x7F080043, 0x7F080066, 0x7F08004A, 0x7F080045, 0x7F080046, 0x7F080049, 0x7F080048};  // drawable:abc_ic_commit_search_api_mtrl_alpha
            this.c = new int[]{0x7F080074, 0x7F080076, 0x7F08003C, 0x7F080070, 0x7F080071, 0x7F080072, 0x7F080073};  // drawable:abc_textfield_activated_mtrl_alpha
            this.d = new int[]{0x7F08005C, 0x7F08003A, 0x7F08005B};  // drawable:abc_popup_background_mtrl_mult
            this.e = new int[]{0x7F08006E, 0x7F080078};  // drawable:abc_tab_indicator_material
            this.f = new int[]{0x7F08002E, 0x7F080034, 0x7F08002F, 0x7F080035};  // drawable:abc_btn_check_material
            return;
        }
        super();
        this.a = k1.F.l(q1.g);
        this.b = t1.b;
        this.c = N.b;
        this.d = p0.e;
        this.e = Bundle.EMPTY;
        this.f = null;
    }

    public u(k1 k10, t1 t10, N n0, V v0, Bundle bundle0, u1 u10) {
        this.a = k10;
        this.b = t10;
        this.c = n0;
        this.d = v0;
        if(bundle0 == null) {
            bundle0 = Bundle.EMPTY;
        }
        this.e = bundle0;
        this.f = u10;
    }

    public u(m m0, MediaFormat mediaFormat0, b b0, Surface surface0, MediaCrypto mediaCrypto0, d5.m m1) {
        this.a = m0;
        this.b = mediaFormat0;
        this.c = b0;
        this.d = surface0;
        this.e = mediaCrypto0;
        this.f = m1;
    }

    // 去混淆评级： 低(30)
    public static boolean A(z z0, Object object0, boolean z1, int v, int v1, int v2) {
        return z0.a.equals(object0) ? z1 && z0.b == v && z0.c == v1 || !z1 && z0.b == -1 && z0.e == v2 : false;
    }

    public q B(qf.b b0, Me.N n0, List list0) {
        kotlin.jvm.internal.q.g(list0, "result");
        e e0 = w.f(((A)this.c), b0, ((com.google.firebase.messaging.u)this.d));
        q q0 = new q();  // 初始化器: Ljava/lang/Object;-><init>()V
        q0.c = this;
        q0.d = e0;
        q0.e = b0;
        q0.f = list0;
        q0.g = n0;
        q0.a = this;
        q0.b = new HashMap();
        return q0;
    }

    public q C(qf.b b0, Re.a a0, List list0) {
        kotlin.jvm.internal.q.g(list0, "result");
        return Ie.a.a.contains(b0) ? null : this.B(b0, a0, list0);
    }

    public Object D(Df.u u0, I i0, int v, x x0, n n0) {
        Re.c c0 = e1.n.w(u0, true, true, d.B.e(i0.d), g.d(i0), ((Re.b)this.a), ((nf.e)this.f));
        if(c0 == null) {
            if(u0 instanceof s) {
                Me.N n1 = (Me.N)((s)u0).d;
                o o0 = n1 instanceof o ? ((o)n1) : null;
                c0 = o0 == null ? null : o0.a;
            }
            else {
                c0 = null;
            }
        }
        if(c0 != null) {
            nf.e e0 = (nf.e)c0.b.e;
            kotlin.jvm.internal.q.g(jf.e.e, "version");
            boolean z = e0.a(jf.e.e.b, jf.e.e.c, jf.e.e.d);
            p p0 = u.w(i0, ((f)u0.b), ((Pe.z)u0.c), v, z);
            if(p0 != null) {
                vf.g g0 = n0.invoke(((Gf.e)this.b).invoke(c0), p0);
                if(g0 != null) {
                    if(t.a(x0)) {
                        if(g0 instanceof vf.d) {
                            return new vf.A(((Number)((vf.d)g0).a).byteValue());
                        }
                        if(g0 instanceof vf.x) {
                            return new vf.A(((Number)((vf.x)g0).a).shortValue());
                        }
                        if(g0 instanceof l) {
                            return new vf.A(((Number)((l)g0).a).intValue());
                        }
                        if(g0 instanceof v) {
                            return new vf.A(((Number)((v)g0).a).longValue());
                        }
                    }
                    return g0;
                }
            }
        }
        return null;
    }

    public List E(Df.u u0, I i0, jf.b b0) {
        Pe.z z0 = (Pe.z)u0.c;
        f f0 = (f)u0.b;
        Boolean boolean0 = d.B.e(i0.d);
        boolean z1 = g.d(i0);
        if(b0 == jf.b.a) {
            p p0 = e1.u.z(i0, f0, z0, 40);
            if(p0 != null) {
                return u.t(this, u0, p0, boolean0, z1, 8);
            }
        }
        else {
            p p1 = e1.u.z(i0, f0, z0, 0x30);
            if(p1 != null) {
                boolean z2 = false;
                boolean z3 = Tf.o.v0(p1.a, "$delegate", false);
                if(b0 == jf.b.c) {
                    z2 = true;
                }
                if(z3 == z2) {
                    return this.s(u0, p1, true, true, boolean0, z1);
                }
            }
        }
        return je.w.a;
    }

    public void F(String s, String s1, Bundle bundle0) {
        String s2;
        int v5;
        String s3;
        bundle0.putString("scope", s1);
        bundle0.putString("sender", s);
        bundle0.putString("subtype", s);
        com.google.firebase.e e0 = (com.google.firebase.e)this.a;
        e0.a();
        bundle0.putString("gmp_app_id", e0.c.b);
        Z z0 = (Z)this.b;
        synchronized(z0) {
            if(z0.a == 0) {
                PackageInfo packageInfo0 = z0.j("com.google.android.gms");
                if(packageInfo0 != null) {
                    z0.a = packageInfo0.versionCode;
                }
            }
        }
        bundle0.putString("gmsv", Integer.toString(z0.a));
        bundle0.putString("osv", "33");
        bundle0.putString("app_ver", ((Z)this.b).h());
        Z z1 = (Z)this.b;
        synchronized(z1) {
            if(((String)z1.e) == null) {
                z1.p();
            }
            s2 = (String)z1.e;
        }
        bundle0.putString("app_ver_name", s2);
        com.google.firebase.e e1 = (com.google.firebase.e)this.a;
        e1.a();
        try {
            s3 = "[HASH-ERROR]";
            s3 = Base64.encodeToString(MessageDigest.getInstance("SHA-1").digest(e1.b.getBytes()), 11);
        }
        catch(NoSuchAlgorithmException unused_ex) {
        }
        bundle0.putString("firebase-app-name-hash", s3);
        try {
            String s4 = ((z7.a)Tasks.await(((z7.c)(((z7.d)this.f))).d())).a;
            if(TextUtils.isEmpty(s4)) {
                Log.w("FirebaseMessaging", "FIS auth token is empty");
            }
            else {
                bundle0.putString("Goog-Firebase-Installations-Auth", s4);
            }
        }
        catch(ExecutionException | InterruptedException executionException0) {
            Log.e("FirebaseMessaging", "Failed to get FIS auth token", executionException0);
        }
        bundle0.putString("appid", ((String)Tasks.await(((z7.c)(((z7.d)this.f))).c())));
        bundle0.putString("cliv", "fcm-24.1.2");
        w7.f f0 = (w7.f)((y7.b)this.e).get();
        G7.b b0 = (G7.b)((y7.b)this.d).get();
        if(f0 != null && b0 != null) {
            __monitor_enter(((w7.c)f0));
            int v2 = FIN.finallyOpen$NT();
            w7.g g0 = (w7.g)((w7.c)f0).a.get();
            synchronized(g0) {
                boolean z2 = g0.g(System.currentTimeMillis());
            }
            if(z2) {
                synchronized(g0) {
                    g0.a.edit().putString("last-used-date", "2025-09-06").commit();
                    g0.f("2025-09-06");
                }
                FIN.finallyCodeBegin$NT(v2);
                __monitor_exit(((w7.c)f0));
                FIN.finallyCodeEnd$NT(v2);
                v5 = 3;
            }
            else {
                FIN.finallyExec$NT(v2);
                v5 = 1;
            }
            if(v5 != 1) {
                bundle0.putString("Firebase-Client-Log-Type", Integer.toString(e0.b.b(v5)));
                bundle0.putString("Firebase-Client", b0.a());
            }
        }
    }

    public static void G(Drawable drawable0, int v, PorterDuff.Mode porterDuff$Mode0) {
        Drawable drawable1 = drawable0.mutate();
        if(porterDuff$Mode0 == null) {
            porterDuff$Mode0 = androidx.appcompat.widget.x.b;
        }
        drawable1.setColorFilter(androidx.appcompat.widget.x.c(v, porterDuff$Mode0));
    }

    public Task H(String s, String s1, Bundle bundle0) {
        try {
            this.F(s, s1, bundle0);
            return ((Rpc)this.c).send(bundle0);
        }
        catch(InterruptedException interruptedException0) {
            return Tasks.forException(interruptedException0);
        }
        catch(ExecutionException interruptedException0) {
            return Tasks.forException(interruptedException0);
        }
    }

    public void I(b3.p0 p00) {
        B7.b b0 = new B7.b(4);
        if(((V)this.b).isEmpty()) {
            this.n(b0, ((z)this.e), p00);
            if(!x1.a.w(((z)this.f), ((z)this.e))) {
                this.n(b0, ((z)this.f), p00);
            }
            if(!x1.a.w(((z)this.d), ((z)this.e)) && !x1.a.w(((z)this.d), ((z)this.f))) {
                this.n(b0, ((z)this.d), p00);
            }
        }
        else {
            for(int v = 0; v < ((V)this.b).size(); ++v) {
                this.n(b0, ((z)((V)this.b).get(v)), p00);
            }
            if(!((V)this.b).contains(((z)this.d))) {
                this.n(b0, ((z)this.d), p00);
            }
        }
        this.c = b0.g();
    }

    @Override  // Df.c
    public List a(Df.u u0, lf.v v0) {
        kotlin.jvm.internal.q.g(u0, "container");
        String s = ((f)u0.b).getString(v0.d);
        String s1 = pf.b.b(((s)u0).g.b());
        kotlin.jvm.internal.q.g(s1, "desc");
        return u.t(this, u0, new p(s + '#' + s1), null, false, 60);
    }

    @Override  // Df.c
    public List b(Df.u u0, rf.a a0, int v, int v1, b0 b00) {
        kotlin.jvm.internal.q.g(a0, "callableProto");
        Y.r(v, "kind");
        p p0 = u.w(a0, ((f)u0.b), ((Pe.z)u0.c), v, false);
        if(p0 != null) {
            if(a0 instanceof lf.A) {
                int v2 = ((lf.A)a0).c;
                return (v2 & 0x20) != 0x20 && (v2 & 0x40) != 0x40 ? u.t(this, u0, new p(p0.a + '@' + v1), null, false, 60) : u.t(this, u0, new p(p0.a + '@' + (v1 + 1)), null, false, 60);
            }
            if(a0 instanceof I) {
                int v3 = ((I)a0).c;
                return (v3 & 0x20) != 0x20 && (v3 & 0x40) != 0x40 ? u.t(this, u0, new p(p0.a + '@' + v1), null, false, 60) : u.t(this, u0, new p(p0.a + '@' + (v1 + 1)), null, false, 60);
            }
            if(!(a0 instanceof lf.n)) {
                throw new UnsupportedOperationException("Unsupported message: " + a0.getClass());
            }
            if(((s)u0).h == j.d) {
                return u.t(this, u0, new p(p0.a + '@' + (v1 + 2)), null, false, 60);
            }
            return ((s)u0).i ? u.t(this, u0, new p(p0.a + '@' + (v1 + 1)), null, false, 60) : u.t(this, u0, new p(p0.a + '@' + v1), null, false, 60);
        }
        return je.w.a;
    }

    @Override  // Df.c
    public ArrayList c(T t0, f f0) {
        kotlin.jvm.internal.q.g(t0, "proto");
        kotlin.jvm.internal.q.g(f0, "nameResolver");
        Object object0 = t0.i(k.f);
        kotlin.jvm.internal.q.f(object0, "getExtension(...)");
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, ((Iterable)object0)));
        for(Object object1: ((Iterable)object0)) {
            kotlin.jvm.internal.q.d(((h)object1));
            arrayList0.add(((x9.b)this.e).j(((h)object1), f0));
        }
        return arrayList0;
    }

    @Override  // Df.c
    public List d(Df.u u0, rf.a a0, int v) {
        kotlin.jvm.internal.q.g(a0, "proto");
        Y.r(v, "kind");
        if(v == 2) {
            return this.E(u0, ((I)a0), jf.b.a);
        }
        p p0 = u.w(a0, ((f)u0.b), ((Pe.z)u0.c), v, false);
        return p0 == null ? je.w.a : u.t(this, u0, p0, null, false, 60);
    }

    @Override  // Df.c
    public List e(Df.u u0, I i0) {
        kotlin.jvm.internal.q.g(i0, "proto");
        return this.E(u0, i0, jf.b.c);
    }

    @Override  // Df.c
    public List f(Df.u u0, I i0) {
        kotlin.jvm.internal.q.g(i0, "proto");
        return this.E(u0, i0, jf.b.b);
    }

    @Override  // Df.c
    public List g(Df.u u0, rf.a a0, int v) {
        kotlin.jvm.internal.q.g(a0, "proto");
        Y.r(v, "kind");
        p p0 = u.w(a0, ((f)u0.b), ((Pe.z)u0.c), v, false);
        return p0 != null ? u.t(this, u0, new p(U4.x.m(new StringBuilder(), p0.a, "@0")), null, false, 60) : je.w.a;
    }

    @Override  // Df.c
    public ArrayList h(lf.Y y0, f f0) {
        kotlin.jvm.internal.q.g(y0, "proto");
        kotlin.jvm.internal.q.g(f0, "nameResolver");
        Object object0 = y0.i(k.h);
        kotlin.jvm.internal.q.f(object0, "getExtension(...)");
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, ((Iterable)object0)));
        for(Object object1: ((Iterable)object0)) {
            kotlin.jvm.internal.q.d(((h)object1));
            arrayList0.add(((x9.b)this.e).j(((h)object1), f0));
        }
        return arrayList0;
    }

    @Override  // Df.a
    public Object i(Df.u u0, I i0, x x0) {
        kotlin.jvm.internal.q.g(i0, "proto");
        return this.D(u0, i0, 2, x0, jf.a.c);
    }

    @Override  // Df.c
    public ArrayList j(s s0) {
        kotlin.jvm.internal.q.g(s0, "container");
        Me.N n0 = (Me.N)s0.d;
        Re.c c0 = null;
        o o0 = n0 instanceof o ? ((o)n0) : null;
        if(o0 != null) {
            c0 = o0.a;
        }
        if(c0 == null) {
            throw new IllegalStateException(("Class for loading annotations is not found: " + s0.g.a()).toString());
        }
        ArrayList arrayList0 = new ArrayList(1);
        kotlin.jvm.internal.q.g(c0.a, "klass");
        c2.Y y0 = kotlin.jvm.internal.q.j(c0.a.getDeclaredAnnotations());
        while(y0.hasNext()) {
            Annotation annotation0 = (Annotation)y0.next();
            kotlin.jvm.internal.q.d(annotation0);
            Class class0 = df.d.v(df.d.s(annotation0));
            q q0 = this.C(Se.c.a(class0), new Re.a(annotation0), arrayList0);
            if(q0 != null) {
                F.R(q0, annotation0, class0);
            }
        }
        return arrayList0;
    }

    @Override  // Df.a
    public Object k(Df.u u0, I i0, x x0) {
        kotlin.jvm.internal.q.g(i0, "proto");
        return this.D(u0, i0, 3, x0, jf.a.b);
    }

    public void l(int v, boolean z) {
        ArrayList arrayList0 = (ArrayList)this.c;
        if(arrayList0.size() > 0) {
            androidx.appcompat.app.o.z(arrayList0.get(0));
            throw null;
        }
    }

    public static final vf.g m(u u0, qf.e e0, Object object0) {
        vf.g g0 = i.b(((A)u0.c), object0);
        if(g0 == null) {
            kotlin.jvm.internal.q.g(("Unsupported annotation argument: " + e0), "message");
            return new vf.k("Unsupported annotation argument: " + e0);
        }
        return g0;
    }

    public void n(B7.b b0, z z0, b3.p0 p00) {
        if(z0 != null) {
            if(p00.b(z0.a) != -1) {
                b0.v(z0, p00);
                return;
            }
            b3.p0 p01 = (b3.p0)((I6.Y)this.c).get(z0);
            if(p01 != null) {
                b0.v(z0, p01);
            }
        }
    }

    public static boolean o(int v, int[] arr_v) {
        for(int v1 = 0; v1 < arr_v.length; ++v1) {
            if(arr_v[v1] == v) {
                return true;
            }
        }
        return false;
    }

    public ArrayList p() {
        synchronized(this.a) {
        }
        return new ArrayList(((ArrayList)this.d));
    }

    public static ColorStateList q(Context context0, int v) {
        int v1 = a1.c(context0, 0x7F040167);  // attr:colorControlHighlight
        int v2 = a1.b(context0, 0x7F040164);  // attr:colorButtonNormal
        int v3 = S1.c.h(v1, v);
        int v4 = S1.c.h(v1, v);
        return new ColorStateList(new int[][]{a1.b, a1.d, a1.c, a1.f}, new int[]{v2, v3, v4, v});
    }

    public Task r(Task task0) {
        return task0.continueWith(new l.a(1), new com.google.firebase.messaging.q(this, 1));
    }

    public List s(Df.u u0, p p0, boolean z, boolean z1, Boolean boolean0, boolean z2) {
        Re.c c0 = e1.n.w(u0, z, z1, boolean0, z2, ((Re.b)this.a), ((nf.e)this.f));
        if(c0 == null) {
            if(u0 instanceof s) {
                Me.N n0 = (Me.N)((s)u0).d;
                o o0 = n0 instanceof o ? ((o)n0) : null;
                c0 = o0 == null ? null : o0.a;
            }
            else {
                c0 = null;
            }
        }
        if(c0 != null) {
            List list0 = (List)((jf.c)((Gf.e)this.b).invoke(c0)).a.get(p0);
            if(list0 != null) {
                return list0;
            }
        }
        return je.w.a;
    }

    public static List t(u u0, Df.u u1, p p0, Boolean boolean0, boolean z, int v) {
        boolean z1 = (v & 4) == 0;
        if((v & 16) != 0) {
            boolean0 = null;
        }
        return (v & 0x20) == 0 ? u0.s(u1, p0, z1, false, boolean0, z) : u0.s(u1, p0, z1, false, boolean0, false);
    }

    public static z u(S s0, V v0, z z0, m0 m00) {
        b3.p0 p00 = s0.getCurrentTimeline();
        int v1 = s0.getCurrentPeriodIndex();
        Object object0 = p00.p() ? null : p00.l(v1);
        int v2 = s0.isPlayingAd() || p00.p() ? -1 : p00.f(v1, m00, false).b(e3.x.M(s0.getCurrentPosition()) - m00.e);
        for(int v3 = 0; v3 < v0.size(); ++v3) {
            z z1 = (z)v0.get(v3);
            if(u.A(z1, object0, s0.isPlayingAd(), s0.getCurrentAdGroupIndex(), s0.getCurrentAdIndexInAdGroup(), v2)) {
                return z1;
            }
        }
        return !v0.isEmpty() || z0 == null || !u.A(z0, object0, s0.isPlayingAd(), s0.getCurrentAdGroupIndex(), s0.getCurrentAdIndexInAdGroup(), v2) ? null : z0;
    }

    public void v() {
        ((ArrayList)this.c).clear();
        ((ArrayList)this.d).clear();
        ArrayList arrayList0 = (ArrayList)this.e;
        Iterator iterator0 = arrayList0.iterator();
        if(iterator0.hasNext()) {
            throw H0.b.b(iterator0);
        }
        arrayList0.clear();
    }

    public static p w(rf.a a0, f f0, Pe.z z0, int v, boolean z1) {
        kotlin.jvm.internal.q.g(a0, "proto");
        kotlin.jvm.internal.q.g(f0, "nameResolver");
        Y.r(v, "kind");
        if(a0 instanceof lf.n) {
            pf.e e0 = g.a(((lf.n)a0), f0, z0);
            return e0 == null ? null : e2.a.D(e0);
        }
        if(a0 instanceof lf.A) {
            pf.e e1 = g.c(((lf.A)a0), f0, z0);
            return e1 == null ? null : e2.a.D(e1);
        }
        if(a0 instanceof I) {
            kotlin.jvm.internal.q.f(k.d, "propertySignature");
            of.e e2 = (of.e)e1.x.G(((rf.j)a0), k.d);
            if(e2 != null) {
                switch(e0.b.b(v)) {
                    case 1: {
                        return e1.u.y(((I)a0), f0, z0, true, true, z1);
                    }
                    case 2: {
                        if(e2.g()) {
                            of.c c1 = e2.e;
                            kotlin.jvm.internal.q.f(c1, "getGetter(...)");
                            return new p(f0.getString(c1.c) + f0.getString(c1.d));
                        }
                        break;
                    }
                    case 3: {
                        if((e2.b & 8) == 8) {
                            of.c c0 = e2.f;
                            kotlin.jvm.internal.q.f(c0, "getSetter(...)");
                            return new p(f0.getString(c0.c) + f0.getString(c0.d));
                        }
                        return null;
                    }
                    default: {
                        return null;
                    }
                }
            }
        }
        return null;
    }

    public static LayerDrawable x(E0 e00, Context context0, int v) {
        BitmapDrawable bitmapDrawable2;
        BitmapDrawable bitmapDrawable1;
        BitmapDrawable bitmapDrawable0;
        int v1 = context0.getResources().getDimensionPixelSize(v);
        Drawable drawable0 = e00.c(context0, 0x7F08006A);  // drawable:abc_star_black_48dp
        Drawable drawable1 = e00.c(context0, 0x7F08006B);  // drawable:abc_star_half_black_48dp
        if(!(drawable0 instanceof BitmapDrawable) || drawable0.getIntrinsicWidth() != v1 || drawable0.getIntrinsicHeight() != v1) {
            Bitmap bitmap0 = Bitmap.createBitmap(v1, v1, Bitmap.Config.ARGB_8888);
            Canvas canvas0 = new Canvas(bitmap0);
            drawable0.setBounds(0, 0, v1, v1);
            drawable0.draw(canvas0);
            bitmapDrawable0 = new BitmapDrawable(bitmap0);
            bitmapDrawable1 = new BitmapDrawable(bitmap0);
        }
        else {
            bitmapDrawable0 = (BitmapDrawable)drawable0;
            bitmapDrawable1 = new BitmapDrawable(bitmapDrawable0.getBitmap());
        }
        bitmapDrawable1.setTileModeX(Shader.TileMode.REPEAT);
        if(!(drawable1 instanceof BitmapDrawable) || drawable1.getIntrinsicWidth() != v1 || drawable1.getIntrinsicHeight() != v1) {
            Bitmap bitmap1 = Bitmap.createBitmap(v1, v1, Bitmap.Config.ARGB_8888);
            Canvas canvas1 = new Canvas(bitmap1);
            drawable1.setBounds(0, 0, v1, v1);
            drawable1.draw(canvas1);
            bitmapDrawable2 = new BitmapDrawable(bitmap1);
        }
        else {
            bitmapDrawable2 = (BitmapDrawable)drawable1;
        }
        LayerDrawable layerDrawable0 = new LayerDrawable(new Drawable[]{bitmapDrawable0, bitmapDrawable2, bitmapDrawable1});
        layerDrawable0.setId(0, 0x1020000);
        layerDrawable0.setId(1, 0x102000F);
        layerDrawable0.setId(2, 0x102000D);
        return layerDrawable0;
    }

    public ColorStateList y(Context context0, int v) {
        switch(v) {
            case 0x7F08002D: {  // drawable:abc_btn_borderless_material
                return u.q(context0, 0);
            }
            case 0x7F080032: {  // drawable:abc_btn_colored_material
                return u.q(context0, a1.c(context0, 0x7F040162));  // attr:colorAccent
            }
            case 0x7F080033: {  // drawable:abc_btn_default_mtrl_shape
                return u.q(context0, a1.c(context0, 0x7F040164));  // attr:colorButtonNormal
            }
            case 0x7F08003F: {  // drawable:abc_edit_text_material
                return P1.c.getColorStateList(context0, 0x7F060015);  // color:abc_tint_edittext
            }
            case 0x7F080068:   // drawable:abc_spinner_mtrl_am_alpha
            case 0x7F080069: {  // drawable:abc_spinner_textfield_background_material
                return P1.c.getColorStateList(context0, 0x7F060017);  // color:abc_tint_spinner
            }
            case 0x7F08006C: {  // drawable:abc_switch_thumb_material
                int[][] arr2_v = new int[3][];
                int[] arr_v = new int[3];
                ColorStateList colorStateList0 = a1.d(context0, 0x7F04019A);  // attr:colorSwitchThumbNormal
                if(colorStateList0 != null && colorStateList0.isStateful()) {
                    arr2_v[0] = a1.b;
                    arr_v[0] = colorStateList0.getColorForState(a1.b, 0);
                    arr2_v[1] = a1.e;
                    arr_v[1] = a1.c(context0, 0x7F040166);  // attr:colorControlActivated
                    arr2_v[2] = a1.f;
                    arr_v[2] = colorStateList0.getDefaultColor();
                    return new ColorStateList(arr2_v, arr_v);
                }
                arr2_v[0] = a1.b;
                arr_v[0] = a1.b(context0, 0x7F04019A);  // attr:colorSwitchThumbNormal
                arr2_v[1] = a1.e;
                arr_v[1] = a1.c(context0, 0x7F040166);  // attr:colorControlActivated
                arr2_v[2] = a1.f;
                arr_v[2] = a1.c(context0, 0x7F04019A);  // attr:colorSwitchThumbNormal
                return new ColorStateList(arr2_v, arr_v);
            }
            case 0x7F08006D: {  // drawable:abc_switch_track_mtrl_alpha
                return P1.c.getColorStateList(context0, 0x7F060018);  // color:abc_tint_switch_track
            }
            default: {
                if(u.o(v, ((int[])this.b))) {
                    return a1.d(context0, 0x7F040168);  // attr:colorControlNormal
                }
                if(u.o(v, ((int[])this.e))) {
                    return P1.c.getColorStateList(context0, 0x7F060014);  // color:abc_tint_default
                }
                if(u.o(v, ((int[])this.f))) {
                    return P1.c.getColorStateList(context0, 0x7F060013);  // color:abc_tint_btn_checkable
                }
                return v == 0x7F080065 ? P1.c.getColorStateList(context0, 0x7F060016) : null;  // drawable:abc_seekbar_thumb_material
            }
        }
    }

    public boolean z(qf.b b0) {
        if(b0.e() != null && kotlin.jvm.internal.q.b(b0.f().b(), "Container")) {
            Re.c c0 = G.q(((Re.b)this.a), b0, ((nf.e)this.f));
            if(c0 != null) {
                kotlin.jvm.internal.q.g(c0.a, "klass");
                boolean z = false;
                c2.Y y0 = kotlin.jvm.internal.q.j(c0.a.getDeclaredAnnotations());
                while(y0.hasNext()) {
                    Annotation annotation0 = (Annotation)y0.next();
                    kotlin.jvm.internal.q.d(annotation0);
                    if(Se.c.a(df.d.v(df.d.s(annotation0))).equals(Ze.u.b)) {
                        z = true;
                    }
                }
                return z;
            }
        }
        return false;
    }
}

