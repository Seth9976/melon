package com.iloen.melon.player.playlist.music.composables;

import Ib.b;
import K.m;
import Q0.k0;
import X0.i;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import com.iloen.melon.fragments.mymusic.dna.d;
import d5.w;
import e1.F;
import ie.H;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import m0.c;
import oc.c0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r0.n;
import w0.h;
import we.a;
import we.o;

@Metadata(d1 = {"\u0000&\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001A}\u0010\u0010\u001A\u00020\n2\u0006\u0010\u0001\u001A\u00020\u00002\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0004\u001A\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\u00072\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"", "isSelected", "", "songCountString", "sortMode", "LIb/b;", "offlineState", "Loc/c0;", "sectionSelectState", "Lkotlin/Function0;", "Lie/H;", "allSelectClick", "orderClick", "onOfflineButtonClicked", "onSectionSelectButtonClick", "onSectionSelectCancelClick", "MusicPlaylistHeader", "(ZLjava/lang/String;Ljava/lang/String;LIb/b;Loc/c0;Lwe/a;Lwe/a;Lwe/a;Lwe/a;Lwe/a;Landroidx/compose/runtime/l;I)V", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class MusicPlaylistHeaderKt {
    public static final void MusicPlaylistHeader(boolean z, @NotNull String s, @NotNull String s1, @NotNull b b0, @NotNull c0 c00, @NotNull a a0, @NotNull a a1, @NotNull a a2, @NotNull a a3, @NotNull a a4, @Nullable l l0, int v) {
        p p0;
        boolean z2;
        q.g(s, "songCountString");
        q.g(s1, "sortMode");
        q.g(b0, "offlineState");
        q.g(c00, "sectionSelectState");
        q.g(a0, "allSelectClick");
        q.g(a1, "orderClick");
        q.g(a2, "onOfflineButtonClicked");
        q.g(a3, "onSectionSelectButtonClick");
        q.g(a4, "onSectionSelectCancelClick");
        ((p)l0).c0(0x5DF132EB);
        int v1 = (v & 6) == 0 ? (((p)l0).h(z) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (((p)l0).g(s) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v1 |= (((p)l0).g(s1) ? 0x100 : 0x80);
        }
        if((v & 0xC00) == 0) {
            v1 |= (((p)l0).e(b0.ordinal()) ? 0x800 : 0x400);
        }
        if((v & 0x6000) == 0) {
            v1 |= (((p)l0).e(c00.ordinal()) ? 0x4000 : 0x2000);
        }
        if((0x30000 & v) == 0) {
            v1 |= (((p)l0).i(a0) ? 0x20000 : 0x10000);
        }
        if((0x180000 & v) == 0) {
            v1 |= (((p)l0).i(a1) ? 0x100000 : 0x80000);
        }
        if((0xC00000 & v) == 0) {
            v1 |= (((p)l0).i(a2) ? 0x800000 : 0x400000);
        }
        if((0x6000000 & v) == 0) {
            v1 |= (((p)l0).i(a3) ? 0x4000000 : 0x2000000);
        }
        if((0x30000000 & v) == 0) {
            v1 |= (((p)l0).i(a4) ? 0x20000000 : 0x10000000);
        }
        boolean z1 = true;
        if(((p)l0).Q(v1 & 1, (306783379 & v1) != 306783378)) {
            d d0 = ((p)l0).N();
            if(d0 == k.a) {
                d0 = new d(19);
                ((p)l0).l0(d0);
            }
            if(!((Boolean)w.P(new Object[0], null, null, d0, ((p)l0), 0, 6)).booleanValue() || z) {
                z2 = false;
            }
            else {
                c0.a.getClass();
                z2 = F.u(c00) ? false : true;
            }
            if(z) {
                z1 = false;
            }
            else {
                c0.a.getClass();
                if(F.u(c00)) {
                    z1 = false;
                }
            }
            r0.q q0 = androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.d.h(n.a, 42.0f), 1.0f);
            m0.b b1 = c.e(1024095061, ((p)l0), new com.iloen.melon.player.playlist.music.composables.a(s, s1, z2, b0, a2, z1, a1, c00, a3, a4, z, a0));
            p0 = (p)l0;
            M.c.a(q0, null, false, b1, p0, 0xC06, 6);
        }
        else {
            p0 = (p)l0;
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.player.playlist.music.composables.b(z, s, s1, b0, c00, a0, a1, a2, a3, a4, v);
        }

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.player.playlist.music.composables.MusicPlaylistHeaderKt.MusicPlaylistHeader.lambda.8.lambda.7.lambda.6..inlined.noRippleClickable-YQRRFTQ.default.1 implements o {
            public com.iloen.melon.player.playlist.music.composables.MusicPlaylistHeaderKt.MusicPlaylistHeader.lambda.8.lambda.7.lambda.6..inlined.noRippleClickable-YQRRFTQ.default.1(boolean z, String s, int v, a a0) {
            }

            @Override  // we.o
            public Object invoke(Object object0, Object object1, Object object2) {
                return this.invoke(((r0.q)object0), ((l)object1), ((Number)object2).intValue());
            }

            public final r0.q invoke(r0.q q0, l l0, int v) {
                q.g(q0, "$this$composed");
                ((p)l0).a0(0x1FF03545);
                h h0 = (h)((p)l0).k(k0.i);
                m m0 = ((p)l0).N();
                if(m0 == k.a) {
                    m0 = androidx.appcompat.app.o.d(((p)l0));
                }
                i i0 = new i(this.c);
                com.iloen.melon.player.playlist.music.composables.MusicPlaylistHeaderKt.MusicPlaylistHeader.lambda.8.lambda.7.lambda.6..inlined.noRippleClickable-YQRRFTQ.default.1.1 musicPlaylistHeaderKt$MusicPlaylistHeader$lambda$8$lambda$7$lambda$6$$inlined$noRippleClickable-YQRRFTQ$default$1$10 = new a() {
                    @Override  // we.a
                    public Object invoke() {
                        this.invoke();
                        return H.a;
                    }

                    public final void invoke() {
                        h.a(this.d);
                        this.b.invoke();
                    }
                };
                r0.q q1 = androidx.compose.foundation.q.l(q0, m0, null, this.a, this.b, i0, musicPlaylistHeaderKt$MusicPlaylistHeader$lambda$8$lambda$7$lambda$6$$inlined$noRippleClickable-YQRRFTQ$default$1$10);
                ((p)l0).p(false);
                return q1;
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.player.playlist.music.composables.MusicPlaylistHeaderKt.MusicPlaylistHeader.lambda.8.lambda.7.lambda.6..inlined.noRippleClickable-YQRRFTQ.default.2 implements o {
            public com.iloen.melon.player.playlist.music.composables.MusicPlaylistHeaderKt.MusicPlaylistHeader.lambda.8.lambda.7.lambda.6..inlined.noRippleClickable-YQRRFTQ.default.2(boolean z, String s, int v, a a0) {
            }

            @Override  // we.o
            public Object invoke(Object object0, Object object1, Object object2) {
                return this.invoke(((r0.q)object0), ((l)object1), ((Number)object2).intValue());
            }

            public final r0.q invoke(r0.q q0, l l0, int v) {
                q.g(q0, "$this$composed");
                ((p)l0).a0(0x1FF03545);
                h h0 = (h)((p)l0).k(k0.i);
                m m0 = ((p)l0).N();
                if(m0 == k.a) {
                    m0 = androidx.appcompat.app.o.d(((p)l0));
                }
                i i0 = new i(this.c);
                com.iloen.melon.player.playlist.music.composables.MusicPlaylistHeaderKt.MusicPlaylistHeader.lambda.8.lambda.7.lambda.6..inlined.noRippleClickable-YQRRFTQ.default.2.1 musicPlaylistHeaderKt$MusicPlaylistHeader$lambda$8$lambda$7$lambda$6$$inlined$noRippleClickable-YQRRFTQ$default$2$10 = new a() {
                    @Override  // we.a
                    public Object invoke() {
                        this.invoke();
                        return H.a;
                    }

                    public final void invoke() {
                        h.a(this.d);
                        this.b.invoke();
                    }
                };
                r0.q q1 = androidx.compose.foundation.q.l(q0, m0, null, this.a, this.b, i0, musicPlaylistHeaderKt$MusicPlaylistHeader$lambda$8$lambda$7$lambda$6$$inlined$noRippleClickable-YQRRFTQ$default$2$10);
                ((p)l0).p(false);
                return q1;
            }
        }

    }
}

