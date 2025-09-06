package h7;

import Ac.A2;
import Ac.T0;
import Af.f;
import Af.m;
import Af.p;
import Af.r;
import Cc.N1;
import Cc.c1;
import Cc.e0;
import D2.z0;
import Dc.u;
import Hf.P;
import Hf.x;
import I6.S;
import I6.v0;
import Je.i;
import Je.o;
import Ke.g;
import Ke.j;
import Ke.k;
import Ke.l;
import M.j0;
import M.p0;
import Me.e;
import Me.h;
import Nc.Y;
import Nc.d0;
import O.F;
import Q.K;
import Q0.g0;
import Q0.k0;
import a1.M;
import a1.U;
import android.content.ClipData;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.database.SQLException;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.metrics.LogSessionId;
import android.media.metrics.MediaMetricsManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.Process;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode;
import android.text.Annotation;
import android.text.SpannableString;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import androidx.compose.foundation.E0;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.lazy.layout.z;
import androidx.compose.runtime.E;
import androidx.compose.runtime.J;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.lifecycle.f0;
import androidx.media3.exoplayer.B;
import be.a;
import com.google.firebase.b;
import com.melon.ui.n0;
import d5.n;
import e1.t;
import e1.y;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel.MapMode;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import je.C;
import je.D;
import je.w;
import jeb.synthetic.TWR;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import qf.c;
import qf.d;
import y0.T;
import y0.s;

public abstract class u0 {
    public static final int a;
    public static final int b;
    public static final int c;
    public static final int d;

    public static final List A(x x0) {
        q.g(x0, "<this>");
        u0.H(x0);
        int v = u0.p(x0);
        if(v == 0) {
            return w.a;
        }
        Iterable iterable0 = x0.r().subList(0, v);
        List list0 = new ArrayList(je.q.Q(10, iterable0));
        for(Object object0: iterable0) {
            ((ArrayList)list0).add(((P)object0).b());
        }
        return list0;
    }

    public static Collection B(r r0, f f0, int v) {
        if((v & 1) != 0) {
            f0 = f.m;
        }
        p.a.getClass();
        return r0.e(f0, m.b);
    }

    public static final k C(h h0) {
        if(h0 instanceof e && i.J(h0)) {
            d d0 = xf.d.h(h0);
            if(d0.d() && !d0.c()) {
                c c0 = d0.g().b();
                String s = d0.f().b();
                q.f(s, "asString(...)");
                Ke.m.c.getClass();
                l l0 = Ke.m.c.a(s, c0);
                return l0 == null ? null : l0.a;
            }
        }
        return null;
    }

    public static final x D(x x0) {
        q.g(x0, "<this>");
        u0.H(x0);
        if(x0.getAnnotations().e0(o.p) != null) {
            int v = u0.p(x0);
            return ((P)x0.r().get(v)).b();
        }
        return null;
    }

    public static File E(Context context0) {
        File file0 = context0.getCacheDir();
        if(file0 == null) {
            return null;
        }
        String s = ".font" + Process.myPid() + "-" + Process.myTid() + "-";
        for(int v = 0; v < 100; ++v) {
            File file1 = new File(file0, s + v);
            try {
                if(file1.createNewFile()) {
                    return file1;
                }
            }
            catch(IOException unused_ex) {
            }
        }
        return null;
    }

    public static final List F(x x0) {
        q.g(x0, "<this>");
        u0.H(x0);
        List list0 = x0.r();
        int v = u0.p(x0);
        return !u0.H(x0) || x0.getAnnotations().e0(o.p) == null ? list0.subList(v, list0.size() - 1) : list0.subList(v + 1, list0.size() - 1);
    }

