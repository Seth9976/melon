package sg;

import java.util.concurrent.ThreadFactory;
import okhttp3.internal.Util;

public final class a implements ThreadFactory {
    public final String a;
    public final boolean b;

    public a(String s, boolean z) {
        this.a = s;
        this.b = z;
    }

    @Override
    public final Thread newThread(Runnable runnable0) {
        return Util.threadFactory$lambda$1(this.a, this.b, runnable0);
    }
}

