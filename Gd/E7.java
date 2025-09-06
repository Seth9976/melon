package gd;

import A7.d;
import com.melon.ui.I4;
import kotlin.jvm.internal.q;

public final class e7 implements I4 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final boolean i;
    public final boolean j;

    public e7(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, boolean z, boolean z1) {
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = s3;
        this.e = s4;
        this.f = s5;
        this.g = s6;
        this.h = s7;
        this.i = z;
        this.j = z1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof e7)) {
            return false;
        }
        if(!q.b(this.a, ((e7)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((e7)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((e7)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((e7)object0).d)) {
            return false;
        }
        if(!q.b(this.e, ((e7)object0).e)) {
            return false;
        }
        if(!q.b(this.f, ((e7)object0).f)) {
            return false;
        }
        if(!q.b(this.g, ((e7)object0).g)) {
            return false;
        }
        if(!q.b(this.h, ((e7)object0).h)) {
            return false;
        }
        return this.i == ((e7)object0).i ? this.j == ((e7)object0).j : false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        int v2 = this.b == null ? 0 : this.b.hashCode();
        int v3 = this.c == null ? 0 : this.c.hashCode();
        int v4 = this.d == null ? 0 : this.d.hashCode();
        int v5 = this.e == null ? 0 : this.e.hashCode();
        int v6 = this.f == null ? 0 : this.f.hashCode();
        int v7 = this.g == null ? 0 : this.g.hashCode();
        String s = this.h;
        if(s != null) {
            v = s.hashCode();
        }
        return Boolean.hashCode(this.j) + d.e((((((((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v5) * 0x1F + v6) * 0x1F + v7) * 0x1F + v) * 0x1F, 0x1F, this.i);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("ShowContextPopup(playlistSeq=", this.a, ", playlistTitle=", this.b, ", artistName=");
        d.u(stringBuilder0, this.c, ", ownerMemberKey=", this.d, ", fameRegYn=");
        d.u(stringBuilder0, this.e, ", withDrawYn=", this.f, ", songCount=");
        d.u(stringBuilder0, this.g, ", imgUrl=", this.h, ", isDeleted=");
        stringBuilder0.append(this.i);
        stringBuilder0.append(", isOpen=");
        stringBuilder0.append(this.j);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

