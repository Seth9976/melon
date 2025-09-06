package d5;

import Ac.Z3;
import Cc.N1;
import Cc.c1;
import Cc.e0;
import De.I;
import F.e;
import G.f;
import G.j;
import M.c;
import M.j0;
import M.n0;
import M.y;
import N0.M;
import O.F;
import Q0.N;
import Qb.z;
import U4.D;
import U4.x;
import X7.d;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaRoute2Info;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.E0;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.runtime.E;
import androidx.compose.runtime.I0;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.Z;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.p;
import androidx.fragment.app.l0;
import androidx.recyclerview.widget.p0;
import cd.V2;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.popup.MelonTextPopup;
import com.iloen.melon.popup.PopupHelper;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.network.CookieHelper;
import com.iloen.melon.utils.network.NetUtils;
import df.v;
import e5.h;
import ed.w0;
import gd.M0;
import gd.T7;
import gd.Y1;
import gd.Z1;
import gd.b2;
import gd.c2;
import gd.d2;
import gd.h2;
import h7.u0;
import i.n.i.b.a.s.e.M3;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import l4.P;
import l4.i;
import l4.u;
import m8.a0;
import m8.c0;
import m8.f0;
import o0.b;
import o0.k;
import o0.l;
import o0.m;
import r0.g;
import r0.n;
import rd.k0;
import ud.s;
import va.o;
import vd.G;
import we.a;
import zd.D0;

public abstract class w implements d {
    public static final int a;
    public static final int b;
    public static final int c;
    public static boolean d;
    public static String e;
    public static final int f;

    public int A() {
        return 10;
    }

    public static Drawable B(Context context0, int v) {
        return E0.b().c(context0, v);
    }

    public static final ViewParent C(View view0) {
        ViewParent viewParent0 = view0.getParent();
        if(viewParent0 != null) {
            return viewParent0;
        }
        Object object0 = view0.getTag(0x7F0A0DD0);  // id:view_tree_disjoint_parent
        return object0 instanceof ViewParent ? ((ViewParent)object0) : null;
    }

