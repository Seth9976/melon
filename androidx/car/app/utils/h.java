package androidx.car.app.utils;

import android.os.Handler;
import android.os.Looper;

public abstract class h {
    public static final Handler a;

    static {
        h.a = new Handler(Looper.getMainLooper());
    }

    public static void a(Runnable runnable0) {
        if(Looper.getMainLooper() == Looper.myLooper()) {
            runnable0.run();
            return;
        }
        h.a.post(runnable0);
    }
}

