package t0;

import A7.d;
import I7.c;
import kotlin.jvm.internal.q;

public final class e {
    public final int a;
    public final long b;
    public final f c;
    public final c d;

    public e(int v, long v1, f f0, c c0) {
        this.a = v;
        this.b = v1;
        this.c = f0;
        this.d = c0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof e)) {
            return false;
        }
        if(this.a != ((e)object0).a) {
            return false;
        }
        if(this.b != ((e)object0).b) {
            return false;
        }
        return this.c == ((e)object0).c ? q.b(this.d, ((e)object0).d) : false;
    }

    @Override
    public final int hashCode() {
        int v = d.c(this.a * 0x1F, 0x1F, this.b);
        int v1 = this.c.hashCode();
        return this.d == null ? (v1 + v) * 0x1F : (v1 + v) * 0x1F + this.d.hashCode();
    }

    @Override
    public final String toString() {
        return "ContentCaptureEvent(id=" + this.a + ", timestamp=" + this.b + ", type=" + this.c + ", structureCompat=" + this.d + ')';
    }
}

