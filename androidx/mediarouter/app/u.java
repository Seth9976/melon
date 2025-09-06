package androidx.mediarouter.app;

import l4.O;

public final class u {
    public final Object a;
    public final int b;

    public u(Object object0) {
        this.a = object0;
        if(object0 instanceof String) {
            this.b = 1;
            return;
        }
        if(!(object0 instanceof O)) {
            throw new IllegalArgumentException();
        }
        this.b = 2;
    }
}

