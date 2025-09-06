package com.iloen.melon.player.playlist.common.scrollbar;

import K.b;
import K.c;
import K.l;
import K.m;
import androidx.compose.runtime.b0;
import kotlin.jvm.internal.H;
import we.a;

public final class d implements a {
    public final int a;
    public final H b;
    public final l c;
    public final b0 d;

    public d(H h0, l l0, b0 b00, int v) {
        this.a = v;
        this.b = h0;
        this.c = l0;
        this.d = b00;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            b b0 = (b)this.b.a;
            if(b0 != null) {
                l l0 = this.c;
                if(l0 != null) {
                    ((m)l0).b(new K.a(b0));
                }
            }
            ScrollbarKt.access$Scrollbar_jIwJxvA$lambda$2(this.d, 0x7FC000007FC00000L);
            return ie.H.a;
        }
        b b1 = (b)this.b.a;
        if(b1 != null) {
            l l1 = this.c;
            if(l1 != null) {
                ((m)l1).b(new c(b1));
            }
        }
        ScrollbarKt.access$Scrollbar_jIwJxvA$lambda$2(this.d, 0x7FC000007FC00000L);
        return ie.H.a;
    }
}

