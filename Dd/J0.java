package Dd;

import A7.d;
import U4.x;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.ui.K4;
import kotlin.jvm.internal.q;

public final class j0 implements K4 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final StatsElementsBase f;

    public j0(String s, String s1, String s2, String s3, String s4, StatsElementsBase statsElementsBase0) {
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = s3;
        this.e = s4;
        this.f = statsElementsBase0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof j0)) {
            return false;
        }
        if(!q.b(this.a, ((j0)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((j0)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((j0)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((j0)object0).d)) {
            return false;
        }
        return q.b(this.e, ((j0)object0).e) ? q.b(this.f, ((j0)object0).f) : false;
    }

    @Override
    public final int hashCode() {
        int v = x.b(x.b(x.b(x.b(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c), 0x1F, this.d), 0x1F, this.e);
        return this.f == null ? v : v + this.f.hashCode();
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("DjPickPlaylistItemUiState(playlistSeq=", this.a, ", playlistTitle=", this.b, ", contsTypeCode=");
        d.u(stringBuilder0, this.c, ", imageUrl=", this.d, ", title=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", statsElements=");
        stringBuilder0.append(this.f);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

