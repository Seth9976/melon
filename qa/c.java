package Qa;

public final class c extends oe.c {
    public int B;
    public Object r;
    public final I7.c w;

    public c(I7.c c0, oe.c c1) {
        this.w = c0;
        super(c1);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.D(this);
    }
}

