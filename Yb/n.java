package Yb;

import Sb.a;
import kotlin.jvm.internal.q;

public final class n extends a {
    public final f c;
    public final String d;

    public n(String s) {
        this(s, f.c);
    }

    public n(String s, f f0) {
        q.g(s, "message");
        q.g(f0, "afterAction");
        super(s, null);
        this.c = f0;
        this.d = "MelonNotificationException";
    }

    @Override  // Sb.a
    public final String b() {
        return this.d;
    }
}

