package D4;

import kotlin.jvm.internal.q;

public final class n implements Comparable {
    public final int a;
    public final int b;
    public final String c;
    public final String d;

    public n(int v, int v1, String s, String s1) {
        q.g(s, "from");
        q.g(s1, "to");
        super();
        this.a = v;
        this.b = v1;
        this.c = s;
        this.d = s1;
    }

    @Override
    public final int compareTo(Object object0) {
        q.g(((n)object0), "other");
        int v = this.a - ((n)object0).a;
        return v == 0 ? this.b - ((n)object0).b : v;
    }
}

