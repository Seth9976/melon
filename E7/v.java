package e7;

import android.os.Looper;
import com.google.android.gms.tasks.Task;
import com.iloen.melon.fragments.radio.a;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;

public abstract class v {
    public static final ExecutorService a;

    static {
        s s0 = new s(new AtomicLong(1L));
        ThreadPoolExecutor.DiscardPolicy threadPoolExecutor$DiscardPolicy0 = new ThreadPoolExecutor.DiscardPolicy();
        ExecutorService executorService0 = Executors.unconfigurableExecutorService(new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), s0, threadPoolExecutor$DiscardPolicy0));
        Runtime.getRuntime().addShutdownHook(new Thread(new r(executorService0), "Crashlytics Shutdown Hook for awaitEvenIfOnMainThread task continuation executor"));
        v.a = executorService0;
    }

    public static void a(Task task0) {
        CountDownLatch countDownLatch0 = new CountDownLatch(1);
        a a0 = new a(countDownLatch0, 6);
        task0.continueWith(v.a, a0);
        if(Looper.getMainLooper() == Looper.myLooper()) {
            countDownLatch0.await(3000L, TimeUnit.MILLISECONDS);
        }
        else {
            countDownLatch0.await(4000L, TimeUnit.MILLISECONDS);
        }
        if(task0.isSuccessful()) {
            task0.getResult();
            return;
        }
        if(task0.isCanceled()) {
            throw new CancellationException("Task is already canceled");
        }
        if(!task0.isComplete()) {
            throw new TimeoutException();
        }
        throw new IllegalStateException(task0.getException());
    }
}

