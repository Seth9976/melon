package Dd;

import A7.d;
import U4.x;
import com.melon.ui.K4;
import kotlin.jvm.internal.q;

public final class c2 implements K4 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final int f;

    public c2(int v, String s, String s1, String s2, String s3, String s4) {
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = s3;
        this.e = s4;
        this.f = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof c2)) {
            return false;
        }
        if(!q.b(this.a, ((c2)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((c2)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((c2)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((c2)object0).d)) {
            return false;
        }
        return q.b(this.e, ((c2)object0).e) ? this.f == ((c2)object0).f : false;
    }

    @Override
    public final int hashCode() {
        return this.f + x.b(x.b(x.b(x.b(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c), 0x1F, this.d), 0x1F, this.e);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("StationItemUiState(castSeq=", this.a, ", imageUrl=", this.b, ", programTitle=");
        d.u(stringBuilder0, this.c, ", castTitle=", this.d, ", date=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", index=");
        stringBuilder0.append(this.f);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

