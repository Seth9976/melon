package com.iloen.melon.player.playlist.common;

import Ac.U0;
import Cc.J;
import Cc.N1;
import Cc.P2;
import Cc.c1;
import Cc.e0;
import Cc.u1;
import Dc.g;
import De.I;
import H0.e;
import I.G1;
import J0.C;
import J0.y;
import K.m;
import M.c;
import M.j0;
import M.j;
import M.n0;
import M.p0;
import M.q0;
import O.F;
import O.u;
import O.v;
import Q0.k0;
import U4.x;
import X0.i;
import X0.s;
import android.content.Context;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.VerticalAlignElement;
import androidx.compose.foundation.layout.a;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.E;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.b1;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.compose.LottieAnimationKt;
import com.airbnb.lottie.compose.LottieCompositionResult;
import com.airbnb.lottie.compose.LottieCompositionSpec.Asset;
import com.airbnb.lottie.compose.RememberLottieCompositionKt;
import com.iloen.melon.utils.TalkbackUtilKt;
import com.iloen.melon.utils.system.AppUtils;
import com.iloen.melon.utils.ui.ViewUtilsKt;
import ie.H;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pb.b;
import r0.n;
import we.k;
import we.o;
import y0.M;

@Metadata(d1 = {"\u0000\u008C\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u000F\u0010\u0001\u001A\u00020\u0000H\u0007\u00A2\u0006\u0004\b\u0001\u0010\u0002\u001A\u008B\u0002\u0010\"\u001A\u00020\u00192\b\b\u0002\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\b\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\u00062\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\n2\u0006\u0010\u000E\u001A\u00020\n2\u0006\u0010\u000F\u001A\u00020\n2\u0006\u0010\u0010\u001A\u00020\n2\b\u0010\u0012\u001A\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001A\u00020\n2\u0006\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0016\u001A\u00020\n2\u0006\u0010\u0017\u001A\u00020\n2\f\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u00190\u00182\f\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u00190\u00182\f\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020\u00190\u00182\f\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\u00190\u00182\f\u0010\u001E\u001A\b\u0012\u0004\u0012\u00020\u00190\u00182\f\u0010\u001F\u001A\b\u0012\u0004\u0012\u00020\u00190\u00182\u0010\b\u0002\u0010 \u001A\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\u0010\b\u0002\u0010!\u001A\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018H\u0007\u00A2\u0006\u0004\b\"\u0010#\u001A%\u0010%\u001A\u00020\u00192\u0006\u0010\u000E\u001A\u00020\n2\f\u0010$\u001A\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0007\u00A2\u0006\u0004\b%\u0010&\u001A=\u0010(\u001A\u00020\u00192\u0006\u0010\'\u001A\u00020\u00062\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\n2\f\u0010$\u001A\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0007\u00A2\u0006\u0004\b(\u0010)\u001A\u0017\u0010+\u001A\u00020\u00192\u0006\u0010*\u001A\u00020\u0006H\u0007\u00A2\u0006\u0004\b+\u0010,\u001AS\u0010-\u001A\u00020\u00192\b\b\u0002\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\b\u001A\u00020\u00062\u0006\u0010\u0010\u001A\u00020\n2\b\u0010\u0012\u001A\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\n2\u0006\u0010\u0017\u001A\u00020\nH\u0007\u00A2\u0006\u0004\b-\u0010.\u001A\u0019\u00101\u001A\u0004\u0018\u00010\u00112\b\u00100\u001A\u0004\u0018\u00010/\u00A2\u0006\u0004\b1\u00102\u001A%\u00104\u001A\u00020\u00192\b\b\u0002\u0010\u0004\u001A\u00020\u00032\n\b\u0002\u00103\u001A\u0004\u0018\u00010\u0003H\u0007\u00A2\u0006\u0004\b4\u00105\u001A\u0019\u00106\u001A\u00020\u00192\b\b\u0002\u0010\u0004\u001A\u00020\u0003H\u0007\u00A2\u0006\u0004\b6\u00107\u001A5\u0010:\u001A\u00020\u00192\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u00108\u001A\u00020\u00112\u0014\b\u0002\u0010$\u001A\u000E\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001909H\u0007\u00A2\u0006\u0004\b:\u0010;\u001A\u00A5\u0001\u0010C\u001A\u00020\u0019*\u00020<2\u0006\u0010>\u001A\u00020=2\u0006\u0010\f\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\n2\u0006\u0010?\u001A\u00020\u00062\u0006\u0010@\u001A\u00020\u00062\u0006\u0010\u000E\u001A\u00020\n2\f\u0010\u001F\u001A\b\u0012\u0004\u0012\u00020\u00190\u00182\f\u0010\u001E\u001A\b\u0012\u0004\u0012\u00020\u00190\u00182\f\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u00190\u00182\f\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\u00190\u00182\u0010\b\u0002\u0010A\u001A\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\u0010\b\u0002\u0010B\u001A\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018\u00A2\u0006\u0004\bC\u0010D\u001A*\u0010I\u001A\u00020\u00192\u0006\u0010F\u001A\u00020E2\u0006\u0010G\u001A\u00020\u00112\b\b\u0002\u0010H\u001A\u00020\u0011H\u0086@\u00A2\u0006\u0004\bI\u0010J\u001A/\u0010P\u001A\u00020O2\u0006\u0010F\u001A\u00020E2\f\u0010L\u001A\b\u0012\u0004\u0012\u00020\n0K2\b\b\u0002\u0010N\u001A\u00020MH\u0007\u00A2\u0006\u0004\bP\u0010Q\u001A+\u0010S\u001A\u00020\u00192\f\u0010R\u001A\b\u0012\u0004\u0012\u00020\n0\u00182\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0018H\u0007\u00A2\u0006\u0004\bS\u0010T\"\u0017\u0010Z\u001A\u00020U8\u0006\u00A2\u0006\f\n\u0004\bV\u0010W\u001A\u0004\bX\u0010Y\"\u0017\u0010`\u001A\u00020[8\u0006\u00A2\u0006\f\n\u0004\b\\\u0010]\u001A\u0004\b^\u0010_\u00A8\u0006d\u00B2\u0006\u000E\u0010b\u001A\u0004\u0018\u00010a8\nX\u008A\u0084\u0002\u00B2\u0006\f\u0010c\u001A\u00020\n8\nX\u008A\u0084\u0002"}, d2 = {"LDc/g;", "getPlaylistCommonItemBgColor", "(Landroidx/compose/runtime/l;I)LDc/g;", "Lr0/q;", "modifier", "longPressDetectModifierForMove", "", "title", "subTitle", "thumbImgUrl", "", "isCurrentPlaylist", "isCurrent", "isPlaying", "isSelected", "isSelectedForSelectRepeat", "isAdult", "", "fileTypeDrawableResId", "isOfflineContents", "Lcom/iloen/melon/player/playlist/common/SongListItemRightIconType;", "rightIconType", "isMovable", "isMarquee", "Lkotlin/Function0;", "Lie/H;", "onClickItem", "onLongClickItem", "onTouchDownMoveIconWhenNotMovable", "onClickMore", "onClickThumb", "onClickSelect", "onClickMoveUpAccessibilityAction", "onClickMoveDownAccessibilityAction", "SongListItem", "(Lr0/q;Lr0/q;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZZZLjava/lang/Integer;ZLcom/iloen/melon/player/playlist/common/SongListItemRightIconType;ZZLwe/a;Lwe/a;Lwe/a;Lwe/a;Lwe/a;Lwe/a;Lwe/a;Lwe/a;Landroidx/compose/runtime/l;IIII)V", "onClick", "Selector", "(ZLwe/a;Landroidx/compose/runtime/l;I)V", "albumUri", "SongThumbNailLayoutIsPlaying", "(Ljava/lang/String;ZZZLwe/a;Landroidx/compose/runtime/l;I)V", "imageUrl", "ThumbNailImageView", "(Ljava/lang/String;Landroidx/compose/runtime/l;I)V", "SongTitleAndArtistLayout", "(Lr0/q;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;ZZZLandroidx/compose/runtime/l;II)V", "Lpb/b;", "fileType", "getFileTypeDrawableResId", "(Lpb/b;)Ljava/lang/Integer;", "longPressDetectModifier", "MoveIconLayout", "(Lr0/q;Lr0/q;Landroidx/compose/runtime/l;II)V", "MoreIcon", "(Lr0/q;Landroidx/compose/runtime/l;II)V", "count", "Lkotlin/Function1;", "GroupTitle", "(Ljava/lang/String;ILwe/k;Landroidx/compose/runtime/l;II)V", "LX0/x;", "Landroid/content/Context;", "context", "songName", "artistNames", "onClickMoveUp", "onClickMoveDown", "setSongItemSemantics", "(LX0/x;Landroid/content/Context;ZZZLjava/lang/String;Ljava/lang/String;ZLwe/a;Lwe/a;Lwe/a;Lwe/a;Lwe/a;Lwe/a;)V", "LO/F;", "lazyListState", "currentIndex", "itemHeightDp", "scrollToCurrentWhenInvisible", "(LO/F;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/runtime/b0;", "topBtnVisible", "", "hideTopButtonDelayTime", "LI0/a;", "topButtonManagingNestedScrollConnection", "(LO/F;Landroidx/compose/runtime/b0;JLandroidx/compose/runtime/l;II)LI0/a;", "isVisible", "PlaylistTopBtn", "(Lwe/a;Lwe/a;Landroidx/compose/runtime/l;I)V", "Lr1/f;", "a", "F", "getPlaylistCommonFadingEdgeTopSideSize", "()F", "playlistCommonFadingEdgeTopSideSize", "LM/i0;", "b", "LM/i0;", "getPlaylistCommonListContentPadding", "()LM/i0;", "playlistCommonListContentPadding", "Lcom/airbnb/lottie/LottieComposition;", "motionEqComposition", "canTopBtnVisible", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class PlaylistCommonSongListComposableKt {
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[b.values().length];
            try {
                arr_v[0] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[1] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[2] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    public static final float a;
    public static final j0 b;

    static {
        PlaylistCommonSongListComposableKt.a = 40.0f;
        PlaylistCommonSongListComposableKt.b = a.c(0.0f, 0.0f, 0.0f, 50.0f, 7);
    }

    public static final void GroupTitle(@NotNull String s, int v, @Nullable k k0, @Nullable l l0, int v1, int v2) {
        k k2;
        k k1;
        q.g(s, "title");
        p p0 = (p)l0;
        p0.c0(0xB487DDD8);
        int v3 = (v1 & 6) == 0 ? (p0.g(s) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v3 |= (p0.e(v) ? 0x20 : 16);
        }
        if((v2 & 4) != 0) {
            v3 |= 0x180;
        }
        else if((v1 & 0x180) == 0) {
            v3 |= (p0.i(k0) ? 0x100 : 0x80);
        }
        if(p0.Q(v3 & 1, (v3 & 0x93) != 0x92)) {
            if((v2 & 4) == 0) {
                k1 = k0;
            }
            else {
                h h0 = p0.N();
                if(h0 == androidx.compose.runtime.k.a) {
                    h0 = new h(0);
                    p0.l0(h0);
                }
                k1 = h0;
            }
            n n0 = n.a;
            r0.q q0 = r0.a.a(androidx.compose.foundation.q.f(d.h(d.f(a.l(n0, 0.0f, 6.0f, 1), 1.0f), 44.0f), e0.T(p0, 0x7F06047C), M.a), new o() {  // color:smart_playlist_section_title_bg_color
                @Override  // we.o
                public Object invoke(Object object0, Object object1, Object object2) {
                    return this.invoke(((r0.q)object0), ((l)object1), ((Number)object2).intValue());
                }

                public final r0.q invoke(r0.q q0, l l0, int v) {
                    q.g(q0, "$this$composed");
                    ((p)l0).a0(0x1FF03545);
                    w0.h h0 = (w0.h)((p)l0).k(k0.i);
                    m m0 = ((p)l0).N();
                    if(m0 == androidx.compose.runtime.k.a) {
                        m0 = androidx.appcompat.app.o.d(((p)l0));
                    }
                    i i0 = new i(0);
                    com.iloen.melon.player.playlist.common.PlaylistCommonSongListComposableKt.GroupTitle..inlined.noRippleClickable-YQRRFTQ.default.1.1 playlistCommonSongListComposableKt$GroupTitle$$inlined$noRippleClickable-YQRRFTQ$default$1$10 = new we.a() {
                        @Override  // we.a
                        public Object invoke() {
                            this.invoke();
                            return H.a;
                        }

                        public final void invoke() {
                            w0.h.a(this.d);
                            this.e.invoke(this.c);
                        }
                    };
                    r0.q q1 = androidx.compose.foundation.q.l(q0, m0, null, true, null, i0, playlistCommonSongListComposableKt$GroupTitle$$inlined$noRippleClickable-YQRRFTQ$default$1$10);
                    ((p)l0).p(false);
                    return q1;
                }
            });
            p0 p00 = n0.a(j.a, r0.d.k, p0, 0x30);
            int v4 = p0.P;
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
            P0.h h1 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h1);
            }
            w.x(p0, q1, P0.j.d);
            long v5 = ye.a.v(p0, 0x7F0604A1);  // color:white000e
            N1.b(s, x.r(1.0f, a.n(n0, 20.0f, 0.0f, 0.0f, 0.0f, 14), true), v5, 14.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, v3 & 14 | 0xC00, 0xC30, 0x1D7F0);
            String s1 = e.Y(p0, 0x7F130A3C);  // string:smart_playlist_title_section "선택"
            long v6 = e0.T(p0, 0x7F0604B4);  // color:white500e_support_high_contrast
            N1.b(s1, a.n(n0, 0.0f, 0.0f, 20.0f, 0.0f, 11), v6, 14.0f, null, null, 0L, new l1.k(6), 0.0f, 0, false, 0, 0, null, null, p0, 0xC30, 0, 0x1FDF0);
            p0.p(true);
            k2 = k1;
        }
        else {
            p0.T();
            k2 = k0;
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.player.playlist.common.i(s, v, k2, v1, v2);
        }
    }

    public static final void MoreIcon(@Nullable r0.q q0, @Nullable l l0, int v, int v1) {
        r0.q q1;
        int v2;
        p p0 = (p)l0;
        p0.c0(0x24807A17);
        if((v1 & 1) == 0) {
            v2 = (v & 6) == 0 ? (p0.g(q0) ? 4 : 2) | v : v;
        }
        else {
            v2 = v | 6;
        }
        if(p0.Q(v2 & 1, (v2 & 3) != 2)) {
            n n0 = n.a;
            q1 = (v1 & 1) == 0 ? q0 : n0;
            r0.q q2 = a.n(d.c(d.v(q1, null, 3), 1.0f), 2.0f, 0.0f, 0.0f, 0.0f, 14);
            p0 p00 = n0.a(j.a, r0.d.k, p0, 0x30);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q3 = r0.a.d(p0, q2);
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
            w.x(p0, q3, P0.j.d);
            c.d(p0, d.q(n0, 16.0f));
            androidx.compose.foundation.q.c(I.Q(0x7F080157, p0, 6), null, d.n(n0, 28.0f), null, null, 0.0f, null, p0, 0x1B0, 120);  // drawable:btn_common_more_04_w
            x.z(n0, 14.0f, p0, true);
        }
        else {
            p0.T();
            q1 = q0;
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new P2(q1, v, v1, 2);
        }
    }

    public static final void MoveIconLayout(@Nullable r0.q q0, @Nullable r0.q q1, @Nullable l l0, int v, int v1) {
        int v2;
        p p0 = (p)l0;
        p0.c0(-2106053708);
        if((v1 & 1) == 0) {
            v2 = (v & 6) == 0 ? (p0.g(q0) ? 4 : 2) | v : v;
        }
        else {
            v2 = v | 6;
        }
        if((v1 & 2) != 0) {
            v2 |= 0x30;
        }
        else if((v & 0x30) == 0) {
            v2 |= (p0.g(q1) ? 0x20 : 16);
        }
        if(p0.Q(v2 & 1, (v2 & 19) != 18)) {
            n n0 = n.a;
            if((v1 & 1) != 0) {
                q0 = n0;
            }
            if((v1 & 2) != 0) {
                q1 = null;
            }
            r0.q q2 = d.q(d.c(q0, 1.0f), 56.0f);
            if(q1 != null) {
                q2 = q2.then(q1);
            }
            N0.M m0 = M.p.d(r0.d.e, false);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q3 = r0.a.d(p0, q2);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
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
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h0);
            }
            w.x(p0, q3, P0.j.d);
            C0.c c0 = I.Q(0x7F08015D, p0, 6);  // drawable:btn_common_move_28_w
            y0.k k0 = new y0.k(e0.T(p0, 0x7F0604B3), 5);  // color:white400e_support_high_contrast
            androidx.compose.foundation.q.c(c0, null, d.o(n0, 28.0f, 28.0f), null, null, 0.0f, k0, p0, 0x1B0, 56);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Nc.p(q0, q1, v, v1, 3);
        }
    }

    public static final void PlaylistTopBtn(@NotNull we.a a0, @NotNull we.a a1, @Nullable l l0, int v) {
        q.g(a0, "isVisible");
        q.g(a1, "modifier");
        p p0 = (p)l0;
        p0.c0(0x5C89F817);
        int v1 = (v & 6) == 0 ? (p0.i(a0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (p0.i(a1) ? 0x20 : 16);
        }
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            if(((Boolean)a0.invoke()).booleanValue()) {
                p0.a0(-610308981);
                n n0 = n.a;
                r0.q q0 = a.n(n0, 0.0f, 0.0f, 0.0f, 10.0f, 7).then(((r0.q)a1.invoke()));
                N0.M m0 = M.p.d(r0.d.e, false);
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
                w.x(p0, m0, P0.j.f);
                w.x(p0, i00, P0.j.e);
                P0.h h0 = P0.j.g;
                if(p0.O || !q.b(p0.N(), v2)) {
                    A7.d.q(v2, p0, v2, h0);
                }
                w.x(p0, q1, P0.j.d);
                c1.n(d.o(n0, 52.0f, 52.0f), 0x7F08009F, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x6036, 0, 0x7FEC);  // drawable:arrow_scroll_up
                p0.p(true);
            }
            else {
                p0.a0(0xDA486D0B);
            }
            p0.p(false);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new J(v, 1, a0, a1);
        }
    }

    public static final void Selector(boolean z, @NotNull we.a a0, @Nullable l l0, int v) {
        y0.k k0;
        q.g(a0, "onClick");
        ((p)l0).c0(0xB1A714A1);
        int v1 = (v & 6) == 0 ? (((p)l0).h(z) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (((p)l0).i(a0) ? 0x20 : 16);
        }
        boolean z1 = true;
        if(((p)l0).Q(v1 & 1, (v1 & 19) != 18)) {
            if(z) {
                ((p)l0).a0(0xA25DA10D);
                ((p)l0).p(false);
                k0 = null;
            }
            else {
                ((p)l0).a0(0xA25E0F3F);
                k0 = new y0.k(e0.T(((p)l0), 0x7F0604B2), 5);  // color:white300e_support_high_contrast
                ((p)l0).p(false);
            }
            C0.c c0 = I.Q((z ? 0x7F080172 : 0x7F080171), ((p)l0), 0);  // drawable:btn_common_select_18_w_on
            if((v1 & 0x70) != 0x20) {
                z1 = false;
            }
            Bc.d d0 = ((p)l0).N();
            if(z1 || d0 == androidx.compose.runtime.k.a) {
                d0 = new Bc.d(25, a0);
                ((p)l0).l0(d0);
            }
            androidx.compose.foundation.selection.a a1 = new androidx.compose.foundation.selection.a(z, d0);
            androidx.compose.foundation.q.c(c0, null, r0.a.a(n.a, a1), null, null, 0.0f, k0, ((p)l0), 0x30, 56);
        }
        else {
            ((p)l0).T();
        }
        androidx.compose.runtime.n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new f(z, a0, v, 0);
        }
    }

    public static final void SongListItem(@Nullable r0.q q0, @NotNull r0.q q1, @NotNull String s, @NotNull String s1, @NotNull String s2, boolean z, boolean z1, boolean z2, boolean z3, boolean z4, boolean z5, @Nullable Integer integer0, boolean z6, @NotNull SongListItemRightIconType songListItemRightIconType0, boolean z7, boolean z8, @NotNull we.a a0, @NotNull we.a a1, @NotNull we.a a2, @NotNull we.a a3, @NotNull we.a a4, @NotNull we.a a5, @Nullable we.a a6, @Nullable we.a a7, @Nullable l l0, int v, int v1, int v2, int v3) {
        we.a a13;
        we.a a12;
        V v26;
        int v25;
        int v24;
        n n1;
        we.a a11;
        int v22;
        int v21;
        r0.q q5;
        we.a a10;
        int v20;
        V v19;
        int v18;
        r0.q q3;
        int v16;
        int v15;
        int v4;
        q.g(q1, "longPressDetectModifierForMove");
        q.g(s, "title");
        q.g(s1, "subTitle");
        q.g(s2, "thumbImgUrl");
        q.g(songListItemRightIconType0, "rightIconType");
        q.g(a0, "onClickItem");
        q.g(a1, "onLongClickItem");
        q.g(a2, "onTouchDownMoveIconWhenNotMovable");
        q.g(a3, "onClickMore");
        q.g(a4, "onClickThumb");
        q.g(a5, "onClickSelect");
        p p0 = (p)l0;
        p0.c0(0x4D7A3E59);
        if((v3 & 1) == 0) {
            v4 = (v & 6) == 0 ? v | (p0.g(q0) ? 4 : 2) : v;
        }
        else {
            v4 = v | 6;
        }
        int v5 = 16;
        if((v & 0x30) == 0) {
            v4 |= (p0.g(q1) ? 0x20 : 16);
        }
        int v6 = 0x80;
        if((v & 0x180) == 0) {
            v4 |= (p0.g(s) ? 0x100 : 0x80);
        }
        int v7 = 0x400;
        if((v & 0xC00) == 0) {
            v4 |= (p0.g(s1) ? 0x800 : 0x400);
        }
        int v8 = 0x2000;
        if((v & 0x6000) == 0) {
            v4 |= (p0.g(s2) ? 0x4000 : 0x2000);
        }
        int v9 = 0x10000;
        if((v & 0x30000) == 0) {
            v4 |= (p0.h(z) ? 0x20000 : 0x10000);
        }
        int v10 = 0x80000;
        if((v & 0x180000) == 0) {
            v4 |= (p0.h(z1) ? 0x100000 : 0x80000);
        }
        if((v & 0xC00000) == 0) {
            v4 |= (p0.h(z2) ? 0x800000 : 0x400000);
        }
        int v11 = 0x2000000;
        if((v & 0x6000000) == 0) {
            v4 |= (p0.h(z3) ? 0x4000000 : 0x2000000);
        }
        int v12 = 0x10000000;
        if((v & 0x30000000) == 0) {
            v4 |= (p0.h(z4) ? 0x20000000 : 0x10000000);
        }
        int v13 = (v1 & 6) == 0 ? v1 | (p0.h(z5) ? 4 : 2) : v1;
        if((v1 & 0x30) == 0) {
            v13 |= (p0.g(integer0) ? 0x20 : 16);
        }
        if((v1 & 0x180) == 0) {
            v13 |= (p0.h(z6) ? 0x100 : 0x80);
        }
        if((v1 & 0xC00) == 0) {
            v13 |= (p0.e(songListItemRightIconType0.ordinal()) ? 0x800 : 0x400);
        }
        if((v1 & 0x6000) == 0) {
            if(p0.h(z7)) {
                v8 = 0x4000;
            }
            v13 |= v8;
        }
        if((v1 & 0x30000) == 0) {
            if(p0.h(z8)) {
                v9 = 0x20000;
            }
            v13 |= v9;
        }
        if((v1 & 0x180000) == 0) {
            if(p0.i(a0)) {
                v10 = 0x100000;
            }
            v13 |= v10;
        }
        if((v1 & 0xC00000) == 0) {
            v13 |= (p0.i(a1) ? 0x800000 : 0x400000);
        }
        if((v1 & 0x6000000) == 0) {
            if(p0.i(a2)) {
                v11 = 0x4000000;
            }
            v13 |= v11;
        }
        if((v1 & 0x30000000) == 0) {
            if(p0.i(a3)) {
                v12 = 0x20000000;
            }
            v13 |= v12;
        }
        int v14 = (v2 & 6) == 0 ? v2 | (p0.i(a4) ? 4 : 2) : v2;
        if((v2 & 0x30) == 0) {
            if(p0.i(a5)) {
                v5 = 0x20;
            }
            v14 |= v5;
        }
        if((v3 & 0x400000) != 0) {
            v15 = v14 | 0x180;
        }
        else if((v2 & 0x180) == 0) {
            if(p0.i(a6)) {
                v6 = 0x100;
            }
            v15 = v14 | v6;
        }
        else {
            v15 = v14;
        }
        if((v3 & 0x800000) != 0) {
            v16 = v15 | 0xC00;
        }
        else if((v2 & 0xC00) == 0) {
            if(p0.i(a7)) {
                v7 = 0x800;
            }
            v16 = v15 | v7;
        }
        else {
            v16 = v15;
        }
        if(p0.Q(v4 & 1, (v4 & 306783379) != 306783378 || (v13 & 306783379) != 306783378 || (v16 & 0x493) != 1170)) {
            n n0 = n.a;
            r0.q q2 = (v3 & 1) == 0 ? q0 : n0;
            we.a a8 = (v3 & 0x400000) == 0 ? a6 : null;
            we.a a9 = (v3 & 0x800000) == 0 ? a7 : null;
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            q3 = q2;
            r0.q q4 = androidx.compose.foundation.q.f(d.h(q2, 60.0f), e0.T(p0, (z4 ? 0x7F0604AD : 0x7F06048A)), M.a);  // color:white075e
            boolean z9 = p0.i(context0);
            com.iloen.melon.player.playlist.common.j j0 = p0.N();
            V v17 = androidx.compose.runtime.k.a;
            if((((v16 & 0x1C00) == 0x800 ? 1 : 0) | (((v16 & 0x380) == 0x100 ? 1 : 0) | (((v4 & 0x70000) == 0x20000 ? 1 : 0) | (z9 | (v4 & 0x380000) == 0x100000) | ((v4 & 0x1C00000) == 0x800000 ? 1 : 0) | ((v4 & 0x380) == 0x100 ? 1 : 0) | ((v4 & 0x1C00) == 0x800 ? 1 : 0) | ((0xE000000 & v4) == 0x4000000 ? 1 : 0) | ((v16 & 0x70) == 0x20 ? 1 : 0) | ((v16 & 14) == 4 ? 1 : 0) | ((v13 & 0x380000) == 0x100000 ? 1 : 0) | ((v13 & 0x70000000) == 0x20000000 ? 1 : 0)))) != 0 || j0 == v17) {
                v19 = v17;
                v20 = v4 & 0x380000;
                v21 = v16 & 0x70;
                v18 = v13 & 0x70000000;
                q5 = q4;
                v22 = v13 & 0x380000;
                n1 = n0;
                j0 = new com.iloen.melon.player.playlist.common.j(context0, z1, z, z2, s, s1, z3, a5, a4, a0, a3, a8, a9);
                a10 = a9;
                a11 = a8;
                p0.l0(j0);
            }
            else {
                v18 = v13 & 0x70000000;
                v19 = v17;
                v20 = v4 & 0x380000;
                a10 = a9;
                q5 = q4;
                v21 = v16 & 0x70;
                v22 = v13 & 0x380000;
                a11 = a8;
                n1 = n0;
            }
            r0.q q6 = X0.n.b(q5, j0);
            r0.h h0 = r0.d.k;
            M.b b0 = j.a;
            p0 p00 = n0.a(b0, h0, p0, 0x30);
            int v23 = p0.P;
            i0 i00 = p0.m();
            r0.q q7 = r0.a.d(p0, q6);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
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
            if(p0.O || !q.b(p0.N(), v23)) {
                A7.d.q(v23, p0, v23, h3);
            }
            P0.h h4 = P0.j.d;
            w.x(p0, q7, h4);
            r0.q q8 = d.c(q0.a(n1, 1.0f), 1.0f);
            if((v13 & 0x1C00000) == 0x800000) {
                v24 = v22;
                v25 = 1;
            }
            else {
                v24 = v22;
                v25 = 0;
            }
            com.iloen.melon.player.playlist.common.PlaylistCommonSongListComposableKt.SongListItem.2.1.1 playlistCommonSongListComposableKt$SongListItem$2$1$10 = p0.N();
            if((v25 | (v24 == 0x100000 ? 1 : 0)) == 0) {
                v26 = v19;
                if(playlistCommonSongListComposableKt$SongListItem$2$1$10 == v26) {
                    playlistCommonSongListComposableKt$SongListItem$2$1$10 = new PointerInputEventHandler() {
                        public final we.a a;
                        public final we.a b;

                        {
                            we.a a0 = a1;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                            we.a a1 = a0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                            this.a = a0;
                            this.b = a1;
                        }

                        @Override  // androidx.compose.ui.input.pointer.PointerInputEventHandler
                        public final Object invoke(y y0, Continuation continuation0) {
                            Object object0 = G1.d(y0, new u1(9, this.a), null, new u1(10, this.b), continuation0, 5);
                            return object0 == ne.a.a ? object0 : H.a;
                        }
                    };
                    p0.l0(playlistCommonSongListComposableKt$SongListItem$2$1$10);
                }
            }
            else {
                v26 = v19;
                playlistCommonSongListComposableKt$SongListItem$2$1$10 = new PointerInputEventHandler() {
                    public final we.a a;
                    public final we.a b;

                    {
                        we.a a0 = a1;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                        we.a a1 = a0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                        this.a = a0;
                        this.b = a1;
                    }

                    @Override  // androidx.compose.ui.input.pointer.PointerInputEventHandler
                    public final Object invoke(y y0, Continuation continuation0) {
                        Object object0 = G1.d(y0, new u1(9, this.a), null, new u1(10, this.b), continuation0, 5);
                        return object0 == ne.a.a ? object0 : H.a;
                    }
                };
                p0.l0(playlistCommonSongListComposableKt$SongListItem$2$1$10);
            }
            H h5 = H.a;
            r0.q q9 = J0.H.a(q8, h5, playlistCommonSongListComposableKt$SongListItem$2$1$10);
            p0 p01 = n0.a(b0, h0, p0, 0x30);
            int v27 = p0.P;
            i0 i01 = p0.m();
            r0.q q10 = r0.a.d(p0, q9);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p01, h1);
            w.x(p0, i01, h2);
            if(p0.O || !q.b(p0.N(), v27)) {
                A7.d.q(v27, p0, v27, h3);
            }
            w.x(p0, q10, h4);
            c.d(p0, d.q(n1, 20.0f));
            Bc.d d0 = p0.N();
            if(v21 == 0x20 || d0 == v26) {
                d0 = new Bc.d(22, a5);
                p0.l0(d0);
            }
            PlaylistCommonSongListComposableKt.Selector(z3, d0, p0, v4 >> 24 & 14);
            c.d(p0, d.q(n1, 14.0f));
            Bc.d d1 = p0.N();
            if((v16 & 14) == 4 || d1 == v26) {
                d1 = new Bc.d(23, a4);
                p0.l0(d1);
            }
            PlaylistCommonSongListComposableKt.SongThumbNailLayoutIsPlaying(s2, z, z1, z2, d1, p0, v4 >> 12 & 0x1FFE);
            c.d(p0, d.q(n1, 10.0f));
            PlaylistCommonSongListComposableKt.SongTitleAndArtistLayout(q0.a(n1, 1.0f), s, s1, z5, integer0, z6, z1, z8, p0, v4 >> 3 & 0x3F0 | v13 << 9 & 0x1C00 | 0xE000 & v13 << 9 | v13 << 9 & 0x70000 | v20 | v13 << 6 & 0x1C00000, 0);
            x.z(n1, 2.0f, p0, true);
            if(songListItemRightIconType0 == SongListItemRightIconType.MOVE) {
                p0.a0(0x7181260D);
                if(z7) {
                    p0.a0(1904302623);
                    PlaylistCommonSongListComposableKt.MoveIconLayout(null, q1, p0, v4 & 0x70, 1);
                }
                else {
                    p0.a0(1904459080);
                    u1 u10 = p0.N();
                    if((v13 & 0xE000000) == 0x4000000 || u10 == v26) {
                        u10 = new u1(8, a2);
                        p0.l0(u10);
                    }
                    PlaylistCommonSongListComposableKt.MoveIconLayout(r0.a.a(n1, new C(0, u10)), null, p0, 0, 2);
                }
                p0.p(false);
            }
            else {
                p0.a0(0x718ADA0C);
                com.iloen.melon.player.playlist.common.PlaylistCommonSongListComposableKt.SongListItem.2.4.1 playlistCommonSongListComposableKt$SongListItem$2$4$10 = p0.N();
                if((((v13 & 0x1C00000) == 0x800000 ? 1 : 0) | (v18 == 0x20000000 ? 1 : 0)) != 0 || playlistCommonSongListComposableKt$SongListItem$2$4$10 == v26) {
                    playlistCommonSongListComposableKt$SongListItem$2$4$10 = new PointerInputEventHandler() {
                        public final we.a a;
                        public final we.a b;

                        {
                            we.a a0 = a1;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                            we.a a1 = a3;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                            this.a = a0;
                            this.b = a1;
                        }

                        @Override  // androidx.compose.ui.input.pointer.PointerInputEventHandler
                        public final Object invoke(y y0, Continuation continuation0) {
                            Object object0 = G1.d(y0, new u1(11, this.a), null, new u1(12, this.b), continuation0, 5);
                            return object0 == ne.a.a ? object0 : H.a;
                        }
                    };
                    p0.l0(playlistCommonSongListComposableKt$SongListItem$2$4$10);
                }
                PlaylistCommonSongListComposableKt.MoreIcon(J0.H.a(n1, h5, playlistCommonSongListComposableKt$SongListItem$2$4$10), p0, 0, 0);
            }
            p0.p(false);
            p0.p(true);
            a12 = a11;
            a13 = a10;
        }
        else {
            p0.T();
            q3 = q0;
            a12 = a6;
            a13 = a7;
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.player.playlist.common.c(q3, q1, s, s1, s2, z, z1, z2, z3, z4, z5, integer0, z6, songListItemRightIconType0, z7, z8, a0, a1, a2, a3, a4, a5, a12, a13, v, v1, v2, v3);
        }
    }

    public static final void SongThumbNailLayoutIsPlaying(@NotNull String s, boolean z, boolean z1, boolean z2, @NotNull we.a a0, @Nullable l l0, int v) {
        q.g(s, "albumUri");
        q.g(a0, "onClick");
        p p0 = (p)l0;
        p0.c0(0xB5366132);
        int v1 = (v & 6) == 0 ? (p0.g(s) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (p0.h(z) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v1 |= (p0.h(z1) ? 0x100 : 0x80);
        }
        if((v & 0xC00) == 0) {
            v1 |= (p0.h(z2) ? 0x800 : 0x400);
        }
        if((v & 0x6000) == 0) {
            v1 |= (p0.i(a0) ? 0x4000 : 0x2000);
        }
        if(p0.Q(v1 & 1, (v1 & 9363) != 9362)) {
            LottieCompositionResult lottieCompositionResult0 = RememberLottieCompositionKt.rememberLottieComposition(Asset.box-impl("animation/Motion_Graphic_Equalizer.json"), null, null, null, null, null, p0, 6, 62);
            n n0 = n.a;
            r0.q q0 = d.o(n0, 44.0f, 44.0f).then(r0.a.a(n0, new o() {
                @Override  // we.o
                public Object invoke(Object object0, Object object1, Object object2) {
                    return this.invoke(((r0.q)object0), ((l)object1), ((Number)object2).intValue());
                }

                public final r0.q invoke(r0.q q0, l l0, int v) {
                    q.g(q0, "$this$composed");
                    ((p)l0).a0(0x1FF03545);
                    w0.h h0 = (w0.h)((p)l0).k(k0.i);
                    m m0 = ((p)l0).N();
                    if(m0 == androidx.compose.runtime.k.a) {
                        m0 = androidx.appcompat.app.o.d(((p)l0));
                    }
                    i i0 = new i(0);
                    com.iloen.melon.player.playlist.common.PlaylistCommonSongListComposableKt.SongThumbNailLayoutIsPlaying..inlined.noRippleClickable-YQRRFTQ.default.1.1 playlistCommonSongListComposableKt$SongThumbNailLayoutIsPlaying$$inlined$noRippleClickable-YQRRFTQ$default$1$10 = new we.a() {
                        @Override  // we.a
                        public Object invoke() {
                            this.invoke();
                            return H.a;
                        }

                        public final void invoke() {
                            w0.h.a(this.d);
                            this.b.invoke();
                        }
                    };
                    r0.q q1 = androidx.compose.foundation.q.l(q0, m0, null, true, null, i0, playlistCommonSongListComposableKt$SongThumbNailLayoutIsPlaying$$inlined$noRippleClickable-YQRRFTQ$default$1$10);
                    ((p)l0).p(false);
                    return q1;
                }
            }));
            N0.M m0 = M.p.d(r0.d.e, false);
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
            w.x(p0, m0, P0.j.f);
            w.x(p0, i00, P0.j.e);
            P0.h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            w.x(p0, q1, P0.j.d);
            PlaylistCommonSongListComposableKt.ThumbNailImageView(s, p0, v1 & 14);
            if(!z1 || !z) {
                p0.a0(9740982);
            }
            else {
                p0.a0(20198119);
                M.p.a(androidx.compose.foundation.q.f(d5.n.o(d.c(d.f(n0, 1.0f), 1.0f), T.e.b(4.0f)), e0.T(p0, 0x7F06003F), M.a), p0, 0);  // color:black_60
                r0.q q2 = d.n(n0, 28.0f);
                LottieAnimationKt.LottieAnimation(((LottieComposition)lottieCompositionResult0.getValue()), q2, z2, false, null, 0.0f, 0x7FFFFFFF, false, false, false, false, null, false, false, null, null, null, false, false, null, false, null, p0, v1 >> 3 & 0x380 | 0x180030, 0, 0, 0x3FFFB8);
            }
            p0.p(false);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.player.playlist.common.e(s, z, z1, z2, a0, v);
        }
    }

    public static final void SongTitleAndArtistLayout(@Nullable r0.q q0, @NotNull String s, @NotNull String s1, boolean z, @Nullable Integer integer0, boolean z1, boolean z2, boolean z3, @Nullable l l0, int v, int v1) {
        r0.q q10;
        n n1;
        P0.h h8;
        r0.q q5;
        P0.h h7;
        r0.h h6;
        int v2;
        r0.h h0 = r0.d.k;
        q.g(s, "title");
        q.g(s1, "subTitle");
        p p0 = (p)l0;
        p0.c0(0xEA3A195B);
        if((v1 & 1) == 0) {
            v2 = (v & 6) == 0 ? (p0.g(q0) ? 4 : 2) | v : v;
        }
        else {
            v2 = v | 6;
        }
        if((v & 0x30) == 0) {
            v2 |= (p0.g(s) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v2 |= (p0.g(s1) ? 0x100 : 0x80);
        }
        if((v & 0xC00) == 0) {
            v2 |= (p0.h(z) ? 0x800 : 0x400);
        }
        if((v & 0x6000) == 0) {
            v2 |= (p0.g(integer0) ? 0x4000 : 0x2000);
        }
        if((0x30000 & v) == 0) {
            v2 |= (p0.h(z1) ? 0x20000 : 0x10000);
        }
        if((0x180000 & v) == 0) {
            v2 |= (p0.h(z2) ? 0x100000 : 0x80000);
        }
        if((0xC00000 & v) == 0) {
            v2 |= (p0.h(z3) ? 0x800000 : 0x400000);
        }
        if(p0.Q(v2 & 1, (v2 & 0x492493) != 4793490)) {
            n n0 = n.a;
            r0.q q1 = (v1 & 1) == 0 ? q0 : n0;
            boolean z4 = integer0 != null && ((int)integer0) > 0;
            M.y y0 = M.w.a(j.c, r0.d.m, p0, 0);
            int v3 = p0.P;
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
            P0.h h1 = P0.j.f;
            w.x(p0, y0, h1);
            P0.h h2 = P0.j.e;
            w.x(p0, i00, h2);
            P0.h h3 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h3);
            }
            P0.h h4 = P0.j.d;
            w.x(p0, q2, h4);
            M.b b0 = j.a;
            r0.h h5 = r0.d.j;
            p0 p00 = n0.a(b0, h5, p0, 0);
            int v4 = p0.P;
            i0 i01 = p0.m();
            r0.q q3 = r0.a.d(p0, n0);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, h1);
            w.x(p0, i01, h2);
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h3);
            }
            w.x(p0, q3, h4);
            if(z) {
                p0.a0(0x5E6BD5CD);
                r0.q q4 = H0.b.r(h0, d.n(n0, 14.0f));
                h6 = h5;
                h7 = h2;
                q5 = q1;
                h8 = h1;
                n1 = n0;
                androidx.compose.foundation.q.c(I.Q(0x7F0803D2, p0, 6), null, q4, null, null, 0.0f, null, p0, 0x30, 120);  // drawable:ic_common_19
                x.z(n1, 2.0f, p0, false);
            }
            else {
                q5 = q1;
                h6 = h5;
                h8 = h1;
                h7 = h2;
                n1 = n0;
                p0.a0(1571918209);
                p0.p(false);
            }
            if(z4) {
                p0.a0(0x5E71FBE6);
                r0.q q6 = d.o(n1, 28.0f, 14.0f).then(new VerticalAlignElement(h0));
                q.d(integer0);
                androidx.compose.foundation.q.c(I.Q(((int)integer0), p0, 0), null, q6, null, null, 0.0f, null, p0, 0x30, 120);
                x.z(n1, 3.0f, p0, false);
            }
            else {
                p0.a0(1571918209);
                p0.p(false);
            }
            long v5 = z2 ? A7.d.f(p0, 1584940503, 0x7F060179, p0, false) : A7.d.f(p0, 1585019863, 0x7F0604A1, p0, false);  // color:green490e
            r0.q q7 = q0.a(n1, 1.0f);
            if(z3) {
                q7 = androidx.compose.foundation.q.h(q7, 0, 0, null, 0.0f, 62);
            }
            N1.b(s, q7, v5, 15.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, v2 >> 3 & 14 | 0xC00, 0xC30, 0x1D7F0);
            p0.p(true);
            c.d(p0, d.h(n1, 4.0f));
            p0 p01 = n0.a(b0, h6, p0, 0);
            int v6 = p0.P;
            i0 i02 = p0.m();
            r0.q q8 = r0.a.d(p0, n1);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p01, h8);
            w.x(p0, i02, h7);
            if(p0.O || !q.b(p0.N(), v6)) {
                A7.d.q(v6, p0, v6, h3);
            }
            w.x(p0, q8, h4);
            if(!z1 || z4) {
                p0.a0(0x3D0F4BD8);
                p0.p(false);
            }
            else {
                p0.a0(1038264734);
                r0.q q9 = H0.b.r(h0, d.n(n1, 12.0f));
                androidx.compose.foundation.q.c(I.Q(0x7F0805B2, p0, 6), null, q9, null, null, 0.0f, null, p0, 0x30, 120);  // drawable:ic_player_offline
                x.z(n1, 4.0f, p0, false);
            }
            N1.b(s1, null, e0.T(p0, 0x7F0604B4), 13.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, v2 >> 6 & 14 | 0xC00, 0xC30, 0x1D7F2);  // color:white500e_support_high_contrast
            p0.p(true);
            p0.p(true);
            q10 = q5;
        }
        else {
            p0.T();
            q10 = q0;
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.player.playlist.common.d(q10, s, s1, z, integer0, z1, z2, z3, v, v1);
        }
    }

    public static final void ThumbNailImageView(@NotNull String s, @Nullable l l0, int v) {
        q.g(s, "imageUrl");
        p p0 = (p)l0;
        p0.c0(0x6A8C3F23);
        int v1 = (v & 6) == 0 ? v | (p0.g(s) ? 4 : 2) : v;
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            FillElement fillElement0 = d.c;
            r0.q q0 = androidx.compose.foundation.q.f(d5.n.o(fillElement0, T.e.b(4.0f)), e0.T(p0, 0x7F060144), M.a);  // color:gray050e
            androidx.compose.foundation.y y0 = androidx.compose.foundation.q.a(e0.T(p0, 0x7F06014A), 0.2f);  // color:gray100a
            T.d d0 = T.e.b(4.0f);
            r0.q q1 = androidx.compose.foundation.q.j(q0, y0.a, y0.b, d0);
            N0.M m0 = M.p.d(r0.d.a, false);
            int v2 = p0.P;
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
            w.x(p0, m0, P0.j.f);
            w.x(p0, i00, P0.j.e);
            P0.h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            w.x(p0, q2, P0.j.d);
            c1.n(d5.n.o(fillElement0, T.e.b(4.0f)), s, null, N0.j.b, false, 0x7F08078C, null, null, null, 0.0f, null, 0, 0, false, false, p0, v1 << 3 & 0x70 | 200064, 0, 0x7FD0);  // drawable:noimage_logo_mini_w
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new U0(s, v, 2);
        }
    }

    public static final boolean access$topButtonManagingNestedScrollConnection$lambda$46(b1 b10) {
        return ((Boolean)b10.getValue()).booleanValue();
    }

    @Nullable
    public static final Integer getFileTypeDrawableResId(@Nullable b b0) {
        switch((b0 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[b0.ordinal()])) {
            case 1: {
                return 0x7F0805A4;  // drawable:ic_player_dcf
            }
            case 2: {
                return 0x7F0805A9;  // drawable:ic_player_flac
            }
            case 3: {
                return 0x7F0805AD;  // drawable:ic_player_mp_3
            }
            default: {
                return null;
            }
        }
    }

    public static final float getPlaylistCommonFadingEdgeTopSideSize() [...] // 潜在的解密器

    @NotNull
    public static final g getPlaylistCommonItemBgColor(@Nullable l l0, int v) {
        return new g(e0.T(l0, 0x7F0604AD), e0.T(l0, 0x7F06048A));  // color:white075e
    }

    @NotNull
    public static final M.i0 getPlaylistCommonListContentPadding() {
        return PlaylistCommonSongListComposableKt.b;
    }

    @Nullable
    public static final Object scrollToCurrentWhenInvisible(@NotNull F f0, int v, int v1, @NotNull Continuation continuation0) {
        if(v >= 0) {
            u u0 = f0.h();
            Iterable iterable0 = (Iterable)u0.k;
            if(!(iterable0 instanceof Collection) || !((Collection)iterable0).isEmpty()) {
                for(Object object0: iterable0) {
                    v v2 = (v)object0;
                    if(v2.a == v && (v2.m >= 0 && v2.m + v2.n <= u0.m)) {
                        return H.a;
                    }
                    if(false) {
                        break;
                    }
                }
            }
            int v3 = ViewUtilsKt.dpToPx(v1);
            Object object1 = f0.j(v, -(u0.m / 2 - v3 / 2), continuation0);
            if(object1 == ne.a.a) {
                return object1;
            }
        }
        return H.a;
    }

    public static Object scrollToCurrentWhenInvisible$default(F f0, int v, int v1, Continuation continuation0, int v2, Object object0) {
        if((v2 & 4) != 0) {
            v1 = 60;
        }
        return PlaylistCommonSongListComposableKt.scrollToCurrentWhenInvisible(f0, v, v1, continuation0);
    }

    public static final void setSongItemSemantics(@NotNull X0.x x0, @NotNull Context context0, boolean z, boolean z1, boolean z2, @NotNull String s, @NotNull String s1, boolean z3, @NotNull we.a a0, @NotNull we.a a1, @NotNull we.a a2, @NotNull we.a a3, @Nullable we.a a4, @Nullable we.a a5) {
        q.g(x0, "<this>");
        q.g(context0, "context");
        q.g(s, "songName");
        q.g(s1, "artistNames");
        q.g(a0, "onClickSelect");
        q.g(a1, "onClickThumb");
        q.g(a2, "onClickItem");
        q.g(a3, "onClickMore");
        De.w w0 = X0.u.a[4];
        s.k.a(x0, Boolean.TRUE);
        De.w w1 = X0.u.a[5];
        s.l.a(x0, Boolean.TRUE);
        X0.u.h(x0, (z3 ? ", " : "") + (!z || !z1 ? "" : ", ") + TalkbackUtilKt.getPlayableTalkbackInfo(context0, s, s1));
        X0.u.k(x0, 0);
        ArrayList arrayList0 = e.k.C(new X0.e[]{new X0.e("", new Bc.d(24, a0)), new X0.e("", new Bc.d(26, a1)), new X0.e("", new Bc.d(27, a2)), new X0.e("", new Bc.d(28, a3))});
        if(a4 != null) {
            arrayList0.add(new X0.e("", new Bc.d(29, a4)));
        }
        if(a5 != null) {
            arrayList0.add(new X0.e("", new com.iloen.melon.player.playlist.common.g(0, a5)));
        }
        X0.u.i(x0, arrayList0);
    }

    public static void setSongItemSemantics$default(X0.x x0, Context context0, boolean z, boolean z1, boolean z2, String s, String s1, boolean z3, we.a a0, we.a a1, we.a a2, we.a a3, we.a a4, we.a a5, int v, Object object0) {
        PlaylistCommonSongListComposableKt.setSongItemSemantics(x0, context0, z, z1, z2, s, s1, z3, a0, a1, a2, a3, ((v & 0x800) == 0 ? a4 : null), ((v & 0x1000) == 0 ? a5 : null));
    }

    @NotNull
    public static final I0.a topButtonManagingNestedScrollConnection(@NotNull F f0, @NotNull b0 b00, long v, @Nullable l l0, int v1, int v2) {
        q.g(f0, "lazyListState");
        q.g(b00, "topBtnVisible");
        if((v2 & 4) != 0) {
            v = AppUtils.isAccessibilityTalkbackOn() ? 20000L : 3000L;
        }
        CoroutineScope coroutineScope0 = ((p)l0).N();
        V v3 = androidx.compose.runtime.k.a;
        if(coroutineScope0 == v3) {
            coroutineScope0 = androidx.compose.runtime.J.i(((p)l0));
            ((p)l0).l0(coroutineScope0);
        }
        kotlin.jvm.internal.H h0 = new kotlin.jvm.internal.H();  // 初始化器: Ljava/lang/Object;-><init>()V
        E e0 = ((p)l0).N();
        if(e0 == v3) {
            e0 = w.i(new Ac.M(f0, 22));
            ((p)l0).l0(e0);
        }
        boolean z = (v1 & 0x70 ^ 0x30) > 0x20 && ((p)l0).g(b00) || (v1 & 0x30) == 0x20;
        com.iloen.melon.player.playlist.common.PlaylistCommonSongListComposableKt.topButtonManagingNestedScrollConnection.1.1 playlistCommonSongListComposableKt$topButtonManagingNestedScrollConnection$1$10 = ((p)l0).N();
        if(z || playlistCommonSongListComposableKt$topButtonManagingNestedScrollConnection$1$10 == v3) {
            playlistCommonSongListComposableKt$topButtonManagingNestedScrollConnection$1$10 = new we.n(e0, b00, null) {
                public final b0 B;
                public int r;
                public final b1 w;

                {
                    this.w = b10;
                    this.B = b00;
                    super(2, continuation0);
                }

                @Override  // oe.a
                public final Continuation create(Object object0, Continuation continuation0) {
                    return new com.iloen.melon.player.playlist.common.PlaylistCommonSongListComposableKt.topButtonManagingNestedScrollConnection.1.1(this.w, this.B, continuation0);
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                }

                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                    return ((com.iloen.melon.player.playlist.common.PlaylistCommonSongListComposableKt.topButtonManagingNestedScrollConnection.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                }

                @Override  // oe.a
                public final Object invokeSuspend(Object object0) {
                    ne.a a0 = ne.a.a;
                    switch(this.r) {
                        case 0: {
                            d5.n.D(object0);
                            Flow flow0 = w.y(new Cc.b0(this.w, 5));
                            com.iloen.melon.player.playlist.common.PlaylistCommonSongListComposableKt.topButtonManagingNestedScrollConnection.1.1.2 playlistCommonSongListComposableKt$topButtonManagingNestedScrollConnection$1$1$20 = new we.n(null) {
                                public boolean r;
                                public final b0 w;

                                {
                                    this.w = b00;
                                    super(2, continuation0);
                                }

                                @Override  // oe.a
                                public final Continuation create(Object object0, Continuation continuation0) {
                                    Continuation continuation1 = new com.iloen.melon.player.playlist.common.PlaylistCommonSongListComposableKt.topButtonManagingNestedScrollConnection.1.1.2(this.w, continuation0);
                                    continuation1.r = ((Boolean)object0).booleanValue();
                                    return continuation1;
                                }

                                @Override  // we.n
                                public Object invoke(Object object0, Object object1) {
                                    return this.invoke(((Boolean)object0).booleanValue(), ((Continuation)object1));
                                }

                                public final Object invoke(boolean z, Continuation continuation0) {
                                    return ((com.iloen.melon.player.playlist.common.PlaylistCommonSongListComposableKt.topButtonManagingNestedScrollConnection.1.1.2)this.create(Boolean.valueOf(z), continuation0)).invokeSuspend(H.a);
                                }

                                @Override  // oe.a
                                public final Object invokeSuspend(Object object0) {
                                    boolean z = this.r;
                                    d5.n.D(object0);
                                    if(!z) {
                                        this.w.setValue(Boolean.FALSE);
                                    }
                                    return H.a;
                                }
                            };
                            this.r = 1;
                            return FlowKt.collectLatest(flow0, playlistCommonSongListComposableKt$topButtonManagingNestedScrollConnection$1$1$20, this) == a0 ? a0 : H.a;
                        }
                        case 1: {
                            d5.n.D(object0);
                            return H.a;
                        }
                        default: {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                    }
                }
            };
            ((p)l0).l0(playlistCommonSongListComposableKt$topButtonManagingNestedScrollConnection$1$10);
        }
        androidx.compose.runtime.J.d(((p)l0), Boolean.TRUE, playlistCommonSongListComposableKt$topButtonManagingNestedScrollConnection$1$10);
        com.iloen.melon.player.playlist.common.PlaylistCommonSongListComposableKt.topButtonManagingNestedScrollConnection.2.1 playlistCommonSongListComposableKt$topButtonManagingNestedScrollConnection$2$10 = ((p)l0).N();
        if(playlistCommonSongListComposableKt$topButtonManagingNestedScrollConnection$2$10 == v3) {
            com.iloen.melon.player.playlist.common.PlaylistCommonSongListComposableKt.topButtonManagingNestedScrollConnection.2.1 playlistCommonSongListComposableKt$topButtonManagingNestedScrollConnection$2$11 = new I0.a() {
                public final F a;
                public final b0 b;
                public final kotlin.jvm.internal.H c;
                public final CoroutineScope d;
                public final long e;

                {
                    F f0 = f0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                    b0 b00 = b00;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                    kotlin.jvm.internal.H h0 = h0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                    CoroutineScope coroutineScope0 = coroutineScope0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                    long v = v;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                    this.a = f0;
                    this.b = b00;
                    this.c = h0;
                    this.d = coroutineScope0;
                    this.e = v;
                }

                @Override  // I0.a
                public Object onPostFling-RZ2iAVY(long v, long v1, Continuation continuation0) {
                    b0 b00 = this.b;
                    if(((Boolean)b00.getValue()).booleanValue()) {
                        kotlin.jvm.internal.H h0 = this.c;
                        Job job0 = (Job)h0.a;
                        if(job0 != null) {
                            DefaultImpls.cancel$default(job0, null, 1, null);
                        }
                        CompletableJob completableJob0 = SupervisorKt.SupervisorJob$default(null, 1, null);
                        com.iloen.melon.player.playlist.common.PlaylistCommonSongListComposableKt.topButtonManagingNestedScrollConnection.2.1.onPostFling.2 playlistCommonSongListComposableKt$topButtonManagingNestedScrollConnection$2$1$onPostFling$20 = new we.n(b00, null) {
                            public final b0 B;
                            public int r;
                            public final long w;

                            {
                                this.w = v;
                                this.B = b00;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.player.playlist.common.PlaylistCommonSongListComposableKt.topButtonManagingNestedScrollConnection.2.1.onPostFling.2(this.w, this.B, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.player.playlist.common.PlaylistCommonSongListComposableKt.topButtonManagingNestedScrollConnection.2.1.onPostFling.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                ne.a a0 = ne.a.a;
                                switch(this.r) {
                                    case 0: {
                                        d5.n.D(object0);
                                        this.r = 1;
                                        if(DelayKt.delay(this.w, this) == a0) {
                                            return a0;
                                        }
                                        break;
                                    }
                                    case 1: {
                                        d5.n.D(object0);
                                        break;
                                    }
                                    default: {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                }
                                this.B.setValue(Boolean.FALSE);
                                return H.a;
                            }
                        };
                        h0.a = BuildersKt__Builders_commonKt.launch$default(this.d, completableJob0, null, playlistCommonSongListComposableKt$topButtonManagingNestedScrollConnection$2$1$onPostFling$20, 2, null);
                    }
                    return I0.a.super.onPostFling-RZ2iAVY(v, v1, continuation0);
                }

                @Override  // I0.a
                public long onPostScroll-DzOQY0M(long v, long v1, int v2) {
                    return 0L;
                }

                @Override  // I0.a
                public Object onPreFling-QWom1Mo(long v, Continuation continuation0) {
                    if(this.a.c()) {
                        this.b.setValue(Boolean.TRUE);
                    }
                    return I0.a.super.onPreFling-QWom1Mo(v, continuation0);
                }

                @Override  // I0.a
                public long onPreScroll-OzD1aCk(long v, int v1) {
                    return 0L;
                }
            };
            ((p)l0).l0(playlistCommonSongListComposableKt$topButtonManagingNestedScrollConnection$2$11);
            return playlistCommonSongListComposableKt$topButtonManagingNestedScrollConnection$2$11;
        }
        return playlistCommonSongListComposableKt$topButtonManagingNestedScrollConnection$2$10;
    }
}

