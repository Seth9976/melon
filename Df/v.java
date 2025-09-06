package df;

import Bd.F;
import Cc.N1;
import Cc.R2;
import Cc.c1;
import Cc.e0;
import Hf.W;
import M.p0;
import M.y;
import P0.I;
import P0.j0;
import Q0.C0;
import Q0.N;
import X0.k;
import X0.l;
import X0.s;
import X0.w;
import Y0.a;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.EmojiConsistency;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillValue;
import androidx.collection.G;
import androidx.collection.K;
import androidx.compose.runtime.E;
import androidx.compose.runtime.J;
import androidx.compose.runtime.K0;
import androidx.compose.runtime.V;
import androidx.compose.runtime.a0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.n0;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.fragment.app.FragmentActivity;
import cd.V2;
import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.custom.T;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.genre.Genre.More_Fragment_Type;
import com.iloen.melon.net.v4x.request.UaLogDummyReq;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.PlayableAlbumUriData;
import com.iloen.melon.popup.GenreAllPopup;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.network.NetUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.melon.playlist.interfaces.PlayableData;
import e1.m;
import ed.w0;
import g0.b;
import gd.A;
import gd.B0;
import gd.B2;
import gd.B;
import gd.M6;
import gd.c;
import gd.m4;
import gd.n4;
import gd.p4;
import gd.q4;
import gd.t;
import gd.u;
import gd.x0;
import gd.x;
import gd.y0;
import gd.z;
import i.n.i.b.a.s.e.M3;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import je.D;
import je.n;
import je.p;
import k8.Y;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import me.g;
import me.h;
import me.i;
import me.j;
import p8.O;
import q2.f;
import s0.e;
import s0.o;
import y0.M;

public abstract class v {
    public static final int a;
    public static final int b;
    public static final int c;
    public static final int d;

