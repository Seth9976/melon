package v2;

import android.os.Handler;
import android.os.Looper;

public abstract class a {
    public static Handler a(Looper looper0) {
        return Handler.createAsync(looper0);
    }
}

