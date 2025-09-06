package Vc;

import com.melon.playlist.mixup.DjMalrangInfo;
import kotlin.jvm.internal.q;

public final class n implements o {
    public final DjMalrangInfo a;

    public n(DjMalrangInfo djMalrangInfo0) {
        this.a = djMalrangInfo0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof n ? q.b(this.a, ((n)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a == null ? 0 : this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "OnPlayButtonClick(mixUpInfo=" + this.a + ")";
    }
}

