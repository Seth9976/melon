package r0;

import android.os.Handler;
import android.os.Looper;

public abstract class b {
    public static final Handler a;

    static {
        b.a = new Handler(Looper.getMainLooper());
    }
}

