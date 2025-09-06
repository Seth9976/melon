package a;

import Ac.P0;
import Ac.W;
import Ac.X2;
import Af.o;
import Af.p;
import Bc.d;
import Cb.l;
import Cb.m;
import Cc.M0;
import Cc.N1;
import Cc.c1;
import Cc.e0;
import Cc.m3;
import Cc.z2;
import Ce.g;
import D2.F;
import De.I;
import Ge.A0;
import Ge.m0;
import H0.e;
import Hd.C;
import J2.t;
import M.b;
import M.j;
import M.p0;
import M.w;
import M.y;
import N0.M;
import Nc.F0;
import Nc.Y;
import Nc.u1;
import Nc.v1;
import P0.i;
import Q.O;
import Qf.f;
import T7.h;
import Tf.v;
import Vc.h0;
import Vc.q0;
import W7.c;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.runtime.J;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.V;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.n0;
import com.google.gson.r;
import com.google.gson.s;
import com.google.gson.u;
import com.google.gson.x;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.l1;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.playback.Playable;
import com.melon.net.res.common.SongInfoBase;
import h7.u0;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.SupervisorKt;
import we.k;
import we.n;

public abstract class a {
    public static final int a;
    public static final int b;
    public static final int c;
    public static final int d;
    public static final int e;
    public static final int f;

    public static final Integer A(Integer integer0) {
        return integer0 == null || ((int)integer0) != -1 ? integer0 : null;
    }

