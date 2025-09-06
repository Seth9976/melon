package Dd;

import A7.d;
import Ac.p0;
import U4.x;
import b3.Z;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import kotlin.jvm.internal.q;

public final class a2 extends p0 {
    public final boolean a;
    public final String b;
    public final String c;
    public final String d;
    public final StatsElementsBase e;
    public final int f;

    public a2(boolean z, String s, String s1, String s2, StatsElementsBase statsElementsBase0, int v) {
        this.a = z;
        this.b = s;
        this.c = s1;
        this.d = s2;
        this.e = statsElementsBase0;
        this.f = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof a2)) {
            return false;
        }
        if(this.a != ((a2)object0).a) {
            return false;
        }
        if(!q.b(this.b, ((a2)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((a2)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((a2)object0).d)) {
            return false;
        }
        return q.b(this.e, ((a2)object0).e) ? this.f == ((a2)object0).f : false;
    }

    @Override
    public final int hashCode() {
        int v = x.b(x.b(x.b(Boolean.hashCode(this.a) * 0x1F, 0x1F, this.b), 0x1F, this.c), 0x1F, this.d);
        return this.e == null ? this.f + v * 0x1F : this.f + (v + this.e.hashCode()) * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = Z.p("OnPlayButtonClick(isDj=", ", playlistSeq=", this.b, ", playlistTitle=", this.a);
        d.u(stringBuilder0, this.c, ", contsTypeCode=", this.d, ", statsElements=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", index=");
        stringBuilder0.append(this.f);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

