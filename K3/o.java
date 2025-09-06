package k3;

import android.os.Looper;
import androidx.media3.common.b;
import i3.l;

public interface o {
    public static final m a;

    static {
        o.a = new m();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    default n a(k k0, b b0) {
        return n.O;
    }

    h b(k arg1, b arg2);

    int c(b arg1);

    void d(Looper arg1, l arg2);

    default void prepare() {
    }

    default void release() {
    }
}

