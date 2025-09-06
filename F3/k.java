package f3;

import java.util.ArrayList;

public final class k implements Comparable {
    public final ArrayList a;
    public long b;

    public k() {
        this.b = 0x8000000000000001L;
        this.a = new ArrayList();
    }

    @Override
    public final int compareTo(Object object0) {
        return Long.compare(this.b, ((k)object0).b);
    }
}

