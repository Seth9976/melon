package k6;

import b3.Z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class l {
    public final float a;
    public final List b;
    public final int c;
    public final int d;

    public l(float f, ArrayList arrayList0, int v, int v1) {
        this.a = f;
        this.b = Collections.unmodifiableList(arrayList0);
        this.c = v;
        this.d = v1;
    }

    public final k a() {
        return (k)this.b.get(this.c);
    }

    public final k b() {
        return (k)this.b.get(0);
    }

    public final k c() {
        return (k)this.b.get(this.d);
    }

    public final k d() {
        return (k)Z.h(1, this.b);
    }
}

