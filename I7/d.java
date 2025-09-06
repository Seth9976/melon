package I7;

import H7.i;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import l.a;

public final class d {
    public final Executor a;
    public final q b;
    public Task c;
    public static final HashMap d;
    public static final a e;

    static {
        d.d = new HashMap();
        d.e = new a(1);
    }

    public d(Executor executor0, q q0) {
        this.a = executor0;
        this.b = q0;
        this.c = null;
    }

    public static Object a(Task task0) {
        TimeUnit timeUnit0 = TimeUnit.SECONDS;
        c c0 = new c(0);
        task0.addOnSuccessListener(d.e, c0);
        task0.addOnFailureListener(d.e, c0);
        task0.addOnCanceledListener(d.e, c0);
        if(!((CountDownLatch)c0.b).await(5L, timeUnit0)) {
            throw new TimeoutException("Task await timed out.");
        }
        if(!task0.isSuccessful()) {
            throw new ExecutionException(task0.getException());
        }
        return task0.getResult();
    }

    public final Task b() {
        synchronized(this) {
            if(this.c == null || this.c.isComplete() && !this.c.isSuccessful()) {
                i i0 = new i(this.b, 1);
                this.c = Tasks.call(this.a, i0);
            }
            return this.c;
        }
    }

    public final f c() {
        synchronized(this) {
            if(this.c != null && this.c.isSuccessful()) {
                return (f)this.c.getResult();
            }
        }
        try {
            return (f)d.a(this.b());
        }
        catch(InterruptedException | ExecutionException | TimeoutException interruptedException0) {
            Log.d("FirebaseRemoteConfig", "Reading from storage file failed.", interruptedException0);
            return null;
        }
    }
}

