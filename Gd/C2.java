package gd;

import A7.d;
import java.util.List;
import kotlin.jvm.internal.q;

public final class c2 extends e2 {
    public final String a;
    public final String b;
    public final boolean c;
    public final Object d;

    public c2(List list0, boolean z, String s, String s1) {
        this.a = s;
        this.b = s1;
        this.c = z;
        this.d = list0;
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof c2 && q.b(this.a, ((c2)object0).a) && q.b(this.b, ((c2)object0).b) && this.c == ((c2)object0).c && this.d.equals(((c2)object0).d);
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        String s = this.b;
        if(s != null) {
            v = s.hashCode();
        }
        return this.d.hashCode() + d.e((v1 * 0x1F + v) * 0x1F, 0x1F, this.c);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("ProgramItemUiState(programSeq=", this.a, ", programTitle=", this.b, ", showAllButton=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", castList=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

