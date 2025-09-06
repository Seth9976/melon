package e2;

import Ac.R0;
import Ac.X2;
import Cc.H3;
import Cc.N1;
import Cc.c1;
import Cc.e0;
import Cc.h0;
import Cc.r0;
import Dd.k2;
import G.C;
import G.f;
import M.j0;
import M.j;
import M.n0;
import M.p0;
import M.q0;
import M.y;
import N0.M;
import P0.i;
import P1.b;
import Q.O;
import Q0.C0;
import Q0.N;
import Rc.r;
import U8.A;
import a1.T;
import a1.g;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.ColorStateListDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Log;
import android.view.inputmethod.EditorInfo;
import androidx.appcompat.app.o;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.HorizontalAlignElement;
import androidx.compose.foundation.layout.VerticalAlignElement;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.MelonFragmentManager;
import com.iloen.melon.fragments.artistchannel.ArtistDetailContentsTopicFragment;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import dd.z;
import de.c;
import f1.x;
import gd.R7;
import gd.S7;
import gd.T7;
import gd.V7;
import gd.W7;
import gd.Y7;
import gd.a8;
import gd.b8;
import gd.c8;
import gd.e8;
import gd.f8;
import gd.g8;
import gd.h8;
import gd.l8;
import gd.m4;
import h7.u0;
import i.n.i.b.a.s.e.M3;
import ie.H;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import je.n;
import jf.p;
import kotlin.jvm.internal.q;
import lf.g0;
import okio.FileSystem;
import pf.d;
import pf.e;
import r0.h;
import ud.s;
import we.k;

public abstract class a {
    public static final int a;
    public static final int b;
    public static final int c;
    public static final int d;
    public static final int e;
    public static final int f;

    public static float A(float f, float f1, float f2, float f3) {
        float f4 = a.z(f, f1, 0.0f, 0.0f);
        float f5 = a.z(f, f1, f2, 0.0f);
        float f6 = a.z(f, f1, f2, f3);
        float f7 = a.z(f, f1, 0.0f, f3);
        if(f4 > f5 && f4 > f6 && f4 > f7) {
            return f4;
        }
        if(f5 > f6 && f5 > f7) {
            return f5;
        }
        return f6 > f7 ? f6 : f7;
    }

    public static void B(Uri uri0) {
        String s = uri0.getPath();
        if(s != null) {
        alab1:
            switch(s) {
                case "/topiclist": {
                    String s1 = uri0.getQueryParameter("artistId");
                    if(s1 != null) {
                        MelonFragmentManager.getInstance().open(ArtistDetailContentsTopicFragment.Companion.newInstance(s1));
                        return;
                    }
                    break;
                }
                case "/topiclist/topic": {
                    String[] arr_s = {uri0.getQueryParameter("artistId"), uri0.getQueryParameter("topicSeq")};
                    for(int v = 0; v < 2; ++v) {
                        if(arr_s[v] == null) {
                            break alab1;
                        }
                    }
                    ArrayList arrayList0 = n.g0(arr_s);
                    String s2 = (String)arrayList0.get(0);
                    String s3 = (String)arrayList0.get(1);
                    q.g(s2, "artistId");
                    q.g(s3, "topicSeq");
                    Navigator.INSTANCE.openTopic(s2, s3);
                }
            }
        }
    }

    public static void C(Uri uri0) {
        String s = uri0.getPath();
        if(s != null) {
            switch(s) {
                case "": {
                    String s1 = u0.y(uri0, "mode");
                    int v = 0;
                    if(s1 != null) {
                        switch(s1) {
                            case "broad": {
                                v = 5;
                                break;
                            }
                            case "liked": {
                                v = 7;
                                break;
                            }
                            case "live": {
                                v = 6;
                                break;
                            }
                            case "mv": {
                                v = 3;
                                break;
                            }
                            case "new": {
                                v = 1;
                                break;
                            }
                            case "original": {
                                v = 4;
                                break;
                            }
                            case "pop": {
                                v = 2;
                            }
                        }
                    }
                    Navigator.INSTANCE.openMelonTvMain(v);
                    return;
                }
                case "/program": {
                    String s2 = u0.y(uri0, "progSeq");
                    if(s2 != null) {
                        Navigator.INSTANCE.openMelonTvProgram(s2);
                    }
                    break;
                }
            }
        }
    }

