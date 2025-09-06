package Dd;

import A7.d;
import U4.x;
import b3.Z;
import com.melon.ui.K4;
import kotlin.jvm.internal.q;

public final class d2 implements K4 {
    public final boolean a;
    public final String b;
    public final boolean c;
    public final String d;

    public d2(String s, String s1, boolean z, boolean z1) {
        this.a = z;
        this.b = s;
        this.c = z1;
        this.d = s1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof d2)) {
            return false;
        }
        if(this.a != ((d2)object0).a) {
            return false;
        }
        if(!q.b(this.b, ((d2)object0).b)) {
            return false;
        }
        return this.c == ((d2)object0).c ? q.b(this.d, ((d2)object0).d) : false;
    }

    @Override
    public final int hashCode() {
        return this.d.hashCode() + d.e(x.b(Boolean.hashCode(this.a) * 0x1F, 0x1F, this.b), 0x1F, this.c);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = Z.p("TitleItemUiState(isDj=", ", title=", this.b, ", isShowAll=", this.a);
        stringBuilder0.append(this.c);
        stringBuilder0.append(", type=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

