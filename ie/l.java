package ie;

import kotlin.jvm.internal.q;

public final class l extends Error {
    public l() {
        this("An operation is not implemented.");
    }

    public l(String s) {
        q.g(s, "message");
        super(s);
    }
}

