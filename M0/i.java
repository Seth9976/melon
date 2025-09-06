package m0;

import android.os.Looper;

public abstract class i {
    public static final long a;

    static {
        long v = -1L;
        try {
            v = Looper.getMainLooper().getThread().getId();
        }
        catch(Exception unused_ex) {
        }
        i.a = v;
    }
}

