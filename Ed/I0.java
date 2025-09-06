package ed;

import androidx.compose.runtime.b0;
import kotlin.jvm.internal.q;

public final class i0 extends l0 {
    public final b0 a;

    public i0(b0 b00) {
        this.a = b00;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof i0 ? q.b(this.a, ((i0)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "HotKeyword(data=" + this.a + ")";
    }
}

