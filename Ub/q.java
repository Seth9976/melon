package Ub;

import Xb.j;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import fc.a;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowKt;

public final class q {
    public final CoroutineScope a;
    public final MutableStateFlow b;
    public final MutableSharedFlow c;
    public final SharedFlow d;

    public q() {
        LogU logU0 = Companion.create$default(LogU.Companion, "PlaybackManager", false, Category.Playback, 2, null);
        this.a = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        this.b = StateFlowKt.MutableStateFlow(new a(false, 0L, 0L, null, null, null, 0x3FF));
        MutableSharedFlow mutableSharedFlow0 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.c = mutableSharedFlow0;
        this.d = FlowKt.asSharedFlow(mutableSharedFlow0);
        LogConstantsKt.debugOnlyDebugMode(logU0, "init()");
    }

    public final a a() {
        return (a)this.b.getValue();
    }

    public final void b(j j0) {
        kotlin.jvm.internal.q.g(j0, "event");
        p p0 = new p(this, j0, null);
        BuildersKt__Builders_commonKt.launch$default(this.a, null, null, p0, 3, null);
    }
}

