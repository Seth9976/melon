package com.iloen.melon.player.playlist.drawernew;

import K.m;
import Q0.k0;
import X0.i;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import ie.H;
import kotlin.Metadata;
import r0.q;
import w0.h;
import we.a;
import we.o;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
public final class DrawerSongFragmentKt.PlaylistFunctionHeader.lambda.12.lambda.9..inlined.noRippleClickable-YQRRFTQ.default.1 implements o {
    public final boolean a;
    public final String b;
    public final int c;
    public final a d;

    public DrawerSongFragmentKt.PlaylistFunctionHeader.lambda.12.lambda.9..inlined.noRippleClickable-YQRRFTQ.default.1(boolean z, String s, int v, a a0) {
        this.a = z;
        this.b = s;
        this.c = v;
        this.d = a0;
        super();
    }

    @Override  // we.o
    public Object invoke(Object object0, Object object1, Object object2) {
        return this.invoke(((q)object0), ((l)object1), ((Number)object2).intValue());
    }

    public final q invoke(q q0, l l0, int v) {
        kotlin.jvm.internal.q.g(q0, "$this$composed");
        ((p)l0).a0(0x1FF03545);
        h h0 = (h)((p)l0).k(k0.i);
        m m0 = ((p)l0).N();
        if(m0 == k.a) {
            m0 = androidx.appcompat.app.o.d(((p)l0));
        }
        i i0 = new i(this.c);
        com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentKt.PlaylistFunctionHeader.lambda.12.lambda.9..inlined.noRippleClickable-YQRRFTQ.default.1.1 drawerSongFragmentKt$PlaylistFunctionHeader$lambda$12$lambda$9$$inlined$noRippleClickable-YQRRFTQ$default$1$10 = new a() {
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
        q q1 = androidx.compose.foundation.q.l(q0, m0, null, this.a, this.b, i0, drawerSongFragmentKt$PlaylistFunctionHeader$lambda$12$lambda$9$$inlined$noRippleClickable-YQRRFTQ$default$1$10);
        ((p)l0).p(false);
        return q1;
    }
}

