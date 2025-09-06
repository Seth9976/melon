package b0;

import kotlin.jvm.internal.r;
import we.a;

public final class u extends r implements a {
    public final int f;
    public final a g;

    public u(int v, a a0) {
        this.f = v;
        this.g = a0;
        super(0);
    }

    @Override  // we.a
    public final Object invoke() {
        float f = 1.0f;
        switch(this.f) {
            case 0: {
                return P4.a.i(((Number)this.g.invoke()).floatValue(), 0.0f, 1.0f);
            }
            case 1: {
                if(((Number)this.g.invoke()).floatValue() < 1.0f) {
                    f = 0.3f;
                }
                return f;
            }
            case 2: {
                return this.g.invoke();
            }
            default: {
                return this.g.invoke();
            }
        }
    }
}

