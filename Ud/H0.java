package ud;

import A7.d;
import U4.x;
import com.melon.ui.K4;
import kotlin.jvm.internal.q;

public final class h0 implements K4 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final E e;

    public h0(String s, String s1, String s2, String s3, E e0) {
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = s3;
        this.e = e0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof h0)) {
            return false;
        }
        if(!q.b(this.a, ((h0)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((h0)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((h0)object0).c)) {
            return false;
        }
        return q.b(this.d, ((h0)object0).d) ? q.b(this.e, ((h0)object0).e) : false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = x.b(x.b((this.a.hashCode() * 0x1F + (this.b == null ? 0 : this.b.hashCode())) * 0x1F, 0x1F, this.c), 0x1F, this.d);
        E e0 = this.e;
        if(e0 != null) {
            v = e0.hashCode();
        }
        return v1 + v;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("StationPlayerUiState(castSeq=", this.a, ", thumbnailUri=", this.b, ", title=");
        d.u(stringBuilder0, this.c, ", creator=", this.d, ", playableState=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

