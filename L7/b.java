package l7;

import I6.Q;
import I6.V;
import I6.p0;
import N5.h;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import b3.q0;
import com.google.android.gms.tasks.TaskCompletionSource;
import e7.a;
import i.n.i.b.a.s.e.P3;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import v3.d;
import v3.e;
import v3.k;

public final class b implements h, k {
    public final boolean a;
    public final Object b;
    public final Object c;
    public final Object d;

    public b(boolean z, Object object0, Object object1, Object object2) {
        this.b = object0;
        this.c = object1;
        this.a = z;
        this.d = object2;
        super();
    }

    @Override  // N5.h
    public void b(Exception exception0) {
        c c0 = (c)this.b;
        TaskCompletionSource taskCompletionSource0 = (TaskCompletionSource)this.c;
        a a0 = (a)this.d;
        if(exception0 != null) {
            taskCompletionSource0.trySetException(exception0);
            return;
        }
        if(this.a) {
            CountDownLatch countDownLatch0 = new CountDownLatch(1);
            new Thread(new P3(18, c0, countDownLatch0)).start();
            boolean z = false;
            try {
                long v = TimeUnit.SECONDS.toNanos(2L);
                long v1 = System.nanoTime() + v;
                while(true) {
                    try {
                        countDownLatch0.await(v, TimeUnit.NANOSECONDS);
                        break;
                    }
                    catch(InterruptedException unused_ex) {
                        v = v1 - System.nanoTime();
                        z = true;
                    }
                }
            }
            catch(Throwable throwable0) {
                if(z) {
                    Thread.currentThread().interrupt();
                }
                throw throwable0;
            }
            if(z) {
                Thread.currentThread().interrupt();
            }
        }
        taskCompletionSource0.trySetResult(a0);
    }

    @Override  // v3.k
    public p0 c(int v, q0 q00, int[] arr_v) {
        v3.h h0 = (v3.h)this.c;
        ((DefaultTrackSelector)this.b).getClass();
        d d0 = new d(((DefaultTrackSelector)this.b));
        int v1 = ((int[])this.d)[v];
        Q q0 = V.o();
        for(int v2 = 0; v2 < q00.a; ++v2) {
            q0.a(new e(v, q00, v2, h0, arr_v[v2], this.a, d0, v1));
        }
        return q0.g();
    }
}

