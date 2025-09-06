package H6;

import M6.C;
import M6.D;
import M6.G;
import android.util.Base64;
import androidx.media3.exoplayer.j;
import b3.y0;
import i3.g;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public final class m implements k {
    public final int a;

    public m(int v) {
        this.a = v;
        super();
    }

    @Override  // H6.k
    public final Object get() {
        switch(this.a) {
            case 0: {
                throw new IllegalStateException();
            }
            case 1: {
                return new j();
            }
            case 2: {
                ExecutorService executorService0 = Executors.newSingleThreadExecutor();
                if(executorService0 instanceof C) {
                    return (C)executorService0;
                }
                return executorService0 instanceof ScheduledExecutorService ? new G(((ScheduledExecutorService)executorService0)) : new D(executorService0);
            }
            case 3: {
                byte[] arr_b = new byte[12];
                g.i.nextBytes(arr_b);
                return Base64.encodeToString(arr_b, 10);
            }
            default: {
                try {
                    Class class0 = Class.forName("androidx.media3.effect.DefaultVideoFrameProcessor$Factory$Builder");
                    Object object0 = class0.getMethod("build", null).invoke(class0.getConstructor(null).newInstance(null), null);
                    object0.getClass();
                    return (y0)object0;
                }
                catch(Exception exception0) {
                    throw new IllegalStateException(exception0);
                }
            }
        }
    }
}

