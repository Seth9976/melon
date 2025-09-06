package df;

import Af.p;
import Hf.x;
import Me.e;
import Me.h;
import Pe.L;
import Se.v;
import java.lang.reflect.Modifier;
import kotlin.jvm.internal.q;
import we.k;

public final class m implements k {
    public final int a;
    public static final m b;
    public static final m c;
    public static final m d;
    public static final m e;
    public static final m f;

    static {
        m.b = new m(0);
        m.c = new m(1);
        m.d = new m(2);
        m.e = new m(3);
        m.f = new m(4);
    }

    public m(int v) {
        this.a = v;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                q.g(((v)object0), "it");
                return Boolean.valueOf(!Modifier.isStatic(((v)object0).b().getModifiers()));
            }
            case 1: {
                q.g(((L)object0), "$this$selectMostSpecificInEachOverridableGroup");
                return (L)object0;
            }
            case 2: {
                q.g(((v)object0), "it");
                return Boolean.valueOf(Modifier.isStatic(((v)object0).b().getModifiers()));
            }
            case 3: {
                q.g(((p)object0), "it");
                return ((p)object0).g();
            }
            default: {
                h h0 = ((x)object0).w().e();
                return h0 instanceof e ? ((e)h0) : null;
            }
        }
    }
}

