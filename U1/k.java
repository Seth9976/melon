package u1;

import E4.g;
import P0.I;
import androidx.compose.ui.viewinterop.a;
import androidx.lifecycle.D;
import i.n.i.b.a.s.e.M3;
import ie.H;
import kotlin.jvm.internal.r;
import r0.q;
import r1.c;
import r1.m;
import we.n;

public final class k extends r implements n {
    public final int f;
    public static final k g;
    public static final k h;
    public static final k i;
    public static final k j;
    public static final k k;
    public static final k l;
    public static final k m;
    public static final k n;
    public static final k o;
    public static final k r;

    static {
        k.g = new k(2, 0);
        k.h = new k(2, 1);
        k.i = new k(2, 2);
        k.j = new k(2, 3);
        k.k = new k(2, 4);
        k.l = new k(2, 5);
        k.m = new k(2, 6);
        k.n = new k(2, 7);
        k.o = new k(2, 8);
        k.r = new k(2, 9);
    }

    public k(int v, int v1) {
        this.f = v1;
        super(v);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.f) {
            case 0: {
                a.c(((I)object0)).setResetBlock(((we.k)object1));
                return H.a;
            }
            case 1: {
                a.c(((I)object0)).setUpdateBlock(((we.k)object1));
                return H.a;
            }
            case 2: {
                a.c(((I)object0)).setReleaseBlock(((we.k)object1));
                return H.a;
            }
            case 3: {
                a.c(((I)object0)).setUpdateBlock(((we.k)object1));
                return H.a;
            }
            case 4: {
                a.c(((I)object0)).setReleaseBlock(((we.k)object1));
                return H.a;
            }
            case 5: {
                a.c(((I)object0)).setModifier(((q)object1));
                return H.a;
            }
            case 6: {
                a.c(((I)object0)).setDensity(((c)object1));
                return H.a;
            }
            case 7: {
                a.c(((I)object0)).setLifecycleOwner(((D)object1));
                return H.a;
            }
            case 8: {
                a.c(((I)object0)).setSavedStateRegistryOwner(((g)object1));
                return H.a;
            }
            default: {
                int v = 1;
                o o0 = a.c(((I)object0));
                int v1 = ((m)object1).ordinal();
                if(v1 == 0) {
                    v = 0;
                }
                else if(v1 != 1) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                o0.setLayoutDirection(v);
                return H.a;
            }
        }
    }
}

