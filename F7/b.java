package f7;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.iloen.melon.fragments.radio.a;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public final class b implements Executor {
    public final ExecutorService a;
    public final Object b;
    public Task c;

    public b(ExecutorService executorService0) {
        this.b = new Object();
        this.c = Tasks.forResult(null);
        this.a = executorService0;
    }

    public final Task a(Runnable runnable0) {
        synchronized(this.b) {
            Task task0 = this.c;
            a a0 = new a(runnable0, 9);
            Task task1 = task0.continueWithTask(this.a, a0);
            this.c = task1;
            return task1;
        }
    }

    @Override
    public final void execute(Runnable runnable0) {
        this.a.execute(runnable0);
    }
}

