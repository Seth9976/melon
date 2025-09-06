package com.iloen.melon.player.playlist.common.scrollbar;

import J0.v;
import androidx.compose.runtime.b0;
import ie.H;
import kotlin.jvm.internal.q;
import we.n;
import x0.b;

public final class e implements n {
    public final b0 a;

    public e(b0 b00) {
        this.a = b00;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        float f = (float)(((Float)object1));
        q.g(((v)object0), "<unused var>");
        b0 b00 = this.a;
        if(!b.b(ScrollbarKt.access$Scrollbar_jIwJxvA$lambda$1(b00), 0x7FC000007FC00000L)) {
            ScrollbarKt.access$Scrollbar_jIwJxvA$lambda$2(b00, b.a(1, ScrollbarKt.access$Scrollbar_jIwJxvA$lambda$1(b00), Float.intBitsToFloat(((int)(ScrollbarKt.access$Scrollbar_jIwJxvA$lambda$1(b00) & 0xFFFFFFFFL))) + f));
        }
        return H.a;
    }
}

