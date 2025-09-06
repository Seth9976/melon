package e7;

import android.os.Process;
import android.util.Log;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public final class r implements Runnable {
    public final int a;
    public final Object b;

    public r(Runnable runnable0) {
        this.a = 0;
        super();
        this.b = runnable0;
    }

    public r(ExecutorService executorService0) {
        this.a = 1;
        super();
        this.b = executorService0;
    }

    @Override
    public final void run() {
        ExecutorService executorService0;
        Process.setThreadPriority(10);
        if(this.a == 0) {
            ((Runnable)this.b).run();
        }
        else {
            executorService0 = (ExecutorService)this.b;
            try {
                if(Log.isLoggable("FirebaseCrashlytics", 3)) {
                    Log.d("FirebaseCrashlytics", "Executing shutdown hook for awaitEvenIfOnMainThread task continuation executor", null);
                }
                executorService0.shutdown();
                if(!executorService0.awaitTermination(2L, TimeUnit.SECONDS)) {
                    if(Log.isLoggable("FirebaseCrashlytics", 3)) {
                        Log.d("FirebaseCrashlytics", "awaitEvenIfOnMainThread task continuation executor did not shut down in the allocated time. Requesting immediate shutdown.", null);
                    }
                    executorService0.shutdownNow();
                    return;
                }
            }
            catch(InterruptedException unused_ex) {
                goto label_13;
            }
        }
        try {
        }
        catch(InterruptedException unused_ex) {
        label_13:
            if(Log.isLoggable("FirebaseCrashlytics", 3)) {
                Log.d("FirebaseCrashlytics", "Interrupted while waiting for awaitEvenIfOnMainThread task continuation executor to shut down. Requesting immediate shutdown.", null);
            }
            executorService0.shutdownNow();
        }
    }
}

