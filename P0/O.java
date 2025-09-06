package p0;

import i0.b;

public final class o extends v {
    public b c;
    public int d;
    public int e;

    public o(long v, b b0) {
        super(v);
        this.c = b0;
    }

    @Override  // p0.v
    public final void a(v v0) {
        synchronized(q.a) {
            kotlin.jvm.internal.q.e(v0, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord>");
            this.c = ((o)v0).c;
            this.d = ((o)v0).d;
            this.e = ((o)v0).e;
        }
    }

    @Override  // p0.v
    public final v b(long v) {
        return new o(v, this.c);
    }
}

