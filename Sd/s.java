package sd;

import A7.d;
import U4.x;
import b3.Z;
import kotlin.jvm.internal.q;

public final class s extends w {
    public final boolean a;
    public final String b;
    public final String c;
    public final String d;
    public final boolean e;
    public final boolean f;

    public s(boolean z, String s, String s1, String s2, boolean z1, boolean z2) {
        q.g(s, "title1");
        q.g(s1, "title2");
        super();
        this.a = z;
        this.b = s;
        this.c = s1;
        this.d = s2;
        this.e = z1;
        this.f = z2;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof s)) {
            return false;
        }
        if(this.a != ((s)object0).a) {
            return false;
        }
        if(!q.b(this.b, ((s)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((s)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((s)object0).d)) {
            return false;
        }
        return this.e == ((s)object0).e ? this.f == ((s)object0).f : false;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.f) + d.e(x.b(x.b(x.b(Boolean.hashCode(this.a) * 0x1F, 0x1F, this.b), 0x1F, this.c), 0x1F, this.d), 0x1F, this.e);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = Z.p("CommonMusicPlayerUiState(isEmpty=", ", title1=", this.b, ", title2=", this.a);
        d.u(stringBuilder0, this.c, ", contentDesc=", this.d, ", isPlaying=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", isDjMalrang=");
        stringBuilder0.append(this.f);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

