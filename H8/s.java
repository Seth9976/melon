package H8;

import A7.d;
import U4.x;
import com.iloen.melon.utils.a;
import kotlin.jvm.internal.q;

public final class s {
    public long a;
    public String b;
    public long c;
    public long d;
    public int e;
    public final int f;

    public s() {
        this(0L, "", 0L, 0L, 0, 0);
    }

    public s(long v, String s, long v1, long v2, int v3, int v4) {
        q.g(s, "name");
        super();
        this.a = v;
        this.b = s;
        this.c = v1;
        this.d = v2;
        this.e = v3;
        this.f = v4;
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
        if(this.c != ((s)object0).c) {
            return false;
        }
        if(this.d != ((s)object0).d) {
            return false;
        }
        return this.e == ((s)object0).e ? this.f == ((s)object0).f : false;
    }

    @Override
    public final int hashCode() {
        return this.f + d.b(this.e, d.c(d.c(x.b(Long.hashCode(this.a) * 0x1F, 0x1F, this.b), 0x1F, this.c), 0x1F, this.d), 0x1F);
    }

    @Override
    public final String toString() {
        long v = this.a;
        String s = this.b;
        long v1 = this.c;
        long v2 = this.d;
        int v3 = this.e;
        StringBuilder stringBuilder0 = new StringBuilder("LocalPlaylistsEntity(id=");
        stringBuilder0.append(v);
        stringBuilder0.append(", name=");
        stringBuilder0.append(s);
        a.s(v1, ", dateAdded=", ", dataModified=", stringBuilder0);
        stringBuilder0.append(v2);
        stringBuilder0.append(", sortOrder=");
        stringBuilder0.append(v3);
        stringBuilder0.append(", playlistCount=");
        stringBuilder0.append(this.f);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

