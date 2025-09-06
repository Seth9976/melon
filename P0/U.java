package p0;

import m0.a;

public abstract class u implements t {
    public final a a;

    public u() {
        this.a = new a(0);  // 初始化器: Ljava/util/concurrent/atomic/AtomicInteger;-><init>(I)V
    }

    public final boolean j(int v) {
        return (v & this.a.get()) != 0;
    }

    public final void k(int v) {
        do {
            int v1 = this.a.get();
        }
        while((v1 & v) == 0 && !this.a.compareAndSet(v1, v1 | v));
    }
}

