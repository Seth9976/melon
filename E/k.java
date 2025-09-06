package e;

import Ce.f;
import Ce.g;
import De.I;
import Q0.Y0;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.DragEvent;
import android.view.View;
import androidx.compose.runtime.n0;
import c2.Z;
import com.google.android.material.internal.F;
import com.iloen.melon.activity.PresentSendActivity;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.Navigator;
import df.v;
import f.d;
import f.e;
import f.h;
import gd.B2;
import i.n.i.b.a.s.e.M3;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import je.l;
import je.p;
import je.q;
import je.w;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.Deferred;
import l2.i;
import mf.a;
import oc.H;
import pc.t;
import r0.n;
import va.e0;
import va.o;
import w1.m;
import w2.b;
import x0.c;

public abstract class k {
    public static final int a;
    public static final int b;
    public static final int c;
    public static final int d;
    public static final int e;

    public static List A(Object[] arr_object) [...] // Inlined contents

    public static List B(Object object0) {
        return object0 != null ? k.z(object0) : w.a;
    }

    public static ArrayList C(Object[] arr_object) {
        return arr_object.length == 0 ? new ArrayList() : new ArrayList(new l(arr_object, true));
    }

    public void D(int v, int v1) {
    }

    public void E() {
    }

    public void F(View view0, int v) {
    }

    public abstract void G(int arg1);

    public abstract void H(View arg1, int arg2, int arg3);

    public abstract void I(View arg1, float arg2, float arg3);

    public static final List J(List list0) {
        switch(list0.size()) {
            case 0: {
                return w.a;
            }
            case 1: {
                return k.z(list0.get(0));
            }
            default: {
                return list0;
            }
        }
    }

    public static final void K(int v, int v1) {
        if(v1 < 0) {
            throw new IllegalArgumentException("fromIndex (0) is greater than toIndex (" + v1 + ").");
        }
        if(v1 > v) {
            throw new IndexOutOfBoundsException("toIndex (" + v1 + ") is greater than size (" + v + ").");
        }
    }

    public static b L(MappedByteBuffer mappedByteBuffer0) {
        long v3;
        ByteBuffer byteBuffer0 = mappedByteBuffer0.duplicate();
        byteBuffer0.order(ByteOrder.BIG_ENDIAN);
        byteBuffer0.position(byteBuffer0.position() + 4);
        int v = byteBuffer0.getShort();
        if((v & 0xFFFF) > 100) {
            throw new IOException("Cannot read metadata.");
        }
        byteBuffer0.position(byteBuffer0.position() + 6);
        int v1 = 0;
        for(int v2 = 0; true; ++v2) {
            v3 = -1L;
            if(v2 >= (v & 0xFFFF)) {
                break;
            }
            int v4 = byteBuffer0.getInt();
            byteBuffer0.position(byteBuffer0.position() + 4);
            v3 = ((long)byteBuffer0.getInt()) & 0xFFFFFFFFL;
            byteBuffer0.position(byteBuffer0.position() + 4);
            if(0x6D657461 == v4) {
                break;
            }
        }
        if(v3 != -1L) {
            byteBuffer0.position(byteBuffer0.position() + ((int)(v3 - ((long)byteBuffer0.position()))));
            byteBuffer0.position(byteBuffer0.position() + 12);
            long v5 = ((long)byteBuffer0.getInt()) & 0xFFFFFFFFL;
            while(((long)v1) < v5) {
                int v6 = byteBuffer0.getInt();
                long v7 = ((long)byteBuffer0.getInt()) & 0xFFFFFFFFL;
                byteBuffer0.getInt();
                if(0x456D6A69 != v6 && 1701669481 != v6) {
                    ++v1;
                    continue;
                }
                byteBuffer0.position(((int)(v7 + v3)));
                b b0 = new b();  // 初始化器: Lc2/J;-><init>()V
                byteBuffer0.order(ByteOrder.LITTLE_ENDIAN);
                int v8 = byteBuffer0.position() + byteBuffer0.getInt(byteBuffer0.position());
                b0.d = byteBuffer0;
                b0.a = v8;
                int v9 = v8 - byteBuffer0.getInt(v8);
                b0.b = v9;
                b0.c = ((ByteBuffer)b0.d).getShort(v9);
                return b0;
            }
        }
        throw new IOException("Cannot read metadata.");
    }

