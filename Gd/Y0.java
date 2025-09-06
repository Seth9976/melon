package gd;

import A7.d;
import com.melon.ui.K4;
import kotlin.jvm.internal.q;

public final class y0 implements K4 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;

    public y0(String s, String s1, String s2, String s3, String s4, String s5) {
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = s3;
        this.e = s4;
        this.f = s5;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof y0)) {
            return false;
        }
        if(!q.b(this.a, ((y0)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((y0)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((y0)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((y0)object0).d)) {
            return false;
        }
        return q.b(this.e, ((y0)object0).e) ? q.b(this.f, ((y0)object0).f) : false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        int v2 = this.b == null ? 0 : this.b.hashCode();
        int v3 = this.c == null ? 0 : this.c.hashCode();
        int v4 = this.d == null ? 0 : this.d.hashCode();
        int v5 = this.e == null ? 0 : this.e.hashCode();
        String s = this.f;
        if(s != null) {
            v = s.hashCode();
        }
        return ((((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v5) * 0x1F + v;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("MelonDjBrandMagazineItemUiState(storySeq=", this.a, ", title=", this.b, ", date=");
        d.u(stringBuilder0, this.c, ", imgUrl=", this.d, ", linkType=");
        return d.n(stringBuilder0, this.e, ", linkUrl=", this.f, ")");
    }
}