    public static boolean G(Me.c c0) {
        q.g(c0, "callableMemberDescriptor");
        qf.e e0 = c0.getName();
        if(Ze.f.d.contains(e0)) {
            c c1 = xf.d.c(c0);
            if(je.p.d0(Ze.f.c, c1) && c0.F().isEmpty()) {
                return true;
            }
            if(i.A(c0)) {
                Collection collection0 = c0.f();
                q.f(collection0, "getOverriddenDescriptors(...)");
                if(!collection0.isEmpty()) {
                    for(Object object0: collection0) {
                        q.d(((Me.c)object0));
                        if(!u0.G(((Me.c)object0))) {
                            continue;
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final boolean H(x x0) {
        q.g(x0, "<this>");
        h h0 = x0.w().e();
        if(h0 != null) {
            k k0 = u0.C(h0);
            return q.b(k0, g.c) || q.b(k0, j.c);
        }
        return false;
    }

    public static boolean I(Context context0) {
        ((k8.o)(((a)b.B(context0, a.class)))).getClass();
        n.n(v0.j.h <= 1, "Cannot bind the flag @DisableFragmentGetContextFix more than once.", new Object[0]);
        return v0.j.isEmpty() ? true : ((Boolean)((S)v0.j.k()).next()).booleanValue();
    }

    public static final boolean J(x x0) {
        q.g(x0, "<this>");
        h h0 = x0.w().e();
        return h0 == null ? q.b(null, j.c) : q.b(u0.C(h0), j.c);
    }

    // 去混淆评级： 低(20)
    public static boolean K(char c) {
        return Character.isWhitespace(c) || Character.isSpaceChar(c);
    }

    public static Job L(n0 n00, me.i i0, we.n n0, int v) {
        if((v & 1) != 0) {
            i0 = me.j.a;
        }
        q.g(n00, "<this>");
        q.g(i0, "context");
        q.g(CoroutineStart.DEFAULT, "start");
        return BuildersKt.launch(f0.h(n00), i0, CoroutineStart.DEFAULT, n0);
    }

    public static MappedByteBuffer M(Context context0, Uri uri0) {
        ContentResolver contentResolver0 = context0.getContentResolver();
        try(ParcelFileDescriptor parcelFileDescriptor0 = contentResolver0.openFileDescriptor(uri0, "r", null)) {
            if(parcelFileDescriptor0 != null) {
                FileInputStream fileInputStream0 = new FileInputStream(parcelFileDescriptor0.getFileDescriptor());
                TWR.declareResource(fileInputStream0);
                TWR.useResource$NT(fileInputStream0);
                FileChannel fileChannel0 = fileInputStream0.getChannel();
                long v = fileChannel0.size();
                return fileChannel0.map(FileChannel.MapMode.READ_ONLY, 0L, v);
            }
        }
        catch(IOException unused_ex) {
        }
        return null;
    }

    public static final C2.f N(C2.d[] arr_d) {
        ArrayList arrayList0 = new ArrayList(arr_d.length);
        if(arr_d.length <= 0) {
            ie.m[] arr_m = (ie.m[])arrayList0.toArray(new ie.m[0]);
            return new C2.f(C.T(((ie.m[])Arrays.copyOf(arr_m, arr_m.length))));
        }
        C2.d d0 = arr_d[0];
        throw null;
    }

    public static i3.l O(Context context0, B b0, boolean z, String s) {
        MediaMetricsManager mediaMetricsManager0 = i3.i.h(context0.getSystemService("media_metrics"));
        i3.j j0 = mediaMetricsManager0 == null ? null : new i3.j(context0, mediaMetricsManager0.createPlaybackSession());
        if(j0 == null) {
            e3.b.D("ExoPlayerImpl", "MediaMetricsService unavailable.");
            return new i3.l(LogSessionId.LOG_SESSION_ID_NONE, s);
        }
        if(z) {
            b0.s.getClass();
            b0.s.f.a(j0);
        }
        return new i3.l(j0.c.getSessionId(), s);
    }

    public static final u P(F f0, we.a a0, we.n n0, we.n n1, androidx.compose.runtime.p p0, int v) {
        q.g(f0, "lazyListState");
        q.g(n0, "onMove");
        q.g(n1, "onMoveEnd");
        float f1 = Dc.l.a;
        float f2 = ((r1.c)p0.k(k0.h)).Y(f1);
        CoroutineScope coroutineScope0 = p0.N();
        V v1 = androidx.compose.runtime.k.a;
        if(coroutineScope0 == v1) {
            coroutineScope0 = J.i(p0);
            p0.l0(coroutineScope0);
        }
        boolean z = p0.g(coroutineScope0);
        boolean z1 = p0.g(f0);
        boolean z2 = p0.d(f1);
        boolean z3 = p0.d(0.06f);
        boolean z4 = p0.h(false);
        u u0 = p0.N();
        if((z2 | (z | z1) | z3 | z4) != 0 || u0 == v1) {
            u u1 = new u(f0, coroutineScope0, n0, a0, n1, f2);
            p0.l0(u1);
            return u1;
        }
        return u0;
    }

    public static final cf.c Q(com.google.firebase.messaging.u u0, gf.b b0) {
        q.g(u0, "<this>");
        q.g(b0, "annotationsOwner");
        return new cf.c(u0, b0, false);
    }

    public static void R(androidx.constraintlayout.widget.a a0, View view0, float[] arr_f) {
        Class class0 = view0.getClass();
        String s = "set" + a0.b;
        try {
            int v = e0.b.b(a0.c);
            Class class1 = Integer.TYPE;
            Class class2 = Float.TYPE;
            boolean z = true;
            switch(v) {
                case 0: {
                    class0.getMethod(s, class1).invoke(view0, ((int)arr_f[0]));
                    return;
                }
                case 1: {
                    class0.getMethod(s, class2).invoke(view0, ((float)arr_f[0]));
                    return;
                }
                case 2: {
                    class0.getMethod(s, class1).invoke(view0, ((int)(u0.m(((int)(((float)Math.pow(arr_f[0], 0.454545)) * 255.0f))) << 16 | u0.m(((int)(arr_f[3] * 255.0f))) << 24 | u0.m(((int)(((float)Math.pow(arr_f[1], 0.454545)) * 255.0f))) << 8 | u0.m(((int)(((float)Math.pow(arr_f[2], 0.454545)) * 255.0f))))));
                    return;
                }
                case 3: {
                    Method method0 = class0.getMethod(s, Drawable.class);
                    int v1 = u0.m(((int)(((float)Math.pow(arr_f[0], 0.454545)) * 255.0f)));
                    int v2 = u0.m(((int)(((float)Math.pow(arr_f[1], 0.454545)) * 255.0f)));
                    int v3 = u0.m(((int)(((float)Math.pow(arr_f[2], 0.454545)) * 255.0f)));
                    int v4 = u0.m(((int)(arr_f[3] * 255.0f)));
                    ColorDrawable colorDrawable0 = new ColorDrawable();
                    colorDrawable0.setColor(v1 << 16 | v4 << 24 | v2 << 8 | v3);
                    method0.invoke(view0, colorDrawable0);
                    return;
                }
                case 4: {
                    throw new RuntimeException("unable to interpolate strings " + a0.b);
                }
                case 5: {
                    Method method1 = class0.getMethod(s, Boolean.TYPE);
                    if(arr_f[0] <= 0.5f) {
                        z = false;
                    }
                    method1.invoke(view0, Boolean.valueOf(z));
                    return;
                }
                case 6: {
                    class0.getMethod(s, class2).invoke(view0, ((float)arr_f[0]));
                    return;
                }
                default: {
                    return;
                }
            }
        }
        catch(NoSuchMethodException noSuchMethodException0) {
        }
        catch(IllegalAccessException illegalAccessException0) {
            goto label_41;
        }
        catch(InvocationTargetException invocationTargetException0) {
            goto label_46;
        }
        StringBuilder stringBuilder0 = com.iloen.melon.utils.a.n("No method ", s, " on View \"");
        stringBuilder0.append(ye.a.G(view0));
        stringBuilder0.append("\"");
        Log.e("CustomSupport", stringBuilder0.toString(), noSuchMethodException0);
        return;
    label_41:
        StringBuilder stringBuilder1 = com.iloen.melon.utils.a.n("Cannot access method ", s, " on View \"");
        stringBuilder1.append(ye.a.G(view0));
        stringBuilder1.append("\"");
        Log.e("CustomSupport", stringBuilder1.toString(), illegalAccessException0);
        return;
    label_46:
        StringBuilder stringBuilder2 = com.iloen.melon.utils.a.n("Cannot invoke method ", s, " on View \"");
        stringBuilder2.append(ye.a.G(view0));
        stringBuilder2.append("\"");
        Log.e("CustomSupport", stringBuilder2.toString(), invocationTargetException0);
    }

    public static final void S(int v, String s) {
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append("Error code: " + v);
        if(s != null) {
            stringBuilder0.append(", message: " + s);
        }
        throw new SQLException(stringBuilder0.toString());
    }

    public static final g0 T(a1.g g0) {
        SpannableString spannableString1;
        ArrayList arrayList0 = g0.c;
        w w0 = w.a;
        w w1 = arrayList0 == null ? w0 : arrayList0;
        String s = g0.b;
        if(!w1.isEmpty()) {
            SpannableString spannableString0 = new SpannableString(s);
            I7.c c0 = new I7.c(9, false);
            c0.b = Parcel.obtain();
            if(arrayList0 == null) {
                arrayList0 = w0;
            }
            int v = arrayList0.size();
            int v1 = 0;
            while(v1 < v) {
                a1.e e0 = (a1.e)arrayList0.get(v1);
                M m0 = (M)e0.a;
                int v2 = e0.c;
                ((Parcel)c0.b).recycle();
                c0.b = Parcel.obtain();
                long v3 = m0.l;
                long v4 = m0.h;
                long v5 = m0.b;
                long v6 = m0.a.b();
                int v7 = e0.b;
                long v8 = s.g;
                if(s.d(v6, v8)) {
                    spannableString1 = spannableString0;
                }
                else {
                    c0.x(1);
                    spannableString1 = spannableString0;
                    long v9 = m0.a.b();
                    ((Parcel)c0.b).writeLong(v9);
                }
                long v10 = r1.o.c;
                int v11 = 2;
                if(!r1.o.a(v5, v10)) {
                    c0.x(2);
                    c0.z(v5);
                }
                y y0 = m0.c;
                if(y0 != null) {
                    c0.x(3);
                    ((Parcel)c0.b).writeInt(y0.a);
                }
                e1.s s1 = m0.d;
                if(s1 != null) {
                    c0.x(4);
                    c0.x(((byte)(s1.a == 1 ? 1 : 0)));
                }
                t t0 = m0.e;
                if(t0 != null) {
                    int v12 = t0.a;
                    c0.x(5);
                    if(v12 == 0) {
                        v11 = 0;
                    }
                    else {
                        switch(v12) {
                            case 1: {
                                break;
                            }
                            case 2: {
                                v11 = 3;
                                break;
                            }
                            case 0xFFFF: {
                                v11 = 1;
                                break;
                            }
                            default: {
                                v11 = 0;
                            }
                        }
                    }
                    c0.x(((byte)v11));
                }
                String s2 = m0.g;
                if(s2 != null) {
                    c0.x(6);
                    ((Parcel)c0.b).writeString(s2);
                }
                if(!r1.o.a(v4, v10)) {
                    c0.x(7);
                    c0.z(v4);
                }
                l1.a a0 = m0.i;
                if(a0 != null) {
                    c0.x(8);
                    c0.y(a0.a);
                }
                l1.q q0 = m0.j;
                if(q0 != null) {
                    c0.x(9);
                    c0.y(q0.a);
                    c0.y(q0.b);
                }
                if(!s.d(v3, v8)) {
                    c0.x(10);
                    ((Parcel)c0.b).writeLong(v3);
                }
                l1.l l0 = m0.m;
                if(l0 != null) {
                    c0.x(11);
                    ((Parcel)c0.b).writeInt(l0.a);
                }
                y0.P p0 = m0.n;
                if(p0 != null) {
                    c0.x(12);
                    ((Parcel)c0.b).writeLong(p0.a);
                    c0.y(Float.intBitsToFloat(((int)(p0.b >> 0x20))));
                    c0.y(Float.intBitsToFloat(((int)(p0.b & 0xFFFFFFFFL))));
                    c0.y(p0.c);
                }
                spannableString1.setSpan(new Annotation("androidx.compose.text.SpanStyle", Base64.encodeToString(((Parcel)c0.b).marshall(), 0)), v7, v2, 33);
                ++v1;
                spannableString0 = spannableString1;
            }
            s = spannableString0;
        }
        return new g0(ClipData.newPlainText("plain text", s));
    }

    public static String U(String s) {
        int v = s.length();
        for(int v1 = 0; v1 < v; ++v1) {
            int v2 = s.charAt(v1);
            if(v2 >= 65 && v2 <= 90) {
                char[] arr_c = s.toCharArray();
                while(v1 < v) {
                    int v3 = arr_c[v1];
                    if(v3 >= 65 && v3 <= 90) {
                        arr_c[v1] = (char)(v3 ^ 0x20);
                    }
                    ++v1;
                }
                return String.valueOf(arr_c);
            }
        }
        return s;
    }

    public static String V(String s) {
        int v = s.length();
        for(int v1 = 0; v1 < v; ++v1) {
            int v2 = s.charAt(v1);
            if(v2 >= 97 && v2 <= 0x7A) {
                char[] arr_c = s.toCharArray();
                while(v1 < v) {
                    int v3 = arr_c[v1];
                    if(v3 >= 97 && v3 <= 0x7A) {
                        arr_c[v1] = (char)(v3 ^ 0x20);
                    }
                    ++v1;
                }
                return String.valueOf(arr_c);
            }
        }
        return s;
    }

    public static final void a(r0.q q0, d0 d00, androidx.compose.runtime.l l0, int v) {
        q.g(d00, "uiState");
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0xAD5DF3A4);
        int v1 = (p0.i(d00) ? 0x20 : 16) | v;
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
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
            androidx.compose.runtime.w.x(p0, y0, P0.j.f);
            androidx.compose.runtime.w.x(p0, i00, P0.j.e);
            P0.h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            androidx.compose.runtime.w.x(p0, q1, P0.j.d);
            a.a.e(androidx.compose.foundation.layout.a.l(r0.n.a, 16.0f, 0.0f, 2), d00.a, p0, 6);
            M.c.d(p0, androidx.compose.foundation.layout.d.h(r0.n.a, 10.0f));
            j0 j00 = androidx.compose.foundation.layout.a.a(16.0f, 0.0f, 2);
            M.g g0 = M.j.h(20.0f);
            boolean z = p0.i(d00);
            Mc.q q2 = p0.N();
            if(z || q2 == androidx.compose.runtime.k.a) {
                q2 = new Mc.q(d00, 6);
                p0.l0(q2);
            }
            c1.q(null, null, j00, g0, null, null, false, q2, p0, 0x6180, 0xEB);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Y(q0, d00, v, 2);
        }
    }

    public static final void b(K k0, r0.q q0, M.i0 i00, Q.m m0, int v, float f, r0.h h0, J.g g0, boolean z, I0.a a0, J.l l0, androidx.compose.foundation.m m1, m0.b b0, androidx.compose.runtime.l l1, int v1, int v2) {
        r0.q q2;
        J.l l3;
        M.i0 i03;
        float f2;
        androidx.compose.foundation.m m6;
        r0.h h3;
        int v9;
        boolean z2;
        Q.m m5;
        J.g g3;
        J.l l2;
        boolean z1;
        float f1;
        J.g g1;
        M.i0 i01;
        r0.q q1;
        androidx.compose.foundation.m m3;
        I0.a a1;
        r0.h h1;
        int v8;
        J.g g2;
        int v6;
        int v5;
        Q.m m2;
        int v4;
        ((androidx.compose.runtime.p)l1).c0(0xAE2A18BC);
        int v3 = (((androidx.compose.runtime.p)l1).g(k0) ? 4 : 2) | v1;
        if((v2 & 2) != 0) {
            v3 |= 0x30;
        }
        else if((v1 & 0x30) == 0) {
            v3 |= (((androidx.compose.runtime.p)l1).g(q0) ? 0x20 : 16);
        }
        if((v2 & 4) != 0) {
            v3 |= 0x180;
        }
        else if((v1 & 0x180) == 0) {
            v3 |= (((androidx.compose.runtime.p)l1).g(i00) ? 0x100 : 0x80);
        }
        if((v2 & 8) == 0) {
            m2 = m0;
            v4 = v3 | (((androidx.compose.runtime.p)l1).g(m2) ? 0x800 : 0x400);
        }
        else {
            v4 = v3 | 0xC00;
            m2 = m0;
        }
        if((v2 & 16) == 0) {
            v6 = v;
            v5 = v4 | (((androidx.compose.runtime.p)l1).e(v6) ? 0x4000 : 0x2000);
        }
        else {
            v5 = v4 | 0x6000;
            v6 = v;
        }
        if((v2 & 0x20) != 0) {
            v5 |= 0x30000;
        }
        else if((v1 & 0x30000) == 0) {
            v5 |= (((androidx.compose.runtime.p)l1).d(f) ? 0x20000 : 0x10000);
        }
        int v7 = v5 | 0x180000 | ((v2 & 0x80) != 0 || !((androidx.compose.runtime.p)l1).g(g0) ? 0x400000 : 0x800000) | 0x36000000;
        if(((androidx.compose.runtime.p)l1).Q(v7 & 1, (v7 & 306783379) != 306783378)) {
            ((androidx.compose.runtime.p)l1).V();
            if((v1 & 1) == 0 || ((androidx.compose.runtime.p)l1).B()) {
                q1 = (v2 & 2) == 0 ? q0 : r0.n.a;
                M.i0 i02 = (v2 & 4) == 0 ? i00 : new j0(0.0f, 0.0f, 0.0f, 0.0f);
                Q.m m4 = (v2 & 8) == 0 ? m2 : (z z0, int v) -> v;
                if((v2 & 16) != 0) {
                    v6 = 0;
                }
                r0.h h2 = r0.d.k;
                if((v2 & 0x80) == 0) {
                    g2 = g0;
                    v8 = v7;
                }
                else {
                    g2 = d5.f.z(k0, null, ((androidx.compose.runtime.p)l1), v7 & 14 | 0x30000, 30);
                    v8 = v7 & 0xFE3FFFFF;
                }
                Q.a a2 = d5.f.L(k0, I.u0.b, ((androidx.compose.runtime.p)l1), v8 & 14 | 0x1B0);
                f1 = (v2 & 0x20) == 0 ? f : 0.0f;
                g1 = g2;
                i01 = i02;
                m3 = E0.a(((androidx.compose.runtime.p)l1));
                l2 = J.l.a;
                h1 = h2;
                a1 = a2;
                m2 = m4;
                z1 = true;
            }
            else {
                ((androidx.compose.runtime.p)l1).T();
                v8 = (v2 & 0x80) == 0 ? v7 : v7 & 0xFE3FFFFF;
                h1 = h0;
                a1 = a0;
                m3 = m1;
                q1 = q0;
                i01 = i00;
                g1 = g0;
                f1 = f;
                z1 = z;
                l2 = l0;
            }
            ((androidx.compose.runtime.p)l1).q();
            b.m(q1, k0, i01, I.u0.b, g1, z1, m3, v6, f1, m2, a1, r0.d.n, h1, l2, b0, ((androidx.compose.runtime.p)l1), v8 >> 3 & 14 | 0x6000 | v8 << 3 & 0x70 | v8 & 0x380 | 0xC00 | v8 >> 6 & 0x70000 | 0x180000 | v8 << 12 & 0xE000000 | v8 << 12 & 0x70000000, v8 >> 9 & 14 | 0x1B6D80);
            g3 = g1;
            m5 = m2;
            z2 = z1;
            v9 = v6;
            h3 = h1;
            m6 = m3;
            f2 = f1;
            i03 = i01;
            l3 = l2;
            q2 = q1;
        }
        else {
            ((androidx.compose.runtime.p)l1).T();
            a1 = a0;
            m6 = m1;
            q2 = q0;
            i03 = i00;
            m5 = m2;
            v9 = v6;
            g3 = g0;
            f2 = f;
            h3 = h0;
            z2 = z;
            l3 = l0;
        }
        androidx.compose.runtime.n0 n00 = ((androidx.compose.runtime.p)l1).t();
        if(n00 != null) {
            n00.d = new Q.q(k0, q2, i03, m5, v9, f2, h3, g3, z2, a1, l3, m6, b0, v1, v2);
        }
    }

    public static final void c(float f, B2.n n0, O2.a a0, O2.a a1, androidx.compose.runtime.l l0, int v) {
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(-12096187);
        if((((p0.d(f) ? 4 : 2) | v | (p0.g(n0) ? 0x20 : 16) | (p0.g(a0) ? 0x100 : 0x80) | (p0.g(a1) ? 0x800 : 0x400)) & 0x493) == 1170 && p0.D()) {
            p0.T();
            goto label_24;
        }
        p0.V();
        if((v & 1) != 0 && !p0.B()) {
            p0.T();
        }
        p0.q();
        p0.b0(0xBD7CCD0A);
        p0.b0(0x7076B8D0);
        if(p0.a instanceof B2.b) {
            p0.Y();
            if(p0.O) {
                p0.l(new D2.y(0, 2));
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, n0, D2.d.E);
            androidx.compose.runtime.w.x(p0, f, D2.d.G);
            androidx.compose.runtime.w.x(p0, a0, D2.d.I);
            androidx.compose.runtime.w.x(p0, a1, D2.d.M);
            p0.p(true);
            p0.p(false);
            p0.p(false);
        label_24:
            androidx.compose.runtime.n0 n00 = p0.t();
            if(n00 != null) {
                n00.d = new z0(f, n0, a0, a1, v);
            }
            return;
        }
        androidx.compose.runtime.w.m();
        throw null;
    }

    public static final void d(String s, String s1, U u0, int v, int v1, boolean z, int v2, we.k k0, androidx.compose.runtime.l l0, int v3) {
        boolean z3;
        int v13;
        int v12;
        boolean z2;
        int v7;
        int v6;
        boolean z1;
        int v5;
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(-108107439);
        int v4 = v3 | (p0.g(s) ? 4 : 2) | (p0.g(s1) ? 0x20 : 16) | (p0.g(u0) ? 0x100 : 0x80) | 0x1B2C00 | (p0.i(k0) ? 0x4000000 : 0x2000000);
        if(p0.Q(v4 & 1, (0x2492493 & v4) != 0x2492492)) {
            p0.V();
            if((v3 & 1) == 0 || p0.B()) {
                v6 = v4 & 0xFFFF1FFF;
                z1 = true;
                v7 = 1;
                v5 = 0x7FFFFFFF;
            }
            else {
                p0.T();
                v5 = v;
                z1 = z;
                v6 = v4 & 0xFFFF1FFF;
                v7 = v1;
            }
            p0.q();
            b0 b00 = p0.N();
            V v8 = androidx.compose.runtime.k.a;
            if(b00 == v8) {
                b00 = androidx.compose.runtime.w.s(s);
                p0.l0(b00);
            }
            M.y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
            int v9 = p0.P;
            i0 i00 = p0.m();
            r0.n n0 = r0.n.a;
            r0.q q0 = r0.a.d(p0, n0);
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
            if(p0.O) {
                z2 = z1;
                A7.d.q(v9, p0, v9, h2);
            }
            else {
                z2 = z1;
                if(!q.b(p0.N(), v9)) {
                    A7.d.q(v9, p0, v9, h2);
                }
            }
            P0.h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q0, h3);
            p0 p00 = M.n0.a(M.j.a, r0.d.l, p0, 0x30);
            int v10 = p0.P;
            i0 i01 = p0.m();
            r0.q q1 = r0.a.d(p0, n0);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p00, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v10)) {
                A7.d.q(v10, p0, v10, h2);
            }
            androidx.compose.runtime.w.x(p0, q1, h3);
            LayoutWeightElement layoutWeightElement0 = new LayoutWeightElement(1.0f, true);
            N0.M m0 = M.p.d(r0.d.a, false);
            int v11 = p0.P;
            i0 i02 = p0.m();
            r0.q q2 = r0.a.d(p0, layoutWeightElement0);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m0, h0);
            androidx.compose.runtime.w.x(p0, i02, h1);
            if(p0.O || !q.b(p0.N(), v11)) {
                A7.d.q(v11, p0, v11, h2);
            }
            androidx.compose.runtime.w.x(p0, q2, h3);
            r0.q q3 = androidx.compose.foundation.q.f(androidx.compose.foundation.layout.d.f(n0, 1.0f), ye.a.v(p0, 0x7F06048A), y0.M.a);  // color:transparent
            String s2 = (String)b00.getValue();
            T t0 = new T(e0.T(p0, 0x7F06017C));  // color:green500s_support_high_contrast
            Ec.j j0 = p0.N();
            if((v6 & 0xE000000) == 0x4000000 || j0 == v8) {
                j0 = new Ec.j(v2, k0, b00);
                p0.l0(j0);
            }
            U.m.b(s2, j0, q3, z2, u0, null, null, false, v5, v7, null, null, t0, null, p0, v6 << 9 & 0x70000 | 0x6000C00, 6, 0xB8D0);
            if(s1.length() <= 0 || ((String)b00.getValue()).length() != 0) {
                p0.a0(0xF1287011);
            }
            else {
                p0.a0(0xF14EEC22);
                N1.b(s1, null, e0.T(p0, 0x7F060159), r1.o.c(u0.a.b), u0.a.c, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, v6 >> 3 & 14, 0, 0x1FFD2);  // color:gray400s_support_high_contrast
            }
            p0.p(false);
            p0.p(true);
            if(v2 == 0x7FFFFFFF) {
                p0.a0(700886219);
            }
            else {
                p0.a0(0x29F318B5);
                N1.b((((String)b00.getValue()).length() + "/" + v2), null, e0.T(p0, 0x7F060159), 12.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF2);  // color:gray400s_support_high_contrast
            }
            p0.p(false);
            p0.p(true);
            M.c.d(p0, androidx.compose.foundation.layout.d.h(n0, 8.0f));
            P4.a.b(androidx.compose.foundation.layout.d.h(n0, 1.0f), e0.T(p0, 0x7F06016D), 0.0f, 0.0f, p0, 6, 12);  // color:gray900s
            p0.p(true);
            v12 = v5;
            v13 = v7;
            z3 = z2;
        }
        else {
            p0.T();
            v12 = v;
            v13 = v1;
            z3 = z;
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new T0(s, s1, u0, v12, v13, z3, v2, k0, v3);
        }
    }

