package e5;

import androidx.work.impl.WorkDatabase;
import d5.d;
import java.util.concurrent.Callable;

public final class f implements Callable {
    public final g a;
    public final int b;

    public f(g g0, int v) {
        this.a = g0;
        this.b = v;
    }

    @Override
    public final Object call() {
        WorkDatabase workDatabase0 = this.a.a;
        Long long0 = workDatabase0.c().i("next_job_scheduler_id");
        int v = long0 == null ? 0 : ((int)(((long)long0)));
        workDatabase0.c().m(new d("next_job_scheduler_id", ((long)(v == 0x7FFFFFFF ? 0 : v + 1))));
        if(v >= 0 && v <= this.b) {
            return v;
        }
        workDatabase0.c().m(new d("next_job_scheduler_id", 1L));
        return 0;
    }
}

