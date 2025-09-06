package androidx.media3.session;

import android.os.Looper;
import android.view.Choreographer;
import androidx.media3.common.e;
import e3.t;
import e3.x;
import f1.B;
import java.util.concurrent.Executor;
import l4.b;

public final class w implements Executor {
    public final int a;
    public final Object b;

    public w(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override
    public final void execute(Runnable runnable0) {
        switch(this.a) {
            case 0: {
                x.P(((androidx.media3.session.x)this.b).h, runnable0);
                return;
            }
            case 1: {
                t t0 = ((e)this.b).e;
                if(t0.a.getLooper() == Looper.myLooper()) {
                    runnable0.run();
                    return;
                }
                t0.c(runnable0);
                return;
            }
            case 2: {
                B b0 = new B(runnable0, 0);
                ((Choreographer)this.b).postFrameCallback(b0);
                return;
            }
            default: {
                ((b)this.b).post(runnable0);
            }
        }
    }
}

