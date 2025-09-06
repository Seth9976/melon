package com.melon.playback.melon.drm;

import com.iloen.melon.drm.DcfFile;
import oe.c;

public final class b extends c {
    public Object B;
    public final com.melon.playback.melon.drm.c D;
    public int E;
    public DcfFile r;
    public boolean w;

    public b(com.melon.playback.melon.drm.c c0, c c1) {
        this.D = c0;
        super(c1);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return this.D.b(null, false, this);
    }
}

