package Dc;

import androidx.compose.runtime.O0;
import we.a;

public final class p implements a {
    public final int a;
    public final u b;

    public p(u u0, int v) {
        this.a = v;
        this.b = u0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                return this.b.a();
            }
            case 1: {
                return this.b.a();
            }
            default: {
                return ((O0)this.b.g).getValue() == null ? false : true;
            }
        }
    }
}

