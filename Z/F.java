package Z;

import kotlin.jvm.internal.r;
import we.a;
import y0.s;

public final class f extends r implements a {
    public final int f;
    public static final f g;
    public static final f h;
    public static final f i;
    public static final f j;
    public static final f k;
    public static final f l;
    public static final f m;
    public static final f n;
    public static final f o;
    public static final f r;

    static {
        f.g = new f(0, 0);
        f.h = new f(0, 1);
        f.i = new f(0, 2);
        f.j = new f(0, 3);
        f.k = new f(0, 4);
        f.l = new f(0, 5);
        f.m = new f(0, 6);
        f.n = new f(0, 7);
        f.o = new f(0, 8);
        f.r = new f(0, 9);
    }

    public f(int v, int v1) {
        this.f = v1;
        super(v);
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.f) {
            case 0: {
                return new e(0xFF6200EE00000000L, 0xFF3700B300000000L, 0xFF03DAC600000000L, 0xFF01878600000000L, s.c, s.c, 0xFFB0002000000000L, s.c, s.b, s.b, s.b, s.c);
            }
            case 1: {
                return 1.0f;
            }
            case 2: {
                return new s(s.b);
            }
            case 3: {
                return new r1.f(0.0f);
            }
            case 4: {
                return o.a;
            }
            case 5: {
                return true;
            }
            case 6: {
                return new F();
            }
            case 7: {
                return new I();
            }
            case 8: {
                return V.a;
            }
            default: {
                return new U();
            }
        }
    }
}