    public static a M(InputStream inputStream0) {
        DataInputStream dataInputStream0 = new DataInputStream(inputStream0);
        g g0 = new g(1, dataInputStream0.readInt(), 1);  // 初始化器: LCe/e;-><init>(III)V
        ArrayList arrayList0 = new ArrayList(q.Q(10, g0));
        f f0 = g0.b();
        while(f0.c) {
            f0.nextInt();
            arrayList0.add(dataInputStream0.readInt());
        }
        int[] arr_v = p.O0(arrayList0);
        return new a(Arrays.copyOf(arr_v, arr_v.length));
    }

    public static void N() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    public static void O() {
        throw new ArithmeticException("Index overflow has happened.");
    }

    public abstract boolean P(View arg1, int arg2);

    public static final long a(float f, float f1) [...] // 潜在的解密器

    public static final void b(B2 b20, we.k k0, androidx.compose.runtime.l l0, int v) {
        kotlin.jvm.internal.q.g(k0, "onUserEvent");
        ((androidx.compose.runtime.p)l0).c0(1160209738);
        int v1 = (((androidx.compose.runtime.p)l0).i(b20) ? 4 : 2) | v | (((androidx.compose.runtime.p)l0).i(k0) ? 0x20 : 16);
        if(((androidx.compose.runtime.p)l0).Q(v1 & 1, (v1 & 19) != 18)) {
            r0.q q0 = androidx.compose.foundation.layout.a.n(n.a, 0.0f, 0.0f, 0.0f, 30.0f, 7);
            v.d(b20.a, q0, null, false, b20, k0, ((androidx.compose.runtime.p)l0), 0xE000 & v1 << 12 | 0x30 | v1 << 12 & 0x70000, 12);
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
        }
        n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new gd.a(b20, k0, v, 1);
        }
    }

    public static j c(h h0) {
        int v = Build.VERSION.SDK_INT;
        int v1 = v < 33 && (v < 30 || F.x() < 2) ? 0x7FFFFFFF : com.kakao.sdk.common.util.a.a();
        if(v >= 33 || v >= 30 && F.x() >= 2) {
            com.kakao.sdk.common.util.a.a();
        }
        j j0 = new j();  // 初始化器: Ljava/lang/Object;-><init>()V
        j0.a = e.a;
        if(v >= 33 || v >= 30 && F.x() >= 2) {
            com.kakao.sdk.common.util.a.a();
        }
        j0.a = h0;
        j0.b = v1;
        j0.c = d.a;
        return j0;
    }

    public static final c d(long v, long v1) {
        return new c(Float.intBitsToFloat(((int)(v >> 0x20))), Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))), Float.intBitsToFloat(((int)(v1 >> 0x20))) + Float.intBitsToFloat(((int)(v >> 0x20))), Float.intBitsToFloat(((int)(v1 & 0xFFFFFFFFL))) + Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))));
    }

    public static ArrayList e(Object[] arr_object) {
        kotlin.jvm.internal.q.g(arr_object, "elements");
        return arr_object.length == 0 ? new ArrayList() : new ArrayList(new l(arr_object, true));
    }

    public static m f(Deferred deferred0) {
        kotlin.jvm.internal.q.g(deferred0, "<this>");
        return k.q(new j3.n(deferred0, 9));
    }

    public static int g(ArrayList arrayList0, Comparable comparable0) {
        int v = arrayList0.size();
        kotlin.jvm.internal.q.g(arrayList0, "<this>");
        k.K(arrayList0.size(), v);
        int v1 = v - 1;
        int v2 = 0;
        while(v2 <= v1) {
            int v3 = v2 + v1 >>> 1;
            int v4 = e1.b.r(((Comparable)arrayList0.get(v3)), comparable0);
            if(v4 < 0) {
                v2 = v3 + 1;
                continue;
            }
            if(v4 > 0) {
                v1 = v3 - 1;
                continue;
            }
            return v3;
        }
        return -(v2 + 1);
    }

    public static ke.b h(ke.b b0) {
        b0.k();
        b0.c = true;
        return b0.b <= 0 ? ke.b.d : b0;
    }

    public static final void i(View view0) {
        kotlin.jvm.internal.q.g(view0, "<this>");
        Sf.l l0 = I.P(new Z(view0, null));
        while(l0.hasNext()) {
            ArrayList arrayList0 = k.t(((View)l0.next())).a;
            for(int v = k.s(arrayList0); -1 < v; --v) {
                ((Y0)arrayList0.get(v)).a.c();
            }
        }
    }

    public abstract int j(View arg1, int arg2);

    public abstract int k(View arg1, int arg2);

    public static ke.b l() {
        return new ke.b(10);
    }

    public static final long m() [...] // 潜在的解密器

    public static final Object n(i i0, we.n n0, Continuation continuation0) {
        return i0.a(new q2.j(n0, null), continuation0);
    }

    public static void o(Activity activity0, Uri uri0) {
        if(activity0 != null) {
            String s = uri0.getPath();
            if(s != null) {
                switch(s) {
                    case "/receive": {
                        String s4 = uri0.getQueryParameter("giftAuthKey");
                        if(s4 != null) {
                            m8.k k1 = new m8.k(0);
                            k1.i1(uri0);
                            if(!((e0)o.a()).m()) {
                                Navigator.openLoginView(k1.c1());
                                return;
                            }
                            Navigator.INSTANCE.openGiftBoxDetailByKey(s4);
                            return;
                        }
                        break;
                    }
                    case "/send": {
                        String s1 = uri0.getQueryParameter("menuid");
                        String s2 = uri0.getQueryParameter("prodIds");
                        String s3 = uri0.getQueryParameter("eventEnterAuthKey");
                        m8.k k0 = new m8.k(1);
                        k0.i1(uri0);
                        if(!((e0)o.a()).m()) {
                            Navigator.openLoginView(k0.c1());
                            return;
                        }
                        Intent intent0 = new Intent(activity0, PresentSendActivity.class);
                        intent0.putExtra("menuId", s1);
                        intent0.putExtra("presentProductId", s2);
                        intent0.putExtra("presentEventEnterAuthKey", s3);
                        activity0.startActivity(intent0);
                    }
                }
            }
        }
    }

    public static final Playable p(H h0) {
        kotlin.jvm.internal.q.g(h0, "<this>");
        return e1.b.y(h0.getState());
    }

    public static m q(w1.k k0) {
        w1.j j0 = new w1.j();  // 初始化器: Ljava/lang/Object;-><init>()V
        j0.c = new w1.o();  // 初始化器: Ljava/lang/Object;-><init>()V
        m m0 = new m(j0);
        j0.b = m0;
        j0.a = k0.getClass();
        try {
            Object object0 = k0.attachCompleter(j0);
            if(object0 != null) {
                j0.a = object0;
                return m0;
            }
        }
        catch(Exception exception0) {
            m0.b.j(exception0);
        }
        return m0;
    }

    public static g r(Collection collection0) {
        kotlin.jvm.internal.q.g(collection0, "<this>");
        return new g(0, collection0.size() - 1, 1);  // 初始化器: LCe/e;-><init>(III)V
    }

    public static int s(List list0) {
        kotlin.jvm.internal.q.g(list0, "<this>");
        return list0.size() - 1;
    }

    public static final i2.a t(View view0) {
        i2.a a0 = (i2.a)view0.getTag(0x7F0A093D);  // id:pooling_container_listener_holder_tag
        if(a0 == null) {
            a0 = new i2.a();
            view0.setTag(0x7F0A093D, a0);  // id:pooling_container_listener_holder_tag
        }
        return a0;
    }

    public static final long u(t t0) {
        DragEvent dragEvent0 = (DragEvent)t0.b;
        return ((long)Float.floatToRawIntBits(dragEvent0.getX())) << 0x20 | ((long)Float.floatToRawIntBits(dragEvent0.getY())) & 0xFFFFFFFFL;
    }

    public int v(View view0) {
        return 0;
    }

    public int w() {
        return 0;
    }

    public static String x(h h0) {
        if(h0 instanceof f.f) {
            return "image/*";
        }
        if(h0 instanceof f.g) {
            return "image/jpeg";
        }
        if(!(h0 instanceof e)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        return null;
    }

    public static final boolean y(H h0) {
        kotlin.jvm.internal.q.g(h0, "<this>");
        return h0.getState().c().isEmpty();
    }

    public static List z(Object object0) {
        List list0 = Collections.singletonList(object0);
        kotlin.jvm.internal.q.f(list0, "singletonList(...)");
        return list0;
    }
}

