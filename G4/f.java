package g4;

public final class f implements Comparable {
    public final int a;
    public final b b;

    public f(int v, b b0) {
        this.a = v;
        this.b = b0;
    }

    @Override
    public final int compareTo(Object object0) {
        return Integer.compare(this.a, ((f)object0).a);
    }
}

