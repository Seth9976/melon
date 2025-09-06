package androidx.media3.session;

import android.os.Handler;
import e3.x;
import java.util.concurrent.Executor;

public final class p0 implements Executor {
    public final int a;
    public final Handler b;

    public p0(Handler handler0, int v) {
        this.a = v;
        this.b = handler0;
        super();
    }

    @Override
    public final void execute(Runnable runnable0) {
        if(this.a != 0) {
            this.b.post(runnable0);
            return;
        }
        x.P(this.b, runnable0);
    }
}

