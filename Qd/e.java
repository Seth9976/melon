package qd;

import I0.a;
import androidx.compose.runtime.b0;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.SupervisorKt;

public final class e implements a {
    public final b0 a;
    public final CoroutineScope b;

    public e(b0 b00, CoroutineScope coroutineScope0) {
        this.a = b00;
        this.b = coroutineScope0;
    }

    @Override  // I0.a
    public final Object onPostFling-RZ2iAVY(long v, long v1, Continuation continuation0) {
        CompletableJob completableJob0 = SupervisorKt.SupervisorJob$default(null, 1, null);
        d d0 = new d(this.a, null);
        BuildersKt__Builders_commonKt.launch$default(this.b, completableJob0, null, d0, 2, null);
        return a.super.onPostFling-RZ2iAVY(v, v1, continuation0);
    }

    @Override  // I0.a
    public final long onPostScroll-DzOQY0M(long v, long v1, int v2) {
        return 0L;
    }

    @Override  // I0.a
    public final Object onPreFling-QWom1Mo(long v, Continuation continuation0) {
        this.a.setValue(Boolean.FALSE);
        return a.super.onPreFling-QWom1Mo(v, continuation0);
    }

    @Override  // I0.a
    public final long onPreScroll-OzD1aCk(long v, int v1) {
        return 0L;
    }
}

