package vb;

import Q0.a;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import kotlin.jvm.internal.q;

public final class e extends a {
    public final ContsTypeCode c;

    public e() {
        q.f(ContsTypeCode.UNKNOWN, "UNKNOWN");
        this.c = ContsTypeCode.UNKNOWN;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this != object0) {
            if(!(object0 instanceof e)) {
                return false;
            }
            ((e)object0).getClass();
        }
        return true;
    }

    @Override  // Q0.a
    public final String h() {
        return "";
    }

    @Override
    public final int hashCode() {
        return 0;
    }

    @Override  // Q0.a
    public final ContsTypeCode i() {
        return this.c;
    }

    @Override
    public final String toString() {
        return "MelgunSharableProperties(contentsId=)";
    }
}

