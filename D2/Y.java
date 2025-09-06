package D2;

import android.os.Bundle;
import kotlin.jvm.internal.r;
import we.a;

public final class y extends r implements a {
    public final int f;
    public static final y g;

    static {
        y.g = new y(0, 0);
    }

    public y(int v, int v1) {
        this.f = v1;
        super(v);
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.f) {
            case 0: {
                return new Bundle();
            }
            case 1: {
                return new H();
            }
            default: {
                return new I();
            }
        }
    }
}

