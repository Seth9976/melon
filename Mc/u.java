package Mc;

import androidx.lifecycle.n;
import androidx.lifecycle.r0;
import ie.j;
import kotlin.jvm.internal.r;
import we.a;

public final class u extends r implements a {
    public final int f;
    public final Object g;

    public u(j j0, int v) {
        this.f = v;
        this.g = j0;
        super(0);
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.f) {
            case 0: {
                return ((r0)((j)this.g).getValue()).getViewModelStore();
            }
            case 1: {
                r0 r01 = (r0)((j)this.g).getValue();
                n n1 = r01 instanceof n ? ((n)r01) : null;
                return n1 != null ? n1.getDefaultViewModelCreationExtras() : S2.a.b;
            }
            case 2: {
                return ((r0)((j)this.g).getValue()).getViewModelStore();
            }
            case 3: {
                r0 r02 = (r0)((j)this.g).getValue();
                n n2 = r02 instanceof n ? ((n)r02) : null;
                return n2 != null ? n2.getDefaultViewModelCreationExtras() : S2.a.b;
            }
            case 4: {
                return ((r0)((j)this.g).getValue()).getViewModelStore();
            }
            case 5: {
                r0 r03 = (r0)((j)this.g).getValue();
                n n3 = r03 instanceof n ? ((n)r03) : null;
                return n3 != null ? n3.getDefaultViewModelCreationExtras() : S2.a.b;
            }
            case 6: {
                return ((r0)((j)this.g).getValue()).getViewModelStore();
            }
            case 7: {
                r0 r04 = (r0)((j)this.g).getValue();
                n n4 = r04 instanceof n ? ((n)r04) : null;
                return n4 != null ? n4.getDefaultViewModelCreationExtras() : S2.a.b;
            }
            case 8: {
                return ((r0)((j)this.g).getValue()).getViewModelStore();
            }
            default: {
                r0 r00 = (r0)((j)this.g).getValue();
                n n0 = r00 instanceof n ? ((n)r00) : null;
                return n0 != null ? n0.getDefaultViewModelCreationExtras() : S2.a.b;
            }
        }
    }
}

