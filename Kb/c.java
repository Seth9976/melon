package kb;

public final class c extends oe.c {
    public int B;
    public Object r;
    public final s w;

    public c(s s0, oe.c c0) {
        this.w = s0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.d(null, null, this);
    }
}

