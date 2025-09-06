package e1;

import Ac.g1;
import Ac.h1;
import Ac.i1;
import Bc.h;
import Cc.C3;
import Cc.G2;
import Cc.N1;
import Cc.U;
import Cc.c1;
import Cc.e0;
import Cc.n3;
import Cc.x0;
import Dd.k2;
import Hf.B;
import Hf.I;
import Hf.M;
import Hf.P;
import Hf.b0;
import Hf.c;
import Hf.w;
import M.j0;
import M.p0;
import Ma.n;
import Me.Q;
import Me.S;
import Me.e;
import N0.g0;
import Pe.C;
import Q0.C0;
import Q0.Q0;
import Q0.k0;
import Q0.w0;
import Tf.v;
import U4.F;
import Vc.N;
import X0.a;
import X0.k;
import X0.p;
import a1.T;
import a1.g;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.hardware.display.DisplayManager;
import android.media.MediaDrm;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.LongSparseArray;
import android.view.Display;
import android.view.translation.TranslationResponseValue;
import android.view.translation.ViewTranslationResponse;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.runtime.E;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.n0;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.iloen.melon.custom.B1;
import com.iloen.melon.custom.l1;
import com.iloen.melon.utils.Navigator;
import d5.t;
import ed.D;
import gd.B2;
import gd.J0;
import gd.M0;
import gd.d1;
import gd.e1;
import gd.f1;
import gd.f5;
import gd.h5;
import gd.j5;
import gd.l3;
import gd.m3;
import gd.o3;
import gd.p3;
import gd.q3;
import h7.u0;
import i.n.i.b.a.s.e.M3;
import i3.i;
import ie.H;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import jd.b2;
import je.u;
import jf.f;
import jf.r;
import k5.s;
import k8.o;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import m1.q;
import rf.j;
import rf.l;
import t0.b;
import t0.d;
import x1.m;

public abstract class x {
    public static final int a;
    public static final int b;
    public static final int c;

