package k3;

import e3.x;
import h3.a;
import java.util.UUID;

public final class u implements a {
    public final UUID a;
    public final byte[] b;
    public static final boolean c;

    static {
        u.c = "Amazon".equals(x.c) && ("AFTM".equals(x.d) || "AFTB".equals(x.d));
    }

    public u(UUID uUID0, byte[] arr_b) {
        this.a = uUID0;
        this.b = arr_b;
    }
}

