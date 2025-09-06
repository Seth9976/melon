package H0;

import Ac.U2;
import Ac.X3;
import Ac.l1;
import Ac.m2;
import B9.r;
import B9.u;
import Cc.K1;
import Cc.N1;
import Cc.c1;
import Cc.c4;
import Cc.e0;
import Cc.r0;
import Cc.u3;
import Cc.w0;
import D2.E0;
import Dd.d2;
import Dd.i2;
import Dd.j2;
import Dd.k2;
import Dd.l0;
import Dd.o2;
import Dd.q2;
import G.z0;
import I.u0;
import I7.h;
import J0.n;
import J0.v;
import J8.J0;
import J8.Q1;
import K6.d;
import M.i0;
import M.p0;
import M.q0;
import Nc.V0;
import Nc.Y;
import P0.i;
import Q0.b1;
import U.t0;
import U4.B;
import U4.k;
import Ve.A;
import Ve.D;
import Ve.G;
import Ve.J;
import Ve.K;
import Ve.M;
import Ve.s;
import Ve.t;
import Ve.x;
import Ve.y;
import Ve.z;
import Wf.a;
import X0.p;
import Z.j;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View.OnLongClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView.ScaleType;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.runtime.K0;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.V;
import androidx.compose.runtime.a0;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.I;
import androidx.fragment.app.f0;
import androidx.lifecycle.L;
import androidx.room.w;
import coil.request.ImageRequest.Builder;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.b;
import com.iloen.melon.custom.CheckableImageView;
import com.iloen.melon.custom.F;
import com.iloen.melon.custom.L0;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.utils.StringUtils;
import com.melon.net.res.common.ArtistPlayListWrapperInfoBase;
import i.n.i.b.a.s.e.M3;
import ie.H;
import ie.m;
import java.lang.reflect.Method;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import je.C;
import kotlin.jvm.internal.q;
import nf.f;
import oe.c;
import r0.g;
import we.o;
import y0.Q;

public abstract class e {
    public static final int a;
    public static final int b;
    public static final int c;
    public static final int d;

    public static ImageView.ScaleType A(int v) {
        switch(v) {
            case 0: {
                return ImageView.ScaleType.FIT_XY;
            }
            case 1: {
                return ImageView.ScaleType.FIT_START;
            }
            case 2: {
                return ImageView.ScaleType.FIT_CENTER;
            }
            case 3: {
                return ImageView.ScaleType.FIT_END;
            }
            case 5: {
                return ImageView.ScaleType.CENTER_CROP;
            }
            case 6: {
                return ImageView.ScaleType.CENTER_INSIDE;
            }
            default: {
                return ImageView.ScaleType.CENTER;
            }
        }
    }

    public abstract String B(byte[] arg1, int arg2, int arg3);

    public static long C(long v, long v1, RoundingMode roundingMode0) {
        roundingMode0.getClass();
        long v2 = v / v1;
        long v3 = v - v1 * v2;
        int v4 = Long.compare(v3, 0L);
        if(v4 != 0) {
            int v5 = ((int)((v ^ v1) >> 0x3F)) | 1;
            switch(d.a[roundingMode0.ordinal()]) {
                case 1: {
                    if(v4 != 0) {
                        throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
                    }
                    break;
                }
                case 2: {
                    break;
                }
                case 3: {
                    return v5 >= 0 ? v2 : v2 + ((long)v5);
                }
                case 4: {
                    return v2 + ((long)v5);
                }
                case 5: {
                    return v5 <= 0 ? v2 : v2 + ((long)v5);
                }
                case 6: 
                case 7: 
                case 8: {
                    long v6 = Math.abs(v3);
                    int v7 = Long.compare(v6 - (Math.abs(v1) - v6), 0L);
                    if(v7 == 0) {
                        return roundingMode0 != RoundingMode.HALF_UP && (roundingMode0 != RoundingMode.HALF_EVEN || (1L & v2) == 0L) ? v2 : v2 + ((long)v5);
                    }
                    return v7 <= 0 ? v2 : v2 + ((long)v5);
                }
                default: {
                    throw new AssertionError();
                }
            }
        }
        return v2;
    }

    public abstract int D(String arg1, byte[] arg2, int arg3, int arg4);

    public static final Object E(w w0, String s, c c0) {
        Object object0 = w0.d(s, new a(11), c0);
        return object0 == ne.a.a ? object0 : H.a;
    }

    // This method was un-flattened
    public static final List F(E0 e00, int v, int v1) {
        m m0;
        q.g(e00, "<this>");
        LinkedHashMap linkedHashMap0 = e00.a;
        if(v == v1) {
            return je.w.a;
        }
        boolean z = v1 > v;
        List list0 = new ArrayList();
        while(true) {
            if(!z) {
                if(v > v1) {
                    goto label_10;
                }
                return list0;
            }
            else if(v >= v1) {
                return list0;
            }
        label_10:
            if(z) {
                TreeMap treeMap0 = (TreeMap)linkedHashMap0.get(v);
                if(treeMap0 != null) {
                    m0 = new m(treeMap0, treeMap0.descendingKeySet());
                    goto label_20;
                }
            }
            else {
                TreeMap treeMap1 = (TreeMap)linkedHashMap0.get(v);
                if(treeMap1 != null) {
                    m0 = new m(treeMap1, treeMap1.keySet());
                    goto label_20;
                }
            }
            m0 = null;
        label_20:
            if(m0 == null) {
                return null;
            }
            Map map0 = (Map)m0.a;
            Iterator iterator0 = ((Iterable)m0.b).iterator();
        label_23:
            if(!iterator0.hasNext()) {
                return null;
            }
            Object object0 = iterator0.next();
            int v2 = ((Number)object0).intValue();
            if(!z) {
                if(v1 <= v2 && v2 < v) {
                    goto label_30;
                }
                break;
            }
            else if(v + 1 > v2 || v2 > v1) {
                break;
            }
        label_30:
            Object object1 = map0.get(v2);
            q.d(object1);
            ((ArrayList)list0).add(object1);
            v = v2;
        }
        goto label_23;
    }

    public static final L0 G(I i0) {
        FragmentActivity fragmentActivity0 = i0.getActivity();
        if(fragmentActivity0 != null && fragmentActivity0 instanceof F) {
            return ((F)fragmentActivity0).getProgressManager().getProgressUpdater();
        }
        while(i0 != null) {
            if(i0 instanceof F) {
                return ((F)i0).getProgressManager().getProgressUpdater();
            }
            i0 = i0.getParentFragment();
        }
        return null;
    }

    public static long H(long v, long v1) {
        P4.a.g(v, "a");
        P4.a.g(v1, "b");
        if(v == 0L) {
            return v1;
        }
        if(v1 == 0L) {
            return v;
        }
        int v2 = Long.numberOfTrailingZeros(v);
        long v3 = v >> v2;
        int v4 = Long.numberOfTrailingZeros(v1);
        long v5 = v1 >> v4;
        while(v3 != v5) {
            long v6 = v3 - v5;
            long v7 = v6 >> 0x3F & v6;
            long v8 = v6 - v7 - v7;
            v5 += v7;
            v3 = v8 >> Long.numberOfTrailingZeros(v8);
        }
        return v3 << Math.min(v2, v4);
    }

    public static final String I(f f0, int v) {
        q.g(f0, "<this>");
        String s = f0.e(v);
        return f0.c(v) ? "." + s : s;
    }

    public static final long J(KeyEvent keyEvent0) {
        return b.h(keyEvent0.getKeyCode());
    }

    public static final int K(KeyEvent keyEvent0) {
        switch(keyEvent0.getAction()) {
            case 0: {
                return 2;
            }
            case 1: {
                return 1;
            }
            default: {
                return 0;
            }
        }
    }

    // 去混淆评级： 低(20)
    public static final boolean L(androidx.room.a a0, int v, int v1) {
        q.g(a0, "<this>");
        return v <= v1 || !a0.l ? a0.k && (a0.m == null || !a0.m.contains(v)) : false;
    }

    public static final boolean M(n n0) {
        Object object0 = n0.a;
        int v = ((Collection)object0).size();
        int v1 = 0;
        while(v1 < v) {
            if(((v)((List)object0).get(v1)).i == 2) {
                ++v1;
                continue;
            }
            return false;
        }
        return true;
    }

    public static final boolean N(I i0) {
        if(i0 == null) {
            return false;
        }
        FragmentActivity fragmentActivity0 = i0.getActivity();
        return fragmentActivity0 == null ? false : !fragmentActivity0.isFinishing() && i0.isAdded();
    }

    public static final B O(k k0, String s, Executor executor0, we.a a0) {
        q.g(k0, "tracer");
        q.g(s, "label");
        q.g(executor0, "executor");
        L l0 = new L(B.c);  // 初始化器: Landroidx/lifecycle/K;-><init>(Ljava/lang/Object;)V
        return new B(l0, e.k.q(new h(executor0, k0, s, a0, l0)));
    }

