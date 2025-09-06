package E9;

import Ac.X;
import B9.m;
import Cb.i;
import Cc.N1;
import Cc.e0;
import Cc.u3;
import Cc.z2;
import D4.j;
import De.I;
import Ge.u0;
import I.Z;
import M.n0;
import M.p0;
import M.q0;
import M.y;
import Me.c;
import N0.M;
import Nc.U0;
import P.F;
import P0.h;
import P0.r;
import Pc.d;
import Q.K;
import Q.N;
import T.e;
import T1.b;
import Ve.i0;
import Ve.j0;
import Ve.k0;
import X2.l;
import a1.Q;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.graphics.drawable.Drawable;
import android.net.Uri.Builder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.appcompat.app.o;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.VerticalAlignElement;
import androidx.compose.foundation.lazy.layout.C;
import androidx.compose.runtime.E;
import androidx.compose.runtime.I0;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.b1;
import androidx.compose.runtime.p;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.room.A;
import androidx.room.H;
import androidx.room.J;
import androidx.room.P;
import c2.d0;
import com.google.android.gms.cast.CastStatusCodes;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.constants.MelonLimits.TextLimit;
import com.iloen.melon.custom.l1;
import com.iloen.melon.playback.Actor;
import com.kakao.tiara.data.ActionKind;
import com.melon.net.res.v3.CommentConfig;
import com.melon.playback.MelonIntentService;
import com.melon.ui.interfaces.StringProviderImpl;
import d5.n;
import e1.G;
import e1.u;
import e1.x;
import i.n.i.b.a.s.e.B;
import i.n.i.b.a.s.e.E4;
import i.n.i.b.a.s.e.F4;
import i.n.i.b.a.s.e.K4;
import i.n.i.b.a.s.e.L6;
import i.n.i.b.a.s.e.O6;
import i.n.i.b.a.s.e.ra;
import i.n.i.b.a.s.e.t4;
import i.n.i.b.a.s.e.w2;
import i.n.i.b.a.s.e.w6;
import i.n.i.b.a.s.e.yd;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.concurrent.RejectedExecutionException;
import k8.Y;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import me.f;
import p8.g;
import p8.s;
import we.a;
import we.k;
import y0.z;

public abstract class w implements d0 {
    public static volatile boolean a = false;
    public static final int b;
    public static final int c;
    public static final int d;
    public static final int e;
    public static final int f;

    public static Intent A(Actor actor0) {
        q.g(actor0, "actor");
        Intent intent0 = w.u("com.iloen.melon.intent.action.playservice.prev").putExtra("com.iloen.melon.intent.extra.actor", actor0).setData(new Uri.Builder().appendPath(actor0.name()).build());
        q.f(intent0, "setData(...)");
        return intent0;
    }

