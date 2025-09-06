package ed;

import com.iloen.melon.net.v6x.response.SearchHotKeywordAndMenuListRes.RESPONSE;
import kotlin.jvm.internal.q;

public final class d0 extends f0 {
    public final RESPONSE a;

    public d0(RESPONSE searchHotKeywordAndMenuListRes$RESPONSE0) {
        this.a = searchHotKeywordAndMenuListRes$RESPONSE0;
    }

    @Override  // ed.f0
    public final f0 a() {
        return new e0(this.a);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof d0 ? q.b(this.a, ((d0)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "Collapse(data=" + this.a + ")";
    }
}