    public static ArrayList D(List list0) {
        if(list0 == null) {
            return new ArrayList();
        }
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: list0) {
            MediaRoute2Info mediaRoute2Info0 = (MediaRoute2Info)object0;
            if(mediaRoute2Info0 != null) {
                arrayList0.add(i.j(mediaRoute2Info0));
            }
        }
        return arrayList0;
    }

    public static final boolean E(NetworkInterface networkInterface0) {
        List list0 = networkInterface0.getInterfaceAddresses();
        q.f(list0, "interfaceAddresses");
        if(list0 instanceof Collection && list0.isEmpty()) {
            return false;
        }
        for(Object object0: list0) {
            q.f(((InterfaceAddress)object0), "it");
            InetAddress inetAddress0 = ((InterfaceAddress)object0).getAddress();
            q.f(inetAddress0, "it.address");
            if(inetAddress0 instanceof Inet4Address) {
                return true;
            }
            if(false) {
                break;
            }
        }
        return false;
    }

    public static final boolean F(NetworkInterface networkInterface0) {
        List list0 = networkInterface0.getInterfaceAddresses();
        q.f(list0, "interfaceAddresses");
        if(!(list0 instanceof Collection) || !list0.isEmpty()) {
            for(Object object0: list0) {
                q.f(((InterfaceAddress)object0), "it");
                InetAddress inetAddress0 = ((InterfaceAddress)object0).getAddress();
                q.f(inetAddress0, "it.address");
                if(inetAddress0 instanceof Inet6Address && ((Inet6Address)inetAddress0).isLinkLocalAddress()) {
                    return true;
                }
                if(false) {
                    break;
                }
            }
        }
        return false;
    }

    public static final int G(int v) {
        switch(v) {
            case 0: {
                return 1;
            }
            case 1: {
                return 2;
            }
            default: {
                throw new IllegalArgumentException("Could not convert " + v + " to BackoffPolicy");
            }
        }
    }

    public static final int H(int v) {
        switch(v) {
            case 0: {
                return 1;
            }
            case 1: {
                return 2;
            }
            case 2: {
                return 3;
            }
            case 3: {
                return 4;
            }
            case 4: {
                return 5;
            }
            default: {
                if(Build.VERSION.SDK_INT < 30 || v != 5) {
                    throw new IllegalArgumentException("Could not convert " + v + " to NetworkType");
                }
                return 6;
            }
        }
    }

    public static final int I(int v) {
        switch(v) {
            case 0: {
                return 1;
            }
            case 1: {
                return 2;
            }
            default: {
                throw new IllegalArgumentException("Could not convert " + v + " to OutOfQuotaPolicy");
            }
        }
    }

    public static final D J(int v) {
        switch(v) {
            case 0: {
                return D.a;
            }
            case 1: {
                return D.b;
            }
            case 2: {
                return D.c;
            }
            case 3: {
                return D.d;
            }
            case 4: {
                return D.e;
            }
            case 5: {
                return D.f;
            }
            default: {
                throw new IllegalArgumentException("Could not convert " + v + " to State");
            }
        }
    }

    public static final boolean K(NetworkInterface networkInterface0) {
        q.g(networkInterface0, "$this$isAvailableInet4Interface");
        return w.M(networkInterface0) && w.E(networkInterface0);
    }

    public static final boolean L(NetworkInterface networkInterface0) {
        q.g(networkInterface0, "$this$isAvailableInet6Interface");
        return w.M(networkInterface0) && w.F(networkInterface0);
    }

    public static final boolean M(NetworkInterface networkInterface0) {
        try {
            if(!networkInterface0.isLoopback() && networkInterface0.isUp() && networkInterface0.supportsMulticast()) {
                return true;
            }
        }
        catch(SocketException unused_ex) {
        }
        return false;
    }

    public static final byte[] N(InputStream inputStream0) {
        q.g(inputStream0, "<this>");
        ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream(Math.max(0x2000, inputStream0.available()));
        w.t(inputStream0, byteArrayOutputStream0);
        byte[] arr_b = byteArrayOutputStream0.toByteArray();
        q.f(arr_b, "toByteArray(...)");
        return arr_b;
    }

    public static final b0 O(Object[] arr_object, l l0, a a0, androidx.compose.runtime.l l1) {
        Object[] arr_object1 = Arrays.copyOf(arr_object, arr_object.length);
        q.e(l0, "null cannot be cast to non-null type androidx.compose.runtime.saveable.Saver<T of androidx.compose.runtime.saveable.RememberSaveableKt.mutableStateSaver, kotlin.Any>");
        return (b0)w.P(arr_object1, new d5.l(13, new e(l0, 20), new androidx.compose.foundation.w(l0, 17)), null, a0, l1, 0, 0);
    }

    public static final Object P(Object[] arr_object, l l0, String s, a a0, androidx.compose.runtime.l l1, int v, int v1) {
        Object object4;
        Object object3;
        if((v1 & 2) != 0) {
            l0 = m.a;
        }
        Object object0 = null;
        if((v1 & 4) != 0) {
            s = null;
        }
        int v2 = ((p)l1).P;
        if(s == null || s.length() == 0) {
            u0.l(36);
            s = Integer.toString(v2, 36);
            q.f(s, "toString(...)");
        }
        q.e(l0, "null cannot be cast to non-null type androidx.compose.runtime.saveable.Saver<T of androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable, kotlin.Any>");
        Object object1 = ((p)l1).k(k.a);
        b b0 = ((p)l1).N();
        V v3 = androidx.compose.runtime.k.a;
        if(b0 == v3) {
            if(((o0.i)object1) == null) {
                object3 = null;
            }
            else {
                Object object2 = ((o0.i)object1).c(s);
                object3 = object2 == null ? null : l0.d(object2);
            }
            if(object3 == null) {
                object3 = a0.invoke();
            }
            b b1 = new b(l0, ((o0.i)object1), s, object3, arr_object);
            ((p)l1).l0(b1);
            b0 = b1;
        }
        if(Arrays.equals(arr_object, b0.e)) {
            object0 = b0.d;
        }
        if(object0 == null) {
            object0 = a0.invoke();
        }
        boolean z = ((p)l1).i(b0);
        boolean z1 = ((p)l1).i(l0);
        boolean z2 = ((p)l1).i(((o0.i)object1));
        boolean z3 = ((p)l1).g(s);
        boolean z4 = ((p)l1).i(object0);
        boolean z5 = ((p)l1).i(arr_object);
        o0.a a1 = ((p)l1).N();
        if((z | z1 | z2 | z3 | z4 | z5) != 0 || a1 == v3) {
            object4 = object0;
            o0.a a2 = new o0.a(b0, l0, ((o0.i)object1), s, object4, arr_object);
            ((p)l1).l0(a2);
            a1 = a2;
        }
        else {
            object4 = object0;
        }
        J.h(a1, ((p)l1));
        return object4;
    }

    public static final r0.q Q(r0.q q0, float f) {
        return Float.compare(f, 1.0f) == 0 ? q0 : androidx.compose.ui.graphics.a.b(q0, f, f, 0.0f, 0.0f, 0.0f, null, false, 0x1FFFC);
    }

    public static final int R(D d0) {
        int v = 1;
        q.g(d0, "state");
        int v1 = d0.ordinal();
        switch(v1) {
            case 0: {
                return 0;
            label_6:
                if(v1 != 2 && v1 != 3) {
                    v = 4;
                    switch(v1) {
                        case 4: {
                            break;
                        }
                        case 5: {
                            return 5;
                        }
                        default: {
                            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                        }
                    }
                }
                break;
            }
            case 1: {
                break;
            }
            default: {
                goto label_6;
            }
        }
        return v;
    }

    public static final String S(InetAddress inetAddress0, int v) {
        String s;
        q.g(inetAddress0, "$this$toAddressString");
        if(inetAddress0 instanceof Inet6Address) {
            s = "[" + w.V(((Inet6Address)inetAddress0)) + ']';
            return v == 80 || v <= 0 ? s : s + ':' + v;
        }
        s = inetAddress0.getHostAddress();
        q.f(s, "hostAddress");
        return v == 80 || v <= 0 ? s : s + ':' + v;
    }

    public static u T(MediaRoute2Info mediaRoute2Info0) {
        int v;
        if(mediaRoute2Info0 != null) {
            d5.i i0 = new d5.i(i.j(mediaRoute2Info0), l4.p.h(mediaRoute2Info0).toString());
            Bundle bundle0 = (Bundle)i0.a;
            bundle0.putInt("connectionState", P.b(mediaRoute2Info0));
            bundle0.putInt("volumeHandling", P.r(mediaRoute2Info0));
            bundle0.putInt("volumeMax", P.u(mediaRoute2Info0));
            bundle0.putInt("volume", P.w(mediaRoute2Info0));
            Bundle bundle1 = i.i(mediaRoute2Info0);
            if(bundle1 == null) {
                bundle0.putBundle("extras", null);
            }
            else {
                bundle0.putBundle("extras", new Bundle(bundle1));
            }
            bundle0.putBoolean("enabled", true);
            bundle0.putBoolean("canDisconnect", false);
            if(Build.VERSION.SDK_INT >= 34) {
                bundle0.putStringArrayList("deduplicationIds", new ArrayList(androidx.core.widget.l.f(mediaRoute2Info0)));
                v = 2;
                switch(androidx.core.widget.l.i(mediaRoute2Info0)) {
                    case 2: {
                        v = 12;
                        break;
                    }
                    case 3: {
                        v = 13;
                        break;
                    }
                    case 4: {
                        v = 14;
                        break;
                    }
                    case 8: {
                        v = 3;
                        break;
                    }
                    case 9: {
                        v = 16;
                        break;
                    }
                    case 10: {
                        v = 23;
                        break;
                    }
                    case 11: {
                        v = 17;
                        break;
                    }
                    case 12: {
                        v = 18;
                        break;
                    }
                    case 13: {
                        v = 19;
                        break;
                    }
                    case 22: {
                        v = 20;
                        break;
                    }
                    case 23: {
                        v = 21;
                        break;
                    }
                    case 26: {
                        v = 22;
                        break;
                    }
                    case 29: {
                        v = 24;
                        break;
                    }
                    case 1001: {
                        v = 1;
                        break;
                    }
                    case 1002: {
                        break;
                    }
                    case 1003: {
                        v = 4;
                        break;
                    }
                    case 1004: {
                        v = 5;
                        break;
                    }
                    case 1005: {
                        v = 6;
                        break;
                    }
                    case 1006: {
                        v = 7;
                        break;
                    }
                    case 1007: {
                        v = 8;
                        break;
                    }
                    case 0x3F0: {
                        v = 9;
                        break;
                    }
                    case 1009: {
                        v = 10;
                        break;
                    }
                    case 1010: {
                        v = 11;
                        break;
                    }
                    case 2000: {
                        v = 1000;
                        break;
                    }
                    default: {
                        v = 0;
                    }
                }
            }
            else {
                v = 0;
            }
            CharSequence charSequence0 = P.k(mediaRoute2Info0);
            if(charSequence0 != null) {
                bundle0.putString("status", charSequence0.toString());
            }
            Uri uri0 = P.j(mediaRoute2Info0);
            if(uri0 != null) {
                bundle0.putString("iconUri", uri0.toString());
            }
            Bundle bundle2 = i.i(mediaRoute2Info0);
            if(bundle2 != null && bundle2.containsKey("androidx.mediarouter.media.KEY_EXTRAS") && bundle2.containsKey("androidx.mediarouter.media.KEY_DEVICE_TYPE") && bundle2.containsKey("androidx.mediarouter.media.KEY_CONTROL_FILTERS")) {
                Bundle bundle3 = bundle2.getBundle("androidx.mediarouter.media.KEY_EXTRAS");
                if(bundle3 == null) {
                    bundle0.putBundle("extras", null);
                }
                else {
                    bundle0.putBundle("extras", new Bundle(bundle3));
                }
                if(v == 0) {
                    v = bundle2.getInt("androidx.mediarouter.media.KEY_DEVICE_TYPE", 0);
                }
                bundle0.putInt("deviceType", v);
                bundle0.putInt("playbackType", bundle2.getInt("androidx.mediarouter.media.KEY_PLAYBACK_TYPE", 1));
                ArrayList arrayList0 = bundle2.getParcelableArrayList("androidx.mediarouter.media.KEY_CONTROL_FILTERS");
                if(arrayList0 != null) {
                    i0.a(arrayList0);
                }
                List list0 = l4.p.j(mediaRoute2Info0);
                if(list0.contains("android.media.route.feature.REMOTE_DYNAMIC_GROUP_ROUTE")) {
                    bundle0.putBoolean("isDynamicGroupRoute", true);
                }
                if(list0.contains("android.media.route.feature.REMOTE_GROUP_PLAYBACK")) {
                    ArrayList arrayList1 = bundle2.getStringArrayList("androidx.mediarouter.media.KEY_GROUP_MEMBER_IDS");
                    if(arrayList1 != null && !arrayList1.isEmpty()) {
                        i0.b(arrayList1);
                        return i0.d();
                    }
                    Log.w("MediaRouter2Utils", "Invalid feature of a group without members");
                }
                return i0.d();
            }
        }
        return null;
    }

    public static final h U(byte[] arr_b) {
        h h0;
        ObjectInputStream objectInputStream0;
        q.g(arr_b, "bytes");
        if(Build.VERSION.SDK_INT >= 28 && arr_b.length != 0) {
            ByteArrayInputStream byteArrayInputStream0 = new ByteArrayInputStream(arr_b);
            try {
                objectInputStream0 = new ObjectInputStream(byteArrayInputStream0);
            }
            catch(Throwable throwable0) {
                d8.d.l(byteArrayInputStream0, throwable0);
                throw throwable0;
            }
            try {
                int v = objectInputStream0.readInt();
                int[] arr_v = new int[v];
                for(int v2 = 0; v2 < v; ++v2) {
                    arr_v[v2] = objectInputStream0.readInt();
                }
                int v3 = objectInputStream0.readInt();
                int[] arr_v1 = new int[v3];
                for(int v1 = 0; v1 < v3; ++v1) {
                    arr_v1[v1] = objectInputStream0.readInt();
                }
                h0 = e5.i.c(arr_v1, arr_v);
                goto label_25;
            }
            catch(Throwable throwable1) {
            }
            try {
                throw throwable1;
            }
            catch(Throwable throwable2) {
                try {
                    d8.d.l(objectInputStream0, throwable1);
                    throw throwable2;
                label_25:
                    objectInputStream0.close();
                    goto label_30;
                }
                catch(Throwable throwable0) {
                }
            }
            d8.d.l(byteArrayInputStream0, throwable0);
            throw throwable0;
        label_30:
            byteArrayInputStream0.close();
            return h0;
        }
        return new h(null);
    }

    public static final String V(Inet6Address inet6Address0) {
        q.g(inet6Address0, "$this$toNormalizedString");
        ShortBuffer shortBuffer0 = ByteBuffer.wrap(inet6Address0.getAddress()).asShortBuffer();
        int[] arr_v = new int[8];
        for(int v1 = 0; v1 < 8; ++v1) {
            arr_v[v1] = shortBuffer0.get() & 0xFFFF;
        }
        p0 p00 = new p0();
        p0 p01 = new p0();
        for(int v2 = 0; v2 < 8; ++v2) {
            if(arr_v[v2] == 0) {
                if(p00.a < 0) {
                    p00.a = v2;
                }
                ++p00.b;
            }
            else if(p00.a >= 0) {
                if(p00.b <= p01.b) {
                    p00 = p01;
                }
                p01 = p00;
                p00 = new p0();
            }
        }
        if(p00.b <= p01.b) {
            p00 = p01;
        }
        ie.m m0 = p00.b >= 2 ? new ie.m(p00.a, ((int)(p00.a + p00.b))) : new ie.m(-1, -1);
        int v3 = ((Number)m0.a).intValue();
        int v4 = ((Number)m0.b).intValue();
        StringBuilder stringBuilder0 = new StringBuilder();
        for(int v = 0; v < 8; ++v) {
            if(v < v3 || v >= v4) {
                if(v != 0 && v != v4) {
                    stringBuilder0.append(':');
                }
                int v5 = arr_v[v];
                u0.l(16);
                String s = Integer.toString(v5, 16);
                q.f(s, "java.lang.Integer.toStri…(this, checkRadix(radix))");
                stringBuilder0.append(s);
            }
            else if(v == v3) {
                stringBuilder0.append("::");
            }
        }
        String s1 = stringBuilder0.toString();
        q.f(s1, "StringBuilder().apply(builderAction).toString()");
        return s1;
    }

    public static final pd.d W(Activity activity0) {
        q.g(activity0, "<this>");
        return activity0 instanceof pd.d ? ((pd.d)activity0) : null;
    }

    public static final double X(long v) [...] // Inlined contents

    public static final void a(String s, int v, int v1, androidx.compose.runtime.l l0, int v2) {
        P0.h h4;
        p p0 = (p)l0;
        p0.c0(0x28ECDD0E);
        int v3 = v2 | (p0.g(s) ? 4 : 2) | (p0.e(v) ? 0x20 : 16) | (p0.e(v1) ? 0x100 : 0x80);
        if(p0.Q(v3 & 1, (v3 & 0x93) != 0x92)) {
            Z z0 = p0.N();
            V v4 = androidx.compose.runtime.k.a;
            if(z0 == v4) {
                z0 = androidx.compose.runtime.w.o(0.0f);
                p0.l0(z0);
            }
            float f = ((Number)j.b(((I0)z0).m(), f.r((((I0)z0).m() == 0.0f ? 0 : 500), 0, null, 6), "", null, p0, 0xC00, 20).getValue()).floatValue();
            n n0 = n.a;
            r0.q q0 = androidx.compose.foundation.layout.d.f(e2.a.r(n0, f), 1.0f);
            ud.l l1 = p0.N();
            if(l1 == v4) {
                l1 = new ud.l(z0, 1);
                p0.l0(l1);
            }
            r0.q q1 = androidx.compose.ui.layout.a.d(q0, l1);
            M.d d0 = M.j.c;
            g g0 = r0.d.m;
            y y0 = M.w.a(d0, g0, p0, 0);
            int v5 = p0.P;
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
            P0.h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, y0, h0);
            P0.h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            P0.h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h2);
            }
            P0.h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q2, h3);
            r0.q q3 = androidx.compose.foundation.layout.d.h(n0, 45.0f);
            M m0 = M.p.d(r0.d.a, false);
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
            androidx.compose.runtime.w.x(p0, m0, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v6)) {
                A7.d.q(v6, p0, v6, h2);
            }
            androidx.compose.runtime.w.x(p0, q4, h3);
            r0.q q5 = androidx.compose.foundation.layout.a.n(n0, 20.0f, 0.0f, 0.0f, 0.0f, 14);
            N1.b("", (androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q5, r0.d.d), e0.T(p0, 0x7F06016D), 21.0f, e1.y.i, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0x30C00, 0, 0x1FFD0);  // color:gray900s
            e1.y y1 = e1.y.i;
            p0.p(true);
            r0.q q6 = androidx.compose.foundation.layout.a.n(x.s(n0, 4.0f, p0, n0, 1.0f), 20.0f, 6.0f, 0.0f, 0.0f, 12);
            M.p0 p00 = n0.a(M.j.a, r0.d.l, p0, 0x30);
            int v7 = p0.P;
            i0 i02 = p0.m();
            r0.q q7 = r0.a.d(p0, q6);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p00, h0);
            androidx.compose.runtime.w.x(p0, i02, h1);
            if(!p0.O && q.b(p0.N(), v7)) {
                h4 = h2;
            }
            else {
                h4 = h2;
                A7.d.q(v7, p0, v7, h4);
            }
            androidx.compose.runtime.w.x(p0, q7, h3);
            y y2 = M.w.a(d0, g0, p0, 0);
            int v8 = p0.P;
            i0 i03 = p0.m();
            r0.q q8 = r0.a.d(p0, n0);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y2, h0);
            androidx.compose.runtime.w.x(p0, i03, h1);
            if(p0.O || !q.b(p0.N(), v8)) {
                A7.d.q(v8, p0, v8, h4);
            }
            androidx.compose.runtime.w.x(p0, q8, h3);
            N1.b(H0.e.Y(p0, 0x7F1305ED), null, e0.T(p0, 0x7F06016D), 15.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF2);  // string:melon_chart_pick_in_one_day "24시간 내 피크"
            c.d(p0, androidx.compose.foundation.layout.d.h(n0, 4.0f));
            N1.b(s, null, e0.T(p0, 0x7F06017C), 30.0f, y1, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, v3 & 14 | 0x30C00, 0, 0x1FFD2);  // color:green500s_support_high_contrast
            p0.p(true);
            c.d(p0, androidx.compose.foundation.layout.d.q(n0, 27.0f));
            c.d(p0, androidx.compose.foundation.q.f(androidx.compose.foundation.layout.a.n(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.q(n0, 1.0f), 28.0f), 0.0f, 0.0f, 0.0f, 5.0f, 7), e0.T(p0, 0x7F06014A), y0.M.a));  // color:gray100a
            c.d(p0, androidx.compose.foundation.layout.d.q(n0, 27.0f));
            y y3 = M.w.a(d0, g0, p0, 0);
            int v9 = p0.P;
            i0 i04 = p0.m();
            r0.q q9 = r0.a.d(p0, n0);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y3, h0);
            androidx.compose.runtime.w.x(p0, i04, h1);
            if(p0.O || !q.b(p0.N(), v9)) {
                A7.d.q(v9, p0, v9, h4);
            }
            androidx.compose.runtime.w.x(p0, q9, h3);
            N1.b(H0.e.Y(p0, 0x7F1305D4), null, e0.T(p0, 0x7F06016D), 15.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF2);  // string:melon_chart_continuously_top_rank "연속 1위 달성"
            c.d(p0, androidx.compose.foundation.layout.d.h(n0, 4.0f));
            if(v > 0) {
                p0.a0(-1991882003);
                N1.b((v + "시간"), null, e0.T(p0, 0x7F06017C), 30.0f, y1, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0x30C00, 0, 0x1FFD2);  // color:green500s_support_high_contrast
            }
            else {
                p0.a0(0x894B34D9);
                N1.b(H0.e.Y(p0, 0x7F1305FC), null, e0.T(p0, 0x7F060156), 30.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF2);  // string:melon_chart_top_rank_fail_dash "-"
            }
            p0.p(false);
            p0.p(true);
            p0.p(true);
            p0.p(true);
            Integer integer0 = v1;
            zc.b b0 = p0.N();
            if(b0 == v4) {
                b0 = new zc.b(z0, null);
                p0.l0(b0);
            }
            J.d(p0, integer0, b0);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Id.f(v, v1, v2, s);
        }
    }

    public static final void b(vd.P p0, a a0, androidx.compose.runtime.l l0, int v) {
        FillElement fillElement1;
        p p1 = (p)l0;
        p1.c0(0x278D72B1);
        int v1 = v | (p1.i(p0) ? 4 : 2) | (p1.i(a0) ? 0x20 : 16);
        if(p1.Q(v1 & 1, (v1 & 19) != 18)) {
            n n0 = n.a;
            r0.q q0 = r0.a.a(androidx.compose.foundation.layout.a.l(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(n0, 1.0f), 96.0f), 0.0f, 6.0f, 1), new s(12, a0));
            boolean z = p1.i(p0);
            G g0 = p1.N();
            if(z || g0 == androidx.compose.runtime.k.a) {
                g0 = new G(p0, 6);
                p1.l0(g0);
            }
            r0.q q1 = X0.n.b(q0, g0);
            M.p0 p00 = n0.a(M.j.a, r0.d.j, p1, 0);
            int v2 = p1.P;
            i0 i00 = p1.m();
            r0.q q2 = r0.a.d(p1, q1);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
            p1.e0();
            if(p1.O) {
                p1.l(i0);
            }
            else {
                p1.o0();
            }
            P0.h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p1, p00, h0);
            P0.h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p1, i00, h1);
            P0.h h2 = P0.j.g;
            if(p1.O || !q.b(p1.N(), v2)) {
                A7.d.q(v2, p1, v2, h2);
            }
            P0.h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p1, q2, h3);
            r0.q q3 = androidx.compose.foundation.q.f(e0.K(d5.n.o(androidx.compose.foundation.layout.d.o(n0, 150.0f, 84.0f), T.e.b(4.0f))), e0.T(p1, 0x7F060145), y0.M.a);  // color:gray050s
            M m0 = M.p.d(r0.d.a, false);
            int v3 = p1.P;
            i0 i01 = p1.m();
            r0.q q4 = r0.a.d(p1, q3);
            p1.e0();
            if(p1.O) {
                p1.l(i0);
            }
            else {
                p1.o0();
            }
            androidx.compose.runtime.w.x(p1, m0, h0);
            androidx.compose.runtime.w.x(p1, i01, h1);
            if(p1.O || !q.b(p1.N(), v3)) {
                A7.d.q(v3, p1, v3, h2);
            }
            androidx.compose.runtime.w.x(p1, q4, h3);
            c1.n(androidx.compose.foundation.layout.d.c, p0.f, null, N0.j.b, false, 0x7F08078B, null, null, null, 0.0f, null, 0, 0, false, false, p1, 0x30C06, 0, 0x7FD4);  // drawable:noimage_logo_mini
            FillElement fillElement0 = androidx.compose.foundation.layout.d.c;
            ContsTypeCode contsTypeCode0 = ContsTypeCode.valueOf(p0.c);
            if(q.b(contsTypeCode0, ContsTypeCode.RADIO_CAST)) {
                p1.a0(0xC932BA7B);
                r0.q q5 = androidx.compose.foundation.layout.a.g(androidx.compose.foundation.layout.d.u(n0, 3), 7.0f, 6.0f);
                androidx.compose.foundation.q.c(I.Q(0x7F08067F, p1, 6), "", q5, null, null, 0.0f, null, p1, 0x1B0, 120);  // drawable:img_station_logo_02
                p1.p(false);
                fillElement1 = fillElement0;
            }
            else if(q.b(contsTypeCode0, ContsTypeCode.MELON_MAGAZINE)) {
                p1.a0(0xC938D05A);
                r0.q q6 = androidx.compose.foundation.layout.a.g(androidx.compose.foundation.layout.d.u(n0, 3), 7.0f, 6.0f);
                androidx.compose.foundation.q.c(I.Q(0x7F08064C, p1, 6), "", q6, null, null, 0.0f, null, p1, 0x1B0, 120);  // drawable:img_magazine_logo_02
                p1.p(false);
                fillElement1 = fillElement0;
            }
            else {
                if(q.b(contsTypeCode0, ContsTypeCode.VIDEO)) {
                    p1.a0(0xC93F2A47);
                    r0.q q7 = androidx.compose.foundation.q.e(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(n0, 1.0f), 40.0f), wc.u.f(e.k.A(new y0.s[]{new y0.s(e0.T(p1, 0x7F06048A)), new y0.s(e0.T(p1, 0x7F06015F))}), 0.0f, 0.0f, 14), null, 6);  // color:transparent
                    M.p.a((androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q7, r0.d.g), p1, 0);
                    String s = p0.i == null ? "" : Cb.k.f(p0.i);
                    long v4 = e0.T(p1, 0x7F0604A1);  // color:white000e
                    fillElement1 = fillElement0;
                    N1.b(s, androidx.compose.foundation.layout.a.g((androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(n0, r0.d.g), 10.0f, -8.0f), v4, 12.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p1, 0xC00, 0xC30, 0x1D7F0);
                }
                else {
                    fillElement1 = fillElement0;
                    p1.a0(0xC8655A7B);
                }
                p1.p(false);
            }
            p1.p(true);
            c.d(p1, androidx.compose.foundation.layout.d.q(n0, 12.0f));
            y y0 = M.w.a(M.j.e, r0.d.m, p1, 6);
            int v5 = p1.P;
            i0 i02 = p1.m();
            r0.q q8 = r0.a.d(p1, fillElement1);
            p1.e0();
            if(p1.O) {
                p1.l(i0);
            }
            else {
                p1.o0();
            }
            androidx.compose.runtime.w.x(p1, y0, h0);
            androidx.compose.runtime.w.x(p1, i02, h1);
            if(p1.O || !q.b(p1.N(), v5)) {
                A7.d.q(v5, p1, v5, h2);
            }
            androidx.compose.runtime.w.x(p1, q8, h3);
            N1.b((p0.e == null ? "" : p0.e), null, 0L, 0.0f, null, null, 0L, null, 18.0f, 2, false, 2, 0, null, null, p1, 0, 0xC36, 0x1D3FE);
            c.d(p1, androidx.compose.foundation.layout.d.h(n0, 7.0f));
            N1.b((p0.a == null ? "" : p0.a), null, e0.T(p1, 0x7F060160), 13.0f, null, null, 0L, null, 18.0f, 2, false, 1, 0, null, null, p1, 0xC00, 0xC36, 0x1D3F2);  // color:gray600s_support_high_contrast
            p1.p(true);
            p1.p(true);
        }
        else {
            p1.T();
        }
        androidx.compose.runtime.n0 n00 = p1.t();
        if(n00 != null) {
            n00.d = new T7(p0, a0, v, 28);
        }
    }

    public static final void c(b2 b20, we.k k0, androidx.compose.runtime.l l0, int v) {
        ((p)l0).c0(0x31050207);
        int v1 = (((p)l0).g(b20) ? 4 : 2) | v | (((p)l0).i(k0) ? 0x20 : 16);
        if(((p)l0).Q(v1 & 1, (v1 & 19) != 18)) {
            String s = b20.d;
            String s1 = b20.b;
            String s2 = b20.c;
            float f = E9.h.t(((p)l0), 0x7F0700E3);  // dimen:detail_list_padding_left_right
            r0.q q0 = androidx.compose.foundation.layout.a.l(n.a, f, 0.0f, 2);
            Y1 y10 = ((p)l0).N();
            V v2 = androidx.compose.runtime.k.a;
            if((((v1 & 0x70) == 0x20 ? 1 : 0) | ((v1 & 14) == 4 ? 1 : 0)) != 0 || y10 == v2) {
                y10 = new Y1(k0, b20, 3);
                ((p)l0).l0(y10);
            }
            Y1 y11 = ((p)l0).N();
            if((((v1 & 0x70) == 0x20 ? 1 : 0) | ((v1 & 14) == 4 ? 1 : 0)) != 0 || y11 == v2) {
                y11 = new Y1(k0, b20, 0);
                ((p)l0).l0(y11);
            }
            e0.f(s, s1, s2, q0, 4.0f, 0x7F06015D, 12.0f, y10, y11, ((p)l0), 0xDB0030, 0);  // color:gray500s_support_high_contrast
        }
        else {
            ((p)l0).T();
        }
        androidx.compose.runtime.n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.fragments.artistchannel.viewholder.e(b20, k0, v, 16);
        }
    }

    public static final void d(c2 c20, we.k k0, androidx.compose.runtime.l l0, int v) {
        String s4;
        ((p)l0).c0(0x18E69029);
        int v1 = (((p)l0).i(c20) ? 4 : 2) | v | (((p)l0).i(k0) ? 0x20 : 16);
        if(((p)l0).Q(v1 & 1, (v1 & 19) != 18)) {
            String s = c20.b;
            boolean z = c20.c;
            ((p)l0).a0(0x7983513F);
            ArrayList arrayList0 = new ArrayList(je.q.Q(10, ((Iterable)c20.d)));
            Iterator iterator0 = ((Iterable)c20.d).iterator();
            while(true) {
                boolean z1 = iterator0.hasNext();
                V v2 = androidx.compose.runtime.k.a;
                if(!z1) {
                    break;
                }
                Object object0 = iterator0.next();
                b2 b20 = (b2)object0;
                String s1 = b20.d;
                String s2 = b20.b;
                String s3 = b20.c;
                boolean z2 = ((p)l0).g(b20);
                Y1 y10 = ((p)l0).N();
                if((v1 & 0x70) == 0x20 || z2 || y10 == v2) {
                    s4 = s;
                    y10 = new Y1(k0, b20, 1);
                    ((p)l0).l0(y10);
                }
                else {
                    s4 = s;
                }
                boolean z3 = ((p)l0).g(b20);
                Y1 y11 = ((p)l0).N();
                if((v1 & 0x70) == 0x20 || z3 || y11 == v2) {
                    y11 = new Y1(k0, b20, 2);
                    ((p)l0).l0(y11);
                }
                arrayList0.add(new Cc.s(s1, s2, s3, y10, y11));
                s = s4;
            }
            boolean z4 = false;
            ((p)l0).p(false);
            if((v1 & 0x70) == 0x20) {
                z4 = true;
            }
            boolean z5 = ((p)l0).i(c20);
            w0 w00 = ((p)l0).N();
            if(z4 || z5 || w00 == v2) {
                w00 = new w0(5, k0, c20);
                ((p)l0).l0(w00);
            }
            e0.g(s, z, arrayList0, 4.0f, 0x7F06015D, 12.0f, w00, ((p)l0), 0x36C00);  // color:gray500s_support_high_contrast
        }
        else {
            ((p)l0).T();
        }
        androidx.compose.runtime.n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.fragments.artistchannel.viewholder.e(c20, k0, v, 17);
        }
    }

    public static final void e(h2 h20, we.k k0, we.k k1, androidx.compose.runtime.l l0, int v) {
        p p0 = (p)l0;
        p0.c0(-734010938);
        int v1 = v | (p0.i(h20) ? 4 : 2) | (p0.i(k0) ? 0x20 : 16) | (p0.i(k1) ? 0x100 : 0x80);
        if(p0.Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            F f0 = O.I.a(0, 0, 3, p0);
            E e0 = p0.N();
            V v2 = androidx.compose.runtime.k.a;
            if(e0 == v2) {
                e0 = androidx.compose.runtime.w.i(new M0(f0, 4));
                p0.l0(e0);
            }
            E e1 = p0.N();
            if(e1 == v2) {
                e1 = androidx.compose.runtime.w.i(new M0(f0, 5));
                p0.l0(e1);
            }
            Boolean boolean0 = (Boolean)e0.getValue();
            boolean0.booleanValue();
            Boolean boolean1 = (Boolean)e1.getValue();
            boolean1.booleanValue();
            Z1 z10 = p0.N();
            if((v1 & 0x380) == 0x100 || z10 == v2) {
                z10 = new Z1(k1, e0, e1, null);
                p0.l0(z10);
            }
            J.f(boolean0, boolean1, z10, p0);
            r0.q q0 = androidx.compose.foundation.layout.d.c(androidx.compose.foundation.layout.a.n(n.a, 0.0f, 4.0f, 0.0f, 0.0f, 13), 1.0f);
            j0 j00 = androidx.compose.foundation.layout.a.c(0.0f, 0.0f, 0.0f, E9.h.t(p0, 0x7F070058), 7);  // dimen:bottom_tab_plus_miniplayer_height
            boolean z = p0.i(h20);
            gd.l l1 = p0.N();
            if(z || (v1 & 0x70) == 0x20 || l1 == v2) {
                l1 = new gd.l(9, h20, k0);
                p0.l0(l1);
            }
            c1.o(q0, f0, j00, false, null, null, null, false, l1, p0, 6, 0xF8);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Id.h(h20, k0, k1, v, 17);
        }
    }

    public static final void f(d2 d20, androidx.compose.runtime.l l0, int v) {
        ((p)l0).c0(0xF54F434);
        int v1 = (((p)l0).g(d20) ? 4 : 2) | v;
        if(((p)l0).Q(v1 & 1, (v1 & 3) != 2)) {
            float f = E9.h.t(((p)l0), 0x7F0700E3);  // dimen:detail_list_padding_left_right
            r0.q q0 = androidx.compose.foundation.layout.a.l(n.a, f, 0.0f, 2);
            e0.h(d20.b, false, q0, null, ((p)l0), 0x30, 8);
        }
        else {
            ((p)l0).T();
        }
        androidx.compose.runtime.n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new V2(d20, v, 8);
        }
    }

    public static final void g(D0 d00, List list0, int v, String s, we.k k0, a a0, androidx.compose.runtime.l l0, int v1) {
        p p0 = (p)l0;
        p0.c0(1710146620);
        int v2 = v1 | (p0.i(d00) ? 4 : 2) | (p0.i(list0) ? 0x20 : 16) | (p0.e(v) ? 0x100 : 0x80) | (p0.g(s) ? 0x800 : 0x400) | (p0.i(k0) ? 0x4000 : 0x2000) | (p0.i(a0) ? 0x20000 : 0x10000);
        if(p0.Q(v2 & 1, (74899 & v2) != 74898)) {
            b0 b00 = p0.N();
            V v3 = androidx.compose.runtime.k.a;
            if(b00 == v3) {
                b00 = x.d(0, p0);
            }
            n n0 = n.a;
            r0.q q0 = androidx.compose.ui.input.nestedscroll.a.a(androidx.compose.foundation.layout.d.f(n0, 1.0f), N.u(p0), null);
            Z3 z30 = p0.N();
            if((0xE000 & v2) == 0x4000 || z30 == v3) {
                z30 = new Z3(k0, b00, 3);
                p0.l0(z30);
            }
            r0.q q1 = androidx.compose.ui.layout.a.f(q0, z30);
            y y0 = M.w.a(M.j.e, r0.d.n, p0, 54);
            int v4 = p0.P;
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
            androidx.compose.runtime.w.x(p0, y0, P0.j.f);
            androidx.compose.runtime.w.x(p0, i00, P0.j.e);
            P0.h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h0);
            }
            androidx.compose.runtime.w.x(p0, q2, P0.j.d);
            r0.q q3 = androidx.compose.foundation.layout.d.f(n0, 1.0f);
            j0 j00 = androidx.compose.foundation.layout.a.a(20.0f, 0.0f, 2);
            boolean z = p0.i(d00);
            boolean z1 = p0.i(list0);
            Bd.F f0 = p0.N();
            if((((v2 & 0x70000) == 0x20000 ? 1 : 0) | (z | z1 | ((v2 & 0x1C00) == 0x800 ? 1 : 0))) != 0 || f0 == v3) {
                Bd.F f1 = new Bd.F(list0, d00, s, a0, 20);
                p0.l0(f1);
                f0 = f1;
            }
            c1.o(q3, null, j00, false, null, null, null, false, f0, p0, 390, 0xFA);
            if(v == 0 || ((Number)b00.getValue()).intValue() <= v) {
                p0.a0(0xDC4368FC);
            }
            else {
                p0.a0(0xDCF91937);
                c.d(p0, androidx.compose.foundation.q.x(x.r(1.0f, androidx.compose.foundation.layout.d.f(n0, 1.0f), true), androidx.compose.foundation.q.t(p0), false, 14));
            }
            p0.p(false);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new k0(d00, list0, v, s, k0, a0, v1);
        }
    }

    public static final qf.b h(String s) {
        qf.e e0 = qf.e.e(s);
        return new qf.b(qf.h.h, e0);
    }

    public static final qf.b i(String s) {
        qf.e e0 = qf.e.e(s);
        return new qf.b(qf.h.a, e0);
    }

    public static final qf.b j(String s) {
        qf.e e0 = qf.e.e(s);
        return new qf.b(qf.h.c, e0);
    }

    public static final LinkedHashMap k(LinkedHashMap linkedHashMap0) {
        Iterable iterable0 = linkedHashMap0.entrySet();
        int v = je.D.N(je.q.Q(10, iterable0));
        if(v < 16) {
            v = 16;
        }
        LinkedHashMap linkedHashMap1 = new LinkedHashMap(v);
        for(Object object0: iterable0) {
            Object object1 = ((Map.Entry)object0).getKey();
            linkedHashMap1.put(((Map.Entry)object0).getValue(), object1);
        }
        return linkedHashMap1;
    }

    public static final qf.b l(qf.e e0) {
        qf.e e1 = qf.e.e((e0.c() + "Array"));
        return new qf.b(qf.h.n.a, e1);
    }

    public static final qf.b m(String s) {
        qf.e e0 = qf.e.e(s);
        return new qf.b(qf.h.b, e0);
    }

    public static final qf.b n(qf.b b0) {
        qf.e e0 = qf.e.e(("U" + b0.f().c()));
        return new qf.b(qf.h.a, e0);
    }

    public static int o(boolean[] arr_z, int v, int[] arr_v, boolean z) {
        int v2 = 0;
        for(int v1 = 0; v1 < arr_v.length; ++v1) {
            int v3 = arr_v[v1];
            int v4 = 0;
            while(v4 < v3) {
                arr_z[v] = z;
                ++v4;
                ++v;
            }
            v2 += v3;
            z = !z;
        }
        return v2;
    }

    @Override  // X7.d
    public a8.b p(String s, int v, EnumMap enumMap0) {
        if(s.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        int v1 = this.A();
        X7.a a0 = X7.a.f;
        if(enumMap0.containsKey(a0)) {
            v1 = Integer.parseInt(enumMap0.get(a0).toString());
        }
        boolean[] arr_z = this.w(s);
        int v2 = v1 + arr_z.length;
        int v3 = Math.max(200, v2);
        int v4 = v3 / v2;
        int v5 = (v3 - arr_z.length * v4) / 2;
        a8.b b0 = new a8.b(v3, 200);
        int v6 = 0;
        while(v6 < arr_z.length) {
            if(arr_z[v6]) {
                b0.c(v5, 0, v4, 200);
            }
            ++v6;
            v5 += v4;
        }
        return b0;
    }

    public static final LinkedHashSet q(byte[] arr_b) {
        q.g(arr_b, "bytes");
        LinkedHashSet linkedHashSet0 = new LinkedHashSet();
        if(arr_b.length == 0) {
            return linkedHashSet0;
        }
        ByteArrayInputStream byteArrayInputStream0 = new ByteArrayInputStream(arr_b);
        try {
            try {
                ObjectInputStream objectInputStream0 = new ObjectInputStream(byteArrayInputStream0);
                try {
                    int v = objectInputStream0.readInt();
                    for(int v1 = 0; v1 < v; ++v1) {
                        Uri uri0 = Uri.parse(objectInputStream0.readUTF());
                        boolean z = objectInputStream0.readBoolean();
                        q.f(uri0, "uri");
                        linkedHashSet0.add(new U4.c(uri0, z));
                    }
                }
                catch(Throwable throwable1) {
                    d8.d.l(objectInputStream0, throwable1);
                    throw throwable1;
                }
                objectInputStream0.close();
            }
            catch(IOException iOException0) {
                iOException0.printStackTrace();
            }
        }
        catch(Throwable throwable0) {
            d8.d.l(byteArrayInputStream0, throwable0);
            throw throwable0;
        }
        byteArrayInputStream0.close();
        return linkedHashSet0;
    }

    public static String r(Context context0, long v) {
        q.g(context0, "context");
        if(Long.compare(0L, v) <= 0 && v < 10000L) {
            String s = new DecimalFormat("#,###").format(v);
            q.d(s);
            return s;
        }
        if(Long.compare(10000L, v) <= 0 && v < 100000L) {
            return va.e.h(new DecimalFormat("#.#").format(Math.floor(((double)v) / 10000.0 * 10.0) / 10.0), "만");
        }
        if(Long.compare(100000L, v) <= 0 && v < 10000000L) {
            return va.e.h(new DecimalFormat("#.#").format(Math.floor(((double)v) / 10000.0 * 10.0) / 10.0), "만");
        }
        if(Long.compare(10000000L, v) <= 0 && v < 100000000L) {
            return va.e.h(new DecimalFormat("#,###").format(v / 10000L), "만");
        }
        if(Long.compare(100000000L, v) <= 0 && v < 100000000000L) {
            return va.e.h(new DecimalFormat("#.#").format(Math.floor(((double)v) / 100000000.0 * 10.0) / 10.0), "억");
        }
        return 100000000000L > v || v >= 0xE8D4A50FFFL ? "9,999억+" : va.e.h(new DecimalFormat("#,###").format(v / 100000000L), "억");
    }

    public static Bitmap s(Drawable drawable0, Bitmap.Config bitmap$Config0, u5.g g0, u5.f f0, boolean z) {
        int v2;
        int v;
        if(drawable0 instanceof BitmapDrawable) {
            Bitmap bitmap0 = ((BitmapDrawable)drawable0).getBitmap();
            if(bitmap0.getConfig() == (bitmap$Config0 == null || bitmap$Config0 == Bitmap.Config.HARDWARE ? Bitmap.Config.ARGB_8888 : bitmap$Config0) && (z || v.r(bitmap0.getWidth(), bitmap0.getHeight(), (q.b(g0, u5.g.c) ? bitmap0.getWidth() : x5.g.e(g0.a, f0)), (q.b(g0, u5.g.c) ? bitmap0.getHeight() : x5.g.e(g0.b, f0)), f0) == 1.0)) {
                return bitmap0;
            }
        }
        Drawable drawable1 = drawable0.mutate();
        BitmapDrawable bitmapDrawable0 = null;
        BitmapDrawable bitmapDrawable1 = drawable1 instanceof BitmapDrawable ? ((BitmapDrawable)drawable1) : null;
        if(bitmapDrawable1 == null) {
            v = drawable1.getIntrinsicWidth();
        }
        else {
            Bitmap bitmap1 = bitmapDrawable1.getBitmap();
            v = bitmap1 == null ? drawable1.getIntrinsicWidth() : bitmap1.getWidth();
        }
        int v1 = 0x200;
        if(v <= 0) {
            v = 0x200;
        }
        if(drawable1 instanceof BitmapDrawable) {
            bitmapDrawable0 = (BitmapDrawable)drawable1;
        }
        if(bitmapDrawable0 == null) {
            v2 = drawable1.getIntrinsicHeight();
        }
        else {
            Bitmap bitmap2 = bitmapDrawable0.getBitmap();
            v2 = bitmap2 == null ? drawable1.getIntrinsicHeight() : bitmap2.getHeight();
        }
        if(v2 > 0) {
            v1 = v2;
        }
        double f1 = v.r(v, v1, (q.b(g0, u5.g.c) ? v : x5.g.e(g0.a, f0)), (q.b(g0, u5.g.c) ? v1 : x5.g.e(g0.b, f0)), f0);
        int v3 = ye.a.U(((double)v) * f1);
        int v4 = ye.a.U(f1 * ((double)v1));
        if(bitmap$Config0 == null || bitmap$Config0 == Bitmap.Config.HARDWARE) {
            bitmap$Config0 = Bitmap.Config.ARGB_8888;
        }
        Bitmap bitmap3 = Bitmap.createBitmap(v3, v4, bitmap$Config0);
        Rect rect0 = drawable1.getBounds();
        int v5 = rect0.left;
        int v6 = rect0.top;
        int v7 = rect0.right;
        int v8 = rect0.bottom;
        drawable1.setBounds(0, 0, v3, v4);
        drawable1.draw(new Canvas(bitmap3));
        drawable1.setBounds(v5, v6, v7, v8);
        return bitmap3;
    }

    public static final long t(InputStream inputStream0, OutputStream outputStream0) {
        q.g(inputStream0, "<this>");
        byte[] arr_b = new byte[0x2000];
        int v = inputStream0.read(arr_b);
        long v1 = 0L;
        while(v >= 0) {
            outputStream0.write(arr_b, 0, v);
            v1 += (long)v;
            v = inputStream0.read(arr_b);
        }
        return v1;
    }

    public static d5.e u() {
        jg.f f0 = new jg.f();  // 初始化器: Ljava/lang/Object;-><init>()V
        f0.a = jg.b.c;
        f0.b = 0;
        f0.c = "";
        f0.d = "HTTP/1.1";
        return new d5.e(12, f0, new mg.d(f0, null));
    }

    public static final void v(pd.d d0) {
        q.g(d0, "<this>");
        Activity activity0 = d0.getActivity();
        q.e(activity0, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        l0 l00 = ((AppCompatActivity)activity0).getSupportFragmentManager();
        androidx.fragment.app.w w0 = l00 == null ? null : com.melon.ui.popup.b.b(l00, "", vd.E.b, null, 8);
        pd.d.Q.getClass();
        m9.l l0 = new m9.l(3, d0, w0);
        LogConstantsKt.buildDebug(pd.c.b, true, l0);
        if(w0 != null) {
            w0.dismissAllowingStateLoss();
        }
    }

    public abstract boolean[] w(String arg1);

    public static void x(Activity activity0, Uri uri0) {
        if(activity0 != null) {
            String s = uri0.getPath();
            if(s != null) {
                Class class0 = Ma.m.class;
                switch(s) {
                    case "": {
                        m8.c c0 = new m8.c(2);
                        c0.i1(uri0);
                        MelonTextPopup melonTextPopup0 = (MelonTextPopup)c0.c;
                        if(melonTextPopup0 != null && melonTextPopup0.isShowing()) {
                            MelonTextPopup melonTextPopup1 = (MelonTextPopup)c0.c;
                            if(melonTextPopup1 != null) {
                                melonTextPopup1.dismiss();
                                goto label_40;
                            }
                            q.m("messagePopup");
                            throw null;
                        }
                    label_40:
                        boolean z1 = true;
                        if(q.b(c0.c1().getQueryParameter("ctype"), "simplemode")) {
                            String s5 = c0.c1().getQueryParameter("menuId");
                            if(!((va.e0)o.a()).m()) {
                                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new f0(activity0, null), 3, null);
                                return;
                            }
                            String s6 = c0.c1().getQueryParameter("openplayer");
                            if(s6 == null || s6.length() == 0 || !"Y".equals(s6)) {
                                z1 = false;
                            }
                            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new m8.j0(activity0, c0, s5, z1, null), 3, null);
                            return;
                        }
                        if(q.b(c0.c1().getQueryParameter("ctype"), "mixup")) {
                            H h0 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
                            String s7 = c0.c1().getQueryParameter("menuId");
                            h0.a = s7;
                            if(s7 == null || s7.length() == 0) {
                                h0.a = "1000003089";
                            }
                            String s8 = c0.c1().getQueryParameter("openplayer");
                            if(s8 == null || s8.length() == 0 || !"Y".equals(s8)) {
                                z1 = false;
                            }
                            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new m8.e0(c0, h0, activity0, z1, null), 3, null);
                            return;
                        }
                        MelonTextPopup melonTextPopup2 = PopupHelper.showConfirmPopup(activity0, 0x7F1300D0, 0x7F1300B1, new com.facebook.login.b(c0, 4));  // string:alert_dlg_title_info "안내"
                        q.f(melonTextPopup2, "showConfirmPopup(...)");
                        c0.c = melonTextPopup2;
                        break;
                    }
                    case "/control/mode": {
                        String s1 = uri0.getQueryParameter("releaseRepeat");
                        String s2 = uri0.getQueryParameter("shuffle");
                        String s3 = uri0.getQueryParameter("repeat");
                        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new a0(activity0, s1, s2, s3, null), 3, null);
                        return;
                    }
                    case "/control/next": {
                        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new m8.b0(activity0, null), 3, null);
                        return;
                    }
                    case "/control/pause": {
                        Context context2 = activity0.getApplicationContext();
                        q.d(context2);
                        ((z)((k8.o)(((Ma.m)com.google.firebase.b.B(context2, class0)))).t.get()).r();
                        return;
                    }
                    case "/control/play": {
                        Context context0 = activity0.getApplicationContext();
                        q.d(context0);
                        ((z)((k8.o)(((Ma.m)com.google.firebase.b.B(context0, class0)))).t.get()).s();
                        return;
                    }
                    case "/control/prev": {
                        String s4 = uri0.getQueryParameter("forced");
                        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new c0(activity0, s4, null), 3, null);
                        return;
                    }
                    case "/control/replay": {
                        Context context1 = activity0.getApplicationContext();
                        q.d(context1);
                        z z0 = (z)((k8.o)(((Ma.m)com.google.firebase.b.B(context1, class0)))).t.get();
                        LogU.info$default(z0.h, "stopAndPlay()", null, false, 6, null);
                        z0.f(new Qb.y(2, null));  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                    }
                }
            }
        }
    }

    public static void y(Uri uri0) {
        String s = uri0.getPath();
        if(s != null && s.hashCode() == 0x1719D3 && s.equals("/set")) {
            Set set0 = NetUtils.getQueryParameterNames(uri0);
            if(set0 != null) {
                m8.d d0 = new m8.d(0);  // 初始化器: Lm8/e;-><init>(I)V
                d0.i1(uri0);
                for(Object object0: set0) {
                    String s1 = d0.c1().getQueryParameter(((String)object0));
                    LogU.Companion.d("Cookies.kt", androidx.appcompat.app.o.o("COOKIES_SET ", ((String)object0), ":", s1));
                    CookieHelper.getInstance().setCookie(((String)object0), s1);
                    if("IS_INPUT_AUTHENTICATION_ADULT_PWD".equalsIgnoreCase(((String)object0))) {
                        mb.k k0 = o.a();
                        va.b0 b00 = new va.b0(((va.e0)k0), "Y".equals(s1), null);
                        BuildersKt__Builders_commonKt.launch$default(((va.e0)k0).i, null, null, b00, 3, null);
                    }
                }
            }
        }
    }

    public static final String z(Object object0) [...] // Inlined contents
}

