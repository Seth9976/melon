package e5;

import androidx.work.impl.WorkDatabase;
import kotlin.jvm.internal.q;

public final class g {
    public final WorkDatabase a;

    public g(WorkDatabase workDatabase0, int v) {
        if(v != 1) {
            q.g(workDatabase0, "workDatabase");
            super();
            this.a = workDatabase0;
            return;
        }
        super();
        this.a = workDatabase0;
    }
}

