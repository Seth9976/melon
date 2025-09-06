package rd;

import androidx.compose.runtime.K0;
import androidx.compose.runtime.a0;
import we.a;

public final class u implements a {
    public final int a;
    public final a0 b;
    public final float c;

    public u(a0 a00, float f, int v) {
        this.a = v;
        this.b = a00;
        this.c = f;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                return ((float)((K0)this.b).m()) >= this.c;
            }
            case 1: {
                return ((float)((K0)this.b).m()) >= this.c * 2.0f;
            }
            case 2: {
                return ((float)((K0)this.b).m()) >= this.c;
            }
            case 3: {
                return ((float)((K0)this.b).m()) >= this.c * 2.0f;
            }
            case 4: {
                return ((float)((K0)this.b).m()) >= this.c;
            }
            default: {
                return ((float)((K0)this.b).m()) >= this.c;
            }
        }
    }
}

