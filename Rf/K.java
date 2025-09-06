package rf;

public final class k implements Comparable {
    public final int a;
    public final J b;
    public final boolean c;

    public k(int v, J j0, boolean z) {
        this.a = v;
        this.b = j0;
        this.c = z;
    }

    @Override
    public final int compareTo(Object object0) {
        return this.a - ((k)object0).a;
    }
}

