package Le;

import Ne.e;
import Ne.g;
import Ne.i;
import java.util.List;
import we.a;

public final class k implements a {
    public final int a;
    public final o b;

    public k(o o0, int v) {
        this.a = v;
        this.b = o0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            return this.b.a.d.e();
        }
        List list0 = e.k.z(e.a(this.b.a.d, "This member is not fully supported by Kotlin compiler, so it may be absent or have different signature in next major version", "", "WARNING"));
        return list0.isEmpty() ? g.a : new i(list0, 0);
    }
}

