package androidx.lifecycle;

import A3.l;
import android.os.Handler;
import kotlin.jvm.internal.q;

public final class T implements D {
    public int a;
    public int b;
    public boolean c;
    public boolean d;
    public Handler e;
    public final F f;
    public final l g;
    public final b h;
    public static final T i;

    static {
        T.i = new T();
    }

    public T() {
        this.c = true;
        this.d = true;
        this.f = new F(this);
        this.g = new l(this, 16);
        this.h = new b(this, 1);
    }

    public final void a() {
        int v = this.b + 1;
        this.b = v;
        if(v == 1) {
            if(this.c) {
                this.f.f(r.ON_RESUME);
                this.c = false;
                return;
            }
            Handler handler0 = this.e;
            q.d(handler0);
            handler0.removeCallbacks(this.g);
        }
    }

    // 检测为 Lambda 实现
    @Override  // androidx.lifecycle.D
    public final t getLifecycle() [...]
}

