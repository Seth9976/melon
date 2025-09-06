package rb;

public final class c extends oe.c {
    public long B;
    public Object D;
    public final i E;
    public int G;
    public String r;
    public int w;

    public c(i i0, oe.c c0) {
        this.E = i0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.D = object0;
        this.G |= 0x80000000;
        return this.E.c(0, null, this);
    }
}

