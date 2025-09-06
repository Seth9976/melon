package f7;

import H7.c;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class a {
    public static final l.a a;

    static {
        a.a = new l.a(1);
    }

    public static Task a(Task task0, Task task1) {
        CancellationTokenSource cancellationTokenSource0 = new CancellationTokenSource();
        TaskCompletionSource taskCompletionSource0 = new TaskCompletionSource(cancellationTokenSource0.getToken());
        c c0 = new c(taskCompletionSource0, new AtomicBoolean(false), cancellationTokenSource0, 19);
        task0.continueWithTask(a.a, c0);
        task1.continueWithTask(a.a, c0);
        return taskCompletionSource0.getTask();
    }
}

