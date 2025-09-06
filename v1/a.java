package v1;

import java.util.UUID;
import kotlin.jvm.internal.r;

public final class a extends r implements we.a {
    public final int f;
    public static final a g;
    public static final a h;

    static {
        a.g = new a(0, 0);
        a.h = new a(0, 1);
    }

    public a(int v, int v1) {
        this.f = v1;
        super(v);
    }

    @Override  // we.a
    public final Object invoke() {
        return this.f != 0 ? UUID.randomUUID() : "DEFAULT_TEST_TAG";
    }
}