    public static u P(ViewGroup viewGroup0, r r0) {
        q.g(viewGroup0, "parent");
        q.g(r0, "marginType");
        View view0 = LayoutInflater.from(viewGroup0.getContext()).inflate(0x7F0D0485, viewGroup0, false);  // layout:listitem_detail_playlist_with_right_buttons
        int v = 0x7F0A017A;  // id:btn_more
        View view1 = De.I.C(view0, 0x7F0A017A);  // id:btn_more
        if(((ImageView)view1) != null) {
            v = 0x7F0A0610;  // id:iv_check
            View view2 = De.I.C(view0, 0x7F0A0610);  // id:iv_check
            if(((CheckableImageView)view2) != null) {
                v = 0x7F0A0651;  // id:iv_move
                View view3 = De.I.C(view0, 0x7F0A0651);  // id:iv_move
                if(((ImageView)view3) != null) {
                    v = 0x7F0A07C8;  // id:main_container
                    View view4 = De.I.C(view0, 0x7F0A07C8);  // id:main_container
                    if(view4 != null) {
                        Q1 q10 = Q1.a(view4);
                        v = 0x7F0A09F6;  // id:right_button_container
                        if(((RelativeLayout)De.I.C(view0, 0x7F0A09F6)) != null) {  // id:right_button_container
                            v = 0x7F0A0A6E;  // id:series_back_rect_container
                            View view5 = De.I.C(view0, 0x7F0A0A6E);  // id:series_back_rect_container
                            if(((RelativeLayout)view5) != null) {
                                return new u(new J0(((RelativeLayout)view0), ((ImageView)view1), ((CheckableImageView)view2), ((ImageView)view3), q10, ((RelativeLayout)view5)), r0);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    public static final s Q(lf.h h0, f f0) {
        q.g(h0, "<this>");
        q.g(f0, "strings");
        String s = e.I(f0, h0.c);
        List list0 = h0.d;
        q.f(list0, "getArgumentList(...)");
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: list0) {
            lf.e e0 = ((lf.f)object0).d;
            q.f(e0, "getValue(...)");
            M m0 = e.R(e0, f0);
            m m1 = m0 == null ? null : new m(f0.getString(((lf.f)object0).c), m0);
            if(m1 != null) {
                arrayList0.add(m1);
            }
        }
        return new s(s, C.Y(arrayList0));
    }

    public static final M R(lf.e e0, f f0) {
        q.g(e0, "<this>");
        q.g(f0, "strings");
        boolean z = true;
        int v = -1;
        if(nf.d.P.e(e0.m).booleanValue()) {
            lf.d d0 = e0.c;
            if(d0 != null) {
                v = We.h.a[d0.ordinal()];
            }
            switch(v) {
                case 1: {
                    return new Ve.I(((byte)(((int)e0.d))));
                }
                case 2: {
                    return new Ve.L(((short)(((int)e0.d))));
                }
                case 3: {
                    return new J(((int)e0.d));
                }
                case 4: {
                    return new K(e0.d);
                }
                default: {
                    throw new IllegalStateException(("Cannot read value of unsigned type: " + e0.c).toString());
                }
            }
        }
        lf.d d1 = e0.c;
        if(d1 != null) {
            v = We.h.a[d1.ordinal()];
        }
        switch(v) {
            case -1: {
                return null;
            }
            case 1: {
                return new x(((byte)(((int)e0.d))));
            }
            case 2: {
                return new G(((short)(((int)e0.d))));
            }
            case 3: {
                return new Ve.C(((int)e0.d));
            }
            case 4: {
                return new Ve.F(e0.d);
            }
            case 5: {
                return new y(((char)(((int)e0.d))));
            }
            case 6: {
                return new Ve.B(e0.e);
            }
            case 7: {
                return new z(e0.f);
            }
            case 8: {
                if(e0.d == 0L) {
                    z = false;
                }
                return new Ve.w(z);
            }
            case 9: {
                return new Ve.H(f0.getString(e0.g));
            }
            case 10: {
                String s = e.I(f0, e0.h);
                int v1 = e0.l;
                return v1 == 0 ? new D(s) : new Ve.u(s, v1);
            }
            case 11: {
                return new A(e.I(f0, e0.h), f0.getString(e0.i));
            }
            case 12: {
                lf.h h0 = e0.j;
                q.f(h0, "getAnnotation(...)");
                return new t(e.Q(h0, f0));
            }
            case 13: {
                List list0 = e0.k;
                q.f(list0, "getArrayElementList(...)");
                ArrayList arrayList0 = new ArrayList();
                for(Object object0: list0) {
                    q.d(((lf.e)object0));
                    M m0 = e.R(((lf.e)object0), f0);
                    if(m0 != null) {
                        arrayList0.add(m0);
                    }
                }
                return new Ve.v(arrayList0);
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
    }

    public static void S(TextInputLayout textInputLayout0, CheckableImageButton checkableImageButton0, ColorStateList colorStateList0) {
        Drawable drawable0 = checkableImageButton0.getDrawable();
        if(checkableImageButton0.getDrawable() != null && colorStateList0 != null && colorStateList0.isStateful()) {
            int[] arr_v = textInputLayout0.getDrawableState();
            int[] arr_v1 = checkableImageButton0.getDrawableState();
            int[] arr_v2 = Arrays.copyOf(arr_v, arr_v.length + arr_v1.length);
            System.arraycopy(arr_v1, 0, arr_v2, arr_v.length, arr_v1.length);
            int v = colorStateList0.getColorForState(arr_v2, colorStateList0.getDefaultColor());
            Drawable drawable1 = drawable0.mutate();
            drawable1.setTintList(ColorStateList.valueOf(v));
            checkableImageButton0.setImageDrawable(drawable1);
        }
    }

    public static final e.b T(I i0, we.k k0) {
        q.g(i0, "<this>");
        e.b b0 = i0.registerForActivityResult(new f0(2), new X3(k0));
        q.f(b0, "registerForActivityResult(...)");
        return b0;
    }

    public static long U(long v, long v1) {
        int v2 = 0;
        int v3 = Long.numberOfLeadingZeros(~v1) + (Long.numberOfLeadingZeros(v1) + (Long.numberOfLeadingZeros(~v) + Long.numberOfLeadingZeros(v)));
        if(v3 > 65) {
            return v * v1;
        }
        int v4 = Long.compare(v, 0L);
        if(v1 == 0x8000000000000000L) {
            v2 = 1;
        }
        if(((v3 >= 0x40 ? 0 : 1) | v2 & (v4 >= 0 ? 0 : 1)) == 0) {
            long v5 = v * v1;
            return v4 == 0 || v5 / v == v1 ? v5 : ((v ^ v1) >>> 0x3F) + 0x7FFFFFFFFFFFFFFFL;
        }
        return ((v ^ v1) >>> 0x3F) + 0x7FFFFFFFFFFFFFFFL;
    }

    public static final void V(p p0, d2.d d0) {
        Object object0 = p0.i().a.g(X0.s.g);
        Object object1 = null;
        if(object0 == null) {
            object0 = null;
        }
        if(((X0.c)object0) != null) {
            int v = ((X0.c)object0).a;
            int v1 = ((X0.c)object0).b;
            int v2 = ((X0.c)object0).c;
            int v3 = ((X0.c)object0).d;
            Boolean boolean0 = p0.i().a.g(X0.s.F);
            if(boolean0 == null) {
                boolean0 = Boolean.FALSE;
            }
            d0.n(B6.f.c(v, v1, v2, v3, false, boolean0.booleanValue()));
        }
        p p1 = p0.j();
        if(p1 != null) {
            Object object2 = p1.i().a.g(X0.s.e);
            if(object2 == null) {
                object2 = null;
            }
            if(object2 != null) {
                Object object3 = p1.i().a.g(X0.s.f);
                if(object3 != null) {
                    object1 = object3;
                }
                if((((X0.b)object1) == null || ((X0.b)object1).a >= 0 && ((X0.b)object1).b >= 0) && p0.i().a.c(X0.s.F)) {
                    ArrayList arrayList0 = new ArrayList();
                    List list0 = p.h(4, p1);
                    int v4 = list0.size();
                    int v6 = 0;
                    for(int v5 = 0; v5 < v4; ++v5) {
                        p p2 = (p)list0.get(v5);
                        if(p2.i().a.c(X0.s.F)) {
                            arrayList0.add(p2);
                            if(p2.c.v() < p0.c.v()) {
                                ++v6;
                            }
                        }
                    }
                    if(!arrayList0.isEmpty()) {
                        boolean z = e.x(arrayList0);
                        Boolean boolean1 = p0.i().a.g(X0.s.F);
                        if(boolean1 == null) {
                            boolean1 = Boolean.FALSE;
                        }
                        d0.n(B6.f.c((z ? 0 : v6), 1, (z ? v6 : 0), 1, false, boolean1.booleanValue()));
                    }
                }
            }
        }
    }

    public static void W(Window window0, boolean z) {
        int v = Build.VERSION.SDK_INT;
        if(v >= 35) {
            P1.b.j(window0, z);
            return;
        }
        if(v >= 30) {
            P1.b.i(window0, z);
            return;
        }
        View view0 = window0.getDecorView();
        int v1 = view0.getSystemUiVisibility();
        view0.setSystemUiVisibility((z ? v1 & 0xFFFFF8FF : v1 | 0x700));
    }

    public static void X(CheckableImageButton checkableImageButton0, View.OnLongClickListener view$OnLongClickListener0) {
        boolean z = checkableImageButton0.hasOnClickListeners();
        boolean z1 = false;
        int v = 1;
        if(z || view$OnLongClickListener0 != null) {
            z1 = true;
        }
        checkableImageButton0.setFocusable(z1);
        checkableImageButton0.setClickable(z);
        checkableImageButton0.setPressable(z);
        checkableImageButton0.setLongClickable(view$OnLongClickListener0 != null);
        if(!z1) {
            v = 2;
        }
        checkableImageButton0.setImportantForAccessibility(v);
    }

    public static final String Y(l l0, int v) {
        return E9.w.T(l0).getString(v);
    }

    public static final Bitmap Z(Drawable drawable0, int v, int v1, Bitmap.Config bitmap$Config0) {
        if(drawable0 instanceof BitmapDrawable && ((BitmapDrawable)drawable0).getBitmap() == null) {
            return null;
        }
        if(drawable0 instanceof BitmapDrawable) {
            if(((BitmapDrawable)drawable0).getBitmap() == null) {
                throw new IllegalArgumentException("bitmap is null");
            }
            if(bitmap$Config0 == null || ((BitmapDrawable)drawable0).getBitmap().getConfig() == bitmap$Config0) {
                return v != ((BitmapDrawable)drawable0).getBitmap().getWidth() || v1 != ((BitmapDrawable)drawable0).getBitmap().getHeight() ? Bitmap.createScaledBitmap(((BitmapDrawable)drawable0).getBitmap(), v, v1, true) : ((BitmapDrawable)drawable0).getBitmap();
            }
        }
        Rect rect0 = drawable0.getBounds();
        int v2 = rect0.left;
        int v3 = rect0.top;
        int v4 = rect0.right;
        int v5 = rect0.bottom;
        if(bitmap$Config0 == null) {
            bitmap$Config0 = Bitmap.Config.ARGB_8888;
        }
        Bitmap bitmap0 = Bitmap.createBitmap(v, v1, bitmap$Config0);
        drawable0.setBounds(0, 0, v, v1);
        drawable0.draw(new Canvas(bitmap0));
        drawable0.setBounds(v2, v3, v4, v5);
        return bitmap0;
    }

    public static final void a(B2.n n0, J2.c c0, m0.b b0, l l0, int v, int v1) {
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0x74C75949);
        int v2 = (v & 6) == 0 ? (p0.g(n0) ? 4 : 2) | v : v;
        if((v1 & 2) != 0) {
            v2 |= 0x30;
        }
        else if((v & 0x30) == 0) {
            v2 |= (p0.g(c0) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v2 |= (p0.g(b0) ? 0x100 : 0x80);
        }
        if((v2 & 0x93) == 0x92 && p0.D()) {
            p0.T();
            goto label_30;
        }
        if((v1 & 2) != 0) {
            c0 = J2.c.c;
        }
        J2.d d0 = J2.d.b;
        p0.b0(0x227C4E56);
        p0.b0(0xDF52C09C);
        if(p0.a instanceof B2.b) {
            p0.Y();
            if(p0.O) {
                p0.l(d0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, n0, J2.e.g);
            androidx.compose.runtime.w.x(p0, c0, J2.e.h);
            b0.invoke(p0, ((int)((v2 & 0x380) >> 6 & 14)));
            p0.p(true);
            p0.p(false);
            p0.p(false);
        label_30:
            n0 n00 = p0.t();
            if(n00 != null) {
                n00.d = new J2.f(v, v1, 0, b0, n0, c0);
            }
            return;
        }
        androidx.compose.runtime.w.m();
        throw null;
    }

    public static Bitmap a0(Drawable drawable0) {
        return e.Z(drawable0, drawable0.getIntrinsicWidth(), drawable0.getIntrinsicHeight(), null);
    }

    public static final void b(we.a a0, r0.q q0, boolean z, Z.n n0, Q q1, j j0, i0 i00, o o0, l l0, int v, int v1) {
        Q q6;
        boolean z12;
        i0 i02;
        float f;
        G.p p1;
        Q q5;
        boolean z7;
        long v13;
        K.l l1;
        i0 i01;
        Q q3;
        int v7;
        int v6;
        Q q2;
        int v5;
        Z.n n1;
        boolean z1;
        int v3;
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0x81DE5DA8);
        int v2 = (v & 6) == 0 ? v | (p0.i(a0) ? 4 : 2) : v;
        if((v & 0x30) == 0) {
            v2 |= (p0.g(q0) ? 0x20 : 16);
        }
        if((v1 & 4) == 0) {
            z1 = z;
            v3 = v2 | (p0.h(z1) ? 0x100 : 0x80);
        }
        else {
            v3 = v2 | 0x180;
            z1 = z;
        }
        int v4 = (v1 & 8) == 0 ? v3 | (p0.g(null) ? 0x800 : 0x400) : v3 | 0xC00;
        if((v1 & 16) == 0) {
            n1 = n0;
            v5 = p0.g(n1) ? 0x4000 : 0x2000;
        }
        else {
            n1 = n0;
            v5 = 0x2000;
        }
        if((v1 & 0x20) == 0) {
            q2 = q1;
            v6 = p0.g(q2) ? 0x20000 : 0x10000;
        }
        else {
            q2 = q1;
            v6 = 0x10000;
        }
        if((v1 & 0x40) == 0) {
            v7 = p0.g(null) ? 0x100000 : 0x80000;
        }
        else {
            v7 = 0x180000;
        }
        int v8 = v4 | v5 | v6 | v7 | (p0.g(j0) ? 0x800000 : 0x400000);
        if((v1 & 0x100) != 0) {
            v8 |= 0x6000000;
        }
        else if((v & 0x6000000) == 0) {
            v8 |= (p0.g(i00) ? 0x4000000 : 0x2000000);
        }
        int v9 = 1;
        if(p0.Q(v8 & 1, (v8 & 306783379) != 306783378)) {
            p0.V();
            V v10 = androidx.compose.runtime.k.a;
            if((v & 1) == 0 || p0.B()) {
                if((v1 & 4) != 0) {
                    z1 = true;
                }
                if((v1 & 16) != 0) {
                    boolean z2 = p0.d(2.0f);
                    boolean z3 = p0.d(8.0f);
                    boolean z4 = p0.d(0.0f);
                    boolean z5 = p0.d(4.0f);
                    boolean z6 = p0.d(4.0f);
                    Z.n n2 = p0.N();
                    if((z2 | z3 | z4 | z5 | z6) != 0 || n2 == v10) {
                        n2 = new Z.n(2.0f, 8.0f, 0.0f, 4.0f, 4.0f);
                        p0.l0(n2);
                    }
                    n1 = n2;
                    v8 &= 0xFFFF1FFF;
                }
                if((v1 & 0x20) != 0) {
                    v8 &= 0xFFF8FFFF;
                    q2 = ((Z.I)p0.k(Z.J.a)).a;
                }
                if((v1 & 0x100) == 0) {
                    q3 = q2;
                    i01 = i00;
                }
                else {
                    i01 = Z.a.a;
                    q3 = q2;
                }
            }
            else {
                p0.T();
                if((v1 & 16) != 0) {
                    v8 &= 0xFFFF1FFF;
                }
                if((v1 & 0x20) != 0) {
                    v8 &= 0xFFF8FFFF;
                }
                q3 = q2;
                i01 = i00;
            }
            p0.q();
            p0.a0(1050689923);
            K.m m0 = p0.N();
            if(m0 == v10) {
                m0 = androidx.appcompat.app.o.d(p0);
            }
            p0.p(false);
            j0.getClass();
            p0.a0(0x80D31F4C);
            b0 b00 = androidx.compose.runtime.w.w(new y0.s((z1 ? j0.b : j0.d)), p0);
            p0.p(false);
            r0.q q4 = X0.n.c(q0, false, Z.b.g);
            p0.a0(0xD8F19C1D);
            b0 b01 = androidx.compose.runtime.w.w(new y0.s((z1 ? j0.a : j0.c)), p0);
            p0.p(false);
            long v11 = ((y0.s)b01.getValue()).a;
            long v12 = y0.s.c(((y0.s)b00.getValue()).a, 1.0f);
            if(n1 == null) {
                p0.a0(1051096580);
                p0.p(false);
                l1 = m0;
                v13 = v12;
                z7 = z1;
                q5 = q3;
                p1 = null;
            }
            else {
                p0.a0(0xF1813D9D);
                p0.a0(-1588756907);
                p0.p p2 = p0.N();
                if(p2 == v10) {
                    p2 = new p0.p();
                    p0.l0(p2);
                }
                boolean z8 = p0.g(m0);
                Z.l l2 = p0.N();
                if(z8 || l2 == v10) {
                    l2 = new Z.l(m0, p2, null);
                    p0.l0(l2);
                }
                androidx.compose.runtime.J.d(p0, m0, l2);
                K.k k0 = (K.k)je.p.t0(p2);
                if(!z1) {
                    f = n1.c;
                }
                else if(k0 instanceof K.o) {
                    f = n1.b;
                }
                else if(k0 instanceof K.h) {
                    f = n1.d;
                }
                else {
                    f = k0 instanceof K.f ? n1.e : n1.a;
                }
                G.e e0 = p0.N();
                if(e0 == v10) {
                    l1 = m0;
                    v13 = v12;
                    q5 = q3;
                    e0 = new G.e(new r1.f(f), z0.c, null, 12);
                    p0.l0(e0);
                }
                else {
                    l1 = m0;
                    v13 = v12;
                    q5 = q3;
                }
                r1.f f1 = new r1.f(f);
                boolean z9 = p0.i(e0);
                boolean z10 = p0.d(f);
                int v14 = ((v8 >> 6 & 14 ^ 6) <= 4 || !p0.h(z1)) && (v8 >> 6 & 6) != 4 ? 0 : 1;
                if(((v8 >> 6 & 0x380 ^ 0x180) <= 0x100 || !p0.g(n1)) && (v8 >> 6 & 0x180) != 0x100) {
                    v9 = 0;
                }
                boolean z11 = p0.i(k0);
                Z.m m1 = p0.N();
                if((z9 | z10 | v14 | v9 | z11) != 0 || m1 == v10) {
                    z7 = z1;
                    m1 = new Z.m(e0, f, z7, n1, k0, null);
                    p0.l0(m1);
                }
                else {
                    z7 = z1;
                }
                androidx.compose.runtime.J.d(p0, f1, m1);
                p1 = e0.c;
                p0.p(false);
                p0.p(false);
            }
            Q1.c.h(a0, q4, z7, q5, v11, v13, (p1 == null ? 0.0f : ((r1.f)((O0)p1.b).getValue()).a), l1, m0.c.e(0x72CFAF, p0, new I.L0(b00, i01, o0, 5)), p0, v8 & 14 | 0x30000000 | v8 & 0x380 | v8 >> 6 & 0x1C00 | v8 & 0x380000, 0);
            i02 = i01;
            z12 = z7;
            q6 = q5;
        }
        else {
            p0.T();
            z12 = z1;
            q6 = q2;
            i02 = i00;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Z.d(a0, q0, z12, n1, q6, j0, i02, o0, v, v1);
        }
    }

    public static final String b0(Ob.d d0) {
        q.g(d0, "<this>");
        switch(d0.ordinal()) {
            case 0: {
                return "1GB";
            }
            case 1: {
                return "3GB";
            }
            case 2: {
                return "5GB";
            }
            case 3: {
                return "10GB";
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
    }

    public static final void c(r0.q q0, Q.K k0, long v, long v1, l l0, int v2) {
        long v11;
        long v10;
        long v5;
        long v4;
        q.g(q0, "modifier");
        q.g(k0, "pagerState");
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(-735128041);
        int v3 = v2 | (p0.g(q0) ? 4 : 2) | (p0.g(k0) ? 0x20 : 16) | 0x480;
        if(p0.Q(v3 & 1, (v3 & 0x493) != 1170)) {
            p0.V();
            if((v2 & 1) == 0 || p0.B()) {
                v4 = e0.T(p0, 0x7F06017C);  // color:green500s_support_high_contrast
                v5 = e0.T(p0, 0x7F0604BB);  // color:white_10
            }
            else {
                p0.T();
                v4 = v;
                v5 = v1;
            }
            p0.q();
            p0 p00 = M.n0.a(M.j.e, r0.d.j, p0, 6);
            int v6 = p0.P;
            androidx.compose.runtime.i0 i00 = p0.m();
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
            androidx.compose.runtime.w.x(p0, p00, P0.j.f);
            androidx.compose.runtime.w.x(p0, i00, P0.j.e);
            P0.h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v6)) {
                A7.d.q(v6, p0, v6, h0);
            }
            androidx.compose.runtime.w.x(p0, q1, P0.j.d);
            p0.a0(0xD121521C);
            int v7 = k0.l();
            for(int v8 = 0; v8 < v7; ++v8) {
                long v9 = k0.j() == v8 ? v4 : v5;
                M.p.a(androidx.compose.foundation.layout.d.n(androidx.compose.foundation.q.f(d5.n.o(androidx.compose.foundation.layout.a.j(r0.n.a, 2.0f), T.e.a), v9, y0.M.a), 5.0f), p0, 0);
            }
            p0.p(false);
            p0.p(true);
            v10 = v4;
            v11 = v5;
        }
        else {
            p0.T();
            v10 = v;
            v11 = v1;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new c4(q0, k0, v10, v11, v2, 1);
        }
    }

    public static final int c0(P.s s0) {
        boolean z = s0.p == u0.a;
        Object object0 = s0.l;
        int v = 0;
        int v1 = 0;
        int v2 = 0;
        while(v < ((List)object0).size()) {
            int v3 = e.d0(z, s0, v);
            if(v3 == -1) {
                ++v;
            }
            else {
                int v4 = 0;
                while(v < ((List)object0).size() && e.d0(z, s0, v) == v3) {
                    v4 = Math.max(v4, ((int)(z ? ((P.t)((List)object0).get(v)).o & 0xFFFFFFFFL : ((P.t)((List)object0).get(v)).o >> 0x20)));
                    ++v;
                }
                v1 += v4;
                ++v2;
            }
        }
        return v1 / v2 + s0.r;
    }

    public static final void d(String s, l l0, int v) {
        ((androidx.compose.runtime.p)l0).c0(-2103917235);
        int v1 = (((androidx.compose.runtime.p)l0).g(s) ? 4 : 2) | v;
        if(((androidx.compose.runtime.p)l0).Q(v1 & 1, (v1 & 3) != 2)) {
            String s1 = e.Y(((androidx.compose.runtime.p)l0), 0x7F1308A0);  // string:profile_liked_desc " 외"
            b0 b00 = ((androidx.compose.runtime.p)l0).N();
            V v2 = androidx.compose.runtime.k.a;
            if(b00 == v2) {
                b00 = androidx.compose.runtime.w.s((s + s1));
                ((androidx.compose.runtime.p)l0).l0(b00);
            }
            r0.q q0 = androidx.compose.foundation.layout.d.q(androidx.compose.foundation.layout.a.n(r0.n.a, 0.0f, 6.0f, 0.0f, 0.0f, 13), 144.0f);
            String s2 = (String)b00.getValue();
            long v3 = e0.T(((androidx.compose.runtime.p)l0), 0x7F06016D);  // color:gray900s
            l1.k k0 = new l1.k(5);
            boolean z = ((androidx.compose.runtime.p)l0).g(s1);
            m2 m20 = ((androidx.compose.runtime.p)l0).N();
            if(z || (v1 & 14) == 4 || m20 == v2) {
                m20 = new m2(s, s1, b00, 6);
                ((androidx.compose.runtime.p)l0).l0(m20);
            }
            N1.b(s2, q0, v3, 15.0f, null, null, 0L, k0, 17.0f, 1, false, 2, 0, m20, null, ((androidx.compose.runtime.p)l0), 0xC30, 0xC36, 0x151F0);
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
        }
        n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new k2(s, v, 0);
        }
    }

    // 去混淆评级： 低(20)
    public static final int d0(boolean z, P.s s0, int v) {
        return z ? ((P.t)((List)s0.l).get(v)).q : ((P.t)((List)s0.l).get(v)).r;
    }

    public static final void e(r0.q q0, V0 v00, l l0, int v) {
        q.g(v00, "uiState");
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0xDA73C8C5);
        int v1 = (p0.g(v00) ? 0x20 : 16) | v;
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            M.y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
            int v2 = p0.P;
            androidx.compose.runtime.i0 i00 = p0.m();
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
            androidx.compose.runtime.w.x(p0, y0, P0.j.f);
            androidx.compose.runtime.w.x(p0, i00, P0.j.e);
            P0.h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            androidx.compose.runtime.w.x(p0, q1, P0.j.d);
            a.a.e(androidx.compose.foundation.layout.a.l(r0.n.a, 16.0f, 0.0f, 2), v00.a, p0, 6);
            M.c.d(p0, androidx.compose.foundation.layout.d.h(r0.n.a, 12.0f));
            P4.a.d(androidx.compose.foundation.layout.a.l(r0.n.a, 16.0f, 0.0f, 2), v00.b, p0, 6);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Y(q0, v00, v, 7);
        }
    }

    public static final void f(l l0, int v) {
        ((androidx.compose.runtime.p)l0).c0(0x60BC1F7D);
        if(((androidx.compose.runtime.p)l0).Q(v & 1, v != 0)) {
            r0.q q0 = androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.a.n(r0.n.a, 0.0f, 30.0f, 0.0f, 60.0f, 5), 1.0f);
            N1.b(e.Y(((androidx.compose.runtime.p)l0), 0x7F13089B), q0, e0.T(((androidx.compose.runtime.p)l0), 0x7F060163), 15.0f, null, null, 0L, new l1.k(3), 0.0f, 0, false, 0, 0, null, null, ((androidx.compose.runtime.p)l0), 0xC30, 0, 0x1FDF0);  // string:profile_empty_like "좋아요한 콘텐츠가 없습니다."
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
        }
        n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new Ac.F(v, 16);
        }
    }

    public static final void g(l l0, int v) {
        ((androidx.compose.runtime.p)l0).c0(-1216180850);
        if(((androidx.compose.runtime.p)l0).Q(v & 1, v != 0)) {
            M.p.a(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(r0.n.a, 1.0f), 40.0f), ((androidx.compose.runtime.p)l0), 6);
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
        }
        n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new Ac.F(v, 17);
        }
    }

    public static final void h(l l0, int v) {
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0xF4F66B20);
        if(p0.Q(v & 1, v != 0)) {
            r0.n n0 = r0.n.a;
            r0.q q0 = androidx.compose.foundation.layout.d.f(n0, 1.0f);
            M.y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
            int v1 = p0.P;
            androidx.compose.runtime.i0 i00 = p0.m();
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
            androidx.compose.runtime.w.x(p0, y0, P0.j.f);
            androidx.compose.runtime.w.x(p0, i00, P0.j.e);
            P0.h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v1)) {
                A7.d.q(v1, p0, v1, h0);
            }
            androidx.compose.runtime.w.x(p0, q1, P0.j.d);
            r0.q q2 = androidx.compose.foundation.layout.a.n(n0, 0.0f, 100.0f, 0.0f, 0.0f, 13);
            r0.q q3 = H0.b.q(r0.d.n, q2);
            androidx.compose.foundation.q.c(De.I.Q(0x7F080786, p0, 6), null, q3, null, N0.j.f, 0.0f, null, p0, 0x6030, 104);  // drawable:noimage_logo_large
            r0.q q4 = androidx.compose.foundation.layout.a.n(n0, 0.0f, 10.0f, 0.0f, 0.0f, 13);
            r0.q q5 = H0.b.q(r0.d.n, q4);
            N1.b(e.Y(p0, 0x7F130C90), q5, e0.T(p0, 0x7F060163), 15.0f, null, null, 0L, new l1.k(3), 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FDF0);  // string:text_contents_empty "콘텐츠가 없습니다."
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Ac.F(v, 15);
        }
    }

    public static final void i(r0.q q0, String s, String s1, we.a a0, l l0, int v) {
        q.g(s1, "label");
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0x18309B48);
        int v1 = v | (p0.g(q0) ? 4 : 2) | (p0.g(s) ? 0x20 : 16) | (p0.g(s1) ? 0x100 : 0x80) | (p0.i(a0) ? 0x800 : 0x400);
        if(p0.Q(v1 & 1, (v1 & 0x493) != 1170)) {
            r0.q q1 = r0.a.a(q0, new u3(23, a0));
            M.y y0 = M.w.a(M.j.c, r0.d.n, p0, 0x30);
            int v2 = p0.P;
            androidx.compose.runtime.i0 i00 = p0.m();
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
            androidx.compose.runtime.w.x(p0, y0, P0.j.f);
            androidx.compose.runtime.w.x(p0, i00, P0.j.e);
            P0.h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            androidx.compose.runtime.w.x(p0, q2, P0.j.d);
            long v3 = e0.T(p0, 0x7F06016D);  // color:gray900s
            l1.k k0 = new l1.k(3);
            N1.b(s, null, v3, 18.0f, e1.y.i, null, 0L, k0, 0.0f, 0, false, 0, 0, null, null, p0, v1 >> 3 & 14 | 0x30C00, 0, 0x1FDD2);
            M.c.d(p0, androidx.compose.foundation.layout.d.h(r0.n.a, 6.0f));
            N1.b(s1, null, e0.T(p0, 0x7F060165), 12.0f, null, null, 0L, new l1.k(3), 0.0f, 0, false, 0, 0, null, null, p0, v1 >> 6 & 14 | 0xC00, 0, 0x1FDF2);  // color:gray800s
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new U2(q0, s, s1, a0, v, 9);
        }
    }

    public static final void j(l0 l00, we.k k0, l l0, int v) {
        r0.n n6;
        int v20;
        r0.n n5;
        P0.h h19;
        i i6;
        P0.h h18;
        P0.h h17;
        P0.h h16;
        i i5;
        r0.n n4;
        r0.n n3;
        a0 a014;
        int v18;
        a0 a013;
        V v17;
        a0 a012;
        a0 a011;
        we.k k1;
        a0 a010;
        P0.h h15;
        P0.h h14;
        i i4;
        int v15;
        a0 a09;
        a0 a08;
        V v14;
        a0 a07;
        a0 a06;
        int v13;
        a0 a05;
        i i3;
        P0.h h13;
        V v12;
        r0.h h12;
        P0.h h11;
        P0.h h10;
        P0.h h9;
        a0 a04;
        r0.n n2;
        V v11;
        a0 a03;
        r0.q q11;
        P0.h h8;
        i i2;
        P0.h h7;
        r0.n n1;
        P0.h h6;
        P0.h h5;
        g g0 = r0.d.m;
        N0.i i0 = N0.j.b;
        q.g(l00, "uiState");
        int v1 = l00.h;
        String s = l00.d;
        List list0 = l00.f;
        int v2 = l00.e;
        boolean z = l00.c;
        boolean z1 = l00.b;
        boolean z2 = l00.a;
        String s1 = l00.j;
        q.g(k0, "onEvent");
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        int v3 = l00.k;
        p0.c0(-1800902144);
        boolean z3 = p0.i(l00);
        String s2 = l00.g;
        r0 r00 = r0.b;
        int v4 = v | (z3 ? 4 : 2) | (p0.i(k0) ? 0x20 : 16);
        if(p0.Q(v4 & 1, (v4 & 19) != 18)) {
            r0.q q0 = androidx.compose.foundation.q.u(androidx.compose.foundation.layout.d.f(r0.n.a, 1.0f), androidx.compose.foundation.q.t(p0), true, false);
            M.b b0 = M.j.a;
            r0.n n0 = r0.n.a;
            r0.h h0 = r0.d.j;
            p0 p00 = M.n0.a(b0, h0, p0, 0);
            int v5 = p0.P;
            androidx.compose.runtime.i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            i i1 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            P0.h h1 = P0.j.f;
            androidx.compose.runtime.w.x(p0, p00, h1);
            P0.h h2 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h2);
            P0.h h3 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h3);
            }
            P0.h h4 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q1, h4);
            if(z2) {
                p0.a0(1090659857);
                r0.q q2 = r0.a.a(androidx.compose.foundation.layout.a.n(n0, 20.0f, 0.0f, (z1 || z ? 0.0f : 16.0f), 0.0f, 10), new l1(2, k0));
                M.d d0 = M.j.c;
                M.y y0 = M.w.a(d0, g0, p0, 0);
                int v6 = p0.P;
                androidx.compose.runtime.i0 i01 = p0.m();
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
                if(v2 == 1) {
                    p0.a0(0x50A9E3A6);
                    r0.q q4 = androidx.compose.foundation.layout.d.n(n0, 144.0f);
                    String s3 = list0 == null ? null : ((String)je.p.m0(list0));
                    r00.c(q4, (s3 == null ? "" : s3), 144.0f, null, 0L, null, false, false, p0, 0x6000186, 0xF8);
                    p0.p(false);
                    h5 = h4;
                    h6 = h3;
                    n1 = n0;
                    h7 = h2;
                    i2 = i1;
                    h8 = h1;
                }
                else {
                    p0.a0(0x50B1706D);
                    int v7 = list0 == null ? 0 : list0.size();
                    a0 a00 = p0.N();
                    V v8 = androidx.compose.runtime.k.a;
                    if(a00 == v8) {
                        a00 = androidx.compose.runtime.w.p(0);
                        p0.l0(a00);
                    }
                    a0 a01 = p0.N();
                    if(a01 == v8) {
                        a01 = androidx.compose.runtime.w.p(0);
                        p0.l0(a01);
                    }
                    if(((K0)a01).m() > 0) {
                        p0.a0(0x50B31198);
                        r00.c(androidx.compose.foundation.layout.d.n(n0, 144.0f), "", 144.0f, null, 0L, null, false, false, p0, 0x60001B6, 0xF8);
                        p0.p(false);
                        h5 = h4;
                        h6 = h3;
                        n1 = n0;
                        h7 = h2;
                        i2 = i1;
                        h8 = h1;
                    }
                    else {
                        p0.a0(0x50BA114C);
                        a0 a02 = a01;
                        r0.q q5 = androidx.compose.foundation.q.f(androidx.compose.foundation.layout.d.n(n0, 144.0f), e0.T(p0, 0x7F060145), y0.M.a);  // color:gray050s
                        r0.q q6 = androidx.compose.foundation.q.i(0.5f, e0.T(p0, 0x7F06014A), q5, T.e.b(4.0f));  // color:gray100a
                        M.y y1 = M.w.a(d0, g0, p0, 0);
                        int v9 = p0.P;
                        androidx.compose.runtime.i0 i02 = p0.m();
                        r0.q q7 = r0.a.d(p0, q6);
                        p0.e0();
                        if(p0.O) {
                            p0.l(i1);
                        }
                        else {
                            p0.o0();
                        }
                        androidx.compose.runtime.w.x(p0, y1, h1);
                        androidx.compose.runtime.w.x(p0, i02, h2);
                        if(p0.O || !q.b(p0.N(), v9)) {
                            A7.d.q(v9, p0, v9, h3);
                        }
                        androidx.compose.runtime.w.x(p0, q7, h4);
                        r0.q q8 = d5.n.o(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.q(n0, 144.0f), 72.0f), T.e.c(4.0f, 4.0f, 0.0f, 0.0f));
                        p0 p01 = M.n0.a(b0, h0, p0, 0);
                        int v10 = p0.P;
                        androidx.compose.runtime.i0 i03 = p0.m();
                        r0.q q9 = r0.a.d(p0, q8);
                        p0.e0();
                        if(p0.O) {
                            p0.l(i1);
                        }
                        else {
                            p0.o0();
                        }
                        androidx.compose.runtime.w.x(p0, p01, h1);
                        androidx.compose.runtime.w.x(p0, i03, h2);
                        if(p0.O || !q.b(p0.N(), v10)) {
                            A7.d.q(v10, p0, v10, h3);
                        }
                        androidx.compose.runtime.w.x(p0, q9, h4);
                        if(v7 > 0) {
                            p0.a0(-483101095);
                            r0.q q10 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.q(n0, 72.0f), 72.0f);
                            String s4 = list0 == null ? null : ((String)list0.get(0));
                            if(s4 == null) {
                                s4 = "";
                            }
                            Cc.X3 x30 = p0.N();
                            if(x30 == v8) {
                                q11 = q10;
                                a03 = a00;
                                x30 = new Cc.X3(a03, 3);
                                p0.l0(x30);
                            }
                            else {
                                q11 = q10;
                                a03 = a00;
                            }
                            i2 i20 = p0.N();
                            if(i20 == v8) {
                                v11 = v8;
                                n2 = n0;
                                a04 = a02;
                                i20 = new i2(a04, 3);
                                p0.l0(i20);
                            }
                            else {
                                v11 = v8;
                                n2 = n0;
                                a04 = a02;
                            }
                            h9 = h4;
                            h10 = h3;
                            h11 = h1;
                            h12 = h0;
                            n1 = n2;
                            v12 = v11;
                            h13 = h2;
                            i3 = i1;
                            a05 = a03;
                            v13 = v7;
                            a02 = a04;
                            c1.n(q11, s4, null, i0, false, 0, x30, i20, null, 0.0f, null, 0, 0, false, false, p0, 0xD86D86, 0, 0x7F20);
                        }
                        else {
                            h9 = h4;
                            n1 = n0;
                            h10 = h3;
                            i3 = i1;
                            h11 = h1;
                            h13 = h2;
                            v13 = v7;
                            a05 = a00;
                            v12 = v8;
                            h12 = h0;
                            p0.a0(0xE1EE0619);
                        }
                        p0.p(false);
                        if(v13 > 1) {
                            p0.a0(0xE342BC79);
                            r0.q q12 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.q(n1, 72.0f), 72.0f);
                            String s5 = list0 == null ? null : ((String)list0.get(1));
                            if(s5 == null) {
                                s5 = "";
                            }
                            Cc.X3 x31 = p0.N();
                            if(x31 == v12) {
                                a06 = a05;
                                x31 = new Cc.X3(a06, 4);
                                p0.l0(x31);
                            }
                            else {
                                a06 = a05;
                            }
                            i2 i21 = p0.N();
                            if(i21 == v12) {
                                a07 = a02;
                                i21 = new i2(a07, 0);
                                p0.l0(i21);
                            }
                            else {
                                a07 = a02;
                            }
                            v14 = v12;
                            a08 = a06;
                            a09 = a07;
                            v15 = v13;
                            c1.n(q12, s5, null, i0, false, 0, x31, i21, null, 0.0f, null, 0, 0, false, false, p0, 0xD86D86, 0, 0x7F20);
                        }
                        else {
                            a08 = a05;
                            a09 = a02;
                            v14 = v12;
                            v15 = v13;
                            p0.a0(0xE1EE0619);
                        }
                        p0.p(false);
                        p0.p(true);
                        r0.q q13 = d5.n.o(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.q(n1, 144.0f), 72.0f), T.e.c(0.0f, 0.0f, 4.0f, 4.0f));
                        p0 p02 = M.n0.a(b0, h12, p0, 0);
                        int v16 = p0.P;
                        androidx.compose.runtime.i0 i04 = p0.m();
                        r0.q q14 = r0.a.d(p0, q13);
                        p0.e0();
                        if(p0.O) {
                            i4 = i3;
                            p0.l(i4);
                        }
                        else {
                            i4 = i3;
                            p0.o0();
                        }
                        androidx.compose.runtime.w.x(p0, p02, h11);
                        androidx.compose.runtime.w.x(p0, i04, h13);
                        if(!p0.O && q.b(p0.N(), v16)) {
                            h14 = h10;
                        }
                        else {
                            h14 = h10;
                            A7.d.q(v16, p0, v16, h14);
                        }
                        androidx.compose.runtime.w.x(p0, q14, h9);
                        if(v15 > 2) {
                            p0.a0(0xEBF3C450);
                            r0.q q15 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.q(n1, 72.0f), 72.0f);
                            String s6 = list0 == null ? null : ((String)list0.get(2));
                            if(s6 == null) {
                                s6 = "";
                            }
                            Cc.X3 x32 = p0.N();
                            if(x32 == v14) {
                                h15 = h9;
                                a010 = a08;
                                x32 = new Cc.X3(a010, 1);
                                p0.l0(x32);
                            }
                            else {
                                h15 = h9;
                                a010 = a08;
                            }
                            i2 i22 = p0.N();
                            if(i22 == v14) {
                                k1 = x32;
                                a011 = a010;
                                a012 = a09;
                                i22 = new i2(a012, 1);
                                p0.l0(i22);
                            }
                            else {
                                k1 = x32;
                                a011 = a010;
                                a012 = a09;
                            }
                            v17 = v14;
                            h8 = h11;
                            a013 = a011;
                            h5 = h15;
                            v18 = v15;
                            h7 = h13;
                            a014 = a012;
                            i2 = i4;
                            h6 = h14;
                            c1.n(q15, s6, null, i0, false, 0, k1, i22, null, 0.0f, null, 0, 0, false, false, p0, 0xD86D86, 0, 0x7F20);
                        }
                        else {
                            h7 = h13;
                            h5 = h9;
                            h6 = h14;
                            i2 = i4;
                            h8 = h11;
                            v18 = v15;
                            a013 = a08;
                            a014 = a09;
                            v17 = v14;
                            p0.a0(-360282000);
                        }
                        p0.p(false);
                        if(v18 > 3) {
                            p0.a0(0xEC020A70);
                            r0.q q16 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.q(n1, 72.0f), 72.0f);
                            String s7 = list0 == null ? null : ((String)list0.get(3));
                            Cc.X3 x33 = p0.N();
                            if(x33 == v17) {
                                x33 = new Cc.X3(a013, 2);
                                p0.l0(x33);
                            }
                            i2 i23 = p0.N();
                            if(i23 == v17) {
                                i23 = new i2(a014, 2);
                                p0.l0(i23);
                            }
                            c1.n(q16, (s7 == null ? "" : s7), null, i0, false, 0, x33, i23, null, 0.0f, null, 0, 0, false, false, p0, 0xD86D86, 0, 0x7F20);
                        }
                        else {
                            p0.a0(-360282000);
                        }
                        p0.p(false);
                        A7.d.s(p0, true, true, false);
                    }
                    p0.p(false);
                }
                if(v2 == 1) {
                    p0.a0(0x510EDF1B);
                    n3 = n1;
                    N1.b(s, androidx.compose.foundation.layout.d.q(androidx.compose.foundation.layout.a.n(n1, 0.0f, 6.0f, 0.0f, 0.0f, 13), 144.0f), e0.T(p0, 0x7F06016D), 15.0f, null, null, 0L, new l1.k(5), 17.0f, 2, false, 2, 0, null, null, p0, 0xC30, 0xC36, 0x1D1F0);  // color:gray900s
                }
                else {
                    n3 = n1;
                    p0.a0(0x51176401);
                    e.d(s, p0, 0);
                }
                p0.p(false);
                n4 = n3;
                r0.q q17 = androidx.compose.foundation.layout.d.q(androidx.compose.foundation.layout.a.n(n3, 0.0f, 3.0f, 0.0f, 0.0f, 13), 144.0f);
                N1.b(StringUtils.getSongCountString(String.valueOf((v2 == 1 ? 1 : v2 - 1))), q17, e0.T(p0, 0x7F060160), 13.0f, null, null, 0L, new l1.k(5), 0.0f, 2, false, 1, 0, null, null, p0, 0xC30, 0xC30, 0x1D5F0);  // color:gray600s_support_high_contrast
                p0.p(true);
            }
            else {
                h5 = h4;
                h6 = h3;
                h8 = h1;
                h7 = h2;
                i2 = i1;
                n4 = n0;
                p0.a0(0x3FE077A6);
            }
            p0.p(false);
            if(z1) {
                p0.a0(0x4180EE57);
                r0.q q18 = r0.a.a(androidx.compose.foundation.layout.a.n(n4, (z2 ? 12.0f : 20.0f), 0.0f, (z ? 0.0f : 20.0f), 0.0f, 10), new l1(3, k0));
                M.y y2 = M.w.a(M.j.c, g0, p0, 0);
                int v19 = p0.P;
                androidx.compose.runtime.i0 i05 = p0.m();
                r0.q q19 = r0.a.d(p0, q18);
                p0.e0();
                if(p0.O) {
                    i5 = i2;
                    p0.l(i5);
                }
                else {
                    i5 = i2;
                    p0.o0();
                }
                h16 = h8;
                androidx.compose.runtime.w.x(p0, y2, h16);
                androidx.compose.runtime.w.x(p0, i05, h7);
                if(!p0.O && q.b(p0.N(), v19)) {
                    h17 = h6;
                }
                else {
                    h17 = h6;
                    A7.d.q(v19, p0, v19, h17);
                }
                androidx.compose.runtime.w.x(p0, q19, h5);
                r0.q q20 = e0.K(androidx.compose.foundation.layout.d.n(n4, 144.0f));
                T.d d1 = T.e.b(4.0f);
                h18 = h7;
                i6 = i5;
                h19 = h5;
                r00.c(q20, l00.i, 144.0f, null, 0L, d1, false, false, p0, 0x6000180, 0xD8);
                if(v1 == 1) {
                    p0.a0(0x62929DB1);
                    n5 = n4;
                    v20 = 1;
                    N1.b(s2, androidx.compose.foundation.layout.d.q(androidx.compose.foundation.layout.a.n(n4, 0.0f, 6.0f, 0.0f, 0.0f, 13), 144.0f), e0.T(p0, 0x7F06016D), 15.0f, null, null, 0L, new l1.k(5), 17.0f, 2, false, 2, 0, null, null, p0, 0xC30, 0xC36, 0x1D1F0);  // color:gray900s
                }
                else {
                    v20 = v1;
                    n5 = n4;
                    p0.a0(1654335095);
                    e.d(s2, p0, 0);
                }
                p0.p(false);
                n4 = n5;
                r0.q q21 = androidx.compose.foundation.layout.d.q(androidx.compose.foundation.layout.a.n(n5, 0.0f, 3.0f, 0.0f, 0.0f, 13), 144.0f);
                String s8 = e.Y(p0, 0x7F13089E);  // string:profile_liked_count_album "%1$s개 앨범"
                if(v20 != 1) {
                    --v20;
                }
                N1.b(String.format(s8, Arrays.copyOf(new Object[]{StringUtils.getCountFormattedString(v20)}, 1)), q21, e0.T(p0, 0x7F060160), 13.0f, null, null, 0L, new l1.k(5), 0.0f, 2, false, 1, 0, null, null, p0, 0xC30, 0xC30, 0x1D5F0);  // color:gray600s_support_high_contrast
                p0.p(true);
            }
            else {
                i6 = i2;
                h16 = h8;
                h18 = h7;
                h17 = h6;
                h19 = h5;
                p0.a0(0x3FE077A6);
            }
            p0.p(false);
            if(z) {
                p0.a0(1101309163);
                r0.q q22 = r0.a.a(androidx.compose.foundation.layout.a.n(n4, (z2 || z1 ? 12.0f : 20.0f), 0.0f, 20.0f, 0.0f, 10), new l1(4, k0));
                M.y y3 = M.w.a(M.j.c, g0, p0, 0);
                int v21 = p0.P;
                androidx.compose.runtime.i0 i06 = p0.m();
                r0.q q23 = r0.a.d(p0, q22);
                p0.e0();
                if(p0.O) {
                    p0.l(i6);
                }
                else {
                    p0.o0();
                }
                androidx.compose.runtime.w.x(p0, y3, h16);
                androidx.compose.runtime.w.x(p0, i06, h18);
                if(p0.O || !q.b(p0.N(), v21)) {
                    A7.d.q(v21, p0, v21, h17);
                }
                androidx.compose.runtime.w.x(p0, q23, h19);
                r0.q q24 = e0.K(androidx.compose.foundation.layout.d.n(n4, 144.0f));
                T.d d2 = T.e.b(4.0f);
                r00.c(q24, l00.l, 144.0f, null, 0L, d2, false, false, p0, 0x6000180, 0xD8);
                int v22 = v3;
                if(v22 == 1) {
                    p0.a0(0x2DD6B60F);
                    n6 = n4;
                    N1.b(s1, androidx.compose.foundation.layout.d.q(androidx.compose.foundation.layout.a.n(n4, 0.0f, 6.0f, 0.0f, 0.0f, 13), 144.0f), e0.T(p0, 0x7F06016D), 15.0f, null, null, 0L, new l1.k(5), 17.0f, 2, false, 2, 0, null, null, p0, 0xC30, 0xC36, 0x1D1F0);  // color:gray900s
                }
                else {
                    n6 = n4;
                    p0.a0(769608309);
                    e.d(s1, p0, 0);
                }
                p0.p(false);
                r0.q q25 = androidx.compose.foundation.layout.d.q(androidx.compose.foundation.layout.a.n(n6, 0.0f, 3.0f, 0.0f, 0.0f, 13), 144.0f);
                String s9 = e.Y(p0, 0x7F13089F);  // string:profile_liked_count_playlist "%1$s개 플레이리스트"
                if(v22 != 1) {
                    --v22;
                }
                N1.b(String.format(s9, Arrays.copyOf(new Object[]{StringUtils.getCountFormattedString(v22)}, 1)), q25, e0.T(p0, 0x7F060160), 13.0f, null, null, 0L, new l1.k(5), 0.0f, 2, false, 1, 0, null, null, p0, 0xC30, 0xC30, 0x1D5F0);  // color:gray600s_support_high_contrast
                p0.p(true);
            }
            else {
                p0.a0(0x3FE077A6);
            }
            p0.p(false);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Ac.z(l00, k0, v, 21);
        }
    }

    public static final void k(List list0, we.k k0, l l0, int v) {
        int v8;
        String s6;
        int v7;
        String s5;
        q.g(list0, "playlist");
        q.g(k0, "onEvent");
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0xC7007DCA);
        int v1 = (p0.i(list0) ? 4 : 2) | v | (p0.i(k0) ? 0x20 : 16);
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            boolean z = ((Configuration)p0.k(AndroidCompositionLocals_androidKt.a)).orientation == 1;
            r0.n n0 = r0.n.a;
            if(list0.isEmpty()) {
                p0.a0(305338032);
                r0.q q0 = r0.a.a(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.v(androidx.compose.foundation.layout.a.l(n0, 20.0f, 0.0f, 2), null, 3), 38.0f), new l1(5, k0));
                p0 p00 = M.n0.a(M.j.a, r0.d.k, p0, 0x30);
                int v2 = p0.P;
                androidx.compose.runtime.i0 i00 = p0.m();
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
                androidx.compose.runtime.w.x(p0, p00, P0.j.f);
                androidx.compose.runtime.w.x(p0, i00, P0.j.e);
                P0.h h0 = P0.j.g;
                if(p0.O || !q.b(p0.N(), v2)) {
                    A7.d.q(v2, p0, v2, h0);
                }
                androidx.compose.runtime.w.x(p0, q1, P0.j.d);
                r0.q q2 = androidx.compose.foundation.layout.d.n(n0, 17.0f);
                androidx.compose.foundation.q.c(De.I.Q(0x7F080117, p0, 6), null, q2, null, N0.j.g, 0.0f, null, p0, 25008, 104);  // drawable:btn_common_add_17_gr
                r0.q q3 = androidx.compose.foundation.layout.a.n(n0, 3.0f, 0.0f, 0.0f, 0.0f, 14);
                N1.b(e.Y(p0, 0x7F130C9F), q3, e0.T(p0, 0x7F06017C), 14.0f, null, null, 0L, new l1.k(5), 0.0f, 0, false, 0, 0, null, null, p0, 0xC30, 0, 0x1FDF0);  // string:text_make_playlist "플레이리스트 만들기"
                p0.p(true);
                p0.p(false);
                n0 n00 = p0.t();
                if(n00 != null) {
                    n00.d = new Dd.K(v, 2, list0, k0);
                }
            }
            else {
                p0.a0(0x11D70DB8);
                p0.p(false);
                if(z) {
                    p0.a0(306403316);
                    int v3 = 0;
                    for(Object object0: je.p.U0(list0, 2, 2)) {
                        if(v3 >= 0) {
                            r0.q q4 = androidx.compose.foundation.layout.d.f(n0, 1.0f);
                            p0 p01 = M.n0.a(M.j.a, r0.d.j, p0, 0);
                            int v4 = p0.P;
                            androidx.compose.runtime.i0 i01 = p0.m();
                            r0.q q5 = r0.a.d(p0, q4);
                            P0.k.y.getClass();
                            i i1 = P0.j.b;
                            p0.e0();
                            if(p0.O) {
                                p0.l(i1);
                            }
                            else {
                                p0.o0();
                            }
                            androidx.compose.runtime.w.x(p0, p01, P0.j.f);
                            androidx.compose.runtime.w.x(p0, i01, P0.j.e);
                            P0.h h1 = P0.j.g;
                            if(p0.O || !q.b(p0.N(), v4)) {
                                A7.d.q(v4, p0, v4, h1);
                            }
                            androidx.compose.runtime.w.x(p0, q5, P0.j.d);
                            p0.a0(-140811751);
                            int v5 = 0;
                            for(Object object1: ((List)object0)) {
                                if(v5 >= 0) {
                                    int v6 = v3 * 2 + v5;
                                    r0.q q6 = q0.a(n0, 1.0f);
                                    boolean z1 = ((ArtistPlayListWrapperInfoBase)object1).getIsdj();
                                    String s = ((ArtistPlayListWrapperInfoBase)object1).plylstseq;
                                    if(s == null) {
                                        s = "";
                                    }
                                    String s1 = ((ArtistPlayListWrapperInfoBase)object1).plylsttitle;
                                    String s2 = s1 == null ? "" : s1;
                                    String s3 = ((ArtistPlayListWrapperInfoBase)object1).contsTypeCode;
                                    if(s3 == null) {
                                        s3 = "";
                                    }
                                    String s4 = ((ArtistPlayListWrapperInfoBase)object1).thumbimg;
                                    if(s4 == null) {
                                        s4 = "";
                                    }
                                    if(s1 == null) {
                                        s1 = "";
                                    }
                                    StatsElementsBase statsElementsBase0 = ((ArtistPlayListWrapperInfoBase)object1).statsElements;
                                    if(v6 % 2 == 0) {
                                        s5 = s;
                                        v7 = 1;
                                    }
                                    else {
                                        s5 = s;
                                        v7 = 0;
                                    }
                                    ArrayList arrayList0 = ((ArtistPlayListWrapperInfoBase)object1).taglist;
                                    List list1 = arrayList0 == null ? null : je.p.K0(2, arrayList0);
                                    if(list1 == null) {
                                        p0.a0(0x6CF5BA70);
                                        p0.p(((boolean)0));
                                        s6 = null;
                                    }
                                    else {
                                        p0.a0(0xFB41BBB1);
                                        K1 k10 = p0.N();
                                        if(k10 == androidx.compose.runtime.k.a) {
                                            k10 = new K1(11);
                                            p0.l0(k10);
                                        }
                                        s6 = je.p.q0(list1, " ", null, null, k10, 30);
                                        p0.p(((boolean)0));
                                    }
                                    if(s6 == null) {
                                        s6 = "";
                                    }
                                    String s7 = ((ArtistPlayListWrapperInfoBase)object1).getSeriesThemeLogoImg();
                                    if(list0.size() % 2 != 0) {
                                        if(v6 == e.k.s(list0)) {
                                            v8 = 1;
                                        }
                                    }
                                    else if(v6 == e.k.s(list0) || v6 == e.k.s(list0) - 1) {
                                        v8 = 1;
                                    }
                                    else {
                                        v8 = 0;
                                    }
                                    e.m(q6, z1, s5, s2, s3, s4, s1, statsElementsBase0, v6, ((boolean)v7), ((boolean)v8), s6, (s7 == null ? "" : s7), k0, p0, 0, v1 << 6 & 0x1C00);
                                    ++v5;
                                    continue;
                                }
                                e.k.O();
                                throw null;
                            }
                            p0.p(((boolean)0));
                            if(((List)object0).size() < 2) {
                                p0.a0(-68887109);
                                M.c.d(p0, q0.a(n0, 1.0f));
                            }
                            else {
                                p0.a0(0xFB61B709);
                            }
                            p0.p(((boolean)0));
                            p0.p(true);
                            ++v3;
                            continue;
                        }
                        e.k.O();
                        throw null;
                    }
                    p0.p(0);
                }
                else {
                    p0.a0(0x125BF302);
                    e.l(list0, k0, p0, v1 & 0x7E);
                    p0.p(false);
                }
                goto label_143;
            }
        }
        else {
            p0.T();
        label_143:
            n0 n01 = p0.t();
            if(n01 != null) {
                n01.d = new Dd.K(v, 4, list0, k0);
            }
        }
    }

    public static final void l(List list0, we.k k0, l l0, int v) {
        r0.n n1;
        q.g(list0, "playlist");
        q.g(k0, "onEvent");
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0x9831D0EB);
        int v1 = v | (p0.i(list0) ? 4 : 2) | (p0.i(k0) ? 0x20 : 16);
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            r0.n n0 = r0.n.a;
            r0.q q0 = androidx.compose.foundation.q.u(androidx.compose.foundation.layout.d.f(n0, 1.0f), androidx.compose.foundation.q.t(p0), true, false);
            p0 p00 = M.n0.a(M.j.a, r0.d.j, p0, 0);
            int v2 = p0.P;
            androidx.compose.runtime.i0 i00 = p0.m();
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
            androidx.compose.runtime.w.x(p0, p00, P0.j.f);
            androidx.compose.runtime.w.x(p0, i00, P0.j.e);
            P0.h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            androidx.compose.runtime.w.x(p0, q1, P0.j.d);
            p0.a0(0x5B520AA5);
            int v3 = 0;
            for(Object object0: list0) {
                String s = null;
                if(v3 >= 0) {
                    r0.q q2 = r0.a.a(androidx.compose.foundation.layout.a.n(n0, (v3 == 0 ? 20.0f : 10.0f), 0.0f, (v3 == e.k.s(list0) ? 20.0f : 0.0f), 0.0f, 10), new Dd.m2(k0, ((ArtistPlayListWrapperInfoBase)object0), v3, 0));
                    M.y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
                    int v4 = p0.P;
                    androidx.compose.runtime.i0 i01 = p0.m();
                    r0.q q3 = r0.a.d(p0, q2);
                    P0.k.y.getClass();
                    i i1 = P0.j.b;
                    p0.e0();
                    if(p0.O) {
                        p0.l(i1);
                    }
                    else {
                        p0.o0();
                    }
                    P0.h h1 = P0.j.f;
                    androidx.compose.runtime.w.x(p0, y0, h1);
                    P0.h h2 = P0.j.e;
                    androidx.compose.runtime.w.x(p0, i01, h2);
                    P0.h h3 = P0.j.g;
                    if(p0.O || !q.b(p0.N(), v4)) {
                        A7.d.q(v4, p0, v4, h3);
                    }
                    P0.h h4 = P0.j.d;
                    androidx.compose.runtime.w.x(p0, q3, h4);
                    N0.M m0 = M.p.d(r0.d.a, false);
                    int v5 = p0.P;
                    androidx.compose.runtime.i0 i02 = p0.m();
                    r0.q q4 = r0.a.d(p0, n0);
                    p0.e0();
                    if(p0.O) {
                        p0.l(i1);
                    }
                    else {
                        p0.o0();
                    }
                    androidx.compose.runtime.w.x(p0, m0, h1);
                    androidx.compose.runtime.w.x(p0, i02, h2);
                    if(p0.O || !q.b(p0.N(), v5)) {
                        A7.d.q(v5, p0, v5, h3);
                    }
                    androidx.compose.runtime.w.x(p0, q4, h4);
                    r0.q q5 = e0.K(androidx.compose.foundation.layout.d.n(n0, 144.0f));
                    String s1 = ((ArtistPlayListWrapperInfoBase)object0).thumbimg;
                    r0.b.c(q5, (s1 == null ? "" : s1), 144.0f, null, 0L, T.e.b(4.0f), false, false, p0, 0x6000180, 0xD8);
                    r0.q q6 = androidx.compose.foundation.layout.a.n(n0, 0.0f, 6.0f, 6.0f, 0.0f, 9);
                    r0.q q7 = r0.a.a((androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q6, r0.d.c), new Dd.m2(k0, ((ArtistPlayListWrapperInfoBase)object0), v3, 1));
                    C0.c c0 = De.I.Q(0x7F080309, p0, 6);  // drawable:common_btn_play_01
                    String s2 = e.Y(p0, 0x7F130BB4);  // string:talkback_play "재생"
                    androidx.compose.foundation.layout.b b0 = (androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false));
                    androidx.compose.foundation.q.c(c0, s2, q7, null, N0.j.g, 0.0f, null, p0, 0x6000, 104);
                    String s3 = ((ArtistPlayListWrapperInfoBase)object0).getSeriesThemeLogoImg();
                    if(s3 == null) {
                        s3 = "";
                    }
                    if(s3.length() > 0) {
                        p0.a0(0xE52E3115);
                        n1 = n0;
                        r0.q q8 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.q(b0.a(androidx.compose.foundation.layout.a.n(n0, 11.0f, 0.0f, 0.0f, 10.0f, 6), r0.d.g), 23.0f), 16.0f);
                        String s4 = ((ArtistPlayListWrapperInfoBase)object0).getSeriesThemeLogoImg();
                        if(s4 == null) {
                            s4 = "";
                        }
                        c1.n(q8, s4, null, N0.j.b, true, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x6D80, 0, 0x7FE0);
                    }
                    else {
                        n1 = n0;
                        p0.a0(0xE444516D);
                    }
                    p0.p(false);
                    p0.p(true);
                    r0.q q9 = androidx.compose.foundation.layout.d.q(androidx.compose.foundation.layout.a.n(n1, 0.0f, 9.0f, 0.0f, 0.0f, 13), 144.0f);
                    String s5 = ((ArtistPlayListWrapperInfoBase)object0).plylsttitle;
                    if(s5 == null) {
                        s5 = "";
                    }
                    N1.b(s5, q9, e0.T(p0, 0x7F06016D), 15.0f, null, null, 0L, new l1.k(5), 19.0f, 2, false, 2, 0, null, null, p0, 0xC30, 0xC36, 0x1D1F0);  // color:gray900s
                    ArrayList arrayList0 = ((ArtistPlayListWrapperInfoBase)object0).taglist;
                    List list1 = arrayList0 == null ? null : je.p.K0(2, arrayList0);
                    if(list1 == null) {
                        p0.a0(0xBE0A9F08);
                    }
                    else {
                        p0.a0(1211229209);
                        K1 k10 = p0.N();
                        if(k10 == androidx.compose.runtime.k.a) {
                            k10 = new K1(12);
                            p0.l0(k10);
                        }
                        s = je.p.q0(list1, " ", null, null, k10, 30);
                    }
                    p0.p(false);
                    String s6 = s == null ? "" : s;
                    if(!((ArtistPlayListWrapperInfoBase)object0).getIsdj() || s6.length() <= 0) {
                        p0.a0(0xBD0F2673);
                    }
                    else {
                        p0.a0(0xBE0C5774);
                        N1.b(s6, androidx.compose.foundation.layout.d.q(androidx.compose.foundation.layout.a.n(n1, 0.0f, 4.0f, 0.0f, 0.0f, 13), 144.0f), e0.T(p0, 0x7F060160), 13.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC30, 0xC30, 0x1D7F0);  // color:gray600s_support_high_contrast
                    }
                    p0.p(false);
                    p0.p(true);
                    ++v3;
                    n0 = n1;
                    continue;
                }
                e.k.O();
                throw null;
            }
            p0.p(false);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Dd.K(v, 3, list0, k0);
        }
    }

    public static final void m(r0.q q0, boolean z, String s, String s1, String s2, String s3, String s4, StatsElementsBase statsElementsBase0, int v, boolean z1, boolean z2, String s5, String s6, we.k k0, l l0, int v1, int v2) {
        q.g(k0, "onEvent");
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(-1330074243);
        int v3 = 0x20;
        int v4 = 0x80;
        int v5 = 0x400;
        int v6 = v1 | (p0.g(q0) ? 4 : 2) | (p0.h(z) ? 0x20 : 16) | (p0.g(s) ? 0x100 : 0x80) | (p0.g(s1) ? 0x800 : 0x400) | (p0.g(s2) ? 0x4000 : 0x2000) | (p0.g(s3) ? 0x20000 : 0x10000) | (p0.g(s4) ? 0x100000 : 0x80000) | (p0.i(statsElementsBase0) ? 0x800000 : 0x400000) | (p0.e(v) ? 0x4000000 : 0x2000000) | (p0.h(z1) ? 0x20000000 : 0x10000000);
        int v7 = (v2 & 6) == 0 ? v2 | (p0.h(z2) ? 4 : 2) : v2;
        if((v2 & 0x30) == 0) {
            if(!p0.g(s5)) {
                v3 = 16;
            }
            v7 |= v3;
        }
        if((v2 & 0x180) == 0) {
            if(p0.g(s6)) {
                v4 = 0x100;
            }
            v7 |= v4;
        }
        if((v2 & 0xC00) == 0) {
            if(p0.i(k0)) {
                v5 = 0x800;
            }
            v7 |= v5;
        }
        if(p0.Q(v6 & 1, (v6 & 306783379) != 306783378 || (v7 & 0x493) != 1170)) {
            r0.q q1 = r0.a.a(androidx.compose.foundation.layout.d.t(androidx.compose.foundation.layout.a.n(q0, (z1 ? 20.0f : 6.0f), 0.0f, (z1 ? 6.0f : 20.0f), (z2 ? 0.0f : 20.0f), 2), 3), new o2(k0, z, s, s1, s2, v));
            M.y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
            int v8 = p0.P;
            androidx.compose.runtime.i0 i00 = p0.m();
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
            if(p0.O || !q.b(p0.N(), v8)) {
                A7.d.q(v8, p0, v8, h2);
            }
            P0.h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q2, h3);
            N0.M m0 = M.p.d(r0.d.a, false);
            int v9 = p0.P;
            androidx.compose.runtime.i0 i01 = p0.m();
            r0.n n0 = r0.n.a;
            r0.q q3 = r0.a.d(p0, n0);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m0, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v9)) {
                A7.d.q(v9, p0, v9, h2);
            }
            androidx.compose.runtime.w.x(p0, q3, h3);
            e.n(v6 >> 15 & 14 | v6 << 3 & 0x70, p0, s3, q0);
            r0.q q4 = androidx.compose.foundation.layout.a.n(n0, 0.0f, 6.0f, 6.0f, 0.0f, 9);
            r0.q q5 = r0.a.a((androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q4, r0.d.c), new q2(k0, z, s, s1, s2, statsElementsBase0, v));
            C0.c c0 = De.I.Q(0x7F080309, p0, 6);  // drawable:common_btn_play_01
            String s7 = e.Y(p0, 0x7F130BB4);  // string:talkback_play "재생"
            androidx.compose.foundation.layout.b b0 = (androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false));
            androidx.compose.foundation.q.c(c0, s7, q5, null, N0.j.g, 0.0f, null, p0, 0x6000, 104);
            if(s6.length() > 0) {
                p0.a0(0x335C28E3);
                c1.n(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.q(b0.a(androidx.compose.foundation.layout.a.n(n0, 11.0f, 0.0f, 0.0f, 10.0f, 6), r0.d.g), 23.0f), 16.0f), s6, null, N0.j.b, true, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, v7 >> 3 & 0x70 | 0x6D80, 0, 0x7FE0);
            }
            else {
                p0.a0(850535713);
            }
            p0.p(false);
            p0.p(true);
            N1.b(s4, androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.a.n(n0, 0.0f, 9.0f, 0.0f, 0.0f, 13), 1.0f), e0.T(p0, 0x7F06016D), 15.0f, null, null, 0L, new l1.k(5), 19.0f, 2, false, 2, 0, null, null, p0, v6 >> 18 & 14 | 0xC30, 0xC36, 0x1D1F0);  // color:gray900s
            if(!z || s5.length() <= 0) {
                p0.a0(0x6F95E5DB);
            }
            else {
                p0.a0(0x704DDD46);
                N1.b(s5, androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.a.n(n0, 0.0f, 4.0f, 0.0f, 0.0f, 13), 1.0f), e0.T(p0, 0x7F060160), 13.0f, null, null, 0L, new l1.k(5), 0.0f, 2, false, 1, 0, null, null, p0, v7 >> 3 & 14 | 0xC30, 0xC30, 0x1D5F0);  // color:gray600s_support_high_contrast
            }
            p0.p(false);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new j2(q0, z, s, s1, s2, s3, s4, statsElementsBase0, v, z1, z2, s5, s6, k0, v1, v2);
        }
    }

    public static final void n(int v, l l0, String s, r0.q q0) {
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0x63808848);
        int v1 = (v & 6) == 0 ? (p0.g(s) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (p0.g(q0) ? 0x20 : 16);
        }
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            r0.q q1 = androidx.compose.foundation.layout.a.d(1.0f, q0, false);
            N0.M m0 = M.p.d(r0.d.a, false);
            int v2 = p0.P;
            androidx.compose.runtime.i0 i00 = p0.m();
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
            androidx.compose.runtime.w.x(p0, m0, P0.j.f);
            androidx.compose.runtime.w.x(p0, i00, P0.j.e);
            P0.h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            androidx.compose.runtime.w.x(p0, q2, P0.j.d);
            T.d d0 = T.e.b(4.0f);
            r0.q q3 = androidx.compose.foundation.q.f(d5.n.o(androidx.compose.foundation.layout.d.c, d0), e0.T(p0, 0x7F060145), y0.M.a);  // color:gray050s
            androidx.compose.foundation.q.c(De.I.Q(0x7F080788, p0, 6), null, q3, null, N0.j.f, 0.0f, null, p0, 0x6030, 104);  // drawable:noimage_logo_medium
            ImageRequest.Builder imageRequest$Builder0 = new ImageRequest.Builder(((Context)p0.k(AndroidCompositionLocals_androidKt.b)));
            imageRequest$Builder0.c = s;
            imageRequest$Builder0.n = Boolean.TRUE;
            t5.j j0 = imageRequest$Builder0.a();
            T.d d1 = T.e.b(4.0f);
            j5.n.b(j0, null, d5.n.o(androidx.compose.foundation.layout.d.c, d1), null, N0.j.b, null, p0, 0x180030, 0xFB8);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new w0(s, q0, v, 3);
        }
    }

    public static final void o(d2 d20, we.a a0, l l0, int v) {
        float f;
        q.g(d20, "uiState");
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(1165582055);
        int v1 = (p0.g(d20) ? 4 : 2) | v | (p0.i(a0) ? 0x20 : 16);
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            switch(d20.d) {
                case "TITLE_TYPE_ARTIST": 
                case "TITLE_TYPE_LIKE": 
                case "TITLE_TYPE_MAGAZINE": 
                case "TITLE_TYPE_SONG": 
                case "TITLE_TYPE_STATION": 
                case "TITLE_TYPE_VIDEO": {
                    f = 40.0f;
                    break;
                }
                case "TITLE_TYPE_OFFER_PLAYLIST": 
                case "TITLE_TYPE_PLAYLIST": 
                case "TITLE_TYPE_SERIES_PLAYLIST": {
                    f = 30.0f;
                    break;
                }
                default: {
                    f = 0.0f;
                }
            }
            r0.n n0 = r0.n.a;
            r0.q q0 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.a.n(n0, 20.0f, f, 20.0f, 0.0f, 8), 1.0f), 48.0f);
            p0 p00 = M.n0.a(M.j.a, r0.d.k, p0, 0x30);
            int v2 = p0.P;
            androidx.compose.runtime.i0 i00 = p0.m();
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
            androidx.compose.runtime.w.x(p0, p00, P0.j.f);
            androidx.compose.runtime.w.x(p0, i00, P0.j.e);
            P0.h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            androidx.compose.runtime.w.x(p0, q1, P0.j.d);
            r0.q q2 = U4.x.r(1.0f, androidx.compose.foundation.layout.a.n(n0, 0.0f, 0.0f, 15.0f, 0.0f, 11), true);
            long v3 = e0.T(p0, 0x7F06016D);  // color:gray900s
            l1.k k0 = new l1.k(5);
            N1.b(d20.b, q2, v3, 21.0f, e1.y.i, null, 0L, k0, 0.0f, 2, false, 1, 0, null, null, p0, 0x30C00, 0xC30, 0x1D5D0);
            if(d20.c) {
                p0.a0(0xC8D7EE67);
                r0.q q3 = r0.a.a(n0, new u3(24, a0));
                N1.b(e.Y(p0, 0x7F13056E), q3, e0.T(p0, 0x7F060160), 15.0f, null, null, 0L, new l1.k(3), 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FDF0);  // string:main_common_view_all "전체보기"
            }
            else {
                p0.a0(-930652001);
            }
            p0.p(false);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Ac.z(d20, a0, v, 22);
        }
    }

    public static final void p(we.a a0, j j0, m0.b b0, l l0, int v, int v1) {
        T.d d0 = ((Z.I)((androidx.compose.runtime.p)l0).k(Z.J.a)).a;
        j j1 = (v1 & 0x80) == 0 ? j0 : Z.a.b(0L, l0, 7);
        e.b(a0, r0.n.a, true, null, d0, j1, Z.a.d, b0, l0, v & 0x7FFFFFFE, 0);
    }

    public static final Object q(J0.L l0, oe.a a0) {
        Y.p p0;
        if(a0 instanceof Y.p) {
            p0 = (Y.p)a0;
            int v = p0.B;
            if((v & 0x80000000) == 0) {
                p0 = new Y.p(a0);  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
            }
            else {
                p0.B = v ^ 0x80000000;
            }
        }
        else {
            p0 = new Y.p(a0);  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
        }
        Object object0 = p0.w;
        ne.a a1 = ne.a.a;
        switch(p0.B) {
            case 0: {
                d5.n.D(object0);
                goto label_24;
            }
            case 1: {
                l0 = p0.r;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    alab1:
        while(true) {
            Object object1 = ((n)object0).a;
            int v1 = ((Collection)object1).size();
            int v2 = 0;
            while(true) {
                if(v2 >= v1) {
                    break alab1;
                }
                if(J0.u.a(((v)((List)object1).get(v2)))) {
                    ++v2;
                    continue;
                }
            label_24:
                p0.r = l0;
                p0.B = 1;
                object0 = l0.a(J0.o.b, p0);
                if(object0 != a1) {
                    break;
                }
                return a1;
            }
        }
        return (n)object0;
    }

    public static final String r(Method method0) {
        Class[] arr_class = method0.getParameterTypes();
        q.f(arr_class, "getParameterTypes(...)");
        Class class0 = method0.getReturnType();
        q.f(class0, "getReturnType(...)");
        return method0.getName() + je.n.r0(arr_class, "", "(", ")", Ge.b.j, 24) + Se.c.b(class0);
    }

    public static final Object s(J0.L l0, Ua.h h0, B7.b b0, n n0, oe.a a0) {
        kotlin.jvm.internal.C c0;
        boolean z;
        T7.b b2;
        Y.q q0;
        T7.b b1 = Y.n.d;
        if(a0 instanceof Y.q) {
            q0 = (Y.q)a0;
            int v = q0.E;
            if((v & 0x80000000) == 0) {
                q0 = new Y.q(a0);  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
            }
            else {
                q0.E = v ^ 0x80000000;
            }
        }
        else {
            q0 = new Y.q(a0);  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
        }
        Object object0 = q0.D;
        ne.a a1 = ne.a.a;
        switch(q0.E) {
            case 0: {
                d5.n.D(object0);
                b1 b10 = (b1)b0.b;
                v v4 = (v)b0.c;
                v v5 = (v)((List)n0.a).get(0);
                if(v4 == null) {
                    b0.a = 1;
                }
                else {
                    long v6 = b10.a();
                    if(v5.b - v4.b < v6) {
                        float f = I.I.g(b10, v4.i);
                        if(x0.b.c(x0.b.f(v4.c, v5.c)) < f) {
                            ++b0.a;
                        }
                        else {
                            b0.a = 1;
                        }
                    }
                    else {
                        b0.a = 1;
                    }
                }
                b0.c = v5;
                Object object2 = ((List)n0.a).get(0);
                switch(b0.a) {
                    case 1: {
                        b2 = b1;
                        break;
                    }
                    case 2: {
                        b2 = Y.n.e;
                        break;
                    }
                    default: {
                        b2 = Y.n.f;
                    }
                }
                long v7 = ((v)object2).c;
                Y.Q q1 = (Y.Q)h0.a;
                if(!q1.k() || q1.m().a.b.length() == 0 || (q1.d == null || q1.d.d() == null)) {
                    z = false;
                }
                else {
                    w0.p p0 = q1.l;
                    if(p0 != null) {
                        w0.p.b(p0);
                    }
                    q1.o = v7;
                    q1.t = -1;
                    z = true;
                    q1.h(true);
                    h0.P(q1.m(), q1.o, true, b2);
                }
                if(z) {
                    c0 = new kotlin.jvm.internal.C();  // 初始化器: Ljava/lang/Object;-><init>()V
                    c0.a = !b2.equals(b1);
                    F.g g0 = new F.g(h0, b2, c0, 16);
                    q0.r = l0;
                    q0.w = h0;
                    q0.B = c0;
                    q0.E = 2;
                    object0 = I.I.e(l0, ((v)object2).a, g0, q0);
                    if(object0 == a1) {
                        return a1;
                    }
                    goto label_83;
                }
                break;
            }
            case 1: {
                Ua.h h1 = q0.w;
                J0.L l1 = q0.r;
                d5.n.D(object0);
                if(((Boolean)object0).booleanValue()) {
                    Object object1 = l1.f.e.a;
                    int v2 = ((Collection)object1).size();
                    for(int v1 = 0; v1 < v2; ++v1) {
                        v v3 = (v)((List)object1).get(v1);
                        if(J0.u.b(v3)) {
                            v3.a();
                        }
                    }
                }
                h1.getClass();
                return H.a;
            }
            case 2: {
                kotlin.jvm.internal.C c1 = q0.B;
                h0 = q0.w;
                J0.L l2 = q0.r;
                d5.n.D(object0);
                c0 = c1;
                l0 = l2;
            label_83:
                if(((Boolean)object0).booleanValue() && c0.a) {
                    Object object3 = l0.f.e.a;
                    int v8 = ((Collection)object3).size();
                    for(int v9 = 0; v9 < v8; ++v9) {
                        v v10 = (v)((List)object3).get(v9);
                        if(J0.u.b(v10)) {
                            v10.a();
                        }
                    }
                }
                h0.getClass();
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return H.a;
    }

    public static final String t(androidx.media3.session.w0 w00) {
        return "ControllerInfo[packageName: " + w00.a() + ", connectionHints: " + new Bundle(w00.e) + "]";
    }

    public static final Object u(J0.L l0, t0 t00, n n0, oe.a a0) {
        ne.a a1;
        Object object0;
        Y.s s0;
        if(a0 instanceof Y.s) {
            s0 = (Y.s)a0;
            int v = s0.E;
            if((v & 0x80000000) == 0) {
                s0 = new Y.s(a0);  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
            }
            else {
                s0.E = v ^ 0x80000000;
            }
        }
        else {
            s0 = new Y.s(a0);  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
        }
        try {
            object0 = s0.D;
            a1 = ne.a.a;
            switch(s0.E) {
                case 0: {
                    goto label_14;
                }
                case 1: {
                    goto label_23;
                }
                case 2: {
                    goto label_42;
                }
            }
        }
        catch(CancellationException cancellationException0) {
            t00.onCancel();
            throw cancellationException0;
        }
        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
    label_14:
        d5.n.D(object0);
        try {
            v v2 = (v)je.p.k0(((List)n0.a));
            s0.r = l0;
            s0.w = t00;
            s0.B = v2;
            s0.E = 1;
            object0 = I.I.b(l0, v2.a, s0);
            if(object0 == a1) {
                return a1;
            }
            goto label_29;
        label_23:
            v v3 = s0.B;
            t00 = s0.w;
            J0.L l1 = s0.r;
            d5.n.D(object0);
            v2 = v3;
            l0 = l1;
        label_29:
            if(((v)object0) != null) {
                long v4 = ((v)object0).c;
                float f = I.I.g(l0.f(), v2.i);
                if(x0.b.c(x0.b.f(v2.c, v4)) < f) {
                    t00.b(v4);
                    U.l0 l00 = new U.l0(t00, 1);
                    s0.r = l0;
                    s0.w = t00;
                    s0.B = null;
                    s0.E = 2;
                    object0 = I.I.e(l0, ((v)object0).a, l00, s0);
                    if(object0 == a1) {
                        return a1;
                    label_42:
                        t00 = s0.w;
                        l0 = s0.r;
                        d5.n.D(object0);
                    }
                    if(((Boolean)object0).booleanValue()) {
                        Object object1 = l0.f.e.a;
                        int v5 = ((Collection)object1).size();
                        for(int v1 = 0; v1 < v5; ++v1) {
                            v v6 = (v)((List)object1).get(v1);
                            if(J0.u.b(v6)) {
                                v6.a();
                            }
                        }
                        t00.onStop();
                        return H.a;
                    }
                    t00.onCancel();
                }
            }
            return H.a;
        }
        catch(CancellationException cancellationException0) {
            t00.onCancel();
            throw cancellationException0;
        }
    }

    public static void v(TextInputLayout textInputLayout0, CheckableImageButton checkableImageButton0, ColorStateList colorStateList0, PorterDuff.Mode porterDuff$Mode0) {
        Drawable drawable0 = checkableImageButton0.getDrawable();
        if(drawable0 != null) {
            drawable0 = drawable0.mutate();
            if(colorStateList0 == null || !colorStateList0.isStateful()) {
                drawable0.setTintList(colorStateList0);
            }
            else {
                int[] arr_v = textInputLayout0.getDrawableState();
                int[] arr_v1 = checkableImageButton0.getDrawableState();
                int[] arr_v2 = Arrays.copyOf(arr_v, arr_v.length + arr_v1.length);
                System.arraycopy(arr_v1, 0, arr_v2, arr_v.length, arr_v1.length);
                drawable0.setTintList(ColorStateList.valueOf(colorStateList0.getColorForState(arr_v2, colorStateList0.getDefaultColor())));
            }
            if(porterDuff$Mode0 != null) {
                drawable0.setTintMode(porterDuff$Mode0);
            }
        }
        if(checkableImageButton0.getDrawable() != drawable0) {
            checkableImageButton0.setImageDrawable(drawable0);
        }
    }

    public static final void w(I i0) {
        q.g(i0, "<this>");
        FragmentActivity fragmentActivity0 = i0.getActivity();
        if(fragmentActivity0 == null) {
            return;
        }
        fragmentActivity0.onBackPressed();
    }

    public static final boolean x(ArrayList arrayList0) {
        je.w w0;
        if(arrayList0.size() >= 2) {
            if(arrayList0.size() <= 1) {
                w0 = je.w.a;
            }
            else {
                ArrayList arrayList1 = new ArrayList();
                Object object0 = arrayList0.get(0);
                int v = e.k.s(arrayList0);
                int v1 = 0;
                while(v1 < v) {
                    ++v1;
                    Object object1 = arrayList0.get(v1);
                    arrayList1.add(new x0.b(((long)Float.floatToRawIntBits(Math.abs(Float.intBitsToFloat(((int)(((p)object0).e().a() >> 0x20))) - Float.intBitsToFloat(((int)(((p)object1).e().a() >> 0x20)))))) << 0x20 | ((long)Float.floatToRawIntBits(Math.abs(Float.intBitsToFloat(((int)(((p)object0).e().a() & 0xFFFFFFFFL))) - Float.intBitsToFloat(((int)(((p)object1).e().a() & 0xFFFFFFFFL)))))) & 0xFFFFFFFFL));
                    object0 = object1;
                }
                w0 = arrayList1;
            }
            if(w0.size() == 1) {
                long v2 = ((x0.b)je.p.k0(w0)).a;
                return Float.intBitsToFloat(((int)(0xFFFFFFFFL & v2))) < Float.intBitsToFloat(((int)(v2 >> 0x20)));
            }
            if(w0.isEmpty()) {
                t1.a.b("Empty collection can\'t be reduced.");
            }
            x0.b b0 = je.p.k0(w0);
            int v3 = e.k.s(w0);
            if(1 <= v3) {
                for(int v4 = 1; true; ++v4) {
                    long v5 = ((x0.b)w0.get(v4)).a;
                    b0 = new x0.b(x0.b.g(b0.a, v5));
                    if(v4 == v3) {
                        break;
                    }
                }
            }
            return Float.intBitsToFloat(((int)(0xFFFFFFFFL & b0.a))) < Float.intBitsToFloat(((int)(b0.a >> 0x20)));
        }
        return true;
    }

    public static long y(long v, long v1) {
        long v2 = v + v1;
        int v3 = 0;
        int v4 = Long.compare(v ^ v1, 0L) >= 0 ? 0 : 1;
        if((v ^ v2) >= 0L) {
            v3 = 1;
        }
        if((v4 | v3) == 0) {
            throw new ArithmeticException(U4.x.h(v1, ")", k8.Y.o(v, "overflow: checkedAdd(", ", ")));
        }
        return v2;
    }

    public static String z(String s) [...] // 潜在的解密器
}

