package x1;

public final class e extends o {
    public final Object c;
    public final g d;
    public final f e;
    public final g f;
    public final f g;

    public e(Object object0) {
        super(object0);
        this.c = object0;
        this.d = new g(object0, -2, this);
        this.e = new f(object0, 0, this);
        this.f = new g(object0, -1, this);
        this.g = new f(object0, 1, this);
    }

    @Override  // x1.o
    public final Object a() {
        return this.c;
    }
}

