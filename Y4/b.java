package y4;

import d5.v;
import java.util.LinkedHashMap;
import java.util.concurrent.locks.ReentrantLock;
import w4.f;

public final class b {
    public final ReentrantLock a;
    public final v b;
    public static final f c;
    public static final LinkedHashMap d;

    static {
        b.c = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
        b.d = new LinkedHashMap();
    }

    public b(String s, boolean z) {
        ReentrantLock reentrantLock0;
        v v1;
        synchronized(b.c) {
            LinkedHashMap linkedHashMap0 = b.d;
            reentrantLock0 = linkedHashMap0.get(s);
            if(reentrantLock0 == null) {
                reentrantLock0 = new ReentrantLock();
                linkedHashMap0.put(s, reentrantLock0);
            }
        }
        this.a = reentrantLock0;
        if(z) {
            v1 = new v();  // 初始化器: Ljava/lang/Object;-><init>()V
            v1.a = s + ".lck";
        }
        else {
            v1 = null;
        }
        this.b = v1;
    }
}

