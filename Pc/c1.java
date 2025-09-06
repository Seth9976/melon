package pc;

import A7.d;
import androidx.appcompat.app.o;
import java.util.List;
import kotlin.jvm.internal.q;

public final class c1 implements d1 {
    public final String a;
    public final String b;
    public final List c;
    public final List d;
    public final boolean e;

    public c1(String s, String s1, List list0, List list1, boolean z) {
        this.a = s;
        this.b = s1;
        this.c = list0;
        this.d = list1;
        this.e = z;
    }

    @Override  // pc.d1
    public final List a() {
        return this.c;
    }

    @Override  // pc.d1
    public final boolean b() {
        return this.e;
    }

    @Override  // pc.d1
    public final List c() {
        return this.d;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof c1)) {
            return false;
        }
        if(!q.b(this.a, ((c1)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((c1)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((c1)object0).c)) {
            return false;
        }
        return q.b(this.d, ((c1)object0).d) ? this.e == ((c1)object0).e : false;
    }

    @Override  // pc.d1
    public final String getTitle() {
        return this.a;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        int v2 = this.b == null ? 0 : this.b.hashCode();
        int v3 = this.c == null ? 0 : this.c.hashCode();
        List list0 = this.d;
        if(list0 != null) {
            v = list0.hashCode();
        }
        return Boolean.hashCode(this.e) + (((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v) * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("MixUpPlayableInfo(title=", this.a, ", subTitle=", this.b, ", seedPlayableList=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", recommendPlayableList=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(", overSeedMaxSize=");
        return o.s(stringBuilder0, this.e, ")");
    }
}

