package Ea;

public final class c extends oe.c {
    public int B;
    public Object r;
    public final e w;

    public c(e e0, oe.c c0) {
        this.w = e0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.c(null, null, null, this);
    }
}

