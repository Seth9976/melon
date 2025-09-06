package hf;

import Hf.x;
import Jf.l;
import Me.N;
import Me.e;
import java.util.Map;
import qf.c;
import xf.d;

public final class b implements Ne.b {
    public static final b a;

    static {
        b.a = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override  // Ne.b
    public final Map a() {
        throw new IllegalStateException("No methods should be called on this descriptor. Only its presence matters");
    }

    @Override  // Ne.b
    public final c b() {
        e e0 = d.d(this);
        if(e0 != null) {
            if(l.f(e0)) {
                e0 = null;
            }
            return e0 == null ? null : d.c(e0);
        }
        return null;
    }

    @Override  // Ne.b
    public final N getSource() {
        throw new IllegalStateException("No methods should be called on this descriptor. Only its presence matters");
    }

    @Override  // Ne.b
    public final x getType() {
        throw new IllegalStateException("No methods should be called on this descriptor. Only its presence matters");
    }

    @Override
    public final String toString() {
        return "[EnhancedType]";
    }
}

