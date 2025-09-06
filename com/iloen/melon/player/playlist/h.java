package com.iloen.melon.player.playlist;

import J8.H2;
import J8.i1;

public final class h implements Runnable {
    public final H2 a;
    public final i1 b;
    public final int c;

    public h(H2 h20, i1 i10, int v) {
        this.a = h20;
        this.b = i10;
        this.c = v;
    }

    @Override
    public final void run() {
        boolean z = this.b.h.getSelectedTabPosition() == this.c;
        this.a.b.setChecked(z);
    }
}

