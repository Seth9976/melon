package V4;

import U4.a;
import androidx.work.impl.WorkDatabase;
import d5.j;
import java.util.List;
import java.util.concurrent.Executor;

public final class i implements c {
    public final Executor a;
    public final List b;
    public final a c;
    public final WorkDatabase d;

    public i(Executor executor0, List list0, a a0, WorkDatabase workDatabase0) {
        this.a = executor0;
        this.b = list0;
        this.c = a0;
        this.d = workDatabase0;
    }

    @Override  // V4.c
    public final void e(j j0, boolean z) {
        D5.a a0 = new D5.a(this.b, j0, this.c, this.d, 2);
        this.a.execute(a0);
    }
}

