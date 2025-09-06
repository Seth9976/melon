package t7;

import r7.f;
import r7.g;

public final class b implements f {
    public final int a;

    public b(int v) {
        this.a = v;
        super();
    }

    @Override  // r7.a
    public final void a(Object object0, Object object1) {
        if(this.a != 0) {
            ((g)object1).g(((Boolean)object0).booleanValue());
            return;
        }
        ((g)object1).c(((String)object0));
    }
}

