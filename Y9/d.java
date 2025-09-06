package y9;

import k8.Y;
import kotlin.jvm.internal.q;

public final class d {
    public long a;
    public int b;
    public String c;
    public String d;
    public String e;

    public d() {
        this.a = 0L;
        this.b = 0;
        this.c = "";
        this.d = "";
        this.e = "0";
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof d)) {
            return false;
        }
        if(this.a != ((d)object0).a) {
            return false;
        }
        if(this.b != ((d)object0).b) {
            return false;
        }
        if(!q.b(this.c, ((d)object0).c)) {
            return false;
        }
        return q.b(this.d, ((d)object0).d) ? q.b(this.e, ((d)object0).e) : false;
    }

    @Override
    public final int hashCode() {
        int v = A7.d.b(this.b, Long.hashCode(this.a) * 0x1F, 0x1F);
        int v1 = 0;
        int v2 = this.c == null ? 0 : this.c.hashCode();
        String s = this.d;
        if(s != null) {
            v1 = s.hashCode();
        }
        return this.e.hashCode() + ((v + v2) * 0x1F + v1) * 0x1F;
    }

    @Override
    public final String toString() {
        long v = this.a;
        int v1 = this.b;
        String s = this.c;
        String s1 = this.d;
        String s2 = this.e;
        StringBuilder stringBuilder0 = new StringBuilder("SyncEntity(uid=");
        stringBuilder0.append(v);
        stringBuilder0.append(", syncType=");
        stringBuilder0.append(v1);
        A7.d.u(stringBuilder0, ", syncTime=", s, ", updateTime=", s1);
        return Y.l(stringBuilder0, ", memberKey=", s2, ")");
    }
}

