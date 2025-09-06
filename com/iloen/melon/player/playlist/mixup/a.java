package com.iloen.melon.player.playlist.mixup;

import androidx.compose.runtime.b0;
import ie.H;

public final class a implements we.a {
    public final int a;
    public final b0 b;

    public a(b0 b00, int v) {
        this.a = v;
        this.b = b00;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        b0 b00 = this.b;
        if(this.a != 0) {
            Boolean boolean0 = (Boolean)b00.getValue();
            boolean0.getClass();
            return boolean0;
        }
        b00.setValue(Boolean.valueOf(!((Boolean)b00.getValue()).booleanValue()));
        return H.a;
    }
}

