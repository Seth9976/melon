package t0;

import kotlinx.coroutines.channels.ChannelIterator;

public final class c extends oe.c {
    public Object B;
    public final d D;
    public int E;
    public d r;
    public ChannelIterator w;

    public c(d d0, oe.c c0) {
        this.D = d0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return this.D.a(this);
    }
}