    public static final void B(BroadcastReceiver broadcastReceiver0, CoroutineDispatcher coroutineDispatcher0, n n0) {
        CoroutineScope coroutineScope0 = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(coroutineDispatcher0));
        BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new F(n0, coroutineScope0, broadcastReceiver0.goAsync(), null), 3, null);
    }

    public static final void C(MelonTextView melonTextView0, k k0) {
        q.g(melonTextView0, "<this>");
        if(melonTextView0.getLayout() == null) {
            melonTextView0.getViewTreeObserver().addOnPreDrawListener(new m(k0, melonTextView0));
            return;
        }
        k0.invoke(melonTextView0.getLineCount());
    }

    public static final f D(ArrayList arrayList0) {
        f f0 = new f();
        for(Object object0: arrayList0) {
            if(((p)object0) != null && ((p)object0) != o.b) {
                f0.add(object0);
            }
        }
        return f0;
    }

    public static final void E(TextView textView0, CharSequence charSequence0, CharSequence charSequence1, CharSequence charSequence2, int v, int v1, boolean z) {
        q.g(charSequence0, "frontText");
        q.g(charSequence1, "replaceText");
        q.g(charSequence2, "backText");
        if(!Tf.o.H0(charSequence1) && v1 <= 50) {
            textView0.post(new l(textView0, charSequence0, charSequence1, charSequence2, v, v1, z));
            return;
        }
        textView0.setMaxLines(v);
        textView0.setVisibility(0);
        if(!Tf.o.H0(charSequence1) && z) {
            a.F(textView0, charSequence0, charSequence1);
        }
    }

    public static final void F(TextView textView0, CharSequence charSequence0, CharSequence charSequence1) {
        CharSequence charSequence2 = textView0.getText();
        q.e(charSequence2, "null cannot be cast to non-null type android.text.Spannable");
        ForegroundColorSpan foregroundColorSpan0 = new ForegroundColorSpan(textView0.getHighlightColor());
        int v = charSequence0.length();
        int v1 = charSequence0.length();
        ((Spannable)charSequence2).setSpan(foregroundColorSpan0, v, charSequence1.length() + v1, 33);
    }

    public static final int G(g g0) {
        int v = g0.a;
        if(g0.isEmpty()) {
            throw new IllegalArgumentException("Cannot get random in empty range: " + g0);
        }
        int v1 = g0.b;
        if(v1 < 0x7FFFFFFF) {
            return Ae.f.b.d(v, v1 + 1);
        }
        return v <= 0x80000000 ? Ae.f.b.b() : Ae.f.b.d(v - 1, v1) + 1;
    }

    public static void H(InputConnection inputConnection0, EditorInfo editorInfo0, TextView textView0) {
        if(inputConnection0 != null && editorInfo0.hintText == null) {
            for(ViewParent viewParent0 = textView0.getParent(); viewParent0 instanceof View; viewParent0 = viewParent0.getParent()) {
            }
        }
    }

    public static com.google.gson.q I(W7.a a0) {
        int v = a0.o;
        if(v == 2) {
            a0.o = 1;
        }
        try {
            return h.i(a0);
        }
        catch(StackOverflowError | OutOfMemoryError stackOverflowError0) {
            throw new u("Failed parsing JSON source: " + a0 + " to Json", stackOverflowError0);  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V
        }
        finally {
            a0.c0(v);
        }
    }

    public static com.google.gson.q J(InputStreamReader inputStreamReader0) {
        try {
            W7.a a0 = new W7.a(inputStreamReader0);
            com.google.gson.q q0 = a.I(a0);
            q0.getClass();
            if(!(q0 instanceof s) && a0.Z() != 10) {
                throw new x("Did not consume the entire document.");  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V
            }
            return q0;
        }
        catch(c | NumberFormatException exception0) {
            throw new x(exception0);  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V
        }
        catch(IOException iOException0) {
            throw new r(iOException0);  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V
        }
    }

    public abstract void K(M6.p arg1, M6.p arg2);

    public abstract void L(M6.p arg1, Thread arg2);

    public static final void M(View view0, E4.g g0) {
        q.g(view0, "<this>");
        view0.setTag(0x7F0A0DD3, g0);  // id:view_tree_saved_state_registry_owner
    }

    public static final void N(TextView textView0, String s, String s1, String s2, int v, boolean z) {
        q.g(s, "fullText");
        q.g(s1, "replaceText");
        if(s1.length() == 0 || !Tf.o.v0(s, s2, false)) {
            textView0.setText(s);
            textView0.setVisibility(0);
            textView0.setMaxLines(v);
            return;
        }
        try {
            int v1 = Tf.o.F0(s, s2, 0, false, 6);
            String s3 = s.subSequence(0, v1).toString();
            String s4 = s.subSequence(s2.length() + v1, s.length()).toString();
            textView0.setVisibility(4);
            textView0.setMaxLines(v + 1);
            textView0.setSingleLine(false);
            textView0.setText((v == 1 ? v.p0(v.p0((s3 + s1 + s4), " ", " "), "-", "—") : s3 + s1 + s4));
            a.E(textView0, s3, s1, s4, v, 0, z);
        }
        catch(Exception unused_ex) {
            textView0.setText(s);
            textView0.setVisibility(0);
        }
    }

    public static final void O(TextView textView0, int v) {
        Drawable[] arr_drawable = textView0.getCompoundDrawables();
        q.f(arr_drawable, "getCompoundDrawables(...)");
        for(Object object0: je.n.g0(arr_drawable)) {
            ((Drawable)object0).mutate();
            ((Drawable)object0).setTint(v);
        }
    }

    public static final v1 P(SongInfoBase songInfoBase0, String s, k k0) {
        String s1 = songInfoBase0.songName == null ? "" : songInfoBase0.songName;
        String s2 = songInfoBase0.getArtistNames();
        String s3 = songInfoBase0.albumImg == null ? "" : songInfoBase0.albumImg;
        boolean z = songInfoBase0.isAdult;
        boolean z1 = songInfoBase0.isHoldback;
        boolean z2 = songInfoBase0.isFree;
        boolean z3 = songInfoBase0.canService;
        if(s == null) {
            s = "";
        }
        Playable playable0 = Playable.from(songInfoBase0, s, null);
        q.f(playable0, "from(...)");
        return new v1(s1, s2, s3, z, z1, z2, z3, playable0, false, false, k0);
    }

    public static final void a(r0.q q0, String s, String s1, String s2, int v, we.a a0, we.a a1, androidx.compose.runtime.l l0, int v1) {
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0x7670AB40);
        int v2 = v1 | (p0.g(s) ? 0x20 : 16) | (p0.g(s1) ? 0x100 : 0x80) | (p0.g(s2) ? 0x800 : 0x400) | (p0.e(v) ? 0x4000 : 0x2000) | (p0.i(a0) ? 0x20000 : 0x10000) | (p0.i(a1) ? 0x100000 : 0x80000);
        if(p0.Q(v2 & 1, (0x92493 & v2) != 0x92492)) {
            r0.q q1 = r0.a.a(q0, new Lc.c(17, a0));
            d d0 = p0.N();
            if((0x380000 & v2) == 0x100000 || d0 == androidx.compose.runtime.k.a) {
                d0 = new d(15, a1);
                p0.l0(d0);
            }
            r0.q q2 = m3.b(q1, d0);
            y y0 = w.a(j.c, r0.d.m, p0, 0);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q3 = r0.a.d(p0, q2);
            P0.k.y.getClass();
            i i0 = P0.j.b;
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
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h0);
            }
            androidx.compose.runtime.w.x(p0, q3, P0.j.d);
            c1.n(e0.L(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(r0.n.a, 1.0f), 242.0f), 0x7F0604AE), s, null, N0.j.b, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, v2 & 0x70 | 0xC00, 0, 0x7FF4);  // color:white120e
            N1.c(s1, v, U4.x.s(r0.n.a, 8.0f, p0, r0.n.a, 1.0f), 0L, 18.0f, null, null, 0L, 0.0f, 2, false, 2, 0, null, null, p0, v2 >> 6 & 14 | 0x6180 | v2 >> 9 & 0x70, 0x6180, 0x3AFE8);
            N1.b(s2, U4.x.s(r0.n.a, 6.0f, p0, r0.n.a, 1.0f), e0.T(p0, 0x7F060160), 13.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, v2 >> 9 & 14 | 0xC30, 0xC30, 0x1D7F0);  // color:gray600s_support_high_contrast
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Cc.n0(q0, s, s1, s2, v, a0, a1, v1);
        }
    }

    public static final void b(r0.q q0, androidx.compose.runtime.l l0, int v) {
        ((androidx.compose.runtime.p)l0).c0(0xB4B9C086);
        if(((androidx.compose.runtime.p)l0).Q((v | 6) & 1, ((v | 6) & 3) != 2)) {
            r0.n n0 = r0.n.a;
            r0.q q1 = androidx.compose.foundation.layout.d.t(androidx.compose.foundation.layout.d.f(n0, 1.0f), 3);
            M m0 = M.p.d(r0.d.a, false);
            int v1 = ((androidx.compose.runtime.p)l0).P;
            i0 i00 = ((androidx.compose.runtime.p)l0).m();
            r0.q q2 = r0.a.d(((androidx.compose.runtime.p)l0), q1);
            P0.k.y.getClass();
            i i0 = P0.j.b;
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
            if(((androidx.compose.runtime.p)l0).O || !q.b(((androidx.compose.runtime.p)l0).N(), v1)) {
                A7.d.q(v1, ((androidx.compose.runtime.p)l0), v1, h0);
            }
            androidx.compose.runtime.w.x(((androidx.compose.runtime.p)l0), q2, P0.j.d);
            M.c.d(((androidx.compose.runtime.p)l0), androidx.compose.foundation.q.f(androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.a.n(n0, 0.0f, 25.0f, 0.0f, 18.0f, 5), 1.0f), 1.0f), e0.T(((androidx.compose.runtime.p)l0), 0x7F06014A), y0.M.a));  // color:gray100a
            ((androidx.compose.runtime.p)l0).p(true);
            q0 = n0;
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
        }
        n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new Bd.h(q0, v, 2);
        }
    }

    public static final void c(int v, androidx.compose.runtime.l l0, r0.q q0, k k0, boolean z) {
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(1714670379);
        int v1 = v | (p0.h(z) ? 0x20 : 16) | (p0.i(k0) ? 0x100 : 0x80);
        if(p0.Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            r0.q q1 = r0.a.a(androidx.compose.foundation.layout.d.f(q0, 1.0f), new M0(k0, z, 1));
            p0 p00 = M.n0.a(j.e, r0.d.k, p0, 54);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q2 = r0.a.d(p0, q1);
            P0.k.y.getClass();
            i i0 = P0.j.b;
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
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            androidx.compose.runtime.w.x(p0, q2, P0.j.d);
            N1.b(e.Y(p0, 0x7F1306AE), null, e0.T(p0, 0x7F06016D), 12.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF2);  // string:more_title "더보기"
            M.c.d(p0, androidx.compose.foundation.layout.d.q(r0.n.a, 1.0f));
            androidx.compose.foundation.q.c(I.Q((z ? 0x7F08008D : 0x7F080099), p0, 0), null, androidx.compose.foundation.layout.d.n(androidx.compose.foundation.layout.d.u(r0.n.a, 3), 16.0f), null, null, 0.0f, null, p0, 0x1B0, 120);  // drawable:arrow_common_menu
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new z2(q0, z, k0, v, 4);
        }
    }

    public static final void d(r0.q q0, String s, String s1, androidx.compose.runtime.l l0, int v) {
        String s2;
        q.g(s, "title");
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(50803801);
        int v1 = v | (p0.g(s) ? 0x20 : 16) | 0xD80;
        if(p0.Q(v1 & 1, (v1 & 0x493) != 1170)) {
            A9.a a0 = p0.N();
            if(a0 == androidx.compose.runtime.k.a) {
                a0 = new A9.a(9);
                p0.l0(a0);
            }
            r0.q q1 = androidx.compose.foundation.q.n(q0, null, a0, 7);
            y y0 = w.a(j.c, r0.d.m, p0, 0);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q2 = r0.a.d(p0, q1);
            P0.k.y.getClass();
            i i0 = P0.j.b;
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
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            P0.h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q2, h3);
            r0.q q3 = androidx.compose.foundation.layout.d.t(androidx.compose.foundation.layout.d.f(r0.n.a, 1.0f), 3);
            p0 p00 = M.n0.a(j.a, r0.d.k, p0, 0x30);
            int v3 = p0.P;
            i0 i01 = p0.m();
            r0.q q4 = r0.a.d(p0, q3);
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
            androidx.compose.runtime.w.x(p0, q4, h3);
            N1.b(s, null, e0.T(p0, 0x7F06016D), 18.0f, e1.y.i, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, v1 >> 3 & 14 | 0x30C00, 0, 0x1FFD2);  // color:gray900s
            p0.a0(0x5606AA23);
            p0.p(false);
            p0.p(true);
            s2 = "";
            p0.a0(0x7925117F);
            p0.p(false);
            p0.p(true);
        }
        else {
            p0.T();
            s2 = s1;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new P0(q0, s, s2, v, 1);
        }
    }

    public static final void e(r0.q q0, F0 f00, androidx.compose.runtime.l l0, int v) {
        q.g(f00, "genreListItemTitleUiState");
        k k0 = f00.c;
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0xAEFD5DF8);
        int v1 = (p0.g(f00) ? 0x20 : 16) | v;
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            Ma.k k1 = p0.N();
            if(k1 == androidx.compose.runtime.k.a) {
                k1 = new Ma.k(4);
                p0.l0(k1);
            }
            r0.q q1 = X0.n.c(q0, true, k1);
            if(k0 != null) {
                r0.q q2 = r0.a.a(q1, new Ac.l(9, k0, f00));
                if(q2 != null) {
                    q1 = q2;
                }
            }
            y y0 = w.a(j.c, r0.d.m, p0, 0);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q3 = r0.a.d(p0, q1);
            P0.k.y.getClass();
            i i0 = P0.j.b;
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
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            P0.h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q3, h3);
            r0.n n0 = r0.n.a;
            r0.q q4 = androidx.compose.foundation.layout.d.t(androidx.compose.foundation.layout.d.f(n0, 1.0f), 3);
            p0 p00 = M.n0.a(j.a, r0.d.k, p0, 0x30);
            int v3 = p0.P;
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
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            androidx.compose.runtime.w.x(p0, q5, h3);
            long v4 = e0.T(p0, 0x7F06016D);  // color:gray900s
            N1.b(f00.a, null, v4, 18.0f, e1.y.i, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0x30C00, 0, 0x1FFD2);
            if(k0 == null) {
                p0.a0(-1219741307);
            }
            else {
                p0.a0(-1219741306);
                j5.n.b(0x7F08008D, null, androidx.compose.foundation.layout.d.n(n0, 16.0f), null, null, null, p0, 438, 0xFF8);  // drawable:arrow_common_menu
            }
            p0.p(false);
            p0.p(true);
            String s = f00.b;
            if(s.length() > 0) {
                p0.a0(525003172);
                N1.b(s, null, e0.T(p0, 0x7F06015D), 13.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F2);  // color:gray500s_support_high_contrast
            }
            else {
                p0.a0(0x1F174880);
            }
            p0.p(false);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Gd.p(q0, f00, v, 28);
        }
    }

    public static final void f(r0.q q0, v1 v10, androidx.compose.runtime.l l0, int v) {
        r0.q q11;
        q.g(v10, "uiState");
        boolean z = v10.j;
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0xF6CD4F4C);
        int v1 = v | 6 | (p0.i(v10) ? 0x20 : 16);
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            int v2 = v10.i ? 0x7F060199 : 0x7F06048A;  // color:list_item_marked
            r0.n n0 = r0.n.a;
            r0.q q1 = androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.d.h(n0, 60.0f), 1.0f);
            boolean z1 = p0.i(v10);
            Nc.f f0 = p0.N();
            if(z1 || f0 == androidx.compose.runtime.k.a) {
                f0 = new Nc.f(v10, 2);
                p0.l0(f0);
            }
            r0.q q2 = androidx.compose.foundation.layout.a.n(androidx.compose.foundation.q.f(r0.a.a(q1, new Ac.l(10, f0, v10)), e0.T(p0, v2), y0.M.a), 20.0f, 0.0f, 8.0f, 0.0f, 10);
            r0.h h0 = r0.d.k;
            b b0 = j.a;
            p0 p00 = M.n0.a(b0, h0, p0, 0x30);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q3 = r0.a.d(p0, q2);
            P0.k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            P0.h h1 = P0.j.f;
            androidx.compose.runtime.w.x(p0, p00, h1);
            P0.h h2 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h2);
            P0.h h3 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h3);
            }
            P0.h h4 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q3, h4);
            r0.q q4 = r0.a.a(androidx.compose.foundation.layout.d.n(n0, 44.0f), new u1(v10, 0));
            com.google.firebase.b.f(0, p0, v10.c, q4);
            M.c.d(p0, androidx.compose.foundation.layout.d.q(n0, 10.0f));
            LayoutWeightElement layoutWeightElement0 = new LayoutWeightElement(1.0f, true);
            y y0 = w.a(j.c, r0.d.m, p0, 0);
            int v4 = p0.P;
            i0 i01 = p0.m();
            r0.q q5 = r0.a.d(p0, layoutWeightElement0);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y0, h1);
            androidx.compose.runtime.w.x(p0, i01, h2);
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h3);
            }
            androidx.compose.runtime.w.x(p0, q5, h4);
            p0 p01 = M.n0.a(b0, h0, p0, 0x30);
            int v5 = p0.P;
            i0 i02 = p0.m();
            r0.q q6 = r0.a.d(p0, n0);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p01, h1);
            androidx.compose.runtime.w.x(p0, i02, h2);
            if(p0.O || !q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h3);
            }
            androidx.compose.runtime.w.x(p0, q6, h4);
            if(v10.d) {
                p0.a0(-2049634904);
                r0.q q7 = androidx.compose.foundation.layout.d.u(androidx.compose.foundation.layout.a.n(n0, 0.0f, 0.0f, 3.0f, 0.0f, 11), 3);
                j5.n.b(0x7F0803D2, e.Y(p0, 0x7F130B3D), q7, null, null, null, p0, 390, 0xFF8);  // drawable:ic_common_19
            }
            else {
                p0.a0(-2054414732);
            }
            p0.p(false);
            if(v10.f) {
                p0.a0(0x85DB2E10);
                r0.q q8 = androidx.compose.foundation.layout.d.u(androidx.compose.foundation.layout.a.n(n0, 0.0f, 0.0f, 3.0f, 0.0f, 11), 3);
                j5.n.b(0x7F0803ED, e.Y(p0, 0x7F130B2E), q8, null, null, new y0.k(e0.T(p0, 0x7F06017C), 5), p0, 390, 0xEF8);  // drawable:ic_common_free
            }
            else {
                p0.a0(-2054414732);
            }
            p0.p(false);
            if(v10.e) {
                p0.a0(-2048716250);
                r0.q q9 = androidx.compose.foundation.layout.d.u(androidx.compose.foundation.layout.a.n(n0, 0.0f, 0.0f, 3.0f, 0.0f, 11), 3);
                j5.n.b(0x7F080414, e.Y(p0, 0x7F130B4D), q9, null, null, null, p0, 390, 0xFF8);  // drawable:ic_common_time
            }
            else {
                p0.a0(-2054414732);
            }
            p0.p(false);
            r0.q q10 = z ? androidx.compose.foundation.q.h(n0, 0, 0, null, 0.0f, 62) : n0;
            long v6 = e0.T(p0, 0x7F06016D);  // color:gray900s
            q11 = n0;
            N1.b(v10.a, q10, v6, 15.0f, null, null, 0L, null, 0.0f, (z ? 1 : 2), false, 1, 0, null, null, p0, 0xC00, 0xC00, 0x1D7F0);
            p0.p(true);
            M.c.d(p0, androidx.compose.foundation.layout.d.h(q11, 2.0f));
            long v7 = e0.T(p0, 0x7F060165);  // color:gray800s
            l1.k k0 = new l1.k(3);
            N1.b(v10.b, null, v7, 13.0f, null, null, 0L, k0, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 120306);
            p0.p(true);
            M.c.d(p0, androidx.compose.foundation.layout.d.q(q11, 4.0f));
            r0.q q12 = r0.a.a(androidx.compose.foundation.layout.d.n(q11, 26.0f), new u1(v10, 1));
            j5.n.b(0x7F08015F, e.Y(p0, 0x7F130BB4), q12, null, null, new y0.k(e0.T(p0, 0x7F06016D), 5), p0, 6, 0xEF8);  // drawable:btn_common_play_02
            M.c.d(p0, androidx.compose.foundation.layout.d.q(q11, 4.0f));
            r0.q q13 = r0.a.a(androidx.compose.foundation.layout.d.n(q11, 28.0f), new u1(v10, 2));
            androidx.compose.foundation.q.c(I.Q(0x7F080159, p0, 6), e.Y(p0, 0x7F130B88), q13, null, null, 0.0f, new y0.k(e0.T(p0, 0x7F060163), 5), p0, 0, 56);  // drawable:btn_common_moreview_01
            p0.p(true);
        }
        else {
            p0.T();
            q11 = q0;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Y(q11, v10, v, 11);
        }
    }

    public static final void g(r0.q q0, h0 h00, k k0, androidx.compose.runtime.l l0, int v) {
        i i3;
        P0.h h7;
        r0.n n1;
        P0.h h6;
        P0.h h5;
        P0.h h4;
        String s = h00.b;
        String s1 = h00.f;
        N0.i i0 = N0.j.b;
        String s2 = h00.d;
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0xF7842C45);
        int v1 = v | (p0.g(h00) ? 0x20 : 16) | (p0.i(k0) ? 0x100 : 0x80);
        if(p0.Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            Ma.k k1 = p0.N();
            V v2 = androidx.compose.runtime.k.a;
            if(k1 == v2) {
                k1 = new Ma.k(26);
                p0.l0(k1);
            }
            r0.q q1 = e0.L(androidx.compose.foundation.layout.a.l(androidx.compose.foundation.layout.d.f(X0.n.c(q0, false, k1), 1.0f), 15.0f, 0.0f, 2), 0x7F06048A);  // color:transparent
            Dc.i i1 = p0.N();
            if((((v1 & 0x70) == 0x20 ? 1 : 0) | ((v1 & 0x380) == 0x100 ? 1 : 0)) != 0 || i1 == v2) {
                i1 = new Dc.i(25, k0, h00);
                p0.l0(i1);
            }
            r0.q q2 = r0.a.a(m3.b(q1, i1), new Vc.n0(k0, h00, 0));
            p0 p00 = M.n0.a(j.a, r0.d.k, p0, 0x30);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q3 = r0.a.d(p0, q2);
            P0.k.y.getClass();
            i i2 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i2);
            }
            else {
                p0.o0();
            }
            P0.h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, p00, h0);
            P0.h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            P0.h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            P0.h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q3, h3);
            ContsTypeCode contsTypeCode0 = ContsTypeCode.ARTIST;
            boolean z = s2.equals("N10006");
            wc.u u0 = y0.M.a;
            r0.n n0 = r0.n.a;
            if(!z && !s2.equals("N10101")) {
                p0.a0(0x4AA185A);
                h4 = h1;
                h7 = h0;
                h6 = h2;
                h5 = h3;
                n1 = n0;
                c1.n(androidx.compose.foundation.q.f(e0.L(androidx.compose.foundation.layout.d.n(n0, 62.0f), 0x7F0604AE), e0.T(p0, 0x7F060144), u0), s1, "", i0, false, 0x7F08078C, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x30C00, 0, 0x7FD0);  // color:white120e
                p0.p(false);
                i3 = i2;
            }
            else {
                h4 = h1;
                h5 = h3;
                h6 = h2;
                n1 = n0;
                h7 = h0;
                p0.a0(0x4A22619);
                i3 = i2;
                c1.n(androidx.compose.foundation.q.f(d5.n.o(e0.J(androidx.compose.foundation.layout.d.n(n1, 62.0f)), T.e.a), e0.T(p0, 0x7F060144), u0), s1, "", i0, false, 0x7F08079D, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x30C00, 0, 0x7FD0);  // color:gray050e
                p0.p(false);
            }
            M.c.d(p0, androidx.compose.foundation.layout.d.q(n1, 10.0f));
            LayoutWeightElement layoutWeightElement0 = new LayoutWeightElement(1.0f, true);
            y y0 = w.a(j.e, r0.d.m, p0, 6);
            int v4 = p0.P;
            i0 i01 = p0.m();
            r0.q q4 = r0.a.d(p0, layoutWeightElement0);
            p0.e0();
            if(p0.O) {
                p0.l(i3);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y0, h7);
            androidx.compose.runtime.w.x(p0, i01, h4);
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h6);
            }
            androidx.compose.runtime.w.x(p0, q4, h5);
            long v5 = e0.T(p0, 0x7F0604B7);  // color:white700e
            N1.b(h00.a, null, v5, 12.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F2);
            M.c.d(p0, androidx.compose.foundation.layout.d.h(n1, 4.0f));
            long v6 = e0.T(p0, 0x7F06009F);  // color:color_fafafa
            int v7 = e.k.A(new String[]{"N10009", "N10103", "N10005", "N10113", contsTypeCode0.code(), "N10101"}).contains(s2) ? 2 : 1;
            N1.b(h00.c, null, v6, 15.0f, null, null, 0L, null, 18.0f, 2, false, v7, 0, null, null, p0, 0xC00, 54, 0x1D3F2);
            if(s.length() > 0) {
                p0.a0(0xDCFB2392);
                M.c.d(p0, androidx.compose.foundation.layout.d.h(n1, 3.0f));
                N1.b(s, null, e0.T(p0, 0x7F0604B7), 13.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F2);  // color:white700e
            }
            else {
                p0.a0(0xDC670DD7);
            }
            p0.p(false);
            p0.p(true);
            M.c.d(p0, androidx.compose.foundation.layout.d.q(n1, 10.0f));
            c1.n(r0.a.a(androidx.compose.foundation.layout.d.n(n1, 30.0f), new Vc.n0(k0, h00, 1)), 0x7F080155, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x30, 0, 0x7FFC);  // drawable:btn_common_mixup_18
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Id.h(q0, h00, k0, v, 7);
        }
    }

    public static final void h(q0 q00, androidx.compose.runtime.l l0, int v) {
        Q.e e1;
        q.g(q00, "uiState");
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0x489DF24B);
        int v1 = v | (p0.i(q00) ? 4 : 2);
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            r0.n n0 = r0.n.a;
            r0.q q0 = e0.M(androidx.compose.foundation.layout.a.l(androidx.compose.foundation.layout.d.f(n0, 1.0f), 20.0f, 0.0f, 2), 0x7F06048A, 8.0f);  // color:transparent
            long v2 = e0.T(p0, 0x7F060087);  // color:color_4B33FF
            wc.u u0 = y0.M.a;
            r0.q q1 = androidx.compose.foundation.q.f(q0, v2, u0);
            y y0 = w.a(j.c, r0.d.m, p0, 0);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q2 = r0.a.d(p0, q1);
            P0.k.y.getClass();
            i i0 = P0.j.b;
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
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            P0.h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q2, h3);
            int v4 = (int)(((float)Math.ceil(((float)q00.b.size()) / 3.0f)));
            boolean z = p0.e(v4);
            Nc.M m0 = p0.N();
            V v5 = androidx.compose.runtime.k.a;
            if(z || m0 == v5) {
                m0 = new Nc.M(v4, 2);
                p0.l0(m0);
            }
            Q.e e0 = O.b(m0, p0, 6, 2);
            CoroutineScope coroutineScope0 = p0.N();
            if(coroutineScope0 == v5) {
                coroutineScope0 = J.i(p0);
                p0.l0(coroutineScope0);
            }
            r0.q q3 = androidx.compose.foundation.layout.a.k(androidx.compose.foundation.layout.d.f(n0, 1.0f), 15.0f, 15.0f);
            p0 p00 = M.n0.a(j.a, r0.d.k, p0, 0x30);
            int v6 = p0.P;
            i0 i01 = p0.m();
            r0.q q4 = r0.a.d(p0, q3);
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
            androidx.compose.runtime.w.x(p0, q4, h3);
            long v7 = e0.T(p0, 0x7F0604A1);  // color:white000e
            N1.b(q00.a, null, v7, 22.0f, e1.y.i, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0x30C00, 0, 0x1FFD2);
            l1.x(1.0f, true, p0);
            if(v4 > 1) {
                p0.a0(0x51B2246F);
                p0 p01 = M.n0.a(j.e, r0.d.j, p0, 6);
                int v8 = p0.P;
                i0 i02 = p0.m();
                r0.q q5 = r0.a.d(p0, n0);
                p0.e0();
                if(p0.O) {
                    p0.l(i0);
                }
                else {
                    p0.o0();
                }
                androidx.compose.runtime.w.x(p0, p01, h0);
                androidx.compose.runtime.w.x(p0, i02, h1);
                if(p0.O || !q.b(p0.N(), v8)) {
                    A7.d.q(v8, p0, v8, h2);
                }
                androidx.compose.runtime.w.x(p0, q5, h3);
                p0.a0(0x30CE91BC);
                for(int v9 = 0; v9 < v4; ++v9) {
                    boolean z1 = e0.j() == v9;
                    if(v9 == 0) {
                        p0.a0(0x27364280);
                        p0.p(false);
                    }
                    else {
                        p0.a0(662480161);
                        U4.x.z(n0, 5.0f, p0, false);
                    }
                    M.p.a(r0.a.a(androidx.compose.foundation.q.f(d5.n.o(androidx.compose.foundation.layout.d.n(n0, 5.0f), T.e.a), (z1 ? A7.d.f(p0, 1406856551, 0x7F0604A1, p0, false) : A7.d.f(p0, 1406860381, 0x7F0604B3, p0, false)), u0), new X2(coroutineScope0, e0, v9, 6)), p0, 0);  // color:white000e
                }
                e1 = e0;
                A7.d.s(p0, false, true, false);
            }
            else {
                e1 = e0;
                p0.a0(1366206833);
                p0.p(false);
            }
            p0.p(true);
            M.c.d(p0, androidx.compose.foundation.layout.d.h(n0, 14.0f));
            boolean z2 = p0.g(e1);
            boolean z3 = p0.i(q00);
            Vc.p0 p02 = p0.N();
            if(z2 || z3 || p02 == v5) {
                p02 = new Vc.p0(e1, q00, null);
                p0.l0(p02);
            }
            J.d(p0, e1, p02);
            u0.b(e1, androidx.compose.foundation.layout.d.h(n0, 218.0f), null, null, 0, 0.0f, null, null, false, null, null, null, m0.c.e(0x10702374, p0, new C(q00, 3)), p0, 0x30, 0x3FFC);
            A7.d.v(n0, 15.0f, p0, true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new C8.a(q00, v, 26);
        }
    }

    public static final void i(B2.n n0, androidx.compose.runtime.l l0, int v) {
        ((androidx.compose.runtime.p)l0).c0(1380468206);
        if((((((androidx.compose.runtime.p)l0).g(n0) ? 4 : 2) | v) & 3) == 2 && ((androidx.compose.runtime.p)l0).D()) {
            ((androidx.compose.runtime.p)l0).T();
            goto label_17;
        }
        t t0 = t.b;
        ((androidx.compose.runtime.p)l0).b0(0xBD7CCD0A);
        ((androidx.compose.runtime.p)l0).b0(0x7076B8D0);
        if(((androidx.compose.runtime.p)l0).a instanceof B2.b) {
            ((androidx.compose.runtime.p)l0).Y();
            if(((androidx.compose.runtime.p)l0).O) {
                ((androidx.compose.runtime.p)l0).l(new B2.o(t0));
            }
            else {
                ((androidx.compose.runtime.p)l0).o0();
            }
            androidx.compose.runtime.w.x(((androidx.compose.runtime.p)l0), n0, J2.e.o);
            ((androidx.compose.runtime.p)l0).p(true);
            ((androidx.compose.runtime.p)l0).p(false);
            ((androidx.compose.runtime.p)l0).p(false);
        label_17:
            n0 n00 = ((androidx.compose.runtime.p)l0).t();
            if(n00 != null) {
                n00.d = new F.e(n0, v, 4);
            }
            return;
        }
        androidx.compose.runtime.w.m();
        throw null;
    }

    public static final int j(float[] arr_f) {
        int v = 0;
        if(arr_f.length < 16) {
            return 0;
        }
        int v1 = Float.compare(arr_f[0], 1.0f) != 0 || arr_f[1] != 0.0f || arr_f[2] != 0.0f || arr_f[4] != 0.0f || arr_f[5] != 1.0f || arr_f[6] != 0.0f || arr_f[8] != 0.0f || arr_f[9] != 0.0f || arr_f[10] != 1.0f ? 0 : 1;
        if(arr_f[12] == 0.0f && arr_f[13] == 0.0f && arr_f[14] == 0.0f && arr_f[15] == 1.0f) {
            v = 1;
        }
        return v1 << 1 | v;
    }

    public static final void k(int v, StringBuilder stringBuilder0) {
        for(int v1 = 0; v1 < v; ++v1) {
            stringBuilder0.append("?");
            if(v1 < v - 1) {
                stringBuilder0.append(",");
            }
        }
    }

    public abstract boolean l(M6.h arg1, M6.e arg2, M6.e arg3);

    public abstract boolean m(M6.h arg1, Object arg2, Object arg3);

    public abstract boolean n(M6.q arg1, M6.p arg2, M6.p arg3);

    public static final void o(H.n n0) {
        ((O0)n0.a).setValue(H.k.a);
    }

    public static final Collection p(Collection collection0, Collection collection1) {
        q.g(collection1, "collection");
        if(collection1.isEmpty()) {
            return collection0;
        }
        if(collection0 == null) {
            return collection1;
        }
        if(collection0 instanceof LinkedHashSet) {
            ((LinkedHashSet)collection0).addAll(collection1);
            return collection0;
        }
        Collection collection2 = new LinkedHashSet(collection0);
        ((AbstractCollection)collection2).addAll(collection1);
        return collection2;
    }

    public static Re.c q(Class class0) {
        kf.c c1;
        q.g(class0, "klass");
        kf.e e0 = new kf.e();  // 初始化器: Ljava/lang/Object;-><init>()V
        e0.a = null;
        e0.b = null;
        boolean z = false;
        e0.c = 0;
        e0.d = null;
        e0.e = null;
        e0.f = null;
        e0.g = null;
        e0.h = null;
        c2.Y y0 = q.j(class0.getDeclaredAnnotations());
        while(y0.hasNext()) {
            Annotation annotation0 = (Annotation)y0.next();
            q.d(annotation0);
            Class class1 = df.d.v(df.d.s(annotation0));
            qf.b b0 = Se.c.a(class1);
            qf.c c0 = b0.a();
            if(c0.equals(Ze.v.a)) {
                c1 = new kf.c(e0, 0);
            }
            else if(c0.equals(Ze.v.o)) {
                c1 = new kf.c(e0, 1);
            }
            else {
                if(!kf.e.i && e0.g == null) {
                    kf.a a0 = (kf.a)kf.e.j.get(b0);
                    if(a0 != null) {
                        e0.g = a0;
                        c1 = new kf.c(e0, 2);
                        goto label_31;
                    }
                }
                c1 = null;
            }
        label_31:
            if(c1 != null) {
                U4.F.R(c1, annotation0, class1);
            }
        }
        nf.e e1 = nf.e.g;
        if(e0.g != null && e0.a != null) {
            int[] arr_v = e0.a;
            if((e0.c & 8) != 0) {
                z = true;
            }
            nf.e e2 = new nf.e(arr_v, z);
            boolean z1 = false;
            if(!e2.b(e1)) {
                z1 = true;
                e0.f = e0.d;
                e0.d = null;
            }
            else if(e0.g != kf.a.e && e0.g != kf.a.f && e0.g != kf.a.i || e0.d != null) {
                z1 = true;
            }
            if(z1) {
                String[] arr_s = e0.h;
                if(arr_s != null) {
                    pf.a.a(arr_s);
                }
                A7.a a1 = new A7.a(e0.g, e2, e0.d, e0.f, e0.e, e0.b, e0.c);
                return a1 == null ? null : new Re.c(class0, a1);
            }
        }
        return null;
    }

    public static final Object r(Class class0, Map map0, List list0) {
        q.g(class0, "annotationClass");
        q.g(list0, "methods");
        ie.r r0 = d3.g.Q(new Af.g(map0, 12));
        He.d d0 = new He.d(class0, map0, d3.g.Q(new W(13, class0, map0)), r0, list0);
        Object object0 = Proxy.newProxyInstance(class0.getClassLoader(), new Class[]{class0}, d0);
        q.e(object0, "null cannot be cast to non-null type T of kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt.createAnnotationInstance");
        return object0;
    }

    public static String s(androidx.glance.appwidget.protobuf.i i0) {
        StringBuilder stringBuilder0 = new StringBuilder(i0.size());
        for(int v = 0; v < i0.size(); ++v) {
            int v1 = i0.a(v);
            switch(v1) {
                case 7: {
                    stringBuilder0.append("\\a");
                    break;
                }
                case 8: {
                    stringBuilder0.append("\\b");
                    break;
                }
                case 9: {
                    stringBuilder0.append("\\t");
                    break;
                }
                case 10: {
                    stringBuilder0.append("\\n");
                    break;
                }
                case 11: {
                    stringBuilder0.append("\\v");
                    break;
                }
                case 12: {
                    stringBuilder0.append("\\f");
                    break;
                }
                case 13: {
                    stringBuilder0.append("\\r");
                    break;
                }
                case 34: {
                    stringBuilder0.append("\\\"");
                    break;
                }
                case 39: {
                    stringBuilder0.append("\\\'");
                    break;
                }
                case 92: {
                    stringBuilder0.append("\\\\");
                    break;
                }
                default: {
                    if(v1 < 0x20 || v1 > 0x7E) {
                        stringBuilder0.append('\\');
                        stringBuilder0.append(((char)((v1 >>> 6 & 3) + 0x30)));
                        stringBuilder0.append(((char)((v1 >>> 3 & 7) + 0x30)));
                        stringBuilder0.append(((char)((v1 & 7) + 0x30)));
                    }
                    else {
                        stringBuilder0.append(((char)v1));
                    }
                }
            }
        }
        return stringBuilder0.toString();
    }

    public abstract M6.e t(M6.h arg1);

    public abstract M6.p u(M6.h arg1);

    public static final E4.g v(View view0) {
        q.g(view0, "<this>");
        while(view0 != null) {
            Object object0 = view0.getTag(0x7F0A0DD3);  // id:view_tree_saved_state_registry_owner
            E4.g g0 = object0 instanceof E4.g ? ((E4.g)object0) : null;
            if(g0 != null) {
                return g0;
            }
            ViewParent viewParent0 = d5.w.C(view0);
            view0 = viewParent0 instanceof View ? ((View)viewParent0) : null;
        }
        return null;
    }

    public static Application w(Context context0) {
        if(context0 instanceof Application) {
            return (Application)context0;
        }
        Context context1 = context0;
        while(context1 instanceof ContextWrapper) {
            context1 = ((ContextWrapper)context1).getBaseContext();
            if(context1 instanceof Application) {
                return (Application)context1;
            }
            if(false) {
                break;
            }
        }
        throw new IllegalStateException("Could not find an Application in the given context: " + context0);
    }

    public static final Field x(De.w w0) {
        q.g(w0, "<this>");
        m0 m00 = A0.c(w0);
        return m00 == null ? null : ((Field)((ie.j)m00.k).getValue());
    }

    public static final Method y(De.g g0) {
        q.g(g0, "<this>");
        Ge.s s0 = A0.a(g0);
        if(s0 != null) {
            He.g g1 = s0.g();
            if(g1 != null) {
                Member member0 = g1.b();
                return member0 instanceof Method ? ((Method)member0) : null;
            }
        }
        return null;
    }

    public static final Object z(X0.l l0, X0.w w0) {
        Object object0 = l0.a.g(w0);
        return object0 == null ? null : object0;
    }
}

