package com.iloen.melon.popup;

import Cc.N1;
import Cc.e0;
import Cc.h0;
import De.I;
import K.m;
import L5.c;
import M.y;
import N0.M;
import P0.h;
import P0.i;
import P0.j;
import Q0.k0;
import Q0.t0;
import T.e;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.b;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.fragment.app.l0;
import com.bumptech.glide.Glide;
import com.bumptech.glide.integration.webp.decoder.WebpDrawable;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.iloen.melon.net.v4x.response.MainBottomSlidePopupRes.Response.Banner;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.utils.preference.MusicTabPrefsHelper;
import com.iloen.melon.utils.system.ScreenUtils;
import com.kakao.tiara.data.ContentList;
import com.kakao.tiara.data.ViewImpContent.Builder;
import com.kakao.tiara.data.ViewImpContent;
import i6.d;
import ie.H;
import java.util.List;
import je.p;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r0.n;
import we.a;
import we.o;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 /2\u00020\u0001:\u0001/B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001A\u00020\u00062\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0016\u00A2\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000B\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\t2\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0016\u00A2\u0006\u0004\b\u000B\u0010\fJ-\u0010\u0011\u001A\u0004\u0018\u00010\t2\u0006\u0010\u000E\u001A\u00020\r2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000F2\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0016\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0013\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0003J%\u0010\u0019\u001A\u00020\u00062\u000E\u0010\u0016\u001A\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\u0006\u0010\u0018\u001A\u00020\u0017\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u0087\u0001\u0010)\u001A\u00020\u00062\n\b\u0002\u0010\u001C\u001A\u0004\u0018\u00010\u001B2\n\b\u0002\u0010\u001D\u001A\u0004\u0018\u00010\u001B2\b\b\u0002\u0010\u001F\u001A\u00020\u001E2\b\b\u0002\u0010 \u001A\u00020\u001E2\n\b\u0002\u0010!\u001A\u0004\u0018\u00010\u001B2\b\b\u0002\u0010\"\u001A\u00020\u001E2\u0010\b\u0002\u0010$\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010#2\u0010\b\u0002\u0010%\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010#2\u0010\b\u0002\u0010&\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010#H\u0007\u00A2\u0006\u0004\b\'\u0010(R(\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00150\u00148\u0006@\u0006X\u0086.\u00A2\u0006\u0012\n\u0004\b\u0016\u0010*\u001A\u0004\b+\u0010,\"\u0004\b-\u0010.\u00A8\u00064\u00B2\u0006\u0010\u00101\u001A\u0004\u0018\u0001008\n@\nX\u008A\u008E\u0002\u00B2\u0006\u000E\u00103\u001A\u0002028\n@\nX\u008A\u008E\u0002"}, d2 = {"Lcom/iloen/melon/popup/MainBottomPopup;", "Li6/d;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onStart", "", "Lcom/iloen/melon/net/v4x/response/MainBottomSlidePopupRes$Response$Banner;", "banners", "Landroidx/fragment/app/l0;", "fragmentManager", "show", "(Ljava/util/List;Landroidx/fragment/app/l0;)V", "", "imageUrl", "buttonText", "Ly0/s;", "buttonTextColor", "buttonBgColor", "dismissText", "dismissTextColor", "Lkotlin/Function0;", "onBannerButtonClick", "onCloseButtonClick", "onDismissTextClick", "BottomSheetDialogScreen-_ZOWojw", "(Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;JLwe/a;Lwe/a;Lwe/a;Landroidx/compose/runtime/l;II)V", "BottomSheetDialogScreen", "Ljava/util/List;", "getBanners", "()Ljava/util/List;", "setBanners", "(Ljava/util/List;)V", "Companion", "Landroid/graphics/drawable/Drawable;", "bannerImageDrawable", "Lr1/l;", "size", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MainBottomPopup extends d {
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001J\u001D\u0010\u0006\u001A\u00020\u00052\u000E\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001A\u00020\b8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\t\u0010\n\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000ER\u0014\u0010\u000F\u001A\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000F\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/popup/MainBottomPopup$Companion;", "", "", "Lcom/iloen/melon/net/v4x/response/MainBottomSlidePopupRes$Response$Banner;", "banners", "", "isBannerAvailable", "(Ljava/util/List;)Z", "", "hideBannerId", "Ljava/lang/String;", "getHideBannerId", "()Ljava/lang/String;", "setHideBannerId", "(Ljava/lang/String;)V", "TAG", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        // 去混淆评级： 低(20)
        @NotNull
        public final String getHideBannerId() [...] // 潜在的解密器

        public final boolean isBannerAvailable(@Nullable List list0) {
            if(list0 != null && !list0.isEmpty()) {
                Banner mainBottomSlidePopupRes$Response$Banner0 = (Banner)p.m0(list0);
                if(mainBottomSlidePopupRes$Response$Banner0 != null) {
                    if(q.b("", mainBottomSlidePopupRes$Response$Banner0.banerseq)) {
                        return false;
                    }
                    Long long0 = (Long)MusicTabPrefsHelper.INSTANCE.getBottomSlideBanner().get(mainBottomSlidePopupRes$Response$Banner0.banerseq);
                    return long0 == null || System.currentTimeMillis() > long0.longValue();
                }
                return true;
            }
            return false;
        }

        public final void setHideBannerId(@NotNull String s) {
            q.g(s, "<set-?>");
            MainBottomPopup.a = s;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "MelonMainBottomPopup";
    public static String a;
    public List banners;

    static {
        MainBottomPopup.Companion = new Companion(null);
        MainBottomPopup.$stable = 8;
        MainBottomPopup.a = "";
    }

    public final void BottomSheetDialogScreen-_ZOWojw(@Nullable String s, @Nullable String s1, long v, long v1, @Nullable String s2, long v2, @Nullable a a0, @Nullable a a1, @Nullable a a2, @Nullable l l0, int v3, int v4) {
        long v26;
        a a12;
        long v25;
        a a11;
        long v24;
        String s11;
        String s10;
        String s9;
        String s8;
        a a10;
        a a9;
        a a8;
        long v23;
        long v22;
        String s7;
        a a7;
        a a6;
        long v17;
        a a5;
        int v13;
        String s6;
        a a4;
        a a3;
        String s5;
        String s4;
        int v12;
        int v11;
        long v10;
        String s3;
        int v9;
        long v8;
        int v7;
        long v6;
        int v5;
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0xFDB3DAF1);
        if((v4 & 1) == 0) {
            v5 = (v3 & 6) == 0 ? (p0.g(s) ? 4 : 2) | v3 : v3;
        }
        else {
            v5 = v3 | 6;
        }
        if((v4 & 2) != 0) {
            v5 |= 0x30;
        }
        else if((v3 & 0x30) == 0) {
            v5 |= (p0.g(s1) ? 0x20 : 16);
        }
        if((v3 & 0x180) == 0) {
            if((v4 & 4) == 0) {
                v6 = v;
                v7 = p0.f(v6) ? 0x100 : 0x80;
            }
            else {
                v6 = v;
                v7 = 0x80;
            }
            v5 |= v7;
        }
        else {
            v6 = v;
        }
        if((v3 & 0xC00) == 0) {
            if((v4 & 8) == 0) {
                v8 = v1;
                v9 = p0.f(v8) ? 0x800 : 0x400;
            }
            else {
                v8 = v1;
                v9 = 0x400;
            }
            v5 |= v9;
        }
        else {
            v8 = v1;
        }
        if((v4 & 16) != 0) {
            v5 |= 0x6000;
            s3 = s2;
        }
        else if((v3 & 0x6000) == 0) {
            s3 = s2;
            v5 |= (p0.g(s3) ? 0x4000 : 0x2000);
        }
        else {
            s3 = s2;
        }
        if((v3 & 0x30000) == 0) {
            v10 = v2;
            v5 |= ((v4 & 0x20) != 0 || !p0.f(v10) ? 0x10000 : 0x20000);
        }
        else {
            v10 = v2;
        }
        if((v4 & 0x40) != 0) {
            v5 |= 0x180000;
        }
        else if((v3 & 0x180000) == 0) {
            v5 |= (p0.i(a0) ? 0x100000 : 0x80000);
        }
        if((v4 & 0x80) != 0) {
            v5 |= 0xC00000;
            v11 = v4 & 0x80;
        }
        else if((v3 & 0xC00000) == 0) {
            v11 = v4 & 0x80;
            v5 |= (p0.i(a1) ? 0x800000 : 0x400000);
        }
        else {
            v11 = v4 & 0x80;
        }
        if((v4 & 0x100) != 0) {
            v5 |= 0x6000000;
            v12 = v4 & 0x100;
        }
        else if((v3 & 0x6000000) == 0) {
            v12 = v4 & 0x100;
            v5 |= (p0.i(a2) ? 0x4000000 : 0x2000000);
        }
        else {
            v12 = v4 & 0x100;
        }
        if(p0.Q(v5 & 1, (v5 & 0x2492493) != 0x2492492)) {
            p0.V();
            if((v3 & 1) == 0 || p0.B()) {
                s4 = (v4 & 1) == 0 ? s : null;
                s5 = (v4 & 2) == 0 ? s1 : null;
                if((v4 & 4) != 0) {
                    v6 = e0.T(p0, 0x7F0604A1);  // color:white000e
                    v5 &= -897;
                }
                if((v4 & 8) != 0) {
                    v8 = e0.T(p0, 0x7F06017A);  // color:green500e_support_high_contrast
                    v5 &= 0xFFFFE3FF;
                }
                if((v4 & 16) != 0) {
                    s3 = null;
                }
                if((v4 & 0x20) != 0) {
                    v10 = e0.T(p0, 0x7F0604A1);  // color:white000e
                    v5 &= 0xFFF8FFFF;
                }
                a3 = (v4 & 0x40) == 0 ? a0 : null;
                a4 = v11 == 0 ? a1 : null;
                s6 = s3;
                v13 = v5;
                a5 = v12 == 0 ? a2 : null;
            }
            else {
                p0.T();
                if((v4 & 4) != 0) {
                    v5 &= -897;
                }
                if((v4 & 8) != 0) {
                    v5 &= 0xFFFFE3FF;
                }
                if((v4 & 0x20) != 0) {
                    v5 &= 0xFFF8FFFF;
                }
                s4 = s;
                s5 = s1;
                a3 = a0;
                a4 = a1;
                s6 = s3;
                v13 = v5;
                a5 = a2;
            }
            p0.q();
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            int v14 = ((Configuration)p0.k(AndroidCompositionLocals_androidKt.a)).orientation;
            b0 b00 = p0.N();
            V v15 = k.a;
            if(b00 == v15) {
                b00 = w.s(null);
                p0.l0(b00);
            }
            n n0 = n.a;
            r0.q q0 = d5.n.o(androidx.compose.foundation.layout.d.t(androidx.compose.foundation.layout.d.f(n0, 1.0f), 3), e.d(15.0f, 15.0f, 0.0f, 0.0f, 12));
            M m0 = M.p.d(r0.d.a, false);
            int v16 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            i i0 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            h h0 = j.f;
            w.x(p0, m0, h0);
            h h1 = j.e;
            w.x(p0, i00, h1);
            h h2 = j.g;
            if(p0.O || !q.b(p0.N(), v16)) {
                A7.d.q(v16, p0, v16, h2);
            }
            h h3 = j.d;
            w.x(p0, q1, h3);
            Drawable drawable0 = (Drawable)b00.getValue();
            if(drawable0 == null) {
                p0.a0(-1054592388);
                p0.p(false);
                v17 = v10;
                a6 = a4;
            }
            else {
                p0.a0(-1054592387);
                b0 b01 = p0.N();
                if(b01 == v15) {
                    v17 = v10;
                    b01 = w.s(new r1.l(0L));
                    p0.l0(b01);
                }
                else {
                    v17 = v10;
                }
                a6 = a4;
                r0.q q2 = r0.a.a(androidx.compose.foundation.q.x(n0, androidx.compose.foundation.q.t(p0), false, 14), new o() {
                    @Override  // we.o
                    public Object invoke(Object object0, Object object1, Object object2) {
                        return this.invoke(((r0.q)object0), ((l)object1), ((Number)object2).intValue());
                    }

                    public final r0.q invoke(r0.q q0, l l0, int v) {
                        q.g(q0, "$this$composed");
                        ((androidx.compose.runtime.p)l0).a0(0x1FF03545);
                        w0.h h0 = (w0.h)((androidx.compose.runtime.p)l0).k(k0.i);
                        m m0 = ((androidx.compose.runtime.p)l0).N();
                        if(m0 == k.a) {
                            m0 = androidx.appcompat.app.o.d(((androidx.compose.runtime.p)l0));
                        }
                        X0.i i0 = new X0.i(a3);
                        com.iloen.melon.popup.MainBottomPopup.BottomSheetDialogScreen__ZOWojw.lambda.33.lambda.22..inlined.noRippleClickable-YQRRFTQ.default.1.1 mainBottomPopup$BottomSheetDialogScreen__ZOWojw$lambda$33$lambda$22$$inlined$noRippleClickable-YQRRFTQ$default$1$10 = new a() {
                            @Override  // we.a
                            public Object invoke() {
                                this.invoke();
                                return H.a;
                            }

                            public final void invoke() {
                                w0.h.a(this.d);
                                a a0 = this.b;
                                if(a0 != null) {
                                    a0.invoke();
                                }
                            }
                        };
                        r0.q q1 = androidx.compose.foundation.q.l(q0, m0, null, null, 0, i0, mainBottomPopup$BottomSheetDialogScreen__ZOWojw$lambda$33$lambda$22$$inlined$noRippleClickable-YQRRFTQ$default$1$10);
                        ((androidx.compose.runtime.p)l0).p(false);
                        return q1;
                    }
                });
                g g0 = p0.N();
                if(g0 == v15) {
                    g0 = new g(b01, 4);
                    p0.l0(g0);
                }
                r0.q q3 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(androidx.compose.ui.layout.a.f(q2, g0), 1.0f), (ScreenUtils.isTablet(context0) ? 700.0f : 590.0f));
                y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
                int v18 = p0.P;
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
                if(p0.O || !q.b(p0.N(), v18)) {
                    A7.d.q(v18, p0, v18, h2);
                }
                w.x(p0, q4, h3);
                if(v14 == 1) {
                    p0.a0(0xA6A0D011);
                    r0.q q5 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(n0, 1.0f), ((float)(ScreenUtils.isTablet(context0) ? 700 : 590)));
                    androidx.compose.foundation.q.c(c.a(((Drawable)b00.getValue()), p0), H0.e.Y(p0, 0x7F130ADA), q5, null, N0.j.b, 0.0f, null, p0, 0x6000, 104);  // string:talkback_banner "배너"
                }
                else {
                    p0.a0(0xA6A8B17D);
                    int v19 = (int)(((r1.l)b01.getValue()).a >> 0x20);
                    int v20 = drawable0.getIntrinsicWidth();
                    r0.q q6 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(n0, 1.0f), ((float)(drawable0.getIntrinsicHeight() * (v19 / v20))));
                    androidx.compose.foundation.q.c(c.a(((Drawable)b00.getValue()), p0), H0.e.Y(p0, 0x7F130ADA), q6, null, N0.j.h, 0.0f, null, p0, 0x6000, 104);  // string:talkback_banner "배너"
                }
                p0.p(false);
                p0.p(true);
                p0.p(false);
            }
            r0.q q7 = androidx.compose.foundation.layout.a.j(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.q(n0, 46.0f), 50.0f), 4.0f);
            a7 = a6;
            r0.q q8 = r0.a.a((b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q7, r0.d.c), new o() {
                @Override  // we.o
                public Object invoke(Object object0, Object object1, Object object2) {
                    return this.invoke(((r0.q)object0), ((l)object1), ((Number)object2).intValue());
                }

                public final r0.q invoke(r0.q q0, l l0, int v) {
                    q.g(q0, "$this$composed");
                    ((androidx.compose.runtime.p)l0).a0(0x1FF03545);
                    w0.h h0 = (w0.h)((androidx.compose.runtime.p)l0).k(k0.i);
                    m m0 = ((androidx.compose.runtime.p)l0).N();
                    if(m0 == k.a) {
                        m0 = androidx.appcompat.app.o.d(((androidx.compose.runtime.p)l0));
                    }
                    X0.i i0 = new X0.i(a7);
                    com.iloen.melon.popup.MainBottomPopup.BottomSheetDialogScreen__ZOWojw.lambda.33..inlined.noRippleClickable-YQRRFTQ.default.1.1 mainBottomPopup$BottomSheetDialogScreen__ZOWojw$lambda$33$$inlined$noRippleClickable-YQRRFTQ$default$1$10 = new a() {
                        @Override  // we.a
                        public Object invoke() {
                            this.invoke();
                            return H.a;
                        }

                        public final void invoke() {
                            w0.h.a(this.d);
                            a a0 = this.b;
                            if(a0 != null) {
                                a0.invoke();
                            }
                        }
                    };
                    r0.q q1 = androidx.compose.foundation.q.l(q0, m0, null, null, 0, i0, mainBottomPopup$BottomSheetDialogScreen__ZOWojw$lambda$33$$inlined$noRippleClickable-YQRRFTQ$default$1$10);
                    ((androidx.compose.runtime.p)l0).p(false);
                    return q1;
                }
            });
            androidx.compose.foundation.q.c(I.Q(0x7F0801D1, p0, 6), H0.e.Y(p0, 0x7F130AE8), q8, null, null, 0.0f, new y0.k(v17, 5), p0, 0, 56);  // drawable:btn_gnb_close_w
            r0.q q9 = androidx.compose.foundation.layout.d.f(n0, 1.0f);
            r0.q q10 = androidx.compose.foundation.layout.a.n((b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q9, r0.d.h), 20.0f, 0.0f, 20.0f, 40.0f, 2);
            y y1 = M.w.a(M.j.c, r0.d.n, p0, 0x30);
            int v21 = p0.P;
            i0 i02 = p0.m();
            r0.q q11 = r0.a.d(p0, q10);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, y1, h0);
            w.x(p0, i02, h1);
            if(p0.O || !q.b(p0.N(), v21)) {
                A7.d.q(v21, p0, v21, h2);
            }
            w.x(p0, q11, h3);
            if(s5 == null) {
                p0.a0(0x7DD105AF);
                p0.p(false);
                s7 = null;
                v22 = v6;
                v23 = v8;
                a8 = a3;
            }
            else {
                p0.a0(2110850480);
                r0.q q12 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(n0, 1.0f), 60.0f);
                v23 = v8;
                Z.j j0 = Z.a.a(v23, p0, v13 >> 9 & 14, 14);
                com.iloen.melon.popup.e e0 = p0.N();
                if((v13 & 0x380000) == 0x100000 || e0 == v15) {
                    a8 = a3;
                    e0 = new com.iloen.melon.popup.e(2, a8);
                    p0.l0(e0);
                }
                else {
                    a8 = a3;
                }
                s7 = s5;
                v22 = v6;
                H0.e.b(e0, q12, false, null, null, j0, null, m0.c.e(0x50CB587F, p0, new z(s7, v22)), p0, 0x30000030, 380);
                p0.p(false);
            }
            if(s6 == null) {
                p0.a0(0x7DDDB7F6);
                p0.p(false);
                a9 = a8;
                a10 = a5;
            }
            else {
                p0.a0(0x7DDDB7F7);
                M.c.d(p0, androidx.compose.foundation.layout.d.h(n0, 26.0f));
                a9 = a8;
                a10 = a5;
                r0.q q13 = r0.a.a(androidx.compose.foundation.layout.d.v(n0, null, 3), new o() {
                    @Override  // we.o
                    public Object invoke(Object object0, Object object1, Object object2) {
                        return this.invoke(((r0.q)object0), ((l)object1), ((Number)object2).intValue());
                    }

                    public final r0.q invoke(r0.q q0, l l0, int v) {
                        q.g(q0, "$this$composed");
                        ((androidx.compose.runtime.p)l0).a0(0x1FF03545);
                        w0.h h0 = (w0.h)((androidx.compose.runtime.p)l0).k(k0.i);
                        m m0 = ((androidx.compose.runtime.p)l0).N();
                        if(m0 == k.a) {
                            m0 = androidx.appcompat.app.o.d(((androidx.compose.runtime.p)l0));
                        }
                        X0.i i0 = new X0.i(a10);
                        com.iloen.melon.popup.MainBottomPopup.BottomSheetDialogScreen__ZOWojw.lambda.33.lambda.32.lambda.31..inlined.noRippleClickable-YQRRFTQ.default.1.1 mainBottomPopup$BottomSheetDialogScreen__ZOWojw$lambda$33$lambda$32$lambda$31$$inlined$noRippleClickable-YQRRFTQ$default$1$10 = new a() {
                            @Override  // we.a
                            public Object invoke() {
                                this.invoke();
                                return H.a;
                            }

                            public final void invoke() {
                                w0.h.a(this.d);
                                a a0 = this.b;
                                if(a0 != null) {
                                    a0.invoke();
                                }
                            }
                        };
                        r0.q q1 = androidx.compose.foundation.q.l(q0, m0, null, null, 0, i0, mainBottomPopup$BottomSheetDialogScreen__ZOWojw$lambda$33$lambda$32$lambda$31$$inlined$noRippleClickable-YQRRFTQ$default$1$10);
                        ((androidx.compose.runtime.p)l0).p(false);
                        return q1;
                    }
                });
                boolean z = (v13 & 0x70000 ^ 0x30000) > 0x20000 && p0.f(v17) || (v13 & 0x30000) == 0x20000;
                h0 h00 = p0.N();
                if(z || h00 == v15) {
                    h00 = new h0(v17, 16);
                    p0.l0(h00);
                }
                N1.b(s6, androidx.compose.ui.draw.a.a(q13, h00), v17, 13.0f, null, null, 0L, null, 0.0f, 0, false, 1, 0, null, null, p0, v13 >> 9 & 0x380 | 0xC00, 0xC00, 0x1DFF0);
                p0.p(false);
            }
            p0.p(true);
            p0.p(true);
            boolean z1 = p0.i(context0);
            com.iloen.melon.popup.MainBottomPopup.BottomSheetDialogScreen.2.1 mainBottomPopup$BottomSheetDialogScreen$2$10 = p0.N();
            if(z1 || (v13 & 14) == 4 || mainBottomPopup$BottomSheetDialogScreen$2$10 == v15) {
                s8 = s4;
                mainBottomPopup$BottomSheetDialogScreen$2$10 = new we.n(s8, b00, null) {
                    public final b0 B;
                    public final Context r;
                    public final String w;

                    {
                        this.r = context0;
                        this.w = s;
                        this.B = b00;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.popup.MainBottomPopup.BottomSheetDialogScreen.2.1(this.r, this.w, this.B, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.popup.MainBottomPopup.BottomSheetDialogScreen.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        d5.n.D(object0);
                        Glide.with(this.r).asDrawable().load(this.w).into(new CustomTarget() {
                            @Override  // com.bumptech.glide.request.target.Target
                            public void onLoadCleared(Drawable drawable0) {
                            }

                            public void onResourceReady(Drawable drawable0, Transition transition0) {
                                q.g(drawable0, "resource");
                                if(drawable0 instanceof WebpDrawable) {
                                    ((WebpDrawable)drawable0).setLoopCount(0);
                                    ((WebpDrawable)drawable0).start();
                                }
                                MainBottomPopup.access$BottomSheetDialogScreen__ZOWojw$lambda$14(this.a, drawable0);
                            }

                            @Override  // com.bumptech.glide.request.target.Target
                            public void onResourceReady(Object object0, Transition transition0) {
                                this.onResourceReady(((Drawable)object0), transition0);
                            }
                        });
                        return H.a;
                    }
                };
                p0.l0(mainBottomPopup$BottomSheetDialogScreen$2$10);
            }
            else {
                s8 = s4;
            }
            J.d(p0, s8, mainBottomPopup$BottomSheetDialogScreen$2$10);
            s9 = s6;
            s10 = s8;
            s11 = s7;
            v24 = v22;
            a11 = a10;
            v25 = v23;
            a12 = a9;
            v26 = v17;
        }
        else {
            p0.T();
            s10 = s;
            s11 = s1;
            a7 = a1;
            v24 = v6;
            s9 = s3;
            a11 = a2;
            a12 = a0;
            v26 = v10;
            v25 = v8;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new A(this, s10, s11, v24, v25, s9, v26, a12, a7, a11, v3, v4);
        }
    }

    public static final void access$BottomSheetDialogScreen__ZOWojw$lambda$14(b0 b00, Drawable drawable0) {
        b00.setValue(drawable0);
    }

    public static final String access$getHideBannerId$cp() [...] // 潜在的解密器

    @NotNull
    public final List getBanners() {
        List list0 = this.banners;
        if(list0 != null) {
            return list0;
        }
        q.m("banners");
        throw null;
    }

    public final void m(Banner mainBottomSlidePopupRes$Response$Banner0, String s) {
        p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
        g0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        g0.b = this.getString(0x7F130E4B);  // string:tiara_common_section "멜론홈탭"
        g0.c = this.getString(0x7F130E52);  // string:tiara_common_section_music "멜론홈탭_뮤직"
        g0.I = mainBottomSlidePopupRes$Response$Banner0.menuId;
        g0.y = this.getString(0x7F130DEA);  // string:tiara_common_layer1_bottom_popup "하단팝업"
        g0.F = s;
        g0.H = "melon_admin";
        g0.e = mainBottomSlidePopupRes$Response$Banner0.banerseq;
        g0.f = this.getString(0x7F130EF3);  // string:tiara_meta_type_banner "배너"
        g0.g = mainBottomSlidePopupRes$Response$Banner0.title;
        g0.j = "melon_admin";
        g0.K = mainBottomSlidePopupRes$Response$Banner0.targetId;
        StatsElementsBase statsElementsBase0 = mainBottomSlidePopupRes$Response$Banner0.getStatsElements();
        g0.J = statsElementsBase0 == null ? null : statsElementsBase0.rangeCode;
        g0.R = mainBottomSlidePopupRes$Response$Banner0.banerseq;
        g0.a().track();
    }

    @Override  // androidx.fragment.app.w
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        this.setStyle(0, 0x7F14013B);  // style:CommonComposeBottomSheet
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        String s = null;
        if(this.banners == null) {
            this.dismiss();
            return null;
        }
        Banner mainBottomSlidePopupRes$Response$Banner0 = (Banner)p.k0(this.getBanners());
        Context context0 = this.requireContext();
        q.f(context0, "requireContext(...)");
        View view0 = new ComposeView(context0, null, 6, 0);
        ((AbstractComposeView)view0).setViewCompositionStrategy(t0.d);
        ((ComposeView)view0).setContent(new m0.b(0x5E3C5C3, new f(2, this, mainBottomSlidePopupRes$Response$Banner0), true));
        Builder viewImpContent$Builder0 = new Builder().id(mainBottomSlidePopupRes$Response$Banner0.banerseq).name(mainBottomSlidePopupRes$Response$Banner0.title).type(this.getString(0x7F130DE7)).layer1(this.getString(0x7F130DEA)).impType(this.getString(0x7F130EBC)).impProvider("melon_admin");  // string:tiara_common_layer1_banner "배너"
        StatsElementsBase statsElementsBase0 = mainBottomSlidePopupRes$Response$Banner0.getStatsElements();
        if(statsElementsBase0 != null) {
            s = statsElementsBase0.rangeCode;
        }
        if(s == null) {
            s = "";
        }
        ViewImpContent viewImpContent0 = viewImpContent$Builder0.impArea(s).build();
        q.f(viewImpContent0, "build(...)");
        ContentList contentList0 = new ContentList();
        contentList0.addContent(viewImpContent0);
        p8.i i0 = new p8.i();  // 初始化器: Lp8/f;-><init>()V
        i0.b = this.getString(0x7F130E4B);  // string:tiara_common_section "멜론홈탭"
        i0.c = this.getString(0x7F130E52);  // string:tiara_common_section_music "멜론홈탭_뮤직"
        i0.I = mainBottomSlidePopupRes$Response$Banner0.menuId;
        i0.N = "0647dcc15b20c4f83f";
        i0.O = "app_user_id";
        i0.Q = "slot_personal";
        i0.M = "toros_melon_slot_personal_base";
        i0.Z = contentList0;
        i0.a().track();
        return view0;
    }

    @Override  // androidx.fragment.app.w
    public void onStart() {
        super.onStart();
        Dialog dialog0 = this.getDialog();
        BottomSheetBehavior bottomSheetBehavior0 = null;
        BottomSheetDialog bottomSheetDialog0 = dialog0 instanceof BottomSheetDialog ? ((BottomSheetDialog)dialog0) : null;
        if(bottomSheetDialog0 != null) {
            BottomSheetBehavior bottomSheetBehavior1 = bottomSheetDialog0.e();
            if(bottomSheetBehavior1 != null) {
                bottomSheetBehavior1.f0 = true;
                this.setCancelable(false);
                bottomSheetBehavior1.g0 = false;
                bottomSheetBehavior0 = bottomSheetBehavior1;
            }
        }
        if(bottomSheetBehavior0 != null) {
            bottomSheetBehavior0.M(3);
        }
    }

    @Override  // androidx.fragment.app.I
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
    }

    public final void setBanners(@NotNull List list0) {
        q.g(list0, "<set-?>");
        this.banners = list0;
    }

    public final void show(@Nullable List list0, @NotNull l0 l00) {
        q.g(l00, "fragmentManager");
        if(list0 != null && !list0.isEmpty() && MainBottomPopup.Companion.isBannerAvailable(list0)) {
            this.setBanners(list0);
            if(l00.E("MelonMainBottomPopup") == null) {
                androidx.fragment.app.a a0 = new androidx.fragment.app.a(l00);
                a0.e(0, this, "MelonMainBottomPopup", 1);
                a0.l(true, true);
            }
        }
    }
}

