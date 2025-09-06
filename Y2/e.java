package y2;

public final class e {
    public final long a;
    public final long b;

    public e(long v, long v1) {
        if(v1 == 0L) {
            this.a = 0L;
            this.b = 1L;
            return;
        }
        this.a = v;
        this.b = v1;
    }

    @Override
    public final String toString() {
        return this.a + "/" + this.b;
    }
}

