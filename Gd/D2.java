package gd;

import kotlin.jvm.internal.q;

public final class d2 extends e2 {
    public final String a;
    public final String b;

    public d2(String s, String s1) {
        this.a = s;
        this.b = s1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof d2)) {
            return false;
        }
        return q.b(this.a, ((d2)object0).a) ? q.b(this.b, ((d2)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        String s = this.b;
        if(s != null) {
            v = s.hashCode();
        }
        return v1 * 0x1F + v;
    }

    @Override
    public final String toString() {
        return "TitleItemUiState(programSeq=" + this.a + ", title=" + this.b + ")";
    }
}

