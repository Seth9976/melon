package com.iloen.melon.player.playlist.mixup.composables;

import I.G1;
import J0.y;
import M.b;
import M.j;
import M.p0;
import M.q0;
import P0.h;
import P0.i;
import U4.x;
import android.content.Context;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.V;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.iloen.melon.custom.l1;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.player.playlist.common.PlaylistCommonSongListComposableKt;
import com.iloen.melon.player.playlist.mixup.MixUpUIItemData.PlayableItem;
import com.iloen.melon.player.playlist.mixup.MixUpUIItemData;
import com.melon.playlist.interfaces.PlayableData;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r0.n;
import r0.q;
import we.a;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A7\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\u0001\u001A\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u00002\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001A\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lr0/q;", "modifier", "longPressDetectModifier", "Lkotlin/Function0;", "Lcom/iloen/melon/player/playlist/mixup/MixUpUIItemData;", "getItem", "Lcom/iloen/melon/player/playlist/mixup/composables/SongListClickListener;", "songListClickListener", "Lie/H;", "MixUpSongItemInPlaylist", "(Lr0/q;Lr0/q;Lwe/a;Lcom/iloen/melon/player/playlist/mixup/composables/SongListClickListener;Landroidx/compose/runtime/l;II)V", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class MixUpSongListKt {
    public static final void MixUpSongItemInPlaylist(@Nullable q q0, @NotNull q q1, @NotNull a a0, @NotNull SongListClickListener songListClickListener0, @Nullable l l0, int v, int v1) {
        h h4;
        com.iloen.melon.player.playlist.mixup.composables.a a1;
        n0 n00;
        q q2;
        int v2;
        kotlin.jvm.internal.q.g(q1, "longPressDetectModifier");
        kotlin.jvm.internal.q.g(a0, "getItem");
        kotlin.jvm.internal.q.g(songListClickListener0, "songListClickListener");
        p p0 = (p)l0;
        p0.c0(960580054);
        if((v1 & 1) != 0) {
            v2 = v | 6;
            q2 = q0;
        }
        else if((v & 6) == 0) {
            q2 = q0;
            v2 = (p0.g(q2) ? 4 : 2) | v;
        }
        else {
            q2 = q0;
            v2 = v;
        }
        if((v & 0x30) == 0) {
            v2 |= (p0.g(q1) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v2 |= (p0.i(a0) ? 0x100 : 0x80);
        }
        if((v & 0xC00) == 0) {
            v2 |= (p0.g(songListClickListener0) ? 0x800 : 0x400);
        }
        if(p0.Q(v2 & 1, (v2 & 0x493) != 1170)) {
            n n0 = n.a;
            if((v1 & 1) != 0) {
                q2 = n0;
            }
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            MixUpUIItemData mixUpUIItemData0 = (MixUpUIItemData)a0.invoke();
            PlayableItem mixUpUIItemData$PlayableItem0 = mixUpUIItemData0 instanceof PlayableItem ? ((PlayableItem)mixUpUIItemData0) : null;
            if(mixUpUIItemData$PlayableItem0 == null) {
                n00 = p0.t();
                if(n00 != null) {
                    a1 = new com.iloen.melon.player.playlist.mixup.composables.a(q2, q1, a0, songListClickListener0, v, v1, 0);
                    n00.d = a1;
                }
            }
            else {
                PlayableData playableData0 = mixUpUIItemData$PlayableItem0.getPlayableData();
                Playable playable0 = playableData0.a;
                q q3 = d.h(d.f(q2, 1.0f), 60.0f);
                boolean z = p0.i(context0);
                c c0 = p0.N();
                V v3 = k.a;
                if(((v2 & 0x380) == 0x100 | z | ((v2 & 0x1C00) == 0x800 ? 1 : 0)) != 0 || c0 == v3) {
                    c0 = new c(a0, context0, songListClickListener0, 0);
                    p0.l0(c0);
                }
                q q4 = X0.n.b(q3, c0);
                r0.h h0 = r0.d.k;
                b b0 = j.a;
                p0 p00 = M.n0.a(b0, h0, p0, 0x30);
                int v4 = p0.P;
                i0 i00 = p0.m();
                q q5 = r0.a.d(p0, q4);
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
                if(p0.O) {
                    h4 = h2;
                    A7.d.q(v4, p0, v4, h3);
                }
                else {
                    h4 = h2;
                    if(!kotlin.jvm.internal.q.b(p0.N(), v4)) {
                        A7.d.q(v4, p0, v4, h3);
                    }
                }
                h h5 = P0.j.d;
                w.x(p0, q5, h5);
                q q6 = d.c(q0.a(n0, 1.0f), 1.0f);
                com.iloen.melon.player.playlist.mixup.composables.MixUpSongListKt.MixUpSongItemInPlaylist.2.1.1 mixUpSongListKt$MixUpSongItemInPlaylist$2$1$10 = p0.N();
                if((((v2 & 0x380) == 0x100 ? 1 : 0) | ((v2 & 0x1C00) == 0x800 ? 1 : 0)) != 0 || mixUpSongListKt$MixUpSongItemInPlaylist$2$1$10 == v3) {
                    mixUpSongListKt$MixUpSongItemInPlaylist$2$1$10 = new PointerInputEventHandler() {
                        public final a a;
                        public final SongListClickListener b;

                        {
                            a a0 = a0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                            SongListClickListener songListClickListener0 = songListClickListener0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                            this.a = a0;
                            this.b = songListClickListener0;
                        }

                        @Override  // androidx.compose.ui.input.pointer.PointerInputEventHandler
                        public final Object invoke(y y0, Continuation continuation0) {
                            Object object0 = G1.d(y0, new e(this.a, this.b, 0), null, new e(this.a, this.b, 1), continuation0, 5);
                            return object0 == ne.a.a ? object0 : H.a;
                        }
                    };
                    p0.l0(mixUpSongListKt$MixUpSongItemInPlaylist$2$1$10);
                }
                q q7 = J0.H.a(q6, H.a, mixUpSongListKt$MixUpSongItemInPlaylist$2$1$10);
                p0 p01 = M.n0.a(b0, h0, p0, 0x30);
                int v5 = p0.P;
                i0 i01 = p0.m();
                q q8 = r0.a.d(p0, q7);
                p0.e0();
                if(p0.O) {
                    p0.l(i0);
                }
                else {
                    p0.o0();
                }
                w.x(p0, p01, h1);
                w.x(p0, i01, h4);
                if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v5)) {
                    A7.d.q(v5, p0, v5, h3);
                }
                w.x(p0, q8, h5);
                M.c.d(p0, d.q(n0, 20.0f));
                boolean z1 = ((PlayableItem)mixUpUIItemData0).isSelected();
                boolean z2 = p0.i(mixUpUIItemData0);
                com.iloen.melon.player.playlist.mixup.composables.d d0 = p0.N();
                if((v2 & 0x1C00) == 0x800 || z2 || d0 == v3) {
                    d0 = new com.iloen.melon.player.playlist.mixup.composables.d(songListClickListener0, mixUpUIItemData0, 0);
                    p0.l0(d0);
                }
                PlaylistCommonSongListComposableKt.Selector(z1, d0, p0, 0);
                M.c.d(p0, d.q(n0, 14.0f));
                String s = playableData0.m.toString();
                kotlin.jvm.internal.q.f(s, "toString(...)");
                boolean z3 = ((PlayableItem)mixUpUIItemData0).isCurrentPlaylist();
                boolean z4 = ((PlayableItem)mixUpUIItemData0).isCurrent();
                boolean z5 = ((PlayableItem)mixUpUIItemData0).isPlaying();
                boolean z6 = p0.i(mixUpUIItemData0);
                boolean z7 = p0.i(playable0);
                com.iloen.melon.player.playlist.mixup.composables.b b1 = p0.N();
                if((z6 | (v2 & 0x1C00) == 0x800 | z7) != 0 || b1 == v3) {
                    b1 = new com.iloen.melon.player.playlist.mixup.composables.b(songListClickListener0, mixUpUIItemData0, playable0, 1);
                    p0.l0(b1);
                }
                PlaylistCommonSongListComposableKt.SongThumbNailLayoutIsPlaying(s, z3, z4, z5, b1, p0, 0);
                M.c.d(p0, d.q(n0, 10.0f));
                PlaylistCommonSongListComposableKt.SongTitleAndArtistLayout(q0.a(n0, 1.0f), "", l1.n("", "getSongName(...)", playable0, "getArtistNames(...)"), playable0.isAdult(), null, false, ((PlayableItem)mixUpUIItemData0).isCurrent(), ((PlayableItem)mixUpUIItemData0).isMarquee(), p0, 0x36000, 0);
                x.z(n0, 2.0f, p0, true);
                PlaylistCommonSongListComposableKt.MoveIconLayout(null, q1, p0, v2 & 0x70, 1);
                p0.p(true);
                goto label_118;
            }
        }
        else {
            p0.T();
        label_118:
            n00 = p0.t();
            if(n00 != null) {
                a1 = new com.iloen.melon.player.playlist.mixup.composables.a(q2, q1, a0, songListClickListener0, v, v1, 1);
                n00.d = a1;
            }
        }
    }
}

