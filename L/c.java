package l;

import P1.a;
import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.Handler;
import android.os.Looper;
import e1.G;
import e7.s;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class c extends G {
    public final Object g;
    public final ExecutorService h;
    public volatile Handler i;

    public c() {
        this.g = new Object();
        this.h = Executors.newFixedThreadPool(4, new s());
    }

    public static Handler P(Looper looper0) {
        if(Build.VERSION.SDK_INT >= 28) {
            return a.b(looper0);
        }
        try {
            return (Handler)Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper0, 0, Boolean.TRUE);
        }
        catch(IllegalAccessException | InstantiationException | NoSuchMethodException unused_ex) {
            return new Handler(looper0);
        }
        catch(InvocationTargetException unused_ex) {
            return new Handler(looper0);
        }
    }
}

