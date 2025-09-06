package com.iloen.melon.player.playlist.music.composables;

import Cc.A2;
import Cc.e0;
import Dc.u;
import K.m;
import M.y;
import N0.M;
import O.F;
import O.I;
import P0.h;
import P0.i;
import P0.j;
import Q0.k0;
import U4.x;
import android.content.Context;
import android.net.Uri;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.b;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.iloen.melon.custom.B1;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.player.playlist.common.PlaylistCommonSongListComposableKt;
import com.iloen.melon.player.playlist.common.PlaylistUiExtensionsKt;
import com.iloen.melon.player.playlist.common.SongListItemRightIconType;
import com.iloen.melon.player.playlist.common.scrollbar.AppScrollbarsKt;
import com.iloen.melon.player.playlist.common.scrollbar.ScrollbarExtKt;
import com.iloen.melon.player.playlist.common.scrollbar.ScrollbarState;
import com.iloen.melon.player.playlist.common.scrollbar.ThumbExtKt;
import com.iloen.melon.player.playlist.drawernew.composable.f;
import com.iloen.melon.player.playlist.drawernew.composable.g;
import com.iloen.melon.player.playlist.music.MusicPlaylistUiState.Success;
import com.iloen.melon.player.playlist.music.SongUiState;
import com.iloen.melon.utils.DateUtils;
import h7.u0;
import ie.H;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import je.C;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.StateFlow;
import oc.p0;
import oc.q0;
import oc.r0;
import oc.t0;
import oc.v0;
import oc.w0;
import oc.x0;
import oc.y0;
import oe.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p0.p;
import r0.d;
import we.a;
import we.k;
import we.n;
import we.o;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u001Aß\u0001\u0010\u0013\u001A\u00020\u00072\u0006\u0010\u0001\u001A\u00020\u00002\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u00022\u0012\u0010\b\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0012\u0010\t\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0012\u0010\n\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0012\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0012\u0010\f\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00070\r2\u001C\b\u0002\u0010\u0010\u001A\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000F2\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00070\r2\u001A\b\u0002\u0010\u0012\u001A\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u000FH\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001A\u001B\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0015\u001A\u00020\u0000¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001A"}, d2 = {"Lcom/iloen/melon/player/playlist/music/MusicPlaylistUiState$Success;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "", "isToolbarVisible", "Lkotlin/Function1;", "", "Lie/H;", "onSelectClick", "onClickSongMore", "onClickItem", "onClickThumb", "onLongClickItem", "Lkotlin/Function0;", "onMoveBefore", "Lkotlin/Function2;", "onSwapped", "onTouchDownMoveWhenSelectRepeatOn", "onClickGroupTitle", "MusicSongList", "(Lcom/iloen/melon/player/playlist/music/MusicPlaylistUiState$Success;Lkotlinx/coroutines/flow/StateFlow;Lwe/k;Lwe/k;Lwe/k;Lwe/k;Lwe/k;Lwe/a;Lwe/n;Lwe/a;Lwe/n;Landroidx/compose/runtime/l;III)V", "state", "", "Lcom/iloen/melon/player/playlist/music/composables/SongUiStateWithGroup;", "makeMusicUiList", "(Lcom/iloen/melon/player/playlist/music/MusicPlaylistUiState$Success;)Ljava/util/List;", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class MusicSongListKt {
    public static final void MusicSongList(@NotNull Success musicPlaylistUiState$Success0, @NotNull StateFlow stateFlow0, @NotNull k k0, @NotNull k k1, @NotNull k k2, @NotNull k k3, @NotNull k k4, @NotNull a a0, @Nullable n n0, @NotNull a a1, @Nullable n n1, @Nullable l l0, int v, int v1, int v2) {
        n n8;
        n n7;
        F f2;
        b0 b02;
        r0.n n6;
        V v10;
        p p3;
        n n5;
        Context context1;
        V v9;
        i i2;
        p p2;
        n n3;
        int v4;
        q.g(musicPlaylistUiState$Success0, "uiState");
        q.g(stateFlow0, "isToolbarVisible");
        q.g(k0, "onSelectClick");
        q.g(k1, "onClickSongMore");
        q.g(k2, "onClickItem");
        q.g(k3, "onClickThumb");
        q.g(k4, "onLongClickItem");
        q.g(a0, "onMoveBefore");
        q.g(a1, "onTouchDownMoveWhenSelectRepeatOn");
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0x1CFB05FE);
        int v3 = (v & 6) == 0 ? (p0.i(musicPlaylistUiState$Success0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v3 |= (p0.i(stateFlow0) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v3 |= (p0.i(k0) ? 0x100 : 0x80);
        }
        if((v & 0xC00) == 0) {
            v3 |= (p0.i(k1) ? 0x800 : 0x400);
        }
        if((v & 0x6000) == 0) {
            v3 |= (p0.i(k2) ? 0x4000 : 0x2000);
        }
        if((0x30000 & v) == 0) {
            v3 |= (p0.i(k3) ? 0x20000 : 0x10000);
        }
        if((0x180000 & v) == 0) {
            v3 |= (p0.i(k4) ? 0x100000 : 0x80000);
        }
        if((0xC00000 & v) == 0) {
            v3 |= (p0.i(a0) ? 0x800000 : 0x400000);
        }
        if((v2 & 0x100) != 0) {
            v3 |= 0x6000000;
        }
        else if((v & 0x6000000) == 0) {
            v3 |= (p0.i(n0) ? 0x4000000 : 0x2000000);
        }
        if((v & 0x30000000) == 0) {
            v3 |= (p0.i(a1) ? 0x20000000 : 0x10000000);
        }
        if((v2 & 0x400) == 0) {
            v4 = (v1 & 6) == 0 ? v1 | (p0.i(n1) ? 4 : 2) : v1;
        }
        else {
            v4 = v1 | 6;
        }
        if(p0.Q(v3 & 1, (v3 & 306783379) != 306783378 || (v4 & 3) != 2)) {
            n n2 = (v2 & 0x100) == 0 ? n0 : null;
            V v5 = androidx.compose.runtime.k.a;
            if((v2 & 0x400) == 0) {
                n3 = n1;
            }
            else {
                B1 b10 = p0.N();
                if(b10 == v5) {
                    b10 = new B1(8);
                    p0.l0(b10);
                }
                n3 = b10;
            }
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            F0.a a2 = (F0.a)p0.k(k0.l);
            p p1 = p0.N();
            if(p1 == v5) {
                p1 = new p();
                p0.l0(p1);
            }
            F f0 = I.a(0, 0, 3, p0);
            ScrollbarState scrollbarState0 = ScrollbarExtKt.scrollbarState(f0, p1.size(), null, p0, 0, 2);
            boolean z = p0.i(a2);
            f f1 = p0.N();
            if(z || (0x1C00000 & v3) == 0x800000 || f1 == v5) {
                f1 = new f(a2, a0, 1);
                p0.l0(f1);
            }
            g g0 = p0.N();
            if(g0 == v5) {
                g0 = new g(p1, 1);
                p0.l0(g0);
            }
            A2 a20 = p0.N();
            if((0xE000000 & v3) == 0x4000000 || a20 == v5) {
                p2 = p1;
                a20 = new A2(n2, 4);
                p0.l0(a20);
            }
            else {
                p2 = p1;
            }
            u u0 = u0.P(f0, f1, g0, a20, p0, 0x30000);
            Dc.g g1 = PlaylistCommonSongListComposableKt.getPlaylistCommonItemBgColor(p0, 0);
            boolean z1 = q.b(musicPlaylistUiState$Success0.getSortType(), t0.b);
            SongListItemRightIconType songListItemRightIconType0 = z1 ? SongListItemRightIconType.MOVE : SongListItemRightIconType.MORE;
            boolean z2 = z1 && musicPlaylistUiState$Success0.getSelectRepeatIndices().isEmpty();
            List list0 = MusicSongListKt.makeMusicUiList(musicPlaylistUiState$Success0);
            r0.i i0 = d.a;
            M m0 = M.p.d(i0, false);
            int v6 = p0.P;
            i0 i00 = p0.m();
            r0.q q0 = r0.a.d(p0, androidx.compose.foundation.layout.d.c);
            P0.k.y.getClass();
            FillElement fillElement0 = androidx.compose.foundation.layout.d.c;
            i i1 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, m0, j.f);
            h h0 = j.e;
            w.x(p0, i00, h0);
            h h1 = j.g;
            h h2 = j.f;
            if(p0.O) {
                i2 = i1;
                A7.d.q(v6, p0, v6, h1);
            }
            else {
                i2 = i1;
                if(!q.b(p0.N(), v6)) {
                    A7.d.q(v6, p0, v6, h1);
                }
            }
            h h3 = j.d;
            w.x(p0, q0, h3);
            CoroutineScope coroutineScope0 = p0.N();
            if(coroutineScope0 == v5) {
                coroutineScope0 = J.i(p0);
                p0.l0(coroutineScope0);
            }
            b0 b00 = p0.N();
            if(b00 == v5) {
                b00 = w.s(Boolean.FALSE);
                p0.l0(b00);
            }
            I0.a a3 = PlaylistCommonSongListComposableKt.topButtonManagingNestedScrollConnection(f0, b00, 0L, p0, 0x30, 4);
            y y0 = M.w.a(M.j.c, d.m, p0, 0);
            int v7 = p0.P;
            i0 i01 = p0.m();
            r0.q q1 = r0.a.d(p0, fillElement0);
            p0.e0();
            if(p0.O) {
                p0.l(i2);
            }
            else {
                p0.o0();
            }
            w.x(p0, y0, h2);
            w.x(p0, i01, h0);
            if(p0.O || !q.b(p0.N(), v7)) {
                A7.d.q(v7, p0, v7, h1);
            }
            w.x(p0, q1, h3);
            b0 b01 = B.a.r(stateFlow0, p0, v3 >> 3 & 14);
            r0.q q2 = androidx.compose.foundation.layout.d.f(r0.n.a, 1.0f);
            r0.n n4 = r0.n.a;
            r0.q q3 = x.r(1.0f, q2, true);
            M m1 = M.p.d(i0, false);
            int v8 = p0.P;
            i0 i02 = p0.m();
            r0.q q4 = r0.a.d(p0, q3);
            p0.e0();
            if(p0.O) {
                p0.l(i2);
            }
            else {
                p0.o0();
            }
            w.x(p0, m1, h2);
            w.x(p0, i02, h0);
            if(p0.O || !q.b(p0.N(), v8)) {
                A7.d.q(v8, p0, v8, h1);
            }
            w.x(p0, q4, h3);
            r0.q q5 = e0.R(androidx.compose.ui.input.nestedscroll.a.a(fillElement0, a3, null), f0, 40.0f, true, false, null, 0x30);
            M.i0 i03 = PlaylistCommonSongListComposableKt.getPlaylistCommonListContentPadding();
            boolean z3 = p0.i(u0);
            boolean z4 = p0.g(g1);
            boolean z5 = p0.g(f0);
            boolean z6 = p0.i(musicPlaylistUiState$Success0);
            boolean z7 = p0.h(z2);
            boolean z8 = p0.e(songListItemRightIconType0.ordinal());
            c c0 = p0.N();
            if((((0xE000000 & v3) == 0x4000000 ? 1 : 0) | ((0x1C00000 & v3) == 0x800000 ? 1 : 0) | z3 | z4 | z5 | ((v4 & 14) == 4 ? 1 : 0) | z6 | z7 | z8 | ((v3 & 0xE000) == 0x4000 ? 1 : 0) | ((v3 & 0x380000) == 0x100000 ? 1 : 0) | ((v3 & 0x70000000) == 0x20000000 ? 1 : 0) | ((v3 & 0x1C00) == 0x800 ? 1 : 0) | ((0x70000 & v3) == 0x20000 ? 1 : 0) | ((v3 & 0x380) == 0x100 ? 1 : 0)) == 0) {
                v9 = v5;
                if(c0 == v9) {
                    goto label_167;
                }
                else {
                    context1 = context0;
                    n5 = n3;
                    p3 = p2;
                    v10 = v9;
                    n6 = n4;
                    b02 = b00;
                    f2 = f0;
                }
            }
            else {
                v9 = v5;
            label_167:
                context1 = context0;
                n5 = n3;
                v10 = v9;
                n6 = n4;
                b02 = b00;
                c c1 = new c(p2, a0, n2, u0, g1, f0, n5, musicPlaylistUiState$Success0, z2, songListItemRightIconType0, k2, k4, a1, k1, k3, k0);
                p3 = p2;
                f2 = f0;
                p0.l0(c1);
                c0 = c1;
            }
            ye.a.i(q5, f2, i03, false, null, null, null, false, null, c0, p0, 0x180, 504);
            r0.q q6 = androidx.compose.foundation.layout.d.c(n6, 1.0f);
            r0.q q7 = (b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q6, d.f);
            AppScrollbarsKt.DraggableScrollbar(f2, scrollbarState0, ThumbExtKt.rememberDraggableScroller(f2, list0.size(), p0, 0), q7, p0, 0, 0);
            int v11 = musicPlaylistUiState$Success0.getCurrentIndex();
            SongUiStateWithGroup songUiStateWithGroup0 = (SongUiStateWithGroup)je.p.n0(musicPlaylistUiState$Success0.getCurrentIndex(), list0);
            String s = songUiStateWithGroup0 == null ? null : songUiStateWithGroup0.getTrackId();
            boolean z9 = p0.g(f2);
            boolean z10 = p0.e(v11);
            com.iloen.melon.player.playlist.music.composables.MusicSongListKt.MusicSongList.2.1.1.2.1 musicSongListKt$MusicSongList$2$1$1$2$10 = p0.N();
            if(z9 || z10 || musicSongListKt$MusicSongList$2$1$1$2$10 == v10) {
                musicSongListKt$MusicSongList$2$1$1$2$10 = new n(f2, v11, null) {
                    public final int B;
                    public int r;
                    public final F w;

                    {
                        this.w = f0;
                        this.B = v;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.player.playlist.music.composables.MusicSongListKt.MusicSongList.2.1.1.2.1(this.w, this.B, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.player.playlist.music.composables.MusicSongListKt.MusicSongList.2.1.1.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        ne.a a0 = ne.a.a;
                        switch(this.r) {
                            case 0: {
                                d5.n.D(object0);
                                this.r = 1;
                                if(DelayKt.delay(100L, this) == a0) {
                                    return a0;
                                }
                                break;
                            }
                            case 1: {
                                d5.n.D(object0);
                                break;
                            }
                            case 2: {
                                d5.n.D(object0);
                                return H.a;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                        this.r = 2;
                        return PlaylistCommonSongListComposableKt.scrollToCurrentWhenInvisible$default(this.w, this.B, 0, this, 4, null) == a0 ? a0 : H.a;
                    }
                };
                p0.l0(musicSongListKt$MusicSongList$2$1$1$2$10);
            }
            J.d(p0, s, musicSongListKt$MusicSongList$2$1$1$2$10);
            y0 y00 = musicPlaylistUiState$Success0.getSortType();
            boolean z11 = p0.g(f2);
            boolean z12 = p0.e(v11);
            com.iloen.melon.player.playlist.music.composables.MusicSongListKt.MusicSongList.2.1.1.3.1 musicSongListKt$MusicSongList$2$1$1$3$10 = p0.N();
            if(z11 || z12 || musicSongListKt$MusicSongList$2$1$1$3$10 == v10) {
                musicSongListKt$MusicSongList$2$1$1$3$10 = new n(f2, v11, null) {
                    public final int B;
                    public int r;
                    public final F w;

                    {
                        this.w = f0;
                        this.B = v;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.player.playlist.music.composables.MusicSongListKt.MusicSongList.2.1.1.3.1(this.w, this.B, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.player.playlist.music.composables.MusicSongListKt.MusicSongList.2.1.1.3.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        ne.a a0 = ne.a.a;
                        switch(this.r) {
                            case 0: {
                                d5.n.D(object0);
                                this.r = 1;
                                if(DelayKt.delay(100L, this) == a0) {
                                    return a0;
                                }
                                break;
                            }
                            case 1: {
                                d5.n.D(object0);
                                break;
                            }
                            case 2: {
                                d5.n.D(object0);
                                return H.a;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                        this.r = 2;
                        return PlaylistCommonSongListComposableKt.scrollToCurrentWhenInvisible$default(this.w, this.B, 0, this, 4, null) == a0 ? a0 : H.a;
                    }
                };
                p0.l0(musicSongListKt$MusicSongList$2$1$1$3$10);
            }
            J.d(p0, y00, musicSongListKt$MusicSongList$2$1$1$3$10);
            p0.p(true);
            if(((Boolean)b01.getValue()).booleanValue()) {
                p0.a0(0xB5FC033);
                M.c.d(p0, androidx.compose.foundation.layout.d.h(n6, E9.h.t(p0, 0x7F070464)));  // dimen:toolbar_height
            }
            else {
                p0.a0(177394400);
            }
            p0.p(false);
            p0.p(true);
            U8.F f3 = p0.N();
            if(f3 == v10) {
                f3 = new U8.F(b02, 5);
                p0.l0(f3);
            }
            boolean z13 = p0.i(coroutineScope0);
            boolean z14 = p0.g(f2);
            boolean z15 = p0.i(context1);
            com.iloen.melon.player.playlist.drawernew.composable.i i3 = p0.N();
            if((z13 | z14 | z15) != 0 || i3 == v10) {
                i3 = new com.iloen.melon.player.playlist.drawernew.composable.i(coroutineScope0, f2, context1, 1);
                p0.l0(i3);
            }
            PlaylistCommonSongListComposableKt.PlaylistTopBtn(f3, i3, p0, 6);
            p0.p(true);
            boolean z16 = p0.i(list0);
            com.iloen.melon.player.playlist.music.composables.MusicSongListKt.MusicSongList.3.1 musicSongListKt$MusicSongList$3$10 = p0.N();
            if(z16 || musicSongListKt$MusicSongList$3$10 == v10) {
                musicSongListKt$MusicSongList$3$10 = new n(p3, list0, null) {
                    public final p r;
                    public final List w;

                    {
                        this.r = p0;
                        this.w = list0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.player.playlist.music.composables.MusicSongListKt.MusicSongList.3.1(this.r, this.w, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.player.playlist.music.composables.MusicSongListKt.MusicSongList.3.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        d5.n.D(object0);
                        this.r.clear();
                        this.r.addAll(this.w);
                        return H.a;
                    }
                };
                p0.l0(musicSongListKt$MusicSongList$3$10);
            }
            J.d(p0, list0, musicSongListKt$MusicSongList$3$10);
            n7 = n5;
            n8 = n2;
        }
        else {
            p0.T();
            n8 = n0;
            n7 = n1;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.player.playlist.music.composables.d(musicPlaylistUiState$Success0, stateFlow0, k0, k1, k2, k3, k4, a0, n8, a1, n7, v, v1, v2);
        }

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.music.composables.MusicSongListKt.MusicSongList.2.1.1.1.1.2.1 implements we.p {
            public final SongUiStateWithGroup a;
            public final F b;
            public final n c;
            public final int d;
            public final Success e;
            public final boolean f;
            public final k g;
            public final k h;
            public final SongListItemRightIconType i;
            public final k j;
            public final k k;
            public final a l;
            public final k m;
            public final k n;
            public final k o;

            public com.iloen.melon.player.playlist.music.composables.MusicSongListKt.MusicSongList.2.1.1.1.1.2.1(SongUiStateWithGroup songUiStateWithGroup0, F f0, n n0, int v, Success musicPlaylistUiState$Success0, boolean z, k k0, k k1, SongListItemRightIconType songListItemRightIconType0, k k2, k k3, a a0, k k4, k k5, k k6) {
                this.a = songUiStateWithGroup0;
                this.b = f0;
                this.c = n0;
                this.d = v;
                this.e = musicPlaylistUiState$Success0;
                this.f = z;
                this.g = k0;
                this.h = k1;
                this.i = songListItemRightIconType0;
                this.j = k2;
                this.k = k3;
                this.l = a0;
                this.m = k4;
                this.n = k5;
                this.o = k6;
            }

            @Override  // we.p
            public Object invoke(Object object0, Object object1, Object object2, Object object3) {
                this.invoke(((Dc.h)object0), ((Boolean)object1).booleanValue(), ((l)object2), ((Number)object3).intValue());
                return H.a;
            }

            public final void invoke(Dc.h h0, boolean z, l l0, int v) {
                a a1;
                a a0;
                r0.q q2;
                String s3;
                q.g(h0, "$this$MovableItem");
                int v1 = (v & 6) == 0 ? v | (((v & 8) == 0 ? ((androidx.compose.runtime.p)l0).g(h0) : ((androidx.compose.runtime.p)l0).i(h0)) ? 4 : 2) : v;
                androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
                if(p0.Q(v1 & 1, (v1 & 0x83) != 130)) {
                    r0.q q0 = Dc.h.a(h0, false, 15);
                    y y0 = M.w.a(M.j.c, d.m, p0, 0);
                    int v2 = p0.P;
                    i0 i00 = p0.m();
                    r0.q q1 = r0.a.d(p0, r0.n.a);
                    P0.k.y.getClass();
                    i i0 = j.b;
                    p0.e0();
                    if(p0.O) {
                        p0.l(i0);
                    }
                    else {
                        p0.o0();
                    }
                    w.x(p0, y0, j.f);
                    w.x(p0, i00, j.e);
                    h h1 = j.g;
                    if(p0.O || !q.b(p0.N(), v2)) {
                        A7.d.q(v2, p0, v2, h1);
                    }
                    w.x(p0, q1, j.d);
                    SongUiStateWithGroup songUiStateWithGroup0 = this.a;
                    V v3 = androidx.compose.runtime.k.a;
                    F f0 = this.b;
                    if(songUiStateWithGroup0.getGroupTitleState() == null) {
                        p0.a0(0xA20335BA);
                    }
                    else {
                        p0.a0(0xA27D9033);
                        String s = songUiStateWithGroup0.getGroupTitleState().getTitle();
                        int v4 = songUiStateWithGroup0.getGroupTitleState().getCount();
                        boolean z1 = p0.g(f0);
                        boolean z2 = p0.i(songUiStateWithGroup0);
                        n n0 = this.c;
                        boolean z3 = p0.g(n0);
                        int v5 = this.d;
                        boolean z4 = p0.e(v5);
                        com.iloen.melon.player.playlist.music.composables.MusicSongListKt.MusicSongList.2.1.1.1.1.2.1.1.1.1 musicSongListKt$MusicSongList$2$1$1$1$1$2$1$1$1$10 = p0.N();
                        if((z1 | z2 | z3 | z4) != 0 || musicSongListKt$MusicSongList$2$1$1$1$1$2$1$1$1$10 == v3) {
                            musicSongListKt$MusicSongList$2$1$1$1$1$2$1$1$1$10 = new k() {
                                public final F a;
                                public final SongUiStateWithGroup b;
                                public final n c;
                                public final int d;

                                {
                                    F f0 = songUiStateWithGroup0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                                    SongUiStateWithGroup songUiStateWithGroup0 = n0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                                    n n0 = v5;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                                    this.a = f0;
                                    this.b = songUiStateWithGroup0;
                                    this.c = n0;
                                    this.d = v;
                                }

                                @Override  // we.k
                                public Object invoke(Object object0) {
                                    this.invoke(((Number)object0).intValue());
                                    return H.a;
                                }

                                public final void invoke(int v) {
                                    if(PlaylistUiExtensionsKt.getPositionFromKey(this.a, this.b.getTrackId()) != null) {
                                        this.c.invoke(this.d, v);
                                    }
                                }
                            };
                            p0.l0(musicSongListKt$MusicSongList$2$1$1$1$1$2$1$1$1$10);
                        }
                        PlaylistCommonSongListComposableKt.GroupTitle(s, v4, musicSongListKt$MusicSongList$2$1$1$1$1$2$1$1$1$10, p0, 0, 0);
                    }
                    p0.p(false);
                    String s1 = songUiStateWithGroup0.getSongName();
                    String s2 = songUiStateWithGroup0.getArtistName();
                    Uri uri0 = songUiStateWithGroup0.getThumbnailUrl();
                    if(uri0 == null) {
                        s3 = "";
                    }
                    else {
                        s3 = uri0.toString();
                        if(s3 == null) {
                            s3 = "";
                        }
                    }
                    boolean z5 = this.e.isCurrentPlaylist();
                    boolean z6 = songUiStateWithGroup0.getHasFocus();
                    boolean z7 = songUiStateWithGroup0.isPlayingAnimation();
                    boolean z8 = songUiStateWithGroup0.isChecked();
                    boolean z9 = songUiStateWithGroup0.isSelectedForSelectRepeat();
                    boolean z10 = songUiStateWithGroup0.isAdult();
                    Integer integer0 = songUiStateWithGroup0.getFileTypeDrawableResId();
                    boolean z11 = songUiStateWithGroup0.isMarquee();
                    boolean z12 = songUiStateWithGroup0.getShowOfflineIcon();
                    boolean z13 = this.f;
                    if(z13) {
                        p0.a0(0xA2B140B8);
                        boolean z14 = p0.g(f0);
                        boolean z15 = p0.i(songUiStateWithGroup0);
                        k k0 = this.g;
                        boolean z16 = p0.g(k0);
                        q2 = q0;
                        com.iloen.melon.player.playlist.music.composables.MusicSongListKt.MusicSongList.2.1.1.1.1.2.1.1.2.1 musicSongListKt$MusicSongList$2$1$1$1$1$2$1$1$2$10 = p0.N();
                        if((z14 | z15 | z16) != 0 || musicSongListKt$MusicSongList$2$1$1$1$1$2$1$1$2$10 == v3) {
                            musicSongListKt$MusicSongList$2$1$1$1$1$2$1$1$2$10 = new a() {
                                public final F a;
                                public final SongUiStateWithGroup b;
                                public final k c;

                                {
                                    F f0 = songUiStateWithGroup0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                                    SongUiStateWithGroup songUiStateWithGroup0 = k0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                                    this.a = f0;
                                    this.b = songUiStateWithGroup0;
                                    this.c = k0;
                                }

                                @Override  // we.a
                                public Object invoke() {
                                    this.invoke();
                                    return H.a;
                                }

                                public final void invoke() {
                                    Integer integer0 = PlaylistUiExtensionsKt.getPositionFromKey(this.a, this.b.getTrackId());
                                    if(integer0 != null) {
                                        this.c.invoke(integer0);
                                    }
                                }
                            };
                            p0.l0(musicSongListKt$MusicSongList$2$1$1$1$1$2$1$1$2$10);
                        }
                        p0.p(false);
                        a0 = musicSongListKt$MusicSongList$2$1$1$1$1$2$1$1$2$10;
                    }
                    else {
                        q2 = q0;
                        p0.a0(0xA2B61135);
                        p0.p(false);
                        a0 = null;
                    }
                    if(z13) {
                        p0.a0(-1565023178);
                        boolean z17 = p0.g(f0);
                        boolean z18 = p0.i(songUiStateWithGroup0);
                        k k1 = this.h;
                        boolean z19 = p0.g(k1);
                        com.iloen.melon.player.playlist.music.composables.MusicSongListKt.MusicSongList.2.1.1.1.1.2.1.1.3.1 musicSongListKt$MusicSongList$2$1$1$1$1$2$1$1$3$10 = p0.N();
                        if((z17 | z18 | z19) != 0 || musicSongListKt$MusicSongList$2$1$1$1$1$2$1$1$3$10 == v3) {
                            musicSongListKt$MusicSongList$2$1$1$1$1$2$1$1$3$10 = new a() {
                                public final F a;
                                public final SongUiStateWithGroup b;
                                public final k c;

                                {
                                    F f0 = songUiStateWithGroup0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                                    SongUiStateWithGroup songUiStateWithGroup0 = k1;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                                    this.a = f0;
                                    this.b = songUiStateWithGroup0;
                                    this.c = k0;
                                }

                                @Override  // we.a
                                public Object invoke() {
                                    this.invoke();
                                    return H.a;
                                }

                                public final void invoke() {
                                    Integer integer0 = PlaylistUiExtensionsKt.getPositionFromKey(this.a, this.b.getTrackId());
                                    if(integer0 != null) {
                                        this.c.invoke(integer0);
                                    }
                                }
                            };
                            p0.l0(musicSongListKt$MusicSongList$2$1$1$1$1$2$1$1$3$10);
                        }
                        p0.p(false);
                        a1 = musicSongListKt$MusicSongList$2$1$1$1$1$2$1$1$3$10;
                    }
                    else {
                        p0.a0(-1564705739);
                        p0.p(false);
                        a1 = null;
                    }
                    boolean z20 = p0.g(f0);
                    boolean z21 = p0.i(songUiStateWithGroup0);
                    k k2 = this.j;
                    boolean z22 = p0.g(k2);
                    com.iloen.melon.player.playlist.music.composables.MusicSongListKt.MusicSongList.2.1.1.1.1.2.1.1.4.1 musicSongListKt$MusicSongList$2$1$1$1$1$2$1$1$4$10 = p0.N();
                    if((z20 | z21 | z22) != 0 || musicSongListKt$MusicSongList$2$1$1$1$1$2$1$1$4$10 == v3) {
                        musicSongListKt$MusicSongList$2$1$1$1$1$2$1$1$4$10 = new a() {
                            public final F a;
                            public final SongUiStateWithGroup b;
                            public final k c;

                            {
                                F f0 = songUiStateWithGroup0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                                SongUiStateWithGroup songUiStateWithGroup0 = k2;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                                this.a = f0;
                                this.b = songUiStateWithGroup0;
                                this.c = k0;
                            }

                            @Override  // we.a
                            public Object invoke() {
                                this.invoke();
                                return H.a;
                            }

                            public final void invoke() {
                                Integer integer0 = PlaylistUiExtensionsKt.getPositionFromKey(this.a, this.b.getTrackId());
                                if(integer0 != null) {
                                    this.c.invoke(integer0);
                                }
                            }
                        };
                        p0.l0(musicSongListKt$MusicSongList$2$1$1$1$1$2$1$1$4$10);
                    }
                    boolean z23 = p0.g(f0);
                    boolean z24 = p0.i(songUiStateWithGroup0);
                    k k3 = this.k;
                    boolean z25 = p0.g(k3);
                    com.iloen.melon.player.playlist.music.composables.MusicSongListKt.MusicSongList.2.1.1.1.1.2.1.1.5.1 musicSongListKt$MusicSongList$2$1$1$1$1$2$1$1$5$10 = p0.N();
                    if((z23 | z24 | z25) != 0 || musicSongListKt$MusicSongList$2$1$1$1$1$2$1$1$5$10 == v3) {
                        musicSongListKt$MusicSongList$2$1$1$1$1$2$1$1$5$10 = new a() {
                            public final F a;
                            public final SongUiStateWithGroup b;
                            public final k c;

                            {
                                F f0 = songUiStateWithGroup0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                                SongUiStateWithGroup songUiStateWithGroup0 = k3;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                                this.a = f0;
                                this.b = songUiStateWithGroup0;
                                this.c = k0;
                            }

                            @Override  // we.a
                            public Object invoke() {
                                this.invoke();
                                return H.a;
                            }

                            public final void invoke() {
                                Integer integer0 = PlaylistUiExtensionsKt.getPositionFromKey(this.a, this.b.getTrackId());
                                if(integer0 != null) {
                                    this.c.invoke(integer0);
                                }
                            }
                        };
                        p0.l0(musicSongListKt$MusicSongList$2$1$1$1$1$2$1$1$5$10);
                    }
                    a a2 = this.l;
                    boolean z26 = p0.g(a2);
                    com.iloen.melon.player.playlist.music.composables.MusicSongListKt.MusicSongList.2.1.1.1.1.2.1.1.6.1 musicSongListKt$MusicSongList$2$1$1$1$1$2$1$1$6$10 = p0.N();
                    if(z26 || musicSongListKt$MusicSongList$2$1$1$1$1$2$1$1$6$10 == v3) {
                        musicSongListKt$MusicSongList$2$1$1$1$1$2$1$1$6$10 = new a() {
                            public final a a;

                            {
                                this.a = a0;
                            }

                            @Override  // we.a
                            public Object invoke() {
                                this.invoke();
                                return H.a;
                            }

                            public final void invoke() {
                                this.a.invoke();
                            }
                        };
                        p0.l0(musicSongListKt$MusicSongList$2$1$1$1$1$2$1$1$6$10);
                    }
                    boolean z27 = p0.g(f0);
                    boolean z28 = p0.i(songUiStateWithGroup0);
                    k k4 = this.m;
                    boolean z29 = p0.g(k4);
                    com.iloen.melon.player.playlist.music.composables.MusicSongListKt.MusicSongList.2.1.1.1.1.2.1.1.7.1 musicSongListKt$MusicSongList$2$1$1$1$1$2$1$1$7$10 = p0.N();
                    if((z27 | z28 | z29) != 0 || musicSongListKt$MusicSongList$2$1$1$1$1$2$1$1$7$10 == v3) {
                        musicSongListKt$MusicSongList$2$1$1$1$1$2$1$1$7$10 = new a() {
                            public final F a;
                            public final SongUiStateWithGroup b;
                            public final k c;

                            {
                                F f0 = songUiStateWithGroup0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                                SongUiStateWithGroup songUiStateWithGroup0 = k4;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                                this.a = f0;
                                this.b = songUiStateWithGroup0;
                                this.c = k0;
                            }

                            @Override  // we.a
                            public Object invoke() {
                                this.invoke();
                                return H.a;
                            }

                            public final void invoke() {
                                Integer integer0 = PlaylistUiExtensionsKt.getPositionFromKey(this.a, this.b.getTrackId());
                                if(integer0 != null) {
                                    this.c.invoke(integer0);
                                }
                            }
                        };
                        p0.l0(musicSongListKt$MusicSongList$2$1$1$1$1$2$1$1$7$10);
                    }
                    boolean z30 = p0.g(f0);
                    boolean z31 = p0.i(songUiStateWithGroup0);
                    k k5 = this.n;
                    boolean z32 = p0.g(k5);
                    com.iloen.melon.player.playlist.music.composables.MusicSongListKt.MusicSongList.2.1.1.1.1.2.1.1.8.1 musicSongListKt$MusicSongList$2$1$1$1$1$2$1$1$8$10 = p0.N();
                    if((z30 | z31 | z32) != 0 || musicSongListKt$MusicSongList$2$1$1$1$1$2$1$1$8$10 == v3) {
                        musicSongListKt$MusicSongList$2$1$1$1$1$2$1$1$8$10 = new a() {
                            public final F a;
                            public final SongUiStateWithGroup b;
                            public final k c;

                            {
                                F f0 = songUiStateWithGroup0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                                SongUiStateWithGroup songUiStateWithGroup0 = k5;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                                this.a = f0;
                                this.b = songUiStateWithGroup0;
                                this.c = k0;
                            }

                            @Override  // we.a
                            public Object invoke() {
                                this.invoke();
                                return H.a;
                            }

                            public final void invoke() {
                                Integer integer0 = PlaylistUiExtensionsKt.getPositionFromKey(this.a, this.b.getTrackId());
                                if(integer0 != null) {
                                    this.c.invoke(integer0);
                                }
                            }
                        };
                        p0.l0(musicSongListKt$MusicSongList$2$1$1$1$1$2$1$1$8$10);
                    }
                    boolean z33 = p0.g(f0);
                    boolean z34 = p0.i(songUiStateWithGroup0);
                    k k6 = this.o;
                    boolean z35 = p0.g(k6);
                    com.iloen.melon.player.playlist.music.composables.MusicSongListKt.MusicSongList.2.1.1.1.1.2.1.1.9.1 musicSongListKt$MusicSongList$2$1$1$1$1$2$1$1$9$10 = p0.N();
                    if((z33 | z34 | z35) != 0 || musicSongListKt$MusicSongList$2$1$1$1$1$2$1$1$9$10 == v3) {
                        musicSongListKt$MusicSongList$2$1$1$1$1$2$1$1$9$10 = new a() {
                            public final F a;
                            public final SongUiStateWithGroup b;
                            public final k c;

                            {
                                F f0 = songUiStateWithGroup0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                                SongUiStateWithGroup songUiStateWithGroup0 = k6;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                                this.a = f0;
                                this.b = songUiStateWithGroup0;
                                this.c = k0;
                            }

                            @Override  // we.a
                            public Object invoke() {
                                this.invoke();
                                return H.a;
                            }

                            public final void invoke() {
                                Integer integer0 = PlaylistUiExtensionsKt.getPositionFromKey(this.a, this.b.getTrackId());
                                if(integer0 != null) {
                                    this.c.invoke(integer0);
                                }
                            }
                        };
                        p0.l0(musicSongListKt$MusicSongList$2$1$1$1$1$2$1$1$9$10);
                    }
                    PlaylistCommonSongListComposableKt.SongListItem(null, q2, s1, s2, s3, z5, z6, z7, z8, z9, z10, integer0, z12, this.i, z13, z11, musicSongListKt$MusicSongList$2$1$1$1$1$2$1$1$4$10, musicSongListKt$MusicSongList$2$1$1$1$1$2$1$1$5$10, musicSongListKt$MusicSongList$2$1$1$1$1$2$1$1$6$10, musicSongListKt$MusicSongList$2$1$1$1$1$2$1$1$7$10, musicSongListKt$MusicSongList$2$1$1$1$1$2$1$1$8$10, musicSongListKt$MusicSongList$2$1$1$1$1$2$1$1$9$10, a0, a1, p0, 0, 0, 0, 1);
                    p0.p(true);
                    return;
                }
                p0.T();
            }
        }


        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
        @e(c = "com.iloen.melon.player.playlist.music.composables.MusicSongListKt$MusicSongList$2$3$1$1$1", f = "MusicSongList.kt", l = {291}, m = "invokeSuspend")
        final class com.iloen.melon.player.playlist.music.composables.MusicSongListKt.MusicSongList.2.3.1.1.1 extends oe.i implements n {
            public int r;
            public final F w;

            public com.iloen.melon.player.playlist.music.composables.MusicSongListKt.MusicSongList.2.3.1.1.1(F f0, Continuation continuation0) {
                this.w = f0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.music.composables.MusicSongListKt.MusicSongList.2.3.1.1.1(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.music.composables.MusicSongListKt.MusicSongList.2.3.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        this.r = 1;
                        return this.w.j(0, 0, this) == a0 ? a0 : H.a;
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
        }


        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0006\u001A\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "", "index", "", "invoke", "(I)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 2, 0})
        public final class com.iloen.melon.player.playlist.music.composables.MusicSongListKt.MusicSongList.lambda.26.lambda.19.lambda.18.lambda.15.lambda.14..inlined.itemsIndexed.default.1 extends r implements k {
            public final n f;
            public final List g;

            public com.iloen.melon.player.playlist.music.composables.MusicSongListKt.MusicSongList.lambda.26.lambda.19.lambda.18.lambda.15.lambda.14..inlined.itemsIndexed.default.1(n n0, List list0) {
                this.f = n0;
                this.g = list0;
                super(1);
            }

            public final Object invoke(int v) {
                Object object0 = this.g.get(v);
                return this.f.invoke(v, object0);
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                return this.invoke(((Number)object0).intValue());
            }
        }


        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0006\u001A\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "", "index", "", "invoke", "(I)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 2, 0})
        public final class com.iloen.melon.player.playlist.music.composables.MusicSongListKt.MusicSongList.lambda.26.lambda.19.lambda.18.lambda.15.lambda.14..inlined.itemsIndexed.default.2 extends r implements k {
            public final List f;

            public com.iloen.melon.player.playlist.music.composables.MusicSongListKt.MusicSongList.lambda.26.lambda.19.lambda.18.lambda.15.lambda.14..inlined.itemsIndexed.default.2(List list0) {
                this.f = list0;
                super(1);
            }

            public final Object invoke(int v) {
                this.f.get(v);
                return null;
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                return this.invoke(((Number)object0).intValue());
            }
        }


        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001A\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0002H\u000B¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "Landroidx/compose/foundation/lazy/a;", "", "it", "Lie/H;", "invoke", "(Landroidx/compose/foundation/lazy/a;ILandroidx/compose/runtime/l;I)V", "<anonymous>"}, k = 3, mv = {2, 2, 0})
        public final class com.iloen.melon.player.playlist.music.composables.MusicSongListKt.MusicSongList.lambda.26.lambda.19.lambda.18.lambda.15.lambda.14..inlined.itemsIndexed.default.3 extends r implements we.p {
            public final a B;
            public final k D;
            public final k E;
            public final k G;
            public final List f;
            public final u g;
            public final Dc.g h;
            public final F i;
            public final n j;
            public final Success k;
            public final boolean l;
            public final k m;
            public final k n;
            public final SongListItemRightIconType o;
            public final k r;
            public final k w;

            public com.iloen.melon.player.playlist.music.composables.MusicSongListKt.MusicSongList.lambda.26.lambda.19.lambda.18.lambda.15.lambda.14..inlined.itemsIndexed.default.3(List list0, u u0, Dc.g g0, F f0, n n0, Success musicPlaylistUiState$Success0, boolean z, k k0, k k1, SongListItemRightIconType songListItemRightIconType0, k k2, k k3, a a0, k k4, k k5, k k6) {
                this.f = list0;
                this.g = u0;
                this.h = g0;
                this.i = f0;
                this.j = n0;
                this.k = musicPlaylistUiState$Success0;
                this.l = z;
                this.m = k0;
                this.n = k1;
                this.o = songListItemRightIconType0;
                this.r = k2;
                this.w = k3;
                this.B = a0;
                this.D = k4;
                this.E = k5;
                this.G = k6;
                super(4);
            }

            @Override  // we.p
            public Object invoke(Object object0, Object object1, Object object2, Object object3) {
                this.invoke(((androidx.compose.foundation.lazy.a)object0), ((Number)object1).intValue(), ((l)object2), ((Number)object3).intValue());
                return H.a;
            }

            public final void invoke(androidx.compose.foundation.lazy.a a0, int v, l l0, int v1) {
                int v2 = (v1 & 6) == 0 ? v1 | (((androidx.compose.runtime.p)l0).g(a0) ? 4 : 2) : v1;
                if((v1 & 0x30) == 0) {
                    v2 |= (((androidx.compose.runtime.p)l0).e(v) ? 0x20 : 16);
                }
                if(((androidx.compose.runtime.p)l0).Q(v2 & 1, (v2 & 0x93) != 0x92)) {
                    SongUiStateWithGroup songUiStateWithGroup0 = (SongUiStateWithGroup)this.f.get(v);
                    ((androidx.compose.runtime.p)l0).a0(0x20372063);
                    m0.b b0 = m0.c.e(0xF3197D72, ((androidx.compose.runtime.p)l0), new com.iloen.melon.player.playlist.music.composables.MusicSongListKt.MusicSongList.2.1.1.1.1.2.1(songUiStateWithGroup0, this.i, this.j, v, this.k, this.l, this.m, this.n, this.o, this.r, this.w, this.B, this.D, this.E, this.G));
                    u0.e(a0, this.g, songUiStateWithGroup0.getTrackId(), null, false, this.h, b0, ((androidx.compose.runtime.p)l0), v2 & 14 | 0x180000);
                    ((androidx.compose.runtime.p)l0).p(false);
                    return;
                }
                ((androidx.compose.runtime.p)l0).T();
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.player.playlist.music.composables.MusicSongListKt.MusicSongList.lambda.26.lambda.25.lambda.24..inlined.noRippleClickable-YQRRFTQ.default.1 implements o {
            public com.iloen.melon.player.playlist.music.composables.MusicSongListKt.MusicSongList.lambda.26.lambda.25.lambda.24..inlined.noRippleClickable-YQRRFTQ.default.1(boolean z, String s, int v, CoroutineScope coroutineScope0, F f0) {
            }

            @Override  // we.o
            public Object invoke(Object object0, Object object1, Object object2) {
                return this.invoke(((r0.q)object0), ((l)object1), ((Number)object2).intValue());
            }

            public final r0.q invoke(r0.q q0, l l0, int v) {
                q.g(q0, "$this$composed");
                ((androidx.compose.runtime.p)l0).a0(0x1FF03545);
                w0.h h0 = (w0.h)((androidx.compose.runtime.p)l0).k(k0.i);
                m m0 = ((androidx.compose.runtime.p)l0).N();
                if(m0 == androidx.compose.runtime.k.a) {
                    m0 = androidx.appcompat.app.o.d(((androidx.compose.runtime.p)l0));
                }
                X0.i i0 = new X0.i(this.c);
                com.iloen.melon.player.playlist.music.composables.MusicSongListKt.MusicSongList.lambda.26.lambda.25.lambda.24..inlined.noRippleClickable-YQRRFTQ.default.1.1 musicSongListKt$MusicSongList$lambda$26$lambda$25$lambda$24$$inlined$noRippleClickable-YQRRFTQ$default$1$10 = new a() {
                    @Override  // we.a
                    public Object invoke() {
                        this.invoke();
                        return H.a;
                    }

                    public final void invoke() {
                        w0.h.a(this.d);
                        com.iloen.melon.player.playlist.music.composables.MusicSongListKt.MusicSongList.2.3.1.1.1 musicSongListKt$MusicSongList$2$3$1$1$10 = new com.iloen.melon.player.playlist.music.composables.MusicSongListKt.MusicSongList.2.3.1.1.1(this.c, null);
                        BuildersKt__Builders_commonKt.launch$default(this.e, null, null, musicSongListKt$MusicSongList$2$3$1$1$10, 3, null);
                    }
                };
                r0.q q1 = androidx.compose.foundation.q.l(q0, m0, null, this.a, this.b, i0, musicSongListKt$MusicSongList$lambda$26$lambda$25$lambda$24$$inlined$noRippleClickable-YQRRFTQ$default$1$10);
                ((androidx.compose.runtime.p)l0).p(false);
                return q1;
            }
        }

    }

    @NotNull
    public static final List makeMusicUiList(@NotNull Success musicPlaylistUiState$Success0) {
        GroupTitleState groupTitleState0;
        q.g(musicPlaylistUiState$Success0, "state");
        Iterable iterable0 = musicPlaylistUiState$Success0.getSongList();
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, iterable0));
        for(Object object0: iterable0) {
            arrayList0.add(((SongUiState)object0).getPlayable());
        }
        y0 y00 = musicPlaylistUiState$Success0.getSortType();
        LinkedHashMap linkedHashMap0 = new LinkedHashMap();
        if(q.b(y00, oc.u0.b) || q.b(y00, v0.b)) {
            int v3 = 0;
            for(Object object1: arrayList0) {
                if(v3 >= 0) {
                    String s = DateUtils.convertDateFormat(((Playable)object1).getCreatedAt(), "yyyy. MM. dd");
                    if(linkedHashMap0.containsKey(s)) {
                        List list3 = (List)linkedHashMap0.get(s);
                        if(list3 != null) {
                            list3.add(v3);
                        }
                    }
                    else {
                        linkedHashMap0.put(s, e.k.C(new Integer[]{v3}));
                    }
                    ++v3;
                    continue;
                }
                e.k.O();
                throw null;
            }
        }
        else if(q.b(y00, q0.b) || q.b(y00, r0.b)) {
            int v2 = 0;
            Iterator iterator3 = arrayList0.iterator();
            while(iterator3.hasNext()) {
                iterator3.next();
                if(v2 >= 0) {
                    if(linkedHashMap0.containsKey("")) {
                        List list2 = (List)linkedHashMap0.get("");
                        if(list2 != null) {
                            list2.add(v2);
                        }
                    }
                    else {
                        linkedHashMap0.put("", e.k.C(new Integer[]{v2}));
                    }
                    ++v2;
                    continue;
                }
                e.k.O();
                throw null;
            }
        }
        else if(q.b(y00, w0.b) || q.b(y00, x0.b)) {
            int v1 = 0;
            Iterator iterator2 = arrayList0.iterator();
            while(iterator2.hasNext()) {
                iterator2.next();
                if(v1 >= 0) {
                    if(linkedHashMap0.containsKey("#")) {
                        List list1 = (List)linkedHashMap0.get("#");
                        if(list1 != null) {
                            list1.add(v1);
                        }
                    }
                    else {
                        linkedHashMap0.put("#", e.k.C(new Integer[]{v1}));
                    }
                    ++v1;
                    continue;
                }
                e.k.O();
                throw null;
            }
        }
        else if(q.b(y00, p0.b)) {
            int v = 0;
            Iterator iterator1 = arrayList0.iterator();
            while(iterator1.hasNext()) {
                iterator1.next();
                if(v >= 0) {
                    if(linkedHashMap0.containsKey("")) {
                        List list0 = (List)linkedHashMap0.get("");
                        if(list0 != null) {
                            list0.add(v);
                        }
                    }
                    else {
                        linkedHashMap0.put("", e.k.C(new Integer[]{v}));
                    }
                    ++v;
                    continue;
                }
                e.k.O();
                throw null;
            }
        }
        LinkedHashMap linkedHashMap1 = new LinkedHashMap();
        for(Object object2: linkedHashMap0.entrySet()) {
            String s1 = (String)((Map.Entry)object2).getKey();
            linkedHashMap1.put(je.p.k0(((List)((Map.Entry)object2).getValue())), s1);
        }
        GroupTitleData groupTitleData0 = new GroupTitleData(linkedHashMap0, C.Z(linkedHashMap1));
        Iterable iterable1 = musicPlaylistUiState$Success0.getSongList();
        List list4 = new ArrayList(je.q.Q(10, iterable1));
        int v4 = 0;
        for(Object object3: iterable1) {
            if(v4 >= 0) {
                if(groupTitleData0.getFirstIndexTitleMap().containsKey(v4)) {
                    String s2 = (String)groupTitleData0.getFirstIndexTitleMap().get(v4);
                    if(s2 == null) {
                        s2 = "";
                    }
                    List list5 = (List)groupTitleData0.getTitleIndicesMap().get(s2);
                    groupTitleState0 = new GroupTitleState(s2, (list5 == null ? 0 : list5.size()));
                }
                else {
                    groupTitleState0 = null;
                }
                q.f("", "getTrackId(...)");
                boolean z = ((SongUiState)object3).isMarquee();
                ((ArrayList)list4).add(new SongUiStateWithGroup("", groupTitleState0, ((SongUiState)object3).isSelected(), musicPlaylistUiState$Success0.getSelectRepeatIndices().contains(v4), ((SongUiState)object3).getThumbnailUri(), ((SongUiState)object3).getSongName(), ((SongUiState)object3).getArtistName(), v4 == musicPlaylistUiState$Success0.getCurrentIndex(), musicPlaylistUiState$Success0.isCurrentPlaylist() && v4 == musicPlaylistUiState$Success0.getCurrentIndex(), musicPlaylistUiState$Success0.isPlaying() && v4 == musicPlaylistUiState$Success0.getCurrentIndex(), ((SongUiState)object3).isAdult(), z, ((SongUiState)object3).isOfflineSong(), PlaylistCommonSongListComposableKt.getFileTypeDrawableResId(((SongUiState)object3).getFileType())));
                ++v4;
                continue;
            }
            e.k.O();
            throw null;
        }
        return list4;
    }
}

