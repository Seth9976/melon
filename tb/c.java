package tb;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.q;

public final class c extends e {
    public final List a;

    public c(ArrayList arrayList0) {
        this.a = arrayList0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof c ? q.b(this.a, ((c)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a == null ? 0 : this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "GetPlaylistContextInfoList(contextItemInfoList=" + this.a + ")";
    }
}

