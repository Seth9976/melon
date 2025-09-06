package androidx.room;

import ie.H;
import we.a;

public final class i implements a {
    public final int a;
    public final l b;

    public i(l l0, int v) {
        this.a = v;
        this.b = l0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                this.b.getClass();
                return H.a;
            }
            case 1: {
                this.b.getClass();
                return H.a;
            }
            default: {
                return !this.b.a.inCompatibilityMode$room_runtime_release() || this.b.a.isOpenInternal();
            }
        }
    }
}

