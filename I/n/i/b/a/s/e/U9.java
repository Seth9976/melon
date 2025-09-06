package i.n.i.b.a.s.e;

import J8.S0;
import Q0.P0;
import Q0.Q0;
import Q0.u;
import S1.g;
import X0.p;
import X0.w;
import Z1.i;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Trace;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.collection.K;
import androidx.collection.m;
import androidx.collection.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.w0;
import com.google.android.material.carousel.CarouselLayoutManager;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.custom.BottomDetectableScrollView;
import com.iloen.melon.custom.RecyclerViewWithEmptyView;
import com.iloen.melon.net.v4x.response.SearchIntentListRes.Response;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.ViewUtils;
import df.d;
import e.k;
import h7.u0;
import i3.a;
import i3.c;
import i3.e;
import id.D;
import ie.H;
import j3.s;
import java.net.SocketTimeoutException;
import java.nio.MappedByteBuffer;
import java.util.List;
import k3.h;
import k8.Y;
import k8.t;
import kotlin.jvm.internal.q;
import l4.M;
import o9.b;
import t0.f;
import ud.L;
import ud.O;
import v2.n;
import vd.v;

public final class u9 implements Runnable {
    public final int a;
    public final Object b;

    public u9(L9 l90, r7 r70) {
        this.a = 2;
        super();
        this.b = r70;
    }

    public u9(Za za0, int v, long v1, long v2) {
        this.a = 3;
        super();
        this.b = za0;
    }

