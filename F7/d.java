package f7;

import Ic.h;
import android.util.Log;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.q;

public final class d {
    public final b a;
    public final b b;
    public final b c;
    public static final c d;

    static {
        d.d = new c();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public d(ExecutorService executorService0, ExecutorService executorService1) {
        q.g(executorService0, "backgroundExecutorService");
        q.g(executorService1, "blockingExecutorService");
        super();
        this.a = new b(executorService0);
        this.b = new b(executorService0);
        Tasks.forResult(null);
        this.c = new b(executorService1);
    }

    // 去混淆评级： 低(20)
    public static final void a() {
        if(!((Boolean)new h(0, d.d, c.class, "isBackgroundThread", "isBackgroundThread()Z", 0, 16).invoke()).booleanValue() && Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", "Must be called on a background thread, was called on jeb-dexdec-sb-st-1622" + '.', null);
        }
    }

    // 去混淆评级： 低(20)
    public static final void b() {
        if(!((Boolean)new h(0, d.d, c.class, "isBlockingThread", "isBlockingThread()Z", 0, 17).invoke()).booleanValue() && Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", "Must be called on a blocking thread, was called on jeb-dexdec-sb-st-1602" + '.', null);
        }
    }
}

