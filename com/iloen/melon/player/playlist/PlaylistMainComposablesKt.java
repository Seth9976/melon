package com.iloen.melon.player.playlist;

import Cc.H3;
import Cc.P2;
import Cc.c1;
import Cc.e0;
import Cc.n3;
import Cc.u2;
import Cc.x2;
import E9.g;
import F.S;
import F.X;
import G.f;
import N0.M;
import N0.N;
import N0.O;
import N0.Z;
import N0.g0;
import P0.h;
import P0.i;
import P0.j;
import P0.x0;
import Q0.k0;
import U8.z;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import androidx.compose.animation.b;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.runtime.J;
import androidx.compose.runtime.K0;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.V;
import androidx.compose.runtime.a0;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.iloen.melon.custom.B1;
import com.iloen.melon.custom.l1;
import com.melon.playlist.mixup.DjMalrangInfo;
import com.melon.ui.common.composable.PlayBgColorData;
import i.n.i.b.a.s.e.M3;
import ie.H;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import je.x;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.channels.Channel;
import m0.c;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.e;
import r0.d;
import r0.n;
import r0.q;
import we.o;
import x1.m;
import x1.t;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A)\u0010\u0007\u001A\u00020\u00062\b\b\u0002\u0010\u0001\u001A\u00020\u00002\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\b\u0007\u0010\b\u001A\u00B1\u0001\u0010\u001A\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\u000B\u001A\u00020\t2\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u00060\f2\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00060\f2\u0018\u0010\u0011\u001A\u0014\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\u000F2\u0006\u0010\u0013\u001A\u00020\u00122\u000E\b\u0002\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00060\f2\u000E\b\u0002\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00060\f2\u001A\b\u0002\u0010\u0016\u001A\u0014\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\u000F2\u0006\u0010\u0018\u001A\u00020\u00172\u000E\b\u0002\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u00060\fH\u0007\u00A2\u0006\u0004\b\u001A\u0010\u001B\u001A\u00B1\u0001\u0010\u001C\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\u000B\u001A\u00020\t2\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u00060\f2\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00060\f2\u0018\u0010\u0011\u001A\u0014\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\u000F2\u0006\u0010\u0013\u001A\u00020\u00122\u000E\b\u0002\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00060\f2\u000E\b\u0002\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00060\f2\u001A\b\u0002\u0010\u0016\u001A\u0014\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\u000F2\u0006\u0010\u0018\u001A\u00020\u00172\u000E\b\u0002\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u00060\fH\u0007\u00A2\u0006\u0004\b\u001C\u0010\u001B\u001A\u00B1\u0001\u0010\u001D\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\u000B\u001A\u00020\t2\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u00060\f2\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00060\f2\u0018\u0010\u0011\u001A\u0014\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\u000F2\u0006\u0010\u0013\u001A\u00020\u00122\u000E\b\u0002\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00060\f2\u000E\b\u0002\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00060\f2\u001A\b\u0002\u0010\u0016\u001A\u0014\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\u000F2\u0006\u0010\u0018\u001A\u00020\u00172\u000E\b\u0002\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u00060\fH\u0007\u00A2\u0006\u0004\b\u001D\u0010\u001B\u001A\u000F\u0010\u001E\u001A\u00020\u0006H\u0007\u00A2\u0006\u0004\b\u001E\u0010\u001F\u00A8\u0006\'\u00B2\u0006\u000E\u0010!\u001A\u00020 8\n@\nX\u008A\u008E\u0002\u00B2\u0006\u0010\u0010#\u001A\u0004\u0018\u00010\"8\n@\nX\u008A\u008E\u0002\u00B2\u0006\u0010\u0010%\u001A\u0004\u0018\u00010$8\n@\nX\u008A\u008E\u0002\u00B2\u0006\u000E\u0010&\u001A\u00020\u00108\n@\nX\u008A\u008E\u0002"}, d2 = {"Lr0/q;", "modifier", "Lcom/iloen/melon/player/playlist/PlaylistMainBgData;", "data", "LCc/x2;", "playBgColorExtractor", "Lie/H;", "PlaylistBg", "(Lr0/q;Lcom/iloen/melon/player/playlist/PlaylistMainBgData;LCc/x2;Landroidx/compose/runtime/l;II)V", "", "playTimeMs", "durationMs", "Lkotlin/Function0;", "onClickSetting", "onClickPrev", "Lkotlin/Function2;", "", "onLongClickPrev", "", "isPlaying", "onClickPlayPause", "onClickNext", "onLongClickNext", "", "thumbUri", "onClickAlbumArt", "PlaylistBottomController", "(JJLwe/a;Lwe/a;Lwe/n;ZLwe/a;Lwe/a;Lwe/n;Ljava/lang/String;Lwe/a;Landroidx/compose/runtime/l;III)V", "PlaylistPortraitBottomController", "PlaylistLandscapeBottomController", "PlaylistPortraitBottomControllerLayoutPreview", "(Landroidx/compose/runtime/l;I)V", "Lcom/iloen/melon/player/playlist/PlaylistBgType;", "bgType", "Lpc/b;", "djMalrangColorType", "Lcom/melon/ui/common/composable/PlayBgColorData;", "playBgColorData", "dataCount", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class PlaylistMainComposablesKt {
    public static final void PlaylistBg(@Nullable q q0, @NotNull PlaylistMainBgData playlistMainBgData0, @NotNull x2 x20, @Nullable l l0, int v, int v1) {
        q q3;
        com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistBg.1.1 playlistMainComposablesKt$PlaylistBg$1$10;
        a0 a01;
        b0 b04;
        b0 b03;
        int v2;
        kotlin.jvm.internal.q.g(playlistMainBgData0, "data");
        kotlin.jvm.internal.q.g(x20, "playBgColorExtractor");
        p p0 = (p)l0;
        p0.c0(0x8420461F);
        if((v1 & 1) == 0) {
            v2 = (v & 6) == 0 ? (p0.g(q0) ? 4 : 2) | v : v;
        }
        else {
            v2 = v | 6;
        }
        if((v & 0x30) == 0) {
            v2 |= (((v & 0x40) == 0 ? p0.g(playlistMainBgData0) : p0.i(playlistMainBgData0)) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v2 |= (p0.i(x20) ? 0x100 : 0x80);
        }
        if(p0.Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            q q1 = (v1 & 1) == 0 ? q0 : n.a;
            b0 b00 = p0.N();
            V v3 = k.a;
            if(b00 == v3) {
                b00 = w.s(PlaylistBgType.Default);
                p0.l0(b00);
            }
            b0 b01 = p0.N();
            if(b01 == v3) {
                b01 = w.s(null);
                p0.l0(b01);
            }
            b0 b02 = p0.N();
            if(b02 == v3) {
                b02 = w.s(null);
                p0.l0(b02);
            }
            a0 a00 = p0.N();
            if(a00 == v3) {
                a00 = w.p(0);
                p0.l0(a00);
            }
            boolean z = (v2 & 0x70) == 0x20 || (v2 & 0x40) != 0 && p0.i(playlistMainBgData0);
            boolean z1 = p0.i(x20);
            Object object0 = p0.N();
            if(!z && !z1 && object0 != v3) {
                b03 = b01;
                playlistMainComposablesKt$PlaylistBg$1$10 = object0;
                b04 = b02;
                a01 = a00;
            }
            else {
                b03 = b01;
                b04 = b02;
                a01 = a00;
                playlistMainComposablesKt$PlaylistBg$1$10 = new we.n(playlistMainBgData0, x20, a01, b03, b00, b04, null) {
                    public final PlaylistMainBgData B;
                    public final x2 D;
                    public final a0 E;
                    public final b0 G;
                    public final b0 I;
                    public final b0 M;
                    public b0 r;
                    public int w;

                    {
                        this.B = playlistMainBgData0;
                        this.D = x20;
                        this.E = a00;
                        this.G = b00;
                        this.I = b01;
                        this.M = b02;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistBg.1.1(this.B, this.D, this.E, this.G, this.I, this.M, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistBg.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        b0 b01;
                        a a0 = a.a;
                        b0 b00 = this.I;
                        switch(this.w) {
                            case 0: {
                                d5.n.D(object0);
                                int v = PlaylistMainComposablesKt.access$PlaylistBg$lambda$10(this.E);
                                PlaylistMainComposablesKt.access$PlaylistBg$lambda$11(this.E, v + 1);
                                PlaylistMainBgData playlistMainBgData0 = this.B;
                                if(playlistMainBgData0 instanceof DjMalrang) {
                                    DjMalrangInfo djMalrangInfo0 = ((DjMalrang)playlistMainBgData0).getDjMalrangInfo();
                                    PlaylistMainComposablesKt.access$PlaylistBg$lambda$5(this.G, djMalrangInfo0.i);
                                    PlaylistMainComposablesKt.access$PlaylistBg$lambda$2(b00, PlaylistBgType.DjMalrang);
                                    return H.a;
                                }
                                if(!(playlistMainBgData0 instanceof Default)) {
                                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                                }
                                Uri uri0 = ((Default)playlistMainBgData0).getThumbnailUri();
                                b01 = this.M;
                                this.r = b01;
                                this.w = 1;
                                object0 = this.D.a(uri0, this);
                                if(object0 == a0) {
                                    return a0;
                                }
                                goto label_24;
                            }
                            case 1: {
                                b01 = this.r;
                                d5.n.D(object0);
                            label_24:
                                PlaylistMainComposablesKt.access$PlaylistBg$lambda$8(b01, ((PlayBgColorData)object0));
                                this.r = null;
                                this.w = 2;
                                if(DelayKt.delay(u2.b.a, this) == a0) {
                                    return a0;
                                }
                                break;
                            }
                            case 2: {
                                d5.n.D(object0);
                                break;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                        PlaylistMainComposablesKt.access$PlaylistBg$lambda$2(b00, PlaylistBgType.Default);
                        return H.a;
                    }
                };
                p0.l0(playlistMainComposablesKt$PlaylistBg$1$10);
            }
            J.d(p0, playlistMainBgData0, playlistMainComposablesKt$PlaylistBg$1$10);
            M m0 = M.p.d(d.a, false);
            int v4 = p0.P;
            i0 i00 = p0.m();
            q q2 = r0.a.d(p0, q1);
            P0.k.y.getClass();
            i i0 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, m0, j.f);
            w.x(p0, i00, j.e);
            h h0 = j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h0);
            }
            w.x(p0, q2, j.d);
            q3 = q1;
            u2.a(((PlayBgColorData)b04.getValue()), null, 0.0f, 0.0f, null, null, null, null, false, p0, 0, 510);
            b.d(((PlaylistBgType)b00.getValue()) == PlaylistBgType.DjMalrang, androidx.compose.foundation.layout.d.c, (((K0)a01).m() <= 1 ? X.b : S.b(f.r(700, 0, null, 6), 2)), S.c(f.r(700, 0, null, 6), 2), null, c.e(0x9A702681, p0, new com.iloen.melon.player.playlist.d(b03)), p0, 0x30C30, 16);
            p0.p(true);
        }
        else {
            p0.T();
            q3 = q0;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new H3(q3, playlistMainBgData0, x20, v, v1, 11);
        }
    }

    public static final void PlaylistBottomController(long v, long v1, @NotNull we.a a0, @NotNull we.a a1, @NotNull we.n n0, boolean z, @Nullable we.a a2, @Nullable we.a a3, @Nullable we.n n1, @NotNull String s, @Nullable we.a a4, @Nullable l l0, int v2, int v3, int v4) {
        we.a a10;
        we.a a9;
        we.a a8;
        we.n n3;
        we.a a7;
        we.n n2;
        we.a a6;
        we.a a5;
        int v8;
        int v7;
        int v6;
        kotlin.jvm.internal.q.g(a0, "onClickSetting");
        kotlin.jvm.internal.q.g(a1, "onClickPrev");
        kotlin.jvm.internal.q.g(n0, "onLongClickPrev");
        kotlin.jvm.internal.q.g(s, "thumbUri");
        p p0 = (p)l0;
        p0.c0(0xAEAB8E43);
        int v5 = (v2 & 6) == 0 ? (p0.f(v) ? 4 : 2) | v2 : v2;
        if((v2 & 0x30) == 0) {
            v5 |= (p0.f(v1) ? 0x20 : 16);
        }
        if((v2 & 0x180) == 0) {
            v5 |= (p0.i(a0) ? 0x100 : 0x80);
        }
        if((v2 & 0xC00) == 0) {
            v5 |= (p0.i(a1) ? 0x800 : 0x400);
        }
        if((v2 & 0x6000) == 0) {
            v5 |= (p0.i(n0) ? 0x4000 : 0x2000);
        }
        if((0x30000 & v2) == 0) {
            v5 |= (p0.h(z) ? 0x20000 : 0x10000);
        }
        if((v4 & 0x40) != 0) {
            v5 |= 0x180000;
        }
        else if((v2 & 0x180000) == 0) {
            v5 |= (p0.i(a2) ? 0x100000 : 0x80000);
        }
        if((v4 & 0x80) != 0) {
            v5 |= 0xC00000;
        }
        else if((v2 & 0xC00000) == 0) {
            v5 |= (p0.i(a3) ? 0x800000 : 0x400000);
        }
        if((v4 & 0x100) != 0) {
            v5 |= 0x6000000;
            v6 = v4 & 0x100;
        }
        else if((v2 & 0x6000000) == 0) {
            v6 = v4 & 0x100;
            v5 |= (p0.i(n1) ? 0x4000000 : 0x2000000);
        }
        else {
            v6 = v4 & 0x100;
        }
        if((v2 & 0x30000000) == 0) {
            v5 |= (p0.g(s) ? 0x20000000 : 0x10000000);
        }
        if((v4 & 0x400) != 0) {
            v7 = v3 | 6;
            v8 = v4 & 0x400;
        }
        else if((v3 & 6) == 0) {
            v8 = v4 & 0x400;
            v7 = v3 | (p0.i(a4) ? 4 : 2);
        }
        else {
            v8 = v4 & 0x400;
            v7 = v3;
        }
        if(p0.Q(v5 & 1, (v5 & 306783379) != 306783378 || (v7 & 3) != 2)) {
            V v9 = k.a;
            if((v4 & 0x40) == 0) {
                a5 = a2;
            }
            else {
                e e0 = p0.N();
                if(e0 == v9) {
                    e0 = new e(24);
                    p0.l0(e0);
                }
                a5 = e0;
            }
            if((v4 & 0x80) == 0) {
                a6 = a3;
            }
            else {
                e e1 = p0.N();
                if(e1 == v9) {
                    e1 = new e(24);
                    p0.l0(e1);
                }
                a6 = e1;
            }
            if(v6 == 0) {
                n2 = n1;
            }
            else {
                B1 b10 = p0.N();
                if(b10 == v9) {
                    b10 = new B1(6);
                    p0.l0(b10);
                }
                n2 = b10;
            }
            if(v8 == 0) {
                a7 = a4;
            }
            else {
                e e2 = p0.N();
                if(e2 == v9) {
                    e2 = new e(24);
                    p0.l0(e2);
                }
                a7 = e2;
            }
            if(((Configuration)p0.k(AndroidCompositionLocals_androidKt.a)).orientation == 2) {
                p0.a0(-1909904444);
                PlaylistMainComposablesKt.PlaylistLandscapeBottomController(v, v1, a0, a1, n0, z, a5, a6, n2, s, a7, p0, v5 & 0x7FFFFFFE, v7 & 14, 0);
            }
            else {
                p0.a0(-1909321179);
                PlaylistMainComposablesKt.PlaylistPortraitBottomController(v, v1, a0, a1, n0, z, a5, a6, n2, s, a7, p0, v5 & 0x7FFFFFFE, v7 & 14, 0);
            }
            p0.p(false);
            n3 = n2;
            a8 = a6;
            a9 = a7;
            a10 = a5;
        }
        else {
            p0.T();
            a8 = a3;
            n3 = n1;
            a10 = a2;
            a9 = a4;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.player.playlist.c(v, v1, a0, a1, n0, z, a10, a8, n3, s, a9, v2, v3, v4, 0);
        }
    }

    public static final void PlaylistLandscapeBottomController(long v, long v1, @NotNull we.a a0, @NotNull we.a a1, @NotNull we.n n0, boolean z, @Nullable we.a a2, @Nullable we.a a3, @Nullable we.n n1, @NotNull String s, @Nullable we.a a4, @Nullable l l0, int v2, int v3, int v4) {
        we.a a10;
        we.n n3;
        we.a a9;
        we.a a8;
        b0 b02;
        m m1;
        we.a a7;
        we.n n2;
        we.a a6;
        we.a a5;
        int v8;
        int v7;
        int v6;
        kotlin.jvm.internal.q.g(a0, "onClickSetting");
        kotlin.jvm.internal.q.g(a1, "onClickPrev");
        kotlin.jvm.internal.q.g(n0, "onLongClickPrev");
        kotlin.jvm.internal.q.g(s, "thumbUri");
        p p0 = (p)l0;
        p0.c0(0x2A71FEDE);
        int v5 = (v2 & 6) == 0 ? (p0.f(v) ? 4 : 2) | v2 : v2;
        if((v2 & 0x30) == 0) {
            v5 |= (p0.f(v1) ? 0x20 : 16);
        }
        if((v2 & 0x180) == 0) {
            v5 |= (p0.i(a0) ? 0x100 : 0x80);
        }
        if((v2 & 0xC00) == 0) {
            v5 |= (p0.i(a1) ? 0x800 : 0x400);
        }
        if((v2 & 0x6000) == 0) {
            v5 |= (p0.i(n0) ? 0x4000 : 0x2000);
        }
        if((0x30000 & v2) == 0) {
            v5 |= (p0.h(z) ? 0x20000 : 0x10000);
        }
        if((v4 & 0x40) != 0) {
            v5 |= 0x180000;
        }
        else if((v2 & 0x180000) == 0) {
            v5 |= (p0.i(a2) ? 0x100000 : 0x80000);
        }
        if((v4 & 0x80) != 0) {
            v5 |= 0xC00000;
        }
        else if((v2 & 0xC00000) == 0) {
            v5 |= (p0.i(a3) ? 0x800000 : 0x400000);
        }
        if((v4 & 0x100) != 0) {
            v5 |= 0x6000000;
            v6 = v4 & 0x100;
        }
        else if((v2 & 0x6000000) == 0) {
            v6 = v4 & 0x100;
            v5 |= (p0.i(n1) ? 0x4000000 : 0x2000000);
        }
        else {
            v6 = v4 & 0x100;
        }
        if((v2 & 0x30000000) == 0) {
            v5 |= (p0.g(s) ? 0x20000000 : 0x10000000);
        }
        if((v4 & 0x400) != 0) {
            v7 = v3 | 6;
            v8 = v4 & 0x400;
        }
        else if((v3 & 6) == 0) {
            v8 = v4 & 0x400;
            v7 = v3 | (p0.i(a4) ? 4 : 2);
        }
        else {
            v8 = v4 & 0x400;
            v7 = v3;
        }
        if(p0.Q(v5 & 1, (v5 & 306783379) != 306783378 || (v7 & 3) != 2)) {
            V v9 = k.a;
            if((v4 & 0x40) == 0) {
                a5 = a2;
            }
            else {
                e e0 = p0.N();
                if(e0 == v9) {
                    e0 = new e(24);
                    p0.l0(e0);
                }
                a5 = e0;
            }
            if((v4 & 0x80) == 0) {
                a6 = a3;
            }
            else {
                e e1 = p0.N();
                if(e1 == v9) {
                    e1 = new e(24);
                    p0.l0(e1);
                }
                a6 = e1;
            }
            if(v6 == 0) {
                n2 = n1;
            }
            else {
                B1 b10 = p0.N();
                if(b10 == v9) {
                    b10 = new B1(6);
                    p0.l0(b10);
                }
                n2 = b10;
            }
            if(v8 == 0) {
                a7 = a4;
            }
            else {
                e e2 = p0.N();
                if(e2 == v9) {
                    e2 = new e(24);
                    p0.l0(e2);
                }
                a7 = e2;
            }
            q q0 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(n.a, 1.0f), 96.0f);
            p0.a0(-1003410150);
            p0.a0(212064437);
            p0.p(false);
            r1.c c0 = (r1.c)p0.k(k0.h);
            x1.q q1 = p0.N();
            if(q1 == v9) {
                q1 = l1.w(c0, p0);
            }
            x1.j j0 = p0.N();
            if(j0 == v9) {
                j0 = l1.u(p0);
            }
            b0 b00 = p0.N();
            if(b00 == v9) {
                b00 = w.s(Boolean.FALSE);
                p0.l0(b00);
            }
            m m0 = p0.N();
            if(m0 == v9) {
                m0 = l1.v(j0, p0);
            }
            b0 b01 = p0.N();
            if(b01 == v9) {
                b01 = w.r(H.a, V.c);
                p0.l0(b01);
            }
            boolean z1 = p0.i(q1);
            boolean z2 = p0.e(0x101);
            com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistLandscapeBottomController..inlined.ConstraintLayout.2 playlistMainComposablesKt$PlaylistLandscapeBottomController$$inlined$ConstraintLayout$20 = p0.N();
            if(z1 || z2 || playlistMainComposablesKt$PlaylistLandscapeBottomController$$inlined$ConstraintLayout$20 == v9) {
                playlistMainComposablesKt$PlaylistLandscapeBottomController$$inlined$ConstraintLayout$20 = new M() {
                    @Override  // N0.M
                    public int maxIntrinsicHeight(@NotNull N0.q q0, @NotNull List list0, int v) {
                        return M.super.maxIntrinsicHeight(q0, list0, v);
                    }

                    @Override  // N0.M
                    public int maxIntrinsicWidth(@NotNull N0.q q0, @NotNull List list0, int v) {
                        return M.super.maxIntrinsicWidth(q0, list0, v);
                    }

                    @Override  // N0.M
                    public final N measure-3p2s80s(O o0, List list0, long v) {
                        LinkedHashMap linkedHashMap0 = new LinkedHashMap();
                        b01.getValue();
                        r1.m m0 = o0.getLayoutDirection();
                        long v1 = q1.f(v, m0, m0, list0, linkedHashMap0, 0x101);
                        b00.getValue();
                        com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistLandscapeBottomController..inlined.ConstraintLayout.2.1 playlistMainComposablesKt$PlaylistLandscapeBottomController$$inlined$ConstraintLayout$2$10 = new we.k(list0, linkedHashMap0) {
                            public final x1.q f;
                            public final List g;
                            public final Map h;

                            {
                                this.f = q0;
                                this.g = list0;
                                this.h = map0;
                                super(1);
                            }

                            @Override  // we.k
                            public Object invoke(Object object0) {
                                this.invoke(((Z)object0));
                                return H.a;
                            }

                            public final void invoke(Z z0) {
                                this.f.e(z0, this.g, this.h);
                            }
                        };
                        return o0.w(((int)(v1 >> 0x20)), ((int)(v1 & 0xFFFFFFFFL)), x.a, playlistMainComposablesKt$PlaylistLandscapeBottomController$$inlined$ConstraintLayout$2$10);
                    }

                    @Override  // N0.M
                    public int minIntrinsicHeight(@NotNull N0.q q0, @NotNull List list0, int v) {
                        return M.super.minIntrinsicHeight(q0, list0, v);
                    }

                    @Override  // N0.M
                    public int minIntrinsicWidth(@NotNull N0.q q0, @NotNull List list0, int v) {
                        return M.super.minIntrinsicWidth(q0, list0, v);
                    }
                };
                m1 = m0;
                b02 = b00;
                p0.l0(playlistMainComposablesKt$PlaylistLandscapeBottomController$$inlined$ConstraintLayout$20);
            }
            else {
                m1 = m0;
                b02 = b00;
            }
            com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistLandscapeBottomController..inlined.ConstraintLayout.3 playlistMainComposablesKt$PlaylistLandscapeBottomController$$inlined$ConstraintLayout$30 = p0.N();
            if(playlistMainComposablesKt$PlaylistLandscapeBottomController$$inlined$ConstraintLayout$30 == v9) {
                playlistMainComposablesKt$PlaylistLandscapeBottomController$$inlined$ConstraintLayout$30 = new we.a(b02, m1) {
                    public final b0 f;
                    public final m g;

                    {
                        this.f = b00;
                        this.g = m0;
                        super(0);
                    }

                    @Override  // we.a
                    public Object invoke() {
                        this.invoke();
                        return H.a;
                    }

                    public final void invoke() {
                        Boolean boolean0 = Boolean.valueOf(!((Boolean)this.f.getValue()).booleanValue());
                        this.f.setValue(boolean0);
                        this.g.d = true;
                    }
                };
                p0.l0(playlistMainComposablesKt$PlaylistLandscapeBottomController$$inlined$ConstraintLayout$30);
            }
            boolean z3 = p0.i(q1);
            com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistLandscapeBottomController..inlined.ConstraintLayout.4 playlistMainComposablesKt$PlaylistLandscapeBottomController$$inlined$ConstraintLayout$40 = p0.N();
            if(z3 || playlistMainComposablesKt$PlaylistLandscapeBottomController$$inlined$ConstraintLayout$40 == v9) {
                playlistMainComposablesKt$PlaylistLandscapeBottomController$$inlined$ConstraintLayout$40 = new we.k(q1) {
                    public final x1.q f;

                    {
                        this.f = q0;
                        super(1);
                    }

                    @Override  // we.k
                    public Object invoke(Object object0) {
                        this.invoke(((X0.x)object0));
                        return H.a;
                    }

                    public final void invoke(X0.x x0) {
                        t.a(x0, this.f);
                    }
                };
                p0.l0(playlistMainComposablesKt$PlaylistLandscapeBottomController$$inlined$ConstraintLayout$40);
            }
            g0.a(X0.n.c(q0, false, playlistMainComposablesKt$PlaylistLandscapeBottomController$$inlined$ConstraintLayout$40), c.e(1200550679, p0, new we.n(b01, j0, playlistMainComposablesKt$PlaylistLandscapeBottomController$$inlined$ConstraintLayout$30, v1, v, a1, n0, z, a5, a6, n2, s, a0, a7) {
                public final we.a B;
                public final we.a D;
                public final b0 f;
                public final x1.j g;
                public final we.a h;
                public final long i;
                public final long j;
                public final we.a k;
                public final we.n l;
                public final boolean m;
                public final we.a n;
                public final we.a o;
                public final we.n r;
                public final String w;

                {
                    this.f = b00;
                    this.g = j0;
                    this.h = a0;
                    this.i = v;
                    this.j = v1;
                    this.k = a1;
                    this.l = n0;
                    this.m = z;
                    this.n = a2;
                    this.o = a3;
                    this.r = n1;
                    this.w = s;
                    this.B = a4;
                    this.D = a5;
                    super(2);
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    this.invoke(((l)object0), ((Number)object1).intValue());
                    return H.a;
                }

                public final void invoke(l l0, int v) {
                    if((v & 3) == 2 && ((p)l0).D()) {
                        ((p)l0).T();
                        return;
                    }
                    this.f.setValue(H.a);
                    x1.j j0 = this.g;
                    int v1 = j0.b;
                    j0.h();
                    p p0 = (p)l0;
                    p0.a0(0xE3BDF5C);
                    wa.a a0 = j0.f();
                    x1.e e0 = ((x1.j)a0.a).e();
                    x1.e e1 = ((x1.j)a0.a).e();
                    x1.e e2 = ((x1.j)a0.a).e();
                    x1.e e3 = ((x1.j)a0.a).e();
                    x1.e e4 = ((x1.j)a0.a).e();
                    x1.e e5 = ((x1.j)a0.a).e();
                    n n0 = n.a;
                    q q0 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(n0, 1.0f), 2.0f);
                    com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistLandscapeBottomController.5.1.1 playlistMainComposablesKt$PlaylistLandscapeBottomController$5$1$10 = p0.N();
                    V v2 = k.a;
                    if(playlistMainComposablesKt$PlaylistLandscapeBottomController$5$1$10 == v2) {
                        playlistMainComposablesKt$PlaylistLandscapeBottomController$5$1$10 = com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistLandscapeBottomController.5.1.1.INSTANCE;
                        p0.l0(playlistMainComposablesKt$PlaylistLandscapeBottomController$5$1$10);
                    }
                    q q1 = x1.j.b(q0, e0, playlistMainComposablesKt$PlaylistLandscapeBottomController$5$1$10);
                    long v3 = e0.T(p0, 0x7F0604B0);  // color:white160en
                    long v4 = e0.T(p0, 0x7F06017C);  // color:green500s_support_high_contrast
                    c1.F(q1, this.i, this.j, v3, v4, p0, 0, 0);
                    q q2 = androidx.compose.foundation.layout.d.n(n0, 48.0f);
                    com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistLandscapeBottomController.5.2.1 playlistMainComposablesKt$PlaylistLandscapeBottomController$5$2$10 = p0.N();
                    if(playlistMainComposablesKt$PlaylistLandscapeBottomController$5$2$10 == v2) {
                        playlistMainComposablesKt$PlaylistLandscapeBottomController$5$2$10 = com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistLandscapeBottomController.5.2.1.INSTANCE;
                        p0.l0(playlistMainComposablesKt$PlaylistLandscapeBottomController$5$2$10);
                    }
                    PlaylistMainComposablesKt.access$SettingButton(r0.a.a(x1.j.b(q2, e1, playlistMainComposablesKt$PlaylistLandscapeBottomController$5$2$10), new com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistLandscapeBottomController.lambda.60..inlined.noRippleClickable-YQRRFTQ.default.1(true, null, 0, this.B)), p0, 0, 0);
                    boolean z = p0.g(e1);
                    boolean z1 = p0.g(e3);
                    com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistLandscapeBottomController.5.4.1 playlistMainComposablesKt$PlaylistLandscapeBottomController$5$4$10 = p0.N();
                    if(z || z1 || playlistMainComposablesKt$PlaylistLandscapeBottomController$5$4$10 == v2) {
                        playlistMainComposablesKt$PlaylistLandscapeBottomController$5$4$10 = new com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistLandscapeBottomController.5.4.1(e1, e3);
                        p0.l0(playlistMainComposablesKt$PlaylistLandscapeBottomController$5$4$10);
                    }
                    c1.E(x1.j.b(n0, e2, playlistMainComposablesKt$PlaylistLandscapeBottomController$5$4$10), this.k, this.l, p0, 0);
                    com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistLandscapeBottomController.5.5.1 playlistMainComposablesKt$PlaylistLandscapeBottomController$5$5$10 = p0.N();
                    if(playlistMainComposablesKt$PlaylistLandscapeBottomController$5$5$10 == v2) {
                        playlistMainComposablesKt$PlaylistLandscapeBottomController$5$5$10 = com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistLandscapeBottomController.5.5.1.INSTANCE;
                        p0.l0(playlistMainComposablesKt$PlaylistLandscapeBottomController$5$5$10);
                    }
                    c1.z(0, p0, x1.j.b(n0, e3, playlistMainComposablesKt$PlaylistLandscapeBottomController$5$5$10), this.n, this.m);
                    boolean z2 = p0.g(e3);
                    boolean z3 = p0.g(e5);
                    com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistLandscapeBottomController.5.6.1 playlistMainComposablesKt$PlaylistLandscapeBottomController$5$6$10 = p0.N();
                    if(z2 || z3 || playlistMainComposablesKt$PlaylistLandscapeBottomController$5$6$10 == v2) {
                        playlistMainComposablesKt$PlaylistLandscapeBottomController$5$6$10 = new com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistLandscapeBottomController.5.6.1(e3, e5);
                        p0.l0(playlistMainComposablesKt$PlaylistLandscapeBottomController$5$6$10);
                    }
                    c1.x(x1.j.b(n0, e4, playlistMainComposablesKt$PlaylistLandscapeBottomController$5$6$10), this.o, this.r, p0, 0);
                    q q3 = androidx.compose.foundation.layout.d.n(n0, 48.0f);
                    com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistLandscapeBottomController.5.7.1 playlistMainComposablesKt$PlaylistLandscapeBottomController$5$7$10 = p0.N();
                    if(playlistMainComposablesKt$PlaylistLandscapeBottomController$5$7$10 == v2) {
                        playlistMainComposablesKt$PlaylistLandscapeBottomController$5$7$10 = com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistLandscapeBottomController.5.7.1.INSTANCE;
                        p0.l0(playlistMainComposablesKt$PlaylistLandscapeBottomController$5$7$10);
                    }
                    PlaylistMainComposablesKt.access$AlbumUri(r0.a.a(x1.j.b(q3, e5, playlistMainComposablesKt$PlaylistLandscapeBottomController$5$7$10), new com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistLandscapeBottomController.lambda.60..inlined.noRippleClickable-YQRRFTQ.default.2(true, null, 0, this.D)), this.w, p0, 0, 0);
                    p0.p(false);
                    if(j0.b != v1) {
                        J.h(this.h, p0);
                    }
                }
            }), playlistMainComposablesKt$PlaylistLandscapeBottomController$$inlined$ConstraintLayout$20, p0, 0x30);
            p0.p(false);
            a8 = a5;
            a9 = a6;
            n3 = n2;
            a10 = a7;
        }
        else {
            p0.T();
            a9 = a3;
            n3 = n1;
            a10 = a4;
            a8 = a2;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.player.playlist.c(v, v1, a0, a1, n0, z, a8, a9, n3, s, a10, v2, v3, v4, 1);
        }

        @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001A\u00020\u0000H\u000B¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lie/H;", "invoke", "(Landroidx/compose/runtime/l;I)V", "<anonymous>"}, k = 3, mv = {2, 2, 0})
        public final class com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistLandscapeBottomController..inlined.ConstraintLayout.1 extends r implements we.n {
            public final b0 f;

            public com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistLandscapeBottomController..inlined.ConstraintLayout.1(b0 b00, x0 x00, x1.j j0, Channel channel0, b0 b01, b0 b02, long v, long v1, we.a a0, we.n n0, boolean z, we.a a1, we.a a2, we.n n1, String s, we.a a3, we.a a4) {
                this.f = b00;
                super(2);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                this.invoke(((l)object0), ((Number)object1).intValue());
                return H.a;
            }

            public final void invoke(l l0, int v) {
                if((v & 3) == 2 && ((p)l0).D()) {
                    ((p)l0).T();
                    return;
                }
                this.f.setValue(H.a);
                throw null;

                @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lie/H;", "invoke", "()V", "<anonymous>"}, k = 3, mv = {2, 2, 0})
                public final class com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistLandscapeBottomController..inlined.ConstraintLayout.1.1 extends r implements we.a {
                    public final x1.j f;
                    public final b0 g;
                    public final b0 h;
                    public final Channel i;

                    public com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistLandscapeBottomController..inlined.ConstraintLayout.1.1(x1.j j0, b0 b00, b0 b01, Channel channel0) {
                        this.f = j0;
                        this.g = b00;
                        this.h = b01;
                        this.i = channel0;
                        super(0);
                    }

                    @Override  // we.a
                    public Object invoke() {
                        this.invoke();
                        return H.a;
                    }

                    public final void invoke() {
                        x1.r r0 = new x1.r(this.f.a.D());
                        b0 b00 = this.g;
                        Object object0 = b00.getValue();
                        b0 b01 = this.h;
                        if(object0 != null && b01.getValue() != null) {
                            this.i.trySend-JP2dKIU(r0);
                            return;
                        }
                        b00.setValue(r0);
                        b01.setValue(b00.getValue());
                    }
                }

            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistLandscapeBottomController.5.1.1 implements we.k {
            public static final com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistLandscapeBottomController.5.1.1 INSTANCE;

            static {
                com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistLandscapeBottomController.5.1.1.INSTANCE = new com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistLandscapeBottomController.5.1.1();  // 初始化器: Ljava/lang/Object;-><init>()V
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((x1.d)object0));
                return H.a;
            }

            public final void invoke(x1.d d0) {
                kotlin.jvm.internal.q.g(d0, "$this$constrainAs");
                g.v(d0.e, d0.c.e, 0.0f, 6);
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistLandscapeBottomController.5.2.1 implements we.k {
            public static final com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistLandscapeBottomController.5.2.1 INSTANCE;

            static {
                com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistLandscapeBottomController.5.2.1.INSTANCE = new com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistLandscapeBottomController.5.2.1();  // 初始化器: Ljava/lang/Object;-><init>()V
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((x1.d)object0));
                return H.a;
            }

            public final void invoke(x1.d d0) {
                kotlin.jvm.internal.q.g(d0, "$this$constrainAs");
                g.v(d0.g, d0.c.g, 25.0f, 4);
                W.p.l(d0.d, d0.c.d, 14.0f, 4);
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistLandscapeBottomController.5.4.1 implements we.k {
            public final x1.e a;
            public final x1.e b;

            public com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistLandscapeBottomController.5.4.1(x1.e e0, x1.e e1) {
                this.a = e0;
                this.b = e1;
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((x1.d)object0));
                return H.a;
            }

            public final void invoke(x1.d d0) {
                kotlin.jvm.internal.q.g(d0, "$this$constrainAs");
                g.v(d0.g, d0.c.g, 20.0f, 4);
                x1.d.b(d0, this.a.f, this.b.d, 0.0f, 0.0f, 0.8f, 60);
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistLandscapeBottomController.5.5.1 implements we.k {
            public static final com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistLandscapeBottomController.5.5.1 INSTANCE;

            static {
                com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistLandscapeBottomController.5.5.1.INSTANCE = new com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistLandscapeBottomController.5.5.1();  // 初始化器: Ljava/lang/Object;-><init>()V
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((x1.d)object0));
                return H.a;
            }

            public final void invoke(x1.d d0) {
                kotlin.jvm.internal.q.g(d0, "$this$constrainAs");
                g.v(d0.g, d0.c.g, 20.0f, 4);
                W.p.l(d0.d, d0.c.d, 0.0f, 6);
                W.p.l(d0.f, d0.c.f, 0.0f, 6);
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistLandscapeBottomController.5.6.1 implements we.k {
            public final x1.e a;
            public final x1.e b;

            public com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistLandscapeBottomController.5.6.1(x1.e e0, x1.e e1) {
                this.a = e0;
                this.b = e1;
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((x1.d)object0));
                return H.a;
            }

            public final void invoke(x1.d d0) {
                kotlin.jvm.internal.q.g(d0, "$this$constrainAs");
                g.v(d0.g, d0.c.g, 20.0f, 4);
                x1.d.b(d0, this.a.f, this.b.d, 0.0f, 0.0f, 0.2f, 60);
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistLandscapeBottomController.5.7.1 implements we.k {
            public static final com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistLandscapeBottomController.5.7.1 INSTANCE;

            static {
                com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistLandscapeBottomController.5.7.1.INSTANCE = new com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistLandscapeBottomController.5.7.1();  // 初始化器: Ljava/lang/Object;-><init>()V
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((x1.d)object0));
                return H.a;
            }

            public final void invoke(x1.d d0) {
                kotlin.jvm.internal.q.g(d0, "$this$constrainAs");
                g.v(d0.g, d0.c.g, 25.0f, 4);
                W.p.l(d0.f, d0.c.f, 14.0f, 4);
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistLandscapeBottomController.lambda.60..inlined.noRippleClickable-YQRRFTQ.default.1 implements o {
            public com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistLandscapeBottomController.lambda.60..inlined.noRippleClickable-YQRRFTQ.default.1(boolean z, String s, int v, we.a a0) {
            }

            @Override  // we.o
            public Object invoke(Object object0, Object object1, Object object2) {
                return this.invoke(((q)object0), ((l)object1), ((Number)object2).intValue());
            }

            public final q invoke(q q0, l l0, int v) {
                kotlin.jvm.internal.q.g(q0, "$this$composed");
                ((p)l0).a0(0x1FF03545);
                w0.h h0 = (w0.h)((p)l0).k(k0.i);
                K.m m0 = ((p)l0).N();
                if(m0 == k.a) {
                    m0 = androidx.appcompat.app.o.d(((p)l0));
                }
                X0.i i0 = new X0.i(this.c);
                com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistLandscapeBottomController.lambda.60..inlined.noRippleClickable-YQRRFTQ.default.1.1 playlistMainComposablesKt$PlaylistLandscapeBottomController$lambda$60$$inlined$noRippleClickable-YQRRFTQ$default$1$10 = new we.a() {
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
                q q1 = androidx.compose.foundation.q.l(q0, m0, null, this.a, this.b, i0, playlistMainComposablesKt$PlaylistLandscapeBottomController$lambda$60$$inlined$noRippleClickable-YQRRFTQ$default$1$10);
                ((p)l0).p(false);
                return q1;
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistLandscapeBottomController.lambda.60..inlined.noRippleClickable-YQRRFTQ.default.2 implements o {
            public com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistLandscapeBottomController.lambda.60..inlined.noRippleClickable-YQRRFTQ.default.2(boolean z, String s, int v, we.a a0) {
            }

            @Override  // we.o
            public Object invoke(Object object0, Object object1, Object object2) {
                return this.invoke(((q)object0), ((l)object1), ((Number)object2).intValue());
            }

            public final q invoke(q q0, l l0, int v) {
                kotlin.jvm.internal.q.g(q0, "$this$composed");
                ((p)l0).a0(0x1FF03545);
                w0.h h0 = (w0.h)((p)l0).k(k0.i);
                K.m m0 = ((p)l0).N();
                if(m0 == k.a) {
                    m0 = androidx.appcompat.app.o.d(((p)l0));
                }
                X0.i i0 = new X0.i(this.c);
                com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistLandscapeBottomController.lambda.60..inlined.noRippleClickable-YQRRFTQ.default.2.1 playlistMainComposablesKt$PlaylistLandscapeBottomController$lambda$60$$inlined$noRippleClickable-YQRRFTQ$default$2$10 = new we.a() {
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
                q q1 = androidx.compose.foundation.q.l(q0, m0, null, this.a, this.b, i0, playlistMainComposablesKt$PlaylistLandscapeBottomController$lambda$60$$inlined$noRippleClickable-YQRRFTQ$default$2$10);
                ((p)l0).p(false);
                return q1;
            }
        }

    }

    public static final void PlaylistPortraitBottomController(long v, long v1, @NotNull we.a a0, @NotNull we.a a1, @NotNull we.n n0, boolean z, @Nullable we.a a2, @Nullable we.a a3, @Nullable we.n n1, @NotNull String s, @Nullable we.a a4, @Nullable l l0, int v2, int v3, int v4) {
        we.a a10;
        we.n n3;
        we.a a9;
        we.a a8;
        b0 b02;
        m m1;
        we.a a7;
        we.n n2;
        we.a a6;
        we.a a5;
        int v8;
        int v7;
        int v6;
        kotlin.jvm.internal.q.g(a0, "onClickSetting");
        kotlin.jvm.internal.q.g(a1, "onClickPrev");
        kotlin.jvm.internal.q.g(n0, "onLongClickPrev");
        kotlin.jvm.internal.q.g(s, "thumbUri");
        p p0 = (p)l0;
        p0.c0(0x6A0E10FE);
        int v5 = (v2 & 6) == 0 ? (p0.f(v) ? 4 : 2) | v2 : v2;
        if((v2 & 0x30) == 0) {
            v5 |= (p0.f(v1) ? 0x20 : 16);
        }
        if((v2 & 0x180) == 0) {
            v5 |= (p0.i(a0) ? 0x100 : 0x80);
        }
        if((v2 & 0xC00) == 0) {
            v5 |= (p0.i(a1) ? 0x800 : 0x400);
        }
        if((v2 & 0x6000) == 0) {
            v5 |= (p0.i(n0) ? 0x4000 : 0x2000);
        }
        if((0x30000 & v2) == 0) {
            v5 |= (p0.h(z) ? 0x20000 : 0x10000);
        }
        if((v4 & 0x40) != 0) {
            v5 |= 0x180000;
        }
        else if((v2 & 0x180000) == 0) {
            v5 |= (p0.i(a2) ? 0x100000 : 0x80000);
        }
        if((v4 & 0x80) != 0) {
            v5 |= 0xC00000;
        }
        else if((v2 & 0xC00000) == 0) {
            v5 |= (p0.i(a3) ? 0x800000 : 0x400000);
        }
        if((v4 & 0x100) != 0) {
            v5 |= 0x6000000;
            v6 = v4 & 0x100;
        }
        else if((v2 & 0x6000000) == 0) {
            v6 = v4 & 0x100;
            v5 |= (p0.i(n1) ? 0x4000000 : 0x2000000);
        }
        else {
            v6 = v4 & 0x100;
        }
        if((v2 & 0x30000000) == 0) {
            v5 |= (p0.g(s) ? 0x20000000 : 0x10000000);
        }
        if((v4 & 0x400) != 0) {
            v7 = v3 | 6;
            v8 = v4 & 0x400;
        }
        else if((v3 & 6) == 0) {
            v8 = v4 & 0x400;
            v7 = v3 | (p0.i(a4) ? 4 : 2);
        }
        else {
            v8 = v4 & 0x400;
            v7 = v3;
        }
        if(p0.Q(v5 & 1, (v5 & 306783379) != 306783378 || (v7 & 3) != 2)) {
            V v9 = k.a;
            if((v4 & 0x40) == 0) {
                a5 = a2;
            }
            else {
                e e0 = p0.N();
                if(e0 == v9) {
                    e0 = new e(24);
                    p0.l0(e0);
                }
                a5 = e0;
            }
            if((v4 & 0x80) == 0) {
                a6 = a3;
            }
            else {
                e e1 = p0.N();
                if(e1 == v9) {
                    e1 = new e(24);
                    p0.l0(e1);
                }
                a6 = e1;
            }
            if(v6 == 0) {
                n2 = n1;
            }
            else {
                B1 b10 = p0.N();
                if(b10 == v9) {
                    b10 = new B1(6);
                    p0.l0(b10);
                }
                n2 = b10;
            }
            if(v8 == 0) {
                a7 = a4;
            }
            else {
                e e2 = p0.N();
                if(e2 == v9) {
                    e2 = new e(24);
                    p0.l0(e2);
                }
                a7 = e2;
            }
            q q0 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(n.a, 1.0f), 96.0f);
            p0.a0(-1003410150);
            p0.a0(212064437);
            p0.p(false);
            r1.c c0 = (r1.c)p0.k(k0.h);
            x1.q q1 = p0.N();
            if(q1 == v9) {
                q1 = l1.w(c0, p0);
            }
            x1.j j0 = p0.N();
            if(j0 == v9) {
                j0 = l1.u(p0);
            }
            b0 b00 = p0.N();
            if(b00 == v9) {
                b00 = w.s(Boolean.FALSE);
                p0.l0(b00);
            }
            m m0 = p0.N();
            if(m0 == v9) {
                m0 = l1.v(j0, p0);
            }
            b0 b01 = p0.N();
            if(b01 == v9) {
                b01 = w.r(H.a, V.c);
                p0.l0(b01);
            }
            boolean z1 = p0.i(q1);
            boolean z2 = p0.e(0x101);
            com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistPortraitBottomController..inlined.ConstraintLayout.2 playlistMainComposablesKt$PlaylistPortraitBottomController$$inlined$ConstraintLayout$20 = p0.N();
            if(z1 || z2 || playlistMainComposablesKt$PlaylistPortraitBottomController$$inlined$ConstraintLayout$20 == v9) {
                playlistMainComposablesKt$PlaylistPortraitBottomController$$inlined$ConstraintLayout$20 = new M() {
                    @Override  // N0.M
                    public int maxIntrinsicHeight(@NotNull N0.q q0, @NotNull List list0, int v) {
                        return M.super.maxIntrinsicHeight(q0, list0, v);
                    }

                    @Override  // N0.M
                    public int maxIntrinsicWidth(@NotNull N0.q q0, @NotNull List list0, int v) {
                        return M.super.maxIntrinsicWidth(q0, list0, v);
                    }

                    @Override  // N0.M
                    public final N measure-3p2s80s(O o0, List list0, long v) {
                        LinkedHashMap linkedHashMap0 = new LinkedHashMap();
                        b01.getValue();
                        r1.m m0 = o0.getLayoutDirection();
                        long v1 = q1.f(v, m0, m0, list0, linkedHashMap0, 0x101);
                        b00.getValue();
                        com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistPortraitBottomController..inlined.ConstraintLayout.2.1 playlistMainComposablesKt$PlaylistPortraitBottomController$$inlined$ConstraintLayout$2$10 = new we.k(list0, linkedHashMap0) {
                            public final x1.q f;
                            public final List g;
                            public final Map h;

                            {
                                this.f = q0;
                                this.g = list0;
                                this.h = map0;
                                super(1);
                            }

                            @Override  // we.k
                            public Object invoke(Object object0) {
                                this.invoke(((Z)object0));
                                return H.a;
                            }

                            public final void invoke(Z z0) {
                                this.f.e(z0, this.g, this.h);
                            }
                        };
                        return o0.w(((int)(v1 >> 0x20)), ((int)(v1 & 0xFFFFFFFFL)), x.a, playlistMainComposablesKt$PlaylistPortraitBottomController$$inlined$ConstraintLayout$2$10);
                    }

                    @Override  // N0.M
                    public int minIntrinsicHeight(@NotNull N0.q q0, @NotNull List list0, int v) {
                        return M.super.minIntrinsicHeight(q0, list0, v);
                    }

                    @Override  // N0.M
                    public int minIntrinsicWidth(@NotNull N0.q q0, @NotNull List list0, int v) {
                        return M.super.minIntrinsicWidth(q0, list0, v);
                    }
                };
                m1 = m0;
                b02 = b00;
                p0.l0(playlistMainComposablesKt$PlaylistPortraitBottomController$$inlined$ConstraintLayout$20);
            }
            else {
                m1 = m0;
                b02 = b00;
            }
            com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistPortraitBottomController..inlined.ConstraintLayout.3 playlistMainComposablesKt$PlaylistPortraitBottomController$$inlined$ConstraintLayout$30 = p0.N();
            if(playlistMainComposablesKt$PlaylistPortraitBottomController$$inlined$ConstraintLayout$30 == v9) {
                playlistMainComposablesKt$PlaylistPortraitBottomController$$inlined$ConstraintLayout$30 = new we.a(b02, m1) {
                    public final b0 f;
                    public final m g;

                    {
                        this.f = b00;
                        this.g = m0;
                        super(0);
                    }

                    @Override  // we.a
                    public Object invoke() {
                        this.invoke();
                        return H.a;
                    }

                    public final void invoke() {
                        Boolean boolean0 = Boolean.valueOf(!((Boolean)this.f.getValue()).booleanValue());
                        this.f.setValue(boolean0);
                        this.g.d = true;
                    }
                };
                p0.l0(playlistMainComposablesKt$PlaylistPortraitBottomController$$inlined$ConstraintLayout$30);
            }
            boolean z3 = p0.i(q1);
            com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistPortraitBottomController..inlined.ConstraintLayout.4 playlistMainComposablesKt$PlaylistPortraitBottomController$$inlined$ConstraintLayout$40 = p0.N();
            if(z3 || playlistMainComposablesKt$PlaylistPortraitBottomController$$inlined$ConstraintLayout$40 == v9) {
                playlistMainComposablesKt$PlaylistPortraitBottomController$$inlined$ConstraintLayout$40 = new we.k(q1) {
                    public final x1.q f;

                    {
                        this.f = q0;
                        super(1);
                    }

                    @Override  // we.k
                    public Object invoke(Object object0) {
                        this.invoke(((X0.x)object0));
                        return H.a;
                    }

                    public final void invoke(X0.x x0) {
                        t.a(x0, this.f);
                    }
                };
                p0.l0(playlistMainComposablesKt$PlaylistPortraitBottomController$$inlined$ConstraintLayout$40);
            }
            g0.a(X0.n.c(q0, false, playlistMainComposablesKt$PlaylistPortraitBottomController$$inlined$ConstraintLayout$40), c.e(1200550679, p0, new we.n(b01, j0, playlistMainComposablesKt$PlaylistPortraitBottomController$$inlined$ConstraintLayout$30, v1, v, a1, n0, z, a5, a6, n2, s, a0, a7) {
                public final we.a B;
                public final we.a D;
                public final b0 f;
                public final x1.j g;
                public final we.a h;
                public final long i;
                public final long j;
                public final we.a k;
                public final we.n l;
                public final boolean m;
                public final we.a n;
                public final we.a o;
                public final we.n r;
                public final String w;

                {
                    this.f = b00;
                    this.g = j0;
                    this.h = a0;
                    this.i = v;
                    this.j = v1;
                    this.k = a1;
                    this.l = n0;
                    this.m = z;
                    this.n = a2;
                    this.o = a3;
                    this.r = n1;
                    this.w = s;
                    this.B = a4;
                    this.D = a5;
                    super(2);
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    this.invoke(((l)object0), ((Number)object1).intValue());
                    return H.a;
                }

                public final void invoke(l l0, int v) {
                    if((v & 3) == 2 && ((p)l0).D()) {
                        ((p)l0).T();
                        return;
                    }
                    this.f.setValue(H.a);
                    x1.j j0 = this.g;
                    int v1 = j0.b;
                    j0.h();
                    p p0 = (p)l0;
                    p0.a0(-930261105);
                    wa.a a0 = j0.f();
                    x1.e e0 = ((x1.j)a0.a).e();
                    x1.e e1 = ((x1.j)a0.a).e();
                    x1.e e2 = ((x1.j)a0.a).e();
                    x1.e e3 = ((x1.j)a0.a).e();
                    x1.e e4 = ((x1.j)a0.a).e();
                    x1.e e5 = ((x1.j)a0.a).e();
                    n n0 = n.a;
                    q q0 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(n0, 1.0f), 2.0f);
                    com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistPortraitBottomController.5.1.1 playlistMainComposablesKt$PlaylistPortraitBottomController$5$1$10 = p0.N();
                    V v2 = k.a;
                    if(playlistMainComposablesKt$PlaylistPortraitBottomController$5$1$10 == v2) {
                        playlistMainComposablesKt$PlaylistPortraitBottomController$5$1$10 = com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistPortraitBottomController.5.1.1.INSTANCE;
                        p0.l0(playlistMainComposablesKt$PlaylistPortraitBottomController$5$1$10);
                    }
                    q q1 = x1.j.b(q0, e0, playlistMainComposablesKt$PlaylistPortraitBottomController$5$1$10);
                    long v3 = e0.T(p0, 0x7F0604B0);  // color:white160en
                    long v4 = e0.T(p0, 0x7F06017C);  // color:green500s_support_high_contrast
                    c1.F(q1, this.i, this.j, v3, v4, p0, 0, 0);
                    q q2 = androidx.compose.foundation.layout.d.n(n0, 48.0f);
                    com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistPortraitBottomController.5.2.1 playlistMainComposablesKt$PlaylistPortraitBottomController$5$2$10 = p0.N();
                    if(playlistMainComposablesKt$PlaylistPortraitBottomController$5$2$10 == v2) {
                        playlistMainComposablesKt$PlaylistPortraitBottomController$5$2$10 = com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistPortraitBottomController.5.2.1.INSTANCE;
                        p0.l0(playlistMainComposablesKt$PlaylistPortraitBottomController$5$2$10);
                    }
                    PlaylistMainComposablesKt.access$SettingButton(r0.a.a(x1.j.b(q2, e1, playlistMainComposablesKt$PlaylistPortraitBottomController$5$2$10), new com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistPortraitBottomController.lambda.42..inlined.noRippleClickable-YQRRFTQ.default.1(true, null, 0, this.B)), p0, 0, 0);
                    boolean z = p0.g(e1);
                    boolean z1 = p0.g(e3);
                    com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistPortraitBottomController.5.4.1 playlistMainComposablesKt$PlaylistPortraitBottomController$5$4$10 = p0.N();
                    if(z || z1 || playlistMainComposablesKt$PlaylistPortraitBottomController$5$4$10 == v2) {
                        playlistMainComposablesKt$PlaylistPortraitBottomController$5$4$10 = new com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistPortraitBottomController.5.4.1(e1, e3);
                        p0.l0(playlistMainComposablesKt$PlaylistPortraitBottomController$5$4$10);
                    }
                    c1.E(x1.j.b(n0, e2, playlistMainComposablesKt$PlaylistPortraitBottomController$5$4$10), this.k, this.l, p0, 0);
                    com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistPortraitBottomController.5.5.1 playlistMainComposablesKt$PlaylistPortraitBottomController$5$5$10 = p0.N();
                    if(playlistMainComposablesKt$PlaylistPortraitBottomController$5$5$10 == v2) {
                        playlistMainComposablesKt$PlaylistPortraitBottomController$5$5$10 = com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistPortraitBottomController.5.5.1.INSTANCE;
                        p0.l0(playlistMainComposablesKt$PlaylistPortraitBottomController$5$5$10);
                    }
                    c1.z(0, p0, x1.j.b(n0, e3, playlistMainComposablesKt$PlaylistPortraitBottomController$5$5$10), this.n, this.m);
                    boolean z2 = p0.g(e3);
                    boolean z3 = p0.g(e5);
                    com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistPortraitBottomController.5.6.1 playlistMainComposablesKt$PlaylistPortraitBottomController$5$6$10 = p0.N();
                    if(z2 || z3 || playlistMainComposablesKt$PlaylistPortraitBottomController$5$6$10 == v2) {
                        playlistMainComposablesKt$PlaylistPortraitBottomController$5$6$10 = new com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistPortraitBottomController.5.6.1(e3, e5);
                        p0.l0(playlistMainComposablesKt$PlaylistPortraitBottomController$5$6$10);
                    }
                    c1.x(x1.j.b(n0, e4, playlistMainComposablesKt$PlaylistPortraitBottomController$5$6$10), this.o, this.r, p0, 0);
                    q q3 = androidx.compose.foundation.layout.d.n(n0, 48.0f);
                    com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistPortraitBottomController.5.7.1 playlistMainComposablesKt$PlaylistPortraitBottomController$5$7$10 = p0.N();
                    if(playlistMainComposablesKt$PlaylistPortraitBottomController$5$7$10 == v2) {
                        playlistMainComposablesKt$PlaylistPortraitBottomController$5$7$10 = com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistPortraitBottomController.5.7.1.INSTANCE;
                        p0.l0(playlistMainComposablesKt$PlaylistPortraitBottomController$5$7$10);
                    }
                    PlaylistMainComposablesKt.access$AlbumUri(r0.a.a(x1.j.b(q3, e5, playlistMainComposablesKt$PlaylistPortraitBottomController$5$7$10), new com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistPortraitBottomController.lambda.42..inlined.noRippleClickable-YQRRFTQ.default.2(true, null, 0, this.D)), this.w, p0, 0, 0);
                    p0.p(false);
                    if(j0.b != v1) {
                        J.h(this.h, p0);
                    }
                }
            }), playlistMainComposablesKt$PlaylistPortraitBottomController$$inlined$ConstraintLayout$20, p0, 0x30);
            p0.p(false);
            a8 = a5;
            a9 = a6;
            n3 = n2;
            a10 = a7;
        }
        else {
            p0.T();
            a9 = a3;
            n3 = n1;
            a10 = a4;
            a8 = a2;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.player.playlist.c(v, v1, a0, a1, n0, z, a8, a9, n3, s, a10, v2, v3, v4, 2);
        }

        @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001A\u00020\u0000H\u000B¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lie/H;", "invoke", "(Landroidx/compose/runtime/l;I)V", "<anonymous>"}, k = 3, mv = {2, 2, 0})
        public final class com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistPortraitBottomController..inlined.ConstraintLayout.1 extends r implements we.n {
            public final b0 f;

            public com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistPortraitBottomController..inlined.ConstraintLayout.1(b0 b00, x0 x00, x1.j j0, Channel channel0, b0 b01, b0 b02, long v, long v1, we.a a0, we.n n0, boolean z, we.a a1, we.a a2, we.n n1, String s, we.a a3, we.a a4) {
                this.f = b00;
                super(2);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                this.invoke(((l)object0), ((Number)object1).intValue());
                return H.a;
            }

            public final void invoke(l l0, int v) {
                if((v & 3) == 2 && ((p)l0).D()) {
                    ((p)l0).T();
                    return;
                }
                this.f.setValue(H.a);
                throw null;

                @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lie/H;", "invoke", "()V", "<anonymous>"}, k = 3, mv = {2, 2, 0})
                public final class com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistPortraitBottomController..inlined.ConstraintLayout.1.1 extends r implements we.a {
                    public final x1.j f;
                    public final b0 g;
                    public final b0 h;
                    public final Channel i;

                    public com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistPortraitBottomController..inlined.ConstraintLayout.1.1(x1.j j0, b0 b00, b0 b01, Channel channel0) {
                        this.f = j0;
                        this.g = b00;
                        this.h = b01;
                        this.i = channel0;
                        super(0);
                    }

                    @Override  // we.a
                    public Object invoke() {
                        this.invoke();
                        return H.a;
                    }

                    public final void invoke() {
                        x1.r r0 = new x1.r(this.f.a.D());
                        b0 b00 = this.g;
                        Object object0 = b00.getValue();
                        b0 b01 = this.h;
                        if(object0 != null && b01.getValue() != null) {
                            this.i.trySend-JP2dKIU(r0);
                            return;
                        }
                        b00.setValue(r0);
                        b01.setValue(b00.getValue());
                    }
                }

            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistPortraitBottomController.5.1.1 implements we.k {
            public static final com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistPortraitBottomController.5.1.1 INSTANCE;

            static {
                com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistPortraitBottomController.5.1.1.INSTANCE = new com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistPortraitBottomController.5.1.1();  // 初始化器: Ljava/lang/Object;-><init>()V
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((x1.d)object0));
                return H.a;
            }

            public final void invoke(x1.d d0) {
                kotlin.jvm.internal.q.g(d0, "$this$constrainAs");
                g.v(d0.e, d0.c.e, 0.0f, 6);
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistPortraitBottomController.5.2.1 implements we.k {
            public static final com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistPortraitBottomController.5.2.1 INSTANCE;

            static {
                com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistPortraitBottomController.5.2.1.INSTANCE = new com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistPortraitBottomController.5.2.1();  // 初始化器: Ljava/lang/Object;-><init>()V
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((x1.d)object0));
                return H.a;
            }

            public final void invoke(x1.d d0) {
                kotlin.jvm.internal.q.g(d0, "$this$constrainAs");
                W.p.l(d0.d, d0.c.d, 14.0f, 4);
                g.v(d0.e, d0.c.e, 0.0f, 6);
                g.v(d0.g, d0.c.g, 0.0f, 6);
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistPortraitBottomController.5.4.1 implements we.k {
            public final x1.e a;
            public final x1.e b;

            public com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistPortraitBottomController.5.4.1(x1.e e0, x1.e e1) {
                this.a = e0;
                this.b = e1;
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((x1.d)object0));
                return H.a;
            }

            public final void invoke(x1.d d0) {
                kotlin.jvm.internal.q.g(d0, "$this$constrainAs");
                g.v(d0.e, d0.c.e, 0.0f, 6);
                g.v(d0.g, d0.c.g, 0.0f, 6);
                W.p.l(d0.d, this.a.f, 0.0f, 6);
                W.p.l(d0.f, this.b.d, 0.0f, 6);
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistPortraitBottomController.5.5.1 implements we.k {
            public static final com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistPortraitBottomController.5.5.1 INSTANCE;

            static {
                com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistPortraitBottomController.5.5.1.INSTANCE = new com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistPortraitBottomController.5.5.1();  // 初始化器: Ljava/lang/Object;-><init>()V
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((x1.d)object0));
                return H.a;
            }

            public final void invoke(x1.d d0) {
                kotlin.jvm.internal.q.g(d0, "$this$constrainAs");
                g.v(d0.e, d0.c.e, 0.0f, 6);
                g.v(d0.g, d0.c.g, 0.0f, 6);
                W.p.l(d0.d, d0.c.d, 0.0f, 6);
                W.p.l(d0.f, d0.c.f, 0.0f, 6);
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistPortraitBottomController.5.6.1 implements we.k {
            public final x1.e a;
            public final x1.e b;

            public com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistPortraitBottomController.5.6.1(x1.e e0, x1.e e1) {
                this.a = e0;
                this.b = e1;
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((x1.d)object0));
                return H.a;
            }

            public final void invoke(x1.d d0) {
                kotlin.jvm.internal.q.g(d0, "$this$constrainAs");
                g.v(d0.e, d0.c.e, 0.0f, 6);
                g.v(d0.g, d0.c.g, 0.0f, 6);
                W.p.l(d0.d, this.a.f, 0.0f, 6);
                W.p.l(d0.f, this.b.d, 0.0f, 6);
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistPortraitBottomController.5.7.1 implements we.k {
            public static final com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistPortraitBottomController.5.7.1 INSTANCE;

            static {
                com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistPortraitBottomController.5.7.1.INSTANCE = new com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistPortraitBottomController.5.7.1();  // 初始化器: Ljava/lang/Object;-><init>()V
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((x1.d)object0));
                return H.a;
            }

            public final void invoke(x1.d d0) {
                kotlin.jvm.internal.q.g(d0, "$this$constrainAs");
                g.v(d0.e, d0.c.e, 0.0f, 6);
                g.v(d0.g, d0.c.g, 0.0f, 6);
                W.p.l(d0.f, d0.c.f, 12.0f, 4);
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistPortraitBottomController.lambda.42..inlined.noRippleClickable-YQRRFTQ.default.1 implements o {
            public com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistPortraitBottomController.lambda.42..inlined.noRippleClickable-YQRRFTQ.default.1(boolean z, String s, int v, we.a a0) {
            }

            @Override  // we.o
            public Object invoke(Object object0, Object object1, Object object2) {
                return this.invoke(((q)object0), ((l)object1), ((Number)object2).intValue());
            }

            public final q invoke(q q0, l l0, int v) {
                kotlin.jvm.internal.q.g(q0, "$this$composed");
                ((p)l0).a0(0x1FF03545);
                w0.h h0 = (w0.h)((p)l0).k(k0.i);
                K.m m0 = ((p)l0).N();
                if(m0 == k.a) {
                    m0 = androidx.appcompat.app.o.d(((p)l0));
                }
                X0.i i0 = new X0.i(this.c);
                com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistPortraitBottomController.lambda.42..inlined.noRippleClickable-YQRRFTQ.default.1.1 playlistMainComposablesKt$PlaylistPortraitBottomController$lambda$42$$inlined$noRippleClickable-YQRRFTQ$default$1$10 = new we.a() {
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
                q q1 = androidx.compose.foundation.q.l(q0, m0, null, this.a, this.b, i0, playlistMainComposablesKt$PlaylistPortraitBottomController$lambda$42$$inlined$noRippleClickable-YQRRFTQ$default$1$10);
                ((p)l0).p(false);
                return q1;
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistPortraitBottomController.lambda.42..inlined.noRippleClickable-YQRRFTQ.default.2 implements o {
            public com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistPortraitBottomController.lambda.42..inlined.noRippleClickable-YQRRFTQ.default.2(boolean z, String s, int v, we.a a0) {
            }

            @Override  // we.o
            public Object invoke(Object object0, Object object1, Object object2) {
                return this.invoke(((q)object0), ((l)object1), ((Number)object2).intValue());
            }

            public final q invoke(q q0, l l0, int v) {
                kotlin.jvm.internal.q.g(q0, "$this$composed");
                ((p)l0).a0(0x1FF03545);
                w0.h h0 = (w0.h)((p)l0).k(k0.i);
                K.m m0 = ((p)l0).N();
                if(m0 == k.a) {
                    m0 = androidx.appcompat.app.o.d(((p)l0));
                }
                X0.i i0 = new X0.i(this.c);
                com.iloen.melon.player.playlist.PlaylistMainComposablesKt.PlaylistPortraitBottomController.lambda.42..inlined.noRippleClickable-YQRRFTQ.default.2.1 playlistMainComposablesKt$PlaylistPortraitBottomController$lambda$42$$inlined$noRippleClickable-YQRRFTQ$default$2$10 = new we.a() {
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
                q q1 = androidx.compose.foundation.q.l(q0, m0, null, this.a, this.b, i0, playlistMainComposablesKt$PlaylistPortraitBottomController$lambda$42$$inlined$noRippleClickable-YQRRFTQ$default$2$10);
                ((p)l0).p(false);
                return q1;
            }
        }

    }

    public static final void PlaylistPortraitBottomControllerLayoutPreview(@Nullable l l0, int v) {
        ((p)l0).c0(0xF8EDBC0D);
        if(((p)l0).Q(v & 1, v != 0)) {
            e e0 = ((p)l0).N();
            V v1 = k.a;
            if(e0 == v1) {
                e0 = new e(24);
                ((p)l0).l0(e0);
            }
            e e1 = ((p)l0).N();
            if(e1 == v1) {
                e1 = new e(24);
                ((p)l0).l0(e1);
            }
            B1 b10 = ((p)l0).N();
            if(b10 == v1) {
                b10 = new B1(6);
                ((p)l0).l0(b10);
            }
            e e2 = ((p)l0).N();
            if(e2 == v1) {
                e2 = new e(24);
                ((p)l0).l0(e2);
            }
            e e3 = ((p)l0).N();
            if(e3 == v1) {
                e3 = new e(24);
                ((p)l0).l0(e3);
            }
            B1 b11 = ((p)l0).N();
            if(b11 == v1) {
                b11 = new B1(6);
                ((p)l0).l0(b11);
            }
            e e4 = ((p)l0).N();
            if(e4 == v1) {
                e4 = new e(24);
                ((p)l0).l0(e4);
            }
            PlaylistMainComposablesKt.PlaylistPortraitBottomController(1000L, 10000L, e0, e1, b10, true, e2, e3, b11, "", e4, ((p)l0), 920350134, 6, 0);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new z(v, 12, 0);
        }
    }

    public static final void a(q q0, String s, l l0, int v, int v1) {
        q q9;
        int v2;
        p p0 = (p)l0;
        p0.c0(0xAC3429F0);
        if((v1 & 1) == 0) {
            v2 = (v & 6) == 0 ? v | (p0.g(q0) ? 4 : 2) : v;
        }
        else {
            v2 = v | 6;
        }
        if((v & 0x30) == 0) {
            v2 |= (p0.g(s) ? 0x20 : 16);
        }
        if(p0.Q(v2 & 1, (v2 & 19) != 18)) {
            n n0 = n.a;
            q q1 = (v1 & 1) == 0 ? q0 : n0;
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            n3 n30 = c1.W(p0, 1);
            boolean z = p0.i(n30);
            boolean z1 = p0.i(context0);
            PlaylistMainComposablesKt.AlbumUri.1.1 playlistMainComposablesKt$AlbumUri$1$10 = p0.N();
            V v3 = k.a;
            if((((v2 & 0x70) == 0x20 ? 1 : 0) | (z | z1)) != 0 || playlistMainComposablesKt$AlbumUri$1$10 == v3) {
                playlistMainComposablesKt$AlbumUri$1$10 = new PlaylistMainComposablesKt.AlbumUri.1.1(n30, context0, s, null);
                p0.l0(playlistMainComposablesKt$AlbumUri$1$10);
            }
            J.d(p0, s, playlistMainComposablesKt$AlbumUri$1$10);
            String s1 = H0.e.Y(p0, 0x7F130BD1);  // string:talkback_player_open_empty_playlist "플레이어 전환"
            boolean z2 = p0.g(s1);
            com.iloen.melon.player.playlist.a a0 = p0.N();
            if(z2 || a0 == v3) {
                a0 = new com.iloen.melon.player.playlist.a(s1, 0);
                p0.l0(a0);
            }
            q q2 = X0.n.c(q1, true, a0);
            r0.i i0 = d.a;
            M m0 = M.p.d(i0, false);
            int v4 = p0.P;
            i0 i00 = p0.m();
            q q3 = r0.a.d(p0, q2);
            P0.k.y.getClass();
            i i1 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            h h0 = j.f;
            w.x(p0, m0, h0);
            h h1 = j.e;
            w.x(p0, i00, h1);
            h h2 = j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            h h3 = j.d;
            w.x(p0, q3, h3);
            q q4 = androidx.compose.foundation.layout.d.n(n0, 32.0f);
            q q5 = (androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q4, d.e);
            M m1 = M.p.d(i0, false);
            int v5 = p0.P;
            i0 i01 = p0.m();
            q q6 = r0.a.d(p0, q5);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, m1, h0);
            w.x(p0, i01, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h2);
            }
            w.x(p0, q6, h3);
            T.d d0 = T.e.b(4.0f);
            c1.n(androidx.compose.foundation.q.f(d5.n.o(androidx.compose.foundation.layout.d.c, d0), e0.T(p0, 0x7F0604BB), y0.M.a), null, null, null, true, 0x7F080795, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x36030, 0, 0x7FCC);  // color:white_10
            T.d d1 = T.e.b(4.0f);
            q q7 = d5.n.o(androidx.compose.foundation.layout.d.c, d1);
            q q8 = androidx.compose.foundation.q.i(0.5f, e0.T(p0, 0x7F0604AE), q7, T.e.b(4.0f));  // color:white120e
            j5.n.b(((t5.j)((O0)n30.c).getValue()), null, q8, null, N0.j.b, null, p0, 0x180030, 0xFB8);
            p0.p(true);
            p0.p(true);
            q9 = q1;
        }
        else {
            p0.T();
            q9 = q0;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.player.playlist.b(q9, s, v, v1, 0);
        }
    }

    public static final void access$AlbumUri(q q0, String s, l l0, int v, int v1) {
        PlaylistMainComposablesKt.a(q0, s, l0, v, v1);
    }

    public static final int access$PlaylistBg$lambda$10(a0 a00) {
        return ((K0)a00).m();
    }

    public static final void access$PlaylistBg$lambda$11(a0 a00, int v) {
        ((K0)a00).n(v);
    }

    public static final void access$PlaylistBg$lambda$2(b0 b00, PlaylistBgType playlistBgType0) {
        b00.setValue(playlistBgType0);
    }

    public static final void access$PlaylistBg$lambda$5(b0 b00, pc.b b0) {
        b00.setValue(b0);
    }

    public static final void access$PlaylistBg$lambda$8(b0 b00, PlayBgColorData playBgColorData0) {
        b00.setValue(playBgColorData0);
    }

    public static final void access$SettingButton(q q0, l l0, int v, int v1) {
        PlaylistMainComposablesKt.c(q0, l0, v, v1);
    }

    public static final void b(q q0, pc.b b0, l l0, int v) {
        ((p)l0).c0(0xAFFA264A);
        int v1 = (((p)l0).e((b0 == null ? -1 : b0.ordinal())) ? 0x20 : 16) | v;
        if(((p)l0).Q(v1 & 1, (v1 & 19) != 18)) {
            if(b0 == null) {
                ((p)l0).a0(0xA6EB32F8);
            }
            else {
                ((p)l0).a0(0xA73000E7);
                M.p.a(androidx.compose.foundation.q.f(q0, y0.M.e(x1.a.z(b0)), y0.M.a), ((p)l0), 0);
            }
            ((p)l0).p(false);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.fragments.artistchannel.viewholder.e(q0, b0, v, 5);
        }
    }

    public static final void c(q q0, l l0, int v, int v1) {
        q q1;
        int v2;
        p p0 = (p)l0;
        p0.c0(0xF9F53ACE);
        if((v1 & 1) != 0) {
            v2 = v | 6;
            q1 = q0;
        }
        else if((v & 6) == 0) {
            q1 = q0;
            v2 = v | (p0.g(q1) ? 4 : 2);
        }
        else {
            q1 = q0;
            v2 = v;
        }
        if(p0.Q(v2 & 1, (v2 & 3) != 2)) {
            n n0 = n.a;
            q q2 = (v1 & 1) == 0 ? q1 : n0;
            String s = H0.e.Y(p0, 0x7F130BB7);  // string:talkback_play_condition_setting_btn "재생환경 설정 버튼"
            boolean z = p0.g(s);
            com.iloen.melon.player.playlist.a a0 = p0.N();
            if(z || a0 == k.a) {
                a0 = new com.iloen.melon.player.playlist.a(s, 1);
                p0.l0(a0);
            }
            q q3 = X0.n.c(q2, true, a0);
            M m0 = M.p.d(d.a, false);
            int v3 = p0.P;
            i0 i00 = p0.m();
            q q4 = r0.a.d(p0, q3);
            P0.k.y.getClass();
            i i0 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, m0, j.f);
            w.x(p0, i00, j.e);
            h h0 = j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h0);
            }
            w.x(p0, q4, j.d);
            q q5 = androidx.compose.foundation.layout.d.n(n0, 28.0f);
            c1.n((androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q5, d.e), 0x7F080180, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x6030, 0, 0x7FEC);  // drawable:btn_cpplaylist_control_setting
            p0.p(true);
            q1 = q2;
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new P2(q1, v, v1, 1);
        }
    }
}

