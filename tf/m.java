package Tf;

import java.io.Serializable;
import java.util.regex.Pattern;
import kotlin.jvm.internal.q;

public final class m implements Serializable {
    public final String a;
    public final int b;
    private static final long serialVersionUID;

    public m(String s, int v) {
        this.a = s;
        this.b = v;
    }

    private final Object readResolve() {
        Pattern pattern0 = Pattern.compile(this.a, this.b);
        q.f(pattern0, "compile(...)");
        return new n(pattern0);
    }
}

