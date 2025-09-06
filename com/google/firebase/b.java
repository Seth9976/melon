package com.google.firebase;

import Ac.U2;
import Ac.X;
import Cc.E;
import Cc.N1;
import Cc.c1;
import Cc.e0;
import Cc.m3;
import Cc.w0;
import D2.C;
import D2.D;
import D2.U;
import D2.V;
import D2.s;
import D4.o;
import D4.r;
import E9.w;
import Ec.d;
import H0.e;
import Hd.F0;
import He.g;
import Hf.B;
import I.L;
import I.u0;
import M.j;
import M.p0;
import M.y;
import M6.v;
import M6.x;
import Me.S;
import N0.M;
import Nc.C1;
import Nc.N;
import P0.I;
import P0.d0;
import P0.h;
import P0.n;
import P0.z0;
import Q.K;
import Q.Q;
import Q.t;
import Q.z;
import U4.F;
import U8.G;
import V4.u;
import Vc.s0;
import a.a;
import android.content.Context;
import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.util.Log;
import android.view.Window;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.VerticalAlignElement;
import androidx.compose.runtime.J;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.b1;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.glance.appwidget.GlanceAppWidgetManager;
import coil.request.ImageRequest.Builder;
import com.google.android.gms.cast.CastStatusCodes;
import com.iloen.melon.custom.l1;
import com.iloen.melon.net.v4x.common.HeaderBase;
import com.iloen.melon.net.v4x.common.LogoImageType;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.time.TimeUtils;
import com.iloen.melon.utils.ui.ViewUtilsKt;
import com.kakao.tiara.data.ActionKind;
import d5.f;
import e1.m;
import i.n.i.b.a.s.e.M3;
import ie.H;
import java.io.FileDescriptor;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Future;
import je.A;
import jeb.synthetic.TWR;
import ke.i;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import oe.c;
import r0.p;
import w8.T;

public abstract class b {
    public static final int a;
    public static final int b;
    public static Thread c;

    public static final void A(Window window0) {
        if(Build.VERSION.SDK_INT < 35) {
            e.W(window0, false);
        }
    }

    public static final Object B(Context context0, Class class0) {
        q.g(context0, "context");
        return w.s(a.w(context0.getApplicationContext()), class0);
    }

    public static final int C(g g0) {
        q.g(g0, "<this>");
        return g0.a().size();
    }

    public static Object D(Future future0) {
        if(!future0.isDone()) {
            throw new IllegalStateException(ye.a.O("Future was expected to be done: %s", new Object[]{future0}));
        }
        return f.H(future0);
    }

    public static final z0 E(I i0) {
        d0 d00 = i0.b0;
        if((((p)d00.f).getAggregateChildKindSet$ui_release() & 8) != 0) {
            p p0 = (p)d00.f;
            while(p0 != null) {
                if((p0.getKindSet$ui_release() & 8) != 0) {
                    p p1 = p0;
                    g0.e e0 = null;
                    while(p1 != null) {
                        if(p1 instanceof z0) {
                            if(((z0)p1).l0()) {
                                return (z0)p1;
                            }
                        }
                        else if((p1.getKindSet$ui_release() & 8) != 0 && p1 instanceof n) {
                            p p2 = ((n)p1).b;
                            int v = 0;
                            while(p2 != null) {
                                if((p2.getKindSet$ui_release() & 8) != 0) {
                                    ++v;
                                    if(v == 1) {
                                        p1 = p2;
                                    }
                                    else {
                                        if(e0 == null) {
                                            e0 = new g0.e(new p[16]);
                                        }
                                        if(p1 != null) {
                                            e0.b(p1);
                                            p1 = null;
                                        }
                                        e0.b(p2);
                                    }
                                }
                                p2 = p2.getChild$ui_release();
                            }
                            if(v != 1) {
                                goto label_29;
                            }
                            continue;
                        }
                    label_29:
                        p1 = P0.f.f(e0);
                    }
                }
                if((p0.getAggregateChildKindSet$ui_release() & 8) == 0) {
                    break;
                }
                p0 = p0.getChild$ui_release();
            }
        }
        return null;
    }

    public static Object F(Bundle bundle0, String s, Class class0) {
        if(Build.VERSION.SDK_INT >= 34) {
            return P1.e.b(bundle0, s, class0);
        }
        Parcelable parcelable0 = bundle0.getParcelable(s);
        return class0.isInstance(parcelable0) ? parcelable0 : null;
    }

    public static Serializable G(Bundle bundle0, String s, Class class0) {
        if(Build.VERSION.SDK_INT >= 34) {
            return P1.e.e(bundle0, s, class0);
        }
        Serializable serializable0 = bundle0.getSerializable(s);
        return class0.isInstance(serializable0) ? serializable0 : null;
    }

    public static v H() {
        return v.h == null ? new v() : v.h;
    }

    public static x I(Object object0) {
        return object0 == null ? x.b : new x(object0);
    }

    public static boolean J(byte b) {
        return b > -65;
    }

    public static Bitmap K(int v, ParcelFileDescriptor parcelFileDescriptor0, int v1) {
        Bitmap bitmap0 = null;
        if(parcelFileDescriptor0 == null) {
            throw null;
        }
        else {
            try {
                try {
                    BitmapFactory.Options bitmapFactory$Options0 = new BitmapFactory.Options();
                    FileDescriptor fileDescriptor0 = parcelFileDescriptor0.getFileDescriptor();
                    bitmapFactory$Options0.inJustDecodeBounds = true;
                    com.iloen.melon.activity.crop.b.b().a(fileDescriptor0, bitmapFactory$Options0);
                    if(!bitmapFactory$Options0.mCancel && bitmapFactory$Options0.outWidth != -1 && bitmapFactory$Options0.outHeight != -1) {
                        bitmapFactory$Options0.inSampleSize = b.t(bitmapFactory$Options0, v, v1);
                        bitmapFactory$Options0.inJustDecodeBounds = false;
                        bitmapFactory$Options0.inDither = false;
                        bitmapFactory$Options0.inPreferredConfig = Bitmap.Config.ARGB_8888;
                        bitmap0 = com.iloen.melon.activity.crop.b.b().a(fileDescriptor0, bitmapFactory$Options0);
                    }
                }
                catch(OutOfMemoryError outOfMemoryError0) {
                    Log.e("Util", "Got oom exception ", outOfMemoryError0);
                }
                try {
                    parcelFileDescriptor0.close();
                }
                catch(Throwable unused_ex) {
                }
                return bitmap0;
            }
            catch(Throwable throwable0) {
            }
        }
        TWR.safeClose$NT(parcelFileDescriptor0, throwable0);
        throw throwable0;
    }

    // 去混淆评级： 低(40)
    public static final String L(J9.f f0) {
        return "/types/MELON/chats/";
    }

