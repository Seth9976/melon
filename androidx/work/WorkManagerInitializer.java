package androidx.work;

import K4.b;
import U4.a;
import U4.k;
import U4.w;
import V4.s;
import V4.u;
import android.content.Context;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.q;

public final class WorkManagerInitializer implements b {
    public static final String a;

    static {
        WorkManagerInitializer.a = "WM-WrkMgrInitializer";
    }

    @Override  // K4.b
    public final List a() {
        return Collections.EMPTY_LIST;
    }

    @Override  // K4.b
    public final Object b(Context context0) {
        w.e().a("WM-WrkMgrInitializer", "Initializing WorkManager with default configuration.");
        a a0 = new a(new k());  // 初始化器: Ljava/lang/Object;-><init>()V
        q.g(context0, "context");
        synchronized(s.t) {
            s s0 = s.r;
            if(s0 != null && s.s != null) {
                throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information.");
            }
            if(s0 == null) {
                Context context1 = context0.getApplicationContext();
                if(s.s == null) {
                    s.s = u.m(context1, a0);
                }
                s.r = s.s;
            }
        }
        return s.c0(context0);
    }
}

