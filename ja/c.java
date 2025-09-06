package ja;

public final class c extends oe.c {
    public int B;
    public Object r;
    public final g w;

    public c(g g0, oe.c c0) {
        this.w = g0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.c(0, 0, null, this);
    }
}

