package i.n.i.b.a.s.e;

public final class ue implements Comparable {
    public final int a;
    public final Dd b;

    public ue(int v, Dd dd0) {
        this.a = v;
        this.b = dd0;
    }

    @Override
    public final int compareTo(Object object0) {
        return Integer.compare(this.a, ((ue)object0).a);
    }
}

