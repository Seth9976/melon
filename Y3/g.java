package Y3;

public final class g implements Comparable {
    public final long a;
    public final byte[] b;

    public g(long v, byte[] arr_b) {
        this.a = v;
        this.b = arr_b;
    }

    @Override
    public final int compareTo(Object object0) {
        return Long.compare(this.a, ((g)object0).a);
    }
}

