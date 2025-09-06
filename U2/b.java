package u2;

import androidx.collection.V;
import java.util.ArrayList;
import pc.t;
import y8.s;

public final class b {
    public final V a;
    public final ArrayList b;
    public final t c;
    public s d;
    public boolean e;
    public static final ThreadLocal f;

    static {
        b.f = new ThreadLocal();
    }

    public b() {
        this.a = new V(0);
        this.b = new ArrayList();
        this.c = new t(this, 22);
        this.e = false;
    }
}

