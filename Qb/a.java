package qb;

import A7.d;
import U4.x;
import androidx.appcompat.app.o;
import kotlin.jvm.internal.q;

public final class a {
    public final int a;
    public final String b;
    public final String c;
    public final String d;
    public final boolean e;
    public final boolean f;
    public final boolean g;

    public a(int v, String s, String s1, String s2, boolean z, boolean z1, boolean z2) {
        this.a = v;
        this.b = s;
        this.c = s1;
        this.d = s2;
        this.e = z;
        this.f = z1;
        this.g = z2;
    }

    public static a a(a a0, String s, boolean z, int v) {
        int v1 = a0.a;
        String s1 = a0.b;
        String s2 = a0.c;
        if((v & 8) != 0) {
            s = a0.d;
        }
        if((v & 16) != 0) {
            z = a0.e;
        }
        return new a(v1, s1, s2, s, z, a0.f, a0.g);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof a)) {
            return false;
        }
        if(this.a != ((a)object0).a) {
            return false;
        }
        if(!q.b(this.b, ((a)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((a)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((a)object0).d)) {
            return false;
        }
        if(this.e != ((a)object0).e) {
            return false;
        }
        return this.f == ((a)object0).f ? this.g == ((a)object0).g : false;
    }

    @Override
    public final int hashCode() {
        int v = x.b(this.a * 0x1F, 0x1F, this.b);
        int v1 = 0;
        int v2 = this.c == null ? 0 : this.c.hashCode();
        String s = this.d;
        if(s != null) {
            v1 = s.hashCode();
        }
        return Boolean.hashCode(this.g) + d.e(d.e(((v + v2) * 0x1F + v1) * 0x1F, 0x1F, this.e), 0x1F, this.f);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = x.o(this.a, "ArtistListItemInfo(type=", ", artistId=", this.b, ", artistName=");
        d.u(stringBuilder0, this.c, ", artistImgUrl=", this.d, ", isFan=");
        x.y(stringBuilder0, this.e, ", isEnable=", this.f, ", isShowFan=");
        return o.s(stringBuilder0, this.g, ")");
    }
}

