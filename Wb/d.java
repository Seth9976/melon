package wb;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.q;

public final class d extends f {
    public final List a;

    public d(ArrayList arrayList0) {
        q.g(arrayList0, "contentsList");
        super();
        this.a = arrayList0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof d ? q.b(this.a, ((d)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "GetSongInfoBaseList(contentsList=" + this.a + ")";
    }
}

