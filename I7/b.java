package I7;

import I.t0;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.ScheduledExecutorService;

public final class b implements Runnable {
    public final int a;
    public final long b;
    public final t0 c;

    public b(t0 t00, int v, long v1) {
        this.c = t00;
        this.a = v;
        this.b = v1;
    }

    @Override
    public final void run() {
        synchronized(this.c) {
            Task task0 = ((j)this.c.d).c(4 - this.a);
            Task task1 = ((d)this.c.e).b();
            Tasks.whenAllComplete(new Task[]{task0, task1}).continueWithTask(((ScheduledExecutorService)this.c.g), new a(this.c, task0, task1, this.b, this.a - 1));
        }
    }
}

