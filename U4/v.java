package U4;

import android.content.Context;
import androidx.work.WorkerParameters;
import java.util.concurrent.atomic.AtomicInteger;
import w1.m;

public abstract class v {
    public final Context a;
    public final WorkerParameters b;
    public final AtomicInteger c;
    public boolean d;

    public v(Context context0, WorkerParameters workerParameters0) {
        this.c = new AtomicInteger(0xFFFFFF00);
        this.a = context0;
        this.b = workerParameters0;
    }

    public abstract m a();

    public abstract m b();
}

