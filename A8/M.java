package A8;

import A7.d;
import U4.x;
import kotlin.jvm.internal.q;

public final class m {
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    public m(int v, String s, String s1, String s2, String s3) {
        if((v & 1) != 0) {
            s = "";
        }
        if((v & 2) != 0) {
            s1 = "";
        }
        if((v & 4) != 0) {
            s2 = "";
        }
        if((v & 8) != 0) {
            s3 = "";
        }
        q.g(s, "contentsId");
        q.g(s3, "scheme");
        super();
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = s3;
    }

    // 去混淆评级： 中等(60)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof m && this.a.equals(((m)object0).a) && this.b.equals(((m)object0).b) && this.c.equals(((m)object0).c) && this.d.equals(((m)object0).d);
    }

    @Override
    public final int hashCode() {
        return x.b(x.b(x.b(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c), 0x1F, this.d) + 0x4D5;
    }

    @Override
    public final String toString() {
        return d.n(d.o("LandingData(contentsId=", this.a, ", linkUrl=", this.b, ", linkType="), this.c, ", scheme=", this.d, ", includeShortcuts=false)");
    }
}

