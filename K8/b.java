package k8;

import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

public final class b implements a {
    public final LogU a;
    public final AtomicInteger b;
    public final MutableStateFlow c;
    public final MutableStateFlow d;

    public b() {
        this.a = LogU.Companion.create("BlockingProgressDialogManageUsingCounter", false, Category.UI);
        this.b = new AtomicInteger(0);
        MutableStateFlow mutableStateFlow0 = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.c = mutableStateFlow0;
        this.d = mutableStateFlow0;
    }

    @Override  // com.iloen.melon.custom.L0
    public final void a(String s, boolean z) {
        q.g(s, "caller");
        LogU.debug$default(this.a, "updateDialogVisible " + z + " " + s, null, false, 6, null);
        int v = z ? this.b.incrementAndGet() : this.b.decrementAndGet();
        do {
            Object object0 = this.c.getValue();
            ((Boolean)object0).getClass();
        }
        while(!this.c.compareAndSet(object0, Boolean.valueOf(v > 0)));
    }
}

