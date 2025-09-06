package Se;

import gf.d;
import java.lang.reflect.Type;
import java.util.Collection;
import je.w;

public final class y extends A implements d {
    public final Class a;

    public y(Class class0) {
        this.a = class0;
    }

    @Override  // Se.A
    public final Type b() {
        return this.a;
    }

    @Override  // gf.b
    public final Collection getAnnotations() {
        return w.a;
    }
}