    public static final void e(androidx.compose.foundation.lazy.a a0, u u0, Object object0, r0.q q0, boolean z, Dc.g g0, m0.b b0, androidx.compose.runtime.l l0, int v) {
        r0.q q8;
        boolean z4;
        r0.q q6;
        r0.n n1;
        r0.q q3;
        E e2;
        int v4;
        q.g(a0, "<this>");
        q.g(u0, "movableLazyListState");
        q.g(object0, "key");
        q.g(g0, "bgColor");
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(-1708250172);
        int v1 = (v & 0x30) == 0 ? (p0.i(u0) ? 0x20 : 16) | v : v;
        if((v & 0x180) == 0) {
            v1 |= (p0.i(object0) ? 0x100 : 0x80);
        }
        int v2 = (0x30000 & v) == 0 ? v1 | 0x6C00 | (p0.g(g0) ? 0x20000 : 0x10000) : v1 | 0x6C00;
        if((0x180000 & v) == 0) {
            v2 |= (p0.i(b0) ? 0x100000 : 0x80000);
        }
        if(p0.Q(v2 & 1, (0x92491 & v2) != 0x92490)) {
            E e0 = androidx.compose.runtime.w.i(new Dc.i(1, object0, u0));
            kotlin.jvm.internal.E e1 = new kotlin.jvm.internal.E();  // 初始化器: Ljava/lang/Object;-><init>()V
            Float float0 = p0.N();
            V v3 = androidx.compose.runtime.k.a;
            if(float0 == v3) {
                float0 = 0.0f;
                p0.l0(0.0f);
            }
            e1.a = float0.floatValue();
            boolean z1 = ((Boolean)e0.getValue()).booleanValue();
            wc.u u1 = y0.M.a;
            r0.n n0 = r0.n.a;
            if(z1) {
                p0.a0(0x22FEC86A);
                r0.q q1 = r0.a.e(n0, 1.0f);
                p0.a0(-950888048);
                boolean z2 = p0.i(u0);
                Dc.m m0 = p0.N();
                if(z2 || m0 == v3) {
                    m0 = new Dc.m(u0, 0);
                    p0.l0(m0);
                }
                r0.q q2 = androidx.compose.ui.graphics.a.a(n0, m0);
                p0.p(false);
                v4 = v2;
                e2 = e0;
                q3 = androidx.compose.foundation.q.f(q1.then(q2), g0.a, u1);
                p0.p(false);
                n1 = n0;
            }
            else {
                v4 = v2;
                e2 = e0;
                p0.a0(0xC7530D8C);
                if(object0.equals(((O0)u0.o).getValue())) {
                    p0.a0(0x2306D530);
                    r0.q q4 = r0.a.e(n0, 1.0f);
                    p0.a0(-950871042);
                    boolean z3 = p0.i(u0);
                    Dc.m m1 = p0.N();
                    if(z3 || m1 == v3) {
                        m1 = new Dc.m(u0, 1);
                        p0.l0(m1);
                    }
                    r0.q q5 = androidx.compose.ui.graphics.a.a(n0, m1);
                    p0.p(false);
                    n1 = n0;
                    q6 = androidx.compose.foundation.q.f(q4.then(q5), g0.b, u1);
                    p0.p(false);
                }
                else {
                    n1 = n0;
                    p0.a0(0x230E2DC6);
                    p0.p(false);
                    q6 = n1;
                }
                q3 = androidx.compose.ui.layout.a.d(q6, new A2(e1));
                p0.p(false);
            }
            M.y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
            int v5 = p0.P;
            i0 i00 = p0.m();
            r0.q q7 = r0.a.d(p0, q3);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y0, P0.j.f);
            androidx.compose.runtime.w.x(p0, i00, P0.j.e);
            P0.h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h0);
            }
            androidx.compose.runtime.w.x(p0, q7, P0.j.d);
            Dc.k k0 = new Dc.k(u0, object0, new Ac.U(e1, 11));
            Boolean boolean0 = (Boolean)e2.getValue();
            boolean0.getClass();
            b0.invoke(k0, boolean0, p0, ((int)(v4 >> 12 & 0x380)));
            z4 = true;
            p0.p(true);
            boolean z5 = p0.i(u0);
            boolean z6 = p0.i(object0);
            Dc.o o0 = p0.N();
            if((z5 | (0xE000 & v4) == 0x4000 | z6) != 0 || o0 == v3) {
                o0 = new Dc.o(u0, object0, null);
                p0.l0(o0);
            }
            J.d(p0, Boolean.TRUE, o0);
            q8 = n1;
        }
        else {
            p0.T();
            q8 = q0;
            z4 = z;
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Dc.n(a0, u0, object0, q8, z4, g0, b0, v);
        }
    }

    public static final void f(K k0, r0.q q0, M.i0 i00, Q.m m0, float f, r0.g g0, J.g g1, boolean z, I0.a a0, J.l l0, androidx.compose.foundation.m m1, m0.b b0, androidx.compose.runtime.l l1, int v) {
        J.l l3;
        I0.a a3;
        J.g g6;
        M.i0 i02;
        r0.g g5;
        androidx.compose.foundation.m m4;
        androidx.compose.foundation.m m2;
        J.l l2;
        I0.a a1;
        J.g g3;
        r0.g g2;
        M.i0 i01;
        int v2;
        ((androidx.compose.runtime.p)l1).c0(0x25B8943C);
        int v1 = v | (((androidx.compose.runtime.p)l1).g(k0) ? 4 : 2) | 0x180 | (((androidx.compose.runtime.p)l1).g(m0) ? 0x800 : 0x400) | 0x30586000;
        if(((androidx.compose.runtime.p)l1).Q(v1 & 1, (306783379 & v1) != 306783378)) {
            ((androidx.compose.runtime.p)l1).V();
            if((v & 1) == 0 || ((androidx.compose.runtime.p)l1).B()) {
                j0 j00 = new j0(0.0f, 0.0f, 0.0f, 0.0f);
                J.g g4 = d5.f.z(k0, null, ((androidx.compose.runtime.p)l1), v1 & 14 | 0x30000, 30);
                Q.a a2 = d5.f.L(k0, I.u0.a, ((androidx.compose.runtime.p)l1), v1 & 14 | 0x1B0);
                androidx.compose.foundation.m m3 = E0.a(((androidx.compose.runtime.p)l1));
                a1 = a2;
                g2 = r0.d.n;
                v2 = 0xFE3FFFFF & v1;
                i01 = j00;
                g3 = g4;
                m2 = m3;
                l2 = J.l.a;
            }
            else {
                ((androidx.compose.runtime.p)l1).T();
                v2 = v1 & 0xFE3FFFFF;
                i01 = i00;
                g2 = g0;
                g3 = g1;
                a1 = a0;
                l2 = l0;
                m2 = m1;
            }
            ((androidx.compose.runtime.p)l1).q();
            b.m(q0, k0, i01, I.u0.a, g3, z, m2, 0, f, m0, a1, g2, r0.d.k, l2, b0, ((androidx.compose.runtime.p)l1), v2 << 3 & 0x70 | 907570566, v2 >> 9 & 14 | 0x1B6D80);
            m4 = m2;
            g5 = g2;
            i02 = i01;
            g6 = g3;
            a3 = a1;
            l3 = l2;
        }
        else {
            ((androidx.compose.runtime.p)l1).T();
            i02 = i00;
            g5 = g0;
            g6 = g1;
            a3 = a0;
            l3 = l0;
            m4 = m1;
        }
        androidx.compose.runtime.n0 n00 = ((androidx.compose.runtime.p)l1).t();
        if(n00 != null) {
            n00.d = new Q.r(k0, q0, i02, m0, f, g5, g6, z, a3, l3, m4, b0, v);
        }
    }

    public static void g(Parcel parcel0, Parcelable parcelable0) {
        if(parcelable0 != null) {
            parcel0.writeInt(1);
            parcelable0.writeToParcel(parcel0, 0);
            return;
        }
        parcel0.writeInt(0);
    }

    public static final ie.m h(O.u u0) {
        return new ie.m(0, ((int)(((int)(u0.e() & 0xFFFFFFFFL)) - (-u0.l - u0.q))));
    }

    public static boolean i(Bundle bundle0, Bundle bundle1) {
        if(bundle0 == bundle1) {
            return true;
        }
        if(bundle0 == null) {
            return bundle1.getInt("android.media.browse.extra.PAGE", -1) == -1 && bundle1.getInt("android.media.browse.extra.PAGE_SIZE", -1) == -1;
        }
        return bundle1 == null ? bundle0.getInt("android.media.browse.extra.PAGE", -1) == -1 && bundle0.getInt("android.media.browse.extra.PAGE_SIZE", -1) == -1 : bundle0.getInt("android.media.browse.extra.PAGE", -1) == bundle1.getInt("android.media.browse.extra.PAGE", -1) && bundle0.getInt("android.media.browse.extra.PAGE_SIZE", -1) == bundle1.getInt("android.media.browse.extra.PAGE_SIZE", -1);
    }

    public static Deferred j(n0 n00, me.i i0, we.n n0, int v) {
        if((v & 1) != 0) {
            i0 = me.j.a;
        }
        q.g(n00, "<this>");
        q.g(i0, "context");
        q.g(CoroutineStart.DEFAULT, "start");
        return BuildersKt.async(f0.h(n00), i0, CoroutineStart.DEFAULT, n0);
    }

    public static final void k(int v, String s) {
        if(s.charAt(v) == 45) {
            return;
        }
        StringBuilder stringBuilder0 = U4.x.n(v, "Expected \'-\' (hyphen) at index ", ", but was \'");
        stringBuilder0.append(s.charAt(v));
        stringBuilder0.append('\'');
        throw new IllegalArgumentException(stringBuilder0.toString().toString());
    }

    public static void l(int v) {
        if(2 <= v && v < 37) {
            return;
        }
        StringBuilder stringBuilder0 = U4.x.n(v, "radix ", " was not in valid range ");
        stringBuilder0.append(new Ce.g(2, 36, 1));  // 初始化器: LCe/e;-><init>(III)V
        throw new IllegalArgumentException(stringBuilder0.toString());
    }

    public static int m(int v) {
        int v1 = (v & ~(v >> 0x1F)) - 0xFF;
        return (v1 & v1 >> 0x1F) + 0xFF;
    }

    public static void n(Closeable closeable0) {
        if(closeable0 != null) {
            try {
                closeable0.close();
            }
            catch(IOException unused_ex) {
            }
        }
    }

    public static final Ne.h o(Ne.h h0, Ne.h h1) {
        q.g(h0, "first");
        q.g(h1, "second");
        if(h0.isEmpty()) {
            return h1;
        }
        return h1.isEmpty() ? h0 : new Ne.i(new Ne.h[]{h0, h1});
    }

    public static final int p(x x0) {
        q.g(x0, "<this>");
        Ne.b b0 = x0.getAnnotations().e0(o.q);
        if(b0 == null) {
            return 0;
        }
        Map map0 = b0.a();
        vf.g g0 = (vf.g)C.Q(Je.p.e, map0);
        q.e(g0, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.constants.IntValue");
        return ((Number)((vf.l)g0).a).intValue();
    }

    public static boolean q(File file0, Resources resources0, int v) {
        InputStream inputStream0;
        try {
            inputStream0 = resources0.openRawResource(v);
            return u0.r(inputStream0, file0);
        }
        finally {
            u0.n(inputStream0);
        }
    }

    public static boolean r(InputStream inputStream0, File file0) {
        StrictMode.ThreadPolicy strictMode$ThreadPolicy0 = StrictMode.allowThreadDiskWrites();
        FileOutputStream fileOutputStream0 = null;
        try {
            fileOutputStream0 = new FileOutputStream(file0, false);
            byte[] arr_b = new byte[0x400];
            int v1;
            while((v1 = inputStream0.read(arr_b)) != -1) {
                fileOutputStream0.write(arr_b, 0, v1);
            }
            return true;
        }
        catch(IOException iOException0) {
            Log.e("TypefaceCompatUtil", "Error copying resource contents to temp file: " + iOException0.getMessage());
            return false;
        }
        finally {
            u0.n(fileOutputStream0);
            StrictMode.setThreadPolicy(strictMode$ThreadPolicy0);
        }
    }

    public static Handler s(Looper looper0) {
        if(Build.VERSION.SDK_INT >= 28) {
            return P1.a.a(looper0);
        }
        try {
            return (Handler)Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper0, 0, Boolean.TRUE);
        }
        catch(IllegalAccessException | InstantiationException | NoSuchMethodException illegalAccessException0) {
            Log.w("HandlerCompat", "Unable to invoke Handler(Looper, Callback, boolean) constructor", illegalAccessException0);
            return new Handler(looper0);
        }
        catch(InvocationTargetException invocationTargetException0) {
            Throwable throwable0 = invocationTargetException0.getCause();
            if(throwable0 instanceof RuntimeException) {
                throw (RuntimeException)throwable0;
            }
            if(!(throwable0 instanceof Error)) {
                throw new RuntimeException(throwable0);
            }
            throw (Error)throwable0;
        }
    }

    public static final Hf.B t(i i0, Ne.h h0, x x0, List list0, ArrayList arrayList0, x x1, boolean z) {
        int v = 1;
        ArrayList arrayList1 = new ArrayList(list0.size() + arrayList0.size() + (x0 == null ? 0 : 1) + 1);
        ArrayList arrayList2 = new ArrayList(je.q.Q(10, list0));
        for(Object object0: list0) {
            arrayList2.add(U4.F.j(((x)object0)));
        }
        arrayList1.addAll(arrayList2);
        Qf.k.a(arrayList1, (x0 == null ? null : U4.F.j(x0)));
        int v1 = 0;
        for(Object object1: arrayList0) {
            if(v1 >= 0) {
                arrayList1.add(U4.F.j(((x)object1)));
                ++v1;
                continue;
            }
            e.k.O();
            throw null;
        }
        arrayList1.add(U4.F.j(x1));
        int v2 = arrayList0.size();
        int v3 = list0.size();
        if(x0 == null) {
            v = 0;
        }
        int v4 = v3 + v2 + v;
        e e0 = z ? i0.w(v4) : i0.k("Function" + v4);
        Ne.f f0 = Ne.g.a;
        if(x0 != null) {
            c c0 = o.p;
            if(!h0.c(c0)) {
                ArrayList arrayList3 = je.p.y0(h0, new Ne.j(i0, c0, je.x.a));
                h0 = arrayList3.isEmpty() ? f0 : new Ne.i(arrayList3, 0);
            }
        }
        if(!list0.isEmpty()) {
            int v5 = list0.size();
            c c1 = o.q;
            if(!h0.c(c1)) {
                vf.l l0 = new vf.l(v5);
                ArrayList arrayList4 = je.p.y0(h0, new Ne.j(i0, c1, D.O(new ie.m(Je.p.e, l0))));
                if(!arrayList4.isEmpty()) {
                    f0 = new Ne.i(arrayList4, 0);
                }
                h0 = f0;
            }
        }
        return Hf.c.t(Hf.c.C(h0), e0, arrayList1);
    }

    public static final boolean u(char c, char c1, boolean z) {
        if(c == c1) {
            return true;
        }
        if(!z) {
            return false;
        }
        int v = Character.toUpperCase(c);
        int v1 = Character.toUpperCase(c1);
        return v == v1 || Character.toLowerCase(((char)v)) == Character.toLowerCase(((char)v1));
    }

    public static boolean v(CharSequence charSequence0, String s) {
        int v = charSequence0.length();
        if(charSequence0 != s) {
            if(v == s.length()) {
                for(int v1 = 0; v1 < v; ++v1) {
                    int v2 = charSequence0.charAt(v1);
                    int v3 = s.charAt(v1);
                    if(v2 != v3) {
                        int v4 = (char)((v2 | 0x20) - 97);
                        if(v4 < 26 && v4 == ((char)((v3 | 0x20) - 97))) {
                            continue;
                        }
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public static final void w(String s, G4.a a0) {
        q.g(a0, "<this>");
        q.g(s, "sql");
        G4.c c0 = a0.l0(s);
        try {
            c0.j0();
        }
        catch(Throwable throwable0) {
            e1.x.y(c0, throwable0);
            throw throwable0;
        }
        e1.x.y(c0, null);
    }

    public static final qf.e x(x x0) {
        Ne.b b0 = x0.getAnnotations().e0(o.r);
        if(b0 != null) {
            Object object0 = je.p.F0(b0.a().values());
            vf.y y0 = object0 instanceof vf.y ? ((vf.y)object0) : null;
            if(y0 != null) {
                String s = (String)y0.a;
                if(s != null) {
                    if(!qf.e.f(s)) {
                        s = null;
                    }
                    return s == null ? null : qf.e.e(s);
                }
            }
        }
        return null;
    }

    public static final String y(Uri uri0, String s) {
        Set set0 = uri0.getQueryParameterNames();
        q.f(set0, "getQueryParameterNames(...)");
        int v = D.N(je.q.Q(10, set0));
        if(v < 16) {
            v = 16;
        }
        LinkedHashMap linkedHashMap0 = new LinkedHashMap(v);
        for(Object object0: set0) {
            linkedHashMap0.put(object0, uri0.getQueryParameter(((String)object0)));
        }
        return (String)linkedHashMap0.get(s);
    }

    public static final void z(long v, byte[] arr_b, int v1, int v2, int v3) {
        int v4 = 7 - v2;
        if(8 - v3 <= v4) {
            while(true) {
                int v5 = Tf.d.a[((int)(v >> (v4 << 3) & 0xFFL))];
                int v6 = v1 + 1;
                arr_b[v1] = (byte)(v5 >> 8);
                v1 += 2;
                arr_b[v6] = (byte)v5;
                if(v4 == 8 - v3) {
                    break;
                }
                --v4;
            }
        }
    }
}

