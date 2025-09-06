package Ae;

import java.util.Random;
import kotlin.jvm.internal.q;

public final class c extends a {
    public final b c;

    public c() {
        this.c = new b(0);
    }

    @Override  // Ae.a
    public final Random e() {
        Object object0 = this.c.get();
        q.f(object0, "get(...)");
        return (Random)object0;
    }
}

