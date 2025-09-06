package jd;

import Na.f;
import com.iloen.melon.custom.L0;
import kotlin.jvm.internal.H;
import oe.c;

public final class v0 extends c {
    public f B;
    public q D;
    public Object E;
    public H G;
    public int I;
    public int M;
    public Object N;
    public final M0 S;
    public int T;
    public L0 r;
    public String w;

    public v0(M0 m00, c c0) {
        this.S = m00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.N = object0;
        this.T |= 0x80000000;
        return this.S.onFetchStart(null, this);
    }
}

