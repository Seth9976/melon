package T7;

public final class k extends m {
    public final int f;

    public k(o o0, int v) {
        this.f = v;
        super(o0);
    }

    @Override  // T7.m
    public Object next() {
        return this.f == 1 ? this.a().f : super.next();
    }
}

