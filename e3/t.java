package e3;

import android.os.Handler;
import java.util.ArrayList;

public final class t {
    public final Handler a;
    public static final ArrayList b;

    static {
        t.b = new ArrayList(50);
    }

    public t(Handler handler0) {
        this.a = handler0;
    }

    public final s a(int v, Object object0) {
        s s0 = t.b();
        s0.a = this.a.obtainMessage(v, object0);
        return s0;
    }

    public static s b() {
        synchronized(t.b) {
            return t.b.isEmpty() ? new s() : ((s)t.b.remove(t.b.size() - 1));  // 初始化器: Ljava/lang/Object;-><init>()V
        }
    }

    public final boolean c(Runnable runnable0) {
        return this.a.post(runnable0);
    }

    public final void d(int v) {
        b.c(v != 0);
        this.a.removeMessages(v);
    }

    public final boolean e(int v) {
        return this.a.sendEmptyMessage(v);
    }
}

