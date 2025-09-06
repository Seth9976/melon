package H;

import androidx.compose.runtime.O0;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.w;
import kotlin.jvm.internal.q;

public final class n {
    public final b0 a;

    public n() {
        this.a = w.s(k.a);
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        return object0 instanceof n ? q.b(((m)((O0)((n)object0).a).getValue()), ((m)((O0)this.a).getValue())) : false;
    }

    @Override
    public final int hashCode() {
        return ((m)((O0)this.a).getValue()).hashCode();
    }

    @Override
    public final String toString() {
        return "ContextMenuState(status=" + ((m)((O0)this.a).getValue()) + ')';
    }
}

