package U4;

import android.content.Context;
import androidx.work.WorkerParameters;
import kotlin.jvm.internal.q;

public final class k {
    public static final k a;
    public static final k b;

    static {
        k.a = new k();  // 初始化器: Ljava/lang/Object;-><init>()V
        k.b = new k();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public v a(Context context0, String s, WorkerParameters workerParameters0) {
        v v0;
        Class class0;
        q.g(context0, "appContext");
        q.g(s, "workerClassName");
        q.g(workerParameters0, "workerParameters");
        try {
            class0 = Class.forName(s).asSubclass(v.class);
            q.f(class0, "{\n                Class.…class.java)\n            }");
        }
        catch(Throwable throwable0) {
            w.e().d("WM-WorkerFactory", "Invalid class: " + s, throwable0);
            throw throwable0;
        }
        try {
            Object object0 = class0.getDeclaredConstructor(Context.class, WorkerParameters.class).newInstance(context0, workerParameters0);
            q.f(object0, "{\n                val co…Parameters)\n            }");
            v0 = (v)object0;
        }
        catch(Throwable throwable1) {
            w.e().d("WM-WorkerFactory", "Could not instantiate " + s, throwable1);
            throw throwable1;
        }
        if(v0.d) {
            throw new IllegalStateException("WorkerFactory (" + this.getClass().getName() + ") returned an instance of a ListenableWorker (" + s + ") which has already been invoked. createWorker() must always return a new instance of a ListenableWorker.");
        }
        return v0;
    }
}

