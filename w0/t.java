package w0;

import i.n.i.b.a.s.e.M3;
import kotlin.jvm.internal.q;
import pe.b;

public enum t implements s {
    Active,
    ActiveParent,
    Captured,
    Inactive;

    public static final t[] e;

    static {
        t.e = arr_t;
        q.g(arr_t, "entries");
        new b(arr_t);
    }

    public final boolean a() {
        int v = this.ordinal();
        if(v != 0 && v != 1) {
            switch(v) {
                case 2: {
                    break;
                }
                case 3: {
                    return false;
                }
                default: {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
            }
        }
        return true;
    }

    public final boolean b() {
        switch(this.ordinal()) {
            case 0: 
            case 2: {
                return true;
            }
            case 1: 
            case 3: {
                return false;
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
    }
}

