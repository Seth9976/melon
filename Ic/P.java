package Ic;

import A7.d;
import U4.x;
import com.melon.ui.K4;
import kotlin.jvm.internal.q;

public final class p implements K4 {
    public final String a;
    public final boolean b;
    public final String c;
    public final String d;
    public final u e;

    public p(String s, boolean z, String s1, String s2, u u0) {
        this.a = s;
        this.b = z;
        this.c = s1;
        this.d = s2;
        this.e = u0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof p)) {
            return false;
        }
        if(!q.b(this.a, ((p)object0).a)) {
            return false;
        }
        if(this.b != ((p)object0).b) {
            return false;
        }
        if(!q.b(this.c, ((p)object0).c)) {
            return false;
        }
        return q.b(this.d, ((p)object0).d) ? q.b(this.e, ((p)object0).e) : false;
    }

    @Override
    public final int hashCode() {
        return this.e.hashCode() + x.b(x.b(d.e(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c), 0x1F, this.d);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("BannerUiState(seq=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", visible=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", imageUrl=");
        d.u(stringBuilder0, this.c, ", bgColor=", this.d, ", link=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