    public static p D(c c0) {
        if(c0 instanceof e) {
            q.g(((e)c0).k, "name");
            q.g(((e)c0).l, "desc");
            return new p(((e)c0).k + ((e)c0).l);
        }
        if(!(c0 instanceof d)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        q.g(((d)c0).k, "name");
        q.g(((d)c0).l, "desc");
        return new p(((d)c0).k + '#' + ((d)c0).l);
    }

    public static int[] E(int[] arr_v) {
        for(int v = 0; v < arr_v.length; ++v) {
            int v1 = arr_v[v];
            if(v1 == 0x10100A0) {
                return arr_v;
            }
            if(v1 == 0) {
                int[] arr_v1 = (int[])arr_v.clone();
                arr_v1[v] = 0x10100A0;
                return arr_v1;
            }
        }
        int[] arr_v2 = Arrays.copyOf(arr_v, arr_v.length + 1);
        arr_v2[arr_v.length] = 0x10100A0;
        return arr_v2;
    }

    public static ColorStateList F(Drawable drawable0) {
        if(drawable0 instanceof ColorDrawable) {
            return ColorStateList.valueOf(((ColorDrawable)drawable0).getColor());
        }
        return Build.VERSION.SDK_INT < 29 || !o3.q.i(drawable0) ? null : o3.q.a(((ColorStateListDrawable)drawable0));
    }

    public static final int G(int v, int v1, int v2) {
        if(v2 > 0) {
            if(v >= v1) {
                return v1;
            }
            int v3 = v1 % v2;
            if(v3 < 0) {
                v3 += v2;
            }
            int v4 = v % v2;
            if(v4 < 0) {
                v4 += v2;
            }
            int v5 = (v3 - v4) % v2;
            if(v5 < 0) {
                v5 += v2;
            }
            return v1 - v5;
        }
        if(v2 >= 0) {
            throw new IllegalArgumentException("Step is zero.");
        }
        if(v <= v1) {
            return v1;
        }
        int v6 = v % -v2;
        if(v6 < 0) {
            v6 -= v2;
        }
        int v7 = v1 % -v2;
        if(v7 < 0) {
            v7 -= v2;
        }
        int v8 = (v6 - v7) % -v2;
        if(v8 < 0) {
            v8 -= v2;
        }
        return v8 + v1;
    }

    public static final g H(x x0) {
        x0.a.getClass();
        return x0.a.b(T.e(x0.b), T.d(x0.b));
    }

    public static final g I(x x0, int v) {
        return x0.a.b(T.d(x0.b), Math.min(T.d(x0.b) + v, x0.a.b.length()));
    }

    public static final g J(x x0, int v) {
        return x0.a.b(Math.max(0, T.e(x0.b) - v), T.e(x0.b));
    }

    public static float K(float f, float f1, float f2) [...] // Inlined contents

    public static void L(String s) {
        if(Log.isLoggable("InstallReferrerClient", 2)) {
            Log.v("InstallReferrerClient", s);
        }
    }

    public static void M(String s) {
        if(Log.isLoggable("InstallReferrerClient", 5)) {
            Log.w("InstallReferrerClient", s);
        }
    }

    public void N(FloatingActionButton floatingActionButton0) {
    }

    public void O() {
    }

    public static void P(EditorInfo editorInfo0, CharSequence charSequence0) {
        if(Build.VERSION.SDK_INT >= 30) {
            b.l(editorInfo0, charSequence0);
            return;
        }
        charSequence0.getClass();
        int v = editorInfo0.initialSelStart;
        int v1 = editorInfo0.initialSelEnd;
        int v2 = v <= v1 ? v : v1;
        if(v <= v1) {
            v = v1;
        }
        int v3 = charSequence0.length();
        if(v2 >= 0 && v <= v3) {
            if((editorInfo0.inputType & 0xFFF) != 18 && (editorInfo0.inputType & 0xFFF) != 0x81 && (editorInfo0.inputType & 0xFFF) != 0xE1) {
                if(v3 <= 0x800) {
                    a.S(editorInfo0, charSequence0, v2, v);
                    return;
                }
                int v4 = v - v2;
                int v5 = v4 <= 0x400 ? v4 : 0;
                int v6 = Math.min(charSequence0.length() - v, 0x800 - v5 - Math.min(v2, ((int)(((double)(0x800 - v5)) * 0.8))));
                int v7 = Math.min(v2, 0x800 - v5 - v6);
                int v8 = v2 - v7;
                if(Character.isLowSurrogate(charSequence0.charAt(v8))) {
                    ++v8;
                    --v7;
                }
                if(Character.isHighSurrogate(charSequence0.charAt(v + v6 - 1))) {
                    --v6;
                }
                int v9 = v7 + v5;
                a.S(editorInfo0, (v5 == v4 ? charSequence0.subSequence(v8, v9 + v6 + v8) : TextUtils.concat(new CharSequence[]{charSequence0.subSequence(v8, v8 + v7), charSequence0.subSequence(v, v6 + v)})), v7, v9);
                return;
            }
            a.S(editorInfo0, null, 0, 0);
            return;
        }
        a.S(editorInfo0, null, 0, 0);
    }

    public static void Q(Outline outline0, Path path0) {
        int v = Build.VERSION.SDK_INT;
        if(v >= 30) {
            p6.b.a(outline0, path0);
            return;
        }
        if(v >= 29) {
            try {
                p6.a.a(outline0, path0);
            }
            catch(IllegalArgumentException unused_ex) {
            }
            return;
        }
        if(path0.isConvex()) {
            p6.a.a(outline0, path0);
        }
    }

    public static void R(EditorInfo editorInfo0, boolean z) {
        if(Build.VERSION.SDK_INT >= 35) {
            androidx.core.widget.g.b(editorInfo0, z);
        }
        if(editorInfo0.extras == null) {
            editorInfo0.extras = new Bundle();
        }
        editorInfo0.extras.putBoolean("androidx.core.view.inputmethod.EditorInfoCompat.STYLUS_HANDWRITING_ENABLED", z);
    }

    public static void S(EditorInfo editorInfo0, CharSequence charSequence0, int v, int v1) {
        if(editorInfo0.extras == null) {
            editorInfo0.extras = new Bundle();
        }
        SpannableStringBuilder spannableStringBuilder0 = charSequence0 == null ? null : new SpannableStringBuilder(charSequence0);
        editorInfo0.extras.putCharSequence("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT", spannableStringBuilder0);
        editorInfo0.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD", v);
        editorInfo0.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END", v1);
    }

    public static String T(Throwable throwable0) {
        q.g(throwable0, "<this>");
        StringWriter stringWriter0 = new StringWriter();
        PrintWriter printWriter0 = new PrintWriter(stringWriter0);
        throwable0.printStackTrace(printWriter0);
        printWriter0.flush();
        String s = stringWriter0.toString();
        q.f(s, "toString(...)");
        return s;
    }

    public static final void a(r0.q q0, we.a a0, k k0, l l0, int v) {
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(-1298561707);
        int v1 = (v & 6) == 0 ? (p0.g(q0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (p0.i(a0) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v1 |= (p0.i(k0) ? 0x100 : 0x80);
        }
        if(p0.Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            h h0 = r0.d.k;
            p0 p00 = n0.a(j.g, h0, p0, 54);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
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
            w.x(p0, p00, h1);
            P0.h h2 = P0.j.e;
            w.x(p0, i00, h2);
            P0.h h3 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h3);
            }
            P0.h h4 = P0.j.d;
            w.x(p0, q1, h4);
            b0 b00 = p0.N();
            if(b00 == androidx.compose.runtime.k.a) {
                b00 = w.s(Boolean.FALSE);
                p0.l0(b00);
            }
            r0.q q2 = androidx.compose.foundation.layout.a.n(r0.n.a, 16.0f, 0.0f, 0.0f, 0.0f, 14);
            r0.n n0 = r0.n.a;
            r0.q q3 = r0.a.a(q0.a(androidx.compose.foundation.layout.d.c(q2, 1.0f), 1.0f), new Ec.g(k0, b00, 5));
            p0 p01 = n0.a(j.a, h0, p0, 0x30);
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
            w.x(p0, p01, h1);
            w.x(p0, i01, h2);
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h3);
            }
            w.x(p0, q4, h4);
            int v4 = ((Boolean)b00.getValue()).booleanValue() ? 0x7F08012A : 0x7F080129;  // drawable:btn_common_checkbox_on
            c1.n(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.q(n0, 18.0f), 18.0f), v4, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 390, 0, 0x7FF8);
            N1.b(l1.s(n0, 8.0f, p0, 0x7F130A0C, p0), null, e0.T(p0, 0x7F060160), 13.0f, null, null, 0L, new l1.k(3), 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FDF2);  // string:show_once "다시 보지 않기"
            p0.p(true);
            r0.q q5 = r0.a.a(q0.a(androidx.compose.foundation.layout.d.c(n0, 1.0f), 1.0f), new s(7, a0));
            M m0 = M.p.d(r0.d.e, false);
            int v5 = p0.P;
            i0 i02 = p0.m();
            r0.q q6 = r0.a.d(p0, q5);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, m0, h1);
            w.x(p0, i02, h2);
            if(p0.O || !q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h3);
            }
            w.x(p0, q6, h4);
            N1.b(H0.e.Y(p0, 0x7F1301D2), null, e0.T(p0, 0x7F06017C), 15.0f, null, null, 0L, new l1.k(3), 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FDF2);  // string:close "닫기"
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Ac.e(q0, a0, k0, v, 20);
        }
    }

    public static final void b(we.a a0, l l0, int v) {
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0xD3DDF254);
        int v1 = v | (p0.i(a0) ? 4 : 2);
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            b0 b00 = p0.N();
            V v2 = androidx.compose.runtime.k.a;
            if(b00 == v2) {
                b00 = w.s(Boolean.FALSE);
                p0.l0(b00);
            }
            R0 r00 = p0.N();
            if(r00 == v2) {
                r00 = new R0(b00, 27);
                p0.l0(r00);
            }
            J.b(H.a, r00, p0);
            r0.n n0 = r0.n.a;
            r0.q q0 = androidx.compose.foundation.layout.d.q(androidx.compose.foundation.layout.d.j(n0, 0.0f, 440.0f, 1), 270.0f);
            M m0 = M.p.d(r0.d.e, false);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
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
            w.x(p0, m0, h0);
            P0.h h1 = P0.j.e;
            w.x(p0, i00, h1);
            P0.h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            P0.h h3 = P0.j.d;
            w.x(p0, q1, h3);
            r0.q q2 = androidx.compose.foundation.q.f(d5.n.o(n0, T.e.b(12.0f)), e0.T(p0, 0x7F0604AB), y0.M.a);  // color:white001s
            M.d d0 = j.c;
            y y0 = M.w.a(d0, r0.d.m, p0, 0);
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
            w.x(p0, y0, h0);
            w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            w.x(p0, q3, h3);
            r0.q q4 = androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.a.m(n0, 20.0f, 26.0f, 20.0f, 20.0f), 1.0f);
            M m1 = M.p.d(r0.d.a, false);
            int v5 = p0.P;
            i0 i02 = p0.m();
            r0.q q5 = r0.a.d(p0, q4);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, m1, h0);
            w.x(p0, i02, h1);
            if(p0.O || !q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h2);
            }
            w.x(p0, q5, h3);
            r0.g g0 = r0.d.n;
            y y1 = M.w.a(d0, g0, p0, 0x30);
            int v6 = p0.P;
            i0 i03 = p0.m();
            r0.q q6 = r0.a.d(p0, n0);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, y1, h0);
            w.x(p0, i03, h1);
            if(p0.O || !q.b(p0.N(), v6)) {
                A7.d.q(v6, p0, v6, h2);
            }
            w.x(p0, q6, h3);
            yd.h.c(H0.e.Y(p0, 0x7F130077), p0, 0);  // string:alert_dialog_webview_chrome_issue_title "웹뷰 업데이트 안내"
            M.c.d(p0, androidx.compose.foundation.layout.d.h(n0, 12.0f));
            yd.h.a(H0.e.Y(p0, 0x7F130076), true, 12.0f, p0, 0x1B0, 8);  // string:alert_dialog_webview_chrome_issue_desc "안드로이드 웹뷰 버전을 최신 버전으로 업데이트 해주세요.<br/><br/>고객님이 
                                                                        // 사용하는 구버전 웹뷰는 멜론 서비스 이용 시 특정 페이지에서 빈 화면으로 보이는 문제가 있습니다.<br/>Play 스토어에서 \'<a href=market://details?id=com.google.android.webview>안드로이드 
                                                                        // 시스템 웹뷰</a>\'로 검색하여 최신 버전으로 업데이트 해주시기 바랍니다."
            r0.q q7 = r0.a.a(new HorizontalAlignElement(r0.d.o), new s(8, a0));
            p0 p00 = n0.a(j.a, r0.d.k, p0, 0x30);
            int v7 = p0.P;
            i0 i04 = p0.m();
            r0.q q8 = r0.a.d(p0, q7);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, h0);
            w.x(p0, i04, h1);
            if(p0.O || !q.b(p0.N(), v7)) {
                A7.d.q(v7, p0, v7, h2);
            }
            w.x(p0, q8, h3);
            N1.b(H0.e.Y(p0, 0x7F130074), null, e0.T(p0, 0x7F060160), 13.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF2);  // string:alert_dialog_use_info_link "자세히 보기"
            M.c.d(p0, androidx.compose.foundation.layout.d.q(n0, 2.0f));
            c1.n(null, 0x7F08008D, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x30, 0, 0x7FFD);  // drawable:arrow_common_menu
            A7.d.s(p0, true, true, true);
            e0.C(androidx.compose.foundation.layout.d.f(n0, 1.0f), 0L, 0, 0.0f, p0, 6, 30);
            r0.q q9 = H0.b.q(g0, androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(n0, 1.0f), 44.0f));
            R0 r01 = p0.N();
            if(r01 == v2) {
                r01 = new R0(b00, 28);
                p0.l0(r01);
            }
            a.a(q9, a0, r01, p0, v1 << 3 & 0x70 | 0x180);
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new C8.j(v, 9, a0);
        }
    }

    public static final void c(String s, l l0, int v) {
        ((androidx.compose.runtime.p)l0).c0(0xB0F2FBD5);
        int v1 = (((androidx.compose.runtime.p)l0).g(s) ? 4 : 2) | v;
        if(((androidx.compose.runtime.p)l0).Q(v1 & 1, (v1 & 3) != 2)) {
            long v2 = e0.T(((androidx.compose.runtime.p)l0), 0x7F060157);  // color:gray400e
            ye.a.e(s, null, f.r(500, 0, C.d, 2), "", m0.c.e(576304727, ((androidx.compose.runtime.p)l0), new S7(v2, 0)), ((androidx.compose.runtime.p)l0), v1 & 14 | 0x6C00, 2);
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
        }
        androidx.compose.runtime.n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new k2(s, v, 3);
        }
    }

    public static final void d(int v, int v1, l l0, boolean z, boolean z1) {
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0x4CD9D8ED);
        int v2 = (p0.h(z) ? 4 : 2) | v1 | (p0.h(z1) ? 0x20 : 16) | (p0.e(v) ? 0x100 : 0x80);
        if(p0.Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            float f = 6.0f;
            r0.n n0 = r0.n.a;
            r0.q q0 = androidx.compose.foundation.layout.d.h(n0, 6.0f);
            h h0 = r0.d.k;
            p0 p00 = n0.a(j.a, h0, p0, 0x30);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, P0.j.f);
            w.x(p0, i00, P0.j.e);
            P0.h h1 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h1);
            }
            w.x(p0, q1, P0.j.d);
            String s = E9.w.T(p0).getString(0x7F130B7B, Arrays.copyOf(new Object[]{((int)(v + 1))}, 1));  // string:talkback_melon_dj_slide "슬라이드 %d"
            r0.q q2 = androidx.compose.foundation.layout.a.n(n0, (z1 ? 0.0f : 4.0f), 0.0f, 0.0f, 0.0f, 14);
            if(!z) {
                f = 5.0f;
            }
            r0.q q3 = H0.b.r(h0, androidx.compose.foundation.layout.d.n(q2, f));
            ed.s s1 = p0.N();
            if(s1 == androidx.compose.runtime.k.a) {
                s1 = new ed.s(16);
                p0.l0(s1);
            }
            c1.n(X0.n.c(q3, false, s1), ((int)(z ? 0x7F080855 : 0x7F080848)), s, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0, 0, 0x7FF8);  // drawable:shape_circle_green500s
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new A(z, z1, v, v1);
        }
    }

    public static final void e(int v, Q.e e0, l l0, int v1) {
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(1061778055);
        int v2 = (p0.e(v) ? 4 : 2) | v1 | (p0.g(e0) ? 0x20 : 16);
        if(p0.Q(v2 & 1, (v2 & 19) != 18)) {
            r0.q q0 = androidx.compose.foundation.layout.a.n(androidx.compose.foundation.layout.d.f(r0.n.a, 1.0f), 0.0f, 14.0f, 0.0f, 0.0f, 13);
            p0 p00 = n0.a(j.e, r0.d.j, p0, 6);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, P0.j.f);
            w.x(p0, i00, P0.j.e);
            P0.h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h0);
            }
            w.x(p0, q1, P0.j.d);
            p0.a0(0x21C1824B);
            for(int v4 = 0; v4 < v; ++v4) {
                a.d(v4, 0, p0, e0.j() == v4, v4 == 0);
            }
            p0.p(false);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new W8.a(v, e0, v1);
        }
    }

    public static final void f(h8 h80, int v, k k0, l l0, int v1) {
        float f;
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0xEFF26944);
        int v2 = (v1 & 6) == 0 ? (p0.i(h80) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v2 |= (p0.e(v) ? 0x20 : 16);
        }
        if((v1 & 0x180) == 0) {
            v2 |= (p0.i(k0) ? 0x100 : 0x80);
        }
        if(p0.Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            r0.n n0 = r0.n.a;
            r0.q q0 = androidx.compose.foundation.q.f(e0.L(androidx.compose.foundation.layout.a.l(androidx.compose.foundation.layout.d.f(n0, 1.0f), 16.0f, 0.0f, 2), 0x7F060148), e0.T(p0, 0x7F0604AB), y0.M.a);  // color:gray075s
            y y0 = M.w.a(j.c, r0.d.m, p0, 0);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
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
            w.x(p0, y0, h0);
            P0.h h1 = P0.j.e;
            w.x(p0, i00, h1);
            P0.h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            P0.h h3 = P0.j.d;
            w.x(p0, q1, h3);
            r0.q q2 = r0.a.a(androidx.compose.foundation.layout.d.f(n0, 1.0f), new V7(k0, h80, v, 0));
            boolean z = p0.i(h80);
            z z1 = p0.N();
            V v4 = androidx.compose.runtime.k.a;
            if(z || z1 == v4) {
                z1 = new z(h80, 26);
                p0.l0(z1);
            }
            r0.q q3 = X0.n.c(q2, false, z1);
            h h4 = r0.d.j;
            p0 p00 = n0.a(j.g, h4, p0, 6);
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
            w.x(p0, p00, h0);
            w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h2);
            }
            w.x(p0, q4, h3);
            String s = h80.b;
            boolean z2 = h80.e;
            if(s == null) {
                s = "";
            }
            N1.b(s, androidx.compose.foundation.layout.a.n(n0, 16.0f, 24.0f, 0.0f, 0.0f, 12), e0.T(p0, 0x7F06016D), 20.0f, e1.y.i, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0x30C30, 0xC30, 0x1D7D0);  // color:gray900s
            c1.n(androidx.compose.foundation.layout.a.n(r0.a.a(n0, new V7(k0, h80, v, 1)), 0.0f, 17.0f, 16.0f, 0.0f, 9), ((int)(z2 ? 0x7F08014F : 0x7F08014E)), (z2 ? "좋아요 취소 버튼" : "좋아요 버튼"), N0.j.h, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0xC00, 0, 0x7FF0);  // drawable:btn_common_like_36_on
            p0.p(true);
            r0.q q5 = androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.a.n(n0, 16.0f, 9.0f, 0.0f, 10.0f, 4), 1.0f);
            p0 p01 = n0.a(j.a, h4, p0, 0);
            int v6 = p0.P;
            i0 i02 = p0.m();
            r0.q q6 = r0.a.d(p0, q5);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p01, h0);
            w.x(p0, i02, h1);
            if(p0.O || !q.b(p0.N(), v6)) {
                A7.d.q(v6, p0, v6, h2);
            }
            w.x(p0, q6, h3);
            c1.n(null, 0x7F080407, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x1B0, 0, 0x7FF9);  // drawable:ic_common_playlist_13
            String s1 = h80.c == null ? "" : h80.c;
            r0.q q7 = androidx.compose.foundation.layout.a.n(n0, 3.0f, 0.0f, 0.0f, 0.0f, 14);
            boolean z3 = p0.i(context0);
            boolean z4 = p0.i(h80);
            R7 r70 = p0.N();
            if(z3 || z4 || r70 == v4) {
                r70 = new R7(0, context0, h80);
                p0.l0(r70);
            }
            N1.b(s1, X0.n.c(q7, false, r70), e0.T(p0, 0x7F060159), 12.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF0);  // color:gray400s_support_high_contrast
            p0.p(true);
            p0.a0(-1548254930);
            for(int v7 = 0; v7 < 3; ++v7) {
                switch(v7) {
                    case 0: {
                        f = 8.0f;
                        break;
                    }
                    case 1: {
                        f = 9.0f;
                        break;
                    }
                    default: {
                        f = 11.0f;
                    }
                }
                a.k(v7, ((c8)h80.f.get(v7)), androidx.compose.foundation.layout.a.m(n0, 16.0f, 8.0f, 14.0f, f), k0, p0, v2 << 3 & 0x1C00);
            }
            l1.y(p0, false, n0, 16.0f, p0);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Nc.p(h80, v, k0, v1, 20);
        }
    }

    public static final void g(int v, a8 a80, k k0, l l0, int v1) {
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(30163110);
        int v2 = (v1 & 6) == 0 ? (p0.e(v) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v2 |= (p0.g(a80) ? 0x20 : 16);
        }
        if((v1 & 0x180) == 0) {
            v2 |= (p0.i(k0) ? 0x100 : 0x80);
        }
        if(p0.Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            r0.n n0 = r0.n.a;
            r0.q q0 = androidx.compose.foundation.layout.a.n(r0.a.a(androidx.compose.foundation.layout.d.h(n0, 36.0f), new X2(k0, a80, v, 13)), (a80.c ? 16.0f : 10.0f), 0.0f, (a80.d ? 16.0f : 0.0f), 0.0f, 10);
            androidx.compose.foundation.y y0 = androidx.compose.foundation.q.a(e0.T(p0, 0x7F06017D), 0.5f);  // color:green501s
            r0.q q1 = androidx.compose.foundation.q.j(q0, y0.a, y0.b, y0.M.a);
            y y1 = M.w.a(j.e, r0.d.m, p0, 6);
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
            w.x(p0, y1, P0.j.f);
            w.x(p0, i00, P0.j.e);
            P0.h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h0);
            }
            w.x(p0, q2, P0.j.d);
            r0.q q3 = androidx.compose.foundation.layout.a.n(n0, 16.0f, 0.0f, 16.0f, 0.0f, 10);
            long v4 = e0.T(p0, 0x7F06017C);  // color:green500s_support_high_contrast
            N1.b(a80.a, q3, v4, 14.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC30, 0, 0x1FFF0);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Nc.p(v, a80, k0, v1, 21);
        }
    }

    public static final void h(b8 b80, k k0, l l0, int v) {
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0x1543CBB4);
        int v1 = (p0.i(b80) ? 4 : 2) | v | (p0.i(k0) ? 0x20 : 16);
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            if(((Collection)b80.a).isEmpty()) {
                p0.a0(0x9B1CCBCE);
            }
            else {
                p0.a0(0x9C798CA7);
                r0.n n0 = r0.n.a;
                r0.q q0 = androidx.compose.foundation.layout.a.l(n0, 0.0f, 8.0f, 1);
                y y0 = M.w.a(j.c, r0.d.m, p0, 0);
                int v2 = p0.P;
                i0 i00 = p0.m();
                r0.q q1 = r0.a.d(p0, q0);
                P0.k.y.getClass();
                i i0 = P0.j.b;
                p0.e0();
                if(p0.O) {
                    p0.l(i0);
                }
                else {
                    p0.o0();
                }
                w.x(p0, y0, P0.j.f);
                w.x(p0, i00, P0.j.e);
                P0.h h0 = P0.j.g;
                if(p0.O || !q.b(p0.N(), v2)) {
                    A7.d.q(v2, p0, v2, h0);
                }
                w.x(p0, q1, P0.j.d);
                Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
                r0.q q2 = androidx.compose.foundation.layout.a.n(r0.a.a(n0, new Ac.l1(26, k0)), 0.0f, 4.0f, 0.0f, 0.0f, 13);
                q.f("좋아요 한 태그", "getString(...)");
                a.p(q2, "좋아요 한 태그", true, true, p0, 0xC30, 0);
                boolean z = p0.i(b80);
                R7 r70 = p0.N();
                if(z || (v1 & 0x70) == 0x20 || r70 == androidx.compose.runtime.k.a) {
                    r70 = new R7(2, b80, k0);
                    p0.l0(r70);
                }
                c1.q(null, null, null, null, null, null, false, r70, p0, 0, 0xFF);
                p0.p(true);
            }
            p0.p(false);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new T7(b80, k0, v, 0);
        }
    }

    public static final void i(k k0, l l0, int v) {
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0x188A8978);
        int v1 = v | (p0.i(k0) ? 4 : 2);
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            Ac.l1 l10 = new Ac.l1(27, k0);
            r0.n n0 = r0.n.a;
            r0.q q0 = androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.a.n(r0.a.a(n0, l10), 0.0f, 8.0f, 0.0f, 26.0f, 5), 1.0f);
            h h0 = r0.d.k;
            p0 p00 = n0.a(j.e, h0, p0, 54);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, P0.j.f);
            w.x(p0, i00, P0.j.e);
            P0.h h1 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h1);
            }
            w.x(p0, q1, P0.j.d);
            q.f("DJ 플레이리스트 전체보기", "getString(...)");
            N1.b("DJ 플레이리스트 전체보기", n0, e0.T(p0, 0x7F060163), 15.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC30, 0, 0x1FFF0);  // color:gray700s
            c1.n(new VerticalAlignElement(h0), 0x7F08008D, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x30, 0, 0x7FFC);  // drawable:arrow_common_menu
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Rc.q(k0, v, 4);
        }
    }

    public static final void j(g8 g80, k k0, l l0, int v) {
        Q.e e1;
        W7 w70;
        V v7;
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0xC5D59E8B);
        int v1 = v | (p0.i(g80) ? 4 : 2) | (p0.i(k0) ? 0x20 : 16);
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            b0 b00 = p0.N();
            V v2 = androidx.compose.runtime.k.a;
            if(b00 == v2) {
                b00 = w.s("");
                p0.l0(b00);
            }
            r0.n n0 = r0.n.a;
            r0.q q0 = androidx.compose.foundation.layout.d.t(androidx.compose.foundation.layout.d.f(n0, 1.0f), 3);
            M m0 = M.p.d(r0.d.a, false);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
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
            w.x(p0, m0, h0);
            P0.h h1 = P0.j.e;
            w.x(p0, i00, h1);
            P0.h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            w.x(p0, q1, P0.j.d);
            a.c(((String)b00.getValue()), p0, 0);
            r0.q q2 = androidx.compose.foundation.layout.a.n(n0, 16.0f, 47.0f, 3.0f, 0.0f, 8);
            q.f("오늘의 추천 태그", "getString(...)");
            long v4 = e0.T(p0, 0x7F0604A1);  // color:white000e
            P0.h h3 = P0.j.d;
            N1.b("오늘의 추천 태그", q2, v4, 18.0f, e1.y.i, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0x30C00, 0xC30, 0x1D7D0);
            p0.p(true);
            r0.q q3 = androidx.compose.foundation.layout.a.n(n0, 0.0f, 84.0f, 0.0f, 0.0f, 13);
            y y0 = M.w.a(j.c, r0.d.m, p0, 0);
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
            w.x(p0, y0, h0);
            w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h2);
            }
            w.x(p0, q4, h3);
            int v6 = g80.a.size();
            boolean z = p0.e(v6);
            Nc.M m1 = p0.N();
            if(z) {
                v7 = v2;
                m1 = new Nc.M(v6, 2);
                p0.l0(m1);
            }
            else {
                v7 = v2;
                if(m1 == v7) {
                    m1 = new Nc.M(v6, 2);
                    p0.l0(m1);
                }
            }
            Q.e e0 = O.b(m1, p0, 0, 3);
            C0 c00 = N.u(p0);
            Integer integer0 = e0.o();
            boolean z1 = p0.i(g80);
            boolean z2 = p0.g(e0);
            Object object0 = p0.N();
            if((z1 | z2 | ((v1 & 0x70) == 0x20 ? 1 : 0)) != 0 || object0 == v7) {
                e1 = e0;
                w70 = new W7(g80, e1, k0, b00, null);
                p0.l0(w70);
            }
            else {
                w70 = object0;
                e1 = e0;
            }
            J.d(p0, integer0, w70);
            u0.b(e1, androidx.compose.ui.input.nestedscroll.a.a(androidx.compose.foundation.layout.d.h(n0, 286.0f), c00, null), null, null, v6, 0.0f, null, d5.f.z(e1, f.q(1500.0f, 1, 1.0f), p0, 0, 22), false, null, null, null, m0.c.e(0x672FE834, p0, new D8.b(1, g80, k0)), p0, 0, 0x3F6C);
            a.e(g80.a.size(), e1, p0, 0);
            a.m(k0, p0, v1 >> 3 & 14);
            M.c.d(p0, androidx.compose.foundation.q.f(androidx.compose.foundation.layout.a.l(androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.d.h(n0, 2.0f), 1.0f), 16.0f, 0.0f, 2), e0.T(p0, 0x7F06016D), y0.M.a));  // color:gray900s
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.fragments.artistchannel.viewholder.e(g80, k0, v, 29);
        }
    }

    public static final void k(int v, c8 c80, r0.q q0, k k0, l l0, int v1) {
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0x55511F59);
        int v2 = (v1 & 6) == 0 ? (p0.e(v) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v2 |= (p0.i(c80) ? 0x20 : 16);
        }
        if((v1 & 0x180) == 0) {
            v2 |= (p0.g(q0) ? 0x100 : 0x80);
        }
        if((v1 & 0xC00) == 0) {
            v2 |= (p0.i(k0) ? 0x800 : 0x400);
        }
        if(p0.Q(v2 & 1, (v2 & 0x493) != 1170)) {
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            r0.q q1 = r0.a.a(androidx.compose.foundation.layout.d.f(q0, 1.0f), new Y7(k0, c80, v, 0));
            h h0 = r0.d.k;
            M.b b0 = j.a;
            p0 p00 = n0.a(b0, h0, p0, 0x30);
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
            P0.h h1 = P0.j.f;
            w.x(p0, p00, h1);
            P0.h h2 = P0.j.e;
            w.x(p0, i00, h2);
            P0.h h3 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h3);
            }
            P0.h h4 = P0.j.d;
            w.x(p0, q2, h4);
            r0 r00 = r0.b;
            String s = c80.b;
            String s1 = "";
            if(s == null) {
                s = "";
            }
            float f = E9.h.t(p0, 0x7F07045E);  // dimen:thumb_width_song
            r00.c(androidx.compose.foundation.layout.d.n(r0.n.a, 44.0f), s, f, null, 0L, null, false, false, p0, 0x6000006, 0xF8);
            r0.q q3 = androidx.compose.foundation.layout.a.n(r0.n.a, 10.0f, 0.0f, 0.0f, 0.0f, 14);
            r0.n n0 = r0.n.a;
            r0.q q4 = H0.b.r(h0, U4.x.r(1.0f, androidx.compose.foundation.layout.d.f(q3, 1.0f), true));
            y y0 = M.w.a(j.c, r0.d.m, p0, 0);
            int v4 = p0.P;
            i0 i01 = p0.m();
            r0.q q5 = r0.a.d(p0, q4);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, y0, h1);
            w.x(p0, i01, h2);
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h3);
            }
            w.x(p0, q5, h4);
            String s2 = c80.a;
            if(s2 != null) {
                s1 = s2;
            }
            N1.b(s1, null, e0.T(p0, 0x7F06016D), 15.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F2);  // color:gray900s
            r0.q q6 = androidx.compose.foundation.layout.a.n(n0, 0.0f, 4.0f, 0.0f, 0.0f, 13);
            p0 p01 = n0.a(b0, r0.d.j, p0, 0);
            int v5 = p0.P;
            i0 i02 = p0.m();
            r0.q q7 = r0.a.d(p0, q6);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p01, h1);
            w.x(p0, i02, h2);
            if(p0.O || !q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h3);
            }
            w.x(p0, q7, h4);
            c1.n(null, 0x7F0803F9, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x30, 0, 0x7FFD);  // drawable:ic_common_like_13
            String s3 = StringUtils.getCountString(c80.c, 0x3B9AC9FF);
            r0.q q8 = androidx.compose.foundation.layout.a.n(n0, 3.0f, 0.0f, 0.0f, 0.0f, 14);
            boolean z = p0.i(context0);
            boolean z1 = p0.i(c80);
            R7 r70 = p0.N();
            if(z || z1 || r70 == androidx.compose.runtime.k.a) {
                r70 = new R7(1, context0, c80);
                p0.l0(r70);
            }
            N1.b(s3, X0.n.c(q8, false, r70), e0.T(p0, 0x7F06015D), 12.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F0);  // color:gray500s_support_high_contrast
            p0.p(true);
            p0.p(true);
            c1.n(r0.a.a(n0, new Y7(k0, c80, v, 1)), 0x7F080161, "재생", N0.j.h, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0xC30, 0, 0x7FF0);  // drawable:btn_common_play_02_tint
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new H3(v, v1, 17, k0, c80, q0);
        }
    }

    public static final void l(l8 l80, k k0, l l0, int v) {
        ((androidx.compose.runtime.p)l0).c0(0x6792A8D9);
        int v1 = (((androidx.compose.runtime.p)l0).i(l80) ? 4 : 2) | v | (((androidx.compose.runtime.p)l0).i(k0) ? 0x20 : 16);
        boolean z = false;
        if(((androidx.compose.runtime.p)l0).Q(v1 & 1, (v1 & 19) != 18)) {
            ArrayList arrayList0 = l80.a;
            C0 c00 = N.u(((androidx.compose.runtime.p)l0));
            r0.q q0 = androidx.compose.ui.input.nestedscroll.a.a(androidx.compose.foundation.layout.d.c, c00, null);
            P.a a0 = new P.a(2);
            j0 j00 = androidx.compose.foundation.layout.a.c(0.0f, 0.0f, 0.0f, E9.h.t(((androidx.compose.runtime.p)l0), 0x7F070058), 7);  // dimen:bottom_tab_plus_miniplayer_height
            boolean z1 = ((androidx.compose.runtime.p)l0).i(arrayList0);
            if((v1 & 0x70) == 0x20) {
                z = true;
            }
            m4 m40 = ((androidx.compose.runtime.p)l0).N();
            if(z1 || z || m40 == androidx.compose.runtime.k.a) {
                m40 = new m4(arrayList0, k0, 1);
                ((androidx.compose.runtime.p)l0).l0(m40);
            }
            c1.r(a0, q0, null, j00, null, null, null, false, m40, ((androidx.compose.runtime.p)l0), 0, 500);
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
        }
        androidx.compose.runtime.n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.fragments.artistchannel.viewholder.e(l80, k0, v, 28);
        }
    }

    public static final void m(k k0, l l0, int v) {
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0xF326DFA8);
        int v1 = (v & 6) == 0 ? v | (p0.i(k0) ? 4 : 2) : v;
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            r0.n n0 = r0.n.a;
            r0.q q0 = androidx.compose.foundation.layout.a.n(r0.a.a(androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.d.h(n0, 56.0f), 1.0f), new Ac.l1(28, k0)), 0.0f, 19.0f, 0.0f, 0.0f, 13);
            p0 p00 = n0.a(j.a, r0.d.j, p0, 0);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, P0.j.f);
            w.x(p0, i00, P0.j.e);
            P0.h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            w.x(p0, q1, P0.j.d);
            N1.b("#", androidx.compose.foundation.layout.a.n(n0, 16.0f, 0.0f, 3.0f, 0.0f, 10), e0.T(p0, 0x7F06016D), 15.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC36, 0, 0x1FFF0);  // color:gray900s
            q.f("찾고 싶은 태그를 입력해보세요.", "getString(...)");
            long v3 = e0.T(p0, 0x7F060159);  // color:gray400s_support_high_contrast
            N1.b("찾고 싶은 태그를 입력해보세요.", androidx.compose.foundation.layout.a.n(n0, 6.0f, 0.0f, 24.0f, 0.0f, 10), v3, 15.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC30, 0, 0x1FFF0);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new r(k0, v, 3);
        }
    }

    public static final void n(int v, e8 e80, k k0, l l0, int v1) {
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0x7430A963);
        int v2 = (v1 & 6) == 0 ? (p0.e(v) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v2 |= (p0.g(e80) ? 0x20 : 16);
        }
        if((v1 & 0x180) == 0) {
            v2 |= (p0.i(k0) ? 0x100 : 0x80);
        }
        if(p0.Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            Object object0 = p0.k(AndroidCompositionLocals_androidKt.b);
            long v3 = e0.T(p0, 0x7F060157);  // color:gray400e
            r0.n n0 = r0.n.a;
            r0.q q0 = e0.K(d5.n.o(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.a.n(r0.a.a(androidx.compose.foundation.layout.d.f(n0, 1.0f), new X2(k0, e80, v, 14)), (e80.d ? 16.0f : 8.0f), 0.0f, (e80.d ? 8.0f : 16.0f), 16.0f, 2), 100.0f), T.e.b(4.0f)));
            M m0 = M.p.d(r0.d.a, false);
            int v4 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, m0, P0.j.f);
            w.x(p0, i00, P0.j.e);
            P0.h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h0);
            }
            w.x(p0, q1, P0.j.d);
            long v5 = e0.T(p0, 0x7F060161);  // color:gray601s
            r0.q q2 = androidx.compose.foundation.q.f(androidx.compose.foundation.layout.d.c, v5, y0.M.a);
            FillElement fillElement0 = androidx.compose.foundation.layout.d.c;
            c1.n(q2, 0x7F08078D, null, N0.j.f, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x6C30, 0, 0x7FE4);  // drawable:noimage_logo_small
            String s = e80.a;
            boolean z = p0.f(v3);
            h0 h00 = p0.N();
            if(z || h00 == androidx.compose.runtime.k.a) {
                h00 = new h0(v3, 18);
                p0.l0(h00);
            }
            c1.n(androidx.compose.ui.draw.a.c(fillElement0, h00), s, null, N0.j.b, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x6C00, 0, 0x7FE4);
            int v6 = ScreenUtils.isPortrait(((Context)object0)) ? 9 : 12;
            N1.b(StringUtils.getTrimmed(("#" + e80.c), v6), (androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(n0, r0.d.e), e0.T(p0, 0x7F0604A1), 17.0f, e1.y.i, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0x30C00, 0, 0x1FFD0);  // color:white000e
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Nc.p(v, e80, k0, v1, 19);
        }
    }

    public static final void o(boolean z, f8 f80, l l0, int v) {
        ((androidx.compose.runtime.p)l0).c0(0xEB4BC8AF);
        int v1 = (((androidx.compose.runtime.p)l0).h(z) ? 4 : 2) | v | (((androidx.compose.runtime.p)l0).g(f80) ? 0x20 : 16);
        if(((androidx.compose.runtime.p)l0).Q(v1 & 1, (v1 & 19) != 18)) {
            a.p(null, f80.a, z, false, ((androidx.compose.runtime.p)l0), v1 << 3 & 0x70 | 0xC00, 1);
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
        }
        androidx.compose.runtime.n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new Fd.h(z, f80, v, 5);
        }
    }

    public static final void p(r0.q q0, String s, boolean z, boolean z1, l l0, int v, int v1) {
        r0.q q1;
        int v2;
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0x54674DF8);
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
            v2 |= (p0.h(z) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v2 |= (p0.g(s) ? 0x100 : 0x80);
        }
        if((v & 0xC00) == 0) {
            v2 |= (p0.h(z1) ? 0x800 : 0x400);
        }
        if(p0.Q(v2 & 1, (v2 & 0x493) != 1170)) {
            r0.n n0 = r0.n.a;
            if((v1 & 1) != 0) {
                q1 = n0;
            }
            y y0 = M.w.a(j.c, r0.d.m, p0, 0);
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
            w.x(p0, y0, h0);
            P0.h h1 = P0.j.e;
            w.x(p0, i00, h1);
            P0.h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            P0.h h3 = P0.j.d;
            w.x(p0, q2, h3);
            if(z) {
                p0.a0(0xB5EC82D3);
                A7.d.v(n0, 16.0f, p0, false);
            }
            else {
                p0.a0(0xB4A02F14);
                p0.p(false);
            }
            r0.q q3 = androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.a.m(n0, 16.0f, 8.0f, 16.0f, 12.0f), 1.0f);
            h h4 = r0.d.k;
            p0 p00 = n0.a(j.a, h4, p0, 0x30);
            int v4 = p0.P;
            i0 i01 = p0.m();
            r0.q q4 = r0.a.d(p0, q3);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, h0);
            w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            w.x(p0, q4, h3);
            N1.b(s, n0, e0.T(p0, 0x7F06016D), 18.0f, e1.y.i, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, v2 >> 6 & 14 | 0x30C30, 0xC30, 0x1D7D0);  // color:gray900s
            if(z1) {
                p0.a0(-1516000625);
                c1.n(new VerticalAlignElement(h4), 0x7F08008D, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x30, 0, 0x7FFC);  // drawable:arrow_common_menu
            }
            else {
                p0.a0(0xA44D7090);
            }
            p0.p(false);
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.player.playlist.drawernew.composable.a(q1, z, s, z1, v, v1);
        }
    }

    public static void q(Throwable throwable0, Throwable throwable1) {
        q.g(throwable0, "<this>");
        q.g(throwable1, "exception");
        if(throwable0 != throwable1) {
            if(re.a.a == null || ((int)re.a.a) >= 19) {
                throwable0.addSuppressed(throwable1);
            }
            else {
                Method method0 = qe.a.a;
                if(method0 != null) {
                    method0.invoke(throwable0, throwable1);
                }
            }
        }
    }

    public static final r0.q r(r0.q q0, float f) {
        return f == 1.0f ? q0 : androidx.compose.ui.graphics.a.b(q0, 0.0f, 0.0f, f, 0.0f, 0.0f, null, true, 0x1EFFB);
    }

    public static final void s(int v, int v1) {
        if(v < 0 || v >= v1) {
            throw new IndexOutOfBoundsException("index: " + v + ", size: " + v1);
        }
    }

    public static final void t(int v, int v1) {
        if(v < 0 || v > v1) {
            throw new IndexOutOfBoundsException("index: " + v + ", size: " + v1);
        }
    }

    public static final void u(int v, int v1, int v2) {
        if(v >= 0 && v1 <= v2) {
            if(v > v1) {
                throw new IllegalArgumentException("fromIndex: " + v + " > toIndex: " + v1);
            }
            return;
        }
        StringBuilder stringBuilder0 = o.t(v, v1, "fromIndex: ", ", toIndex: ", ", size: ");
        stringBuilder0.append(v2);
        throw new IndexOutOfBoundsException(stringBuilder0.toString());
    }

    public static Drawable v(Drawable drawable0, Drawable drawable1, int v, int v1) {
        if(drawable0 == null) {
            return drawable1;
        }
        if(drawable1 == null) {
            return drawable0;
        }
        if(v == -1) {
            v = drawable1.getIntrinsicWidth();
            if(v == -1) {
                v = drawable0.getIntrinsicWidth();
            }
        }
        if(v1 == -1) {
            v1 = drawable1.getIntrinsicHeight();
            if(v1 == -1) {
                v1 = drawable0.getIntrinsicHeight();
            }
        }
        if(v > drawable0.getIntrinsicWidth() || v1 > drawable0.getIntrinsicHeight()) {
            float f = ((float)v) / ((float)v1);
            if(f >= ((float)drawable0.getIntrinsicWidth()) / ((float)drawable0.getIntrinsicHeight())) {
                int v2 = drawable0.getIntrinsicWidth();
                v1 = (int)(((float)v2) / f);
                v = v2;
            }
            else {
                v1 = drawable0.getIntrinsicHeight();
                v = (int)(f * ((float)v1));
            }
        }
        Drawable drawable2 = new LayerDrawable(new Drawable[]{drawable0, drawable1});
        ((LayerDrawable)drawable2).setLayerSize(1, v, v1);
        ((LayerDrawable)drawable2).setLayerGravity(1, 17);
        return drawable2;
    }

    public static nf.h w(g0 g00) {
        q.g(g00, "table");
        if(g00.b.size() == 0) {
            return nf.h.b;
        }
        List list0 = g00.b;
        q.f(list0, "getRequirementList(...)");
        return new nf.h(list0);
    }

    public static Drawable x(Drawable drawable0, ColorStateList colorStateList0, PorterDuff.Mode porterDuff$Mode0) {
        if(drawable0 == null) {
            return null;
        }
        if(colorStateList0 != null) {
            drawable0 = drawable0.mutate();
            if(porterDuff$Mode0 != null) {
                drawable0.setTintMode(porterDuff$Mode0);
            }
        }
        return drawable0;
    }

    public static final void y(FileSystem fileSystem0, okio.Path path0) {
        try {
            List list0 = fileSystem0.list(path0);
        }
        catch(FileNotFoundException unused_ex) {
            return;
        }
        Throwable throwable0 = null;
        for(Object object0: list0) {
            okio.Path path1 = (okio.Path)object0;
            try {
                if(fileSystem0.metadata(path1).isDirectory()) {
                    a.y(fileSystem0, path1);
                }
                fileSystem0.delete(path1);
                continue;
            label_13:
                if(throwable0 == null) {
                    goto label_14;
                }
                continue;
            }
            catch(IOException iOException0) {
                goto label_13;
            }
        label_14:
            throwable0 = iOException0;
        }
        if(throwable0 != null) {
            throw throwable0;
        }
    }

    public static float z(float f, float f1, float f2, float f3) {
        return (float)Math.hypot(f2 - f, f3 - f1);
    }
}

