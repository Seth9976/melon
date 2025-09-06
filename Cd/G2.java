package cd;

import kotlin.jvm.internal.q;

public final class g2 implements h2 {
    public final d2 a;
    public final String b;

    public g2(d2 d20, String s) {
        q.g(d20, "tagItemUiState");
        super();
        this.a = d20;
        this.b = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof g2)) {
            return false;
        }
        return q.b(this.a, ((g2)object0).a) ? q.b(this.b, ((g2)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "OnPlayButtonClick(tagItemUiState=" + this.a + ", tagName=" + this.b + ")";
    }
}

