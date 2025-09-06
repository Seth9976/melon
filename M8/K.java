package m8;

public final class k extends e {
    public final int c;

    public k(int v) {
        this.c = v;
        super(1);
    }

    @Override  // Bf.a
    public final String Z0() {
        return this.c == 0 ? "/receive" : "/send";
    }
}

