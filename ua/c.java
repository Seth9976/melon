package Ua;

public final class c extends oe.c {
    public int B;
    public Object r;
    public final h w;

    public c(h h0, oe.c c0) {
        this.w = h0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.g(0, 0, null, this);
    }
}

