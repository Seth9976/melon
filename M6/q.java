package M6;

import N6.a;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class q extends a implements B {
    public volatile Object a;
    public volatile e b;
    public volatile p c;
    public static final Object d;
    public static final A e;
    public static final boolean f;
    public static final a.a g;

    static {
        i i0;
        Throwable throwable0;
        o o0;
        q.d = new Object();
        q.e = new A(h.class);
        q.f = false;
        Exception exception0 = null;
        try {
            o0 = new o();  // 初始化器: Ljava/lang/Object;-><init>()V
            throwable0 = null;
        }
        catch(Exception | Error exception1) {
            try {
                i0 = new i();  // 初始化器: Ljava/lang/Object;-><init>()V
            }
            catch(Exception | Error exception0) {
                i0 = new j();  // 初始化器: Ljava/lang/Object;-><init>()V
            }
            throwable0 = exception1;
            o0 = i0;
        }
        q.g = o0;
        if(exception0 != null) {
            Logger logger0 = q.e.a();
            Level level0 = Level.SEVERE;
            logger0.log(level0, "UnsafeAtomicHelper is broken!", throwable0);
            q.e.a().log(level0, "AtomicReferenceFieldUpdaterAtomicHelper is broken!", exception0);
        }
    }

    public final void b(p p0) {
        p0.a = null;
    alab1:
        p p1;
        while((p1 = this.c) != p.c) {
            p p2 = null;
            while(true) {
                if(p1 == null) {
                    break alab1;
                }
                p p3 = p1.b;
                if(p1.a != null) {
                    p2 = p1;
                }
                else if(p2 == null) {
                    if(q.g.n(this, p1, p3)) {
                        p1 = p3;
                        continue;
                    }
                    break;
                }
                else {
                    p2.b = p3;
                    if(p2.a == null) {
                        break;
                    }
                }
                p1 = p3;
            }
        }
    }
}

