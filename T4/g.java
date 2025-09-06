package T4;

import java.util.HashSet;

public final class g {
    public static final HashSet a;

    static {
        g.a = new HashSet();
    }

    public g() {
        g.a.add(this);
    }
}

