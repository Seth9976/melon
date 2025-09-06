package Dd;

import A7.d;
import Ac.p0;
import U4.x;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import kotlin.jvm.internal.q;

public final class t0 extends p0 {
    public final String a;
    public final String b;
    public final String c;
    public final StatsElementsBase d;

    public t0(String s, String s1, String s2, StatsElementsBase statsElementsBase0) {
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = statsElementsBase0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof t0)) {
            return false;
        }
        if(!q.b(this.a, ((t0)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((t0)object0).b)) {
            return false;
        }
        return q.b(this.c, ((t0)object0).c) ? q.b(this.d, ((t0)object0).d) : false;
    }

    @Override
    public final int hashCode() {
        int v = x.b(x.b(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c);
        return this.d == null ? v : v + this.d.hashCode();
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("OnPlayButtonClick(playlistSeq=", this.a, ", playlistTitle=", this.b, ", contsTypeCode=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", statsElements=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

