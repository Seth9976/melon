package M6;

public final class p {
    public volatile Thread a;
    public volatile p b;
    public static final p c;

    static {
        p.c = new p();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public p() {
        q.g.L(this, Thread.currentThread());
    }
}

