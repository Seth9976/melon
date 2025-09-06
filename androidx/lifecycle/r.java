package androidx.lifecycle;

import i.n.i.b.a.s.e.M3;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import pe.a;
import pe.b;

public enum r {
    ON_CREATE,
    ON_START,
    ON_RESUME,
    ON_PAUSE,
    ON_STOP,
    ON_DESTROY,
    ON_ANY;

    private static final a $ENTRIES;
    private static final r[] $VALUES;
    @NotNull
    public static final p Companion;

    static {
        r.$VALUES = arr_r;
        q.g(arr_r, "entries");
        r.$ENTRIES = new b(arr_r);
        r.Companion = new p();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public final s a() {
        switch(this) {
            case 1: 
            case 2: {
                return s.c;
            }
            case 3: 
            case 4: {
                return s.d;
            }
            case 5: {
                return s.e;
            }
            case 6: {
                return s.a;
            }
            case 7: {
                throw new IllegalArgumentException(this + " has no target state");
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
    }
}

