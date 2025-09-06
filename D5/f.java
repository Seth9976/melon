package d5;

import C1.b;
import Cb.n;
import Cc.N1;
import Cc.c1;
import Cc.e0;
import Cc.m3;
import Cc.z2;
import D1.i;
import D2.W0;
import De.I;
import F.m0;
import G.a0;
import Ge.A0;
import Ge.s0;
import He.D;
import Hf.B;
import Hf.Y;
import Hf.x;
import I.u0;
import J8.H;
import Jc.g0;
import M.n0;
import M.p0;
import M.y;
import Me.A;
import Me.E;
import Me.L;
import Me.T;
import Me.c;
import Me.e;
import Me.h;
import Me.j;
import Me.k;
import N0.M;
import Nc.Z;
import Pe.C;
import Pe.S;
import Pe.u;
import Q.K;
import Q.a;
import Q0.k0;
import Tf.p;
import Tf.v;
import U4.F;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.app.o;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.w;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.ToolBar;
import com.iloen.melon.fragments.main.common.MainTabTitleView;
import com.melon.ui.o1;
import i.n.i.b.a.s.e.M3;
import ie.m;
import java.io.File;
import java.io.PrintStream;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import kotlin.jvm.internal.q;
import tf.g;
import x1.s;
import xf.d;

public abstract class f {
    public static final int a;
    public static final int b;
    public static final int c;
    public static Typeface d;
    public static Typeface e;

    public f() {
        new ConcurrentHashMap();
    }

    public static final String A(Collection collection0) {
        q.g(collection0, "collection");
        return collection0.isEmpty() ? " }" : p.a0(je.p.q0(collection0, ",\n", "\n", "\n", null, 56), "    ") + "},";
    }

    public static final x B(c c0) {
        u u0 = c0.Q();
        u u1 = c0.L();
        if(u0 != null) {
            return u0.getType();
        }
        if(u1 != null) {
            if(c0 instanceof j) {
                return u1.getType();
            }
            k k0 = c0.e();
            e e0 = k0 instanceof e ? ((e)k0) : null;
            if(e0 != null) {
                return e0.g();
            }
        }
        return null;
    }

    public static final Method C(Class class0, c c0) {
        q.g(c0, "descriptor");
        try {
            Method method0 = class0.getDeclaredMethod("unbox-impl", null);
            q.d(method0);
            return method0;
        }
        catch(NoSuchMethodException unused_ex) {
            throw new s0("No unbox method found in inline class: " + class0 + " (calling " + c0 + ')');
        }
    }

