package R5;

import R6.c;
import R6.d;
import S5.b;
import android.content.Context;

public final class e implements b {
    public final int a;
    public final Object b;

    public e(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // javax.inject.Provider
    public final Object get() {
        if(this.a != 0) {
            return this.b;
        }
        d d0 = new d(11);
        c c0 = new c(11);
        return new R5.d(((Context)((e)this.b).b), d0, c0);
    }
}

