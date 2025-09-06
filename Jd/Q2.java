package jd;

import A7.d;
import Ac.m4;
import U4.x;
import java.util.List;
import kotlin.jvm.internal.q;

public final class q2 extends m4 {
    public final boolean a;
    public final Object b;
    public final String c;
    public final String d;

    public q2(List list0, boolean z, String s, String s1) {
        this.a = z;
        this.b = list0;
        this.c = s;
        this.d = s1;
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof q2 && this.a == ((q2)object0).a && this.b.equals(((q2)object0).b) && this.c.equals(((q2)object0).c) && q.b(this.d, ((q2)object0).d);
    }

    @Override
    public final int hashCode() {
        int v = x.b((this.b.hashCode() + Boolean.hashCode(this.a) * 0x1F) * 0x1F, 0x1F, this.c);
        return this.d == null ? v : v + this.d.hashCode();
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("Success(isArtist=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", imageList=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", clickedImageSeq=");
        return d.n(stringBuilder0, this.c, ", myMemberKey=", this.d, ")");
    }
}

