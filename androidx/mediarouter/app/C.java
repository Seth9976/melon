package androidx.mediarouter.app;

import java.util.Comparator;
import l4.O;

public final class c implements Comparator {
    public final int a;
    public static final c b;
    public static final c c;
    public static final c d;

    static {
        c.b = new c(0);
        c.c = new c(1);
        c.d = new c(2);
    }

    public c(int v) {
        this.a = v;
        super();
    }

    @Override
    public final int compare(Object object0, Object object1) {
        switch(this.a) {
            case 0: {
                return ((O)object0).d.compareToIgnoreCase(((O)object1).d);
            }
            case 1: {
                return ((O)object0).d.compareToIgnoreCase(((O)object1).d);
            }
            default: {
                return ((O)object0).d.compareToIgnoreCase(((O)object1).d);
            }
        }
    }
}

