package com.iloen.melon.playback;

import ac.w;
import com.iloen.melon.net.mcp.Area;
import we.k;

public final class a implements k {
    public final String a;
    public final String b;
    public final Area c;
    public final w d;
    public final long e;
    public final long f;

    public a(String s, String s1, Area area0, w w0, long v, long v1) {
        this.a = s;
        this.b = s1;
        this.c = area0;
        this.d = w0;
        this.e = v;
        this.f = v1;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        return EpPlayLogger.sendPlayEventAndPolling$lambda$4(this.a, this.b, this.c, this.d, this.e, this.f, ((StringBuilder)object0));
    }
}

