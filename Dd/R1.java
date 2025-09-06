package Dd;

import com.melon.ui.K4;
import kotlin.jvm.internal.q;

public final class r1 implements K4 {
    public final String a;
    public final String b;

    public r1(String s, String s1) {
        this.a = s;
        this.b = s1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof r1)) {
            return false;
        }
        return q.b(this.a, ((r1)object0).a) ? q.b(this.b, ((r1)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "BrandDetailItemUiState(webSiteVal=" + this.a + ", appVal=" + this.b + ")";
    }
}

