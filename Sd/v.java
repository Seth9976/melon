package sd;

import A7.d;
import U4.x;
import androidx.appcompat.app.o;
import b3.Z;
import kotlin.jvm.internal.q;

public final class v extends w {
    public final boolean a;
    public final String b;
    public final String c;
    public final String d;
    public final boolean e;

    public v(String s, String s1, boolean z, String s2, boolean z1) {
        q.g(s, "title1");
        q.g(s1, "title2");
        super();
        this.a = z;
        this.b = s;
        this.c = s1;
        this.d = s2;
        this.e = z1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof v)) {
            return false;
        }
        if(this.a != ((v)object0).a) {
            return false;
        }
        if(!q.b(this.b, ((v)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((v)object0).c)) {
            return false;
        }
        return q.b(this.d, ((v)object0).d) ? this.e == ((v)object0).e : false;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.e) + x.b(x.b(x.b(Boolean.hashCode(this.a) * 0x1F, 0x1F, this.b), 0x1F, this.c), 0x1F, this.d);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = Z.p("StationPlayerUiState(isEmpty=", ", title1=", this.b, ", title2=", this.a);
        d.u(stringBuilder0, this.c, ", contentDesc=", this.d, ", isPlaying=");
        return o.s(stringBuilder0, this.e, ")");
    }
}

