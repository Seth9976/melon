package N9;

import java.util.List;
import jd.A2;

public final class c {
    public final Object a;
    public final Object b;
    public final long c;
    public final d d;
    public final int e;
    public final A2 f;

    public c(List list0, List list1, long v, d d0, int v1, A2 a20) {
        this.a = list0;
        this.b = list1;
        this.c = v;
        this.d = d0;
        this.e = v1;
        this.f = a20;
    }

    // 去混淆评级： 中等(50)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof c && this.a.equals(((c)object0).a) && this.b.equals(((c)object0).b) && this.c == ((c)object0).c && this.d.equals(((c)object0).d) && this.e == ((c)object0).e && this.f.equals(((c)object0).f);
    }

    @Override
    public final int hashCode() {
        return this.f.hashCode() + A7.d.b(this.e, (this.d.hashCode() + A7.d.c((this.b.hashCode() + this.a.hashCode() * 0x1F) * 0x1F, 0x1F, this.c)) * 0x1F, 0x1F);
    }

    @Override
    public final String toString() {
        return "PollingData(userMsgList=" + this.a + ", artistMsgList=" + this.b + ", pollingSec=" + this.c + ", refreshInfo=" + this.d + ", retryCnt=" + this.e + ", pollingCustomAction=" + this.f + ')';
    }
}