    public static void A(d d0, LongSparseArray longSparseArray0) {
        int v = longSparseArray0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            long v2 = longSparseArray0.keyAt(v1);
            ViewTranslationResponse viewTranslationResponse0 = i.o(longSparseArray0.get(v2));
            if(viewTranslationResponse0 != null) {
                TranslationResponseValue translationResponseValue0 = b.e(viewTranslationResponse0);
                if(translationResponseValue0 != null) {
                    CharSequence charSequence0 = b.f(translationResponseValue0);
                    if(charSequence0 != null) {
                        Q0 q00 = (Q0)d0.d().b(((int)v2));
                        if(q00 != null) {
                            p p0 = q00.a;
                            if(p0 != null) {
                                Object object0 = p0.d.a.g(k.k);
                                if(object0 == null) {
                                    object0 = null;
                                }
                                if(((a)object0) != null) {
                                    we.k k0 = (we.k)((a)object0).b;
                                    if(k0 != null) {
                                        Boolean boolean0 = (Boolean)k0.invoke(new g(charSequence0.toString()));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static boolean B(Context context0) {
        DisplayManager displayManager0 = (DisplayManager)context0.getSystemService("display");
        Display display0 = displayManager0 == null ? null : displayManager0.getDisplay(0);
        if(display0 != null && display0.isHdr()) {
            int[] arr_v = display0.getHdrCapabilities().getSupportedHdrTypes();
            for(int v = 0; v < arr_v.length; ++v) {
                if(arr_v[v] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void C(Uri uri0) {
        boolean z = v.j0(uri0.getQueryParameter("home"), "Y", true);
        String s = uri0.getPath();
        if(s != null) {
            switch(s) {
                case "/library": {
                    Navigator.INSTANCE.openMainLibrary(z, z);
                    return;
                }
                case "/music": {
                    Navigator.INSTANCE.openMainMusic(z, z);
                    return;
                }
                case "/search": {
                    Navigator.INSTANCE.openMainSearch(z, z);
                    break;
                }
                case "/shortcut": {
                    Navigator.INSTANCE.openMainMenu(z, z);
                    return;
                }
                case "/station": {
                    Navigator.INSTANCE.openMainForu(z, z);
                }
            }
        }
    }

    public static final ArrayList D(List list0, we.k k0) {
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: list0) {
            q q0 = (q)object0;
            ArrayList arrayList1 = x.D(q0.e, k0);
            ArrayList arrayList2 = new ArrayList();
            for(Object object1: arrayList1) {
                q q1 = (q)object1;
                List list1 = q1.d == null ? q1.e : e.k.z(q1);
                u.U(arrayList2, list1);
            }
            u.U(arrayList0, (((Boolean)k0.invoke(q0)).booleanValue() ? e.k.z(new q(q0.a, q0.b, q0.c, q0.d, arrayList2, q0.f)) : e.k.z(new q("<root>", -1, r1.k.e, null, arrayList2, null))));
        }
        return arrayList0;
    }

    public static final int E(Bitmap bitmap0) {
        if(!bitmap0.isRecycled()) {
            try {
                return bitmap0.getAllocationByteCount();
            }
            catch(Exception unused_ex) {
                int v = bitmap0.getWidth();
                int v1 = bitmap0.getHeight();
                Bitmap.Config bitmap$Config0 = bitmap0.getConfig();
                if(bitmap$Config0 == Bitmap.Config.ALPHA_8) {
                    return v1 * v;
                }
                if(bitmap$Config0 != Bitmap.Config.RGB_565 && bitmap$Config0 != Bitmap.Config.ARGB_4444) {
                    return bitmap$Config0 == Bitmap.Config.RGBA_F16 ? v1 * v * 8 : v1 * v * 4;
                }
                return v1 * v * 2;
            }
        }
        throw new IllegalStateException(("Cannot obtain size for recycled bitmap: " + bitmap0 + " [" + bitmap0.getWidth() + " x " + bitmap0.getHeight() + "] + " + bitmap0.getConfig()).toString());
    }

    public static y F() {
        return y.i;
    }

    public static final Object G(j j0, l l0) {
        kotlin.jvm.internal.q.g(j0, "<this>");
        kotlin.jvm.internal.q.g(l0, "extension");
        return j0.j(l0) ? j0.i(l0) : null;
    }

    public static final Object H(j j0, l l0, int v) {
        kotlin.jvm.internal.q.g(j0, "<this>");
        kotlin.jvm.internal.q.g(l0, "extension");
        j0.m(l0);
        rf.k k0 = l0.d;
        j0.a.getClass();
        rf.y y0 = j0.a.a;
        if(!k0.c) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        Object object0 = y0.get(k0);
        if(v < (object0 == null ? 0 : ((List)object0).size())) {
            j0.m(l0);
            if(!k0.c) {
                throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
            }
            Object object1 = y0.get(k0);
            if(object1 == null) {
                throw new IndexOutOfBoundsException();
            }
            return l0.a(((List)object1).get(v));
        }
        return null;
    }

    public static final h I(androidx.compose.runtime.l l0) {
        ((androidx.compose.runtime.p)l0).a0(0x15B95C77);
        if(((Boolean)((androidx.compose.runtime.p)l0).k(w0.a)).booleanValue()) {
            ((androidx.compose.runtime.p)l0).a0(0xDB12F70);
            ((androidx.compose.runtime.p)l0).p(false);
            ((androidx.compose.runtime.p)l0).p(false);
            return null;
        }
        ((androidx.compose.runtime.p)l0).a0(229752094);
        Context context0 = (Context)((androidx.compose.runtime.p)l0).k(AndroidCompositionLocals_androidKt.b);
        h h0 = ((androidx.compose.runtime.p)l0).N();
        if(h0 == androidx.compose.runtime.k.a) {
            kotlin.jvm.internal.q.g(context0, "context");
            Context context1 = context0.getApplicationContext();
            kotlin.jvm.internal.q.d(context1);
            h0 = ((o)(((n)com.google.firebase.b.B(context1, n.class)))).j();
            ((androidx.compose.runtime.p)l0).l0(h0);
        }
        ((androidx.compose.runtime.p)l0).p(false);
        ((androidx.compose.runtime.p)l0).p(false);
        return h0;
    }

    public static final Object J(Hf.x x0, r r0, we.o o0) {
        jf.i i2;
        boolean z1;
        jf.j j0;
        f f0 = f.d;
        kotlin.jvm.internal.q.g(x0, "kotlinType");
        boolean z = r0.c;
        kotlin.jvm.internal.q.g(o0, "writeGenericType");
        if(u0.J(x0)) {
            u0.J(x0);
            Je.i i0 = F.u(x0);
            Ne.h h0 = x0.getAnnotations();
            Hf.x x1 = u0.D(x0);
            List list0 = u0.A(x0);
            Iterable iterable0 = u0.F(x0);
            ArrayList arrayList0 = new ArrayList(je.q.Q(10, iterable0));
            for(Object object0: iterable0) {
                arrayList0.add(((P)object0).b());
            }
            I.b.getClass();
            M m0 = Je.q.a.q();
            u0.H(x0);
            Hf.x x2 = ((P)je.p.s0(x0.r())).b();
            kotlin.jvm.internal.q.f(x2, "getType(...)");
            List list1 = e.k.z(F.j(x2));
            ArrayList arrayList1 = je.p.z0(c.u(I.c, m0, list1, false), arrayList0);
            B b0 = F.u(x0).p();
            kotlin.jvm.internal.q.f(b0, "getNullableAnyType(...)");
            return x.J(u0.t(i0, h0, x1, list0, arrayList1, b0, false).V(x0.D()), r0, o0);
        }
        B b1 = If.g.h(x0);
        if(b1 == null) {
            Hf.p p0 = If.g.g(x0);
            if(p0 == null) {
                b1 = If.g.h(x0);
                kotlin.jvm.internal.q.d(b1);
            }
            else {
                b1 = If.g.N(p0);
                if(b1 == null) {
                    b1 = If.g.h(x0);
                    kotlin.jvm.internal.q.d(b1);
                }
            }
        }
        M m1 = If.g.V(b1);
        jf.k k0 = null;
        if(If.g.y(m1)) {
            kotlin.jvm.internal.q.g(m1, "$receiver");
            if(!(m1 instanceof M)) {
                goto label_123;
            }
            Me.h h1 = m1.e();
            kotlin.jvm.internal.q.e(h1, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            Je.k k1 = Je.i.u(((e)h1));
            if(k1 == null) {
                kotlin.jvm.internal.q.g(m1, "$receiver");
                if(!(m1 instanceof M)) {
                    goto label_118;
                }
                Me.h h2 = m1.e();
                kotlin.jvm.internal.q.e(h2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                Je.k k2 = Je.i.s(((e)h2));
                if(k2 == null) {
                    kotlin.jvm.internal.q.g(m1, "$receiver");
                    if(!(m1 instanceof M)) {
                        goto label_113;
                    }
                    Me.h h3 = m1.e();
                    if(h3 != null && Je.i.J(h3)) {
                        kotlin.jvm.internal.q.g(m1, "$receiver");
                        if(!(m1 instanceof M)) {
                            goto label_108;
                        }
                        Me.h h4 = m1.e();
                        kotlin.jvm.internal.q.e(h4, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                        qf.b b2 = Le.d.f(xf.d.h(((e)h4)));
                        if(b2 != null) {
                            if(!r0.g) {
                                Iterable iterable1 = Le.d.n;
                                if(!(iterable1 instanceof Collection) || !((Collection)iterable1).isEmpty()) {
                                    for(Object object1: iterable1) {
                                        if(!((Le.c)object1).a.equals(b2)) {
                                            continue;
                                        }
                                        goto label_128;
                                    }
                                }
                            }
                            k0 = f.d(yf.b.e(b2));
                            goto label_128;
                        label_108:
                            StringBuilder stringBuilder1 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
                            stringBuilder1.append(m1);
                            stringBuilder1.append(", ");
                            Class class0 = m1.getClass();
                            throw new IllegalArgumentException(H0.b.l(kotlin.jvm.internal.I.a, class0, stringBuilder1).toString());
                        label_113:
                            StringBuilder stringBuilder2 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
                            stringBuilder2.append(m1);
                            stringBuilder2.append(", ");
                            Class class1 = m1.getClass();
                            throw new IllegalArgumentException(H0.b.l(kotlin.jvm.internal.I.a, class1, stringBuilder2).toString());
                        label_118:
                            StringBuilder stringBuilder3 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
                            stringBuilder3.append(m1);
                            stringBuilder3.append(", ");
                            Class class2 = m1.getClass();
                            throw new IllegalArgumentException(H0.b.l(kotlin.jvm.internal.I.a, class2, stringBuilder3).toString());
                        label_123:
                            StringBuilder stringBuilder4 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
                            stringBuilder4.append(m1);
                            stringBuilder4.append(", ");
                            Class class3 = m1.getClass();
                            throw new IllegalArgumentException(H0.b.l(kotlin.jvm.internal.I.a, class3, stringBuilder4).toString());
                        }
                    }
                }
                else {
                    StringBuilder stringBuilder0 = new StringBuilder("[");
                    yf.c c0 = (yf.c)yf.c.n.get(k2);
                    if(c0 != null) {
                        stringBuilder0.append(c0.c());
                        k0 = f.c(stringBuilder0.toString());
                        goto label_128;
                    }
                    yf.c.a(6);
                    throw null;
                }
            }
            else {
                switch(k1.ordinal()) {
                    case 0: {
                        j0 = jf.k.a;
                        break;
                    }
                    case 1: {
                        j0 = jf.k.b;
                        break;
                    }
                    case 2: {
                        j0 = jf.k.c;
                        break;
                    }
                    case 3: {
                        j0 = jf.k.d;
                        break;
                    }
                    case 4: {
                        j0 = jf.k.e;
                        break;
                    }
                    case 5: {
                        j0 = jf.k.f;
                        break;
                    }
                    case 6: {
                        j0 = jf.k.g;
                        break;
                    }
                    case 7: {
                        j0 = jf.k.h;
                        break;
                    }
                    default: {
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                }
                if(If.g.H(x0)) {
                    z1 = true;
                }
                else {
                    kotlin.jvm.internal.q.f(Ze.v.p, "ENHANCED_NULLABILITY_ANNOTATION");
                    z1 = If.g.u(x0, Ze.v.p);
                }
                k0 = t.d(j0, z1);
            }
        }
    label_128:
        if(k0 != null) {
            Object object2 = t.d(k0, r0.a);
            o0.invoke(x0, object2, r0);
            return object2;
        }
        M m2 = x0.w();
        if(m2 instanceof w) {
            Hf.x x3 = ((w)m2).a;
            if(x3 != null) {
                return x.J(F.T(x3), r0, o0);
            }
            kotlin.jvm.internal.q.g(((w)m2).b, "types");
            throw new AssertionError("There should be no intersection type in existing descriptors, but found: " + je.p.q0(((w)m2).b, null, null, null, null, 0x3F));
        }
        Me.h h5 = m2.e();
        if(h5 == null) {
            throw new UnsupportedOperationException("no descriptor for type constructor of " + x0);
        }
        if(Jf.l.f(h5)) {
            jf.i i1 = f.d("error/NonExistentClass");
            e e0 = (e)h5;
            return i1;
        }
        if(h5 instanceof e && Je.i.z(x0)) {
            if(x0.r().size() != 1) {
                throw new UnsupportedOperationException("arrays must have one type argument");
            }
            P p1 = (P)x0.r().get(0);
            Hf.x x4 = p1.b();
            kotlin.jvm.internal.q.f(x4, "getType(...)");
            if(p1.a() == b0.d) {
                return f.c("[Ljava/lang/Object;");
            }
            b0 b00 = p1.a();
            kotlin.jvm.internal.q.f(b00, "getProjectionKind(...)");
            if(!z) {
                switch(b00.ordinal()) {
                    case 0: {
                        return r0.i == null ? f.c(("[" + f.h(x.J(x4, r0, o0)))) : f.c(("[" + f.h(x.J(x4, r0.i, o0))));
                    }
                    case 1: {
                        return r0.h == null ? f.c(("[" + f.h(x.J(x4, r0, o0)))) : f.c(("[" + f.h(x.J(x4, r0.h, o0))));
                    }
                    default: {
                        return r0.f == null ? f.c(("[" + f.h(x.J(x4, r0, o0)))) : f.c(("[" + f.h(x.J(x4, r0.f, o0))));
                    }
                }
            }
            return f.c(("[" + f.h(x.J(x4, r0, o0))));
        }
        if(h5 instanceof e) {
            if(tf.g.b(h5) && !r0.b) {
                Hf.x x5 = (Hf.x)c.d(x0, new HashSet());
                if(x5 != null) {
                    return x.J(x5, new r(r0.a, true, r0.c, r0.d, r0.e, r0.f, r0.g, r0.h, r0.i, 0x200), o0);
                }
            }
            if(!z || !Je.i.b(((e)h5), Je.o.Q)) {
                e e1 = (e)h5;
                kotlin.jvm.internal.q.f(e1.a(), "getOriginal(...)");
                if(e1.getKind() == Me.f.d) {
                    Me.k k3 = e1.e();
                    kotlin.jvm.internal.q.e(k3, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    e1 = (e)k3;
                }
                e e2 = e1.a();
                kotlin.jvm.internal.q.f(e2, "getOriginal(...)");
                i2 = f.d(x.z(e2, f0));
            }
            else {
                i2 = f.d("java/lang/Class");
            }
            o0.invoke(x0, i2, r0);
            return i2;
        }
        if(h5 instanceof S) {
            Hf.x x6 = F.B(((S)h5));
            if(x0.D()) {
                x6 = F.N(x6);
            }
            return x.J(x6, r0, Qf.c.a);
        }
        if(!(h5 instanceof Q) || !r0.j) {
            throw new UnsupportedOperationException("Unknown type " + x0);
        }
        return x.J(((Ff.v)(((Q)h5))).u1(), r0, o0);
    }

    public static Typeface K(Configuration configuration0, Typeface typeface0) {
        return Build.VERSION.SDK_INT < 0x1F || (configuration0.fontWeightAdjustment == 0 || configuration0.fontWeightAdjustment == 0x7FFFFFFF) || typeface0 == null ? null : com.iloen.melon.utils.system.a.h(typeface0, E9.h.r(configuration0.fontWeightAdjustment + s.a(typeface0), 1, 1000), typeface0.isItalic());
    }

    public static long L(d5.e e0) {
        String s1;
        String s = ((mg.d)e0.c).a.b("TIMEOUT");
        if(s == null) {
            s1 = null;
        }
        else {
            Locale locale0 = Locale.ENGLISH;
            kotlin.jvm.internal.q.f(locale0, "Locale.ENGLISH");
            s1 = s.toLowerCase(locale0);
            kotlin.jvm.internal.q.f(s1, "(this as java.lang.String).toLowerCase(locale)");
        }
        if(s1 != null && s1.length() != 0 && !Tf.o.v0(s1, "infinite", false)) {
            int v = Tf.o.F0(s1, "second-", 0, false, 6);
            if(v < 0) {
                return kg.r.e;
            }
            String s2 = s1.substring(v + 7);
            kotlin.jvm.internal.q.f(s2, "(this as java.lang.String).substring(startIndex)");
            Long long0 = v.u0(s2);
            return long0 == null ? kg.r.e : TimeUnit.SECONDS.toMillis(((long)long0));
        }
        return kg.r.e;
    }

    public static p2.b M(String s, m2.a a0, com.iloen.melon.utils.datastore.a a1, int v) {
        if((v & 2) != 0) {
            a0 = null;
        }
        if((v & 4) != 0) {
            a1 = p2.a.f;
        }
        CoroutineScope coroutineScope0 = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        kotlin.jvm.internal.q.g(coroutineScope0, "scope");
        return new p2.b(s, a0, a1, coroutineScope0);
    }

    public static final String N(List list0, int v, we.k k0) {
        String s = v.n0(v, ".");
        StringBuilder stringBuilder0 = new StringBuilder();
        for(Object object0: je.p.J0(x.D(list0, k0), e1.b.q(new we.k[]{m1.p.i, m1.p.j, m1.p.k}))) {
            q q0 = (q)object0;
            if(q0.d == null) {
                stringBuilder0.append(s + "|<root>");
            }
            else {
                stringBuilder0.append(s + '|' + q0.a + ':' + q0.b);
            }
            stringBuilder0.append('\n');
            String s1 = Tf.o.e1(x.N(q0.e, v + 1, k0)).toString();
            if(s1.length() > 0) {
                stringBuilder0.append(s1);
                stringBuilder0.append('\n');
            }
        }
        return stringBuilder0.toString();
    }

    public static final long O(long v, long v1) {
        int v2 = T.e(v);
        int v3 = T.d(v);
        int v4 = 0;
        if(((T.e(v1) >= T.d(v) ? 0 : 1) & (T.e(v) >= T.d(v1) ? 0 : 1)) != 0) {
            if(((T.e(v1) > T.e(v) ? 0 : 1) & (T.d(v) > T.d(v1) ? 0 : 1)) != 0) {
                v2 = T.e(v1);
                return a1.t.b(v2, v2);
            }
            int v5 = T.e(v) > T.e(v1) ? 0 : 1;
            if(T.d(v1) <= T.d(v)) {
                v4 = 1;
            }
            if((v5 & v4) != 0) {
                return a1.t.b(v2, v3 - T.c(v1));
            }
            return v2 >= T.d(v1) || T.e(v1) > v2 ? a1.t.b(v2, T.e(v1)) : a1.t.b(T.e(v1), v3 - T.c(v1));
        }
        return v3 <= T.e(v1) ? a1.t.b(v2, v3) : a1.t.b(v2 - T.c(v1), v3 - T.c(v1));
    }

    public static final void a(androidx.compose.runtime.l l0, int v) {
        ((androidx.compose.runtime.p)l0).c0(0x809BFDC);
        if(((androidx.compose.runtime.p)l0).Q(v & 1, v != 0)) {
            M.p.a(androidx.compose.foundation.q.f(androidx.compose.foundation.layout.d.n(androidx.compose.foundation.layout.a.n(r0.n.a, 0.0f, 6.0f, 8.0f, 0.0f, 9), 3.0f), e0.T(((androidx.compose.runtime.p)l0), 0x7F060159), T.e.a), ((androidx.compose.runtime.p)l0), 0);  // color:gray400s_support_high_contrast
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
        }
        n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new B1(v, 25);
        }
    }

    public static final void b(we.a a0, androidx.compose.runtime.l l0, int v) {
        androidx.compose.runtime.p p0;
        kotlin.jvm.internal.q.g(a0, "onClickClose");
        ((androidx.compose.runtime.p)l0).c0(-1009160393);
        int v1 = (v & 6) == 0 ? (((androidx.compose.runtime.p)l0).i(a0) ? 4 : 2) | v : v;
        if(((androidx.compose.runtime.p)l0).Q(v1 & 1, (v1 & 3) != 2)) {
            r0.n n0 = r0.n.a;
            r0.q q0 = r0.a.a(androidx.compose.foundation.layout.d.n(n0, 48.0f), new D(18, a0));
            N0.M m0 = M.p.d(r0.d.a, false);
            int v2 = ((androidx.compose.runtime.p)l0).P;
            i0 i00 = ((androidx.compose.runtime.p)l0).m();
            r0.q q1 = r0.a.d(((androidx.compose.runtime.p)l0), q0);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
            ((androidx.compose.runtime.p)l0).e0();
            if(((androidx.compose.runtime.p)l0).O) {
                ((androidx.compose.runtime.p)l0).l(i0);
            }
            else {
                ((androidx.compose.runtime.p)l0).o0();
            }
            androidx.compose.runtime.w.x(((androidx.compose.runtime.p)l0), m0, P0.j.f);
            androidx.compose.runtime.w.x(((androidx.compose.runtime.p)l0), i00, P0.j.e);
            P0.h h0 = P0.j.g;
            if(((androidx.compose.runtime.p)l0).O || !kotlin.jvm.internal.q.b(((androidx.compose.runtime.p)l0).N(), v2)) {
                A7.d.q(v2, ((androidx.compose.runtime.p)l0), v2, h0);
            }
            androidx.compose.runtime.w.x(((androidx.compose.runtime.p)l0), q1, P0.j.d);
            r0.q q2 = androidx.compose.foundation.layout.d.n(n0, 34.0f);
            c1.n((androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q2, r0.d.e), 0x7F080230, H0.e.Y(((androidx.compose.runtime.p)l0), 0x7F1301D2), null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, ((androidx.compose.runtime.p)l0), 0x6030, 0, 0x7FE8);  // drawable:btn_player_gnb_down
            p0 = (androidx.compose.runtime.p)l0;
            p0.p(true);
        }
        else {
            p0 = (androidx.compose.runtime.p)l0;
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new x0(v, 3, a0);
        }
    }

    public static final void c(r0.q q0, we.a a0, androidx.compose.runtime.l l0, int v) {
        kotlin.jvm.internal.q.g(q0, "modifier");
        kotlin.jvm.internal.q.g(a0, "onClick");
        ((androidx.compose.runtime.p)l0).c0(-1100333139);
        int v1 = (v & 6) == 0 ? (((androidx.compose.runtime.p)l0).g(q0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (((androidx.compose.runtime.p)l0).i(a0) ? 0x20 : 16);
        }
        if(((androidx.compose.runtime.p)l0).Q(v1 & 1, (v1 & 19) != 18)) {
            c1.n(r0.a.a(androidx.compose.foundation.layout.d.n(q0, E9.h.t(((androidx.compose.runtime.p)l0), 0x7F070409)), new D(19, a0)), 0x7F0801B8, H0.e.Y(((androidx.compose.runtime.p)l0), 0x7F130BC0), N0.j.f, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, ((androidx.compose.runtime.p)l0), 0x6C30, 0, 0x7FE0);  // dimen:player_bottom_default_button_size
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
        }
        n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new qd.j(q0, a0, v, 0);
        }
    }

    public static final void d(r0.q q0, String s, we.a a0, androidx.compose.runtime.l l0, int v) {
        kotlin.jvm.internal.q.g(s, "connectDeviceName");
        ((androidx.compose.runtime.p)l0).c0(0x14437BF2);
        int v1 = (v & 6) == 0 ? (((androidx.compose.runtime.p)l0).g(q0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (((androidx.compose.runtime.p)l0).g(s) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v1 |= (((androidx.compose.runtime.p)l0).i(a0) ? 0x100 : 0x80);
        }
        if(((androidx.compose.runtime.p)l0).Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            N1.b(s, r0.a.a(q0, new D(20, a0)), e0.T(((androidx.compose.runtime.p)l0), 0x7F06017B), 14.0f, null, null, 0L, new l1.k(3), 0.0f, 2, false, 1, 0, null, null, ((androidx.compose.runtime.p)l0), v1 >> 3 & 14 | 0xC00, 0xC30, 0x1D5F0);  // color:green500s
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
        }
        n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new Ac.e(q0, s, a0, v, 16);
        }
    }

    public static final void e(int v, androidx.compose.runtime.l l0, String s, r0.q q0) {
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0xBC358A3D);
        int v1 = v | (p0.g(s) ? 4 : 2) | (p0.g(q0) ? 0x20 : 16);
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            r0.q q1 = androidx.compose.foundation.layout.d.f(q0, 1.0f);
            p0 p00 = M.n0.a(M.j.a, r0.d.j, p0, 0);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q2 = r0.a.d(p0, q1);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p00, P0.j.f);
            androidx.compose.runtime.w.x(p0, i00, P0.j.e);
            P0.h h0 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            androidx.compose.runtime.w.x(p0, q2, P0.j.d);
            x.a(p0, 0);
            N1.b(s, null, e0.T(p0, 0x7F060163), 14.0f, null, null, 0L, null, 18.5f, 0, false, 0, 0, null, null, p0, v1 & 14 | 0xC00, 6, 0x1FBF2);  // color:gray700s
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Ac.h(s, q0, v, 4);
        }
    }

    public static final void f(r0.q q0, boolean z, we.a a0, androidx.compose.runtime.l l0, int v, int v1) {
        int v3;
        String s;
        r0.q q1;
        int v2;
        kotlin.jvm.internal.q.g(a0, "onClickEq");
        ((androidx.compose.runtime.p)l0).c0(0xFCD7E5E8);
        if((v1 & 1) == 0) {
            v2 = (v & 6) == 0 ? (((androidx.compose.runtime.p)l0).g(q0) ? 4 : 2) | v : v;
        }
        else {
            v2 = v | 6;
        }
        if((v & 0x30) == 0) {
            v2 |= (((androidx.compose.runtime.p)l0).h(z) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v2 |= (((androidx.compose.runtime.p)l0).i(a0) ? 0x100 : 0x80);
        }
        if(((androidx.compose.runtime.p)l0).Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            q1 = (v1 & 1) == 0 ? q0 : r0.n.a;
            if(z) {
                s = l1.h(((androidx.compose.runtime.p)l0), 0xA84E2337, 0x7F130BC8, ((androidx.compose.runtime.p)l0), false);  // string:talkback_player_eq_on "이퀄라이저 적용됨"
                v3 = 0x7F0801AF;  // drawable:btn_fullplayer_control_eq_on
            }
            else {
                s = l1.h(((androidx.compose.runtime.p)l0), 0xA8503655, 0x7F130BC7, ((androidx.compose.runtime.p)l0), false);  // string:talkback_player_eq_off "이퀄라이저 적용안됨"
                v3 = 0x7F0801AE;  // drawable:btn_fullplayer_control_eq_off
            }
            String s1 = H0.e.Y(((androidx.compose.runtime.p)l0), 0x7F130BC6);  // string:talkback_player_eq_click "이퀄라이저 설정 팝업 열기"
            c1.n(r0.a.a(androidx.compose.foundation.layout.d.n(q1, E9.h.t(((androidx.compose.runtime.p)l0), 0x7F070409)), new N(s1, a0, 1)), v3, s, N0.j.f, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, ((androidx.compose.runtime.p)l0), 0x6C00, 0, 0x7FE0);  // dimen:player_bottom_default_button_size
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
            q1 = q0;
        }
        n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new b2(q1, z, a0, v, v1, 3);
        }
    }

    public static final void g(r0.q q0, boolean z, long v, String s, long v1, String s1, long v2, long v3, we.k k0, we.k k1, we.k k2, we.k k3, we.a a0, we.a a1, androidx.compose.runtime.l l0, int v4) {
        N0.M m2;
        androidx.compose.runtime.b0 b02;
        m m1;
        x1.j j1;
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(-960053102);
        int v5 = v4 | (p0.h(z) ? 0x20 : 16) | (p0.f(v) ? 0x100 : 0x80) | (p0.g(s) ? 0x800 : 0x400) | (p0.f(v1) ? 0x4000 : 0x2000) | (p0.g(s1) ? 0x20000 : 0x10000) | (p0.f(v2) ? 0x100000 : 0x80000) | (p0.f(v3) ? 0x800000 : 0x400000) | (p0.i(k0) ? 0x4000000 : 0x2000000) | (p0.i(k1) ? 0x20000000 : 0x10000000);
        if(p0.Q(v5 & 1, (v5 & 306783379) != 306783378 || (((p0.i(k2) ? 4 : 2) | (p0.i(k3) ? 0x20 : 16) | (p0.i(a0) ? 0x100 : 0x80) | (p0.i(a1) ? 0x800 : 0x400)) & 0x493) != 1170)) {
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            h h0 = x.I(p0);
            p0.a0(-1003410150);
            p0.a0(212064437);
            p0.p(false);
            r1.c c0 = (r1.c)p0.k(k0.h);
            x1.q q1 = p0.N();
            V v6 = androidx.compose.runtime.k.a;
            if(q1 == v6) {
                q1 = l1.w(c0, p0);
            }
            x1.j j0 = p0.N();
            if(j0 == v6) {
                j0 = l1.u(p0);
            }
            androidx.compose.runtime.b0 b00 = p0.N();
            if(b00 == v6) {
                b00 = androidx.compose.runtime.w.s(Boolean.FALSE);
                p0.l0(b00);
            }
            m m0 = p0.N();
            if(m0 == v6) {
                m0 = l1.v(j0, p0);
            }
            androidx.compose.runtime.b0 b01 = p0.N();
            if(b01 == v6) {
                j1 = j0;
                b01 = androidx.compose.runtime.w.r(H.a, V.c);
                p0.l0(b01);
            }
            else {
                j1 = j0;
            }
            boolean z1 = p0.i(q1);
            boolean z2 = p0.e(0x101);
            g1 g10 = p0.N();
            if(z1 || z2 || g10 == v6) {
                g10 = new g1(b01, q1, m0, 9, b00);
                m1 = m0;
                b02 = b00;
                p0.l0(g10);
            }
            else {
                m1 = m0;
                b02 = b00;
            }
            h1 h10 = p0.N();
            if(h10 == v6) {
                m2 = g10;
                h10 = new h1(b02, m1, 9);
                p0.l0(h10);
            }
            else {
                m2 = g10;
            }
            boolean z3 = p0.i(q1);
            i1 i10 = p0.N();
            if(z3 || i10 == v6) {
                i10 = new i1(q1, 9);
                p0.l0(i10);
            }
            g0.a(X0.n.c(q0, false, i10), m0.c.e(1200550679, p0, new qd.o(b01, j1, h10, v, v1, a1, a0, context0, z, k1, k0, k2, h0, k3, v2, v3, s, s1)), m2, p0, 0x30);
            p0.p(false);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new qd.m(q0, z, v, s, v1, s1, v2, v3, k0, k1, k2, k3, a0, a1, v4);
        }
    }

    public static final void h(String s, int v, String s1, String s2, boolean z, we.k k0, androidx.compose.runtime.l l0, int v1) {
        kotlin.jvm.internal.q.g(k0, "onUserEvent");
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(-1074009389);
        int v2 = (v1 & 6) == 0 ? (p0.g(s) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v2 |= (p0.e(v) ? 0x20 : 16);
        }
        if((v1 & 0x180) == 0) {
            v2 |= (p0.g(s1) ? 0x100 : 0x80);
        }
        if((v1 & 0xC00) == 0) {
            v2 |= (p0.g(s2) ? 0x800 : 0x400);
        }
        if((v1 & 0x6000) == 0) {
            v2 |= (p0.h(z) ? 0x4000 : 0x2000);
        }
        if((0x30000 & v1) == 0) {
            v2 |= (p0.i(k0) ? 0x20000 : 0x10000);
        }
        if(p0.Q(v2 & 1, (74899 & v2) != 74898)) {
            p0.k(AndroidCompositionLocals_androidKt.b);
            r0.n n0 = r0.n.a;
            r0.q q0 = r0.a.a(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.q(n0, 140.0f), 84.0f), new C3(v, 2, s1, s2, k0));
            N0.M m0 = M.p.d(r0.d.a, false);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m0, P0.j.f);
            androidx.compose.runtime.w.x(p0, i00, P0.j.e);
            P0.h h0 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h0);
            }
            androidx.compose.runtime.w.x(p0, q1, P0.j.d);
            T.d d0 = T.e.b(4.0f);
            c1.n(d5.n.o(androidx.compose.foundation.layout.d.c, d0), s, null, N0.j.b, false, 0x7F08078B, null, null, null, 0.0f, null, 0, 0, false, false, p0, v2 << 3 & 0x70 | 0x30C00, 0, 0x7FD4);  // drawable:noimage_logo_mini
            T.d d1 = T.e.b(4.0f);
            M.p.a(androidx.compose.foundation.q.f(d5.n.o(androidx.compose.foundation.layout.d.c, d1), e0.T(p0, 0x7F060157), y0.M.a), p0, 0);  // color:gray400e
            r0.q q2 = androidx.compose.foundation.layout.a.n(n0, 10.0f, 0.0f, 10.0f, 8.0f, 2);
            r0.q q3 = (androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q2, r0.d.g);
            long v4 = e0.T(p0, 0x7F0604A1);  // color:white000e
            androidx.compose.foundation.layout.b b0 = (androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false));
            N1.b(s1, q3, v4, 15.0f, null, null, 0L, null, 0.0f, 2, false, 2, 0, null, null, p0, v2 >> 6 & 14 | 0xC00, 0xC30, 0x1D7F0);
            if(z) {
                p0.a0(0x622C0F79);
                c1.n(androidx.compose.foundation.layout.a.n(androidx.compose.foundation.layout.d.u(b0.a(androidx.compose.foundation.layout.a.n(n0, 0.0f, 0.0f, 11.0f, 0.0f, 11), r0.d.i), 3), 0.0f, 0.0f, 0.0f, 9.0f, 7), 0x7F080487, "좋아요", null, false, 0, null, null, null, 0.0f, new y0.k(e0.T(p0, 0x7F06017B), 5), 0, 0, false, false, p0, 0x30, 0, 0x7BF8);  // drawable:ic_like_16_on
            }
            else {
                p0.a0(1643880809);
            }
            p0.p(false);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.player.playlist.common.b(s, v, s1, s2, z, k0, v1);
        }
    }

    public static final void i(f1 f10, we.k k0, androidx.compose.runtime.l l0, int v) {
        ((androidx.compose.runtime.p)l0).c0(0xD6F2E10E);
        int v1 = (((androidx.compose.runtime.p)l0).g(f10) ? 4 : 2) | v | (((androidx.compose.runtime.p)l0).i(k0) ? 0x20 : 16);
        int v2 = 1;
        if(((androidx.compose.runtime.p)l0).Q(v1 & 1, (v1 & 19) != 18)) {
            String s = f10.c;
            String s1 = f10.b;
            boolean z = f10.d;
            boolean z1 = f10.e;
            d1 d10 = ((androidx.compose.runtime.p)l0).N();
            V v3 = androidx.compose.runtime.k.a;
            if((((v1 & 0x70) == 0x20 ? 1 : 0) | ((v1 & 14) == 4 ? 1 : 0)) != 0 || d10 == v3) {
                d10 = new d1(k0, f10, 0);
                ((androidx.compose.runtime.p)l0).l0(d10);
            }
            if((v1 & 14) != 4) {
                v2 = 0;
            }
            d1 d11 = ((androidx.compose.runtime.p)l0).N();
            if((((v1 & 0x70) == 0x20 ? 1 : 0) | v2) != 0 || d11 == v3) {
                d11 = new d1(k0, f10, 1);
                ((androidx.compose.runtime.p)l0).l0(d11);
            }
            e0.d(s, s1, z, z1, d10, d11, ((androidx.compose.runtime.p)l0), 0);
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
        }
        n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.fragments.artistchannel.viewholder.e(f10, k0, v, 14);
        }
    }

    public static final void j(gd.i1 i10, we.k k0, we.k k1, androidx.compose.runtime.l l0, int v) {
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0xFC943CE6);
        int v1 = v | (p0.i(i10) ? 4 : 2) | (p0.i(k0) ? 0x20 : 16) | (p0.i(k1) ? 0x100 : 0x80);
        boolean z = true;
        if(p0.Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            O.F f0 = O.I.a(0, 0, 3, p0);
            E e0 = p0.N();
            V v2 = androidx.compose.runtime.k.a;
            if(e0 == v2) {
                e0 = androidx.compose.runtime.w.i(new M0(f0, 1));
                p0.l0(e0);
            }
            E e1 = p0.N();
            if(e1 == v2) {
                e1 = androidx.compose.runtime.w.i(new M0(f0, 2));
                p0.l0(e1);
            }
            Boolean boolean0 = (Boolean)e0.getValue();
            boolean0.booleanValue();
            Boolean boolean1 = (Boolean)e1.getValue();
            boolean1.booleanValue();
            e1 e10 = p0.N();
            if((v1 & 0x380) == 0x100 || e10 == v2) {
                e10 = new e1(k1, e0, e1, null);
                p0.l0(e10);
            }
            J.f(boolean0, boolean1, e10, p0);
            r0.q q0 = androidx.compose.foundation.layout.d.c(androidx.compose.foundation.layout.a.n(r0.n.a, 0.0f, 8.0f, 0.0f, 0.0f, 13), 1.0f);
            j0 j00 = androidx.compose.foundation.layout.a.c(0.0f, 0.0f, 0.0f, E9.h.t(p0, 0x7F070058), 7);  // dimen:bottom_tab_plus_miniplayer_height
            boolean z1 = p0.i(i10);
            if((v1 & 0x70) != 0x20) {
                z = false;
            }
            gd.l l1 = p0.N();
            if(z1 || z || l1 == v2) {
                l1 = new gd.l(7, i10, k0);
                p0.l0(l1);
            }
            c1.o(q0, f0, j00, false, null, null, null, false, l1, p0, 6, 0xF8);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Id.h(i10, k0, k1, v, 15);
        }
    }

    public static final void k(B2 b20, we.k k0, androidx.compose.runtime.l l0, int v) {
        kotlin.jvm.internal.q.g(k0, "onUserEvent");
        ((androidx.compose.runtime.p)l0).c0(0xCC402DFE);
        int v1 = (((androidx.compose.runtime.p)l0).i(b20) ? 4 : 2) | v | (((androidx.compose.runtime.p)l0).i(k0) ? 0x20 : 16);
        if(((androidx.compose.runtime.p)l0).Q(v1 & 1, (v1 & 19) != 18)) {
            r0.q q0 = androidx.compose.foundation.layout.a.n(r0.n.a, 0.0f, 0.0f, 0.0f, 29.0f, 7);
            df.v.d(b20.a, q0, "전체보기", true, b20, k0, ((androidx.compose.runtime.p)l0), 0xE000 & v1 << 12 | 0xC30 | v1 << 12 & 0x70000, 0);
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
        }
        n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new gd.a(b20, k0, v, 6);
        }
    }

    public static final void l(p3 p30, we.k k0, androidx.compose.runtime.l l0, int v) {
        ((androidx.compose.runtime.p)l0).c0(-688110057);
        int v1 = (((androidx.compose.runtime.p)l0).i(p30) ? 4 : 2) | v | (((androidx.compose.runtime.p)l0).i(k0) ? 0x20 : 16);
        boolean z = false;
        if(((androidx.compose.runtime.p)l0).Q(v1 & 1, (v1 & 19) != 18)) {
            List list0 = p30.b;
            int v2 = p30.a;
            if((v1 & 0x70) == 0x20) {
                z = true;
            }
            boolean z1 = ((androidx.compose.runtime.p)l0).i(p30);
            ed.w0 w00 = ((androidx.compose.runtime.p)l0).N();
            if(z1 || z || w00 == androidx.compose.runtime.k.a) {
                w00 = new ed.w0(7, k0, p30);
                ((androidx.compose.runtime.p)l0).l0(w00);
            }
            e0.A(list0, v2, w00, ((androidx.compose.runtime.p)l0), 0x180);
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
        }
        n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.fragments.artistchannel.viewholder.e(p30, k0, v, 20);
        }
    }

    public static final void m(q3 q30, int v, we.k k0, androidx.compose.runtime.l l0, int v1) {
        ((androidx.compose.runtime.p)l0).c0(0x9D8308F4);
        int v2 = (v1 & 6) == 0 ? (((androidx.compose.runtime.p)l0).i(q30) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v2 |= (((androidx.compose.runtime.p)l0).e(v) ? 0x20 : 16);
        }
        if((v1 & 0x180) == 0) {
            v2 |= (((androidx.compose.runtime.p)l0).i(k0) ? 0x100 : 0x80);
        }
        if(((androidx.compose.runtime.p)l0).Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            String s = q30.b;
            String s1 = q30.c;
            String s2 = q30.e;
            String s3 = q30.f;
            boolean z = ((androidx.compose.runtime.p)l0).i(q30);
            l3 l30 = ((androidx.compose.runtime.p)l0).N();
            V v3 = androidx.compose.runtime.k.a;
            if(((v2 & 0x380) == 0x100 | z | ((v2 & 0x70) == 0x20 ? 1 : 0)) != 0 || l30 == v3) {
                l30 = new l3(k0, q30, v, 0);
                ((androidx.compose.runtime.p)l0).l0(l30);
            }
            boolean z1 = ((androidx.compose.runtime.p)l0).i(q30);
            l3 l31 = ((androidx.compose.runtime.p)l0).N();
            if(((v2 & 0x380) == 0x100 | z1 | ((v2 & 0x70) == 0x20 ? 1 : 0)) != 0 || l31 == v3) {
                l31 = new l3(k0, q30, v, 1);
                ((androidx.compose.runtime.p)l0).l0(l31);
            }
            boolean z2 = ((androidx.compose.runtime.p)l0).i(q30);
            l3 l32 = ((androidx.compose.runtime.p)l0).N();
            if(((v2 & 0x380) == 0x100 | z2 | ((v2 & 0x70) == 0x20 ? 1 : 0)) != 0 || l32 == v3) {
                l32 = new l3(k0, q30, v, 2);
                ((androidx.compose.runtime.p)l0).l0(l32);
            }
            c1.C(s, null, s1, s2, s3, 0.0f, 0.0f, l30, l31, l32, ((androidx.compose.runtime.p)l0), 0, 0x60);
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
        }
        n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new Nc.p(q30, v, k0, v1, 14);
        }
    }

    public static final void n(int v, androidx.compose.runtime.l l0, List list0, we.a a0, we.k k0, we.k k1) {
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(-292323607);
        int v1 = v | (p0.i(list0) ? 4 : 2) | (p0.i(a0) ? 0x20 : 16) | (p0.i(k0) ? 0x100 : 0x80) | (p0.i(k1) ? 0x800 : 0x400);
        if(p0.Q(v1 & 1, (v1 & 0x493) != 1170)) {
            O.F f0 = O.I.a(0, 0, 3, p0);
            E e0 = p0.N();
            V v2 = androidx.compose.runtime.k.a;
            if(e0 == v2) {
                e0 = androidx.compose.runtime.w.i(new M0(f0, 8));
                p0.l0(e0);
            }
            E e1 = p0.N();
            if(e1 == v2) {
                e1 = androidx.compose.runtime.w.i(new M0(f0, 9));
                p0.l0(e1);
            }
            Boolean boolean0 = (Boolean)e0.getValue();
            boolean0.booleanValue();
            Object object0 = e1.getValue();
            ((Boolean)object0).booleanValue();
            m3 m30 = p0.N();
            if((v1 & 0x1C00) == 0x800 || m30 == v2) {
                m30 = new m3(k1, e0, e1, null);
                p0.l0(m30);
            }
            J.f(boolean0, ((Boolean)object0), m30, p0);
            C0 c00 = Q0.N.u(p0);
            boolean z = p0.g(f0);
            o3 o30 = p0.N();
            if((v1 & 0x70) == 0x20 || z || o30 == v2) {
                o30 = new o3(f0, a0, null);
                p0.l0(o30);
            }
            J.d(p0, H.a, o30);
            r0.q q0 = androidx.compose.ui.input.nestedscroll.a.a(androidx.compose.foundation.layout.d.c(r0.n.a, 1.0f), c00, null);
            j0 j00 = androidx.compose.foundation.layout.a.c(0.0f, 0.0f, 0.0f, E9.h.t(p0, 0x7F070058), 7);  // dimen:bottom_tab_plus_miniplayer_height
            boolean z1 = p0.i(list0);
            gd.e e2 = p0.N();
            if(z1 || (v1 & 0x380) == 0x100 || e2 == v2) {
                e2 = new gd.e(list0, 4, k0);
                p0.l0(e2);
            }
            c1.o(q0, f0, j00, false, null, null, null, false, e2, p0, 0, 0xF8);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new J0(list0, a0, k0, k1, v, 1);
        }
    }

    public static final void o(j5 j50, we.k k0, androidx.compose.runtime.l l0, int v) {
        P0.h h4;
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0x6EBCFD39);
        int v1 = v | (p0.i(j50) ? 4 : 2) | (p0.i(k0) ? 0x20 : 16);
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            M.d d0 = M.j.c;
            r0.g g0 = r0.d.m;
            M.y y0 = M.w.a(d0, g0, p0, 0);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q0 = r0.a.d(p0, androidx.compose.foundation.layout.d.c);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            P0.h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, y0, h0);
            P0.h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            P0.h h2 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            P0.h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q0, h3);
            androidx.compose.foundation.Q0 q00 = androidx.compose.foundation.q.t(p0);
            r0.n n0 = r0.n.a;
            r0.q q1 = androidx.compose.foundation.q.x(n0, q00, false, 14);
            M.y y1 = M.w.a(d0, g0, p0, 0);
            int v3 = p0.P;
            i0 i01 = p0.m();
            r0.q q2 = r0.a.d(p0, q1);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y1, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            androidx.compose.runtime.w.x(p0, q2, h3);
            kotlin.jvm.internal.q.f("멜론DJ를 신청해주신 회원님!\n진심으로 감사드립니다. 아래와 같은 이유로 멜론DJ로 선정되지 못하셨습니다.", "getString(...)");
            N1.b("멜론DJ를 신청해주신 회원님!\n진심으로 감사드립니다. 아래와 같은 이유로 멜론DJ로 선정되지 못하셨습니다.", androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.a.n(n0, 16.0f, 19.0f, 16.0f, 0.0f, 8), 1.0f), e0.T(p0, 0x7F06016D), 15.0f, null, null, 0L, null, 19.5f, 0, false, 0, 0, null, null, p0, 0xC30, 6, 0x1FBF0);  // color:gray900s
            r0.q q3 = androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.a.n(n0, 16.0f, 13.0f, 16.0f, 0.0f, 8), 1.0f);
            androidx.compose.foundation.y y2 = androidx.compose.foundation.q.a(e0.T(p0, 0x7F06014E), 1.0f);  // color:gray125s
            T.d d1 = T.e.b(5.0f);
            r0.q q4 = androidx.compose.foundation.q.f(androidx.compose.foundation.q.j(q3, y2.a, y2.b, d1), e0.T(p0, 0x7F0604AB), T.e.b(5.0f));  // color:white001s
            N0.M m0 = M.p.d(r0.d.a, false);
            int v4 = p0.P;
            i0 i02 = p0.m();
            r0.q q5 = r0.a.d(p0, q4);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m0, h0);
            androidx.compose.runtime.w.x(p0, i02, h1);
            if(!p0.O && kotlin.jvm.internal.q.b(p0.N(), v4)) {
                h4 = h2;
            }
            else {
                h4 = h2;
                A7.d.q(v4, p0, v4, h4);
            }
            androidx.compose.runtime.w.x(p0, q5, h3);
            N1.b((j50.a == null ? "" : j50.a), androidx.compose.foundation.layout.a.m(n0, 13.0f, 15.0f, 13.0f, 10.5f), e0.T(p0, 0x7F060169), 15.0f, null, null, 0L, null, 19.5f, 0, false, 0, 0, null, null, p0, 0xC00, 6, 0x1FBF0);  // color:gray850s
            p0.p(true);
            M.c.d(p0, androidx.compose.foundation.layout.d.h(n0, 4.5f));
            kotlin.jvm.internal.q.f("다음 기회에 다시 한번 신청을 부탁드리며, DJ로 만나 뵐 수 있기를 기다리고 있겠습니다. 항상 더 나은 서비스로 고객님의 성원에 보답하겠습니다.", "getString(...)");
            x.e(0, p0, "다음 기회에 다시 한번 신청을 부탁드리며, DJ로 만나 뵐 수 있기를 기다리고 있겠습니다. 항상 더 나은 서비스로 고객님의 성원에 보답하겠습니다.", androidx.compose.foundation.layout.a.n(n0, 16.0f, 16.0f, 16.0f, 0.0f, 8));
            e0.C(androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.a.n(n0, 0.0f, 19.0f, 0.0f, 0.0f, 13), 1.0f), 0L, 0, 0.0f, p0, 6, 30);
            x.v(j50, k0, p0, v1 & 0x7E);
            r0.q q6 = r0.a.a(e0.M(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.a.m(n0, 16.0f, 17.0f, 16.0f, 20.0f), 1.0f), 40.0f), 0x7F060152, 100.0f), new h5(j50, k0));  // color:gray200a
            N0.M m1 = M.p.d(r0.d.e, false);
            int v5 = p0.P;
            i0 i03 = p0.m();
            r0.q q7 = r0.a.d(p0, q6);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m1, h0);
            androidx.compose.runtime.w.x(p0, i03, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h4);
            }
            androidx.compose.runtime.w.x(p0, q7, h3);
            kotlin.jvm.internal.q.f("확인하기", "getString(...)");
            N1.b("확인하기", null, e0.T(p0, 0x7F060165), 15.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F2);  // color:gray800s
            A7.d.s(p0, true, true, true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.fragments.artistchannel.viewholder.e(j50, k0, v, 25);
        }
    }

    public static final void p(boolean z, we.a a0, androidx.compose.runtime.l l0, int v) {
        kotlin.jvm.internal.q.g(a0, "onClickMore");
        ((androidx.compose.runtime.p)l0).c0(-2093132670);
        int v1 = (v & 6) == 0 ? (((androidx.compose.runtime.p)l0).h(z) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (((androidx.compose.runtime.p)l0).i(a0) ? 0x20 : 16);
        }
        if(((androidx.compose.runtime.p)l0).Q(v1 & 1, (v1 & 19) != 18)) {
            r0.n n0 = r0.n.a;
            r0.q q0 = e0.Q(r0.a.a(androidx.compose.foundation.layout.d.n(n0, 48.0f), new Cd.e(z, a0, 1)), z);
            N0.M m0 = M.p.d(r0.d.a, false);
            int v2 = ((androidx.compose.runtime.p)l0).P;
            i0 i00 = ((androidx.compose.runtime.p)l0).m();
            r0.q q1 = r0.a.d(((androidx.compose.runtime.p)l0), q0);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
            ((androidx.compose.runtime.p)l0).e0();
            if(((androidx.compose.runtime.p)l0).O) {
                ((androidx.compose.runtime.p)l0).l(i0);
            }
            else {
                ((androidx.compose.runtime.p)l0).o0();
            }
            androidx.compose.runtime.w.x(((androidx.compose.runtime.p)l0), m0, P0.j.f);
            androidx.compose.runtime.w.x(((androidx.compose.runtime.p)l0), i00, P0.j.e);
            P0.h h0 = P0.j.g;
            if(((androidx.compose.runtime.p)l0).O || !kotlin.jvm.internal.q.b(((androidx.compose.runtime.p)l0).N(), v2)) {
                A7.d.q(v2, ((androidx.compose.runtime.p)l0), v2, h0);
            }
            androidx.compose.runtime.w.x(((androidx.compose.runtime.p)l0), q1, P0.j.d);
            r0.q q2 = androidx.compose.foundation.layout.d.n(n0, 34.0f);
            c1.n((androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q2, r0.d.e), 0x7F0801BB, H0.e.Y(((androidx.compose.runtime.p)l0), 0x7F130B88), null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, ((androidx.compose.runtime.p)l0), 0x6030, 0, 0x7FE8);  // drawable:btn_fullplayer_gnb_more
            ((androidx.compose.runtime.p)l0).p(true);
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
        }
        n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.player.playlist.common.f(z, a0, v, 1);
        }
    }

    public static final void q(boolean z, long v, String s, long v1, String s1, long v2, long v3, we.k k0, we.k k1, we.k k2, we.k k3, we.a a0, we.a a1, androidx.compose.runtime.l l0, int v4) {
        androidx.compose.runtime.p p0;
        kotlin.jvm.internal.q.g(s1, "durationText");
        ((androidx.compose.runtime.p)l0).c0(0x5A67D3CA);
        int v5 = v4 | (((androidx.compose.runtime.p)l0).h(z) ? 4 : 2) | (((androidx.compose.runtime.p)l0).f(v) ? 0x20 : 16) | (((androidx.compose.runtime.p)l0).g(s) ? 0x100 : 0x80) | (((androidx.compose.runtime.p)l0).f(v1) ? 0x800 : 0x400) | (((androidx.compose.runtime.p)l0).g(s1) ? 0x4000 : 0x2000) | (((androidx.compose.runtime.p)l0).f(v2) ? 0x20000 : 0x10000) | (((androidx.compose.runtime.p)l0).f(v3) ? 0x100000 : 0x80000) | (((androidx.compose.runtime.p)l0).i(k0) ? 0x800000 : 0x400000) | (((androidx.compose.runtime.p)l0).i(k1) ? 0x4000000 : 0x2000000) | (((androidx.compose.runtime.p)l0).i(k2) ? 0x20000000 : 0x10000000);
        if(((androidx.compose.runtime.p)l0).Q(v5 & 1, (v5 & 306783379) != 306783378 || (((((androidx.compose.runtime.p)l0).i(k3) ? 4 : 2) | (((androidx.compose.runtime.p)l0).i(a0) ? 0x20 : 16) | (((androidx.compose.runtime.p)l0).i(a1) ? 0x100 : 0x80)) & 0x93) != 0x92)) {
            r0.q q0 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(r0.n.a, 1.0f), E9.h.t(((androidx.compose.runtime.p)l0), 0x7F070415));  // dimen:player_seekbar_area_height
            qd.i i0 = new qd.i(z, v, s, v1, s1, v2, v3, k0, k1, k2, k3, a0, a1);
            p0 = (androidx.compose.runtime.p)l0;
            M.c.a(q0, null, false, m0.c.e(0x85F96C20, p0, i0), p0, 0xC00, 6);
        }
        else {
            p0 = (androidx.compose.runtime.p)l0;
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new qd.k(z, v, s, v1, s1, v2, v3, k0, k1, k2, k3, a0, a1, v4);
        }
    }

    public static final void r(r0.q q0, String s, androidx.compose.runtime.l l0, int v, int v1) {
        int v6;
        ((androidx.compose.runtime.p)l0).c0(2022287462);
        int v2 = (v1 & 6) == 0 ? v1 | (((androidx.compose.runtime.p)l0).g(q0) ? 4 : 2) : v1;
        if((v1 & 0x30) == 0) {
            v2 |= (((androidx.compose.runtime.p)l0).g(s) ? 0x20 : 16);
        }
        int v3 = 0;
        if(((androidx.compose.runtime.p)l0).Q((v2 | 0x180) & 1, ((v2 | 0x180) & 0x93) != 0x92)) {
            Context context0 = (Context)((androidx.compose.runtime.p)l0).k(AndroidCompositionLocals_androidKt.b);
            n3 n30 = c1.W(((androidx.compose.runtime.p)l0), 0);
            boolean z = ((androidx.compose.runtime.p)l0).i(n30);
            boolean z1 = ((androidx.compose.runtime.p)l0).i(context0);
            int v4 = (v2 | 0x180) & 0x70;
            if(v4 == 0x20) {
                v3 = 1;
            }
            qd.w w0 = ((androidx.compose.runtime.p)l0).N();
            V v5 = androidx.compose.runtime.k.a;
            if((z | z1 | v3) != 0 || w0 == v5) {
                w0 = new qd.w(n30, context0, s, null);
                ((androidx.compose.runtime.p)l0).l0(w0);
            }
            J.d(((androidx.compose.runtime.p)l0), s, w0);
            String s1 = H0.e.Y(((androidx.compose.runtime.p)l0), 0x7F130B6C);  // string:talkback_lyric_detail_close "전체 가사닫기"
            r0.q q1 = d5.n.o(androidx.compose.foundation.layout.d.n(q0, 44.0f), T.e.b(4.0f));
            r0.q q2 = androidx.compose.foundation.q.f(androidx.compose.foundation.q.i(0.5f, e0.T(((androidx.compose.runtime.p)l0), 0x7F0604AE), q1, T.e.b(4.0f)), e0.T(((androidx.compose.runtime.p)l0), 0x7F060144), y0.M.a);  // color:white120e
            boolean z2 = ((androidx.compose.runtime.p)l0).g(s1);
            com.iloen.melon.playback.playlist.db.d d0 = ((androidx.compose.runtime.p)l0).N();
            if(z2 || d0 == v5) {
                d0 = new com.iloen.melon.playback.playlist.db.d(s1, 20);
                ((androidx.compose.runtime.p)l0).l0(d0);
            }
            rd.a.u(X0.n.c(q2, true, d0), s, s1, N0.j.b, 0x7F08078C, ((androidx.compose.runtime.p)l0), v4 | 0x36C00, 0);  // drawable:noimage_logo_mini_w
            v6 = 300;
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
            v6 = v;
        }
        n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.player.playlist.b(q0, s, v6, v1, 1);
        }
    }

    public static final void s(r0.q q0, String s, String s1, we.a a0, androidx.compose.runtime.l l0, int v) {
        String s3;
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(-1960712418);
        int v1 = (v & 6) == 0 ? (p0.g(q0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (p0.g(s) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v1 |= (p0.g(s1) ? 0x100 : 0x80);
        }
        if((v & 0xC00) == 0) {
            v1 |= (p0.i(a0) ? 0x800 : 0x400);
        }
        if(p0.Q(v1 & 1, (v1 & 0x493) != 1170)) {
            h h0 = x.I(p0);
            M.y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            P0.h h1 = P0.j.f;
            androidx.compose.runtime.w.x(p0, y0, h1);
            P0.h h2 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h2);
            P0.h h3 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h3);
            }
            androidx.compose.runtime.w.x(p0, q1, P0.j.d);
            M.c.d(p0, androidx.compose.foundation.layout.d.h(r0.n.a, 11.0f));
            long v3 = e0.T(p0, 0x7F0604A1);  // color:white000e
            r0.n n0 = r0.n.a;
            P0.h h4 = P0.j.d;
            c1.g(null, s, v3, 16.0f, y.i, null, null, 0, 0, p0, v1 & 0x70 | 0x6C00, 481);
            M.c.d(p0, androidx.compose.foundation.layout.d.h(n0, 4.0f));
            String s2 = p0.N();
            V v4 = androidx.compose.runtime.k.a;
            if((v1 & 0x380) == 0x100 || s2 == v4) {
                if(h0 == null) {
                    s3 = "";
                }
                else {
                    s3 = h0.a(s1);
                    if(s3 == null) {
                        s3 = "";
                    }
                }
                s2 = s3;
                p0.l0(s2);
            }
            r0.q q2 = androidx.compose.foundation.layout.d.f(n0, 1.0f);
            boolean z = p0.g(s2);
            com.iloen.melon.playback.playlist.db.d d0 = p0.N();
            if(z || d0 == v4) {
                d0 = new com.iloen.melon.playback.playlist.db.d(s2, 19);
                p0.l0(d0);
            }
            r0.q q3 = X0.n.b(q2, d0);
            N0.M m0 = M.p.d(r0.d.a, false);
            int v5 = p0.P;
            i0 i01 = p0.m();
            r0.q q4 = r0.a.d(p0, q3);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m0, h1);
            androidx.compose.runtime.w.x(p0, i01, h2);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h3);
            }
            androidx.compose.runtime.w.x(p0, q4, h4);
            int v6 = v1 >> 6 & 14;
            N1.b(s1, androidx.compose.foundation.q.h(androidx.compose.foundation.layout.d.f(n0, 1.0f), 0, 0, null, 0.0f, 62), e0.T(p0, 0x7F0604B7), 13.0f, null, null, 0L, null, 0.0f, 0, false, 1, 0, null, null, p0, v6 | 0xC30, 0xC00, 0x1DFF0);  // color:white700e
            N1.b(s1, r0.a.a(androidx.compose.foundation.layout.d.v(n0, null, 3), new D(21, a0)), e0.T(p0, 0x7F06048A), 13.0f, null, null, 0L, null, 0.0f, 0, false, 1, 0, null, null, p0, v6 | 0xC00, 0xC00, 0x1DFF0);  // color:transparent
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new qd.n(v, 0, s, s1, q0, a0);
        }
    }

    public static final void t(r0.q q0, boolean z, we.a a0, we.a a1, androidx.compose.runtime.l l0, int v) {
        kotlin.jvm.internal.q.g(q0, "modifier");
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0x640BF08B);
        int v1 = (v & 6) == 0 ? (p0.g(q0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (p0.h(z) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v1 |= (p0.i(a0) ? 0x100 : 0x80);
        }
        if((v & 0xC00) == 0) {
            v1 |= (p0.i(a1) ? 0x800 : 0x400);
        }
        if(p0.Q(v1 & 1, (v1 & 0x493) != 1170)) {
            p0 p00 = M.n0.a(M.j.a, r0.d.j, p0, 0);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p00, P0.j.f);
            androidx.compose.runtime.w.x(p0, i00, P0.j.e);
            P0.h h0 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            androidx.compose.runtime.w.x(p0, q1, P0.j.d);
            x.p(z, a0, p0, v1 >> 3 & 0x7E);
            x.b(a1, p0, v1 >> 9 & 14);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new qd.l(q0, z, a0, a1, v);
        }
    }

    public static final void u(we.a a0, r0.q q0, androidx.compose.runtime.l l0, int v, int v1) {
        r0.q q1;
        int v2;
        kotlin.jvm.internal.q.g(a0, "onClickPlaylist");
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(-1578870294);
        if((v1 & 1) != 0) {
            v2 = v | 6;
            q1 = q0;
        }
        else if((v & 6) == 0) {
            q1 = q0;
            v2 = (p0.g(q1) ? 4 : 2) | v;
        }
        else {
            q1 = q0;
            v2 = v;
        }
        if((v & 0x30) == 0) {
            v2 |= (p0.i(a0) ? 0x20 : 16);
        }
        if(p0.Q(v2 & 1, (v2 & 19) != 18)) {
            r0.q q2 = (v1 & 1) == 0 ? q1 : r0.n.a;
            String s = H0.e.Y(p0, 0x7F130B80);  // string:talkback_miniplayer_playlist_open "재생목록으로 이동"
            r0.q q3 = r0.a.a(androidx.compose.foundation.layout.d.n(q2, E9.h.t(p0, 0x7F070409)), new D(22, a0));  // dimen:player_bottom_default_button_size
            boolean z = p0.g(s);
            com.iloen.melon.playback.playlist.db.d d0 = p0.N();
            if(z || d0 == androidx.compose.runtime.k.a) {
                d0 = new com.iloen.melon.playback.playlist.db.d(s, 18);
                p0.l0(d0);
            }
            r0.q q4 = X0.n.c(q3, true, d0);
            N0.M m0 = M.p.d(r0.d.a, false);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q5 = r0.a.d(p0, q4);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m0, P0.j.f);
            androidx.compose.runtime.w.x(p0, i00, P0.j.e);
            P0.h h0 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h0);
            }
            androidx.compose.runtime.w.x(p0, q5, P0.j.d);
            c1.n(androidx.compose.foundation.layout.d.c, 0x7F080809, null, N0.j.f, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 27702, 0, 0x7FE4);  // drawable:selector_btn_fullplayer_control_playlist
            p0.p(true);
            q1 = q2;
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.popup.r(q1, a0, v, v1);
        }
    }

    public static final void v(j5 j50, we.k k0, androidx.compose.runtime.l l0, int v) {
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0xCB71EBAE);
        int v1 = (v & 6) == 0 ? v | (p0.i(j50) ? 4 : 2) : v;
        if((v & 0x30) == 0) {
            v1 |= (p0.i(k0) ? 0x20 : 16);
        }
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            kotlin.jvm.internal.q.f("플레이리스트 저장하기", "getString(...)");
            r0.q q0 = androidx.compose.foundation.layout.a.n(r0.n.a, 16.0f, 19.0f, 16.0f, 0.0f, 8);
            r0.n n0 = r0.n.a;
            N1.b("플레이리스트 저장하기", androidx.compose.foundation.layout.d.f(q0, 1.0f), e0.T(p0, 0x7F06016D), 18.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F0);  // color:gray900s
            r0.q q1 = androidx.compose.foundation.layout.a.n(n0, 0.0f, 0.0f, 0.0f, 7.0f, 7);
            String s = j50.c;
            String s1 = j50.b;
            String s2 = j50.d;
            String s3 = j50.e;
            Object object0 = je.p.m0(j50.f);
            Object object1 = je.p.n0(1, j50.f);
            G2 g20 = G2.a;
            boolean z = p0.i(j50);
            f5 f50 = p0.N();
            V v2 = androidx.compose.runtime.k.a;
            if((v1 & 0x70) == 0x20 || z || f50 == v2) {
                f50 = new f5(k0, j50, 0);
                p0.l0(f50);
            }
            boolean z1 = p0.i(j50);
            f5 f51 = p0.N();
            if((v1 & 0x70) == 0x20 || z1 || f51 == v2) {
                f51 = new f5(k0, j50, 1);
                p0.l0(f51);
            }
            c1.A(false, s, s1, null, s2, s3, null, null, null, ((ie.m)object0), ((ie.m)object1), q1, g20, null, null, f50, f51, null, p0, 0xC06DB6, 0x1B01B6, 0x4E0000);
            r0.q q2 = androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.a.n(n0, 16.0f, 0.0f, 16.0f, 0.0f, 10), 18.0f), 1.0f);
            p0 p00 = M.n0.a(M.j.a, r0.d.k, p0, 0x30);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q3 = r0.a.d(p0, q2);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p00, P0.j.f);
            androidx.compose.runtime.w.x(p0, i00, P0.j.e);
            P0.h h0 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h0);
            }
            androidx.compose.runtime.w.x(p0, q3, P0.j.d);
            int v4 = j50.g ? 0x7F08012A : 0x7F080129;  // drawable:btn_common_checkbox_on
            r0.q q4 = androidx.compose.foundation.layout.d.n(n0, 18.0f);
            boolean z2 = p0.i(context0);
            Cc.n n1 = p0.N();
            if(z2 || n1 == v2) {
                n1 = new Cc.n(context0, 11);
                p0.l0(n1);
            }
            c1.n(r0.a.a(X0.n.c(q4, false, n1), new h5(k0, j50)), v4, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0, 0, 0x7FFC);
            kotlin.jvm.internal.q.f("음악서랍 > 플레이리스트에 저장하기", "getString(...)");
            N1.b("음악서랍 > 플레이리스트에 저장하기", androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.a.n(n0, 9.0f, 0.0f, 0.0f, 0.0f, 14), 1.0f), e0.T(p0, 0x7F06016D), 15.0f, null, null, 0L, null, 0.0f, 2, false, 0, 0, null, null, p0, 0xC30, 0x30, 0x1F7F0);  // color:gray900s
            p0.p(true);
            kotlin.jvm.internal.q.f("체크하시면, DJ 신청 시 제작하신 플레이리스트를 회원님의 \'음악서랍 > 플레이리스트\' 메뉴로 옮기실 수 있습니다.", "getString(...)");
            x.e(0, p0, "체크하시면, DJ 신청 시 제작하신 플레이리스트를 회원님의 \'음악서랍 > 플레이리스트\' 메뉴로 옮기실 수 있습니다.", androidx.compose.foundation.layout.a.n(n0, 16.0f, 19.0f, 16.0f, 0.0f, 8));
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new U(j50, k0, v, 17);
        }
    }

    public static final void w(String s, androidx.compose.runtime.l l0, int v) {
        ((androidx.compose.runtime.p)l0).c0(0x9FFACF53);
        int v1 = v | (((androidx.compose.runtime.p)l0).g(s) ? 4 : 2);
        if(((androidx.compose.runtime.p)l0).Q(v1 & 1, (v1 & 3) != 2)) {
            N1.b(s, androidx.compose.foundation.layout.d.u(r0.n.a, 3), e0.T(((androidx.compose.runtime.p)l0), 0x7F0604A1), 24.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, ((androidx.compose.runtime.p)l0), v1 & 14 | 0xC30, 0, 0x1FFF0);  // color:white000e
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
        }
        n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new k2(s, v, 5);
        }
    }

    public static final long x(float f, float f1) {
        return ((long)Float.floatToRawIntBits(f1)) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(f)) << 0x20;
    }

    public static final void y(AutoCloseable autoCloseable0, Throwable throwable0) {
        if(autoCloseable0 != null) {
            if(throwable0 != null) {
                goto label_32;
            }
            if(autoCloseable0 instanceof AutoCloseable) {
                autoCloseable0.close();
                return;
            }
            if(!(autoCloseable0 instanceof ExecutorService)) {
                goto label_22;
            }
            ExecutorService executorService0 = (ExecutorService)autoCloseable0;
            if(executorService0 != ForkJoinPool.commonPool()) {
                boolean z = executorService0.isTerminated();
                if(!z) {
                    executorService0.shutdown();
                    boolean z1 = false;
                    while(!z) {
                        try {
                            z = executorService0.awaitTermination(1L, TimeUnit.DAYS);
                        }
                        catch(InterruptedException unused_ex) {
                            if(z1) {
                                continue;
                            }
                            executorService0.shutdownNow();
                            z1 = true;
                        }
                    }
                    if(z1) {
                        Thread.currentThread().interrupt();
                        return;
                    label_22:
                        if(autoCloseable0 instanceof TypedArray) {
                            ((TypedArray)autoCloseable0).recycle();
                            return;
                        }
                        if(autoCloseable0 instanceof MediaMetadataRetriever) {
                            ((MediaMetadataRetriever)autoCloseable0).release();
                            return;
                        }
                        if(!(autoCloseable0 instanceof MediaDrm)) {
                            throw new IllegalArgumentException();
                        }
                        ((MediaDrm)autoCloseable0).release();
                        return;
                        try {
                        label_32:
                            H0.b.u(autoCloseable0);
                        }
                        catch(Throwable throwable1) {
                            e2.a.q(throwable0, throwable1);
                        }
                    }
                }
            }
        }
    }

    public static final String z(e e0, f f0) {
        kotlin.jvm.internal.q.g(e0, "klass");
        kotlin.jvm.internal.q.g(f0, "typeMappingConfiguration");
        Me.k k0 = e0.e();
        kotlin.jvm.internal.q.f(k0, "getContainingDeclaration(...)");
        qf.e e1 = e0.getName();
        if(e1 == null || e1.b) {
            e1 = qf.g.c;
        }
        String s = e1.c();
        if(k0 instanceof Me.E) {
            qf.c c0 = ((C)(((Me.E)k0))).e;
            return c0.a.c() ? s : v.o0(c0.a.a, '.', '/') + '/' + s;
        }
        e e2 = k0 instanceof e ? ((e)k0) : null;
        if(e2 == null) {
            throw new IllegalArgumentException("Unexpected container: " + k0 + " for " + e0);
        }
        return x.z(e2, f0) + '$' + s;
    }
}