    public static final void M(m0.b b0, c c0) {
        U u0;
        if(c0 instanceof U) {
            u0 = (U)c0;
            int v = u0.w;
            if((v & 0x80000000) == 0) {
                u0 = new U(c0);  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
            }
            else {
                u0.w = v ^ 0x80000000;
            }
        }
        else {
            u0 = new U(c0);  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
        }
        Object object0 = u0.r;
        switch(u0.w) {
            case 0: {
                d5.n.D(object0);
                D d0 = (D)u0.getContext().get(C.a);
                if(d0 == null) {
                    throw new IllegalStateException("provideContent requires a ContentReceiver and should only be called from GlanceAppWidget.provideGlance");
                }
                u0.w = 1;
                ((s)d0).a(b0, u0);
                return;
            }
            case 1: {
                d5.n.D(object0);
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public static r N(String s, G4.a a0) {
        i i3;
        i i2;
        i i1;
        je.x x0;
        q.g(a0, "connection");
        G4.c c0 = a0.l0("PRAGMA table_info(`" + s + "`)");
        try {
            if(c0.j0()) {
                int v = F.l(c0, "name");
                int v1 = F.l(c0, "type");
                int v2 = F.l(c0, "notnull");
                int v3 = F.l(c0, "pk");
                int v4 = F.l(c0, "dflt_value");
                ke.e e0 = new ke.e();
                do {
                    String s1 = c0.S(v);
                    String s2 = c0.S(v1);
                    boolean z = c0.getLong(v2) != 0L;
                    e0.put(s1, new o(((int)c0.getLong(v3)), s1, s2, (c0.isNull(v4) ? null : c0.S(v4)), z, 2));
                }
                while(c0.j0());
                x0 = e0.b();
            }
            else {
                x0 = je.x.a;
            }
        }
        catch(Throwable throwable0) {
            e1.x.y(c0, throwable0);
            throw throwable0;
        }
        e1.x.y(c0, null);
        G4.c c1 = a0.l0("PRAGMA foreign_key_list(`" + s + "`)");
        try {
            int v5 = F.l(c1, "id");
            int v6 = F.l(c1, "seq");
            int v7 = F.l(c1, "table");
            int v8 = F.l(c1, "on_delete");
            int v9 = F.l(c1, "on_update");
            List list0 = u.A(c1);
            c1.reset();
            i i0 = new i();
            while(c1.j0()) {
                if(c1.getLong(v6) == 0L) {
                    int v10 = (int)c1.getLong(v5);
                    ArrayList arrayList0 = new ArrayList();
                    ArrayList arrayList1 = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    for(Object object0: list0) {
                        if(((D4.n)object0).a == v10) {
                            arrayList2.add(object0);
                        }
                    }
                    for(Object object1: arrayList2) {
                        arrayList0.add(((D4.n)object1).c);
                        arrayList1.add(((D4.n)object1).d);
                    }
                    i0.add(new D4.p(c1.S(v7), c1.S(v8), c1.S(v9), arrayList0, arrayList1));
                }
            }
            i1 = m.k(i0);
        }
        catch(Throwable throwable1) {
            e1.x.y(c1, throwable1);
            throw throwable1;
        }
        e1.x.y(c1, null);
        G4.c c2 = a0.l0("PRAGMA index_list(`" + s + "`)");
        try {
            int v11 = F.l(c2, "name");
            int v12 = F.l(c2, "origin");
            int v13 = F.l(c2, "unique");
            if(v11 != -1 && v12 != -1 && v13 != -1) {
                i2 = new i();
                while(true) {
                    if(!c2.j0()) {
                        goto label_71;
                    }
                    if("c".equals(c2.S(v12))) {
                        D4.q q0 = u.B(a0, c2.S(v11), c2.getLong(v13) == 1L);
                        if(q0 == null) {
                            goto label_69;
                        }
                        i2.add(q0);
                    }
                }
            }
            goto label_78;
        }
        catch(Throwable throwable2) {
            e1.x.y(c2, throwable2);
            throw throwable2;
        }
    label_69:
        e1.x.y(c2, null);
        return new r(s, x0, i1, null);
        try {
        label_71:
            i3 = m.k(i2);
        }
        catch(Throwable throwable2) {
            e1.x.y(c2, throwable2);
            throw throwable2;
        }
        e1.x.y(c2, null);
        return new r(s, x0, i1, i3);
    label_78:
        e1.x.y(c2, null);
        return new r(s, x0, i1, null);
    }

    public static void O(p8.f f0, Context context0, String s, String s1, ActionKind actionKind0, String s2, int v, String s3, String s4, String s5, String s6, String s7, boolean z, int v1, int v2) {
        String s8 = null;
        String s9 = (v2 & 2) == 0 ? s : null;
        ActionKind actionKind1 = (v2 & 8) == 0 ? actionKind0 : null;
        String s10 = (v2 & 16) == 0 ? s2 : null;
        int v3 = (v2 & 0x20) == 0 ? v : -1;
        String s11 = (v2 & 0x40) == 0 ? s3 : null;
        String s12 = (v2 & 0x80) == 0 ? s4 : null;
        String s13 = (v2 & 0x100) == 0 ? s5 : null;
        String s14 = (v2 & 0x200) == 0 ? s6 : null;
        String s15 = (v2 & 0x400) == 0 ? s7 : null;
        int v4 = (v2 & 0x1000) == 0 ? v1 : -1;
        if(ActionKind.PlayMusic == actionKind1) {
            f0.a = context0 == null ? null : "음악재생";
        }
        else {
            if(s9 == null) {
                s9 = context0 == null ? null : "페이지이동";
            }
            f0.a = s9;
        }
        if(actionKind1 != null) {
            f0.d = actionKind1;
        }
        f0.y = s1;
        if(s10 != null && s10.length() != 0) {
            f0.F = Tf.v.p0(s10, " ", "");
        }
        if(v3 > -1) {
            f0.c(v3 + 1);
        }
        if(s11 != null && s11.length() != 0) {
            f0.e = s11;
        }
        if(s12 != null && s12.length() != 0) {
            f0.f = s12;
        }
        if(s13 != null && s13.length() != 0) {
            f0.g = s13;
        }
        if(s14 != null && s14.length() != 0) {
            f0.h = s14;
        }
        if(s15 != null && s15.length() != 0) {
            f0.i = s15;
        }
        if(actionKind1 == ActionKind.Like) {
            if(!((v2 & 0x800) == 0 ? z : false)) {
                if(context0 != null) {
                    s8 = context0.getString(0x7F130FCC);  // string:tiara_props_dislike "dislike"
                }
            }
            else if(context0 != null) {
                s8 = context0.getString(0x7F130FCD);  // string:tiara_props_like "like"
            }
            f0.U = s8;
        }
        if(v4 > -1) {
            f0.D = String.valueOf(v4 + 1);
        }
        f0.a().track();
    }

    public static final Object P(T t0, Context context0, c c0) {
        Iterator iterator0;
        T t1;
        V v0;
        if(c0 instanceof V) {
            v0 = (V)c0;
            int v1 = v0.E;
            if((v1 & 0x80000000) == 0) {
                v0 = new V(c0);  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
            }
            else {
                v0.E = v1 ^ 0x80000000;
            }
        }
        else {
            v0 = new V(c0);  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
        }
        Serializable serializable0 = v0.D;
        ne.a a0 = ne.a.a;
    alab1:
        switch(v0.E) {
            case 0: {
                d5.n.D(serializable0);
                GlanceAppWidgetManager glanceAppWidgetManager0 = new GlanceAppWidgetManager(context0);
                Class class0 = t0.getClass();
                v0.r = t0;
                v0.w = context0;
                v0.E = 1;
                serializable0 = glanceAppWidgetManager0.a(class0, v0);
                if(serializable0 != a0) {
                    t1 = t0;
                    iterator0 = ((Iterable)serializable0).iterator();
                    goto label_34;
                }
                break;
            }
            case 1: {
                context0 = v0.w;
                t0 = v0.r;
                d5.n.D(serializable0);
                t1 = t0;
                iterator0 = ((Iterable)serializable0).iterator();
                goto label_34;
            }
            case 2: {
                iterator0 = v0.B;
                context0 = v0.w;
                t1 = v0.r;
                d5.n.D(serializable0);
                while(true) {
                label_34:
                    if(!iterator0.hasNext()) {
                        return H.a;
                    }
                    Object object0 = iterator0.next();
                    v0.r = t1;
                    v0.w = context0;
                    v0.B = iterator0;
                    v0.E = 2;
                    if(t1.g(context0, ((D2.f)object0), v0) == a0) {
                        break alab1;
                    }
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return a0;
    }

    public static final void a(r0.q q0, List list0, long v, float f, float f1, l l0, int v1, int v2) {
        float f5;
        float f4;
        long v6;
        r0.q q1;
        float f2;
        ((androidx.compose.runtime.p)l0).c0(0x27080640);
        int v3 = v1 | 6 | (((androidx.compose.runtime.p)l0).i(list0) ? 0x20 : 16);
        int v4 = v3 | 0xD80;
        if((v2 & 0x20) != 0) {
            v4 = 200064 | v3;
            f2 = f1;
        }
        else if((v1 & 0x30000) == 0) {
            f2 = f1;
            v4 |= (((androidx.compose.runtime.p)l0).d(f2) ? 0x20000 : 0x10000);
        }
        else {
            f2 = f1;
        }
        if(((androidx.compose.runtime.p)l0).Q(v4 & 1, (66707 & v4) != 66706)) {
            if((v2 & 0x20) != 0) {
                f2 = 8.0f;
            }
            if(list0.isEmpty()) {
                n0 n00 = ((androidx.compose.runtime.p)l0).t();
                if(n00 != null) {
                    n00.d = new Ec.c(list0, 16L, 1.0f, f2, v1, v2);
                }
            }
            else {
                O.F f3 = O.I.a(0, 0, 3, ((androidx.compose.runtime.p)l0));
                M.g g0 = j.h(f2);
                boolean z = ((androidx.compose.runtime.p)l0).i(list0);
                Bd.l l1 = ((androidx.compose.runtime.p)l0).N();
                androidx.compose.runtime.V v5 = k.a;
                if(z || l1 == v5) {
                    l1 = new Bd.l(list0, 1);
                    ((androidx.compose.runtime.p)l0).l0(l1);
                }
                r0.n n0 = r0.n.a;
                c1.q(n0, f3, null, g0, null, null, false, l1, ((androidx.compose.runtime.p)l0), 0xC00006, 108);
                boolean z1 = ((androidx.compose.runtime.p)l0).g(f3);
                Ec.e e0 = ((androidx.compose.runtime.p)l0).N();
                if(z1 || e0 == v5) {
                    Ec.e e1 = new Ec.e(16L, f3, 1.0f, null);
                    ((androidx.compose.runtime.p)l0).l0(e1);
                    e0 = e1;
                }
                J.d(((androidx.compose.runtime.p)l0), H.a, e0);
                q1 = n0;
                v6 = 16L;
                f4 = 1.0f;
                f5 = f2;
                goto label_47;
            }
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
            q1 = q0;
            v6 = v;
            f4 = f;
            f5 = f2;
        label_47:
            n0 n01 = ((androidx.compose.runtime.p)l0).t();
            if(n01 != null) {
                n01.d = new d(q1, list0, v6, f4, f5, v1, v2);
            }
        }
    }

    public static C0.a b(y0.e e0, int v) {
        C0.a a0 = new C0.a(e0, ((long)e0.a.getWidth()) << 0x20 | ((long)e0.a.getHeight()) & 0xFFFFFFFFL);
        a0.c = v;
        return a0;
    }

    public static final void c(List list0, String s, float f, float f1, int v, we.a a0, l l0, int v1) {
        int v5;
        float f3;
        float f2;
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0x2BA16B14);
        int v2 = v1 | (p0.i(list0) ? 4 : 2) | (p0.g(s) ? 0x20 : 16) | 0xD80 | (p0.i(a0) ? 0x20000 : 0x10000);
        if(p0.Q(v2 & 1, (66707 & v2) != 66706)) {
            f2 = 144.0f;
            r0.n n0 = r0.n.a;
            r0.q q0 = androidx.compose.foundation.layout.d.o(n0, 144.0f, 215.0f);
            M m0 = M.p.d(r0.d.a, false);
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
            h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, m0, h0);
            h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q1, h3);
            Bc.d d0 = p0.N();
            if((0x70000 & v2) == 0x20000 || d0 == k.a) {
                d0 = new Bc.d(9, a0);
                p0.l0(d0);
            }
            e0.w(list0, 0.0f, 0.0f, 0, d0, p0, v2 & 14);
            if(s.length() > 0) {
                p0.a0(0x717E8FAB);
                r0.q q2 = androidx.compose.foundation.layout.a.n((androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(n0, r0.d.h), 12.0f, 0.0f, 12.0f, 14.0f, 2);
                p0 p00 = M.n0.a(j.a, r0.d.j, p0, 0);
                int v4 = p0.P;
                i0 i01 = p0.m();
                r0.q q3 = r0.a.d(p0, q2);
                p0.e0();
                if(p0.O) {
                    p0.l(i0);
                }
                else {
                    p0.o0();
                }
                androidx.compose.runtime.w.x(p0, p00, h0);
                androidx.compose.runtime.w.x(p0, i01, h1);
                if(p0.O || !q.b(p0.N(), v4)) {
                    A7.d.q(v4, p0, v4, h2);
                }
                androidx.compose.runtime.w.x(p0, q3, h3);
                N1.b(s, new LayoutWeightElement(1.0f, true), e0.T(p0, 0x7F06016D), 13.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, v2 >> 3 & 14 | 0xC00, 0xC30, 0x1D7F0);  // color:gray900s
                c1.n(androidx.compose.foundation.layout.d.n(n0, 16.0f), 0x7F08008D, null, null, false, 0, null, null, null, 0.0f, new y0.k(e0.T(p0, 0x7F0604A1), 5), 0, 0, false, false, p0, 54, 0, 0x7BFC);  // drawable:arrow_common_menu
                p0.p(true);
            }
            else {
                p0.a0(1902979016);
            }
            p0.p(false);
            p0.p(true);
            f3 = 215.0f;
            v5 = 3000;
        }
        else {
            p0.T();
            f2 = f;
            f3 = f1;
            v5 = v;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new a(list0, s, f2, f3, v5, a0, v1);
        }
    }

    public static final void d(N n0, l l0, int v) {
        q.g(n0, "uiState");
        ArrayList arrayList0 = n0.b;
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(-88004816);
        int v1 = (p0.i(n0) ? 0x20 : 16) | v;
        boolean z = false;
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            int v2 = arrayList0.size();
            boolean z1 = p0.e(v2);
            Nc.M m0 = p0.N();
            androidx.compose.runtime.V v3 = k.a;
            if(z1 || m0 == v3) {
                m0 = new Nc.M(v2, 0);
                p0.l0(m0);
            }
            b0 b00 = (b0)d5.w.P(new Object[0], null, null, m0, p0, 0, 6);
            r0.n n1 = r0.n.a;
            r0.q q0 = androidx.compose.foundation.layout.a.l(n1, 16.0f, 0.0f, 2);
            y y0 = M.w.a(j.c, r0.d.m, p0, 0);
            int v4 = p0.P;
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
            h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h0);
            }
            androidx.compose.runtime.w.x(p0, q1, P0.j.d);
            a.e(n1, n0.a, p0, 6);
            M.c.d(p0, androidx.compose.foundation.layout.d.h(n1, 4.0f));
            p0.a0(-2040514701);
            for(Object object0: je.p.K0(((Number)b00.getValue()).intValue(), arrayList0)) {
                Nc.T.a(null, ((Nc.U)object0), p0, 0);
            }
            p0.p(false);
            r0.q q2 = androidx.compose.foundation.layout.a.n(n1, 0.0f, 9.0f, 0.0f, 0.0f, 13);
            if(((Number)b00.getValue()).intValue() >= v2 || ((Number)b00.getValue()).intValue() >= 15) {
                z = true;
            }
            boolean z2 = p0.i(n0);
            boolean z3 = p0.g(b00);
            boolean z4 = p0.e(v2);
            F0 f00 = p0.N();
            if((z2 | z3 | z4) != 0 || f00 == v3) {
                f00 = new F0(n0, v2, b00, 3);
                p0.l0(f00);
            }
            a.c(6, p0, q2, f00, z);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new C8.a(n0, v, 18);
        }
    }

    public static final void e(r0.q q0, String s, int v, N0.k k0, l l0, int v1, int v2) {
        N0.k k1;
        q.g(s, "imageUrl");
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0x5BB1C7A2);
        int v3 = (p0.g(q0) ? 4 : 2) | v1;
        if((v1 & 0x30) == 0) {
            v3 |= (p0.g(s) ? 0x20 : 16);
        }
        if((v2 & 8) != 0) {
            v3 |= 0xC00;
            k1 = k0;
        }
        else if((v1 & 0xC00) == 0) {
            k1 = k0;
            v3 |= (p0.g(k1) ? 0x800 : 0x400);
        }
        else {
            k1 = k0;
        }
        if(p0.Q(v3 & 1, (v3 & 0x493) != 1170)) {
            N0.k k2 = (v2 & 8) == 0 ? k1 : N0.j.b;
            M m0 = M.p.d(r0.d.a, false);
            int v4 = p0.P;
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
            h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h0);
            }
            androidx.compose.runtime.w.x(p0, q1, P0.j.d);
            r0.q q2 = d5.n.p((androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(androidx.compose.foundation.layout.d.c, r0.d.e));
            androidx.compose.foundation.q.c(De.I.Q(v, p0, 6), null, q2, null, N0.j.f, 0.0f, null, p0, 0x6030, 104);
            ImageRequest.Builder imageRequest$Builder0 = new ImageRequest.Builder(((Context)p0.k(AndroidCompositionLocals_androidKt.b)));
            imageRequest$Builder0.c = s;
            imageRequest$Builder0.j = new w5.a(100);
            j5.n.b(imageRequest$Builder0.a(), null, androidx.compose.foundation.layout.d.c, null, k2, null, p0, v3 << 9 & 0x380000 | 0x1B0, 0xFB8);
            p0.p(true);
            k1 = k2;
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new C1(q0, s, v, k1, v1, v2);
        }
    }

    public static final void f(int v, l l0, String s, r0.q q0) {
        q.g(s, "imageUrl");
        ((androidx.compose.runtime.p)l0).c0(0xB1741720);
        int v1 = ((v & 6) == 0 ? (((androidx.compose.runtime.p)l0).g(q0) ? 4 : 2) | v : v) | (((androidx.compose.runtime.p)l0).g(s) ? 0x20 : 16);
        if(((androidx.compose.runtime.p)l0).Q(v1 & 1, (v1 & 19) != 18)) {
            b.e(q0.then(androidx.compose.foundation.q.f(e0.L(r0.n.a, 0x7F06014A), e0.T(((androidx.compose.runtime.p)l0), 0x7F060145), y0.M.a)), s, 0x7F08078D, N0.j.b, ((androidx.compose.runtime.p)l0), v1 & 0x70 | 0xD80, 0);  // color:gray100a
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
        }
        n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new w0(q0, s, v, 4);
        }
    }

    public static final void g(int v, l l0, String s, r0.q q0) {
        q.g(s, "imageUrl");
        ((androidx.compose.runtime.p)l0).c0(0x4A4E5F5F);
        int v1 = (((androidx.compose.runtime.p)l0).g(q0) ? 4 : 2) | v | (((androidx.compose.runtime.p)l0).g(s) ? 0x20 : 16);
        if(((androidx.compose.runtime.p)l0).Q(v1 & 1, (v1 & 19) != 18)) {
            r0.q q1 = d5.n.o(r0.n.a, T.e.a);
            androidx.compose.foundation.y y0 = androidx.compose.foundation.q.a(e0.T(((androidx.compose.runtime.p)l0), 0x7F060032), 1.0f);  // color:black_04
            b.e(q0.then(androidx.compose.foundation.q.f(androidx.compose.foundation.q.j(q1, y0.a, y0.b, T.e.a), e0.T(((androidx.compose.runtime.p)l0), 0x7F060145), y0.M.a)), s, 0x7F0807A2, N0.j.b, ((androidx.compose.runtime.p)l0), v1 & 0x70 | 0xD80, 0);  // color:gray050s
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
        }
        n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new Ac.h(q0, s, v, 2);
        }
    }

    public static final long h(int v) [...] // Inlined contents

    public static final void i(Drawable drawable0, float f, y0.s s0, String s1, l l0, int v) {
        ((androidx.compose.runtime.p)l0).c0(0x67750157);
        int v1 = v | (((androidx.compose.runtime.p)l0).i(drawable0) ? 4 : 2) | (((androidx.compose.runtime.p)l0).g(s0) ? 0x100 : 0x80) | (((androidx.compose.runtime.p)l0).g(s1) ? 0x800 : 0x400);
        boolean z = true;
        if(((androidx.compose.runtime.p)l0).Q(v1 & 1, (v1 & 0x493) != 1170)) {
            N0.i i0 = drawable0.getIntrinsicHeight() < ViewUtilsKt.dpToPx(f) ? N0.j.b : N0.j.c;
            r0.n n0 = r0.n.a;
            androidx.compose.runtime.V v2 = k.a;
            if(s0 == null) {
                ((androidx.compose.runtime.p)l0).a0(0x690B33EB);
                r0.q q0 = androidx.compose.foundation.layout.d.h(n0, f);
                if((v1 & 0x1C00) != 0x800) {
                    z = false;
                }
                Ac.g g0 = ((androidx.compose.runtime.p)l0).N();
                if(z || g0 == v2) {
                    g0 = new Ac.g(s1, 28);
                    ((androidx.compose.runtime.p)l0).l0(g0);
                }
                r0.q q1 = X0.n.c(q0, false, g0);
                androidx.compose.foundation.q.c(L5.c.a(drawable0, ((androidx.compose.runtime.p)l0)), null, q1, null, i0, 0.0f, null, ((androidx.compose.runtime.p)l0), 0x30, 104);
            }
            else {
                ((androidx.compose.runtime.p)l0).a0(1762730514);
                r0.q q2 = androidx.compose.foundation.layout.d.h(n0, f);
                if((v1 & 0x1C00) != 0x800) {
                    z = false;
                }
                Ac.g g1 = ((androidx.compose.runtime.p)l0).N();
                if(z || g1 == v2) {
                    g1 = new Ac.g(s1, 29);
                    ((androidx.compose.runtime.p)l0).l0(g1);
                }
                r0.q q3 = X0.n.c(q2, false, g1);
                androidx.compose.foundation.q.c(L5.c.a(drawable0, ((androidx.compose.runtime.p)l0)), null, q3, null, i0, 0.0f, new y0.k(s0.a, 5), ((androidx.compose.runtime.p)l0), 0x30, 40);
            }
            ((androidx.compose.runtime.p)l0).p(false);
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
        }
        n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new G(drawable0, f, s0, s1, v);
        }
    }

    public static final void j(bd.s s0, l l0, int v) {
        androidx.compose.runtime.V v15;
        h h13;
        h h12;
        h h11;
        h h10;
        P0.i i3;
        HeaderBase headerBase2;
        Context context0;
        androidx.compose.runtime.V v8;
        b0 b02;
        r0.h h9;
        boolean z1;
        String s3;
        h h8;
        P0.i i2;
        h h7;
        h h6;
        HeaderBase headerBase1;
        h h5;
        Long long1;
        h h14;
        androidx.compose.runtime.V v5;
        y0.s s2;
        r0.i i0 = r0.d.a;
        q.g(s0, "uiState");
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0xA98A0F78);
        int v1 = v | (p0.i(s0) ? 4 : 2);
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            androidx.compose.runtime.c1 c10 = AndroidCompositionLocals_androidKt.b;
            Object object0 = p0.k(c10);
            HeaderBase headerBase0 = s0.a;
            boolean z = s0.h;
            b0 b00 = p0.N();
            androidx.compose.runtime.V v2 = k.a;
            if(b00 == v2) {
                b00 = androidx.compose.runtime.w.s(null);
                p0.l0(b00);
            }
            b0 b01 = p0.N();
            if(b01 == v2) {
                b01 = androidx.compose.runtime.w.s(null);
                p0.l0(b01);
            }
            String s1 = !ScreenUtils.isDarkMode(((Context)object0)) || (headerBase0.logoDarkImg == null || headerBase0.logoDarkImg.length() == 0) ? headerBase0.logoImg : headerBase0.logoDarkImg;
            if(LogoImageType.webp == headerBase0.logoImageType) {
                p0.a0(2034672549);
                p0.p(false);
                s2 = null;
            }
            else {
                p0.a0(1866750307);
                long v3 = y0.M.c(ColorUtils.getColor(((Context)p0.k(c10)), 0x7F060172));  // color:gray990s
                p0.p(false);
                s2 = new y0.s(v3);
            }
            r0.n n0 = r0.n.a;
            r0.q q0 = androidx.compose.foundation.layout.a.l(androidx.compose.foundation.layout.d.f(n0, 1.0f), 20.0f, 0.0f, 2);
            M.b b0 = j.a;
            p0 p00 = M.n0.a(b0, r0.d.l, p0, 0x30);
            int v4 = p0.P;
            r0.h h0 = r0.d.l;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            P0.i i1 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            h h1 = P0.j.f;
            androidx.compose.runtime.w.x(p0, p00, h1);
            h h2 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h2);
            h h3 = P0.j.g;
            if(p0.O) {
                v5 = v2;
                A7.d.q(v4, p0, v4, h3);
            }
            else {
                v5 = v2;
                if(!q.b(p0.N(), v4)) {
                    A7.d.q(v4, p0, v4, h3);
                }
            }
            h h4 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q1, h4);
            r0.q q2 = U4.x.r(1.0f, androidx.compose.foundation.layout.d.f(n0, 1.0f), true);
            y y0 = M.w.a(j.c, r0.d.m, p0, 0);
            int v6 = p0.P;
            i0 i01 = p0.m();
            r0.q q3 = r0.a.d(p0, q2);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y0, h1);
            androidx.compose.runtime.w.x(p0, i01, h2);
            if(p0.O || !q.b(p0.N(), v6)) {
                A7.d.q(v6, p0, v6, h3);
            }
            androidx.compose.runtime.w.x(p0, q3, h4);
            Long long0 = headerBase0.countDown;
            if(long0 == null) {
                s3 = s1;
                z1 = z;
                h9 = h0;
                b02 = b01;
                v8 = v5;
                int v11 = 6;
                context0 = (Context)object0;
                if(headerBase0.isLogoOnly) {
                    headerBase2 = headerBase0;
                    i3 = i1;
                    h10 = h1;
                    h11 = h2;
                    h12 = h3;
                    p0.a0(0x241CB6B);
                    if(headerBase2.logoImg != null && headerBase2.logoImg.length() != 0) {
                        p0.a0(0x242AAF5);
                        r0.q q7 = r0.a.a(androidx.compose.foundation.layout.d.h(n0, 48.0f), new bd.q(s0, 1));
                        M m1 = M.p.d(i0, false);
                        int v13 = p0.P;
                        i0 i04 = p0.m();
                        r0.q q8 = r0.a.d(p0, q7);
                        p0.e0();
                        if(p0.O) {
                            p0.l(i3);
                        }
                        else {
                            p0.o0();
                        }
                        androidx.compose.runtime.w.x(p0, m1, h10);
                        androidx.compose.runtime.w.x(p0, i04, h11);
                        if(p0.O || !q.b(p0.N(), v13)) {
                            A7.d.q(v13, p0, v13, h12);
                        }
                        h13 = h4;
                        androidx.compose.runtime.w.x(p0, q8, h13);
                        Drawable drawable1 = (Drawable)b00.getValue();
                        if(drawable1 == null) {
                            p0.a0(608005954);
                        }
                        else {
                            p0.a0(608005955);
                            b.i(drawable1, 48.0f, s2, headerBase2.logoImgAltText, p0, 0x30);
                        }
                        p0.p(false);
                        p0.p(true);
                    }
                    else {
                        h13 = h4;
                        p0.a0(0x1DC2F64);
                    }
                    p0.p(false);
                    p0.p(false);
                }
                else {
                    p0.a0(0x234FBF5);
                    if(headerBase0.logoImg != null && headerBase0.logoImg.length() != 0) {
                        p0.a0(37070825);
                        r0.q q5 = androidx.compose.foundation.layout.d.h(n0, 22.0f);
                        M m0 = M.p.d(i0, false);
                        int v12 = p0.P;
                        i0 i03 = p0.m();
                        r0.q q6 = r0.a.d(p0, q5);
                        p0.e0();
                        if(p0.O) {
                            i3 = i1;
                            p0.l(i3);
                        }
                        else {
                            i3 = i1;
                            p0.o0();
                        }
                        h10 = h1;
                        androidx.compose.runtime.w.x(p0, m0, h10);
                        h11 = h2;
                        androidx.compose.runtime.w.x(p0, i03, h11);
                        if(!p0.O && q.b(p0.N(), v12)) {
                            h12 = h3;
                        }
                        else {
                            h12 = h3;
                            A7.d.q(v12, p0, v12, h12);
                        }
                        androidx.compose.runtime.w.x(p0, q6, h4);
                        Drawable drawable0 = (Drawable)b00.getValue();
                        if(drawable0 == null) {
                            p0.a0(0xBF0FA8FA);
                            p0.p(false);
                            h14 = h4;
                        }
                        else {
                            p0.a0(0xBF0FA8FB);
                            M.c.d(p0, androidx.compose.foundation.layout.d.h(n0, 13.0f));
                            h14 = h4;
                            b.i(drawable0, 22.0f, s2, headerBase0.logoImgAltText, p0, 0x30);
                            p0.p(false);
                        }
                        p0.p(true);
                    }
                    else {
                        i3 = i1;
                        h10 = h1;
                        h11 = h2;
                        h12 = h3;
                        h14 = h4;
                        p0.a0(0x1DC2F64);
                    }
                    p0.p(false);
                    if(headerBase0.logoImg == null || headerBase0.logoImg.length() == 0) {
                        v11 = 8;
                    }
                    M.c.d(p0, androidx.compose.foundation.layout.d.h(n0, ((float)v11)));
                    b.l(headerBase0, s0.f, s0.g, s0.i, p0, 0);
                    headerBase2 = headerBase0;
                    A7.d.v(n0, 11.0f, p0, false);
                    h13 = h14;
                }
            }
            else {
                p0.a0(0x21F9911);
                M.c.d(p0, androidx.compose.foundation.layout.d.h(n0, 19.0f));
                p0 p01 = M.n0.a(b0, r0.d.j, p0, 0);
                int v7 = p0.P;
                i0 i02 = p0.m();
                r0.q q4 = r0.a.d(p0, n0);
                p0.e0();
                if(p0.O) {
                    p0.l(i1);
                }
                else {
                    p0.o0();
                }
                androidx.compose.runtime.w.x(p0, p01, h1);
                androidx.compose.runtime.w.x(p0, i02, h2);
                if(p0.O || !q.b(p0.N(), v7)) {
                    A7.d.q(v7, p0, v7, h3);
                }
                androidx.compose.runtime.w.x(p0, q4, h4);
                if(headerBase0.subTitle != null && headerBase0.subTitle.length() != 0) {
                    p0.a0(0x1B094625);
                    String s4 = StringUtils.INSTANCE.getBoldText((headerBase0.subTitle == null ? "" : headerBase0.subTitle));
                    long v9 = e0.T(p0, 0x7F06017C);  // color:green500s_support_high_contrast
                    i2 = i1;
                    headerBase1 = headerBase0;
                    s3 = s1;
                    h9 = h0;
                    long1 = long0;
                    v8 = v5;
                    h5 = h3;
                    h6 = h4;
                    h7 = h2;
                    h8 = h1;
                    b02 = b01;
                    z1 = z;
                    context0 = (Context)object0;
                    N1.b(s4, null, v9, 15.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F2);
                    U4.x.z(n0, 4.0f, p0, false);
                }
                else {
                    long1 = long0;
                    h5 = h3;
                    headerBase1 = headerBase0;
                    h6 = h4;
                    h7 = h2;
                    i2 = i1;
                    h8 = h1;
                    s3 = s1;
                    z1 = z;
                    h9 = h0;
                    b02 = b01;
                    v8 = v5;
                    context0 = (Context)object0;
                    p0.a0(449039395);
                    p0.p(false);
                }
                long v10 = e0.T(p0, s0.d);
                b.k(((long)long1), s0.c, s0.b, v10, p0, 0);
                p0.p(true);
                M.c.d(p0, androidx.compose.foundation.layout.d.h(n0, 6.0f));
                b.l(headerBase1, s0.f, s0.g, s0.i, p0, 0);
                A7.d.v(n0, 11.0f, p0, false);
                headerBase2 = headerBase1;
                i3 = i2;
                h10 = h8;
                h11 = h7;
                h12 = h5;
                h13 = h6;
            }
            p0.p(true);
            if(headerBase2.artistImg != null && headerBase2.artistImg.length() != 0) {
                p0.a0(0x300EFF2E);
                r0.q q9 = androidx.compose.foundation.layout.a.n(new VerticalAlignElement(h9), 0.0f, 0.0f, 0.0f, 9.0f, 7);
                M m2 = M.p.d(i0, false);
                int v14 = p0.P;
                i0 i05 = p0.m();
                r0.q q10 = r0.a.d(p0, q9);
                p0.e0();
                if(p0.O) {
                    p0.l(i3);
                }
                else {
                    p0.o0();
                }
                androidx.compose.runtime.w.x(p0, m2, h10);
                androidx.compose.runtime.w.x(p0, i05, h11);
                if(p0.O || !q.b(p0.N(), v14)) {
                    A7.d.q(v14, p0, v14, h12);
                }
                androidx.compose.runtime.w.x(p0, q10, h13);
                Cc.m.a(headerBase2.artistImg, 38.0f, 32.0f, 0.0f, s0.k, p0, 0x1B0, 40);
                p0.p(true);
            }
            else if(!headerBase2.isLinkable() || !s0.e) {
                p0.a0(0x2F9E976E);
            }
            else {
                p0.a0(806753206);
                N1.b("", r0.a.a(androidx.compose.foundation.layout.a.n(n0, 0.0f, 0.0f, 0.0f, 15.0f, 7), new bd.q(s0, 0)), e0.T(p0, 0x7F060160), 14.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF0);  // color:gray600s_support_high_contrast
            }
            p0.p(false);
            p0.p(true);
            boolean z2 = p0.g(s3);
            boolean z3 = p0.i(context0);
            boolean z4 = p0.h(z1);
            bd.n n1 = p0.N();
            if((z2 | z3 | z4) == 0) {
                v15 = v8;
                if(n1 == v15) {
                    goto label_275;
                }
            }
            else {
                v15 = v8;
            label_275:
                bd.n n2 = new bd.n(s3, context0, z1, b00, null);
                p0.l0(n2);
                n1 = n2;
            }
            J.d(p0, s3, n1);
            String s5 = headerBase2.artistImg;
            boolean z5 = p0.i(context0);
            boolean z6 = p0.i(headerBase2);
            bd.o o0 = p0.N();
            if(z5 || z6 || o0 == v15) {
                o0 = new bd.o(context0, headerBase2, b02, null);
                p0.l0(o0);
            }
            J.d(p0, s5, o0);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Zc.c(s0, v, 6);
        }
    }

    public static final void k(long v, boolean z, SimpleDateFormat simpleDateFormat0, long v1, l l0, int v2) {
        androidx.compose.runtime.V v5;
        ((androidx.compose.runtime.p)l0).c0(0xC82D3395);
        int v3 = v2 | (((androidx.compose.runtime.p)l0).f(v) ? 4 : 2) | (((androidx.compose.runtime.p)l0).h(z) ? 0x20 : 16) | (((androidx.compose.runtime.p)l0).i(simpleDateFormat0) ? 0x100 : 0x80) | (((androidx.compose.runtime.p)l0).f(v1) ? 0x800 : 0x400);
        boolean z1 = true;
        if(((androidx.compose.runtime.p)l0).Q(v3 & 1, (v3 & 0x493) != 1170)) {
            ((androidx.compose.runtime.p)l0).V();
            if((v2 & 1) != 0 && !((androidx.compose.runtime.p)l0).B()) {
                ((androidx.compose.runtime.p)l0).T();
            }
            ((androidx.compose.runtime.p)l0).q();
            Context context0 = (Context)((androidx.compose.runtime.p)l0).k(AndroidCompositionLocals_androidKt.b);
            String s = simpleDateFormat0.format(new Date(v));
            b0 b00 = ((androidx.compose.runtime.p)l0).N();
            androidx.compose.runtime.V v4 = k.a;
            if((v3 & 14) == 4 || b00 == v4) {
                Vb.i i0 = new Vb.i(10);
                v5 = v4;
                b00 = androidx.compose.runtime.w.s(TimeUtils.INSTANCE.getRemainedTimeTextOrDefault(v, System.currentTimeMillis(), i0));
                ((androidx.compose.runtime.p)l0).l0(b00);
            }
            else {
                v5 = v4;
            }
            Long long0 = v;
            boolean z2 = ((androidx.compose.runtime.p)l0).g(b00);
            if((v3 & 14) != 4) {
                z1 = false;
            }
            bd.r r0 = ((androidx.compose.runtime.p)l0).N();
            if(z2 || z1 || r0 == v5) {
                r0 = new bd.r(v, b00, null);
                ((androidx.compose.runtime.p)l0).l0(r0);
            }
            J.d(((androidx.compose.runtime.p)l0), long0, r0);
            a1.d d0 = new a1.d();
            if(z) {
                q.d(s);
                d0.d(s);
            }
            if(((CharSequence)b00.getValue()).length() > 0) {
                if(z) {
                    d0.d(", ");
                }
                int v6 = d0.g(new a1.M(v1, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, 0xFFFE));
                try {
                    d0.d(((String)b00.getValue()));
                }
                finally {
                    d0.f(v6);
                }
            }
            N1.a(d0.h(), null, e0.T(((androidx.compose.runtime.p)l0), 0x7F06016D), 15.0f, null, null, 0L, null, 0.0f, 2, false, 2, 0, null, null, null, ((androidx.compose.runtime.p)l0), 0xC00, 0xC30, 0x3D7F2);  // color:gray900s
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
        }
        n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new bd.m(v, z, simpleDateFormat0, v1, v2);
        }
    }

    public static final void l(HeaderBase headerBase0, String s, String s1, we.a a0, l l0, int v) {
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(1702659681);
        int v1 = v | (p0.i(headerBase0) ? 4 : 2) | (p0.g(s) ? 0x20 : 16) | (p0.g(s1) ? 0x100 : 0x80) | (p0.i(a0) ? 0x800 : 0x400);
        if(p0.Q(v1 & 1, (v1 & 0x493) != 1170)) {
            r0.n n0 = r0.n.a;
            r0.q q0 = androidx.compose.foundation.layout.d.f(n0, 1.0f);
            p0 p00 = M.n0.a(j.a, r0.d.k, p0, 0x30);
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
            h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            androidx.compose.runtime.w.x(p0, q1, P0.j.d);
            String s2 = headerBase0.title;
            if(s2 == null) {
                p0.a0(0x3132859F);
            }
            else {
                p0.a0(0x313285A0);
                androidx.compose.runtime.V v3 = k.a;
                if(s.length() > 0) {
                    p0.a0(1457674790);
                    Wf.a a1 = p0.N();
                    if(a1 == v3) {
                        a1 = new Wf.a(13);
                        p0.l0(a1);
                    }
                    E.a(r0.a.a(X0.n.c(n0, false, a1), new Lc.c(18, a0)), s2, s, s1, 0, 22.0f, e0.T(p0, 0x7F06016D), e0.T(p0, 0x7F06016D), e1.y.i, 1, 0, e1.y.i, 0.0f, null, null, p0, v1 << 3 & 0x380 | 0x36030000 | v1 << 3 & 0x1C00, 0x30, 0xF410);  // color:gray900s
                }
                else {
                    p0.a0(0x56ECDC9C);
                    Wf.a a2 = p0.N();
                    if(a2 == v3) {
                        a2 = new Wf.a(14);
                        p0.l0(a2);
                    }
                    r0.q q2 = r0.a.a(X0.n.c(n0, false, a2), new Lc.c(19, a0));
                    N1.b(Cb.k.c(s2, s1, s), q2, e0.T(p0, 0x7F06016D), 22.0f, e1.y.i, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0x30C00, 0xC30, 0x1D7D0);  // color:gray900s
                }
                p0.p(false);
            }
            p0.p(false);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new U2(headerBase0, s, s1, a0, v, 20);
        }
    }

    public static final void m(r0.q q0, K k0, M.i0 i00, u0 u00, J.g g0, boolean z, androidx.compose.foundation.m m0, int v, float f, Q.m m1, I0.a a0, r0.g g1, r0.h h0, J.l l0, m0.b b0, l l1, int v1, int v2) {
        r0.q q2;
        z z6;
        De.r r0;
        int v29;
        int v28;
        int v27;
        int v25;
        int v24;
        int v11;
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l1;
        p0.c0(1125194810);
        int v3 = 2;
        int v4 = (v1 & 6) == 0 ? v1 | (p0.g(q0) ? 4 : 2) : v1;
        int v5 = 16;
        if((v1 & 0x30) == 0) {
            v4 |= (p0.g(k0) ? 0x20 : 16);
        }
        int v6 = 0x80;
        if((v1 & 0x180) == 0) {
            v4 |= (p0.g(i00) ? 0x100 : 0x80);
        }
        int v7 = 0x400;
        if((v1 & 0xC00) == 0) {
            v4 |= (p0.h(false) ? 0x800 : 0x400);
        }
        int v8 = 0x2000;
        if((v1 & 0x6000) == 0) {
            v4 |= (p0.g(u00) ? 0x4000 : 0x2000);
        }
        int v9 = 0x10000;
        if((v1 & 0x30000) == 0) {
            v4 |= (p0.g(g0) ? 0x20000 : 0x10000);
        }
        int v10 = 0x80000;
        if((v1 & 0x180000) == 0) {
            v4 |= (p0.h(z) ? 0x100000 : 0x80000);
        }
        if((v1 & 0xC00000) == 0) {
            v4 |= (p0.g(m0) ? 0x800000 : 0x400000);
        }
        if((v1 & 0x6000000) == 0) {
            v4 |= (p0.e(v) ? 0x4000000 : 0x2000000);
        }
        if((v1 & 0x30000000) == 0) {
            v4 |= (p0.d(f) ? 0x20000000 : 0x10000000);
        }
        if((v2 & 6) == 0) {
            if(p0.g(m1)) {
                v3 = 4;
            }
            v11 = v2 | v3;
        }
        else {
            v11 = v2;
        }
        if((v2 & 0x30) == 0) {
            if(p0.i(a0)) {
                v5 = 0x20;
            }
            v11 |= v5;
        }
        if((v2 & 0x180) == 0) {
            if(p0.i(null)) {
                v6 = 0x100;
            }
            v11 |= v6;
        }
        if((v2 & 0xC00) == 0) {
            if(p0.g(g1)) {
                v7 = 0x800;
            }
            v11 |= v7;
        }
        if((v2 & 0x6000) == 0) {
            if(p0.g(h0)) {
                v8 = 0x4000;
            }
            v11 |= v8;
        }
        if((v2 & 0x30000) == 0) {
            if(p0.g(l0)) {
                v9 = 0x20000;
            }
            v11 |= v9;
        }
        if((v2 & 0x180000) == 0) {
            if(p0.i(b0)) {
                v10 = 0x100000;
            }
            v11 |= v10;
        }
        if(p0.Q(v4 & 1, (v4 & 306783379) != 306783378 || (0x92493 & v11) != 0x92492)) {
            if(v < 0) {
                L.a.a(("beyondViewportPageCount should be greater than or equal to 0, you selected " + v));
            }
            Q.g g2 = p0.N();
            androidx.compose.runtime.V v12 = k.a;
            if((v4 & 0x70) == 0x20 || g2 == v12) {
                g2 = new Q.g(k0, 1);
                p0.l0(g2);
            }
            int v13 = v4 >> 3 & 14;
            b0 b00 = androidx.compose.runtime.w.w(b0, p0);
            int v14 = v13 | v11 >> 15 & 0x70 | v11 & 0x380;
            b0 b01 = androidx.compose.runtime.w.w(null, p0);
            boolean z1 = (v14 & 14 ^ 6) > 4 && p0.g(k0) || (v14 & 6) == 4;
            boolean z2 = p0.g(b00);
            boolean z3 = p0.g(b01);
            boolean z4 = p0.g(g2);
            O.l l2 = p0.N();
            if((z1 | z2 | z3 | z4) != 0 || l2 == v12) {
                I.i i0 = new I.i(b00, b01, g2, 2);
                G.g g3 = new G.g(9, androidx.compose.runtime.w.h(androidx.compose.runtime.V.d, i0), k0);
                androidx.compose.runtime.E e0 = androidx.compose.runtime.w.h(androidx.compose.runtime.V.d, g3);
                l2 = new O.l(0, 2, b1.class, e0, "value", "getValue()Ljava/lang/Object;");
                p0.l0(l2);
            }
            CoroutineScope coroutineScope0 = p0.N();
            if(coroutineScope0 == v12) {
                coroutineScope0 = J.i(p0);
                p0.l0(coroutineScope0);
            }
            Q.g g4 = p0.N();
            if((v4 & 0x70) == 0x20 || g4 == v12) {
                g4 = new Q.g(k0, 0);
                p0.l0(g4);
            }
            int v15 = v4 & 0xFFF0 | v4 >> 9 & 0x70000 | v4 >> 9 & 0x380000 | v11 << 21 & 0x1C00000 | v11 << 15 & 0xE000000 | v11 << 15 & 0x70000000;
            int v16 = ((v15 & 0x70 ^ 0x30) <= 0x20 || !p0.g(k0)) && (v15 & 0x30) != 0x20 ? 0 : 1;
            int v17 = ((v15 & 0x380 ^ 0x180) <= 0x100 || !p0.g(i00)) && (v15 & 0x180) != 0x100 ? 0 : 1;
            int v18 = ((v15 & 0x1C00 ^ 0xC00) <= 0x800 || !p0.h(false)) && (v15 & 0xC00) != 0x800 ? 0 : 1;
            int v19 = ((0xE000 & v15 ^ 0x6000) <= 0x4000 || !p0.g(u00)) && (v15 & 0x6000) != 0x4000 ? 0 : 1;
            int v20 = ((v15 & 0xE000000 ^ 0x6000000) <= 0x4000000 || !p0.g(g1)) && (v15 & 0x6000000) != 0x4000000 ? 0 : 1;
            int v21 = ((v15 & 0x70000000 ^ 0x30000000) <= 0x20000000 || !p0.g(h0)) && (v15 & 0x30000000) != 0x20000000 ? 0 : 1;
            int v22 = ((v15 & 0x380000 ^ 0x180000) <= 0x100000 || !p0.d(f)) && (v15 & 0x180000) != 0x100000 ? 0 : 1;
            int v23 = ((v15 & 0x1C00000 ^ 0xC00000) <= 0x800000 || !p0.g(m1)) && (v15 & 0xC00000) != 0x800000 ? 0 : 1;
            if((v11 >> 15 & 14 ^ 6) > 4) {
                v24 = v15;
                if(p0.g(l0)) {
                    v25 = 1;
                }
                else {
                    v25 = (v11 >> 15 & 6) == 4 ? 1 : 0;
                }
            }
            else {
                v24 = v15;
                v25 = (v11 >> 15 & 6) == 4 ? 1 : 0;
            }
            int v26 = v25 | (v17 | v16 | v18 | v19 | v20 | v21 | v22 | v23) | p0.g(g4);
            if((v24 & 0x70000 ^ 0x30000) > 0x20000 && p0.e(v)) {
                v27 = v26;
                v28 = 1;
            }
            else {
                v27 = v26;
                v28 = (v24 & 0x30000) == 0x20000 ? 1 : 0;
            }
            boolean z5 = p0.g(coroutineScope0);
            Object object0 = p0.N();
            if((v27 | v28 | z5) != 0 || object0 == v12) {
                v29 = v4 & 0x70;
                z6 = new z(k0, u00, i00, f, m1, l2, g4, h0, g1, v, l0, coroutineScope0);
                r0 = l2;
                p0.l0(z6);
            }
            else {
                v29 = v4 & 0x70;
                r0 = l2;
                z6 = object0;
            }
            u0 u01 = u0.a;
            boolean z7 = u00 == u01;
            boolean z8 = (v13 ^ 6) > 4 && p0.g(k0) || (v4 >> 3 & 6) == 4;
            boolean z9 = p0.h(z7);
            O.e e1 = p0.N();
            if(z8 || z9 || e1 == v12) {
                e1 = new O.e(k0, z7, 1);
                p0.l0(e1);
            }
            Q q1 = p0.N();
            if(((v29 == 0x20 ? 1 : 0) | ((v4 & 0x70000) == 0x20000 ? 1 : 0)) != 0 || q1 == v12) {
                q1 = new Q(g0, k0);
                p0.l0(q1);
            }
            I.d d0 = (I.d)p0.k(I.g.a);
            boolean z10 = p0.g(d0);
            Q.o o0 = p0.N();
            if(v29 == 0x20 || z10 || o0 == v12) {
                o0 = new Q.o(k0, d0);
                p0.l0(o0);
            }
            r0.n n0 = r0.n.a;
            if(z) {
                p0.a0(0x735B3D0D);
                int v30 = v13 | v4 >> 21 & 0x70;
                int v31 = ((v30 & 14 ^ 6) <= 4 || !p0.g(k0)) && (v30 & 6) != 4 ? 0 : 1;
                int v32 = ((v30 & 0x70 ^ 0x30) <= 0x20 || !p0.e(v)) && (v30 & 0x30) != 0x20 ? 0 : 1;
                Q.n n1 = p0.N();
                if((v31 | v32) != 0 || n1 == v12) {
                    n1 = new Q.n(k0, v);
                    p0.l0(n1);
                }
                q2 = androidx.compose.foundation.lazy.layout.j.q(n1, k0.x, false, u00);
                p0.p(false);
            }
            else {
                p0.a0(1935788068);
                p0.p(false);
                q2 = n0;
            }
            r0.q q3 = androidx.compose.foundation.lazy.layout.j.r(q0.then(k0.A).then(k0.y), r0, e1, u00, z, false);
            androidx.compose.foundation.lazy.layout.j.d(r0, androidx.compose.ui.input.nestedscroll.a.a(androidx.compose.foundation.q.v((z ? q3.then(X0.n.c(n0, false, new t(u00 == u01, k0, coroutineScope0))) : q3.then(n0)).then(q2), k0, u00, z, false, q1, k0.r, false, m0, o0).then(J0.H.a(n0, k0, new L(k0, 1))), a0, null), k0.w, z6, p0, 0);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Q.f(q0, k0, i00, u00, g0, z, m0, v, f, m1, a0, g1, h0, l0, b0, v1, v2);
        }
    }

    public static final X0.p n(I i0, boolean z) {
        X0.l l0;
        p p4;
        d0 d00 = i0.b0;
        p p0 = null;
        if((((p)d00.f).getAggregateChildKindSet$ui_release() & 8) == 0) {
        label_35:
            q.d(p0);
            p4 = ((p)(((z0)p0))).getNode();
            l0 = i0.w();
            if(l0 == null) {
                l0 = new X0.l();
            }
        }
        else {
            p p1 = (p)d00.f;
            while(true) {
                if(p1 == null) {
                    goto label_35;
                }
                if((p1.getKindSet$ui_release() & 8) != 0) {
                    p p2 = p1;
                    g0.e e0 = null;
                    while(p2 != null) {
                        if(p2 instanceof z0) {
                            p0 = p2;
                            goto label_35;
                        }
                        if((p2.getKindSet$ui_release() & 8) != 0 && p2 instanceof n) {
                            p p3 = ((n)p2).b;
                            int v = 0;
                            while(p3 != null) {
                                if((p3.getKindSet$ui_release() & 8) != 0) {
                                    ++v;
                                    if(v == 1) {
                                        p2 = p3;
                                    }
                                    else {
                                        if(e0 == null) {
                                            e0 = new g0.e(new p[16]);
                                        }
                                        if(p2 != null) {
                                            e0.b(p2);
                                            p2 = null;
                                        }
                                        e0.b(p3);
                                    }
                                }
                                p3 = p3.getChild$ui_release();
                            }
                            if(v != 1) {
                                p2 = P0.f.f(e0);
                            }
                        }
                        else {
                            p2 = P0.f.f(e0);
                        }
                    }
                }
                if((p1.getAggregateChildKindSet$ui_release() & 8) != 0) {
                    p1 = p1.getChild$ui_release();
                    continue;
                }
                goto label_35;
            }
        }
        return new X0.p(p4, z, i0, l0);
    }

    public static final void o(s0 s00, l l0, int v) {
        h h6;
        P0.i i3;
        h h5;
        P0.i i2;
        q.g(s00, "uiState");
        Object object0 = s00.a;
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0xD8E714F1);
        int v1 = v | (p0.i(s00) ? 4 : 2);
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            r0.n n0 = r0.n.a;
            r0.q q0 = e0.M(androidx.compose.foundation.layout.a.l(androidx.compose.foundation.layout.d.f(n0, 1.0f), 20.0f, 0.0f, 2), 0x7F06048A, 8.0f);  // color:transparent
            ie.m[] arr_m = {new ie.m(0.0f, new y0.s(e0.T(p0, 0x7F060088))), new ie.m(1.0f, new y0.s(e0.T(p0, 0x7F06008F)))};  // color:color_4b33ff
            ArrayList arrayList0 = new ArrayList(2);
            for(int v2 = 0; v2 < 2; ++v2) {
                arrayList0.add(new y0.s(((y0.s)arr_m[v2].b).a));
            }
            ArrayList arrayList1 = new ArrayList(2);
            for(int v3 = 0; v3 < 2; ++v3) {
                arrayList1.add(((Number)arr_m[v3].a).floatValue());
            }
            r0.q q1 = androidx.compose.foundation.layout.a.m(androidx.compose.foundation.q.e(q0, new y0.E(arrayList0, arrayList1, 0L, 0x7F8000007F800000L), null, 6), 15.0f, 20.0f, 15.0f, 15.0f);
            boolean z = p0.i(s00);
            Nc.f f0 = p0.N();
            androidx.compose.runtime.V v4 = k.a;
            if(z || f0 == v4) {
                f0 = new Nc.f(s00, 21);
                p0.l0(f0);
            }
            r0.q q2 = m3.b(q1, f0);
            y y0 = M.w.a(j.c, r0.d.m, p0, 0);
            int v5 = p0.P;
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
            h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, y0, h0);
            h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h2);
            }
            h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q3, h3);
            r0.q q4 = androidx.compose.foundation.layout.d.h(n0, 35.0f);
            r0.h h4 = r0.d.k;
            p0 p00 = M.n0.a(j.a, h4, p0, 0x30);
            int v6 = p0.P;
            M.b b0 = j.a;
            i0 i01 = p0.m();
            r0.q q5 = r0.a.d(p0, q4);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p00, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v6)) {
                A7.d.q(v6, p0, v6, h2);
            }
            androidx.compose.runtime.w.x(p0, q5, h3);
            N1.b("", null, e0.T(p0, 0x7F0604A1), 22.0f, e1.y.i, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0x30C00, 0, 0x1FFD2);  // color:white000e
            e1.y y1 = e1.y.i;
            M.c.d(p0, androidx.compose.foundation.layout.d.q(n0, 6.0f));
            r0.q q6 = androidx.compose.foundation.layout.d.n(n0, 35.0f);
            T.d d0 = T.e.a;
            r0.q q7 = d5.n.o(q6, d0);
            Ma.k k0 = p0.N();
            if(k0 == v4) {
                k0 = new Ma.k(27);
                p0.l0(k0);
            }
            c1.n(X0.n.b(q7, k0), je.p.m0(((List)object0)), null, N0.j.b, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0xC00, 0, 0x7FF4);
            N0.i i1 = N0.j.b;
            M.c.d(p0, androidx.compose.foundation.layout.d.q(n0, 6.0f));
            N1.b("", null, e0.T(p0, 0x7F0604A1), 22.0f, y1, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0x30C00, 0, 0x1FFD2);  // color:white000e
            p0.p(true);
            M.c.d(p0, androidx.compose.foundation.layout.d.h(n0, 4.0f));
            r0.q q8 = androidx.compose.foundation.layout.d.h(n0, 35.0f);
            p0 p01 = M.n0.a(b0, h4, p0, 0x30);
            int v7 = p0.P;
            i0 i02 = p0.m();
            r0.q q9 = r0.a.d(p0, q8);
            p0.e0();
            if(p0.O) {
                i2 = i0;
                p0.l(i2);
            }
            else {
                i2 = i0;
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p01, h0);
            androidx.compose.runtime.w.x(p0, i02, h1);
            if(!p0.O && q.b(p0.N(), v7)) {
                h5 = h2;
            }
            else {
                h5 = h2;
                A7.d.q(v7, p0, v7, h5);
            }
            androidx.compose.runtime.w.x(p0, q9, h3);
            r0.q q10 = d5.n.o(androidx.compose.foundation.layout.d.n(n0, 35.0f), d0);
            Ma.k k1 = p0.N();
            if(k1 == v4) {
                k1 = new Ma.k(28);
                p0.l0(k1);
            }
            c1.n(X0.n.b(q10, k1), ((List)object0).get(1), null, i1, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0xC00, 0, 0x7FF4);
            M.c.d(p0, androidx.compose.foundation.layout.d.q(n0, 6.0f));
            N1.b("", null, e0.T(p0, 0x7F0604A1), 22.0f, y1, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0x30C00, 0, 0x1FFD2);  // color:white000e
            l1.y(p0, true, n0, 4.0f, p0);
            r0.q q11 = androidx.compose.foundation.layout.d.h(n0, 35.0f);
            p0 p02 = M.n0.a(b0, h4, p0, 0x30);
            int v8 = p0.P;
            i0 i03 = p0.m();
            r0.q q12 = r0.a.d(p0, q11);
            p0.e0();
            if(p0.O) {
                i3 = i2;
                p0.l(i3);
            }
            else {
                i3 = i2;
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p02, h0);
            androidx.compose.runtime.w.x(p0, i03, h1);
            if(!p0.O && q.b(p0.N(), v8)) {
                h6 = h5;
            }
            else {
                h6 = h5;
                A7.d.q(v8, p0, v8, h6);
            }
            androidx.compose.runtime.w.x(p0, q12, h3);
            N1.b("", null, e0.T(p0, 0x7F0604A1), 22.0f, y1, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0x30C00, 0, 0x1FFD2);  // color:white000e
            M.c.d(p0, androidx.compose.foundation.layout.d.q(n0, 6.0f));
            r0.q q13 = androidx.compose.foundation.layout.d.h(n0, 36.0f);
            Ma.k k2 = p0.N();
            if(k2 == v4) {
                k2 = new Ma.k(29);
                p0.l0(k2);
            }
            c1.n(X0.n.b(q13, k2), 0x7F08066F, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x30, 0, 0x7FFC);  // drawable:img_settingcard_shape
            l1.y(p0, true, n0, 20.0f, p0);
            r0.q q14 = r0.a.a(e0.L(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(n0, 1.0f), 44.0f), 0x7F0604B6), new X(s00, 22));  // color:white501e
            M m0 = M.p.d(r0.d.e, false);
            int v9 = p0.P;
            i0 i04 = p0.m();
            r0.q q15 = r0.a.d(p0, q14);
            p0.e0();
            if(p0.O) {
                p0.l(i3);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m0, h0);
            androidx.compose.runtime.w.x(p0, i04, h1);
            if(p0.O || !q.b(p0.N(), v9)) {
                A7.d.q(v9, p0, v9, h6);
            }
            androidx.compose.runtime.w.x(p0, q15, h3);
            N1.b("", null, e0.T(p0, 0x7F0604A1), 15.0f, null, null, 0L, new l1.k(3), 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FDF2);  // color:white000e
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new C8.a(s00, v, 27);
        }
    }

    public static Object p(Parcel parcel0, Parcelable.Creator parcelable$Creator0) {
        return parcel0.readInt() == 0 ? null : parcelable$Creator0.createFromParcel(parcel0);
    }

    public static void q(Parcel parcel0, Parcelable parcelable0, int v) {
        if(parcelable0 != null) {
            parcel0.writeInt(1);
            parcelable0.writeToParcel(parcel0, v);
            return;
        }
        parcel0.writeInt(0);
    }

    public static final String r(int v) {
        switch(v) {
            case 0: {
                return "Success.";
            }
            case 7: {
                return "Network I/O error.";
            }
            case 8: {
                return "An internal error has occurred.";
            }
            case 13: {
                return "An unknown, unexpected error has occurred.";
            }
            case 14: {
                return "A blocking call was interrupted while waiting and did not run to completion.";
            }
            case 15: {
                return "An operation has timed out.";
            }
            case 2000: {
                return "Authentication failure.";
            }
            case 2001: {
                return "An invalid request was made.";
            }
            case 2002: {
                return "An in-progress request has been canceled, most likely because another action has preempted it.";
            }
            case 2003: {
                return "The request was disallowed and could not be completed.";
            }
            case 2004: {
                return "A requested application could not be found.";
            }
            case 2005: {
                return "A requested application is not currently running.";
            }
            case 2006: {
                return "A message could not be sent because it is too large.";
            }
            case 2007: {
                return "A message could not be sent because there is not enough room in the send buffer at this time.";
            }
            case 2100: {
                return "The in-progress request failed.";
            }
            case 2103: {
                return "The request\'s progress is no longer being tracked because another request of the same type has been made before the first request completed.";
            }
            case 2200: {
                return "The Cast Remote Display service could not be created.";
            }
            case 2201: {
                return "The Cast Remote Display service was disconnected.";
            }
            default: {
                String s = CastStatusCodes.getStatusCodeString(v);
                q.f(s, "getStatusCodeString(...)");
                return s;
            }
        }
    }

    public static void s(OutputStream outputStream0) {
        if(outputStream0 == null) {
            return;
        }
        try {
            outputStream0.close();
        }
        catch(Throwable unused_ex) {
        }
    }

    public static int t(BitmapFactory.Options bitmapFactory$Options0, int v, int v1) {
        double f = (double)bitmapFactory$Options0.outWidth;
        double f1 = (double)bitmapFactory$Options0.outHeight;
        int v2 = 1;
        int v3 = v1 == -1 ? 1 : ((int)Math.ceil(Math.sqrt(f * f1 / ((double)v1))));
        int v4 = v == -1 ? 0x80 : ((int)Math.min(Math.floor(f / ((double)v)), Math.floor(f1 / ((double)v))));
        if(v4 >= v3) {
            if(v1 == -1 && v == -1) {
                v3 = 1;
            }
            else if(v != -1) {
                v3 = v4;
            }
        }
        if(v3 <= 8) {
            while(v2 < v3) {
                v2 <<= 1;
            }
            return v2;
        }
        return (v3 + 7) / 8 * 8;
    }

    public static float[] u(float[] arr_f, int v) {
        if(v < 0) {
            throw new IllegalArgumentException();
        }
        if(arr_f.length < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        float[] arr_f1 = new float[v];
        System.arraycopy(arr_f, 0, arr_f1, 0, Math.min(v, arr_f.length));
        return arr_f1;
    }

    public static Af.p v(String s, Iterable iterable0) {
        Af.p p0;
        q.g(s, "debugName");
        Qf.f f0 = new Qf.f();
        Iterator iterator0 = iterable0.iterator();
        while(true) {
            boolean z = iterator0.hasNext();
            p0 = Af.o.b;
            if(!z) {
                break;
            }
            Object object0 = iterator0.next();
            Af.p p1 = (Af.p)object0;
            if(p1 == p0) {
            }
            else if(p1 instanceof Af.a) {
                je.u.V(f0, ((Af.a)p1).c);
            }
            else {
                f0.add(p1);
            }
        }
        switch(f0.a) {
            case 0: {
                return p0;
            }
            case 1: {
                return (Af.p)f0.get(0);
            }
            default: {
                return new Af.a(s, ((Af.p[])f0.toArray(new Af.p[0])));
            }
        }
    }

    public static Ke.f w(Ke.c c0, boolean z) {
        String s2;
        q.g(c0, "functionClass");
        List list0 = c0.k;
        Ke.f f0 = new Ke.f(c0, null, 1, z);
        Pe.u u0 = c0.P0();
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: list0) {
            if(((S)object0).y() != Hf.b0.d) {
                break;
            }
            arrayList0.add(object0);
        }
        Sf.p p0 = je.p.V0(arrayList0);
        ArrayList arrayList1 = new ArrayList(je.q.Q(10, p0));
        Iterator iterator1 = p0.iterator();
        while(((Sf.b)iterator1).b.hasNext()) {
            A a0 = (A)((Sf.b)iterator1).next();
            int v = a0.a;
            S s0 = (S)a0.b;
            String s1 = s0.getName().b();
            q.f(s1, "asString(...)");
            if(s1.equals("T")) {
                s2 = "instance";
            }
            else if(s1.equals("E")) {
                s2 = "receiver";
            }
            else {
                s2 = s1.toLowerCase(Locale.ROOT);
                q.f(s2, "toLowerCase(...)");
            }
            qf.e e0 = qf.e.e(s2);
            B b0 = s0.g();
            q.f(b0, "getDefaultType(...)");
            arrayList1.add(new Pe.S(f0, null, v, Ne.g.a, e0, b0, false, false, false, null, Me.N.q));
        }
        B b1 = ((S)je.p.s0(list0)).g();
        f0.G1(null, u0, je.w.a, je.w.a, arrayList1, b1, Me.y.e, Me.p.e);
        f0.M = true;
        return f0;
    }

    public static S1.f[] x(String s) {
        float[] arr_f1;
        ArrayList arrayList0 = new ArrayList();
        int v = 0;
        int v1 = 1;
        while(v1 < s.length()) {
            while(v1 < s.length()) {
                int v2 = s.charAt(v1);
                if(((v2 - 90) * (v2 - 65) <= 0 || (v2 - 0x7A) * (v2 - 97) <= 0) && v2 != 101 && v2 != 69) {
                    break;
                }
                ++v1;
            }
            String s1 = s.substring(v, v1).trim();
            if(!s1.isEmpty()) {
                if(s1.charAt(0) == 90 || s1.charAt(0) == 0x7A) {
                    arr_f1 = new float[0];
                }
                else {
                    try {
                        float[] arr_f = new float[s1.length()];
                        int v3 = s1.length();
                        int v4 = 0;
                        for(int v5 = 1; v5 < v3; v5 = z3 ? v6 : v6 + 1) {
                            boolean z = false;
                            boolean z1 = false;
                            boolean z2 = false;
                            boolean z3 = false;
                            int v6;
                            for(v6 = v5; v6 < s1.length(); ++v6) {
                                switch(s1.charAt(v6)) {
                                    case 0x20: 
                                    case 44: {
                                        z = false;
                                        z2 = true;
                                        break;
                                    }
                                    case 45: {
                                        if(v6 == v5 || z) {
                                            z = false;
                                            break;
                                        }
                                        z = false;
                                        z2 = true;
                                        z3 = true;
                                        break;
                                    }
                                    case 46: {
                                        if(!z1) {
                                            z = false;
                                            z1 = true;
                                            break;
                                        }
                                        z = false;
                                        z2 = true;
                                        z3 = true;
                                        break;
                                    }
                                    case 69: 
                                    case 101: {
                                        z = true;
                                        break;
                                    }
                                    default: {
                                        z = false;
                                    }
                                }
                                if(z2) {
                                    break;
                                }
                            }
                            if(v5 < v6) {
                                arr_f[v4] = Float.parseFloat(s1.substring(v5, v6));
                                ++v4;
                            }
                        }
                        arr_f1 = b.u(arr_f, v4);
                        goto label_57;
                    }
                    catch(NumberFormatException numberFormatException0) {
                    }
                    throw new RuntimeException("error in parsing \"" + s1 + "\"", numberFormatException0);
                }
            label_57:
                arrayList0.add(new S1.f(s1.charAt(0), arr_f1));
            }
            v = v1;
            ++v1;
        }
        if(v1 - v == 1 && v < s.length()) {
            arrayList0.add(new S1.f(s.charAt(v), new float[0]));
        }
        return (S1.f[])arrayList0.toArray(new S1.f[0]);
    }

    public static Path y(String s) {
        Path path0 = new Path();
        S1.f[] arr_f = b.x(s);
        try {
            S1.f.b(arr_f, path0);
            return path0;
        }
        catch(RuntimeException runtimeException0) {
            throw new RuntimeException("Error in parsing " + s, runtimeException0);
        }
    }

    public static S1.f[] z(S1.f[] arr_f) {
        S1.f[] arr_f1 = new S1.f[arr_f.length];
        for(int v = 0; v < arr_f.length; ++v) {
            arr_f1[v] = new S1.f(arr_f[v]);
        }
        return arr_f1;
    }
}

