package androidx.compose.foundation.lazy.layout;

import E9.h;
import F.B;
import I.a;
import I.u0;
import N0.L;
import N0.N;
import N0.O;
import N0.a0;
import O0.d;
import O0.g;
import P0.f;
import P0.z;
import androidx.compose.runtime.O0;
import i.n.i.b.a.s.e.M3;
import je.x;
import r0.p;

public final class m extends p implements d, z {
    public n a;
    public a b;
    public boolean c;
    public u0 d;
    public static final k e;

    static {
        m.e = new k();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public final boolean m0(i i0, int v) {
        switch(v) {
            case 1: 
            case 2: {
            label_5:
                if(this.n0(v)) {
                    int v1 = this.a.getItemCount();
                    return i0.b < v1 - 1;
                }
                return i0.a > 0;
            }
            case 3: 
            case 4: {
                if(this.d != u0.a) {
                    goto label_5;
                }
                return false;
            }
            case 5: 
            case 6: {
                if(this.d != u0.b) {
                    goto label_5;
                }
                return false;
            }
            default: {
                throw new IllegalStateException("Lazy list does not support beyond bounds layout for the specified direction");
            }
        }
    }

    @Override  // P0.z
    public final N measure-3p2s80s(O o0, L l0, long v) {
        a0 a00 = l0.O(v);
        int v1 = a00.a;
        int v2 = a00.b;
        B b0 = new B(a00, 13);
        return o0.w(v1, v2, x.a, b0);
    }

    public final boolean n0(int v) {
        switch(v) {
            case 1: {
                return false;
            }
            case 2: {
                return true;
            }
            case 3: {
                switch(f.v(this).T.ordinal()) {
                    case 0: {
                        return this.c;
                    }
                    case 1: {
                        return !this.c;
                    }
                    default: {
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                }
            }
            case 4: {
                switch(f.v(this).T.ordinal()) {
                    case 0: {
                        return !this.c;
                    }
                    case 1: {
                        return this.c;
                    }
                    default: {
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                }
            }
            case 5: {
                return this.c;
            }
            case 6: {
                return !this.c;
            }
            default: {
                throw new IllegalStateException("Lazy list does not support beyond bounds layout for the specified direction");
            }
        }
    }

    @Override  // O0.d
    public final h s() {
        h h0 = new g(N0.f.a);
        ((O0)h0.j).setValue(this);
        return h0;
    }
}

