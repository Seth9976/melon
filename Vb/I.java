package vb;

import A7.d;
import Q0.a;
import U4.x;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import java.util.ArrayList;
import kotlin.jvm.internal.q;

public final class i extends a {
    public final String c;
    public final String d;
    public final String e;
    public final ArrayList f;
    public final ContsTypeCode g;

    public i(String s, ArrayList arrayList0, String s1, String s2) {
        q.g(s, "contentsId");
        q.g(s1, "title");
        q.g(s2, "programImgUrl");
        super();
        this.c = s;
        this.d = s1;
        this.e = s2;
        this.f = arrayList0;
        q.f(ContsTypeCode.RADIO_PROGRAM, "RADIO_PROGRAM");
        this.g = ContsTypeCode.RADIO_PROGRAM;
    }

    // 去混淆评级： 中等(50)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof i && q.b(this.c, ((i)object0).c) && q.b(this.d, ((i)object0).d) && q.b(this.e, ((i)object0).e) && this.f.equals(((i)object0).f);
    }

    @Override  // Q0.a
    public final String h() {
        return this.c;
    }

    @Override
    public final int hashCode() {
        return this.f.hashCode() + x.b(x.b(this.c.hashCode() * 0x1F, 0x1F, this.d), 0x1F, this.e);
    }

    @Override  // Q0.a
    public final ContsTypeCode i() {
        return this.g;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("ProgramSharableProperties(contentsId=", this.c, ", title=", this.d, ", programImgUrl=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", creatorNames=");
        stringBuilder0.append(this.f);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

