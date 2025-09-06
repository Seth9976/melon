package Q5;

import H8.i;
import N5.c;
import N5.e;
import N5.g;
import java.util.Set;

public final class t implements g {
    public final Set a;
    public final j b;
    public final u c;

    public t(Set set0, j j0, u u0) {
        this.a = set0;
        this.b = j0;
        this.c = u0;
    }

    public final i a(String s, c c0, e e0) {
        Set set0 = this.a;
        if(!set0.contains(c0)) {
            throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", c0, set0));
        }
        return new i(this.b, s, c0, e0, this.c);
    }
}

