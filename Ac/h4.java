package Ac;

import A0.c;
import Cc.c1;
import Cc.e0;
import F8.A;
import F8.m;
import F8.o;
import J8.W0;
import M.y;
import P0.h;
import P0.j;
import Q4.a;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.f0;
import androidx.fragment.app.l0;
import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.custom.f1;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.utils.image.ImageSelector;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.melon.net.res.v3.CommentConfig;
import com.melon.net.res.v3.MediaAttachHelper.AttachAlbumData;
import com.melon.net.res.v3.MediaAttachHelper.AttachArtistData;
import com.melon.net.res.v3.MediaAttachHelper.AttachImageData;
import com.melon.net.res.v3.MediaAttachHelper.AttachKakaoEmoticonData;
import com.melon.net.res.v3.MediaAttachHelper.AttachLinkGenrlData;
import com.melon.net.res.v3.MediaAttachHelper.AttachLinkVideoData;
import com.melon.net.res.v3.MediaAttachHelper.AttachPropertyData;
import com.melon.net.res.v3.MediaAttachHelper.AttachSongData;
import com.melon.net.res.v3.MediaAttachHelper.AttachVideoData;
import com.melon.ui.I4;
import com.melon.ui.K4;
import d5.w;
import e.b;
import f1.E;
import f1.x;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import r0.d;
import r0.g;
import r0.i;
import r0.n;
import wc.u;
import we.k;
import y0.M;
import y0.T;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"LAc/h4;", "Lcom/melon/ui/o1;", "LAc/r4;", "LJ8/W0;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class h4 extends x4 {
    public final LogU d;
    public A e;
    public final O3 f;
    public final b g;
    public final ImageSelector h;
    public final c i;

    public h4() {
        LogU logU0 = new LogU("CommentWriteFragment");
        logU0.setCategory(Category.UI);
        this.d = logU0;
        this.f = new O3();  // 初始化器: Ljava/lang/Object;-><init>()V
        b b0 = this.registerForActivityResult(new f0(2), new X3(this, 0));
        q.f(b0, "registerForActivityResult(...)");
        this.g = b0;
        this.h = new ImageSelector(this, new c4(this));
        this.i = new c(this, 5);
    }

    // 去混淆评级： 低(20)
    @Override  // com.melon.ui.c0
    public final f1 getInsetHandlingType() {
        return ScreenUtils.isPortrait(this.getContext()) ? f1.c : f1.a;
    }

    @Override  // com.melon.ui.o1
    public final String getPvDummyLogAction() {
        return "reply";
    }

    @Override  // com.melon.ui.o1
    public final Map getPvDummyLogParams() {
        Map map0 = new HashMap();
        map0.put("type", "write");
        map0.put("chnlSeq", String.valueOf(((r4)this.getViewModel()).d()));
        map0.put("contsRefValue", ((r4)this.getViewModel()).g());
        map0.put("cmtSeq", String.valueOf(((r4)this.getViewModel()).e()));
        return map0;
    }

    @Override  // com.melon.ui.J0
    public final a getViewBinding(LayoutInflater layoutInflater0) {
        q.g(layoutInflater0, "inflater");
        return W0.a(layoutInflater0);
    }

    @Override  // com.melon.ui.J0
    public final Class getViewModelClass() {
        return r4.class;
    }

    @Override  // com.melon.ui.c0
    public final boolean isShowTabAndMiniPlayer() {
        return false;
    }

    public final void n(l4 l40, k k0, k k1, l l0, int v) {
        u u4;
        n n3;
        V v16;
        b0 b03;
        V v15;
        V v14;
        r0.q q17;
        V v13;
        V v12;
        o2 o210;
        u u3;
        n n2;
        V v11;
        Configuration configuration3;
        p p3;
        r0.q q9;
        V v10;
        b0 b02;
        p p2;
        Configuration configuration1;
        b4 b40;
        b0 b01;
        CommentConfig commentConfig0 = l40.c;
        List list0 = l40.e;
        g g0 = d.m;
        p p0 = (p)l0;
        p0.c0(0x354412D);
        int v1 = v | (p0.i(l40) ? 4 : 2) | (p0.i(k0) ? 0x20 : 16) | (p0.i(k1) ? 0x100 : 0x80) | (p0.i(this) ? 0x800 : 0x400);
        if(p0.Q(v1 & 1, (v1 & 0x493) != 1170)) {
            Configuration configuration0 = (Configuration)p0.k(AndroidCompositionLocals_androidKt.a);
            w0.p p1 = p0.N();
            V v2 = androidx.compose.runtime.k.a;
            if(p1 == v2) {
                p1 = new w0.p();
                p0.l0(p1);
            }
            d5.l l1 = x.d;
            boolean z = p0.i(l40);
            U u0 = p0.N();
            if(z || u0 == v2) {
                u0 = new U(l40, 6);
                p0.l0(u0);
            }
            b0 b00 = w.O(new Object[0], l1, u0, p0);
            String s = l40.a;
            boolean z1 = p0.i(this);
            boolean z2 = p0.g(b00);
            boolean z3 = p0.i(l40);
            Object object0 = p0.N();
            if((z1 | z2 | z3) != 0 || object0 == v2) {
                configuration1 = configuration0;
                b40 = new b4(p1, this, b00, l40, null);
                b01 = b00;
                p0.l0(b40);
            }
            else {
                b01 = b00;
                b40 = object0;
                configuration1 = configuration0;
            }
            J.d(p0, s, b40);
            FillElement fillElement0 = androidx.compose.foundation.layout.d.c;
            r0.q q0 = androidx.compose.foundation.q.f(fillElement0, e0.T(p0, 0x7F0604AA), M.a);  // color:white000s_support_high_contrast
            i i0 = d.a;
            u u1 = M.a;
            N0.M m0 = M.p.d(i0, false);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            P0.i i1 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            h h0 = j.f;
            androidx.compose.runtime.w.x(p0, m0, h0);
            h h1 = j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            h h2 = j.g;
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            h h3 = j.d;
            androidx.compose.runtime.w.x(p0, q1, h3);
            r0.q q2 = androidx.compose.foundation.q.x(fillElement0, androidx.compose.foundation.q.t(p0), false, 14);
            N0.M m1 = M.p.d(i0, false);
            int v4 = p0.P;
            i0 i01 = p0.m();
            r0.q q3 = r0.a.d(p0, q2);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m1, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            androidx.compose.runtime.w.x(p0, q3, h3);
            y y0 = M.w.a(M.j.c, g0, p0, 0);
            int v5 = p0.P;
            i0 i02 = p0.m();
            r0.q q4 = r0.a.d(p0, fillElement0);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y0, h0);
            androidx.compose.runtime.w.x(p0, i02, h1);
            if(p0.O || !q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h2);
            }
            androidx.compose.runtime.w.x(p0, q4, h3);
            n n0 = n.a;
            r0.q q5 = androidx.compose.foundation.layout.d.t(androidx.compose.foundation.layout.d.f(androidx.compose.ui.focus.a.a(n0, p1), 1.0f), 3);
            long v6 = e0.T(p0, 0x7F060169);  // color:gray850s
            long v7 = e0.N(22.0f, p0);
            a1.U u2 = new a1.U(v6, e0.N(15.0f, p0), null, null, 0L, null, 0, v7, 0xFDFFFC);
            T t0 = new T(e0.T(p0, 0x7F06017A));  // color:green500e_support_high_contrast
            x x0 = (x)b01.getValue();
            boolean z4 = p0.g(b01);
            Z3 z30 = p0.N();
            if(z4 || (v1 & 0x70) == 0x20 || z30 == v2) {
                z30 = new Z3(b01, k0, 0);
                p0.l0(z30);
            }
            m0.b b0 = m0.c.e(-2044502812, p0, new a4(0, b01, l40));
            Configuration configuration2 = configuration1;
            V v8 = v2;
            c1.h(x0, z30, q5, false, u2, null, null, false, 0, 0, E.a, null, t0, b0, p0, 0, 0x180180, 0x6FD8);
            p2 = p0;
            if(list0 == null || !list0.isEmpty() != 1) {
                b03 = b01;
                v16 = v8;
                u4 = u1;
                n3 = n0;
                p2.a0(0xF195CF33);
                p2.p(false);
            }
            else {
                p2.a0(0xF292F1CB);
                n n1 = n0;
                r0.q q6 = androidx.compose.foundation.layout.a.n(n1, 20.0f, 0.0f, 0.0f, 0.0f, 14);
                N0.M m2 = M.p.d(i0, false);
                int v9 = p2.P;
                i0 i03 = p2.m();
                r0.q q7 = r0.a.d(p2, q6);
                p2.e0();
                if(p2.O) {
                    p2.l(i1);
                }
                else {
                    p2.o0();
                }
                androidx.compose.runtime.w.x(p2, m2, h0);
                androidx.compose.runtime.w.x(p2, i03, h1);
                if(p2.O || !q.b(p2.N(), v9)) {
                    A7.d.q(v9, p2, v9, h2);
                }
                androidx.compose.runtime.w.x(p2, q7, h3);
                p2.a0(0xB7A2AD09);
                for(Object object1: list0) {
                    AttachPropertyData mediaAttachHelper$AttachPropertyData0 = (AttachPropertyData)object1;
                    if(mediaAttachHelper$AttachPropertyData0 instanceof AttachImageData) {
                        p2.a0(0x74EFD0F6);
                        if(configuration2.orientation == 2) {
                            p2.a0(0x74F1D700);
                            r0.q q8 = androidx.compose.foundation.layout.a.n(n1, 0.0f, 16.0f, 20.0f, 0.0f, 9);
                            boolean z5 = p2.i(this);
                            o2 o20 = p2.N();
                            if(z5 || o20 == v8) {
                                v10 = v8;
                                q9 = q8;
                                b02 = b01;
                                o2 o21 = new o2(1, this, h4.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 11);
                                p2.l0(o21);
                                o20 = o21;
                            }
                            else {
                                b02 = b01;
                                v10 = v8;
                                q9 = q8;
                            }
                            Ac.y.f(q9, ((AttachImageData)mediaAttachHelper$AttachPropertyData0), 0, true, o20, p2, 0xC06);
                            p2.p(false);
                            p3 = p2;
                        }
                        else {
                            b02 = b01;
                            v10 = v8;
                            p2.a0(0x74FB194A);
                            r0.q q10 = androidx.compose.foundation.layout.a.n(n1, 0.0f, 6.0f, 20.0f, 0.0f, 9);
                            boolean z6 = p2.i(this);
                            o2 o22 = p2.N();
                            if(z6 || o22 == v10) {
                                o2 o23 = new o2(1, this, h4.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 12);
                                p2.l0(o23);
                                o22 = o23;
                            }
                            Ac.y.e(q10, ((AttachImageData)mediaAttachHelper$AttachPropertyData0), 0, true, o22, p2, 0xC06, 4);
                            p3 = p2;
                            p3.p(false);
                        }
                        p3.p(false);
                        p2 = p3;
                        goto label_203;
                    }
                    else {
                        b02 = b01;
                        v10 = v8;
                        if(mediaAttachHelper$AttachPropertyData0 instanceof AttachSongData) {
                            p2.a0(0x7505C739);
                            r0.q q11 = androidx.compose.foundation.layout.a.n(n1, 0.0f, 16.0f, 0.0f, 0.0f, 13);
                            boolean z7 = p2.i(this);
                            o2 o24 = p2.N();
                            if(z7 || o24 == v10) {
                                o2 o25 = new o2(1, this, h4.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 13);
                                p2.l0(o25);
                                o24 = o25;
                            }
                            Ac.y.b(q11, mediaAttachHelper$AttachPropertyData0, true, true, o24, p2, 0xD86);
                            p2.p(false);
                            goto label_203;
                        }
                        else if(mediaAttachHelper$AttachPropertyData0 instanceof AttachAlbumData) {
                            p2.a0(0x750F0AD8);
                            r0.q q12 = androidx.compose.foundation.layout.a.n(n1, 0.0f, 16.0f, 0.0f, 0.0f, 13);
                            boolean z8 = p2.i(this);
                            o2 o26 = p2.N();
                            if(z8 || o26 == v10) {
                                o2 o27 = new o2(1, this, h4.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 14);
                                p2.l0(o27);
                                o26 = o27;
                            }
                            Ac.y.b(q12, mediaAttachHelper$AttachPropertyData0, false, true, o26, p2, 0xD86);
                            p2.p(false);
                            goto label_203;
                        }
                        else if(mediaAttachHelper$AttachPropertyData0 instanceof AttachArtistData) {
                            p2.a0(1964529207);
                            r0.q q13 = androidx.compose.foundation.layout.a.n(n1, 0.0f, 16.0f, 0.0f, 0.0f, 13);
                            boolean z9 = p2.i(this);
                            o2 o28 = p2.N();
                            if(z9 || o28 == v10) {
                                o2 o29 = new o2(1, this, h4.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 15);
                                p2.l0(o29);
                                o28 = o29;
                            }
                            Ac.y.a(q13, ((AttachArtistData)mediaAttachHelper$AttachPropertyData0), true, o28, p2, 0xD86);
                            p2.p(false);
                        label_203:
                            configuration3 = configuration2;
                            v11 = v10;
                            n2 = n1;
                            u3 = u1;
                        }
                        else if(mediaAttachHelper$AttachPropertyData0 instanceof AttachVideoData) {
                            p2.a0(1965138202);
                            r0.q q14 = androidx.compose.foundation.layout.a.n(n1, 0.0f, 16.0f, 0.0f, 0.0f, 13);
                            boolean z10 = p2.i(this);
                            Object object2 = p2.N();
                            if(z10 || object2 == v10) {
                                o210 = new o2(1, this, h4.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 16);
                                p2.l0(o210);
                            }
                            else {
                                o210 = object2;
                            }
                            Ac.y.g(q14, mediaAttachHelper$AttachPropertyData0, 0, true, true, o210, p2, 0x6C06, 4);
                            p2.p(false);
                            configuration3 = configuration2;
                            n2 = n1;
                            u3 = u1;
                            v11 = v10;
                        }
                        else if(mediaAttachHelper$AttachPropertyData0 instanceof AttachLinkVideoData) {
                            p2.a0(0x752AF059);
                            r0.q q15 = androidx.compose.foundation.layout.a.n(n1, 0.0f, 16.0f, 0.0f, 0.0f, 13);
                            boolean z11 = p2.i(this);
                            o2 o211 = p2.N();
                            if(z11 || o211 == v10) {
                                v12 = v10;
                                u3 = u1;
                                o2 o212 = new o2(1, this, h4.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 17);
                                p2.l0(o212);
                                o211 = o212;
                            }
                            else {
                                v12 = v10;
                                u3 = u1;
                            }
                            Ac.y.g(q15, mediaAttachHelper$AttachPropertyData0, 0, false, true, o211, p2, 0x6C06, 4);
                            p2.p(false);
                            configuration3 = configuration2;
                            n2 = n1;
                            v11 = v12;
                        }
                        else {
                            u3 = u1;
                            if(mediaAttachHelper$AttachPropertyData0 instanceof AttachLinkGenrlData) {
                                p2.a0(0x75343474);
                                r0.q q16 = androidx.compose.foundation.layout.a.n(n1, 0.0f, 16.0f, 0.0f, 0.0f, 13);
                                boolean z12 = p2.i(this);
                                o2 o213 = p2.N();
                                if(z12) {
                                    v13 = v10;
                                }
                                else {
                                    v13 = v10;
                                    if(o213 != v13) {
                                        q17 = q16;
                                        v14 = v13;
                                        goto label_263;
                                    }
                                }
                                v14 = v13;
                                q17 = q16;
                                o2 o214 = new o2(1, this, h4.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 18);
                                p2.l0(o214);
                                o213 = o214;
                            label_263:
                                Ac.y.d(q17, ((AttachLinkGenrlData)mediaAttachHelper$AttachPropertyData0), o213, p2, 6);
                                p2.p(false);
                                configuration3 = configuration2;
                                n2 = n1;
                                v11 = v14;
                            }
                            else {
                                if(mediaAttachHelper$AttachPropertyData0 instanceof AttachKakaoEmoticonData) {
                                    p2.a0(1966850766);
                                    r0.q q18 = androidx.compose.foundation.layout.a.n(n1, 0.0f, 16.0f, 0.0f, 0.0f, 13);
                                    n2 = n1;
                                    boolean z13 = p2.i(this);
                                    o2 o215 = p2.N();
                                    if(z13) {
                                    label_282:
                                        v15 = v10;
                                    }
                                    else {
                                        if(o215 == v10) {
                                            v15 = v10;
                                            goto label_283;
                                        }
                                        else {
                                            configuration3 = configuration2;
                                            v11 = v10;
                                            goto label_288;
                                        }
                                        goto label_282;
                                    }
                                label_283:
                                    configuration3 = configuration2;
                                    v11 = v15;
                                    o2 o216 = new o2(1, this, h4.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 19);
                                    p2.l0(o216);
                                    o215 = o216;
                                label_288:
                                    Ac.y.c(q18, ((AttachKakaoEmoticonData)mediaAttachHelper$AttachPropertyData0), true, o215, p2, 390);
                                }
                                else {
                                    configuration3 = configuration2;
                                    n2 = n1;
                                    v11 = v10;
                                    p2.a0(0x73F0EACF);
                                }
                                p2.p(false);
                            }
                        }
                    }
                    v8 = v11;
                    n1 = n2;
                    configuration2 = configuration3;
                    b01 = b02;
                    u1 = u3;
                }
                b03 = b01;
                v16 = v8;
                n3 = n1;
                u4 = u1;
                A7.d.s(p2, false, true, false);
            }
            M.c.d(p2, androidx.compose.foundation.layout.d.h(n3, 86.0f));
            p2.p(true);
            p2.p(true);
            r0.q q19 = androidx.compose.foundation.q.f((androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(n3, d.g), e0.T(p2, 0x7F0604AA), u4);  // color:white000s_support_high_contrast
            y y1 = M.w.a(M.j.c, g0, p2, 0);
            int v17 = p2.P;
            i0 i04 = p2.m();
            r0.q q20 = r0.a.d(p2, q19);
            P0.k.y.getClass();
            P0.i i2 = j.b;
            p2.e0();
            if(p2.O) {
                p2.l(i2);
            }
            else {
                p2.o0();
            }
            androidx.compose.runtime.w.x(p2, y1, j.f);
            androidx.compose.runtime.w.x(p2, i04, j.e);
            h h4 = j.g;
            if(p2.O || !q.b(p2.N(), v17)) {
                A7.d.q(v17, p2, v17, h4);
            }
            androidx.compose.runtime.w.x(p2, q20, j.d);
            r0.q q21 = androidx.compose.foundation.layout.d.u(n3, 3);
            o1.e(androidx.compose.foundation.layout.a.n(H0.b.q(d.o, q21), 0.0f, 0.0f, 16.0f, 0.0f, 11), ((x)b03.getValue()).a.b, String.valueOf(commentConfig0.getWriteMaxLength()), p2, 0);
            M.c.d(p2, androidx.compose.foundation.layout.d.h(n3, 10.0f));
            b0.y.b(null, 0.5f, e0.T(p2, 0x7F06014A), p2, 0x30);  // color:gray100a
            if(commentConfig0.isAttachable()) {
                p2.a0(1906677413);
                Y1 y10 = p2.N();
                if((v1 & 0x380) == 0x100 || y10 == v16) {
                    y10 = new Y1(3, k1);
                    p2.l0(y10);
                }
                o1.b(commentConfig0, list0, y10, p2, 0);
            }
            else {
                p2.a0(0x7043E4F9);
            }
            p2.p(false);
            p2.p(true);
            p2.p(true);
        }
        else {
            p2 = p0;
            p2.T();
        }
        n0 n00 = p2.t();
        if(n00 != null) {
            n00.d = new U2(this, l40, k0, k1, v, 1);
        }
    }

    @Override  // com.melon.ui.J0
    public final void onConfigurationChanged(Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        FragmentActivity fragmentActivity0 = this.getActivity();
        MusicBrowserActivity musicBrowserActivity0 = fragmentActivity0 instanceof MusicBrowserActivity ? ((MusicBrowserActivity)fragmentActivity0) : null;
        if(musicBrowserActivity0 != null) {
            musicBrowserActivity0.updateSystemUiFit((configuration0.orientation == 1 ? f1.c : f1.a));
        }
    }

    @Override  // com.melon.ui.c0
    public final void onDestroy() {
        if(b9.d.h == null) {
            b9.d.h = new b9.d();
        }
        b9.d d0 = b9.d.h;
        if(d0 != null) {
            d0.e = this;
            d0.a();
            super.onDestroy();
            return;
        }
        q.m("mInstance");
        throw null;
    }

    @Override  // com.melon.ui.c0
    public final void onPause() {
        super.onPause();
    }

    @Override  // com.melon.ui.c0
    public final void onResume() {
        super.onResume();
    }

    @Override  // com.melon.ui.J0
    public final void onUiEvent(I4 i40) {
        q.g(i40, "event");
        LogU.debug$default(this.d, "CommentWriteFragment onUiEvent: " + i40, null, false, 6, null);
        if(i40 instanceof G1) {
            this.h.cleanUp();
        }
        else if(i40 instanceof A1) {
            l0 l00 = this.requireActivity().getSupportFragmentManager();
            o2 o20 = new o2(1, this, h4.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 20);
            l0 l01 = this.getParentFragmentManager();
            this.f.b(l00, ((B1)i40), o20, l01);
        }
        super.onUiEvent(i40);
    }

    @Override  // com.melon.ui.J0
    public final void onViewCreated(View view0, Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        W0 w00 = (W0)this.getBinding();
        if(w00 == null) {
            return;
        }
        TitleBar titleBar0 = (TitleBar)w00.c.c;
        F8.p p0 = new F8.p(1);
        p0.c = new W3(this, 0);
        m m0 = new m(2, 0);
        m0.m = this.getString(0x7F130B32);  // string:talkback_gnb_cmt_write_info "댓글쓰기 안내 열기"
        W3 w30 = new W3(this, 1);
        if(m0.j != 0) {
            m0.l = w30;
        }
        A a0 = new A();  // 初始化器: Ljava/lang/Object;-><init>()V
        String s = this.getString(0x7F130C1E);  // string:talkback_registration_btn "등록 버튼"
        q.f(s, "getString(...)");
        a0.d = s;
        a0.c = new W3(this, 2);
        this.e = a0;
        o[] arr_o = {p0, m0, a0};
        o o0 = null;
        for(int v = 0; v < 3; ++v) {
            o o1 = arr_o[v];
            if(o0 == null) {
                o0 = o1;
            }
            else {
                o0.g(o1);
            }
        }
        if(o0 != null) {
            titleBar0.a(o0);
        }
        titleBar0.setTitle("글쓰기");
        titleBar0.f(true);
        BuildersKt__Builders_commonKt.launch$default(androidx.lifecycle.f0.f(this), null, null, new g4(this, null), 3, null);
    }

    @Override  // com.melon.ui.J0
    public final void renderUi(K4 k40) {
        q.g(k40, "uiState");
        W0 w00 = (W0)this.getBinding();
        if(w00 == null) {
            return;
        }
        m0.b b0 = new m0.b(-489321704, new z(k40, this, 9), true);
        w00.b.setContent(b0);
    }

    @Override  // com.melon.ui.c0
    public final void setInsetHandlingType(f1 f10) {
        q.g(f10, "<set-?>");
    }
}

