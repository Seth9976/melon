package Ic;

import com.melon.ui.K4;
import kotlin.jvm.internal.q;

public final class v implements K4 {
    public final String a;
    public final String b;

    public v(String s, String s1) {
        this.a = s;
        this.b = s1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof v)) {
            return false;
        }
        return q.b(this.a, ((v)object0).a) ? q.b(this.b, ((v)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "NoticeUiState(title=" + this.a + ", text=" + this.b + ")";
    }
}