    public static String B(int v) {
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
                return CastStatusCodes.getStatusCodeString(v);
            }
        }
    }

    public static g C(s s0, CommentConfig commentConfig0) {
        if(s0 == null || commentConfig0 == null) {
            return null;
        }
        g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
        g0.b = s0.a;
        g0.c = s0.b;
        g0.I = s0.c;
        g0.o = commentConfig0.getContentRefValue();
        g0.r = commentConfig0.getChannelName();
        g0.s = String.valueOf(commentConfig0.getChannelSeq());
        return g0;
    }

    public static boolean D(EditText editText0) {
        return editText0.getInputType() != 0;
    }

    public static boolean E(byte b) {
        return b > -65;
    }

    public static final boolean F(K k0, float f) {
        k0.k().getClass();
        return Float.compare((k0.q() ? -f : w.p(k0)), 0.0f) <= 0;
    }

    public static void G(s s0, CommentConfig commentConfig0, d d0, String s1, ActionKind actionKind0, String s2, String s3, boolean z, String s4, String s5, String s6) {
        q.g(d0, "stringProvider");
        g g0 = w.C(s0, commentConfig0);
        if(g0 != null) {
            g0.a = s1;
            if(i.l(actionKind0)) {
                g0.d = actionKind0;
            }
            g0.y = s2;
            if(i.l(s3)) {
                g0.F = s3;
            }
            if(i.l(s5)) {
                g0.B = s5;
            }
            if(i.l(s4)) {
                g0.e = s4;
            }
            if(i.l(s6)) {
                g0.h = s6;
            }
            if(ActionKind.Like == actionKind0) {
                g0.U = ((StringProviderImpl)d0).a((z ? 0x7F130FCD : 0x7F130FCC));  // string:tiara_props_like "like"
            }
            g0.a().track();
        }
    }

    public static u0 H(c c0, a a0) {
        if(a0 == null) {
            throw new IllegalArgumentException("Argument for @NotNull parameter \'initializer\' of kotlin/reflect/jvm/internal/ReflectProperties.lazySoft must not be null");
        }
        return new u0(c0, a0);
    }

    public static MelonLimits.TextLimit I(int v) {
        return new MelonLimits.TextLimit(v);
    }

    public static final void J(t t0) {
        q.f(nf.d.p, "MEMBER_KIND");
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, i0.c));
        for(Object object0: i0.c) {
            arrayList0.add(((i0)object0).a);
        }
    }

    public static String K(String s, String s1) {
        int v = s.length() - s1.length();
        if(v < 0 || v > 1) {
            throw new IllegalArgumentException("Invalid input received");
        }
        StringBuilder stringBuilder0 = new StringBuilder(s1.length() + s.length());
        for(int v1 = 0; v1 < s.length(); ++v1) {
            stringBuilder0.append(s.charAt(v1));
            if(s1.length() > v1) {
                stringBuilder0.append(s1.charAt(v1));
            }
        }
        return stringBuilder0.toString();
    }

    public static final void L(t t0) {
        q.f(nf.d.e, "MODALITY");
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, j0.c));
        for(Object object0: j0.c) {
            arrayList0.add(((j0)object0).a);
        }
    }

    public static m M(ViewGroup viewGroup0) {
        View view0 = o.e(viewGroup0, 0x7F0D04BA, viewGroup0, false);  // layout:listitem_user_new
        q.d(view0);
        return new m(view0);
    }

    public static final Object N(H h0, boolean z, boolean z1, k k0) {
        q.g(h0, "db");
        h0.assertNotMainThread();
        h0.assertNotSuspendingTransaction();
        return G.E(new D4.c(h0, null, k0, z1, z));
    }

    public static final Object O(H h0, Continuation continuation0, k k0) {
        f f0 = null;
        if(h0.inCompatibilityMode$room_runtime_release()) {
            J j0 = new J(new D4.f(h0, null, k0), null);
            P p0 = (P)continuation0.getContext().get(P.c);
            if(p0 != null) {
                f0 = p0.a;
            }
            if(f0 != null) {
                return BuildersKt.withContext(f0, j0, continuation0);
            }
            me.i i0 = continuation0.getContext();
            CancellableContinuationImpl cancellableContinuationImpl0 = new CancellableContinuationImpl(u.D(continuation0), 1);
            cancellableContinuationImpl0.initCancellability();
            try {
                h0.getTransactionExecutor().execute(new l(4, i0, cancellableContinuationImpl0, h0, j0, false));
                return cancellableContinuationImpl0.getResult();
            }
            catch(RejectedExecutionException rejectedExecutionException0) {
                cancellableContinuationImpl0.cancel(new IllegalStateException("Unable to acquire a thread to perform the database transaction.", rejectedExecutionException0));
                return cancellableContinuationImpl0.getResult();
            }
        }
        return BuildersKt.withContext(h0.getCoroutineScope().getCoroutineContext(), new D4.i(h0, null, k0), continuation0);
    }

    public static final Object P(H h0, Continuation continuation0, k k0, boolean z, boolean z1) {
        boolean z3;
        boolean z2;
        k k2;
        H h1;
        D4.k k1;
        if(continuation0 instanceof D4.k) {
            k1 = (D4.k)continuation0;
            int v = k1.G;
            if((v & 0x80000000) == 0) {
                k1 = new D4.k(continuation0);  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
            }
            else {
                k1.G = v ^ 0x80000000;
            }
        }
        else {
            k1 = new D4.k(continuation0);  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
        }
        me.i i0 = k1.E;
        ne.a a0 = ne.a.a;
        switch(k1.G) {
            case 0: {
                n.D(i0);
                if(h0.inCompatibilityMode$room_runtime_release() && h0.isOpenInternal() && h0.inTransaction()) {
                    D4.m m0 = new D4.m(h0, null, k0, z1, z);
                    k1.G = 1;
                    Object object0 = h0.useConnection$room_runtime_release(z, m0, k1);
                    return object0 == a0 ? a0 : object0;
                }
                k1.r = h0;
                k1.w = k0;
                k1.B = z;
                k1.D = z1;
                k1.G = 2;
                me.i i1 = w.t(h0, z1, k1);
                if(i1 == a0) {
                    return a0;
                }
                h1 = h0;
                k2 = k0;
                i0 = i1;
                z2 = z1;
                z3 = z;
                break;
            }
            case 1: {
                n.D(i0);
                return i0;
            }
            case 2: {
                boolean z4 = k1.D;
                boolean z5 = k1.B;
                k k3 = k1.w;
                H h2 = k1.r;
                n.D(i0);
                z2 = z4;
                z3 = z5;
                k2 = k3;
                h1 = h2;
                break;
            }
            case 3: {
                n.D(i0);
                return i0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        j j0 = new j(h1, null, k2, z3, z2);
        k1.r = null;
        k1.w = null;
        k1.G = 3;
        Object object1 = BuildersKt.withContext(i0, j0, k1);
        return object1 == a0 ? a0 : object1;
    }

    public static final void Q(B3.d d0) {
        if(d0.b != 1 || d0.c != 1) {
            throw new IllegalArgumentException(("BooleanFlagDelegate can work only with boolean flags (bitWidth = 1 and value = 1), but " + d0 + " was passed").toString());
        }
    }

    public static final Cursor R(H h0, H4.g g0, boolean z) {
        Cursor cursor1;
        q.g(h0, "db");
        Cursor cursor0 = h0.query(g0, null);
        if(z && cursor0 instanceof AbstractWindowedCursor) {
            int v = ((AbstractWindowedCursor)cursor0).getCount();
            if((((AbstractWindowedCursor)cursor0).hasWindow() ? ((AbstractWindowedCursor)cursor0).getWindow().getNumRows() : v) < v) {
                q.g(cursor0, "c");
                try {
                    cursor1 = new MatrixCursor(cursor0.getColumnNames(), cursor0.getCount());
                    while(true) {
                        if(!cursor0.moveToNext()) {
                            goto label_32;
                        }
                        Object[] arr_object = new Object[cursor0.getColumnCount()];
                        int v1 = cursor0.getColumnCount();
                        for(int v2 = 0; v2 < v1; ++v2) {
                            switch(cursor0.getType(v2)) {
                                case 0: {
                                    arr_object[v2] = null;
                                    break;
                                }
                                case 1: {
                                    arr_object[v2] = cursor0.getLong(v2);
                                    break;
                                }
                                case 2: {
                                    arr_object[v2] = cursor0.getDouble(v2);
                                    break;
                                }
                                case 3: {
                                    arr_object[v2] = cursor0.getString(v2);
                                    break;
                                }
                                case 4: {
                                    arr_object[v2] = cursor0.getBlob(v2);
                                    break;
                                }
                                default: {
                                    throw new IllegalStateException();
                                }
                            }
                        }
                        ((MatrixCursor)cursor1).addRow(arr_object);
                    }
                }
                catch(Throwable throwable0) {
                }
                try {
                    throw throwable0;
                }
                catch(Throwable throwable1) {
                    d8.d.l(cursor0, throwable0);
                    throw throwable1;
                }
            label_32:
                cursor0.close();
                return cursor1;
            }
        }
        return cursor0;
    }

    public static final void S(Context context0, BroadcastReceiver broadcastReceiver0, IntentFilter intentFilter0, String s) {
        q.g(context0, "<this>");
        context0.registerReceiver(broadcastReceiver0, intentFilter0, s, null, 4);
    }

    public static final Resources T(androidx.compose.runtime.l l0) {
        ((p)l0).k(AndroidCompositionLocals_androidKt.a);
        return ((Context)((p)l0).k(AndroidCompositionLocals_androidKt.b)).getResources();
    }

    public static void U(Drawable drawable0, int v) {
        drawable0.setTint(v);
    }

    public static Drawable V(Drawable drawable0) {
        if(drawable0 instanceof T1.a) {
            ((b)(((T1.a)drawable0))).getClass();
            return null;
        }
        return drawable0;
    }

    public static final void W(B3.d d0) {
        if(d0.b != 1 || d0.c != 1) {
            throw new IllegalArgumentException(("BooleanFlagDelegate can work only with boolean flags (bitWidth = 1 and value = 1), but " + d0 + " was passed").toString());
        }
    }

    public static final void X(t t0) {
        q.f(nf.d.d, "VISIBILITY");
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, k0.c));
        for(Object object0: k0.c) {
            arrayList0.add(((k0)object0).a);
        }
    }

    @Override  // c2.d0
    public void a() {
    }

    public static final void b(Bb.c c0, a a0, androidx.compose.runtime.l l0, int v) {
        q.g(c0, "item");
        q.g(a0, "onDeleteClick");
        p p0 = (p)l0;
        p0.c0(0xD734F702);
        int v1 = (p0.i(c0) ? 4 : 2) | v | (p0.i(a0) ? 0x20 : 16);
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
            int v2 = p0.P;
            androidx.compose.runtime.i0 i00 = p0.m();
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
            h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, y0, h0);
            h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q0, h3);
            r0.q q1 = androidx.compose.foundation.layout.d.h(n0, 55.0f);
            p0 p00 = n0.a(M.j.a, r0.d.j, p0, 0);
            int v3 = p0.P;
            androidx.compose.runtime.i0 i01 = p0.m();
            r0.q q2 = r0.a.d(p0, q1);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p00, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            androidx.compose.runtime.w.x(p0, q2, h3);
            r0.q q3 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.q(androidx.compose.foundation.layout.a.n(n0, 16.0f, 0.0f, 10.0f, 0.0f, 10), 12.0f), 15.0f);
            r0.q q4 = H0.b.r(r0.d.k, q3);
            androidx.compose.foundation.q.c(I.Q(0x7F080588, p0, 6), null, q4, null, null, 0.0f, null, p0, 0x30, 120);  // drawable:ic_my_list_playlist_fail
            r0.q q5 = H0.b.r(r0.d.k, q0.a(n0, 1.0f));
            N1.b((c0.l == null ? "" : c0.l), q5, e0.T(p0, 0x7F06016D), 16.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F0);  // color:gray900s
            r0.q q6 = r0.a.a(H0.b.r(r0.d.k, androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.q(androidx.compose.foundation.layout.a.n(n0, 21.0f, 0.0f, 16.0f, 0.0f, 10), 18.0f), 18.0f)), new u3(27, a0));
            androidx.compose.foundation.q.c(I.Q(0x7F080583, p0, 6), null, q6, null, null, 0.0f, null, p0, 0x30, 120);  // drawable:ic_my_list_delete
            p0.p(true);
            P4.a.b(androidx.compose.foundation.layout.a.l(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(n0, 1.0f), 0.5f), 16.0f, 0.0f, 2), e0.T(p0, 0x7F06014A), 0.0f, 0.0f, p0, 6, 12);  // color:gray100a
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Gd.p(c0, a0, v, 12);
        }
    }

    public static final void c(a a0, a a1, androidx.compose.runtime.l l0, int v) {
        q.g(a0, "onFirstButtonClick");
        q.g(a1, "onSecondButtonClick");
        p p0 = (p)l0;
        p0.c0(1298043098);
        int v1 = v | (p0.i(a0) ? 4 : 2) | (p0.i(a1) ? 0x20 : 16);
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            r0.n n0 = r0.n.a;
            r0.q q0 = androidx.compose.foundation.layout.a.m(n0, 16.0f, 20.0f, 16.0f, 10.0f).then(androidx.compose.foundation.layout.d.c);
            p0 p00 = n0.a(M.j.a, r0.d.j, p0, 0);
            int v2 = p0.P;
            androidx.compose.runtime.i0 i00 = p0.m();
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
            r0.q q2 = new LayoutWeightElement(1.0f, true).then(new VerticalAlignElement(r0.d.k));
            q.f("다운로드 실패", "getString(...)");
            N1.b("다운로드 실패", q2, e0.T(p0, 0x7F06016D), 16.0f, null, null, 0L, null, 0.0f, 0, false, 1, 0, null, null, p0, 0xC00, 0xC00, 0x1DFF0);  // color:gray900s
            r0.q q3 = androidx.compose.foundation.layout.d.q(androidx.compose.foundation.layout.a.n(n0, 5.0f, 0.0f, 0.0f, 0.0f, 14), 70.0f);
            androidx.compose.foundation.y y0 = androidx.compose.foundation.q.a(e0.T(p0, 0x7F060152), 0.5f);  // color:gray200a
            T.d d0 = e.b(100.0f);
            r0.q q4 = r0.a.a(androidx.compose.foundation.q.j(q3, y0.a, y0.b, d0), new u3(28, a0));
            q.f("전체삭제", "getString(...)");
            N1.b("전체삭제", q4, e0.T(p0, 0x7F060160), 13.0f, null, null, 0L, new l1.k(3), 25.0f, 0, false, 0, 0, null, null, p0, 0xC00, 6, 0x1F9F0);  // color:gray600s_support_high_contrast
            r0.q q5 = androidx.compose.foundation.layout.d.q(androidx.compose.foundation.layout.a.n(n0, 5.0f, 0.0f, 0.0f, 0.0f, 14), 70.0f);
            androidx.compose.foundation.y y1 = androidx.compose.foundation.q.a(e0.T(p0, 0x7F060152), 0.5f);  // color:gray200a
            T.d d1 = e.b(100.0f);
            r0.q q6 = r0.a.a(androidx.compose.foundation.q.j(q5, y1.a, y1.b, d1), new u3(29, a1));
            q.f("재시도", "getString(...)");
            N1.b("재시도", q6, e0.T(p0, 0x7F060160), 13.0f, null, null, 0L, new l1.k(3), 25.0f, 0, false, 0, 0, null, null, p0, 0xC00, 6, 0x1F9F0);  // color:gray600s_support_high_contrast
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Gd.p(a0, a1, v, 13);
        }
    }

    public static final void d(String s, U0 u00, r0.q q0, androidx.compose.runtime.l l0, int v) {
        q.g(s, "genreCode");
        p p0 = (p)l0;
        p0.c0(0x9208DF5B);
        int v1 = v | (p0.g(s) ? 4 : 2) | (p0.g(u00) ? 0x20 : 16);
        if(p0.Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            boolean z = s.equals("GN2300");
            r0.n n0 = r0.n.a;
            r0.q q1 = e2.a.r(n0, (z ? 0.3f : 1.0f));
            M m0 = M.p.d(r0.d.a, false);
            int v2 = p0.P;
            androidx.compose.runtime.i0 i00 = p0.m();
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
            h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, m0, h0);
            h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q2, h3);
            r0.q q3 = androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.q.f(q0, e0.T(p0, 0x7F060145), e.b(4.0f)), 48.0f), 1.0f);  // color:gray050s
            if(!z) {
                q3 = r0.a.a(q3, new X(u00, 15));
            }
            M m1 = M.p.d(r0.d.e, false);
            int v3 = p0.P;
            androidx.compose.runtime.i0 i01 = p0.m();
            r0.q q4 = r0.a.d(p0, q3);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m1, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            androidx.compose.runtime.w.x(p0, q4, h3);
            p0 p00 = n0.a(M.j.a, r0.d.k, p0, 0x30);
            int v4 = p0.P;
            androidx.compose.runtime.i0 i02 = p0.m();
            r0.q q5 = r0.a.d(p0, n0);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p00, h0);
            androidx.compose.runtime.w.x(p0, i02, h1);
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            androidx.compose.runtime.w.x(p0, q5, h3);
            j5.n.b(0x7F080154, null, androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.q(n0, 25.0f), 16.0f), null, null, null, p0, 438, 0xFF8);  // drawable:btn_common_mixup_16
            N1.b(l1.s(n0, 8.0f, p0, 0x7F1302F4, p0), null, e0.T(p0, 0x7F06016D), 15.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF2);  // string:detail_common_genre_play_button_mixup "장르 믹스업"
            A7.d.s(p0, true, true, true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Id.h(v, 5, u00, q0, s);
        }
    }

    public static final void e(r0.q q0, F f0, P.c c0, M.i0 i00, boolean z, Z z1, boolean z2, androidx.compose.foundation.m m0, M.h h0, M.f f1, k k0, androidx.compose.runtime.l l0, int v, int v1) {
        r0.q q2;
        V v18;
        p p0 = (p)l0;
        p0.c0(708740370);
        int v2 = (v & 6) == 0 ? (p0.g(q0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v2 |= (p0.g(f0) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v2 |= (((v & 0x200) == 0 ? p0.g(c0) : p0.i(c0)) ? 0x100 : 0x80);
        }
        if((v & 0xC00) == 0) {
            v2 |= (p0.g(i00) ? 0x800 : 0x400);
        }
        if((v & 0x6000) == 0) {
            v2 |= (p0.h(false) ? 0x4000 : 0x2000);
        }
        if((v & 0x30000) == 0) {
            v2 |= (p0.h(z) ? 0x20000 : 0x10000);
        }
        if((v & 0x180000) == 0) {
            v2 |= (p0.g(z1) ? 0x100000 : 0x80000);
        }
        if((v & 0xC00000) == 0) {
            v2 |= (p0.h(z2) ? 0x800000 : 0x400000);
        }
        if((v & 0x6000000) == 0) {
            v2 |= (p0.g(m0) ? 0x4000000 : 0x2000000);
        }
        if((v & 0x30000000) == 0) {
            v2 |= (p0.g(h0) ? 0x20000000 : 0x10000000);
        }
        int v3 = (v1 & 6) == 0 ? v1 | (p0.g(f1) ? 4 : 2) : v1;
        if((v1 & 0x30) == 0) {
            v3 |= (p0.i(k0) ? 0x20 : 16);
        }
        boolean z3 = true;
        if(p0.Q(v2 & 1, (v2 & 306783379) != 306783378 || (v3 & 19) != 18)) {
            p0.V();
            if((v & 1) != 0 && !p0.B()) {
                p0.T();
            }
            p0.q();
            int v4 = v2 >> 3 & 14;
            int v5 = v4 | v3 & 0x70;
            b0 b00 = androidx.compose.runtime.w.w(k0, p0);
            boolean z4 = (v5 & 14 ^ 6) > 4 && p0.g(f0) || (v5 & 6) == 4;
            O.l l1 = p0.N();
            V v6 = androidx.compose.runtime.k.a;
            if(z4 || l1 == v6) {
                O.m m1 = new O.m(b00, 1);
                G.g g0 = new G.g(5, androidx.compose.runtime.w.h(V.d, m1), f0);
                E e0 = androidx.compose.runtime.w.h(V.d, g0);
                l1 = new O.l(0, 1, b1.class, e0, "value", "getValue()Ljava/lang/Object;");
                p0.l0(l1);
            }
            int v7 = v4 | v2 >> 9 & 0x70;
            int v8 = ((v7 & 14 ^ 6) <= 4 || !p0.g(f0)) && (v7 & 6) != 4 ? 0 : 1;
            int v9 = ((v7 & 0x70 ^ 0x30) <= 0x20 || !p0.h(false)) && (v7 & 0x30) != 0x20 ? 0 : 1;
            P.J j0 = p0.N();
            if((v9 | v8) != 0 || j0 == v6) {
                j0 = new P.J(f0);
                p0.l0(j0);
            }
            CoroutineScope coroutineScope0 = p0.N();
            if(coroutineScope0 == v6) {
                coroutineScope0 = androidx.compose.runtime.J.i(p0);
                p0.l0(coroutineScope0);
            }
            Object object0 = p0.k(Q0.k0.g);
            C c1 = ((Boolean)p0.k(Q0.k0.v)).booleanValue() ? null : androidx.compose.foundation.lazy.layout.d0.a;
            int v10 = v2 & 0x7FFF0 | v3 << 18 & 0x380000 | v2 >> 6 & 0x1C00000;
            int v11 = ((v10 & 0x70 ^ 0x30) <= 0x20 || !p0.g(f0)) && (v10 & 0x30) != 0x20 ? 0 : 1;
            int v12 = ((v10 & 0x380 ^ 0x180) <= 0x100 || !p0.g(c0)) && (v10 & 0x180) != 0x100 ? 0 : 1;
            int v13 = ((v10 & 0x1C00 ^ 0xC00) <= 0x800 || !p0.g(i00)) && (v10 & 0xC00) != 0x800 ? 0 : 1;
            int v14 = ((0xE000 & v10 ^ 0x6000) <= 0x4000 || !p0.h(false)) && (v10 & 0x6000) != 0x4000 ? 0 : 1;
            int v15 = ((0x70000 & v10 ^ 0x30000) <= 0x20000 || !p0.h(z)) && (v10 & 0x30000) != 0x20000 ? 0 : 1;
            int v16 = ((v10 & 0x380000 ^ 0x180000) <= 0x100000 || !p0.g(f1)) && (v10 & 0x180000) != 0x100000 ? 0 : 1;
            int v17 = ((v10 & 0x1C00000 ^ 0xC00000) <= 0x800000 || !p0.g(h0)) && (v10 & 0xC00000) != 0x800000 ? 0 : 1;
            boolean z5 = p0.g(((z)object0));
            P.q q1 = p0.N();
            if((v15 | (v11 | v12 | v13 | v14) | v16 | v17 | z5) != 0 || q1 == v6) {
                v18 = v6;
                q1 = new P.q(f0, z, i00, l1, c0, h0, f1, coroutineScope0, ((z)object0), c1);
                p0.l0(q1);
            }
            else {
                v18 = v6;
            }
            I.u0 u00 = z ? I.u0.a : I.u0.b;
            if(z2) {
                p0.a0(-1614890700);
                if(((v4 ^ 6) <= 4 || !p0.g(f0)) && (v2 >> 3 & 6) != 4) {
                    z3 = false;
                }
                P.d d0 = p0.N();
                if(z3 || d0 == v18) {
                    d0 = new P.d(f0);
                    p0.l0(d0);
                }
                q2 = androidx.compose.foundation.lazy.layout.j.q(d0, f0.n, false, u00);
                p0.p(false);
            }
            else {
                p0.a0(0x9FC33A80);
                p0.p(false);
                q2 = r0.n.a;
            }
            androidx.compose.foundation.lazy.layout.j.d(l1, androidx.compose.foundation.q.v(androidx.compose.foundation.lazy.layout.j.r(q0.then(f0.k).then(f0.l), l1, j0, u00, z2, false).then(q2).then(f0.m.i), f0, u00, z2, false, z1, f0.f, false, m0, null), f0.o, q1, p0, 0);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new P.n(q0, f0, c0, i00, z, z1, z2, m0, h0, f1, k0, v, v1);
        }
    }

    public static final void f(boolean z, Bb.c c0, a a0, androidx.compose.runtime.l l0, int v) {
        androidx.compose.runtime.Z z5;
        androidx.compose.runtime.Z z4;
        b0 b01;
        q.g(c0, "item");
        q.g(a0, "onDeleteClick");
        p p0 = (p)l0;
        p0.c0(0x4000D28);
        int v1 = v | (p0.h(z) ? 4 : 2) | (p0.i(c0) ? 0x20 : 16) | (p0.i(a0) ? 0x100 : 0x80);
        if(p0.Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            b0 b00 = p0.N();
            V v2 = androidx.compose.runtime.k.a;
            if(b00 == v2) {
                b00 = androidx.compose.runtime.w.s("");
                p0.l0(b00);
            }
            androidx.compose.runtime.Z z1 = p0.N();
            if(z1 == v2) {
                z1 = androidx.compose.runtime.w.o(0.0f);
                p0.l0(z1);
            }
            Long long0 = c0.r;
            boolean z2 = p0.i(c0);
            boolean z3 = p0.i(context0);
            Lc.a a1 = p0.N();
            if(((v1 & 14) == 4 | z2 | z3) != 0 || a1 == v2) {
                b01 = b00;
                z4 = z1;
                Lc.a a2 = new Lc.a(z, c0, context0, b01, z4, null);
                p0.l0(a2);
                a1 = a2;
            }
            else {
                b01 = b00;
                z4 = z1;
            }
            androidx.compose.runtime.J.d(p0, long0, a1);
            M.d d0 = M.j.c;
            r0.g g0 = r0.d.m;
            y y0 = M.w.a(d0, g0, p0, 0);
            int v3 = p0.P;
            androidx.compose.runtime.i0 i00 = p0.m();
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
            h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, y0, h0);
            h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O) {
                z5 = z4;
                A7.d.q(v3, p0, v3, h2);
            }
            else {
                z5 = z4;
                if(!q.b(p0.N(), v3)) {
                    A7.d.q(v3, p0, v3, h2);
                }
            }
            h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q0, h3);
            M.b b0 = M.j.a;
            p0 p00 = n0.a(b0, r0.d.j, p0, 0);
            int v4 = p0.P;
            r0.h h4 = r0.d.j;
            androidx.compose.runtime.i0 i01 = p0.m();
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
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            androidx.compose.runtime.w.x(p0, q1, h3);
            r0.q q2 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.q(androidx.compose.foundation.layout.a.n(n0, 16.0f, 16.0f, 10.0f, 0.0f, 8), 12.0f), 15.0f);
            androidx.compose.foundation.q.c(I.Q(0x7F080587, p0, 6), null, q2, null, null, 0.0f, null, p0, 0x1B0, 120);  // drawable:ic_my_list_playlist
            r0.q q3 = q0.a(androidx.compose.foundation.layout.a.n(n0, 0.0f, 16.0f, 0.0f, 0.0f, 13), 1.0f);
            y y1 = M.w.a(d0, g0, p0, 0);
            int v5 = p0.P;
            androidx.compose.runtime.i0 i02 = p0.m();
            r0.q q4 = r0.a.d(p0, q3);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y1, h0);
            androidx.compose.runtime.w.x(p0, i02, h1);
            if(p0.O || !q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h2);
            }
            androidx.compose.runtime.w.x(p0, q4, h3);
            p0 p01 = n0.a(b0, h4, p0, 0);
            int v6 = p0.P;
            androidx.compose.runtime.i0 i03 = p0.m();
            r0.q q5 = r0.a.d(p0, n0);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p01, h0);
            androidx.compose.runtime.w.x(p0, i03, h1);
            if(p0.O || !q.b(p0.N(), v6)) {
                A7.d.q(v6, p0, v6, h2);
            }
            androidx.compose.runtime.w.x(p0, q5, h3);
            r0.q q6 = q0.a(n0, 1.0f);
            r0.q q7 = H0.b.r(r0.d.k, q6);
            N1.b((c0.l == null ? "" : c0.l), q7, e0.T(p0, 0x7F06016D), 15.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F0);  // color:gray900s
            r0.q q8 = H0.b.r(r0.d.k, androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.q(androidx.compose.foundation.layout.a.n(n0, 10.0f, 0.0f, 0.0f, 0.0f, 14), 31.0f), 14.0f));
            N1.b(((String)b01.getValue()), q8, e0.T(p0, 0x7F060159), 12.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF0);  // color:gray400s_support_high_contrast
            p0.p(true);
            p0.p(true);
            r0.q q9 = r0.a.a(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.q(androidx.compose.foundation.layout.a.n(n0, 9.0f, 14.0f, 16.0f, 0.0f, 8), 18.0f), 18.0f), new Lc.c(0, a0));
            androidx.compose.foundation.q.c(I.Q(0x7F080583, p0, 6), null, q9, null, null, 0.0f, null, p0, 0x30, 120);  // drawable:ic_my_list_delete
            p0.p(true);
            r0.q q10 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.a.n(n0, 16.0f, 13.0f, 16.0f, 0.0f, 8).then(androidx.compose.foundation.layout.d.c), 2.0f);
            long v7 = e0.T(p0, 0x7F06014B);  // color:gray100s_support_high_contrast
            long v8 = e0.T(p0, 0x7F06017A);  // color:green500e_support_high_contrast
            Z.E.a(((I0)z5).m(), q10, v8, v7, p0, 0x30);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new z2(z, c0, a0, v);
        }
    }

    public static final void g(boolean z, a a0, a a1, androidx.compose.runtime.l l0, int v) {
        Context context1;
        int v3;
        q.g(a0, "onFirstButtonClick");
        q.g(a1, "onSecondButtonClick");
        p p0 = (p)l0;
        p0.c0(0x934800B8);
        int v1 = v | (p0.h(z) ? 4 : 2) | (p0.i(a0) ? 0x20 : 16);
        if(p0.Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            r0.n n0 = r0.n.a;
            r0.q q0 = androidx.compose.foundation.layout.a.m(n0, 16.0f, 20.0f, 16.0f, 10.0f).then(androidx.compose.foundation.layout.d.c);
            p0 p00 = n0.a(M.j.a, r0.d.j, p0, 0);
            int v2 = p0.P;
            androidx.compose.runtime.i0 i00 = p0.m();
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
            r0.q q2 = new LayoutWeightElement(1.0f, true).then(new VerticalAlignElement(r0.d.k));
            q.f("다운로드 진행", "getString(...)");
            N1.b("다운로드 진행", q2, e0.T(p0, 0x7F06016D), 16.0f, null, null, 0L, null, 0.0f, 0, false, 1, 0, null, null, p0, 0xC00, 0xC00, 0x1DFF0);  // color:gray900s
            r0.q q3 = androidx.compose.foundation.layout.d.q(androidx.compose.foundation.layout.a.n(n0, 5.0f, 0.0f, 0.0f, 0.0f, 14), 70.0f);
            androidx.compose.foundation.y y0 = androidx.compose.foundation.q.a(e0.T(p0, 0x7F060152), 0.5f);  // color:gray200a
            T.d d0 = e.b(100.0f);
            r0.q q4 = r0.a.a(androidx.compose.foundation.q.j(q3, y0.a, y0.b, d0), new Lc.c(1, a0));
            q.f("전체삭제", "getString(...)");
            N1.b("전체삭제", q4, e0.T(p0, 0x7F060160), 13.0f, null, null, 0L, new l1.k(3), 25.0f, 0, false, 0, 0, null, null, p0, 0xC00, 6, 0x1F9F0);  // color:gray600s_support_high_contrast
            r0.q q5 = androidx.compose.foundation.layout.d.q(androidx.compose.foundation.layout.a.n(n0, 5.0f, 0.0f, 0.0f, 0.0f, 14), 70.0f);
            androidx.compose.foundation.y y1 = androidx.compose.foundation.q.a(e0.T(p0, 0x7F060152), 0.5f);  // color:gray200a
            T.d d1 = e.b(100.0f);
            r0.q q6 = r0.a.a(androidx.compose.foundation.q.j(q5, y1.a, y1.b, d1), new Lc.c(2, a1));
            if(z) {
                v3 = 0x7F130375;  // string:download_queue_pause "일시정지"
                context1 = context0;
            }
            else {
                context1 = context0;
                v3 = 0x7F130374;  // string:download_queue_download "다운로드"
            }
            String s = context1.getString(v3);
            q.d(s);
            N1.b(s, q6, e0.T(p0, 0x7F060160), 13.0f, null, null, 0L, new l1.k(3), 25.0f, 0, false, 0, 0, null, null, p0, 0xC00, 6, 0x1F9F0);  // color:gray600s_support_high_contrast
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Cd.c(z, a0, a1, v, 1);
        }
    }

    public static void h() {
        synchronized(w.class) {
            if(!w.a) {
                w.a = true;
                O6.a(t4.b);
                O6.a(K4.b);
                O6.a(w6.b);
                O6.a(B.b);
                O6.a(ra.b);
                O6.a(yd.b);
                O6.a(w2.a);
                O6.a(() -> v.a);
                O6.a(L6.b);
                E4 e40 = new E4(17);
                F4.a.add(e40);
            }
        }
    }

    public static final Y.m i(J0.h h0, Y.h h1) {
        Y.i i0 = h0.j();
        Vd.w w0 = (Vd.w)h0.d;
        return i0 == Y.i.a ? new Y.m(w.k(w0, true, true, h1), w.k(w0, true, false, h1), true) : new Y.m(w.k(w0, false, true, h1), w.k(w0, false, false, h1), false);
    }

    public static final Y.l j(J0.h h0, Vd.w w0, Y.l l0) {
        Y.i i0;
        int v = w0.c;
        int v1 = w0.b;
        boolean z = h0.b;
        int v2 = z ? v1 : v;
        Q q0 = (Q)w0.e;
        int v3 = w0.d;
        ie.j j0 = d3.g.P(ie.k.c, new N(w0, v2));
        ie.j j1 = d3.g.P(ie.k.c, new Y.o(w0, v2, (z ? v : v1), h0, j0));
        if(1L != l0.c) {
            return (Y.l)j1.getValue();
        }
        if(v2 == v3) {
            return l0;
        }
        int v4 = q0.b.d(v3);
        if(((Number)j0.getValue()).intValue() != v4) {
            return (Y.l)j1.getValue();
        }
        int v5 = l0.b;
        long v6 = q0.j(v5);
        if(v3 != -1) {
            if(v2 == v3) {
                return w0.d(v2);
            }
            if(v1 < v) {
                i0 = Y.i.b;
            }
            else {
                i0 = v1 <= v ? Y.i.c : Y.i.a;
            }
            if((i0 == Y.i.a ^ z) != 0) {
                if(v2 >= v3) {
                    return w0.d(v2);
                }
                return v5 == ((int)(v6 >> 0x20)) || v5 == ((int)(0xFFFFFFFFL & v6)) ? ((Y.l)j1.getValue()) : w0.d(v2);
            }
            if(v2 <= v3) {
                return w0.d(v2);
            }
        }
        return v5 == ((int)(v6 >> 0x20)) || v5 == ((int)(0xFFFFFFFFL & v6)) ? ((Y.l)j1.getValue()) : w0.d(v2);
    }

    public static final Y.l k(Vd.w w0, boolean z, boolean z1, Y.h h0) {
        long v = h0.a(w0, (z1 ? w0.b : w0.c));
        return (z ^ z1) == 0 ? w0.d(((int)(0xFFFFFFFFL & v))) : w0.d(((int)(v >> 0x20)));
    }

    public static final Y.l l(Y.l l0, Vd.w w0, int v) {
        return new Y.l(((Q)w0.e).a(v), v, l0.c);
    }

    public static int m(int v, int v1) {
        long v2 = ((long)v) + ((long)v1);
        if(v2 != ((long)(((int)v2)))) {
            throw new ArithmeticException("overflow: checkedAdd(" + v + ", " + v1 + ")");
        }
        return (int)v2;
    }

    public static void n(s s0, CommentConfig commentConfig0, d d0, ActionKind actionKind0, String s1, String s2, String s3, String s4) {
        q.g(d0, "stringProvider");
        g g0 = w.C(s0, commentConfig0);
        if(g0 != null) {
            g0.a = ((StringProviderImpl)d0).a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            g0.d = actionKind0;
            g0.y = ((StringProviderImpl)d0).a(0x7F130DEC);  // string:tiara_common_layer1_comment_list "댓글리스트"
            g0.F = s1;
            g0.e = s2;
            g0.f = s3;
            g0.g = s4;
            if(((StringProviderImpl)d0).a(0x7F130D82).equals(s1)) {  // string:tiara_click_copy_profile "프로필"
                g0.e = null;
                g0.f = null;
                g0.g = null;
                g0.h = s4;
            }
            g0.a().track();
        }
    }

    public static final A o(Context context0, Class class0, String s) {
        q.g(context0, "context");
        if(Tf.o.H0(s)) {
            throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
        }
        if(s.equals(":memory:")) {
            throw new IllegalArgumentException("Cannot build a database with the special name \':memory:\'. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
        }
        return new A(context0, class0, s);
    }

    @Override  // c2.d0
    public void onAnimationStart() {
    }

    public static final float p(K k0) {
        return k0.k().e == I.u0.b ? Float.intBitsToFloat(((int)(k0.p() >> 0x20))) : Float.intBitsToFloat(((int)(k0.p() & 0xFFFFFFFFL)));
    }

    public static final void q(G4.a a0) {
        q.g(a0, "connection");
        ke.b b0 = e.k.l();
        G4.c c0 = a0.l0("SELECT name FROM sqlite_master WHERE type = \'trigger\'");
        while(true) {
            try {
                if(!c0.j0()) {
                    break;
                }
                b0.add(c0.S(0));
            }
            catch(Throwable throwable0) {
                x.y(c0, throwable0);
                throw throwable0;
            }
        }
        x.y(c0, null);
        ListIterator listIterator0 = e.k.h(b0).listIterator(0);
        while(((r)listIterator0).hasNext()) {
            String s = (String)((r)listIterator0).next();
            if(Tf.v.r0(s, "room_fts_content_sync_", false)) {
                h7.u0.w(("DROP TRIGGER IF EXISTS " + s), a0);
            }
        }
    }

    public static final void r(B3.d d0) {
        if(d0.b != 1 || d0.c != 1) {
            throw new IllegalArgumentException(("BooleanFlagDelegate can work only with boolean flags (bitWidth = 1 and value = 1), but " + d0 + " was passed").toString());
        }
    }

    public static Object s(Object object0, Class class0) {
        if(object0 instanceof fe.a) {
            return class0.cast(object0);
        }
        if(!(object0 instanceof fe.b)) {
            throw new IllegalStateException("Given component holder " + object0.getClass() + " does not implement " + fe.a.class + " or " + fe.b.class);
        }
        return w.s(((fe.b)object0).generatedComponent(), class0);
    }

    public static final me.i t(H h0, boolean z, oe.c c0) {
        if(h0.inCompatibilityMode$room_runtime_release()) {
            P p0 = (P)c0.getContext().get(P.c);
            if(p0 != null) {
                me.i i0 = h0.getQueryContext().plus(p0.a);
                if(i0 != null) {
                    return i0;
                }
            }
            return z ? h0.getTransactionContext$room_runtime_release() : h0.getQueryContext();
        }
        return h0.getCoroutineScope().getCoroutineContext();
    }

    public static Intent u(String s) {
        Intent intent0 = new Intent(Y.a(MelonAppBase.Companion), MelonIntentService.class);
        intent0.setAction(s);
        return intent0;
    }

    public static Intent v(String s, String s1, String s2) {
        Intent intent0 = w.u("com.iloen.melon.intent.action.playservice.autoplay.mixup").putExtra("songId", s).putExtra("songName", s1).putExtra("artistIds", s2);
        q.f(intent0, "putExtra(...)");
        return intent0;
    }

    public static Intent w(Actor actor0) {
        q.g(actor0, "actor");
        Intent intent0 = w.u("com.iloen.melon.save_repeat_mode").putExtra("com.iloen.melon.intent.extra.actor", actor0).setData(new Uri.Builder().appendPath(actor0.name()).build());
        q.f(intent0, "setData(...)");
        return intent0;
    }

    public static Intent x(Actor actor0) {
        q.g(actor0, "actor");
        Intent intent0 = w.u("com.iloen.melon.save_shuffle_mode").putExtra("com.iloen.melon.intent.extra.actor", actor0).setData(new Uri.Builder().appendPath(actor0.name()).build());
        q.f(intent0, "setData(...)");
        return intent0;
    }

    public static Intent y(Actor actor0) {
        q.g(actor0, "actor");
        Intent intent0 = w.u("com.iloen.melon.intent.action.playservice.next").putExtra("com.iloen.melon.intent.extra.actor", actor0).setData(new Uri.Builder().appendPath(actor0.name()).build());
        q.f(intent0, "setData(...)");
        return intent0;
    }

    public static Intent z(Actor actor0) {
        q.g(actor0, "actor");
        Intent intent0 = w.u("com.iloen.melon.intent.action.playservice.playpause").putExtra("com.iloen.melon.intent.extra.actor", actor0).setData(new Uri.Builder().appendPath(actor0.name()).build());
        q.f(intent0, "setData(...)");
        return intent0;
    }
}

