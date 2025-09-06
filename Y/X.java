package Y;

import ie.H;
import kotlin.jvm.internal.r;
import we.k;
import x0.b;

public final class x extends r implements k {
    public final int f;
    public static final x g;
    public static final x h;
    public static final x i;

    static {
        x.g = new x(1, 0);
        x.h = new x(1, 1);
        x.i = new x(1, 2);
    }

    public x(int v, int v1) {
        this.f = v1;
        super(v);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.f) {
            case 0: {
                long v = ((b)object0).a;
                return (0x7FFFFFFF7FFFFFFFL & v) == 0x7FC000007FC00000L ? B.a : new G.r(Float.intBitsToFloat(((int)(v >> 0x20))), Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))));
            }
            case 1: {
                return new b(((long)Float.floatToRawIntBits(((G.r)object0).a)) << 0x20 | ((long)Float.floatToRawIntBits(((G.r)object0).b)) & 0xFFFFFFFFL);
            }
            default: {
                f1.x x0 = (f1.x)object0;
                return H.a;
            }
        }
    }
}