    public static final ArrayList D(B b0) {
        ArrayList arrayList0 = f.E(Hf.c.b(b0));
        if(arrayList0 != null) {
            ArrayList arrayList1 = new ArrayList(je.q.Q(10, arrayList0));
            for(Object object0: arrayList0) {
                arrayList1.add("unbox-impl-" + ((String)object0));
            }
            h h0 = b0.w().e();
            q.e(h0, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            Class class0 = A0.k(((e)h0));
            q.d(class0);
            ArrayList arrayList2 = new ArrayList(je.q.Q(10, arrayList1));
            for(Object object1: arrayList1) {
                arrayList2.add(class0.getDeclaredMethod(((String)object1), null));
            }
            return arrayList2;
        }
        return null;
    }

    public static final ArrayList E(B b0) {
        List list0;
        A a0 = null;
        if(g.h(b0)) {
            h h0 = b0.w().e();
            q.e(h0, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            T t0 = ((e)h0).a0();
            if(t0 instanceof A) {
                a0 = (A)t0;
            }
            q.d(a0);
            ArrayList arrayList0 = new ArrayList();
            for(Object object0: a0.a) {
                qf.e e0 = (qf.e)((m)object0).a;
                ArrayList arrayList1 = f.E(((B)((m)object0).b));
                if(arrayList1 == null) {
                    list0 = e.k.z(e0.c());
                }
                else {
                    list0 = new ArrayList(je.q.Q(10, arrayList1));
                    for(Object object1: arrayList1) {
                        ((ArrayList)list0).add(e0.c() + '-' + ((String)object1));
                    }
                }
                je.u.U(arrayList0, list0);
            }
            return arrayList0;
        }
        return null;
    }

    public static Typeface F(Context context0) {
        if(f.e == null) {
            f.e = context0.getResources().getFont(0x7F090001);  // font:roboto_noto_bold
        }
        return f.e;
    }

    public static Typeface G(Context context0) {
        if(f.d == null) {
            f.d = context0.getResources().getFont(0x7F090002);  // font:roboto_noto_normal
        }
        return f.d;
    }

    public static Object H(Future future0) {
        Object object0;
        boolean z = false;
        while(true) {
            try {
                object0 = future0.get();
                break;
            }
            catch(InterruptedException unused_ex) {
                z = true;
            }
            catch(Throwable throwable0) {
                if(z) {
                    Thread.currentThread().interrupt();
                }
                throw throwable0;
            }
        }
        if(z) {
            Thread.currentThread().interrupt();
        }
        return object0;
    }

    public static boolean I(Ne.h h0, qf.c c0) {
        q.g(c0, "fqName");
        return h0.e0(c0) != null;
    }

    public static final void J(ToolBar toolBar0, o1 o10) {
        q.g(toolBar0, "<this>");
        if(toolBar0.getVisibility() == 0) {
            toolBar0.setOnToolBarAnimationListener(new n(o10, 0));
            toolBar0.h(false);
        }
    }

    public static g0 K(ViewGroup viewGroup0) {
        View view0 = o.e(viewGroup0, 0x7F0D01F9, viewGroup0, false);  // layout:detail_album_info
        int v = 0x7F0A007B;  // id:agency_container
        View view1 = I.C(view0, 0x7F0A007B);  // id:agency_container
        if(((LinearLayout)view1) != null) {
            v = 0x7F0A0090;  // id:album_type_container
            View view2 = I.C(view0, 0x7F0A0090);  // id:album_type_container
            if(((LinearLayout)view2) != null) {
                v = 0x7F0A04EB;  // id:genre_container
                View view3 = I.C(view0, 0x7F0A04EB);  // id:genre_container
                if(((LinearLayout)view3) != null && ((RelativeLayout)I.C(view0, 0x7F0A0579)) != null) {  // id:info_layout
                    v = 0x7F0A0595;  // id:issue_date_container
                    View view4 = I.C(view0, 0x7F0A0595);  // id:issue_date_container
                    if(((LinearLayout)view4) != null) {
                        v = 0x7F0A07CA;  // id:main_contents_title
                        View view5 = I.C(view0, 0x7F0A07CA);  // id:main_contents_title
                        if(((MainTabTitleView)view5) != null) {
                            v = 0x7F0A0963;  // id:preview_layout
                            View view6 = I.C(view0, 0x7F0A0963);  // id:preview_layout
                            if(((LinearLayout)view6) != null) {
                                v = 0x7F0A098B;  // id:publisher_container
                                View view7 = I.C(view0, 0x7F0A098B);  // id:publisher_container
                                if(((LinearLayout)view7) != null) {
                                    v = 0x7F0A0C05;  // id:tv_agency
                                    View view8 = I.C(view0, 0x7F0A0C05);  // id:tv_agency
                                    if(((MelonTextView)view8) != null) {
                                        v = 0x7F0A0C10;  // id:tv_album_type
                                        View view9 = I.C(view0, 0x7F0A0C10);  // id:tv_album_type
                                        if(((MelonTextView)view9) != null) {
                                            v = 0x7F0A0C83;  // id:tv_genre
                                            View view10 = I.C(view0, 0x7F0A0C83);  // id:tv_genre
                                            if(((MelonTextView)view10) != null) {
                                                v = 0x7F0A0C93;  // id:tv_issue_date
                                                View view11 = I.C(view0, 0x7F0A0C93);  // id:tv_issue_date
                                                if(((MelonTextView)view11) != null) {
                                                    v = 0x7F0A0CEC;  // id:tv_preview
                                                    View view12 = I.C(view0, 0x7F0A0CEC);  // id:tv_preview
                                                    if(((MelonTextView)view12) != null) {
                                                        v = 0x7F0A0CF1;  // id:tv_publisher
                                                        View view13 = I.C(view0, 0x7F0A0CF1);  // id:tv_publisher
                                                        if(((MelonTextView)view13) != null) {
                                                            return new g0(new H(((ConstraintLayout)view0), ((LinearLayout)view1), ((LinearLayout)view2), ((LinearLayout)view3), ((LinearLayout)view4), ((MainTabTitleView)view5), ((LinearLayout)view6), ((LinearLayout)view7), ((MelonTextView)view8), ((MelonTextView)view9), ((MelonTextView)view10), ((MelonTextView)view11), ((MelonTextView)view12), ((MelonTextView)view13)));
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    public static a L(K k0, u0 u00, l l0, int v) {
        boolean z = (v & 14 ^ 6) > 4 && ((androidx.compose.runtime.p)l0).g(k0) || (v & 6) == 4;
        a a0 = ((androidx.compose.runtime.p)l0).N();
        if(z || a0 == androidx.compose.runtime.k.a) {
            a0 = new a(k0, u00);
            ((androidx.compose.runtime.p)l0).l0(a0);
        }
        return a0;
    }

    public static void M(int v, s s0, d5.m m0, B1.a a0) {
        String s2;
        D1.h h0 = v == 0 ? ((D1.h)s0.e(1)) : ((i)s0.e(2));
        B1.c c0 = a0.o(1);
        if(c0 instanceof B1.a && ((B1.a)c0).e.size() >= 1) {
            for(int v1 = 0; v1 < ((B1.a)c0).e.size(); ++v1) {
                h0.q(new Object[]{((B1.a)c0).v(v1)});
            }
            if(a0.e.size() > 2) {
                B1.c c1 = a0.o(2);
                if(c1 instanceof B1.g) {
                    for(Object object0: ((B1.g)c1).z()) {
                        String s1 = (String)object0;
                        s1.getClass();
                        if(s1.equals("style")) {
                            B1.c c2 = ((B1.g)c1).p(s1);
                            if(!(c2 instanceof B1.a) || ((B1.a)c2).e.size() <= 1) {
                                s2 = c2.d();
                            }
                            else {
                                s2 = ((B1.a)c2).v(0);
                                h0.n0 = ((B1.a)c2).q(1);
                            }
                            s2.getClass();
                            if(s2.equals("packed")) {
                                h0.t0 = C1.i.c;
                            }
                            else {
                                h0.t0 = s2.equals("spread_inside") ? C1.i.b : C1.i.a;
                            }
                        }
                        else {
                            f.N(((B1.g)c1), h0, m0, s1, s0);
                        }
                    }
                }
            }
        }
    }

    public static void N(B1.g g0, b b0, d5.m m0, String s, s s1) {
        int v1;
        int v;
        boolean z1;
        float f4;
        float f2;
        boolean z = s1.b;
        B1.c c0 = g0.u(s);
        B1.a a0 = c0 instanceof B1.a ? ((B1.a)c0) : null;
        if(a0 != null && a0.e.size() > 1) {
            String s2 = a0.v(0);
            B1.c c1 = a0.t(1);
            String s3 = c1 instanceof B1.i ? c1.d() : null;
            float f = 0.0f;
            if(a0.e.size() > 2) {
                float f1 = m0.h(a0.t(2));
                f2 = s1.a.e(f1);
            }
            else {
                f2 = 0.0f;
            }
            if(a0.e.size() > 3) {
                float f3 = m0.h(a0.t(3));
                f4 = s1.a.e(f3);
            }
            else {
                f4 = 0.0f;
            }
            b b1 = s2.equals("parent") ? s1.b(0) : s1.b(s2);
            s.getClass();
            switch(s) {
                case "baseline": {
                    s3.getClass();
                    switch(s3) {
                        case "baseline": {
                            s1.a(b0.a);
                            s1.a(b1.a);
                            b0.j0 = 15;
                            b0.X = b1;
                            goto label_75;
                        }
                        case "bottom": {
                            s1.a(b0.a);
                            b0.j0 = 17;
                            b0.Z = b1;
                            goto label_75;
                        }
                        case "top": {
                            s1.a(b0.a);
                            b0.j0 = 16;
                            b0.Y = b1;
                            goto label_75;
                        }
                        default: {
                            goto label_75;
                        }
                    }
                }
                case "bottom": {
                    s3.getClass();
                    switch(s3) {
                        case "baseline": {
                            s1.a(b1.a);
                            b0.j0 = 14;
                            b0.W = b1;
                            goto label_75;
                        }
                        case "bottom": {
                            b0.e(b1);
                            goto label_75;
                        }
                        case "top": {
                            b0.j0 = 12;
                            b0.U = b1;
                            goto label_75;
                        }
                        default: {
                            goto label_75;
                        }
                    }
                }
                case "circular": {
                    float f5 = m0.h(a0.o(1));
                    if(a0.e.size() > 2) {
                        float f6 = m0.h(a0.t(2));
                        f = s1.a.e(f6);
                    }
                    b0.a0 = b0.j(b1);
                    b0.b0 = f5;
                    b0.c0 = f;
                    b0.j0 = 20;
                    z1 = false;
                    v = 1;
                    break;
                }
                case "end": {
                    v = !z;
                    z1 = true;
                    break;
                }
                case "left": {
                    z1 = true;
                    v = 1;
                    break;
                }
                case "right": {
                    z1 = true;
                    v = 0;
                    break;
                }
                case "start": {
                    v = z;
                    z1 = true;
                    break;
                }
                case "top": {
                    s3.getClass();
                    switch(s3) {
                        case "baseline": {
                            s1.a(b1.a);
                            b0.j0 = 11;
                            b0.T = b1;
                            break;
                        }
                        case "bottom": {
                            b0.j0 = 10;
                            b0.S = b1;
                            break;
                        }
                        case "top": {
                            b0.p(b1);
                        }
                    }
                label_75:
                    z1 = false;
                    v = 1;
                    break;
                }
                default: {
                    goto label_75;
                }
            }
            if(z1) {
                s3.getClass();
                switch(s3) {
                    case "end": {
                        v1 = !z;
                        break;
                    }
                    case "right": {
                        v1 = 0;
                        break;
                    }
                    case "start": {
                        v1 = z;
                        break;
                    }
                    default: {
                        v1 = 1;
                    }
                }
                if(v == 0) {
                    if(v1 == 0) {
                        b0.j0 = 4;
                        b0.M = b1;
                    }
                    else {
                        b0.j0 = 3;
                        b0.L = b1;
                    }
                }
                else if(v1 != 0) {
                    b0.j0 = 1;
                    b0.J = b1;
                }
                else {
                    b0.j0 = 2;
                    b0.K = b1;
                }
            }
            b0.l(f2).n(f4);
            return;
        }
        String s4 = g0.x(s);
        if(s4 != null) {
            b b2 = s4.equals("parent") ? s1.b(0) : s1.b(s4);
            s.getClass();
            switch(s) {
                case "baseline": {
                    s1.a(b0.a);
                    s1.a(b2.a);
                    b0.j0 = 15;
                    b0.X = b2;
                    break;
                }
                case "bottom": {
                    b0.e(b2);
                    return;
                }
                case "end": {
                    if(z) {
                        b0.j0 = 4;
                        b0.M = b2;
                        return;
                    }
                    b0.j0 = 1;
                    b0.J = b2;
                    return;
                }
                case "start": {
                    if(z) {
                        b0.j0 = 1;
                        b0.J = b2;
                        return;
                    }
                    b0.j0 = 4;
                    b0.M = b2;
                    return;
                }
                case "top": {
                    b0.p(b2);
                }
            }
        }
    }

    public static C1.f O(B1.g g0, String s, s s1, j3.n n0) {
        B1.c c0 = g0.p(s);
        C1.f f0 = C1.f.b(0);
        if(c0 instanceof B1.i) {
            return f.P(c0.d());
        }
        if(c0 instanceof B1.e) {
            return C1.f.b(s1.c(n0.e(g0.r(s))));
        }
        if(c0 instanceof B1.g) {
            String s2 = ((B1.g)c0).x("value");
            if(s2 != null) {
                f0 = f.P(s2);
            }
            B1.c c1 = ((B1.g)c0).u("min");
            if(c1 != null) {
                if(c1 instanceof B1.e) {
                    int v = s1.c(n0.e(((B1.e)c1).e()));
                    if(v >= 0) {
                        f0.a = v;
                    }
                }
                else if(c1 instanceof B1.i) {
                    f0.a = -2;
                }
            }
            B1.c c2 = ((B1.g)c0).u("max");
            if(c2 != null) {
                if(c2 instanceof B1.e) {
                    int v1 = s1.c(n0.e(((B1.e)c2).e()));
                    if(f0.b >= 0) {
                        f0.b = v1;
                        return f0;
                    }
                }
                else if(c2 instanceof B1.i && f0.g) {
                    f0.f = "WRAP_DIMENSION";
                    f0.b = 0x7FFFFFFF;
                }
            }
        }
        return f0;
    }

    public static C1.f P(String s) {
        C1.f f0 = C1.f.b(0);
        s.getClass();
        switch(s) {
            case "parent": {
                return new C1.f("PARENT_DIMENSION");
            }
            case "preferWrap": {
                return C1.f.c("WRAP_DIMENSION");
            }
            case "spread": {
                return C1.f.c("SPREAD_DIMENSION");
            }
            case "wrap": {
                return new C1.f("WRAP_DIMENSION");
            }
            default: {
                if(s.endsWith("%")) {
                    float f1 = Float.parseFloat(s.substring(0, s.indexOf(37)));
                    C1.f f2 = new C1.f("PERCENT_DIMENSION");
                    f2.c = f1 / 100.0f;
                    f2.g = true;
                    f2.b = 0;
                    return f2;
                }
                if(s.contains(":")) {
                    C1.f f3 = new C1.f("RATIO_DIMENSION");
                    f3.e = s;
                    f3.f = "SPREAD_DIMENSION";
                    f3.g = true;
                    return f3;
                }
                return f0;
            }
        }
    }

    // This method was un-flattened
    public static void Q(int v, s s0, String s1, B1.g g0) {
        ArrayList arrayList0 = g0.z();
        b b0 = s0.b(s1);
        if(v == 0) {
            s0.d(0, s1);
        }
        else {
            s0.d(1, s1);
        }
        int v1 = s0.b || v == 0 ? 1 : 0;
        D1.g g1 = (D1.g)b0.c;
        boolean z = false;
        int v2 = 1;
        float f = 0.0f;
        for(Object object0: arrayList0) {
            String s2 = (String)object0;
            s2.getClass();
            switch(s2) {
                case "end": {
                label_46:
                    float f2 = g0.r(s2);
                    f = s0.a.e(f2);
                    v2 = v1 ^ 1;
                    break;
                }
                case "left": {
                    float f3 = g0.r(s2);
                    f = s0.a.e(f3);
                    v2 = 1;
                    break;
                }
                case "percent": {
                    B1.c c0 = g0.u(s2);
                    B1.a a0 = c0 instanceof B1.a ? ((B1.a)c0) : null;
                    if(a0 == null) {
                        f = g0.r(s2);
                        z = true;
                        v2 = 1;
                        continue;
                    }
                    else {
                        if(a0.e.size() > 1) {
                            String s3 = a0.v(0);
                            float f1 = a0.q(1);
                            s3.getClass();
                            switch(s3) {
                                case "end": {
                                    v2 = v1 ^ 1;
                                    f = f1;
                                    break;
                                }
                                case "left": {
                                    v2 = 1;
                                    f = f1;
                                    z = true;
                                    continue;
                                }
                                case "right": {
                                    v2 = 0;
                                    f = f1;
                                    break;
                                }
                                case "start": {
                                    v2 = v1;
                                    f = f1;
                                    break;
                                }
                                default: {
                                    f = f1;
                                }
                            }
                        }
                        z = true;
                        break;
                    }
                    goto label_46;
                }
                case "right": {
                    float f4 = g0.r(s2);
                    f = s0.a.e(f4);
                    v2 = 0;
                    break;
                }
                case "start": {
                    float f5 = g0.r(s2);
                    f = s0.a.e(f5);
                    v2 = v1;
                }
            }
        }
        if(z) {
            if(v2 != 0) {
                g1.d = -1;
                g1.e = -1;
                g1.f = f;
                return;
            }
            g1.d = -1;
            g1.e = -1;
            g1.f = 1.0f - f;
            return;
        }
        if(v2 != 0) {
            g1.d = g1.a.c(f);
            g1.e = -1;
            g1.f = 0.0f;
            return;
        }
        g1.d = -1;
        g1.e = g1.a.c(f);
        g1.f = 0.0f;
    }

    public static void R(s s0, d5.m m0, String s1, B1.g g0) {
        b b0 = s0.b(s1);
        if(b0.d0 == null) {
            b0.d0 = new C1.f("WRAP_DIMENSION");
        }
        if(b0.e0 == null) {
            b0.e0 = new C1.f("WRAP_DIMENSION");
        }
        for(Object object0: g0.z()) {
            f.h(g0, b0, m0, ((String)object0), s0);
        }
    }

    // This method was un-flattened
    public static void S(B1.g g0, s s0, d5.m m0) {
        Iterator iterator8;
        float f35;
        float f34;
        float f36;
        B1.a a4;
        B1.c c15;
        Float float6;
        Float float5;
        Float float4;
        float f33;
        float f32;
        float f31;
        float f28;
        String s24;
        String s23;
        String s22;
        Float float2;
        Float float1;
        Float float0;
        String s20;
        String s19;
        String s18;
        String s6;
        Iterator iterator4;
        int v1;
        float f4;
        float f3;
        float f2;
        float f1;
        float f;
        float f5;
        Iterator iterator3;
        String s10;
        int v6;
        float f24;
        float f23;
        float f22;
        float f21;
        int v3;
        Iterator iterator0 = g0.z().iterator();
    label_1:
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            String s1 = (String)object0;
            B1.c c0 = g0.p(s1);
            s1.getClass();
        alab1:
            switch(s1) {
                case "Generate": {
                    if(!(c0 instanceof B1.g)) {
                        continue;
                    }
                    B1.g g2 = (B1.g)c0;
                    for(Object object6: g2.z()) {
                        String s30 = (String)object6;
                        B1.c c20 = g2.p(s30);
                        HashMap hashMap0 = (HashMap)m0.d;
                        ArrayList arrayList0 = hashMap0.containsKey(s30) ? ((ArrayList)hashMap0.get(s30)) : null;
                        if(arrayList0 != null && c20 instanceof B1.g) {
                            for(Object object7: arrayList0) {
                                f.R(s0, m0, ((String)object7), ((B1.g)c20));
                            }
                        }
                    }
                    continue;
                }
                case "Helpers": {
                    if(!(c0 instanceof B1.a)) {
                        continue;
                    }
                    B1.a a5 = (B1.a)c0;
                    for(int v10 = 0; v10 < a5.e.size(); ++v10) {
                        B1.c c17 = a5.o(v10);
                        if(c17 instanceof B1.a && ((B1.a)c17).e.size() > 1) {
                            String s27 = ((B1.a)c17).v(0);
                            s27.getClass();
                            switch(s27) {
                                case "hChain": {
                                    f.M(0, s0, m0, ((B1.a)c17));
                                    break;
                                }
                                case "hGuideline": {
                                    B1.c c19 = ((B1.a)c17).o(1);
                                    if(c19 instanceof B1.g) {
                                        String s29 = ((B1.g)c19).x("id");
                                        if(s29 != null) {
                                            f.Q(0, s0, s29, ((B1.g)c19));
                                        }
                                    }
                                    break;
                                }
                                case "vChain": {
                                    f.M(1, s0, m0, ((B1.a)c17));
                                    break;
                                }
                                case "vGuideline": {
                                    B1.c c18 = ((B1.a)c17).o(1);
                                    if(c18 instanceof B1.g) {
                                        String s28 = ((B1.g)c18).x("id");
                                        if(s28 != null) {
                                            f.Q(1, s0, s28, ((B1.g)c18));
                                        }
                                    }
                                }
                            }
                        }
                    }
                    continue;
                }
                case "Variables": {
                    if(!(c0 instanceof B1.g)) {
                        continue;
                    }
                    B1.g g3 = (B1.g)c0;
                    Iterator iterator11 = g3.z().iterator();
                    while(true) {
                        if(!iterator11.hasNext()) {
                            break alab1;
                        }
                        Object object8 = iterator11.next();
                        String s31 = (String)object8;
                        B1.c c21 = g3.p(s31);
                        if(c21 instanceof B1.e) {
                            Integer integer1 = c21.f();
                            ((HashMap)m0.b).put(s31, integer1);
                        }
                        else if(!(c21 instanceof B1.g)) {
                        }
                        else if(((B1.g)c21).y("from") && ((B1.g)c21).y("to")) {
                            float f42 = m0.h(((B1.g)c21).p("from"));
                            float f43 = m0.h(((B1.g)c21).p("to"));
                            String s32 = ((B1.g)c21).x("prefix");
                            String s33 = ((B1.g)c21).x("postfix");
                            HashMap hashMap1 = (HashMap)m0.c;
                            if(hashMap1.containsKey(s31)) {
                                hashMap1.get(s31);
                            }
                            C1.c c22 = new C1.c();  // 初始化器: Ljava/lang/Object;-><init>()V
                            c22.a = false;
                            c22.d = 0.0f;
                            if(s32 == null) {
                                s32 = "";
                            }
                            c22.b = s32;
                            if(s33 == null) {
                                s33 = "";
                            }
                            c22.c = s33;
                            c22.e = f43;
                            hashMap1.put(s31, c22);
                            HashMap hashMap2 = (HashMap)m0.d;
                            ArrayList arrayList1 = new ArrayList();
                            int v11 = (int)f42;
                            int v12 = (int)f43;
                            int v13 = v11;
                            while(v11 <= v12) {
                                arrayList1.add(c22.b + v13 + c22.c);
                                ++v13;
                                ++v11;
                            }
                            hashMap2.put(s31, arrayList1);
                        }
                        else if(((B1.g)c21).y("from") && ((B1.g)c21).y("step")) {
                            float f44 = m0.h(((B1.g)c21).p("from"));
                            float f45 = m0.h(((B1.g)c21).p("step"));
                            HashMap hashMap3 = (HashMap)m0.c;
                            if(hashMap3.containsKey(s31)) {
                                hashMap3.get(s31);
                            }
                            C1.e e2 = new C1.e();  // 初始化器: Ljava/lang/Object;-><init>()V
                            e2.a = f45;
                            e2.b = f44;
                            hashMap3.put(s31, e2);
                        }
                        else {
                            if(((B1.g)c21).y("ids")) {
                                B1.c c23 = ((B1.g)c21).p("ids");
                                if(!(c23 instanceof B1.a)) {
                                    throw new B1.h("no array found for key <ids>, found [" + c23.g() + "] : " + c23, ((B1.g)c21));
                                }
                                B1.a a6 = (B1.a)c23;
                                ArrayList arrayList2 = new ArrayList();
                                for(int v14 = 0; v14 < a6.e.size(); ++v14) {
                                    arrayList2.add(a6.v(v14));
                                }
                                ((HashMap)m0.d).put(s31, arrayList2);
                                continue;
                            }
                            if(((B1.g)c21).y("tag")) {
                                String s34 = ((B1.g)c21).w("tag");
                                ArrayList arrayList3 = s0.e.containsKey(s34) ? ((ArrayList)s0.e.get(s34)) : null;
                                ((HashMap)m0.d).put(s31, arrayList3);
                            }
                        }
                    }
                }
                default: {
                    if(c0 instanceof B1.g) {
                        String s2 = null;
                        B1.g g1 = (B1.g)c0;
                        for(Object object1: g1.z()) {
                            if(((String)object1).equals("type")) {
                                s2 = g1.w("type");
                                break;
                            }
                        }
                        if(s2 == null) {
                            f.R(s0, m0, s1, g1);
                        }
                        else {
                            switch(s2) {
                                case "barrier": {
                                    boolean z = s0.b;
                                    b b0 = s0.b(s1);
                                    if(b0.c == null || !(b0.c instanceof D1.b)) {
                                        D1.b b1 = new D1.b(s0, 5);  // 初始化器: LC1/g;-><init>(Lx1/s;I)V
                                        b1.n0 = 4;
                                        b0.c = b1;
                                        b0.b(b1.a());
                                    }
                                    D1.b b2 = (D1.b)b0.c;
                                    for(Object object3: g1.z()) {
                                        String s7 = (String)object3;
                                        s7.getClass();
                                    alab2:
                                        switch(s7) {
                                            case "contains": {
                                                B1.c c5 = g1.u(s7);
                                                B1.a a1 = c5 instanceof B1.a ? ((B1.a)c5) : null;
                                                if(a1 == null) {
                                                    continue;
                                                }
                                                for(int v2 = 0; true; ++v2) {
                                                    if(v2 >= a1.e.size()) {
                                                        break alab2;
                                                    }
                                                    b2.q(new Object[]{s0.b(a1.o(v2).d())});
                                                }
                                            }
                                            case "direction": {
                                                String s8 = g1.w(s7);
                                                s8.getClass();
                                                switch(s8) {
                                                    case "bottom": {
                                                        b2.n0 = 6;
                                                        break;
                                                    }
                                                    case "end": {
                                                        b2.n0 = z ? 2 : 1;
                                                        break;
                                                    }
                                                    case "left": {
                                                        b2.n0 = 1;
                                                        break;
                                                    }
                                                    case "right": {
                                                        b2.n0 = 2;
                                                        break;
                                                    }
                                                    case "start": {
                                                        b2.n0 = z ? 1 : 2;
                                                        break;
                                                    }
                                                    case "top": {
                                                        b2.n0 = 5;
                                                    }
                                                }
                                                continue;
                                            }
                                            case "margin": {
                                                B1.c c4 = g1.u(s7);
                                                float f18 = c4 instanceof B1.e ? c4.e() : NaNf;
                                                if(Float.isNaN(f18)) {
                                                    continue;
                                                }
                                                b2.l(s0.a.e(f18));
                                            }
                                        }
                                    }
                                    break;
                                }
                                case "column": {
                                    goto label_199;
                                }
                                case "grid": 
                                case "row": {
                                label_199:
                                    b b3 = s0.b(s1);
                                    if(b3.c == null || !(b3.c instanceof D1.f)) {
                                        switch(s2.charAt(0)) {
                                            case 99: {
                                                v3 = 11;
                                                break;
                                            }
                                            case 0x72: {
                                                v3 = 10;
                                                break;
                                            }
                                            default: {
                                                v3 = 9;
                                            }
                                        }
                                        D1.f f19 = new D1.f(s0, v3);
                                        b3.c = f19;
                                        b3.b(f19.a());
                                    }
                                    D1.f f20 = (D1.f)b3.c;
                                    for(Object object4: g1.z()) {
                                        String s9 = (String)object4;
                                        s9.getClass();
                                        switch(s9) {
                                            case "columnWeights": {
                                                goto label_308;
                                            }
                                            case "columns": {
                                                goto label_304;
                                            }
                                            case "contains": {
                                                goto label_243;
                                            }
                                            case "flags": {
                                                goto label_262;
                                            }
                                            case "hGap": {
                                                goto label_252;
                                            }
                                            case "orientation": {
                                                f20.s0 = g1.p(s9).f();
                                                continue;
                                            }
                                            case "padding": {
                                                goto label_221;
                                            }
                                            case "rowWeights": {
                                                goto label_300;
                                            }
                                            case "rows": {
                                                goto label_255;
                                            }
                                            case "skips": {
                                                goto label_292;
                                            }
                                            case "spans": {
                                                goto label_296;
                                            }
                                            case "vGap": {
                                                goto label_259;
                                            }
                                        }
                                        f.h(g1, s0.b(s1), m0, s9, s0);
                                        continue;
                                    label_221:
                                        B1.c c6 = g1.p(s9);
                                        if(!(c6 instanceof B1.a) || ((B1.a)c6).e.size() <= 1) {
                                            f21 = (float)c6.f();
                                            f24 = f21;
                                            f23 = f24;
                                            f22 = f23;
                                        }
                                        else {
                                            f21 = (float)((B1.a)c6).s(0);
                                            f22 = (float)((B1.a)c6).s(1);
                                            if(((B1.a)c6).e.size() > 2) {
                                                f23 = (float)((B1.a)c6).s(2);
                                                try {
                                                    f24 = (float)((B1.a)c6).s(3);
                                                }
                                                catch(ArrayIndexOutOfBoundsException unused_ex) {
                                                    f24 = 0.0f;
                                                }
                                            }
                                            else {
                                                f23 = f21;
                                                f24 = f22;
                                            }
                                        }
                                        f20.o0 = Math.round(s0.a.e(f21));
                                        f20.q0 = Math.round(s0.a.e(f22));
                                        f20.p0 = Math.round(s0.a.e(f23));
                                        f20.r0 = Math.round(s0.a.e(f24));
                                        continue;
                                    label_243:
                                        B1.c c7 = g1.u(s9);
                                        B1.a a2 = c7 instanceof B1.a ? ((B1.a)c7) : null;
                                        if(a2 != null) {
                                            for(int v4 = 0; v4 < a2.e.size(); ++v4) {
                                                f20.q(new Object[]{s0.b(a2.o(v4).d())});
                                            }
                                            continue;
                                        label_252:
                                            float f25 = g1.p(s9).e();
                                            f20.v0 = s0.a.e(f25);
                                            continue;
                                        label_255:
                                            int v5 = g1.p(s9).f();
                                            if(v5 > 0 && f20.l0 != 11) {
                                                f20.t0 = v5;
                                                continue;
                                            label_259:
                                                float f26 = g1.p(s9).e();
                                                f20.w0 = s0.a.e(f26);
                                                continue;
                                                try {
                                                label_262:
                                                    B1.c c8 = g1.p(s9);
                                                    if(c8 instanceof B1.e) {
                                                        v6 = c8.f();
                                                        s10 = "";
                                                    }
                                                    else {
                                                        s10 = c8.d();
                                                        goto label_272;
                                                    }
                                                    goto label_273;
                                                }
                                                catch(Exception exception0) {
                                                }
                                                System.err.println("Error parsing grid flags " + exception0);
                                                s10 = "";
                                            label_272:
                                                v6 = 0;
                                            label_273:
                                                if(s10 == null || s10.isEmpty()) {
                                                    f20.B0 = v6;
                                                }
                                                else {
                                                    f20.getClass();
                                                    if(s10.isEmpty()) {
                                                        continue;
                                                    }
                                                    String[] arr_s = s10.split("\\|");
                                                    f20.B0 = 0;
                                                    for(int v7 = 0; v7 < arr_s.length; ++v7) {
                                                        String s11 = arr_s[v7].toLowerCase();
                                                        s11.getClass();
                                                        if(s11.equals("subgridbycolrow")) {
                                                            f20.B0 |= 1;
                                                        }
                                                        else if(s11.equals("spansrespectwidgetorder")) {
                                                            f20.B0 |= 2;
                                                        }
                                                    }
                                                }
                                                continue;
                                            label_292:
                                                String s12 = g1.p(s9).d();
                                                if(s12 != null && s12.contains(":")) {
                                                    f20.A0 = s12;
                                                    continue;
                                                label_296:
                                                    String s13 = g1.p(s9).d();
                                                    if(s13 != null && s13.contains(":")) {
                                                        f20.z0 = s13;
                                                        continue;
                                                    label_300:
                                                        String s14 = g1.p(s9).d();
                                                        if(s14 != null && s14.contains(",")) {
                                                            f20.x0 = s14;
                                                            continue;
                                                        label_304:
                                                            int v8 = g1.p(s9).f();
                                                            if(v8 > 0 && f20.l0 != 10) {
                                                                f20.u0 = v8;
                                                                continue;
                                                            label_308:
                                                                String s15 = g1.p(s9).d();
                                                                if(s15 != null && s15.contains(",")) {
                                                                    f20.y0 = s15;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    break;
                                }
                                case "hChain": 
                                case "vChain": {
                                    D1.h h0 = s2.charAt(0) == 104 ? ((D1.h)s0.e(1)) : ((i)s0.e(2));
                                    h0.a = s1;
                                    Iterator iterator2 = g1.z().iterator();
                                    while(iterator2.hasNext()) {
                                        Object object2 = iterator2.next();
                                        String s3 = (String)object2;
                                        s3.getClass();
                                        switch(s3) {
                                            case "bottom": {
                                                iterator4 = iterator2;
                                                f.N(g1, h0, m0, s3, s0);
                                                break;
                                            }
                                            case "contains": {
                                                B1.c c1 = g1.p(s3);
                                                if(c1 instanceof B1.a) {
                                                    B1.a a0 = (B1.a)c1;
                                                    if(a0.e.size() >= 1) {
                                                        int v = 0;
                                                        while(v < a0.e.size()) {
                                                            B1.c c2 = a0.o(v);
                                                            if(!(c2 instanceof B1.a)) {
                                                                iterator3 = iterator2;
                                                                v1 = v;
                                                                h0.q(new Object[]{c2.d()});
                                                            }
                                                            else if(((B1.a)c2).e.size() > 0) {
                                                                String s4 = ((B1.a)c2).o(0).d();
                                                                iterator3 = iterator2;
                                                                switch(((B1.a)c2).e.size()) {
                                                                    case 2: {
                                                                        f3 = ((B1.a)c2).q(1);
                                                                        f = NaNf;
                                                                        f1 = NaNf;
                                                                        f2 = NaNf;
                                                                        f4 = NaNf;
                                                                        break;
                                                                    }
                                                                    case 3: {
                                                                        f5 = ((B1.a)c2).q(1);
                                                                        float f6 = ((B1.a)c2).q(2);
                                                                        f = s0.a.e(f6);
                                                                        f4 = f;
                                                                        f3 = f5;
                                                                        f1 = NaNf;
                                                                        f2 = NaNf;
                                                                        break;
                                                                    }
                                                                    case 4: {
                                                                        f5 = ((B1.a)c2).q(1);
                                                                        float f7 = ((B1.a)c2).q(2);
                                                                        float f8 = s0.a.e(f7);
                                                                        float f9 = ((B1.a)c2).q(3);
                                                                        f = s0.a.e(f9);
                                                                        f4 = f8;
                                                                        f3 = f5;
                                                                        f1 = NaNf;
                                                                        f2 = NaNf;
                                                                        break;
                                                                    }
                                                                    case 6: {
                                                                        float f10 = ((B1.a)c2).q(1);
                                                                        float f11 = ((B1.a)c2).q(2);
                                                                        float f12 = s0.a.e(f11);
                                                                        float f13 = ((B1.a)c2).q(3);
                                                                        float f14 = s0.a.e(f13);
                                                                        float f15 = ((B1.a)c2).q(4);
                                                                        float f16 = s0.a.e(f15);
                                                                        float f17 = ((B1.a)c2).q(5);
                                                                        f2 = s0.a.e(f17);
                                                                        f = f14;
                                                                        f4 = f12;
                                                                        f3 = f10;
                                                                        f1 = f16;
                                                                        break;
                                                                    }
                                                                    default: {
                                                                        f = NaNf;
                                                                        f1 = NaNf;
                                                                        f2 = NaNf;
                                                                        f3 = NaNf;
                                                                        f4 = NaNf;
                                                                    }
                                                                }
                                                                h0.q(new Object[]{s4});
                                                                String s5 = s4.toString();
                                                                if(Float.isNaN(f3)) {
                                                                    v1 = v;
                                                                }
                                                                else {
                                                                    v1 = v;
                                                                    h0.o0.put(s5, f3);
                                                                }
                                                                if(!Float.isNaN(f4)) {
                                                                    h0.p0.put(s5, f4);
                                                                }
                                                                if(!Float.isNaN(f)) {
                                                                    h0.q0.put(s5, f);
                                                                }
                                                                if(!Float.isNaN(f1)) {
                                                                    if(h0.r0 == null) {
                                                                        h0.r0 = new HashMap();
                                                                    }
                                                                    h0.r0.put(s5, f1);
                                                                }
                                                                if(!Float.isNaN(f2)) {
                                                                    if(h0.s0 == null) {
                                                                        h0.s0 = new HashMap();
                                                                    }
                                                                    h0.s0.put(s5, f2);
                                                                }
                                                            }
                                                            else {
                                                                iterator3 = iterator2;
                                                                v1 = v;
                                                            }
                                                            v = v1 + 1;
                                                            iterator2 = iterator3;
                                                        }
                                                        iterator4 = iterator2;
                                                        break;
                                                    }
                                                }
                                                PrintStream printStream0 = System.err;
                                                StringBuilder stringBuilder0 = U4.x.p(s1, " contains should be an array \"");
                                                stringBuilder0.append(c1.d());
                                                stringBuilder0.append("\"");
                                                printStream0.println(stringBuilder0.toString());
                                                continue label_1;
                                            }
                                            case "end": 
                                            case "left": 
                                            case "right": 
                                            case "top": {
                                                iterator4 = iterator2;
                                                f.N(g1, h0, m0, s3, s0);
                                                break;
                                            }
                                            case "start": {
                                                iterator4 = iterator2;
                                                f.N(g1, h0, m0, s3, s0);
                                                break;
                                            }
                                            case "style": {
                                                B1.c c3 = g1.p(s3);
                                                if(!(c3 instanceof B1.a) || ((B1.a)c3).e.size() <= 1) {
                                                    s6 = c3.d();
                                                }
                                                else {
                                                    s6 = ((B1.a)c3).v(0);
                                                    h0.n0 = ((B1.a)c3).q(1);
                                                }
                                                s6.getClass();
                                                if(s6.equals("packed")) {
                                                    h0.t0 = C1.i.c;
                                                }
                                                else if(s6.equals("spread_inside")) {
                                                    h0.t0 = C1.i.b;
                                                }
                                                else {
                                                    h0.t0 = C1.i.a;
                                                }
                                                iterator4 = iterator2;
                                                break;
                                            }
                                            default: {
                                                iterator4 = iterator2;
                                                break;
                                            }
                                        }
                                        iterator2 = iterator4;
                                    }
                                    break;
                                }
                                case "hFlow": 
                                case "vFlow": {
                                    boolean z1 = s2.charAt(0) == 0x76;
                                    b b4 = s0.b(s1);
                                    if(b4.c == null || !(b4.c instanceof D1.e)) {
                                        D1.e e0 = z1 ? new D1.e(s0, 8) : new D1.e(s0, 7);
                                        b4.c = e0;
                                        b4.b(e0.a());
                                    }
                                    D1.e e1 = (D1.e)b4.c;
                                    Iterator iterator7 = g1.z().iterator();
                                    while(iterator7.hasNext()) {
                                        Object object5 = iterator7.next();
                                        String s16 = (String)object5;
                                        s16.getClass();
                                        switch(s16.hashCode()) {
                                            case -1254185091: {
                                                iterator8 = iterator7;
                                                if(s16.equals("hAlign")) {
                                                    String s17 = g1.p(s16).d();
                                                    s17.getClass();
                                                    if(s17.equals("end")) {
                                                        e1.z0 = 1;
                                                    }
                                                    else if(s17.equals("start")) {
                                                        e1.z0 = 0;
                                                    }
                                                    else {
                                                        e1.z0 = 2;
                                                    }
                                                }
                                                else {
                                                    f.h(g1, s0.b(s1), m0, s16, s0);
                                                }
                                                break;
                                            }
                                            case 0xB6402E29: {
                                                iterator8 = iterator7;
                                                if(s16.equals("hStyle")) {
                                                    B1.c c9 = g1.p(s16);
                                                    if(!(c9 instanceof B1.a) || ((B1.a)c9).e.size() <= 1) {
                                                        s19 = c9.d();
                                                        s18 = "";
                                                        s20 = "";
                                                    }
                                                    else {
                                                        s18 = ((B1.a)c9).v(0);
                                                        s19 = ((B1.a)c9).v(1);
                                                        s20 = ((B1.a)c9).e.size() > 2 ? ((B1.a)c9).v(2) : "";
                                                    }
                                                    if(!s19.equals("")) {
                                                        e1.v0 = C1.i.a(s19);
                                                    }
                                                    if(!s18.equals("")) {
                                                        e1.w0 = C1.i.a(s18);
                                                    }
                                                    if(!s20.equals("")) {
                                                        e1.x0 = C1.i.a(s20);
                                                    }
                                                }
                                                else {
                                                    f.h(g1, s0.b(s1), m0, s16, s0);
                                                    break;
                                                }
                                                break;
                                            }
                                            case -1198076529: {
                                                iterator8 = iterator7;
                                                if(s16.equals("hFlowBias")) {
                                                    B1.c c10 = g1.p(s16);
                                                    if(!(c10 instanceof B1.a) || ((B1.a)c10).e.size() <= 1) {
                                                        float1 = c10.e();
                                                        float0 = 0.5f;
                                                        float2 = 0.5f;
                                                    }
                                                    else {
                                                        float0 = ((B1.a)c10).q(0);
                                                        float1 = ((B1.a)c10).q(1);
                                                        float2 = ((B1.a)c10).e.size() > 2 ? ((B1.a)c10).q(2) : 0.5f;
                                                    }
                                                    try {
                                                        e1.h = (float)float1;
                                                        if(((float)float0) != 0.5f) {
                                                            e1.K0 = (float)float0;
                                                        }
                                                        if(((float)float2) != 0.5f) {
                                                            e1.L0 = (float)float2;
                                                        }
                                                    }
                                                    catch(NumberFormatException unused_ex) {
                                                    }
                                                }
                                                else {
                                                    f.h(g1, s0.b(s1), m0, s16, s0);
                                                    break;
                                                }
                                                break;
                                            }
                                            case 0xCD22802F: {
                                                iterator8 = iterator7;
                                                if(s16.equals("vAlign")) {
                                                    String s21 = g1.p(s16).d();
                                                    s21.getClass();
                                                    switch(s21) {
                                                        case "baseline": {
                                                            e1.y0 = 3;
                                                            break;
                                                        }
                                                        case "bottom": {
                                                            e1.y0 = 1;
                                                            break;
                                                        }
                                                        case "top": {
                                                            e1.y0 = 0;
                                                            break;
                                                        }
                                                        default: {
                                                            e1.y0 = 2;
                                                        }
                                                    }
                                                }
                                                else {
                                                    f.h(g1, s0.b(s1), m0, s16, s0);
                                                }
                                                break;
                                            }
                                            case 0xCE2406DB: {
                                                iterator8 = iterator7;
                                                if(s16.equals("vStyle")) {
                                                    B1.c c11 = g1.p(s16);
                                                    if(!(c11 instanceof B1.a) || ((B1.a)c11).e.size() <= 1) {
                                                        s23 = c11.d();
                                                        s22 = "";
                                                        s24 = "";
                                                    }
                                                    else {
                                                        s22 = ((B1.a)c11).v(0);
                                                        s23 = ((B1.a)c11).v(1);
                                                        s24 = ((B1.a)c11).e.size() > 2 ? ((B1.a)c11).v(2) : "";
                                                    }
                                                    if(!s23.equals("")) {
                                                        e1.s0 = C1.i.a(s23);
                                                    }
                                                    if(!s22.equals("")) {
                                                        e1.t0 = C1.i.a(s22);
                                                    }
                                                    if(!s24.equals("")) {
                                                        e1.u0 = C1.i.a(s24);
                                                    }
                                                }
                                                else {
                                                    f.h(g1, s0.b(s1), m0, s16, s0);
                                                    break;
                                                }
                                                break;
                                            }
                                            case 0xCFF03C11: {
                                                iterator8 = iterator7;
                                                if(s16.equals("padding")) {
                                                    B1.c c12 = g1.p(s16);
                                                    if(!(c12 instanceof B1.a) || ((B1.a)c12).e.size() <= 1) {
                                                        f32 = (float)c12.f();
                                                        f31 = f32;
                                                        f28 = f31;
                                                        f33 = f28;
                                                    }
                                                    else {
                                                        float f27 = (float)((B1.a)c12).s(0);
                                                        f28 = (float)((B1.a)c12).s(1);
                                                        float f29 = f27;
                                                        if(((B1.a)c12).e.size() > 2) {
                                                            float f30 = (float)((B1.a)c12).s(2);
                                                            try {
                                                                f31 = f30;
                                                                f32 = f29;
                                                                f33 = (float)((B1.a)c12).s(3);
                                                                f31 = f30;
                                                                f32 = f29;
                                                            }
                                                            catch(ArrayIndexOutOfBoundsException unused_ex) {
                                                                f33 = 0.0f;
                                                            }
                                                        }
                                                        else {
                                                            f33 = f28;
                                                            f32 = f29;
                                                            f31 = f32;
                                                        }
                                                    }
                                                    e1.C0 = Math.round(s0.a.e(f32));
                                                    e1.E0 = Math.round(s0.a.e(f28));
                                                    e1.D0 = Math.round(s0.a.e(f31));
                                                    e1.F0 = Math.round(s0.a.e(f33));
                                                }
                                                else {
                                                    f.h(g1, s0.b(s1), m0, s16, s0);
                                                }
                                                break;
                                            }
                                            case 0xD454DF9D: {
                                                iterator8 = iterator7;
                                                if(s16.equals("vFlowBias")) {
                                                    B1.c c13 = g1.p(s16);
                                                    if(!(c13 instanceof B1.a) || ((B1.a)c13).e.size() <= 1) {
                                                        float4 = c13.e();
                                                        float6 = 0.5f;
                                                        float5 = 0.5f;
                                                    }
                                                    else {
                                                        Float float3 = ((B1.a)c13).q(0);
                                                        float4 = ((B1.a)c13).q(1);
                                                        float5 = ((B1.a)c13).e.size() <= 2 ? 0.5f : ((B1.a)c13).q(2);
                                                        float6 = float3;
                                                    }
                                                    try {
                                                        e1.i = (float)float4;
                                                        if(((float)float6) != 0.5f) {
                                                            e1.I0 = (float)float6;
                                                        }
                                                        if(((float)float5) != 0.5f) {
                                                            e1.J0 = (float)float5;
                                                        }
                                                    }
                                                    catch(NumberFormatException unused_ex) {
                                                    }
                                                }
                                                else {
                                                    f.h(g1, s0.b(s1), m0, s16, s0);
                                                }
                                                break;
                                            }
                                            case 0xDE2D761F: {
                                                iterator8 = iterator7;
                                                if(s16.equals("contains")) {
                                                    B1.c c14 = g1.p(s16);
                                                    if(c14 instanceof B1.a) {
                                                        B1.a a3 = (B1.a)c14;
                                                        if(a3.e.size() < 1) {
                                                            c15 = c14;
                                                            goto label_524;
                                                        }
                                                        else {
                                                            int v9 = 0;
                                                            while(v9 < a3.e.size()) {
                                                                B1.c c16 = a3.o(v9);
                                                                if(!(c16 instanceof B1.a)) {
                                                                    a4 = a3;
                                                                    e1.q(new Object[]{c16.d()});
                                                                }
                                                                else if(((B1.a)c16).e.size() > 0) {
                                                                    String s25 = ((B1.a)c16).o(0).d();
                                                                    a4 = a3;
                                                                    switch(((B1.a)c16).e.size()) {
                                                                        case 2: {
                                                                            f34 = ((B1.a)c16).q(1);
                                                                            f35 = NaNf;
                                                                            f36 = NaNf;
                                                                            break;
                                                                        }
                                                                        case 3: {
                                                                            f34 = ((B1.a)c16).q(1);
                                                                            float f37 = ((B1.a)c16).q(2);
                                                                            f35 = s0.a.e(f37);
                                                                            f36 = f35;
                                                                            break;
                                                                        }
                                                                        case 4: {
                                                                            float f38 = ((B1.a)c16).q(1);
                                                                            float f39 = ((B1.a)c16).q(2);
                                                                            float f40 = s0.a.e(f39);
                                                                            float f41 = ((B1.a)c16).q(3);
                                                                            f36 = f40;
                                                                            f35 = s0.a.e(f41);
                                                                            f34 = f38;
                                                                            break;
                                                                        }
                                                                        default: {
                                                                            f34 = NaNf;
                                                                            f35 = NaNf;
                                                                            f36 = NaNf;
                                                                            break;
                                                                        }
                                                                    }
                                                                    e1.q(new Object[]{s25});
                                                                    if(!Float.isNaN(f34)) {
                                                                        if(e1.o0 == null) {
                                                                            e1.o0 = new HashMap();
                                                                        }
                                                                        e1.o0.put(s25, f34);
                                                                    }
                                                                    if(!Float.isNaN(f36)) {
                                                                        if(e1.p0 == null) {
                                                                            e1.p0 = new HashMap();
                                                                        }
                                                                        e1.p0.put(s25, f36);
                                                                    }
                                                                    if(!Float.isNaN(f35)) {
                                                                        if(e1.q0 == null) {
                                                                            e1.q0 = new HashMap();
                                                                        }
                                                                        e1.q0.put(s25, f35);
                                                                    }
                                                                }
                                                                else {
                                                                    a4 = a3;
                                                                }
                                                                ++v9;
                                                                a3 = a4;
                                                            }
                                                            break;
                                                        }
                                                        goto label_523;
                                                    }
                                                    else {
                                                    label_523:
                                                        c15 = c14;
                                                    }
                                                label_524:
                                                    PrintStream printStream1 = System.err;
                                                    StringBuilder stringBuilder1 = U4.x.p(s1, " contains should be an array \"");
                                                    stringBuilder1.append(c15.d());
                                                    stringBuilder1.append("\"");
                                                    printStream1.println(stringBuilder1.toString());
                                                    continue label_1;
                                                }
                                                f.h(g1, s0.b(s1), m0, s16, s0);
                                                break;
                                            }
                                            case -488900360: {
                                                iterator8 = iterator7;
                                                if(s16.equals("maxElement")) {
                                                    e1.G0 = g1.p(s16).f();
                                                    break;
                                                }
                                                f.h(g1, s0.b(s1), m0, s16, s0);
                                                break;
                                            }
                                            case 0x305D4E: {
                                                iterator8 = iterator7;
                                                if(s16.equals("hGap")) {
                                                    e1.B0 = g1.p(s16).f();
                                                    break;
                                                }
                                                f.h(g1, s0.b(s1), m0, s16, s0);
                                                break;
                                            }
                                            case 0x368F3A: {
                                                iterator8 = iterator7;
                                                if(s16.equals("type")) {
                                                    e1.H0 = g1.p(s16).d().equals("hFlow") ? 0 : 1;
                                                    break;
                                                }
                                                f.h(g1, s0.b(s1), m0, s16, s0);
                                                break;
                                            }
                                            case 0x36BA80: {
                                                iterator8 = iterator7;
                                                if(s16.equals("vGap")) {
                                                    e1.A0 = g1.p(s16).f();
                                                    break;
                                                }
                                                f.h(g1, s0.b(s1), m0, s16, s0);
                                                break;
                                            }
                                            case 0x37D04A: {
                                                iterator8 = iterator7;
                                                if(s16.equals("wrap")) {
                                                    String s26 = g1.p(s16).d();
                                                    e1.r0 = C1.j.a.containsKey(s26) ? ((int)(((Integer)C1.j.a.get(s26)))) : -1;
                                                    break;
                                                }
                                                f.h(g1, s0.b(s1), m0, s16, s0);
                                                break;
                                            }
                                            default: {
                                                iterator8 = iterator7;
                                                f.h(g1, s0.b(s1), m0, s16, s0);
                                                break;
                                            }
                                        }
                                        iterator7 = iterator8;
                                    }
                                    break;
                                }
                                case "hGuideline": {
                                    f.Q(0, s0, s1, g1);
                                    break;
                                }
                                case "vGuideline": {
                                    f.Q(1, s0, s1, g1);
                                }
                            }
                        }
                    }
                    else {
                        if(!(c0 instanceof B1.e)) {
                            continue;
                        }
                        Integer integer0 = c0.f();
                        ((HashMap)m0.b).put(s1, integer0);
                    }
                }
            }
        }
    }

    public static final void T(Ue.b b0, Ue.a a0, E e0, qf.e e1) {
        q.g(b0, "<this>");
        q.g(a0, "from");
        q.g(e0, "scopeOwner");
        q.g(e1, "name");
        q.f(e1.b(), "asString(...)");
        q.g(((C)e0).e.a.a, "packageFqName");
    }

    public static final boolean U(B2.i i0) {
        if(i0 instanceof D2.H) {
            return true;
        }
        if(i0 instanceof B2.k) {
            ArrayList arrayList0 = ((B2.k)i0).b;
            if(arrayList0 == null || !arrayList0.isEmpty()) {
                for(Object object0: arrayList0) {
                    if(f.U(((B2.i)object0))) {
                        return true;
                    }
                    if(false) {
                        break;
                    }
                }
            }
        }
        return false;
    }

    public static final File V(Uri uri0) {
        if(!q.b(uri0.getScheme(), "file")) {
            throw new IllegalArgumentException(("Uri lacks \'file\' scheme: " + uri0).toString());
        }
        String s = uri0.getPath();
        if(s == null) {
            throw new IllegalArgumentException(("Uri path is null: " + uri0).toString());
        }
        return new File(s);
    }

    public static final Class W(x x0) {
        Class class0 = f.X(x0.w().e());
        if(class0 != null) {
            if(Y.e(x0)) {
                B b0 = g.i(x0);
                return b0 == null || Y.e(b0) || Je.i.G(b0) ? null : class0;
            }
            return class0;
        }
        return null;
    }

    public static final Class X(k k0) {
        if(k0 instanceof e && g.b(k0)) {
            Class class0 = A0.k(((e)k0));
            if(class0 == null) {
                throw new s0("Class object for the class " + ((e)k0).getName() + " cannot be found (classId=" + d.f(((h)k0)) + ')');
            }
            return class0;
        }
        return null;
    }

    public static final Object Y(Context context0, D2.f f0, we.n n0, oe.c c0) {
        G2.a a0 = new G2.a(n0, null);
        if(!(f0 instanceof D2.f)) {
            throw new IllegalArgumentException("The glance ID is not the one of an App Widget");
        }
        Object object0 = M2.f.a.d(context0, M2.h.a, F.p(f0.a), a0, c0);
        return object0 == ne.a.a ? object0 : ie.H.a;
    }

    public static final void a(String s, boolean z, we.k k0, l l0, int v) {
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0x74F02E05);
        int v1 = v | (p0.g(s) ? 4 : 2) | (p0.h(z) ? 0x20 : 16) | (p0.i(k0) ? 0x100 : 0x80);
        if(p0.Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            b0 b00 = p0.N();
            V v2 = androidx.compose.runtime.k.a;
            if(b00 == v2) {
                b00 = w.s(Boolean.valueOf(z));
                p0.l0(b00);
            }
            Ec.g g0 = new Ec.g(k0, b00, 0);
            r0.n n0 = r0.n.a;
            r0.q q0 = r0.a.a(n0, g0);
            p0 p00 = n0.a(M.j.a, r0.d.j, p0, 0);
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
            w.x(p0, p00, P0.j.f);
            w.x(p0, i00, P0.j.e);
            P0.h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h0);
            }
            w.x(p0, q1, P0.j.d);
            c1.n(null, ((int)(((Boolean)b00.getValue()).booleanValue() ? 0x7F080126 : 0x7F080125)), null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0, 0, 0x7FFD);  // drawable:btn_common_check_17_on
            M.c.d(p0, androidx.compose.foundation.layout.d.q(n0, 3.0f));
            N1.b(s, null, e0.T(p0, (((Boolean)b00.getValue()).booleanValue() ? 0x7F06017C : 0x7F060165)), 14.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, v1 & 14 | 0xC00, 0, 0x1FFF2);  // color:green500s_support_high_contrast
            p0.p(true);
            Boolean boolean0 = Boolean.valueOf(z);
            Ec.h h1 = p0.N();
            if((v1 & 0x70) == 0x20 || h1 == v2) {
                h1 = new Ec.h(b00, null, z);
                p0.l0(h1);
            }
            J.d(p0, boolean0, h1);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new z2(s, z, k0, v, 2);
        }
    }

    public static final void b(r0.q q0, Z z0, l l0, int v) {
        q.g(z0, "uiState");
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0xF6D08600);
        int v1 = (p0.g(z0) ? 0x20 : 16) | v;
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
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
            w.x(p0, y0, P0.j.f);
            w.x(p0, i00, P0.j.e);
            P0.h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            w.x(p0, q1, P0.j.d);
            a.a.e(androidx.compose.foundation.layout.a.l(r0.n.a, 16.0f, 0.0f, 2), z0.a, p0, 6);
            M.c.d(p0, androidx.compose.foundation.layout.d.h(r0.n.a, 6.0f));
            Nc.b0.a(androidx.compose.foundation.layout.a.l(r0.n.a, 16.0f, 0.0f, 2), z0.b, p0, 6);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Nc.Y(q0, z0, v, 0);
        }
    }

    public static final void c(l l0, int v) {
        ((androidx.compose.runtime.p)l0).c0(0x4AF006C4);
        if(v == 0 && ((androidx.compose.runtime.p)l0).D()) {
            ((androidx.compose.runtime.p)l0).T();
            goto label_13;
        }
        ((androidx.compose.runtime.p)l0).b0(0xBD7CCD0A);
        ((androidx.compose.runtime.p)l0).b0(0x7076B8D0);
        if(((androidx.compose.runtime.p)l0).a instanceof B2.b) {
            ((androidx.compose.runtime.p)l0).Y();
            if(((androidx.compose.runtime.p)l0).O) {
                ((androidx.compose.runtime.p)l0).l(new D2.y(0, 1));
            }
            else {
                ((androidx.compose.runtime.p)l0).o0();
            }
            A7.d.s(((androidx.compose.runtime.p)l0), true, false, false);
        label_13:
            androidx.compose.runtime.n0 n00 = ((androidx.compose.runtime.p)l0).t();
            if(n00 != null) {
                n00.d = new W0(v);
            }
            return;
        }
        w.m();
        throw null;
    }

    public static final void d(String s, String s1, String s2, String s3, we.a a0, we.a a1, we.a a2, l l0, int v) {
        r0.n n2;
        String s7;
        String s6;
        r0.n n1;
        String s8;
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(2006802897);
        int v1 = v | (p0.g(s) ? 4 : 2) | (p0.g(s1) ? 0x20 : 16) | (p0.g(s2) ? 0x100 : 0x80) | (p0.g(s3) ? 0x800 : 0x400) | (p0.i(a0) ? 0x4000 : 0x2000) | (p0.i(a1) ? 0x20000 : 0x10000) | (p0.i(a2) ? 0x100000 : 0x80000);
        if(p0.Q(v1 & 1, (v1 & 0x92493) != 0x92492)) {
            r0.q q0 = androidx.compose.foundation.layout.a.n(r0.n.a, 0.0f, 0.0f, 0.0f, 8.0f, 7);
            r0.n n0 = r0.n.a;
            M m0 = M.p.d(r0.d.a, false);
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
            P0.h h0 = P0.j.f;
            w.x(p0, m0, h0);
            P0.h h1 = P0.j.e;
            w.x(p0, i00, h1);
            P0.h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            P0.h h3 = P0.j.d;
            w.x(p0, q1, h3);
            r0.q q2 = r0.a.a(androidx.compose.foundation.layout.a.l(androidx.compose.foundation.q.f(d5.n.o(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(n0, 1.0f), 50.0f), T.e.b(4.0f)), e0.T(p0, 0x7F060142), y0.M.a), 10.0f, 0.0f, 2), new Lc.c(21, a0));  // color:gray030s
            Bc.d d0 = p0.N();
            if((v1 & 0x380000) == 0x100000 || d0 == androidx.compose.runtime.k.a) {
                d0 = new Bc.d(19, a2);
                p0.l0(d0);
            }
            r0.q q3 = m3.b(q2, d0);
            r0.h h4 = r0.d.k;
            p0 p00 = n0.a(M.j.a, h4, p0, 0x30);
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
            w.x(p0, p00, h0);
            w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            w.x(p0, q4, h3);
            c1.n(e0.L(androidx.compose.foundation.layout.d.n(n0, 34.0f), 0x7F0604AE), s, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, v1 << 3 & 0x70, 0, 0x7FFC);  // color:white120e
            r0.q q5 = androidx.compose.foundation.layout.a.l(new LayoutWeightElement(1.0f, true), 8.0f, 0.0f, 2);
            y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
            int v4 = p0.P;
            i0 i02 = p0.m();
            r0.q q6 = r0.a.d(p0, q5);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, y0, h0);
            w.x(p0, i02, h1);
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            w.x(p0, q6, h3);
            String s4 = "";
            if(s3 == null || s3.length() == 0 || s3.length() < 10) {
                p0.a0(0x986AFCBC);
                if(s1 == null) {
                    p0.a0(0x986B676A);
                    p0.p(false);
                    n2 = n0;
                }
                else {
                    p0.a0(0x986B676B);
                    if(s2 == null) {
                        s8 = null;
                    }
                    else {
                        if(s3 != null) {
                            s4 = s3;
                        }
                        s8 = v.p0(s2, "<b>ARTISTNAME</b>", s4);
                    }
                    n2 = n0;
                    Cc.E.a(null, s1, s8, null, 0, 13.0f, 0L, 0L, e1.y.i, 2, 0, null, 0.0f, null, null, p0, v1 & 0x70 | 0x36030000, 0, 0xFCD9);
                    p0.p(false);
                }
                p0.p(false);
            }
            else {
                p0.a0(0x98598461);
                if(s2 == null) {
                    p0.a0(0x985A0956);
                    p0.p(false);
                    n1 = n0;
                }
                else {
                    p0.a0(0x985A0957);
                    if(s3.length() > 16) {
                        String s5 = s3.substring(0, 16);
                        q.f(s5, "substring(...)");
                        s6 = s5 + "...";
                    }
                    else {
                        s6 = s3;
                    }
                    Cc.E.a(null, s2, s6, "<b>ARTISTNAME</b>", 0, 13.0f, e0.T(p0, 0x7F06017C), 0L, e1.y.i, 1, 0, null, 0.0f, null, null, p0, v1 >> 3 & 0x70 | 0x36030C00, 0, 0xFC91);  // color:green500s_support_high_contrast
                    if(s1 == null) {
                        s7 = "";
                    }
                    else {
                        s7 = Tf.o.e1(v.p0(s1, "<b>TITLEREPLACE</b>", "")).toString();
                        if(s7 == null) {
                            s7 = "";
                        }
                    }
                    Cc.E.a(null, s7, null, null, 0, 13.0f, e0.T(p0, 0x7F06016D), 0L, null, 0, 0, null, 0.0f, null, null, p0, 0x30000, 0, 0xFF9D);  // color:gray900s
                    n1 = n0;
                    A7.d.v(n1, 2.0f, p0, false);
                }
                p0.p(false);
                n2 = n1;
            }
            p0.p(true);
            r0.q q7 = r0.a.a(H0.b.r(h4, androidx.compose.foundation.layout.d.n(n2, 26.0f)), new Lc.c(22, a1));
            androidx.compose.foundation.q.c(I.Q(0x7F080133, p0, 6), H0.e.Y(p0, 0x7F130AE8), q7, null, null, 0.0f, null, p0, 0, 120);  // drawable:btn_common_delete_26_gray
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new bd.F(s, s1, s2, s3, a0, a1, a2, v);
        }
    }

    public static Object e(Parcel parcel0, Parcelable.Creator parcelable$Creator0) {
        return parcel0.readInt() == 0 ? null : parcelable$Creator0.createFromParcel(parcel0);
    }

    public static void f(Parcel parcel0, Parcelable parcelable0) {
        if(parcelable0 != null) {
            parcel0.writeInt(1);
            parcelable0.writeToParcel(parcel0, 0);
            return;
        }
        parcel0.writeInt(0);
    }

    public static final qf.c g(String s, qf.c c0) {
        return c0.a(qf.e.e(s));
    }

    // This method was un-flattened
    public static void h(B1.g g0, b b0, d5.m m0, String s, s s1) {
        long v;
        s.getClass();
        switch(s) {
            case "alpha": {
                b0.F = m0.h(g0.p(s));
                return;
            }
            case "center": {
                String s3 = g0.w(s);
                b b2 = s3.equals("parent") ? s1.b(0) : s1.b(s3);
                b0.o(b2);
                b0.i(b2);
                b0.p(b2);
                b0.e(b2);
                return;
            }
            case "centerHorizontally": {
                String s4 = g0.w(s);
                b b3 = s4.equals("parent") ? s1.b(0) : s1.b(s4);
                b0.o(b3);
                b0.i(b3);
                return;
            }
            case "centerVertically": {
                String s2 = g0.w(s);
                b b1 = s2.equals("parent") ? s1.b(0) : s1.b(s2);
                b0.p(b1);
                b0.e(b1);
                return;
            }
            case "custom": {
                B1.c c0 = g0.u(s);
                B1.g g1 = c0 instanceof B1.g ? ((B1.g)c0) : null;
                if(g1 != null) {
                    for(Object object0: g1.z()) {
                        String s6 = (String)object0;
                        B1.c c1 = g1.p(s6);
                        if(c1 instanceof B1.e) {
                            float f4 = c1.e();
                            if(b0.i0 == null) {
                                b0.i0 = new HashMap();
                            }
                            b0.i0.put(s6, f4);
                        }
                        else if(c1 instanceof B1.i) {
                            String s7 = c1.d();
                            if(s7.startsWith("#")) {
                                String s8 = s7.substring(1);
                                v = Long.parseLong((s8.length() == 6 ? "FF" + s8 : s7.substring(1)), 16);
                            }
                            else {
                                v = -1L;
                            }
                            if(v != -1L) {
                                b0.h0.put(s6, ((int)v));
                            }
                        }
                    }
                    return;
                }
                break;
            }
            case "hBias": {
                b0.h = m0.h(g0.p(s));
                return;
            }
            case "hRtlBias": {
                float f3 = m0.h(g0.p(s));
                if(!s1.b) {
                    f3 = 1.0f - f3;
                }
                b0.h = f3;
                return;
            }
            case "hWeight": {
                b0.f = m0.h(g0.p(s));
                return;
            }
            case "height": {
                b0.e0 = f.O(g0, s, s1, s1.a);
                return;
            }
            case "motion": {
                B1.c c2 = g0.p(s);
                if(c2 instanceof B1.g) {
                    A1.q q0 = new A1.q(0);
                    q0.e = new int[10];
                    q0.f = new int[10];
                    q0.b = 0;
                    q0.g = new int[10];
                    q0.i = new float[10];
                    q0.c = 0;
                    q0.h = new int[5];
                    q0.j = new String[5];
                    q0.d = 0;
                    for(Object object1: ((B1.g)c2).z()) {
                        String s9 = (String)object1;
                        s9.getClass();
                        switch(s9) {
                            case "easing": {
                                q0.c(603, ((B1.g)c2).w(s9));
                                break;
                            }
                            case "pathArc": {
                            label_138:
                                String s10 = ((B1.g)c2).w(s9);
                                int v2 = 0;
                                while(true) {
                                    if(v2 < 6) {
                                        if(new String[]{"none", "startVertical", "startHorizontal", "flip", "below", "above"}[v2].equals(s10)) {
                                            break;
                                        }
                                        else {
                                            ++v2;
                                            continue;
                                        }
                                    }
                                    v2 = -1;
                                    break;
                                }
                                if(v2 == -1) {
                                    System.err.println("0 pathArc = \'" + s10 + "\'");
                                    continue;
                                }
                                else {
                                    q0.b(607, v2);
                                    break;
                                }
                                q0.c(605, ((B1.g)c2).w(s9));
                                break;
                            }
                            case "quantize": {
                                B1.c c3 = ((B1.g)c2).p(s9);
                                if(c3 instanceof B1.a) {
                                    int v1 = ((B1.a)c3).e.size();
                                    if(v1 <= 0) {
                                        continue;
                                    }
                                    q0.b(610, ((B1.a)c3).s(0));
                                    if(v1 <= 1) {
                                        continue;
                                    }
                                    q0.c(611, ((B1.a)c3).v(1));
                                    if(v1 <= 2) {
                                        continue;
                                    }
                                    q0.a(((B1.a)c3).q(2), 602);
                                    continue;
                                }
                                else {
                                    B1.c c4 = ((B1.g)c2).p(s9);
                                    if(c4 != null) {
                                        q0.b(610, c4.f());
                                        continue;
                                    }
                                    com.iloen.melon.utils.a.n("no int found for key <", s9, ">, found [");
                                    throw new NullPointerException();
                                }
                                goto label_138;
                            }
                            case "relativeTo": {
                                q0.c(605, ((B1.g)c2).w(s9));
                                break;
                            }
                            case "stagger": {
                                q0.a(((B1.g)c2).r(s9), 600);
                            }
                        }
                    }
                    b0.getClass();
                    return;
                }
                break;
            }
            case "pivotX": {
                b0.x = m0.h(g0.p(s));
                return;
            }
            case "pivotY": {
                b0.y = m0.h(g0.p(s));
                return;
            }
            case "rotationX": {
                b0.z = m0.h(g0.p(s));
                return;
            }
            case "rotationY": {
                b0.A = m0.h(g0.p(s));
                return;
            }
            case "rotationZ": {
                b0.B = m0.h(g0.p(s));
                return;
            }
            case "scaleX": {
                b0.G = m0.h(g0.p(s));
                return;
            }
            case "scaleY": {
                b0.H = m0.h(g0.p(s));
                return;
            }
            case "translationX": {
                float f = m0.h(g0.p(s));
                b0.C = s1.a.e(f);
                return;
            }
            case "translationY": {
                float f1 = m0.h(g0.p(s));
                b0.D = s1.a.e(f1);
                return;
            }
            case "translationZ": {
                float f2 = m0.h(g0.p(s));
                b0.E = s1.a.e(f2);
                return;
            }
            case "vBias": {
                b0.i = m0.h(g0.p(s));
                return;
            }
            case "vWeight": {
                b0.g = m0.h(g0.p(s));
                return;
            }
            case "visibility": {
                String s5 = g0.w(s);
                s5.getClass();
                switch(s5) {
                    case "gone": {
                        b0.I = 8;
                        return;
                    }
                    case "invisible": {
                        b0.I = 4;
                        b0.F = 0.0f;
                        return;
                    }
                    case "visible": {
                        b0.I = 0;
                        return;
                    }
                    default: {
                        return;
                    }
                }
            }
            case "width": {
                b0.d0 = f.O(g0, s, s1, s1.a);
                return;
            }
            default: {
                f.N(g0, b0, m0, s, s1);
            }
        }
    }

    public static void i(H4.f f0, Object[] arr_object) {
        if(arr_object != null) {
            int v = 0;
            while(v < arr_object.length) {
                Object object0 = arr_object[v];
                ++v;
                if(object0 == null) {
                    f0.b(v);
                }
                else if(object0 instanceof byte[]) {
                    f0.O(v, ((byte[])object0));
                }
                else if(object0 instanceof Float) {
                    f0.U(((double)((Number)object0).floatValue()), v);
                }
                else if(object0 instanceof Double) {
                    f0.U(((Number)object0).doubleValue(), v);
                }
                else if(object0 instanceof Long) {
                    f0.a(v, ((Number)object0).longValue());
                }
                else if(object0 instanceof Integer) {
                    f0.a(v, ((long)((Number)object0).intValue()));
                }
                else if(object0 instanceof Short) {
                    f0.a(v, ((long)((Number)object0).shortValue()));
                }
                else if(object0 instanceof Byte) {
                    f0.a(v, ((long)((Number)object0).byteValue()));
                }
                else if(object0 instanceof String) {
                    f0.k(v, ((String)object0));
                }
                else {
                    if(!(object0 instanceof Boolean)) {
                        throw new IllegalArgumentException("Cannot bind " + object0 + " at index " + v + " Supported types: Null, ByteArray, Float, Double, Long, Int, Short, Byte, String");
                    }
                    f0.a(v, (((Boolean)object0).booleanValue() ? 1L : 0L));
                }
            }
        }
    }

    public static final Bundle j(m[] arr_m) {
        Bundle bundle0 = new Bundle(arr_m.length);
        for(int v = 0; v < arr_m.length; ++v) {
            m m0 = arr_m[v];
            String s = (String)m0.a;
            Object object0 = m0.b;
            if(object0 == null) {
                bundle0.putString(s, null);
            }
            else if(object0 instanceof Boolean) {
                bundle0.putBoolean(s, ((Boolean)object0).booleanValue());
            }
            else if(object0 instanceof Byte) {
                bundle0.putByte(s, ((Number)object0).byteValue());
            }
            else if(object0 instanceof Character) {
                bundle0.putChar(s, ((Character)object0).charValue());
            }
            else if(object0 instanceof Double) {
                bundle0.putDouble(s, ((Number)object0).doubleValue());
            }
            else if(object0 instanceof Float) {
                bundle0.putFloat(s, ((Number)object0).floatValue());
            }
            else if(object0 instanceof Integer) {
                bundle0.putInt(s, ((Number)object0).intValue());
            }
            else if(object0 instanceof Long) {
                bundle0.putLong(s, ((Number)object0).longValue());
            }
            else if(object0 instanceof Short) {
                bundle0.putShort(s, ((Number)object0).shortValue());
            }
            else if(object0 instanceof Bundle) {
                bundle0.putBundle(s, ((Bundle)object0));
            }
            else if(object0 instanceof CharSequence) {
                bundle0.putCharSequence(s, ((CharSequence)object0));
            }
            else if(object0 instanceof Parcelable) {
                bundle0.putParcelable(s, ((Parcelable)object0));
            }
            else if(object0 instanceof boolean[]) {
                bundle0.putBooleanArray(s, ((boolean[])object0));
            }
            else if(object0 instanceof byte[]) {
                bundle0.putByteArray(s, ((byte[])object0));
            }
            else if(object0 instanceof char[]) {
                bundle0.putCharArray(s, ((char[])object0));
            }
            else if(object0 instanceof double[]) {
                bundle0.putDoubleArray(s, ((double[])object0));
            }
            else if(object0 instanceof float[]) {
                bundle0.putFloatArray(s, ((float[])object0));
            }
            else if(object0 instanceof int[]) {
                bundle0.putIntArray(s, ((int[])object0));
            }
            else if(object0 instanceof long[]) {
                bundle0.putLongArray(s, ((long[])object0));
            }
            else if(object0 instanceof short[]) {
                bundle0.putShortArray(s, ((short[])object0));
            }
            else if(object0 instanceof Object[]) {
                Class class0 = object0.getClass().getComponentType();
                q.d(class0);
                if(Parcelable.class.isAssignableFrom(class0)) {
                    bundle0.putParcelableArray(s, ((Parcelable[])object0));
                }
                else if(String.class.isAssignableFrom(class0)) {
                    bundle0.putStringArray(s, ((String[])object0));
                }
                else if(CharSequence.class.isAssignableFrom(class0)) {
                    bundle0.putCharSequenceArray(s, ((CharSequence[])object0));
                }
                else {
                    if(!Serializable.class.isAssignableFrom(class0)) {
                        throw new IllegalArgumentException("Illegal value array type " + class0.getCanonicalName() + " for key \"" + s + '\"');
                    }
                    bundle0.putSerializable(s, ((Serializable)object0));
                }
            }
            else if(object0 instanceof Serializable) {
                bundle0.putSerializable(s, ((Serializable)object0));
            }
            else if(object0 instanceof IBinder) {
                bundle0.putBinder(s, ((IBinder)object0));
            }
            else if(object0 instanceof Size) {
                bundle0.putSize(s, ((Size)object0));
            }
            else {
                if(!(object0 instanceof SizeF)) {
                    throw new IllegalArgumentException("Illegal value type " + object0.getClass().getCanonicalName() + " for key \"" + s + '\"');
                }
                bundle0.putSizeF(s, ((SizeF)object0));
            }
        }
        return bundle0;
    }

    public static com.google.firebase.messaging.u k(com.google.firebase.messaging.u u0, Me.g g0, Se.n n0, int v) {
        if((v & 2) != 0) {
            n0 = null;
        }
        q.g(u0, "<this>");
        Nc.W0 w00 = new Nc.W0(17, u0, g0);
        ie.j j0 = d3.g.P(ie.k.c, w00);
        cf.a a0 = (cf.a)u0.a;
        return n0 == null ? new com.google.firebase.messaging.u(a0, ((cf.e)u0.b), j0) : new com.google.firebase.messaging.u(a0, new A1.k(u0, g0, n0, 0), j0);
    }

    public static final Object l(Object object0, c c0) {
        if(!(c0 instanceof L) || !g.e(((Me.V)c0))) {
            x x0 = f.B(c0);
            if(x0 != null) {
                Class class0 = f.W(x0);
                return class0 == null ? object0 : f.C(class0, c0).invoke(object0, null);
            }
        }
        return object0;
    }

    public static final Kf.i m(Hf.b0 b00) {
        switch(b00.ordinal()) {
            case 0: {
                return Kf.i.d;
            }
            case 1: {
                return Kf.i.b;
            }
            case 2: {
                return Kf.i.c;
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
    }

    public static final com.google.firebase.messaging.u n(com.google.firebase.messaging.u u0, Ne.h h0) {
        q.g(u0, "<this>");
        q.g(h0, "additionalAnnotations");
        if(h0.isEmpty()) {
            return u0;
        }
        cf.a a0 = (cf.a)u0.a;
        cf.e e0 = (cf.e)u0.b;
        Nc.W0 w00 = new Nc.W0(18, u0, h0);
        return new com.google.firebase.messaging.u(a0, e0, d3.g.P(ie.k.c, w00));
    }

    public abstract Typeface o(Context arg1, R1.d arg2, Resources arg3, int arg4);

    public abstract Typeface p(Context arg1, Z1.i[] arg2, int arg3);

    public Typeface q(Context context0, List list0, int v) {
        throw new IllegalStateException("createFromFontInfoWithFallback must only be called on API 29+");
    }

    public Typeface r(Context context0, Resources resources0, int v, String s, int v1) {
        File file0 = h7.u0.E(context0);
        if(file0 == null) {
            return null;
        }
        try {
            return h7.u0.q(file0, resources0, v) ? Typeface.createFromFile(file0.getPath()) : null;
        }
        catch(RuntimeException unused_ex) {
            return null;
        }
        finally {
            file0.delete();
        }
    }

    public static final He.g s(He.g g0, c c0, boolean z) {
        q.g(c0, "descriptor");
        if(!g.a(c0)) {
            List list0 = c0.D0();
            q.f(list0, "getContextReceiverParameters(...)");
            if(!(list0 instanceof Collection) || !list0.isEmpty()) {
                for(Object object0: list0) {
                    if(g.g(((u)object0).getType())) {
                        return new D(g0, c0, z);
                    }
                    if(false) {
                        break;
                    }
                }
            }
            List list1 = c0.F();
            q.f(list1, "getValueParameters(...)");
            if(!(list1 instanceof Collection) || !list1.isEmpty()) {
                for(Object object1: list1) {
                    x x0 = ((S)object1).getType();
                    q.f(x0, "getType(...)");
                    if(g.g(x0)) {
                        return new D(g0, c0, z);
                    }
                    if(false) {
                        break;
                    }
                }
            }
            x x1 = c0.getReturnType();
            if(x1 == null || !g.c(x1)) {
                x x2 = f.B(c0);
                if(x2 == null || !g.g(x2)) {
                    return g0;
                }
            }
        }
        return new D(g0, c0, z);
    }

    public abstract String t(byte[] arg1, int arg2, int arg3);

    public static final boolean u(String s, String s1) {
        q.g(s, "current");
        if(s.equals(s1)) {
            return true;
        }
        if(s.length() != 0) {
            int v = 0;
            int v1 = 0;
            for(int v2 = 0; v < s.length(); ++v2) {
                int v3 = s.charAt(v);
                if(v2 == 0 && v3 != 40) {
                    return false;
                }
                switch(v3) {
                    case 40: {
                        ++v1;
                        break;
                    }
                    case 41: {
                        --v1;
                        if(v1 == 0 && v2 != s.length() - 1) {
                            return false;
                        }
                    }
                }
                ++v;
            }
            if(v1 == 0) {
                String s2 = s.substring(1, s.length() - 1);
                q.f(s2, "substring(...)");
                return q.b(Tf.o.e1(s2).toString(), s1);
            }
        }
        return false;
    }

    public abstract int v(String arg1, byte[] arg2, int arg3, int arg4);

    public static Ne.b w(Ne.h h0, qf.c c0) {
        q.g(c0, "fqName");
        for(Object object0: h0) {
            if(q.b(((Ne.b)object0).b(), c0)) {
                return (Ne.b)object0;
            }
            if(false) {
                break;
            }
        }
        return null;
    }

    public Z1.i x(Z1.i[] arr_i, int v) {
        new R6.d(2);
        Z1.i i0 = null;
        int v1 = 0x7FFFFFFF;
        for(int v2 = 0; v2 < arr_i.length; ++v2) {
            Z1.i i1 = arr_i[v2];
            int v3 = Math.abs(i1.c - ((v & 1) == 0 ? 400 : 700)) * 2 + (i1.d == ((v & 2) != 0) ? 0 : 1);
            if(i0 == null || v1 > v3) {
                i0 = i1;
                v1 = v3;
            }
        }
        return i0;
    }

    public static final HashSet y(Iterable iterable0) {
        HashSet hashSet0 = new HashSet();
        for(Object object0: iterable0) {
            Iterable iterable1 = ((Af.p)object0).d();
            if(iterable1 == null) {
                return null;
            }
            je.u.U(hashSet0, iterable1);
        }
        return hashSet0;
    }

    public static J.g z(K k0, a0 a00, l l0, int v, int v1) {
        Q.D d0 = new Q.D();  // 初始化器: Ljava/lang/Object;-><init>()V
        G.y y0 = m0.a(l0);
        int v2 = 1;
        if((v1 & 8) != 0) {
            a00 = G.f.q(400.0f, 1, 1.0f);
        }
        r1.c c0 = (r1.c)((androidx.compose.runtime.p)l0).k(k0.h);
        r1.m m0 = (r1.m)((androidx.compose.runtime.p)l0).k(k0.n);
        boolean z = (v & 14 ^ 6) > 4 && ((androidx.compose.runtime.p)l0).g(k0) || (v & 6) == 4;
        boolean z1 = ((androidx.compose.runtime.p)l0).g(y0);
        boolean z2 = ((androidx.compose.runtime.p)l0).g(a00);
        if(((v & 0x70 ^ 0x30) <= 0x20 || !((androidx.compose.runtime.p)l0).g(d0)) && (v & 0x30) != 0x20) {
            v2 = 0;
        }
        boolean z3 = ((androidx.compose.runtime.p)l0).g(c0);
        boolean z4 = ((androidx.compose.runtime.p)l0).g(m0);
        J.g g0 = ((androidx.compose.runtime.p)l0).N();
        if((z | z1 | z2 | v2 | z3 | z4) != 0 || g0 == androidx.compose.runtime.k.a) {
            F.C c1 = new F.C(4, k0, m0);
            x9.b b0 = new x9.b();  // 初始化器: Ljava/lang/Object;-><init>()V
            b0.a = k0;
            b0.b = c1;
            J.g g1 = new J.g(b0, y0, a00);
            ((androidx.compose.runtime.p)l0).l0(g1);
            return g1;
        }
        return g0;
    }
}

