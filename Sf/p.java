package sf;

import Tf.v;
import kotlin.jvm.internal.q;

public final class p extends r {
    public p() {
        super("HTML", 1);
    }

    @Override  // sf.r
    public final String a(String s) {
        q.g(s, "string");
        return v.p0(v.p0(s, "<", "&lt;"), ">", "&gt;");
    }
}

