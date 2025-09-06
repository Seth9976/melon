package com.iloen.melon.player.playlist.drawernew.composable;

import Ac.T0;
import Ac.m2;
import Cc.N1;
import Cc.c1;
import Cc.e0;
import Cc.r0;
import De.I;
import H0.e;
import K.m;
import M.b;
import M.c;
import M.j;
import M.n0;
import M.p0;
import M.y;
import N0.M;
import P0.h;
import P0.i;
import Q0.k0;
import U4.x;
import U8.s;
import X0.u;
import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import coil.request.ImageRequest.Builder;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.compose.LottieAnimationKt;
import com.airbnb.lottie.compose.LottieCompositionResult;
import com.airbnb.lottie.compose.LottieCompositionSpec.Asset;
import com.airbnb.lottie.compose.RememberLottieCompositionKt;
import com.iloen.melon.player.playlist.common.g;
import com.iloen.melon.player.playlist.drawernew.model.DrawerPlytWrapper;
import com.iloen.melon.utils.image.ImageUrl;
import ie.H;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r0.d;
import r0.n;
import r0.q;
import t5.f;
import we.a;
import we.o;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001AU\u0010\r\u001A\u00020\n2\b\b\u0002\u0010\u0001\u001A\u00020\u00002\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\u00072\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\n0\tH\u0007\u00A2\u0006\u0004\b\r\u0010\u000E\u001AM\u0010\u000F\u001A\u00020\n2\b\b\u0002\u0010\u0001\u001A\u00020\u00002\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\u00072\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\n0\tH\u0007\u00A2\u0006\u0004\b\u000F\u0010\u0010\u001Am\u0010\u001A\u001A\u00020\n2\b\b\u0002\u0010\u0001\u001A\u00020\u00002\u0006\u0010\u0005\u001A\u00020\u00042\b\b\u0002\u0010\u0011\u001A\u00020\u00042\u0006\u0010\u0013\u001A\u00020\u00122\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\u0014\u001A\u00020\u00072\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00120\u00152\b\u0010\u0017\u001A\u0004\u0018\u00010\u00122\b\b\u0001\u0010\u0018\u001A\u00020\u00072\u0006\u0010\u0019\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\b\u001A\u0010\u001B\u001A3\u0010\u001D\u001A\u00020\n2\u0006\u0010\u001C\u001A\u00020\u00122\b\b\u0002\u0010\u0001\u001A\u00020\u00002\u0006\u0010\u0005\u001A\u00020\u00042\b\b\u0001\u0010\u0018\u001A\u00020\u0007H\u0007\u00A2\u0006\u0004\b\u001D\u0010\u001E\u001AI\u0010 \u001A\u00020\n2\f\u0010\u001F\u001A\b\u0012\u0004\u0012\u00020\u00120\u00152\u0006\u0010\u0013\u001A\u00020\u00122\b\u0010\u0017\u001A\u0004\u0018\u00010\u00122\u0006\u0010\b\u001A\u00020\u00072\b\b\u0002\u0010\u0001\u001A\u00020\u00002\u0006\u0010\u0019\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\b \u0010!\u001A1\u0010\"\u001A\u00020\n2\f\u0010\u001F\u001A\b\u0012\u0004\u0012\u00020\u00120\u00152\b\b\u0002\u0010\u0001\u001A\u00020\u00002\b\b\u0001\u0010\u0018\u001A\u00020\u0007H\u0007\u00A2\u0006\u0004\b\"\u0010#\u001AM\u0010)\u001A\u00020\n*\u00020$2\u0006\u0010%\u001A\u00020\u00042\u0006\u0010&\u001A\u00020\u00042\u0006\u0010\'\u001A\u00020\u00122\u0006\u0010(\u001A\u00020\u00122\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\n0\t\u00A2\u0006\u0004\b)\u0010*\u00A8\u0006.\u00B2\u0006\u000E\u0010,\u001A\u0004\u0018\u00010+8\nX\u008A\u0084\u0002\u00B2\u0006\u000E\u0010,\u001A\u0004\u0018\u00010+8\nX\u008A\u0084\u0002\u00B2\u0006\u000E\u0010-\u001A\u00020\u00048\n@\nX\u008A\u008E\u0002"}, d2 = {"Lr0/q;", "modifier", "Lcom/iloen/melon/player/playlist/drawernew/model/DrawerPlytWrapper;", "item", "", "isBottomSheet", "isConnectNetwork", "", "thumbSize", "Lkotlin/Function0;", "Lie/H;", "onClickPlay", "onClickItem", "DrawerPlytListItemDefault", "(Lr0/q;Lcom/iloen/melon/player/playlist/drawernew/model/DrawerPlytWrapper;ZZILwe/a;Lwe/a;Landroidx/compose/runtime/l;II)V", "DrawerPlytListItemGrid", "(Lr0/q;Lcom/iloen/melon/player/playlist/drawernew/model/DrawerPlytWrapper;ZILwe/a;Lwe/a;Landroidx/compose/runtime/l;II)V", "isSelect", "", "contsId", "thumbType", "", "thumbImgUrlList", "artistName", "noImageId", "isGridItem", "DrawerPlytPlytThumb", "(Lr0/q;ZZLjava/lang/String;IILjava/util/List;Ljava/lang/String;IZLandroidx/compose/runtime/l;II)V", "thumbUImageUrl", "DrawerPlytPlytThumbSingle", "(Ljava/lang/String;Lr0/q;ZILandroidx/compose/runtime/l;II)V", "thumbImageUrlList", "DrawerPlytPlytThumbCover", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ILr0/q;ZLandroidx/compose/runtime/l;II)V", "DrawerPlytPlytThumbQuarter", "(Ljava/util/List;Lr0/q;ILandroidx/compose/runtime/l;II)V", "LX0/x;", "isCurrent", "isPlaying", "title", "subTitle", "setDrawerPlaylistItemSemantics", "(LX0/x;ZZLjava/lang/String;Ljava/lang/String;Lwe/a;Lwe/a;)V", "Lcom/airbnb/lottie/LottieComposition;", "motionJson", "showDefaultImage", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class DrawerPlytListItemKt {
    public static final void DrawerPlytListItemDefault(@Nullable q q0, @NotNull DrawerPlytWrapper drawerPlytWrapper0, boolean z, boolean z1, int v, @NotNull a a0, @NotNull a a1, @Nullable l l0, int v1, int v2) {
        q q10;
        i i2;
        h h8;
        h h7;
        h h6;
        h h5;
        i i1;
        int v5;
        int v3;
        kotlin.jvm.internal.q.g(drawerPlytWrapper0, "item");
        kotlin.jvm.internal.q.g(a0, "onClickPlay");
        kotlin.jvm.internal.q.g(a1, "onClickItem");
        p p0 = (p)l0;
        p0.c0(0xCAD7F226);
        if((v2 & 1) == 0) {
            v3 = (v1 & 6) == 0 ? (p0.g(q0) ? 4 : 2) | v1 : v1;
        }
        else {
            v3 = v1 | 6;
        }
        if((v1 & 0x30) == 0) {
            v3 |= (p0.i(drawerPlytWrapper0) ? 0x20 : 16);
        }
        if((v1 & 0x180) == 0) {
            v3 |= (p0.h(z) ? 0x100 : 0x80);
        }
        if((v1 & 0xC00) == 0) {
            v3 |= (p0.h(z1) ? 0x800 : 0x400);
        }
        if((v1 & 0x6000) == 0) {
            v3 |= (p0.e(v) ? 0x4000 : 0x2000);
        }
        if((0x30000 & v1) == 0) {
            v3 |= (p0.i(a0) ? 0x20000 : 0x10000);
        }
        if((0x180000 & v1) == 0) {
            v3 |= (p0.i(a1) ? 0x100000 : 0x80000);
        }
        if(p0.Q(v3 & 1, (0x92493 & v3) != 0x92492)) {
            n n0 = n.a;
            q q1 = (v2 & 1) == 0 ? q0 : n0;
            int v4 = 0x7F0604A1;  // color:white000e
            if(!z) {
                v5 = drawerPlytWrapper0.isSelect() ? 0x7F060179 : 0x7F0604A1;  // color:green490e
            }
            else if(drawerPlytWrapper0.isSelect()) {
                v5 = 0x7F06017C;  // color:green500s_support_high_contrast
            }
            else {
                v5 = 0x7F06016D;  // color:gray900s
            }
            if(z) {
                v4 = 0x7F06016D;  // color:gray900s
            }
            boolean z2 = z1 || drawerPlytWrapper0.isOfflineMode();
            r0.h h0 = d.k;
            q q2 = androidx.compose.foundation.layout.a.m(r0.a.a(e0.Q(q1, z2), new o() {
                @Override  // we.o
                public Object invoke(Object object0, Object object1, Object object2) {
                    return this.invoke(((q)object0), ((l)object1), ((Number)object2).intValue());
                }

                public final q invoke(q q0, l l0, int v) {
                    kotlin.jvm.internal.q.g(q0, "$this$composed");
                    ((p)l0).a0(0x1FF03545);
                    w0.h h0 = (w0.h)((p)l0).k(k0.i);
                    m m0 = ((p)l0).N();
                    if(m0 == k.a) {
                        m0 = androidx.appcompat.app.o.d(((p)l0));
                    }
                    X0.i i0 = new X0.i(0);
                    com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListItemKt.DrawerPlytListItemDefault..inlined.noRippleClickable-YQRRFTQ.default.1.1 drawerPlytListItemKt$DrawerPlytListItemDefault$$inlined$noRippleClickable-YQRRFTQ$default$1$10 = new a() {
                        @Override  // we.a
                        public Object invoke() {
                            this.invoke();
                            return H.a;
                        }

                        public final void invoke() {
                            w0.h.a(this.d);
                            if(this.e) {
                                this.c.invoke();
                            }
                        }
                    };
                    q q1 = androidx.compose.foundation.q.l(q0, m0, null, true, null, i0, drawerPlytListItemKt$DrawerPlytListItemDefault$$inlined$noRippleClickable-YQRRFTQ$default$1$10);
                    ((p)l0).p(false);
                    return q1;
                }
            }), 20.0f, 8.0f, 14.0f, 8.0f);
            b b0 = j.a;
            p0 p00 = n0.a(b0, h0, p0, 0x30);
            int v6 = p0.P;
            i0 i00 = p0.m();
            q q3 = r0.a.d(p0, q2);
            P0.k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            h h1 = P0.j.f;
            w.x(p0, p00, h1);
            h h2 = P0.j.e;
            w.x(p0, i00, h2);
            h h3 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v6)) {
                A7.d.q(v6, p0, v6, h3);
            }
            w.x(p0, q3, P0.j.d);
            q q4 = androidx.compose.foundation.layout.d.n(n0, 58.0f);
            h h4 = P0.j.d;
            DrawerPlytListItemKt.DrawerPlytPlytThumb(q4, z, false, drawerPlytWrapper0.getDrawerPlaylistInfo().getContsId(), v, drawerPlytWrapper0.getThumbType(), drawerPlytWrapper0.getThumbImageList(), drawerPlytWrapper0.getDrawerPlaylistInfo().getTitleReplace(), (z ? 0x7F08078B : 0x7F08078C), false, p0, v3 >> 3 & 0x70 | 0x30000186 | v3 & 0xE000, 0);  // drawable:noimage_logo_mini
            c.d(p0, androidx.compose.foundation.layout.d.q(n0, 14.0f));
            LayoutWeightElement layoutWeightElement0 = new LayoutWeightElement(1.0f, true);
            y y0 = M.w.a(j.c, d.m, p0, 0);
            int v7 = p0.P;
            i0 i01 = p0.m();
            q q5 = r0.a.d(p0, layoutWeightElement0);
            p0.e0();
            if(p0.O) {
                i1 = i0;
                p0.l(i1);
            }
            else {
                i1 = i0;
                p0.o0();
            }
            w.x(p0, y0, h1);
            w.x(p0, i01, h2);
            if(!p0.O && kotlin.jvm.internal.q.b(p0.N(), v7)) {
                h5 = h3;
            }
            else {
                h5 = h3;
                A7.d.q(v7, p0, v7, h5);
            }
            w.x(p0, q5, h4);
            p0 p01 = n0.a(b0, h0, p0, 0x30);
            int v8 = p0.P;
            i0 i02 = p0.m();
            q q6 = r0.a.d(p0, n0);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, p01, h1);
            w.x(p0, i02, h2);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v8)) {
                A7.d.q(v8, p0, v8, h5);
            }
            w.x(p0, q6, h4);
            if(drawerPlytWrapper0.isOpen()) {
                h6 = h4;
                h7 = h5;
                i2 = i1;
                h8 = h1;
                p0.a0(0x1F1BCCBE);
                p0.p(false);
            }
            else {
                p0.a0(0x1F693141);
                h6 = h4;
                h7 = h5;
                h8 = h1;
                i2 = i1;
                c1.n(androidx.compose.foundation.layout.d.o(n0, 14.0f, 16.0f), ((int)(z ? 0x7F0805BC : 0x7F0805BD)), null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 6, 0, 0x7FFC);  // drawable:ic_private_16
                x.z(n0, 4.0f, p0, false);
            }
            N1.b(drawerPlytWrapper0.getTitleForList(), null, e0.T(p0, v5), 15.0f, null, null, 0L, null, 18.0f, 0, false, 2, 0, null, null, p0, 0xC00, 0xC06, 0x1DBF2);
            p0.p(true);
            if(drawerPlytWrapper0.getDesc().length() > 0) {
                p0.a0(0x64631ED4);
                c.d(p0, androidx.compose.foundation.layout.d.h(n0, 3.0f));
                N1.b(drawerPlytWrapper0.getDesc(), null, e0.T(p0, (z ? 0x7F060163 : 0x7F0604B7)), 0.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0, 0, 0x1FFFA);  // color:gray700s
            }
            else {
                p0.a0(0x6409D662);
            }
            p0.p(false);
            p0.p(true);
            c.d(p0, androidx.compose.foundation.layout.d.q(n0, 16.0f));
            if(drawerPlytWrapper0.isSelect()) {
                p0.a0(0x5F5B3CC1);
                LottieCompositionResult lottieCompositionResult0 = RememberLottieCompositionKt.rememberLottieComposition(Asset.box-impl("animation/Motion_Graphic_Equalizer.json"), null, null, null, null, null, p0, 6, 62);
                M m0 = M.p.d(d.e, false);
                int v9 = p0.P;
                i0 i03 = p0.m();
                q q7 = r0.a.d(p0, n0);
                p0.e0();
                if(p0.O) {
                    p0.l(i2);
                }
                else {
                    p0.o0();
                }
                w.x(p0, m0, h8);
                w.x(p0, i03, h2);
                if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v9)) {
                    A7.d.q(v9, p0, v9, h7);
                }
                w.x(p0, q7, h6);
                q q8 = androidx.compose.foundation.layout.d.n(n0, 28.0f);
                LottieAnimationKt.LottieAnimation(((LottieComposition)lottieCompositionResult0.getValue()), q8, drawerPlytWrapper0.isPlaying(), false, null, 0.0f, 0x7FFFFFFF, false, false, false, false, null, false, false, null, null, null, false, false, null, false, null, p0, 0x180030, 0, 0, 0x3FFFB8);
                p0.p(true);
            }
            else {
                p0.a0(1600378491);
                q q9 = r0.a.a(androidx.compose.foundation.layout.d.n(n0, 28.0f), new o() {
                    @Override  // we.o
                    public Object invoke(Object object0, Object object1, Object object2) {
                        return this.invoke(((q)object0), ((l)object1), ((Number)object2).intValue());
                    }

                    public final q invoke(q q0, l l0, int v) {
                        kotlin.jvm.internal.q.g(q0, "$this$composed");
                        ((p)l0).a0(0x1FF03545);
                        w0.h h0 = (w0.h)((p)l0).k(k0.i);
                        m m0 = ((p)l0).N();
                        if(m0 == k.a) {
                            m0 = androidx.appcompat.app.o.d(((p)l0));
                        }
                        X0.i i0 = new X0.i(0);
                        com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListItemKt.DrawerPlytListItemDefault.lambda.6..inlined.noRippleClickable-YQRRFTQ.default.1.1 drawerPlytListItemKt$DrawerPlytListItemDefault$lambda$6$$inlined$noRippleClickable-YQRRFTQ$default$1$10 = new a() {
                            @Override  // we.a
                            public Object invoke() {
                                this.invoke();
                                return H.a;
                            }

                            public final void invoke() {
                                w0.h.a(this.d);
                                if(this.e) {
                                    this.c.invoke();
                                }
                            }
                        };
                        q q1 = androidx.compose.foundation.q.l(q0, m0, null, true, null, i0, drawerPlytListItemKt$DrawerPlytListItemDefault$lambda$6$$inlined$noRippleClickable-YQRRFTQ$default$1$10);
                        ((p)l0).p(false);
                        return q1;
                    }
                });
                y0.k k0 = new y0.k(e0.T(p0, v4), 5);
                c1.n(q9, 0x7F08015F, e.Y(p0, 0x7F130BB4), null, false, 0, null, null, null, 0.0f, k0, 0, 0, false, false, p0, 0x30, 0, 0x7BF8);  // drawable:btn_common_play_02
            }
            p0.p(false);
            p0.p(true);
            q10 = q1;
        }
        else {
            p0.T();
            q10 = q0;
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.player.playlist.drawernew.composable.c(q10, drawerPlytWrapper0, z, z1, v, a0, a1, v1, v2);
        }
    }

    public static final void DrawerPlytListItemGrid(@Nullable q q0, @NotNull DrawerPlytWrapper drawerPlytWrapper0, boolean z, int v, @NotNull a a0, @NotNull a a1, @Nullable l l0, int v1, int v2) {
        q q9;
        n n1;
        h h6;
        h h5;
        h h4;
        q q1;
        int v3;
        r0.i i0 = d.c;
        kotlin.jvm.internal.q.g(drawerPlytWrapper0, "item");
        kotlin.jvm.internal.q.g(a0, "onClickPlay");
        kotlin.jvm.internal.q.g(a1, "onClickItem");
        p p0 = (p)l0;
        p0.c0(0xD7A0E2B5);
        if((v2 & 1) != 0) {
            v3 = v1 | 6;
            q1 = q0;
        }
        else if((v1 & 6) == 0) {
            q1 = q0;
            v3 = (p0.g(q1) ? 4 : 2) | v1;
        }
        else {
            q1 = q0;
            v3 = v1;
        }
        if((v1 & 0x30) == 0) {
            v3 |= (p0.i(drawerPlytWrapper0) ? 0x20 : 16);
        }
        if((v1 & 0x180) == 0) {
            v3 |= (p0.h(z) ? 0x100 : 0x80);
        }
        if((v1 & 0xC00) == 0) {
            v3 |= (p0.e(v) ? 0x800 : 0x400);
        }
        if((v1 & 0x6000) == 0) {
            v3 |= (p0.i(a0) ? 0x4000 : 0x2000);
        }
        if((0x30000 & v1) == 0) {
            v3 |= (p0.i(a1) ? 0x20000 : 0x10000);
        }
        boolean z1 = false;
        if(p0.Q(v3 & 1, (74899 & v3) != 74898)) {
            n n0 = n.a;
            if((v2 & 1) != 0) {
                q1 = n0;
            }
            int v4 = drawerPlytWrapper0.isSelect() ? 0x7F060179 : 0x7F0604A1;  // color:green490e
            if(z || drawerPlytWrapper0.isOfflineMode()) {
                z1 = true;
            }
            q q2 = r0.a.a(e0.Q(q1, z1), new o() {
                @Override  // we.o
                public Object invoke(Object object0, Object object1, Object object2) {
                    return this.invoke(((q)object0), ((l)object1), ((Number)object2).intValue());
                }

                public final q invoke(q q0, l l0, int v) {
                    kotlin.jvm.internal.q.g(q0, "$this$composed");
                    ((p)l0).a0(0x1FF03545);
                    w0.h h0 = (w0.h)((p)l0).k(k0.i);
                    m m0 = ((p)l0).N();
                    if(m0 == k.a) {
                        m0 = androidx.appcompat.app.o.d(((p)l0));
                    }
                    X0.i i0 = new X0.i(0);
                    com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListItemKt.DrawerPlytListItemGrid..inlined.noRippleClickable-YQRRFTQ.default.1.1 drawerPlytListItemKt$DrawerPlytListItemGrid$$inlined$noRippleClickable-YQRRFTQ$default$1$10 = new a() {
                        @Override  // we.a
                        public Object invoke() {
                            this.invoke();
                            return H.a;
                        }

                        public final void invoke() {
                            w0.h.a(this.d);
                            if(this.e) {
                                this.c.invoke();
                            }
                        }
                    };
                    q q1 = androidx.compose.foundation.q.l(q0, m0, null, true, null, i0, drawerPlytListItemKt$DrawerPlytListItemGrid$$inlined$noRippleClickable-YQRRFTQ$default$1$10);
                    ((p)l0).p(false);
                    return q1;
                }
            });
            y y0 = M.w.a(j.c, d.m, p0, 0);
            int v5 = p0.P;
            i0 i00 = p0.m();
            q q3 = r0.a.d(p0, q2);
            P0.k.y.getClass();
            i i1 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            h h0 = P0.j.f;
            w.x(p0, y0, h0);
            h h1 = P0.j.e;
            w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h2);
            }
            h h3 = P0.j.d;
            w.x(p0, q3, h3);
            M m0 = M.p.d(d.a, false);
            int v6 = p0.P;
            i0 i01 = p0.m();
            q q4 = r0.a.d(p0, n0);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, m0, h0);
            w.x(p0, i01, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v6)) {
                A7.d.q(v6, p0, v6, h2);
            }
            w.x(p0, q4, h3);
            DrawerPlytListItemKt.DrawerPlytPlytThumb(androidx.compose.foundation.layout.a.d(1.0f, androidx.compose.foundation.layout.d.f(n0, 1.0f), false), false, drawerPlytWrapper0.isSelect(), drawerPlytWrapper0.getDrawerPlaylistInfo().getContsId(), v, drawerPlytWrapper0.getThumbType(), drawerPlytWrapper0.getThumbImageList(), drawerPlytWrapper0.getDrawerPlaylistInfo().getTitleReplace(), 0x7F08078A, true, p0, v3 << 3 & 0xE000 | 0x36000036, 0);  // drawable:noimage_logo_medium_w
            androidx.compose.foundation.layout.b b0 = (androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false));
            if(drawerPlytWrapper0.isSelect()) {
                p0.a0(0x4C3E268C);
                LottieCompositionResult lottieCompositionResult0 = RememberLottieCompositionKt.rememberLottieComposition(Asset.box-impl("animation/Motion_Graphic_Equalizer.json"), null, null, null, null, null, p0, 6, 62);
                q q5 = b0.a(androidx.compose.foundation.layout.a.n(n0, 0.0f, 4.0f, 4.0f, 0.0f, 9), i0);
                M m1 = M.p.d(d.e, false);
                int v7 = p0.P;
                i0 i02 = p0.m();
                q q6 = r0.a.d(p0, q5);
                p0.e0();
                if(p0.O) {
                    p0.l(i1);
                }
                else {
                    p0.o0();
                }
                w.x(p0, m1, h0);
                w.x(p0, i02, h1);
                if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v7)) {
                    A7.d.q(v7, p0, v7, h2);
                }
                w.x(p0, q6, h3);
                q q7 = androidx.compose.foundation.layout.d.n(n0, 28.0f);
                LottieAnimationKt.LottieAnimation(((LottieComposition)lottieCompositionResult0.getValue()), q7, drawerPlytWrapper0.isPlaying(), false, null, 0.0f, 0x7FFFFFFF, false, false, false, false, null, false, false, null, null, null, false, false, null, false, null, p0, 0x180030, 0, 0, 0x3FFFB8);
                p0.p(true);
                p0.p(false);
                h4 = h3;
                h5 = h1;
                h6 = h2;
                n1 = n0;
            }
            else {
                p0.a0(0x4C492A56);
                h6 = h2;
                h5 = h1;
                h4 = h3;
                n1 = n0;
                c1.n(r0.a.a(androidx.compose.foundation.layout.a.g(b0.a(androidx.compose.foundation.layout.d.n(n0, 24.0f), i0), -6.0f, 6.0f), new o() {
                    @Override  // we.o
                    public Object invoke(Object object0, Object object1, Object object2) {
                        return this.invoke(((q)object0), ((l)object1), ((Number)object2).intValue());
                    }

                    public final q invoke(q q0, l l0, int v) {
                        kotlin.jvm.internal.q.g(q0, "$this$composed");
                        ((p)l0).a0(0x1FF03545);
                        w0.h h0 = (w0.h)((p)l0).k(k0.i);
                        m m0 = ((p)l0).N();
                        if(m0 == k.a) {
                            m0 = androidx.appcompat.app.o.d(((p)l0));
                        }
                        X0.i i0 = new X0.i(0);
                        com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListItemKt.DrawerPlytListItemGrid.lambda.14.lambda.12..inlined.noRippleClickable-YQRRFTQ.default.1.1 drawerPlytListItemKt$DrawerPlytListItemGrid$lambda$14$lambda$12$$inlined$noRippleClickable-YQRRFTQ$default$1$10 = new a() {
                            @Override  // we.a
                            public Object invoke() {
                                this.invoke();
                                return H.a;
                            }

                            public final void invoke() {
                                w0.h.a(this.d);
                                if(this.e) {
                                    this.c.invoke();
                                }
                            }
                        };
                        q q1 = androidx.compose.foundation.q.l(q0, m0, null, true, null, i0, drawerPlytListItemKt$DrawerPlytListItemGrid$lambda$14$lambda$12$$inlined$noRippleClickable-YQRRFTQ$default$1$10);
                        ((p)l0).p(false);
                        return q1;
                    }
                }), 0x7F08015E, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x30, 0, 0x7FFC);  // drawable:btn_common_play_01
                p0.p(false);
            }
            p0.p(true);
            c.d(p0, androidx.compose.foundation.layout.d.h(n1, 8.0f));
            p0 p00 = n0.a(j.a, d.k, p0, 0x30);
            int v8 = p0.P;
            i0 i03 = p0.m();
            q q8 = r0.a.d(p0, n1);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, h0);
            w.x(p0, i03, h5);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v8)) {
                A7.d.q(v8, p0, v8, h6);
            }
            w.x(p0, q8, h4);
            if(drawerPlytWrapper0.isOpen()) {
                p0.a0(0xCBFEA9A7);
                p0.p(false);
            }
            else {
                p0.a0(0xCC908774);
                c1.n(androidx.compose.foundation.layout.d.o(n1, 14.0f, 16.0f), 0x7F0805BD, null, null, false, 0, null, null, null, 0.0f, new y0.k(e0.T(p0, 0x7F0604A1), 5), 0, 0, false, false, p0, 54, 0, 0x7BFC);  // drawable:ic_private_16_w
                x.z(n1, 4.0f, p0, false);
            }
            N1.b(drawerPlytWrapper0.getTitleForGrid(), null, e0.T(p0, v4), 15.0f, null, null, 0L, null, 18.0f, 2, false, 2, 0, null, null, p0, 0xC00, 0xC36, 0x1D3F2);
            p0.p(true);
            if(drawerPlytWrapper0.getDesc().length() > 0) {
                p0.a0(0x2584B78C);
                c.d(p0, androidx.compose.foundation.layout.d.h(n1, 5.0f));
                N1.b(drawerPlytWrapper0.getDesc(), null, e0.T(p0, 0x7F0604B7), 13.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F2);  // color:white700e
            }
            else {
                p0.a0(0x24E8B8E3);
            }
            p0.p(false);
            p0.p(true);
        }
        else {
            p0.T();
        }
        q9 = q1;
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new T0(q9, drawerPlytWrapper0, z, v, a0, a1, v1, v2);
        }
    }

    public static final void DrawerPlytPlytThumb(@Nullable q q0, boolean z, boolean z1, @NotNull String s, int v, int v1, @NotNull List list0, @Nullable String s1, int v2, boolean z2, @Nullable l l0, int v3, int v4) {
        boolean z4;
        q q4;
        q q3;
        int v5;
        kotlin.jvm.internal.q.g(s, "contsId");
        kotlin.jvm.internal.q.g(list0, "thumbImgUrlList");
        p p0 = (p)l0;
        p0.c0(-1408073770);
        if((v4 & 1) == 0) {
            v5 = (v3 & 6) == 0 ? (p0.g(q0) ? 4 : 2) | v3 : v3;
        }
        else {
            v5 = v3 | 6;
        }
        if((v3 & 0x30) == 0) {
            v5 |= (p0.h(z) ? 0x20 : 16);
        }
        if((v4 & 4) != 0) {
            v5 |= 0x180;
        }
        else if((v3 & 0x180) == 0) {
            v5 |= (p0.h(z1) ? 0x100 : 0x80);
        }
        if((v3 & 0xC00) == 0) {
            v5 |= (p0.g(s) ? 0x800 : 0x400);
        }
        if((v3 & 0x6000) == 0) {
            v5 |= (p0.e(v) ? 0x4000 : 0x2000);
        }
        if((0x30000 & v3) == 0) {
            v5 |= (p0.e(v1) ? 0x20000 : 0x10000);
        }
        if((0x180000 & v3) == 0) {
            v5 |= (p0.i(list0) ? 0x100000 : 0x80000);
        }
        if((0xC00000 & v3) == 0) {
            v5 |= (p0.g(s1) ? 0x800000 : 0x400000);
        }
        if((0x6000000 & v3) == 0) {
            v5 |= (p0.e(v2) ? 0x4000000 : 0x2000000);
        }
        if((v3 & 0x30000000) == 0) {
            v5 |= (p0.h(z2) ? 0x20000000 : 0x10000000);
        }
        if(p0.Q(v5 & 1, (v5 & 306783379) != 306783378)) {
            q q1 = (v4 & 1) == 0 ? q0 : n.a;
            boolean z3 = (v4 & 4) == 0 ? z1 : false;
            M m0 = M.p.d(d.a, false);
            int v6 = p0.P;
            i0 i00 = p0.m();
            q q2 = r0.a.d(p0, q1);
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
            h h0 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v6)) {
                A7.d.q(v6, p0, v6, h0);
            }
            w.x(p0, q2, P0.j.d);
            switch(v1) {
                case 0: {
                    p0.a0(0x2F6F148C);
                    q3 = q1;
                    DrawerPlytListItemKt.DrawerPlytPlytThumbCover(list0, s, s1, v, q1.then(androidx.compose.foundation.layout.d.c), z2, p0, v5 >> 18 & 14 | v5 >> 6 & 0x70 | v5 >> 15 & 0x380 | v5 >> 3 & 0x1C00 | v5 >> 12 & 0x70000, 0);
                    p0.p(false);
                    break;
                }
                case 1: {
                    p0.a0(0x2F751D57);
                    DrawerPlytListItemKt.DrawerPlytPlytThumbQuarter(list0, q1.then(androidx.compose.foundation.layout.d.c), v2, p0, v5 >> 18 & 910, 0);
                    p0.p(false);
                    q3 = q1;
                    break;
                }
                case 2: {
                    p0.a0(0x2F792208);
                    String s2 = list0.size() > 0 ? list0.get(0) : "";
                    DrawerPlytListItemKt.DrawerPlytPlytThumbSingle(s2, q1.then(androidx.compose.foundation.layout.d.c), z, v2, p0, v5 << 3 & 0x380 | v5 >> 15 & 0x1C00, 0);
                    p0.p(false);
                    q3 = q1;
                    break;
                }
                default: {
                    p0.a0(784836210);
                    p0.p(false);
                    q3 = q1;
                }
            }
            if(z3) {
                p0.a0(0x2F7E282B);
                long v7 = e0.T(p0, 0x7F06015B);  // color:gray500e
                T.d d0 = T.e.b(4.0f);
                M.p.a(androidx.compose.foundation.q.f(androidx.compose.foundation.layout.d.c, v7, d0), p0, 0);
            }
            else {
                p0.a0(784836210);
            }
            p0.p(false);
            p0.p(true);
            q4 = q3;
            z4 = z3;
        }
        else {
            p0.T();
            q4 = q0;
            z4 = z1;
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.player.playlist.drawernew.composable.b(q4, z, z4, s, v, v1, list0, s1, v2, z2, v3, v4);
        }
    }

    public static final void DrawerPlytPlytThumbCover(@NotNull List list0, @NotNull String s, @Nullable String s1, int v, @Nullable q q0, boolean z, @Nullable l l0, int v1, int v2) {
        q q2;
        q q1;
        kotlin.jvm.internal.q.g(list0, "thumbImageUrlList");
        kotlin.jvm.internal.q.g(s, "contsId");
        ((p)l0).c0(0x1A9D52B9);
        int v3 = (v1 & 6) == 0 ? (((p)l0).i(list0) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v3 |= (((p)l0).g(s) ? 0x20 : 16);
        }
        if((v1 & 0x180) == 0) {
            v3 |= (((p)l0).g(s1) ? 0x100 : 0x80);
        }
        if((v1 & 0xC00) == 0) {
            v3 |= (((p)l0).e(v) ? 0x800 : 0x400);
        }
        if((v2 & 16) != 0) {
            v3 |= 0x6000;
            q1 = q0;
        }
        else if((v1 & 0x6000) == 0) {
            q1 = q0;
            v3 |= (((p)l0).g(q1) ? 0x4000 : 0x2000);
        }
        else {
            q1 = q0;
        }
        if((0x30000 & v1) == 0) {
            v3 |= (((p)l0).h(z) ? 0x20000 : 0x10000);
        }
        int v4 = 0;
        if(((p)l0).Q(v3 & 1, (74899 & v3) != 74898)) {
            if((v2 & 16) != 0) {
                q1 = n.a;
            }
            s s2 = ((p)l0).N();
            V v5 = k.a;
            if((((0x70000 & v3) == 0x20000 ? 1 : 0) | ((v3 & 0x1C00) == 0x800 ? 1 : 0)) != 0 || s2 == v5) {
                s2 = new s(z, v, 1);
                ((p)l0).l0(s2);
            }
            boolean z1 = ((p)l0).i(list0);
            if((v3 & 0x380) == 0x100) {
                v4 = 1;
            }
            m2 m20 = ((p)l0).N();
            if(((v3 & 0x70) == 0x20 | z1 | v4) != 0 || m20 == v5) {
                m20 = new m2(s, list0, s1, 29);
                ((p)l0).l0(m20);
            }
            androidx.compose.ui.viewinterop.a.a(s2, q1, m20, ((p)l0), v3 >> 9 & 0x70, 0);
        }
        else {
            ((p)l0).T();
        }
        q2 = q1;
        androidx.compose.runtime.n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new T0(list0, s, s1, v, q2, z, v1, v2);
        }
    }

    public static final void DrawerPlytPlytThumbQuarter(@NotNull List list0, @Nullable q q0, int v, @Nullable l l0, int v1, int v2) {
        q q7;
        q q6;
        i5.n n2;
        p0.p p3;
        Context context1;
        V v6;
        kotlin.jvm.internal.q.g(list0, "thumbImageUrlList");
        p p0 = (p)l0;
        p0.c0(0xDCAC6D3A);
        int v3 = (v1 & 6) == 0 ? (p0.i(list0) ? 4 : 2) | v1 : v1;
        if((v2 & 2) != 0) {
            v3 |= 0x30;
        }
        else if((v1 & 0x30) == 0) {
            v3 |= (p0.g(q0) ? 0x20 : 16);
        }
        if((v1 & 0x180) == 0) {
            v3 |= (p0.e(v) ? 0x100 : 0x80);
        }
        if(p0.Q(v3 & 1, (v3 & 0x93) != 0x92)) {
            n n0 = n.a;
            q q1 = (v2 & 2) == 0 ? q0 : n0;
            b0 b00 = p0.N();
            V v4 = k.a;
            if(b00 == v4) {
                b00 = w.s(Boolean.TRUE);
                p0.l0(b00);
            }
            p0.p p1 = p0.N();
            if(p1 == v4) {
                p0.p p2 = new p0.p();
                p2.addAll(je.n.z0(new Drawable[]{0, 0, 0, 0}));
                p0.l0(p2);
                p1 = p2;
            }
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            i5.n n1 = c1.V(context0);
            q q2 = androidx.compose.foundation.q.f(d5.n.o(q1, T.e.b(4.0f)), e0.T(p0, 0x7F060144), y0.M.a);  // color:gray050e
            M m0 = M.p.d(d.e, false);
            int v5 = p0.P;
            i0 i00 = p0.m();
            q q3 = r0.a.d(p0, q2);
            P0.k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            h h0 = P0.j.f;
            w.x(p0, m0, h0);
            h h1 = P0.j.e;
            w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h2);
            }
            h h3 = P0.j.d;
            w.x(p0, q3, h3);
            if(((Boolean)b00.getValue()).booleanValue()) {
                p0.a0(2026987190);
                v6 = v4;
                context1 = context0;
                p3 = p1;
                n2 = n1;
                androidx.compose.foundation.q.c(I.Q(v, p0, v3 >> 6 & 14), null, null, null, null, 0.0f, null, p0, 0x30, 0x7C);
                p0.p(false);
            }
            else {
                p3 = p1;
                context1 = context0;
                n2 = n1;
                p0.a0(2027146158);
                y y0 = M.w.a(j.c, d.m, p0, 0);
                int v7 = p0.P;
                i0 i01 = p0.m();
                q q4 = r0.a.d(p0, n0);
                p0.e0();
                if(p0.O) {
                    p0.l(i0);
                }
                else {
                    p0.o0();
                }
                w.x(p0, y0, h0);
                w.x(p0, i01, h1);
                if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v7)) {
                    A7.d.q(v7, p0, v7, h2);
                }
                w.x(p0, q4, h3);
                p0.a0(-360871761);
                for(int v8 = 0; v8 < 2; ++v8) {
                    LayoutWeightElement layoutWeightElement0 = new LayoutWeightElement(1.0f, true);
                    p0 p00 = n0.a(j.a, d.j, p0, 0);
                    int v9 = p0.P;
                    i0 i02 = p0.m();
                    q q5 = r0.a.d(p0, layoutWeightElement0);
                    P0.k.y.getClass();
                    i i1 = P0.j.b;
                    p0.e0();
                    if(p0.O) {
                        p0.l(i1);
                    }
                    else {
                        p0.o0();
                    }
                    w.x(p0, p00, P0.j.f);
                    w.x(p0, i02, P0.j.e);
                    h h4 = P0.j.g;
                    if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v9)) {
                        A7.d.q(v9, p0, v9, h4);
                    }
                    w.x(p0, q5, P0.j.d);
                    p0.a0(0x5E1509B7);
                    for(int v10 = 0; v10 < 2; ++v10) {
                        Drawable drawable0 = (Drawable)je.p.n0(v8 * 2 + v10, p3);
                        if(drawable0 == null) {
                            drawable0 = "";
                        }
                        c1.n(new LayoutWeightElement(1.0f, true), drawable0, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x6000, 0, 0x7FEC);
                    }
                    p0.p(false);
                    p0.p(true);
                }
                v6 = v4;
                A7.d.s(p0, false, true, false);
            }
            p0.p(true);
            com.iloen.melon.player.playlist.common.h h5 = p0.N();
            if(h5 == v6) {
                h5 = new com.iloen.melon.player.playlist.common.h(9);
                p0.l0(h5);
            }
            String s = je.p.q0(list0, null, null, null, h5, 0x1F);
            boolean z = p0.i(list0);
            boolean z1 = p0.i(context1);
            boolean z2 = p0.i(n2);
            com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListItemKt.DrawerPlytPlytThumbQuarter.3.1 drawerPlytListItemKt$DrawerPlytPlytThumbQuarter$3$10 = p0.N();
            if((z | z1 | z2) != 0 || drawerPlytListItemKt$DrawerPlytPlytThumbQuarter$3$10 == v6) {
                q6 = q1;
                com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListItemKt.DrawerPlytPlytThumbQuarter.3.1 drawerPlytListItemKt$DrawerPlytPlytThumbQuarter$3$11 = new we.n(list0, context1, n2, p3, b00, null) {
                    public final i5.n B;
                    public final p0.p D;
                    public final b0 E;
                    public final List r;
                    public final Context w;

                    {
                        this.r = list0;
                        this.w = context0;
                        this.B = n0;
                        this.D = p0;
                        this.E = b00;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListItemKt.DrawerPlytPlytThumbQuarter.3.1(this.r, this.w, this.B, this.D, this.E, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListItemKt.DrawerPlytPlytThumbQuarter.3.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        d5.n.D(object0);
                        int v = 0;
                        for(Object object1: this.r) {
                            if(v >= 0) {
                                ImageRequest.Builder imageRequest$Builder0 = new ImageRequest.Builder(this.w);
                                imageRequest$Builder0.c = (String)object1;
                                imageRequest$Builder0.e = new t5.i() {
                                    @Override  // t5.i
                                    public void onCancel(t5.j j0) {
                                    }

                                    @Override  // t5.i
                                    public void onError(t5.j j0, f f0) {
                                    }

                                    @Override  // t5.i
                                    public void onStart(t5.j j0) {
                                    }

                                    @Override  // t5.i
                                    public void onSuccess(t5.j j0, t5.s s0) {
                                        v.set(this.E, s0.a);
                                        DrawerPlytListItemKt.access$DrawerPlytPlytThumbQuarter$lambda$30(this.c, false);
                                    }
                                };
                                t5.j j0 = imageRequest$Builder0.a();
                                this.B.b(j0);
                                ++v;
                                continue;
                            }
                            e.k.O();
                            throw null;
                        }
                        return H.a;
                    }
                };
                p0.l0(drawerPlytListItemKt$DrawerPlytPlytThumbQuarter$3$11);
                drawerPlytListItemKt$DrawerPlytPlytThumbQuarter$3$10 = drawerPlytListItemKt$DrawerPlytPlytThumbQuarter$3$11;
            }
            else {
                q6 = q1;
            }
            J.d(p0, s, drawerPlytListItemKt$DrawerPlytPlytThumbQuarter$3$10);
            q7 = q6;
        }
        else {
            p0.T();
            q7 = q0;
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.player.playlist.common.i(list0, q7, v, v1, v2, 1);
        }
    }

    public static final void DrawerPlytPlytThumbSingle(@NotNull String s, @Nullable q q0, boolean z, int v, @Nullable l l0, int v1, int v2) {
        q q1;
        kotlin.jvm.internal.q.g(s, "thumbUImageUrl");
        p p0 = (p)l0;
        p0.c0(0x43702943);
        int v3 = (v1 & 6) == 0 ? (p0.g(s) ? 4 : 2) | v1 : v1;
        if((v2 & 2) != 0) {
            v3 |= 0x30;
            q1 = q0;
        }
        else if((v1 & 0x30) == 0) {
            q1 = q0;
            v3 |= (p0.g(q1) ? 0x20 : 16);
        }
        else {
            q1 = q0;
        }
        if((v1 & 0x180) == 0) {
            v3 |= (p0.h(z) ? 0x100 : 0x80);
        }
        if((v1 & 0xC00) == 0) {
            v3 |= (p0.e(v) ? 0x800 : 0x400);
        }
        if(p0.Q(v3 & 1, (v3 & 0x493) != 1170)) {
            if((v2 & 2) != 0) {
                q1 = n.a;
            }
            String s1 = k9.j.b() ? ImageUrl.getOfflinePlaylistImagePath(s).toString() : s;
            kotlin.jvm.internal.q.d(s1);
            q q2 = androidx.compose.foundation.q.i(0.5f, e0.T(p0, (z ? 0x7F06014A : 0x7F0604AE)), q1, T.e.b(4.0f));  // color:gray100a
            M m0 = M.p.d(d.a, false);
            int v4 = p0.P;
            i0 i00 = p0.m();
            q q3 = r0.a.d(p0, q2);
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
            h h0 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h0);
            }
            w.x(p0, q3, P0.j.d);
            long v5 = e0.T(p0, (z ? 0x7F060145 : 0x7F060144));  // color:gray050s
            r0.b.c(q1, s1, 0.0f, v, v5, null, false, false, p0, v3 >> 3 & 14 | 0x6000180 | v3 & 0x1C00, 0xE0);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new U8.n(s, q1, z, v, v1, v2);
        }
    }

    public static final void access$DrawerPlytPlytThumbQuarter$lambda$30(b0 b00, boolean z) {
        b00.setValue(Boolean.valueOf(z));
    }

    public static final void setDrawerPlaylistItemSemantics(@NotNull X0.x x0, boolean z, boolean z1, @NotNull String s, @NotNull String s1, @NotNull a a0, @NotNull a a1) {
        kotlin.jvm.internal.q.g(x0, "<this>");
        kotlin.jvm.internal.q.g(s, "title");
        kotlin.jvm.internal.q.g(s1, "subTitle");
        kotlin.jvm.internal.q.g(a0, "onClickItem");
        kotlin.jvm.internal.q.g(a1, "onClickPlay");
        De.w w0 = u.a[4];
        X0.s.k.a(x0, Boolean.TRUE);
        De.w w1 = u.a[5];
        X0.s.l.a(x0, Boolean.TRUE);
        StringBuilder stringBuilder0 = x.p((z ? "," : ""), s);
        if(s1.length() > 0) {
            stringBuilder0.append(",");
            stringBuilder0.append(s1);
        }
        String s2 = stringBuilder0.toString();
        kotlin.jvm.internal.q.f(s2, "toString(...)");
        u.h(x0, s2);
        u.k(x0, 0);
        u.i(x0, (z ? e.k.z(new X0.e("", new g(1, a0))) : e.k.A(new X0.e[]{new X0.e("", new g(2, a1)), new X0.e("", new g(3, a0))})));
    }
}

