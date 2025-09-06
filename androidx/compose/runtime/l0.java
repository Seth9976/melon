package androidx.compose.runtime;

import kotlin.jvm.internal.q;
import p0.v;

public final class L0 extends v {
    public long c;

    public L0(long v, long v1) {
        super(v);
        this.c = v1;
    }

    @Override  // p0.v
    public final void a(v v0) {
        q.e(v0, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableLongStateImpl.LongStateStateRecord");
        this.c = ((L0)v0).c;
    }

    @Override  // p0.v
    public final v b(long v) {
        return new L0(v, this.c);
    }
}

