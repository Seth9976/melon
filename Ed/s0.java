package ed;

import kotlin.jvm.internal.q;

public final class s0 extends u0 {
    public final i0 a;

    public s0(i0 i00) {
        this.a = i00;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof s0 ? q.b(this.a, ((s0)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.a.hashCode();
    }

    @Override
    public final String toString() {
        return "HotKeywordAndError(hotKeyword=" + this.a + ")";
    }
}

