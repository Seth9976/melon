package t3;

import e3.h;

public interface c {
    public static final h R;

    static {
        c.R = new h();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    long getChunkEndTimeUs();

    long getChunkStartTimeUs();

    boolean next();
}