    public static boolean A(int v, Rect rect0, Rect rect1) {
        switch(v) {
            case 17: {
                return (rect0.right > rect1.right || rect0.left >= rect1.right) && rect0.left > rect1.left;
            }
            case 33: {
                return (rect0.bottom > rect1.bottom || rect0.top >= rect1.bottom) && rect0.top > rect1.top;
            }
            case 66: {
                return (rect0.left < rect1.left || rect0.right <= rect1.left) && rect0.right < rect1.right;
            }
            case 130: {
                return (rect0.top < rect1.top || rect0.bottom <= rect1.top) && rect0.bottom < rect1.bottom;
            }
            default: {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
        }
    }

    public static final f B(String s) {
        q.g(s, "name");
        return new f(s);
    }

    public static int C(int v, Rect rect0, Rect rect1) {
        switch(v) {
            case 17: {
                return Math.max(0, rect0.left - rect1.right);
            }
            case 33: {
                return Math.max(0, rect0.top - rect1.bottom);
            }
            case 66: {
                return Math.max(0, rect1.left - rect0.right);
            }
            case 130: {
                return Math.max(0, rect1.top - rect0.bottom);
            }
            default: {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
        }
    }

    public static int D(int v, Rect rect0, Rect rect1) {
        switch(v) {
            case 17: 
            case 66: {
                int v1 = rect0.top;
                int v2 = rect0.height();
                int v3 = rect1.top;
                return Math.abs(v2 / 2 + v1 - (rect1.height() / 2 + v3));
            }
            case 33: 
            case 130: {
                int v4 = rect0.left;
                int v5 = rect0.width();
                int v6 = rect1.left;
                return Math.abs(v5 / 2 + v4 - (rect1.width() / 2 + v6));
            }
            default: {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
        }
    }

    public static i E(g g0, h h0) {
        q.g(h0, "key");
        return q.b(g0.getKey(), h0) ? j.a : g0;
    }

    public static i F(i i0, g g0) {
        q.g(i0, "context");
        return i0 == j.a ? g0 : ((i)i0.fold(g0, new M6(19)));
    }

    public static final void G(ViewStructure viewStructure0, I i0, AutofillId autofillId0, String s, a a0) {
        boolean z2;
        Integer integer5;
        Integer integer3;
        Object[] arr_object4;
        long[] arr_v2;
        Integer integer2;
        List list0;
        a1.g g1;
        X0.i i2;
        Z0.a a2;
        a1.g g0;
        Integer integer1;
        boolean z1;
        X0.i i1;
        Boolean boolean0;
        o o0;
        Z0.a a1;
        boolean z;
        e e0;
        Integer integer0 = 1;
        l l0 = i0.w();
        if(l0 == null) {
        label_102:
            a2 = null;
            i2 = null;
            g1 = null;
            e0 = null;
            z = false;
            o0 = null;
            boolean0 = null;
            z1 = false;
            integer1 = null;
        }
        else {
            K k0 = l0.a;
            if(k0 != null) {
                Object[] arr_object = k0.b;
                Object[] arr_object1 = k0.c;
                long[] arr_v = k0.a;
                int v = arr_v.length - 2;
                if(v >= 0) {
                    int v1 = 0;
                    e0 = null;
                    z = false;
                    a1 = null;
                    o0 = null;
                    boolean0 = null;
                    i1 = null;
                    z1 = false;
                    integer1 = null;
                    g0 = null;
                    while(true) {
                        long v2 = arr_v[v1];
                        if((~v2 << 7 & v2 & 0x8080808080808080L) == 0x8080808080808080L) {
                            goto label_86;
                        }
                        int v3 = 8 - (~(v1 - v) >>> 0x1F);
                        for(int v4 = 0; v4 < v3; ++v4) {
                            if((v2 & 0xFFL) < 0x80L) {
                                int v5 = (v1 << 3) + v4;
                                Object object0 = arr_object[v5];
                                Object object1 = arr_object1[v5];
                                w w0 = (w)object0;
                                if(q.b(w0, s.q)) {
                                    q.e(object1, "null cannot be cast to non-null type androidx.compose.ui.autofill.ContentDataType");
                                    e0 = (e)object1;
                                }
                                else if(q.b(w0, s.a)) {
                                    q.e(object1, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                                    String s1 = (String)p.m0(((List)object1));
                                    if(s1 != null) {
                                        viewStructure0.setContentDescription(s1);
                                    }
                                }
                                else if(q.b(w0, s.p)) {
                                    q.e(object1, "null cannot be cast to non-null type androidx.compose.ui.autofill.ContentType");
                                    o0 = (o)object1;
                                }
                                else if(q.b(w0, s.C)) {
                                    q.e(object1, "null cannot be cast to non-null type androidx.compose.ui.text.AnnotatedString");
                                    g0 = (a1.g)object1;
                                }
                                else if(q.b(w0, s.k)) {
                                    q.e(object1, "null cannot be cast to non-null type kotlin.Boolean");
                                    viewStructure0.setFocused(((Boolean)object1).booleanValue());
                                }
                                else if(q.b(w0, s.L)) {
                                    q.e(object1, "null cannot be cast to non-null type kotlin.Int");
                                    integer1 = (Integer)object1;
                                }
                                else if(q.b(w0, s.H)) {
                                    z1 = true;
                                }
                                else if(q.b(w0, s.v)) {
                                    q.e(object1, "null cannot be cast to non-null type androidx.compose.ui.semantics.Role");
                                    i1 = (X0.i)object1;
                                }
                                else if(q.b(w0, s.F)) {
                                    q.e(object1, "null cannot be cast to non-null type kotlin.Boolean");
                                    boolean0 = (Boolean)object1;
                                }
                                else if(q.b(w0, s.G)) {
                                    q.e(object1, "null cannot be cast to non-null type androidx.compose.ui.state.ToggleableState");
                                    a1 = (Z0.a)object1;
                                }
                                else if(q.b(w0, k.b)) {
                                    viewStructure0.setClickable(true);
                                }
                                else if(q.b(w0, k.c)) {
                                    viewStructure0.setLongClickable(true);
                                }
                                else if(q.b(w0, k.v)) {
                                    viewStructure0.setFocusable(true);
                                }
                                else if(q.b(w0, k.j)) {
                                    z = true;
                                }
                            }
                            v2 >>= 8;
                        }
                        if(v3 == 8) {
                        label_86:
                            if(v1 != v) {
                                ++v1;
                                continue;
                            }
                        }
                        break;
                    }
                }
                else {
                    e0 = null;
                    z = false;
                    a1 = null;
                    o0 = null;
                    boolean0 = null;
                    i1 = null;
                    z1 = false;
                    integer1 = null;
                    g0 = null;
                }
                a2 = a1;
                i2 = i1;
                g1 = g0;
                goto label_111;
            }
            goto label_102;
        }
    label_111:
        l l1 = i0.w();
        if(l1 != null && l1.c && !l1.d) {
            l1 = l1.b();
            G g2 = new G(((b)i0.o()).a.c);
            g2.b(i0.o());
            int v6;
            while((v6 = g2.b) != 0) {
                I i3 = (I)g2.i(v6 - 1);
                l l2 = i3.w();
                if(l2 != null && !l2.c) {
                    l1.e(l2);
                    if(!l2.d) {
                        g2.b(i3.o());
                    }
                }
            }
        }
        if(l1 == null) {
            integer3 = 1;
            list0 = null;
        }
        else {
            K k1 = l1.a;
            if(k1 == null) {
                integer3 = 1;
                list0 = null;
            }
            else {
                Object[] arr_object2 = k1.b;
                Object[] arr_object3 = k1.c;
                long[] arr_v1 = k1.a;
                int v7 = arr_v1.length - 2;
                if(v7 >= 0) {
                    int v8 = 0;
                    list0 = null;
                    while(true) {
                        long v9 = arr_v1[v8];
                        if((~v9 << 7 & v9 & 0x8080808080808080L) == 0x8080808080808080L) {
                            goto label_169;
                        }
                        int v10 = 8 - (~(v8 - v7) >>> 0x1F);
                        int v11 = 0;
                        while(v11 < v10) {
                            if((v9 & 0xFFL) < 0x80L) {
                                int v12 = (v8 << 3) + v11;
                                Object object2 = arr_object2[v12];
                                integer2 = integer0;
                                Object object3 = arr_object3[v12];
                                arr_v2 = arr_v1;
                                w w1 = (w)object2;
                                arr_object4 = arr_object2;
                                if(q.b(w1, s.i)) {
                                    viewStructure0.setEnabled(false);
                                }
                                else if(q.b(w1, s.y)) {
                                    q.e(object3, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.ui.text.AnnotatedString>");
                                    list0 = (List)object3;
                                }
                            }
                            else {
                                integer2 = integer0;
                                arr_v2 = arr_v1;
                                arr_object4 = arr_object2;
                            }
                            v9 >>= 8;
                            ++v11;
                            arr_v1 = arr_v2;
                            arr_object2 = arr_object4;
                            integer0 = integer2;
                        }
                        integer3 = integer0;
                        long[] arr_v3 = arr_v1;
                        Object[] arr_object5 = arr_object2;
                        if(v10 == 8) {
                            goto label_172;
                        label_169:
                            integer3 = integer0;
                            arr_v3 = arr_v1;
                            arr_object5 = arr_object2;
                        label_172:
                            if(v8 != v7) {
                                ++v8;
                                arr_v1 = arr_v3;
                                arr_object2 = arr_object5;
                                integer0 = integer3;
                                continue;
                            }
                        }
                        break;
                    }
                }
                else {
                    integer3 = 1;
                    list0 = null;
                }
            }
        }
        Integer integer4 = i0.u() == null ? null : i0.b;
        int v13 = integer4 == null ? -1 : ((int)integer4);
        viewStructure0.setAutofillId(autofillId0, v13);
        viewStructure0.setId(v13, s, null, null);
        if(e0 != null) {
            integer5 = integer3;
        label_197:
            if(integer5 != null) {
                viewStructure0.setAutofillType(integer5.intValue());
            }
        }
        else if(z) {
            integer5 = integer3;
            goto label_197;
        }
        else if(a2 != null) {
            viewStructure0.setAutofillType(2);
        }
        else {
            integer5 = null;
            goto label_197;
        }
        if(o0 != null) {
            String[] arr_s = d.t(o0);
            if(arr_s != null) {
                viewStructure0.setAutofillHints(arr_s);
            }
        }
        int v14 = i0.b;
        O.h h0 = new O.h(viewStructure0, 2);
        a0.a.z(v14, h0);
        if(boolean0 != null) {
            viewStructure0.setSelected(boolean0.booleanValue());
        }
        int v15 = 4;
        if(a2 != null) {
            viewStructure0.setCheckable(true);
            viewStructure0.setChecked(a2 == Z0.a.a);
        }
        else if(boolean0 != null && (i2 == null || i2.a != 4)) {
            viewStructure0.setCheckable(true);
            viewStructure0.setChecked(boolean0.booleanValue());
        }
        o.a.getClass();
        if(o0 == null) {
            z2 = false;
        }
        else {
            String[] arr_s1 = d.t(o0);
            z2 = arr_s1 == null || !n.Q(arr_s1, "password") ? false : true;
        }
        boolean z3 = z1 || z2;
        if(z3) {
            viewStructure0.setDataIsSensitive(true);
        }
        if(!((j0)i0.b0.d).Z0()) {
            v15 = 0;
        }
        viewStructure0.setVisibility(v15);
        if(list0 != null) {
            int v16 = list0.size();
            String s2 = "";
            for(int v17 = 0; v17 < v16; ++v17) {
                a1.g g3 = (a1.g)list0.get(v17);
                s2 = androidx.appcompat.app.o.r(Y.p(s2), g3.b, '\n');
            }
            viewStructure0.setText(s2);
            viewStructure0.setClassName("android.widget.TextView");
        }
        if(((b)i0.o()).isEmpty() && i2 != null) {
            String s3 = N.x(i2.a);
            if(s3 != null) {
                viewStructure0.setClassName(s3);
            }
        }
        if(z) {
            viewStructure0.setClassName("android.widget.EditText");
            if(Build.VERSION.SDK_INT >= 28 && integer1 != null) {
                viewStructure0.setMaxTextLength(integer1.intValue());
            }
            if(g1 != null) {
                viewStructure0.setAutofillValue(AutofillValue.forText(g1.b));
            }
            if(z3) {
                viewStructure0.setInputType(0x81);
            }
        }
    }

    public abstract void H(w1.h arg1, w1.h arg2);

    public abstract void I(w1.h arg1, Thread arg2);

    public static boolean J(byte[] arr_b, byte[] arr_b1) {
        if(arr_b1 != null && arr_b.length >= arr_b1.length) {
            for(int v = 0; v < arr_b1.length; ++v) {
                if(arr_b[v] != arr_b1[v]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static final f K(String s) {
        q.g(s, "name");
        return new f(s);
    }

    public static ef.a L(W w0, boolean z, H h0, int v) {
        Set set0 = null;
        if((v & 4) != 0) {
            h0 = null;
        }
        if(h0 != null) {
            set0 = m.E(h0);
        }
        return new ef.a(w0, (v & 2) == 0, ((v & 1) == 0 ? z : false), set0, 34);
    }

    public static final void a(p4 p40, androidx.compose.runtime.l l0, int v) {
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0x19F5854E);
        int v1 = (p0.g(p40) ? 4 : 2) | v;
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            float f = E9.h.t(p0, 0x7F0700AC);  // dimen:context_list_padding_left_right
            r0.n n0 = r0.n.a;
            r0.q q0 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.a.m(androidx.compose.foundation.layout.d.f(n0, 1.0f), f, 8.0f, f, 6.0f), 38.0f);
            y y0 = M.w.a(M.j.e, r0.d.m, p0, 6);
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
            r0.q q2 = androidx.compose.foundation.layout.d.f(n0, 1.0f);
            long v3 = e0.T(p0, 0x7F060165);  // color:gray800s
            l1.k k0 = new l1.k(6);
            N1.b(p40.a, q2, v3, 14.0f, null, null, 0L, k0, 0.0f, 0, false, 1, 0, null, null, p0, 0xC30, 0xC00, 0x1DDF0);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new V2(p40, v, 9);
        }
    }

    public static final void b(q4 q40, int v, we.k k0, androidx.compose.runtime.l l0, int v1) {
        ((androidx.compose.runtime.p)l0).c0(0x58B4DFC);
        int v2 = (v1 & 6) == 0 ? (((androidx.compose.runtime.p)l0).i(q40) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v2 |= (((androidx.compose.runtime.p)l0).e(v) ? 0x20 : 16);
        }
        if((v1 & 0x180) == 0) {
            v2 |= (((androidx.compose.runtime.p)l0).i(k0) ? 0x100 : 0x80);
        }
        if(((androidx.compose.runtime.p)l0).Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            String s = q40.d;
            R2 r20 = new R2(q40.e, q40.f, q40.g);
            String s1 = q40.a;
            String s2 = q40.b;
            String s3 = q40.c;
            boolean z = ((androidx.compose.runtime.p)l0).i(q40);
            n4 n40 = ((androidx.compose.runtime.p)l0).N();
            V v3 = androidx.compose.runtime.k.a;
            if(((v2 & 0x380) == 0x100 | z | ((v2 & 0x70) == 0x20 ? 1 : 0)) != 0 || n40 == v3) {
                n40 = new n4(k0, q40, v, 0);
                ((androidx.compose.runtime.p)l0).l0(n40);
            }
            boolean z1 = ((androidx.compose.runtime.p)l0).i(q40);
            n4 n41 = ((androidx.compose.runtime.p)l0).N();
            if(((v2 & 0x380) == 0x100 | z1 | ((v2 & 0x70) == 0x20 ? 1 : 0)) != 0 || n41 == v3) {
                n41 = new n4(k0, q40, v, 1);
                ((androidx.compose.runtime.p)l0).l0(n41);
            }
            boolean z2 = ((androidx.compose.runtime.p)l0).i(q40);
            n4 n42 = ((androidx.compose.runtime.p)l0).N();
            if(((v2 & 0x380) == 0x100 | z2 | ((v2 & 0x70) == 0x20 ? 1 : 0)) != 0 || n42 == v3) {
                n42 = new n4(k0, q40, v, 2);
                ((androidx.compose.runtime.p)l0).l0(n42);
            }
            c1.C(s, r20, s1, s2, s3, 0.0f, 0.0f, n40, n41, n42, ((androidx.compose.runtime.p)l0), 0, 0x60);
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
        }
        n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new Nc.p(q40, v, k0, v1, 16);
        }
    }

    public static r1.d c() {
        return new r1.d(1.0f, 1.0f);
    }

    public static final void d(String s, r0.q q0, String s1, boolean z, B2 b20, we.k k0, androidx.compose.runtime.l l0, int v, int v1) {
        boolean z20;
        String s11;
        String s6;
        boolean z9;
        K0 k00;
        r0.n n1;
        V v6;
        F f2;
        String s3;
        boolean z3;
        boolean z1;
        q.g(b20, "item");
        List list0 = b20.b;
        q.g(k0, "onUserEvent");
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(-1656046540);
        int v2 = (v & 6) == 0 ? (p0.g(s) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v2 |= (p0.g(q0) ? 0x20 : 16);
        }
        if((v1 & 4) != 0) {
            v2 |= 0x180;
        }
        else if((v & 0x180) == 0) {
            v2 |= (p0.g(s1) ? 0x100 : 0x80);
        }
        if((v1 & 8) != 0) {
            v2 |= 0xC00;
            z1 = z;
        }
        else if((v & 0xC00) == 0) {
            z1 = z;
            v2 |= (p0.h(z1) ? 0x800 : 0x400);
        }
        else {
            z1 = z;
        }
        if((v & 0x6000) == 0) {
            v2 |= (p0.i(b20) ? 0x4000 : 0x2000);
        }
        if((0x30000 & v) == 0) {
            v2 |= (p0.i(k0) ? 0x20000 : 0x10000);
        }
        z z2 = null;
        if(p0.Q(v2 & 1, (74899 & v2) != 74898)) {
            String s2 = (v1 & 4) == 0 ? s1 : null;
            if((v1 & 8) != 0) {
                z1 = false;
            }
            y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
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
            P0.h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, y0, h0);
            P0.h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            P0.h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            P0.h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q1, h3);
            Object object0 = p0.k(AndroidCompositionLocals_androidKt.b);
            float f = ((Context)object0).getResources().getDimension(0x7F07044B);  // dimen:tab_common_title_height
            float f1 = ((Context)object0).getResources().getDimension(0x7F07044C);  // dimen:tab_common_title_padding
            B b0 = (B)p.m0(list0);
            r0.n n0 = r0.n.a;
            V v4 = androidx.compose.runtime.k.a;
            if(b0 instanceof A) {
                p0.a0(478028201);
                c1.f((s == null ? "" : s), androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.a.l(n0, e0.Y(f1, p0), 0.0f, 2), e0.Y(f, p0)), z1, s2, 0.0f, 0.0f, null, p0, v2 << 6 & 0x70000 | v2 << 12 & 0x380000, 0x3F9C);
                z3 = z1;
                s3 = s2;
                M.j0 j00 = androidx.compose.foundation.layout.a.a(20.0f, 0.0f, 2);
                M.g g0 = M.j.h(11.0f);
                boolean z4 = p0.i(b20);
                gd.b b1 = p0.N();
                if(z4 || (v2 & 0x70000) == 0x20000 || b1 == v4) {
                    b1 = new gd.b(b20, k0, 0);
                    p0.l0(b1);
                }
                c1.q(null, null, j00, g0, null, null, false, b1, p0, 0x6180, 0xEB);
                p0.p(false);
                s6 = s3;
                z9 = z3;
            }
            else if(b0 instanceof z) {
                p0.a0(0x1C9090AF);
                r0.q q2 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.a.l(n0, e0.Y(f1, p0), 0.0f, 2), e0.Y(f, p0));
                boolean z5 = p0.i(((Context)object0));
                c c0 = p0.N();
                if((v2 & 0x70000) == 0x20000 || z5 || c0 == v4) {
                    c0 = new c(k0, ((Context)object0), 2);
                    p0.l0(c0);
                }
                c1.f((s == null ? "" : s), q2, z1, s2, 0.0f, 0.0f, c0, p0, v2 << 6 & 0x70000 | v2 << 12 & 0x380000, 15260);
                a0 a00 = p0.N();
                if(a00 == v4) {
                    a00 = androidx.compose.runtime.w.p(0);
                    p0.l0(a00);
                }
                int v5 = ((K0)a00).m();
                M.g g1 = M.j.h(6.0f);
                ArrayList arrayList0 = new ArrayList(je.q.Q(10, list0));
                for(Object object1: list0) {
                    q.e(((B)object1), "null cannot be cast to non-null type com.melon.ui.melondj.DjHomeSubContentListItem.DjHomeTagSubContentListItem");
                    String s4 = ((z)(((B)object1))).a;
                    if(s4 == null) {
                        s4 = "";
                    }
                    String s5 = ((z)(((B)object1))).b;
                    if(s5 == null) {
                        s5 = "";
                    }
                    arrayList0.add(new Cc.b(s4, s5));
                }
                boolean z6 = p0.i(b20);
                boolean z7 = p0.i(((Context)object0));
                Object object2 = p0.N();
                if((z6 | (v2 & 0x70000) == 0x20000 | z7) != 0 || object2 == v4) {
                    n1 = n0;
                    v6 = v4;
                    k00 = (K0)a00;
                    f2 = new F(k00, b20, k0, ((Context)object0), 13);
                    p0.l0(f2);
                }
                else {
                    f2 = object2;
                    v6 = v4;
                    n1 = n0;
                    k00 = (K0)a00;
                }
                e0.b(null, v5, arrayList0, g1, 0x7F06017F, 0x7F0600C6, 0x7F06017F, 0x7F0604AA, 0x7F0604A0, 0x7F06016D, 23.0f, 18.0f, 40.0f, 14.0f, f2, p0, 0x36DB6C00, 1);  // color:green502s_support_high_contrast
                M.c.d(p0, androidx.compose.foundation.layout.d.h(n1, 20.0f));
                Object object3 = p.n0(k00.m(), list0);
                if(object3 instanceof z) {
                    z2 = (z)object3;
                }
                List list1 = z2 == null ? je.w.a : z2.a();
                p0.X(0x21F5BC47, list1);
                r0.q q3 = androidx.compose.foundation.layout.d.h(n1, 179.0f);
                P.a a0 = new P.a(2);
                M.g g2 = M.j.h(11.0f);
                M.g g3 = M.j.h(11.0f);
                M.j0 j01 = androidx.compose.foundation.layout.a.a(20.0f, 0.0f, 2);
                boolean z8 = p0.i(list1);
                gd.e e0 = p0.N();
                if(z8 || (v2 & 0x70000) == 0x20000 || e0 == v6) {
                    e0 = new gd.e(list1, 0, k0);
                    p0.l0(e0);
                }
                c1.p(a0, q3, null, j01, g3, g2, null, false, e0, p0, 0x1B0C30, 404);
                p0.p(false);
                p0.p(false);
                z9 = z1;
                s6 = s2;
            }
            else if(b0 instanceof gd.v) {
                p0.a0(0x1CD3A30D);
                r0.q q4 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.a.l(n0, e0.Y(f1, p0), 0.0f, 2), e0.Y(f, p0));
                boolean z10 = p0.i(((Context)object0));
                c c1 = p0.N();
                if((v2 & 0x70000) == 0x20000 || z10 || c1 == v4) {
                    c1 = new c(k0, ((Context)object0), 3);
                    p0.l0(c1);
                }
                c1.f((s == null ? "" : s), q4, z1, s2, 0.0f, 0.0f, c1, p0, v2 << 6 & 0x70000 | v2 << 12 & 0x380000, 15260);
                z3 = z1;
                s3 = s2;
                r0.q q5 = androidx.compose.foundation.layout.d.h(n0, 262.0f);
                P.a a1 = new P.a(3);
                M.g g4 = M.j.h(11.0f);
                M.g g5 = M.j.h(11.0f);
                M.j0 j02 = androidx.compose.foundation.layout.a.a(20.0f, 0.0f, 2);
                boolean z11 = p0.i(b20);
                gd.b b2 = p0.N();
                if(z11 || (v2 & 0x70000) == 0x20000 || b2 == v4) {
                    b2 = new gd.b(b20, k0, 1);
                    p0.l0(b2);
                }
                c1.p(a1, q5, null, j02, g5, g4, null, false, b2, p0, 0x1B0C30, 404);
                p0.p(false);
                s6 = s3;
                z9 = z3;
            }
            else {
                s3 = s2;
                z3 = z1;
                if(b0 instanceof gd.y) {
                    p0.a0(0x1CF151ED);
                    c1.f((s == null ? "" : s), androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.a.l(n0, e0.Y(f1, p0), 0.0f, 2), e0.Y(f, p0)), z3, s3, 0.0f, 0.0f, null, p0, v2 << 6 & 0x70000 | v2 << 12 & 0x380000, 0x3F9C);
                    M.j0 j03 = androidx.compose.foundation.layout.a.a(20.0f, 0.0f, 2);
                    M.g g6 = M.j.h(11.0f);
                    boolean z12 = p0.i(b20);
                    gd.b b3 = p0.N();
                    if(z12 || (v2 & 0x70000) == 0x20000 || b3 == v4) {
                        b3 = new gd.b(b20, k0, 2);
                        p0.l0(b3);
                    }
                    c1.q(null, null, j03, g6, null, null, false, b3, p0, 0x6180, 0xEB);
                    p0.p(false);
                    s6 = s3;
                    z9 = z3;
                }
                else if(b0 instanceof x) {
                    p0.a0(0x1D02D73D);
                    r0.q q6 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.a.l(n0, e0.Y(f1, p0), 0.0f, 2), e0.Y(f, p0));
                    boolean z13 = p0.i(((Context)object0));
                    c c2 = p0.N();
                    if((v2 & 0x70000) == 0x20000 || z13 || c2 == v4) {
                        c2 = new c(k0, ((Context)object0), 0);
                        p0.l0(c2);
                    }
                    c1.f((s == null ? "" : s), q6, z3, s3, 0.0f, 0.0f, c2, p0, v2 << 6 & 0x70000 | v2 << 12 & 0x380000, 15260);
                    M.j0 j04 = androidx.compose.foundation.layout.a.a(20.0f, 0.0f, 2);
                    M.g g7 = M.j.h(11.0f);
                    boolean z14 = p0.i(b20);
                    gd.b b4 = p0.N();
                    if(z14 || (v2 & 0x70000) == 0x20000 || b4 == v4) {
                        b4 = new gd.b(b20, k0, 3);
                        p0.l0(b4);
                    }
                    c1.q(null, null, j04, g7, null, null, false, b4, p0, 0x6180, 0xEB);
                    p0.p(false);
                    s6 = s3;
                    z9 = z3;
                }
                else if(b0 instanceof gd.w) {
                    p0.a0(488307305);
                    r0.q q7 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.a.l(n0, e0.Y(f1, p0), 0.0f, 2), e0.Y(f, p0));
                    boolean z15 = p0.i(((Context)object0));
                    c c3 = p0.N();
                    if((v2 & 0x70000) == 0x20000 || z15 || c3 == v4) {
                        c3 = new c(k0, ((Context)object0), 1);
                        p0.l0(c3);
                    }
                    c1.f((s == null ? "" : s), q7, z3, s3, 0.0f, 0.0f, c3, p0, v2 << 6 & 0x70000 | v2 << 12 & 0x380000, 15260);
                    z9 = z3;
                    s6 = s3;
                    r0.q q8 = androidx.compose.foundation.layout.d.h(n0, 471.0f);
                    P.a a2 = new P.a(2);
                    M.g g8 = M.j.h(11.0f);
                    M.j0 j05 = androidx.compose.foundation.layout.a.a(20.0f, 0.0f, 2);
                    boolean z16 = p0.i(b20);
                    gd.b b5 = p0.N();
                    if(z16 || (v2 & 0x70000) == 0x20000 || b5 == v4) {
                        b5 = new gd.b(b20, k0, 4);
                        p0.l0(b5);
                    }
                    c1.p(a2, q8, null, j05, null, g8, null, false, b5, p0, 0x180C30, 436);
                    p0.p(false);
                }
                else {
                    s6 = s3;
                    z9 = z3;
                    if(b0 instanceof u) {
                        p0.a0(490235195);
                        c1.f((s == null ? "" : s), androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.a.l(n0, e0.Y(f1, p0), 0.0f, 2), e0.Y(f, p0)), false, null, 0.0f, 0.0f, null, p0, 0, 0x3FFC);
                        float f3 = ScreenUtils.isPortrait(((Context)object0)) ? 310.0f : 380.0f;
                        r0.q q9 = androidx.compose.foundation.layout.d.h(n0, 264.0f);
                        P.a a3 = new P.a(3);
                        M.j0 j06 = androidx.compose.foundation.layout.a.a(20.0f, 0.0f, 2);
                        M.g g9 = M.j.h(20.0f);
                        boolean z17 = p0.i(b20);
                        boolean z18 = p0.d(f3);
                        boolean z19 = p0.i(((Context)object0));
                        gd.d d0 = p0.N();
                        if((z17 | z18 | ((v2 & 0x70000) == 0x20000 ? 1 : 0) | z19) != 0 || d0 == v4) {
                            gd.d d1 = new gd.d(b20, f3, ((Context)object0), k0, 0);
                            p0.l0(d1);
                            d0 = d1;
                        }
                        c1.p(a3, q9, null, j06, null, g9, null, false, d0, p0, 0x180C30, 436);
                    }
                    else if(b0 instanceof t) {
                        p0.a0(493106105);
                        c1.f((s == null ? "" : s), androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.a.l(n0, e0.Y(f1, p0), 0.0f, 2), e0.Y(f, p0)), false, null, 0.0f, 0.0f, null, p0, 0, 0x3FFC);
                        c1.n(androidx.compose.foundation.q.f(d5.n.o(androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.a.l(n0, 20.0f, 0.0f, 2), 168.0f), 1.0f), T.e.d(4.0f, 4.0f, 0.0f, 0.0f, 12)), e0.T(p0, 0x7F060148), M.a), 0x7F080650, null, N0.j.b, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0xC30, 0, 0x7FF4);  // color:gray075s
                        r0.q q10 = androidx.compose.foundation.q.f(d5.n.o(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.a.l(n0, 20.0f, 0.0f, 2), 1.0f), 57.0f), T.e.d(0.0f, 0.0f, 4.0f, 4.0f, 3)), e0.T(p0, 0x7F060145), M.a);  // color:gray050s
                        p0 p00 = M.n0.a(M.j.f, r0.d.k, p0, 54);
                        int v7 = p0.P;
                        i0 i01 = p0.m();
                        r0.q q11 = r0.a.d(p0, q10);
                        p0.e0();
                        if(p0.O) {
                            p0.l(i0);
                        }
                        else {
                            p0.o0();
                        }
                        androidx.compose.runtime.w.x(p0, p00, h0);
                        androidx.compose.runtime.w.x(p0, i01, h1);
                        if(p0.O || !q.b(p0.N(), v7)) {
                            A7.d.q(v7, p0, v7, h2);
                        }
                        androidx.compose.runtime.w.x(p0, q11, h3);
                        Object object4 = p.m0(list0);
                        t t0 = object4 instanceof t ? ((t)object4) : null;
                        if(t0 == null) {
                            p0.a0(0x629B4075);
                        }
                        else {
                            p0.a0(0x629B4076);
                            String s7 = t0.a == null ? "" : t0.a;
                            ed.s s8 = p0.N();
                            if(s8 == v4) {
                                s8 = new ed.s(4);
                                p0.l0(s8);
                            }
                            N1.b(s7, r0.a.a(X0.n.c(n0, false, s8), new gd.h(k0, t0, 0)), e0.T(p0, 0x7F06016D), 14.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF0);  // color:gray900s
                            e0.r(androidx.compose.foundation.layout.d.h(n0, 21.0f), e0.T(p0, 0x7F06014A), 0, 0.5f, p0, 0xC06);  // color:gray100a
                        }
                        p0.p(false);
                        Object object5 = p.t0(list0);
                        if(object5 instanceof t) {
                            z2 = (t)object5;
                        }
                        if(z2 == null) {
                            p0.a0(0x62AF636B);
                        }
                        else {
                            p0.a0(0x62AF636C);
                            String s9 = z2.a == null ? "" : z2.a;
                            ed.s s10 = p0.N();
                            if(s10 == v4) {
                                s10 = new ed.s(5);
                                p0.l0(s10);
                            }
                            N1.b(s9, r0.a.a(X0.n.c(n0, false, s10), new gd.h(k0, ((t)z2), 1)), e0.T(p0, 0x7F06016D), 14.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF0);  // color:gray900s
                        }
                        p0.p(false);
                        p0.p(true);
                    }
                    else {
                        if(b0 != null) {
                            throw l1.c(p0, 0x21F3C87B, false);
                        }
                        p0.a0(0x1D9B714B);
                    }
                    p0.p(false);
                }
            }
            p0.p(true);
            s11 = s6;
            z20 = z9;
        }
        else {
            p0.T();
            s11 = s1;
            z20 = z1;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.player.playlist.mixup.b(s, q0, s11, z20, b20, k0, v, v1);
        }
    }

    public static final void e(y0 y00, we.k k0, androidx.compose.runtime.l l0, int v) {
        ((androidx.compose.runtime.p)l0).c0(0x2AD15A09);
        int v1 = (((androidx.compose.runtime.p)l0).g(y00) ? 4 : 2) | v | (((androidx.compose.runtime.p)l0).i(k0) ? 0x20 : 16);
        int v2 = 0;
        if(((androidx.compose.runtime.p)l0).Q(v1 & 1, (v1 & 19) != 18)) {
            String s = y00.d;
            String s1 = y00.b;
            String s2 = y00.c;
            float f = E9.h.t(((androidx.compose.runtime.p)l0), 0x7F0700E3);  // dimen:detail_list_padding_left_right
            r0.q q0 = androidx.compose.foundation.layout.a.l(r0.n.a, f, 0.0f, 2);
            if((v1 & 14) == 4) {
                v2 = 1;
            }
            w0 w00 = ((androidx.compose.runtime.p)l0).N();
            if((((v1 & 0x70) == 0x20 ? 1 : 0) | v2) != 0 || w00 == androidx.compose.runtime.k.a) {
                w00 = new w0(4, k0, y00);
                ((androidx.compose.runtime.p)l0).l0(w00);
            }
            e0.p(s, s1, s2, q0, w00, ((androidx.compose.runtime.p)l0), 0);
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
        }
        n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.fragments.artistchannel.viewholder.e(y00, k0, v, 13);
        }
    }

    public static final void f(B0 b00, we.k k0, we.k k1, androidx.compose.runtime.l l0, int v) {
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0xD71422C8);
        int v1 = v | (p0.i(b00) ? 4 : 2) | (p0.i(k0) ? 0x20 : 16) | (p0.i(k1) ? 0x100 : 0x80);
        if(p0.Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            O.F f0 = O.I.a(0, 0, 3, p0);
            E e0 = p0.N();
            V v2 = androidx.compose.runtime.k.a;
            if(e0 == v2) {
                e0 = androidx.compose.runtime.w.i(new Ac.M(f0, 26));
                p0.l0(e0);
            }
            E e1 = p0.N();
            if(e1 == v2) {
                e1 = androidx.compose.runtime.w.i(new Ac.M(f0, 27));
                p0.l0(e1);
            }
            Boolean boolean0 = (Boolean)e0.getValue();
            boolean0.booleanValue();
            Boolean boolean1 = (Boolean)e1.getValue();
            boolean1.booleanValue();
            x0 x00 = p0.N();
            if((v1 & 0x380) == 0x100 || x00 == v2) {
                x00 = new x0(k1, e0, e1, null);
                p0.l0(x00);
            }
            J.f(boolean0, boolean1, x00, p0);
            r0.q q0 = androidx.compose.foundation.layout.d.c(androidx.compose.foundation.layout.a.n(r0.n.a, 0.0f, 16.0f, 0.0f, 0.0f, 13), 1.0f);
            M.j0 j00 = androidx.compose.foundation.layout.a.c(0.0f, 0.0f, 0.0f, E9.h.t(p0, 0x7F070058), 7);  // dimen:bottom_tab_plus_miniplayer_height
            boolean z = p0.i(b00);
            gd.l l1 = p0.N();
            if(z || (v1 & 0x70) == 0x20 || l1 == v2) {
                l1 = new gd.l(5, b00, k0);
                p0.l0(l1);
            }
            c1.o(q0, f0, j00, false, null, null, null, false, l1, p0, 6, 0xF8);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Id.h(b00, k0, k1, v, 14);
        }
    }

    public static final void g(ArrayList arrayList0, we.k k0, androidx.compose.runtime.l l0, int v) {
        ((androidx.compose.runtime.p)l0).c0(0xBA49C0C2);
        int v1 = (((androidx.compose.runtime.p)l0).i(arrayList0) ? 4 : 2) | v | (((androidx.compose.runtime.p)l0).i(k0) ? 0x20 : 16);
        boolean z = true;
        if(((androidx.compose.runtime.p)l0).Q(v1 & 1, (v1 & 19) != 18)) {
            C0 c00 = N.u(((androidx.compose.runtime.p)l0));
            O.F f0 = O.I.a(0, 0, 3, ((androidx.compose.runtime.p)l0));
            r0.q q0 = androidx.compose.ui.input.nestedscroll.a.a(androidx.compose.foundation.layout.d.f(r0.n.a, 1.0f), c00, null);
            M.j0 j00 = androidx.compose.foundation.layout.a.c(0.0f, 0.0f, 0.0f, E9.h.t(((androidx.compose.runtime.p)l0), 0x7F070058), 7);  // dimen:bottom_tab_plus_miniplayer_height
            boolean z1 = ((androidx.compose.runtime.p)l0).i(arrayList0);
            if((v1 & 0x70) != 0x20) {
                z = false;
            }
            m4 m40 = ((androidx.compose.runtime.p)l0).N();
            if(z1 || z || m40 == androidx.compose.runtime.k.a) {
                m40 = new m4(arrayList0, k0, 0);
                ((androidx.compose.runtime.p)l0).l0(m40);
            }
            c1.o(q0, f0, j00, false, null, null, null, false, m40, ((androidx.compose.runtime.p)l0), 0, 0xF8);
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
        }
        n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.fragments.artistchannel.viewholder.e(arrayList0, k0, v, 22);
        }
    }

    public static final long h(float f, float f1) [...] // 潜在的解密器

    public static final boolean i(u0.e e0, long v) {
        if(e0.getNode().isAttached()) {
            P0.v v1 = (P0.v)P0.f.v(e0).b0.c;
            if(v1.h()) {
                long v2 = v1.j0(0L);
                float f = Float.intBitsToFloat(((int)(v2 >> 0x20)));
                float f1 = Float.intBitsToFloat(((int)(v2 & 0xFFFFFFFFL)));
                float f2 = ((float)(((int)(e0.c & 0xFFFFFFFFL)))) + f1;
                float f3 = Float.intBitsToFloat(((int)(v >> 0x20)));
                if(f <= f3 && f3 <= ((float)(((int)(e0.c >> 0x20)))) + f) {
                    float f4 = Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL)));
                    return f1 <= f4 && f4 <= f2;
                }
            }
        }
        return false;
    }

    public static final Object j(Playable playable0, oc.a a0, oe.c c0) {
        oc.F f0;
        if(c0 instanceof oc.F) {
            f0 = (oc.F)c0;
            int v = f0.B;
            if((v & 0x80000000) == 0) {
                f0 = new oc.F(c0);  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
            }
            else {
                f0.B = v ^ 0x80000000;
            }
        }
        else {
            f0 = new oc.F(c0);  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
        }
        Object object0 = f0.w;
        ne.a a1 = ne.a.a;
        switch(f0.B) {
            case 0: {
                d5.n.D(object0);
                if(playable0 == null) {
                    return null;
                }
                f0.r = playable0;
                f0.B = 1;
                object0 = a0.h(playable0, f0);
                if(object0 == a1) {
                    return a1;
                }
                break;
            }
            case 1: {
                playable0 = f0.r;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        boolean z = playable0.isOriginMelon();
        boolean z1 = playable0.isOriginLocal();
        boolean z2 = playable0.isAdult();
        boolean z3 = playable0.isLiked();
        Uri uri0 = ((PlayableAlbumUriData)object0).getSmallAlbumUri();
        Uri uri1 = ((PlayableAlbumUriData)object0).getLargeAlbumUri();
        List list0 = playable0.getBgImgs();
        q.f(list0, "getBgImgs(...)");
        return new PlayableData(playable0, "", z, z1, "", "", playable0.getDurationLimit(), "", "", z2, z3, playable0.getLikeCount(), uri0, uri1, playable0.getBgVideo(), list0);
    }

    public static final Object k(List list0, oc.a a0, Continuation continuation0) {
        Iterator iterator2;
        int v4;
        Collection collection2;
        Collection collection1;
        Iterator iterator0;
        int v2;
        int v1;
        Collection collection0;
        oc.G g0;
        if(continuation0 instanceof oc.G) {
            g0 = (oc.G)continuation0;
            int v = g0.M;
            if((v & 0x80000000) == 0) {
                g0 = new oc.G(continuation0);  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
            }
            else {
                g0.M = v ^ 0x80000000;
            }
        }
        else {
            g0 = new oc.G(continuation0);  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
        }
        Object object0 = g0.I;
        ne.a a1 = ne.a.a;
        switch(g0.M) {
            case 0: {
                d5.n.D(object0);
                collection0 = new ArrayList(je.q.Q(10, list0));
                v1 = 0;
                v2 = 0;
                iterator0 = list0.iterator();
                goto label_34;
            }
            case 1: {
                v2 = g0.G;
                int v3 = g0.E;
                collection1 = g0.D;
                Iterator iterator1 = g0.B;
                collection2 = g0.w;
                oc.a a2 = g0.r;
                d5.n.D(object0);
                v4 = v3;
                a0 = a2;
                iterator2 = iterator1;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        while(true) {
            q.d(object0);
            collection1.add(((PlayableData)object0));
            v1 = v4;
            collection0 = collection2;
            iterator0 = iterator2;
        label_34:
            if(!iterator0.hasNext()) {
                break;
            }
            Object object1 = iterator0.next();
            g0.r = a0;
            g0.w = collection0;
            g0.B = iterator0;
            g0.D = collection0;
            g0.E = v1;
            g0.G = v2;
            g0.M = 1;
            Object object2 = v.j(((Playable)object1), a0, g0);
            if(object2 == a1) {
                return a1;
            }
            iterator2 = iterator0;
            v4 = v1;
            collection1 = collection0;
            object0 = object2;
            collection2 = collection1;
        }
        return (List)collection0;
    }

    public static boolean l(int v, Rect rect0, Rect rect1, Rect rect2) {
        boolean z = v.m(v, rect0, rect1);
        if(!v.m(v, rect0, rect2) && z) {
            switch(v) {
                case 17: {
                    if(rect0.left >= rect2.right) {
                        goto label_11;
                    }
                    break;
                }
                case 33: {
                    if(rect0.top >= rect2.bottom) {
                        goto label_11;
                    }
                    break;
                }
                case 66: {
                    if(rect0.right <= rect2.left) {
                        goto label_11;
                    }
                    break;
                }
                case 130: {
                    if(rect0.bottom <= rect2.top) {
                    label_11:
                        if(v != 17 && v != 66) {
                            int v1 = v.C(v, rect0, rect1);
                            switch(v) {
                                case 33: {
                                    return v1 < Math.max(1, rect0.top - rect2.top);
                                }
                                case 130: {
                                    return v1 < Math.max(1, rect2.bottom - rect0.bottom);
                                }
                                default: {
                                    throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                                }
                            }
                        }
                    }
                    break;
                }
                default: {
                    throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                }
            }
            return true;
        }
        return false;
    }

    public static boolean m(int v, Rect rect0, Rect rect1) {
        switch(v) {
            case 17: 
            case 66: {
                return rect1.bottom >= rect0.top && rect1.top <= rect0.bottom;
            }
            case 33: 
            case 130: {
                return rect1.right >= rect0.left && rect1.left <= rect0.right;
            }
            default: {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
        }
    }

    public static final f n(String s) {
        q.g(s, "name");
        return new f(s);
    }

    public abstract boolean o(w1.i arg1, w1.d arg2, w1.d arg3);

    public abstract boolean p(w1.i arg1, Object arg2, Object arg3);

    public abstract boolean q(w1.i arg1, w1.h arg2, w1.h arg3);

    public static final double r(int v, int v1, int v2, int v3, u5.f f0) {
        double f1 = ((double)v2) / ((double)v);
        double f2 = ((double)v3) / ((double)v1);
        switch(f0.ordinal()) {
            case 0: {
                return Math.max(f1, f2);
            }
            case 1: {
                return Math.min(f1, f2);
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
    }

    public static long[] s(Serializable serializable0) {
        if(serializable0 instanceof int[]) {
            long[] arr_v = new long[((int[])serializable0).length];
            for(int v = 0; v < ((int[])serializable0).length; ++v) {
                arr_v[v] = (long)((int[])serializable0)[v];
            }
            return arr_v;
        }
        return serializable0 instanceof long[] ? ((long[])serializable0) : null;
    }

    public static final void t(int v, int v1) {
        if(v > v1) {
            throw new IndexOutOfBoundsException("toIndex (" + v + ") is greater than size (" + v1 + ").");
        }
    }

    public static void u(Activity activity0, Uri uri0) {
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
        Object object1 = linkedHashMap0.get("genreCode");
        String s = uri0.getPath();
        if(s != null) {
            switch(s.hashCode()) {
                case 0x95C86230: {
                    if(s.equals("/more/newmusic") && ((String)object1) != null) {
                        Navigator.openGenreMore$default(Navigator.INSTANCE, More_Fragment_Type.GUI_MORE_NEW_SONG, ((String)object1), null, null, null, 28, null);
                        return;
                    }
                    break;
                }
                case 0xB072B17B: {
                    if(s.equals("/label/detail")) {
                        String s1 = (String)linkedHashMap0.get("labelSeq");
                        if(s1 != null) {
                            Navigator.INSTANCE.openGenreDetailLabel(s1);
                            return;
                        }
                    }
                    break;
                }
                case 0xB2F09B7D: {
                    if(s.equals("/more/playlist") && ((String)object1) != null) {
                        Navigator.openGenreMore$default(Navigator.INSTANCE, More_Fragment_Type.GUI_MORE_PLAYLIST, ((String)object1), null, null, null, 28, null);
                        return;
                    }
                    break;
                }
                case 0xB350EA3D: {
                    if(s.equals("/masterpiece")) {
                        Object object2 = linkedHashMap0.get("gnrContsSeq");
                        if(((String)object1) != null) {
                            Navigator.INSTANCE.openGenreMore(More_Fragment_Type.GUI_MORE_MASTERPIECE, ((String)object1), ((String)object2), null, null);
                            return;
                        }
                    }
                    break;
                }
                case 0: {
                    return;
                }
                case 0x85302B1: {
                    if(s.equals("/majorartist")) {
                        Object object3 = linkedHashMap0.get("filterTypeCode");
                        Object object4 = linkedHashMap0.get("genreSeq");
                        Object object5 = linkedHashMap0.get("filterTypeFlag");
                        if(((String)object1) != null && ((String)object3) != null) {
                            Navigator.INSTANCE.openGenreMore(More_Fragment_Type.GUI_MORE_ARTIST, ((String)object1), ((String)object4), ((String)object5), ((String)object3));
                            return;
                        }
                    }
                    break;
                }
                case 0x66AEF940: {
                    if(s.equals("/detail") && ((String)object1) != null) {
                        Navigator.openGenreDetail(((String)object1));
                        return;
                    }
                    break;
                }
                case 1932801597: {
                    if(s.equals("/selection") && activity0 != null && activity0 instanceof MusicBrowserActivity) {
                        androidx.fragment.app.I i0 = ((MusicBrowserActivity)activity0).getCurrentFragment();
                        if(i0 instanceof T) {
                            ((Zc.B)(((T)i0))).getClass();
                            switch(NetUtils.checkDataNetwork()) {
                                case 2: 
                                case 3: {
                                    ToastManager.show(0x7F1303DA);  // string:error_network_connectivity_toast "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해주세요."
                                    return;
                                }
                                default: {
                                    FragmentActivity fragmentActivity0 = ((Zc.B)(((T)i0))).getActivity();
                                    if(fragmentActivity0 != null) {
                                        GenreAllPopup genreAllPopup0 = new GenreAllPopup(fragmentActivity0, "");
                                        ((Zc.B)(((T)i0))).i = genreAllPopup0;
                                        genreAllPopup0.show();
                                    }
                                    O.a(new UaLogDummyReq(((Zc.B)(((T)i0))).getContext(), "genrePopupMenuView"));
                                    return;
                                }
                            }
                        }
                    }
                    break;
                }
            }
        }
    }

    public static Object v(g g0, Object object0, we.n n0) {
        q.g(n0, "operation");
        return n0.invoke(object0, g0);
    }

    public static g w(g g0, h h0) {
        q.g(h0, "key");
        return q.b(g0.getKey(), h0) ? g0 : null;
    }

    public static Set x() {
        Set set0 = EmojiConsistency.getEmojiConsistencySet();
        if(set0 == null) {
            return Collections.EMPTY_SET;
        }
        for(Object object0: set0) {
            if(!(object0 instanceof int[])) {
                return Collections.EMPTY_SET;
            }
            if(false) {
                break;
            }
        }
        return set0;
    }

    public static final int y(int v, int v1) [...] // Inlined contents

    public static final f z(String s) {
        q.g(s, "name");
        return new f(s);
    }
}

