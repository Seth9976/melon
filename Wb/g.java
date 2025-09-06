package Wb;

import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import p8.e;

public final class g {
    public final LogU a;
    public final e b;
    public final AtomicReference c;
    public final ArrayList d;
    public final AtomicLong e;
    public Job f;

    public g() {
        this.a = Companion.create$default(LogU.Companion, "Timer", false, null, 6, null);
        e e0 = new e(24);
        this.b = e0;
        this.c = new AtomicReference(e0);
        this.d = new ArrayList();
        this.e = new AtomicLong(0x8000000000000001L);
    }

    public final void a(String s) {
        LogConstantsKt.infoOnlyDebugMode(this.a, "cancel() reason: " + s);
        this.c.set(this.b);
        this.d.clear();
        this.e.set(0x8000000000000001L);
        Job job0 = this.f;
        if(job0 != null) {
            JobKt__JobKt.cancel$default(job0, "Cancel timer", null, 2, null);
        }
    }
}

