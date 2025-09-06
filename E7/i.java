package e7;

import A1.g;
import H8.q;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.iloen.melon.custom.S0;
import g7.c;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import je.x;

public final class i implements Callable {
    public final long a;
    public final Throwable b;
    public final Thread c;
    public final g d;
    public final k e;

    public i(k k0, long v, Throwable throwable0, Thread thread0, g g0) {
        this.e = k0;
        this.a = v;
        this.b = throwable0;
        this.c = thread0;
        this.d = g0;
    }

    @Override
    public final Object call() {
        long v = this.a;
        k k0 = this.e;
        String s = k0.e();
        if(s == null) {
            Log.e("FirebaseCrashlytics", "Tried to write a fatal exception while no session was open.", null);
            return Tasks.forResult(null);
        }
        k0.c.c();
        q q0 = k0.m;
        q0.getClass();
        if(Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", "Persisting fatal event for session " + s, null);
        }
        c c0 = new c(s, v / 1000L, x.a);
        q0.q(this.b, this.c, "crash", c0, true);
        try {
            k0.g.getClass();
            if(!new File(k0.g.c, ".ae" + v).createNewFile()) {
                throw new IOException("Create new file failed.");
            }
        }
        catch(IOException iOException0) {
            Log.w("FirebaseCrashlytics", "Could not create app exception marker file.", iOException0);
        }
        g g0 = this.d;
        k0.b(false, g0, false);
        k0.c("68BBAA19038900010711E80A1D2E91AA", Boolean.FALSE);
        if(!k0.b.f()) {
            return Tasks.forResult(null);
        }
        Task task0 = ((TaskCompletionSource)((AtomicReference)g0.i).get()).getTask();
        S0 s00 = new S0(this, s);
        return task0.onSuccessTask(k0.e.a, s00);
    }
}

