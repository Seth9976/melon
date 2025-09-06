package gd;

import A7.d;
import U4.x;
import androidx.appcompat.app.o;
import kotlin.jvm.internal.q;

public final class i7 extends Z3 {
    public final String a;
    public final String b;
    public final String c;
    public final int d;
    public final boolean e;

    public i7(String s, String s1, String s2, int v, boolean z) {
        q.g(s, "tagName");
        q.g(s1, "tagSeq");
        super();
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = v;
        this.e = z;
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof i7 && q.b(this.a, ((i7)object0).a) && q.b(this.b, ((i7)object0).b) && this.c.equals(((i7)object0).c) && this.d == ((i7)object0).d && this.e == ((i7)object0).e;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.e) + d.b(this.d, x.b(x.b(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c), 0x1F);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("AddTagItem(tagName=", this.a, ", tagSeq=", this.b, ", searchType=");
        d.t(stringBuilder0, this.c, ", position=", this.d, ", requestRelatedTag=");
        return o.s(stringBuilder0, this.e, ")");
    }
}