    public u9(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    private final void a() {
        b b0;
        Typeface typeface0;
        n n0 = (n)this.b;
        synchronized(n0.d) {
            if(n0.h == null) {
                return;
            }
        }
        try {
            i i0 = n0.c();
            int v = i0.e;
            if(v != 0) {
                throw new RuntimeException("fetchFonts result is not OK. (" + v + ")");
            }
            try {
                Trace.beginSection("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                n0.c.getClass();
                Trace.beginSection("TypefaceCompat.createFromFontInfo");
                try {
                    typeface0 = g.a.p(n0.a, new i[]{i0}, 0);
                }
                catch(Throwable throwable1) {
                    Trace.endSection();
                    throw throwable1;
                }
                Trace.endSection();
                MappedByteBuffer mappedByteBuffer0 = u0.M(n0.a, i0.a);
                if(mappedByteBuffer0 != null && typeface0 != null) {
                    try {
                        Trace.beginSection("EmojiCompat.MetadataRepo.create");
                        b0 = new b(typeface0, k.L(mappedByteBuffer0));
                    }
                    finally {
                        Trace.endSection();
                    }
                    synchronized(n0.d) {
                        d d0 = n0.h;
                        if(d0 != null) {
                            d0.D(b0);
                        }
                    }
                    n0.b();
                    return;
                }
            }
            finally {
                Trace.endSection();
            }
            throw new RuntimeException("Unable to open file.");
        }
        catch(Throwable throwable0) {
            synchronized(n0.d) {
                d d1 = n0.h;
                if(d1 != null) {
                    d1.C(throwable0);
                }
            }
            n0.b();
        }
    }

    @Override
    public final void run() {
        u u2;
        long[] arr_v9;
        int v34;
        long v28;
        int v27;
        int v24;
        long[] arr_v7;
        long v21;
        u u1;
        int[] arr_v5;
        m m1;
        switch(this.a) {
            case 0: {
                A9 a90 = (A9)this.b;
                if(!a90.c) {
                    b1 b10 = a90.b;
                    if(b10 != null) {
                        b10.a(a90.a);
                    }
                    a90.d.l.remove(a90);
                    a90.c = true;
                }
                return;
            }
            case 1: {
                ((B8)this.b).a(null);
                return;
            }
            case 2: {
                r7 r70 = (r7)this.b;
                try {
                    r70.a.a(r70.d, r70.e);
                    return;
                }
                catch(y7 y70) {
                    M7.H("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", y70);
                    throw new RuntimeException(y70);
                }
                finally {
                    r70.b(true);
                }
            }
            case 3: {
                S1 s10 = ((Za)this.b).b;
                s10.Y(s10.X((((h9)s10.c.b).isEmpty() ? null : ((e2)M7.A(((h9)s10.c.b))))), 1006, new P1(8));
                return;
            }
            case 4: {
                Sc sc0 = (Sc)this.b;
                synchronized(sc0.c) {
                    Oc oc0 = sc0.i;
                    if(oc0.a != 0) {
                        oc0.a = 0;
                    }
                    Qc qc0 = sc0.j;
                    if(qc0.a != 0) {
                        qc0.a = 0;
                    }
                    Pc pc0 = sc0.k;
                    if(pc0.a != 0) {
                        pc0.a = 0;
                    }
                    Rc rc0 = sc0.l;
                    int v2 = rc0.a;
                    if(v2 != 0) {
                        if(v2 == 1) {
                            sc0.d.j(rc0.c, false);
                        }
                        sc0.l.a = 0;
                    }
                    Sc.o.a = true;
                    sc0.c.notifyAll();
                }
                return;
            }
            case 5: {
                ((K0.d)this.b).e();
                return;
            }
            case 6: {
                a a0 = ((e)this.b).l();
                c c0 = new c(12);
                ((e)this.b).v(a0, 0x404, c0);
                ((e)this.b).f.d();
                return;
            }
            case 7: {
                D d0 = (D)this.b;
                while(true) {
                    try {
                        int v3 = d0.c.read();
                        if(v3 <= 0) {
                            break;
                        }
                        d0.d.append(String.valueOf(((char)v3)));
                        d0.f.sendEmptyMessageDelayed(5000, 50L);
                    }
                    catch(SocketTimeoutException unused_ex) {
                        LogU.Companion.v("PcmSender", "DataInputStream readLine >> Finished!");
                        break;
                    }
                    catch(Exception exception0) {
                        LogU.Companion.w("PcmSender", "DataInputStream readLine >> Err: " + exception0);
                        break;
                    }
                }
                d0.a();
                return;
            }
            case 8: {
                s s0 = (s)this.b;
                if(s0.h0 >= 300000L) {
                    ((j3.u)s0.r.b).k1 = true;
                    s0.h0 = 0L;
                }
                return;
            }
            case 9: {
                k3.e e0 = (k3.e)this.b;
                if(!e0.c) {
                    h h0 = e0.b;
                    if(h0 != null) {
                        h0.d(e0.a);
                    }
                    e0.d.n.remove(e0);
                    e0.c = true;
                }
                return;
            }
            case 10: {
                ((k3.b)this.b).d(null);
                return;
            }
            case 11: {
                ((CarouselLayoutManager)this.b).I();
                return;
            }
            case 12: {
                Intent intent0 = new Intent();
                Q1.c.Y(intent0, "android.intent.action.VIEW", false);
                intent0.setData(Uri.parse(((Response)this.b).landAppScheme));
                intent0.addFlags(0x10000000);
                MelonAppBase.Companion.getClass();
                t.a().getContext().startActivity(intent0);
                return;
            }
            case 13: {
                ((kb.D)this.b).n();
                return;
            }
            case 14: {
                ((l4.h)this.b).n();
                return;
            }
            case 15: {
                ((l4.k)this.b).n = -1;
                return;
            }
            case 16: {
                ((M)this.b).b();
                return;
            }
            case 17: {
                o3.e e1 = (o3.e)this.b;
                synchronized(e1.a) {
                    if(e1.m) {
                        return;
                    }
                    long v5 = e1.l - 1L;
                    e1.l = v5;
                    int v6 = Long.compare(v5, 0L);
                    if(v6 > 0) {
                        return;
                    }
                    if(v6 < 0) {
                        IllegalStateException illegalStateException0 = new IllegalStateException();
                        synchronized(e1.a) {
                            e1.n = illegalStateException0;
                        }
                        return;
                    }
                    e1.a();
                }
                return;
            }
            case 18: {
                t0.d d1 = (t0.d)this.b;
                z z0 = d1.l;
                u u0 = d1.a;
                if(d1.e()) {
                    u0.u(true);
                    int[] arr_v = z0.b;
                    long[] arr_v1 = z0.a;
                    int v7 = arr_v1.length - 2;
                    if(v7 >= 0) {
                        int v8 = 0;
                        while(true) {
                            long v9 = arr_v1[v8];
                            if((~v9 << 7 & v9 & 0x8080808080808080L) == 0x8080808080808080L) {
                                goto label_153;
                            }
                            int v10 = 8 - (~(v8 - v7) >>> 0x1F);
                            for(int v11 = 0; v11 < v10; ++v11) {
                                if((v9 & 0xFFL) < 0x80L) {
                                    int v12 = arr_v[(v8 << 3) + v11];
                                    if(!d1.d().a(v12)) {
                                        t0.e e2 = new t0.e(v12, d1.k, f.b, null);
                                        d1.d.add(e2);
                                        d1.h.trySend-JP2dKIU(H.a);
                                    }
                                }
                                v9 >>= 8;
                            }
                            if(v10 == 8) {
                            label_153:
                                if(v8 != v7) {
                                    ++v8;
                                    continue;
                                }
                            }
                            goto label_156;
                        }
                    }
                    else {
                    label_156:
                        d1.g(u0.getSemanticsOwner().a(), d1.m);
                        m m0 = d1.d();
                        int[] arr_v2 = m0.b;
                        long[] arr_v3 = m0.a;
                        int v13 = arr_v3.length - 2;
                        if(v13 >= 0) {
                            int v14 = 0;
                            while(true) {
                                long v15 = arr_v3[v14];
                                if((~v15 << 7 & v15 & 0x8080808080808080L) == 0x8080808080808080L) {
                                    goto label_283;
                                }
                                int v16 = 8 - (~(v14 - v13) >>> 0x1F);
                                int v17 = 0;
                                while(v17 < v16) {
                                    if((v15 & 0xFFL) < 0x80L) {
                                        int v18 = arr_v2[(v14 << 3) + v17];
                                        P0 p00 = (P0)z0.b(v18);
                                        Q0 q00 = (Q0)m0.b(v18);
                                        p p0 = q00 == null ? null : q00.a;
                                        if(p0 == null) {
                                            throw Y.d("no value for specified key");
                                        }
                                        int v19 = p0.g;
                                        K k0 = p0.d.a;
                                        if(p00 == null) {
                                            Object[] arr_object = k0.b;
                                            m1 = m0;
                                            long[] arr_v4 = k0.a;
                                            arr_v5 = arr_v2;
                                            int v20 = arr_v4.length - 2;
                                            if(v20 >= 0) {
                                                long[] arr_v6 = arr_v4;
                                                u1 = u0;
                                                v21 = v15;
                                                int v22 = 0;
                                                while(true) {
                                                    long v23 = arr_v6[v22];
                                                    arr_v7 = arr_v3;
                                                    v24 = v13;
                                                    if((~v23 << 7 & v23 & 0x8080808080808080L) == 0x8080808080808080L) {
                                                        goto label_210;
                                                    }
                                                    int v25 = 8 - (~(v22 - v20) >>> 0x1F);
                                                    for(int v26 = 0; v26 < v25; v26 = v27 + 1) {
                                                        if((v23 & 0xFFL) < 0x80L) {
                                                            v27 = v26;
                                                            v28 = v23;
                                                            w w0 = X0.s.y;
                                                            if(q.b(((w)arr_object[(v22 << 3) + v26]), w0)) {
                                                                Object object2 = k0.g(w0);
                                                                if(object2 == null) {
                                                                    object2 = null;
                                                                }
                                                                d1.i(v19, String.valueOf((((List)object2) == null ? null : ((a1.g)je.p.m0(((List)object2))))));
                                                            }
                                                        }
                                                        else {
                                                            v27 = v26;
                                                            v28 = v23;
                                                        }
                                                        v23 = v28 >> 8;
                                                    }
                                                    if(v25 == 8) {
                                                    label_210:
                                                        if(v22 != v20) {
                                                            ++v22;
                                                            arr_v3 = arr_v7;
                                                            v13 = v24;
                                                            continue;
                                                        }
                                                    }
                                                    break;
                                                }
                                            }
                                            else {
                                                goto label_265;
                                            }
                                        }
                                        else {
                                            m1 = m0;
                                            arr_v5 = arr_v2;
                                            v24 = v13;
                                            u1 = u0;
                                            v21 = v15;
                                            arr_v7 = arr_v3;
                                            Object[] arr_object1 = k0.b;
                                            long[] arr_v8 = k0.a;
                                            int v29 = arr_v8.length - 2;
                                            if(v29 >= 0) {
                                                int v30 = 0;
                                                while(true) {
                                                    long v31 = arr_v8[v30];
                                                    Object[] arr_object2 = arr_object1;
                                                    if((~v31 << 7 & v31 & 0x8080808080808080L) == 0x8080808080808080L) {
                                                        goto label_257;
                                                    }
                                                    int v32 = 8 - (~(v30 - v29) >>> 0x1F);
                                                    int v33 = 0;
                                                    while(v33 < v32) {
                                                        if((v31 & 0xFFL) < 0x80L) {
                                                            v34 = v33;
                                                            arr_v9 = arr_v8;
                                                            w w1 = X0.s.y;
                                                            if(q.b(((w)arr_object2[(v30 << 3) + v33]), w1)) {
                                                                Object object3 = p00.a.a.g(w1);
                                                                if(object3 == null) {
                                                                    object3 = null;
                                                                }
                                                                a1.g g0 = ((List)object3) == null ? null : ((a1.g)je.p.m0(((List)object3)));
                                                                Object object4 = k0.g(w1);
                                                                if(object4 == null) {
                                                                    object4 = null;
                                                                }
                                                                a1.g g1 = ((List)object4) == null ? null : ((a1.g)je.p.m0(((List)object4)));
                                                                if(!q.b(g0, g1)) {
                                                                    d1.i(v19, String.valueOf(g1));
                                                                }
                                                            }
                                                        }
                                                        else {
                                                            v34 = v33;
                                                            arr_v9 = arr_v8;
                                                        }
                                                        v31 >>= 8;
                                                        v33 = v34 + 1;
                                                        arr_v8 = arr_v9;
                                                    }
                                                    long[] arr_v10 = arr_v8;
                                                    if(v32 == 8) {
                                                        goto label_258;
                                                    label_257:
                                                        arr_v10 = arr_v8;
                                                    label_258:
                                                        if(v30 != v29) {
                                                            ++v30;
                                                            arr_v8 = arr_v10;
                                                            continue;
                                                        }
                                                    }
                                                    goto label_269;
                                                }
                                                throw Y.d("no value for specified key");
                                            }
                                        }
                                    }
                                    else {
                                        m1 = m0;
                                        arr_v5 = arr_v2;
                                    label_265:
                                        v24 = v13;
                                        u1 = u0;
                                        v21 = v15;
                                        arr_v7 = arr_v3;
                                    }
                                label_269:
                                    ++v17;
                                    arr_v3 = arr_v7;
                                    arr_v2 = arr_v5;
                                    u0 = u1;
                                    v13 = v24;
                                    v15 = v21 >> 8;
                                    m0 = m1;
                                }
                                m m2 = m0;
                                int[] arr_v11 = arr_v2;
                                long[] arr_v12 = arr_v3;
                                u2 = u0;
                                if(v16 == 8) {
                                    goto label_287;
                                label_283:
                                    m2 = m0;
                                    arr_v11 = arr_v2;
                                    arr_v12 = arr_v3;
                                    u2 = u0;
                                label_287:
                                    if(v14 != v13) {
                                        ++v14;
                                        arr_v3 = arr_v12;
                                        m0 = m2;
                                        arr_v2 = arr_v11;
                                        u0 = u2;
                                        continue;
                                    }
                                }
                                break;
                            }
                        }
                        else {
                            u2 = u0;
                        }
                    }
                    z0.c();
                    m m3 = d1.d();
                    int[] arr_v13 = m3.b;
                    Object[] arr_object3 = m3.c;
                    long[] arr_v14 = m3.a;
                    int v35 = arr_v14.length - 2;
                    if(v35 >= 0) {
                        int v36 = 0;
                        while(true) {
                            long v37 = arr_v14[v36];
                            if((~v37 << 7 & v37 & 0x8080808080808080L) == 0x8080808080808080L) {
                                goto label_315;
                            }
                            int v38 = 8 - (~(v36 - v35) >>> 0x1F);
                            for(int v39 = 0; v39 < v38; ++v39) {
                                if((v37 & 0xFFL) < 0x80L) {
                                    int v40 = (v36 << 3) + v39;
                                    z0.h(arr_v13[v40], new P0(((Q0)arr_object3[v40]).a, d1.d()));
                                }
                                v37 >>= 8;
                            }
                            if(v38 == 8) {
                            label_315:
                                if(v36 != v35) {
                                    ++v36;
                                    continue;
                                }
                                d1.m = new P0(u2.getSemanticsOwner().a(), d1.d());
                                d1.n = false;
                                return;
                            }
                            break;
                        }
                    }
                    d1.m = new P0(u2.getSemanticsOwner().a(), d1.d());
                    d1.n = false;
                }
                return;
            }
            case 19: {
                ud.K k1 = (ud.K)this.b;
                if(H0.e.N(k1)) {
                    S0 s00 = (S0)k1.getBinding();
                    if(s00 != null) {
                        RecyclerViewWithEmptyView recyclerViewWithEmptyView0 = s00.c;
                        w0 w00 = recyclerViewWithEmptyView0.getLayoutManager();
                        LinearLayoutManager linearLayoutManager0 = w00 instanceof LinearLayoutManager ? ((LinearLayoutManager)w00) : null;
                        if(linearLayoutManager0 != null) {
                            Object object5 = ((O)k1.getViewModel()).getUiState().getValue();
                            L l0 = object5 instanceof L ? ((L)object5) : null;
                            Integer integer0 = l0 == null ? null : l0.a;
                            if(integer0 != null) {
                                int v41 = (int)integer0;
                                if(linearLayoutManager0.findFirstCompletelyVisibleItemPosition() > v41 || linearLayoutManager0.findLastCompletelyVisibleItemPosition() <= v41) {
                                    int v42 = recyclerViewWithEmptyView0.getHeight();
                                    String s1 = Y.h(recyclerViewWithEmptyView0.getHeight(), v42 / 2, "updateCurrentPosition() recyclerView height: ", ", offset: ");
                                    LogU.debug$default(k1.e, s1, null, false, 6, null);
                                    try {
                                        linearLayoutManager0.scrollToPositionWithOffset(v41, v42 / 2);
                                        return;
                                    }
                                    catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
                                        LogU.Companion.e("StationPlaylistFragment", "updateCurrentPosition() recyclerView", indexOutOfBoundsException0);
                                    }
                                }
                            }
                        }
                    }
                }
                return;
            }
            case 20: {
                this.a();
                return;
            }
            case 21: {
                ImageView imageView0 = ((v)this.b).i;
                BottomDetectableScrollView bottomDetectableScrollView0 = ((v)this.b).h;
                int v43 = bottomDetectableScrollView0 == null ? 0 : bottomDetectableScrollView0.getHeight();
                TextView textView0 = ((v)this.b).g;
                ViewUtils.showWhen(imageView0, v43 < (textView0 == null ? 0 : textView0.getHeight()));
                return;
            }
            default: {
                --((z3.g)this.b).m;
            }
        }
    }
}

