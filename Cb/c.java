package cb;

public final class c extends oe.c {
    public Object B;
    public final g D;
    public int E;
    public int r;
    public long w;

    public c(g g0, oe.c c0) {
        this.D = g0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return this.D.c(0, this);
    }
}

