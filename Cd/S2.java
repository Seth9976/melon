package cd;

import com.melon.ui.K4;
import kotlin.jvm.internal.q;

public final class s2 implements K4 {
    public final String a;
    public final String b;

    public s2(String s, String s1) {
        this.a = s;
        this.b = s1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof s2)) {
            return false;
        }
        return q.b(this.a, ((s2)object0).a) ? q.b(this.b, ((s2)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        int v = this.a.hashCode();
        return this.b == null ? v * 0x1F : v * 0x1F + this.b.hashCode();
    }

    @Override
    public final String toString() {
        return "TitleSlotUiState(title=" + this.a + ", replaceText=" + this.b + ")";
    }
}

